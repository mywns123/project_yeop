package project_yeop.dto;

public class Sales {
	int sNo;
	Laundry lLaundryCode;
	int totalCount;
	int totalSales;

	public Sales(int sNo) {
		this.sNo = sNo;
	}

	public Sales(int sNo, Laundry lLaundryCode, int totalCount, int totalSales) {
		this.sNo = sNo;
		this.lLaundryCode = lLaundryCode;
		this.totalCount = totalCount;
		this.totalSales = totalSales;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
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
		return String.format("Sales [sNo=%s, lLaundryCode=%s, totalCount=%s, totalSales=%s]", sNo, lLaundryCode,
				totalCount, totalSales);
	}

}
