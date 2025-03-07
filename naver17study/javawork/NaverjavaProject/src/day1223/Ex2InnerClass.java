package day1223;

class OuterOBj//외부클래스
{
	int a=10;
	static int b=20;
	private int c=30;
		
		class InnerObj//내부클래스는 하나의 멤버로 인식하기에 private로 인식
		{
			int x=40;
			//jdk17에서는 가능, jdk11에서는 static 선언 불가
			static int y=50;//일반 내부클래스는 static이 안됨 > 낮은 버전이면 에러발생함
			
			
			public void disp()
			{
				System.out.println("a="+a);
				System.out.println("b="+b);
				System.out.println("c="+c);
				System.out.println("x="+x);
				System.out.println("y="+y);
			}
		}
		
		public void outerDisp()
		{	
			//외부 클래스에서 직접 내부클래스 호출 시
			InnerObj inObj=new InnerObj();
			inObj.disp();
		}
		
			
}

public class Ex2InnerClass {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//외부 먼저 생성 아니면 내부 따로 생성해서 호출해야함
		OuterOBj obj1=new OuterOBj();
		obj1.outerDisp();
		System.out.println();
		//직접 내부클래스의 메서드를 호출하려면 
		OuterOBj.InnerObj obj2=new OuterOBj().new InnerObj(); //방법1
		//OuterOBj.InnerObj obj2= obj1.new InnerObj();//방법2: 위에 이미(obj1) 생성했던걸로 해도 됨
		obj2.disp();//물론 이 경우 거의 없긴 함
		
	}

}
