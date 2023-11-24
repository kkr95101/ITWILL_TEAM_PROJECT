
<%@page import="myProtein.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>     
<%
	if(request.getMethod().equals("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	try{
		request.setCharacterEncoding("UTF-8");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String phone = request.getParameter("phone");
		String email=request.getParameter("email");
		String address = request.getParameter("address");
		User user = new User(sUserId,password, name, phone, email, address);
		UserService userService=new UserService();
		int updateRowCount=userService.update(user);
		
		response.sendRedirect("user_view.jsp");
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
	
%>






