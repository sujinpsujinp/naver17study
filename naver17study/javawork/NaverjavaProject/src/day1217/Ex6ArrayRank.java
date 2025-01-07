package day1217;

public class Ex6ArrayRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//등수 구하기-동점은 동순위 부여
		int []score= {56,89,100,89,67,100,90,54};
		int []rank=new int[score.length];//score.length로 하면 위에 score 배열을 추가하거나 제거해도 상관없음
		for (int i=0;i<score.length;i++)
		{
			rank[i]=1;
			for(int j=0;j<score.length;j++)
			{
				if(score[i]<score[j])
					rank[i]++;
			}
		}
		System.out.println("번호\t점수\t등수");
		System.out.println("=".repeat(30));
		for(int i=0;i<score.length;i++)
			System.out.println(i+1+"\t"+score[i]+"\t"+rank[i]);
		
		
		
		

	}

}
