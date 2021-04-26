package project_yeop.dao;

import java.util.List;

import project_yeop.dto.Column;

public interface ColumnDao {

	List<Column> selectCtTableColumns();
	
	List<Column> selectOdTableColumns();	
}
