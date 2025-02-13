package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3OracleJoin {
	
	static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";//클래스지만 컴파일러는 String으로 되어있어서 문자열로 인식함
	//db에 접근하려면 url과 id,password가 필요하다.
	String url="jdbc:oracle:thin:@localhost:1521/xe";
	String username="angel";
	String password="pw1234";
	
	public Ex3OracleJoin()
	{
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이버 실패"+e.getMessage());
		}
	}
	
	//db연결 후 connection 반환
	public Connection getConnection()
	{
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("오라클 접속 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 접속 실패!"+e.getMessage());
		}return conn;
	}
	
	public void shopcartData()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="""
				select 
				    s.sangcode,sangname,sangprice,cntnum,to_char(cartday,'yyyy-mm-dd') cartday
				from shop s,cart c
				where s.sangcode=c.sangcode
				""";
		
		conn=this.getConnection();
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("코드\t상품명\t가격\t갯수\t날짜");
			System.out.println("=".repeat(60));
			
			while(rs.next())
			{
				String sangcode=rs.getString("sangcode");
				String name=rs.getNString("sangname");
				String price=rs.getString("sangprice");
				int cnt=rs.getInt("cntnum");
				String cartday=rs.getString("cartday");
				
				System.out.println(sangcode+"\t"+name+"\t"+price+"\t"+cnt+"\t"+cartday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		Ex3OracleJoin ex3=new Ex3OracleJoin();
		ex3.shopcartData();
	}

}
