package myProtein.board;

import java.util.List;

import myProtein.board.util.PageMaker;

public class BoardService {
	private static BoardService _instance;
	
	private BoardDao boardDao;
	
	public BoardService() throws Exception{
		boardDao = new BoardDaoImplMyBatis();
		// boardDao = new BoardDaoImplMyBatis();
	}
	
	
	/*
	 싱글톤 디자인 패턴을 사용하여 BoardService 클래스의 인스턴스를 하나만 생성하도록 구현된 메서드
	 */
	public static BoardService getInstance() throws Exception {
		if(_instance==null) { // _instance는 BoardService 클래스의 유일한 인스턴스를 저장하기 위한 정적 변수
			_instance=new BoardService(); // _instance 변수가 null인 경우, BoardService 클래스의 새로운 인스턴스를 생성하여 _instance에 할당
		}
		return _instance; //  생성된 또는 이미 존재하는 _instance 변수를 반환
	}
	

	// 게시물 삭제
	public int delete(int boardno) throws Exception, BoardException {
		Board tempBoard = boardDao.findBoard(boardno);
		boolean rExist = boardDao.countReplay(tempBoard);
		if(rExist){
			//답글존재하면
			boardDao.deleteReply(tempBoard.getDepth(), tempBoard.getGroupno());
		}
		return boardDao.delete(tempBoard.getBoard_no());
		//return getBoardDao().delete(boardno);
	}

	
	// 게시물 생성
	public int insert(Board board) throws Exception {
		return boardDao.insert(board);
	}

	// 답글 쓰기
	public int insertReply(Board board) throws Exception {
		return boardDao.insertReply(board);
	}
	
	// 게시물 수정
	public int update(Board board) throws Exception {
		return boardDao.update(board);
	}
	
	// 게시물 1개
	public Board findBoard(int boardNo) throws Exception {
		Board board =boardDao.findBoard(boardNo);
		return board;
	}
	public void updateHitCount(int boardNo) throws Exception {
		boardDao.increaseReadCount(boardNo);
	}
	
	// 게시물 리스트
	public BoardListPageMakerDto findBoardList(int currentPage) throws Exception {
		//1. 전체글의 갯수
		int totalRecordCount = boardDao.getBoardCount();
		
		// 2. paging 계산(PageMaker 유틸클래스) 
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		
		//3. 게시물 데이터 얻기
		List<Board> boardList = boardDao.findBoardList(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		
		BoardListPageMakerDto pageMakerBoardList = new BoardListPageMakerDto();
		pageMakerBoardList.itemList=boardList;
		pageMakerBoardList.pageMaker=pageMaker;
		return pageMakerBoardList;
	}
	
	
	// 답변 게시물 삭제관련 메소드
	public int deleteReply(int depth, int groupno) throws Exception {
		return deleteReply(depth, groupno);
	}
	
	
}
