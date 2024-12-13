package day1213;

public class Ex5While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		//while 은 조건이 맞지 않으면 한번도 실행안하고 빠져나온다.
		while(a<10) {
			System.out.println("loop");
		}
		
		//do while은 일단 한번 실행 후 조건을 비교하므로 조건이 맞지 않아도 최소 한번은 문장이 실행됨
		do {
			System.out.println("do-while loop");
		}while(a<10);
		
		a=1;
		while(a<=10) {
			System.out.printf("%3d",a++);
		}
		System.out.println();
		
		a=1;
		while(true)//일단 while문이 실행되도록 true를 준 것(a값이 무엇이든 실행되도록 한 것)
		{
			System.out.printf("%3d",a++);
			if(a>10)
				break;
		}
		
		System.out.println();
		
		a=0;//조건이 전치냐 후치냐에 따라서 달라지는 것 확인
		while(a<10) {
			System.out.printf("%3d",++a);
		}
		
		System.out.println();
		
		a=1;
		do {
			System.out.printf("%3d", a++);
		}while(a<=10);
		
		
		
	}

}
