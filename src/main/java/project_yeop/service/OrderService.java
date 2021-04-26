package project_yeop.service;

import java.util.List;

import project_yeop.dao.OrderDao;
import project_yeop.dao.impl.OrderDaoImpl;
import project_yeop.dto.OdTable;
import project_yeop.dto.Order;

public class OrderService {
	private OrderDao dao = OrderDaoImpl.getInstance();

	public List<OdTable> showOdTables() {
		return dao.selectOdTableByAll();
	}

	public List<OdTable> showOdTableUnComplete() {
		return dao.selectOdTableByUnComplete();
	}
	
	public List<OdTable> showOdTablereleaseDate() {
		return dao.selectOdTableByreleaseDate();
	}
			
	public int addOrder(Order order) {
		return dao.insertOrder(order);
	}

	public int modifyOrder(Order order) {
		return dao.updateOrder(order);
	}

	public int removeOrder(Order order) {
		return dao.deleteOrder(order);
	}
	
	

	public OdTable showOdTable(OdTable odTable) {
		return dao.selectOdTableByNo(odTable);
	}

	
	
	
	
	
}
