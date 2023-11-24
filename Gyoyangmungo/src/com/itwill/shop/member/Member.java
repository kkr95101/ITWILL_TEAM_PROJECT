package com.itwill.shop.member;
/*
VO(Value Object),DTO(Data Transfer Object)
	- userinfo 테이블 1개 row의 데이타의 값을 가지는객체
	- userinfo 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- userinfo 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
* =================================== 
* 이름 		널? 		유형
* =================================== 
* USERID 	NOT NULL VARCHAR2(100) 
* PASSWORD	NOT NULL VARCHAR2(100) 
* NAME 		NOT NULL VARCHAR2(200) 
* EMAIL 			 VARCHAR2(300)
* ===================================
*/
public class Member {
	private String m_Id;
	private String m_Pw;
	private String m_Name;
	private String m_Phone;
	private String m_Email;
	private String m_Address;
	
	public Member() {}

	public Member(String m_Id, String m_Pw, String m_Name, String m_Phone, String m_Email, String m_Address) {
		super();
		this.m_Id = m_Id;
		this.m_Pw = m_Pw;
		this.m_Name = m_Name;
		this.m_Phone = m_Phone;
		this.m_Email = m_Email;
		this.m_Address = m_Address;
	}

	public String getM_Id() {
		return m_Id;
	}

	public void setM_Id(String m_Id) {
		this.m_Id = m_Id;
	}

	public String getM_Pw() {
		return m_Pw;
	}

	public void setM_Pw(String m_Pw) {
		this.m_Pw = m_Pw;
	}

	public String getM_Name() {
		return m_Name;
	}

	public void setM_Name(String m_Name) {
		this.m_Name = m_Name;
	}

	public String getM_Phone() {
		return m_Phone;
	}

	public void setM_Phone(String m_Phone) {
		this.m_Phone = m_Phone;
	}

	public String getM_Email() {
		return m_Email;
	}

	public void setM_Email(String m_Email) {
		this.m_Email = m_Email;
	}

	public String getM_Address() {
		return m_Address;
	}

	public void setM_Address(String m_Address) {
		this.m_Address = m_Address;
	}

	@Override
	public String toString() {
		return "Member [m_Id=" + m_Id + ", m_Pw=" + m_Pw + ", m_Name=" + m_Name + ", m_Phone=" + m_Phone + ", m_Email="
				+ m_Email + ", m_Address=" + m_Address + "]\n";
	}
	

	
	
	
	
	

}
