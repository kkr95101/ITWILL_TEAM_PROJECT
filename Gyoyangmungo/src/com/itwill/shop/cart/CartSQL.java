package com.itwill.shop.cart;

public class CartSQL {
	//카트에 담기
		//public static String CART_INSERT="insert into cart(c_no,c_qty,p_no,m_id) values(cart_c_no_SEQ.nextval,?,?,?)";	
		public static final String CART_INSERT = "insert into cart(c_no, c_qty, p_no, m_id) values(cart_c_no_seq.nextval,?,?,?)";
		//카트에 제품의 수량 변경 (카트리스트에서 변경)
		public static final String CART_UPDATE_C_NO = "update cart set c_qty=? where c_no=?";
		//카트에 있는 제품의 수량 변경 (상품에서 카트 추가시 변경)
		public static final String CART_UPDATE_P_NO = "update cart set c_qty=c_qty+? where m_id=? and p_no=?";
		//아이디로 카트 전체 날리기(주문완료 시 카트 삭제)
		public static final String CART_DELETE_U_ID = "delete from cart where m_id=?";
		//카트 물품 하나 삭제 
		public static final String CART_DELETE_C_NO = "delete from cart where c_no=?";
		//해당 카트번호의 카트내용(카트번호,수량)+제품내용(제품번호,이름,이미지,가격,설명) 찾기
		public static final String CART_SELECT_C_NO = "select * from cart c join product p on c.p_no = p.p_no where c_no=?";
		//해당 아이디가 카트에 담은 모든 제품의 카트내용(카트번호,수량)+제품내용(제품번호,이름,이미지,가격,설명) 찾기
		public static final String CART_SELECT_ALL = "select * from cart c join product p on c.p_no=p.p_no where m_id=?";
		//해당 아이디의 카트 row 수
		public static final String CART_COUNT_USERID_P_NO = "select count(*) from cart where m_id=? and p_no=?";
	
}
