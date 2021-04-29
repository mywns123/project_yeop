package project_yeop.dto;

public class Grade {
	private String gGrade;	
	private int losal;	
	private int hiosal;
	private int discountRate;

	public Grade(String gGrade) {
		this.gGrade = gGrade;
	}

	
	public Grade(int discountRate) {
		this.discountRate = discountRate;
	}


	public Grade(String gGrade, int discountRate) {
		this.gGrade = gGrade;
		this.discountRate = discountRate;
	}

	public int getLosal() {
		return losal;
	}


	public void setLosal(int losal) {
		this.losal = losal;
	}


	public int getHiosal() {
		return hiosal;
	}


	public void setHiosal(int hiosal) {
		this.hiosal = hiosal;
	}


	public Grade(String gGrade,  int losal, int hiosal,int discountRate) {
		this.gGrade = gGrade;
		
		this.losal = losal;
		this.hiosal = hiosal;
		this.discountRate = discountRate;
	}


	public String getgGrade() {
		return gGrade;
	}

	public void setgGrade(String gGrade) {
		this.gGrade = gGrade;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", gGrade, discountRate);
	}

}
