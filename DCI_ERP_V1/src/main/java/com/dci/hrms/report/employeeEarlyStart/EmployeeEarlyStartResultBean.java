package com.dci.hrms.report.employeeEarlyStart;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class EmployeeEarlyStartResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<EmployeeEarlyStartResultBean> hospitalList;

	private List<EmployeeEarlyStartBean> earlyStartList;

	private List<EmployeeEarlyStartBean> LateList;

	private List<EmployeeEarlyStartBean> habitualLateList;

	private List<EmployeeEarlyStartResultBean> employeeList;

	private List<EmployeeEarlyStartResultBean> divisionList;

	private List<EmployeeEarlyStartBean> empDetailList;

	private List<EmployeeEarlyStartBean> leaveTypeList;

	private List<EmployeeEarlyStartBean> leaveDetails;

	private String id;

	private String text;

	public List<EmployeeEarlyStartResultBean> getDivisionList() {
		return divisionList;
	}

	public void setDivisionList(List<EmployeeEarlyStartResultBean> divisionList) {
		this.divisionList = divisionList;
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

	public List<EmployeeEarlyStartResultBean> getHospitalList() {
		return hospitalList;
	}

	public void setHospitalList(List<EmployeeEarlyStartResultBean> hospitalList) {
		this.hospitalList = hospitalList;
	}

	public List<EmployeeEarlyStartBean> getEarlyStartList() {
		return earlyStartList;
	}

	public void setEarlyStartList(List<EmployeeEarlyStartBean> earlyStartList) {
		this.earlyStartList = earlyStartList;
	}

	public List<EmployeeEarlyStartBean> getLateList() {
		return LateList;
	}

	public void setLateList(List<EmployeeEarlyStartBean> lateList) {
		LateList = lateList;
	}

	public List<EmployeeEarlyStartBean> getHabitualLateList() {
		return habitualLateList;
	}

	public void setHabitualLateList(List<EmployeeEarlyStartBean> habitualLateList) {
		this.habitualLateList = habitualLateList;
	}

	public List<EmployeeEarlyStartResultBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeEarlyStartResultBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<EmployeeEarlyStartBean> getEmpDetailList() {
		return empDetailList;
	}

	public void setEmpDetailList(List<EmployeeEarlyStartBean> empDetailList) {
		this.empDetailList = empDetailList;
	}

	public List<EmployeeEarlyStartBean> getLeaveTypeList() {
		return leaveTypeList;
	}

	public void setLeaveTypeList(List<EmployeeEarlyStartBean> leaveTypeList) {
		this.leaveTypeList = leaveTypeList;
	}

	public List<EmployeeEarlyStartBean> getLeaveDetails() {
		return leaveDetails;
	}

	public void setLeaveDetails(List<EmployeeEarlyStartBean> leaveDetails) {
		this.leaveDetails = leaveDetails;
	}

}
