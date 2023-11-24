<%@page import="myProtein.user.exception.PasswordMismatchException"%>
<%@page import="myProtein.user.exception.UserNotFoundException"%>
<%@page import="myProtein.user.UserService"%>
<%@page import="myProtein.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>


<%


if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("user_login_form.jsp");
	return;
}
String userId = null;
String password = null;
try {
	userId = request.getParameter("userId");
	password = request.getParameter("password");
	UserService userService = new UserService();

	User loginUser = userService.login(userId, password);
	session.setAttribute("sUserId", userId);
	session.setAttribute("sUser", loginUser);
	response.sendRedirect("shop_main.jsp");
	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공(세션)
	 */
} catch (UserNotFoundException e) {
	request.setAttribute("msg1", e.getMessage());
	request.setAttribute("fuser", new User(userId, password, "", "", "", ""));
	RequestDispatcher rd = request.getRequestDispatcher("user_login_form.jsp");
	rd.forward(request, response);
} catch (PasswordMismatchException e) {
	request.setAttribute("msg2", e.getMessage());
	request.setAttribute("fuser", new User(userId, password, "", "", "", ""));
	RequestDispatcher rd = request.getRequestDispatcher("user_login_form.jsp");
	rd.forward(request, response);
} catch (Exception e) {
	e.printStackTrace();

	RequestDispatcher rd = request.getRequestDispatcher("user_error.jsp");
	rd.forward(request, response);

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>