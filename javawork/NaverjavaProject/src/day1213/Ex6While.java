package day1213;

public class Ex6While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=65;
		while(a<=90) {
			//System.out.printf("%c",a++);
			System.out.print((char)a++);//(char)없으면 숫자로 출력됨 char로 형변환 해줘야 문자 출력
		}
		
		System.out.println();
		
		char b='a';//97
		//do-while문을 이용해서 a부터z까지 출력
		//아스키코드를 몰라도 조건을 'a' or 'z'로 주면 알아서 아스키코드로 확인함
		do {
			System.out.print(b++);
			
		}while(b<='z');
		
		System.out.println();
		
		int n=0;
		while(n<=10) {
			n++;
			if(n%2==0)
				continue;//조건식으로 이동(while이나 do-while에서)
			System.out.printf("%3d",n++);
			
		}
		
		
	}

}
