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
  	</style>
</head>
<%
	//post방식인 경우 한글깨짐현상 해결법
	//반드시 첫줄에 있어야함!!!!
	request.setCharacterEncoding("utf-8");
	
	//값이 하나인 경우는 무조건 getParameter("값");
	String myid=request.getParameter("myid");
	String mypass=request.getParameter("mypass");
	String myname=request.getParameter("myname");
	String driver=request.getParameter("driver");
	//radio 버튼이어도 하나의 이름으로 묶여있으면 getParameter 사용 가능
	String homeaddr=request.getParameter("homeaddr");
	String myfood=request.getParameter("myfood");
	String fcolor=request.getParameter("fcolor");
	String mybirth=request.getParameter("mybirth");
	
	//체크박스 그룹이 여러개인 경우 배열로 읽는다
	//체크를 모두 안했을 경우 null이 된다 > if문이 반드시 들어가야함
	String []hobby=request.getParameterValues("hobby");
%>
<body>
<div style="font-size:20px; color:<%=fcolor%>;">
	아이디: <%=myid %><br>
	비밀번호 : <%=mypass %><br>
	이름 : <%=myname %><br>
	
	<!-- 이 경우는 null일 경우 NullpointException이 발생 -->
	<!-- 아래 코드는  오류 발생으로 html주석이 아닌 jsp주석으로 줘야함 -->
	<%-- 운전면허 : <%=driver %>: (<%=driver.equals("yes")?"있음":"없음" %>)<br> --%>
	
	<!-- 값에 null이 들어올 확률이 있을 경우 무조건 조건은 null로 해야함 -->
	운전면허 : <%=driver %> : (<%=driver==null?"없음":"있음" %>)<br>
	주거지 : <%=homeaddr %><br>
	
	취미 : 
	<%
	if(hobby==null){
		out.print("<b>없음</b><br>");
	}else{
		String s="나의 취미는 ";
		for(String h:hobby)
			s+="["+h+"]";
			s+="입니다";
			%>
			<b><%=s %></b><br>
	<%}
	%>
	
	좋아하는 음식 : <img src="../image/food/<%=myfood %>" width="100" height="100"
	border="1"><br>
	글자색상 : <%=fcolor %><br>
	생년월일 : <%=mybirth %><br>
</div>
</body>

</html>