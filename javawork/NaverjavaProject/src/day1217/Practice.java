package day1217;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ex2~ 배열
		char []ch; //배열 선언
		int []num;
		String []text;
		
		ch=new char[3];//0~3번 인덱스까지 넣을 수 있음
		num=new int[4];
		text=new String[2];
		
		//초기값 확인
		for(int i=0;i<ch.length;i++)
			System.out.println("ch["+i+"]="+ch[i]);
		for(int i=0;i<num.length;i++)
			System.out.println("ch["+i+"]="+num[i]);//int는 초기값 0
		for(int i=0;i<text.length;i++)
			System.out.println("text["+i+"]="+text[i]);//객체타입은 초기값 null, null 상태에서는 호출불가
		System.out.println("=".repeat(50));
		
		//Ex9 max, min 비교
		int []num2= {25,32,55,87,55,67,120,-25,-55,47};
		int max=num2[0];
		int min=num2[0];
		System.out.println("배열 수 확인:"+num2.length); //배열 수 확인
		for(int i=0;i<num2.length;i++)
		{
			if(max<num2[i])
			{
				max=num2[i];
			}
			if(min>num2[i])
			{
				min=num2[i];
			}
		}
		System.out.println("max:"+max);
		System.err.println("min:"+min);
		System.out.println("=".repeat(50));
		
		int []datas= {12,34,54,20,33,59,41,44,27,21};
		System.out.println("인원수:"+datas.length);
		/*
		 * 위의 데이타를 분석하여 10대부터 50대까지의 각각의 인원수를 구하시오.
		 * 배열변수 []age를 이용하여 구하시오.
		 * 0번지에는 10대 인원수....
		 * 
		 * 출력양식
		 * 10대 : 1명
		 * 20대 : 3명...
		 * 
		 * 인원수 구하기
		 * %10ㅣㅣ
		 */
		int age[]=new int[5];
		
		for(int i=0;i<datas.length;i++)
		{
			//연령별 인원 수 구하기
			//10대일 경우 0번지 증가, 20대일 경우 1번지 증가
			age[datas[i]/10-1]++;
		}
		//출력
		for(int i=0;i<age.length;i++)
		{
			System.out.println(i+1+"0대 :"+age[i]+"명");
		}
		
		//Ex6 등수 구하기 -동점은 동순위 부여
		int []score= {56,89,100,89,67,100,90,54};
		int []rank=new int[score.length];
		
		for(int i=0;i<score.length;i++)
		{
			rank[i]=1;
			for(int j=0;j<score.length;j++)
			{
				if(score[i]<score[j])
					rank[i]++;
			}
			//출력
			
		}
		System.out.println("번호\t점수\t등수");
		System.out.println("=".repeat(30));
		for(int i=0;i<score.length;i++)
			System.out.println(i+1+"\t"+score[i]+"\t"+rank[i]);
		
	}

}
