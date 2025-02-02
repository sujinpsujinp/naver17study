package day1223;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFrame extends JFrame
{
	//멤버변수로 버튼 생성
	JButton btn1=new JButton("OneButton");//버튼제목
	
	
	public MyFrame() {
		//super();//생략가능
		super("Hello");//창제목 지정
		
		this.setBounds(300, 100, 300, 300);//x,y, width, height
		//기본 레이아웃 없애기 : 이걸 안하면 프레임=버튼이 됨
		this.setLayout(null);
		//버튼 위치 지정. 전부 생성자 안에서 호출해야함
		btn1.setBounds(30, 30, 100, 30);
		//프레임에 추가
		this.add(btn1);
	
		//버튼 이벤트-익명 내부 클래스 형태
		btn1.addActionListener(new ActionListener() {
			
			private Component MyFrame;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//버튼 누르면 메세지나오게 함, 앞에는 component를 추가해야해서 위에 추가함
				JOptionPane.showMessageDialog(this.MyFrame, "버튼이벤트입니다.");
			}
		});
		
		this.setVisible(true);//프레임이 보임(true:보임, false:안보임)
		//frame true로 두고 실행 > X누른다고 종료되는게 아님 >> setVisible(false):숨김 됨
		
		//아래 메서드가 없을 경우 x를 눌러서 프레임을 닫으면 그냥 프레임 숨김만 됨
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//실제 프로그램 종료
		
	}
}

public class Ex6JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame my=new MyFrame();
	
		
	}

}
