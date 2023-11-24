package com.itwill.shop.member;


public class MemberService {
	private MemberDao memberDao;
	public MemberService() throws Exception {
		memberDao=new MemberDao();
	}
	
	
	/*
	 * 회원가입
	 */
	public int create(Member member) throws Exception{
		//1.아이디중복체크
		if(memberDao.countByMemberId(member.getM_Id())>=1) {
			//중복
			return -1;
		}else {
			//가입
			int rowCount=memberDao.insert(member);
			return rowCount;
		}
	}
	
	/*
	 * 회원로그인
	 */
	public int login(String m_Id,String m_Pw)throws Exception{
		/*
		 * 0 : 실패
		 * 1 : 성공
		 * 
		 */
		int result=0;
		if(memberDao.countByMemberId(m_Id)==1) {
			//아이디존재하는경우
			Member loginUser = memberDao.findById(m_Id);
			if(loginUser.getM_Pw().equals(m_Pw)) {
				//패쓰워드일치
				result=1;
			}else {
				//패쓰워드불일치
				result=0;
			}
		}else {
			//회원이아닌경우
			result=0;
		}
		return result;
	}
	
	
	/*
	 * 회원로그아웃
	 */
	public void logout() {
		/*
		 * 로그아웃시 DB작업이필요하다면 기술함
		 */
	}
	/*
	 * 로그인한 회원의 정보보기
	 */
	public Member findUser(String m_Id) throws Exception{
		return memberDao.findById(m_Id);
	}
	/*
	 * 회원수정
	 */
	public int update(Member user)throws Exception{
		return memberDao.update(user);
	}
	/*
	 * 아이디중복체크
	 */
	public boolean isDuplicateId(String m_Id) throws Exception{
		if(memberDao.countByMemberId(m_Id)>=1) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 회원탈퇴
	 */
	public int remove(String m_Id) throws Exception{
		return memberDao.delete(m_Id);
	}
	
}
