package com.itwill.shop.test;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.product.Product;

public class CartServiceTestMain {
	public static void main(String[] args) throws Exception{
		CartService cartService = new CartService();
		
		
		System.out.println("1. 카트 추가");
		//Cart cart = new Cart(0, 1, "user3", new Product(1, "문과 남자의 과학공부", 15750, "유시민이 들려주는 과학 인문학이야기", "/com/itwill/shop/image/bestSeller1"));
		//System.out.println(cartService.addCart(cart));
		
		System.out.println("2. 카트 수량 변경");
		//System.out.println(cartService.updateCart(1, 20));
		
		System.out.println("3. 카트 아이템 1개 삭제");
		//System.out.println(cartService.deleteCartItemByCartNo(2));
		
		System.out.println("4. 카트 전체 삭제");
		//System.out.println(cartService.deleteCartItemByUserId("user3"));
		
		System.out.println("5. 카트 아이템 1개 보기");
		//System.out.println(cartService.findCartItemByCartNo(1));
		
		
		
		System.out.println("4. 카트 아이템 전체 보기");
		//System.out.println(cartService.findCartItemByAll("user1"));
		
		
		
	}
	
		
	
	
	
	
	
	
	
	
}
