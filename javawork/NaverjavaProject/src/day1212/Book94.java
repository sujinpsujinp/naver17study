package day1212;

import java.util.Scanner;

public class Book94 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//책94p 예문
		
		//int charCode = 'A';
		//int charCode = 'a';
		int charCode = '5';
		
		if((charCode<=65)&(charCode<=90)) {
			System.out.println("대문자이군요.");
		}
		if((97<=charCode)&&(charCode<=122)) {
			System.out.println("소문자이군요.");
		}
		if((48<=charCode)&&(charCode<=57)) {
			System.out.println("0~9 숫자이군요.");
		}
		
		int value=6;
		//int value=7;
		
		if((value%2==0)||(value%3==3)) {
			System.out.println("2또는 3의 배수이군요.");
		}
		
		boolean result=(value%2==0||(value%3==0));
		if(!result) {
			System.out.println("2또는 3의 배수가 아니군요.");
		}
		
		/*
		//책 예문 배운걸로 바꿔보기
		Scanner sc=new Scanner(System.in);
		
		System.out.println("알파벳이나 숫자를 입력하세요");	
		int charCode;
		charCode=sc.nextInt();
		
		if((charCode<=65)&(charCode<=90)) {
			System.out.println("대문자이군요.");
		}
		if((97<=charCode)&&(charCode<=122)) {
			System.out.println("소문자이군요.");
		}
		if((48<=charCode)&&(charCode<=57)) {
			System.out.println("0~9 숫자이군요.");
		}
		*/
	}

}
