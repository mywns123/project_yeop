package project_yeop.dto;

public class salebyDate {
	
	private int month; 
	private Laundry lLaundryCode;
	private int totalCount;
	private int totalPrice;
	
	public salebyDate(int month) {
		this.month = month;
	}

	public salebyDate(int month, int totalCount, int totalPrice) {
		this.month = month;
		this.totalCount = totalCount;
		this.totalPrice = totalPrice;
	}

	public salebyDate(int month, Laundry lLaundryCode, int totalCount, int totalPrice) {
		this.month = month;
		this.lLaundryCode = lLaundryCode;
		this.totalCount = totalCount;
		this.totalPrice = totalPrice;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Laundry getlLaundryCode() {
		return lLaundryCode;
	}

	public void setlLaundryCode(Laundry lLaundryCode) {
		this.lLaundryCode = lLaundryCode;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return String.format("salebyDate [month=%s, lLaundryCode=%s, totalCount=%s, totalPrice=%s]", month,
				lLaundryCode, totalCount, totalPrice);
	}

	
	
	

}
