package com.dci.tenant.company;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "COMPANY_MASTER", formCode = "F5035")

public class CompanyDetailsBean {

	private String companycode;
	private String companyname;
	private String shortName;
	private String location;
	private String address;
	private String phoneno;
	private String faxno;
	private String email;
	private String personincharge;
	private String relationship;
	private String intercompgroup;
	private String currencyCode;
	private boolean success;
	private boolean isEdit;
	private String created_by;
	private String created_date;
	private boolean selected;
	private String isOperation;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
//	@AuditLoggable(fieldName = "inter_comp_group", displayName = "intercompgroup")

	public String getIntercompgroup() {
		return intercompgroup;
	}

	public void setIntercompgroup(String intercompgroup) {
		this.intercompgroup = intercompgroup;
	}
	//@AuditLoggable(fieldName = "relationship", displayName = "relationship")

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	@AuditLoggable(fieldName = "person_incharge", displayName = "personincharge")

	public String getPersonincharge() {
		return personincharge;
	}

	public void setPersonincharge(String personincharge) {
		this.personincharge = personincharge;
	}
	@AuditLoggable(fieldName = "fax_no", displayName = "Fax Number")

	public String getFaxno() {
		return faxno;
	}
	
	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}

	@AuditLoggable(fieldName = "email", displayName = "email")

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@AuditLoggable(fieldName = "ph_no", displayName = "phoneno")

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@AuditLoggable(fieldName = "address", displayName = "address")

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@AuditLoggable(fieldName = "location", displayName = "location")

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@AuditLoggable(fieldName = "company_name", displayName = "CompanyName")

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	//@AuditLoggable(fieldName = "company_code", displayName = "companycode")

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	@AuditLoggable(fieldName = "currency", displayName = "currencyCode")

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@AuditLoggable(fieldName = "short_name", displayName = "shortName")

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getIsOperation() {
		return isOperation;
	}

	public void setIsOperation(String isOperation) {
		this.isOperation = isOperation;
	}

}
