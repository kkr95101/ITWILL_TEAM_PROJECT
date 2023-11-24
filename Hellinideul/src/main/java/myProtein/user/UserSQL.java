package myProtein.user;

public class UserSQL {
	public final static String USER_INSERT=
			"insert into user_info(u_id, u_pw, u_name, u_phone, u_email, u_address) values(?,?,?,?,?,?)";
	public final static String USER_UPDATE=
			"update set user_info u_pw=?, u_name=?, u_phone=?, u_email=?, u_address=? where u_id=?";
	public final static String USER_DELETE=
			"delete from user_info where u_id=?";
	public final static String USER_SELECT_ALL=
			"select * from user_info";
	public final static String USER_SELECT_BY_ID=
			"select * from user_info where u_id=?";
	public final static String USER_SELECT_BY_ID_COUNT=
			"select count(*) from user_info where u_id=?";
}
