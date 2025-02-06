<%@page import="java.text.SimpleDateFormat"%>
<%@page import="shop.data.ShopDto"%>
<%@page import="shop.data.ShopDao"%>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<%
	//1. num읽기
	int num=Integer.parseInt(request.getParameter("num"));
	
	//2.dao 선언
	ShopDao dao=new ShopDao();
	
	//3. num에 해당하는 dto(dao에 메서드 추가해야함: getSangpum(int num))
	ShopDto dto=dao.getSangpum(num);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
    <style>
       body *{
          font-family:'Jua';
            }
       .btn{
       		width:100px;
       }
       .replelist b{
       		cursor: pointer;
       }
       .replelist div{
       		font-size:15px;
       		font-family: 'Gaegu';
       }
       .replelist .day{
       		margin:20px;
       		font-size:13px;
       		color: gray;
       }
       .replelist .close{
       		margin: 15px;
       		color:red;
       		cursor: pointer;
     		font-size: 20px;
       }
       .star{
       		font-size: 13px;
       }
       .starfill{
      		font-size: 13px;
       		color:orange;
       }
  	</style>
  	<script type="text/javascript">
  		$(function() {
			list();//처음 로딩 시 상품평 출력
			
			//상품평 등록 버튼
			$("#btnreple").click(function() {
				let num=<%=num%>;
				let star=$(".selstar").val();
				let mes=$("#message").val();
				
				$.ajax({
					type:"get",
					dataType:"html",
					data:{"num":num,"star":star,"message":mes},
					url:"./insertreple.jsp",
					success:function(){
						//상품평 등록 후 목록 다시 출력
						list();
						
						//입력값 초기화
						$(".selstar").val(5);
						$("#message").val("");
					}
				});
			});
			
			//상품평 삭제 이벤트
			$(document).on("click","span.close",function(){
				let idx=$(this).attr("idx");
				if(confirm("해당 상품평을 삭제할까요?")){
					$.ajax({
						type:"get",
						dataType:"html",
						data:{"idx":idx},
						url:"./deletereple.jsp",
						success:function(){
							list();
						}
					});
				}
			});
			//상품평 나타내기/숨기기
			$(".replelist>b").click(function() {
				$(this).next().slideToggle('fast');
			});
			
		});
  		
  		function list() 
  		{
  			let s="";
			$.ajax({
				type:"get",
				dataType:"json",
				data:{"num":<%=num%>},
				url:"./listreple.jsp",
				success:function(res){
					let n=$(res).length;
					$(".replelist>b").text("총"+n+"개");
					//상품평 목록 출력
					
					$.each(res,function(idx,ele){
						//class로 star
						for(let i=0;i<=ele.star;i++)
						{
							s+=`<i class="bi bi-star-fill starfill"></i>`;	
						}
						for(let i=0;i<5-ele.star;i++)
						{
							s+=`<i class="bi bi-star star"></i>`;
						}
						s+=`<span class="day">\${ele.writeday}</span>`;
						s+="<br>"
						s+=`<span>\${ele.message}</span>`;
						
						s+=`<span class="close" idx="\${ele.idx}"><i class="bi bi-x-circle"></i></span>`;
						s+="<br>";
					});
					$(".replelist div").html(s);
				}
				
			});
		}
  	</script>
</head>


<body>
<!-- 상품 저장 다이얼로그 -->
<!-- The Modal -->
<div class="modal" id="updatemodal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">상품 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <!-- 이번에 수정은 폼단위로 값을 얻어보자 -->
	   <form id="updatefrm">
	   <!-- hidden -->
	   <input type="hidden" name="num" value="<%=num %>">
	   
	   	<table class="table table-bordered">
			<tr>
				<td>상품사진</td>
				<td>
				<select id="sphoto" name="sphoto" class="form-select">
						  <script>
						  	for(let i=1;i<=34;i++){
						  		let s="";
						  		let sphoto=`../image/photo2/\${i}.\${i==24?"gif":"jpg"}`;
						  		let dbphoto="<%=dto.getSphoto()%>";
						  		if(sphoto==dbphoto)
						  			s=`<option value='\${sphoto}' selected>상품 \${i}</option>`;
						  		else
						  			s=`<option value='\${sphoto}'>상품 \${i}</option>`;
						  		document.write(s);
						  	}
						  </script>		
					 </select>
					 <br>
					<img src="" class="shopphoto" width="100">
					
					<script type="text/javascript">
						$(".shopphoto").attr("src",$("#sphoto").val());
						
						//이벤트
						$("#sphoto").change(function(){
							$(".shopphoto").attr("src",$(this).val());
						});
					</script>
				</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="sangpum" id="sangpum"
				class="form-control" value="<%= dto.getSangpum()%>"></td>
			</tr>
			<tr>
				<td>색상</td>
				<td><input type="color" name="scolor" id="scolor"
				class="form-control" value="<%=dto.getScolor()%>"></td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td><input type="text" name="sprice" id="sprice"
				class="form-control" value="<%=dto.getSprice()%>"></td>
			</tr>
			<tr>
				<td>상품갯수</td>
				<td><input type="number" name="scnt" id="scnt"
			class="form-control" value="<%=dto.getScnt()%>"></td>
			</tr>
			<tr>
				<td>입고일</td>
				<td> <input type="date" name="ipgoday" id="ipgoday"
					class="form-control" value="<%=dto.getIpgoday()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button type="submit" data-bs-dismiss="modal"
				class="btn btn-sm btn-success addshop" >수정하기</button>
				</td>
			<tr>
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


<!-- table 을 이용해서 상세페이지 만들기, 맨 아래 수정, 삭제, 목록(연결) 버튼 넣기 -->
<h5 class="alert alert-danger" style="text-align:center;width:700px" >
[<%=dto.getSangpum() %>] 상품 상세</h5>

 <table class="tabdetail">
 	<tr colspan="7">
 		<td>
 			<img src="<%=dto.getSphoto() %>">
 		</td>
 		<td>
 			<h6>상품명: <%=dto.getSangpum() %></h6>
 			<h6>색상 : <sapn style="background-color:<%=dto.getScolor() %>"><%=dto.getScolor() %></sapn></div>
 			</h6>
 			<h6>가격 : <%= dto.getSprice()%></h6>	
 			<h6>수량: <%=dto.getScnt() %></h6>
 			<h6>입고일 : <%=dto.getIpgoday() %></h6>
 			<h6>등록일 : <%= sdf.format(dto.getWriteday())%></h6>
 		</td>
 	</tr>
 	
 	<tr>
 		<td colspan="2">
 			<h6><b>상품평을 등록해주세요</b></h6>
 			<div class="repleform input-group">
 				<select class="form-select selstar"
 				style="width: 80px;">
 					<option value="5">5점</option>
 					<option value="4">4점</option>
 					<option value="3">3점</option>
 					<option value="2">2점</option>
 					<option value="1">1점</option>
 				</select>
 				<input type="text" id="message" class="form-control"
 				placeholder="상품평쓰기" style="width: 280px;">
 				<button type="button" class="btn btn-sm btn-info"
 				id="btnreple">등록</button>
 			</div>
 			<div class="replelist" style="margin-top: 10px;"> 
 				<b>0</b>
 				<div style="margin-left: 10px;">1</div>
 			</div>
 		</td>
 	</tr>
 	
 	<tr>
 	  <td colspan="2" align="center">
 		<button type="button"  class="btn btn-success btn-sm "
 		id="btnupdate" data-bs-toggle="modal" data-bs-target="#updatemodal">수정</button>
 		
 		<button type="button"  class="btn btn-success btn-sm "
 		id="btndelete">삭제</button>
 		
 		<button type="button" class="btn btn-success btn-sm "
 		onclick="location.href='./shopmain.html'">목록</button>
	  </td>
	</tr>
 </table>
 <hr style="width:500px;">
 <div style="margin:20px;width:500px;"> 
 	
 </div>
 
 <script type="text/javascript">
 	$("#btndelete").click(function(){
 		//confirm으로 물어보고 [확인]을 누르면 삭제
 		let ans=confirm("현재 상품을 db에서 삭제합니다");
		//ajax 함수를 이용해서 한다
 		
 		//data로는  num을 보낸다
 		//success에서 목록을 보낸다(location.href)
 		if(ans){
 			$.ajax({
				type:"get",
				dataType:"html",
				data:{"num":<%=num%>},
				url:"./deleteshop.jsp",
				success:function(res)
				{
					location.href="./shopmain.html";
				}
			});
 		}
 	});
 	
 	/* $("#btnupdate").click(function(){
 		//수정 다이얼로그가 뜨면 데이터 수정 후(ajax를 사용)
 		//현재 디테일 페이지 새로고침(location.reload())
 		
 	}); *///jsp라 데이터를 폼에 직접 넣어서 이벤트 필요없음
 	
 	//모달 다이얼로그 수정 submit 버튼
 	$("#updatefrm").submit(function(e){
 		e.preventDefault();//기본 이벤트를 무효화(action 호출되는거 X)
 		//폼단위 데이터 모두 얻기
 		let d=$(this).serialize();
 		//alert(d);
 		$.ajax({
 			type:"get",
 			dataType:"html",
 			data:d,
			url:"./updateshop.jsp",
			success:function(res)
			{
				//수정 성공 후 새로고침
				location.reload();
			}
 		});
 	});
 </script>

</body>
</html>