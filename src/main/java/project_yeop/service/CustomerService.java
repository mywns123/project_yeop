package project_yeop.service;

import java.util.List;

import project_yeop.dao.CustomerDao;
import project_yeop.dao.impl.CustomerDaoImpl;
import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;

public class CustomerService {
	private CustomerDao dao = CustomerDaoImpl.getInstance();

	public List<CtTable> showCtTable() {
		return dao.selectCtTableByAll();
	}

	public List<CtTable> showCtTableNO(int no) {
		return dao.selectCtTableByNo(no);
	}
	
	public List<CtTable> showCtTableGrade(String grade) {
		return dao.selectCtTableByGrade(grade);
	}
	
	public List<CtTable> showCtTableName(String name) {
		return dao.selectCtTableByName(name);
	}
	
	public List<CtTable> showCtTableGender(boolean gender) {
		return dao.selectCtTableByGender(gender);
	}
	
	public List<CtTable> showCtTableUnRel() {
		return dao.selectCtTableByUnRel();
	}
		
	public CtTable showCtTableNO(CtTable ctTable) {
		return dao.selectCtTableByNo(ctTable);
	}
	
	public int addCustomer(Customer customer) {
		return dao.insertCustomer(customer);
	}
	
	public int modifyCustomer(Customer customer) {
		return dao.updateCustomer(customer);
	}

	public int removeCustomer(Customer customer) {
		return dao.deleteCustomer(customer);
	}
	
}
