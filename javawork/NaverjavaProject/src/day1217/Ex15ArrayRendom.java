package day1217;

import java.util.Random;

public class Ex15ArrayRendom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []numbers=new int[20];
		
		/*
		 * 배열에 1~50 사이의 난수 20개를 구하여 넣고
		 * 오름차순으로 정렬해서 출력을 하시오.
		 */
		Loop:
		for(int i=0;i<numbers.length;i++)
		{
			numbers[i]=(int)(Math.random()*50)+1;
			//이전에 발생한 값이랑 같을 경우 다시 구하기-중복처리
			//내가 짠 코드
//			for(int j=0;j<i;j++)//int j=i+1로 두면 중복 발생함 이유를 모르겠네
//		{
//				if(numbers[i] == numbers[j])
//				{
//					//모르겠음 계속 중복나옴
//					i--;
//					//numbers[i]=(int)(Math.random()*50)+1;
//				}
//			}
			//쌤이 알려주신 코드
			for(int j=0; j<i; j++)//3번째에 있는걸 비교하면 맨 앞에서부터 비교를 해야해서 j는 0부터 비교가 맞음
			{
				if(numbers[i]==numbers[j])
				{
					i--;
					//break;//방법1
					continue Loop;//i++로 이동
				}
			}
			
			
			
			
		}
		
		//정렬
		for(int i=0;i<numbers.length-1;i++)
		{
			for(int j=i+1;j<numbers.length;j++)
			{
				if(numbers[i]>numbers[j])
				{
					int temp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}
			}
			
		}
		//출력- 한줄에 5개씩만 출력
		for(int i=0;i<numbers.length;i++)
		{
			System.out.print(i+":"+numbers[i]+"\t");
			if((i+1)%5==0)
				System.out.println();
		}
		
		
	}

}
