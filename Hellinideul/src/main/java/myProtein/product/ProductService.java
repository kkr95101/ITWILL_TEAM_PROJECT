package myProtein.product;

import java.util.List;


public class ProductService {
	private ProductDao productDao;
	
	public ProductService() throws Exception{
		productDao=new ProductDaoImplMybatis();
	}
	
	// 제품 상세보기 검색
	public Product findByNo(int p_no) throws Exception{
		return productDao.findByNo(p_no);
	}
	
	public int findProductNoByNameSize(String p_name,String p_size) throws Exception {
		return productDao.findProductNoByNameSize(p_name, p_size);
	}
	
	public int findProductName(String p_name) throws Exception {
		return productDao.findProductName(p_name);
	}
	
	//제품 상세보기 패런트 카테고리(옷)
	public Product findProductByCategory(int p_category_no1, int p_category_no2, int p_no) throws Exception {
		return productDao.findProductByCategory(p_category_no1, p_category_no2, p_no);
	}
	
	// 게시물 전체보기
	public List<Product> findAll() throws Exception{
		return productDao.findAll();
	}
	// 제품 삭제
	public int delete(int p_no) throws Exception{
		return productDao.delete(p_no);
	}
	// 제품 등록 
	public int insert(Product product) throws Exception {
		return productDao.insert(product);
	}
	// 제품 업데이트 
	public int update(Product product,int qty,int p_no) throws Exception{
		return productDao.update(product,qty,p_no);
	}
	
	/*
	 * 카테고리별 베스트 상품 전체보기 public List<Product> findBest() throws Exception{ return
	 * productDao.findBest(); }
	 */
	
	
	
		// 소 카테고리 보기
		public List<Product> findByCategory(int p_category_no) throws Exception{
			return productDao.findByCategory(p_category_no);
		};
		//소 카테고리 높은가격
		public List<Product> findHighByCategory(int p_category_no)throws Exception{;
			return productDao.findHighByCategory(p_category_no);
		}
		//소 카테고리 높은가격
		public List<Product> findLowByCategory(int p_category_no)throws Exception{
			return productDao.findLowByCategory(p_category_no);
		};
		//소 카테고리 인기
		public List<Product> findBestByCategory(int p_category_no)throws Exception{
			return productDao.findBestByCategory(p_category_no);
		};
		
		//소 카테고리 뿌리기
		public List<Product> findByCategorySize(int p_category_no) throws Exception{
			return productDao.findByCategorySize(p_category_no);
		};
		
		
		// 모든제품 베스트상품
		public List<Product> findBestList() throws Exception{
			return productDao.findBestList();
		};
		

		// 큰 카테고리 보기
		public List<Product> findByParentCategory(int p_parent_category_no) throws Exception{
			return productDao.findByParentCategory(p_parent_category_no);
		};
		// 큰 카테고리 높은가격순
		public List<Product> findHighByParentCategory(int p_parent_category_no) throws Exception{
			return productDao.findHighByParentCategory(p_parent_category_no);
		};
		// 큰 카테고리 낮은가격순
		public List<Product> findLowByParentCategory(int p_parent_category_no) throws Exception{
			return productDao.findLowByParentCategory(p_parent_category_no);
		};
		// 큰 카테고리 인기상품
		public List<Product> findBestByParentCategory(int p_parent_category_no)throws Exception{
			return productDao.findBestByParentCategory(p_parent_category_no);
		};
		
	
	
	
	
	
	
	
	
	
	
	
}
