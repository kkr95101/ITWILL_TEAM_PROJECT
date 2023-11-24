package com.itwill.shop.test;

import com.itwill.shop.product.ProductService;

public class ProductServiceTestMain {
	
	public static void main(String[] args)throws Exception {
	ProductService productService = new ProductService();
		
		System.out.println("1.상품이름으로 하나보기");
		System.out.println(productService.searchProductByName("있을법한모든것"));
		
		System.out.println("2.상품리스트 전체보기");
		System.out.println(productService.productList());
	}
}
