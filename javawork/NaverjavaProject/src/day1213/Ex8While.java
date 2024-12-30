package day1213;

import java.util.Scanner;

public class Ex8While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 숫자n을 입력하면 1부터 n까지의 sum을 구해서 출력하시오.
		 * 
		 * 예) 100입력 시
		 * 1부터 100까지의 합계는 5050입니다.(printf)
		 */
		Scanner sc=new Scanner(System.in);
		//int a=1, n, sum=0; //내가 짠것
		int n,start=1, sum=0;
		
		System.out.println("숫자를 n 입력");
		n=sc.nextInt();
		
//내가 짠것
//		while(n>=a)
//		{
//			sum=a+1;
//			
//			if(n==a)				
//				break;
//			a++;
//		}
//		System.out.printf("1부터 %d까지의 합계는 %d입니다.",a,n,sum);	
//		
		//아래가 선생님이 해주신 것
		while(start<=n) {
			sum+=start++;//뒤에++는 start++; 로 따로 빠져도 됨
		}
		System.out.printf("1부터 %d까지의 합계는 %d입니다.",n,sum);
		
	}

}
