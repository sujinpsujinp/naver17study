package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex11Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		/*
		 * 년(year), 월(month), 일(day)를 입력 후
		 * 해당날짜에 대한 Date 클래스 생성 후(myDate)
		 * myDate 를 이용해서 년도, 월, 일, 요일(week)을 구해서 출력하시오.
		 * 요일은 요일숫자(weekNum)를 먼저 얻은 후 요일을 구해서 출력
		 */
		/*
		Date myDate=new Date();
		int year,month,day;
		int week;
		
		System.out.println("년도 입력");
		year=sc.nextInt();
		System.out.println("월 입력");
		month=sc.nextInt();
		System.out.println("일 입력");
		day=sc.nextInt();
		
		
		//week=day==0?"일":day==1?"월":day==2?"화":day==3?"수":day==4?"목":day==5?"금":"토";;
		System.out.println(week);
		System.out.println(year+"년"+month+"월"+day+"일");
		*/ // 내가 했던거
		int year,month,day,weekNum;
		String week;
		Date myDate;
		System.out.println("년도 입력");
		year=sc.nextInt();
		System.out.println("월 입력");
		month=sc.nextInt();
		System.out.println("일 입력");
		day=sc.nextInt();
		
		//입력한 날짜에 대한 date 클래스 생성
		myDate=new Date(year-1900,month-1,day);
		
		weekNum=myDate.getDay();//요일숫자
		
		System.out.println("년도 :"+(myDate.getYear()+1900));
		System.out.println("월 :"+(myDate.getMonth()+1));
		System.out.println("일 :"+(myDate.getDate()));
		System.out.println((weekNum==0?"일":weekNum==1?"월":weekNum==2?"화":weekNum==3?"수":weekNum==4?"목":weekNum==5?"금":"토")+"요일입니다.");
		
		
	}

}
