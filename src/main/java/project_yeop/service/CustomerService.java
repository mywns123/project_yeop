package project_yeop.service;

import java.util.List;

import project_yeop.dao.CustomerDao;
import project_yeop.dao.impl.CustomerDaoImpl;
import project_yeop.dto.Customer;

public class CustomerService {
	private CustomerDao dao = CustomerDaoImpl.getInstance();

	public List<Customer> showCustomers() {
		return dao.selectCustomerByAll();
	}

	public Customer showCustomer(Customer customer) {
		return dao.selectCustomerByNo(customer);
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
