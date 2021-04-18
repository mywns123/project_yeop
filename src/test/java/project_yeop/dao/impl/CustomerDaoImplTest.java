package project_yeop.dao.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import project_yeop.dao.CustomerDao;
import project_yeop.dto.Customer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoImplTest {

	private static CustomerDao dao = CustomerDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	

//	@Test
	public void test01SelectCustomerByAll() {
		System.out.printf("%s()%n", "testSelectCustomerByAll");
		List <Customer> list = dao.selectCustomerByAll();
		Assert.assertNotNull(list);
	}

//	@Test
	public void testSelectCustomerByNo() {
		fail("Not yet implemented");
	}

//	@Test
	public void testInsertCustomer() {
		fail("Not yet implemented");
	}

//	@Test
	public void testUpdateCustomer() {
		fail("Not yet implemented");
	}

//	@Test
	public void testDeleteCustomer() {
		fail("Not yet implemented");
	}

}
