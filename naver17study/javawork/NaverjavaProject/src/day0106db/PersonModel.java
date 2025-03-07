package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

//db를 처리하기 위한 클래스
public class PersonModel {
	MysqlConnect connect=new MysqlConnect();
	
	//전체 데이터 반환하는 메서드
	//List안에 Vector 형태로 반환
	public List<Vector<String>> getAllDatas()
	{
		List<Vector<String>> list=new Vector<Vector<String>>();
		Connection conn=connect.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from person order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("age"));
				data.add(rs.getString("hp"));
				data.add(rs.getString("blood"));
				
				//리스트에 추기
				list.add(data);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	//insert
	public void insertPerson(PersonDto dto)
	{
		Connection conn=connect.getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into person (name,age,hp,blood) values (?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getBlood());
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(pstmt, conn);
		}
		
	}
	
	//delete
	public void deletePerson(int num)
	{
		Connection conn=connect.getConnection();
		PreparedStatement pstmt=null;
		String sql="delete from person where num=?";
		
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
			connect.dbClose(pstmt, conn);
		}
		
		
		
		
	}
	
}
