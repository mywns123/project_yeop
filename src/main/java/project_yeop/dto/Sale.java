package project_yeop.dto;

public class Sale {	
	private Laundry lLaundryCode;
	private int totalCount;
	private int totalSales;
	
	public Sale(Laundry lLaundryCode) {
		this.lLaundryCode = lLaundryCode;
	}

	public Sale(Laundry lLaundryCode, int totalCount, int totalSales) {
		this.lLaundryCode = lLaundryCode;
		this.totalCount = totalCount;
		this.totalSales = totalSales;
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

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	@Override
	public String toString() {
		return String.format("Sale [lLaundryCode=%s, totalCount=%s, totalSales=%s]", lLaundryCode, totalCount,
				totalSales);
	}

	

}
