package com.dci.tenant.finance.generalpurchaseInvoice;

public class GeneralPurchaseInvoiceDetailBean {

	private int siNo;
	private String accountHeadCode;
	private String shortDetail;
	private String subGrpCode;
	private double amount;
	private double taxAmount;
	private double totalAmount;
	private boolean select;
	// Account Attributes implementation
	private String departmentCode;
	private String countryCode;
	private String customerCode;
	private String supplierCode;
	private Integer designationCode;
	private String companyCode;
	private int assetCode;
	private Integer patientCode;
	private String purInvoiceNo;
	private Integer costCenter;
	private String acctHeadCode;
	private int purDtlId;
	private String subAccountName;
	private String accountHeadName;
	private String isEmployee;

	private String isDepartment;
	private String subaccountHeadCode;
	private String servicedetail;
	
	private String supplier;

	public String getSubaccountHeadCode() {
		return subaccountHeadCode;
	}

	public void setSubaccountHeadCode(String subaccountHeadCode) {
		this.subaccountHeadCode = subaccountHeadCode;
	}

	public String getServicedetail() {
		return servicedetail;
	}

	public void setServicedetail(String servicedetail) {
		this.servicedetail = servicedetail;
	}

	public String getIsDepartment() {
		return isDepartment;
	}

	public void setIsDepartment(String isDepartment) {
		this.isDepartment = isDepartment;
	}

	public String getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(String isEmployee) {
		this.isEmployee = isEmployee;
	}

	private String employeeCode;

	private double ahamount;

	public double getAhamount() {
		return ahamount;
	}

	public void setAhamount(double ahamount) {
		this.ahamount = ahamount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public Integer getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(Integer designationCode) {
		this.designationCode = designationCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Integer getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(Integer patientCode) {
		this.patientCode = patientCode;
	}

	public String getPurInvoiceNo() {
		return purInvoiceNo;
	}

	public void setPurInvoiceNo(String purInvoiceNo) {
		this.purInvoiceNo = purInvoiceNo;
	}

	public String getAcctHeadCode() {
		return acctHeadCode;
	}

	public void setAcctHeadCode(String acctHeadCode) {
		this.acctHeadCode = acctHeadCode;
	}

	public String getSubAccountName() {
		return subAccountName;
	}

	public void setSubAccountName(String subAccountName) {
		this.subAccountName = subAccountName;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
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

	/**
	 * @return the costCenter
	 */
	public Integer getCostCenter() {
		return costCenter;
	}

	/**
	 * @param costCenter
	 *            the costCenter to set
	 */
	public void setCostCenter(Integer costCenter) {
		this.costCenter = costCenter;
	}

	/**
	 * @return the assetCode
	 */
	public int getAssetCode() {
		return assetCode;
	}

	/**
	 * @param assetCode
	 *            the assetCode to set
	 */
	public void setAssetCode(int assetCode) {
		this.assetCode = assetCode;
	}

	/**
	 * @return the purDtlId
	 */
	public int getPurDtlId() {
		return purDtlId;
	}

	/**
	 * @param purDtlId
	 *            the purDtlId to set
	 */
	public void setPurDtlId(int purDtlId) {
		this.purDtlId = purDtlId;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

}
