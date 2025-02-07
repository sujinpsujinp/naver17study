<%@page import="project1.AnimalDao"%>
<%@page import="project1.AnimalDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String aniname=request.getParameter("aniname");
	String aniphoto=request.getParameter("aniphoto");
	String anikind=request.getParameter("anikind");
	String animessage=request.getParameter("animessage");
	
	AnimalDto dto=new AnimalDto();
	dto.setAniname(aniname);
	dto.setAnikind(anikind);
	dto.setAniphoto(aniphoto);
	dto.setAnimessage(animessage);

	AnimalDao dao=new AnimalDao();
	dao.insertAnimal(dto);
%>
<data>
	<result><%=aniname %>을 DB에 추가했습니다</result>
</data>