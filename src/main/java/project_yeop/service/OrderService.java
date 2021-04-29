package project_yeop.service;

import java.util.List;

import project_yeop.dao.OrderDao;
import project_yeop.dao.impl.OrderDaoImpl;
import project_yeop.dto.OdTable;
import project_yeop.dto.Order;

public class OrderService {
	private OrderDao dao = OrderDaoImpl.getInstance();

	public List<OdTable> showOdTables() {
		return dao.selectOdTableByAll();
	}
	
	public List<OdTable> showOdTableNo(int no) {
		return dao.selectOdTableByNo(no);
	}
	
	public List<OdTable> showOdTableCNo(int cno) {
		return dao.selectOdTableBycNo(cno);
	}
	
	public List<OdTable> showOdTableCName(String cName) {
		return dao.selectOdTableBycName(cName);
	}
	
	public List<OdTable> showOdTableCode(String code) {
		return dao.selectOdTableByCode(code);
	}
	
	public List<OdTable> showOdTableProduct(String product) {
		return dao.selectOdTableByProduct(product);
	}
	
	public List<OdTable> showOdTableUnComplete() {
		return dao.selectOdTableUnComplete();
	}
	
	public List<OdTable> showOdTableUnCompleteNo(int no) {
		return dao.selectOdTableUnCompleteByNo(no);
	}
	
	public List<OdTable> showOdTableUnCompleteCNo(int cno) {
		return dao.selectOdTableUnCompleteBycNo(cno);
	}
	
	public List<OdTable> showOdTableUnCompleteCName(String cName) {
		return dao.selectOdTableUnCompleteBycName(cName);
	}
	
	public List<OdTable> showOdTableUnCompleteCode(String code) {
		return dao.selectOdTableUnCompleteByCode(code);
	}
	
	public List<OdTable> showOdTableUnCompleteProduct(String product) {
		return dao.selectOdTableUnCompleteByProduct(product);
	}
	
	public List<OdTable> showOdTablereleaseDate() {
		return dao.selectOdTableReleaseDate();
	}
		
	public List<OdTable> showOdTableReleaseDatNo(int no) {
		return dao.selectOdTableReleaseDateByNo(no);
	}
	
	public List<OdTable> showOdTableReleaseCNo(int cno) {
		return dao.selectOdTableReleaseDateBycNo(cno);
	}
	
	public List<OdTable> showOdTableReleaseCName(String cName) {
		return dao.selectOdTableReleaseDateBycName(cName);
	}
	
	public List<OdTable> showOdTableReleaseCode(String code) {
		return dao.selectOdTableReleaseDateByCode(code);
	}
	
	public List<OdTable> showOdTableReleaseProduct(String product) {
		return dao.selectOdTableReleaseDateByProduct(product);
	}
	
	public int addOrder(Order order) {
		return dao.insertOrder(order);
	}

	public int modifyOrder(Order order) {
		return dao.updateOrder(order);
	}
	
	public int RelOrder(Order order) {
		return dao.relOrder(order);
	}

	public int removeOrder(Order order) {
		return dao.deleteOrder(order);
	}
	
	

	public OdTable showOdTable(OdTable odTable) {
		return dao.selectOdTableByNo(odTable);
	}

	
	
	
	
	
}
