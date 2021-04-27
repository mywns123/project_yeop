package project_yeop.dto;

public class salebylLaundry {
	private Laundry lLaundryCode;
	private int totalCount;
	private int totalPrice;

	
	public salebylLaundry(Laundry lLaundryCode) {
		this.lLaundryCode = lLaundryCode;
	}

	public salebylLaundry(Laundry lLaundryCode, int totalCount, int totalPrice) {
		this.lLaundryCode = lLaundryCode;
		this.totalCount = totalCount;
		this.totalPrice = totalPrice;
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
		return String.format("Sale [lLaundryCode=%s, totalCount=%s, totalPrice=%s]", lLaundryCode, totalCount,
				totalPrice);
	}

}
