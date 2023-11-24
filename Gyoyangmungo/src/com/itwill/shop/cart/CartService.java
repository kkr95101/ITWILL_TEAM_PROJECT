package com.itwill.shop.cart;

import java.util.List;

public class CartService {
	private CartDao cartDao;
	public CartService () throws Exception {
		cartDao = new CartDao();
	}
	
	
	// 카트추가
	public int addCart(Cart cart) throws Exception {
		if(cartDao.countByCart(cart.getM_Id(), cart.getProduct().getP_no()) > 0) {
			return cartDao.updateByProduct(cart.getCart_qty(), cart.getM_Id(), cart.getProduct().getP_no());
		} else {
			return cartDao.insert(cart);
		}
	}
	// 카트수량변경
	public int updateCart(int c_no, int c_qty) throws Exception {
		return cartDao.update(c_qty, c_no);
	}
	
	// 로그인한 유저 카트 아이템 1개 삭제
	public int deleteCartItemByCartNo(int c_no) throws Exception {
		return cartDao.deleteByCartNo(c_no);
	}
	
	// 로그인한 유저 카트 삭제
	public int deleteCartItemByUserId(String u_id) throws Exception {
		return cartDao.deleteByAll(u_id);
	}
	
	// 카트아이템1개 보기
	public Cart findCartItemByCartNo(int c_no) throws Exception {
		return cartDao.findSelectByCartNo(c_no);
	}
	
	public List<Cart> findCartItemByAll(String u_id) throws Exception {
		return cartDao.findSelectAll(u_id);
	}
	
	// 카트 리스트 가격 총합
	public int addCartListTotal(String m_id) throws Exception {
		int total =0;
		List<Cart> cartList = cartDao.findSelectAll(m_id);
		for (Cart cart : cartList) {
			total+= cart.getCart_qty()* cart.getProduct().getP_price();
		}
		return total;
	}
	
	// 카트 1개의 총합
	public int addCartTotal (int c_no) throws Exception {
		int total =0;
		Cart cart = cartDao.findSelectByCartNo(c_no);
		total+= cart.getCart_qty() * cart.getProduct().getP_price();
		return total;
	}
	
}
