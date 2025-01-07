package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2MysqlConnect {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";//com.mysql.cj.jdbc.이 부분이 패키지, Driver 이게 클래스
	String url="jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String password="1234";
	
	
	public Ex2MysqlConnect() {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql 드라이버 실패: "+e.getMessage());
		}
	}
	
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Mysql 접속 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql 접속 실패"+e.getMessage());
		}
		return conn;
	}
	
	public void personWriteData()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		conn=this.getConnection();
		//방법1
		//String sql="select name,age,blood,hp,date_format(today,\"%Y-%m-%d %H:%i\") today from person";
		//방법2 jdk17에서 추가된 기능- 멀티라인텍스트 
		String sql="""
				select name,age,blood,hp,date_format(today,"%Y-%m-%d %H:%i") today 
				from person
				""";
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);//select sql문은 ReseultSet이 반환되는 executeQuery만 가능
			
			System.out.println("이름\t나이\t혈액형\t전화번호\t날짜");
			System.out.println("=".repeat(60));
			
			while(rs.next())
			{
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String blood=rs.getString("blood");
				String hp=rs.getString("hp");
				String today=rs.getString("today");
				
				System.out.println(name+"\t"+age+"\t"+blood+"\t"+hp+"\t"+today);
				
			}
		} catch (SQLException e) {
			System.out.println("sql문 오류: "+e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2MysqlConnect ex2=new Ex2MysqlConnect();
		ex2.personWriteData();		
		
		
		
		
	}

}
