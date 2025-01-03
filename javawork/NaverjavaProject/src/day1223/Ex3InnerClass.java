package day1223;

abstract class AbstEx
{
	abstract public void show();//정식 선언해도 되지만 바로 오버라이드 하고싶은 경우
	
}

interface MyDB
{
	public void list();
	public void insert();
}

class SubMyDB implements MyDB
{
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("목록 출력 2");
	}
	
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert2");
	}
}

public class Ex3InnerClass {
	
	//익명 내부 클래스 형태로 구현(new Ab 입력하고 컨트롤 스페이스하면 Anonymous inner Type 누르면 자동입력됨)
	AbstEx abst1=new AbstEx() {//보기엔 내부클래스로 보임
		
		
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("show 호출");
		}
	};
	
	MyDB myDB=new MyDB() {
		
		@Override
		public void list() {
			// TODO Auto-generated method stub
			System.out.println("db목록을 출력합니다.");
		}
		
		@Override
		public void insert() {
			// TODO Auto-generated method stub
			System.out.println("db에 데이터를 추가합니다.");
		}
	};
	
	//정식 상속받은 클래스
	MyDB myDB2=new SubMyDB();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex3InnerClass ex3=new Ex3InnerClass();
		
		ex3.abst1.show();//ex3안에 내부 abst1이라는 것 안에 show
		System.out.println();
		ex3.myDB.list();
		ex3.myDB.insert();
		System.out.println();
		ex3.myDB2.list();
		ex3.myDB2.insert();
		
	}

}
