package project_yeop.dto;

public class salebyCt {
	
	private CtTable ctTable;	
	private int totalCount;
	private int totalPrice;
	public salebyCt(CtTable ctTable) {
		this.ctTable = ctTable;
	}
	public salebyCt(CtTable ctTable, int totalCount, int totalPrice) {
		this.ctTable = ctTable;
		this.totalCount = totalCount;
		this.totalPrice = totalPrice;
	}
	public CtTable getCtTable() {
		return ctTable;
	}
	public void setCtTable(CtTable ctTable) {
		this.ctTable = ctTable;
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
		return String.format("salebyCt [ctTable=%s, totalCount=%s, totalPrice=%s]", ctTable, totalCount, totalPrice);
	}
	


	

}
