package myProtein.product;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myProtein.category.Category;
import myProtein.mapper.CategoryMapper;
import myProtein.mapper.ProductMapper;

public class ProductDaoImplMybatis implements ProductDao {
	private SqlSessionFactory sqlSessionFactory;

	public ProductDaoImplMybatis() throws Exception {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
	}

	@Override
	public int insert(Product product) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		int rowCount = productMapper.insert(product);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int update(Product product,int qty,int p_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		int rowCount = productMapper.update(product,qty,p_no);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int delete(int p_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		int rowCount = productMapper.delete(p_no);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public Product findByNo(int p_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		Product product = productMapper.findByNo(p_no);
		sqlSession.close();
		return product;
	}
	@Override
	public int findProductNoByNameSize(String p_name,String p_size) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		int productNo = productMapper.findProductNoByNameSize(p_name,p_size);
		sqlSession.close();
		return productNo;
	}
	
	@Override
	public int findProductName(String p_name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		int productNo1 = productMapper.findProductName(p_name);
		sqlSession.close();
		return productNo1;
	}
	
	@Override
	public Product findProductByCategory(int p_category_no1, int p_category_no2, int p_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		Product product = productMapper.findProductByCategory(p_category_no1, p_category_no2, p_no);
		sqlSession.close();
		return product;
	}

	@Override
	public List<Product> findAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> productList = productMapper.findAll();
		sqlSession.close();
		return productList;
	}

	/*
	 * @Override public List<Product> findBest() throws Exception{ SqlSession
	 * sqlSession=sqlSessionFactory.openSession(true); ProductMapper productMapper
	 * =sqlSession.getMapper(ProductMapper.class); List<Product> bestPList =
	 * productMapper.findBest(); sqlSession.close(); return bestPList; }
	 */

	

	// 소 카테고리 보기
	@Override
	public List<Product> findByCategory(int p_category_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> categoryList = productMapper.findByCategory(p_category_no);
		sqlSession.close();
		return categoryList;
	}

	@Override
	public List<Product> findByCategorySize(int p_category_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> categoryList = productMapper.findByCategorySize(p_category_no);
		sqlSession.close();
		return categoryList;
	}
	
	// 소 카테고리 높은가격
	@Override
	public List<Product> findHighByCategory(int p_category_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> categoryList = productMapper.findHighByCategory(p_category_no);
		sqlSession.close();
		return categoryList;
	}

	// 소 카테고리 낮은가격
	@Override
	public List<Product> findLowByCategory(int p_category_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> categoryList = productMapper.findLowByCategory(p_category_no);
		sqlSession.close();
		return categoryList;
	}

	// 소 카테고리 인기
	@Override
	public List<Product> findBestByCategory(int p_category_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> categoryList = productMapper.findBestByCategory(p_category_no);
		sqlSession.close();
		return categoryList;
	}

	// 전체상품 베스트
	@Override
	public List<Product> findBestList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> bestList = productMapper.findBestList();
		sqlSession.close();
		return bestList;
	}

	// 큰 카테고리 보기
	@Override
	public List<Product> findByParentCategory(int p_parent_category_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> pList = productMapper.findByParentCategory(p_parent_category_no);
		sqlSession.close();
		return pList;
	}
	
	// 큰 카테고리 가격 높은순
	@Override
	public List<Product> findHighByParentCategory(int p_parent_category_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> pList = productMapper.findHighByParentCategory(p_parent_category_no);
		sqlSession.close();
		return pList;
	}

	// 큰 카테고리 가격 낮은순
	@Override
	public List<Product> findLowByParentCategory(int p_parent_category_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> pList = productMapper.findLowByParentCategory(p_parent_category_no);
		sqlSession.close();
		return pList;
	}

	// 큰 카테고리 인기순
	@Override
	public List<Product> findBestByParentCategory(int p_parent_category_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> pList = productMapper.findBestByParentCategory(p_parent_category_no);
		sqlSession.close();
		return pList;
	}

}
