package com.itwill.shop.cart;

import com.itwill.shop.product.Product;

public class Cart {
	private int c_no;
	private int c_qty;
	private String m_Id ;
	private Product product;
	
	
	public Cart() {}

	public Cart(int cart_no, int cart_qty, String m_Id, Product product) {
		super();
		this.c_no = cart_no;
		this.m_Id = m_Id;
		this.product = product;
		this.c_qty = cart_qty;
	}


	public int getCart_no() {
		return c_no;
	}

	public void setCart_no(int cart_no) {
		this.c_no = cart_no;
	}

	public String getM_Id() {
		return m_Id;
	}

	public void setM_Id(String u_Id) {
		this.m_Id = u_Id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCart_qty() {
		return c_qty;
	}

	public void setCart_qty(int cart_qty) {
		this.c_qty = cart_qty;
	}

	@Override
	public String toString() {
		return "cart [cart_no=" + c_no + ", m_Id=" + m_Id + ", product=" + product + ", cart_qty=" + c_qty
				+ "]\n";
	}

	
	
	
	
	
}
