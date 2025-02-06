<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="project1.AnimalDto"%>
<%@page import="java.util.List"%>
<%@page import="project1.AnimalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AnimalDao dao=new AnimalDao();
	List<AnimalDto> list=dao.getAllDatas();
	
	JSONArray arr=new JSONArray();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	for(AnimalDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("idx",dto.getIdx());
		ob.put("aniname",dto.getAniname());
		ob.put("anikind",dto.getAnikind());
		ob.put("aniphoto",dto.getAniphoto());
		ob.put("animessage",dto.getAnimessage());
		ob.put("aniday",sdf.format(dto.getAniday()));
		
		arr.add(ob);
	}
%>
<%=arr%>