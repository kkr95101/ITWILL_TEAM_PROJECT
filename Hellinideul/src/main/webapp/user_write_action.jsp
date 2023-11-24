<%@page import="myProtein.user.exception.ExistedUserException"%>
<%@page import="myProtein.user.UserService"%>
<%@page import="myProtein.user.User"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_write_form.jsp");
		return;
	}
	
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
	User newUser=null;
	try{
		newUser=new User(userId,password,name,phone, email, address);
		UserService userService=new UserService();
		int rowCount = userService.create(newUser);
		response.sendRedirect("user_login_form.jsp");
	}catch(ExistedUserException e){
		/*************************case1[redirect]**************
    	response.sendRedirect("user_write_form.jsp?msg="+URLEncoder.encode(e.getMessage(),"UTF-8"));
    	****************************************************/
    	/*************case2[forward]**************/
    	//이동할려는 page로 데이타를 전달해야할때
    	//<jsp:forward parth="user_write_form.jsp"/>
    	request.setAttribute("msg", e.getMessage());
    	request.setAttribute("fuser", newUser);
    	RequestDispatcher rd=request.getRequestDispatcher("user_write_form.jsp");
    	rd.forward(request, response);
    	/******************************************/
		/*****************case3[정상응답]***************
		out.println("<script>");
		out.println("alert('"+e.getMessage()+"');");
		out.println("location.href='user_write_form.jsp';");
		out.println("</script>");
		********************************************/
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");		
	}
%>















