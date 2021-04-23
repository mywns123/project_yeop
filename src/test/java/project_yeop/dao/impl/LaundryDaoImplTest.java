package project_yeop.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_yeop.dao.LaundryDao;
import project_yeop.dto.Laundry;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LaundryDaoImplTest {
	private static LaundryDao dao = LaundryDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectLaundryByAll() {
		System.out.printf("%s()%n", "test01SelectLaundryByAll()");
		List <Laundry> list = dao.selectLaundryByAll();
		Assert.assertNotNull(list);
	}

	@Test
	public void test04SelectLaundryByNo() {
		System.out.printf("%s()%n", "test04SelectLaundryByNo()");
		Laundry laundry = new Laundry("AAA");
		Laundry searchlaundry = dao.selectLaundryByNo(laundry);
		Assert.assertNotNull(searchlaundry);		
	}

	@Test
	public void test02InsertLaundry() {
		System.out.printf("%s()%n", "test02InsertLaundry()");
		Laundry laundry = new Laundry("III","샌들",2500);
		int res = dao.insertLaundry(laundry);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateLaundry() {
		System.out.printf("%s()%n", "test03UpdateLaundry()");
		Laundry laundry = new Laundry("III","샌들",2700);
		int res = dao.updateLaundry(laundry);
		Assert.assertEquals(1, res);	
	}

	@Test
	public void test05DeleteLaundry() {
		System.out.printf("%s()%n", "test05DeleteLaundry()");
		Laundry laundry = new Laundry("III");
		int res = dao.deleteLaundry(laundry);
		Assert.assertEquals(1, res);
	}

}
