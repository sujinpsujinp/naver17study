package day1218;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ex3 4 5 2차배열
		int [][]arr1=new int[2][];//행의 개수만 먼저 설정
		arr1[0]=new int[3];//첫번째 행에 3열 지정
		arr1[1]=new int[5];//두번째 행에 5열 지정
		//행과 열 출력
		System.out.println("행 개수:"+arr1.length);
		System.out.println("0행의 열 개수:"+arr1[0].length);
		System.out.println("1행의 열 개수:"+arr1[1].length);
		
		//2차원 배열에 값 저장
		arr1[0][2]=50;
		arr1[1][1]=90;
		arr1[1][3]=70;
		
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr1[i].length;j++)
			{
				System.out.printf("%d,%d:%d\t",i,j,arr1[i][j]);
			}
			System.out.println();
			
		}
		System.out.println("=".repeat(40));
		
		//2차원 배열에 선언시 초기값 지정
		int [][]arr2={
				{15,25,35},
				{7,17,27,37},
				{2,12,32,42,52}
			
		};
		//행과 열 개수 출력
		System.out.println("행 개수:"+arr2.length);
		System.out.println("0행의 열 개수:"+arr2[0].length);
		System.out.println("1행의 열 개수:"+arr2[1].length);
		System.out.println("1행의 열 개수:"+arr2[2].length);
		
		for(int i=0;i<arr2.length;i++)
		{
			for(int j=0;j<arr2[i].length;j++)
			{
				System.out.print(arr2[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=".repeat(40));
		
		
	}

}
