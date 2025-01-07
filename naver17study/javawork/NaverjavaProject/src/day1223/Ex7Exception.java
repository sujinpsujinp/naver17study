package day1223;

import java.util.Date;

public class Ex7Exception {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []arr= {4,5,7,12};
		for(int i=0;i<=arr.length;i++)
		{
			try {
			System.out.println(arr[i]);
			//}catch(ArrayIndexOutOfBoundsException e)//정확한 익셉션 적는게 좋음,그러나 어떤 오류가 발생할지 모르면
			}catch(Exception e)//>>상위 익셉션으로 처리
			{
				System.out.println("오류메세지 : "+e.getMessage());//예외처리하는 목적> 예외처리하고 정상종료 시키기위해서
				e.printStackTrace();//오류추적을 해서 행번호 표시 > 메세지만 보고싶으면 없어도 되지만 자동완성시키면 기본으로 들어감
			}
		}
		
		System.out.println();
		
		Date date=null;
		try {
			int age=(date.getYear()+1900)-1989;
			System.out.println("age="+age);
		}catch (NullPointerException e) {
			System.out.println("오류메세지:"+e.getMessage());
		}
		System.out.println("정상종료");

	}

}
