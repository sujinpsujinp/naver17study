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
	또 경호처가 시위대 대응 목적으로 총기를 준비한 것은 경호처 창설 이래 한 번도 없었던 것으로 파악됐다.

22일 뉴스1 취재를 종합하면 경찰청 국가수사본부 비상계엄 특별수사단(단장 우종수 국수사본부장)은 
특수공무집행방해 혐의를 받는 이 본부장의 진술을 확보하고 신병확보 필요성을 검토하고 있다. 경찰은 이 본부장의 혐의와 관련한 경호처 관계자 다수의 진술도 살피고 있다.

경찰은 이 본부장이 '관저 무기고에서 MP7 2정과 실탄 80발을 꺼내 가족경호부에 배치하라'고 지시했다는 진술을 확인한 상태다.

이 본부장은 실탄이 관저로 옮겨진 뒤 경호관들에게 '(관저 인근인) 제2정문이 뚫린다면 기관총을 들고 대응하라'고
 지시했다고 한다.

경찰 특수단은 윤 대통령의 지시를 받아 이 본부장이 '기관총 배치'를 지시한 것으로 의심하고 있다.

윤 대통령이 경호처 실세인 김성훈 경호처 차장에게 총기 사용 검토를 지시했던 정황을 확인했기 때문이다.

사정기관의 한 관계자는 "경호처 역사상 시위대에 대비하고자 총기를 준비한 전례는 없다"고 말했다.

그러나 이 본부장은 경찰 조사에서 구체적인 진술을 피하고 있다. 다만 기관총 배치 지시와 관련해선 
"진보노동단체가 관저로 침입한다는 보고를 받고 대비 차원에서 지시한 것"이라고 진술했다고 전해진다. 
대통령 체포 저지 혐의를 부인한 것이다.

경찰 특수단은 앞서 18일 오전 10시 3분쯤 이 본부장에 대한 체포영장을 집행해 그를 조사했다.

경찰 안팎에서는 그를 구속할 필요성이 제기됐지만 특수단은 체포됐던 그를 지난 19일 석방했다. 
검찰이 앞서 김 차장의 구속영장을 반려한 것을 고려한 조처였다. 이 본부장 구속영장을 신청해도 검찰이 
김 차장 때처럼 영장을 불청구할 것으로 본 것이다.

경찰은 이 본부장의 구속영장을 신청하는 방안을 검토하고 있다.	
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