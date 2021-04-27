package project_yeop.service;

import java.util.List;

import project_yeop.dao.salebyCtDao;
import project_yeop.dao.impl.salebyCtDaoImpl;
import project_yeop.dto.salebyCt;

public class salebyCtService {
	private salebyCtDao dao = salebyCtDaoImpl.getInstance();

	public List<salebyCt> showSales() {
		return dao.selectSaleByCt();
	}

	public salebyCt showSale(salebyCt sale) {
		return dao.selectSaleByNo(sale);
	}
	
}
