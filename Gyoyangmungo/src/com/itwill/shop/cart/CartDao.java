package com.itwill.shop.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.common.DataSource;
import com.itwill.shop.product.Product;

public class CartDao {

	private DataSource dataSource;
	public CartDao() throws Exception {
		dataSource=new DataSource();
	}
	
	// 카트 제품 존재여부 
	
	public int countByCart(String m_id, int p_no) throws Exception {
		int count=0;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_COUNT_USERID_P_NO);
		pstmt.setString(1, m_id);
		pstmt.setInt(2, p_no);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return count;
	}
	
	
	// 카트에 추가
	public int insert(Cart cart) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT);
		pstmt.setInt(1, cart.getCart_qty());
		pstmt.setInt(2, cart.getProduct().getP_no());
		pstmt.setString(3, cart.getM_Id());
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rowCount;
		
	}
	// 카트에 있는 제품의 수량 변경 (카트리스트에서 변경)
	public int update(int c_qty, int c_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_C_NO);
		pstmt.setInt(1, c_qty);
		pstmt.setInt(2, c_no);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	// 카트에 있는 제품의 수량 변경 (상품에서 카트 수량 변경)
	public int updateByProduct(int c_qty, String m_id , int p_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_P_NO);
		pstmt.setInt(1, c_qty);
		pstmt.setString(2, m_id);
		pstmt.setInt(3, p_no);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	
	// 카트 상품 한가지 삭제
	public int deleteByCartNo (int c_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_C_NO);
		pstmt.setInt(1, c_no);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rowCount;
	}
	// 카트 상품 전체 삭제
	public int deleteByAll (String m_id) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_U_ID);
		pstmt.setString(1, m_id);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	// 유저의 카트리스트 보여주기
	public List<Cart> findSelectAll(String m_id) throws Exception {
		List<Cart> cartList=new ArrayList<Cart>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_ALL);
		pstmt.setString(1, m_id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			cartList.add(new Cart(rs.getInt("c_no"),
					rs.getInt("c_qty"),
					rs.getString("m_id"),
					new Product(rs.getInt("p_no"),
							rs.getString("p_name"),
							rs.getInt("p_price"),
							rs.getString("p_image"),
							rs.getString("p_desc"),
							rs.getInt("p_category")
							))
					);
		}
	
		
		rs.close();
		pstmt.close();
		con.close();
		return cartList;
	}
	
	//카트번호로 카트찾기
	public Cart findSelectByCartNo(int c_no) throws Exception {
		Cart findCart = new Cart();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_C_NO);
		pstmt.setInt(1, c_no);
		ResultSet rs = pstmt.executeQuery();
		
		
		if(rs.next() ) {
			findCart = new Cart(rs.getInt("c_no"),
					rs.getInt("c_qty"),
					rs.getString("m_id"),
					new Product(rs.getInt("p_no"),
							rs.getString("p_name"),
							rs.getInt("p_price"),
							rs.getString("p_desc"),
							rs.getString("p_image"),
							rs.getInt("p_category")
							)
					);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return findCart;
	}
	
}
