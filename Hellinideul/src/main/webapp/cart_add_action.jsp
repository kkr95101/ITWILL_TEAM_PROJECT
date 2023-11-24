<%@page import="java.util.ArrayList"%>
<%@page import="myProtein.product.Product"%>
<%@page import="java.util.List"%>
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
		
/* CartService cartService=new CartService();
	cartService.addCart(sUserId, p_no, Integer.parseInt(cart_qtyStr)); */
		
		
       	/*
       	1.파라메타받기(cart_qty,p_no)
       	2.장바구니에 제품을담고 cart_view.jsp로redirection
       	*/
       	String cart_qtyStr=request.getParameter("cart_qty");
       	System.out.println(cart_qtyStr);
       	String p_noStr=request.getParameter("p_no");

       	CartService cartService=new CartService();  

       	cartService.addCart(sUserId,Integer.parseInt(p_noStr),Integer.parseInt	(cart_qtyStr));
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
       		out.print("<script>location.href='product_detail.jsp?p_no="+Integer.parseInt(p_noStr)+ "'</script>");
       		return;
       	}else if(product.getP_stock()<Integer.parseInt(cart_qtyStr)){
       		out.print("<script>alert('"+msg1+"');</script>");
       		out.print("<script>location.href='product_detail.jsp?p_no="+Integer.parseInt(p_noStr)+ "'</script>");
       		return;
       	}
       	cartService.addCart(sUserId,p_no,Integer.parseInt(cart_qtyStr));
       	} else{
       	int p_no1=productService.findProductName(p_name);
       	product = productService.findByNo(p_no1);
       	if(product.getP_stock()==0){
       		out.print("<script>alert('"+msg2+"');</script>");
       		out.print("<script>location.href='product_detail.jsp?p_no="+Integer.parseInt(p_noStr)+ "'</script>");
       		return;
       	}else if(product.getP_stock()<Integer.parseInt(cart_qtyStr)){
       		out.print("<script>alert('"+msg1+"');</script>");
       		out.print("<script>location.href='product_detail.jsp?p_no="+Integer.parseInt(p_noStr)+ "'</script>");
       		return;
       	}
       	cartService.addCart(sUserId,p_no1,Integer.parseInt(cart_qtyStr));
       	}
    	response.sendRedirect("product_detail.jsp?p_no="+Integer.parseInt(p_noStr));

    	
    	
    	
    	
		
		
    	/*
       	response.sendRedirect("cart_view.jsp");
       	response.sendRedirect("cart_view_select.jsp");
       	response.sendRedirect("cart_view_select_update_qty.jsp");
       	response.sendRedirect("cart_view_select_update_qyt_all_check_delete_image.jsp");
       	*/
       
       
       
       
       
       
       
       
       %>