<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="project1.AnimalDao"%>
<%@page import="project1.AnimalDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
       body *{
          font-family:'Jua';
            }
       h2{
           margin:20px auto;
       	   text-align: center;
        }
  	</style>
  	<script>
  		$(function(){
  			list();
  		});
  		
  		function list()
  		{
  			let s="";
  			
  		}
  	</script>
</head>
<%
	//dao 선언
	AnimalDao dao=new AnimalDao();

	//전체 list 얻기
	List<AnimalDto> list=dao.getAllDatas();
	
	//날짜 포멧 양식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
	
	//출력할 시작번호
	int no=list.size();
%>
<body>
<h2 class="alert alert-success">글 목록</h2>

<div>
	<h6><b>총 <%=list.size() %>개의 글이 있습니다.</b></h6>
	
	<button type="button" class="btn btn-sm btn-outline-success"
	style="float:right;"
	onclick="location.href='./insertanimal.jsp'">
	<i class="bi bi-pencil-fill"></i>등록</button>
	
	<div class="result">
	
	</div>
	
</div>

</body>
</html>