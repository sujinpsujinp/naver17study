package day1218;

class Car
{
	static String carCompany="현대";
	
	private String carName;
	private int carPrice;

	public static void setCarCompany(String carCompany)
	{
		//static 메서드에서는 static 변수만이 접근 가능
		Car.carCompany=carCompany;
	}
	//setter method private라 set까지만 해놓으면 불러올 수는 있으나 반환이 안됨
	//멤버 변수를 만들면 setter랑 getter는 무조건 만들어두어야함
	public void setCarName(String carName)
	{
		this.carName=carName;
	}
	public void setCarPrice(int carPrice)
	{
		this.carPrice=carPrice;
	}
	
	//getter method 하나씩 반환할때
	public String getCarName()
	{
		return carName;//this 생략가능
	}
	public int getcarPrice()
	{
		return carPrice;
	}
	
	public void setData(String carName, int carPrice)
	{
		this.setCarName(carName);
		this.setCarPrice(carPrice);
	}
}

public class Ex9Object {

	public static void writeCarInfo(Car myCar)
	{
		System.out.println("=".repeat(30));
		System.out.println("자동차명:"+myCar.getCarName());
		System.out.println("가  격:"+myCar.getcarPrice());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("현재 자동차 회사명:"+Car.carCompany);
		
		Car.setCarCompany("삼성");
		System.out.println("변경된 자동차 회사명:"+Car.carCompany);
		
		Car car1=new Car();
		car1.setCarName("그랜져");
		car1.setCarPrice(3900);
		
		Car car2=new Car();
		car2.setData("소나타",3200);
		
		Car car3=new Car();
		car3.setCarName("Mini");
		car3.setCarPrice(5000);
		
//		System.out.println("car1 자동차명"+car1.getCarName());
//		System.out.println("car1 가격:"+car1.getcarPrice());
//		System.out.println("=".repeat(30));
//		System.out.println("car2 자동차명"+car2.getCarName());
//		System.out.println("car2 가격"+car2.getcarPrice());
		
		writeCarInfo(car1);
		writeCarInfo(car2);
		writeCarInfo(car3);
		
		
	}

}
