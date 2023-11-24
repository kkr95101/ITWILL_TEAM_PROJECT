package com.itwill.shop.product;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception {
		ProductService productService = new ProductService();
		
		//상품번호로 검색
		System.out.println(productService.searchProductByNo(4));
		//상품명으로 검색
		System.out.println(productService.searchProductByName("안녕"));
		//상품리스트
		System.out.println(productService.productList());
	}

}
