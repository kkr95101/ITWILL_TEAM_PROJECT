package myProtein.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;


public interface UserDao {

	
	public int insert(User user) throws Exception;
	

	public int update(User user) throws Exception;
	

	public int delete(String u_id)throws Exception;
	

	public List<User> findAll() throws Exception;
	

	public User findById(String u_id)throws Exception;

	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	public int countByUserId(String u_id) throws Exception;
	

}
