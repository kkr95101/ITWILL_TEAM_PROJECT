
<%@page import="java.util.List"%>
<%@page import="myProtein.product.Product"%>
<%@page import="myProtein.product.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String p_noStr = request.getParameter("p_no");
if (p_noStr == null || p_noStr.equals("")) {
	response.sendRedirect("product_list.jsp");
	return;
}
boolean isLogin = false;
if (session.getAttribute("sUserId") != null) {
	isLogin = true;
}

ProductService productService = new ProductService();
Product product = productService.findByNo(Integer.parseInt(p_noStr));
Product productByCategory = null;
System.out.println(product);
if(2000 <= product.getP_category_no() && product.getP_category_no() < 2300){
	productByCategory = productService.findProductByCategory(2100, 2300, Integer.parseInt(p_noStr));
	System.out.println(productByCategory);
	
}else if (product == null) {
	out.println("<script>");
	out.println("alert('매진된상품입니다.');");
	out.println("location.href='product_list.jsp';");
	out.println("</script>");
	return;
}
%>
<%
productService = new ProductService();

List<Product> proteinList = productService.findByParentCategory(1000); //단백질 보충제
List<Product> protein1List = productService.findByCategory(1100); // 웨이프로틴
List<Product> protein2List = productService.findByCategory(1200); //아이솔레이트
List<Product> protein3List = productService.findByCategory(1300); // 식물성 단백질
List<Product> protein4List = productService.findByCategory(1300); // 복합 단백질

List<Product> clothesList = productService.findByParentCategory(2000); //스포츠웨어
List<Product> topList = productService.findByCategory(2100);// 상의
List<Product> lowList = productService.findByCategory(2200);// 하의
List<Product> acList = productService.findByCategory(2300);// 악세사리

List<Product> vitaminList = productService.findByParentCategory(3000); // 비타민
List<Product> vitamin1List = productService.findByCategory(3100); // 스포츠 퍼포먼스
List<Product> vitamin2List = productService.findByCategory(3200); //뼈%관절 건강
List<Product> vitamin3List = productService.findByCategory(3300); // 체중감량
List<Product> vitamin4List = productService.findByCategory(3400); // 오메가3

List<Product> bestList = productService.findBestList();
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>쇼핑몰</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function add_cart(){
		if (<%=!isLogin%>) {
			alert('로그인 하세요');
			location.href = 'user_login_form.jsp';
			return false;
		}
		return true;
	}
	function updateQuantity() {
		  // 드롭다운 목록에서 선택한 값을 가져오기
		  var selectedQuantity = document.getElementById("cart_qty").value;
		  
		  // <input> 요소에 선택한 값 설정하기
		  document.getElementById("p_qty").value = selectedQuantity;
		}
	function add_cart_popup_window(){
		if (<%=!isLogin%>) {
			alert('로그인 하세요');
			location.href = 'user_login_form.jsp';
		} else {
			
			var left = Math.ceil(( window.screen.width)/5);
			var top = Math.ceil(( window.screen.height)/3); 
			console.log(left);
			console.log(top);
			var cartWin = window.open("about:blank","cartForm","width=260,height=130,top="+top+",left="+0+",location=no, directories=no, status=no, menubar=no, scrollbars=no,copyhistory=no");
			document.add_cart_form_size.action = 'cart_add_action_popup_window.jsp';
			document.add_cart_form_size.target = 'cartForm';
			document.add_cart_form_size.method = 'POST';
			document.add_cart_form_size.submit();
		}
	}
	/*
	제품상세보기에서주문
	*/
	function order_create_form() {
		if (<%=!isLogin%>) {
			alert('로그인 하세요');
			location.href = 'user_login_form.jsp';
		} else {
			document.product_detail_form.method = 'POST';
			document.product_detail_form.action = 'order_create_form.jsp';
			document.product_detail_form.submit();
		}
	}
	function productList() {
		location.href = 'product_list.jsp';
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<form name="product_detail_form">
		<input type="hidden" name="p_no" value="<%=product.getP_no()%>">
		<input type="hidden" name="p_qty" id="p_qty" value="1">
		<input type="hidden" name="buyType" value="direct">
	</form>
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
			<div id="content">
				<div id="menuTest">
					<ul class="menu">
						<li><a href="#">비타민</a>
						<ul class="submenu">
							<li><a href="product_list.jsp?p_category_no=<%=vitamin3List.get(1).getCategory2().getP_category_no()%>">체중 감량</a></li>
							<li><a href="product_list.jsp?p_category_no=<%=vitamin2List.get(1).getCategory2().getP_category_no()%>">뼈,관절 건강</a></li>
							<li><a href="product_list.jsp?p_category_no=<%=vitamin1List.get(1).getCategory2().getP_category_no()%>">스포츠 퍼포먼스</a></li>
							<li><a href="product_list.jsp?p_category_no=<%=vitamin4List.get(0).getCategory2().getP_category_no()%>">오메가3</a></li>
						</ul></li>
					<li><a href="#">스포츠 웨어</a>
						<ul class="submenu">
							<li><a href="product_list.jsp?p_category_no=<%=topList.get(1).getCategory2().getP_category_no()%>"><%=topList.get(1).getCategory1().getP_category_name()%></a></li>
							<li><a href="product_list.jsp?p_category_no=<%=lowList.get(1).getCategory2().getP_category_no()%>"><%=lowList.get(1).getCategory1().getP_category_name()%></a></li>
							<li><a href="product_list.jsp?p_category_no=<%=acList.get(1).getCategory2().getP_category_no()%>">악세사리</a></li>
						</ul></li>
					<li><a href="#">단백질 보충제</a>
						<ul class="submenu">
							<li><a href="product_list.jsp?p_category_no=<%=protein1List.get(1).getCategory2().getP_category_no()%>">웨이프로틴</a></li>
							<li><a href="product_list.jsp?p_category_no=<%=protein2List.get(1).getCategory2().getP_category_no()%>">아이솔레이트</a></li>
							<li><a href="product_list.jsp?p_category_no=<%=protein3List.get(1).getCategory2().getP_category_no()%>">식물성단백질</a></li>
							<li><a href="product_list.jsp?p_category_no=<%=protein4List.get(1).getCategory2().getP_category_no()%>">복합 단백질</a></li>
						</ul>
					</ul>
				</div>
			</div>
		
			
			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>마이프로틴 -
											상품상세보기</b></td>
								</tr>
							</table> <!-- 
							<form name="f" method="post">
							-->
							<table style="margin-left: 10px" border=0 width=80% height=376
								align=center>
								<tr valign=bottom>
									<td width=30% align=center class=t1><font size=2
										color=#0000FF><b>주문량</b></font></td>
									<td width=40% align=center class=t1><font size=2
										color=#0000FF><b>상품 이름</b></font></td>
									<td width=30% align=center class=t1><font size=2
										color=#0000FF><b>상품 소개</b></font></td>
								</tr>
								<tr width=100%>
									<td colspan=3 height=5><hr color=#556b2f></td>
								</tr>
								<tr width=100%>
									<td width=30% height=200 align=center class=t1>
									<form name="add_cart_form_size" method="post" onsubmit="return add_cart();" action="cart_add_action.jsp">
									<%if(productByCategory!=null) { %>
									
											사이즈 :
											<!-- 
											 <input type=text name="cart_qty" value=1 size=4 class=TXTFLD>  
											-->
											<select name="cart_product_size">
												<option value="S">S
												<option value="M">M
												<option value="L">L
											</select><br>
										
										<%} %>
									
											수량 :
											<!-- 
											 <input type=text name="cart_qty" value=1 size=4 class=TXTFLD>  
											-->
											<select id="cart_qty" name="cart_qty" onchange="updateQuantity()">
												<option value="1">1
												<option value="2">2
												<option value="3">3
												<option value="4">4
												<option value="5">5
												<option value="6">6
												<option value="7">7 
												<option value="8">8
												<option value="9">9
												<option value="10">10
											</select> 개<br><br> 
												<input width=40px height=40px type=image src='image/cart.png' value="장바구니담기[장바구니보여주기]" title="장바구니담기[장바구니보여주기]" style="font-size: 6pt;"/> 
												<a href="javascript:add_cart_popup_window(this.parentElement);" title="장바구니담기[계속쇼핑팝업]"><img src='image/cart25.png' style="margin-bottom: 5px "></a>
												<input type="hidden" name=p_no value="<%=product.getP_no()%>">
										</form>
										
									</td>
									<td width=40% height=200 align=center><img border=0
										src='<%=product.getP_image()%>' width=120 height=200></td>
									<td width=30% height=200 class=t1>
										<ol type="disc">
											<li><b>상품 : <%=product.getP_name()%>&nbsp;&nbsp;&nbsp;
											</b></li>
											<li><font color=#FF0000>가격 : <%=product.getP_price()%>&nbsp;&nbsp;&nbsp;
											</font></li>
											<li><font color=#FF0000>재고량 : <%=product.getP_stock()%>&nbsp;&nbsp;&nbsp;
											</font></li>
											<li><font color=#0000FF><%=product.getP_desc()%></font></li>
										</ol>
									</td>
								</tr>
								<tr>
									<td colSpan=3 height=21><hr color=#556b2f></td>
								</tr>
							</table> <!-- 
							</form>
							-->


							<table border="0" cellpadding="0" cellspacing="1">
								<tr>
									<td align=center><input type="button" value="주문하기[주문폼]"
										onClick="order_create_form();"> &nbsp; <input
										type="button" value="상품리스트" onClick="productList();"></td>
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