package com.dci.payroll.payroll.payslip;

import java.util.ArrayList;
import java.util.List;

/**
 * @author parkavi paragon
 *
 */
public class PaySlipDTO {

	private String empId;
	private String desgination;
	private String empName;
	private String company;
	private double totalEarnings;
	private double totalDeductions;
	private double lopAmount;
	private double lopDays;
	private double employeeLeaveAvailable;
	private double employeeLeaveTaken;
	private int departmentId;

	private int leaveAvailable;
	private int leaveTaken;

	private int amount;
	private int printamount;

	private int earnings;
	private int deductions;

	private String accountdebitCode;
	private String accountCode;
	private String month_year;
	private String dept;
	private String bankno;
	private String esicode;
	private String doj;
	private String epfno;
	private String uanno;

	private String paycomponentname;
	private String paybankname ;
	private String cmpyadd ;
	private String monthYear;

	public String getEpfno() {
		return epfno;
	}



	public void setEpfno(String epfno) {
		this.epfno = epfno;
	}



	public String getUanno() {
		return uanno;
	}



	public void setUanno(String uanno) {
		this.uanno = uanno;
	}

	private String designation;

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

	List<PaySlipBean> earningsList = new ArrayList<>();
	List<PaySlipBean> deductionsList = new ArrayList<>();

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the desgination
	 */
	public String getDesgination() {
		return desgination;
	}

	/**
	 * @param desgination
	 *            the desgination to set
	 */
	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 *            the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the totalEarnings
	 */
	public double getTotalEarnings() {
		return totalEarnings;
	}

	/**
	 * @param totalEarnings
	 *            the totalEarnings to set
	 */
	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	/**
	 * @return the totalDeductions
	 */
	public double getTotalDeductions() {
		return totalDeductions;
	}

	/**
	 * @param totalDeductions
	 *            the totalDeductions to set
	 */
	public void setTotalDeductions(double totalDeductions) {
		this.totalDeductions = totalDeductions;
	}

	/**
	 * @return the earningsList
	 */
	public List<PaySlipBean> getEarningsList() {
		return earningsList;
	}

	/**
	 * @param earningsList
	 *            the earningsList to set
	 */
	public void setEarningsList(List<PaySlipBean> earningsList) {
		this.earningsList = earningsList;
	}

	/**
	 * @return the deductionsList
	 */
	public List<PaySlipBean> getDeductionsList() {
		return deductionsList;
	}

	/**
	 * @param deductionsList
	 *            the deductionsList to set
	 */
	public void setDeductionsList(List<PaySlipBean> deductionsList) {
		this.deductionsList = deductionsList;
	}

	public double getEmployeeLeaveTaken() {
		return employeeLeaveTaken;
	}

	public void setEmployeeLeaveTaken(double employeeLeaveTaken) {
		this.employeeLeaveTaken = employeeLeaveTaken;
	}

	public double getEmployeeLeaveAvailable() {
		return employeeLeaveAvailable;
	}

	public void setEmployeeLeaveAvailable(double employeeLeaveAvailable) {
		this.employeeLeaveAvailable = employeeLeaveAvailable;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
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



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
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



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
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



	public String getMonthYear() {
		return monthYear;
	}



	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}



	

	
}
