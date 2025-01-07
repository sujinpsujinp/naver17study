package day1220;



interface InterB
{
	int SPEED=100;//final 상수, 인터페이스는 final만 올 수 있어서 생략함
	
	public void speedWrite();
	public void speedUp(int speed);
	public void speedDown(int speed);
}
	
class Car implements InterB
{
	int curSpeed=SPEED;//초기값 100이 대입
	
	
	@Override
	public void speedWrite() {
		// TODO Auto-generated method stub
		System.out.println("현재 스피드는 "+SPEED);
	}

	@Override
	public void speedUp(int speed) {
		// TODO Auto-generated method stub
		//SPEED+=spped;//오류: SPEED는 상수이므로 변경불가
		System.out.println("스피드를"+curSpeed+" 올립니다.");
		curSpeed+=speed;
	}

	@Override
	public void speedDown(int speed) {
		// TODO Auto-generated method stub
		curSpeed-=speed;
		System.out.println("스피드를"+curSpeed+" 내립니다.");
	}
	
}
public class Ex10Interface {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterB inter=new Car();
		inter.speedWrite();
		inter.speedUp(30);
		inter.speedWrite();
		inter.speedDown(50);
		inter.speedWrite();
		
	}

}
