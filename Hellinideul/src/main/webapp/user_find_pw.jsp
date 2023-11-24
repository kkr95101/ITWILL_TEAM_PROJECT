
<%@page import="myProtein.user.User"%>
<%@page import="myProtein.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
	String userId = request.getParameter("userId");
System.out.println(userId);
	UserService userService = new UserService();
	User user=userService.findById(userId);
	String password = user.getU_pw();
	
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인</title>

<style type="text/css">
#wrap {
	width: 250px;
	text-align: center;
	margin: 0 auto 0 auto;
}

#chk {
	text-align: center;
}

#cancelBtn {
	visibility: visible;
}

#useBtn {
	visibility: visible;
}
</style>

<script type="text/javascript">
	
function goMainPage() {
	f.action = "shop_main.jsp";
	f.submit();
}

function goLoginPage(){
	f.action = "user_login_form.jsp";
	f.submit();
}
	
</script>

</head>
<body>
	<div id="wrap">
		<br> <b><font size="3" color="gray">비밀번호 확인</font></b>
		<hr size="0.5" style="margin: 0 0 0 0"  >
		<div id="chk" style="margin-top: 10px">
			<%=password %>
		</div>
		<div style="margin-top: 30px">
		<a href='shop_main.jsp'>메인</a>
		<a href='user_login_form.jsp'>로그인</a>
		</div>
		
	</div>
</body>
</html>