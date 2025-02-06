package project1;

import java.sql.Timestamp;

public class AnimalDto {
	private int idx;
	private String aniname;
	private String anikind;
	private String aniphoto;
	private String animessage;
	private Timestamp aniday;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getAniname() {
		return aniname;
	}
	public void setAniname(String aniname) {
		this.aniname = aniname;
	}
	public String getAnikind() {
		return anikind;
	}
	public void setAnikind(String anikind) {
		this.anikind = anikind;
	}
	
	public String getAniphoto() {
		return aniphoto;
	}
	public void setAniphoto(String aniphoto) {
		this.aniphoto = aniphoto;
	}
	public String getAnimessage() {
		return animessage;
	}
	public void setAnimessage(String animessage) {
		this.animessage = animessage;
	}
	public Timestamp getAniday() {
		return aniday;
	}
	public void setAniday(Timestamp aniday) {
		this.aniday = aniday;
	}
}
