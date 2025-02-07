<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="project1.AnimalDao"/>
<jsp:useBean id="dto" class="project1.AnimalDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
	dao.updateAnimal(dto);
%>