package day1219;
/*
 *  생성자란
 *  1.객체 생성 시 자동호출
 *  2.리턴(void, String)타입 없음(형석[접근지정자]클래스명)> 리턴타입 적는 순간 인식 못함
 *  3.오버로딩(Overloading:중복함수)이 가능
 *  4.생성자에서는 주로 멤버변수 초기화를 담당한다. >중간에 값을 변경할거면 setter사용
 */
class Apple
{
	Apple()
	{
		System.out.println("디폴트 생성자");
	}
	
	Apple(String name)
	{
		System.out.println(name+"을 인자로 받음");
	}
	
	Apple(int age)
	{
		System.out.println(age+"를 인자로 받음");
	}
	
	Apple(String name, int age)
	{
		System.out.println(name+"과 "+age+"를 인자로 받음");
	}
	
}
////////////////////////////////////////////////

public class Ex3Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a1=new Apple();//생성자 자동 호출
		Apple a2=new Apple("강씨");
		Apple a3=new Apple(50);
		Apple a4=new Apple("빨강",23);
	}

}
