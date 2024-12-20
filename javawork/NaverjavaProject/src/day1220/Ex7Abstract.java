package day1220;

import java.util.List;
import java.util.Vector;

public class Ex7Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다형성 처리 예
		 List<String> list=null;//List<String> 인터페이스 
		 list=new Vector<String>();
		 list.add("Red");//add라는 메서든 오버라이드 메서드
		 list.add("Green");
		 for(String s:list)
			 System.out.println(s);
		
		//현재 할당된 크기를 알아보는 capasity()이 메서드는
		//Vector만이 갖고있다.
		int n=((Vector<String>)list).capacity();//((Vector<String>)list). : 다운캐스팅
		System.out.println(n);
		
	}

}
