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

	public int addSale(Sale sale) {
		return dao.insertSale(sale);
	}

	public int modifySale(Sale sale) {
		return dao.updateSale(sale);
	}

	public int removeSale(Sale sale) {
		return dao.deleteSale(sale);
	}
}
