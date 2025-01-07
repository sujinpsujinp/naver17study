package day1219;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex12SawonArray {
	
	/*
	 * showTitle : 제목 출력
	 * 사원명 직급 기본급 수당 가족수당 세금 실수령액
	 */
	public static void showTitle()
	{
		System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
	}
	
	// writeSawon(Sawon sawon) : 한개의 사원 데이터 출력
	public static void writeSawon(Sawon sawon)
	{
		NumberFormat nf=NumberFormat.getIntegerInstance();//3자리 넘어가면 ,찍도록
		System.out.println(sawon.getSawonName()+"\t"+sawon.getPosition()+"\t"+nf.format(sawon.getGibonPay())+"\t"+nf.format(sawon.getsuDang())+"\t"
					+nf.format(sawon.getFamSuDang())+"\t\t"+nf.format(sawon.getTax())+"\t"+nf.format(sawon.getNetPay()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		int inwon;
		Sawon []mySawon;
		/*
		 * 인원수를 입력 후 인원수만큼 배열 메모리 할당
		 */
		System.out.println("사원수를 입력하세요.");
		inwon=Integer.parseInt(sc.nextLine());
		mySawon=new Sawon[inwon];//할당만! 초기값은 null인 상태!
		
		/* 배열에 데이터 입력 후 생성자를 통해서 데이터 저장하기*/
		for(int i=0;i<mySawon.length;i++)
		{
			System.out.println("사원이름?");
			String sawonName=sc.nextLine();
			System.out.println("직급은?");
			String position=sc.nextLine();
			System.out.println("가족수는?");
			int famSu=Integer.parseInt(sc.nextLine());
			
			
			System.out.println();
			//사원생성 방법 2-내가한 것
			mySawon[i]=new Sawon(sawonName, position, famSu);//디폴트
			//사원 생성 방법1 강사님이 만드신 것
//			mySawon[i]=new Sawon();
//			mySawon[i].setSawonName(sawonName);
//			mySawon[i].setPosition(position);
//			mySawon[i].setFamSu(famSu);
		}		

		//제목 출력
		showTitle();
		
		//반복문 통해서 데이터 출력하는 메서드 호출
		for(Sawon s:mySawon)
		writeSawon(s);
			//for(int i=0;i<mySawon.length;i++)
		//	writeSawon(mySawon[i]);
		
		

	}

}
