
<%@page import="myProtein.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean isDuplicate=false;	
	String msg="";
	//request.setCharacterEncoding("UTF-8");
	String u_id = request.getParameter("userId");
	if(u_id==null|| u_id.equals("")){
		//최초윈도우를 띄울때
		u_id="";
		msg="";
		isDuplicate=true;
	}else{
		UserService userService=new UserService();
		
		isDuplicate=userService.isDuplicateId(u_id); 
		if(isDuplicate){
			msg="사용 불가능한 아이디입니다.";
		}else{
			msg="사용 가능한 아이디 입니다";
		}
	}
	
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 체크</title>

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
	// 아이디 중복체크
	function idCheck() {
		var userId=document.getElementById("userId").value;
		if(userId==null|| userId==''){
			alert('검색할아이디를 입력하시고 중복체크를 하세요.');
			return;
		}
		document.getElementById('checkForm').action='user_id_check_form.jsp';
		document.getElementById('checkForm').method='POST';
		document.getElementById('checkForm').submit();
		
	}

	// 사용하기 클릭 시 부모창으로 값 전달 
	function sendCheckValue() {
		// 중복체크 결과인 idCheck 값을 전달한다.
		// 회원가입 화면의 ID입력란에 값을 전달
		opener.document.f.userId.value = window.document.getElementById('userId').value;
		window.close();
	}
</script>

</head>
<body>
	<div id="wrap">
		<br> <b><font size="3" color="gray">아이디 중복체크</font></b>
		<hr size="0.5" style="margin: 0 0 0 0"  >
		<div id="chk" style="margin-top: 10px">
			<form id="checkForm" style="display: inline;">
				<input type="text" name="userId" id="userId" value="<%=u_id%>"> <input
					type="button" value="중복확인" onclick="idCheck()" style="font-size: 7pt">
			</form>
			<%if(!isDuplicate){ %>
				<div id="msg" style="font-size: 7pt;margin:7px;text-align: left;color: blue;font-weight: bold"><%=msg %></div>
				<input id="useBtn" type="button" value="사용"  style="font-size: 7pt" onclick="sendCheckValue()">
			<%}else{ %>
				<div id="msg" style="font-size: 7pt;margin:7px;text-align: left;color:red;font-weight: bold"><%=msg %></div>
				<input id="useBtn"  type="button" disabled="disabled" value="사용"  style="font-size: 7pt;" onclick="sendCheckValue()" >
			<%} %>
				<input id="cancelBtn" type="button" value="취소"  style="font-size: 7pt" onclick="window.close();"> 
		</div>
	</div>
</body>
</html>