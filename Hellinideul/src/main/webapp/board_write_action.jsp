<%@page import="myProtein.user.User"%>
<%@page import="myProtein.board.BoardService"%>
<%@page import="myProtein.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("board_list.jsp");
		return;
	}
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String sUserId=(String)session.getAttribute("sUserId");
	
	BoardService boardService = new BoardService();
	
	int boardInsert = boardService.insert(new Board(0, title, writer, content, null, 0, 0, 0, 0, sUserId));
	response.sendRedirect("board_list.jsp");

%>
