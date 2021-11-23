package com.dci.master.employeemaster;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;

public class EmpMasterBean extends BasicResultBean{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8121134638192617201L;

	public Boolean isSuccess;
	
	public String message;
	public String emp_id;
	public String  probationfrom ;
	public String  contact_no; 
	public String  probation_to; 
	public String  emp_name ;
	public String  email ;
	public String  dt_of_birth ;
	public String  dt_of_join ;
	public String  dt_of_confirm; 
	public String  dt_of_leave; 
	public String id;
	public String text;

	
	public String  birth_identity ;
	public String  passport_no ;
	public String  company ;
	public String  place_issue ;
	public String designation;
	public String blood_group;
	public String  address ;
	public String department;
	public double  basic_pay ;
	public String mode_payment;
	public boolean  agent ;
	public boolean active;
	public String  password ;
	public String  port ;
	public String  agentName ;
	private String profileImg;
	private int bPay;
	private String moPay;
	
	private String ppf;
	private String ppt;

	public String getPpf() {
		return ppf;
	}
	public void setPpf(String ppf) {
		this.ppf = ppf;
	}
	public String getPpt() {
		return ppt;
	}
	public void setPpt(String ppt) {
		this.ppt = ppt;
	}
	public int getbPay() {
		return bPay;
	}
	public void setbPay(int bPay) {
		this.bPay = bPay;
	}
	public String getMoPay() {
		return moPay;
	}
	public void setMoPay(String moPay) {
		this.moPay = moPay;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	private String acNo;
	private String serviceLoc ;
	public String getServiceLoc() {
		return serviceLoc;
	}
	public void setServiceLoc(String serviceLoc) {
		this.serviceLoc = serviceLoc;
	}
	public List getLserviceLoc() {
		return lserviceLoc;
	}
	public void setLserviceLoc(List lserviceLoc) {
		this.lserviceLoc = lserviceLoc;
	}
	private List lserviceLoc ;

	private List mulPort;

	
	public List getMulPort() {
		return mulPort;
	}
	public void setMulPort(List mulPort) {
		this.mulPort = mulPort;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public boolean isEdit() {
		return isEdit;
	}
	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
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
	private boolean isEdit;
	private String confrmPwd;
	private String newpswd;

	
	
	
	

	
	
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
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
	
	@AuditLoggable(fieldName = "password", displayName = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
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
	
	@AuditLoggable(fieldName = "emp_id", displayName = "Employee")
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getProbationfrom() {
		return probationfrom;
	}
	public void setProbationfrom(String probationfrom) {
		this.probationfrom = probationfrom;
	}
	public String getProbation_to() {
		return probation_to;
	}
	public void setProbation_to(String probation_to) {
		this.probation_to = probation_to;
	}
	public String getDt_of_birth() {
		return dt_of_birth;
	}
	public void setDt_of_birth(String dt_of_birth) {
		this.dt_of_birth = dt_of_birth;
	}
	public String getDt_of_join() {
		return dt_of_join;
	}
	public void setDt_of_join(String dt_of_join) {
		this.dt_of_join = dt_of_join;
	}
	public String getDt_of_confirm() {
		return dt_of_confirm;
	}
	public void setDt_of_confirm(String dt_of_confirm) {
		this.dt_of_confirm = dt_of_confirm;
	}
	public String getDt_of_leave() {
		return dt_of_leave;
	}
	public void setDt_of_leave(String dt_of_leave) {
		this.dt_of_leave = dt_of_leave;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getBirth_identity() {
		return birth_identity;
	}
	public void setBirth_identity(String birth_identity) {
		this.birth_identity = birth_identity;
	}
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPlace_issue() {
		return place_issue;
	}
	public void setPlace_issue(String place_issue) {
		this.place_issue = place_issue;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getBasic_pay() {
		return basic_pay;
	}
	public void setBasic_pay(double basic_pay) {
		this.basic_pay = basic_pay;
	}
	public String getMode_payment() {
		return mode_payment;
	}
	public void setMode_payment(String mode_payment) {
		this.mode_payment = mode_payment;
	}
	public boolean isAgent() {
		return agent;
	}
	public void setAgent(boolean agent) {
		this.agent = agent;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}


