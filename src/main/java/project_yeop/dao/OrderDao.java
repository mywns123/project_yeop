package project_yeop.dao;


import java.util.List;

import project_yeop.dto.OdTable;
import project_yeop.dto.Order;

public interface OrderDao {

	List<OdTable> selectOdTableByAll();
	
	List<OdTable> selectOdTableByNo(int no);
	
	List<OdTable> selectOdTableBycNo(int cno);
	
	List<OdTable> selectOdTableBycName(String cName);
	
	List<OdTable> selectOdTableByCode(String code);
	
	List<OdTable> selectOdTableByProduct(String product);
	
	List<OdTable> selectOdTableUnComplete();
	
	List<OdTable> selectOdTableUnCompleteByNo(int no);
	
	List<OdTable> selectOdTableUnCompleteBycNo(int cno);
	
	List<OdTable> selectOdTableUnCompleteBycName(String cName);
	
	List<OdTable> selectOdTableUnCompleteByCode(String code);
	
	List<OdTable>selectOdTableUnCompleteByProduct(String product);
	
	List<OdTable> selectOdTableReleaseDate();
	
	List<OdTable> selectOdTableReleaseDateByNo(int no);
	
	List<OdTable> selectOdTableReleaseDateBycNo(int cno);
	
	List<OdTable> selectOdTableReleaseDateBycName(String cName);
	
	List<OdTable> selectOdTableReleaseDateByCode(String code);
	
	List<OdTable> selectOdTableReleaseDateByProduct(String product);
		

	int insertOrder(Order order);

	int updateOrder(Order order);

	int deleteOrder(Order order);
	
	int relOrder(Order order);
	
	OdTable selectOdTableByNo(OdTable odTable);
}


