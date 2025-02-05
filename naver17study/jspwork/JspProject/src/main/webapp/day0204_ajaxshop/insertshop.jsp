<?xml version="1.0" encoding="UTF-8"?>
<%@page import="shop.data.ShopDao"%>
<%@page import="shop.data.ShopDto"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sangpum=request.getParameter("sangpum");
	String scolor=request.getParameter("scolor");
	String ipgoday=request.getParameter("ipgoday");
	String sphoto=request.getParameter("sphoto");
	int sprice=Integer.parseInt(request.getParameter("sprice"));
	int scnt=Integer.parseInt(request.getParameter("scnt"));
	
	ShopDto dto=new ShopDto();
	dto.setSangpum(sangpum);
	dto.setScolor(scolor);
	dto.setSprice(sprice);
	dto.setScnt(scnt);
	dto.setIpgoday(ipgoday);
	dto.setSphoto(sphoto);
	
	ShopDao dao=new ShopDao();
	dao.insertShop(dto);
%>
<data>
	<result><%=sangpum %>을 DB에 추가했습니다</result>
</data>