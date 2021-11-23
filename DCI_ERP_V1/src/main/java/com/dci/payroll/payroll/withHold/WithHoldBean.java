package com.dci.payroll.payroll.withHold;

public class WithHoldBean {

	private String id;
	private String text;
	private String withholdDate;
	private String employee;
	private String employeeName;

	private String withholdFrom;
	private String withholdTo;
	private String monthYear;
	private String withHoldCode;
	private boolean check;
	private String fromMonth;
	private String tillMonth;
	private String tillYear;
	private String fromYear;

	public String status;

	public String getFromMonth() {
		return fromMonth;
	}

	public void setFromMonth(String fromMonth) {
		this.fromMonth = fromMonth;
	}

	public String getTillMonth() {
		return tillMonth;
	}

	public void setTillMonth(String tillMonth) {
		this.tillMonth = tillMonth;
	}

	public String getTillYear() {
		return tillYear;
	}

	public void setTillYear(String tillYear) {
		this.tillYear = tillYear;
	}

	public String getFromYear() {
		return fromYear;
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getWithHoldCode() {
		return withHoldCode;
	}

	public void setWithHoldCode(String withHoldCode) {
		this.withHoldCode = withHoldCode;
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

	public String getWithholdDate() {
		return withholdDate;
	}

	public void setWithholdDate(String withholdDate) {
		this.withholdDate = withholdDate;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getWithholdFrom() {
		return withholdFrom;
	}

	public void setWithholdFrom(String withholdFrom) {
		this.withholdFrom = withholdFrom;
	}

	public String getWithholdTo() {
		return withholdTo;
	}

	public void setWithholdTo(String withholdTo) {
		this.withholdTo = withholdTo;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

}
