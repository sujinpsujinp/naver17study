package day1212;

public class Ex3Operator {
		//여기에 변수 선언 시 초기값 설정되어있어서 따로 설정하지 않아도 에러 발생하지 않음
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//대입연산자
		
		int a,b,c,d,e;
		a=b=c=d=e=3; //대입연산자는 초기값을 주지 않으면 에러나옴
		
		a+=5;//a=a+5
		b-=5;
		c*=5;
		d/=2;
		e%=2;	
		
		System.out.println("a="+a);
		System.out.println("b="+b);	
		System.out.println("c="+c);
		System.out.println("d="+d);
		System.out.println("e="+e);
		
	}

}
