<%@page import="java.text.DecimalFormat"%>
<%@page import="myProtein.product.Product"%>
<%@page import="java.util.List"%>
<%@page import="myProtein.product.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
ProductService productService = new ProductService();

List<Product> proteinList = productService.findByParentCategory(1000); //단백질 보충제
List<Product> protein1List = productService.findByCategory(1100); // 웨이프로틴
List<Product> protein2List = productService.findByCategory(1200); //아이솔레이트
List<Product> protein3List = productService.findByCategory(1300); // 식물성 단백질
List<Product> protein4List = productService.findByCategory(1400); // 복합 단백질

List<Product> clothesList = productService.findByParentCategory(2000); //스포츠웨어
List<Product> topList = productService.findByCategory(2100);// 상의
List<Product> lowList = productService.findByCategory(2200);// 하의
List<Product> acList = productService.findByCategory(2300);// 악세사리

List<Product> vitaminList = productService.findByParentCategory(3000); // 비타민
List<Product> vitamin1List = productService.findByCategory(3100); // 스포츠 퍼포먼스
List<Product> vitamin2List = productService.findByCategory(3200); //뼈%관절 건강
List<Product> vitamin3List = productService.findByCategory(3300); // 체중감량
List<Product> vitamin4List = productService.findByCategory(3400); // 오메가3

//List<Product> bestList = productService.findBestList();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MYPROTEIN</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">

<style type="text/css" media="screen">
</style>
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
		
			
			<!-- --------------------------- -->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>쇼핑몰 -
											<%-- <%=productList.get(0).getCategory2().getP_category_name()%> --%> 리스트</b></td>
								</tr>
							</table>

							<div id="f">
								<br />
								<table id="product_table" width="100%" align="center" border="0"
									cellpadding="10" cellspacing="1" bgcolor="FFFFFF">
									<%
									int product_size = protein1List.size();
									int product_column_size = 4;
									int product_line_count = 1;

									for (int i = 0; i < protein1List.size(); i++) {
										Product product = protein1List.get(i);
									%>
									<!--상품시작 -->
									<%
									if (i % product_column_size == 0) {
									%>
									<tr>
										<%
										}
										%>
										<td align="center" width="25%" bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=<%=product.getP_no()%>"><img
												width="88px" height="65px" src="<%=product.getP_image()%>"
												border="0"></a><br /> <br /> <b><%=product.getP_name()%></b>
											<form style="display: inline;">
												<%-- <input type="hidden" name="p_no"
													value="<%=product.getP_no()%>"> <input
													type="hidden" name="cart_qty" value="1"> <img
													src='image/cart20.png' style="cursor: pointer;"
													onclick="add_cart_popup_window(this.parentElement);"
													align="top" /> --%>
											</form> <br> <font color="#FF0000">가격:<%= new DecimalFormat("#,##0").format(product.getP_price())%>원
										</font></td>
										<%
										if (i % product_column_size == 3) {
										%>
									</tr>
									<%
									}
									%>

									<!--상품 끝 -->
									<%}%>
								</table>
					</div>
					<br />
					</td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
			
			
			<!-- --------------------------- -->
			
			
			
			
			
			
			
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