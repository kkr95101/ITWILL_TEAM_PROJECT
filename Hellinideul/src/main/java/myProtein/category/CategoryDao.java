package myProtein.category;

import java.util.List;

public interface CategoryDao {

	int insert(Category category) throws Exception;
	
	List<Category> findByParentCategory(int p_parent_category_no) throws Exception;

}