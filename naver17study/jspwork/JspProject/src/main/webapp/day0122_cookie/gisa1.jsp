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
		조태용 국가정보원장, 김주현 대통령비서실 민정수석, 신원식 국가안보실장, 김태효 국가안보실 1차장, 
		김성훈 대통령경호처 차장도 자리했다. 홍장원 전 국가정보원 1차장도 청문회장에 나왔다.

이상민 전 행정안전부 장관도 청문회에 자리했지만 의원들 질문에 "증언하지 않겠다"는 답변을 되풀이했다.

청문회에서 여당 의원들은 공수처의 윤석열 대통령 내란 혐의 수사가 부당하고, 구속 수사도 불법이라고 주장하는 데 초점을 뒀다.

국민의힘 박준태 의원은 김성훈 경호차장을 향해 "법적인 근거도 없이 편법·위법적인 수사를 하는 공수처가 무슨 자격으로 
'경호처가 위법한 행위를 한 거고 경호관들 다 잡아서 수사하겠다'는 얘기를 하느냐"며 "당당하게 대응하라"고 요구했다.

여당은 아울러 야당이 계엄사태에 앞서 군이 오물풍선 원점타격을 계획한 의혹을 '외환유치 혐의'로 수사해야 한다고 주장하는 
것은 군사활동을 위축시킬 수 있다고 비판했다.

국민의힘 임종득 의원은 "야당이 '내란 특검법' 수정안에서 '외환죄를 뺐다'고 주장하는데, 수정안을 보면 '인지된 관련사건'을 
수사할 수 있도록 심어놨다"며 "외환죄를 물어서 우리 군의 대북 정책과 군사 활동에 족쇄를 채운다면 제일 좋아할 
사람은 김정은"이라고 주장했다.
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