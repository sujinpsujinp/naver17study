package day1213;

import java.util.Scanner;

public class Ex7While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int score, total=0, count=0;//대입연산자, 증감연산자를 쓸 변수는 초기값이 무조건 있어야함
		double avg;
		
		while(true) 
		{
			System.out.print("점수 입력(종료 시 0):");
			score=sc.nextInt();
			if(score<0||score>100) {
				System.out.println("\t잘못 입력된 점수입니다.");
				continue;//다시 처음으로(조건식) 이동
			}
			if(score==0)
				break;
			count++;
			total+=score;
		}
		avg=(double)total/count;//double 형변환 해줘야 소수점 출력

		System.out.println("총 입력한 점수 갯수: "+count);
		System.out.println("점수의 총 합계: "+total);
		System.out.printf("점수들의 평균: %5.2f\n",avg);
		
	}

}
