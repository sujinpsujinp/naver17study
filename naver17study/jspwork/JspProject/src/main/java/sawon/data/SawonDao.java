package sawon.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class SawonDao {
	MysqlConnect connect=new MysqlConnect();
	
	public List<SawonDto> getAllDatas()
	{
		List<SawonDto> list=new Vector<SawonDto>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from sawon order by num";
		
		conn=connect.getConnection();//db연결
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(); //select일때만 executequery 반환타입이 rs라서
			
			//rs.next는 데이터가 없으면 false
			while(rs.next())
			{
				//dto를 while밖에 두면 데이터가 똑바로 안들어감
				//여러개 데이터를 가져오는 경우 while문 안에 들어가야함
				SawonDto dto=new SawonDto();
				dto.setNum(rs.getInt("num"));
				dto.setSname(rs.getString("sname"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setIpsaday(rs.getString("ipsaday"));
				dto.setSbirth(rs.getInt("sbirth"));
				dto.setSblood(rs.getString("sblood"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//dto에 레코드단위 데이터를 다 넣은 후 list에 추가
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		return list;
	}

	public void insertSawon(SawonDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				insert into sawon (sname,sphoto,ipsaday,sbirth,sblood,writeday)
				values(?,?,?,?,?,now())
				""";
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩 5개
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getSphoto());
			pstmt.setString(3, dto.getIpsaday());
			pstmt.setInt(4, dto.getSbirth());
			pstmt.setString(5, dto.getSblood());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(pstmt, conn);
		}
		
		
	}

	public SawonDto getSawon(String num)
	{
		SawonDto dto=new SawonDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from sawon where num=?";
		
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setSname(rs.getString("sname"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setIpsaday(rs.getString("ipsaday"));
				dto.setSbirth(rs.getInt("sbirth"));
				dto.setSblood(rs.getString("sblood"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	
	
	
	
}
