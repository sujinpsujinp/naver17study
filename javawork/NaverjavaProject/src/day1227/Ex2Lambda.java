package day1227;

/*
 * 자바에서의 함수형 프로그램인 람다(Lambda) 표현식은 인터페이스를
 * 사용하는 익명 내부 클래스의 또 다른 표현식이다.
 * 단, 인터페이스는 단 하나의 추상 메서드만 가지고 있어야 한다.
 * 
 * 람다는 ^ 그리스어 알파벳의 11번째 글자이다.
 * 클래스 위에 만들어야함(원래는 파일을 따로 만들어야함)
 */

@FunctionalInterface//메서드가 하나인지 아닌지 검증하는 역할, 두개일 경우 오류발생 > 람다일경우 이거 써줘야함
interface Orange
{
	public void write();//추상 메서드 > 익명 내부클래스 형태로 생성해야함
	//public void study(); //메서드를 두개 추가시 오류 발생
}

@FunctionalInterface
interface DataAdd
{
	public void add(int x,int y);
}



public class Ex2Lambda {
	
	//우리가 알고있는 익명 내부 클래스 형태로 Orange를 구현
	Orange or=new Orange() {
		
		@Override
		public void write() {
			// TODO Auto-generated method stub
			System.out.println("Ornage 익명  내부 클래스 형태");
		}
	};
	
	public void lambdaMethod()
	{
		Orange orange1=()->System.out.println("람다식 오렌지 형태");
		orange1.write();
		
		Orange orange2=() ->System.out.println("안녕하세요. 람다씨!");
		orange2.write();
		
		DataAdd add1=(int x, int y)->System.out.println(x+"+"+y+"="+(x+y));
		add1.add(10, 20);
		add1.add(3, 5);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//우리가 알고있는 익명내부클래스로 호출하기
		Ex2Lambda ex2=new Ex2Lambda();
		ex2.or.write();
		
		//람다메서드 호출
		ex2.lambdaMethod();
		
		
		
	}

}