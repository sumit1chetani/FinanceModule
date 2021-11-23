package com.dci.tenant.finance.generalpurchaseInvoice;

import java.util.List;

public class GeneralPurchaseInvoiceHeaderBean {

	private double ahTotal;
	private List<String> purchaseAHInvoiceDetail;
	private List<GeneralPurchaseInvoiceHeaderBean> itemList;

	private String puchaseInvoiceNo;
	private String puchaseInvoiceDate;
	private String invoiceDueDate;

	private String company;
	private int grnNo;
	private String companyCode;
	private double ex_rate;
	private boolean nonPo;

	public boolean isNonPo() {
		return nonPo;
	}

	public void setNonPo(boolean nonPo) {
		this.nonPo = nonPo;
	}

	public double getEx_rate() {
		return ex_rate;
	}

	public void setEx_rate(double ex_rate) {
		this.ex_rate = ex_rate;
	}

	private int paymentTerms;
	private String supplier;
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
	private boolean isEmployee;
	private String servicedetail;
	private String wotype;
	private String wonumber;
	private int quantity;
	private Integer num;
	private int subGrpCode;

	public int getSubGrpCode() {
		return subGrpCode;
	}

	public void setSubGrpCode(int subGrpCode) {
		this.subGrpCode = subGrpCode;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<GeneralPurchaseInvoiceHeaderBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<GeneralPurchaseInvoiceHeaderBean> itemList) {
		this.itemList = itemList;
	}

	public String getWonumber() {
		return wonumber;
	}

	public void setWonumber(String wonumber) {
		this.wonumber = wonumber;
	}

	private int budgetType;

	// private String invoicedueDate;

	// Account Attributes implementation

	public String getWotype() {
		return wotype;
	}

	public String getServicedetail() {
		return servicedetail;
	}

	public void setServicedetail(String servicedetail) {
		this.servicedetail = servicedetail;
	}

	public int getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(int budgetType) {
		this.budgetType = budgetType;
	}

	public void setWotype(String wotype) {
		this.wotype = wotype;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	/**
	 * 
	 */
	private String departmentCode;

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

	public String getInvoiceDueDate() {
		return invoiceDueDate;
	}

	public void setInvoiceDueDate(String invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}

	private String countryCode;
	private String customerCode;
	private String supplierCode;
	private Integer designationCode;

	private int assetCode;
	private Integer patientCode;
	private String purInvoiceNo;
	private Integer costCenterId;
	private String acctHeadCode;
	private String employeeCode;
	private String subAccountName;
	private String accountHeadName;
	private double poTotalAmount;
	private List<GeneralPurchaseInvoiceProductDetailBean> taxAccountList;
	private List<GeneralPurchaseInvoiceDetailBean> purchaseInvoiceDetail;
	private List<GeneralPurchaseInvoiceProductDetailBean> purchaseInvoiceProdDetail;
	private List<GeneralPurchaseInvoiceHeaderBean> exchangeRatelist;
	private List<GeneralPurchaseInvoiceHeaderBean> currencyList;

	private String grnCode;
	private String paymentStatus;

	private String id;

	private String text;

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

	public List<GeneralPurchaseInvoiceDetailBean> getPurchaseInvoiceDetail() {
		return purchaseInvoiceDetail;
	}

	public void setPurchaseInvoiceDetail(List<GeneralPurchaseInvoiceDetailBean> purchaseInvoiceDetail) {
		this.purchaseInvoiceDetail = purchaseInvoiceDetail;
	}

	public List<GeneralPurchaseInvoiceProductDetailBean> getPurchaseInvoiceProdDetail() {
		return purchaseInvoiceProdDetail;
	}

	public void setPurchaseInvoiceProdDetail(List<GeneralPurchaseInvoiceProductDetailBean> purchaseInvoiceProdDetail) {
		this.purchaseInvoiceProdDetail = purchaseInvoiceProdDetail;
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

	public List<GeneralPurchaseInvoiceHeaderBean> getExchangeRatelist() {
		return exchangeRatelist;
	}

	public void setExchangeRatelist(List<GeneralPurchaseInvoiceHeaderBean> exchangeRatelist) {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPaymentTerms(int paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public List<GeneralPurchaseInvoiceHeaderBean> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<GeneralPurchaseInvoiceHeaderBean> currencyList) {
		this.currencyList = currencyList;
	}

	/**
	 * @return the taxAccountList
	 */
	public List<GeneralPurchaseInvoiceProductDetailBean> getTaxAccountList() {
		return taxAccountList;
	}

	/**
	 * @param taxAccountList
	 *            the taxAccountList to set
	 */
	public void setTaxAccountList(List<GeneralPurchaseInvoiceProductDetailBean> taxAccountList) {
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

	private int siNo;
	private int itemId;
	private double unitprice;
	private String taxCode;
	private int discountPercentage;
	private int prodDtlId;
	private int purchaseOrderId;
	private int taxId;
	private int discountType;
	private int vendorQuantity;
	private int convertedQuantity;
	private int purchaseQuanity;
	private int taxAccountId;

	public double getUnitTaxAmount() {
		return unitTaxAmount;
	}

	public void setUnitTaxAmount(double unitTaxAmount) {
		this.unitTaxAmount = unitTaxAmount;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	private double discountAmount;
	private double taxAmount;
	private String taxAccountCode;
	private double totalAmount;
	private double productAmount;
	private double unitDiscountAmount;
	private String accountHeadCode;
	private String subaccountHeadCode;

	private double unitTaxAmount;
	private boolean select;

	public int getSiNo() {
		return siNo;
	}

	public void setSiNo(int siNo) {
		this.siNo = siNo;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public int getProdDtlId() {
		return prodDtlId;
	}

	public void setProdDtlId(int prodDtlId) {
		this.prodDtlId = prodDtlId;
	}

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public int getVendorQuantity() {
		return vendorQuantity;
	}

	public void setVendorQuantity(int vendorQuantity) {
		this.vendorQuantity = vendorQuantity;
	}

	public int getConvertedQuantity() {
		return convertedQuantity;
	}

	public void setConvertedQuantity(int convertedQuantity) {
		this.convertedQuantity = convertedQuantity;
	}

	public int getPurchaseQuanity() {
		return purchaseQuanity;
	}

	public void setPurchaseQuanity(int purchaseQuanity) {
		this.purchaseQuanity = purchaseQuanity;
	}

	public int getTaxAccountId() {
		return taxAccountId;
	}

	public void setTaxAccountId(int taxAccountId) {
		this.taxAccountId = taxAccountId;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTaxAccountCode() {
		return taxAccountCode;
	}

	public void setTaxAccountCode(String taxAccountCode) {
		this.taxAccountCode = taxAccountCode;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}

	public double getUnitDiscountAmount() {
		return unitDiscountAmount;
	}

	public void setUnitDiscountAmount(double unitDiscountAmount) {
		this.unitDiscountAmount = unitDiscountAmount;
	}

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public String getSubaccountHeadCode() {
		return subaccountHeadCode;
	}

	public void setSubaccountHeadCode(String subaccountHeadCode) {
		this.subaccountHeadCode = subaccountHeadCode;
	}

}
