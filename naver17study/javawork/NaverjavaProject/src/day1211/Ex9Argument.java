package day1211;

public class Ex9Argument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메인 Argument 값 읽기 문제");
		/*
		 * 이상욱
		 * 삼성전자
		 * 홍보부
		 * 89
		 * 100
		 * 74
		 * 
		 * 이름(name), 회사명(emp), 부서(dep),
		 * 3과목 입사시험점수(score1, scroe2, score3)
		 * 를 읽어서 위의 데이터와 입사시험의 총합계(total)과
		 * 평균(average)-소수점 첫째자리까지(pritf) 출력하시오
		 * 
		 */
		String name=args[0];
		String emp=args[1];
		String dep=args[2];
		int score1=Integer.parseInt(args[3]);
		int score2=Integer.parseInt(args[4]);
		int score3=Integer.parseInt(args[5]);
		int total=score1+score2+score3;
		double average=(double)total/3;
		
		System.out.println("이름:"+name);
		System.out.println("회사명: "+emp);
		System.out.println("부서명: "+dep);
		System.out.println("입사시험점수1 : "+score1);
		System.out.println("입사시험점수2 : "+score2);
		System.out.println("입사시험점수3 : "+score3);
		System.out.println("입사시험 점수 합계: "+total);
		System.out.printf("입사시험 점수 평균: %3.1f\n",average);
		
	}

}
