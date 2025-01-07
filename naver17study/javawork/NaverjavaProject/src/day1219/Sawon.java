package day1219;

public class Sawon {
	/*
	 * 멤버변수 사원명 sawonName, 직급 position, 가족수 famSu
	 */
	private String sawonName;
	private String position;
	private int famSu;

	// 디폴트 생성자 
	//사원명, 직급, 가족수를 인자로 받는 생성자
	//제너레이트 using field로 만들 수 있음
	public Sawon(String sawonName, String position, int famSu) {
		this.sawonName = sawonName;
		this.position = position;
		this.famSu = famSu;
	}
	
	// setter & getter method
	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getFamSu() {
		return famSu;
	}

	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}

	// 직급에 따라 기본급gibonPay를 구하는데 부장->450, 과장->300, 대리->250, 사원->150 getGibonPay() 
	public int getGibonPay() {
		int gibonPay = switch (position) {
		case "부장" -> 450000;
		case "과장" -> 300000;
		case "대리" -> 250000;
		case "사원"-> 150000;
		default ->0;
		};
		return gibonPay;
	}

	/*
	 * 직급에따라 수당을 구하는데 부장, 과장->70, 대리,사원->50 getSudang()
	 */
	public int getsuDang() {
		int suDang = switch (position) {
		case "부장", "과장" -> 700000;
		case "대리","사원"->500000;
		default -> 0;
		};
		return suDang;
	}

	/*
	 * getGibonPay() 값을 반환받아서 세금 5프로를 구해서 반환하는 getTax()
	 */
	public int getTax() {
		int gibon = getGibonPay()*5/100;//강사님이 만드신 것>이거면 gibon을 리턴으로 해야함
		//double getTax = gibon * 0.05;//내가 만든 것> 이거면 리턴을 getTax로하고
		return gibon;
	}

	/*
	 * 가족수가 5인 이상이면 30반환. 5인미만 2인이상 10반환, 나머지는 0 getFamSuDang()
	 */
	public int getFamSuDang() {
		//선생님이 짜주신 것
		int famSudang=0;
		if(famSu>=0) famSudang=300000;
		else if(famSu>=2)famSudang=100000;
		else famSudang=0;
		return famSudang;
		//내가 만든 코드
//		if (famSu >= 5)
//			return 30;
//		else if (famSu < 5 && famSu >= 2)
//			return 10;
//		else
//			return 0;
	}

	/*
	 * 실수령액을 구해서 반환하는 메서드 기본급+수당-세금+가족수당을 구해서 반환 getNetPay()
	 */
	public int getNetPay() {
		return getGibonPay()+getsuDang()-getTax()+getFamSuDang();
		
		/*내가 함
		int gibon = getGibonPay();
		int sudang = getsuDang();
		double tax = getTax();
		int famSu = getFamSu();
		int netPay = gibon + sudang - (int) tax + famSu;
		return netPay;
		*/
		
	}

}
