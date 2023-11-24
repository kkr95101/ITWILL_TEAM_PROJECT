package myProtein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import myProtein.category.Category;

public interface CategoryMapper {
	@Insert("insert into category(p_category_no,p_parent_category_no,p_category_name) values(#{p_category_no},#{p_parent_category_no},#{p_category_name})")
	public int insert(Category category) throws Exception;
	
	
	
	
	@ResultMap("categoryResultMap")
	@Select("select * from product p \r\n"
			+ "join category c \r\n"
			+ "on p.p_category_no=c.p_category_no\r\n"
			+ "join category ce \r\n"
			+ "on ce.p_category_no=c.p_parent_category_no\r\n"
			+ "where ce.p_parent_category_no=#{p_parent_category_no}")
	public List<Category> findByParentCategory(int p_parent_category_no);
	
}
       