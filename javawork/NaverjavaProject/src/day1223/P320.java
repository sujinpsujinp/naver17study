package day1223;

 class Vehicle{
	//메소드 선언
	public void run() {
		System.out.println("차량이 달립니다.");
	}
}

 class Bus extends Vehicle
{
	//메소드 재정의(오버라이딩)
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("버스가 달립니다.");
	}
}

 class Taxi extends Vehicle
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("택시가 달립니다.");
	}
}
public class P320 {

	static class Driver
	{
		//메소드 선언(클래스 타입의 매개변수를 가지고 있음)
		public void drive(Vehicle vehicle)
		{
			vehicle.run();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Driver 객체 생성
		Driver driver =new Driver();
		
		//매개값으로 Bus객체를 제공하고 driver() 메소드 호출
		Bus bus =new Bus();
		driver.drive(bus);
		
		//매개값으로 Taxi객체를 제공하고 driver()메소드 호출
		Taxi taxi=new Taxi();
		driver.drive(taxi);
	}

}