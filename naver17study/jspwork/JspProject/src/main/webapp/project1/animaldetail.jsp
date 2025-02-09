<%@page import="java.text.SimpleDateFormat"%>
<%@page import="project1.AnimalDto"%>
<%@page import="project1.AnimalDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<%
	//1. num읽기
	int idx=Integer.parseInt(request.getParameter("idx"));
	
	//2.dao 선언
	AnimalDao dao=new AnimalDao();
	
	//3. num에 해당하는 dto(dao에 메서드 추가해야함
	AnimalDto dto=dao.getAnimalName(idx);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
    <style>
       body *{
          font-family:'Jua';
            }
            
        h5{
        	margin:20px auto;
       	   text-align: center;
       	   width: 700px;
        }
       .tabdetail{
       		margin:30px auto;
        	width:700px;
        	border:1px solid #ddd;
        	padding:10px;
       }
       .tabdetail td{
       		border: solid 1px gray;
       }
            
        .tabdetail img {
    		width: 300px;
    		margin:10px;
    		border-radius: 10px;
		}
		.tabbutton, .tabreple{
			margin:30px auto;
			width:700px;
		}
		.replelist .day{
       		margin:20px;
       		font-size:13px;
       		color: gray;
       }
       
       .replelist i:hover{
       		margin: 12px;
       		color:red;
       		cursor: pointer;
     		font-size: 20px;
       }
	
  	</style>
  	<script>
  	
  	$(function() {
		list();
		
		//상세 수정 버튼 이벤트
		$("#updatefrm").submit(function(e){
			e.preventDefault();//기본 이벤트를 무효화(action 호출되는거 X)
	 		//폼단위 데이터 모두 얻기
	 		let d=$(this).serialize();
	 		//alert(d);
	 		$.ajax({
	 			type:"get",
	 			dataType:"html",
	 			data:d,
				url:"./updateanimall.jsp",
				success:function(res)
				{				
					//수정 성공 후 새로고침
					location.reload();
				}
			});
		});
		
		//상세 삭제버튼 이벤트
		$("#btndelete").click(function(){
	 		//confirm으로 물어보고 [확인]을 누르면 삭제
	 		let ans=confirm("지금 보고있는 글을 삭제합니다");
			//ajax 함수를 이용해서 한다
	 		
	 		//data로는  num을 보낸다
	 		//success에서 목록을 보낸다(location.href)
	 		if(ans){
	 			$.ajax({
					type:"get",
					dataType:"html",
					data:{"idx":<%=idx%>},
					url:"./deleteanimal.jsp",
					success:function(res)
					{
						location.href="./animallist.jsp";
					}
				});
	 		}
	 	});
		
		//댓글 등록 버튼
		$("#btnreple").click(function() {
			let idx=<%=idx%>;
			let nick=$("#nickname").val();
			let mes=$("#replemessage").val();
			
			let isValid = true;
  	        
  	        // 닉네임 유효성 검사
  	        if ($("#nickname").val().trim() == "") {
  	            $("#nicknameError").show();
  	            isValid = false;
  	        } else {
  	            $("#nicknameError").hide();
  	        }
  	        
  	        // 댓글 유효성 검사
  	        if ($("#replemessage").val().trim() == "") {
  	            $("#repleError").show();
  	            isValid = false;
  	        } else {
  	            $("#repleError").hide();
  	        }
  	        
  	        if (!isValid) {
  	            return;
  	        }
			
			
			$.ajax({
				type:"get",
				dataType:"html",
				data:{"idx":idx,"nickname":nick,"replemessage":mes},
				url:"./insertreple.jsp",
				success:function(){
					//상품평 등록 후 목록 다시 출력
					list();
					
					//입력값 초기화
					$("#nickname").val("");
					$("#replemessage").val("");
				}
			});
		});
		
		//상품평 삭제 이벤트
		$(document).on("click","span.close",function(){
			let num=$(this).attr("num");
			if(confirm("해당 댓글을 삭제할까요?")){
				$.ajax({
					type:"get",
					dataType:"html",
					data:{"num":num},
					url:"./deletereple.jsp",
					success:function(){
						list();
					}
				});
			}
		});
		
	});
  	
  	function list()
  	{
  		let s="";
		$.ajax({
			type:"get",
			dataType:"json",
			data:{"idx":<%=idx%>},
			url:"./listreple.jsp",
			success:function(res){
				let n=$(res).length;
				$(".replelist>b").text("총"+n+"개");
				//상품평 목록 출력
				
				$.each(res,function(idx,ele){
					//class로 star
					s+=`<span>\${ele.nickname}</span>`;
					s+=`<span class="day">\${ele.writeday}</span>`;
					s+="<br>"
					s+=`<span>\${ele.replemessage}&nbsp;&nbsp;</span>`;
					s+=`<span class="close" num="\${ele.num}" ><i class="bi bi-trash" style="font-size: 20px;margin: 12px;"></i></span>`;
					s+="<br>"
				});
				$(".replelist div").html(s);
			}
			
		});
  	}
	</script>
  	
</head>
<body>
<!-- The Modal -->
<div class="modal" id="updatemodal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <!-- 이번에 수정은 폼단위로 값을 얻어보자 -->
	   <form id="updatefrm">
	   <!-- hidden -->
	   <input type="hidden" name="idx" value="<%=idx %>">
	   
	   	<table class="table table-bordered">
	   		<tr>
				<td>이름</td>
				<td><input type="text" name="aniname" id="aniname"
				class="form-control" value="<%= dto.getAniname()%>"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td>
				<select id="aniphoto" name="aniphoto" class="form-select">
						  <script>
						  	for(let i=1;i<24;i++){
						  		let s="";
						  		let aniphoto=`../image/project1/\${i}.jpg`;
						  		let dbphoto="<%=dto.getAniphoto()%>";
						  		if(aniphoto==dbphoto)
						  			s=`<option value='\${aniphoto}' selected>동물 \${i}</option>`;
						  		else
						  			s=`<option value='\${aniphoto}'>상품 \${i}</option>`;
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
				<td>종류</td>
				<td>
				 <select id="anikind" name="anikind" class="form-select">
                     <option value="" selected hidden disabled>종류를 선택하세요.</option>
                     <%
                         String[] kinds = {"강아지", "고양이", "달팽이", "도마뱀", "고슴도치", "햄스터", "새", "뱀"};
                         for (String kind : kinds) {
                             if (kind.equals(dto.getAnikind())) {
                                 out.print("<option value='" + kind + "' selected>" + kind + "</option>");
                             } else {
                                 out.print("<option value='" + kind + "'>" + kind + "</option>");
                             }
                         }
                     %>
                 </select>
				 </td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="animessage" id="animessage"
				class="form-control" value="<%=dto.getAnimessage()%>"></td>
			</tr>
			<tr>
			 <td colspan="2" align="center">
			  <button type="submit" data-bs-dismiss="modal"
			  class="btn btn-sm btn-success " >수정하기</button>
			 </td>
			</tr>
		</table>
	   </form>
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>


<h5 class="alert alert-warning" style="text-align:center;width:700px" >
[<%=dto.getAniname() %>]  상세</h5>

<table class="tabdetail">
 	<tr>
 		<td rowspan="4" width="350px">
 			<img src="<%=dto.getAniphoto() %>">
 		</td>
	</tr>
 	<tr>
 		<td style="text-align: center;">이름</td> 
 		<td><%=dto.getAniname() %></td>
 	</tr>
 	<tr>
 		<td style="text-align: center;">등록일</td>
 		<td><%= sdf.format(dto.getAniday())%></td>
 	</tr>
	<tr>
 		<td style="text-align: center;">내용</td>
 		<td><%=dto.getAnimessage() %></td>
 	</tr>
 </table>
 
 <table class="tabreple">
 <!-- 댓글 영역 -->
 	<tr>
 		<td colspan="3">
 			<h6><b>댓글</b></h6>
 			<div class="repleform input-group">
 				<input type="text" id="nickname" class="form-control"
 				placeholder="닉네임 입력">
 				<br><br>
 				
 				<input type="text" id="replemessage" class="form-control"
 				placeholder="댓글 입력"  style="width:300px;">
 				
 				<button type="button" class="btn btn-warning"
 				id="btnreple">등록</button>
 			</div>
 				&nbsp;
 				<span id="nicknameError" style="color: red; font-size: 12px; display: none;">닉네임을 입력하세요.</span> 
 				&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
 				<span id="repleError" style="color: red; font-size: 12px; display: none;">댓글을 입력하세요.</span>
 			<div class="replelist" style="margin-top: 10px;"> 
 				<b>0</b>
 				<div style="margin-left: 10px;">1</div>
 			</div>
 		</td>
 	</tr>
 </table>
 
 <table class="tabbutton">
 	<tr>
		<td colspan="3" align="center">
 		<button type="submit"  class="btn btn-success"
 		id="btnupdate" data-bs-toggle="modal" data-bs-target="#updatemodal">수정</button>
 		
 		<button type="button"  class="btn btn-success"
 		id="btndelete">삭제</button>
 		
 		<button type="button" class="btn btn-success"
 		onclick="location.href='./animallist.jsp'">목록</button>
	  </td>
	</tr>
 </table>
</body>
</html>