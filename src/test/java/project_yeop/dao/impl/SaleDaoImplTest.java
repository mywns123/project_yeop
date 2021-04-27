package project_yeop.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_yeop.dao.salebylLaundryDao;
import project_yeop.dto.Laundry;
import project_yeop.dto.salebylLaundry;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoImplTest {
	
	private static  salebylLaundryDao dao =  salebylLaundryDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectSaleByAll() {
		System.out.printf("%s()%n", "test01SelectSaleByAll");
		List <salebylLaundry> list = dao.selectSaleByAll();
		Assert.assertNotNull(list);
	}

	@Test
	public void test02SelectSaleByNo() {
		System.out.printf("%s()%n", "test02SelectSaleByNo()");
		salebylLaundry sale = new salebylLaundry(new Laundry("AAA"));
		salebylLaundry searchsale = dao.selectSaleByNo(sale);
		Assert.assertNotNull(searchsale);
	}

}
