package myProtein.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myProtein.category.Category;

class ProductDaoTest {

	ProductDao productDao;

	@BeforeEach
	void setUp() throws Exception {
		productDao = new ProductDaoImplMybatis();
	}

//	@Test
//	void testProductDao() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void testInsert() throws Exception {
//		int insertRowCount = productDao
//				.insert(new Product(0, "test", 20000, "image", "test", 0, 0, null, 1115, new Category(),new Category()));
//		assertTrue(insertRowCount == 1, "삽입실패");
//	}
//
//	@Test
//	void testDelete() throws Exception {
//		int deleteRowCount = productDao.delete(17);
//		assertTrue(deleteRowCount == 1, "삭제실패");
//	}
//
//	@Test
//	void testFindProductList() throws Exception {
//		Category category = new Category(1, 1, "스프링");
//		List<Product> productList = productDao.findAll();
//		System.out.println(productList);
//		assertNotNull(productList);
//		assertNotSame(productList.size(), 0);
//	}
//
	/*
	 * @Test void testFindProductNo() throws Exception { Product product =
	 * productDao.findByNo(5); assertNotNull(product); }
	 * 
	 * @Test void testFindProductCategory() throws Exception { Product product =
	 * productDao.findProductByCategory(2000,399,1); System.out.println(product);
	 * assertNotNull(product); }
	 */

//	@Test
//	void testUpdate() throws Exception {
//		int updateRowCount = productDao.update(new Product(21, null, 0, null, null, 0, 0, null, 0, new Category(),new Category()));
//		assertTrue(updateRowCount == 1, "수정실패");
//	}
//	
	

	/*  카테고리별 베스트 상품
	 * @Test void testFindBest() throws Exception { List<Product> pList =
	 * productDao.findBest(); System.out.println(pList); assertNotNull(pList);
	 * assertNotSame(pList.size(), 0); }
	 */

	
	
	
	@Test
	void testBestList() throws Exception {
		List<Product> bestProductList = productDao.findBestList();
		System.out.println(bestProductList.size());
		assertNotNull(bestProductList);
		assertNotSame(bestProductList.size(), 0);
	}
	
	/*
	 * @Test void testFindParentCategory() throws Exception { List<Product>
	 * productList = productDao.findByParentCategory(2000);
	 * System.out.println(productList); assertNotNull(productList);
	 * assertNotSame(productList.size(), 0); }
	 */
//	
//	@Test
//	void testBest() throws Exception {
//		List<Product> productList = productDao.findBestByParentCategory(2000);
//		System.out.println(productList.get(0));
//		assertNotNull(productList);
//		assertNotSame(productList.size(), 0);
//	}
//	
//	@Test
//	void testLow() throws Exception {
//		List<Product> productList = productDao.findLowByParentCategory(2000);
//		System.out.println(productList.get(0));
//		assertNotNull(productList);
//		assertNotSame(productList.size(), 0);
//	}
//	
//	@Test
//	void testHigh() throws Exception {
//		List<Product> productList = productDao.findHighByParentCategory(2000);
//		System.out.println(productList.get(0));
//		assertNotNull(productList);
//		assertNotSame(productList.size(), 0);
//	}
//	 
//	
//	@Test
//	void testFindCategory() throws Exception {
//		List<Product> productCategoryList = productDao.findByCategory(3100);
//		System.out.println(productCategoryList.get(0));
//		assertNotNull(productCategoryList);
//		assertNotSame(productCategoryList.size(), 0);
//	}
//	
//	@Test
//	void testHighCategory() throws Exception {
//		List<Product> productCategoryList = productDao.findHighByCategory(3100);
//		System.out.println(productCategoryList.get(0));
//		assertNotNull(productCategoryList);
//		assertNotSame(productCategoryList.size(), 0);
//	}
//	
//	@Test
//	void testLowCategory() throws Exception {
//		List<Product> productCategoryList = productDao.findLowByCategory(3100);
//		System.out.println(productCategoryList.get(0));
//		assertNotNull(productCategoryList);
//		assertNotSame(productCategoryList.size(), 0);
//	}
//	
//	
//	
//	@Test
//	void testBestCategory() throws Exception {
//		List<Product> productCategoryList = productDao.findBestByCategory(3100);
//		System.out.println(productCategoryList.get(0));
//		assertNotNull(productCategoryList);
//		assertNotSame(productCategoryList.size(), 0);
//	}
//	
}
