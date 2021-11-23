package com.dci.payroll.payroll.gradepaycomponent;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dci.common.util.BasicResultBean;


public class GradePayComponentResultBean extends BasicResultBean implements Serializable {
	private List<GradePayComponentBean> gradePayComList;
	private List<Map<String, Object>> gradeComponentList;
	private boolean salaryCreated;
	private boolean salaryExists;
	private List<GradePayComponentBean> gradeList = null;
	private GradePayComponentBean gradePayComBean = null;

	public List<GradePayComponentBean> getGradePayComList() {
		return gradePayComList;
	}

	public void setGradePayComList(List<GradePayComponentBean> gradePayComList) {
		this.gradePayComList = gradePayComList;
	}

	public List<Map<String, Object>> getGradeComponentList() {
		return gradeComponentList;
	}

	public boolean isSalaryCreated() {
		return salaryCreated;
	}

	public void setSalaryCreated(boolean salaryCreated) {
		this.salaryCreated = salaryCreated;
	}

	public boolean isSalaryExists() {
		return salaryExists;
	}

	public void setSalaryExists(boolean salaryExists) {
		this.salaryExists = salaryExists;
	}

	public void setGradeComponentList(List<Map<String, Object>> gradeComponentList) {
		this.gradeComponentList = gradeComponentList;
	}

	public GradePayComponentBean getGradePayComBean() {
		return gradePayComBean;
	}

	public void setGradePayComBean(GradePayComponentBean gradePayComBean) {
		this.gradePayComBean = gradePayComBean;
	}

	public List<GradePayComponentBean> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<GradePayComponentBean> gradeList) {
		this.gradeList = gradeList;
	}
}