package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import db.connect.MysqlConnect;
import sawon.data.SawonDto;
import shop.data.ShopDto;

public class AnimalDao {
	MysqlConnect db=new MysqlConnect();
	
	public List<AnimalDto> getAllDatas()
	{
		List<AnimalDto> list=new Vector<AnimalDto>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from animal order by idx";
		
		conn=db.getNaverCloudConnection();//db연결
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(); //select일때만 executequery 반환타입이 rs라서
			
			//rs.next는 데이터가 없으면 false
			while(rs.next())
			{
				//dto를 while밖에 두면 데이터가 똑바로 안들어감
				//여러개 데이터를 가져오는 경우 while문 안에 들어가야함
				AnimalDto dto=new AnimalDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setAniname(rs.getString("aniname"));
				dto.setAnikind(rs.getString("anikind"));
				dto.setAniphoto(rs.getString("aniphoto"));
				dto.setAnimessage(rs.getString("animessage"));
				dto.setAniday(rs.getTimestamp("aniday"));
				
				//dto에 레코드단위 데이터를 다 넣은 후 list에 추가
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	public void insertAnimal(AnimalDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				insert into animal (aniname, anikind, aniphoto, animessage, aniday)
				values(?, ?, ?, ?, now())
				""";
		conn=db.getNaverCloudConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
	
			//바인딩 4개
			pstmt.setString(1, dto.getAniname());
			pstmt.setString(2, dto.getAnikind());
			pstmt.setString(3, dto.getAniphoto());
			pstmt.setString(4, dto.getAnimessage());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	
	public AnimalDto getAnimalName(int idx)
	{
		AnimalDto dto=new AnimalDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from animal where idx=? ";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setInt(1,idx);
			
			//실행
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setIdx(rs.getInt("idx"));
				dto.setIdx(rs.getInt("idx"));
				dto.setAniname(rs.getString("aniname"));
				dto.setAnikind(rs.getString("anikind"));
				dto.setAniphoto(rs.getString("aniphoto"));
				dto.setAnimessage(rs.getString("animessage"));
				dto.setAniday(rs.getTimestamp("aniday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void deleteAnimal(int idx)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				delete from animal where idx=?
				""";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1,idx);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	
	public void updateAnimal(AnimalDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				update animal set aniname=?,anikind=?,aniphoto=?, animessage=?
				where idx=?
				""";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getAniname());
			pstmt.setString(2, dto.getAnikind());
			pstmt.setString(3, dto.getAniphoto());
			pstmt.setString(4, dto.getAnimessage());
			pstmt.setInt(5, dto.getIdx());
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	
}
