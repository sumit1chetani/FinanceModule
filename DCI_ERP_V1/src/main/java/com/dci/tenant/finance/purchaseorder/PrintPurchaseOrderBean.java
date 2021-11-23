package com.dci.tenant.finance.purchaseorder;

import java.util.List;

public class PrintPurchaseOrderBean {

	public String purchaseOrderType;
	public String schoolAddress;
	public String entity;
	public String departmentName;
	public String vendorName;
	public String vendorAddress;
	public String vendorPhone;
	public String vendorEmail;
	public String refNo;
	public String poAmendNo;

	public String getPoAmendNo() {
		return poAmendNo;
	}

	public void setPoAmendNo(String poAmendNo) {
		this.poAmendNo = poAmendNo;
	}

	public String purchaseOrderNo;
	public String budgetHead;
	public String purchaseOrderDate;
	public String deliveryTye;
	public String purchaseOrderValue;
	public String paymentTerm;

	public String terms_Condition;
	public String currencyType;
	public double currency;

	public String requisitionDate;
	public String status;
	private int dicountPercentage;
	private double discountAmount;
	private double taxCGST;
	private double taxSGST;
	private double taxIGST;
	private double taxCGSTinPercent;
	private double taxSGSTinPercent;
	private double taxIGSTinPercent;
	private double vatPercent;
	private int paymentTerms;
	private String locationName;
	private List<PrintPurchaseOrderBean> detailList;
	private String itemName;
	private int serialnumber;
	private int advanceAmount;
	private String preparedBy;
	private String remarks;
	private String amountinWords;
	private String approvedName;
	public String companyId;
	public String organisationName;
	public String costcenter;
	private Integer freightTax;
	private double freightAmount;
	public String reqType;

	private String gstgroupbyPercent;
	private Double gstAmtgroupbyPercent;
	private List<PurchaseOrder> gstgropuList;
	private double fTotal;
	private double roundOf;
	private double totalNetPrice;

	public double getTotalNetPrice() {
		return totalNetPrice;
	}

	public void setTotalNetPrice(double totalNetPrice) {
		this.totalNetPrice = totalNetPrice;
	}

	public double getRoundOf() {
		return roundOf;
	}

	public void setRoundOf(double roundOf) {
		this.roundOf = roundOf;
	}

	public double getfTotal() {
		return fTotal;
	}

	public void setfTotal(double fTotal) {
		this.fTotal = fTotal;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public List<PurchaseOrder> getGstgropuList() {
		return gstgropuList;
	}

	public void setGstgropuList(List<PurchaseOrder> gstgropuList) {
		this.gstgropuList = gstgropuList;
	}

	public String getGstgroupbyPercent() {
		return gstgroupbyPercent;
	}

	public void setGstgroupbyPercent(String gstgroupbyPercent) {
		this.gstgroupbyPercent = gstgroupbyPercent;
	}

	public Double getGstAmtgroupbyPercent() {
		return gstAmtgroupbyPercent;
	}

	public void setGstAmtgroupbyPercent(Double gstAmtgroupbyPercent) {
		this.gstAmtgroupbyPercent = gstAmtgroupbyPercent;
	}

	public Integer getFreightTax() {
		return freightTax;
	}

	public void setFreightTax(Integer freightTax) {
		this.freightTax = freightTax;
	}

	public double getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(double freightAmount) {
		this.freightAmount = freightAmount;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getApprovedName() {
		return approvedName;
	}

	public void setApprovedName(String approvedName) {
		this.approvedName = approvedName;
	}

	public String getAmountinWords() {
		return amountinWords;
	}

	public void setAmountinWords(String amountinWords) {
		this.amountinWords = amountinWords;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public int getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(int advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public int getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(int serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(String requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getTerms_Condition() {
		return terms_Condition;
	}

	public void setTerms_Condition(String terms_Condition) {
		this.terms_Condition = terms_Condition;
	}

	public List<PrintPurchaseOrderBean> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<PrintPurchaseOrderBean> detailList) {
		this.detailList = detailList;
	}

	public String getPurchaseOrderType() {
		return purchaseOrderType;
	}

	public void setPurchaseOrderType(String purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public String getBudgetHead() {
		return budgetHead;
	}

	public void setBudgetHead(String budgetHead) {
		this.budgetHead = budgetHead;
	}

	public String getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(String purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

	public String getDeliveryTye() {
		return deliveryTye;
	}

	public void setDeliveryTye(String deliveryTye) {
		this.deliveryTye = deliveryTye;
	}

	public String getPurchaseOrderValue() {
		return purchaseOrderValue;
	}

	public void setPurchaseOrderValue(String purchaseOrderValue) {
		this.purchaseOrderValue = purchaseOrderValue;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public double getCurrency() {
		return currency;
	}

	public void setCurrency(double currency) {
		this.currency = currency;
	}

	private String purchaseReqNo;
	private String itemDescription;
	private double quantity;
	private Integer uom;
	private String uomName;
	private String altQuantity;
	private double rate;
	private double total;
	private double vat;
	private double discount;
	private double amount;

	private double subTotal;
	private double sgstTax;
	private double cgstTax;
	private double igstTax;

	private double roundOff;
	private double grandTotal;
	private double freightCharges;
	private double otherCharges;
	private String otherChargesRemarks;

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getOtherChargesRemarks() {
		return otherChargesRemarks;
	}

	public void setOtherChargesRemarks(String otherChargesRemarks) {
		this.otherChargesRemarks = otherChargesRemarks;
	}

	public double getFreightCharges() {
		return freightCharges;
	}

	public void setFreightCharges(double freightCharges) {
		this.freightCharges = freightCharges;
	}

	public double getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(double otherCharges) {
		this.otherCharges = otherCharges;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getPurchaseReqNo() {
		return purchaseReqNo;
	}

	public void setPurchaseReqNo(String purchaseReqNo) {
		this.purchaseReqNo = purchaseReqNo;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Integer getUom() {
		return uom;
	}

	public void setUom(Integer uom) {
		this.uom = uom;
	}

	public String getAltQuantity() {
		return altQuantity;
	}

	public void setAltQuantity(String altQuantity) {
		this.altQuantity = altQuantity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getSgstTax() {
		return sgstTax;
	}

	public void setSgstTax(double sgstTax) {
		this.sgstTax = sgstTax;
	}

	public double getCgstTax() {
		return cgstTax;
	}

	public void setCgstTax(double cgstTax) {
		this.cgstTax = cgstTax;
	}

	public double getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(double roundOff) {
		this.roundOff = roundOff;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getDicountPercentage() {
		return dicountPercentage;
	}

	public void setDicountPercentage(int dicountPercentage) {
		this.dicountPercentage = dicountPercentage;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getTaxCGST() {
		return taxCGST;
	}

	public void setTaxCGST(double taxCGST) {
		this.taxCGST = taxCGST;
	}

	public double getTaxSGST() {
		return taxSGST;
	}

	public void setTaxSGST(double taxSGST) {
		this.taxSGST = taxSGST;
	}

	public double getTaxIGST() {
		return taxIGST;
	}

	public void setTaxIGST(double taxIGST) {
		this.taxIGST = taxIGST;
	}

	public double getTaxCGSTinPercent() {
		return taxCGSTinPercent;
	}

	public void setTaxCGSTinPercent(double taxCGSTinPercent) {
		this.taxCGSTinPercent = taxCGSTinPercent;
	}

	public double getTaxSGSTinPercent() {
		return taxSGSTinPercent;
	}

	public void setTaxSGSTinPercent(double taxSGSTinPercent) {
		this.taxSGSTinPercent = taxSGSTinPercent;
	}

	public double getTaxIGSTinPercent() {
		return taxIGSTinPercent;
	}

	public void setTaxIGSTinPercent(double taxIGSTinPercent) {
		this.taxIGSTinPercent = taxIGSTinPercent;
	}

	public double getVatPercent() {
		return vatPercent;
	}

	public void setVatPercent(double vatPercent) {
		this.vatPercent = vatPercent;
	}

	public double getIgstTax() {
		return igstTax;
	}

	public void setIgstTax(double igstTax) {
		this.igstTax = igstTax;
	}

	public int getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(int paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

}
