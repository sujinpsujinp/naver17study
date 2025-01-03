package day1223;

import java.io.FileWriter;
import java.io.IOException;

public class Ex11Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//일반 Exception은 선택이 아니라 필수로 처리해만 한다.
		// 메서드 자체가 throws로 던지는 Exception 처리하면 된다.
		
		System.out.println("3초만 기다리세요.");
		
		try {
			Thread.sleep(3000);//무조건 예외처리해줘야함
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("오래 기다리셨어요~!");
		
		//파일에 이름과 주소를 저장해보자
		FileWriter fw=null;
		try {
			//fw=new FileWriter("d:/naver1210/memo.txt");//같은 이름의 파일이 있으면 덮어쓰기함
			fw=new FileWriter("d:/naver1210/memo.txt",true);//true : 기존파일에 추가(없다면 생성)
			fw.write("이름: 강호동\n");
			fw.write("주소: 서초구\n");
			fw.write("==============\n");
			System.out.println("탐색기로 파일을 확인하세요.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();//finally 에서 보통 해주는 것
				//IOException은 나중에 sql 사용하면 SQLExcetion 해야함
				//파일 생성하다가 오류가 발생하면 NullPointException 발생해서 |로 같이 예외처리해줌
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("정상 종료");
	}
}
