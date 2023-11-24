<%@page import="myProtein.order.OrderItem"%>
<%@page import="myProtein.order.Order"%>
<%@page import="myProtein.order.OrderService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>
<%
	String o_noStr=request.getParameter("o_no");
	if(o_noStr==null|| o_noStr.equals("")){
		response.sendRedirect("order_list.jsp");
		return;
	}
	OrderService orderService=new OrderService();
	Order order = orderService.orderWithOrderItem(Integer.parseInt(o_noStr));
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MYPROTEIN</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
 
<style type="text/css" media="screen">
/*
form > table tr td{
	border: 0.1px solid black;
}
*/
</style>
<script type="text/javascript">
	
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
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>
											주문상세조회</b></td>
								</tr>
							</table> <!--form-->
							<form name="f" method="post" action="order_delete_action.jsp">
								<input type="hidden" name="o_no" value="<%=order.getO_no()%>">
								<table align="center" width="80%"  border="0" cellpadding="0" cellspacing="1"  bgcolor="BBBBBB" >
									<caption style="text-align: left;">주문상세정보</caption>
									<tr>
										<td width=290 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>주문번호</font></td>
										<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>주문일</font></td>
										<td width=166 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>주문자</font></td>
										<td width=50 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>비 고</font></td>
									</tr>
									
									
									<tr>
										<td width=290 height=26 align=center bgcolor="ffffff" class=t1><%=order.getO_no()%></td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=new SimpleDateFormat("yyyy/MM/dd").format(order.getO_date())%></td>
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1><%=order.getU_id()%></td>
										
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1>
												<input type="submit" value="삭제">
										</td>
									</tr>
								</table>
									
								<br/>	
								<table align=center  width=80% border="0" cellpadding="0" cellspacing="1"  bgcolor="BBBBBB" >
									<caption style="text-align: left;">주문제품목록</caption>
									<tr style="border: 0.1px solid">
										<td width=290 height=25 align=center bgcolor="E6ECDE" class=t1>상품 이름</td>
										<td width=112 height=25 align=center bgcolor="E6ECDE" class=t1>수 량</td>
										<td width=166 height=25  align=center bgcolor="E6ECDE" class=t1>가 격</td>
										<td width=50 height=25  align=center bgcolor="E6ECDE" class=t1>비 고</td>
									</tr>
									
									<!-- orer item start -->
									<%
									int tot_price=0;
																for(OrderItem orderItem:order.getOrderItemList()) {
																tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
									%>
									<tr>
										<td width=290 height=26 align=center  bgcolor="ffffff" class=t1>
										<a href='product_detail.jsp?p_no=<%=orderItem.getProduct().getP_no()%>'>
										<%=orderItem.getProduct().getP_name()%></a>
										</td>
										
										<td width=112 height=26 align=center  bgcolor="ffffff" class=t1>
										<%=orderItem.getOi_qty()%>
										</td>
										
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1>
										<%=new DecimalFormat("#,###").format(orderItem.getOi_qty()*orderItem.getProduct().getP_price())%>
										</td>
										<td width=50 height=26 align=center class=t1 bgcolor="ffffff"></td>
									</tr>
									<%}%>
									<!-- cart item end -->
									<tr>
										<td width=640 colspan=4 height=26  bgcolor="ffffff" class=t1>
										
											<p align=right style="padding-top: 10px">
												<font color=#FF0000>총 주문 금액 : <%=new DecimalFormat("#,###").format(tot_price)%> 원
												</font>
											</p>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center> 
										&nbsp;&nbsp;<a href=order_list_orderitem2.jsp
										class=m1>주문목록</a>
										&nbsp;&nbsp;<a href=product_list.jsp
										class=m1>계속 쇼핑하기</a>

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
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>