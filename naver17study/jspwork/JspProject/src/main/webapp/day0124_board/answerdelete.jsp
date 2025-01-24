<%@page import="simpleboard.data.SimpleAnswerDao"%>
<%@page import="javax.swing.text.SimpleAttributeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. idx,num 읽기
	int idx=Integer.parseInt(request.getParameter("idx"));
	int num=Integer.parseInt(request.getParameter("num"));
	
	//2. dao 선언
	SimpleAnswerDao adao=new SimpleAnswerDao();
	
	//3. 댓글 삭제 메서드 호출
	adao.deleteAnswer(idx);
	
	//4. 상세페이지로 이동
	response.sendRedirect("./contentdetail.jsp?num="+num+"&idx="+idx);
%>

