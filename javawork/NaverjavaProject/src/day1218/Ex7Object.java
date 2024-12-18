package day1218;

class Apple//>>설계도면
{
	//접근 지정자 생략 시 default가 되는데 같은 패키지에서는
	//private을 제외하고 모두 직접 접근 가능
	static String message="Hello";//클래스 멤버변수
	static final String EMP="비트캠프";//상수
	String name="캔디";//인스턴스 멤버 변수>> 주소가 없어서 new로 만들어줘야 호출가능
	
}

public class Ex7Object {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다른 클래스의 static 변수는 클래스명.변수명 이렇게 접근한다.
		System.out.println("메세지:"+Apple.message);
		System.out.println("EMP:"+Apple.EMP);
		
		Apple.message="Happy Day";
		System.out.println(Apple.message);
		//Apple.EMP="삼성전자";//오류:final 상수는 값 변경 불가 
		
		//다른 클래스의 인스턴스 멤버변수를 접근하려면 new로 생성된 인스턴스 변수가 있어야함
		Apple a=new Apple();//a는 임의로 이름을 지정한 것  
		System.out.println("이름:"+a.name);
		//System.out.println("이름:"+Apple.name);//오류발생 무조건 인스턴스 변수로만 불러올 수 있음
		a.name="미라";
		System.out.println("a의 이름:"+a.name);
		
		Apple b=new Apple();
		b.name="영자";
		System.out.println("b의 이름:"+b.name);
	
	}

}
