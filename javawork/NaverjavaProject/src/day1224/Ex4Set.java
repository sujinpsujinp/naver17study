package day1224;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Set 인터페이스를 구현한 클래스로는 HashSet과 TreeSet이 있다.
 * Set 타입의 특징 : 1. 중복데이터를 허용하지 않는다.
 * 					 2. 비순차적이다.(추가한 순서대로 들어가지 않는다.)
 * 					 	HashSet : 임의로 정해짐, TreeSet:오름차순으로 정해짐
 * 
 * 모든 컬렉션 타입(Set, Map, List)은 제네릭스를 이용하여 타입을 지정한다.
 * 모든 컬렉션은 원래 오브젝트 타입만 추가되는데 jdk5 이후로
 *  오토박싱(박스=클래스)에 의헤 기본형도 자동의 오브젝트(클래스로 바뀌어 들어감)화 되어서 들어간다.
 */
public class Ex4Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set<Integer> set1=new HashSet<Integer>();
		//Integer 타입이외의 데이터를 넣을 경우 컴파일 오류가 발생한다.
		Set<Integer> set1=new HashSet<>();//우측의 제네릭스 부분은 타입 생략가능
		Set<Integer> set2=new TreeSet<Integer>();
		//Set으로 생성 시 HashSet, TreeSet 다 불러올 수 있음 자식이라
		
		set1.add(100);
		set1.add(300);
		set1.add(100);
		set1.add(200);
		set1.add(500);
		
		set2.add(100);
		set2.add(200);
		set2.add(400);
		set2.add(500);
		set2.add(700);
		
		System.out.println("set1의 갯수:"+set1.size());//100은 중복되어서 1번만 들어감.4개
		System.out.println("set2의 갯수:"+set2.size());
		
		//컬렉션 출력 for문
		System.out.println("HashSet 결과");
		for(Integer n:set1)
			System.out.print(n+" ");//비순차적으로 나온다.
		System.out.println();
		
		System.out.println("TreeSet 결과");
		for(Integer n:set2)
			System.out.print(n+" ");//오름차순으로 나온다.
		System.out.println();
		
		
	}

}