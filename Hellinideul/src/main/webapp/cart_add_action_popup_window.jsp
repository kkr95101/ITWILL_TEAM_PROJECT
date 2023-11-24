<%@page import="myProtein.product.Product"%>
<%@page import="myProtein.product.ProductService"%>
<%@page import="myProtein.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>
<%


	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("product_list.jsp");
		return;
	}
	/*
	1.파라메타받기(cart_qty,p_no)
	2.장바구니에 제품을담고 cart_view.jsp로redirection
	*/

	String cart_qtyStr=request.getParameter("cart_qty");
   	System.out.println(cart_qtyStr);
   	String p_noStr=request.getParameter("p_no");

   	CartService cartService=new CartService();  

   	System.out.println(p_noStr);
   	String p_size=request.getParameter("cart_product_size");
   	System.out.println(p_size);
   	ProductService productService = new ProductService();
   	Product product = productService.findByNo(Integer.parseInt(p_noStr));
   	String msg1 = "재고수량이 부족합니다.";
   	String msg2 = "품절된 상품입니다.";
   	String p_name = product.getP_name();
   	if(2000 <= product.getP_category_no() && product.getP_category_no() < 2300){ 
   	int p_no = productService.findProductNoByNameSize(p_name, p_size);
	product = productService.findByNo(p_no);
   	if(product.getP_stock()==0){
   		out.print("<script>alert('"+msg2+"');</script>");
   		out.print("<script>window.close();</script>");
   		return;
   	}else if(product.getP_stock()<Integer.parseInt(cart_qtyStr)){
   		out.print("<script>alert('"+msg1+"');</script>");
   		out.print("<script>window.close();</script>");
   		return;
   	}
  	System.out.println("p_no---------------------->"+p_no);
    cartService.addCart(sUserId,p_no,Integer.parseInt(cart_qtyStr));
    } else{
    int p_no1=productService.findProductName(p_name);
    product = productService.findByNo(p_no1);
    if(product.getP_stock()==0){
   		out.print("<script>alert('"+msg2+"');</script>");
   		out.print("<script>window.close();</script>");
   		return;
   	}else if(product.getP_stock()<Integer.parseInt(cart_qtyStr)){
   		out.print("<script>alert('"+msg1+"');</script>");
   		out.print("<script>window.close();</script>");
   		return;
   	}
    cartService.addCart(sUserId,p_no1,Integer.parseInt(cart_qtyStr));
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<div style="width:180px ;margin:0 auto;padding: 0px">
	<img src="http://pics.gmkt.kr/pc/ko/item/vip/img_cartplus_n.png" width="25px" height="25px"
		alt="장바구니이미지">
	<strong>상품을 담았습니다.</strong>
	<div  style="margin-top: 5px;margin-left: auto;margin-right: auto;padding: 5px" >
		<div  style="margin: 0 auto;padding: 0px 20px">
			<button onclick="window.close();opener.location.reload();" style="font-size: 6pt">
				계속 쇼핑
			</button>
			<button onclick="window.close();opener.location.href='cart_view_select_update_qyt_all_check_delete_image.jsp';" style="font-size: 6pt">
				장바구니
			</button> 
			<!-- <button onclick="window.close();opener.location.href='cart_view_select.jsp';">
				장바구니[cart_view_select.jsp]
			</button> 
			<button onclick="window.close();opener.location.href='cart_view_select_update_qty.jsp';">
				장바구니[cart_view_select_update_qty.jsp]
			</button> 
			<button onclick="window.close();opener.location.href='cart_view_select_update_qyt_all_check_delete_image.jsp';">
				장바구니[cart_view_select_update_qyt_all_check_delete_image.jsp]
			</button>  -->
			
			
		</div>
	</div>
</div>
</body>
</html>
