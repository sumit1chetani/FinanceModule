package com.dci.payroll.payroll.payrollgeneration;

public class PayrollGenerationBean {
	private int totalAmount;

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	private String currentGross;
	private String earningArrear;

	public String getEarningArrear() {
		return earningArrear;
	}

	public void setEarningArrear(String earningArrear) {
		this.earningArrear = earningArrear;
	}

	public String getCurrentGross() {
		return currentGross;
	}

	public void setCurrentGross(String currentGross) {
		this.currentGross = currentGross;
	}

	private String employeeId;
	private String companyId;
	private String companyName;
	private String branchName;
	private String firstName;
	private String branchId;
	private String hdrId;
	private String rangeDate;
	private String departmentName;
	private String professionaltax;
//	private Integer departmentId;
	private String employeeName;
	private String monthYear;
	private String payComponentId;
	private String amount;
	private String taxSlabAmount;
	private String payComponentType;
	private String loginUserEmpId;
	private String monthValue;
	private String payslipYear;
	private String id;
	private int designationId;
	private String designationName;
	private String text;
	private int dId;
	private boolean success;
	private boolean flagMessage;
	private boolean withHold;
	/**
	 * 
	 */
	private boolean salaryError;
	private String accountCode;
private String dept;
private String departmentId;

	public String getDepartmentId() {
	return departmentId;
}

public void setDepartmentId(String departmentId) {
	this.departmentId = departmentId;
}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getProfessionaltax() {
		return professionaltax;
	}

	public void setProfessionaltax(String professionaltax) {
		this.professionaltax = professionaltax;
	}

	public String getHdrId() {
		return hdrId;
	}

	public void setHdrId(String hdrId) {
		this.hdrId = hdrId;
	}

	public String getRangeDate() {
		return rangeDate;
	}

	public void setRangeDate(String rangeDate) {
		this.rangeDate = rangeDate;
	}

	public String getTaxSlabAmount() {
		return taxSlabAmount;
	}

	public void setTaxSlabAmount(String taxSlabAmount) {
		this.taxSlabAmount = taxSlabAmount;
	}

	public boolean isSalaryError() {
		return salaryError;
	}

	public void setSalaryError(boolean salaryError) {
		this.salaryError = salaryError;
	}

	public boolean isFlagMessage() {
		return flagMessage;
	}

	public void setFlagMessage(boolean flagMessage) {
		this.flagMessage = flagMessage;
	}

	public boolean isWithHold() {
		return withHold;
	}

	public void setWithHold(boolean withHold) {
		this.withHold = withHold;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getPayComponentId() {
		return payComponentId;
	}

	public void setPayComponentId(String payComponentId) {
		this.payComponentId = payComponentId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPayComponentType() {
		return payComponentType;
	}

	public void setPayComponentType(String payComponentType) {
		this.payComponentType = payComponentType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

//	public Integer getDepartmentId() {
//		return departmentId;
//	}
//
//	public void setDepartmentId(Integer departmentId) {
//		this.departmentId = departmentId;
//	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getMonthValue() {
		return monthValue;
	}

	public void setMonthValue(String monthValue) {
		this.monthValue = monthValue;
	}

	public String getPayslipYear() {
		return payslipYear;
	}

	public void setPayslipYear(String payslipYear) {
		this.payslipYear = payslipYear;
	}

	public String getLoginUserEmpId() {
		return loginUserEmpId;
	}

	public void setLoginUserEmpId(String loginUserEmpId) {
		this.loginUserEmpId = loginUserEmpId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}