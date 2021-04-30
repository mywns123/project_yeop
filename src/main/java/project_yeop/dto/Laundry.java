package project_yeop.dto;

public class Laundry {
	private String lLaundryCode;
	private String product;
	private int unitPrice;

	public Laundry(String lLaundryCode) {
		this.lLaundryCode = lLaundryCode;
	}

	public Laundry(String lLaundryCode, String product) {
		this.lLaundryCode = lLaundryCode;
		this.product = product;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lLaundryCode == null) ? 0 : lLaundryCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laundry other = (Laundry) obj;
		if (lLaundryCode == null) {
			if (other.lLaundryCode != null)
				return false;
		} else if (!lLaundryCode.equals(other.lLaundryCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", lLaundryCode, product);
	}

}
