package project_yeop.service;

import java.util.List;

import project_yeop.dao.GradeDao;
import project_yeop.dao.impl.GradeDaoImpl;
import project_yeop.dto.Grade;

public class GradeService {
	private GradeDao dao = GradeDaoImpl.getInstance();

	public List<Grade> showGrades() {
		return dao.selectGradeByAll();
	}

	public int modifyGrade(Grade grade) {
		return dao.updateGrade(grade);
	}

	public int addGrade(Grade grade) {
		return dao.insertGrade(grade);
	}

	public int removeGrade(Grade grade) {
		return dao.deleteGrade(grade);
	}

	

	public Grade showGrade(Grade grade) {
		return dao.selectGradeByNo(grade);
	}

	
	
}
