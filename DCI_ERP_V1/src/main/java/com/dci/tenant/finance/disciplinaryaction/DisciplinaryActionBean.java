package com.dci.tenant.finance.disciplinaryaction;

import java.util.List;

public class DisciplinaryActionBean {
	private int disciplinary_proceedings_sk;
	private String proceedings_date;
	private String proceedings;
	private String employeeId;
	private String suspendFrom;
	private String suspendTo;
	private int suspendedDays;
	private String issueWarning;
	private String reason;
	private String approved_by;
	private String approved_on;
	private boolean status;
	private String hospitalId;
	private String branchId;
	private String designationId;
	private String departmentId;
	private String gradeId;
	private String employeename;
	
	
	
	
	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	private String id;
	private String text;
	private String employeeName;

	private DisciplinaryActionBean disciplinaryData;
	// private List<DisciplinaryActionBean> disciplinaryData;
	private List<DisciplinaryActionBean> Discipline;

	private List<DisciplinaryActionBean> employeeList;

	public int getDisciplinary_proceedings_sk() {
		return disciplinary_proceedings_sk;
	}

	public void setDisciplinary_proceedings_sk(int disciplinary_proceedings_sk) {
		this.disciplinary_proceedings_sk = disciplinary_proceedings_sk;
	}

	public String getProceedings_date() {
		return proceedings_date;
	}

	public void setProceedings_date(String proceedings_date) {
		this.proceedings_date = proceedings_date;
	}

	public String getProceedings() {
		return proceedings;
	}

	public void setProceedings(String proceedings) {
		this.proceedings = proceedings;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getApproved_by() {
		return approved_by;
	}

	public String getSuspendFrom() {
		return suspendFrom;
	}

	public void setSuspendFrom(String suspendFrom) {
		this.suspendFrom = suspendFrom;
	}

	public String getSuspendTo() {
		return suspendTo;
	}

	public void setSuspendTo(String suspendTo) {
		this.suspendTo = suspendTo;
	}

	public String getIssueWarning() {
		return issueWarning;
	}

	public void setIssueWarning(String issueWarning) {
		this.issueWarning = issueWarning;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}

	public String getApproved_on() {
		return approved_on;
	}

	public void setApproved_on(String approved_on) {
		this.approved_on = approved_on;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<DisciplinaryActionBean> getDiscipline() {
		return Discipline;
	}

	public void setDiscipline(List<DisciplinaryActionBean> discipline) {
		Discipline = discipline;
	}

	public DisciplinaryActionBean getDisciplinaryData() {
		return disciplinaryData;
	}

	public void setDisciplinaryData(DisciplinaryActionBean disciplinaryData) {
		this.disciplinaryData = disciplinaryData;
	}

	public int getSuspendedDays() {
		return suspendedDays;
	}

	public void setSuspendedDays(int suspendedDays) {
		this.suspendedDays = suspendedDays;
	}

	

	public List<DisciplinaryActionBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<DisciplinaryActionBean> employeeList) {
		this.employeeList = employeeList;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	
	
	

}
