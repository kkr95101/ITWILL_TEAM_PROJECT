package myProtein.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myProtein.mapper.BoardMapper;

public class BoardDaoImplMyBatis implements BoardDao{

	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDaoImplMyBatis() throws Exception{
		this.sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
	}
	
	// 새로운 게시물 추가
	@Override
	public int insert(Board board) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		int rowCount = boardMapper.insert(board);
		sqlSession.close();
		return rowCount;
	}

	// 게시물 수정
	@Override
	public int update(Board board) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		int rowCount = boardMapper.update(board);
		sqlSession.close();
		return rowCount;
	}

	// 게시물 삭제
	@Override
	public int delete(int board_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		int rowCount=boardMapper.delete(board_no);
		sqlSession.close();
		return rowCount;
	}
	
	// 게시물 리스트 반환(게시물시작번호, 게시물끝번호)
	@Override
	public List<Board> findBoardList(int start, int last) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		Map param = new HashMap();
		param.put("start", start);
		param.put("last", last);
		List<Board> boardList=boardMapper.findBoardList(param);
		sqlSession.close();
		return boardList;
	}

	// 게시물 번호에 해당하는 정보 보기
	@Override
	public Board findBoard(int board_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		Board board=boardMapper.findBoardByNo(board_no);
		sqlSession.close();
		return board;
	}

	// 게시물 조회수 1증가
	@Override
	public void increaseReadCount(int num) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		boardMapper.increaseReadCount(num);
		sqlSession.close();
	}

	// 게시물 총 건수 조회
	@Override
	public int getBoardCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		int totCount = boardMapper.getBoardCount();
		sqlSession.close();
		return totCount;
	}

	// 답글 게시물 추가
	@Override
	public int insertReply(Board board) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		
		BoardMapper boardMapper=sqlSession.getMapper(BoardMapper.class);
		Board temp=boardMapper.findBoardByNo(board.getBoard_no());
		boardMapper.updateReply(temp);
		
		board.setGroupno(temp.getGroupno());
		board.setStep(temp.getStep()+1);
		board.setDepth(temp.getDepth()+1);
		System.out.println(board);
		int rowCount = boardMapper.insertReply(board);
		
		sqlSession.commit();
		sqlSession.close();
		return rowCount;
	}
	
	// 답변 게시물 존재여부 확인 메소드
	@Override
	public boolean countReplay(Board board) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		int rowCount = boardMapper.countReplay(board);
		Boolean isExist = false;
		if(rowCount >1) {
			isExist=true;
		}
		sqlSession.close();
		return isExist;
	}
	
	// 답변 게시물 삭제관련 메소드
	public int deleteReply(int depth, int groupno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		int rowCount=boardMapper.deleteReply(depth, groupno);
		sqlSession.close();
		return rowCount;
	}

}
