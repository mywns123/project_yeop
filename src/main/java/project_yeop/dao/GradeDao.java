package project_yeop.dao;

import java.util.List;

import project_yeop.dto.Grade;

public interface GradeDao {
	
	List<Grade> selectGradeByAll();

	Grade selectGradeByNo(Grade grade);

	int insertGrade(Grade grade);

	int updateGrade(Grade grade);

	int deleteGrade(Grade grade);
}
