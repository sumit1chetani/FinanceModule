package com.dci.tenant.finance.generalInvoice;

public class GeneralInvoiceDetailBean {

	private int siNo;
	private double tax;

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	private String accountHeadCode;
	private String shortDetail;
	private String subGrpCode;
	private double amount;
	private boolean select;

	private String employeeCode;
	private String departmentCode;
	private Integer costCenter;

	public Integer getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(Integer costCenter) {
		this.costCenter = costCenter;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public int getSiNo() {
		return siNo;
	}

	public void setSiNo(int siNo) {
		this.siNo = siNo;
	}

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public String getShortDetail() {
		return shortDetail;
	}

	public void setShortDetail(String shortDetail) {
		this.shortDetail = shortDetail;
	}

	public String getSubGrpCode() {
		return subGrpCode;
	}

	public void setSubGrpCode(String subGrpCode) {
		this.subGrpCode = subGrpCode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

}
