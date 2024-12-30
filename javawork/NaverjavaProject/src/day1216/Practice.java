package day1216;

import java.util.Random;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ex1 난수 구하기
		//Math.random()은 0.0보다 크거나같고 1.0보다 작은 난수 발생
		for(int i=1; i<=5; i++){
			System.out.println(Math.random());
		}
		
		System.out.println("1~10까지 난수 구하기");
		for(int i=1;i<=5;i++)
		{
			int n=(int)(Math.random()*10)+1;
			System.out.print(n+" ");
		}
		
		System.out.println("Random 클래스를 이용해서 난수 구하기");
		System.out.println("1~10 까지의 난수 구하기");
		Random r=new Random();
		for(int i=1; i<=5; i++)
		{
			int n=r.nextInt(10)+1;
			System.out.print(n+"  ");
		}
		
		System.out.println("A~Z(65~90) 까지의 난수 구하기");
		for(int i=1; i<=5; i++)
		{
			int n=r.nextInt(26)+62;
			System.out.print((char)n+"  ");
		}
		
		//Ex4 Lable 레이블은 다중for문에서 사용
		Loop: //레이블 명은 임의로 지정 선언 후 바로 반복문이 와야함
		for(int i=1; i<=5; i++) 
		{
			for(int j=1; j<=5; j++)
			{
				if(i==2)
//					continue Loop;//i++로 이동 i가2인경우 출력하지않음
//				if(j==4)
//					continue Loop;//i++로 이동 j는 1 2 3만 출력
//				if(j==4)
//					break; //continue Loop랑 결과 동일
				if(j==3)
					break Loop;//for문 전체 빠져나감
				
				System.out.println("i="+i+",j="+j);
			}
		}
		
		
		
	}

}
