package project_yeop.dto;

import java.sql.Date;

public class Order {
	private boolean complete;
	private int no;
	private Customer ctNo;
	private Laundry LaundryCode;
	private String color;
	private int laundryCount;	
	private Date receiveDate;	
	private String etc;

	
	public Order(int no) {
		this.no = no;
	}
	
	

	public Order(Customer ctNo, Laundry laundryCode, String color, int laundryCount, String etc) {
		this.ctNo = ctNo;
		LaundryCode = laundryCode;
		this.color = color;
		this.laundryCount = laundryCount;
		this.etc = etc;
	}

	public Order(int no, Customer ctNo, Laundry laundryCode, String color, int laundryCount, String etc) {
		this.no = no;
		this.ctNo = ctNo;
		LaundryCode = laundryCode;
		this.color = color;
		this.laundryCount = laundryCount;
		this.etc = etc;
	}

	public Order(boolean complete, int no, Customer ctNo, Laundry laundryCode, String color, int laundryCount,
			String etc) {
		this.complete = complete;
		this.no = no;
		this.ctNo = ctNo;
		LaundryCode = laundryCode;
		this.color = color;
		this.laundryCount = laundryCount;
		this.etc = etc;
	}



	public Order(boolean complete, int no, Customer ctNo, Laundry laundryCode, String color, int laundryCount,
			Date receiveDate, String etc) {
		this.complete = complete;
		this.no = no;
		this.ctNo = ctNo;
		LaundryCode = laundryCode;
		this.color = color;
		this.laundryCount = laundryCount;
		this.receiveDate = receiveDate;
		this.etc = etc;
	}


	public boolean isComplete() {
		return complete;
	}


	public void setComplete(boolean complete) {
		this.complete = complete;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public Customer getCtNo() {
		return ctNo;
	}


	public void setCtNo(Customer ctNo) {
		this.ctNo = ctNo;
	}


	public Laundry getLaundryCode() {
		return LaundryCode;
	}


	public void setLaundryCode(Laundry laundryCode) {
		LaundryCode = laundryCode;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getLaundryCount() {
		return laundryCount;
	}


	public void setLaundryCount(int laundryCount) {
		this.laundryCount = laundryCount;
	}


	public Date getReceiveDate() {
		return receiveDate;
	}


	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}


	public String getEtc() {
		return etc;
	}


	public void setEtc(String etc) {
		this.etc = etc;
	}


	@Override
	public String toString() {
		return String.format(
				"Order [complete=%s, no=%s, ctNo=%s, LaundryCode=%s, color=%s, laundryCount=%s, receiveDate=%s, etc=%s]",
				complete, no, ctNo, LaundryCode, color, laundryCount, receiveDate, etc);
	}
	
	
}
