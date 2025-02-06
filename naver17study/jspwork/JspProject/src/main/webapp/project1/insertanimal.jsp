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
        #addfrm{
        	width:600px;
        	margin: auto; 
   			display: flex;
    		flex-direction: column;
    		align-items: center;
        }
        #addfrm .title{
        	text-align:center;
        }
        #addfrm i{
        	color:red;
        	font-size: 10px;
        }
  	</style>
  	<script>
  	
  	//상품 등록 버튼 이벤트
	$("#addfrm").submit(function(e){
		e.preventDefault();//기본 이벤트를 무효화(action 호출되는거 X)
		$.ajax({
			type:"get",
			dataType:"html",
			data:$(this).serialize(),
			url:"./insertaniaction.jsp",
			success:function(){
				alert("추가되었습니다");
				//입력값 초기화
				$("#aniname").val("");
				$("#aniphoto").val("");
				$("#animessage").val("");
			}
		});
	});
  	</script>
</head>
<body>
<h2 class="alert alert-success"><i class="bi bi-megaphone-fill"></i>&nbsp;&nbsp;동물 자랑하기&nbsp;&nbsp;<i class="bi bi-megaphone-fill"></i></h2>
<form id="addfrm">
	   	<table class="table table-bordered">
	   		<tr >
	   			<td colspan="2">
	   			 <a><i class="bi bi-asterisk"></i>&nbsp;표시는 필수값 입니다.</a>
	   			</td>
	   		</tr>
			<tr>
				<td class="title">이름<i class="bi bi-asterisk"></i></td>
				<td><input type="text" name="aniname" id="aniname"
				class="form-control"></td>
			</tr>
			<tr>
				<td class="title">사진</td>
				<td><form action="./aniphoto.jsp" method="POST" enctype="multipart/form-data">
            	<!-- accept속성 : 파일선택기에 해당하는 파일타입만 보이도록 -->
            	<input type="file" id="aniphoto" name="aniphoto" accept="image/jpg"><br>
            	</td>
        </form>
				
			</tr>
			<tr>
				<td class="title">종류</td>
				<td>
				 <select id="anikind" name="anikind" class="form-select">
				  <option selected hidden disabled>종류를 선택하세요.</option>
				  <option value="강아지">강아지</option>
				  <option value="고양이">고양이</option>
				  <option value="달팽이">달팽이</option>
				  <option value="도마뱀">도마뱀</option>
				  <option value="고슴도치">고슴도치</option>
				  <option value="햄스터">햄스터</option>
				  <option value="새">새</option>
				 </select>
				</td>
			</tr>
			<tr>
				<td class="title">내용<i class="bi bi-asterisk"></i></td>
				<td><input type="text" name="animessage" id="animessage"
				class="form-control" ></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button type="submit" data-bs-dismiss="modal"
				class="btn btn-success addshop" >등록하기</button>
				<button type="button" data-bs-dismiss="modal"
				class="btn btn-success"
				onclick="history.back()">뒤로가기</button>
				</td>
			</tr>
		</table>
	   </form>
</body>
</html>