package day1212;

import java.util.Scanner;

public class Ex7Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);//키보드로부터 입력 시
		String word;
		System.out.println("문장을 입력해보세요.");
//		word=sc.next();//는 한 단어만 읽어옴
//		System.out.println("내가 입력한 단어는 \""+word+"\" 입니다.");
		
		word=sc.nextLine();//엔터를 누르면 그 한 줄을 통채로 읽어옴
		System.out.println("내가 입력한 문장은 \""+word+"\" 입니다.");
		
		int age;
		System.out.println("나이를 입력하세요.");
		age=sc.nextInt();//문자로 입력하거나 문자가 포함되면 에러 발생
		System.out.println("내 나이는"+age+"세 입니다.");
		
		
	}

}
