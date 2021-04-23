package project_yeop.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_yeop.dao.SaleDao;
import project_yeop.dto.Laundry;
import project_yeop.dto.Sale;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoImplTest {
	
	private static  SaleDao dao =  SaleDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectSaleByAll() {
		System.out.printf("%s()%n", "test01SelectSaleByAll");
		List <Sale> list = dao.selectSaleByAll();
		Assert.assertNotNull(list);
	}

	@Test
	public void test02SelectSaleByNo() {
		System.out.printf("%s()%n", "test02SelectSaleByNo()");
		Sale sale = new Sale(new Laundry("AAA"));
		Sale searchsale = dao.selectSaleByNo(sale);
		Assert.assertNotNull(searchsale);
	}

}
