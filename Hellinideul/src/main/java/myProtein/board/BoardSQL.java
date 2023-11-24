package myProtein.board;

public class BoardSQL {
	public static final String BOARD_INSERT=
			"insert into board(board_no, title, writer, content,groupno, step, u_id) values(board_board_no_seq.nextval, ?, ?, ?, board_board_no_seq.currval, 1,?);";

	public static final String BOARD_UPDATE_BY_BOARDNO = 
			"update board set title=?, writer=?, content=? where board_no=?";

	public static final String BOARD_DELETE_BY_BOARDNO=
			"delete board where board_no=?";

	public static final String BOARD_SELECT_BY_BOARDNO=
			"select * from board where board_no=?";
	
	public static final String BOARD_UPDATE_READ_COUNT_BY_BOARDNO=
			"update board set read_count=read_count+1 where board_no=?";
	
	public static final String BOARD_SELECT_COUNT_TOT_RECORD=
			"select count(*) from board";
	
	public static final String BOARD_INSERT_REPLY=
			"insert into board(board_no, title, writer, content, groupno, step, depth) values(board_board_no_seq.nextval, ?,?,?,?,?,?)";

	public static final String BOARD_UPDATE_STEP_REPLY=
			"update board set step=step+1 where step>? and groupno=?";

	public static final String BOARD_SELECT_REPLY_COUNT_BY_GROUPNO_DEPTH_STEP=
			"select count(*) from board where groupno=? and depth>=? and step>=? order by step, depth asc";
	
	public static final String BOARD_SELECT_LIST_BY_ROWNUM_RANGE=
			"SELECT * FROM ( "
					+ "SELECT rownum idx, s.* FROM( "
					+ "SELECT boardno, title, writer,regdate,"
					+ "readcount,groupno, step, depth "
					+ " FROM board ORDER BY groupno DESC, step ASC "
					+ ") s"
					+ ") "
					+ "WHERE idx >= ? AND idx <= ?";
	
	// 답변 게시물 삭제관련 메소드
	public static final String BOARD_DELETE_REPLY=
			"DELETE board WHERE depth >= ? AND groupno = ?";
	
	// SQL : DELETE board WHERE depth >= 1 AND groupno = 90;
	

}
