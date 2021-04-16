package project_yeop.dao;

import java.util.List;

import project_yeop.dto.Order;

public interface OrderDao {

	List<Order> selectOrderByAll();

	Order selectOrderByNo(Order order);

	int insertOrder(Order order);

	int updateOrder(Order order);

	int deleteOrder(Order order);
}
