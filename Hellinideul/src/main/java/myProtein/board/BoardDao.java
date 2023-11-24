package myProtein.board;

import java.sql.SQLException;
import java.util.List;



public interface BoardDao {
	//새로운 게시글 추가 
	int insert(Board board) throws Exception;
	
	//게시글 내용 수정
	int update(Board board) throws Exception;
	
	//게시글 삭제
	int delete(int board_no) throws Exception;
	
	//게시글 리스트 보기
	List<Board> findBoardList(int start, int last) throws Exception;
	
	//게시글 번호로 게시글 정보 확인
	Board findBoard(int board_no) throws Exception;
	
	//게시글 조회수 1증가
	void increaseReadCount(int num) throws Exception;
	
	//게시글 총 건수 조회
	int getBoardCount() throws Exception;
	
	//답글 게시물 추가
	int insertReply(Board board) throws Exception;
	
	// 답변 게시물 존재여부 확인 메소드
	boolean countReplay(Board board) throws Exception;
	
	// 답변 게시물 삭제관련 메소드
	int deleteReply(int depth, int groupno) throws Exception;
	
}
