package day1227;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MySawon
{
	public void sawonAdd(String name);
}

@FunctionalInterface
interface Sales
{
	public void sangPumAdd(String sangpum, int su,int dan);
}


public class Ex3Lambda {
	MySawon sawon1=(name)->System.out.println(name+"사원 추가함!");
	
	Sales sa=(sang, su,dan)->{
		System.out.println(sang+"상품 등록");
		System.out.println("수량: "+su);
		System.out.println("단가: "+dan);
		System.out.println("총금액: "+su*dan+"원");
		System.out.println("=".repeat(30));
	};
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3Lambda ex3=new Ex3Lambda();
		ex3.sawon1.sawonAdd("홍길동");
		ex3.sawon1.sawonAdd("이영자");
		
		ex3.sa.sangPumAdd("딸기", 5, 9000);
		ex3.sa.sangPumAdd("오렌지", 3, 5000);
		
		System.out.println("List 데이터를 람다식으로 출력");
		List<String> list1=Arrays.asList("빨강","노랑","초록","분홍","검정");
		System.out.println("출력1");
		for(String s:list1)
			System.out.print(s+"  ");
		System.out.println();
		System.out.println("출력2");
		list1.forEach(s->System.out.println(s));//forEach : 파라미터를 s가 받아서 출력하겠다.
		
		
	}

}
