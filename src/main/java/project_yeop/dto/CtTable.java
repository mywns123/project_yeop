package project_yeop.dto;

public class CtTable {
	private Customer customer;	
	private int unReleased;
	private int count;
	private Grade cGrade;
	
	public CtTable() {
	}

	public CtTable(Customer customer) {
		this.customer = customer;
	}
	
	public CtTable(Grade cGrade) {
		this.cGrade = cGrade;
	}

	public CtTable(Customer customer, int unReleased, int count, Grade cGrade) {
		this.customer = customer;
		this.unReleased = unReleased;
		this.count = count;
		this.cGrade = cGrade;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getUnReleased() {
		return unReleased;
	}
	public void setUnReleased(int unReleased) {
		this.unReleased = unReleased;
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
		return String.format("%s(%s)", customer.getcName(), customer.getcNo());
	}
	
	
	
	
	
}
