package com.dci.truck.grade;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface GradeAdminDAO {
	public List<GradeAdmin> getGradeList() throws CustomException;

	public boolean insertGrade(GradeAdmin objGrade) throws CustomException;

	public GradeAdmin getGradeById(Integer gradeId) throws CustomException;

	public boolean updateGrade(GradeAdmin grade) throws CustomException;

	public void deleteGrade(Integer gradeId) throws CustomException;

	public GradeAdminResultBean getCompanyList() throws CustomException;

	public void uploadFile(MultipartFile file);
}

