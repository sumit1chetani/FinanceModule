package com.dci.truck.grade;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface GradeAdminService {
	List<GradeAdmin> getGradeList() throws Exception;

	boolean insertGrade(GradeAdmin grade) throws Exception;

	public GradeAdmin getGradeById(Integer gradeId) throws Exception;

	boolean updateGrade(GradeAdmin grade) throws Exception;

	void deleteGrade(Integer gradeId) throws Exception;

	GradeAdminResultBean getCompanyList() throws Exception;

	public void uploadFile(MultipartFile file);
}

