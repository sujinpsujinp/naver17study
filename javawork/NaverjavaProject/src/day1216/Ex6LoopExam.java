package day1216;

import java.util.Scanner;

public class Ex6LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 문자열 str을 입력 후 엔터를 누르면 
		 * 문자열 분석해서 대문자 소문자 소문자 각각의 갯수를 구해서 출력
		 * 사용할 문자메소드 : length(), charAt(인덱스) >> 길이 구해서 각각 for문 if문 
		 */
		Scanner sc=new Scanner(System.in);

		//내가 한 것
//		String str;
//		int lower=0,upper=0, number=0;
//		System.out.println("문자열 입력: ");
//		str=sc.nextLine().charAt(0);
//		
//		
//		for(int i=1;i==str.length();i++) {
//			if(str>='a' && str<='z')
//				lower++;
//			else if(str>='A' && str<='Z')
//				upper++;
//			else if(str>='0' && str<='9')
//				number++;
//		}
//		
		String str;
		int upperCount=0, lowerCount=0, numberCount=0;
		
		System.out.println("문자열을 입력하세요.");
		str=sc.nextLine();
		for (int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
//			if(ch>='A'&&ch<='Z')
//				upperCount++;
//			else if(ch>='a'&&ch<='z')
//				lowerCount++;
//			else if(ch>='0'&&ch<='9')
//				numberCount++;
			if(ch>=65 &&ch<=90)
				upperCount++;
			else if(ch>=97 &&ch<=172)
				lowerCount++;
			else if(ch>=48 && ch<=57)
				numberCount++;
			
		}
		
		System.out.println("대문자 개수:"+upperCount);
		System.out.println("소문자 개수:"+lowerCount);
		System.out.println("숫자 갯수:"+numberCount);
	}

}
