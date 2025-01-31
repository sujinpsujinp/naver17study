package test.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;
import sawon.data.SawonDto;

public class ShopDao {
	MysqlConnect connect=new MysqlConnect();

	public List<ShopDto> getAllDatas()
	{
		List<ShopDto> list=new Vector<ShopDto>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from shop order by idx";
		
		conn=connect.getConnection();//db연결
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(); //select일때만 executequery 반환타입이 rs라서
			
			//rs.next는 데이터가 없으면 false
			while(rs.next())
			{
				//dto를 while밖에 두면 데이터가 똑바로 안들어감
				//여러개 데이터를 가져오는 경우 while문 안에 들어가야함
				ShopDto dto=new ShopDto();
				dto.setSangpum(rs.getString("sangpum"));
				dto.setSu(rs.getInt("su"));
				dto.setDanga(rs.getInt("Danga"));
				dto.setIpgoday(rs.getTimestamp("ipgoday"));
				
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
}
