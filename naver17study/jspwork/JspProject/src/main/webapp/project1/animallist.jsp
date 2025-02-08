<%@page import="project1.AnimalreplDto"%>
<%@page import="project1.AnimalrepleDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="project1.AnimalDao"%>
<%@page import="project1.AnimalDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 목록</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
       body *{
          font-family:'Jua';
          margin:20px;
            }
       h2{
           margin:20px auto;
       	   text-align: center;
       	   width: 700px;

        }
        .divtop{
			margin:20px auto;
        	width: 700px;
        }
        
        .tab1{
        	margin:20px auto;
        	width:700px;
        }
        .tab1 thead th{
       		text-align: center;
       		font-size:0.9em;
       		color:white;
       		background-color: green;
       }
       .tab1 tbody td{
       		text-align: center;
       		font-size:15px;
       		background-color: #f0fff0;
       }
       .tab1 tbody td i:hover{
       		color: red;
       }
       
       .tab1 img{
       		width: 50px;
       		border:1px solid gray;
       		margin-right: 5px;
       }
  	</style>
<%
	
%>
  	<script>
  		$(function(){
  			list();
  			
  			//상세보기 클릭 시 이벤트
  			$(document).on("click","i.detail",function(){
  				let idx=$(this).attr("idx");
  				//상세페이지로 이동
  				location.href="./animaldetail.jsp?idx="+idx;
  			});
  		});
  		
  		function list()
  		{
  			$.ajax({
  				type:"get",
  				dataType:"json",
  				url:"./listcation.jsp",
  				success:function(res){
  					console.log(res);
  		            writedata(res);
  				}
  			});
  		}
  		
  		//res(배열) 데이터를 목록에 출력해주는 함수
  		function writedata(res) {
  		let s="";
    	s = `
        <table class="table table-bordered tab1">
            <thead>
                <th width="50">번호</th>
                <th width="80">이름</th>
                <th width="70">종류</th>
                <th >내용</th>
                <th width="150">등록일</th>
                <th width="80">상세보기</th>
            </thead>
            <tbody>
   		 `;	if(res.length === 0) {
    		s += `
        	<tr height="50" align="center">
            	<td colspan="6">
               		<b>등록된 게시글이 없습니다</b>
            	</td>    
        	</tr>
    		`;
			} else {
    		$.each(res, function(idx, ele) {
 
        	s += `
           	<tr>
                <td>\${idx + 1}</td>
                <td>\${ele.aniname}</td>
                <td>\${ele.anikind}</td>
                <td style="text-align:left;">
                	\${ele.animessage}
                	<span style="color:red;">(\${ele.commentCount})</span>
                </td>
                <td>\${ele.aniday}</td>
                <td>
                    <i class="bi bi-card-list detail"
                    style="font-size:25px;cursor:pointer;"
                    idx="\${ele.idx}"></i>
                </td>
            </tr>
        	`;
    		});
		}
  			    s += "</tbody></table>";
  			    $("div.result").html(s);
		
			}
  	</script>
</head>
<%
	//dao 선언
	AnimalDao dao=new AnimalDao();


	//dto 선언
	AnimalreplDto redto=new AnimalreplDto();	

	//전체 list 얻기
	List<AnimalDto> list=dao.getAllDatas();
	
	//날짜 포멧 양식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
	
	//출력할 시작번호
	int no=list.size();
%>
<body>
<h2 class="alert alert-success">목록</h2>

<div>
	<div class="divtop" style="display: flex; justify-content: space-between; align-items: center;">
    	<h6><b>총 <%=list.size() %>개의 글이 있습니다.</b></h6>
   		<button type="button" class="btn btn-outline-success btn-sm"
    	onclick="location.href='./insertanimal.jsp'"><i class="bi bi-pencil-fill"></i>등록</button>
	</div>
	
	<div class="result">
		목록목록
	</div>
	
</div>

</body>
</html>