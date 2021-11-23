package com.dci.finance.leaverequest;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.SelectivityBean;

public class LeaveRequestBean {

	private String loginEmpId;
	private String leaveType;
	private String fromDate;
	private String toDate;
	private String noOfDays;
	private String noOfDaysCL;
	private String noOfDaysCPL;
	private String noOfDaysML;
	private String noOfDaysEL;
	private String noOfDaysHPL;

	private String leaveReason;
	private int action;
	private String leaveAddress;
	private int leaveRequestId;
	private int leaverequesturlId;
	private String leavePhone;
	private String leaveMobile;
	private String appliedOn;
	private String halfFrom;
	private String addressDuringLeave;
	private String halfTo;
	private String mdUrl;
	private String year;
	private String leaveRadio;
	private String holidayRadio;
	private boolean isHoliday;
	private String isEdit;
	private String empId;
	private String empName;
	private String company;
	private String branch;
	private String department;
	private String grade;
	private int gradeId;
	private String companyId;
	private List<SelectivityBean> alternativeList;
	private String alternativeEmp;
	private String alternativeEmployeeName;
	private String approvalType;
	private int alternateEmpStatus;
	private int finalEmpStatus;
	private String dutyAgreed;
	private int notifyStatus;
	private boolean cancelRequest;
	private boolean wholeLeave;
	private String cancelFromDate;
	private String cancelToDate;
	private int cancelDays;
	private int clLeaveDays;
	private int cplLeaveDays;
	private String clFromDate;
	private String clToDate;
	private String cplFromDate;
	private String cplToDate;
	private double plLeaveDays;
	private double leaveDays;
	private int departmentId;
	private boolean leaveDeduct;
	private List<String> supportDoc = new ArrayList<String>();
	private String payType;
	private String finalSupportDoc;
	private String isMl;
	private String Created_by;
	private String Created_on;
	private String Modified_by;
	private String approvedBy;
	
	private String status;
	
	private String uploadRef;
	
	private List<LeaveRequestBean> fileuploadlist;
	private String Modified_on;
	
	
	List<LeaveRequestBean> approvalList = new ArrayList<>();

	
	private String stepName;
	private String employeeName;
	private String adminStatus;
	private String approvedDate;
	private String comments;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}
	public String getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public List<LeaveRequestBean> getApprovalList() {
		return approvalList;
	}
	public void setApprovalList(List<LeaveRequestBean> approvalList) {
		this.approvalList = approvalList;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public List<LeaveRequestBean> getFileuploadlist() {
		return fileuploadlist;
	}
	public void setFileuploadlist(List<LeaveRequestBean> fileuploadlist) {
		this.fileuploadlist = fileuploadlist;
	}
	public String getUploadRef() {
		return uploadRef;
	}
	public void setUploadRef(String uploadRef) {
		this.uploadRef = uploadRef;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoginEmpId() {
		return loginEmpId;
	}
	public void setLoginEmpId(String loginEmpId) {
		this.loginEmpId = loginEmpId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getNoOfDaysCL() {
		return noOfDaysCL;
	}
	public void setNoOfDaysCL(String noOfDaysCL) {
		this.noOfDaysCL = noOfDaysCL;
	}
	public String getNoOfDaysCPL() {
		return noOfDaysCPL;
	}
	public void setNoOfDaysCPL(String noOfDaysCPL) {
		this.noOfDaysCPL = noOfDaysCPL;
	}
	public String getNoOfDaysML() {
		return noOfDaysML;
	}
	public void setNoOfDaysML(String noOfDaysML) {
		this.noOfDaysML = noOfDaysML;
	}
	public String getNoOfDaysEL() {
		return noOfDaysEL;
	}
	public void setNoOfDaysEL(String noOfDaysEL) {
		this.noOfDaysEL = noOfDaysEL;
	}
	public String getNoOfDaysHPL() {
		return noOfDaysHPL;
	}
	public void setNoOfDaysHPL(String noOfDaysHPL) {
		this.noOfDaysHPL = noOfDaysHPL;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public String getLeaveAddress() {
		return leaveAddress;
	}
	public void setLeaveAddress(String leaveAddress) {
		this.leaveAddress = leaveAddress;
	}
	public int getLeaveRequestId() {
		return leaveRequestId;
	}
	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}
	public int getLeaverequesturlId() {
		return leaverequesturlId;
	}
	public void setLeaverequesturlId(int leaverequesturlId) {
		this.leaverequesturlId = leaverequesturlId;
	}
	public String getLeavePhone() {
		return leavePhone;
	}
	public void setLeavePhone(String leavePhone) {
		this.leavePhone = leavePhone;
	}
	public String getLeaveMobile() {
		return leaveMobile;
	}
	public void setLeaveMobile(String leaveMobile) {
		this.leaveMobile = leaveMobile;
	}
	public String getAppliedOn() {
		return appliedOn;
	}
	public void setAppliedOn(String appliedOn) {
		this.appliedOn = appliedOn;
	}
	public String getHalfFrom() {
		return halfFrom;
	}
	public void setHalfFrom(String halfFrom) {
		this.halfFrom = halfFrom;
	}
	public String getAddressDuringLeave() {
		return addressDuringLeave;
	}
	public void setAddressDuringLeave(String addressDuringLeave) {
		this.addressDuringLeave = addressDuringLeave;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getLeaveRadio() {
		return leaveRadio;
	}
	public void setLeaveRadio(String leaveRadio) {
		this.leaveRadio = leaveRadio;
	}
	public String getHolidayRadio() {
		return holidayRadio;
	}
	public void setHolidayRadio(String holidayRadio) {
		this.holidayRadio = holidayRadio;
	}
	public boolean getisHoliday() {
		return isHoliday;
	}

	public void setisHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	public String getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public List<SelectivityBean> getAlternativeList() {
		return alternativeList;
	}
	public void setAlternativeList(List<SelectivityBean> alternativeList) {
		this.alternativeList = alternativeList;
	}
	public String getAlternativeEmp() {
		return alternativeEmp;
	}
	public void setAlternativeEmp(String alternativeEmp) {
		this.alternativeEmp = alternativeEmp;
	}
	public String getAlternativeEmployeeName() {
		return alternativeEmployeeName;
	}
	public void setAlternativeEmployeeName(String alternativeEmployeeName) {
		this.alternativeEmployeeName = alternativeEmployeeName;
	}
	public String getApprovalType() {
		return approvalType;
	}
	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}
	public int getAlternateEmpStatus() {
		return alternateEmpStatus;
	}
	public void setAlternateEmpStatus(int alternateEmpStatus) {
		this.alternateEmpStatus = alternateEmpStatus;
	}
	public int getFinalEmpStatus() {
		return finalEmpStatus;
	}
	public void setFinalEmpStatus(int finalEmpStatus) {
		this.finalEmpStatus = finalEmpStatus;
	}
	public String getDutyAgreed() {
		return dutyAgreed;
	}
	public void setDutyAgreed(String dutyAgreed) {
		this.dutyAgreed = dutyAgreed;
	}
	public int getNotifyStatus() {
		return notifyStatus;
	}
	public void setNotifyStatus(int notifyStatus) {
		this.notifyStatus = notifyStatus;
	}
	public boolean isCancelRequest() {
		return cancelRequest;
	}
	public void setCancelRequest(boolean cancelRequest) {
		this.cancelRequest = cancelRequest;
	}
	public boolean isWholeLeave() {
		return wholeLeave;
	}
	public void setWholeLeave(boolean wholeLeave) {
		this.wholeLeave = wholeLeave;
	}
	public String getCancelFromDate() {
		return cancelFromDate;
	}
	public void setCancelFromDate(String cancelFromDate) {
		this.cancelFromDate = cancelFromDate;
	}
	public String getCancelToDate() {
		return cancelToDate;
	}
	public void setCancelToDate(String cancelToDate) {
		this.cancelToDate = cancelToDate;
	}
	public int getCancelDays() {
		return cancelDays;
	}
	public void setCancelDays(int cancelDays) {
		this.cancelDays = cancelDays;
	}
	public int getClLeaveDays() {
		return clLeaveDays;
	}
	public void setClLeaveDays(int clLeaveDays) {
		this.clLeaveDays = clLeaveDays;
	}
	public int getCplLeaveDays() {
		return cplLeaveDays;
	}
	public void setCplLeaveDays(int cplLeaveDays) {
		this.cplLeaveDays = cplLeaveDays;
	}
	public String getClFromDate() {
		return clFromDate;
	}
	public void setClFromDate(String clFromDate) {
		this.clFromDate = clFromDate;
	}
	public String getClToDate() {
		return clToDate;
	}
	public void setClToDate(String clToDate) {
		this.clToDate = clToDate;
	}
	public String getCplFromDate() {
		return cplFromDate;
	}
	public void setCplFromDate(String cplFromDate) {
		this.cplFromDate = cplFromDate;
	}
	public String getCplToDate() {
		return cplToDate;
	}
	public void setCplToDate(String cplToDate) {
		this.cplToDate = cplToDate;
	}
	public double getPlLeaveDays() {
		return plLeaveDays;
	}
	public void setPlLeaveDays(double plLeaveDays) {
		this.plLeaveDays = plLeaveDays;
	}
	public double getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(double leaveDays) {
		this.leaveDays = leaveDays;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public boolean isLeaveDeduct() {
		return leaveDeduct;
	}
	public void setLeaveDeduct(boolean leaveDeduct) {
		this.leaveDeduct = leaveDeduct;
	}
	public List<String> getSupportDoc() {
		return supportDoc;
	}
	public void setSupportDoc(List<String> supportDoc) {
		this.supportDoc = supportDoc;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getFinalSupportDoc() {
		return finalSupportDoc;
	}
	public void setFinalSupportDoc(String finalSupportDoc) {
		this.finalSupportDoc = finalSupportDoc;
	}
	public String getIsMl() {
		return isMl;
	}
	public void setIsMl(String isMl) {
		this.isMl = isMl;
	}
	public String getCreated_by() {
		return Created_by;
	}
	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}
	public String getCreated_on() {
		return Created_on;
	}
	public void setCreated_on(String created_on) {
		Created_on = created_on;
	}
	public String getModified_by() {
		return Modified_by;
	}
	public void setModified_by(String modified_by) {
		Modified_by = modified_by;
	}
	public String getModified_on() {
		return Modified_on;
	}
	public void setModified_on(String modified_on) {
		Modified_on = modified_on;
	}
	
	
	

}
