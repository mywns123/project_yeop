package project_yeop.dto;

public class Laundry {
	private String lLaundryCode;
	private String product;
	private int unitPrice;

	public Laundry(String lLaundryCode) {
		this.lLaundryCode = lLaundryCode;
	}

	public Laundry(String lLaundryCode, String product, int unitPrice) {
		this.lLaundryCode = lLaundryCode;
		this.product = product;
		this.unitPrice = unitPrice;
	}

	public String getlLaundryCode() {
		return lLaundryCode;
	}

	public void setlLaundryCode(String lLaundryCode) {
		this.lLaundryCode = lLaundryCode;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", lLaundryCode, product);
	}

}
