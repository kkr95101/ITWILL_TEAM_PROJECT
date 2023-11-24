package com.itwill.shop.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.common.DataSource;

public class ProductDao {
	private DataSource dataSource;
	
	public ProductDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insert(Product product) throws Exception {

		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_INSERT);

		pstmt.setString(1,product.getP_name());
		pstmt.setInt(2, product.getP_price());
		pstmt.setString(3, product.getP_image());
		pstmt.setString(4, product.getP_desc());
		pstmt.setInt(5, product.getP_category());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		

	return rowCount;

	}


public int update(Product product) throws Exception {

	Connection con = dataSource.getConnection();
	PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_UPDATE_BY_NO);

	pstmt.setString(1,product.getP_name());
	pstmt.setInt(2, product.getP_price());
	pstmt.setString(3, product.getP_image());
	pstmt.setString(4, product.getP_desc());
	pstmt.setInt(5, product.getP_category());
	pstmt.setInt(6, product.getP_no());

	int rowCount = pstmt.executeUpdate();

	pstmt.close();
	dataSource.close(con);
	return rowCount;
}


public int delete(int p_no) throws Exception {

	Connection con = dataSource.getConnection();
	PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_DELETE_BY_NO);
	pstmt.setInt(1,p_no);
	int rowCount = pstmt.executeUpdate();

	pstmt.close();
	dataSource.close(con);
	return rowCount;

}


public Product findByNo(int p_no) throws Exception {
	Product findNoProduct = null;
	Connection con = dataSource.getConnection();
	PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_BY_NO);
	pstmt.setInt(1, p_no);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {

		do {
			findNoProduct = new Product (rs.getInt("p_no"),
										 rs.getString("p_name"),
										 rs.getInt("p_price"),
										 rs.getString("p_image"),
										 rs.getString("p_desc"),
										 rs.getInt("p_category"));
		} while(rs.next());


		pstmt.close();
		dataSource.close(con);
	}
	return findNoProduct;
}

/*
		   이름            널?       유형            
		------------- -------- ------------- 
		P_NO          NOT NULL NUMBER(20)    
		P_TITLE                VARCHAR2(50)  
		P_PRICE                NUMBER(10)    
		P_IMAGE                VARCHAR2(50)  
		P_DESC                 VARCHAR2(800) 
 */

public List<Product> findByTitle(String p_name) throws Exception {

	List<Product> productList = new ArrayList<>();
	Connection con = dataSource.getConnection();
	PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_BY_NAME);
	pstmt.setString(1, p_name);
	ResultSet rs = pstmt.executeQuery();

	if(rs.next()) {
		do {
			Product product 
			= new Product (rs.getInt("p_no"), 
							rs.getString("p_name"), 
							rs.getInt("p_price"), 
							rs.getString("p_image"),
							rs.getString("p_desc"),
							rs.getInt("p_category"));

			productList.add(product);

		} while(rs.next());
	}
	return productList;
}

public List <Product> productList() throws Exception {

	List <Product> productList = new ArrayList<>();
	Connection con = dataSource.getConnection();
	PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_ALL);
	ResultSet rs = pstmt.executeQuery();

	if(rs.next()) {
		do {
			Product product 
			= new Product (rs.getInt("p_no"), 
						   rs.getString("p_name"), 
					       rs.getInt("p_price"), 
					       rs.getString("p_image"),
					       rs.getString("p_desc"),
					       rs.getInt("p_category"));

			productList.add(product);
			
		} while(rs.next());
		
		pstmt.close();
		dataSource.close(con);
	}
	return productList;
	
	
}
public List <Product> categoryList(int category) throws Exception {

	List <Product> productList = new ArrayList<>();
	Connection con = dataSource.getConnection();
	PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_CATEGORY);
	pstmt.setInt(1, category);
	ResultSet rs = pstmt.executeQuery();

	if(rs.next()) {
		do {
			Product product 
			= new Product (rs.getInt("p_no"), 
						   rs.getString("p_name"), 
					       rs.getInt("p_price"), 
					       rs.getString("p_image"),
					       rs.getString("p_desc"),
					       rs.getInt("p_category"));

			productList.add(product);
			
		} while(rs.next());
		
		pstmt.close();
		dataSource.close(con);
	}
	return productList;
	
	
}

}