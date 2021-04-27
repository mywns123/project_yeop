package project_yeop.dao;

import java.util.List;

import project_yeop.dto.salebyDate;

public interface salebyDateDao {

	List<salebyDate> selectSaleByYear();
	List<salebyDate> selectSaleByMonth();

	salebyDate selectSaleByNo(salebyDate sale);
	
}
