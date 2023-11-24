package myProtein.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myProtein.product.ProductDao;
import myProtein.product.ProductDaoImplMybatis;

class OrderImplMybatisTest {
	OrderDao orderDao;
	ProductDao productDao;
	@BeforeEach
	void setUp() throws Exception {
		orderDao = new OrderImplMybatis();
		productDao = new ProductDaoImplMybatis();
		
	}


	@Test
	void testInsert() throws Exception {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		OrderItem orderItem = new OrderItem(0, 2, 0, productDao.findByNo(40));
		orderItemList.add(orderItem);
		int rowCount = orderDao.insert(new Order(0, "fsdag", null, 1000000, "bbb", orderItemList));
		assertTrue(rowCount == 1, "삭제실패");
	}


}
