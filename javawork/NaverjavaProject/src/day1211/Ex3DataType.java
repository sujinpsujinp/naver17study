package day1211;

public class Ex3DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f1=3.6f;//뒤에 f를 붙여야4바이트로 저장됨(f가 없으면 double로 인식함)
		double f2=5.6;
		System.out.println("f1="+f1);
		System.out.println("f2="+f2);
		
		float f3=2.12356789f;
		double f4=1232.123456789;
		
		System.out.println("f3="+f3);
		System.out.println("f4="+f4);
		
		//pritf : jdk5부터 추가된 기능, 변환기호를 이용한 출력문 : 실수형:%f
		//제어문자열 : \n(줄넘김), \t(다음탭), \\(\한번만 출력), \"("출력)
		System.out.printf("\n\nf3=%f\nf4=%f\n\n",f3,f4);//변환기호 갯수만큼 변수명 나열
		System.out.printf("\n\nf3=%5.1f\nf4=%5.1f\n\n",f3,f4);//%5.1f전체자릿수 5, 소숫점자릿수1
		
	}

}
