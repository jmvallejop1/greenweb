package com.greenweb.pregunta.data;

public class PreguntaDO {
	private int id;
	private String preg;
	private String r1;
	private String r2;
	private String r3;
	private String r4;
	private Integer rOk;
	
	public String getPreg() {
		return preg;
	}
	public void setPreg(String p) {
		preg=p;
	}
	public String getR1() {
		return r1;
	}
	public void setR1(String r1) {
		this.r1 = r1;
	}
	public String getR2() {
		return r2;
	}
	public void setR2(String r2) {
		this.r2 = r2;
	}
	public String getR3() {
		return r3;
	}
	public void setR3(String r3) {
		this.r3 = r3;
	}
	public String getR4() {
		return r4;
	}
	public void setR4(String r4) {
		this.r4 = r4;
	}
	public Integer getrOk() {
		return rOk;
	}
	public void setrOk(Integer rOk) {
		this.rOk = rOk;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}