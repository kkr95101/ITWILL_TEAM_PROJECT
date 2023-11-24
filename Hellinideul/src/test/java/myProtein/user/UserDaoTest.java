package myProtein.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDaoTest {
	UserDao userDao;

	@BeforeEach
	void userDaoCreate() throws Exception {
		userDao = new UserDaoImpMyBatis();
	}

	@Test
	void testUserDao() throws Exception {
		userDao = new UserDaoImpMyBatis();
		assertNotNull(userDao);
	}

	@Test
	void testFindById() throws Exception {
		User user = userDao.findById("aaa");
		assertNotNull(user);
		System.out.println(user);

	}

	@Test
	void testFindAll() throws Exception {
		List<User> userList = userDao.findAll();
		assertNotNull(userList);
		assertNotSame(userList.size(), 0);
		System.out.println(userList);
	}

	/*
	@Test
	void testInsert() throws Exception {
		int insertRowCount = userDao.insert(new User("hhhh", "hhhh", "테스트이름", "010-8888-8888", "hhh@gmail.com", "주소 테스트"));
		assertTrue(insertRowCount == 1, "삽입실패");
	}
	*/

	/*
	 @Test 
	 void testUpdate() throws Exception{ 
		 int updateRowCount=userDao.update(new User("hhhh", "zzz", "이름변경","010-1234-1234", "수정@gmail.com", "주소변경")); 
		 assertTrue(updateRowCount==1,"수정실패");
		 }
	 */
	
	/*
	 @Test void testDelete() throws Exception{ 
		 int deleteRowCount=userDao.delete("hhhh"); 
		 assertTrue(deleteRowCount==1, "삭제실패");
	 }
	 
	*/
	 
}
