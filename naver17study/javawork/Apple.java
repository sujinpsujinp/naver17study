//Apple.java로 컴파일하기위한 기본 자바클래스 생성해보세요

public class Apple
{
	public static void main(String []args)
	{
	System.out.println(args[0]); //args의 0번 배열값을 출력
	System.out.println(args[1]); //args의 1번 배열값을 출력
	
	System.out.println("두 수를 더해보자");
	System.out.println(args[0]+args[1]); //문자열이라 10, 20 입력 시 1020 출력

	//문자열을 계산을 하기위한 숫자로 변환하려면 Integer.parseInt 를 사용한다.
	int su1=Integer.parseInt(args[0]);
	int su2=Integer.parseInt(args[1]);
	System.out.println("두 수의 합은 "+(su1+su2)+"입니다.");
	
	}
}