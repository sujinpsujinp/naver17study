package day1220_2;

public class Apple {

		public void job()
		{
			System.out.println("아침 식사를 준비합니다.");
		}
		
		protected void study()
		{
			System.out.println("자바 공부를 합니다.");
		}
		
		void draw()//default라서 상속이라도 패키지가 달라서 호출 불가
		{
			System.out.println("그림공부를 합니다.");
		}
		
		protected void process()
		{
			System.out.println("DB 공부를 합니다.");
		}
	}


