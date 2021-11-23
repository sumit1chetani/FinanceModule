package com.dci.payroll.payroll.payrollgeneration;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dci.common.util.BasicResultBean;


public class PayrollGenerationResultBean extends BasicResultBean implements Serializable {

	private String employeeID;
	private String employeeName;
	private String totalAmount;
	private List<Map<String, Object>> payRollList;

	public List<Map<String, Object>> getPayRollList() {
		return payRollList;
	}

	public void setPayRollList(List<Map<String, Object>> payRollList) {
		this.payRollList = payRollList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	private String salaryHold;
	private boolean checkALreadyCreated;
	private String createdOrNot;
	private List<PayrollGenerationBean> taxDeduction;

	public List<PayrollGenerationBean> getTaxDeduction() {
		return taxDeduction;
	}

	public void setTaxDeduction(List<PayrollGenerationBean> taxDeduction) {
		this.taxDeduction = taxDeduction;
	}

	public String getCreatedOrNot() {
		return createdOrNot;
	}

	public void setCreatedOrNot(String createdOrNot) {
		this.createdOrNot = createdOrNot;
	}

	public boolean isCheckALreadyCreated() {
		return checkALreadyCreated;
	}

	public void setCheckALreadyCreated(boolean checkALreadyCreated) {
		this.checkALreadyCreated = checkALreadyCreated;
	}

	private String noSalary;

	public String getNoSalary() {
		return noSalary;
	}

	public void setNoSalary(String noSalary) {
		this.noSalary = noSalary;
	}

	public String getSalaryHold() {
		return salaryHold;
	}

	public void setSalaryHold(String salaryHold) {
		this.salaryHold = salaryHold;
	}

	private List<PayrollGenerationBean> lscManageAdmissionBean;

	public List<PayrollGenerationBean> getLscManageAdmissionBean() {
		return lscManageAdmissionBean;
	}

	public void setLscManageAdmissionBean(List<PayrollGenerationBean> lscManageAdmissionBean) {
		this.lscManageAdmissionBean = lscManageAdmissionBean;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	private static final long serialVersionUID = 1L;

	private boolean salaryCreated;

	private boolean salaryNotCreatedOthers;

	public boolean isSalaryNotCreatedOthers() {
		return salaryNotCreatedOthers;
	}

	public void setSalaryNotCreatedOthers(boolean salaryNotCreatedOthers) {
		this.salaryNotCreatedOthers = salaryNotCreatedOthers;
	}

	private boolean salaryExists;

	private boolean payrollFlag;

	private boolean withHoldList;

	private boolean flagListStopped;

	public boolean isFlagListStopped() {
		return flagListStopped;
	}

	public void setFlagListStopped(boolean flagListStopped) {
		this.flagListStopped = flagListStopped;
	}

	public boolean isWithHoldList() {
		return withHoldList;
	}

	public void setWithHoldList(boolean withHoldList) {
		this.withHoldList = withHoldList;
	}

	public boolean isPayrollFlag() {
		return payrollFlag;
	}

	public void setPayrollFlag(boolean payrollFlag) {
		this.payrollFlag = payrollFlag;
	}

	private List<Map<String, Object>> flagList;

	public List<Map<String, Object>> getFlagList() {
		return flagList;
	}

	public void setFlagList(List<Map<String, Object>> flagList) {
		this.flagList = flagList;
	}

	private List<PayrollGenerationBean> payrollList;

	private List<Map<String, Object>> payRollListByEmpId;

	private List<PayrollGenerationBean> salaryList = null;

	private List<PayrollGenerationBean> departmentList = null;

	private List<PayrollGenerationBean> typeList = null;

	private List<PayrollGenerationBean> companyList = null;

	private List<PayrollGenerationBean> employeeList = null;

	private List<PayrollGenerationBean> branchList = null;

	private List<PayrollGenerationBean> monthYearList = null;

	private List<PayrollGenerationBean> paySlipYearList = null;

	private PayrollGenerationBean payrollBean = null;

	public List<PayrollGenerationBean> getPayrollList() {
		return payrollList;
	}

	public void setPayrollList(List<PayrollGenerationBean> payrollList) {
		this.payrollList = payrollList;
	}

	public PayrollGenerationBean getPayrollBean() {
		return payrollBean;
	}

	public void setPayrollBean(PayrollGenerationBean payrollBean) {
		this.payrollBean = payrollBean;
	}

	public boolean isSalaryCreated() {
		return salaryCreated;
	}

	public void setSalaryCreated(boolean salaryCreated) {
		this.salaryCreated = salaryCreated;
	}

	public boolean isSalaryExists() {
		return salaryExists;
	}

	public void setSalaryExists(boolean salaryExists) {
		this.salaryExists = salaryExists;
	}

	public List<PayrollGenerationBean> getSalaryList() {
		return salaryList;
	}

	public void setSalaryList(List<PayrollGenerationBean> salaryList) {
		this.salaryList = salaryList;
	}

	public List<PayrollGenerationBean> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<PayrollGenerationBean> departmentList) {
		this.departmentList = departmentList;
	}

	public List<PayrollGenerationBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<PayrollGenerationBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Map<String, Object>> getPayRollListByEmpId() {
		return payRollListByEmpId;
	}

	public void setPayRollListByEmpId(List<Map<String, Object>> payRollListByEmpId) {
		this.payRollListByEmpId = payRollListByEmpId;
	}

	public List<PayrollGenerationBean> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<PayrollGenerationBean> branchList) {
		this.branchList = branchList;
	}

	public List<PayrollGenerationBean> getMonthYearList() {
		return monthYearList;
	}

	public void setMonthYearList(List<PayrollGenerationBean> monthYearList) {
		this.monthYearList = monthYearList;
	}

	public List<PayrollGenerationBean> getPaySlipYearList() {
		return paySlipYearList;
	}

	public void setPaySlipYearList(List<PayrollGenerationBean> paySlipYearList) {
		this.paySlipYearList = paySlipYearList;
	}

	public List<PayrollGenerationBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<PayrollGenerationBean> companyList) {
		this.companyList = companyList;
	}

	public List<PayrollGenerationBean> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<PayrollGenerationBean> typeList) {
		this.typeList = typeList;
	}
}