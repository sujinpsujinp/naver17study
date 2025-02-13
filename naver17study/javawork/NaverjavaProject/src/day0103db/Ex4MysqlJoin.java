package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex4MysqlJoin {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";//com.mysql.cj.jdbc.이 부분이 패키지, Driver 이게 클래스
	String url="jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String password="1234";
	
	public Ex4MysqlJoin() {
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
	
	public void joinPersonTable()
	{		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="""
				select name,blood,age,hp,kor,eng,sum
				from person p inner join stu s on p.num=s.num;
				""";
		//db연결
		conn=this.getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("이름\t혈액형\t나이\t핸드폰\t\t국어\t영어\t총점");
			System.out.println("=".repeat(60));
			
			while(rs.next())
			{
				String name=rs.getNString("name");
				String blood=rs.getString("blood");
				int age=rs.getInt("age");
				String hp=rs.getString("hp");
				int kor=rs.getInt("kor");
				int eng=rs.getInt("eng");
				int sum=rs.getInt("sum");		
						
				System.out.println(name+"\t"+blood+"\t"+age+"\t"+hp+"\t"+kor+"\t"+eng+"\t"+sum);
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void personBoodGroup()
	{
		//혈액형별 인원수랑 나이평균 구하기
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		conn=this.getConnection();
		
		String sql="""
				select blood,count(*) count, round(avg(age),1) avgage from person
				group by blood order by count
				""";
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);//select문 가져오면 ReseultSet을 반환하는 executeQuery 필요함
			
			System.out.println("혈액형\t인원수\t평균나이");
			System.out.println("=".repeat(30));
			
			while(rs.next())
			{
				String blood=rs.getString("blood");
				int count=rs.getInt("count");
				double avgage=rs.getDouble("avgage");
				
				System.out.println(blood+"\t"+count+"\t"+avgage);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql문 오류:"+e.getMessage());
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
		Ex4MysqlJoin ex4=new Ex4MysqlJoin();
		ex4.joinPersonTable();
		System.out.println();
		ex4.personBoodGroup();
	
	}

}
