package project_yeop.dto;

public class Column {
	private String  column_name;

	public Column(String column_name) {
		this.column_name = column_name;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	@Override
	public String toString() {
		return String.format("%s", column_name);
	}

	
	
	
}
