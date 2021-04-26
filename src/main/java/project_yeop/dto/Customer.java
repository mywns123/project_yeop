package project_yeop.dto;

import java.util.Date;

public class Customer {
	private int cNo;
	private String cName;
	private boolean gender;
	private String ponNumber;
	private String address;
	private Date joinDate;
	
	public Customer(int cNo) {		
		this.cNo = cNo;
	}

	public Customer(String cName) {
		this.cName = cName;
	}

	public Customer(String cName, boolean gender, String ponNumber, String address) {
		this.cName = cName;
		this.gender = gender;
		this.ponNumber = ponNumber;
		this.address = address;
	}

	
	public Customer(int cNo, String cName, boolean gender, String ponNumber, String address) {
		this.cNo = cNo;
		this.cName = cName;
		this.gender = gender;
		this.ponNumber = ponNumber;
		this.address = address;
	}

	public Customer(int cNo, String cName, boolean gender, String ponNumber, String address, Date joinDate) {
		this.cNo = cNo;
		this.cName = cName;
		this.gender = gender;
		this.ponNumber = ponNumber;
		this.address = address;
		this.joinDate = joinDate;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPonNumber() {
		return ponNumber;
	}

	public void setPonNumber(String ponNumber) {
		this.ponNumber = ponNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return String.format("%s", cNo);
	}
	
	

}
