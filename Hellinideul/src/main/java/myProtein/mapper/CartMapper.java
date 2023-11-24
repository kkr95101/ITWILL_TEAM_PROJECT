package myProtein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import myProtein.cart.Cart;

public interface CartMapper {
	@Insert("insert into cart values(cart_c_no_seq.nextval,#{c_qty},#{p_no},#{u_id})")
	public int insert(@Param("u_id") String u_id,@Param("p_no") int p_no,@Param("c_qty") int c_qty);
	
	@Delete("delete from cart where u_id=#{u_id}")
	public int deleteByU_Id(String u_id);
	
	@Delete("delete from cart where c_no=#{c_no}")
	public int deleteByC_No(int c_no);
	
	@Update("update cart set c_qty=#{c_qty} where c_no=#{c_no}")
	public int updateByC_No(@Param("c_qty") int c_qty, @Param("c_no") int c_no);
	
	@Update("update cart set c_qty=c_qty+#{c_qty} where u_id=#{u_id} and p_no=#{p_no}")
	public int updateByU_Id(@Param("u_id") String u_id,@Param("p_no")int p_no,@Param("c_qty")int c_qty);
	
	@Select("select count(*) as p_count from cart where u_id=#{u_id} and p_no=#{p_no}")
	public int cartRowCount(@Param("u_id") String u_id, @Param("p_no") Integer p_no);

	@ResultMap("findCartListByU_Id_ResultMap")
	@Select("select * from cart c join product p on c.p_no = p.p_no where c.u_id = #{u_id} order by c.c_no desc")
	public List<Cart> findCartListByU_Id(@Param("u_id") String u_id);
	
	@ResultMap("findCartListByU_Id_ResultMap")
	@Select("select * from cart c join product p on c.p_no=p.p_no where c_no=#{c_no}")
	public Cart findByCartNo(@Param("c_no") int c_no);
	
}
