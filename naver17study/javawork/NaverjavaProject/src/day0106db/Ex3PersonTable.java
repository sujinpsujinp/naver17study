package day0106db;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

public class Ex3PersonTable extends JFrame {
	JTextField tfName,tfAge, tfBlood,tfHp;
	JButton btnAdd, btnDel;
	DefaultTableModel tableModel;
	JTable table;
	
	PersonModel personModel=new PersonModel();

	public Ex3PersonTable() {
		super("person 관리");
		this.setBounds(300,100,600,400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		JPanel p1=new JPanel();
	
		tfName=new JTextField(5);
		tfAge=new JTextField(3);
		tfBlood=new JTextField(2);
		tfHp=new JTextField(10);
		
		
		p1.add(new JLabel("이름"));
		p1.add(tfName);
		p1.add(new JLabel("나이"));
		p1.add(tfAge);
		p1.add(new JLabel("혈액형"));
		p1.add(tfBlood);
		p1.add(new JLabel("휴대폰"));
		p1.add(tfHp);
		
		//p1 panel frame 상단에 추가하기
		this.add("North",p1);
		//frame 중간에 table 넣기
		String []title= {"번호","이름","나이","휴대폰","혈액형"};
		tableModel=new DefaultTableModel(title,0);//제목과 데이터는 0개로 생성
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		
		//생성된 테이블에 db데이터 출력하기
		this.rowSelect();
		
		//하단 버튼 두개
		btnAdd=new JButton("직원추가");
		btnDel=new JButton("직원삭제");
		
		JPanel p2=new JPanel();
		p2.add(btnAdd);
		p2.add(btnDel);
		this.add("South",p2);
		
		//직원추가 버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//일단 입력한 데이터들을 읽어서 dto로 묶기
				String name=tfName.getText();
				if(name.length()==0)
				{
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "직원명을 입력해주세요.");
					return;//메세지 띄운 후 메서드 종료
				}
				String text_age=tfAge.getText();
				int age=0;
				if(text_age.length()==0)
				{
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "직원명을 입력해주세요.");
					return;//메세지 띄운 후 메서드 종료
				}else {
					age=Integer.parseInt(text_age);
				}
				
				String blood=tfName.getText();
				if(blood.length()==0)
				{
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "직원명을 입력해주세요.");
					return;//메세지 띄운 후 메서드 종료
				}
				
				String hp=tfName.getText();
				if(hp.length()==0)
				{
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "직원명을 입력해주세요.");
					return;//메세지 띄운 후 메서드 종료
				}
				
				//insert메서드 호출
				personModel.insertPerson(new PersonDto(name,age,hp,blood));
				//전체 데이터 다시 출력
				rowSelect();
				//입력한 데이터 초기화
				tfName.setText("");
				tfAge.setText("");
				tfBlood.setText("");
				tfHp.setText("");
			}
		});
		
		//삭제 버튼 이벤트
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//행번호 가져오기
			int row=table.getSelectedRow();//선택을 안했을 경우 -1반환
			System.out.println(row);
			
			if(row==-1)
			{
				JOptionPane.showMessageDialog(Ex3PersonTable.this, "삭제할 행을 먼저 선택해주세요.");
				return;
			}
			//선택한 행의 0번열(인덱스) 값 가져오기
			int num=Integer.parseInt((String)table.getValueAt(row, 0));
			//삭제 메서드 호출
			personModel.deletePerson(num);
			//테이블 데이터 다시 출력
			rowSelect();
				
			}
		});
	}
	
	//table에 데이터 출력하는 메소드
	public void rowSelect()
	{
		//기전 테이블의 모든 데이터 삭제
		tableModel.setRowCount(0);
		//db의 모든 데이터 가져오기
		List<Vector<String>> list=personModel.getAllDatas();
		for(Vector<String> data:list)
		{
			tableModel.addRow(data);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3PersonTable ex3=new Ex3PersonTable();
		
	}

}
