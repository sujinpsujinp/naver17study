package db.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";//com.mysql.cj.jdbc.이 부분이 패키지, Driver 이게 클래스
	String url="jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String password="1234";
	
	//네이버 클라우드 mysql 서버(camp107)
	String url2="jdbc:mysql://db-324o8s-kr.vpc-pub-cdb.ntruss.com:3306/studydb?serverTimezone=Asia/Seoul";
	String username2="study";
	String password2="bitcamp!@#123";
	
	public MysqlConnect() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql Driver 오류:"+e.getMessage());
		}
	}
	
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, username,password);
		}catch(SQLException e) {
			System.out.println("Mysql 접속 실패 :"+e.getMessage());
		}
		return conn;
	}
	
	public Connection getNaverCloudConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url2, username2,password2);
		}catch(SQLException e) {
			System.out.println("네이버 클라우드 Mysql 접속 실패 :"+e.getMessage());
		}
		return conn;
	}
	
	public void dbClose(PreparedStatement pstmt,Connection conn)
	{
		try {
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn)
	{
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
