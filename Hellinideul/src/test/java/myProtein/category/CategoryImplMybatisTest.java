package myProtein.category;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CategoryImplMybatisTest {
	
	CategoryDao categoryDao;
	
	@BeforeEach
	void set() throws Exception {
		categoryDao = new CategoryDaoImplMybatis();
	}
	
	@Test
	void ListTest() throws Exception{
		List<Category> categoryList = categoryDao.findByParentCategory(1000);
		System.out.println(categoryList);
		assertNotNull(categoryList);
		assertNotSame(categoryList.size(), 0);
	}
	@Test
	void categoryInsert() throws Exception{
		int insertRowCount=categoryDao.insert(new Category(1115, 1000, "웨이프로틴"));
		assertTrue(insertRowCount==1,"삽입실패");
	}
}
