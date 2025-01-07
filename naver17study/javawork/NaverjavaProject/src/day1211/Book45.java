package day1211;

public class Book45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//45페이지 Long타입에 아주 큰 숫자를 대입하려면
		long var1=10;
		long var2=20L;
		//long var3=100000000000; //int 타입의 범위를 초과하므로 에러 발생, 
		long var4=100000000000L; //숫자 뒤에 L,l을 넣어주면 Long으로 인식하기 때문에 에러발생안함
		
		System.out.println(var1);
		System.out.println(var2);
		//System.out.println(var3);
		System.out.println(var4);
	}

}
