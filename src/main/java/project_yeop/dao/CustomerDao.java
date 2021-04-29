package project_yeop.dao;

import java.util.List;

import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;

public interface CustomerDao {

	List<CtTable> selectCtTableByAll();
	
	List<CtTable> selectCtTableByNo(int no);
	
	List<CtTable> selectCtTableByName(String name);

	List<CtTable> selectCtTableByGender(boolean gender);

	List<CtTable> selectCtTableByGrade(String grade);
	
	List<CtTable> selectCtTableByUnRel();

	CtTable selectCtTableByNo(CtTable ctTable);	

	int insertCustomer(Customer customer);

	int updateCustomer(Customer customer);

	int deleteCustomer(Customer customer);

}
