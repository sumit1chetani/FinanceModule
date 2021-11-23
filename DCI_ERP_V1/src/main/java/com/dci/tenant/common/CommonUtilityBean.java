package com.dci.tenant.common;

import java.io.Serializable;

public class CommonUtilityBean implements Serializable {

	private String mloName;
	private String mloShortName;
	private String sectorCode;
	private String sectorName;
	private String portCode;
	private String accountHeadCode;
	private String accountHeadName;
	private String currencyCode;
	private double fromCurrency;
	private double toCurrency;
	private double exchangeRate;
	private String id;
	private String text;
	private String baseCompany;
	private String paymentTerm;
	private String portseq;
	private String vesselCode;
	private String rotationNo;
	private boolean success;
	private String isAgent;
	private String surchareId;
	private String subject;
	private Integer stockQty;
	private String terminalCode;
	private String sectorId;
private String  codeAndName;
	private String mloId;
	private String condition;
	
	//work flow beans
	
	private String empReportingPerson;
	private String empDesignation;
	private String empDepartment;
	private String empBranch;
	private String approveType;
	private String roleNameUser;
	private Integer stepOrder; 
	private String stepName;
	private String paramName;
	private String oldValue;
	private String newValue;
	private String formfield;
	private String screenName;
	private String subaccountcode;
	private String subaccountname;
	

	public String getSubAccountCode() {
		return subAccountCode;
	}

	public void setSubAccountCode(String subAccountCode) {
		this.subAccountCode = subAccountCode;
	}

	public String getSubAccountName() {
		return subAccountName;
	}

	public void setSubAccountName(String subAccountName) {
		this.subAccountName = subAccountName;
	}

	public Boolean getIsBatchNoExist() {
		return isBatchNoExist;
	}

	public void setIsBatchNoExist(Boolean isBatchNoExist) {
		this.isBatchNoExist = isBatchNoExist;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAssetQty() {
		return assetQty;
	}

	public void setAssetQty(Integer assetQty) {
		this.assetQty = assetQty;
	}

	private String subAccountCode;
	private String subAccountName;


	private Boolean isBatchNoExist;


	private String designationName;
	private String value;
	private String description;

	private Integer assetQty;
	
	public String getParamName() {
		return paramName;
	}

	public String getFormfield() {
		return formfield;
	}

	public void setFormfield(String formfield) {
		this.formfield = formfield;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}

	public String getRoleNameUser() {
		return roleNameUser;
	}

	public void setRoleNameUser(String roleNameUser) {
		this.roleNameUser = roleNameUser;
	}

	public Integer getStepOrder() {
		return stepOrder;
	}

	public void setStepOrder(Integer stepOrder) {
		this.stepOrder = stepOrder;
	}

	public String getEmpReportingPerson() {
		return empReportingPerson;
	}

	public void setEmpReportingPerson(String empReportingPerson) {
		this.empReportingPerson = empReportingPerson;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getEmpBranch() {
		return empBranch;
	}

	public void setEmpBranch(String empBranch) {
		this.empBranch = empBranch;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public String getMloId() {
		return mloId;
	}

	public void setMloId(String mloId) {
		this.mloId = mloId;
	}

	public Integer getStockQty() {
		return stockQty;
	}

	public void setStockQty(Integer stockQty) {
		this.stockQty = stockQty;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getMloName() {
		return mloName;
	}

	public void setMloName(String mloName) {
		this.mloName = mloName;
	}

	public String getMloShortName() {
		return mloShortName;
	}

	public void setMloShortName(String mloShortName) {
		this.mloShortName = mloShortName;
	}

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
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

	public String getPortCode() {
		return portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	public String getBaseCompany() {
		return baseCompany;
	}

	public void setBaseCompany(String baseCompany) {
		this.baseCompany = baseCompany;
	}

	public String getPortseq() {
		return portseq;
	}

	public void setPortseq(String portseq) {
		this.portseq = portseq;
	}

	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public String getRotationNo() {
		return rotationNo;
	}

	public void setRotationNo(String rotationNo) {
		this.rotationNo = rotationNo;
	}

	public double getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(double fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public double getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(double toCurrency) {
		this.toCurrency = toCurrency;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getIsAgent() {
		return isAgent;
	}

	public void setIsAgent(String isAgent) {
		this.isAgent = isAgent;
	}

	public String getSurchareId() {
		return surchareId;
	}

	public void setSurchareId(String surchareId) {
		this.surchareId = surchareId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getCodeAndName() {
		return codeAndName;
	}

	public void setCodeAndName(String codeAndName) {
		this.codeAndName = codeAndName;
	}

	public String getSubaccountcode() {
		return subaccountcode;
	}

	public void setSubaccountcode(String subaccountcode) {
		this.subaccountcode = subaccountcode;
	}

	public String getSubaccountname() {
		return subaccountname;
	}

	public void setSubaccountname(String subaccountname) {
		this.subaccountname = subaccountname;
	}

	
	
	
}
