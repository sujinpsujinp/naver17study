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
  	</style>
</head>
<body>
<div style="margin: 20px; width: 500px;">
	<form action="./update" method="post">
	<input type="hidden" name="num" value="${dto.num}">
		<table class="table table-bordered">
			<tr>
				<td>상품사진</td>
				<td>
				<select id="sphoto" name="sphoto" class="form-select">
						  <script>
						  	for(let i=1;i<=34;i++){
						  		let s="";
						  		let s1=`../image/photo2/\${i}.\${i==24?"gif":"jpg"}`;
						  		let s2="${dto.sphoto}";
						  		if(s1==s2)
						  			s=`<option value="\${s1}" selected>상품 \${i}</option>`;
						  		else
						  			s=`<option value="\${s1}">상품 \${i}</option>`;
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
				class="form-control" value="${dto.sangpum }"></td>
			</tr>
			<tr>
				<td>색상</td>
				<td><input type="color" name="scolor" id="scolor"
				class="form-control" value="${dto.scolor}"></td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td><input type="text" name="sprice" id="sprice"
				class="form-control" value="${dto.sprice}"></td>
			</tr>
			<tr>
				<td>상품갯수</td>
				<td><input type="number" name="scnt" id="scnt"
			class="form-control" value="${dto.scnt}"></td>
			</tr>
			<tr>
				<td>입고일</td>
				<td> <input type="date" name="ipgoday" id="ipgoday"
					class="form-control" value="${dto.ipgoday}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button type="submit" class="btn btn-sm btn-success addshop"
				onclick="location.href='./detail?num=${dto.num}'" >상품수정</button>
				
				<button type="submit" class="btn btn-sm btn-success addshop"
				onclick="history.back()" >이전으로</button>
				</td>
			<tr>
		</table>
	</form>
</div>
</body>
</html>