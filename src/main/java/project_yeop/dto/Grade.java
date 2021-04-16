package project_yeop.dto;

public class Grade {
	String gGrade;
	int discountRate;

	public Grade(String gGrade) {
		this.gGrade = gGrade;
	}

	public Grade(String gGrade, int discountRate) {
		this.gGrade = gGrade;
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
		return String.format("Grade [gGrade=%s, discountRate=%s]", gGrade, discountRate);
	}

}
