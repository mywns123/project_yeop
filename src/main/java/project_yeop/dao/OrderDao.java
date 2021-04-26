package project_yeop.dao;

import java.util.List;

import project_yeop.dto.OdTable;
import project_yeop.dto.Order;

public interface OrderDao {

	List<OdTable> selectOdTableByAll();

	List<OdTable> selectOdTableByUnComplete();
	
	List<OdTable> selectOdTableByreleaseDate();

	int insertOrder(Order order);

	int updateOrder(Order order);

	int deleteOrder(Order order);
	
	OdTable selectOdTableByNo(OdTable odTable);
}


