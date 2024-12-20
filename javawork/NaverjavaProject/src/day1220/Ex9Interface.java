package day1220;
/*
 * Interface는 음식점의 메뉴판과 같다.
 * 실체가 없이 메뉴목록만 있기 때문이다.
 * 실제로 주문을 해야 음식이 만들어지는 것처럼
 * 구현을 해야만 기능을 구현할 수 있다.
 * 
 * 인터페이스에는 추상메소드와 상수만이 올 수 있다.
 * 이때 abstract나 final은 생략함
 */

interface InterA
{
	public void process();
}

//InterA를 구현하는 클래스
class SubInter implements InterA
{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("sub 클래스의 process");
	}
	
}

public class Ex9Interface {
	public static void process(InterA inter)
	{
		inter.process();
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterA inter=new SubInter();
		inter.process();
		
		//메서드 호출
		process(new SubInter());

	}

}
