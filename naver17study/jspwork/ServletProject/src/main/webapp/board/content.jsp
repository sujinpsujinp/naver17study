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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
       body *{
          font-family:'Jua';
       }
       
       .day{
       		color:gray;
       		font-size: 13px;
       }
       .smallphoto{
       		width: 40px;
       		height:40px;
       		border:1px solid gray;
       		border-radius: 100px;
       		border-right: 10px;
       		cursor: pointer;
       }
  	</style>
  	<script type="text/javascript">
  		$(function() {
			$(".btn").addClass("btn-sm btn-outline-secondary").css("width","100px");
		});
  	</script>
</head>
<body>
<!-- The Modal -->
<div class="modal" id="imgmodal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">프로필 이미지</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
	   		<img src="${dto.photo}" class="photo">
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>


	<div style="margin: 20px;width: 600px;">
		<h1><b>${dto.subject}</b></h1>
		<div>
			<img src="${dto.photo }" class="smallphoto" align="left" data-bs-toggle="modal" data-bs-target="#imgmodal">
			<span>${dto.writer}</span><br>
			<span class="day">
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd"/>
				&nbsp;&nbsp;&nbsp;
				조회 ${dto.readcount}
			</span>
		</div>
		<hr>
		<pre style="font-size:17px;">${dto.content}</pre>
		<div style="margin-top:50px;">
			<button type="button" class="btn"
			onclick="location.href='./writeform'">글쓰기</button>
			
			<button type="button" class="btn"
			onclick="location.href='./list'">목록</button>
			
			<button type="button" class="btn"
			onclick="location.href='./writeform?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}'">답글</button>
			
			<button type="button" class="btn"
			onclick="location.href='./updateform?num=${dto.num}'">수정</button>
			
			<button type="button" class="btn"
			onclick="location.href='./deletepassform?num=${dto.num}'">삭제</button>
		</div>
	</div>
</body>
</html>