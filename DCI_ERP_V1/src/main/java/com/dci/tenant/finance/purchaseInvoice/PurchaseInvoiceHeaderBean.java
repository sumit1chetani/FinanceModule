package com.dci.tenant.finance.purchaseInvoice;

import java.util.List;

public class PurchaseInvoiceHeaderBean {

	private double ahTotal;
	private List<String> purchaseAHInvoiceDetail;
	public String potype;
	public String budgetType;
	private String puchaseInvoiceNo;
	private String puchaseInvoiceDate;
	private String company;
	private int grnNo;
	private int paymentTerms;
	private String supplier;

	public String getPotype() {
		return potype;
	}

	public void setPotype(String potype) {
		this.potype = potype;
	}

	public String getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(String budgetType) {
		this.budgetType = budgetType;
	}

	private double frieghtTotal;
	private String currency;
	private Double exchangeRate;
	private String partyInvoiceNo;
	private String partyInvoiceDate;
	private String dueDate;
	private String description;
	private String costCenter;
	private double amount;
	private double tcamount;
	private double bcamount;
	private double productTotal;
	private double productwithTaxTotal;
	private double chargeTotal;
	private double grantamount;
	private double ahamount;
	private String ahshortDetail;

	private String grnNumber;

	private double totalTaxPo;
	private double grantamountGst;
	private double discountAmount;

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getTotalTaxPo() {
		return totalTaxPo;
	}

	public void setTotalTaxPo(double totalTaxPo) {
		this.totalTaxPo = totalTaxPo;
	}

	public double getGrantamountGst() {
		return grantamountGst;
	}

	public void setGrantamountGst(double grantamountGst) {
		this.grantamountGst = grantamountGst;
	}

	public String getGrnNumber() {
		return grnNumber;
	}

	public void setGrnNumber(String grnNumber) {
		this.grnNumber = grnNumber;
	}

	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	private String departmentCode;

	public String getAhshortDetail() {
		return ahshortDetail;
	}

	public void setAhshortDetail(String ahshortDetail) {
		this.ahshortDetail = ahshortDetail;
	}

	public double getAhamount() {
		return ahamount;
	}

	public void setAhamount(double ahamount) {
		this.ahamount = ahamount;
	}

	public double getAhTotal() {
		return ahTotal;
	}

	public void setAhTotal(double ahTotal) {
		this.ahTotal = ahTotal;
	}

	public List<String> getPurchaseAHInvoiceDetail() {
		return purchaseAHInvoiceDetail;
	}

	public void setPurchaseAHInvoiceDetail(List<String> purchaseAHInvoiceDetail) {
		this.purchaseAHInvoiceDetail = purchaseAHInvoiceDetail;
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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public int getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(int assetCode) {
		this.assetCode = assetCode;
	}

	public Integer getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(Integer patientCode) {
		this.patientCode = patientCode;
	}

	public String getPurInvoiceNo() {
		return purInvoiceNo;
	}

	public void setPurInvoiceNo(String purInvoiceNo) {
		this.purInvoiceNo = purInvoiceNo;
	}

	public Integer getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(Integer costCenterId) {
		this.costCenterId = costCenterId;
	}

	public String getAcctHeadCode() {
		return acctHeadCode;
	}

	public void setAcctHeadCode(String acctHeadCode) {
		this.acctHeadCode = acctHeadCode;
	}

	public String getSubAccountName() {
		return subAccountName;
	}

	public void setSubAccountName(String subAccountName) {
		this.subAccountName = subAccountName;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	private String countryCode;
	private String customerCode;
	private String supplierCode;
	private Integer designationCode;
	private String companyCode;
	private int assetCode;
	private Integer patientCode;
	private String purInvoiceNo;
	private Integer costCenterId;
	private Integer costdtl;
	private String acctHeadCode;
	private String employeeCode;
	private String subAccountName;
	private String accountHeadName;
	private double poTotalAmount;
	private List<PurchaseInvoiceProductDetailBean> taxAccountList;
	private List<PurchaseInvoiceDetailBean> purchaseInvoiceDetail;
	private List<PurchaseInvoiceProductDetailBean> purchaseInvoiceProdDetail;
	private List<PurchaseInvoiceHeaderBean> exchangeRatelist;
	private List<PurchaseInvoiceHeaderBean> currencyList;
	private List<PurchaseInvoiceHeaderBean> excelUpload;

	private List<PurchaseInvoiceDetailBean> purchaseInvoiceDetailacct;

	public List<PurchaseInvoiceDetailBean> getPurchaseInvoiceDetailacct() {
		return purchaseInvoiceDetailacct;
	}

	public void setPurchaseInvoiceDetailacct(List<PurchaseInvoiceDetailBean> purchaseInvoiceDetailacct) {
		this.purchaseInvoiceDetailacct = purchaseInvoiceDetailacct;
	}

	private String grnCode;
	private String paymentStatus;

	private String id;
	private String text;
	private String accountHeadCode;
	private String narration;
	private double detailAmount;
	private String subGrpCode;

	public String getSubGrpCode() {
		return subGrpCode;
	}

	public void setSubGrpCode(String subGrpCode) {
		this.subGrpCode = subGrpCode;
	}

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public double getDetailAmount() {
		return detailAmount;
	}

	public void setDetailAmount(double detailAmount) {
		this.detailAmount = detailAmount;
	}

	public List<PurchaseInvoiceHeaderBean> getExcelUpload() {
		return excelUpload;
	}

	public void setExcelUpload(List<PurchaseInvoiceHeaderBean> excelUpload) {
		this.excelUpload = excelUpload;
	}

	public String getGrnCode() {
		return grnCode;
	}

	public void setGrnCode(String grnCode) {
		this.grnCode = grnCode;
	}

	public String getPuchaseInvoiceNo() {
		return puchaseInvoiceNo;
	}

	public void setPuchaseInvoiceNo(String puchaseInvoiceNo) {
		this.puchaseInvoiceNo = puchaseInvoiceNo;
	}

	public String getPuchaseInvoiceDate() {
		return puchaseInvoiceDate;
	}

	public void setPuchaseInvoiceDate(String puchaseInvoiceDate) {
		this.puchaseInvoiceDate = puchaseInvoiceDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(int grnNo) {
		this.grnNo = grnNo;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getPartyInvoiceNo() {
		return partyInvoiceNo;
	}

	public void setPartyInvoiceNo(String partyInvoiceNo) {
		this.partyInvoiceNo = partyInvoiceNo;
	}

	public String getPartyInvoiceDate() {
		return partyInvoiceDate;
	}

	public void setPartyInvoiceDate(String partyInvoiceDate) {
		this.partyInvoiceDate = partyInvoiceDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getGrantamount() {
		return grantamount;
	}

	public void setGrantamount(double grantamount) {
		this.grantamount = grantamount;
	}

	public List<PurchaseInvoiceDetailBean> getPurchaseInvoiceDetail() {
		return purchaseInvoiceDetail;
	}

	public void setPurchaseInvoiceDetail(List<PurchaseInvoiceDetailBean> purchaseInvoiceDetail) {
		this.purchaseInvoiceDetail = purchaseInvoiceDetail;
	}

	public List<PurchaseInvoiceProductDetailBean> getPurchaseInvoiceProdDetail() {
		return purchaseInvoiceProdDetail;
	}

	public void setPurchaseInvoiceProdDetail(List<PurchaseInvoiceProductDetailBean> purchaseInvoiceProdDetail) {
		this.purchaseInvoiceProdDetail = purchaseInvoiceProdDetail;
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

	public double getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(double productTotal) {
		this.productTotal = productTotal;
	}

	public double getChargeTotal() {
		return chargeTotal;
	}

	public void setChargeTotal(double chargeTotal) {
		this.chargeTotal = chargeTotal;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getTcamount() {
		return tcamount;
	}

	public void setTcamount(double tcamount) {
		this.tcamount = tcamount;
	}

	public double getProductwithTaxTotal() {
		return productwithTaxTotal;
	}

	public void setProductwithTaxTotal(double productwithTaxTotal) {
		this.productwithTaxTotal = productwithTaxTotal;
	}

	public double getFrieghtTotal() {
		return frieghtTotal;
	}

	public void setFrieghtTotal(double frieghtTotal) {
		this.frieghtTotal = frieghtTotal;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getPoTotalAmount() {
		return poTotalAmount;
	}

	public void setPoTotalAmount(double poTotalAmount) {
		this.poTotalAmount = poTotalAmount;
	}

	public List<PurchaseInvoiceHeaderBean> getExchangeRatelist() {
		return exchangeRatelist;
	}

	public void setExchangeRatelist(List<PurchaseInvoiceHeaderBean> exchangeRatelist) {
		this.exchangeRatelist = exchangeRatelist;
	}

	public double getBcamount() {
		return bcamount;
	}

	public void setBcamount(double bcamount) {
		this.bcamount = bcamount;
	}

	public int getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(int paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public List<PurchaseInvoiceHeaderBean> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<PurchaseInvoiceHeaderBean> currencyList) {
		this.currencyList = currencyList;
	}

	/**
	 * @return the taxAccountList
	 */
	public List<PurchaseInvoiceProductDetailBean> getTaxAccountList() {
		return taxAccountList;
	}

	/**
	 * @param taxAccountList
	 *            the taxAccountList to set
	 */
	public void setTaxAccountList(List<PurchaseInvoiceProductDetailBean> taxAccountList) {
		this.taxAccountList = taxAccountList;
	}

	/**
	 * @return the employeeCode
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * @param employeeCode
	 *            the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Integer getCostdtl() {
		return costdtl;
	}

	public void setCostdtl(Integer costdtl) {
		this.costdtl = costdtl;
	}

}
