package day1218;

import java.util.Scanner;

public class Ex5Array2Binggo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*3행 3열의 2차원 배열을 생성 후 1~3사이의 난수를 발생하여
		 * 가로,세로, 각 대각선을 비교하여 같은 값이 나오면 빙고:2개
		 * 없을 경우 "꽝!!!"출력
		 * 
		 * 엔터를 누를때마다 다시 난수 발생
		 * q나Q를 누르면 프로그램 종료
		 */
		Scanner sc=new Scanner(System.in);
		int [][]puzzle=new int[3][3];
		int binggo;
		
		while(true)
		{
			//2차원 배열에서 1~3사이의 난수 발생
			for(int i=0;i<puzzle.length;i++)
			{
				for(int j=0;j<puzzle.length;j++)
				{
					puzzle[i][j]=(int)(Math.random()*3)+1;
				}
			}
			
			//출력
			for(int i=0;i<puzzle.length;i++)
			{
				for(int j=0;j<puzzle.length;j++)
				{
					System.out.printf("%3d",puzzle[i][j]);
				}
				System.out.println();
			}
			
			//가로 세로 대각선 비요하여 같은 숫자가 나온 갯수 출력
			//없으면 꽝
			binggo=0;
			//빙고수 계산
			
			
			//내가 만든 코드
//			for(int i=0;i<puzzle.length;i++)
//			{
//				for(int j=0;j<puzzle.length;j++)
//				{
//					if(puzzle[i][j]==puzzle[i][j]&&puzzle[i][j]==puzzle[i][j])//가로
//						binggo++;
//					if(puzzle[i][j]==puzzle[i+1][j]&&puzzle[i+1][j]==puzzle[i+2][j])//세로
//						binggo++;
//					
//				}
//				
//			}
			//선생님이 짜주신 코드
			for(int i=0;i<puzzle.length;i++)
				{
					//가로
					if(puzzle[i][0]==puzzle[i][1]&&puzzle[i][1]==puzzle[i][2])
						binggo++;
					//세로
					if(puzzle[0][i]==puzzle[1][i]&&puzzle[1][i]==puzzle[2][i])
						binggo++;
				}
			//대각선
			if(puzzle[0][0]==puzzle[1][1]&&puzzle[1][1]==puzzle[2][2])
				binggo++;
			if(puzzle[0][2]==puzzle[1][1]&&puzzle[1][1]==puzzle[2][0])
				binggo++;
			
			if(binggo==0)
				System.out.println("\t꽝!!!!");
			else
				System.out.println("\t\t빙고"+binggo+"개");
			
			//p(대소문자 상관없음)입력 시 종료
			if(sc.nextLine().equalsIgnoreCase("q")) 
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			System.out.println("-".repeat(20));
		}
		
		

	}

}
