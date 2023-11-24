   package myProtein.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import myProtein.category.Category;
import myProtein.product.Product;

public interface ProductMapper {
	
	@Insert("insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)\r\n"
			+ "         values(product_p_no_SEQ.nextval,#{p_name},#{p_price},#{p_image},#{p_desc},#{p_category_no})")
	public int insert(Product product) throws Exception;
	

/*<<<<<<< HEAD
	@Update("update product set product.p_order_count=product.p_order_count+1,product.p_stock=product.p_stock-#{oi_qty} where p_no=#{p_no}")
	public int update(Product product) throws Exception;
=======*/
	@Update("update product set product.p_order_count=product.p_order_count+#{qty},product.p_stock=product.p_stock-#{qty} where p_no=#{p_no}")
	public int update(@Param("product")Product product,@Param("qty")int qty, @Param("p_no") int p_no) throws Exception;

		
	@Delete("delete from product where p_no=#{p_no}")
	public int delete(int p_no) throws Exception;
	
	@Select("select * from product where p_no=#{p_no}")
	public Product findByNo(int p_no) throws Exception;
	
	@Select("select * from product where p_category_no >= #{p_category_no1} and p_category_no <= #{p_category_no2} and p_no = #{p_no}")
	public Product findProductByCategory( @Param("p_category_no1")int p_category_no1, @Param("p_category_no2")int p_category_no2 ,@Param("p_no")int p_no);
	
	@Select("select * from product where p_name=#{p_name} and p_size=#{p_size}")
	public int findProductNoByNameSize(@Param("p_name") String p_name, @Param("p_size") String p_size);
	
	@Select("select * from product where p_name=#{p_name}")
	public int findProductName(@Param("p_name") String p_name);
	
	@Select("select * from product")
	public List<Product> findAll() throws Exception;
	
	/*
	 * // 베스트
	 * 
	 * @ResultMap("productResultMap")
	 * 
	 * @Select("select * from product p \r\n" + "    join \r\n" +
	 * "        (select p.p_category_no ,c.p_parent_category_no, c.p_category_name,  max(p.p_order_count) as mc \r\n"
	 * + "        from product p \r\n" + "        join category c \r\n" +
	 * "        on p.p_category_no=c.p_category_no \r\n" +
	 * "        group by p.p_category_no,c.p_parent_category_no,c.p_category_name) pc\r\n"
	 * + "    on p.p_category_no=pc.p_category_no\r\n" +
	 * "where p.p_order_count=pc.mc") public List<Product> findBest() throws
	 * Exception;
	 */
	// 베스트 상품 10위
		@ResultMap("productResultMap")
		@Select("select p.p_no,p.p_name,p.p_size,p.p_price,p.p_image from product p join (\r\n"
				+ "select rownum,p_name,s from\r\n"
				+ "(select p_name,sum(p_order_count) as s from product group by p_name order by sum(p_order_count) desc)\r\n"
				+ "where rownum<13) ps \r\n"
				+ "on p.p_name = ps.p_name\r\n"
				+ "where p.p_size='S' or p.p_size is null")
		public List<Product> findBestList();
		// @Select("select rownum,p_name from (select p_name,sum(p_order_count) from product group by p_name order by sum(p_order_count) desc) where rownum<11")
		// select rownum,p_name,p_no,p_image,p_price from (select p_no,p_name,sum(p_order_count),p_image,p_price from product  group by p_no,p_name,p_image,p_price order by sum(p_order_count) desc) where rownum<13
	// 큰 카레고리별 보기
	@ResultMap("productResultMap")
	@Select("select   \r\n"
			+ "    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,\r\n"
			+ "    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name \r\n"
			+ "    from product p \r\n"
			+ "    join category c1   \r\n"
			+ "    on p.p_category_no=c1.p_category_no\r\n"
			+ "    join category c2 \r\n"
			+ "    on c2.p_category_no=c1.p_parent_category_no\r\n"
			+ "    where c2.p_parent_category_no=#{p_parent_category_no}")
	public List<Product> findByParentCategory(int p_parent_category_no);
	
	// 큰 카테고리 가격 높은순
	@ResultMap("productResultMap")
	@Select("select   \r\n"
			+ "    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,\r\n"
			+ "    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name \r\n"
			+ "    from product p \r\n"
			+ "    join category c1   \r\n"
			+ "    on p.p_category_no=c1.p_category_no\r\n"
			+ "    join category c2 \r\n"
			+ "    on c2.p_category_no=c1.p_parent_category_no\r\n"
			+ "    where c2.p_parent_category_no=#{p_parent_category_no}\r\n"
			+ "    order by p.p_price desc    ")
	public List<Product> findHighByParentCategory(int p_parent_cateogry_no);
	
	// 큰 카테고리 가격 낮은순
	@ResultMap("productResultMap")
	@Select("select   \r\n"
			+ "    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,\r\n"
			+ "    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name \r\n"
			+ "    from product p \r\n"
			+ "    join category c1   \r\n"
			+ "    on p.p_category_no=c1.p_category_no\r\n"
			+ "    join category c2 \r\n"
			+ "    on c2.p_category_no=c1.p_parent_category_no\r\n"
			+ "    where c2.p_parent_category_no=#{p_parent_category_no}\r\n"
			+ "    order by p.p_price")
	public List<Product> findLowByParentCategory(int p_parent_category_no);
	
	// 큰 카테고리 인기 순
	@ResultMap("productResultMap")
	@Select("select   \r\n"
			+ "    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,\r\n"
			+ "    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name \r\n"
			+ "    from product p \r\n"
			+ "    join category c1   \r\n"
			+ "    on p.p_category_no=c1.p_category_no\r\n"
			+ "    join category c2 \r\n"
			+ "    on c2.p_category_no=c1.p_parent_category_no\r\n"
			+ "    where c2.p_parent_category_no=#{p_parent_category_no}\r\n"
			+ "    order by p.p_order_count desc")
	public List<Product> findBestByParentCategory(int p_parent_category_no);
	
	
	
	// 소 카테고리별 보기
	@ResultMap("productResultMap")
	@Select("  select p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,\r\n"
			+ "    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name \r\n"
			+ "    from product p \r\n"
			+ "    join category c1 \r\n"
			+ "    on p.p_category_no=c1.p_category_no\r\n"
			+ "    join category c2 \r\n"
			+ "    on c2.p_category_no=c1.p_parent_category_no\r\n"
			+ "    where c2.p_category_no=#{p_category_no}")
	public List<Product> findByCategory(int p_category_no);
	
	// 소 카테고리 높은 가격
		@ResultMap("productResultMap")
		@Select("  select   \r\n"
				+ "    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,\r\n"
				+ "    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name \r\n"
				+ "    from product p \r\n"
				+ "    join category c1   \r\n"
				+ "    on p.p_category_no=c1.p_category_no\r\n"
				+ "    join category c2 \r\n"
				+ "    on c2.p_category_no=c1.p_parent_category_no\r\n"
				+ "    where c2.p_category_no=#{p_category_no}\r\n"
				+ "    order by p.p_price desc")
	public List<Product> findHighByCategory(int p_category_no);

		// 소 카테고리 낮은 가격
				@ResultMap("productResultMap")
				@Select("select   \r\n"
						+ "    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,\r\n"
						+ "    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name \r\n"
						+ "    from product p \r\n"
						+ "    join category c1   \r\n"
						+ "    on p.p_category_no=c1.p_category_no\r\n"
						+ "    join category c2 \r\n"
						+ "    on c2.p_category_no=c1.p_parent_category_no\r\n"
						+ "    where c2.p_category_no=#{p_category_no}\r\n"
						+ "    order by p.p_price")
		public List<Product> findLowByCategory(int p_category_no);
	
				// 소 카테고리 인기
				@ResultMap("productResultMap")
				@Select("select   \r\n"
						+ "    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,\r\n"
						+ "    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name \r\n"
						+ "    from product p \r\n"
						+ "    join category c1   \r\n"
						+ "    on p.p_category_no=c1.p_category_no\r\n"
						+ "    join category c2 \r\n"
						+ "    on c2.p_category_no=c1.p_parent_category_no\r\n"
						+ "    where c2.p_category_no=#{p_category_no}\r\n"
						+ "    order by p.p_order_count desc")
		public List<Product> findBestByCategory(int p_category_no);				
	
				// 소 카테고리별 보기
				@ResultMap("productResultMap")
				@Select("  select distinct   \r\n"
						+ "    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,\r\n"
						+ "    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name \r\n"
						+ "    from product p \r\n"
						+ "    join category c1   \r\n"
						+ "    on p.p_category_no=c1.p_category_no\r\n"
						+ "    join category c2 \r\n"
						+ "    on c2.p_category_no=c1.p_parent_category_no\r\n"
						+ "    where c2.p_category_no=#{p_category_no}\r\n"
						+ "    and p.p_size='S'")
				public List<Product> findByCategorySize(int p_category_no);
				
				
	
}
