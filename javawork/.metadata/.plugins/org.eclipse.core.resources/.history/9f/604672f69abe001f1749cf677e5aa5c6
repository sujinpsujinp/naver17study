package day1220;

//추상클래스는 객체 생성을 할 수 없다.
//자식 클래스로 하여금 반드시 구현하게 할 목적으로 추상메서드를 만든다.
//만약 자식 클래스가 추상메서드를 오버라이드 안했을 경우 그 클래스도 추상화 시켜야함 > 구현할때까지 계속 추상화
abstract class Parent2
{
	//부모가 process에서 하는 일이 없을 경우
	//그렇다고 안만들면 자식클래스에서 오버라이드를 할수없다.
	//이럴경우 미완성으로 선언만 하는데 이런경우  abstract 메서드로 만든다(미완성메서드란 의미)
	abstract public void process();//추상메서드는 일반 클래스에 멤버로 올수 없다. 추상클래스에서만 추상메서드가 올 수 있음

	//추상클래스는 추상메서드뿐 아니라 일반메서드도 구현이 가능
	//부모만이 가진 메서드
	public void study()
	{
		System.out.println("자바 공부를 한다.");
	}
}

class Your1 extends Parent2
{
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("벽지공사를 한다.");
	}
	//Your1이 가진 메서드
	public void draw()
	{
		System.out.println("그림을 그린다.");
	}
}

class Your2 extends Parent2
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("타일공사를 한다.");
	}
}

public class Ex6Abstract {
	public static void yourProcess(Parent2 p)
	{
		p.process();
		p.study();//부모가 가진 메서드는 호출 가능
		
		//p.draw();//오류발생
		//p에 Yout2가 생성되어있는 경우에는 오류가 발생한다.
		//((Your1)p).draw();//다운캐스팅 후 호출하면 됨
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		yourProcess(new Your1());
		System.out.println("=".repeat(30));
		//yourProcess(new Your2());
		
		//yourProcess(new Parent2());//오류: 추상클래스는 new로 생성할 수 없다.
		
		
	}

}
