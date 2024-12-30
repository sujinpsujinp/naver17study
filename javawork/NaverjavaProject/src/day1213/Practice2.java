package day1213;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//Practice2는 입력받는 내용 위주
		
		//Ex2Switch ~5
		/*
		 * 년도와 월을 입력 후 윤년인지 평년인지 출력하고
		 * 그 월이 몇일까지 있는지 구하시오
		 * 윤년이란 년도%4==0 && 년도%100!=0 || 년도%400==0
		 */
		int year, month, days;
		
		System.out.println("년도와 월을 입력하시오.");
		year=sc.nextInt();
		month=sc.nextInt();
		
		boolean yearday=year%4==0 && year%100!=0 || year%400==0;
		
		switch(month) {
			case 1:	 case 3: case 5: case 7: case 8: case 10: case 12:
				days=31;
				break;
			case 2:
				days=yearday?28:29;
				break;
			case 4: case 6: case 9: case 11:
				days=30;
				break;
			default:
				days=-1;// default를 입력해야해서 아무거나 입력한 값
		
		}
		if(days==-1) {
			System.out.println("1~12월을 벗어난 값입니다.");
		}
		else {
		System.out.printf("%d년 %d월은 %d일까지 있습니다.",year,month,days);
		}
		
	}

}
