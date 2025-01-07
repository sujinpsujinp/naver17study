package day1217;

import java.util.Date;
import java.util.Scanner;

public class Ex1Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 년도와 월을 입력하면 해당 월의 달력을 출력하시오.
		 * 달력이 제대로 나오게 하려면
		 * 1. 그 월의 1일이 무슨 요일인가? >>date class 생성되어야함
		 * 2. 그 월이 몇일까지 있는가? 
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		int inputYear, inputMonth;
		int endDays;//몇일까지 있는지
		int weekDay;//요일숫자
		boolean leapYear;
		
		
		System.out.println("년도를 입력해주세요.");
		inputYear=sc.nextInt();
		System.out.println("월을 입력해주세요.");
		inputMonth=sc.nextInt();
		
		//1~12월이 아닌 경우 프로그램 종료
		if(inputMonth<1 ||inputMonth>12)
		{
			System.out.println("잘못된 월입니다.");
			return;//현제 main 메서드 종료
		}
		
		//윤년인지 아닌지 구하기
		leapYear=inputYear%4==0 && inputYear%100!=0 ||inputYear%400==0;
		if(leapYear)
			System.out.println(inputYear+"년도는 윤년입니다.");
		else
			System.out.println(inputYear+"년도는 평년입니다.");
		
		//입력한 년도와 월의 1일에 대한 Date 클래스 생성
		Date inputDate=new Date(inputYear-1900, inputMonth-1, 1);
		//그 날짜에 대한 요일 숫자 구하기
		weekDay=inputDate.getDay();//0:일...6:토
		
		//해당 월이 며칠까지 있는지 구하기 >>제일 많은걸 default로 빼면 됨
		switch(inputMonth)
		{
		case 2:
			endDays=leapYear?29:28;
			break;
		case 4: case 6: case 9: case 11:
			endDays=30;
			break;
		default:
			endDays=31;
		}
		
		//제목부터
		System.out.println("=".repeat(50));
		System.out.println("\t\t["+inputYear+"년 "+inputMonth+"월]");
		System.out.println("=".repeat(50));
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));
		
		//weekDay 숫자만큼 탭 띄우기
		for(int i=1;i<=weekDay;i++)
			System.out.print("\t");
		
		//1일부터 endDays까지 출력(토요일은 출력 후 엔터)
		for(int i=1;i<=endDays;i++)
		{
			++weekDay;//이렇게 증가하면 첫 토요일이 7...그다음부터 토요일이 7의 배수가 됨
			System.out.printf("%2d\t",i);
			if(weekDay%7==0)
				System.out.println();
			
		}
		
		

	}

}
