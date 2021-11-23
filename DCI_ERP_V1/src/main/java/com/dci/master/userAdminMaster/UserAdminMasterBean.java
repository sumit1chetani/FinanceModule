package com.dci.master.userAdminMaster;

import java.util.ArrayList;
import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "user_master", formCode = "F6128")

public class UserAdminMasterBean {

	private String donorCode;
	private String employeeNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String empId;
	private String pwd;
	private String gender;
	private String dob;
	private String empUserId;
	private String emailId;
	private String mobileNo;
	private String doj;
	private String esic;
	private Double fixedGross;
	private String category;
	private String secondLevel;
	private String isActive = "N";
	private String status;
	private String customerName;
	private String vendor;
	private String[] portList;
	
	
	private List<UserAdminMasterBean> port;
	private String portCodes;
	
	
	private List<UserAdminMasterBean> accessCat;
	private String accesscodes;
	
	
	
	
	
	public List<UserAdminMasterBean> getAccessCat() {
		return accessCat;
	}

	public void setAccessCat(List<UserAdminMasterBean> accessCat) {
		this.accessCat = accessCat;
	}

	public String getAccesscodes() {
		return accesscodes;
	}

	public void setAccesscodes(String accesscodes) {
		this.accesscodes = accesscodes;
	}

	private String country;
	
	
	private String genderName;
	
	
	private String active;
	private boolean deptContact;


	private String agentName;


	public boolean isDeptContact() {
		return deptContact;
	}

	public void setDeptContact(boolean deptContact) {
		this.deptContact = deptContact;
	}

	private String countryName;
	private String vendorShow;
	
	
	private String createdBy;
	private String modifiedBy;
	private String createdDate;
	private String modifiedDate;

	
	private String userlocation;
	
	
	private String filepath;

	private String filename;
	private List<UserAdminMasterBean> files1;

	
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	public List<UserAdminMasterBean> getFiles1() {
		return files1;
	}

	public void setFiles1(List<UserAdminMasterBean> files1) {
		this.files1 = files1;
	}

	public String getUserlocation() {
		return userlocation;
	}

	public void setUserlocation(String userlocation) {
		this.userlocation = userlocation;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@AuditLoggable(fieldName = "PortList", displayName = "Port List")
	public String[] getPortList() {
		return portList;
	}

	public void setPortList(String[] portList) {
		this.portList = portList;
	}

	public List<UserAdminMasterBean> getPort() {
		return port;
	}

	public void setPort(List<UserAdminMasterBean> port) {
		this.port = port;
	}

	@AuditLoggable(fieldName = "portCodes", displayName = "Port Code")
	public String getPortCodes() {
		return portCodes;
	}

	public void setPortCodes(String portCodes) {
		this.portCodes = portCodes;
	}

	@AuditLoggable(fieldName = "customerName", displayName = "Customer Name")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@AuditLoggable(fieldName = "vendor", displayName = "Vendor")
	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	private String isEmailExempted;
	private String status1;
	private boolean principal;
	private boolean ms;
	private int employeeType;
	private String accessCardNo;
	private String uploadPhoto;
	private String companyCode;
	private String companyName;
	private String branchId;
	private String branch;
	private String branchName;
	private String departmentId;
	private String departmentCode;
	private String designation;
	private String designationName;
	private int division;
	private String divisionName;
	private Integer grade;
	private String gradeName;
	private String reportToBranch;
	private String reportToBranchName;
	private String reportDeptId;
	private String reportToDept;
	private String reportDesigId;
	private String reportToDesig;
	private String reportMangrId;
	private String reportManagerName;
	private Integer typeOfEmp;
	private String empTypeName;
	private String relieveDate;
	private String epfNo;
	private boolean isEdit;
	private int branchDepartmentId;
	private int isPrimary;
	private String id;
	private String text;
	private String insuranceNo;
	private String cusName;
	private String table;
	private String tableName;
	private String formCode;
	private String departmentName;
	private List<UserAdminMasterPhoneNoDetailBean> presentAddressMultiple;
	private Integer customerId;
	private List<UserAdminDuplicateBean> employeeDuplicateList;
	private String uan;

	public String getUan() {
		return uan;
	}

	public void setUan(String uan) {
		this.uan = uan;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	private int employeeLeaveType;

	private String employmentDate;

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
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

	/***************************** Profile *********************************/

	public String getDonorCode() {
		return donorCode;
	}

	public int getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(int isPrimary) {
		this.isPrimary = isPrimary;
	}

	public int getBranchDepartmentId() {
		return branchDepartmentId;
	}

	public void setBranchDepartmentId(int branchDepartmentId) {
		this.branchDepartmentId = branchDepartmentId;
	}


	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	@AuditLoggable(fieldName = "employeeNo", displayName = "Employee No")
	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public void setDonorCode(String donorCode) {
		this.donorCode = donorCode;
	}

	@AuditLoggable(fieldName = "companyName", displayName = "Company Name")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@AuditLoggable(fieldName = "branchName", displayName = "Branch Name")
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@AuditLoggable(fieldName = "firstName", displayName = "First Name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@AuditLoggable(fieldName = "middleName", displayName = "Middle Name")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@AuditLoggable(fieldName = "lastName", displayName = "Last Name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@AuditLoggable(fieldName = "emp_id", displayName = "employeeId")

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@AuditLoggable(fieldName = "password", displayName = "pwd")

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@AuditLoggable(fieldName = "gender", displayName = "gender")

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@AuditLoggable(fieldName = "dt_of_birth", displayName = "dob")

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	@AuditLoggable(fieldName = "email", displayName = "emailId")

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Double getFixedGross() {
		return fixedGross;
	}

	public void setFixedGross(Double fixedGross) {
		this.fixedGross = fixedGross;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@AuditLoggable(fieldName = "dt_of_join", displayName = "doj")

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getEsic() {
		return esic;
	}

	public void setEsic(String esic) {
		this.esic = esic;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getUploadPhoto() {
		return uploadPhoto;
	}

	public void setUploadPhoto(String uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	@AuditLoggable(fieldName = "branch", displayName = "branch")

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@AuditLoggable(fieldName = "dept", displayName = "departmentCode")

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@AuditLoggable(fieldName = "designation", displayName = "designationName")


	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	

	public String getReportToBranch() {
		return reportToBranch;
	}

	public void setReportToBranch(String reportToBranch) {
		this.reportToBranch = reportToBranch;
	}

	public String getReportToDept() {
		return reportToDept;
	}

	public void setReportToDept(String reportToDept) {
		this.reportToDept = reportToDept;
	}

	public String getReportToDesig() {
		return reportToDesig;
	}

	public void setReportToDesig(String reportToDesig) {
		this.reportToDesig = reportToDesig;
	}

	public String getReportMangrId() {
		return reportMangrId;
	}

	public void setReportMangrId(String reportMangrId) {
		this.reportMangrId = reportMangrId;
	}

	public String getReportManagerName() {
		return reportManagerName;
	}

	public void setReportManagerName(String reportManagerName) {
		this.reportManagerName = reportManagerName;
	}



	public String getRelieveDate() {
		return relieveDate;
	}

	public void setRelieveDate(String relieveDate) {
		this.relieveDate = relieveDate;
	}

	public String getEpfNo() {
		return epfNo;
	}

	public void setEpfNo(String epfNo) {
		this.epfNo = epfNo;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getReportToBranchName() {
		return reportToBranchName;
	}

	public void setReportToBranchName(String reportToBranchName) {
		this.reportToBranchName = reportToBranchName;
	}



	public String getEmpTypeName() {
		return empTypeName;
	}

	public void setEmpTypeName(String empTypeName) {
		this.empTypeName = empTypeName;
	}

	public String getAccessCardNo() {
		return accessCardNo;
	}

	public void setAccessCardNo(String accessCardNo) {
		this.accessCardNo = accessCardNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public boolean isMs() {
		return ms;
	}

	public void setMs(boolean ms) {
		this.ms = ms;
	}

	/***************************** End of Profile *********************************/

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSecondLevel() {
		return secondLevel;
	}

	public void setSecondLevel(String secondLevel) {
		this.secondLevel = secondLevel;
	}

	/****************************** Personal Info ***********************************/

	private boolean marriedStatus = true;
	private String guardianName;
	private String motherName;
	private String race;
	private String bloodGrp;
	private String caste;
	private String religion;
	private String motherTongue;
	private String nationality;
	private String panNo;
	private String gratuityNominee;
	private String nomineeRelation;
	private String modeConveyence;
	private String emgContactNo;
	private String emgContactName;
	private int noticePeriod;
	private String remarks;
	private String hobbies;
	private String confirmDate;
	private String resignationDate;
	private String languages;
	private int confirmationPeriod;
	private String husbWifeName;
	private String personalStatus = "N";
	private String marriageDate;
	private boolean marritalStatus;
	private String guardiansName;
	private String aadharno;

	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getGuardiansName() {
		return guardiansName;
	}

	public void setGuardiansName(String guardiansName) {
		this.guardiansName = guardiansName;
	}

	public boolean isMarriedStatus() {
		return marriedStatus;
	}

	public void setMarriedStatus(boolean marriedStatus) {
		this.marriedStatus = marriedStatus;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getBloodGrp() {
		return bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getGratuityNominee() {
		return gratuityNominee;
	}

	public void setGratuityNominee(String gratuityNominee) {
		this.gratuityNominee = gratuityNominee;
	}

	public String getNomineeRelation() {
		return nomineeRelation;
	}

	public void setNomineeRelation(String nomineeRelation) {
		this.nomineeRelation = nomineeRelation;
	}

	public String getModeConveyence() {
		return modeConveyence;
	}

	public void setModeConveyence(String modeConveyence) {
		this.modeConveyence = modeConveyence;
	}

	public String getEmgContactNo() {
		return emgContactNo;
	}

	public void setEmgContactNo(String emgContactNo) {
		this.emgContactNo = emgContactNo;
	}

	public String getEmgContactName() {
		return emgContactName;
	}

	public void setEmgContactName(String emgContactName) {
		this.emgContactName = emgContactName;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getResignationDate() {
		return resignationDate;
	}

	public void setResignationDate(String resignationDate) {
		this.resignationDate = resignationDate;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public int getConfirmationPeriod() {
		return confirmationPeriod;
	}

	public void setConfirmationPeriod(int confirmationPeriod) {
		this.confirmationPeriod = confirmationPeriod;
	}

	public String getHusbWifeName() {
		return husbWifeName;
	}

	public void setHusbWifeName(String husbWifeName) {
		this.husbWifeName = husbWifeName;
	}

	public String getPersonalStatus() {
		return personalStatus;
	}

	public void setPersonalStatus(String personalStatus) {
		this.personalStatus = personalStatus;
	}

	public String getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(String marriageDate) {
		this.marriageDate = marriageDate;
	}

	/********************************* End Of Personal Info *************************/

	/****************************** Address *******************************/
	private String permAddress;
	private String permPlace;
	private String permDistrict;
	private String permPin;
	private String permPhone;
	private String permMobile;
	private String permState;
	private String isActiveAddress = "N";

	private String presentAddress;
	private String presentPlace;
	private String presentDistrict;
	private String presentPin;
	private String presentPhone;
	private String presentMobile;
	private String isActiveOldAddress = "N";

	public String getPermState() {
		return permState;
	}

	public void setPermState(String permState) {
		this.permState = permState;
	}

	public String getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}

	public String getPermPlace() {
		return permPlace;
	}

	public void setPermPlace(String permPlace) {
		this.permPlace = permPlace;
	}

	public String getPermDistrict() {
		return permDistrict;
	}

	public void setPermDistrict(String permDistrict) {
		this.permDistrict = permDistrict;
	}

	public String getPermPin() {
		return permPin;
	}

	public void setPermPin(String permPin) {
		this.permPin = permPin;
	}

	public String getPermPhone() {
		return permPhone;
	}

	public void setPermPhone(String permPhone) {
		this.permPhone = permPhone;
	}

	public String getPermMobile() {
		return permMobile;
	}

	public void setPermMobile(String permMobile) {
		this.permMobile = permMobile;
	}

	public String getIsActiveAddress() {
		return isActiveAddress;
	}

	public void setIsActiveAddress(String isActiveAddress) {
		this.isActiveAddress = isActiveAddress;
	}

	/******************** end of Address **********************/

	/**************** Rules ********************/
	private boolean overTime = true;
	private boolean esiApp = true;
	private boolean lateApp = true;

	private boolean pfApp = true;
	private boolean earlyExit = true;
	private boolean leaveOption = true;
	private double telephoneLimit;
	private double medicalLimit;
	private int noticePeriodRule;

	public int getNoticePeriodRule() {
		return noticePeriodRule;
	}

	public void setNoticePeriodRule(int noticePeriodRule) {
		this.noticePeriodRule = noticePeriodRule;
	}

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

	/*************** End of Rules ***************/

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

	/****************** Nomination ****************/

	private String nominateName;
	private String nominateOccupation;
	private String nominateRelationship;
	private String nominateEmail;
	private String nominatePhone;
	private String nominateMobile;
	private String nomdateOfBirth;
	private String nomineAddress;
	private String nominatePlace;
	private String nominatePincode;
	private String nominateGender;
	private String uploadPhotoNominee;

	public String getUploadPhotoNominee() {
		return uploadPhotoNominee;
	}

	public void setUploadPhotoNominee(String uploadPhotoNominee) {
		this.uploadPhotoNominee = uploadPhotoNominee;
	}

	public String getNominateGender() {
		return nominateGender;
	}

	public void setNominateGender(String nominateGender) {
		this.nominateGender = nominateGender;
	}

	public String getNominateName() {
		return nominateName;
	}

	public void setNominateName(String nominateName) {
		this.nominateName = nominateName;
	}

	public String getNominateOccupation() {
		return nominateOccupation;
	}

	public void setNominateOccupation(String nominateOccupation) {
		this.nominateOccupation = nominateOccupation;
	}

	public String getNominateRelationship() {
		return nominateRelationship;
	}

	public void setNominateRelationship(String nominateRelationship) {
		this.nominateRelationship = nominateRelationship;
	}

	public String getNominateEmail() {
		return nominateEmail;
	}

	public void setNominateEmail(String nominateEmail) {
		this.nominateEmail = nominateEmail;
	}

	public String getNominatePhone() {
		return nominatePhone;
	}

	public void setNominatePhone(String nominatePhone) {
		this.nominatePhone = nominatePhone;
	}

	public String getNominateMobile() {
		return nominateMobile;
	}

	public void setNominateMobile(String nominateMobile) {
		this.nominateMobile = nominateMobile;
	}

	public String getNomdateOfBirth() {
		return nomdateOfBirth;
	}

	public void setNomdateOfBirth(String nomdateOfBirth) {
		this.nomdateOfBirth = nomdateOfBirth;
	}

	public String getNomineAddress() {
		return nomineAddress;
	}

	public void setNomineAddress(String nomineAddress) {
		this.nomineAddress = nomineAddress;
	}

	public String getNominatePlace() {
		return nominatePlace;
	}

	public void setNominatePlace(String nominatePlace) {
		this.nominatePlace = nominatePlace;
	}

	public String getNominatePincode() {
		return nominatePincode;
	}

	public void setNominatePincode(String nominatePincode) {
		this.nominatePincode = nominatePincode;
	}

	/************* End of Nomination ***************/

	/******************* Physical ********************/

	private String isActiveSight = "N";
	private String isActiveDumb = "N";
	private String isActiveHearing = "N";
	private String isActiveHand = "N";
	private String isActiveFeet = "N";
	private String isActiveWithGlass = "N";

	private double height;
	private double weight;
	private double rightSidePower;
	private double leftSidePower;
	private String otherDisablity;

	public String getOtherDisablity() {
		return otherDisablity;
	}

	public void setOtherDisablity(String otherDisablity) {
		this.otherDisablity = otherDisablity;
	}

	public String getIsActiveSight() {
		return isActiveSight;
	}

	public void setIsActiveSight(String isActiveSight) {
		this.isActiveSight = isActiveSight;
	}

	public String getIsActiveDumb() {
		return isActiveDumb;
	}

	public void setIsActiveDumb(String isActiveDumb) {
		this.isActiveDumb = isActiveDumb;
	}

	public String getIsActiveHearing() {
		return isActiveHearing;
	}

	public void setIsActiveHearing(String isActiveHearing) {
		this.isActiveHearing = isActiveHearing;
	}

	public String getIsActiveHand() {
		return isActiveHand;
	}

	public void setIsActiveHand(String isActiveHand) {
		this.isActiveHand = isActiveHand;
	}

	public String getIsActiveFeet() {
		return isActiveFeet;
	}

	public void setIsActiveFeet(String isActiveFeet) {
		this.isActiveFeet = isActiveFeet;
	}

	public String getIsActiveWithGlass() {
		return isActiveWithGlass;
	}

	public void setIsActiveWithGlass(String isActiveWithGlass) {
		this.isActiveWithGlass = isActiveWithGlass;
	}

	/*********** End of Physical *******/

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	/*********** Emergency Contact *******/
	private String emergencyName;
	private String emergRelationship;
	private String emergEmail;
	private String emergPhone;
	private String emergMobile;
	private String emergPlace;
	private String emergencyOccu;
	private String emerAddress;
	private String emergencyPincode;

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergRelationship() {
		return emergRelationship;
	}

	public void setEmergRelationship(String emergRelationship) {
		this.emergRelationship = emergRelationship;
	}

	public String getEmergEmail() {
		return emergEmail;
	}

	public void setEmergEmail(String emergEmail) {
		this.emergEmail = emergEmail;
	}

	public String getEmergPhone() {
		return emergPhone;
	}

	public void setEmergPhone(String emergPhone) {
		this.emergPhone = emergPhone;
	}

	public String getEmergMobile() {
		return emergMobile;
	}

	public void setEmergMobile(String emergMobile) {
		this.emergMobile = emergMobile;
	}

	public String getEmergPlace() {
		return emergPlace;
	}

	public void setEmergPlace(String emergPlace) {
		this.emergPlace = emergPlace;
	}

	public String getEmergencyOccu() {
		return emergencyOccu;
	}

	public void setEmergencyOccu(String emergencyOccu) {
		this.emergencyOccu = emergencyOccu;
	}

	public String getEmerAddress() {
		return emerAddress;
	}

	public void setEmerAddress(String emerAddress) {
		this.emerAddress = emerAddress;
	}

	public String getEmergencyPincode() {
		return emergencyPincode;
	}

	public void setEmergencyPincode(String emergencyPincode) {
		this.emergencyPincode = emergencyPincode;
	}

	/*********** End of Emergency *******/

	/*********** Reference *******/
	private String referenceName;
	private String occupationRef;
	private String relationshipRef;
	private String emailRef;
	private String referenceAddress;
	private String pincodeRef;
	private String phoneRef;
	private ArrayList employeeRefTables;

	public ArrayList getEmployeeRefTables() {
		return employeeRefTables;
	}

	public void setEmployeeRefTables(ArrayList employeeRefTables) {
		this.employeeRefTables = employeeRefTables;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getOccupationRef() {
		return occupationRef;
	}

	public void setOccupationRef(String occupationRef) {
		this.occupationRef = occupationRef;
	}

	public String getRelationshipRef() {
		return relationshipRef;
	}

	public void setRelationshipRef(String relationshipRef) {
		this.relationshipRef = relationshipRef;
	}

	public String getEmailRef() {
		return emailRef;
	}

	public void setEmailRef(String emailRef) {
		this.emailRef = emailRef;
	}

	public String getReferenceAddress() {
		return referenceAddress;
	}

	public void setReferenceAddress(String referenceAddress) {
		this.referenceAddress = referenceAddress;
	}

	public String getPincodeRef() {
		return pincodeRef;
	}

	public void setPincodeRef(String pincodeRef) {
		this.pincodeRef = pincodeRef;
	}

	public String getPhoneRef() {
		return phoneRef;
	}

	public void setPhoneRef(String phoneRef) {
		this.phoneRef = phoneRef;
	}

	/*********** End of Reference *******/

	/*********** Documents *******/
	private String accountNo;
	private String bankName;
	private String bankPlace;
	private String isActiveCash = "N";
	private String passportNo;
	private String issuedDate;
	private String expiryDate;
	private String issuedPlace;
	private String licenseNo;
	private String licenseType;
	private String licenseIssuedDate;
	private String licenseexpiryDate;
	private String renewalDate;
	private String joinDocUpload;
	private String visaRefNo;
	private String visaType;
	private String visaExpiryDate;
	private String visaIssuedDate;
	private String visaIssuedPlace;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankPlace() {
		return bankPlace;
	}

	public void setBankPlace(String bankPlace) {
		this.bankPlace = bankPlace;
	}

	public String getIsActiveCash() {
		return isActiveCash;
	}

	public void setIsActiveCash(String isActiveCash) {
		this.isActiveCash = isActiveCash;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getIssuedPlace() {
		return issuedPlace;
	}

	public void setIssuedPlace(String issuedPlace) {
		this.issuedPlace = issuedPlace;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getLicenseIssuedDate() {
		return licenseIssuedDate;
	}

	public void setLicenseIssuedDate(String licenseIssuedDate) {
		this.licenseIssuedDate = licenseIssuedDate;
	}

	public String getLicenseexpiryDate() {
		return licenseexpiryDate;
	}

	public void setLicenseexpiryDate(String licenseexpiryDate) {
		this.licenseexpiryDate = licenseexpiryDate;
	}

	public String getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(String renewalDate) {
		this.renewalDate = renewalDate;
	}

	public String getJoinDocUpload() {
		return joinDocUpload;
	}

	public void setJoinDocUpload(String joinDocUpload) {
		this.joinDocUpload = joinDocUpload;
	}

	public String getVisaRefNo() {
		return visaRefNo;
	}

	public void setVisaRefNo(String visaRefNo) {
		this.visaRefNo = visaRefNo;
	}

	public String getVisaType() {
		return visaType;
	}

	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	public String getVisaExpiryDate() {
		return visaExpiryDate;
	}

	public void setVisaExpiryDate(String visaExpiryDate) {
		this.visaExpiryDate = visaExpiryDate;
	}

	public String getVisaIssuedDate() {
		return visaIssuedDate;
	}

	public void setVisaIssuedDate(String visaIssuedDate) {
		this.visaIssuedDate = visaIssuedDate;
	}

	public String getVisaIssuedPlace() {
		return visaIssuedPlace;
	}

	public void setVisaIssuedPlace(String visaIssuedPlace) {
		this.visaIssuedPlace = visaIssuedPlace;
	}

	/*********** End of Documents *******/

	/*********** End of Family *******/
	private ArrayList employeetables;
	private String familyName;
	private String genderType;
	private String relationshipWithEmp;
	private boolean empDependence = true;

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGenderType() {
		return genderType;
	}

	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}

	public String getRelationshipWithEmp() {
		return relationshipWithEmp;
	}

	public void setRelationshipWithEmp(String relationshipWithEmp) {
		this.relationshipWithEmp = relationshipWithEmp;
	}

	public boolean isEmpDependence() {
		return empDependence;
	}

	public void setEmpDependence(boolean empDependence) {
		this.empDependence = empDependence;
	}

	public ArrayList getEmployeetables() {
		return employeetables;
	}

	public void setEmployeetables(ArrayList employeetables) {
		this.employeetables = employeetables;
	}

	/*********** End of Family *******/

	/************ Education ***********/
	private String qualification;
	private Double percentage;
	private String courseType;
	private String institution;
	private int yearPassed;
	private ArrayList employeeEduTables;

	public ArrayList getEmployeeEduTables() {
		return employeeEduTables;
	}

	public void setEmployeeEduTables(ArrayList employeeEduTables) {
		this.employeeEduTables = employeeEduTables;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public int getYearPassed() {
		return yearPassed;
	}

	public void setYearPassed(int yearPassed) {
		this.yearPassed = yearPassed;
	}

	/************ End of Education ***********/

	/************ Experience ***********/
	private String organization;
	private double experienceYear;
	private String expDesisnation;
	private String expRemarks;
	private ArrayList employeeExpTables;

	public ArrayList getEmployeeExpTables() {
		return employeeExpTables;
	}

	public void setEmployeeExpTables(ArrayList employeeExpTables) {
		this.employeeExpTables = employeeExpTables;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public double getExperienceYear() {
		return experienceYear;
	}

	public void setExperienceYear(double experienceYear) {
		this.experienceYear = experienceYear;
	}

	public String getExpDesisnation() {
		return expDesisnation;
	}

	public void setExpDesisnation(String expDesisnation) {
		this.expDesisnation = expDesisnation;
	}

	public String getExpRemarks() {
		return expRemarks;
	}

	public void setExpRemarks(String expRemarks) {
		this.expRemarks = expRemarks;
	}

	/********** End of Experience *********/

	/************** Merits ***************/
	private String awardName;
	private String scholarshipName;
	private String meritDesc;
	private ArrayList employeeMeritTables;

	public ArrayList getEmployeeMeritTables() {
		return employeeMeritTables;
	}

	public void setEmployeeMeritTables(ArrayList employeeMeritTables) {
		this.employeeMeritTables = employeeMeritTables;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getScholarshipName() {
		return scholarshipName;
	}

	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}

	public String getMeritDesc() {
		return meritDesc;
	}

	public void setMeritDesc(String meritDesc) {
		this.meritDesc = meritDesc;
	}

	/******** Rights ********/
	private int companyUserId;
	private int formPropertyId;

	public int getCompanyUserId() {
		return companyUserId;
	}

	public void setCompanyUserId(int companyUserId) {
		this.companyUserId = companyUserId;
	}

	public int getFormPropertyId() {
		return formPropertyId;
	}

	public void setFormPropertyId(int formPropertyId) {
		this.formPropertyId = formPropertyId;
	}

	public List<UserAdminMasterPhoneNoDetailBean> getPresentAddressMultiple() {
		return presentAddressMultiple;
	}

	public void setPresentAddressMultiple(List<UserAdminMasterPhoneNoDetailBean> presentAddressMultiple) {
		this.presentAddressMultiple = presentAddressMultiple;
	}

	public boolean isMarritalStatus() {
		return marritalStatus;
	}

	public void setMarritalStatus(boolean marritalStatus) {
		this.marritalStatus = marritalStatus;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPresentPlace() {
		return presentPlace;
	}

	public void setPresentPlace(String presentPlace) {
		this.presentPlace = presentPlace;
	}

	public String getPresentDistrict() {
		return presentDistrict;
	}

	public void setPresentDistrict(String presentDistrict) {
		this.presentDistrict = presentDistrict;
	}

	public String getPresentPin() {
		return presentPin;
	}

	public void setPresentPin(String presentPin) {
		this.presentPin = presentPin;
	}

	public String getPresentPhone() {
		return presentPhone;
	}

	public void setPresentPhone(String presentPhone) {
		this.presentPhone = presentPhone;
	}

	public String getPresentMobile() {
		return presentMobile;
	}

	public void setPresentMobile(String presentMobile) {
		this.presentMobile = presentMobile;
	}

	public String getIsActiveOldAddress() {
		return isActiveOldAddress;
	}

	public void setIsActiveOldAddress(String isActiveOldAddress) {
		this.isActiveOldAddress = isActiveOldAddress;
	}

	public double getRightSidePower() {
		return rightSidePower;
	}

	public void setRightSidePower(double rightSidePower) {
		this.rightSidePower = rightSidePower;
	}

	public double getLeftSidePower() {
		return leftSidePower;
	}

	public void setLeftSidePower(double leftSidePower) {
		this.leftSidePower = leftSidePower;
	}

	public String getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}

	public List<UserAdminDuplicateBean> getEmployeeDuplicateList() {
		return employeeDuplicateList;
	}

	public void setEmployeeDuplicateList(List<UserAdminDuplicateBean> employeeDuplicateList) {
		this.employeeDuplicateList = employeeDuplicateList;
	}

	public int getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmpUserId() {
		return empUserId;
	}

	public void setEmpUserId(String empUserId) {
		this.empUserId = empUserId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public int getEmployeeLeaveType() {
		return employeeLeaveType;
	}

	public void setEmployeeLeaveType(int employeeLeaveType) {
		this.employeeLeaveType = employeeLeaveType;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getReportDeptId() {
		return reportDeptId;
	}

	public void setReportDeptId(String reportDeptId) {
		this.reportDeptId = reportDeptId;
	}

	public String getReportDesigId() {
		return reportDesigId;
	}

	public void setReportDesigId(String reportDesigId) {
		this.reportDesigId = reportDesigId;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getIsEmailExempted() {
		return isEmailExempted;
	}

	public void setIsEmailExempted(String isEmailExempted) {
		this.isEmailExempted = isEmailExempted;
	}

	

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getTypeOfEmp() {
		return typeOfEmp;
	}

	public void setTypeOfEmp(Integer typeOfEmp) {
		this.typeOfEmp = typeOfEmp;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getVendorShow() {
		return vendorShow;
	}

	public void setVendorShow(String vendorShow) {
		this.vendorShow = vendorShow;
	}
	
	

	/********** End of Experience *********/
}
