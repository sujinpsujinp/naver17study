package day1217;

public class Ex2Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []ch;//배열선언
		
		ch=new char[4];//0~3번 인덱스까지 데이터를 넣을 수 있다.
		
		//초기값 확인용 수업외 내가 입력
		for(int i=0;i<ch.length;i++)
			System.out.println("ch["+i+"]="+ch[i]);
		
		System.out.println("배열크기:"+ch.length);
		//각각의 배열에 데이터 넣기
		ch[0]='H';
		ch[1]=65;//'A'
		ch[2]='x';
		ch[3]='t';

		//출력 #1
		for(int i=0;i<ch.length;i++)//중간 조건식에 '=' 사용하면 오류발생 : 0~3까지만 배열이 있기때문
			System.out.println("ch["+i+"]="+ch[i]);
		System.out.println();
		
		//출력 #2
		for(char a:ch)
			System.out.println(a);
		
		System.out.println("=".repeat(50));
		char []ch2=new char[5];
		ch2=new char[] {'a','n','x','y','u'};//첫번째부터 0~4까지 들어감
		for(int i=0;i<ch2.length;i++)
		{
			System.out.println("ch2["+i+"]="+ch2[i]);
		}
		
		System.out.println("=".repeat(50));
		char []ch3= {'s','r','t','v','i'};//배열 선언하자마자 바로 값 넣어주기
		for(char a:ch3)//데이터만 출력하고 싶으면 ':'으로 출력
			System.out.println(a);
				
		
	}

}
