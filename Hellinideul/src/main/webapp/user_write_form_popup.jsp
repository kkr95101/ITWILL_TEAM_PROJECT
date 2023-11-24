<%@page import="myProtein.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User fuser=(User)request.getAttribute("fuser");
	if(fuser==null){
		fuser = new User("","","","","","");
	}
	String msg = request.getParameter("msg");
	if(msg==null){
		msg="";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
 
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function userCreate() {
		
		
		if (document.f.userId.value == "") {
			alert("사용자 아이디를 입력하십시요.");
			document.f.userId.focus();
			return false;
		}
		
		
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
		/*
		if (document.f.password.value != f.password2.value) {
			alert("비밀번호와 비밀번호확인은 일치하여야합니다.");
			f.password.focus();
			f.password.select();
			return false;
		}
		*/
		
		if(pw==pw2){
			document.getElementById('check').innerHTML="비밀번호가 일치합니다.";
			document.getElementById('check').style.color='blue';
			
		}else{
			document.getElementById('check').innerHTML="비밀번호가 일치하지 않습니다.";
			document.getElementById('check').style.color='red';
			return false;
		}
		
		
		
		document.f.action = "user_write_action.jsp";
		document.f.method='POST';
		document.f.submit();
		alert("회원가입 성공!");
	}

	function userList() {
		f.action = "user_list.jsp";
		f.submit();
	}
	/*
	아이디중복체크
	*/
	function openIdCheck(){
		var left = Math.ceil(( window.screen.width)/5);
		var top = Math.ceil(( window.screen.height)/5); 
		let idCheckWindow = window.open("user_id_check_form.jsp","checkForm","width=430,height=200,top="+top+",left="+left+",resizable = no,location=no, directories=no, status=no, menubar=no, scrollbars=no,copyhistory=no");
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
				<table width=0 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리
											- 회원 가입</b></td>
								</tr>
							</table> 
							<!-- write Form  -->
							<form name="f">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input onclick="openIdCheck();" type="text" style="width: 150px" name="userId" value="<%=fuser.getU_id() %>" readonly="readonly">&nbsp;&nbsp;
											<input type="button" value="아이디중복검사" onclick="openIdCheck();">
											<font color="red"><%=msg%></font>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="password" id="pw" style="width: 150px" name="password"
											value="<%=fuser.getU_pw()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호
											확인</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="password" id="pw2" style="width: 150px" name="password2"
											value="<%=fuser.getU_pw()%>" >&nbsp;<span id="check"></span>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="name"
											value="<%=fuser.getU_name()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">핸드폰번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="phone"
											value="<%=fuser.getU_phone()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이메일
											주소</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="email"
											value="<%=fuser.getU_email()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											주소</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="address"
											value="<%=fuser.getU_address()%>">
										</td>
									</tr>
								</table>
							</form> <br />

							<table border=0 cellpadding=0 cellspacing=1>
								<tr>
									<td align=center>
									<input type="button" value="회원 가입" onclick="userCreate();"> &nbsp; 
									</td>
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
