package com.itwill.shop.order;

public class OrderSQL {
	public final static String ORDER_DELETE_BY_USERID = "delete from orders where m_id=?";
	public final static String ORDER_DELETE_BY_O_NO = "delete from orders where o_no=?";
	public final static String ORDER_INSERT = "insert into orders(o_no,o_desc,o_date,o_price,m_id) values(orders_o_no_seq.nextval,?,sysdate,?,?)";
	public final static String ORDER_SELECT_BY_USERID = "select * from orders where m_id=? order by o_no desc";
	
	public final static String ORDERITEM_INSERT = "insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_seq.nextval,?,orders_o_no_SEQ.currval,?)";
	
	public final static String ORDER_SELECT_WITH_PRODUCT_BY_USERID ="select * from orders where p_no=?";
	public final static String ORDER_SELECT_WITH_ORDERITEM_BY_O_NO = 
			"select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where o.o_no = ?";
			
	public final static String ORDER_SELECT_WITH_ORDERITEM_BY_USERID = 	"select * from orders o join order_item oi on o.o_no=oi.o_no join product p on oi.p_no=p.p_no where o.m_id = ?";
	
	
}
