package day1212;

import java.util.Scanner;

public class Ex8Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String sangpum;
		int price;
		
		System.out.println("상품 가격 입력");
		price=sc.nextInt();//숫자만 읽고 엔터는 버퍼로 들어간다.(숫자 다음 문자를 읽으라하면 안됨)
		// 실무에서 이런걸  쓰려면 문자로 읽어서 int로 형변환을 해야함
		sc.nextLine();//버퍼의 엔터를 읽어서 없앤다.
		System.out.println("상품명 입력");
		sangpum=sc.nextLine();//버퍼의 엔터를 읽어온다.(없을 경우 키보드로부터 읽어온다.)
		
		System.out.println(sangpum+" 상품 가격은"+price+"원 입니다.");
		
		
		

	}

}
