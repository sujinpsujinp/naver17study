package day1220;

class SuperObj1
{
	SuperObj1()
	{
		System.out.println("Super 생성자");
	}
	
	SuperObj1(String msg)
	{
		System.out.println("super 메세지를 받는 생성자"+msg);
	}
}
///////////////////////////////////
class SubObj1 extends SuperObj1
{
	SubObj1()
	{
		//첫줄에 super()가 생략되어있다-직접 쓸 경우 첫줄에 있어야함 밑에 있으면 오류 발생
		super();//부모의 디폴트 생성자를 호출 > 생략가능
		System.out.println("sub 생성자");
	}
	
	SubObj1(String msg)
	{
		super(msg);//생략 불가 - 만약 생략 시 부모의 디폴트 생성자가 호출된다.
		System.out.println("sub의 두번째 생성자");
	}
}


public class Ex1Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj1 sub1=new SubObj1();
		SubObj1 sub2=new SubObj1("Hello");
		
		
		

	}

}
