<%@page import="shop.data.ShoprepleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int idx=Integer.parseInt(request.getParameter("idx"));
	ShoprepleDao dao=new ShoprepleDao();
	dao.deleteReple(idx);
%>