package day1213;

import java.util.Scanner;

public class Ex12For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제1
		 * 숫자 n을 입력하면 1부터 n까지의 합계를 구하시오,
		 * (for문 사용)
		 */
		
		//내가 푼 것
		Scanner sc=new Scanner(System.in);
		int n, sum=0;
		System.out.println("숫자를 n 입력");
		n=sc.nextInt();
		
//		for(int a=1;a<=n;a++) {
//			sum+=a;
//		}
//		System.out.printf("1부터 %d까지의 합계는 %d입니다.",n,sum);
//		
		
		//쌤이 풀어주신 것
		for(int i=1; i<=n; i++) {
			
			sum+=1;
		}
		System.out.println("1부터 "+n+"까지의 합계: "+sum);

	}

}
