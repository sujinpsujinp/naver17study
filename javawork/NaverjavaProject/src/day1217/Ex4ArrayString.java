package day1217;

public class Ex4ArrayString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []str1;
		str1=new String[4];//객체인 경우 null값으로 초기값 지정됨 >> null인 상태에서는 호출불가
		str1[0]="Hello";
		str1[3]="Kitty";
		
		for(int i=0;i<str1.length;i++)
			System.out.println("str1["+i+"]="+str1[i]);
		
		System.out.println("=".repeat(30));	
		String []str2;
		str2=new String[] {"초록색","분홍색","빨강색","노랑색"};
		for(String s:str2)
			System.out.println(s);
		
		System.out.println("=".repeat(30));	
		String []str3= {"김미나","안지영","홍길동","강한나"};
		for(String s:str3)
			System.out.println(s);
	}

}
