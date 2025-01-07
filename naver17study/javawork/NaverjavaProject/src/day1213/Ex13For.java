package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 2
		 * 5명의 나이를 입력 후 40세 이상과 40세 미만이 각각 몇명인지 출력하고
		 * 평균 나이도 같이 출력하시오. //합계도 구해야 평균을 구함
		 * (for문 사용)
		 */
		Scanner sc=new Scanner(System.in);
		
		//내가 푼 것		
//		int n, age, count1=0, count2=0, sum=0, avg;
//			
//		for(n=1;n<=5;n++) {
//		System.out.println("나이를 입력하세요.");
//		age=sc.nextInt();	
//			if(age>=40) {
//				count1++;
//			}else if(age<=40) {
//				count2++;		
//			}else ;//continue;		
//			sum+=age; //이 문장을 for문 밖에 두면 에러가 나옴 age를 for문 안에서 입력받기때문
//
//		}
//		avg=sum/n;
//		System.out.println("40세 이상: "+count1+"명 입니다.");
//		System.out.println("40세 이하: "+count2+"명 입니다.");
//		System.out.println("나이 평균은: "+avg);

		
		//쌤이 풀어주신 것
		int count1=0, count2=0, sum=0, age;
		double avg;
		
		for(int i=1; i<=5; i++) {
			System.out.println(i+"번째 나이를 입력");
			age=sc.nextInt();
			//0~100세를 벗어나는 경우 다시 입력(인원수 제외)
			//continue: for문은 i++로 이동
			
			if(age>100 || age<0) {
				System.out.println("나이를 다시 입력해주세요.");
				i--;//for문 i++로 이동하니까 인원수를 제외하려면 i--가 들어가야함
				continue;
			}
			sum+=age;	
			if(age>=40)
				count1++;
			else count2++;
			
		}
		avg=(double)sum/5;
		System.out.println("40세 이상 인원수"+count1);
		System.out.println("40세 이하 인원수"+count2);
		System.out.println("평균나이"+avg);
	}

}
