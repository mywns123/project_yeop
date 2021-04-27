package project_yeop.dao;

import java.util.List;

import project_yeop.dto.Column;
import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;

public interface CustomerDao {

	List<CtTable> selectCtTableByAll();

	CtTable selectCtTableByNo(CtTable ctTable);

	CtTable selectCtTableByName(CtTable ctTable);

	CtTable selectCtTableByGender(CtTable ctTable);

	CtTable selectCtTableByGrade(CtTable ctTable);

	int insertCustomer(Customer customer);

	int updateCustomer(Customer customer);

	int deleteCustomer(Customer customer);

}
