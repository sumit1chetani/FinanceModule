package com.dci.tenant.finance.purchaseInvoice;

import java.util.ArrayList;

public class PurchaseInvoiceProductDetailBean {

	private int siNo;
	private int itemId;
	private int quantity;
	private double unitprice;
	private String taxCode;
	private double amount;
	private int discountPercentage;
	private int prodDtlId;
	private String costCenter;
	private Integer costdtl;

	private double frieghtTotal;
	private String puchaseInvoiceNo;

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
	private double ahamount;

	private double totalTaxPo;
	private double grantamountGst;

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

	private ArrayList<String> taxIdslist = new ArrayList<>();
	private ArrayList<PurchaseInvoiceProductDetailBean> taxAccountList = new ArrayList<>();

	public double getAhamount() {
		return ahamount;
	}

	public void setAhamount(double ahamount) {
		this.ahamount = ahamount;
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
	public ArrayList<PurchaseInvoiceProductDetailBean> getTaxAccountList() {
		return taxAccountList;
	}

	/**
	 * @param taxAccountList
	 *            the taxAccountList to set
	 */
	public void setTaxAccountList(ArrayList<PurchaseInvoiceProductDetailBean> taxAccountList) {
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

	public Integer getCostdtl() {
		return costdtl;
	}

	public void setCostdtl(Integer costdtl) {
		this.costdtl = costdtl;
	}

	public String getPuchaseInvoiceNo() {
		return puchaseInvoiceNo;
	}

	public void setPuchaseInvoiceNo(String puchaseInvoiceNo) {
		this.puchaseInvoiceNo = puchaseInvoiceNo;
	}

	/**
	 * @return the employeeCode
	 */

}
