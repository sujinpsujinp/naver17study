package day1212;

import java.util.Date;
import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ex6Date 현재 날짜와 시간을 얻기
		//Date 클래스는 jdk1.1이후에 deprecate됨 - Calander를 권장
		Date today=new Date();
		
		int curYear=today.getYear()+1900;//1900을 뺀 값을 반환하므로
		int curMonth=today.getMonth()+1;//0~11을 반환하므로 +1해야함
		int curDate=today.getDate();
		//요일 숫자 구하기(0~6:일~토)
		int weekDay=today.getDay();
		System.out.println(weekDay);
		
		//오늘은 목요일입니다.
		String week=weekDay==0?"일":weekDay==1?"월":weekDay==2?"화":weekDay==3?"수":weekDay==4?"목":weekDay==5?"금":"토";
		System.out.printf("오늘날짜는: %d-%d-%d-%s요일 \n",curYear,curMonth,curDate,week);
		
		//Ex7 Scanner
		Scanner sc=new Scanner(System.in);//키보드로 입력 시
		
		String sangpum;
		int price;
		System.out.println("상품가격입력");
		price=sc.nextInt();//숫자만 읽고 엔터는 버퍼로 들어간다.(숫자 다음 문자를 읽으라하면 안됨)
		sc.nextLine();//버퍼의 엔터를 읽어서 없앤다.
		System.out.println("상품명입력");
		sangpum=sc.nextLine();//버퍼의 엔터를 읽어온다.(없을 경우 키보드로부터 읽어온다.)
		System.out.println(sangpum+"상품의 가격은"+price+"원 입니다.");
		
	}

}
