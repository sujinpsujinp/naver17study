package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Practice1226 extends JFrame {
	static final String FILENAME="d:/naver1210/Practice1226.txt";
	List<Pr1226> list=new ArrayList<Pr1226>();
	JTable table;
	
	public Practice1226() {
		// TODO Auto-generated constructor stub
		super("직원 인사점수 관리");
		this.setBounds(300,100,500,300);
		this.initDesign();//이거 없으면 프레임 안에 내용물 안보임
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도우 X버튼 클릭 시 창 닫힘
		this.setVisible(true);//프레임 창 보이도록 하는 것
	}
	
	public void practiceFileRead()
	{
		//파일 읽어서 list 변수에 담기
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String p=br.readLine();//파일 한줄씩 읽어서 p에 넣기
				
				if(p==null)
					break;
				
				String []data=p.split("\\|");// 정규표현식때문에 \\추가됨, |기준으로 구분하겠음
				Pr1226 practice=new Pr1226();//pr1226 객체생성
				practice.setName(data[0]);
				practice.setDep(data[1]);
				practice.setAddress(data[2]);
				practice.setAScore(Integer.parseInt(data[3]));
				practice.setBscore(Integer.parseInt(data[4]));
				
				//list에 추가
				list.add(practice);
				
			}
			System.out.println("총 "+list.size()+"명 있습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("저장된 정보가 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void initDesign()
	{
		this.practiceFileRead();//파일 읽어서 list에 담는다.
		
		//테이블 제목
		String []title= {"이름","부서","주소","A점수","B점수","총점","평균"};
		
		//테이블 데이터: 행갯수는 List의 size갯수
		String [][]data=new String[list.size()][7];
		
		int i=0;
		for(Pr1226 p:list)
		{
			data[i][0]=p.getName();
			data[i][1]=p.getDep();
			data[i][2]=p.getAddress();
			data[i][3]=String.valueOf(p.getAScore());
			data[i][4]=String.valueOf(p.getBscore());
			int sum=p.getAScore()+p.getBscore();
			double avg=sum/2;
			data[i][5]=String.valueOf(sum);
			data[i][6]=String.valueOf(avg);
			
			i++;
			
		}
		//테이블 생성
		table=new JTable(data,title);
		
		//frame에 추가
		this.add("Center",new JScrollPane(table));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Practice1226();
		
		
	}

}
