package project_yeop.service;

import java.util.List;

import project_yeop.dao.CustomerDao;
import project_yeop.dao.impl.CustomerDaoImpl;
import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;

public class CustomerService {
	private CustomerDao dao = CustomerDaoImpl.getInstance();

	public int modifyCustomer(Customer customer) {
		return dao.updateCustomer(customer);
	}

	public int removeCustomer(Customer customer) {
		return dao.deleteCustomer(customer);
	}

	public List<CtTable> showCtTable() {
		return dao.selectCtTableByAll();
	}

	public CtTable showCtTableNO(CtTable ctTable) {
		return dao.selectCtTableByNo(ctTable);
	}
	
	
	
	
	
	
	public Customer showCustomer(Customer customer) {
		return dao.selectCustomerByNo(customer);
	}
	
	public List<Customer> showCustomers() {
		return dao.selectCustomerByAll();
	}

	public int addCustomer(Customer customer) {
		return dao.insertCustomer(customer);
	}
	
	
	
}
