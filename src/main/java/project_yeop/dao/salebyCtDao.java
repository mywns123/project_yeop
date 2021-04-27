package project_yeop.dao;

import java.util.List;

import project_yeop.dto.salebyCt;

public interface salebyCtDao {

	List<salebyCt> selectSaleByCt();

	salebyCt selectSaleByNo(salebyCt sale);
	
}
