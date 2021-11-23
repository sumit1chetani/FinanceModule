package com.dci.tenant.finance.PurchaseCreditNote;

import com.dci.tenant.auditlog.AuditLoggable;

public class PuchaseCreditNoteDetailBean {

	private Boolean select;
	private String company_id_dtl;
	private String crdtlAccountHead;
	private String accountHeadName;
	private String description;
	private String subAcctCode;
	private String subAcctName;
	private String narration;
	private Double bcamount;
	private Double tcamount;
	private int slNo;
	private String approvedSign;
	// Account Attributes implementation
	private Double totaltc;
	private Double totalbc;
	private String voyageCode;
	private String voyageCode1;
	private String vesselCode;
	private String vesselName;
	private String sectorCode;
	private String sectorName;
	private String employeeCode;
	private String portCode;
	private String portSequence;
	private String departmentCode;
	private String agentCode;
	private String countryCode;
	private String customerCode;
	private String supplierCode;
	private String designationCode;
	private String costCenter;
	private String companyCode;
	private String quantityGO;
	private String quantityFO;
	private Boolean isVoyage;
	private Boolean isVessel;
	private Double tcAmount;
	private Double bcAmount;
	private Boolean isService;
	private String currencyCode;
	private String currency;
	private Double exchangeRate;
	private String assetCode;
	private Boolean isEmployee;
	private Boolean isPort;
	private Boolean isAgent;
	private Boolean isCompany;
	private Boolean isCostCenter;
	private Boolean isCustomer;
	private Boolean isDepartment;
	private Boolean isDesignation;
	private Boolean isLocation;
	private Boolean isPortSequence;
	private Boolean isQuantityFO;
	private Boolean isQuantityGO;
	private Boolean isSupplier;

	public Boolean getIsAgent() {
		return isAgent;
	}

	public void setIsAgent(Boolean isAgent) {
		this.isAgent = isAgent;
	}

	public Boolean getIsCompany() {
		return isCompany;
	}

	public void setIsCompany(Boolean isCompany) {
		this.isCompany = isCompany;
	}

	public Boolean getIsCostCenter() {
		return isCostCenter;
	}

	public void setIsCostCenter(Boolean isCostCenter) {
		this.isCostCenter = isCostCenter;
	}

	public Boolean getIsCustomer() {
		return isCustomer;
	}

	public void setIsCustomer(Boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	public Boolean getIsDepartment() {
		return isDepartment;
	}

	public void setIsDepartment(Boolean isDepartment) {
		this.isDepartment = isDepartment;
	}

	public Boolean getIsDesignation() {
		return isDesignation;
	}

	public void setIsDesignation(Boolean isDesignation) {
		this.isDesignation = isDesignation;
	}

	public Boolean getIsLocation() {
		return isLocation;
	}

	public void setIsLocation(Boolean isLocation) {
		this.isLocation = isLocation;
	}

	public Boolean getIsPortSequence() {
		return isPortSequence;
	}

	public void setIsPortSequence(Boolean isPortSequence) {
		this.isPortSequence = isPortSequence;
	}

	public Boolean getIsQuantityFO() {
		return isQuantityFO;
	}

	public void setIsQuantityFO(Boolean isQuantityFO) {
		this.isQuantityFO = isQuantityFO;
	}

	public Boolean getIsQuantityGO() {
		return isQuantityGO;
	}

	public void setIsQuantityGO(Boolean isQuantityGO) {
		this.isQuantityGO = isQuantityGO;
	}

	public Boolean getIsSupplier() {
		return isSupplier;
	}

	public void setIsSupplier(Boolean isSupplier) {
		this.isSupplier = isSupplier;
	}

	public Boolean getIsPort() {
		return isPort;
	}

	public void setIsPort(Boolean isPort) {
		this.isPort = isPort;
	}

	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	@AuditLoggable(fieldName = "pur_creditnote_acct_head", displayName = "Account Head")
	public String getCrdtlAccountHead() {
		return crdtlAccountHead;
	}

	public void setCrdtlAccountHead(String crdtlAccountHead) {
		this.crdtlAccountHead = crdtlAccountHead;
	}

	public Boolean getIsVoyage() {
		return isVoyage;
	}

	public void setIsVoyage(Boolean isVoyage) {
		this.isVoyage = isVoyage;
	}

	public Boolean getSelect() {
		return select;
	}

	public void setSelect(Boolean select) {
		this.select = select;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@AuditLoggable(fieldName = "sub_account_code", displayName = "Sub Account")
	public String getSubAcctCode() {
		return subAcctCode;
	}

	public void setSubAcctCode(String subAcctCode) {
		this.subAcctCode = subAcctCode;
	}

	@AuditLoggable(fieldName = "pur_creditnote_narration", displayName = "Narration")
	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	@AuditLoggable(fieldName = "PUR_CREDITNOTE_AMOUNTUSD", displayName = " Amount")
	public Double getBcamount() {
		return bcamount;
	}

	public String getCompany_id_dtl() {
		return company_id_dtl;
	}

	public void setCompany_id_dtl(String company_id_dtl) {
		this.company_id_dtl = company_id_dtl;
	}

	public void setBcamount(Double bcamount) {
		this.bcamount = bcamount;
	}

	@AuditLoggable(fieldName = "PUR_CREDITNOTE_AMOUNT", displayName = "TC Amount")
	public Double getTcamount() {
		return tcamount;
	}

	public void setTcamount(Double tcamount) {
		this.tcamount = tcamount;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public Boolean getIsService() {
		return isService;
	}

	public void setIsService(Boolean isService) {
		this.isService = isService;
	}

	public String getVoyageCode() {
		return voyageCode;
	}

	public void setVoyageCode(String voyageCode) {
		this.voyageCode = voyageCode;
	}

	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getPortCode() {
		return portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	public Boolean getIsVessel() {
		return isVessel;
	}

	public void setIsVessel(Boolean isVessel) {
		this.isVessel = isVessel;
	}

	public String getPortSequence() {
		return portSequence;
	}

	public void setPortSequence(String portSequence) {
		this.portSequence = portSequence;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	@AuditLoggable(fieldName = "company_code", displayName = "Company")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getQuantityGO() {
		return quantityGO;
	}

	public void setQuantityGO(String quantityGO) {
		this.quantityGO = quantityGO;
	}

	public String getQuantityFO() {
		return quantityFO;
	}

	public void setQuantityFO(String quantityFO) {
		this.quantityFO = quantityFO;
	}

	public String getApprovedSign() {
		return approvedSign;
	}

	public void setApprovedSign(String approvedSign) {
		this.approvedSign = approvedSign;
	}

	public Double getTotalbc() {
		return totalbc;
	}

	public void setTotalbc(Double totalbc) {
		this.totalbc = totalbc;
	}

	public Double getTotaltc() {
		return totaltc;
	}

	public void setTotaltc(Double totaltc) {
		this.totaltc = totaltc;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public String getSubAcctName() {
		return subAcctName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public void setSubAcctName(String subAcctName) {
		this.subAcctName = subAcctName;
	}

	public String getVesselName() {
		return vesselName;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public Double getTcAmount() {
		return tcAmount;
	}

	public void setTcAmount(Double tcAmount) {
		this.tcAmount = tcAmount;
	}

	public Double getBcAmount() {
		return bcAmount;
	}

	public void setBcAmount(Double bcAmount) {
		this.bcAmount = bcAmount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getVoyageCode1() {
		return voyageCode1;
	}

	public void setVoyageCode1(String voyageCode1) {
		this.voyageCode1 = voyageCode1;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

}