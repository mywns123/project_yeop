package project_yeop.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_yeop.dao.OrderDao;
import project_yeop.dto.Customer;
import project_yeop.dto.Laundry;
import project_yeop.dto.OdTable;
import project_yeop.dto.Order;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplTest {

	private static OrderDao dao = OrderDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectOrderByAll() {
		System.out.printf("%s()%n", "test01SelectOrderByAll");
		List <OdTable> list = dao.selectOrderByAll();
		Assert.assertNotNull(list);
	}

	@Test
	public void test04SelectOrderByNo() {
		System.out.printf("%s()%n", "test04SelectOrderByNo()");
		OdTable odTable = new OdTable(new Order(4));
		OdTable searchodTable = dao.selectOrderByNo(odTable);
		Assert.assertNotNull(searchodTable);
	}

	@Test
	public void test02InsertOrder() {
		System.out.printf("%s()%n", "test02InsertOrder()");
		Order order = new Order(new Customer(3),new Laundry("BBB"),"검정",2," ");
		int res = dao.insertOrder(order);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateOrder() {
		System.out.printf("%s()%n", "test03UpdateOrder()");
		Order order = new Order(6,new Customer(3),new Laundry("BBB"),"black",2," ");
		int res = dao.updateOrder(order);
		Assert.assertEquals(1, res);	
	}

	@Test
	public void test05DeleteOrder() {
		System.out.printf("%s()%n", "test05DeleteCustomer()");
		Order order = new Order(6);
		int res = dao.deleteOrder(order);
		Assert.assertEquals(1, res);
	}

}
