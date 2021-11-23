package com.dci.master.userAdminMaster;

//
public class UserAdminMasterRulesBean {
	private boolean overTime = true;
	private boolean esiApp = true;
	private boolean lateApp = true;

	private boolean pfApp = true;
	private boolean earlyExit = true;
	private boolean leaveOption = true;
	private double telephoneLimit;
	private double medicalLimit;
	private Integer noticePeriodRule;
	private String empId;

	public boolean isOverTime() {
		return overTime;
	}

	public void setOverTime(boolean overTime) {
		this.overTime = overTime;
	}

	public boolean getEsiApp() {
		return esiApp;
	}

	public void setEsiApp(boolean esiApp) {
		this.esiApp = esiApp;
	}

	public boolean isLateApp() {
		return lateApp;
	}

	public void setLateApp(boolean lateApp) {
		this.lateApp = lateApp;
	}

	public boolean isPfApp() {
		return pfApp;
	}

	public void setPfApp(boolean pfApp) {
		this.pfApp = pfApp;
	}

	public boolean isEarlyExit() {
		return earlyExit;
	}

	public void setEarlyExit(boolean earlyExit) {
		this.earlyExit = earlyExit;
	}

	public boolean isLeaveOption() {
		return leaveOption;
	}

	public void setLeaveOption(boolean leaveOption) {
		this.leaveOption = leaveOption;
	}

	public double getTelephoneLimit() {
		return telephoneLimit;
	}

	public void setTelephoneLimit(double telephoneLimit) {
		this.telephoneLimit = telephoneLimit;
	}

	public double getMedicalLimit() {
		return medicalLimit;
	}

	public void setMedicalLimit(double medicalLimit) {
		this.medicalLimit = medicalLimit;
	}

	public Integer getNoticePeriodRule() {
		return noticePeriodRule;
	}

	public void setNoticePeriodRule(Integer noticePeriodRule) {
		this.noticePeriodRule = noticePeriodRule;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
