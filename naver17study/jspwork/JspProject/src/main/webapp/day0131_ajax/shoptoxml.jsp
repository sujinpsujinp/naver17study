<?xml version="1.0" encoding="UTF-8"?>
<%@page import="test.data.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="test.data.ShopDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
<%
	//dao 파일을 만들지 않고 하는 방법이 있을텐데.. 그걸 모루겠어...
	ShopDao dao=new ShopDao();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	List<ShopDto> list=dao.getAllDatas();	
	
	
	for(ShopDto dto:list)
	{%>
		<shop>
			<snagpum><%=dto.getSangpum() %></snagpum>
			<su><%=dto.getSu() %></su>
			<dan><%=dto.getDanga() %></dan>
			<ipgoday><%=sdf.format(dto.getIpgoday()) %></ipgoday>		
		</shop>
	<%}
%>
</data>
