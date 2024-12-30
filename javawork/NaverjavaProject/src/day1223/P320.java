package day1223;

//class Vehicle{
//	//메소드 선언
//	public void run() 
//	{
//		System.out.println("차량이 달립니다.");
//	}
//}

//abstract메서드에는 추상메서드도 일반메서드도 들어갈 수 있음 
//abstract class Vehicle
//{
//	public abstract void run();
//}

//어차피 추상메서드만 있는 경우 interface 로 변경 가능함
interface Vehicle
{
	public void run();
}


// class Bus extends Vehicle
class Bus implements Vehicle
{
	//메소드 재정의(오버라이딩)
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		System.out.println("버스가 달립니다.");
	}
}

 class Taxi implements Vehicle
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("택시가 달립니다.");
	}
}
 class Driver//static이면 driver.driv로 호출 가능함
	{
		//메소드 선언(클래스 타입의 매개변수를 가지고 있음) > 매개변수 다형성
		public void drive(Vehicle vehicle)
		{
			vehicle.run();
		}
	}
 
public class P320 {
	
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
