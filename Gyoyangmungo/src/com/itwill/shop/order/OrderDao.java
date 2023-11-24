package com.itwill.shop.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.common.DataSource;
import com.itwill.shop.product.Product;

public class OrderDao {

	private DataSource dataSource;
	
	
	public OrderDao() throws Exception{
		dataSource=new DataSource();
	}
	
	/*
	 * 주문전체삭제(ON DELETE CASCADE)
	 */
	public int deleteByUserId(String m_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_USERID);
			pstmt.setString(1, m_id);
			rowCount = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
		return rowCount;
	}

	/*
	 * 주문1건삭제(ON DELETE CASCADE)
	 */
	public int deleteByOrderNo(int o_no) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_O_NO);
			pstmt.setInt(1, o_no);
			rowCount = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
		return rowCount;
	}

	/*
	 * 주문생성
	 */
	public int insert(Order order) throws Exception {
		
		
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_INSERT);
			pstmt1.setString(1, order.getO_desc());
			pstmt1.setInt(2, order.getO_price());
			pstmt1.setString(3, order.getM_id());
			pstmt1.executeUpdate();

			pstmt2 = con.prepareStatement(OrderSQL.ORDERITEM_INSERT);
			for (OrderItem orderItem : order.getOrderItemList()) {
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
		return 0;
	}

	/*
	 * 주문전체(특정사용자) - displayorder 용
	 */
	public List<Order> findOrderBym_Id(String m_id) throws Exception {
		List<Order> orderList = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			/*
			 * select * from orders where m_id='guard1'
			 */
			pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderList.add(new Order(
						rs.getInt("o_no"),
						rs.getString("o_desc"),
						rs.getInt("o_price"),
						rs.getDate("o_date"),
						rs.getString("m_id")));
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println(orderList);
		return orderList;
	}
	
	
	/*
	 * 주문전체(특정사용자)
	 */
	public List<Order> findOrderByUserId(String sUserId) throws Exception {
		ArrayList<Order> orderList = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			/*
			 * select * from orders where userid='guard1'
			 */
			pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
			pstmt.setString(1, sUserId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderList.add(new Order(rs.getInt("o_no"),
								rs.getString("o_desc"),
								rs.getInt("o_price"),
								rs.getDate("o_date"),
								rs.getString("m_id"),null));
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return orderList;
	}

	/*
	 * 주문+주문아이템 전체(특정사용자)
	 */
	public List<Order> findOrderWithOrderItemByUserId(String m_id) throws Exception {
		
		List<Order> orderList = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			con = dataSource.getConnection();
			/*
			 * select * from orders where userid='guard1'
			 */
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
			pstmt1.setString(1, m_id);
			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				orderList.add(new Order(rs1.getInt("o_no"), rs1.getString("o_desc"), rs1.getInt("o_price"),
						rs1.getDate("o_date"),
						rs1.getString("m_id"),null));
			}
				
			pstmt2 = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_ORDERITEM_BY_O_NO);
			
			for (int i = 0; i < orderList.size(); i++) {
				Order tempOrder = orderList.get(i);
				/*
				 * select * from orders o join order_item oi on o.o_no=oi.o_no join product p on
				 * oi.p_no=p.p_no where o.userid=? and o.o_no = ?
				 */
				pstmt2.setInt(1, tempOrder.getO_no());
				rs2 = pstmt2.executeQuery();
				
				Order orderWithOrderItem=null;
				if (rs2.next()) {
					orderWithOrderItem = new Order(rs2.getInt("o_no"), 
													rs2.getString("o_desc"),
													rs2.getInt("o_price"),
													rs2.getDate("o_date"),
													rs2.getString("m_id"),null);
					do {
						orderWithOrderItem.getOrderItemList()
								.add(new OrderItem(rs2.getInt("oi_no"), rs2.getInt("oi_qty"), rs2.getInt("o_no"),
										new Product(rs2.getInt("p_no"), rs2.getString("p_name"), rs2.getInt("p_price"),
												rs2.getString("p_image"), rs2.getString("p_desc"), rs2.getInt("p_category"))));
					} while (rs2.next());
				}
				orderList.set(i, orderWithOrderItem);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return orderList;
	}
  

	/*
	 * 주문1개보기(주문상세리스트)
	 */
	public Order findByOrderNo(String m_id, int o_no) throws Exception {

		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		con = dataSource.getConnection();
		/*
		 * select * from orders o join order_item oi on o.o_no=oi.o_no join product p on
		 * oi.p_no=p.p_no where o.userid=? and o.o_no = ?
		 */
		pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_ORDERITEM_BY_O_NO);
		
		pstmt.setInt(1, o_no);
		
		rs = pstmt.executeQuery();
		/*
		  O_NO   O_DESC 	  O_DATE 	O_PRICE  USERID  OI_NO  OI_QTY O_NO P_NO P_NAME 	  P_PRICE   P_IMAGE 	P_DESC 
		  ---------- ------------------------------------------------------------------------------------------------------------ 
		  1   비글외1마리 	2023/01/06 	1550000  guard1 	1 	 1 		 1   1 	 비글 	      550000 	bigle.png 	기타 상세 정보 등... 0 
		  1   비글외1마리 	2023/01/06 	1550000  guard1 	2 	 2 		 1   2 	 달마시안     500000 	dalma.jpg 	기타 상세 정보 등... 0
		 */
		if (rs.next()) {
			order = new Order(
					rs.getInt("o_no"),
					rs.getString("o_desc"),
					rs.getInt("o_price"),
					rs.getDate("o_date"), 
					rs.getString("m_id"),null);
			do {
				order.getOrderItemList()
					.add(new OrderItem(
							rs.getInt("oi_no"),
							rs.getInt("oi_qty"),
							rs.getInt("o_no"),
								new Product(
										rs.getInt("p_no"),
										rs.getString("p_name"),
										rs.getInt("p_price"),
										rs.getString("p_image"),
										rs.getString("p_desc"),
										rs.getInt("p_category"))));
			} while (rs.next());
		}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return order;
	}

}
