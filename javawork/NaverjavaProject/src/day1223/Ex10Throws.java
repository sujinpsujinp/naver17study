package day1223;

import java.util.Scanner;

public class Ex10Throws {

	public static void sum(String a, String b) throws NumberFormatException
	{
		int su1=Integer.parseInt(a);
		int su2=Integer.parseInt(b);
		
		int sum=su1+su2;
		System.out.println(a+"+"+b+"="+sum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자1 입력");
		String s1=sc.nextLine();
		System.out.println("숫자2 입력");
		String s2=sc.nextLine();
		
		try{//위에서 던진걸 호출하는 곳에서 받아서 처리
			sum(s1,s2);
		}catch (NumberFormatException e) {
			System.out.println("오류 발생"+e.getMessage());
		}finally {
			//예외 발생여부 상관없이 무조건 실행되는 영역
			System.out.println("Hello");
		}
		
		System.out.println("** 정상 종료 **");

	}

}
