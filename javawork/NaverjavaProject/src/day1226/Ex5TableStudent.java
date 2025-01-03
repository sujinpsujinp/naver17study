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

public class Ex5TableStudent extends JFrame {
	static final String FILENAME="d:/naver1210/student.txt";
	List<Student> list=new ArrayList<Student>();
	JTable table;
	
	public Ex5TableStudent()
	{
		super("학생성적관리");
		this.setBounds(300,100,400,300);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//엑스누르면 창 닫히는 것
		this.setVisible(true);
		
	}
	
	public void studentFileRead()
	{
		//파일 읽어서 list 변수에 담기
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String s=br.readLine();//한줄 읽기
				if(s==null)
					break;
				
				String []data=s.split("\\|");//|표시로 구분해서 넣기 > 정규표현식으로 앞에 역슬래시 넣어줘야함
				Student student=new Student();//사원 객체 생성
				student.setName(data[0]);
				student.setKor(Integer.parseInt(data[1]));
				student.setEng(Integer.parseInt(data[2]));
				
				//List에 추가
				list.add(student);
			}
			System.out.println("총 "+list.size()+"명 있습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("저장된 학생정보가 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
	
	public void initDesign()
	{
		this.studentFileRead();//파일 읽어서 list변수에 담는다.
		//list의 데이터를 일어서 테이블에 출력 후 
		//frame에 출력하시오.
		//제목은 이름, 국어, 영어,총점,평균 배열 5개
		
		//테이블의 제목부분
		String []title= {"학생이름","국어점수","영어점수","총점","평균"};

		//테이블의 데이터 부분-행갯수는 List의 size 갯수이다.
		String [][]data=new String[list.size()][5];
		
		int i=0;
		for(Student s:list)
		{
			data[i][0]=s.getName();
			data[i][1]=String.valueOf(s.getKor());//나이는 int여서 String.valueOf으로 형변환해줌
			data[i][2]=String.valueOf(s.getEng());
			int sum=s.getKor()+s.getEng();
			double avg=sum/2;
			data[i][3]=String.valueOf(sum);
			data[i][4]=String.valueOf(avg);
			//data[i][3]=String.valueOf((s.getKor()+s.getEng()));
			//data[i][4]=String.valueOf((s.getKor()+s.getEng())/2.0);

			i++;
		}		
		//테이블 생성
		table=new JTable(data,title);
		
		//frame에 추가
		this.add("Center",new JScrollPane(table));//JSCrollPane으로 생성해서 넣어야 이런것(제목, 스크롤)들이 나타남
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5TableStudent();

	}

}
