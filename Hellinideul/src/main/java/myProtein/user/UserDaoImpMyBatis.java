package myProtein.user;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myProtein.mapper.UserMapper;

public class UserDaoImpMyBatis implements UserDao{
	
	public static final String NAMESPACE="myProtein.user";

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpMyBatis() throws Exception {
		this.sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
	}

	public User findById(String u_id) throws Exception{
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findById(u_id);
		sqlSession.close();
		return user;
	}

	@Override
	public int insert(User user) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int rowCount=userMapper.insert(user);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int update(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int rowCount=userMapper.update(user);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int delete(String u_id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int rowCount=userMapper.delete(u_id);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public List<User> findAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> userList=userMapper.findAll();
		sqlSession.close();
		return userList;
	}


	@Override
	public int countByUserId(String u_id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);		
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		int rowCount=userMapper.countByUserId(u_id);
		sqlSession.close();
		return rowCount;
	}

}
