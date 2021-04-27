package project_yeop.service;

import java.util.List;

import project_yeop.dao.salebyDateDao;
import project_yeop.dao.impl.salebyDateDaoImpl;
import project_yeop.dto.salebyDate;

public class salebyDateService {
	private  salebyDateDao dao =  salebyDateDaoImpl.getInstance();
		
	public List<salebyDate> showSaleYear() {
		return dao.selectSaleByYear();
	}
		
	public List<salebyDate> showSaleMonth() {
		return dao.selectSaleByMonth();
	}
	
	public salebyDate showSale(salebyDate sale) {
		return dao.selectSaleByNo(sale);
	}
	
}
