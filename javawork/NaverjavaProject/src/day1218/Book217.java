package day1218;

public class Book217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Book217Car 객체 생성
		Book217Car myCar=new Book217Car();
		
		
		//Car 객체의 필드값 읽기 >> 기본값 출력
		System.out.println("모델명:"+myCar.model);
		System.out.println("시동여부:"+myCar.start);
		System.out.println("현재속도:"+myCar.speed);
	}

}
