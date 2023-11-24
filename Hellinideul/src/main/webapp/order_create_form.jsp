<%@page import="myProtein.order.Order"%>
<%@page import="myProtein.order.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="myProtein.product.Product"%>
<%@page import="myProtein.product.ProductService"%>
<%@page import="myProtein.user.UserService"%>
<%@page import="myProtein.cart.CartService"%>
<%@page import="myProtein.cart.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf"%>
<%
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("product_list.jsp");
	return;
}
String buyType = request.getParameter("buyType");
if (buyType == null){
	response.sendRedirect("product_list.jsp");
	return;
}

CartService cartService = new CartService();
UserService userService = new UserService();
ProductService productService = new ProductService();

int tot_price = 0;
int oi_tot_count = 0;
String[] cart_item_noStr_array = new String[]{};

Order order = new Order();
if (buyType.equals("cart")) {
	/*
	카트테이블에있는 모든제품을 주문하기
	*/
	List<Cart> cartItemList = new ArrayList<Cart>();
	cartItemList = cartService.findAll(sUserId);
	for (Cart cart : cartItemList) {
		order.getOrderItemList().add(new OrderItem(0, cart.getC_qty(), 0, cart.getProduct()));
		tot_price += cart.getC_qty() * cart.getProduct().getP_price();
		oi_tot_count += cart.getC_qty();
		
		order.getOrderItemList().get(1).getOi_qty();
		order.getOrderItemList().get(1).getProduct();
	}
} else if (buyType.equals("cart_select")) {
	/*
	카트보기에서 선택된 제품을 주문하기
	*/
	cart_item_noStr_array = request.getParameterValues("cart_item_no");
	if(cart_item_noStr_array==null){
		response.sendRedirect("product_list.jsp");
		return;
	}

	for (String cart_item_noStr : cart_item_noStr_array) {
		Cart cart = cartService.findCartItemByCartNo(Integer.parseInt(cart_item_noStr));
		order.getOrderItemList().add(new OrderItem(0, cart.getC_qty(), 0, cart.getProduct()));
		tot_price += cart.getC_qty() * cart.getProduct().getP_price();
		oi_tot_count += cart.getC_qty();
	}

} else if (buyType.equals("direct")) {
	/*
	상품에서에서 직접제품을 주문하기
	*/
	String p_noStr = request.getParameter("p_no");
	String p_qtyStr = request.getParameter("p_qty");
	System.out.println(p_noStr);
	System.out.println(p_qtyStr);
	if (p_noStr == null || p_qtyStr == null){
		response.sendRedirect("product_list.jsp");
		return;
	}
	
	Product product = productService.findByNo(Integer.parseInt(p_noStr));
	order.getOrderItemList().add(new OrderItem(0, Integer.parseInt(p_qtyStr), 0, product));
	tot_price = order.getOrderItemList().get(0).getOi_qty() * order.getOrderItemList().get(0).getProduct().getP_price();
	oi_tot_count += order.getOrderItemList().get(0).getOi_qty();

}
String o_desc = order.getOrderItemList().get(0).getProduct().getP_name() + "외 " + (oi_tot_count - 1) + " 개";
if(oi_tot_count == 1) {
	o_desc = order.getOrderItemList().get(0).getProduct().getP_name();
}


order.setU_id(sUserId);
order.setO_price(tot_price);
order.setO_desc(o_desc);
/**********************세션에 주문데이타담기***************************/
session.setAttribute("order", order);
session.setAttribute("cart_item_noStr_array", cart_item_noStr_array);
/*********************************************************************/
User loginUser=userService.findById(sUserId);

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
	/*
	 * 주문
	 */
	function order_create_form_submit() {
		document.order_create_form.method = 'POST';
		document.order_create_form.action = 'order_create_action.jsp';
		document.order_create_form.submit();
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<form name="order_create_form" method="post">
		<input type="hidden" name="buyType" value="<%=buyType%>">
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>
											주문/결제</b></td>
								</tr>
							</table> <!--form-->
							<form>
								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;">구매자정보</caption>
									<tr>
										<td width=290 height=25 align=center bgcolor="E6ECDE" class=t1>아이디</td>
										<td width=112 height=25 align=center bgcolor="E6ECDE" class=t1>이름</td>
										<td width=166 height=25 align=center bgcolor="E6ECDE" class=t1>이메일</td>
										<td width=50 height=25 align=center bgcolor="E6ECDE" class=t1>비
											고</td>
									</tr>
									<tr>
										<td width=290 height=26 align=center bgcolor="ffffff" class=t1><%=loginUser.getU_id()%></td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=loginUser.getU_name()%></td>
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1><%=loginUser.getU_email()%></td>
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1></td>
									</tr>
								</table>

								<br />

								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;">주문제품목록</caption>
									<tr style="border: 0.1px solid">
										<td width=290 height=25 bgcolor="E6ECDE" align=center class=t1>상품
											이름</td>
										<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1>수
											량</td>
										<td width=166 height=25 bgcolor="E6ECDE" align=center class=t1>가
											격</td>
										<td width=50 height=25 bgcolor="E6ECDE" align=center class=t1>비
											고</td>
									</tr>
									<%
									for (OrderItem orderItem : order.getOrderItemList()) {
									%>
									<!-- cart item start -->
									<tr>
										<td width=290 height=26 align=center bgcolor="ffffff" class=t1>
											<a
											href='product_detail.jsp?p_no=<%=orderItem.getProduct().getP_no()%>'><%=orderItem.getProduct().getP_name()%></a>
										</td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=orderItem.getOi_qty()%></td>
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1>
											<%=new DecimalFormat("#,###").format(orderItem.getOi_qty() * orderItem.getProduct().getP_price())%>
										</td>
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1></td>
									</tr>
									<!-- cart item end -->
									<%
									}
									%>
									<tr>
										<td width=640 colspan=4 height=26 bgcolor="ffffff" class=t1>
											<p align=right style="padding-top: 10px">
												<font color=#FF0000>총 주문 금액 : <%=new DecimalFormat("#,###").format(order.getO_price())%>
													원
												</font>
											</p>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp; <a
										href="javascript:order_create_form_submit();" class=m1>구매/결재하기</a>
										&nbsp;&nbsp;<a href=product_list.jsp class=m1>계속 쇼핑하기</a>

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