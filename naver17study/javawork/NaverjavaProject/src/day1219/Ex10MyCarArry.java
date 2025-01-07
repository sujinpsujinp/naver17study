package day1219;

public class Ex10MyCarArry {
	
	public static void showTitle()
	{
		System.out.println("자동차명\t가격\t색상\t구입일");
		System.out.println("=".repeat(35));
	}
	public static void writeMyCar(MyCar MyCar)
	{
		System.out.println(MyCar.getCarName()+"\t"+MyCar.getCarPrice()+"\t"+MyCar.getCarColor()+"\t"+MyCar.getGuipDay());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCar my1=new MyCar();
		System.out.println(my1);//toString이 있을 경우 자동 호출 아니면 이상한 주소 노출
		
		MyCar my2=new MyCar("소나타",3900,"진주색");
		System.out.println(my2);
		

		System.out.println("객체 배열 생성");
		//방법1
//		MyCar []carArray= {
//				new MyCar(),
//				new MyCar("그랜저",5600,"검정색"),
//				new MyCar("BMW",6700,"흰색")
//		};
		
		//방법2
		MyCar [] carArray=new MyCar[3];//메모리할당, 초기값 null
		carArray[0]=new MyCar();
		carArray[1]=new MyCar("그랜저",5600,"검정색");
		carArray[2]=new MyCar("BMW",6700,"흰색");

		
		//제목 출력
		showTitle();
		
		//for문으로 데이터 출력
//		for(MyCar my:carArray)
//			writeMyCar(my);
		for(int i=0;i<carArray.length;i++)
			writeMyCar(carArray[i]);
		
		
	}

}
