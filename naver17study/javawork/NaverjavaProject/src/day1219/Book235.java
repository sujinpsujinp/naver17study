package day1219;

public class Book235 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Carculator 객체 선언
		Carculator myCalc=new Carculator();
		
		//리턴값이 없는 powerOn() 메소드 호출
		myCalc.powerOn();
		
		//plus메소드 호출 시 5와 6을 매개값으로 제공하고,
		//덧셈 결과를 리턴받아 result+1 변수에 대입
		int result1=myCalc.plus(5, 6);
		System.out.println("result="+result1);
		int x=10;
		int y=4;
		//divide() 메소드 호출 시 변수x와 y의 값을 매개값으로 제공하고,
		//나눗셈 결과를 리턴받아 result2 변수에 대입
		double result2=myCalc.divide(x, y);
		System.out.println("result2="+result2);
		
		//리턴값이 없는 powerOff메소드 호출
		myCalc.powerOff();
		
		
	}

}
