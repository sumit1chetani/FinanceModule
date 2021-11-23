package com.dci.tenant.finance.staffcircular;

import java.util.ArrayList;
import java.util.List;

public class StaffCircularBean {

	private ArrayList departmentList = new ArrayList();

	private ArrayList designationList = new ArrayList();

	private ArrayList gradeList = new ArrayList();

	private ArrayList divisionList = new ArrayList();

	private Integer staffNotificationId;

	private ArrayList reportingToList = new ArrayList();

	private ArrayList department = new ArrayList();

	private ArrayList designation = new ArrayList();

	private ArrayList grade = new ArrayList();

	private ArrayList division = new ArrayList();

	private ArrayList reporting = new ArrayList();

	private Integer staffCircularId;
	private Integer staffCircularDetailId;
	private List<String> mobileNo;
	private String phoneNo;
	private String title;
	private String status;
	private String departmentName;
	private String publish;

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	private String designationName;
	private String divisionName;
	private String gradeName;
	private String reportingToName;
	private String toDate;
	private String fromDate;

	/*
	 * private Integer department; private Integer designation; private Integer
	 * grade; private Integer division; private String reporting;
	 */

	public String getToDate() {
		return toDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	private String notificationContent;

	public ArrayList getDepartment() {
		return department;
	}

	public void setDepartment(ArrayList department) {
		this.department = department;
	}

	public ArrayList getDesignation() {
		return designation;
	}

	public void setDesignation(ArrayList designation) {
		this.designation = designation;
	}

	public ArrayList getGrade() {
		return grade;
	}

	public void setGrade(ArrayList grade) {
		this.grade = grade;
	}

	public ArrayList getDivision() {
		return division;
	}

	public void setDivision(ArrayList division) {
		this.division = division;
	}

	private String credtedBy;
	private String createdBy;

	private String createdDate;

	private String modifiedBy;

	private String modifiedDate;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCredtedBy() {
		return createdBy;
	}

	public void setCreatedBy(String creadtedBy) {
		this.createdBy = creadtedBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getStaffNotificationId() {
		return staffNotificationId;
	}

	public void setStaffNotificationId(Integer staffNotificationId) {
		this.staffNotificationId = staffNotificationId;
	}

	public ArrayList getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(ArrayList departmentList) {
		this.departmentList = departmentList;
	}

	public ArrayList getDesignationList() {
		return designationList;
	}

	public void setDesignationList(ArrayList designationList) {
		this.designationList = designationList;
	}

	public ArrayList getGradeList() {
		return gradeList;
	}

	public void setGradeList(ArrayList gradeList) {
		this.gradeList = gradeList;
	}

	public ArrayList getDivisionList() {
		return divisionList;
	}

	public void setDivisionList(ArrayList divisionList) {
		this.divisionList = divisionList;
	}

	public ArrayList getReportingToList() {
		return reportingToList;
	}

	public void setReportingToList(ArrayList reportingToList) {
		this.reportingToList = reportingToList;
	}

	public String getNotificationContent() {
		return notificationContent;
	}

	public void setNotificationContent(String notificationContent) {
		this.notificationContent = notificationContent;
	}

	public ArrayList getReporting() {
		return reporting;
	}

	public void setReporting(ArrayList reporting) {
		this.reporting = reporting;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getReportingToName() {
		return reportingToName;
	}

	public void setReportingToName(String reportingToName) {
		this.reportingToName = reportingToName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getStaffCircularId() {
		return staffCircularId;
	}

	public void setStaffCircularId(Integer staffCircularId) {
		this.staffCircularId = staffCircularId;
	}

	public Integer getStaffCircularDetailId() {
		return staffCircularDetailId;
	}

	public void setStaffCircularDetailId(Integer staffCircularDetailId) {
		this.staffCircularDetailId = staffCircularDetailId;
	}

	public List<String> getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(List<String> mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setCredtedBy(String credtedBy) {
		this.credtedBy = credtedBy;
	}
}