package com.dci.finance.leavedeclare;

import java.io.Serializable;
import java.util.List;

import com.dci.tenant.finance.reports.financials.BankBook.BankBookResultBean;






public class LeaveDeclareResultBean extends BankBookResultBean implements Serializable {
	
	private List<LeaveDeclareBean> leaveDeclareList;
	private List<LeaveDeclareBean> gradeList;
	private List<LeaveDeclareBean> yearList;
	private List<leavedeclareListBean> gradeTypeList;
	private LeaveDeclareBean leaveDeclareObj;
	private String year;
	
	private String branch;
	
	
	private List<LeaveDeclareBean> employeeTypeList;

	
	
	

	public List<LeaveDeclareBean> getEmployeeTypeList() {
		return employeeTypeList;
	}
	public void setEmployeeTypeList(List<LeaveDeclareBean> employeeTypeList) {
		this.employeeTypeList = employeeTypeList;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public List<LeaveDeclareBean> getLeaveDeclareList() {
		return leaveDeclareList;
	}
	public void setLeaveDeclareList(List<LeaveDeclareBean> leaveDeclareList) {
		this.leaveDeclareList = leaveDeclareList;
	}
	public List<LeaveDeclareBean> getGradeList() {
		return gradeList;
	}
	public void setGradeList(List<LeaveDeclareBean> gradeList) {
		this.gradeList = gradeList;
	}
	public List<LeaveDeclareBean> getYearList() {
		return yearList;
	}
	public void setYearList(List<LeaveDeclareBean> yearList) {
		this.yearList = yearList;
	}
	public List<leavedeclareListBean> getGradeTypeList() {
		return gradeTypeList;
	}
	public void setGradeTypeList(List<leavedeclareListBean> gradeTypeList) {
		this.gradeTypeList = gradeTypeList;
	}
	public LeaveDeclareBean getLeaveDeclareObj() {
		return leaveDeclareObj;
	}
	public void setLeaveDeclareObj(LeaveDeclareBean leaveDeclareObj) {
		this.leaveDeclareObj = leaveDeclareObj;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	
	
}
