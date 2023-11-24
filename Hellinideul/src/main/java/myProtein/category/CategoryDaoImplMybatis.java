package myProtein.category;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myProtein.mapper.CategoryMapper;
import myProtein.mapper.ProductMapper;

public class CategoryDaoImplMybatis implements CategoryDao {
	private SqlSessionFactory sqlSessionFactory;

	public CategoryDaoImplMybatis() throws Exception {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("Mybatis-config.xml"));
	}
	
	@Override
	public int insert(Category category) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		CategoryMapper categoryMapper=sqlSession.getMapper(CategoryMapper.class);
		int rowCount=categoryMapper.insert(category);
		sqlSession.close();
		return rowCount;
	}
	
	@Override
	public List<Category> findByParentCategory(int p_parent_category_no){
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		CategoryMapper categoryMapper=sqlSession.getMapper(CategoryMapper.class);
		List<Category> CategoryList = categoryMapper.findByParentCategory(p_parent_category_no);
		return CategoryList;
	}
	
	
}
