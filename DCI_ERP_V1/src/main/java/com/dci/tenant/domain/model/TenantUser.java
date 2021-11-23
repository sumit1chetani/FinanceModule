package com.dci.tenant.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dci.tenant.auditlog.AuditLoggable;

@Entity
@Table(name = "tenant_user")
public class TenantUser {

	@Id
	@Column(name = "tenant_user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tenantUserId;

	@Column(name = "user_id")
	private String userId;

	/*
	 * @Column(name = "user_name") private String userName;
	 */

	/*
	 * @Column(name = "password") private String password;
	 */

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "title")
	private String title;

	@Column(name = "work_email")
	private String workEmail;

	@Column(name = "user_type")
	private String userType;

	@Column(name = "dob")
	private String dob;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;

	@Column(name = "country")
	private String country;

	@Column(name = "state")
	private String state;

	@Column(name = "city")
	private String city;

	@Column(name = "work_mobilenumber")
	private String workmobileNumber;

	@Column(name = "captcha")
	private String captcha;

	@Column(name = "attachment_file")
	private String attachmentFile;

	@Column(name = "zip_code")
	private String zipCode;

	@Column(name = "otp")
	private String otp;

	@Column(name = "usr_id")
	private String usrId;

	@Column(name = "login_id")
	private String loginId;

	/*
	 * @Column(name="is_admin") private boolean isAdmin;
	 */

	/*
	 * public boolean isAdmin() { return isAdmin; }
	 * 
	 * public void setAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }
	 */
	@Column(name = "is_lock")
	private boolean islock;

	@Column(name = "login_status")
	private boolean loginStatus;

	@Column(name = "hire_date")
	private Date hireDate;

	@Column(name = "department")
	private String department;

	@Column(name = "job_code")
	private String jobCode;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "termination_date")
	private Date terminationDate;

	@Column(name = "supervisor_empid")
	private String supervisorEmpid;

	@Column(name = "employee_id")
	private String employeeId;
	
	@Column(name = "display_name")
	private String displayName;

	@Transient
	private String password;

	@Transient
	private boolean check;

	@Transient
	private String role;
	
	@Transient
	private boolean Verified ;


	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isVerified() {
		return Verified;
	}

	public void setVerified(boolean verified) {
		Verified = verified;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public boolean isIslock() {
		return islock;
	}

	public void setIslock(boolean islock) {
		this.islock = islock;
	}

	@Column(name = "idaas_role_id")
	private String idaasRoleId;

	@AuditLoggable(displayName = "Tenant User ID", fieldName = "tenant_user_id", isAuditLog = "true")
	public Integer getTenantUserId() {
		return tenantUserId;
	}

	public void setTenantUserId(Integer tenantUserId) {
		this.tenantUserId = tenantUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIdaasRoleId() {
		return idaasRoleId;
	}

	public void setIdaasRoleId(String idaasRoleId) {
		this.idaasRoleId = idaasRoleId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Column(name = "is_active")
	private boolean active;

	/*
	 * public String getUserName() { return userName; }
	 * 
	 * public void setUserName(String userName) { this.userName = userName; }
	 */
	/*
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */
	
	@AuditLoggable(displayName = "First Name", fieldName = "first_name", isAuditLog = "true")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@AuditLoggable(displayName = "Last Name", fieldName = "last_name", isAuditLog = "true")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@AuditLoggable(displayName = "Email", fieldName = "email", isAuditLog = "true")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@AuditLoggable(displayName = "Phone Number", fieldName = "phone_number", isAuditLog = "true")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWorkmobileNumber() {
		return workmobileNumber;
	}

	public void setWorkmobileNumber(String workmobileNumber) {
		this.workmobileNumber = workmobileNumber;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getAttachmentFile() {
		return attachmentFile;
	}

	public void setAttachmentFile(String attachmentFile) {
		this.attachmentFile = attachmentFile;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String getSupervisorEmpid() {
		return supervisorEmpid;
	}

	public void setSupervisorEmpid(String supervisorEmpid) {
		this.supervisorEmpid = supervisorEmpid;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Transient
	private String colName;

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}
}
