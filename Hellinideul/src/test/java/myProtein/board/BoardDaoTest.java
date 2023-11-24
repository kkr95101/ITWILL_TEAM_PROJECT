package myProtein.board;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myProtein.user.UserDaoImpMyBatis;

public class BoardDaoTest {
	BoardDao boardDao;
	
	@BeforeEach
	void boardDaoCreate() throws Exception {
		boardDao = new BoardDaoImplMyBatis();
	}
	
	@Test
	void testBoardDao() throws Exception {
		boardDao = new BoardDaoImplMyBatis();
		assertNotNull(boardDao);
	}
	
	@Test
	void testFindByNo() throws Exception{
		Board board=boardDao.findBoard(7);
		assertNotNull(board);
		System.out.println(board);
	}
	
	@Test
	void testFindAll() throws Exception{
		List<Board> boardList = boardDao.findBoardList(0, 1);
		assertNotNull(boardList);
		assertNotSame(boardList.size(), 0);
		System.out.println(boardList);
	}
	
	/*
	@Test
	void testInsert() throws Exception{
		int insertRowCount = boardDao.insert(new Board(0,"test test", "작성자 테스트","내용", null,0,0,1,0,"zz"));
		assertTrue(insertRowCount==1, "삽입실패");
	}
	*/
	
	/*
	@Test
	void testUpdate() throws Exception{
		int updateRowCount = boardDao.update(new Board(15, "test1", "작성자", "내용1", null, 0,0,1,0,"zz"));
		assertTrue(updateRowCount==1, "수정실패");
	}
	*/
	
	/*
	@Test
	void testDelete() throws Exception{
		int deleteRowCount = boardDao.delete(20);
		assertTrue(deleteRowCount==1, "삭제실패");
	}
	*/
	/*
	@Test
	void testReply() throws Exception{
		int reply=boardDao.insertReply(new Board(22, "ss", "ss", "ss", null, 0, 0, 0, 0, "zz"));
		assertTrue(reply==1, "답글실패");
	}
	*/
	@Test
	void testGetBoardCount() throws Exception{
		int rowCount = boardDao.getBoardCount();
		System.out.println(rowCount);
		
	}
	
}
