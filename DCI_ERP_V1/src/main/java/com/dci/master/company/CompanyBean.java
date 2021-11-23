package com.dci.master.company;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "company_master", formCode = "F0045")

public class CompanyBean {
	
	public String company_code;
	public String company_name;
	public String location;
	public String address;
	public String telephone_no;
	public String currency;
	public String short_name;
	public String fax_no;
	public String email;
	public String person_incharge;
	public String relationship;
	public String intercompanygroup;
	public String vat_reg_no;
	public String id;
	public String text;
	
	
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
	@AuditLoggable(fieldName = "company_code", displayName = "company_code")
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}
	@AuditLoggable(fieldName = "company_name", displayName = "company_name")
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	@AuditLoggable(fieldName = "location", displayName = "location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@AuditLoggable(fieldName = "address", displayName = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@AuditLoggable(fieldName = "ph_no", displayName = "telephone_no")	
	public String getTelephone_no() {
		return telephone_no;
	}
	public void setTelephone_no(String telephone_no) {
		this.telephone_no = telephone_no;
	}
	@AuditLoggable(fieldName = "currency", displayName = "currency")	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@AuditLoggable(fieldName = "short_name", displayName = "short_name")	
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	@AuditLoggable(fieldName = "fax_no", displayName = "fax_no")	
	public String getFax_no() {
		return fax_no;
	}
	public void setFax_no(String fax_no) {
		this.fax_no = fax_no;
	}
	@AuditLoggable(fieldName = "email", displayName = "email")	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@AuditLoggable(fieldName = "person_incharge", displayName = "person_incharge")	
	public String getPerson_incharge() {
		return person_incharge;
	}
	public void setPerson_incharge(String person_incharge) {
		this.person_incharge = person_incharge;
	}
	@AuditLoggable(fieldName = "relationship", displayName = "relationship")	
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	@AuditLoggable(fieldName = "inter_comp_group", displayName = "intercompanygroup")	
	public String getIntercompanygroup() {
		return intercompanygroup;
	}
	public void setIntercompanygroup(String intercompanygroup) {
		this.intercompanygroup = intercompanygroup;
	}
	public String getVat_reg_no() {
		return vat_reg_no;
	}
	public void setVat_reg_no(String vat_reg_no) {
		this.vat_reg_no = vat_reg_no;
	}
    
	

}
