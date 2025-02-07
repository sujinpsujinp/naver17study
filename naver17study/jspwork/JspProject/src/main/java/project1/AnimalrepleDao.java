package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;
import shop.data.ShoprepleDto;

public class AnimalrepleDao {
	MysqlConnect db=new MysqlConnect();
	
	public void insertReple(AnimalreplDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into anireple values (null,?,?,?,now())";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, dto.getIdx());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getReplemessage());
			//실행
			pstmt.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public List<AnimalreplDto> getRepleByIdx(int idx)
	{
		List<AnimalreplDto> list=new Vector<AnimalreplDto>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from anireple where idx=? order by num desc";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, idx);
			
			//실행
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				AnimalreplDto dto=new AnimalreplDto();
				dto.setNum(rs.getInt("num"));
				dto.setIdx(rs.getInt("idx"));
				dto.setNickname(rs.getString("nickname"));
				dto.setReplemessage(rs.getString("replemessage"));
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
	
	public void deleteReple(int num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from anireple where num=?";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			//실행
			pstmt.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void updateAnimalReple(AnimalreplDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				update anireple set replemessage=?
				where num=?
				""";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getReplemessage());
			pstmt.setInt(2, dto.getNum());
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	
	public int getCommentCountByIdx(int idx) {
	    int count = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT COUNT(*) FROM anireple WHERE idx=?";

	    try {
	        conn = db.getNaverCloudConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, idx);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);
	    }
	    return count;
	}
	
}
