package com.dci.payroll.payroll.payslip;

import java.util.ArrayList;
import java.util.List;

public class PaySlipBean {
	private String employeeId;
	private String companyId;
	private String branchId;
	private int departmentId;
	private String payComponentId;
	private String monthYear;
	private String employeeName;
	private String empId;
	private double amount;
	private String month_year;
	private String dept;
	private String bankno;
	private String esicode;
	private String doj;

	private String designation;
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	private String company;

	private int printamount;
	private int payComponentType;
	private double lopAmount;
	private double lopDays;

	private double employeeLeaveAvailable;
	private double employeeLeaveTaken;
	private String email;
	private String desgination;
	private String empName;

	private double totalEarnings;
	private double totalDeductions;
	private int leaveAvailable;
	private int leaveTaken;
	private int earnings;
	private int deductions;
	private String epfno;
	private String uanno;
	private double salDays;
	private double totalDeduct;
	private String accountdebitCode;
	private String accountCode;
	private String month;
	private String year;
	private String paycomponentname;
	private String paybankname ;
	private String cmpyadd ;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getAccountdebitCode() {
		return accountdebitCode;
	}

	public void setAccountdebitCode(String accountdebitCode) {
		this.accountdebitCode = accountdebitCode;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getUanno() {
		return uanno;
	}

	public void setUanno(String uanno) {
		this.uanno = uanno;
	}

	public String getEpfno() {
		return epfno;
	}

	public void setEpfno(String epfno) {
		this.epfno = epfno;
	}

	public double getSalDays() {
		return salDays;
	}

	public void setSalDays(double salDays) {
		this.salDays = salDays;
	}

	public double getTotalDeduct() {
		return totalDeduct;
	}

	public void setTotalDeduct(double totalDeduct) {
		this.totalDeduct = totalDeduct;
	}

	private boolean select;

	public List<PaySlipBean> getMailSend() {
		return mailSend;
	}

	public void setMailSend(List<PaySlipBean> mailSend) {
		this.mailSend = mailSend;
	}

	List<PaySlipBean> mailSend;

	public List<PaySlipBean> getEarningsList() {
		return earningsList;
	}

	public void setEarningsList(List<PaySlipBean> earningsList) {
		this.earningsList = earningsList;
	}

	public List<PaySlipBean> getDeductionsList() {
		return deductionsList;
	}

	public void setDeductionsList(List<PaySlipBean> deductionsList) {
		this.deductionsList = deductionsList;
	}

	List<PaySlipBean> earningsList = new ArrayList<>();
	List<PaySlipBean> deductionsList = new ArrayList<>();

	List<PaySlipBean> test;

	public double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public double getTotalDeductions() {
		return totalDeductions;
	}

	public void setTotalDeductions(double totalDeductions) {
		this.totalDeductions = totalDeductions;
	}

	public int getLeaveAvailable() {
		return leaveAvailable;
	}

	public void setLeaveAvailable(int leaveAvailable) {
		this.leaveAvailable = leaveAvailable;
	}

	public int getLeaveTaken() {
		return leaveTaken;
	}

	public void setLeaveTaken(int leaveTaken) {
		this.leaveTaken = leaveTaken;
	}

	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}

	public int getDeductions() {
		return deductions;
	}

	public void setDeductions(int deductions) {
		this.deductions = deductions;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPayComponentId() {
		return payComponentId;
	}

	public void setPayComponentId(String payComponentId) {
		this.payComponentId = payComponentId;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPayComponentType() {
		return payComponentType;
	}

	public void setPayComponentType(int payComponentType) {
		this.payComponentType = payComponentType;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}



	public double getEmployeeLeaveAvailable() {
		return employeeLeaveAvailable;
	}

	public void setEmployeeLeaveAvailable(double employeeLeaveAvailable) {
		this.employeeLeaveAvailable = employeeLeaveAvailable;
	}

	public double getEmployeeLeaveTaken() {
		return employeeLeaveTaken;
	}

	public void setEmployeeLeaveTaken(double employeeLeaveTaken) {
		this.employeeLeaveTaken = employeeLeaveTaken;
	}

	public int getPrintamount() {
		return printamount;
	}

	public void setPrintamount(int printamount) {
		this.printamount = printamount;
	}

	/**
	 * @return the lopAmount
	 */
	public double getLopAmount() {
		return lopAmount;
	}

	/**
	 * @param lopAmount
	 *            the lopAmount to set
	 */
	public void setLopAmount(double lopAmount) {
		this.lopAmount = lopAmount;
	}

	/**
	 * @return the lopDays
	 */
	public double getLopDays() {
		return lopDays;
	}

	/**
	 * @param lopDays
	 *            the lopDays to set
	 */
	public void setLopDays(double lopDays) {
		this.lopDays = lopDays;
	}

	public List<PaySlipBean> getTest() {
		return test;
	}

	public void setTest(List<PaySlipBean> test) {
		this.test = test;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDesgination() {
		return desgination;
	}

	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public String getMonth_year() {
		return month_year;
	}

	public void setMonth_year(String month_year) {
		this.month_year = month_year;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;

	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBankno() {
		return bankno;
	}

	public void setBankno(String bankno) {
		this.bankno = bankno;
	}

	public String getEsicode() {
		return esicode;
	}

	public void setEsicode(String esicode) {
		this.esicode = esicode;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getPaycomponentname() {
		return paycomponentname;
	}

	public void setPaycomponentname(String paycomponentname) {
		this.paycomponentname = paycomponentname;
	}

	public String getPaybankname() {
		return paybankname;
	}

	public void setPaybankname(String paybankname) {
		this.paybankname = paybankname;
	}

	public String getCmpyadd() {
		return cmpyadd;
	}

	public void setCmpyadd(String cmpyadd) {
		this.cmpyadd = cmpyadd;
	}

	



	
}



	
	
