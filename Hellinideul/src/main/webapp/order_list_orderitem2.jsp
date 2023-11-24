
<%@page import="myProtein.product.Product"%>
<%@page import="myProtein.order.OrderItem"%>
<%@page import="myProtein.order.Order"%>
<%@page import="myProtein.order.OrderService"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf"%>
<%
OrderService orderService = new OrderService();
List<Order> orderList = orderService.orderWithOrderItemList(sUserId);
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
<script type="text/javascript">
	function order_delete_all_action(){
		document.order_delete_all_form.action='order_delete_all_action.jsp';
		document.order_delete_all_form.method='POST';
		document.order_delete_all_form.submit();
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
<form name="order_delete_all_form" style="margin: 0">
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

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>쇼핑몰 -
											주문 목록</b></td>
								</tr>
							</table> <!--form-->
							<form name="f" method="post">
								<table align=center width=80%  border="0" cellpadding="0"
									cellspacing="1">
									<!-- order start -->
									<%
									for (Order order : orderList) {
										List<OrderItem> ordeItemList=order.getOrderItemList();
										
									%>
									<tr>
										<td colspan="6" height=24 align=left bgcolor="E6ECDE" class=t1 >
											<span
											style="font-size: 10pt; font-style: bold;">&nbsp;2023/01/31</span>
											<span style="font-size: 8pt">주문번호 <%=order.getO_no()%></span> <a href='order_detail.jsp?o_no=<%=order.getO_no()%>' style="font-size: 6pt">상세보기</a>
										</td>
									</tr>
									<tr>
										<td colspan="6" height=4 align=left class=t1 >
										</td>
									</tr>
									<tr>
										<td width="5%"></td>
										<td width="95%" colspan="8" bgcolor="ffffff" class=t1>
											<!--  -->
											<table align="left" border="0" 
												cellspacing="1" bgcolor="EEEEEE">
												<tr >
													<%
													int orderItemSize = ordeItemList.size();
													int remainSize=8-orderItemSize;
													for(int j=0;j<orderItemSize;j++){
														OrderItem orderItem=ordeItemList.get(j);
														Product product=orderItem.getProduct();
													%>
													<!--상품시작 -->
													<td align="center" style="padding: 0px;width: 55px" bgcolor="ffffff"><a style="padding: 0px"
														href="product_detail.jsp?p_no=<%=product.getP_no()%>"><img width="50px"
															height="50px" src="<%=product.getP_image() %>" border="0" style="padding-top: 5px"></a> <br>
														<span style="font-size: 6pt"><b><%=product.getP_name()%></b> <br> <%=new DecimalFormat("#,###").format(orderItem.getOi_qty()*product.getP_price())%> <%=orderItem.getOi_qty()%>개</span>
													</td>
													<!--상품 끝 -->
													<%} %>
													<%
													for(int j=0;j<remainSize;j++){
													%>
													<!--상품시작 -->
													<td align="center" style="padding: 0px;width: 55px" bgcolor="ffffff">
													</td>
													<!--상품 끝 -->
													<%
													}	
													%>
													
													</tr>
											</table>
										</td>
									<tr>
										<td colspan="5" width=145 height=10 align=center
											bgcolor="ffffff" class=t1></td>
									</tr>
									<!-- order end -->
									<%
									}
									%>
									<!-- order end -->
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp;
									<a href=product_list.jsp
										class=m1>계속 구경하기</a>
									<a href='javascript:order_delete_all_action();'
										class=m1>주문전체삭제</a>
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