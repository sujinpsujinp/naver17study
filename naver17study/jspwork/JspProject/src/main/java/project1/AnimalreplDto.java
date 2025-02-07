package project1;

import java.sql.Timestamp;

public class AnimalreplDto {
	private int num;
	private int idx;
	private String nickname;
	private String replemessage;
	private Timestamp writeday;
	
	public AnimalreplDto() {
		
	}
	
	
	
	public AnimalreplDto(int idx, String nickname, String replemessage) {
		super();
		this.idx = idx;
		this.nickname = nickname;
		this.replemessage = replemessage;
	}



	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getReplemessage() {
		return replemessage;
	}
	public void setReplemessage(String replemessage) {
		this.replemessage = replemessage;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
	

}
