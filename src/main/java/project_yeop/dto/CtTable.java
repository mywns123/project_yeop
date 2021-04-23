package project_yeop.dto;

public class CtTable {
	private Customer customer;	
	private int unDelivered;
	private int count;
	private String cGrade;
	
	public CtTable(Customer customer) {
		this.customer = customer;
	}
	
	public CtTable(Customer customer, int unDelivered, int count, String cGrade) {
		this.customer = customer;
		this.unDelivered = unDelivered;
		this.count = count;
		this.cGrade = cGrade;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	public String getcGrade() {
		return cGrade;
	}
	public void setcGrade(String cGrade) {
		this.cGrade = cGrade;
	}
	@Override
	public String toString() {
		return String.format("CtTable [customer=%s, unDelivered=%s, count=%s, cGrade=%s]", customer, unDelivered, count,
				cGrade);
	}
	
	
	
	
	
}
