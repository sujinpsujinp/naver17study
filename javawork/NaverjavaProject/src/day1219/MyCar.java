package day1219;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCar {
	//멤버변수 기본데이터 넣을 수 있게 생성자 만들
	private String carName;
	private int carPrice;
	private String guipDay;
	private String	carColor;
	
	public MyCar() {
		//생성되는 시간을 guipDay 구해서 넣어보자
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm");
		guipDay=sdf.format(new Date());
		
		carColor="흰색";
	}
	//carName, caPrice carColor 생성자로 받을 수 있게 제너레이트 사용
	//source > Generate Constructor using Field
	public MyCar(String carName, int carPrice, String carColor) {
		//생성되는 시간을 guipDay 구해서 넣어보자
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm");
		guipDay=sdf.format(new Date());

		//super();//없어도 기본으로 인식
		this.carName = carName;
		this.carPrice = carPrice;
		this.carColor = carColor;
	
	}
	//제너레이트 사용
	//source > Generate toString()
	@Override 
	public String toString() {
		return "MyCar carName=" + carName + ", carPrice=" + carPrice + ",\n guipDay=" + guipDay + ", carColor="
				+ carColor ;
	}
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public String getGuipDay() {
		return guipDay;
	}
	public void setGuipDay(String guipDay) {
		this.guipDay = guipDay;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
	
	
	

}
