package day1219;

import java.util.Scanner;

public class Ex2ObjectArray {
	
	public static void dataInput(Student s)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("학생이름은?");
		String name=sc.nextLine();
		System.out.println("학생주소는?");
		String addr=sc.nextLine();
		System.out.println("학생혈액형은?");
		String blood=sc.nextLine();
		
		s.changeStudent(name, addr, blood);
		System.out.println();
	}
	
	public static void showTitle()
	{
		System.out.println("이름\t혈액형\t주소");
		System.out.println("=".repeat(35));
	}
	
	public static void writeStudent(Student s)
	{
		System.out.println(s.getStuName()+"\t"+s.getStuBlood()+"형\t"+s.getStuAddress());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int inwon;
		Student []stuArray;
		
		System.out.println("입력할 인원은?");
		inwon=Integer.parseInt(sc.nextLine());
		//메모리할당
		stuArray=new Student[inwon];
		
		//데이터 입력
		for(int i=0;i<stuArray.length;i++)
		{
			stuArray[i]=new Student();//생성
			dataInput(stuArray[i]);//객체타입은 주소가 전달이 된다(주소를 통해서 데이터가 들어온다)
		}
		
		//제목출력
		showTitle();
		//내용출력
		for(int i=0;i<stuArray.length;i++)
			writeStudent(stuArray[i]);
		
		
	}

}
