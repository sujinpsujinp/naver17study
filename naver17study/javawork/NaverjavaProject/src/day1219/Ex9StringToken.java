package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="red|green|yellow|while|black";
		//String msg="red,green,yellow,while,black";
		//|분리해서 출력
//		String []arr=msg.split("|");//잘안됨
//		for(String a:arr)
//		{
//			System.out.println(a);
//		}
		
		StringTokenizer st=new StringTokenizer(msg, "|");
		System.out.println("분리할 총 토큰수: "+st.countTokens());
		
		//countTokens는 토큰을 읽을때마다 갯수가 줄어듬
		//이런식으로 반복문을 돌리면 3번만 반복
//		for(int i=0;i<st.countTokens();i++)//countTokens 고정값이 아니고 계속 바뀜 한번 읽으면 4, 두번째는 3
//		{
//			System.out.println(st.nextToken());
//		}
		
		//방법1
		int count=st.countTokens();
		for(int i=0;i<count;i++)
		{
			System.out.println(st.nextToken());
		}
		System.out.println();
		
		StringTokenizer st2=new StringTokenizer(msg, "|");
		//방법2
		while(st2.hasMoreTokens())//하나라도 남아있으면 true
		{
			System.out.println(st2.nextToken());
		}
		System.out.println();
		
		String []arr2=msg.split("|");
		System.out.println("총 "+arr2.length+"개");
		
		String []arr3=msg.split("\\|");//정규표현식
		System.out.println("총 "+arr3.length+"개");
		for(String a:arr3)
			System.out.println(a);
		System.out.println();
		
		//아래 데이터를 .으로 분리하여 출력하시오.(split)
		String msg2="이미자.손태영.강호동.이영자.박진아";
		String []arr4=msg2.split("\\.");
		System.out.println("총 "+arr4.length+"개");
		for(String b:arr4)
			System.out.println(b);
		System.out.println();
		
	}

}
