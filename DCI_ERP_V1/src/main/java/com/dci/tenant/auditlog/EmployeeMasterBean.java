package com.dci.tenant.auditlog;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.SelectivityBean;

public class EmployeeMasterBean {
	private String aadhaarNo;
	private String aadhaarIssuedDate;
	private String enrollNo ;
	private String aadhaarMail;
	private String bankBranch;
	private String donorCode;
	private String employeeNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String empId;
	private String pwd;
	private String gender;
	private String dob;
	private String emailId;
	private String mobileNo;
	private String doj;
	private String esic;
	private Double fixedGross;
	private String category;
	private String secondLevel;
	private String isActive = "N";
	private String status = "N";
	private boolean principal;
	private boolean ms;
	private String salaryCategory;
	private Boolean isRelieved;
	private Boolean isRejoin;
	private String oldEmpId;
	private Boolean isacctAuthority;
	private String accessCardNo;
	private String uploadPhoto;
	private String companyCode;
	private String companyName;
	private int branchId;
	private String branch;
	private String branchName;
	private int departmentId;
	private String departmentCode;
	private int designation;
	private String designationName;
	private int division;
	private String divisionName;
	private int grade;
	private String gradeName;
	private String reportToBranch;
	private String reportToBranchName;
	private int reportDeptId;
	private String reportToDept;
	private int reportDesigId;
	private String reportToDesig;
	private String reportMangrId;
	private String reportManagerName;
	private int typeOfEmp;
	private String empTypeName;
	private String relieveDate;
	private String epfNo;
	private boolean isEdit;
	private int branchDepartmentId;
	private int isPrimary;
	private String id;
	private String text;
	private String insuranceNo;
	private List<EmployeeMasterPhoneNoDetailBean> presentAddressMultiple;
	private List<SelectivityBean> okker;

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getAadhaarIssuedDate() {
		return aadhaarIssuedDate;
	}

	public void setAadhaarIssuedDate(String aadhaarIssuedDate) {
		this.aadhaarIssuedDate = aadhaarIssuedDate;
	}

	public String getEnrollNo() {
		return enrollNo;
	}

	public void setEnrollNo(String enrollNo) {
		this.enrollNo = enrollNo;
	}

	public String getAadhaarMail() {
		return aadhaarMail;
	}

	public void setAadhaarMail(String aadhaarMail) {
		this.aadhaarMail = aadhaarMail;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
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

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public void setDonorCode(String donorCode) {
		this.donorCode = donorCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public int getDesignation() {
		return designation;
	}

	public void setDesignation(int designation) {
		this.designation = designation;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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

	public int getTypeOfEmp() {
		return typeOfEmp;
	}

	public void setTypeOfEmp(int typeOfEmp) {
		this.typeOfEmp = typeOfEmp;
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

	public int getReportDeptId() {
		return reportDeptId;
	}

	public void setReportDeptId(int reportDeptId) {
		this.reportDeptId = reportDeptId;
	}

	public int getReportDesigId() {
		return reportDesigId;
	}

	public void setReportDesigId(int reportDesigId) {
		this.reportDesigId = reportDesigId;
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
	private int marritalStatus;
	private String guardiansName;

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

	public int getMarritalStatus() {
		return marritalStatus;
	}

	public void setMarritalStatus(int marritalStatus) {
		this.marritalStatus = marritalStatus;
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

	public List<EmployeeMasterPhoneNoDetailBean> getPresentAddressMultiple() {
		return presentAddressMultiple;
	}

	public void setPresentAddressMultiple(List<EmployeeMasterPhoneNoDetailBean> presentAddressMultiple) {
		this.presentAddressMultiple = presentAddressMultiple;
	}

	public String getSalaryCategory() {
		return salaryCategory;
	}

	public void setSalaryCategory(String salaryCategory) {
		this.salaryCategory = salaryCategory;
	}

	public Boolean getIsRelieved() {
		return isRelieved;
	}

	public void setIsRelieved(Boolean isRelieved) {
		this.isRelieved = isRelieved;
	}


	public Boolean getIsRejoin() {
		return isRejoin;
	}

	public void setIsRejoin(Boolean isRejoin) {
		this.isRejoin = isRejoin;
	}

	public String getOldEmpId() {
		return oldEmpId;
	}

	public void setOldEmpId(String oldEmpId) {
		this.oldEmpId = oldEmpId;
	}

	public Boolean getIsacctAuthority() {
		return isacctAuthority;
	}

	public void setIsacctAuthority(Boolean isacctAuthority) {
		this.isacctAuthority = isacctAuthority;
	}

	public List<SelectivityBean> getOkker() {
		return okker;
	}

	public void setOkker(List<SelectivityBean> okker) {
		this.okker = okker;
	}

	

	

	/********** End of Experience *********/
}
