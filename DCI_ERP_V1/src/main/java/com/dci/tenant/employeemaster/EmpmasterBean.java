package com.dci.tenant.employeemaster;
import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;
@AuditLoggableType(tableName = "employee_master", formCode = "F0056")
public class EmpmasterBean {
	
	private String empId;
	private String empName;
	private String doj;
	private String dob;
	private String pswd;
	private String ppf;
	private String ppt;
	private String biMark;
	private String company;
	private String bldGrp;
	private String dsgn;
	private String dept;
	private int bPay;
	private String moPay;
	private String acNo;
	private String contactNo;
	private String emailId;
	private String passNo;
	private String placeIssue;
	private String contactAddr;
	private String isActive;
	private String accessRights;
	private String agent;
	private String confDate;
	private String leaveDate;
	private String id;
	private String text;
	private String profileImg;
	private boolean isEdit;
	private List mulPort;
	private String confrmPwd;
	private String newpswd;
	private String port;
	private String olpwd;
	public Boolean isSuccess;
	public String message;

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getOlpwd() {
		return olpwd;
	}

	public void setOlpwd(String olpwd) {
		this.olpwd = olpwd;
	}

	public String getServiceLoc() {
		return serviceLoc;
	}

	public void setServiceLoc(String serviceLoc) {
		this.serviceLoc = serviceLoc;
	}

	private String serviceLoc ;
	private List lserviceLoc ;

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
	public String getConfDate() {
		return confDate;
	}

	public void setConfDate(String confDate) {
		this.confDate = confDate;
	}
	@AuditLoggable(fieldName = "dt_of_leave", displayName = "Leave Date")
	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	@AuditLoggable(fieldName = "dt_of_birth", displayName = "Date of Birth")
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	//@AuditLoggable(fieldName = "password", displayName = "Password")
	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	@AuditLoggable(fieldName = "dt_probation_from", displayName = "PPF")
	public String getPpf() {
		return ppf;
	}

	public void setPpf(String ppf) {
		this.ppf = ppf;
	}
	@AuditLoggable(fieldName = "dt_probation_to", displayName = "PPT")
	public String getPpt() {
		return ppt;
	}

	public void setPpt(String ppt) {
		this.ppt = ppt;
	}
	@AuditLoggable(fieldName = "brth_identy", displayName = "Mark")
	public String getBiMark() {
		return biMark;
	}

	public void setBiMark(String biMark) {
		this.biMark = biMark;
	}
	@AuditLoggable(fieldName = "company_code", displayName = "Company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	@AuditLoggable(fieldName = "blood_group", displayName = "Blood Group")
	public String getBldGrp() {
		return bldGrp;
	}

	public void setBldGrp(String bldGrp) {
		this.bldGrp = bldGrp;
	}
	@AuditLoggable(fieldName = "designation", displayName = "Designation")
	public String getDsgn() {
		return dsgn;
	}

	public void setDsgn(String dsgn) {
		this.dsgn = dsgn;
	}
	@AuditLoggable(fieldName = "dept", displayName = "Department")
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	@AuditLoggable(fieldName = "payment_mode", displayName = "Mode Of  Payment")
	public String getMoPay() {
		return moPay;
	}

	public void setMoPay(String moPay) {
		this.moPay = moPay;
	}
@AuditLoggable(fieldName = "bankacct_no", displayName = "Bank Account Number")
	public String getAcNo() {
		return acNo;
	}

	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	@AuditLoggable(fieldName = "contact_no", displayName = "Contact No")
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@AuditLoggable(fieldName = "eamil_id", displayName = "Email Id")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@AuditLoggable(fieldName = "passport_no", displayName = "Pass No")
	public String getPassNo() {
		return passNo;
	}

	public void setPassNo(String passNo) {
		this.passNo = passNo;
	}
	@AuditLoggable(fieldName = "place_issue", displayName = "Place of Issue")
	public String getPlaceIssue() {
		return placeIssue;
	}

	public void setPlaceIssue(String placeIssue) {
		this.placeIssue = placeIssue;
	}
	@AuditLoggable(fieldName = "address", displayName = "Contact Address")
	public String getContactAddr() {
		return contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}
	@AuditLoggable(fieldName = "status", displayName  = "Active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@AuditLoggable(fieldName = "sa_right", displayName = "Agent")
	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	
	@AuditLoggable(fieldName = "EMP_ID", displayName = "Employee")
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@AuditLoggable(fieldName = "EMP_NAME", displayName = "empName")
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@AuditLoggable(fieldName = "dt_of_join", displayName = "Date Of Joining")

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	private String dsgnCode;
	private String dsgnName;
	private String companyId;
	private String companyLoc;
	private String deptCode;
	private String deptName;

	public String getDsgnCode() {
		return dsgnCode;
	}

	public void setDsgnCode(String dsgnCode) {
		this.dsgnCode = dsgnCode;
	}
	public String getDsgnName() {
		return dsgnName;
	}

	public void setDsgnName(String dsgnName) {
		this.dsgnName = dsgnName;
	}
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyLoc() {
		return companyLoc;
	}

	public void setCompanyLoc(String companyLoc) {
		this.companyLoc = companyLoc;
	}
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getbPay() {
		return bPay;
	}

	public void setbPay(int bPay) {
		this.bPay = bPay;
	}
	@AuditLoggable(fieldName = "access_status", displayName = "Access Rights")
	public String getAccessRights() {
		return accessRights;
	}

	public void setAccessRights(String accessRights) {
		this.accessRights = accessRights;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setIsEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	@AuditLoggable(fieldName = "mul_port", displayName = "Port")

	public List getMulPort() {
		return mulPort;
	}

	public void setMulPort(List mulPort) {
		this.mulPort = mulPort;
	}
	
	/**
	 * @return the profileImg
	 */
	public String getProfileImg() {
		return profileImg;
	}

	/**
	 * @param profileImg
	 *            the profileImg to set
	 */
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getConfrmPwd() {
		return confrmPwd;
	}

	public void setConfrmPwd(String confrmPwd) {
		this.confrmPwd = confrmPwd;
	}

	public String getNewpswd() {
		return newpswd;
	}

	public void setNewpswd(String newpswd) {
		this.newpswd = newpswd;
	}

	public List getLserviceLoc() {
		return lserviceLoc;
	}

	public void setLserviceLoc(List lserviceLoc) {
		this.lserviceLoc = lserviceLoc;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}