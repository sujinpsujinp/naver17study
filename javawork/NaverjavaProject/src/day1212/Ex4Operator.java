package day1212;

public class Ex4Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//관계연산자(>,<.>=,<=,==, !=), 논리연산자(&&, ||,!(not))>>결과값은 무조건 boolean(true/false)
		int kor=89, eng=100, mat=89;
		boolean f=false;
		
		System.out.println(kor>eng);//false
		System.out.println(kor<eng);//true
		System.out.println(kor==mat);//true
		System.out.println(kor!=eng);//false
		System.out.println(kor>eng && ++eng>mat);//false > false&&true 첫번쨰 조건이 false일 경우 두번째 조건은 비교하지 않음
		System.out.println(eng);//증가 안되어서 100
		System.out.println(kor>eng|| ++eng>mat);//true >> false||true 첫번째 조건이 true면 두번째 조건 비교 안함
		System.out.println(eng);//앞이 false여서 뒤를 비교해서 증가되어있음
		System.out.println(!(kor>eng));//true 
		System.out.println(!f);//true
				
	}

}
