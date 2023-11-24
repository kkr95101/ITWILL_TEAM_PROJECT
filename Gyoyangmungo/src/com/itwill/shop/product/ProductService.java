package com.itwill.shop.product;

import java.util.List;

public class ProductService {
	private ProductDao productDao;
	
	public ProductService() throws Exception {
		 productDao = new ProductDao();
	}
	// 상품추가
	public int addProduct(Product addProduct) throws Exception {
		return productDao.insert(addProduct);
	}
	// 상품수정
	public int updateProduct(Product updateProduct) throws Exception {
		return productDao.update(updateProduct);
	}
	// 상품번호로 삭제
	public int deleteProduct(int p_no) throws Exception {
		return productDao.delete(p_no);
	}
	// 상품번호로 검색
	public Product searchProductByNo(int p_no) throws Exception {
		return productDao.findByNo(p_no);
	}
	// 상품명으로 검색
	public List<Product> searchProductByName(String p_name) throws Exception {
		return productDao.findByTitle(p_name);
	}
	// 상품리스트
	public List<Product> productList() throws Exception {
		return productDao.productList();
	}
	//상품카테고리별리스트
	//베스트셀러
	public List<Product> bestSellerList() throws Exception {
		return productDao.categoryList(10);
	}
	//소설
	public List<Product> novelList() throws Exception {
		return productDao.categoryList(20);
	}
	//자기계발
	public List<Product> selfImprovementList() throws Exception {
		return productDao.categoryList(30);
	}
}
