package com.dci.finance.leaveApproval;

public class LeaveAppCancelBean {
	private int leaveRequestId;
	private String action;
	private int status;
	private String comments;
	private String empId;
	private String firstName;
	private String leaveType;
	private String dateFrom;
	private String dateTo;
	private String nofDays;
	private String reason;
	private String appliedOn;
	private String halfFrom;
	private String halfTo;
	private String mdUrl;
	private Boolean isHoliday;
	private String descrip;
	private int approvalType;
	private String payType;
	private int alternativeStatus;
	
	private int finalStatus;
	
	
	private Integer stepOrder;
	private String stepName;
	private String approveType;
	private String stepRemarks;
	private String stepStatus;
	
	
	
	public Integer getStepOrder() {
		return stepOrder;
	}

	public void setStepOrder(Integer stepOrder) {
		this.stepOrder = stepOrder;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}

	public String getStepRemarks() {
		return stepRemarks;
	}

	public void setStepRemarks(String stepRemarks) {
		this.stepRemarks = stepRemarks;
	}

	public String getStepStatus() {
		return stepStatus;
	}

	public void setStepStatus(String stepStatus) {
		this.stepStatus = stepStatus;
	}

	public int getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(int finalStatus) {
		this.finalStatus = finalStatus;
	}

	public int getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(int approvalType) {
		this.approvalType = approvalType;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getAlternativeStatus() {
		return alternativeStatus;
	}

	public void setAlternativeStatus(int alternativeStatus) {
		this.alternativeStatus = alternativeStatus;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public int getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getNofDays() {
		return nofDays;
	}

	public void setNofDays(String nofDays) {
		this.nofDays = nofDays;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getHalfFrom() {
		return halfFrom;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public void setHalfFrom(String halfFrom) {
		this.halfFrom = halfFrom;
	}

	public String getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(String appliedOn) {
		this.appliedOn = appliedOn;
	}

	public String getHalfTo() {
		return halfTo;
	}

	public void setHalfTo(String halfTo) {
		this.halfTo = halfTo;
	}

	public String getMdUrl() {
		return mdUrl;
	}

	public void setMdUrl(String mdUrl) {
		this.mdUrl = mdUrl;
	}

	public Boolean getIsHoliday() {
		return isHoliday;
	}

	public void setIsHoliday(Boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

}
