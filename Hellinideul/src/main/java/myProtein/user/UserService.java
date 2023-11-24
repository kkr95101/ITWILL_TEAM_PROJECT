package myProtein.user;

import java.util.List;


import myProtein.user.exception.ExistedUserException;
import myProtein.user.exception.UserNotFoundException;
import myProtein.user.exception.PasswordMismatchException;

public class UserService {
	
	private UserDao userDao;
	public UserService() throws Exception{
		userDao= new UserDaoImpMyBatis();
	}
	
	public List<User> findAll() throws Exception{
		return userDao.findAll();
	}
	
	public int insert(User user) throws Exception{
		return userDao.insert(user);
	}
	
	public int update(User user) throws Exception{
		return userDao.update(user);
	}
	
	public int delete(String u_id) throws Exception{
		return userDao.delete(u_id);
	}
	
	public User findById(String u_id) throws Exception{
		return userDao.findById(u_id);
	}
	
	
	
	// 회원가입
	public int create(User user) throws Exception {
		//1. 아이디 중복체크
		if(userDao.countByUserId(user.getU_id())>0) {
			throw new ExistedUserException(user.getU_id() + " 는 이미 존재하는 아이디입니다.");
		}
		return userDao.insert(user);
	}
	
	
	public User login(String u_id, String u_pw) throws Exception {
		// 1.아이디존재여부
		User user = userDao.findById(u_id);
		if (user == null) {
			throw new UserNotFoundException(u_id + " 는 존재하지않는 아이디 입니다.");
		}
		// 2.패쓰워드일치여부
		if (!user.isMatchPassword(u_pw)) {
			throw new PasswordMismatchException("패쓰워드가 일치하지않습니다.");
		}
		return user;
	}
	
	
	
	
	
	/*
	 * 회원가입
	 */
//	
//	public int create(User user)throws Exception{
//		/*
//		 * -1:아이디중복
//		 *  1:회원가입성공
//		 */
//		
//		if(userDao.countByUserId(user.getU_id())==1) {
//			//아이디중복
//			return -1;
//		}else {
//			//아이디안중복
//			//회원가입
//			userDao.insert(user);
//			return 1;
//		}
//	}

	
	/*
	 * 회원로그인
	 *  0:아이디존재안함
	 * 	1:패쓰워드 불일치
	 * 	2:로그인성공(세션)
	 */
	/*
	public int login(String u_id,String u_pw) throws Exception{
		int result=-1;
		//1.아이디존재여부
		User user = userDao.findById(u_id);
		if(user==null) {
			//아이디존재안함
			result=0;
		}else {
			//아이디존재함
			if(user.getU_pw().equals(u_pw)) {
				//패쓰워드일치
				result=2;
			}else {
				//패쓰워드불일치
				result=1;
			}
		}
		return result;
	}
	*/
	
	public boolean isDuplicateId(String u_id) throws Exception{
		int count = userDao.countByUserId(u_id);
		boolean isExist = false;
		if(count>0) {
			isExist=true;
		}
		return isExist;
	}
	
}
