package day1226;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex2JTable extends JFrame {
	JTable table;
	
	public Ex2JTable() {
		super("JTable 공부");
		this.setBounds(300,100,300,300);//시작위치와 크기 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X버튼 클릭 시 종료
		this.initDesign();
		this.setVisible(true);//프레임 보이게 하기
		
	}
	
	public void initDesign()
	{
		//기본 레이아웃은 BorderLayout인데
		//이 레이아웃은 동서남북센터로 위치를 정하는 레이아웃이다.
		//방법1
//		String []title= {"이름","혈액형","나이"};
//		String [][]data= {
//				{"이미자","AB","23"},
//				{"손기자","A","34"},
//				{"박민영","B","19"}
//		};
		
		//방법2
		Vector<String> title=new Vector<String>();
		title.add("이름");
		title.add("혈액형");
		title.add("나이");
		
		Vector<String> data1=new Vector<String>();
		data1.add("박민영");
		data1.add("AB");
		data1.add("23");
		
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		data.add(data1);
		//data.add(data2);
		//data.add(data3);
		
		//jtable 생성
		table=new JTable(data, title);
		
		//North에 JLabel을 추가해보자
		this.add("North",new JLabel("데이터출력테이블",JLabel.CENTER));
		
		//frame의 center에 추가
		//this.add("Center",table);//제목이 안나옴, 데이터가 많은 경우 스크롤도 안됨
		this.add("Center",new JScrollPane(table));//JSCrollPane으로 생성해서 넣어야 이런것(제목, 스크롤)들이 나타남
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2JTable ex2=new Ex2JTable();//호출 안하면 프레임안나옴
		
		
		
	}

}
