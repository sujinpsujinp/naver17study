package day1211;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ex1DataType 정수형 byte : 범위 -128~127
		byte num1=100;
		byte num2=(byte)156;//그냥 156으로 하면 에러발생 (byte)로 형변환, 2의 보수로 결과값 노출
		//2의 보수는 128 16 2 > 2진법 > 1의 보수 > +1 하면 2의 보수 나옴
		System.out.println("숫자1 : "+num1);
		System.out.println("숫자2 : "+num2);
		 
		//Ex2DataType 정수형 int
		int score1=95;
		int score2=77;
		System.out.println("합계: "+score1+score2);//합계=String이므로 String+int=int
		//int를 먼저 계산해주어야 알맞는 값을 노출
		System.out.println("합계: "+(score1+score2));
		//진법 변환은 Book43에서 한번 복습했으므로 pass
		
		//Ex3DataType 실수형double, float
		//제어문자열 : \n(줄넘김), \t(다음탭), \\(\한번만 출력), \"("출력)
		float f1=125524.217f;//마지막에 f를 붙여야만 오류 발생하지 않음
		double b1=12345.521;
		System.out.println("f1: "+f1);
		System.out.println("b1: "+b1);
		//printf 변환기호를 이용한 출력문
		System.out.printf("\nf1: %2.2f\nb1: %3.2f\n",f1,b1);//%5.1f전체자릿수 5, 소숫점자릿수1
		
		//Ex4DataType 날짜출력, 공백 출력
		int year=2024;
		int month=8;
		int day=4;
		//2024-12-11이런 형식으로 출력:정수는 변환기호가 %d
		System.out.println(year+"-"+month+"-"+day);
		System.out.printf("%d-%d-%d\n",year,month,day);
		//2024-05-03이렇게 나오게 출력:정수는 변환기호가 %02d=2자리보다 작을 경우 남는 곳은 0으로 표기
		System.out.printf("%02d-%02d-%02d\n",year,month,day);
		System.out.printf("공백 확인용%5d\n",num1);
		System.out.printf("공백 확인용2%-5d얍\n",num1);
		
		//Ex5DataType 문자형char, 아스키코드
		char ch1='a';
		char ch2='나';
		System.out.println("문자 출력"+ch1+ch2);
		//pritf출력 시 1글자 :%c, 문자열: %s
		System.out.printf("ch1: %c ch2: %c\n",ch1,ch2);
		System.out.printf("ch1: %d ch2: %d\n", (int)ch1, (int)ch2);//아스키코드로 변환되어 노출
		
		//Ex6DataType String(객체타입), 여백주기
		String str1="Banana";
		String str2=new String("Apple");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("\t"+str1);
		System.out.println("\t\t"+str2);
		//printf에서 문자열의 변환기호는 %s
		System.out.printf("%20s\n",str1);
		System.out.printf("%40s\n",str2);
		
		//Ex8Argument argument에 저장된 값 가져오기
		String name=args[0];
		String location=args[1];
		int birthYear=Integer.parseInt(args[2]);
		int age=2024-birthYear;
		int sco1=Integer.parseInt(args[3]);
		int sco2=Integer.parseInt(args[4]);
		int sco3=Integer.parseInt(args[5]);
		int total=sco1+sco3+sco3;
		double average=total/3.0;
		
		System.out.println("이름: "+name);
		System.out.println("지역: "+location);
		System.out.println("나이: "+age);
		System.out.println("첫번째 점수: "+sco1);
		System.out.println("두번째 점수: "+sco2);
		System.out.println("세번째 점수: "+sco3);
		System.out.println("총 점: "+total);
		System.out.printf("평 균: %3.2f ",average);
			
	}

}
