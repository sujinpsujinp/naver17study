<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet 구구단</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
       body *{
          font-family:'Jua';
       }
       .tab th{
       		background-color:seashell;
       		color:purple ;
       		text-align:center;
       }
  	</style>
</head>
<body>
<h2 class="alert alert-success" align="center">JSTL 구구단</h2>
 <div style="margin: 10px">
 <table class="table table-bordered tab" style="width:85%;">
 <tr>	
 	<c:forEach var="dan" begin="2" end="9" step="1">
		<th>${dan}단</th>
 	</c:forEach>
 </tr>
 	<c:forEach var="i" begin="2" end="9" step="1">
 		<tr align="center">
			<c:forEach var="j" begin="2" end="9" step="1">
				<td>${j}X${i}=${j*i}</td>
 			</c:forEach>
 		</tr>
 	</c:forEach>	
 </div>


</body>
</html>