package com.dci.truck.grade;


import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class GradeAdminResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private GradeAdmin grade = new GradeAdmin();

	private List<GradeAdmin> gradeList;

	private List<GradeAdmin> companyList;

	public List<GradeAdmin> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<GradeAdmin> gradeList) {
		this.gradeList = gradeList;
	}

	public GradeAdmin getGrade() {
		return grade;
	}

	public void setGrade(GradeAdmin grade) {
		this.grade = grade;
	}

	public List<GradeAdmin> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<GradeAdmin> companyList) {
		this.companyList = companyList;
	}

}

