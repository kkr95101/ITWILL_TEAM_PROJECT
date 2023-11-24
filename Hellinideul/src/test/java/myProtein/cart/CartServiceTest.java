package myProtein.cart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myProtein.product.Product;

class CartServiceTest {
	CartService cartService;
	@BeforeEach
	void setUp() throws Exception {
		cartService = new CartService();
	}

	@Test
	void testCartService() throws Exception {
		cartService = new CartService();
		assertNotNull(cartService);
	}

	@Test
	void testAddCart() throws Exception {
		int insertRowCount = cartService.addCart("aaa",54,1);
		assertTrue(insertRowCount==1, "삽입실패");
	}

	@Test
	void testRemoveCartByC_No() throws Exception {
		int deleteRowCount = cartService.removeCartByC_No(8);
		assertTrue(deleteRowCount==1, "삭제실패");
	}

	@Test
	void testRemoveCartByU_Id() throws Exception {
		int deleteRowCount = cartService.removeCartByU_Id("aaa");
		assertTrue(deleteRowCount==1, "삭제실패");
	}

	@Test
	void testUpdateByC_No() throws Exception {
		int updateRowCount = cartService.updateByC_No(3, 8);
		assertTrue(updateRowCount==1, "수정실패");
	}

	@Test
	void testUpdateByU_Id() throws Exception {
		int updateRowCount = cartService.updateByU_Id("aaa",54,2);
		assertTrue(updateRowCount==1, "수정실패");
	}

	@Test
	void testFindAll() throws Exception {
		List<Cart> cartList = cartService.findAll("a");
		assertNotNull(cartList);
		assertNotSame(cartList.size(), 0);
	}


}
