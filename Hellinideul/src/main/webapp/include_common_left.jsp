<%@page import="myProtein.user.UserService"%>
<%@page import="myProtein.user.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myProtein.cart.CartService"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>MyProtein 페이지</title>

    <style>
        /* 필요하다면 여기에 CSS 스타일을 추가하세요. */
        ul.menu-list {
           list-style-type: none;
           padding: 0;
        }
        ul.menu-list li {
           padding: 10px 15px;
           margin-bottom: 5px;
           border: 1px solid #ddd; 
           border-radius: 5px;
           transition: background-color 0.3s;
        }
        ul.menu-list li:hover {
           background-color: #f5f5f5;
        }
        ul.menu-list li a {
           text-decoration: none;
           color: #333;
           font-weight: bold;
        }
        span.cart_item_count {
          background-color: #e74c3c;
           border-radius: 50%;
           padding: 5px 10px;
           color: white;
           margin-left: 10px;
        }
    </style>

    <script type="text/javascript">
        function login_message() {
            alert('로그인하세요');
            location.href = 'user_login_form.jsp';
        }
    </script>
</head>
<body>

<%
	String sUserId=(String)session.getAttribute("sUserId");
%>	

<p><strong>메 뉴</strong></p>

<ul class="menu-list">
    <%
        if(sUserId==null){
    %>
        <li><a href="user_login_form.jsp">로그인</a></li>
        <li><a href="user_write_form_popup.jsp">회원가입</a></li>
        <li><a href="javascript:login_message();">장바구니</a></li>
        <li><a href="product_list.jsp">상품리스트</a></li>
        <li><a href="board_list.jsp">게시판리스트</a></li>
        <li><a href="javascript:login_message();">게시판쓰기</a></li>
    <%
        }else{ 
            User sUser=new UserService().findById(sUserId);
            CartService cartService=new CartService();
            int cart_item_count = cartService.findAll(sUserId).size();
    %>    
        <li><a href="user_view.jsp"><%=sUser.getU_name()+"님"%></a></li>
        <li><a href="user_logout_action.jsp">로그아웃</a></li>
        <li><a href="cart_view_select_update_qyt_all_check_delete_image.jsp">장바구니<span class="w3-badge w3-badge-menu w3-green cart_item_count"><%=cart_item_count%></span></a></li>
        <li><a href="order_list_orderitem2.jsp">주문목록</a></li>
        <li><a href="product_list.jsp">상품리스트</a></li>
        <li><a href="board_list.jsp">게시판리스트</a></li>
        <li><a href="board_write.jsp">게시판쓰기</a></li>
    <% 
        } 
    %>
</ul>

</body>
</html>
