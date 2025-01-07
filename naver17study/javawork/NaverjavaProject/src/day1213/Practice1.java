package day1213;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prictice1은 입력받지 않은 내용 위주
		
		//Ex1Switch break가 없으면 우수회원, 일반회원, 손님까지 다 출력함
		char grade='c';
		
		switch(grade) {
		case 'A':
		case 'a':
			System.out.println("우수회원입니다.");
			break;
		case 'B':
		case 'b':
			System.out.println("일반회원입니다.");
			break;
		default:
			System.out.println("손님입니다.");
		}
		
		//Ex5While 
		//while 은 조건이 맞지 않으면 한번도 실행안하고 빠져나온다.
		int a=6;
		while(a<=10) {
			 a++;
			System.out.println("While 기초 확인");
		}
		//do-while은일단 한번 실행 후 조건을 비교하므로 조건이 맞지 않아도 최소 한번은 문장이 실행됨
		do {
			System.out.println("do-while:do");
		} while(a<10);
			
		//Ex10For
		for(int i=1;i<=10;i++) 
			System.out.print(i+"  ");
		System.out.println();
		
		for(int i=0;i<=10;i+=2)
			System.out.print(i+"  ");
		System.out.println();
		
		System.out.println("break");
		for(int i=1;i<=10;i++) {
			System.out.print(i+"  ");
			if(i==5)
				break;
		}
		System.out.println();
		System.out.println("continue");
		for(int i=1;i<=10;i++) {
			if(i%2==1)
				continue;
			System.out.print(i+"  ");
		}
		
		
		
	}

}
