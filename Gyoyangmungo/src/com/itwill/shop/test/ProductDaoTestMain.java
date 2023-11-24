package com.itwill.shop.test;

import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;

public class ProductDaoTestMain {
	
	public static void main(String[] args)throws Exception {
		ProductDao productDao = new ProductDao();
		
		System.out.println("0.insert   --> "+productDao.insert(new Product(0, "춘향전", 40000, "춘향전.jpg", "이몽룡과춘향", 10)));
		System.out.println("1.delete   --> "+productDao.delete(5));
		System.out.println("2.update   --> "+productDao.update(new Product(3, "졸리다이제", 20000, "잘래.jpg", "그만해", 20)));
		System.out.println("3.findByNo -->" + productDao.findByNo(10));
		System.out.println("4.findAll -->" + productDao.productList());
	}
}
