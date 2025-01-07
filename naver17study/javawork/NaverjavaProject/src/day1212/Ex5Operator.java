package day1212;

public class Ex5Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//조건(삼항)연산자 조건식1? 참일때 값 : 거짓일때 값
		//조건이 여러개인 경우
		//조건식1? 참일 때 값 : 조건식2? 참일때 값:조건식3일때 값: 거짓일때 값
		
		int x, y, max;
		x=5;
		//y=3;
		y=13;
		
		max=x>y?x:y;//X가 y보다 크면 x로 맥스값을 보내고 아니면 y로 보내겠다.
		System.out.println("max="+max);
		
		int z=20;
		max=x>y&&x>z?x:y>x&&y>z?y:z;
		System.out.println("max="+max);
		
		int score=75;
		char grade;
		//수식을 구현, 90이상이면 'A', 80이상이면 'B', 70이상이면 'c', 60이상이면 'D', 나머지는 F
		//grade= score>=90?'A':score >=80?'B':score>=70?'C':score>=60?'D':'F';//내가 푼 것
		grade=score>=90?'A':score>=80?'B':score>=70?'C':score>=60?'D':'F';//쌤이 풀어주신 것
		System.out.println(score+"점은"+grade+"학점입니다.");
		
		//점수가 90이상이면 Good, 나머지는 Try
		System.out.println(score+"점수는 "+(score>=90?"Good":"Try"));
		
		
	}

}
