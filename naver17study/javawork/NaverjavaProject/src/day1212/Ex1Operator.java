package day1212;

public class Ex1Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//증감 연산자, ++변수(전치:1순위), 변수++(후치:끝순위)
	
		int a,b,m,n;//변수 선언 시 int=a=b=5; 안됨
		
		a=b=5;//대입연산자는 오른쪽부터 실행
		m=++a;//먼저 a가 증가 된 후 m으로 대입
		n=b++;//먼저 대입 후 b가 증가됨(n:5,b:6)
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		a=b=m=n=5;
		m=a++*++b;//5*6=30
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);//m이랑 n이랑 순서 바꾸면 출력값이 바뀜> ""안에 연산자를 바꿔줘야함
		
		n=a++ + ++b;//6+7
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,n,m);
		
		a=5;
		System.out.println(a++);//먼저 출력 후 내부적으로 증가됨
		System.out.println(++a);//먼저 증가 후 출력됨> 위에서 내부적으로 6이 되었으므로 7이 출력
		
		a=b=m=n=5;
		a*=b-- -++n*3;//n먼저>>*3=18,5-6*3=>5*-13 >b는 대입 후에 값이 줄기때문에 대입 전까지는 5 
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		
		
	}

}
