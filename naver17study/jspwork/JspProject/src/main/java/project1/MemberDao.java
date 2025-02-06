package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.connect.MysqlConnect;

public class MemberDao {
	MysqlConnect db=new MysqlConnect();
	
	public void insertMember(MemberDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into member values(?,?,?)";
		
		conn=db.getNaverCloudConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPw());
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}	
	
}
