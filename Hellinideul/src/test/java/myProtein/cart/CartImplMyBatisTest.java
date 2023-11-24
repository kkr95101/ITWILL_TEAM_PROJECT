package myProtein.cart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myProtein.category.Category;
import myProtein.product.Product;

class CartImplMyBatisTest {
	
	CartDao cartDao;
	
	@BeforeEach
	void set() throws Exception {
		cartDao = new CartImplMyBatis();
	}
	
	@Test
	void testInsert() throws Exception {
		int insertRowCount = cartDao.insert("aaa",59,1);
		assertTrue(insertRowCount==1, "삽입실패");
		
	}

	@Test
	void testDeleteByU_Id() throws Exception {
		int deleteRowCount = cartDao.deleteByU_Id("aaa");
		assertTrue(deleteRowCount==1, "삭제실패");
	}

	@Test
	void testDeleteByC_No() throws Exception {
		int deleteRowCount = cartDao.deleteByC_No(2);
		assertTrue(deleteRowCount==1, "삭제실패");
	}

	@Test
	void testUpdateByC_No() {
		int updateRowCount = cartDao.updateByC_No(3, 60);
		assertTrue(updateRowCount==1, "수정실패");
	}

	@Test
	void testUpdateByU_Id() {
		int updateRowCount = cartDao.updateByU_Id("aaa",54,2);
		assertTrue(updateRowCount==1, "수정실패");
	}

	@Test
	void testCartRowCount() {
		int cartRowCount = cartDao.cartRowCount("aaa", 54);
		assertTrue(cartRowCount==4, "수정실패");
	}

	@Test
	void testFindCartListByU_Id() {
		List<Cart> cartList = cartDao.findCartListByU_Id("aaa");
		System.out.println(cartList);
		assertNotNull(cartList);
		assertNotSame(cartList.size(), 0);
	}
	@Test
	void testFindByCartNo() {
		Cart cart = cartDao.findByCartNo(3);
		assertNotNull(cart);
	}

}
