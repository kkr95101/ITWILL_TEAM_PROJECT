package com.itwill.shop.product;

public class ProductSQL {
	public static final String PRODUCT_INSERT 
	= "insert into product(p_no, p_name, p_price, p_image, p_desc, p_category) values(product_p_no_SEQ.nextval,?,?,?,?,?)";// 상품추가
	
	public static final String PRODUCT_UPDATE_BY_NO
	= "update product set p_name = ?, p_price = ?, p_image = ?, p_desc = ?, p_category = ? where p_no = ?"; //상품번호로 업데이트
	
	public static final String PRODUCT_DELETE_BY_NO =
			"delete from product where p_no = ?"; // 상품번호로 삭제
	
	public static final String PRODUCT_BY_NO =
			"select * from product where p_no = ? "; //상품번호로 찾기 
	
	public static final String PRODUCT_BY_NAME =
			"select * from product where p_name like '%'||?||'%'"; //특정 상품명으로 찾기
	
	public static final String PRODUCT_ALL =
			"select * from product order by p_no"; // 전체 상품 리스트
	
	public static final String PRODUCT_CATEGORY =
			"select * from product where p_category = ?";
			
}
