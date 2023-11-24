package com.itwill.shop.test;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberDao;

public class MemberDaoTestMain {
	
	public static void main(String[] args) throws Exception {
		
		MemberDao memberDao = new MemberDao();
		
//		System.out.println("1.create:"+memberDao.insert(new Member("test1", "1111", "홍길동", "010-111-1111","zz@naver.com","서울시")));
		System.out.println("2.findUser:"+memberDao.findById("test1"));
		System.out.println("3.update:"+memberDao.update(new Member("test1", "1234", "홍길동1", "010-222-2222", "aa@naver.com" , "성남시")));				
		System.out.println("4.delete:"+memberDao.delete("test1"));
		System.out.println("5.findUser:"+memberDao.findById("test1"));
	}
}
