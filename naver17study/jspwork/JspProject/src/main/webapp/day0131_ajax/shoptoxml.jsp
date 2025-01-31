<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.connect.MysqlConnect"%>
<%@page import="java.util.Vector"%>
<%@page import="test.data.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
<%
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	List<ShopDto> list=getAllDatas(search);	
	
	MysqlConnect connect=new MysqlConnect();
	public List<ShopDto> getAllDatas(String search)
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
				ShopDto dto=new ShopDto();
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getInt("su"));
				dto.setDan(rs.getInt("Dan"));
				dto.setIpgoday(rs.getString("ipgoday"));
				
				
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
	};
		
	for(ShopDto dto:list)
	{%>
		<shop>
			<snagpum><%=dto.getSang() %></snagpum>
			<su><%=dto.getSu() %></su>
			<dan><%=dto.getDan() %></dan>
			<ipgoday><%=sdf.format(dto.getIpgoday()) %></ipgoday>		
		</shop>
	<%}
%>
</data>
