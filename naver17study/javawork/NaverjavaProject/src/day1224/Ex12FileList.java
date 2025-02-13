package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex12FileList {

	static final String FILENAME="d:/naver1210/sawon.txt";
	
	
	List<String> sawonList=new Vector<String>();
	
	public Ex12FileList() {
		//파일에서 이름 읽어서 sawonlist에 추가해주세요.
		//filereadline???
		FileReader fr=null;
		BufferedReader br=null;
	
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String name=br.readLine();
				if(name==null)
					break;
				//Vector에 추가
				sawonList.add(name);
			}
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("**해당 파일을 찾을 수 없습니다**");
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
				fr.close();
			}catch (IOException|NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
		/*내가 만든 코드
		try {	
			br=new BufferedReader(fr);
			fr=new FileReader(FILENAME);
			
			while(true)
			{
				String line=br.readLine();//한줄 읽고
				sawonList.add(line);
				if(line==null)//내용이 없으면 나가기
					break;
			}
			System.out.println();
			
			}catch (IOException e) {
				System.out.println("**해당 파일을 찾을 수 없습니다**");
			}finally {
				if(br!=null)
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//파일이 삭제돼서 없을 수 있는데 이 경우에!
				if(fr!=null)
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//널포인트익셉션 트라이해주않으면 if문이라도 넣어줘야함
			}
		}

*/
	public void sawonMemberList()
	{
		//사원 이름과 번호를 같이 출력해주세요.
		System.out.println("총 "+sawonList.size()+"명의 사원이 있습니다.");
		System.out.println();
		System.out.println("사원\t사원명");
		int n=0;
		for(String name:sawonList)
			System.out.println(++n+"\t"+name);
		System.out.println();

		//for문 사용해서 출력
		//내가 만든 코드
//		int n=0;
//		for(String s:sawonList)
//		System.out.println(++n+":"+s);
	}


//여기 이후에는 과제 후 추가된 내용	
	
	//해당 이름이 몇번 인덱스에 있는지 리턴(없으면 -1리턴)
	public int getSearchName(String name){//검색, 삭제시에도 사용됨 getSearchName
		
		int idx=-1;//존재하지 않는 것 중에 제일 작은 것이기에 -1
		for(int i=0;i<sawonList.size();i++)
		{
			String listName=sawonList.get(i);
			if(listName.equals(name))//중복된 이름이 없다는 조건
			{
				idx=i;
				break;
			}
		}
		return idx;
	}
	
	//이름 입력 시 삭제하는 메서드
	public void deleteSawon(String name)
	{
		int idx=this.getSearchName(name);
		if(idx==-1)
			System.out.println(name+"님은 사원명단에 없습니다.");
		else
		{
			sawonList.remove(idx);
			System.out.println(name+" 님을 사원명단에서 삭제했습니다.");
		}		
	}
	
	//이름 조회
	public void searchName(String name)
	{
		int idx=this.getSearchName(name);
		if(idx==-1)
			System.out.println(name+" 님은 사원 명단에 없습니다.");
		else
			System.out.println(name+" 님은 "+(idx+1)+" 번째에 있습니다.");//괄호로 묶지않으면 문자로 됨
	}
	
	//List의 이름들을 다시 파일에 저장하기
	public void sawonFileSave()
	{
		FileWriter fw=null;
		try {
			fw=new FileWriter(FILENAME);
			for(String name:sawonList)//sawonList에 있는 이름 꺼내서 파일에 저장하고 줄바꿈
			{
				fw.write(name+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//사원명 추가
	public void addSawon(String name)
	{
		//이미 존자할 경우 추가 못함
		int idx=this.getSearchName(name);
		if(idx!=-1)
			System.out.println(name+" 님은 이미 존재합니다.");
		else{
			sawonList.add(name);
			System.out.println("추가되었습니다.");
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ex12FileList ex12=new Ex12FileList();
		//ex12.sawonMemberList();
		
		Scanner sc=new Scanner(System.in);
		int menu=0;
		
		while(true)
		{
			System.out.println("1.사원추가 2.사원삭제 3.사원검색 4.전체목록 5.저장 후 종료");
			System.out.println("=".repeat(40));
			try {
				menu=Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				menu=4;//문자를 잘못 입력 시 전체목록이 나오도록
			}
			
			switch(menu)
			{
			case 1->{
				System.out.println("추가할 사원명을 입력하세요.");
				String name=sc.nextLine();
				ex12.addSawon(name);
			}
			case 2->{
				System.out.println("삭제할 사원명을 입력하세요.");
				String name=sc.nextLine();
				ex12.deleteSawon(name);
			}
			case 3->{
				System.out.println("검색할 사원명을 입력하세요.");
				String name=sc.nextLine();
				ex12.searchName(name);
			}
			case 4->ex12.sawonMemberList();			
			default ->{
				System.out.println("** 저장 후 종료합니다.");
				ex12.sawonFileSave();
				System.exit(0);//이거 안쓰면 while까지 나가야해서 레이블써야함
			}
			}
		}
		
		
	}

}
