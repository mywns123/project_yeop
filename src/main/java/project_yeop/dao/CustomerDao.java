package project_yeop.dao;

import java.util.List;

import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;

public interface CustomerDao {

	List<CtTable> selectCustomerByAll();

	CtTable selectCustomerByNo(CtTable CtTable);

	int insertCustomer(Customer customer);

	int updateCustomer(Customer customer);

	int deleteCustomer(Customer customer);
}
