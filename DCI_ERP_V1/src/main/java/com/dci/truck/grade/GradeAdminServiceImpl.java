package com.dci.truck.grade;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GradeAdminServiceImpl implements GradeAdminService {
	@Autowired
	GradeAdminDAO gradeDAO;

	@Override
	public List<GradeAdmin> getGradeList() throws Exception {
		return gradeDAO.getGradeList();
	}

	@Override
	public boolean insertGrade(GradeAdmin grade) throws Exception {
		// TODO Auto-generated method stub
		return gradeDAO.insertGrade(grade);
	}

	@Override
	public GradeAdmin getGradeById(Integer gradeId) throws Exception {
		// TODO Auto-generated method stub
		GradeAdmin grade = gradeDAO.getGradeById(gradeId);
		return grade;

	}

	@Override
	public boolean updateGrade(GradeAdmin grade) throws Exception {
		// TODO Auto-generated method stub
		return gradeDAO.updateGrade(grade);

	}

	@Override
	public void deleteGrade(Integer gradeId) throws Exception {
		// TODO Auto-generated method stub
		gradeDAO.deleteGrade(gradeId);

	}

	@Override
	public GradeAdminResultBean getCompanyList() throws Exception {
		// TODO Auto-generated method stub
		return gradeDAO.getCompanyList();
	}

	@Override
	public void uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		gradeDAO.uploadFile(file);

	}
}

