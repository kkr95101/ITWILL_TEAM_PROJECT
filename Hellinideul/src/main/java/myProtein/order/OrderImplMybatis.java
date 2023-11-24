package myProtein.order;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import myProtein.mapper.OrderMapper;
import myProtein.product.Product;
import myProtein.product.ProductDao;
import myProtein.product.ProductDaoImplMybatis;

public class OrderImplMybatis implements OrderDao{
	private ProductDao productDao;
	
	private SqlSessionFactory sqlSessionFactory;
	
	public OrderImplMybatis()throws Exception{
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
		
		productDao = new ProductDaoImplMybatis();
	}
	
	
	@Override
	public int insert(Order order) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			OrderMapper orderMapper= sqlSession.getMapper(OrderMapper.class);
			int rowCount = orderMapper.insert(order);
			List<OrderItem> orderItemList= order.getOrderItemList();
			for(OrderItem orderItem:orderItemList) {
				orderItem.setO_no(order.getO_no());
				Product product = orderItem.getProduct();
				productDao.update(product,orderItem.getOi_qty(),product.getP_no());
				orderMapper.insertOrderItem(orderItem);
			}
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
	public int deleteByUserId(String u_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			OrderMapper orderMapper= sqlSession.getMapper(OrderMapper.class);
			int rowCount = orderMapper.deleteByUserId(u_id);
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
	public int deleteByOrderNo(int o_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			OrderMapper orderMapper= sqlSession.getMapper(OrderMapper.class);
			int rowCount = orderMapper.deleteByOrderNo(o_no);
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
	public List<Order> findOrderByUserId(String u_id) {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<Order> orderList=orderMapper.findOrderByUserId(u_id);
		sqlSession.close();
		return orderList;
	}

	@Override
	public List<Order> findOrderWithOrderItemByUserId(String u_id) {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<Order> orderList=orderMapper.findOrderWithOrderItemByUserId(u_id);
		sqlSession.close();
		return orderList;
	}

	@Override
	public Order findByOrderNo(int o_no) {
		SqlSession sqlSession= sqlSessionFactory.openSession(true);
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		Order order=orderMapper.findByOrderNo(o_no);
		sqlSession.close();
		return order;
	}

}
