package project_yeop.dao;

import java.util.List;

import project_yeop.dto.salebylLaundry;

public interface salebylLaundryDao {

	List<salebylLaundry> selectSaleByAll();

	salebylLaundry selectSaleByNo(salebylLaundry sale);
	
}
