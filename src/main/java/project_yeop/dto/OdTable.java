package project_yeop.dto;

import java.util.Date;

public class OdTable {
	private Order order;
	private CtTable ctTable;
	private Grade grade;
	private Laundry laundry;
	private int price;
	private Date releaseDate;
	
	public OdTable(Order order) {
		this.order = order;
	}

	
	public OdTable(Order order, Date releaseDate) {
		this.order = order;
		this.releaseDate = releaseDate;
	}


	public OdTable(Order order, Laundry laundry, Date releaseDate) {
		this.order = order;
		this.laundry = laundry;
		this.releaseDate = releaseDate;
	}


	public OdTable(Order order, CtTable ctTable, Grade grade, Laundry laundry, int price, Date releaseDate) {
		this.order = order;
		this.ctTable = ctTable;
		this.grade = grade;
		this.laundry = laundry;
		this.price = price;
		this.releaseDate = releaseDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public CtTable getCtTable() {
		return ctTable;
	}

	public void setCtTable(CtTable ctTable) {
		this.ctTable = ctTable;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Laundry getLaundry() {
		return laundry;
	}

	public void setLaundry(Laundry laundry) {
		this.laundry = laundry;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return String.format("%s의 %s(%s)", order.getCtNo(),order.getLaundryCode(),order.getLaundryCount());
	}

	
	
	
	
}

