package com.dci.master.branch;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "branch", formCode = "F5036")

public class Branch {
	
	private String formCode;
	private String tableName;
	private int branchId;
	private int uom;
	private String gstnNo;
	private Integer logoPath;
	private String branchCode;
	private String branchName;
	private String panNo;
	private String address;
	private String address1;
	private String address2;
	private String faxNo;
	private String serviceTaxNo;
	private String licenceNo;
	private String address3;
	private String pinCode;
	private String companyId;
	private Integer currencyId;
	private String phoneNumber;
	private Boolean isHead;
	private boolean isActive;
	private boolean isEdit;
	private String shortName;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
	private String country;
	private String state;
	private String city;
	private String email;
	private String company;
	private String currency;
	private Integer gstnCode;
	private String id;
	private String text;
	private int tenantId;
	private Integer templateId;
	private String customerName;
	private String companyCode;
	private Integer countryId;
	private Integer cityId;
	private String companyName;
	private String currencyName;
	private String logopath1;
	private String uom1;
	private String stateName;
	private String countryName;
	private String cityName;
    List<String> getTextList;
    
    

	public List<String> getGetTextList() {
		return getTextList;
	}

	public void setGetTextList(List<String> getTextList) {
		this.getTextList = getTextList;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	@AuditLoggable(fieldName = "tenant_id", displayName = "tenantId")

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
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

	@AuditLoggable(fieldName = "brnch_id", displayName = "branchId")

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	@AuditLoggable(fieldName = "brnch_cd", displayName = "branchCode")


	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	@AuditLoggable(fieldName = "address", displayName = "address")

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@AuditLoggable(fieldName = "short_name", displayName = "shortName")

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	@AuditLoggable(fieldName = "city", displayName = "city")

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@AuditLoggable(fieldName = "email", displayName = "email")

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@AuditLoggable(fieldName = "actv_bt", displayName = "isActive")

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	@AuditLoggable(fieldName = "brnch_nam", displayName = "brnch_nam")

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@AuditLoggable(fieldName = "phn_no", displayName = "phoneNumber")


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@AuditLoggable(fieldName = "country", displayName = "country")

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@AuditLoggable(fieldName = "state", displayName = "state")

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@AuditLoggable(fieldName = "is_head", displayName = "isHead")

	public Boolean getIsHead() {
		return isHead;
	}

	public void setIsHead(Boolean isHead) {
		this.isHead = isHead;
	}


	@AuditLoggable(fieldName = "template_id", displayName = "templateId")

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@AuditLoggable(fieldName = "cmpny_id", displayName = "company")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public String getServiceTaxNo() {
		return serviceTaxNo;
	}

	
	public void setServiceTaxNo(String serviceTaxNo) {
		this.serviceTaxNo = serviceTaxNo;
	}


	public String getGstnNo() {
		return gstnNo;
	}

	public void setGstnNo(String gstnNo) {
		this.gstnNo = gstnNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	
	@AuditLoggable(fieldName = "crrncy_id", displayName = "Currency")
	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public int getUom() {
		return uom;
	}

	public void setUom(int uom) {
		this.uom = uom;
	}

	public Integer getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(Integer logoPath) {
		this.logoPath = logoPath;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getGstnCode() {
		return gstnCode;
	}

	public void setGstnCode(Integer gstnCode) {
		this.gstnCode = gstnCode;
	}
	@AuditLoggable(fieldName = "pin_code", displayName = "pinCode")

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getLogopath1() {
		return logopath1;
	}

	public void setLogopath1(String logopath1) {
		this.logopath1 = logopath1;
	}

	public String getUom1() {
		return uom1;
	}

	public void setUom1(String uom1) {
		this.uom1 = uom1;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


}
