package myProtein.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myProtein.cart.CartDao;
import myProtein.cart.CartService;
import myProtein.product.ProductService;

class OrderServiceTest {
	OrderService orderService;
	CartService cartService;
	ProductService productService;
	@BeforeEach
	void setUp() throws Exception {
		orderService = new OrderService();
		cartService = new CartService();
		productService = new ProductService();
		
	}

	@Test
	void testOrderService() throws Exception {
		orderService = new OrderService();
		assertNotNull(orderService);
	}





	@Test
	void testCreateStringStringArray() throws Exception {
		List<String> strList = new ArrayList<String>();
		strList.add(Integer.toString(cartService.findCartItemByCartNo(10).getC_no()));
		Object[] cart_item_noStr_array = (Object[]) strList.toArray();
		String[] stringArray = new String[cart_item_noStr_array.length];

        for (int i = 0; i < cart_item_noStr_array.length; i++) {
            stringArray[i] = String.valueOf(cart_item_noStr_array[i]);
        }
		int rowCount = orderService.create("ccc",stringArray);
		assertTrue(rowCount == 0, "삭제실패");
	}

	@Test
	void testCreateOrderStringArray() throws Exception {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		OrderItem orderItem = new OrderItem(0, 4, 0, productService.findByNo(40));
		orderItemList.add(orderItem);
		Order order = new Order(0, "afdgasd", null, 12000, "ddd", orderItemList);
		List<String> strList = new ArrayList<String>();
		strList.add(Integer.toString(cartService.findCartItemByCartNo(12).getC_no()));
		Object[] cart_item_noStr_array = (Object[]) strList.toArray();
		String[] stringArray = new String[cart_item_noStr_array.length];
		for (int i = 0; i < cart_item_noStr_array.length; i++) {
            stringArray[i] = String.valueOf(cart_item_noStr_array[i]);
        }
		int rowCount = orderService.create(order,stringArray);
		assertTrue(rowCount == 1, "삭제실패");
	}

	@Test
	void testCreateOrder() throws Exception {
		
	}

}
