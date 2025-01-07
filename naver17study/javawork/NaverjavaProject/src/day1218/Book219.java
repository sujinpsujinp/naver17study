package day1218;

public class Book219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Car 객체생성
		Book219Car myCar=new Book219Car();
		
		//Car객체의 필드값 읽기
		System.err.println("제작회사:"+myCar.company);
		System.out.println("모델명:"+myCar.model);
		System.out.println("색깔:"+myCar.color);
		System.out.println("최고속도:"+myCar.maxSpeed);
		System.out.println("현재속도:"+myCar.speed);
		
		//Car객체의 필드값 변경
		myCar.speed=60;
		System.out.println("수정된 속도:"+myCar.speed);
		
	}

}
