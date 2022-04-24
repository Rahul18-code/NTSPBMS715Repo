package com.nt.dto;

import java.io.Serializable;

public class PatientDTO implements Serializable{
	private Integer pno;
	private String pname;
	private String padd;
	private Double pdaycharge;
	private Double bill;
	private Double time;
	
	//setter getter method
	
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPadd() {
		return padd;
	}
	public void setPadd(String padd) {
		this.padd = padd;
	}
	public Double getPdaycharge() {
		return pdaycharge;
	}
	public void setPdaycharge(Double pdaycharge) {
		this.pdaycharge = pdaycharge;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	}
	
}
