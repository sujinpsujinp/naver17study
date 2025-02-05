<%@page import="org.json.simple.JSONObject"%>
<%@page import="memo.data.MemoDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="memo.data.MemoDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemoDao dao=new MemoDao();
	List<MemoDto> list=dao.getAllMemos();
	
	JSONArray arr=new JSONArray();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM");
	
	for(MemoDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("idx", dto.getIdx());
		ob.put("nickname", dto.getNickName());
		ob.put("avata",dto.getAvata());
		ob.put("message", dto.getMessage());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr%>