package com.itwill.shop.member;

public class MemberSQL {
	public static final String MEMBER_INSERT = "insert into userinfo(m_id, m_pw , m_name , m_phone, m_email, m_address) values(?,?,?,?,?,?)";
	public static final String MEMBER_SELECT_BY_ID = "select m_id, m_name ,m_pw, m_phone, m_email, m_address  from userinfo where m_id=?";
	public static final String MEMBER_REMOVE = "delete from userinfo where m_id=?";
	public static final String MEMBER_UPDATE = "update userinfo set m_pw=? , m_name=?, m_phone=?, m_email=? , m_address=? where m_id=?";
	public static final String MEMBER_SELECT_BY_ID_COUNT = "select count(*) from userinfo where m_id=?";
	public static final String MEMBER_SELECT_BY_ALL = "select * from userinfo";
	
	
	
}
