package com.dci.master.userAdminMaster;

import java.util.ArrayList;

public class UserAdminFamilyBean {

	private String empId;
	private String familyName;
	private Boolean genderType;
	private String relationshipWithEmp;
	private Boolean empDependence = false;
	private String uploadPhotoFamily;
	private int empFamilyId;
	private String uploadDependentPhoto;

	private ArrayList employeeDependentList;
	private Integer dependentId;
	private Integer age;
	private String sex;
	private String dependentDob;
	private String employeeId;
	private String relativeName;
	private String relationToEmployee;
	private String aadharno;
	private String mobileno;
	private String aadharno1;

	public String getAadharno1() {
		return aadharno1;
	}

	public void setAadharno1(String aadharno1) {
		this.aadharno1 = aadharno1;
	}

	public ArrayList getEmployeeDependentList() {
		return employeeDependentList;
	}

	public void setEmployeeDependentList(ArrayList employeeDependentList) {
		this.employeeDependentList = employeeDependentList;
	}

	public Integer getDependentId() {
		return dependentId;
	}

	public void setDependentId(Integer dependentId) {
		this.dependentId = dependentId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDependentDob() {
		return dependentDob;
	}

	public void setDependentDob(String dependentDob) {
		this.dependentDob = dependentDob;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getRelativeName() {
		return relativeName;
	}

	public void setRelativeName(String relativeName) {
		this.relativeName = relativeName;
	}

	public String getRelationToEmployee() {
		return relationToEmployee;
	}

	public void setRelationToEmployee(String relationToEmployee) {
		this.relationToEmployee = relationToEmployee;
	}

	public boolean isDependentOnEmployee() {
		return dependentOnEmployee;
	}

	public void setDependentOnEmployee(boolean dependentOnEmployee) {
		this.dependentOnEmployee = dependentOnEmployee;
	}

	public String getDependentPassportNo() {
		return dependentPassportNo;
	}

	public void setDependentPassportNo(String dependentPassportNo) {
		this.dependentPassportNo = dependentPassportNo;
	}

	public String getDependentPassportIssuedDate() {
		return dependentPassportIssuedDate;
	}

	public void setDependentPassportIssuedDate(String dependentPassportIssuedDate) {
		this.dependentPassportIssuedDate = dependentPassportIssuedDate;
	}

	public String getDependentPassportExpiryDate() {
		return dependentPassportExpiryDate;
	}

	public void setDependentPassportExpiryDate(String dependentPassportExpiryDate) {
		this.dependentPassportExpiryDate = dependentPassportExpiryDate;
	}

	public String getDependentPassportIssuedPlace() {
		return dependentPassportIssuedPlace;
	}

	public void setDependentPassportIssuedPlace(String dependentPassportIssuedPlace) {
		this.dependentPassportIssuedPlace = dependentPassportIssuedPlace;
	}

	public String getDependentVisaReferenceNumber() {
		return dependentVisaReferenceNumber;
	}

	public void setDependentVisaReferenceNumber(String dependentVisaReferenceNumber) {
		this.dependentVisaReferenceNumber = dependentVisaReferenceNumber;
	}

	public String getDependentVisaType() {
		return dependentVisaType;
	}

	public void setDependentVisaType(String dependentVisaType) {
		this.dependentVisaType = dependentVisaType;
	}

	public String getDependentVisaIssuedPlace() {
		return dependentVisaIssuedPlace;
	}

	public void setDependentVisaIssuedPlace(String dependentVisaIssuedPlace) {
		this.dependentVisaIssuedPlace = dependentVisaIssuedPlace;
	}

	public String getDependentVisaIssuedDate() {
		return dependentVisaIssuedDate;
	}

	public void setDependentVisaIssuedDate(String dependentVisaIssuedDate) {
		this.dependentVisaIssuedDate = dependentVisaIssuedDate;
	}

	public String getDependentVisaExpirationDate() {
		return dependentVisaExpirationDate;
	}

	public void setDependentVisaExpirationDate(String dependentVisaExpirationDate) {
		this.dependentVisaExpirationDate = dependentVisaExpirationDate;
	}

	public String getDependentPhotoUrl() {
		return dependentPhotoUrl;
	}

	public void setDependentPhotoUrl(String dependentPhotoUrl) {
		this.dependentPhotoUrl = dependentPhotoUrl;
	}

	public String getDependentMedicalEntitlement() {
		return dependentMedicalEntitlement;
	}

	public void setDependentMedicalEntitlement(String dependentMedicalEntitlement) {
		this.dependentMedicalEntitlement = dependentMedicalEntitlement;
	}

	public String getDependentFileName() {
		return dependentFileName;
	}

	public void setDependentFileName(String dependentFileName) {
		this.dependentFileName = dependentFileName;
	}

	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	private boolean dependentOnEmployee = true;
	private String dependentPassportNo;
	private String dependentPassportIssuedDate;
	private String dependentPassportExpiryDate;
	private String dependentPassportIssuedPlace;
	private String dependentVisaReferenceNumber;
	private String dependentVisaType;
	private String dependentVisaIssuedPlace;
	private String dependentVisaIssuedDate;
	private String dependentVisaExpirationDate;
	private String dependentPhotoUrl;
	private String dependentMedicalEntitlement;
	private String dependentFileName;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Boolean getGenderType() {
		return genderType;
	}

	public void setGenderType(Boolean genderType) {
		this.genderType = genderType;
	}

	public String getRelationshipWithEmp() {
		return relationshipWithEmp;
	}

	public void setRelationshipWithEmp(String relationshipWithEmp) {
		this.relationshipWithEmp = relationshipWithEmp;
	}

	public Boolean getEmpDependence() {
		return empDependence;
	}

	public void setEmpDependence(Boolean empDependence) {
		this.empDependence = empDependence;
	}

	public String getUploadPhotoFamily() {
		return uploadPhotoFamily;
	}

	public void setUploadPhotoFamily(String uploadPhotoFamily) {
		this.uploadPhotoFamily = uploadPhotoFamily;
	}

	public int getEmpFamilyId() {
		return empFamilyId;
	}

	public void setEmpFamilyId(int empFamilyId) {
		this.empFamilyId = empFamilyId;
	}

	public String getUploadDependentPhoto() {
		return uploadDependentPhoto;
	}

	public void setUploadDependentPhoto(String uploadDependentPhoto) {
		this.uploadDependentPhoto = uploadDependentPhoto;
	}

}
