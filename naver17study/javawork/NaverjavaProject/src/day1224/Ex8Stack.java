package day1224;

import java.util.Stack;

public class Ex8Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LIFO : last in first out : 마지막으로 들어간 데이터가 먼저 나오는 구조
		//push,pop을 이용해서 데이터를 추가, 제거
		Stack<String> stack1=new Stack<String>();
		
		stack1.push("사과");
		stack1.push("바나나");
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("키위");
		
		System.out.println("stack의 갯수:"+stack1.size());
		
		while(!stack1.isEmpty())//비어있지 않은동안 실행함
		{
			System.out.println(stack1.pop());
		}
		
		
		
	}

}
