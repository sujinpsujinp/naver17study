package day0107db;
//Db관리하는 곳

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class FoodModel {
	MysqlConnect mysqlConnect=new MysqlConnect();

	//메뉴 insert 하는 메서드
	public void foodMenuInsert(String foodName,int foodprice,String foodSize)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into foodrest (foodName,foodPrice,foodSize) values (?,?,?)";
		
		conn=mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,foodName);
			pstmt.setInt(2, foodprice);
			pstmt.setString(3, foodSize);
			
			//실행
			pstmt.execute();//반환값 받을게 없어서 그냥 execute
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}
	
	//전체 메뉴 반환하는 메서드
	public List<Vector<String>> getAllMenus()
	{
		List<Vector<String>> list=new Vector<Vector<String>>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from foodrest order by num";
		
		conn=mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				//벡터에서 데이터를 받아서 다시 벡터에 넣음
				data.add(rs.getString("num"));
				data.add(rs.getString("foodname"));
				data.add(rs.getString("foodprice"));
				data.add(rs.getString("foodsize"));
				
				list.add(data);//벡터에 담은 데이터를 다시 리스트에 담음
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
		return list;
	}

	//예약데이터 insert
	public void foodOrderInsert(FoodOrderDto dto)
	{
		//Connection conn=mysqlConnect.getConnection();
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into foodorder (num,ordername,ordercnt,bookingday) values (?,?,?,?)";

		conn=mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1,dto.getNum());
			pstmt.setString(2,dto.getOrderName());
			pstmt.setInt(3,dto.getOrderCnt());
			pstmt.setString(4,dto.getBookingDay());
			
			//실행
			pstmt.execute();//반환값 받을게 없어서 그냥 execute

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}
	
	//전체 예약데이터 반환하는 메서드
	public List<Vector<String>> getAllOrders()
	{
		List<Vector<String>> list=new Vector<Vector<String>>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select 
					idx,ordername,foodname,foodprice,
					foodsize,ordercnt,bookingday
				from foodrest fr, foodorder fo
				where fr.num=fo.num
				order by idx
				""";

		conn=mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				//벡터에서 데이터를 받아서 다시 벡터에 넣음
				data.add(rs.getString("idx"));
				data.add(rs.getString("ordername"));
				data.add(rs.getString("foodname"));
				data.add(rs.getString("foodprice"));
				data.add(rs.getString("foodsize"));
				data.add(rs.getString("ordercnt"));
				data.add(rs.getString("bookingday"));

				list.add(data);//벡터에 담은 데이터를 다시 리스트에 담음
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	//등록메뉴 삭제
	public void deleteFoodMenu(int num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from foodrest where num=?";
		
		conn=mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1,num);

			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}

	//예약자 삭제
	public void deleteOrder(int idx)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from foodorder where idx=?";
		
		conn=mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1,idx);

			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}
	
	//등록메뉴를 예약한 건수 반환
	public int getOrderMenuCount(int num)
	{
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) count from foodorder where num=?";
		
		conn=mysqlConnect.getConnection();
		
		//count를 얻어서 cnt에 넣어주면 됨
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			if(rs.next())
				cnt=rs.getInt("count");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
		return cnt;
	}
	
}
