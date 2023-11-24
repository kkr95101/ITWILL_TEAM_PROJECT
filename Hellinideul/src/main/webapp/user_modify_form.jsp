
<%@page import="myProtein.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>  
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("shop_main.jsp");
		return;
	}
	UserService userService=new UserService();
	User user=userService.findById(sUserId);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>내정보 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
 
<script type="text/javascript">
	function userModifyAction() {

			let pw = document.getElementById('pw').value;
			let pw2 = document.getElementById('pw2').value;
		
			let num = pw.search(/[0-9]/g);
			let eng = pw.search(/[a-z]/ig);
			let spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
			
			if (pw == "") {
				alert("비밀번호를 입력하십시요.");
				document.f.password.focus();
				return false;
			}else if(pw.length < 8 || pw.length > 20){
				alert("비밀번호는 8 ~ 20자 미만으로 작성해주세요!");
				document.f.password.focus();
				return false;
			}else if(num < 0 || eng < 0 || spe < 0 ){
				  alert("영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
				  return false;
			}
			
			
			
			if (pw2 == "") {
				alert("비밀번호확인을 입력하십시요.");
				f.password2.focus();
				return false;
			}
			
		
		
		if (document.f.name.value == "") {
			alert("이름을 입력하십시요.");
			f.name.focus();
			return false;
		}
		if (document.f.phone.value == "") {
			alert("핸드폰번호를 입력하십시요.");
			f.phone.focus();
			return false;
		}
		if (document.f.email.value == "") {
			alert("이메일 주소를 입력하십시요.");
			f.email.focus();
			return false;
		}
		if (document.f.address.value == "") {
			alert("주소를 입력하십시요.");
			f.address.focus();
			return false;
		}
		
		if(pw==pw2){
			document.getElementById('check').innerHTML="비밀번호가 일치합니다.";
			document.getElementById('check').style.color='blue';
			
		}else{
			document.getElementById('check').innerHTML="비밀번호가 일치하지 않습니다.";
			document.getElementById('check').style.color='red';
			return false;
			
		}
		
		
		document.f.action = "user_modify_action.jsp";
		document.f.method='POST';
		document.f.submit();
		alert("회원정보 수정 성공!");
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
			<jsp:include page="include_common_top.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
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
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>내정보 관리
											- 내정보수정</b></td>
								</tr>
							</table> <!-- update Form  -->
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><%=user.getU_id()%></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="password" style="width: 150px"
											name="password" id="pw"  value="<%=user.getU_pw()%>"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호
											확인</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="password" style="width: 150px"
											name="password2" id="pw2" value="<%=user.getU_pw()%>">&nbsp;<span id="check"></span></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="name" value="<%=user.getU_name()%>"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">핸드폰
											번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="phone" value="<%=user.getU_phone()%>"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이메일
											주소</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="email" value="<%=user.getU_email()%>"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											주소</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="address" value="<%=user.getU_address()%>"></td>
									</tr>
								</table>
							</form> <br>

							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center><input type="button" value="내정보수정"
										onClick="userModifyAction();"> &nbsp;</td>
								</tr>
							</table>

						</td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>
