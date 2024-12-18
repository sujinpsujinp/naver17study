package day1219;

import java.util.Scanner;

public class Ex12SawonArray {
	
	/*
	 * showTitle : 제목 출력
	 * 사원명 직급 기본급 수당 가족수당 세금 실수령액
	 */
	public static void showTitle()
	{
		System.out.println("사원명\t직급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(50));
	}
	
	// writeSawon(Sawon sawon) : 한개의 사원 데이터 출력
	public static void writeSawon(Sawon sawon)
	{
		System.out.println(sawon.getSawonName()+"\t"+sawon.getPosition()+"\t"+sawon.getsuDang()+"\t"
					+sawon.getFamSuDang()+"\t"+sawon.getTax()+"\t"+sawon.getNetPay());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		int inwon;
		Sawon []mySawon;
		/*
		 * 인원수를 입력 후 인원수만큼 배열 메모리 할당
		 */
		System.out.println("인원수를 입력하세요.");
		inwon=Integer.parseInt(sc.nextLine());
		mySawon=new Sawon[inwon];
		
		/* 배열에 데이터 입력 후 생성자를 통해서 데이터 저장하기*/
		for(int i=0;i<mySawon.length;i++)
		{
			System.out.println("사원이름?");
			String sawonName=sc.nextLine();
			System.out.println("직급은?");
			String position=sc.nextLine();
			System.out.println("가족수는??");
			int famSu=Integer.parseInt(sc.nextLine());
			
			mySawon[i]=new Sawon(sawonName, position, famSu);
			System.out.println();
			
		}		

		//제목 출력
		showTitle();
		
		//반복문 통해서 데이터 출력하는 메서드 호출
		for(int i=0;i<mySawon.length;i++)
			writeSawon(mySawon[i]);
		
		

	}

}
