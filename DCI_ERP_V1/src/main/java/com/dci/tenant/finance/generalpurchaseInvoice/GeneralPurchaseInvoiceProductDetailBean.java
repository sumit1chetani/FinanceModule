package com.dci.tenant.finance.generalpurchaseInvoice;

import java.util.ArrayList;
import java.util.List;

public class GeneralPurchaseInvoiceProductDetailBean {

	private int siNo;
	private int itemId;
	private int quantity;
	private double unitprice;
	private String taxCode;
	private double amount;
	private int discountPercentage;
	private int prodDtlId;
	private String costCenter;
	private double frieghtTotal;
	private double ex_rate;

	public double getEx_rate() {
		return ex_rate;
	}

	public void setEx_rate(double ex_rate) {
		this.ex_rate = ex_rate;
	}

	private int purchaseOrderId;
	private int taxId;
	private int discountType;
	private int vendorQuantity;
	private int convertedQuantity;
	private int purchaseQuanity;
	private int taxAccountId;
	private double discountAmount;
	private double taxAmount;
	private String taxAccountCode;
	private double totalAmount;
	private double productAmount;
	private double unitDiscountAmount;
	private String accountHeadCode;
	private boolean isEmployee;
	private String subaccountHeadCode;
	private String servicedetail;
	private Integer num;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getServicedetail() {
		return servicedetail;
	}

	public void setServicedetail(String servicedetail) {
		this.servicedetail = servicedetail;
	}

	public String getSubaccountHeadCode() {
		return subaccountHeadCode;
	}

	public void setSubaccountHeadCode(String subaccountHeadCode) {
		this.subaccountHeadCode = subaccountHeadCode;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	private ArrayList<String> taxIdslist = new ArrayList<>();
	private ArrayList<GeneralPurchaseInvoiceProductDetailBean> taxAccountList = new ArrayList<>();

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
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

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	private double unitTaxAmount;
	private boolean select;
	private double poTotalAmount;
	private String countryCode;
	private String customerCode;
	private String supplierCode;
	private Integer designationCode;
	private String companyCode;
	private int assetCode;
	private String departmentCode;

	private String employeeCode;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
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

	public double getUnitDiscountAmount() {
		return unitDiscountAmount;
	}

	public void setUnitDiscountAmount(double unitDiscountAmount) {
		this.unitDiscountAmount = unitDiscountAmount;
	}

	public double getUnitTaxAmount() {
		return unitTaxAmount;
	}

	public void setUnitTaxAmount(double unitTaxAmount) {
		this.unitTaxAmount = unitTaxAmount;
	}

	public double getFrieghtTotal() {
		return frieghtTotal;
	}

	public void setFrieghtTotal(double frieghtTotal) {
		this.frieghtTotal = frieghtTotal;
	}

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public double getPoTotalAmount() {
		return poTotalAmount;
	}

	public void setPoTotalAmount(double poTotalAmount) {
		this.poTotalAmount = poTotalAmount;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public ArrayList<String> getTaxIdslist() {
		return taxIdslist;
	}

	public void setTaxIdslist(ArrayList<String> taxIdslist) {
		this.taxIdslist = taxIdslist;
	}

	/**
	 * @return the taxAccountList
	 */
	public ArrayList<GeneralPurchaseInvoiceProductDetailBean> getTaxAccountList() {
		return taxAccountList;
	}

	/**
	 * @param taxAccountList
	 *            the taxAccountList to set
	 */
	public void setTaxAccountList(ArrayList<GeneralPurchaseInvoiceProductDetailBean> taxAccountList) {
		this.taxAccountList = taxAccountList;
	}

	/**
	 * @return the taxAccountId
	 */
	public int getTaxAccountId() {
		return taxAccountId;
	}

	/**
	 * @param taxAccountId
	 *            the taxAccountId to set
	 */
	public void setTaxAccountId(int taxAccountId) {
		this.taxAccountId = taxAccountId;
	}

	/**
	 * @return the vendorQuantity
	 */
	public int getVendorQuantity() {
		return vendorQuantity;
	}

	/**
	 * @param vendorQuantity
	 *            the vendorQuantity to set
	 */
	public void setVendorQuantity(int vendorQuantity) {
		this.vendorQuantity = vendorQuantity;
	}

	/**
	 * @return the purchaseQuanity
	 */
	public int getPurchaseQuanity() {
		return purchaseQuanity;
	}

	/**
	 * @param purchaseQuanity
	 *            the purchaseQuanity to set
	 */
	public void setPurchaseQuanity(int purchaseQuanity) {
		this.purchaseQuanity = purchaseQuanity;
	}

	/**
	 * @return the productAmount
	 */
	public double getProductAmount() {
		return productAmount;
	}

	/**
	 * @param productAmount
	 *            the productAmount to set
	 */
	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}

	/**
	 * @return the convertedQuantity
	 */
	public int getConvertedQuantity() {
		return convertedQuantity;
	}

	/**
	 * @param convertedQuantity
	 *            the convertedQuantity to set
	 */
	public void setConvertedQuantity(int convertedQuantity) {
		this.convertedQuantity = convertedQuantity;
	}

	/**
	 * @return the discountPercentage
	 */
	public int getDiscountPercentage() {
		return discountPercentage;
	}

	/**
	 * @param discountPercentage
	 *            the discountPercentage to set
	 */
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	/**
	 * @return the prodDtlId
	 */
	public int getProdDtlId() {
		return prodDtlId;
	}

	/**
	 * @param prodDtlId
	 *            the prodDtlId to set
	 */
	public void setProdDtlId(int prodDtlId) {
		this.prodDtlId = prodDtlId;
	}

	/**
	 * @return the employeeCode
	 */

	private double ahTotal;
	private List<String> purchaseAHInvoiceDetail;
	private List<GeneralPurchaseInvoiceHeaderBean> itemList;

	private String puchaseInvoiceNo;
	private String puchaseInvoiceDate;
	private String invoiceDueDate;

	private String company;
	private int grnNo;

	private int paymentTerms;
	private String supplier;
	private String currency;
	private double exchangeRate;
	private String partyInvoiceNo;
	private String partyInvoiceDate;
	private String dueDate;
	private String description;
	private double tcamount;
	private double bcamount;
	private double productTotal;
	private double productwithTaxTotal;
	private double chargeTotal;
	private double grantamount;
	private String wotype;
	private String wonumber;

	private Integer patientCode;
	private String purInvoiceNo;
	private Integer costCenterId;
	private String acctHeadCode;
	private String subAccountName;
	private String accountHeadName;

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

	public List<GeneralPurchaseInvoiceHeaderBean> getExchangeRatelist() {
		return exchangeRatelist;
	}

	public void setExchangeRatelist(List<GeneralPurchaseInvoiceHeaderBean> exchangeRatelist) {
		this.exchangeRatelist = exchangeRatelist;
	}

	public List<GeneralPurchaseInvoiceHeaderBean> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<GeneralPurchaseInvoiceHeaderBean> currencyList) {
		this.currencyList = currencyList;
	}

	private List<GeneralPurchaseInvoiceDetailBean> purchaseInvoiceDetail;
	private List<GeneralPurchaseInvoiceProductDetailBean> purchaseInvoiceProdDetail;
	private List<GeneralPurchaseInvoiceHeaderBean> exchangeRatelist;
	private List<GeneralPurchaseInvoiceHeaderBean> currencyList;

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

	public List<GeneralPurchaseInvoiceHeaderBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<GeneralPurchaseInvoiceHeaderBean> itemList) {
		this.itemList = itemList;
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

	public String getInvoiceDueDate() {
		return invoiceDueDate;
	}

	public void setInvoiceDueDate(String invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
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

	public int getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(int paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

	public double getTcamount() {
		return tcamount;
	}

	public void setTcamount(double tcamount) {
		this.tcamount = tcamount;
	}

	public double getBcamount() {
		return bcamount;
	}

	public void setBcamount(double bcamount) {
		this.bcamount = bcamount;
	}

	public double getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(double productTotal) {
		this.productTotal = productTotal;
	}

	public double getProductwithTaxTotal() {
		return productwithTaxTotal;
	}

	public void setProductwithTaxTotal(double productwithTaxTotal) {
		this.productwithTaxTotal = productwithTaxTotal;
	}

	public double getChargeTotal() {
		return chargeTotal;
	}

	public void setChargeTotal(double chargeTotal) {
		this.chargeTotal = chargeTotal;
	}

	public double getGrantamount() {
		return grantamount;
	}

	public void setGrantamount(double grantamount) {
		this.grantamount = grantamount;
	}

	public String getWotype() {
		return wotype;
	}

	public void setWotype(String wotype) {
		this.wotype = wotype;
	}

	public String getWonumber() {
		return wonumber;
	}

	public void setWonumber(String wonumber) {
		this.wonumber = wonumber;
	}

}