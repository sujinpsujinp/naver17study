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
	//false >> 로그인 안한 상태를 의미
	boolean blogin=false;
	
	//현재 브라우저에 저장된 모든 쿠키값얻기, 없을경우 null값
	Cookie []cookies=request.getCookies();
	if(cookies!=null)
	{
		for(int i=0;i<cookies.length;i++)
		{
			//loginok라는 쿠키가 있는지 검사
			if(cookies[i].getName().equals("loginok")){
				blogin=true;
				break;
			}
		}
	}
%>
<body>
<%
	if(blogin){
	//로그인을 한 상태
	%>
	<pre>
	A 행정관도 검찰 조사에서 "김 전 장관 지시로 노트북과 휴대전화를 망치로 부쉈다"고 진술했다. 
	A 행정관은 김 전 장관이 대통령 경호처장 시절부터 개인 비서 역할을 맡았고, 국방부 장관 임명 후에도 김 전 장관을 수행한 것으로 전해졌다.

김 전 장관과 A 행정관 진술대로 노트북이 파손됐고 복구가 불가능하다면 포고령 작성 과정을 밝혀낼 물증이 사라진 상황이다. 
검찰은 국회 활동과 집회를 금지한 포고령의 내용이 위법하다고 보고 있다.

검찰의 김 전 장관 공소장에 따르면 김 전 장관은 지난해 11월 24일쯤 윤석열 대통령이 '특단의 대책이 필요하다'고 하자 
비상계엄 선포에 대비해 포고령과 계엄 선포문, 대국민 담화문 초안을 미리 작성했다.

계엄 선포 이틀 전인 12월 1일 포고령 초안을 보고받은 윤 대통령은 '야간 통행금지' 부분을 삭제하는 등 보완을 지시했고, 
이튿날 윤 대통령은 수정된 포고령 내용을 승인한 것으로 조사됐다.

김 전 장관은 검찰 조사에서 "윤 대통령이 포고령 작성 과정에서 관련 법전을 찾아봤다"는 취지의 진술도 한 것으로 전해졌다.

한편 윤 대통령 대리인단은 헌법재판소 탄핵 심판 답변서에서 "포고령 제1호는 국방부 장관 김용현이 국회해산권이 존재했던 
예전 군사정권 때의 계엄 예문을 그대로 필사해 작성한 것을 윤 대통령이 몇 자 수정한 것"이라며 "문구의 잘못을 부주의로 간과한
 것이다. 
포고령에 표현이 미숙했다"고 주장했다.	
	</pre>
	<%}else{%>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요");
			history.back();//이전 페이지로 이동
		</script>
		
	<%}
%>

</body>
</html>