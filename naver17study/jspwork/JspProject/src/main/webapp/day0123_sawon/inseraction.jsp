<%@page import="sawon.data.SawonDao"%>
<%@page import="sawon.data.SawonDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//폼데이터를 읽는다
	String sname=request.getParameter("sname");
	String sphoto=request.getParameter("sphoto");
	String ipsaday=request.getParameter("ipsaday");
	String sblood=request.getParameter("sblood");
	int sbirth=Integer.parseInt(request.getParameter("sbirth"));
	
	//dto에 넣는다
	SawonDto dto=new SawonDto();
	dto.setSname(sname);
	dto.setSbirth(sbirth);
	dto.setSblood(sblood);
	dto.setSphoto(sphoto);
	dto.setIpsaday(ipsaday);
	
	//dao 선언
	SawonDao dao=new SawonDao();
	
	//insert 메서드 호출
	dao.insertSawon(dto);
	
	//목록 이동
	response.sendRedirect("./sawonlist.jsp");
	//redirect는 주소가 바뀜

%>