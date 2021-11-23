package com.dci.payroll.payroll.loanEntry;

public class LoanEntry {

	private boolean isEdit;
	private Integer loanId;
	private String employeeId;
	private String employeeName;
	private String companyId;
	private String companyName;
	private Integer departmentId;
	private String departmentName;
	private String branchId;
	private String branchName;
	private String loanTypeId;
	private double amount;
	private int numberOfInstalments;
	private String deductFrom;
	private String deductFromDisplay;
	private String loanTypeName;
	private String totalInterest;
	private double deductionAmount;
	private String approvedOn;
	private String approvedBy;
	private int status;
	private double interestRate;
	private Integer flatOrDiminishing;

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

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

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(String loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getNumberOfInstalments() {
		return numberOfInstalments;
	}

	public void setNumberOfInstalments(int numberOfInstalments) {
		this.numberOfInstalments = numberOfInstalments;
	}

	public String getDeductFrom() {
		return deductFrom;
	}

	public void setDeductFrom(String deductFrom) {
		this.deductFrom = deductFrom;
	}

	public double getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(double deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public String getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(String approvedOn) {
		this.approvedOn = approvedOn;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getFlatOrDiminishing() {
		return flatOrDiminishing;
	}

	public void setFlatOrDiminishing(Integer flatOrDiminishing) {
		this.flatOrDiminishing = flatOrDiminishing;
	}

	public String getDeductFromDisplay() {
		return deductFromDisplay;
	}

	public void setDeductFromDisplay(String deductFromDisplay) {
		this.deductFromDisplay = deductFromDisplay;
	}

	public String getLoanTypeName() {
		return loanTypeName;
	}

	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
	}

	public String getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(String totalInterest) {
		this.totalInterest = totalInterest;
	}

}