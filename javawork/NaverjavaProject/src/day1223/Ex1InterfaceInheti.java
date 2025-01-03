package day1223;

interface InterA
{
	public void study();
}
//인터페이스끼리의 상속은 extends
interface InterB extends InterA
{
	public void play();
}
//클래스가 인터페이스를 구현 시 implements >> 인터비를 구현시 인터비가 상속한 인터에이의 스터디도 같이 구현해야함
class MyInter implements InterB//선언을 interB로하고 생성도 interB > 스터디랑 플레이 가능 
{
	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("그룹 스터디를 합니다.");
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("그룹 모임을 합니다.");
	}
	
	public void job()
	{
		System.out.println("밀린 일처리를 합니다.");
	}
}

public class Ex1InterfaceInheti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterA interA=new MyInter();
		interA.study();//interA는 A가 갖고있는 것만
		//자식이 아니라 손자가 갖고있는 메서드도 다운캐스팅으로 가능
		((MyInter)interA).job();
		System.out.println("=".repeat(20));
		
		InterB interB=new MyInter();//선언 생성=~~
		interB.play();
		interB.study();//interB는 B가 상속받은 A가 가진 것까지
		//다운케스팅으로 job호출
		((MyInter) interB).job();
		System.out.println("=".repeat(20));
	
		MyInter my=new MyInter();//상속관계에 따라 호출 가능 메서드가 달리짐
		my.play();
		my.study();
		my.job();//MyInter는 B를 상속받았기에 A랑 B가 가진것까지
	}

}
