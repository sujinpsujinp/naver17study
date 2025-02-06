<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mysql.cj.xdevapi.JsonArray"%>
<%@page import="shop.data.ShoprepleDto"%>
<%@page import="java.util.List"%>
<%@page import="shop.data.ShoprepleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));

	ShoprepleDao dao=new ShoprepleDao();
	
	List<ShoprepleDto> list=dao.getRepleByNum(num);
	
	JSONArray arr=new JSONArray();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	for(ShoprepleDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("idx",dto.getIdx());
		ob.put("num",dto.getNum());
		ob.put("star",dto.getStar());
		ob.put("message",dto.getMessage());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr%>