package day0107db;

//웹은 dto로 담음 
public class FoodOrderDto {
	private int idx;
	private int num;
	private String orderName;
	private int orderCnt;
	private String bookingDay;
	
	public FoodOrderDto() {
		// TODO Auto-generated constructor stub
	
	}
	//이 아래는 다 자동으로!
	//idx는 자동으로 들어갈거니까 제외하고 제너레이트
	public FoodOrderDto(int num, String orderName, int orderCnt, String bookingDay) {
		super();
		this.num = num;
		this.orderName = orderName;
		this.orderCnt = orderCnt;
		this.bookingDay = bookingDay;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public String getBookingDay() {
		return bookingDay;
	}
	public void setBookingDay(String bookingDay) {
		this.bookingDay = bookingDay;
	}

}
