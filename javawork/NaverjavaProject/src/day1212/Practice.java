package day1212;

import java.util.Date;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ex1Operator 증감연산자, ++변수(1순위), 변수++(끝순위)
		int a,b,m,n;
		a=8;
		b=5;
		m=++a;
		n=b++;//n에 대입되고 나서 증감됨
		System.out.printf("a=%d b=%d m=%d n=%d \n",a,b,m,n);
		System.out.println("a와 n의 합은"+(a+n));//14 n은 내부적으로 6이 되었으므로 8+6
		System.out.println("a값은 : "+a++);
		System.out.println("b값은 : "+ ++b);
		
		
		a=b=m=n=3;
		a*=b++ - --m*5;//3 -10= -7*3=-21
		System.out.printf("a=%d b=%d m=%d n=%d \n",a,b,m,n);
		System.out.println("--------------------------------------");
		
		//Ex2Operator, 산술 연산자 + - * / %
		int num1=5000;
		int num2=26800;
		System.out.println(num1+num2);
		System.out.println(num1-num2);
		System.out.println(num1*num2);
		System.out.println(num1/num2);//몫
		System.out.println(num1%num2);//나머지
		System.out.println("만원: "+num2/10000);
		System.out.println("천원: "+num2%10000/1000);
		System.out.println("백원: "+num2%1000/100);
		System.out.println("--------------------------------------");
		
		//Ex3Operator, 대입연산자
		int c,d;
		a=b=c=d=8;
		a+=5;//a=a+5 
		b*=5;//b=b-5
		c/=5;//c=c/4
		d%=5;//d=d%5
		System.out.printf("a=%d b=%d c=%d d=%d \n",a,b,c,d);
		System.out.println("--------------------------------------");
		
		//Ex4Operator 관계연산자(>,<.>=,<=,==, !=), 논리연산자(&&, ||,!(not))>>결과값은 무조건 boolean(true/false)
		int kor=50, eng=89, math=100;
		System.out.println(eng);
		System.out.println(kor>eng);//false
		System.out.println(kor<eng);//true
		System.out.println(kor==math);//false
		System.out.println(kor!=eng);//true
		System.out.println(kor>eng&& ++eng<math);//false:true 첫번째 조건이 false인 경우 두번째 조건 비교안함
		System.out.println(eng);//89
		System.out.println(kor<eng || ++eng>math);//true||false 첫번째 조건이 true인 경우 두번째 조건 비교 안함 
		System.out.println(eng);//89
		System.out.println(!(eng<math));//false
		System.out.println(!false); //true
		System.out.println("--------------------------------------");
		
		//Ex5Operator 조건(삼항)연산자 조건식1? 참일때 값 : 거짓일때 값
		int x, y, max;
		x=5;
		y=2;
		max=x>y?x:y;//x가 y보다 크면 x값을 아니면 y값을 반환
		System.out.println("max 값은? "+max);
		int score=75;
		char grade;
		//수식을 구현, 90이상이면 'A', 80이상이면 'B', 70이상이면 'c', 60이상이면 'D', 나머지는 F
		grade=score>=90?'A':score>=80?'B':score>=70?'C':score>=60?'D':'F';
		System.out.println(score+"점은"+grade+"학점 입니다.");
		System.out.println("--------------------------------------");
		
	}

}
