package day0103db;

public class Practice {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";//com.mysql.cj.jdbc.이 부분이 패키지, Driver 이게 클래스
	String url="jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String password="1234";
	
	public Practice() {
		try {
			Class.forName(MYSQL_DRIVER);
		System.out.println();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
