package com.dci.master.servicepartner;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "service_partner", formCode = "F5086")

public class ServicePartnerBean {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private String formCode;
	private String countryName;
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	private String tableName;
	
	private String salesPerson;
	
	private List<ServicePartnerBean> lServicePartnerBean;

	private String servicePartnerCode;
	
	private int servicePartnerId;

	private int servicePartnerKeyId;

	private String servicePartnerName;
	
	private String defaultTypeName;
	
	private String cityName;
	
	private String servicePartnerLedgerName;
	
	private Integer partnerClassification;

	private Integer gSTNStateCode;
	
	private String gSTNNo;

	private String exemptionUnder;
	
	private String servicePartnerDescription;

	private String defaultType;

	private String branch;
	
	private Integer creditDaysOffered;
	public Boolean isSuccess;

	private String gststatecode;

	private String city;

	private String country;

	private String createdBy;

	private String createdDate;

	private String modifiedBy;

	private String modifiedDate;
	
	
	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	private String branchName;
	
	private String sundryStatus;
	
	private String loginId;
	
	private String stateName;
	private String salesPerson1;
	private String sundryStatus1;
	private String type1;

	private int prtyCount;
	private String cusvenagent;
	private String servicepartnertype;

	private double creditAmt;
	private List<Integer> servicePartnerTypeList;


	
	public List<Integer> getServicePartnerTypeList() {
		return servicePartnerTypeList;
	}

	public void setServicePartnerTypeList(List<Integer> servicePartnerTypeList) {
		this.servicePartnerTypeList = servicePartnerTypeList;
	}

	public double getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(double creditAmt) {
		this.creditAmt = creditAmt;
	}

		
	
	
	
	public String getServicepartnertype() {
		return servicepartnertype;
	}

	public void setServicepartnertype(String servicepartnertype) {
		this.servicepartnertype = servicepartnertype;
	}

	public String getCusvenagent() {
		return cusvenagent;
	}

	public void setCusvenagent(String cusvenagent) {
		this.cusvenagent = cusvenagent;
	}

	public int getPrtyCount() {
		return prtyCount;
	}

	public void setPrtyCount(int prtyCount) {
		this.prtyCount = prtyCount;
	}

	public String getSundryStatus() {
		return sundryStatus;
	}

	public void setSundryStatus(String sundryStatus) {
		this.sundryStatus = sundryStatus;
	}

	private Boolean cstbin;
	public Boolean getCstbin() {
		return cstbin;
	}

	public void setCstbin(Boolean cstbin) {
		this.cstbin = cstbin;
	}

	public Boolean getExpbin() {
		return expbin;
	}

	public void setExpbin(Boolean expbin) {
		this.expbin = expbin;
	}

	public Boolean getImpbin() {
		return impbin;
	}

	public void setImpbin(Boolean impbin) {
		this.impbin = impbin;
	}

	public Boolean getShipbin() {
		return shipbin;
	}

	public void setShipbin(Boolean shipbin) {
		this.shipbin = shipbin;
	}

	public Boolean getConsbin() {
		return consbin;
	}

	public void setConsbin(Boolean consbin) {
		this.consbin = consbin;
	}

	public Boolean getLinbin() {
		return linbin;
	}

	public void setLinbin(Boolean linbin) {
		this.linbin = linbin;
	}

	public Boolean getAirlinbin() {
		return airlinbin;
	}

	public void setAirlinbin(Boolean airlinbin) {
		this.airlinbin = airlinbin;
	}

	public Boolean getFribin() {
		return fribin;
	}

	public void setFribin(Boolean fribin) {
		this.fribin = fribin;
	}

	public Boolean getCussbin() {
		return cussbin;
	}

	public void setCussbin(Boolean cussbin) {
		this.cussbin = cussbin;
	}

	public Boolean getTransbin() {
		return transbin;
	}

	public void setTransbin(Boolean transbin) {
		this.transbin = transbin;
	}

	public Boolean getSlotbin() {
		return slotbin;
	}

	public void setSlotbin(Boolean slotbin) {
		this.slotbin = slotbin;
	}

	public Boolean getLeasebin() {
		return leasebin;
	}

	public void setLeasebin(Boolean leasebin) {
		this.leasebin = leasebin;
	}

	public Boolean getConmanubin() {
		return conmanubin;
	}

	public void setConmanubin(Boolean conmanubin) {
		this.conmanubin = conmanubin;
	}

	public Boolean getCfsbin() {
		return cfsbin;
	}

	public void setCfsbin(Boolean cfsbin) {
		this.cfsbin = cfsbin;
	}

	public Boolean getAgebin() {
		return agebin;
	}

	public void setAgebin(Boolean agebin) {
		this.agebin = agebin;
	}

	public Boolean getDepobin() {
		return depobin;
	}

	public void setDepobin(Boolean depobin) {
		this.depobin = depobin;
	}

	public Boolean getIatabin() {
		return iatabin;
	}

	public void setIatabin(Boolean iatabin) {
		this.iatabin = iatabin;
	}

	private Boolean expbin;
	private Boolean impbin;
	private Boolean shipbin;
	private Boolean consbin;
	private Boolean linbin;
	private Boolean airlinbin;
	private Boolean fribin;
	private Boolean cussbin;
	private Boolean transbin;
	private Boolean slotbin;
	private Boolean leasebin;
	private Boolean conmanubin;
	private Boolean cfsbin;
	private Boolean agebin;
	private Boolean depobin;
	private Boolean iatabin;
	
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

	private String designation;

	private boolean active;

	private String address;
	
	private String personToContact;
	
	private String landLineNo;
	
	private String mobileNo;
	
	private String region;
	
	private String zipCode;
	
	private String emailId;
	
	private String skypeId;
	
	private String webSite;
	
	private String pANNo;
	
	private String salesPersonEmp;
	private String FromDate;
	private String ToDate;
	
	private String oldSalePerson;
	
	private String oldStartDate;

	public String getSalesPersonEmp() {
		return salesPersonEmp;
	}

	public void setSalesPersonEmp(String salesPersonEmp) {
		this.salesPersonEmp = salesPersonEmp;
	}

	public String getFromDate() {
		return FromDate;
	}

	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}

	public String getToDate() {
		return ToDate;
	}

	public void setToDate(String toDate) {
		ToDate = toDate;
	}

	public String getOldSalePerson() {
		return oldSalePerson;
	}

	public void setOldSalePerson(String oldSalePerson) {
		this.oldSalePerson = oldSalePerson;
	}

	public String getOldStartDate() {
		return oldStartDate;
	}

	public void setOldStartDate(String oldStartDate) {
		this.oldStartDate = oldStartDate;
	}

	@AuditLoggable(fieldName = "srvc_prtnr_cd", displayName = "servicePartnerCode")

	public String getServicePartnerCode() {
		return servicePartnerCode;
	}

	public void setServicePartnerCode(String servicePartnerCode) {
		this.servicePartnerCode = servicePartnerCode;
	}
	@AuditLoggable(fieldName = "srvc_prtnr_nam", displayName = "servicePartnerName")

	public String getServicePartnerName() {
		return servicePartnerName;
	}

	public void setServicePartnerName(String servicePartnerName) {
		this.servicePartnerName = servicePartnerName;
	}
	@AuditLoggable(fieldName = "srvc_prtnr_ldgr_nam", displayName = "servicePartnerLedgerName")

	public String getServicePartnerLedgerName() {
		return servicePartnerLedgerName;
	}

	public void setServicePartnerLedgerName(String servicePartnerLedgerName) {
		this.servicePartnerLedgerName = servicePartnerLedgerName;
	}

	@AuditLoggable(fieldName = "gstn_no", displayName = "gSTNNo")

	public String getgSTNNo() {
		return gSTNNo;
	}

	public void setgSTNNo(String gSTNNo) {
		this.gSTNNo = gSTNNo;
	}
	@AuditLoggable(fieldName = "exmptn_udr", displayName = "exemptionUnder")


	public String getExemptionUnder() {
		return exemptionUnder;
	}

	public void setExemptionUnder(String exemptionUnder) {
		this.exemptionUnder = exemptionUnder;
	}

	@AuditLoggable(fieldName = "srvc_prtnr_dscrptn", displayName = "servicePartnerDescription")

	public String getServicePartnerDescription() {
		return servicePartnerDescription;
	}

	public void setServicePartnerDescription(String servicePartnerDescription) {
		this.servicePartnerDescription = servicePartnerDescription;
	}
	@AuditLoggable(fieldName = "dflt_typ_id", displayName = "defaultType")

	public String getDefaultType() {
		return defaultType;
	}

	public void setDefaultType(String defaultType) {
		this.defaultType = defaultType;
	}
	@AuditLoggable(fieldName = "brnch_id", displayName = "branch")

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@AuditLoggable(fieldName = "cty_id", displayName = "city")


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	@AuditLoggable(fieldName = "cntry_cd", displayName = "country")

	public void setCountry(String country) {
		this.country = country;
	}
	@AuditLoggable(fieldName = "actv_bt", displayName = "active")

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	@AuditLoggable(fieldName = "addrs1_add", displayName = "address")

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@AuditLoggable(fieldName = "prsn_to_cntct", displayName = "personToContact")

	public String getPersonToContact() {
		return personToContact;
	}

	public void setPersonToContact(String personToContact) {
		this.personToContact = personToContact;
	}
	@AuditLoggable(fieldName = "phn_no_phn", displayName = "landLineNo")

	public String getLandLineNo() {
		return landLineNo;
	}

	public void setLandLineNo(String landLineNo) {
		this.landLineNo = landLineNo;
	}
	@AuditLoggable(fieldName = "mbl_no_mob", displayName = "mobileNo")

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@AuditLoggable(fieldName = "rgn_cd", displayName = "region")

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	@AuditLoggable(fieldName = "zp_cd_zp", displayName = "zipCode")

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@AuditLoggable(fieldName = "eml_id_eml", displayName = "emailId")

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@AuditLoggable(fieldName = "skyp_id", displayName = "skypeId")

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	@AuditLoggable(fieldName = "pan_no", displayName = "pANNo")


	public String getpANNo() {
		return pANNo;
	}

	public void setpANNo(String pANNo) {
		this.pANNo = pANNo;
	}


	public List<ServicePartnerBean> getlServicePartnerBean() {
		return lServicePartnerBean;
	}

	public void setlServicePartnerBean(List<ServicePartnerBean> lServicePartnerBean) {
		this.lServicePartnerBean = lServicePartnerBean;
	}
	@AuditLoggable(fieldName = "dsgntn", displayName = "designation")

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@AuditLoggable(fieldName = "srvc_prtnr_bin", displayName = "servicePartnerId")

	public int getServicePartnerId() {
		return servicePartnerId;
	}

	public void setServicePartnerId(int servicePartnerId) {
		this.servicePartnerId = servicePartnerId;
	}

	public int getServicePartnerKeyId() {
		return servicePartnerKeyId;
	}

	public void setServicePartnerKeyId(int servicePartnerKeyId) {
		this.servicePartnerKeyId = servicePartnerKeyId;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	@AuditLoggable(fieldName = "gstn_stt_cd", displayName = "gSTNStateCode")

	public Integer getgSTNStateCode() {
		return gSTNStateCode;
	}

	public void setgSTNStateCode(Integer gSTNStateCode) {
		this.gSTNStateCode = gSTNStateCode;
	}
	@AuditLoggable(fieldName = "crdt_dys_offrd", displayName = "creditDaysOffered")

	public Integer getCreditDaysOffered() {
		return creditDaysOffered;
	}

	public void setCreditDaysOffered(Integer creditDaysOffered) {
		this.creditDaysOffered = creditDaysOffered;
	}

	public String getDefaultTypeName() {
		return defaultTypeName;
	}

	public void setDefaultTypeName(String defaultTypeName) {
		this.defaultTypeName = defaultTypeName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@AuditLoggable(fieldName = "prtnr_clssfctn_id", displayName = "partnerClassification")

	public Integer getPartnerClassification() {
		return partnerClassification;
	}

	public void setPartnerClassification(Integer partnerClassification) {
		this.partnerClassification = partnerClassification;
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

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getSalesPerson1() {
		return salesPerson1;
	}

	public void setSalesPerson1(String salesPerson1) {
		this.salesPerson1 = salesPerson1;
	}

	public String getSundryStatus1() {
		return sundryStatus1;
	}

	public void setSundryStatus1(String sundryStatus1) {
		this.sundryStatus1 = sundryStatus1;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}
	

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getGststatecode() {
		return gststatecode;
	}

	public void setGststatecode(String gststatecode) {
		this.gststatecode = gststatecode;
	}

	
	
	
}
