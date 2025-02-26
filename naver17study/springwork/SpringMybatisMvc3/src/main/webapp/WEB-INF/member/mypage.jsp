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
       .profilelargephoto{
       		position:relative;
       		top:30px;
       		width: 150px;
       		height: 150px;
       		border: 1px solid gray;
       		border-radius: 100px;
       }
       
       .changecamera{
       		position: relative;
       		cursor: pointer;
       		font-size: 1.5em;
       		left: -30px;
       		top:-80px;
       }
  	</style>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>

<!-- The Modal -->
<div class="modal" id="myMemberModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <form id="updateform">
        <table class="logintab">
        	<tbody>
        		<tr>
        			<th width="80">이름</th>
        			<td>
        				<input type="text" id="mname" name="mname" value="${dto.mname }">
        			</td>
        		</tr>
        		<tr>
        			<th width="80">전화번호</th>
        			<td>
        				<input type="text" id="mhp" name="mhp" value="${dto.mhp}">
        			</td>
        		</tr>
        		<tr>
        			<th width="80">주소</th>
        			<td>
        				<input type="text" id="maddr" name="maddr" value="${dto.maddr }">
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2" align="center">
        				<button type="submit" class="btn btn-sm btn-success">수정</button>
        			</td>
        		</tr>
        	</tbody>	
        </table>
      </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>


<div style="margin: 30px 100px;">
	<%-- <img src="../save/${dto.mphoto}" class="profilelargephoto"
	  onerror="this.src='../save/noimage.png'" style="float: left;"> --%>
	  
	 <!-- naver storage 에 있는 사진으로 출력 -->
	 <img src="${naverurl}/member/${dto.mphoto}" class="profilelargephoto"
	  onerror="this.src='../save/noimage.png'" style="float: left;">
	
	<input type="file" id="fileupload" style="display: none;">
	
	<i class="bi bi-camera-fill changecamera"></i>
	<script>
		$(".changecamera").click(function(){
			$("#fileupload").trigger("click");
		});
		
		//사진변경 이벤트
		$("#fileupload").change(function(e){
			let form=new FormData();
			form.append("upload",e.target.files[0]);
			form.append("num",${dto.num});
			
			$.ajax({
				type:"post",
				dataType:"text",
				data:form,
				url:"./changephoto",
				processData:false,
				contentType:false,
				success:function(){
					location.reload();
				}
			});
		});
	</script>
	<div style="display: inline-block;margin: 20px 50px;">
		<h6>회원명 : ${dto.mname}</h6>
		<h6>아이디 : ${dto.myid}</h6>
		<h6>핸드폰 : ${dto.mhp}</h6>
		<h6>주소 : ${dto.maddr}</h6>
		<h6>가입일 : 
			<fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm"/>
		</h6>
		<br><br>
		<button type="button" class="btn btn-sm btn-danger"
		onclick="memberdel(${dto.num})">회원탈퇴</button>
		
		<script>
			function memberdel(num){
				let ans=confirm("정말 탈퇴하시겠습니까?");
				if(ans){
					$.ajax({
						type:"get",
						dataType:"text",
						data:{"num":num},
						url:"./mypagedel",
						success:function(){
							location.href='../';
						}
					});
				}
			}
		</script>
		
		<!-- 문제 : 아이디를 제외한 나머지 정보(mname,mhp,maddr) 수정(모달) 
		수정 후 reload 할거니까 @resonseBody로 메서드 구현 반환받지 않고 form으로 한번에 해도 되고-->
		<button type="button" class="btn btn-sm btn-success"
		data-bs-toggle="modal" data-bs-target="#myMemberModal">회원정보 수정</button>
		
		<script>
		//수정 이벤트
		$("#updateform").submit(function(e){
			e.preventDefault();//서브밋의 기본이벤트를 무효화(action호출)
			//alert("submit");
			
			
			//console.log(loginid);
			 $.ajax({
				type:"get",
				dataType:"text",
				data:{"mname":$("#mname").val(),"mhp":$("#mhp").val(),"maddr":$("#maddr").val(),"num":${dto.num}},
				url:"./updatemember",
				success:function(res){
					location.reload();	
				}
			});
		});
		</script>
	</div>
</div>
</body>
</html>