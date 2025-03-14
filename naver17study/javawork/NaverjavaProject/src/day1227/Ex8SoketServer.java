package day1227;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Ex8SoketServer extends Thread {
	
	ServerSocket serverSoket;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("서버 소켓을 생성해보자");
		try {
			//접속하는 클라이언트를 허용하기 위해서 필요한 서버소켓
			serverSoket=new ServerSocket(6000);
			System.out.println("서버 소켓 생성 성공");
			
			while(true)
			{
				//접속한 클라이언트를 허용하고 소켓을 얻는다.
				Socket socket=serverSoket.accept();
				System.out.println("접속한 클라이언트의 IP: "+socket.getInetAddress().getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("서버 소켓 생성 실패"+e.getMessage());
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex8SoketServer server=new Ex8SoketServer();
		server.start();//run 메서드 호출
		
		
		
	}

}
