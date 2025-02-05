<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="memo.data.MemoDao"%>
<%@page import="memo.data.MemoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//검색 닉네임 읽기
	String nickname=request.getParameter("nickname");

	MemoDao dao=new MemoDao();
	List<MemoDto> list=dao.getSearchMemos(nickname);
	
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