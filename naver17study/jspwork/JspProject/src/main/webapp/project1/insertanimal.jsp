<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록하자</title>
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
  	
  	$(function(){
		
  		$("#addfrm").submit(function(e){
  			//기본 이벤트를 무효화(action 호출되는거 X)
  			e.preventDefault();
			
  			let isValid = true;
  	        
  	        // 이름 유효성 검사
  	        if ($("#aniname").val().trim() == "") {
  	            $("#nameError").show();
  	            isValid = false;
  	        } else {
  	            $("#nameError").hide();
  	        }
  	        
  	        // 내용 유효성 검사
  	        if ($("#animessage").val().trim() == "") {
  	            $("#messageError").show();
  	            isValid = false;
  	        } else {
  	            $("#messageError").hide();
  	        }
  	        
  	        if (!isValid) {
  	            return;
  	        }
  			
			// anikind 값이 선택되지 않았다면 강아지로 설정
			if ($("#anikind").val() == null) {
	            $("#anikind").val("강아지");
	        }
			
			if($("#aniname").val() == null){
				alert("이름이 입력하지 않았습니다");
			}else if($("#animessage").val() == null){
				alert("내용이 입력되지 않았습니다");
			}
			
			$.ajax({
				type:"post",
				dataType:"html",
				data:$(this).serialize(),
				url:"./insertanimalaction.jsp",
				success:function(){
					alert("추가되었습니다");
					//입력값 초기화
					$("#aniname").val("");
					$("#aniphoto").val("");
					$("#animessage").val("");
				}
			});
  		});
			// 목록보기 버튼 클릭 시 페이지 이동
		    $(".btnshowlist").click(function(){
		        location.href = "./animallist.jsp";
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
				class="form-control">
				<span id="nameError" style="color: red; font-size: 12px; display: none;">이름을 입력하세요.</span>
				</td>
			</tr>
			<tr>
				<td class="title">사진</td>
				<td>
            		<select id="aniphoto" name="aniphoto" class="form-select">
						 <script>
						  for(let i=1;i<24;i++){
						        let s = `<option value="../image/project1/\${i}.jpg">동물 \${i}</option>`;
						        document.write(s);
						  }  
						  </script>
					 </select>
					 <br>
					<img src="" class="animalphoto" width="100">
					
					<script type="text/javascript">
						$(".animalphoto").attr("src",$("#aniphoto").val());
						
						//이벤트
						$("#aniphoto").change(function(){
							$(".animalphoto").attr("src",$(this).val());
						});
					</script>
            	</td>
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
				  <option value="뱀">뱀</option>
				 </select>
				</td>
			</tr>
			<tr>
				<td class="title">내용<i class="bi bi-asterisk"></i></td>
				<td><input type="text" name="animessage" id="animessage"
				class="form-control" >
				<span id="messageError" style="color: red; font-size: 12px; display: none;">내용을 입력하세요.</span>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button type="button" data-bs-dismiss="modal"
				class="btn btn-success"
				onclick="history.back()">뒤로가기</button>
				<button type="submit" data-bs-dismiss="modal"
				class="btn btn-success addshop" >등록하기</button>
				<button type="button"
				class="btn btn-success btnshowlist">목록보기</button>
				</td>
			</tr>
		</table>
	   </form>
</body>
</html>