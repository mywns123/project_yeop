package project_yeop.service;

import java.util.List;

import project_yeop.dao.salebylLaundryDao;
import project_yeop.dao.impl.salebylLaundryDaoImpl;
import project_yeop.dto.salebylLaundry;

public class salebylLaundryService {
	private salebylLaundryDao dao = salebylLaundryDaoImpl.getInstance();

	public List<salebylLaundry> showSales() {
		return dao.selectSaleByAll();
	}

	public salebylLaundry showSale(salebylLaundry sale) {
		return dao.selectSaleByNo(sale);
	}
	
}
