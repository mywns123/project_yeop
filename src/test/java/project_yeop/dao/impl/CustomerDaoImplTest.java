package project_yeop.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_yeop.dao.CustomerDao;
import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoImplTest {

	private static CustomerDao dao = CustomerDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	

	@Test
	public void test01SelectCustomerByAll() {
		System.out.printf("%s()%n", "test01SelectCustomerByAll");
		List <CtTable> list = dao.selectCtTableByAll();
		Assert.assertNotNull(list);
	}

	@Test
	public void test04SelectCustomerByNo() {
		System.out.printf("%s()%n", "test04SelectCustomerByNo()");
		CtTable ctTable = new CtTable(new Customer(12));
		CtTable searchctTable = dao.selectCtTableByNo(ctTable);
		Assert.assertNotNull(searchctTable);	
	}

	@Test
	public void test02InsertCustomer() {
		System.out.printf("%s()%n", "test02InsertCustomer()");
		Customer customer = new Customer("이현영",false,"012345678","서구");
		int res = dao.insertCustomer(customer);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateCustomer() {
		System.out.printf("%s()%n", "test03UpdateCustomer()");
		Customer customer = new Customer(12,"이현영",false,"111345678","서구");
		int res = dao.updateCustomer(customer);
		Assert.assertEquals(1, res);	
	}

	@Test
	public void test05DeleteCustomer() {
		System.out.printf("%s()%n", "test05DeleteCustomer()");
		Customer customer = new Customer(11);
		int res = dao.deleteCustomer(customer);
		Assert.assertEquals(1, res);
	}

}
