<%@page import="project1.AnimalrepleDao"%>
<%@page import="project1.AnimalreplDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	AnimalrepleDao dao=new AnimalrepleDao();
	dao.deleteReple(num);
%>