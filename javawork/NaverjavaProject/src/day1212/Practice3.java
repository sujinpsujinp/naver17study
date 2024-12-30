package day1212;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		/*
		 * 상품(sang)과 수량(su),단가(dan)을 입력 받은 후 
		 * 총금액(total)을 출력하시오.
		 * 단, 수량이 5개 이상이면 총금액의 10프로를 할인된 금액
		 * 으로 출력해주세요.
		 * 
		 * 예)
		 * 상품영: 바나나킥
		 * 수량 : 5개
		 * 단가 : 1000원
		 * 총금액 : 4500원 
		 */
		String sang;
		int su, dan,total;
		
		System.out.println("상품을 입력하세요.");
		sang=sc.nextLine();
		System.out.println("수량을 입력하세요.");
		su=sc.nextInt();
		System.out.println("단가를 입력하세요.");
		dan=sc.nextInt();
		
		total=su<5?su*dan:(int)((su*dan)*0.9);
		System.out.println("상품명: "+sang);
		System.out.println("수량: "+su);
		System.out.println("단가: "+dan);
		System.out.println("총금액: "+total);
	}

}
