<%@page import="myProtein.board.BoardService"%>
<%@page import="myProtein.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //Board객체를 생성하고 입력된데이타를 읽어서 객체에저장
    Board board=new Board();

    String boardNoString = request.getParameter("boardno");
    if (boardNoString != null && !boardNoString.isEmpty()) {
        try {
            int boardNo = Integer.parseInt(boardNoString);
            board.setBoard_no(boardNo);
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우에 대한 처리
            // 예외 처리 내용을 작성해야 합니다.
        }
    } else {
        // boardno 값이 null 또는 비어있는 경우에 대한 처리
        // 예외 처리 내용을 작성해야 합니다.
    }

    /*
    답글 데이타
    */
    String title = request.getParameter("title");
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");
    String sUserId=(String)session.getAttribute("sUserId");
    
    board.setTitle(title);
    board.setWriter(writer);
    board.setContent(content);
    board.setU_id(sUserId);

    BoardService.getInstance().insertReply(board);

    String pageno = "1";
    if(request.getParameter("pageno")!=null){
        pageno=request.getParameter("pageno");
    }
    response.sendRedirect(
            String.format("board_list.jsp?pageno=%s",pageno));
%>
