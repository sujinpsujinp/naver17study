<%@page import="shop.data.ShoprepleDao"%>
<%@page import="shop.data.ShoprepleDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	int star=Integer.parseInt(request.getParameter("star"));
	String message=request.getParameter("message");
	
	ShoprepleDto dto=new ShoprepleDto(num,star,message);
	
	ShoprepleDao dao=new ShoprepleDao();
	dao.insertReple(dto);
%>
