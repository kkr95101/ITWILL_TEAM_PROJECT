package com.itwill.shop.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itwill.shop.common.DataSource;
/*
사용자관리에서 데이타베이스와의 작업을 전담하는 클래스
USERINFO 테이블에 사용자를 추가,삭제,검색,수정등의 작업을한다.
*/
public class MemberDao {
	private DataSource dataSource;
	public MemberDao() throws Exception {
		dataSource=new DataSource();
	}
	/*
	 * create(insert):user테이블에 새로운사용자생성
	 */
	public int insert(Member member) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_INSERT);
		pstmt.setString(1, member.getM_Id());
		pstmt.setString(2, member.getM_Pw());
		pstmt.setString(3, member.getM_Name());
		pstmt.setString(4, member.getM_Address());
		pstmt.setString(5, member.getM_Email());
		pstmt.setString(6, member.getM_Phone());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	/*
	 * update: 기존의 사용자정보를 수정
	 */
	public int update(Member member) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_UPDATE);
		pstmt.setString(1, member.getM_Pw());
		pstmt.setString(2, member.getM_Name());
		pstmt.setString(3, member.getM_Phone());
		pstmt.setString(4, member.getM_Email());
		pstmt.setString(5, member.getM_Address());
		pstmt.setString(6, member.getM_Id());
		
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	/*
	 * remove(delete):사용자아이디에해당하는사용자를 삭제
	 */
	public int delete(String m_Id) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_REMOVE);
		pstmt.setString(1, m_Id);
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 1개 찾아서 User 객체로반환
	 * selectByPK
	 */
	public Member findById(String m_Id)throws Exception {
		Member member=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_SELECT_BY_ID);
		pstmt.setString(1, m_Id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			member=new Member(
					rs.getString("m_id"),
					rs.getString("m_pw"),
					rs.getString("m_name"), 
					rs.getString("m_phone"),
					rs.getString("m_email"),
					rs.getString("m_address"));
		}
		return member;
	}
	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지 여부를 판별
	 */
	public int countByMemberId(String m_Id) throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_SELECT_BY_ID_COUNT);
		pstmt.setString(1, m_Id);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		int memberCount = rs.getInt(1);
		return memberCount;
		
	}
	
}












