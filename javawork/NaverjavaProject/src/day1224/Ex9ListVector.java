package day1224;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex9ListVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1=new Vector<String>();//기본 10개가 할당
		//List<String> list2=new Vector<String>(5);//기본 5개가 할당
		List<String> list2=new Vector<String>(5,3);//기본 5개 할당, 3개씩 증가
		
		System.out.println("List1의 데이터 갯수"+list1.size()+",할당갯수:"
				+((Vector<String>)list1).capacity());//capacity()메서드는 오버라이드 메서드가 아님
		System.out.println("List2의 데이터 갯수"+list2.size()+",할당갯수:"
				+((Vector<String>)list2).capacity());//capacity()메서드는 오버라이드 메서드가 아님
				//capacity는 vector에 있는거고 list2는 list로 선언해서 자식걸 가져오기위해서 다운캐스팅을 해준것!
		
		list2.add("김상아");
		list2.add("이미지");
		list2.add("홍상수");
		list2.add("이진");
		list2.add("이효리");
		list2.add("김상아");
		//처음 할당된 5개가 넘어가면 자동으로 10개로 늘어남
		System.out.println("List2의 데이터 갯수"+list2.size()+",할당갯수:"
				+((Vector<String>)list2).capacity());//capacity()메서드는 오버라이드 메서드가 아님
		
		//출력 방법은 1번과 2번을 가장 많이 사용함
		System.out.println("출력 방법 1");
		for(String s:list2)
			System.out.println(s+"  ");
		System.out.println();

		System.out.println("출력 방법 2");
		for(int i=0;i<list2.size();i++) {
			System.out.print(i+1+":"+list2.get(i)+"  ");//get은 i번지 데이터를 꺼내오겠다!
		}System.out.println();
		
		System.out.println("출력 방법 3");
		Iterator<String> iter=list2.iterator();
		while(iter.hasNext())
			System.out.println(iter.next()+"  ");
		System.out.println();
		
		System.out.println("출력 방법 4");
		Object []ob=list2.toArray();
		for(Object s:ob)
			System.out.println(s+"  ");
		
		
		
	}

}