package day1218;

import java.text.NumberFormat;

public class Ex10Object {
	
	public static void showTitle()
	{
		System.out.println("번호\t자동차명\t가격");
		System.out.println("=".repeat(30));
	}

	public static void writeCar(int num, Car myCar)
	{
		NumberFormat nf=NumberFormat.getInstance();
		System.out.println(num+"\t"+myCar.getCarName()+"\t"+nf.format(myCar.getcarPrice())+"만원");	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체배열
		Car []cars=new Car[5];//메모리 할당 시 객체는 무조건 초기값 null
		
		//배열 5개의 각 Car 객체는 따로 생성해줘야한다.
		for(int i=0;i<cars.length;i++) 
			cars[i]=new Car();
		
		cars[0].setData("그랜져", 5600);
		cars[1].setData("아반떼", 4600);
		cars[2].setData("모닝", 2300);
		cars[3].setData("미니", 4900);
		cars[4].setData("아우디", 6700);
		
		//제목부터 출력
		showTitle();
		for(int i=0;i<cars.length;i++)
		{
			writeCar(i+1, cars[i]);
		}
		System.out.println();
		int n=0;
		for(Car car:cars)
		{
			writeCar(++n,car);
		}
		
	}

}
