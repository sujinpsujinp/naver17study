package day1220;

abstract class Test1
{
	abstract public void play();
}

abstract class Test2 extends Test1
{
	abstract public void job();
}

class Test3 extends Test2//위 추상 메서드 안에 있는 거들 다 오버라이드 해야 오류 발생하지 않음
{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("play");
	}
	
	@Override
	public void job() {
		// TODO Auto-generated method stub
		System.out.println("job");
	}
	
}

public class Ex8Abstract {

	public static void hello1(Test1 t1)//test1이 오버라이드 한 것만 출력
	{
		t1.play();
		System.out.println();
	}
	
	public static void hello2(Test2 t2)//test2가 오버라이드 한 것 모두 출력 가능
	{
		t2.play();
		t2.job();
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		hello1(new Test3());
		hello2(new Test3());

	}

}
