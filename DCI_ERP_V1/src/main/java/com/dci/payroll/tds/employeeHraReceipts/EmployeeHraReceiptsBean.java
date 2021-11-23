package com.dci.payroll.tds.employeeHraReceipts;

import java.math.BigDecimal;

public class EmployeeHraReceiptsBean {
	private String employeeId;
	private String monthYear;
	private String monthYearDisplay;
	private BigDecimal rentPaid;
	private String fileName;
	private String branchId;
	private String branchName;
	private String departmentName;
	private int departmentId;
	private String companyId;
	private String companyName;
	private String employeeName;
	private String month;
	private String id;
	private String text;

	private int hraStatus;
	private boolean isEdit; // Button Change While Adding and Updating

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getHraStatus() {
		return hraStatus;
	}

	public void setHraStatus(int hraStatus) {
		this.hraStatus = hraStatus;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public BigDecimal getRentPaid() {
		return rentPaid;
	}

	public void setRentPaid(BigDecimal rentPaid) {
		this.rentPaid = rentPaid;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getMonthYearDisplay() {
		return monthYearDisplay;
	}

	public void setMonthYearDisplay(String monthYearDisplay) {
		this.monthYearDisplay = monthYearDisplay;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}