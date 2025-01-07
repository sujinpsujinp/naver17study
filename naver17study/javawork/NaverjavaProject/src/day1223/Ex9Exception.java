package day1223;

import java.util.Date;
import java.util.Scanner;

public class Ex9Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ex8번의 예제에서 catch 2개를 하나로 합치기
		Scanner sc=new Scanner(System.in);
		
		int birthYear,age;
		
		try {
		System.out.println("태어난 년도는?");
		birthYear=Integer.parseInt(sc.nextLine());//잘못입력 시 바로 catch로 이동, 
		//오류가 같이 발생하지 않으니 발생하는 곳의 메세지를 노출시킴
		
		Date date=null;
		age=(date.getYear()+1990)-birthYear;
		
		System.out.println("내 나이는 "+age+"세 입니다.");
		}catch (NumberFormatException|NullPointerException e) {
			//둘 중 하나의 Exception 발생 시 catch로 이동
			System.out.println("예외 발생"+e.getMessage());
		}
		
		
		System.out.println("정상종료");
		
	}

}
