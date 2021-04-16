package project_yeop.dao;

import java.util.List;

import project_yeop.dto.Laundry;

public interface LaundryDao {

	List<Laundry> selectLaundryByAll();

	Laundry selectLaundryByNo(Laundry laundry);

	int insertLaundry(Laundry laundry);

	int updateLaundry(Laundry laundry);

	int deleteLaundry(Laundry laundry);
}
