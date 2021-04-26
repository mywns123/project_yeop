package project_yeop.service;

import java.util.List;

import project_yeop.dao.LaundryDao;
import project_yeop.dao.impl.LaundryDaoImpl;
import project_yeop.dto.Laundry;

public class LaundryService {
	private LaundryDao dao = LaundryDaoImpl.getInstance();

	public List<Laundry> showLaundrys() {
		return dao.selectLaundryByAll();
	}

	public int addLaundry(Laundry laundry) {
		return dao.insertLaundry(laundry);
	}

	public int modifyLaundry(Laundry laundry) {
		return dao.updateLaundry(laundry);
	}

	public int removeLaundry(Laundry laundry) {
		return dao.deleteLaundry(laundry);
	}
	
	
	
	public Laundry showLaundry(Laundry laundry) {
		return dao.selectLaundryByNo(laundry);
	}

}
