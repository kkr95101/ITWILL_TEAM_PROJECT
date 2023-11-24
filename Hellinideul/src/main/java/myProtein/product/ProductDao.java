   package myProtein.product;

import java.util.List;




public interface ProductDao {

	int insert(Product product) throws Exception;

	int update(Product product,int qty,int p_no) throws Exception;

	int delete(int p_no) throws Exception;

	Product findByNo(int p_no) throws Exception;
	
	int findProductNoByNameSize(String p_name,String p_size) throws Exception;
	
	int findProductName(String p_name) throws Exception;
	
	Product findProductByCategory(int p_category_no1, int p_category_no2, int p_no) throws Exception;

	List<Product> findAll() throws Exception;

	//List<Product> findBest() throws Exception;  카테고리별 베스트상품 

	
	// 소 카테고리 보기
	List<Product> findByCategory(int p_category_no) throws Exception;
	//소 카테고리 높은가격
	List<Product> findHighByCategory(int p_category_no)throws Exception;
	//소 카테고리 높은가격
	List<Product> findLowByCategory(int p_category_no)throws Exception;
	//소 카테고리 인기
	List<Product> findBestByCategory(int p_category_no)throws Exception;
	// 의류 사이즈
	List<Product> findByCategorySize(int p_category_no) throws Exception;
	
	// 모든제품 베스트상품
	List<Product> findBestList() throws Exception;
	

	// 큰 카테고리 보기
	List<Product> findByParentCategory(int p_parent_category_no) throws Exception;
	// 큰 카테고리 높은가격순
	List<Product> findHighByParentCategory(int p_parent_category_no) throws Exception;
	// 큰 카테고리 낮은가격순
	List<Product> findLowByParentCategory(int p_parent_category_no) throws Exception;
	// 큰 카테고리 인기상품
	List<Product> findBestByParentCategory(int p_parent_category_no)throws Exception;
	
}