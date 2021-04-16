package project_yeop.dto;

import java.sql.Date;

public class Order {
	boolean complete;
	int no;
	Customer cNo;
	Laundry LaundryCode;
	String color;
	int laundryCount;
	int totalPrice;
	Date receiveDate;
	Date releaseDate;
	String ect;

	public Order(int no) {
		this.no = no;
	}

	public Order(boolean complete, int no, Customer cNo, Laundry laundryCode, String color, int laundryCount,
			int totalPrice, Date receiveDate, Date releaseDate, String ect) {
		this.complete = complete;
		this.no = no;
		this.cNo = cNo;
		LaundryCode = laundryCode;
		this.color = color;
		this.laundryCount = laundryCount;
		this.totalPrice = totalPrice;
		this.receiveDate = receiveDate;
		this.releaseDate = releaseDate;
		this.ect = ect;
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

	public Customer getcNo() {
		return cNo;
	}

	public void setcNo(Customer cNo) {
		this.cNo = cNo;
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

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public java.sql.Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getEct() {
		return ect;
	}

	public void setEct(String ect) {
		this.ect = ect;
	}

	@Override
	public String toString() {
		return String.format(
				"Order [complete=%s, no=%s, cNo=%s, LaundryCode=%s, color=%s, laundryCount=%s, totalPrice=%s, receiveDate=%s, releaseDate=%s, ect=%s]",
				complete, no, cNo, LaundryCode, color, laundryCount, totalPrice, receiveDate, releaseDate, ect);
	}

}
