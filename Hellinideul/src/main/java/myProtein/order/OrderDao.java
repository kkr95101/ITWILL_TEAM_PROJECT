package myProtein.order;

import java.util.List;

public interface OrderDao {
	/*
	 * 주문생성
	 */
	public int insert(Order order);
	/*
	 * 주문전체삭제(ON DELETE CASCADE)
	 */
	public int deleteByUserId(String u_id);
	/*
	 * 주문1건삭제(ON DELETE CASCADE)
	 */
	public int deleteByOrderNo(int o_no);
	/*
	 * 주문전체(특정사용자)
	 */
	public List<Order> findOrderByUserId(String u_id);
	/*
	 * 주문+주문아이템 전체(특정사용자)
	 */
	public List<Order> findOrderWithOrderItemByUserId(String u_id);
	/*
	 * 주문1개보기(주문상세리스트)
	 */
	public Order findByOrderNo(int o_no);
 }
