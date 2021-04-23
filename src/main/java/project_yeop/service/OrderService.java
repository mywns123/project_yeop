package project_yeop.service;

import java.util.List;

import project_yeop.dao.OrderDao;
import project_yeop.dao.impl.OrderDaoImpl;
import project_yeop.dto.OdTable;
import project_yeop.dto.Order;

public class OrderService {
	private OrderDao dao = OrderDaoImpl.getInstance();

	public List<OdTable> showOrders() {
		return dao.selectOrderByAll();
	}

	public OdTable showOrder(OdTable odTable) {
		return dao.selectOrderByNo(odTable);
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
}
