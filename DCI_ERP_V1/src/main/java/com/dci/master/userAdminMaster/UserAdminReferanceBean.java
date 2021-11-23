package com.dci.master.userAdminMaster;

import java.util.List;

//
public class UserAdminReferanceBean {
	private String empId;
	private String referenceName;
	private String occupationRef;
	private String relationshipRef;
	private String emailRef;
	private String referenceAddress;
	private String pincodeRef;
	private String emergPhone;
	private boolean isSelect;
	private List<UserAdminReferanceBean> phoneRefMultiple;
	private int empRefId;

	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}

	public String getEmergPhone() {
		return emergPhone;
	}

	public void setEmergPhone(String emergPhone) {
		this.emergPhone = emergPhone;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	public List<UserAdminReferanceBean> getPhoneRefMultiple() {
		return phoneRefMultiple;
	}

	public void setPhoneRefMultiple(List<UserAdminReferanceBean> phoneRefMultiple) {
		this.phoneRefMultiple = phoneRefMultiple;
	}

	public int getEmpRefId() {
		return empRefId;
	}

	public void setEmpRefId(int empRefId) {
		this.empRefId = empRefId;
	}

}
