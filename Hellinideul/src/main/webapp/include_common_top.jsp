<%@page import="myProtein.product.Product"%>
<%@page import="java.util.List"%>
<%@page import="myProtein.product.ProductService"%>
<%@page import="myProtein.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ProductService productService = new ProductService();
	List<Product> clothesList=productService.findByParentCategory(2000);
	List<Product> topList=productService.findByCategory(2100);
	List<Product> lowList=productService.findByCategory(2200);
	List<Product> acList=productService.findByCategory(2300);
	
	List<Product> vitaminList = productService.findByParentCategory(3000);
	List<Product> viamin1List = productService.findByCategory(3100); 
	
	
	
	List<Product> proteinList = productService.findByParentCategory(1000);
	List<Product> protein1List = productService.findByCategory(1100);
	


%>

<!--include_common_top_menu.jsp  end-->

<!-- include_common_top.jsp end-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/top.css" type="text/css">
</head>

<body>
<%-- <div >
<ul class="menu">
      <li>
        <a href="#">비타민</a>
        <ul class="submenu">
          <li><a href="#">체중 감량</a></li>
          <li><a href="#">뼈&관절 건강</a></li>
          <li><a href="#">스포츠 퍼포먼스</a></li>
          <li><a href="#">오메가3</a></li>
        </ul>
      </li>
      <li>
        <a href="#">스포츠 웨어</a>
        <ul class="submenu">
          <li><a href= "product_list.jsp?p_category_no=<%=topList.get(1).getCategory2().getP_category_no()%>"><%=topList.get(1).getCategory1().getP_category_name()%></a></li>
          <li><a href="product_list.jsp?p_category_no=<%= lowList.get(1).getCategory2().getP_category_no()%>"></a><%=lowList.get(1).getCategory1().getP_category_name() %>></li>
          <li><a href="#">악세사리</a></li>
        </ul>
      </li>
      <li>
        <a href="#">단백질 보충제</a>
        <ul class="submenu">
          <li><a href="product_list.jsp?p_category_no=<%=protein1List.get(1).getCategory2().getP_category_no()%>">웨이프로틴</a></li>
          <li><a href="#">아이솔레이트</a></li>
          <li><a href="#">식물성단백질</a></li>
          <li><a href="#">복합 단백질</a></li>
        </ul>
      </li>
      
    </ul>
	
</div> --%>
</body>

</html>
<!-- include_common_top.jsp start-->
<!--include_common_top_menu.jsp  start-->
<h1>
	<a href=""></a>
</h1>
<jsp:include page="include_common_top_menu.jsp" />