package com.itwill.shop.test;

import java.util.ArrayList;
import java.util.Date;

import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderDao;
import com.itwill.shop.order.OrderItem;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;

public class OrderDaoTestMain {

	public static void main(String[] args)throws Exception {
		OrderDao orderDao = new OrderDao();
//		System.out.println(orderDao.findOrderByUserId("user1")); //orderitem없이 뽑음
//		System.out.println("***********************");
//		System.out.println(orderDao.findByOrderNo(23));
//		System.out.println("***********************");
		System.out.println(orderDao.findOrderWithOrderItemByUserId("user1")); //orderitem까지 뽑음
		
//		System.out.println(orderDao.findOrderByUserId("user1"));
		
		/*
		 * 1.상품에서직접주문
		 */
//		int p_qty=1;
//		int p_no=1;
//		ProductDao productDao=new ProductDao();
//		Product product=productDao.findByNo(p_no);
//		
//		ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
//		orderItemList.add(new OrderItem(0, p_qty, p_no, product));
//		
//		Order order=
//				new Order(0,product.getP_name()+"외 0종" ,product.getP_price(), null, "user2",orderItemList);
//		orderDao.insert(order);
//		
//		System.out.println(orderDao.findOrderByUserId("user2"));
		/*
		 * 2.cart에서 주문
		 */
		
	
		

	}

}
