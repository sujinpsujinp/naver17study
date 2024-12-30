package day1211;

public class Ex7DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="Candy";
		int age=32;
		float height=163.8f;
		double weight=56.7;
		char blood='B';
		/*
		 * 이름 : Candy님
		 * 나이 :32세
		 * 키 : 163.8cm
		 * 몸무게 : 56.7KG
		 * 혈액형 : B형
		 * 
		 * printf를 이용해서 위 내용 출력하기
		 */
		 
		//내가 작성한 것
		System.out.printf("이름:%s",name+"님\n");
		System.out.printf("나이:%s",age+"세\n");
		System.out.printf("키:%5.1f",height+"cm \n");
		System.out.printf("몸무게:%s",weight+"KG\n");
		System.out.printf("혈액형:%s",blood+"형\n");
		System.out.println("-------------------------");
		
		
		//쌤이 해주신 것
		System.out.printf("이름 : %s님\n",name);
		System.out.printf("나이 : %d세\n",age);
		System.out.printf("키 : %5.1fCm\n",height);
		System.out.printf("몸무게 : %5.1fKG\n",weight);
		System.out.printf("혈액형 : %c형\n",blood);
		System.out.println("-------------------------");
		
		//위와 똑같이 나오도록 println을 이용해서 출력
		System.out.println("이름:"+name+"님");
		System.out.println("나이:"+age+"세");
		System.out.println("키:"+height+"Cm");
		System.out.println("몸무게:"+weight+"KG");
		System.out.println("혈액형:"+blood+"형");
		
	}

}
