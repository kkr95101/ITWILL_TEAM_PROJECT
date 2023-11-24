package com.itwill.shop.product;

public class Product {
	private int p_no; //상품번호
	private String p_name; //상품명
	private int p_price; //상품가격
	private String p_image; //상품이미지
	private String p_desc; //상품상세설명
	private int p_category; //상품카테고리번호

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int p_no, String p_name, int p_price, String p_image, String p_desc, int p_category) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_image = p_image;
		this.p_desc = p_desc;
		this.p_category = p_category;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	public int getP_category() {
		return p_category;
	}

	public void setP_category(int p_category) {
		this.p_category = p_category;
	}

	@Override
	public String toString() {
		return "Product [p_no=" + p_no + ", p_name=" + p_name + ", p_price=" + p_price + ", p_image=" + p_image
				+ ", p_desc=" + p_desc + ", p_category=" + p_category + "]";
	}


}
