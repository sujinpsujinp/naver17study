<%@page import="project1.AnimalrepleDao"%>
<%@page import="project1.AnimalreplDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int idx=Integer.parseInt(request.getParameter("idx"));
	String nickname=request.getParameter("nickname");
	String replemessage=request.getParameter("replemessage");
	
	AnimalreplDto dto=new AnimalreplDto(idx,nickname, replemessage);
	
	AnimalrepleDao dao=new AnimalrepleDao();
	dao.insertReple(dto);
%>