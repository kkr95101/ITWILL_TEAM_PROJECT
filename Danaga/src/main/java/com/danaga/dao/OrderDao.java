package com.danaga.dao;

import java.util.List;

import org.aspectj.weaver.ast.Or;

import com.danaga.entity.Orders;

import jakarta.persistence.criteria.Order;

public interface OrderDao {

	// 주문 save
	Orders save(Orders orders) throws Exception;

	// 주문상태업데이트(특정주문)
	// 1.정상주문
	Orders updateStatementByNormalOrder(Long orderNo) throws Exception;

	// 2.취소주문
	Orders updateStatementByCancleOrder(Long orderNo) throws Exception;

	// 3.환불주문(client)
	Orders updateStatementByClientRefundOrder(Long orderNo) throws Exception;

	// 4.환불주문(admin)
	Orders updateStatementByAdminRefundOrder(Long orderNo) throws Exception;

	// 5.상태리셋
	Orders updateStatementByResetOrder(Long orderNo) throws Exception;

	// 주문전체(id로 찾기)
	List<Orders> findOrdersByMember_UserName(String userName) throws Exception;

	// 주문전체(email로 찾기)
	List<Orders> findOrdersByMember_Email(String email) throws Exception;
	
	// 주문1개보기(주문상세리스트)
	Orders findById(Long id) throws Exception;

	// 비회원 주문1개보기(주문상세리스트)
	Orders findOrdersByIdAndPhoneNo(Long orderNo, String phoneNo) throws Exception;

	//회원 탈퇴시 id로 찾기
	List<Orders> memberOrdersListNull(String userName) throws Exception;

	//회원 탈퇴시 order에 memeberId를 null로 만들기
	void ordersMemberIdNull(String userName) throws Exception;

}
