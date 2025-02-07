<%@page import="project1.AnimalrepleDao"%>
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
	AnimalrepleDao reDao = new AnimalrepleDao();
	List<AnimalDto> list=dao.getAllDatas();
	
	JSONArray arr=new JSONArray();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	for(AnimalDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("idx",dto.getIdx());
		ob.put("aniname",dto.getAniname());
		ob.put("aniphoto",dto.getAniphoto());
		ob.put("anikind",dto.getAnikind());
		ob.put("animessage",dto.getAnimessage());
		ob.put("aniday",sdf.format(dto.getAniday()));
		
		int commentCount = reDao.getCommentCountByIdx(dto.getIdx());
        ob.put("commentCount", commentCount);
		
		arr.add(ob);
	}
%>
<%=arr%>