package com.dci.payroll.payroll.fullfinalsettlement;

import java.util.List;

public class FullFinalSettlementBean {
	private String employeeId;
	private String employeeName;
	private int employeeFinalSettlementId;
	private String createDate;
	private String departmentName;
	private String branchName;
	private String companyName;
	private String status;
	private String createdDate;
	private String approvedBy;
	private String approvedDate;
	private String settlementDate;
	private List<FullFinalSettlementDetailBean> detailList;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getEmployeeFinalSettlementId() {
		return employeeFinalSettlementId;
	}

	public void setEmployeeFinalSettlementId(int employeeFinalSettlementId) {
		this.employeeFinalSettlementId = employeeFinalSettlementId;
	}

	public List<FullFinalSettlementDetailBean> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<FullFinalSettlementDetailBean> detailList) {
		this.detailList = detailList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}