package myProtein.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import myProtein.board.Board;

public interface BoardMapper {
	
	// 게시글 추가
	@Insert("insert into board(board_no, title, writer, content,regdate,groupno, step, u_id) values(board_board_no_seq.nextval, #{title}, #{writer}, #{content},sysdate, board_board_no_seq.currval, 1,#{u_id})")
	int insert(Board board) throws Exception;
	
	//게시글 수정
	@Update("update board set title=#{title}, writer=#{writer}, content=#{content} where board_no=#{board_no}")
	int update(Board board) throws Exception;
	
	//게시글 삭제
	@Delete("delete board where board_no=#{board_no}")
	int delete(int board_no) throws Exception;
	
	//게시글 번호에 해당하는 게시글 보기
	@Select("select * from board where board_no=#{board_no}")
	Board findBoardByNo(int board_no) throws Exception;
	
	//게시글 리스트 보기
	
	@Select("SELECT * FROM ( SELECT rownum idx, s.* FROM( "
			+ "                            SELECT board_no, title,content, writer,regdate,read_count,groupno, step, depth "
			+ "                            FROM board ORDER BY groupno DESC, step ASC"
			+ "                            ) s"
			+ "               )"
			+ "WHERE idx >= #{start} AND idx <= #{last}")
	List<Board> findBoardList(Map param) throws Exception;
	
	
	
	
	//답글 게시글 추가
	@Insert("insert into board(board_no, title, writer, content, groupno, step, depth, u_id) values(board_board_no_seq.nextval, #{title}, #{writer}, #{content}, #{groupno}, #{step},#{depth},#{u_id})")
	int insertReply(Board board) throws Exception;
	
	//게시글 조회수 1증가
	@Update("update board set read_count=read_count+1 where board_no=#{board_no}")
	void increaseReadCount(int num) throws Exception;
	
	//게시글 총 건수 조회
	@Select("select count(*) from board")
	int getBoardCount() throws Exception;
	
	//답글 게시물 추가 전 STEP UPDATE
	@Update("update board set step = step + 1 where step > #{step} and groupno = #{groupno}")
	int updateReply(Board temp) throws Exception;
	
	// 답변 게시물 존재여부 확인 메소드
	@Select("select count(*) cnt from board where groupno = #{groupno} and depth >= #{depth} and step >=#{step} order by step,depth asc")
	int countReplay(Board board) throws SQLException;
	
	// 답변 게시물 삭제관련 메소드
	@Delete("DELETE board WHERE depth >= #{depth} AND groupno = #{groupno}")
	int deleteReply(@Param("depth") int depth,@Param("groupno") int groupno) throws Exception;
	/*
	 * @param 어노테이션은 MyBatis에서 SQL 쿼리 메소드의 파라미터와 실제 SQL 문 내의 파라미터 이름을 매핑하기 위해 사용한다.
	 * -->> @Param 어노테이션은 메소드 파라미터와 SQL 문 내의 파라미터 이름을 일치시키거나 
	 * 		명확하게 지정하여 가독성과 코드의 의도를 더욱 명확하게 전달하는 데 사용한다.
	 */
}
