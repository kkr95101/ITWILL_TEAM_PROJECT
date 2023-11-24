package myProtein.board.init;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class BoardDataInsertMain {
	public static void main(String[] args) throws Exception{
		Connection con = null;
		Statement stmt = null;
		try {
			Properties properties = new Properties();
			properties.load(BoardDataInsertMain.class.getResourceAsStream("/jdbc.properties"));
			/*** Apache DataSource ***/
			BasicDataSource basicDataSource = new BasicDataSource();
			basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
			basicDataSource.setUrl(properties.getProperty("url"));
			basicDataSource.setUsername(properties.getProperty("username"));
			basicDataSource.setPassword(properties.getProperty("password"));
			DataSource dataSource = basicDataSource;
			con = dataSource.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			con.setAutoCommit(false);
			for (int i = 1; i <= 563; i++) {
				stmt.addBatch("INSERT INTO board (boardno, title, writer, content, groupno, step)" + " VALUES ("
						+ "board_sequence.nextval," + "'게시판타이틀'||board_sequence.currval ,"
						+ "'김경호'||board_sequence.currval," + "'content'||board_sequence.currval,"
						+ "board_sequence.currval," + "1)");

			}
			int[] updateCounts = stmt.executeBatch();
			System.out.println("query 수:" + updateCounts.length);
			con.commit();
			System.out.println("success commit!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				System.out.println("rollback !!!");
			} catch (SQLException e1) {
				System.out.println("rollback fail!!!");
			}
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("close 시 에러발생");
			}
		}

	}
}
