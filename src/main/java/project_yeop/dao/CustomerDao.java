package project_yeop.dao;

import java.util.List;

import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;

public interface CustomerDao {
	
	List<Customer> selectCustomerByAll();

	Customer selectCustomerByNo(Customer customer);	

	int insertCustomer(Customer customer);

	int updateCustomer(Customer customer);

	int deleteCustomer(Customer customer);
	
	List<CtTable> selectCtTableByAll();

	CtTable selectCtTableByNo(CtTable CtTable);
}
