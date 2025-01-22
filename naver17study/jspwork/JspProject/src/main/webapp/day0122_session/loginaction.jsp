<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String chksave=request.getParameter("chksave");//on or null
	String myid=request.getParameter("myid");
	String mypass=request.getParameter("mypass");
	
	if(myid.equals("angel") && mypass.equals("1234"))
	{
		if(chksave!=null){//아이디저장을 체크한 경우
			session.setAttribute("myid", myid);
			session.setAttribute("chksave", "yes");
		}else{
			//이전에 저장된 세선을 삭제
			session.removeAttribute("chksave");
			session.removeAttribute("myid");
		}
		session.setAttribute("loginok", "yes");
		
		//유지시간(생략 시 기본 30분간 유지)
		session.setMaxInactiveInterval(60*60);//한시간 유지(초단위)
		
		response.sendRedirect("./sessionmain.jsp");//메인페이지로 이동
	}else{%>
		<script>
			alert("아이디와 비번이 맞지 않습니다");
			history.back();
		</script>
	<%}
%>