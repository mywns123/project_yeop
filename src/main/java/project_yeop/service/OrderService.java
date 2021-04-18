package project_yeop.service;

import java.util.List;

import project_yeop.dao.OrderDao;
import project_yeop.dao.impl.OrderDaoImpl;
import project_yeop.dto.Order;

public class OrderService {
	private OrderDao dao = OrderDaoImpl.getInstance();

	public List<Order> showOrders() {
		return dao.selectOrderByAll();
	}

	public Order showOrder(Order order) {
		return dao.selectOrderByNo(order);
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
