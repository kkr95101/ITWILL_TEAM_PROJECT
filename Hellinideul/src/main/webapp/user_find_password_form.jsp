<%@page import="myProtein.user.UserService"%>
<%@page import="myProtein.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

String msg1=(String)request.getAttribute("msg1");
if(msg1==null)msg1="";

User fuser=(User)request.getAttribute("fuser");
if(fuser==null){
	fuser=new User("","","","","","");
}


%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
 
<script type="text/javascript">
 
function pw_search(){
	
	
	if(document.f.userId.value==""){
		alert("아이디를 올바르게 입력해주세요");
		return;
	}
	
	if(document.f.name.value=""){
		alert("이름을 올바르게 입력해주세요");
		return;
	}
	
	if(document.f.phone.value=""){
		alert("핸드폰번호를 올바르게 입력해주세요");
		return;
	}
	
	f.action="user_find_pw.jsp";
	
	f.method='POST';
	f.submit();
	
	
}
	
	
	
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">

				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리
											- 비밀번호 찾기</b></td>
								</tr>
							</table> <!-- login Form  -->
							<form  name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											아이디</td>
										<td width=490 align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 150" name="userId"
											value="<%=fuser.getU_id()%>">&nbsp;&nbsp;</td>
									</tr>	
									<tr>
									<td width=100 align=center bgcolor="E6ECDE" height="22">
											이름</td>
										<td width=490 align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 150" name="name"
											value="<%=fuser.getU_name()%>">&nbsp;&nbsp;</td>
									</tr>	
										
									<tr>		
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											핸드폰번호</td>
										<td width=490 align="left" bgcolor="ffffff"
											style="padding-left: 10px"><input type="text"
											style="width: 150" name="phone"
											value="<%=fuser.getU_phone()%>">&nbsp;&nbsp;</td>			
											
									</tr>
									
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1">
								<tr>
									<td align=center><input type="button" value="비밀번호 찾기"
										onClick="pw_search();"> &nbsp; 
										
										</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>
