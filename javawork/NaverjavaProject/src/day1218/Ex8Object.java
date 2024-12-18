package day1218;

class Orange
{
	public static final String MESSAGE="Happy";
	
	private String name;//인스턴스 멤버변수
	private int age;	
	
	public void showData()
	{
		//일반 멤버 메서드는 this라는 인스턴스 변수를 가지고 있다.
		//static 멤버 메서드에는 this가 없음
		//그래서 this.name으로 접근 가능(this는 경우에 다라 생략가능)
		//System.out.println("이름:"+this.name+", 나이:"+this.age);
		System.out.println("이름:"+name+", 나이:"+age);//this 생략 가능 > 메서드에 같은 이름의 변수가 없어서
	}
	//값을 변경하기위한 setter method를 만들어보자
	public void setName(String name)
	{
		//같은 구역에 멤버와 같은 이름의 변수가 있을 경우
		//멤버변수 앞에 반드시 this를 붙인다.
		this.name=name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	
}

public class Ex8Object {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Orange.MESSAGE);//상수라서 변경은 못하고 호출은 가능
		
		Orange orange=new Orange();
		//System.out.println(Orange.name);//오류:private변수는 직접 접근 불가
		orange.showData();
		System.err.println("값 변경");
		orange.setName("김태희");
		orange.setAge(35);
		
		orange.showData();
		
	}

}
