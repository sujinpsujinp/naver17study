<%@page import="org.json.simple.JSONObject"%>
<%@page import="project1.AnimalrepleDao"%>
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="project1.AnimalreplDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int idx=Integer.parseInt(request.getParameter("idx"));

	AnimalrepleDao dao=new AnimalrepleDao();
	
	List<AnimalreplDto> list=dao.getRepleByIdx(idx);
	
	JSONArray arr=new JSONArray();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	for(AnimalreplDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("num",dto.getNum());
		ob.put("idx",dto.getIdx());
		ob.put("nickname",dto.getNickname());
		ob.put("replemessage",dto.getReplemessage());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr%>