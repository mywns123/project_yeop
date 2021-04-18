package project_yeop.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_yeop.dao.GradeDao;
import project_yeop.dto.Grade;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GradeDaoImplTest {
	private static  GradeDao dao =  GradeDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectGradeByAll() {
		System.out.printf("%s()%n", "test01SelectGradeByAll()");
		List <Grade> list = dao.selectGradeByAll();
		Assert.assertNotNull(list);
	}

	@Test
	public void test04SelectGradeByNo() {
		System.out.printf("%s()%n", "test04SelectGradeByNo()");
		Grade grade = new Grade("A");
		Grade searchgrade = dao.selectGradeByNo(grade);
		Assert.assertNotNull(searchgrade);		
	}

	@Test
	public void test02InsertGrade() {
		System.out.printf("%s()%n", "test02InsertGrade()");
		Grade grade = new Grade("D", 5);
		int res = dao.insertGrade(grade);
		Assert.assertEquals(1, res);
		}

	@Test
	public void test03UpdateGrade() {
		System.out.printf("%s()%n", "test03UpdateGrade()");
		Grade grade = new Grade("D", 1);
		int res = dao.updateGrade(grade);
		Assert.assertEquals(1, res);		
	}

	@Test
	public void test05DeleteGrade() {
		System.out.printf("%s()%n", "test05DeleteGrade()");
		Grade grade = new Grade("D");
		int res = dao.deleteGrade(grade);
		Assert.assertEquals(1, res);
	}

}
