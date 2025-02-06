package shop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;
import simpleboard.data.SimpleAnswerDto;

public class ShoprepleDao {
	MysqlConnect db=new MysqlConnect();
	
	public void insertReple(ShoprepleDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into shopreple values (null,?,?,?,now())";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, dto.getNum());
			pstmt.setInt(2, dto.getStar());
			pstmt.setString(3, dto.getMessage());
			//실행
			pstmt.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteReple(int idx)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from shopreple where idx=?";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, idx);
			//실행
			pstmt.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public List<ShoprepleDto> getRepleByNum(int num)
	{
		List<ShoprepleDto> list=new Vector<ShoprepleDto>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from shopreple where num=? order by idx desc";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			
			//실행
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				ShoprepleDto dto=new ShoprepleDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setNum(rs.getInt("num"));
				dto.setStar(rs.getInt("star"));
				dto.setMessage(rs.getString("message"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,pstmt, conn);
		}
		
		return list;
	}
	
	
	
}
