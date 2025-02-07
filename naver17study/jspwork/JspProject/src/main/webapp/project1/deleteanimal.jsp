<%@page import="project1.AnimalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. idx읽기
	int idx=Integer.parseInt(request.getParameter("idx"));
	
	//2. dao 선언
	AnimalDao dao=new AnimalDao();
	
	//3. 삭제메서드 호출(deleteShop(int num))
	dao.deleteAnimal(idx);
	
%>