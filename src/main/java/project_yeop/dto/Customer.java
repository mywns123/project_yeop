package project_yeop.dto;

import java.util.Date;

public class Customer {
	int cNo;
	String cName;
	boolean gender;
	String ponNumber;
	String address;
	Date joinDate;
	int unDelivered;
	int count;
	Grade cGrade;

	public Customer(int cNo) {
		this.cNo = cNo;
	}

	public Customer(int cNo, String cName, boolean gender, String ponNumber, String address) {
		this.cNo = cNo;
		this.cName = cName;
		this.gender = gender;
		this.ponNumber = ponNumber;
		this.address = address;
	}

	public Customer(int cNo, String cName, boolean gender, String ponNumber, String address, Date joinDate,
			int unDelivered, int count, Grade cGrade) {
		this.cNo = cNo;
		this.cName = cName;
		this.gender = gender;
		this.ponNumber = ponNumber;
		this.address = address;
		this.joinDate = joinDate;
		this.unDelivered = unDelivered;
		this.count = count;
		this.cGrade = cGrade;
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

	public int getUnDelivered() {
		return unDelivered;
	}

	public void setUnDelivered(int unDelivered) {
		this.unDelivered = unDelivered;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Grade getcGrade() {
		return cGrade;
	}

	public void setcGrade(Grade cGrade) {
		this.cGrade = cGrade;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer [cNo=%s, cName=%s, gender=%s, ponNumber=%s, address=%s, joinDate=%s, unDelivered=%s, count=%s, cGrade=%s]",
				cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade);
	}

}
