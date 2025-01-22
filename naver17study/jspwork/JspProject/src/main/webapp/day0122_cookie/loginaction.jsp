<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String amho=request.getParameter("amho");
	//암호가 bitcamp가 맞으면 쿠키 생성(이름은 loginok)
	if(amho.equals("bitcamp")){
		Cookie cookie=new Cookie("loginok",amho);//name은 loginok, value는 아무거나 저장(지금은 amho)(의미없음)
		cookie.setPath("/");//저장 위치
		cookie.setMaxAge(60*60*24);//쿠키유지시간, 초단위,24시간 유지 환산하지말고 공식으로 적어야함
		response.addCookie(cookie);//브라우저에 쿠키추가
		response.sendRedirect("./cookiemain.jsp");//메인페이지로 이동
	}else{%>
		<script>
			alert("암호가 맞지않습니다");
			history.back();
		</script>
	<%}
%>