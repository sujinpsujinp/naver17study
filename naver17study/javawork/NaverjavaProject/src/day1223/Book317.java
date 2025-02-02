package day1223;

 class Tire
{
	//메소드선언
	public void roll()
	{
		System.out.println("회전합니다.");
	}
}

	 class HankookTire extends Tire{
	//메소드 재정의(오버라이딩)
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("한국 타이어가 회전합니다.");
	}
}

	class KumhoTire extends Tire{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("금호 타이어가 회전합니다.");
	}
}

public class Book317 {
	
	//317p~318p 다형성 예제 책에서는 나눠진 파일이지만 한 파일에 이어서 작성
	
			static class Car{
			//필드 선언
			public Tire tire;
			
			//메소드선언
			 public void run() {
				//tire 필드에 대입된 객체의 roll() 메소드 호출
				tire.roll();
				}
		}
			
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Car 객체 생성
		Car myCar=new Car();		
		
		//tire 객체 장착
		myCar.tire=new Tire();
		myCar.run();
		
		//HankookTire 객체 장착
		myCar.tire=new HankookTire();
		myCar.run();
		
		//KumhoTire객체장착
		myCar.tire=new KumhoTire();
		myCar.run();
		
	}

}
