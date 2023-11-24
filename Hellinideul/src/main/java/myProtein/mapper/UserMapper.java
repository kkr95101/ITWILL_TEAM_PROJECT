package myProtein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import myProtein.user.User;

public interface UserMapper {
	@Select("select * from user_info where u_id = #{u_id}")
	public User findById(String u_id) throws Exception;
	
	@SelectKey(statement = "select u_id from dual", before = true, keyProperty = "u_id", resultType = String.class)
	
	@Select("select * from user_info")
	public List<User> findAll() throws Exception;
	
	@Insert("insert into user_info values(#{u_id},#{u_pw},#{u_name},#{u_phone},#{u_email},#{u_address} )")
	public int insert(User user) throws Exception;
	
	@Delete("delete from user_info where u_id=#{u_id}")
	public int delete(String u_id) throws Exception;
	
	@Update("update user_info set u_pw=#{u_pw}, u_name=#{u_name},u_phone=#{u_phone},u_email=#{u_email},u_address=#{u_address} where u_id=#{u_id}")
	public int update(User user) throws Exception;
	
	
	@Select("select count(*) from user_info where u_id=#{u_id}")
	int countByUserId(String userId) throws Exception;
	
}
