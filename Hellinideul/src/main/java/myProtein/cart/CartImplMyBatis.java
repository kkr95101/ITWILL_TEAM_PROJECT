package myProtein.cart;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import myProtein.mapper.CartMapper;

public class CartImplMyBatis implements CartDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public CartImplMyBatis() throws Exception {
		this.sqlSessionFactory = 
				new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
	}
	@Override
	public int insert(String u_id,int p_no,int c_qty) {
		 SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
			int rowCount = cartMapper.insert(u_id,p_no,c_qty);
			sqlSession.commit();
			sqlSession.close();
			return rowCount;
			
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			return 0;
		}
	}

	@Override
	public int deleteByU_Id(String u_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
			int rowCount = cartMapper.deleteByU_Id(u_id);
			sqlSession.commit();
			sqlSession.close();
			return rowCount;
			
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			return 0;
		}
	}

	@Override
	public int deleteByC_No(int c_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
			int rowCount = cartMapper.deleteByC_No(c_no);
			sqlSession.commit();
			sqlSession.close();
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			return 0;
		}
		
	}

	@Override
	public int updateByC_No(int c_qty, int c_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
			int rowCount = cartMapper.updateByC_No(c_qty, c_no);
			sqlSession.commit();
			sqlSession.close();
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			return 0;
		}
		
	}

	@Override
	public int updateByU_Id(String u_id,int p_no,int c_qty) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
			int rowCount = cartMapper.updateByU_Id(u_id,p_no,c_qty);
			sqlSession.commit();
			sqlSession.close();
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			return 0;
		}
		
	}

	@Override
	public int cartRowCount(String u_id, int p_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		int cartRowCount = cartMapper.cartRowCount(u_id, p_no);
		sqlSession.close();
		return cartRowCount;
	}

	@Override
	public List<Cart> findCartListByU_Id(String u_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		List<Cart> cartList = cartMapper.findCartListByU_Id(u_id);
		sqlSession.close();
		return cartList;
	}
	@Override
	public Cart findByCartNo(int c_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
		Cart cart = cartMapper.findByCartNo(c_no);
		sqlSession.close();
		return cart;
	}

}
