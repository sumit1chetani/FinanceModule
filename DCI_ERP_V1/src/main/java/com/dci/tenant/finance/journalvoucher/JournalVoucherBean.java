package com.dci.tenant.finance.journalvoucher;

import com.dci.tenant.auditlog.AuditLoggable;

public class JournalVoucherBean {
	private Boolean openingBalance;
	private double ExchangeRate;
	private int slNo;
	private String accountCode;
	private String accountName1;
private String costcenter;
	public Boolean getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Boolean openingBalance) {
		this.openingBalance = openingBalance;
	}

	private String subGroupAccount;
	private String subAccountCode;
	private String subAccountName;
	private String narration;
	private String currency;
	private double exchangeRate;
	private double tcDebitAmount;
	private double bcDebitAmount;
	private double tcCreditAmount;
	private double bcCreditAmount;
	private String jvTypeName;
	private String fromDate;
	private int jvTypeId;
	private String toDate;

	private String subGropAccount;

	private String employeeCode;
	private String departmentCode;
	private String countryCode;
	private String customerCode;
	private String supplierCode;
	private Integer designationCode;
	private String costCenter;
	private String companyCode;
	private Integer patientCode;

	private String bankCenter;

	private double totalTcDebitAmt;
	private double totalBcDebitAmt;
	private double totalTcCreditAmt;
	private double totalBcCreditAmt;
	private double tcAmount;
	private double bcAmount;
	private String id;
	private String text;
	private String journalNo;
	private String jvNumber;
	private String companyName;
	private String accountName;

	private String preparedBy;
	private String quantityFO;
	private String portSequence;
	private String voyageCode;
	private String vesselCode;
	private String assetCode;
	private String jvType;
	private String agentCode;
	private String quantityGO;
	private String portCode;

	public String getPortCode() {
		return portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	private String sectorCode;

	public String getQuantityGO() {
		return quantityGO;
	}

	public void setQuantityGO(String quantityGO) {
		this.quantityGO = quantityGO;
	}

	@AuditLoggable(fieldName = "sectorCode", displayName = "Sector Code")
	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getJvType() {
		return jvType;
	}

	public void setJvType(String jvType) {
		this.jvType = jvType;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	private double total;

	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public String getVoyageCode() {
		return voyageCode;
	}

	public void setVoyageCode(String voyageCode) {
		this.voyageCode = voyageCode;
	}

	public String getPortSequence() {
		return portSequence;
	}

	public void setPortSequence(String portSequence) {
		this.portSequence = portSequence;
	}

	public String getQuantityFO() {
		return quantityFO;
	}

	public void setQuantityFO(String quantityFO) {
		this.quantityFO = quantityFO;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJvNumber() {
		return jvNumber;
	}

	public void setJvNumber(String jvNumber) {
		this.jvNumber = jvNumber;
	}

	public String getJournalNo() {
		return journalNo;
	}

	public void setJournalNo(String journalNo) {
		this.journalNo = journalNo;
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

	public double getTotalTcDebitAmt() {
		return totalTcDebitAmt;
	}

	public void setTotalTcDebitAmt(double totalTcDebitAmt) {
		this.totalTcDebitAmt = totalTcDebitAmt;
	}

	public double getTotalBcDebitAmt() {
		return totalBcDebitAmt;
	}

	public void setTotalBcDebitAmt(double totalBcDebitAmt) {
		this.totalBcDebitAmt = totalBcDebitAmt;
	}

	public double getTotalTcCreditAmt() {
		return totalTcCreditAmt;
	}

	public void setTotalTcCreditAmt(double totalTcCreditAmt) {
		this.totalTcCreditAmt = totalTcCreditAmt;
	}

	public double getTotalBcCreditAmt() {
		return totalBcCreditAmt;
	}

	public void setTotalBcCreditAmt(double totalBcCreditAmt) {
		this.totalBcCreditAmt = totalBcCreditAmt;
	}

	public double getTcAmount() {
		return tcAmount;
	}

	public void setTcAmount(double tcAmount) {
		this.tcAmount = tcAmount;
	}

	public double getBcAmount() {
		return bcAmount;
	}

	public void setBcAmount(double bcAmount) {
		this.bcAmount = bcAmount;
	}

	public String getBankCenter() {
		return bankCenter;
	}

	public void setBankCenter(String bankCenter) {
		this.bankCenter = bankCenter;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getSubAccountCode() {
		return subAccountCode;
	}

	public void setSubAccountCode(String subAccountCode) {
		this.subAccountCode = subAccountCode;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getTcDebitAmount() {
		return tcDebitAmount;
	}

	public void setTcDebitAmount(double tcDebitAmount) {
		this.tcDebitAmount = tcDebitAmount;
	}

	public double getBcDebitAmount() {
		return bcDebitAmount;
	}

	public void setBcDebitAmount(double bcDebitAmount) {
		this.bcDebitAmount = bcDebitAmount;
	}

	public double getTcCreditAmount() {
		return tcCreditAmount;
	}

	public void setTcCreditAmount(double tcCreditAmount) {
		this.tcCreditAmount = tcCreditAmount;
	}

	public double getBcCreditAmount() {
		return bcCreditAmount;
	}

	public void setBcCreditAmount(double bcCreditAmount) {
		this.bcCreditAmount = bcCreditAmount;
	}

	public String getSubGropAccount() {
		return subGropAccount;
	}

	public void setSubGropAccount(String subGropAccount) {
		this.subGropAccount = subGropAccount;
	}

	public String getSubGroupAccount() {
		return subGroupAccount;
	}

	public void setSubGroupAccount(String subGroupAccount) {
		this.subGroupAccount = subGroupAccount;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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

	public Integer getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(Integer designationCode) {
		this.designationCode = designationCode;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Integer getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(Integer patientCode) {
		this.patientCode = patientCode;
	}

	public String getJvTypeName() {
		return jvTypeName;
	}

	public void setJvTypeName(String jvTypeName) {
		this.jvTypeName = jvTypeName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getJvTypeId() {
		return jvTypeId;
	}

	public void setJvTypeId(int jvTypeId) {
		this.jvTypeId = jvTypeId;
	}

	public String getSubAccountName() {
		return subAccountName;
	}

	public void setSubAccountName(String subAccountName) {
		this.subAccountName = subAccountName;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public String getAccountName1() {
		return accountName1;
	}

	public void setAccountName1(String accountName1) {
		this.accountName1 = accountName1;
	}
	
	 

}
