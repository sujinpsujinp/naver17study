package day1217;

public class Ex14StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names= {"Dennis","박남정","공효진","김미나","이진","손석구","Adams"};
		//이름의 오름차순으로 출력
		for(int i=0;i<names.length-1;i++)
		{
			for(int j=i+1;j<names.length;j++)
			{
			//names[i]가 names[j]보다 클경우 양수값, 작을경우 음수값
				if(names[i].compareTo(names[j])>0)
				{
					String temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}	
			}
		}
		for(int i=0;i<names.length;i++) 
		{
			System.out.println(i+":"+names[i]);
		}
		

	}

}
