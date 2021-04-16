package project_yeop.dao;

import java.util.List;

import project_yeop.dto.Sales;

public interface SalesDao {

	List<Sales> selectSalesByAll();

	Sales selectSalesByNo(Sales sales);

	int insertSales(Sales sales);

	int updateSales(Sales sales);

	int deleteSales(Sales sales);
}
