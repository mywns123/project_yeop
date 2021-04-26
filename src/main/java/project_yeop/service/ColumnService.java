package project_yeop.service;

import java.util.List;

import project_yeop.dao.ColumnDao;
import project_yeop.dao.impl.ColumnDaoImpl;
import project_yeop.dto.Column;

public class ColumnService {
	private ColumnDao dao = ColumnDaoImpl.getInstance();
	
	public List<Column> ctTableColumn() {
		return dao.selectCtTableColumns();
	}
	
	public List<Column> odTableColumn() {
		return dao.selectOdTableColumns();
	}
}
