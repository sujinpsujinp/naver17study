package day1216;

import java.util.Random;

public class EX1Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 난수를 구하는 방법이 2가지
		 * 1.Math.random()
		 * 2.Random
		 */
		
		System.out.println("Math.random()은 0.0보다 크거나같고 1.0보다 작은 난수 발생");
		for(int i=1;i<=5;i++) {
			System.out.println(Math.random());
		}
		System.out.println("0~9 사이의 난수를 구하는 방법");
		for(int i=1;i<=5;i++) {
			int n=(int)(Math.random()*10);
			System.out.print(n+"  ");
		}
		System.out.println();
		
		//문제1
		System.out.println("0~99 사이의 난수를 구하는 방법");
		for(int i=1;i<=5;i++) {
			int n=(int)(Math.random()*100);
			System.out.print(n+"  ");
		}
		System.out.println();
		
		//문제2
		System.out.println("1~10 사이의 난수를 구하는 방법");
		for(int i=1;i<=5;i++) {
			int n=(int)(Math.random()*10)+1;
			System.out.print(n+"  ");
		}
		System.out.println();
		
		System.out.println("Random 클래스를 이용해서 난수 구하기");
		Random r=new Random();//인스턴스 메서드
		System.out.println("0~9 까지의 난수 구하기");
		for (int i=1; i<=5;i++) 
		{
			int n=r.nextInt(10);//0~9까지 발생
			System.out.print(n+"  ");
		}
		System.out.println();
		
		System.out.println("1~10 까지의 난수 구하기");
		for (int i=1; i<=5;i++) 
		{
			int n=r.nextInt(10)+1;
			System.out.print(n+"  ");
		}
		System.out.println();
		
		System.out.println("A~Z(65~90) 까지의 난수 구하기");
		for (int i=1; i<=5;i++) 
		{
			int n=r.nextInt(26)+65;//두 합계가 91이 되면 됨 뒷 수를 97로 바꾸면 소문자 출력
			System.out.print((char)n+"  ");
		}
		System.out.println();
		
		
		
	}

}
