package com.dci.master.userAdminMaster;

import java.util.List;

public class UserAdminNominationBean {
	private String aadharno2;
	private String EmpId;
	private boolean select;
	private String nominateName;
	private Boolean nominateGender;
	private String nominateOccupation;
	private String nominateRelationship;
	private String nominateEmail;
	private String uploadPhotoNominee;
	private String nomdateOfBirth;
	private String nomineAddress;
	private String nominatePlace;
	private String nominatePincode;

	private List<UserAdminNominationBean> nominatePhoneMultiple;
	private List<UserAdminNominationBean> nominateMobileMultiple;
	private String emergPhone;
	private String emergMobile;
	private int employeeNomId;

	public String getAadharno2() {
		return aadharno2;
	}

	public void setAadharno2(String aadharno2) {
		this.aadharno2 = aadharno2;
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

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}

	public String getNominateName() {
		return nominateName;
	}

	public void setNominateName(String nominateName) {
		this.nominateName = nominateName;
	}

	public Boolean getNominateGender() {
		return nominateGender;
	}

	public void setNominateGender(Boolean nominateGender) {
		this.nominateGender = nominateGender;
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

	public String getUploadPhotoNominee() {
		return uploadPhotoNominee;
	}

	public void setUploadPhotoNominee(String uploadPhotoNominee) {
		this.uploadPhotoNominee = uploadPhotoNominee;
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

	public List<UserAdminNominationBean> getNominatePhoneMultiple() {
		return nominatePhoneMultiple;
	}

	public void setNominatePhoneMultiple(List<UserAdminNominationBean> nominatePhoneMultiple) {
		this.nominatePhoneMultiple = nominatePhoneMultiple;
	}

	public List<UserAdminNominationBean> getNominateMobileMultiple() {
		return nominateMobileMultiple;
	}

	public void setNominateMobileMultiple(List<UserAdminNominationBean> nominateMobileMultiple) {
		this.nominateMobileMultiple = nominateMobileMultiple;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public int getEmployeeNomId() {
		return employeeNomId;
	}

	public void setEmployeeNomId(int employeeNomId) {
		this.employeeNomId = employeeNomId;
	}

}
