package com.itwill.shop.order;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private int o_no;
	private String o_desc;
	private int o_price;
	private Date o_date;
	private String m_id;
	
	private List<OrderItem> orderItemList;
	
	public Order() {
		orderItemList= new ArrayList<OrderItem>();
	}
	
	public Order(int o_no, String o_desc, int o_price, Date o_date, String m_id ,  List<OrderItem> orderItemList) {
		super();
		this.o_no = o_no;
		this.o_desc = o_desc;
		this.o_price = o_price;
		this.o_date = o_date;
		this.m_id = m_id;
		if(orderItemList!=null) {
			this.orderItemList = orderItemList;
		}else {
			this.orderItemList=new ArrayList<OrderItem>();
		}
	}
	
	public Order(int o_no, String o_desc, int o_price, Date o_date, String m_id) {
		super();
		this.o_no = o_no;
		this.o_desc = o_desc;
		this.o_price = o_price;
		this.o_date = o_date;
		this.m_id = m_id;
		if(orderItemList!=null) {
			this.orderItemList = orderItemList;
		}else {
			this.orderItemList=new ArrayList<OrderItem>();
		}
	}
	
	
	
	


	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public String getO_desc() {
		return o_desc;
	}

	public void setO_desc(String o_desc) {
		this.o_desc = o_desc;
	}

	public int getO_price() {
		return o_price;
	}

	public void setO_price(int o_price) {
		this.o_price = o_price;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "Order [o_no=" + o_no + ", o_desc=" + o_desc + ", o_price=" + o_price + ", o_date=" + o_date + ", m_id="
				+ m_id + ", orderItem=" + orderItemList + "] \n";
	}
	
	
	
	
}
