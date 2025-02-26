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
       img.large{
       		width: 300px;
       		height: 350px;
       		border: 2px solid black;
       }
       img.small{
       		cursor: pointer;
       		width: 80px;
       		height: 80px;
       		border: 1px solid gray;
       		margin: 10px;
       }
       .colorbox{
       		display: inline-block;
       		width: 30px;
       		height: 30px;
       		border: 1px solid black;
       		border-radius: 100px;
       }
       
       #photoupload{
       		display: none;
       }
       
       .addphoto{
       		font-size: 1.5em;
       		cursor: pointer;
       		margin-left: 10px;
       		margin-right: 10px;
       }
       
       .replelist{
       		margin: 10px 10px;
       }
       .replelist #minphoto{
       		cursor:pointer;
       		width: 50px;
       		height: 50px;
       		margin-right:10px;
       }
       .replelist #message{
       		font-size: 17px;
       }
       .replelist #writetime{
       		font-size: 13px;
       		color:gray;
       }
       likesicon{
        	font-size: 18px;
        	cursor: pointer;
        	color: red;
        }
        
        span.chu{
        	color:#999;
        	font-size: 0.9em;
        }
       .replelist #repledel{
       		font-size: 1.2em;
       }
  	</style>
  	<script type="text/javascript">
  		let file
  		$(function() {
			replelist();//처음 로딩 시 댓글 출력
			
			//카메라 아이콘 이벤트
			$(".addphoto").click(function(){
				$("#photoupload").trigger("click");
			});
			
			//파일 업로드 이벤트
			$("#photoupload").change(function(e) {
				file=e.target.files[0];
				console.log(file);
			})
			
			//댓글 등록 버튼 이벤트
			$("#btnaddreple").click(function(){ 
				let m=$("#message").val();
				
				//댓글 유효성 검사
				if (m==''){
					alert("댓글을 입력해주세요.");
					return;
				} 
				
				if (file==null){
					alert("사진을 선택해주세요.");
					return;
				} 
				let form=new FormData();
     			console.log(file);
     			form.append("upload",file);
     			form.append("message",m);
     			form.append("num",${dto.num});			
				
     			$.ajax({
     				type:"post",
     				dataType:"text",
     				url:"./addreple",
     				data:form,
     				processData:false,
     				contentType:false,
     				success:function(){
     					$("#message").val("");
     					file=null;
     					replelist();
					}
				});
			});
			
			//댓글 삭제 이벤트
			$(document).on("click",".repledel",function(){
				let idx=$(this).attr("idx");
				let pname=$(this).attr("pname");
				console.log(idx);
				if(confirm("해당 댓글을 삭제할까요?")){
					$.ajax({
						type:"get",
						dataType:"text",
						url: "./delreple",
						data: {"idx":idx, "pname":pname},
						success:function(){
							replelist();
						}
					});
				}
			});
			
			//댓글이미지클릭 시 모달에서 보여주기
			$(document).on("click", "#minphoto", function(){
	    		let imgSrc = $(this).attr("src"); // 클릭한 이미지의 경로 가져오기
	    		$(".modalphoto").attr("src", imgSrc); // 모달 내부의 이미지 변경
			});
			
			
			//추천아이콘 클릭시 추천수 증가
     		$(document).on("click",".likesicon",function(){
     			let idx=$(this).attr("idx");
     			let icon=$(this);
     			$.ajax({
     				type:"get",
     				dataType:"json",
     				data:{"idx":idx},
     				url:"./likes",
     				success:function(res){
     					//alert(res.likes);
     					icon.next().find(".likes").text(res.likes);
     				}
     			});
     		});
			
		});
  		
  		function replelist() 
  		{
			let s="";
			$.ajax({
				type:"get",
				dataType:"json",
				data:{"num":${dto.num}},
				url:"./replelist",
				success:function(res){	
					$.each(res,function(idx,ele){
						console.log(res);
						s+=`<span><img src="../save/\${ele.photo}" id="minphoto" data-bs-toggle="modal" data-bs-target="#imgmodal"></span>`;
						s+=`<span id="message">\${ele.message}</span>`;
						s+=`<span id="writetime">\${ele.writetime}</span>`;
						s+=`<span><i class="bi bi-hand-thumbs-up likesicon" idx="\${item.idx}"></i>
						<span class="chu">추천<span class="likes">\${item.likes}</span></span>;
<span><i class="bi bi-trash repledel" idx="\${ele.idx}" pname="\${ele.pname}"></i></span>`;
						s+=`<br><hr>`;
					});	
					$(".replelist").html(s);
					
				}
			});
		}
  		
  		
  	</script>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>

<!-- The Modal -->
<div class="modal" id="imgmodal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">댓글 이미지</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
	   		<img src="" class="modalphoto" style="max-width: 100%; height: auto;">
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
<!-- modal 종료 -->

<div style="margin: 20px;width: 500px;">
 <table>
	<tr>
		<td width="120">
			<c:forTokens var="photo" items="${dto.sphoto }" delims=",">
				<img src="../save/${photo }" class="small">
				
				<script type="text/javascript">
					$("img.small").click(function(){
						$("img.large").attr("src",$(this).attr("src"));
					});
				</script>
			</c:forTokens>
		</td>
		<td>
			<img src="../save/${dto.mainPhoto }" class="large"
			onerror="this.src='../save/noimage.png'">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<div style="margin: 20px 100px; font-size: 17px;">
				<mark>상품명 : ${dto.sangpum}</mark><br>
				가격 : <fmt:formatNumber value="${dto.sprice}" type="number"/><br>
				색상 : ${dto.scolor }
				 <div class="colorbox"
				 style="background: ${dto.scolor}"></div>
				 <br>
				 입고일 : ${dto.ipgoday }<br>
				 등록일 : <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<div class="repleform input-group" style="width: 600px;">
				<input type="text" id="message" class="form-control"
				style="width: 400px;" placeholder="댓글 입력">
				
				<input type="file" id="photoupload">
				<i class="bi bi-camera-fill addphoto"></i>
				<button type="button" class="btn btn-sm btn-info" id="btnaddreple">등록</button>
			</div>
			<hr>
			<div class="replelist">
			
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="button" class="btn btn-sm btn-outline-secondary"
			style="width: 90px;"
			onclick="location.href='./addform'">상품등록</button>
			
			<button type="button" class="btn btn-sm btn-outline-secondary"
			style="width: 90px;"
			onclick="location.href='./list'">목록</button>
			
			<button type="button" class="btn btn-sm btn-outline-secondary"
			style="width: 90px;"
			onclick="location.href='./updateform?num=${dto.num}'">수정</button>
			
			<button type="button" class="btn btn-sm btn-outline-secondary delbtn"
			style="width: 90px;">삭제</button>
			
			<button type="button" class="btn btn-sm btn-outline-secondary"
			style="width: 90px;"
			onclick="location.href='./photos?num=${dto.num}'">사진 수정</button>
			
			<!-- 쌤이 짠 코드
			<button type="button" class="btn btn-sm btn-outline-secondary delbtn"
			style="width: 90px;"
			onclick="sangdel(${dto.num})">삭제</button>
			
			<script>
				function sangdel(num)
				{
					let ans=confirm("해당 게시물을 삭제하려면 [확인] 버튼을 클릭해주세요");
					if(ans){
						location.href="./delete?num="+${dto.num};
					}
				}
			</script>
			 -->
		
		</td>
	</tr>
 </table>
 <script>
 	$(".delbtn").click(function(){
 		if(confirm("삭제하시겠습니까?"))
 			location.href="./delete?num="+${dto.num};
 	});
 </script>
</div>
</body>
</html>
















