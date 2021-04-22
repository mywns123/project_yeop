package project_yeop.dao;

import java.util.List;

import project_yeop.dto.Sale;

public interface SaleDao {

	List<Sale> selectSaleByAll();

	Sale selectSaleByNo(Sale sale);
	
}
