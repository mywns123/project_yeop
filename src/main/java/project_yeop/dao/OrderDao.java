package project_yeop.dao;

import java.util.List;

import project_yeop.dto.OdTable;
import project_yeop.dto.Order;

public interface OrderDao {

	List<OdTable> selectOrderByAll();

	OdTable selectOrderByNo(OdTable odTable);

	int insertOrder(Order order);

	int updateOrder(Order order);

	int deleteOrder(Order order);
}
