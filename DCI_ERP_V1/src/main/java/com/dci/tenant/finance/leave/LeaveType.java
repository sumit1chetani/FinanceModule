package com.dci.tenant.finance.leave;

public class LeaveType {

	private String shortName;
	private String leaveTypeName;
	private boolean canCarryForward;
	private String carryForwardLimit;
	private boolean encashable;
	private boolean applicableUnderProbation;
	private int gender;
	private boolean status;
	private String maxDaysUnderProbation;
	private boolean medical;
	private String maxDaysMedicalLeave;
	private boolean maternityLeave;
	private String maxDaysMaternityLeave;
	private int year;	
	private String empId;

	private int leave_request_id;

	private String branch;




	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getLeave_request_id() {
		return leave_request_id;
	}

	public void setLeave_request_id(int leave_request_id) {
		this.leave_request_id = leave_request_id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public boolean getCanCarryForward() {
		return canCarryForward;
	}

	public void setCanCarryForward(boolean canCarryForward) {
		this.canCarryForward = canCarryForward;
	}

	public boolean getEncashable() {
		return encashable;
	}

	public void setEncashable(boolean encashable) {
		this.encashable = encashable;
	}

	public boolean getApplicableUnderProbation() {
		return applicableUnderProbation;
	}

	public void setApplicableUnderProbation(boolean applicableUnderProbation) {
		this.applicableUnderProbation = applicableUnderProbation;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getMedical() {
		return medical;
	}

	public void setMedical(boolean medical) {
		this.medical = medical;
	}

	public boolean getMaternityLeave() {
		return maternityLeave;
	}

	public void setMaternityLeave(boolean maternityLeave) {
		this.maternityLeave = maternityLeave;
	}

	public String getCarryForwardLimit() {
		return carryForwardLimit;
	}

	public void setCarryForwardLimit(String carryForwardLimit) {
		this.carryForwardLimit = carryForwardLimit;
	}

	public String getMaxDaysUnderProbation() {
		return maxDaysUnderProbation;
	}

	public void setMaxDaysUnderProbation(String maxDaysUnderProbation) {
		this.maxDaysUnderProbation = maxDaysUnderProbation;
	}

	public String getMaxDaysMedicalLeave() {
		return maxDaysMedicalLeave;
	}

	public void setMaxDaysMedicalLeave(String maxDaysMedicalLeave) {
		this.maxDaysMedicalLeave = maxDaysMedicalLeave;
	}

	public String getMaxDaysMaternityLeave() {
		return maxDaysMaternityLeave;
	}

	public void setMaxDaysMaternityLeave(String maxDaysMaternityLeave) {
		this.maxDaysMaternityLeave = maxDaysMaternityLeave;
	}

}
