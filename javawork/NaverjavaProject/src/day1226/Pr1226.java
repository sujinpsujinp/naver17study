package day1226;

/*
 * 인사점수 Score에 따라 A등급 B등급 C등급 D등급 나눠지고 각 등급마다
 * 450000
 * 300000
 * 250000 
 * 0원 수당 주기
 */


public class Pr1226 {
	private String name;
	private String dep;
	private String address;
	private int Ascore;
	private int Bscore;

	
	public Pr1226()
	{
		
	}


	public Pr1226(String name, String dep, String address, int Ascore, int Bscore) {
		super();
		this.name = name;
		this.dep = dep;
		this.address = address;
		this.Ascore = Ascore;
		this.Ascore = Ascore;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDep() {
		return dep;
	}


	public void setDep(String dep) {
		this.dep = dep;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAScore() {
		return Ascore;
	}


	public void setAScore(int ascore) {
		this.Ascore = ascore;
	}


	public int getBscore() {
		return Bscore;
	}


	public void setBscore(int bscore) {
		this.Bscore = bscore;
	}
	
	
	
	
}