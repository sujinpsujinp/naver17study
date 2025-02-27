<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

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
       div .smallphoto{
       		width: 40px;
       		height:40px;
       		border:1px solid gray;
       		border-radius: 100px;
       		border-right: 10px;
       }
       .day{
       		color:gray;
       		font-size: 13px;
       }
  	</style>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<c:if test="${sessionScope.loginstatus==null}">
	<script>
		alert("회원게시판입니다\n먼저 로그인을 해주세요");
		history.back();
	</script>
</c:if>

<div style="margin: 30px;">
		<h3><b>${dto.subject}</b></h3>
		<div>
		<img src="${naverurl}/member/${memberPhoto}" class="smallphoto" align="left"
				onerror="this.src='../save/noimage.png'">
			<span>${dto.writer}</span><br>
			<span class="day">
				<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/>
				&nbsp;&nbsp;&nbsp;
				조회 ${dto.readcount}
			</span>
		</div>
		<pre style="margin-top:30px; font-size:17px;">${dto.content}</pre>
		<div style="margin-top: 30px;">
			<c:forEach var="photo" items="${dto.photos}">
				<img src="${naverurl}/board/${photo}" style="max-width: 300px;">
			</c:forEach>
		</div>
		
		
		<div style="margin-top:50px;">
			<button type="button" class="btn btn-success btn-sm" style="width: 80px;"
			onclick="location.href='./writeform'"><i class="bi bi-pencil-fill"></i>글쓰기</button>
			
			<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
			onclick="location.href='./writeform?idx=${dto.idx}&regroup=${dto.regroup }&restep=${dto.restep}&relevel=${dto.relevel}&pageNum=${pageNum}'">답글</button>
			
			<c:if test="${sessionScope.loginid==dto.myid}">
			<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
			onclick="location.href='./updateform?idx=${dto.idx}&pageNum=${pageNum}'">수정</button>
			
			
			<button type="button" class="btn btn-outline-secondary btn-sm"  style="width: 80px;"
			onclick="delete?idx=${dto.idx}?pageNum=${pageNum}">삭제</button>
			</c:if>
			
			<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;margin-left: 50px;"
			onclick="location.href='./list?pageNum=${pageNum}'">목록</button>
		</div>

</body>
</html>











