package myProtein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import myProtein.order.Order;
import myProtein.order.OrderItem;

public interface OrderMapper {
	
	/*
	 * 주문생성
	 */
	@Insert("insert into orders(o_no,o_desc,o_date,o_price,u_id) values (#{o_no},#{o_desc},sysdate,#{o_price},#{u_id})")
	@SelectKey(before = true,keyProperty ="o_no",statement = "select orders_o_no_SEQ.nextval from dual",resultType = Integer.class)
	public int insert(Order order);
	/*
	 * 생성된 주문에 오더아이템 생성
	 */
	@Insert("insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,#{oi_qty},#{o_no},#{product.p_no})")
	int insertOrderItem(OrderItem orderItem);
	/*
	 * 주문전체삭제(ON DELETE CASCADE)
	 */
	@Delete("delete from orders where u_id=#{u_id}")
	public int deleteByUserId(String u_id);
	/*
	 * 주문1건삭제(ON DELETE CASCADE)
	 */
	@Delete("delete from orders where o_no=#{o_no}")
	public int deleteByOrderNo(int o_no);
	/*
	 * 주문전체(특정사용자)
	 */
	@Select("select * from orders where u_id=#{u_id} order by o_no")
	List<Order> findOrderByUserId(String u_id);
	/*
	 * 주문+주문아이템 전체(특정사용자)
	 */
	@ResultMap("orderResultMap")
	@Select("select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where o.u_id = #{u_id} order by o.o_no desc")
	List<Order> findOrderWithOrderItemByUserId(String u_id);
	/*
	 * 주문1개보기(주문상세리스트)
	 */
	@ResultMap("orderResultMap")
	@Select("select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where o.o_no = #{o_no}")
	Order findByOrderNo(int o_no);
}
