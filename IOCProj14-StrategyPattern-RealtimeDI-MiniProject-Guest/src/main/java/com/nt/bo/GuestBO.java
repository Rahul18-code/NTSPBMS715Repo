package com.nt.bo;

public class GuestBO {
	private Integer gno;
	private String gname;
	private String gadd;
	private Double pdaycharge;
	private Integer daysstayed;
	private Double bill;
	
	//setter and getter 
	
	public Integer getGno() {
		return gno;
	}
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGadd() {
		return gadd;
	}
	public void setGadd(String gadd) {
		this.gadd = gadd;
	}
	public Double getPdaycharge() {
		return pdaycharge;
	}
	public void setPdaycharge(Double pdaycharge) {
		this.pdaycharge = pdaycharge;
	}
	public Integer getDaysstayed() {
		return daysstayed;
	}
	public void setDaysstayed(Integer daysstayed) {
		this.daysstayed = daysstayed;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	
}
