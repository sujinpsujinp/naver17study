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
       
       #fileupload{
       		display: none;
       }
       .replecamera{
       		margin-left:30px;
       		font-size: 22px;
       		cursor: pointer;
       }
       .replephoto img{
       		margin:10px;
       		width: 40px;
       		height: 40px;
       		border: 1px solid black;
       		border-radius: 10px;
       }
       .replephotodel{
        	cursor: pointer;
        	position:relative;
        	left: -20px;
        	color:red;
        }
        .profile{
        	width: 30px;
        	height: 30px;
        	border: 1px solid gray;
        	border-radius: 10px;
        	margin-right: 10px;
        }
        .replelist .day{
        	color: #bbb;
        	font-size: 0.9em;
        	margin-left: 20px;
        	margin-right: 20px;
        }
        .replelist .photo{
        	width: 100px;
        	height: 100px;
        	border-radius: 100%;
        }
        .replelist .repledel,.edticon{
        	color:red;
        	cursor: pointer;
        	font-size: 17px;
        }
  	</style>
  	<script type="text/javascript">
  		
  		$(function () {
			replelist();
			
			//카메라 아이콘 이벤트
     		$(".replecamera").click(function(){
     			$("#fileupload").trigger("click");
     		});
     		
     		$("#fileupload").change(function(e){
				let form=new FormData();
				form.append("upload",e.target.files[0]);
				$.ajax({
					type:"post",
					dataType:"text",
					data:form,
					processData:false,
					contentType:false,
					url:"./repleupload",
					success:function(res){
						$(".replephoto").html(`
								<img src="${naverurl}/board/\${res}">
								<i class="bi bi-x-circle-fill replephotodel" fname="\${res}"></i>`);
					}
				});
			});
			     		
     		$(document).on("click",".replephotodel",function(){
				let close=$(this);//x 아이콘
				let fname=close.attr("fname");
				$.ajax({
					type:"get",
					dataType:"text",
					data:{"fname":fname},
					url:"./replephotodel",
					success:function(){
						close.prev().remove();//x아이콘 바로 앞의 사진 삭제
						close.remove();//자기 자신인 x아이콘도 삭제
					}
				});
			});
     		
     		//댓글 저장
     		$("#btnreplesave").click(function() {
				let idx=${dto.idx};
				let m=$("#message").val();
				
				$.ajax({
					type:"get",
					dataType:"text",
					data:{"idx":idx,"message":m},
					url:"./addreple",
					success:function(){
						//댓글 추가 성공 후 초기화
						$("#message").val();
						$(".replephoto").html("");
						
						//추가 성공 후 댓글 목록 다시 출력
						alert("댓글 저장 성공");
						replelist();
					}
				});
			});
     		
     		 //미니 댓글 사진 클릭시 원본사진 보기
     		$(document).on("click", ".photo", function () {
    			let imgSrc = $(this).attr("src");
    			$("#photoModal .replelarge").attr("src", imgSrc);
    			$("#photoModal").modal("show");
			});
     		
     		//댓글 삭제
     		$(document).on("click",".repledel",function(){
     			let num=$(this).attr("num");
     			console.log("삭제할 댓글 번호:", num);
     			let ans=confirm("해당 댓글을 삭제할까요?");
     			 if(!ans) return;//취소 클릭시 함수 종료
     			
     			$.ajax({
     				type:"get",
     				dataType:"text",
     				data:{"num":num},
     				url:"./repledel",
     				success:function(){
     					//댓글 삭제후 전체 댓글 다시 출력
     					replelist();
     				}
     			});  
     		});
     		    		
     		//댓글 수정 이벤트
     		 $(document).on("click", ".updatebtn", function () {
     			let num=$(this).attr("num");
				let m=$("#message").val();
				
				let form=new FormData();
				form.append("num",num);
				form.append("message",m);
				
				$.ajax({
					type:"post",
					dataType:"text",
					data:form,
					processData:false,
					contentType:false,
					url:"./updatereple",
					success:function(){
						//추가 성공 후 댓글 목록 다시 출력
						alert("댓글 수정 성공");
						replelist();
					}
				}); 
			});

		});
  		
  		function replelist()
  		{
  			//console.log("idx 값 확인: ", ${dto.idx});
  			$.ajax({
     			type:"get",
     			dataType:"json",
     			data:{"idx":${dto.idx}},
     			url:"./replelist",
     			success:function(res){
     				let s="";
     				
     				$.each(res,function(i,item){
     					s+=`
     						<img src="${naverurl}/member/\${item.profilePhoto}" class="profile">
     						<b>\${item.writer}</b><span class="day">\${item.writeday}</span>
     						<i class="bi bi-trash-fill repledel" num="\${item.num}"></i>
     						<i class="bi bi-pencil-fill edticon" num="\${item.num}"
     							data-bs-toggle="modal" data-bs-target="#editRepleModal"></i>
     					 <div class="item" style="margin:5px;">
     						<pre style="font-size:15px;">\${item.message}</pre>
     						<br>`;
     						
     					if(item.photo!=null)	
     						s+=`<img src="${naverurl}/board/\${item.photo}" class="photo"
     							data-bs-toggle="modal" data-bs-target="#photoModal"><br><br>`;	
 				
     					s+=`</div>`;
     				});     				
     				$(".replelist").html(s);
     			}
     		}); 
  		}
  	</script>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<c:if test="${sessionScope.loginstatus==null}">
	<script>
		alert("회원게시판입니다\n먼저 로그인을 해주세요");
		history.back();
	</script>
</c:if>

<!-- 이미지 모달 -->
<div class="modal" id="photoModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">원본사진</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <img src="" class="replelarge" style="width: 100%;">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- 댓글 수정 모달 -->
<div class="modal" id="editRepleModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">댓글 수정</h4>
        <button type="button" id="editMessage" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <textarea style="width: 100%;" class="form-control ">\${message}</textarea>
         <button type="submit" class="btn btn-success updatebtn" num="\${dto.num}" data-bs-dismiss="modal">저장</button>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


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
		
		<!-- 댓글 영역 -->
		<div style="margin-top: 30px;width: 500px;border: 1px solid gray;">
			<h5 style="margin-left: 10px;">${writer}</h5>
			<textarea type="text" id="message" class="form-control" placeholder="댓글을 입력하세요"></textarea>
			<br class="replephoto">
			<div>
			
			<input type="file" id="fileupload">
			<i class="bi bi-camera replecamera"></i>	
			
			<button type="button" class="btn btn-sm btn-outline-success" id="btnreplesave"
			style="float: right;margin-right: 10px;">저장</button>
		</div>
		</div>
		<div class="replelist" style="width: 500px;margin: 20px;">
				
		</div>
		<!-- 댓글 영역 종료 -->
		
		
		
		<div style="margin-top:50px;">
			<button type="button" class="btn btn-success btn-sm" style="width: 80px;"
			onclick="location.href='./writeform'"><i class="bi bi-pencil-fill"></i>글쓰기</button>
			
			<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
			onclick="location.href='./writeform?idx=${dto.idx}&regroup=${dto.regroup }&restep=${dto.restep}&relevel=${dto.relevel}&pageNum=${pageNum}'">답글</button>
			
			<c:if test="${sessionScope.loginid==dto.myid}">
			<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
			onclick="location.href='./updateform?idx=${dto.idx}&pageNum=${pageNum}'">수정</button>
			
			
			<button type="button" class="btn btn-outline-secondary btn-sm"  style="width: 80px;"
			onclick="boarddel()">삭제</button>
			
			 <script type="text/javascript">
			 
			 	function boarddel()
			 	{
			 		//삭제할지 물어보고 확인 누르면 목록으로 이동하기(pageNum 전달)
			 		let ans=confirm("정말 삭제하시겠습니까?");
			 		if(ans){
			 		$.ajax({
			 			type:"get",
			 			dataType:"text",
			 			data:{"idx":${dto.idx}},
			 			url:"./delete",
			 			success:function()
			 			{
			 				alert("삭제되었습니다");
			 				location.href="./list?pageNum="+${pageNum};
			 			}
			 		});
			 	  }
			 	}
			 
			 </script>
			</c:if>
			
			<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;margin-left: 50px;"
			onclick="location.href='./list?pageNum=${pageNum}'">목록</button>
		</div>
</body>
</html>

