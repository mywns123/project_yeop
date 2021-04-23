package project_yeop.service;

import java.util.List;

import project_yeop.dao.SaleDao;
import project_yeop.dao.impl.SaleDaoImpl;
import project_yeop.dto.Sale;

public class SalesService {
	private SaleDao dao = SaleDaoImpl.getInstance();

	public List<Sale> showSales() {
		return dao.selectSaleByAll();
	}

	public Sale showSale(Sale sale) {
		return dao.selectSaleByNo(sale);
	}
	
}
