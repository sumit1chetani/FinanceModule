package com.dci.tenant.finance.purchaseorder;

import java.util.ArrayList;

public class PurchaseQuoteDetail {

	private int purchaseQuoteDetailId;
	private String purchaseQuoteId;
	private String edd;
	private int itemId;
	private boolean deliverySchdCount;
	private String tooltipPo;
	private String purchaseItemCode;
	private String purchaseItemName;
	private String purchaseItemDesc;
	private String purchaseStatus;
	private double purchaseQuantity;
	private double vendorQuantity;
	private double tax;
	private String taxCode;
	private String purchaseRequestNum;
	private Double unitPrice;
	private Double oldUnitPrice;
	private int unitDiscount;
	private Double amount;
	private double quantity;
	private String deliveryLeadTime;
	private Double uom;
	private Double price;
	private Double discount;
	private String vendorId;
	private String vendorId1;
	private double finalTotal;
	private String vendorName;
	private int edit;
	private Integer purchaseStatusId;
	private Integer purchaseOrderDetailId;
	private Integer purchaseOrderId;
	private PurchaseOrderQuoteTaxDetail quoteTaxDetail;
	private String uomName;
	private Boolean fixedPrice;
	private Boolean fixedQuantity;
	private Integer pendingQnty;
	private Boolean transfered;
	private Integer frieght;
	private Integer vendorMinQty;
	private Integer paymentTerms;
	private String quoteMaxDate;
	private Double requestedQty;
	private boolean selectedall;
	private Double netPrice;
	private boolean select = false;
	private boolean isSelected = false;
	private String requisitionNo;
	private String duplicateQuantity;

	private int purchaseItemId;

	private boolean isCheck = false;

	private boolean selectCheckBox;
	private String prRequestNo;

	private String purchaseReqQuantity;
	private String vendorUOM;
	private Double taxCGST;
	private Double taxSGST;
	private Double taxIGST;
	private Double taxCGSTinPercent;
	private Double taxSGSTinPercent;
	private Double taxIGSTinPercent;
	public String costcenter;
	private Integer quotationDetailId;
	private Integer quotationId;
	private Integer requisitionId;

	private String eddDate;
	private boolean statuschange;
	private Integer taxId;
	private String ltaxIds;
	private ArrayList<String> taxIdslist = new ArrayList<>();
	private ArrayList<String> taxIdsCodeList = new ArrayList<>();
	private String taxType;
	private String taxName;
	private Integer taxTypeId;
	private int taxAccountId;
	private ArrayList<Object> taxAccountList = new ArrayList<>();
	private Integer discountTypeId;
	private String discountType;
	private Integer percentage;
	private Integer queryStatus;
	// private Double unitPrice;
	private String itemCode;
	private String status;
	private String reqDate;
	private String locationName;
	private String itemName;
	private String itemDescription;
	private int city;
	private String stateCode;
	private String stateName;
	private String cityName;
	private String street;
	private String pincode;
	private String vendorAddress;
	private String country;

	private double taxPercentage;
	private double taxAmount;
	private double disAmt;
	private double taxAmt;
	private double total;

	private Integer subTaxTypeId;
	private String subTaxType;
	private Double subTaxPercentage;
	private Double subTaxAmount;
	private String subTaxTypePercent;
	private String subTaxTypeAmt;
	private Integer statusId;
	private double pendingQty;
	private int pqQuantity;
	private Double discount1;
	private double availableQty;

	private String purchaseUOM;
	private double purchaseQty;
	private String purchaseUOMName;

	private String costCenterName;

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public String getPurchaseUOM() {
		return purchaseUOM;
	}

	public void setPurchaseUOM(String purchaseUOM) {
		this.purchaseUOM = purchaseUOM;
	}

	public double getPurchaseQty() {
		return purchaseQty;
	}

	public void setPurchaseQty(double purchaseQty) {
		this.purchaseQty = purchaseQty;
	}

	public String getPurchaseUOMName() {
		return purchaseUOMName;
	}

	public void setPurchaseUOMName(String purchaseUOMName) {
		this.purchaseUOMName = purchaseUOMName;
	}

	public double getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(double availableQty) {
		this.availableQty = availableQty;
	}

	public double getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(double pendingQty) {
		this.pendingQty = pendingQty;
	}

	public void setPqQuantity(int pqQuantity) {
		this.pqQuantity = pqQuantity;
	}

	public Double getDiscount1() {
		return discount1;
	}

	public void setDiscount1(Double discount1) {
		this.discount1 = discount1;
	}

	public int getPqQuantity() {
		return pqQuantity;
	}

	public Double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
	}

	public Double getTaxCGSTinPercent() {
		return taxCGSTinPercent;
	}

	public void setTaxCGSTinPercent(Double taxCGSTinPercent) {
		this.taxCGSTinPercent = taxCGSTinPercent;
	}

	public Double getTaxSGSTinPercent() {
		return taxSGSTinPercent;
	}

	public void setTaxSGSTinPercent(Double taxSGSTinPercent) {
		this.taxSGSTinPercent = taxSGSTinPercent;
	}

	public Double getTaxIGSTinPercent() {
		return taxIGSTinPercent;
	}

	public void setTaxIGSTinPercent(Double taxIGSTinPercent) {
		this.taxIGSTinPercent = taxIGSTinPercent;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}

	public String getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}

	public Boolean getFixedPrice() {
		return fixedPrice;
	}

	public Boolean getFixedQuantity() {
		return fixedQuantity;
	}

	public String getVendorId1() {
		return vendorId1;
	}

	public void setVendorId1(String vendorId1) {
		this.vendorId1 = vendorId1;
	}

	public int getPurchaseQuoteDetailId() {
		return purchaseQuoteDetailId;
	}

	public void setPurchaseQuoteDetailId(int purchaseQuoteDetailId) {
		this.purchaseQuoteDetailId = purchaseQuoteDetailId;
	}

	public String getPurchaseQuoteId() {
		return purchaseQuoteId;
	}

	public void setPurchaseQuoteId(String purchaseQuoteId) {
		this.purchaseQuoteId = purchaseQuoteId;
	}

	public String getEdd() {
		return edd;
	}

	public void setEdd(String edd) {
		this.edd = edd;
	}

	public String getPurchaseItemCode() {
		return purchaseItemCode;
	}

	public void setPurchaseItemCode(String purchaseItemCode) {
		this.purchaseItemCode = purchaseItemCode;
	}

	public String getPurchaseItemName() {
		return purchaseItemName;
	}

	public void setPurchaseItemName(String purchaseItemName) {
		this.purchaseItemName = purchaseItemName;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getPurchaseItemDesc() {
		return purchaseItemDesc;
	}

	public void setPurchaseItemDesc(String purchaseItemDesc) {
		this.purchaseItemDesc = purchaseItemDesc;
	}

	public String getPurchaseRequestNum() {
		return purchaseRequestNum;
	}

	public void setPurchaseRequestNum(String purchaseRequestNum) {
		this.purchaseRequestNum = purchaseRequestNum;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDeliveryLeadTime() {
		return deliveryLeadTime;
	}

	public void setDeliveryLeadTime(String deliveryLeadTime) {
		this.deliveryLeadTime = deliveryLeadTime;
	}

	public Double getUom() {
		return uom;
	}

	public void setUom(Double uom) {
		this.uom = uom;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/*
	 * public Integer getVendorId() { return vendorId; }
	 * 
	 * public void setVendorId(Integer vendorId) { this.vendorId = vendorId; }
	 */

	public String getVendorName() {
		return vendorName;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Integer getPurchaseStatusId() {
		return purchaseStatusId;
	}

	public void setPurchaseStatusId(Integer purchaseStatusId) {
		this.purchaseStatusId = purchaseStatusId;
	}

	public Integer getPurchaseOrderDetailId() {
		return purchaseOrderDetailId;
	}

	public void setPurchaseOrderDetailId(Integer purchaseOrderDetailId) {
		this.purchaseOrderDetailId = purchaseOrderDetailId;
	}

	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public PurchaseOrderQuoteTaxDetail getQuoteTaxDetail() {
		return quoteTaxDetail;
	}

	public void setQuoteTaxDetail(PurchaseOrderQuoteTaxDetail quoteTaxDetail) {
		this.quoteTaxDetail = quoteTaxDetail;
	}

	public int getEdit() {
		return edit;
	}

	public void setEdit(int edit) {
		this.edit = edit;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public boolean isFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(Boolean fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public boolean isFixedQuantity() {
		return fixedQuantity;
	}

	public void setFixedQuantity(Boolean fixedQuantity) {
		this.fixedQuantity = fixedQuantity;
	}

	public Integer getPendingQnty() {
		return pendingQnty;
	}

	public void setPendingQnty(Integer pendingQnty) {
		this.pendingQnty = pendingQnty;
	}

	public Boolean getTransfered() {
		return transfered;
	}

	public void setTransfered(Boolean transfered) {
		this.transfered = transfered;
	}

	public Integer getVendorMinQty() {
		return vendorMinQty;
	}

	public void setVendorMinQty(Integer vendorMinQty) {
		this.vendorMinQty = vendorMinQty;
	}

	public Integer getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(Integer paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getQuoteMaxDate() {
		return quoteMaxDate;
	}

	public void setQuoteMaxDate(String quoteMaxDate) {
		this.quoteMaxDate = quoteMaxDate;
	}

	public Double getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(Double requestedQty) {
		this.requestedQty = requestedQty;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isSelectedall() {
		return selectedall;
	}

	public void setSelectedall(boolean selectedall) {
		this.selectedall = selectedall;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public String getDuplicateQuantity() {
		return duplicateQuantity;
	}

	public void setDuplicateQuantity(String duplicateQuantity) {
		this.duplicateQuantity = duplicateQuantity;
	}

	public Integer getFrieght() {
		return frieght;
	}

	public void setFrieght(Integer frieght) {
		this.frieght = frieght;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public boolean isDeliverySchdCount() {
		return deliverySchdCount;
	}

	public void setDeliverySchdCount(boolean deliverySchdCount) {
		this.deliverySchdCount = deliverySchdCount;
	}

	public String getTooltipPo() {
		return tooltipPo;
	}

	public void setTooltipPo(String tooltipPo) {
		this.tooltipPo = tooltipPo;
	}

	public Double getOldUnitPrice() {
		return oldUnitPrice;
	}

	public void setOldUnitPrice(Double oldUnitPrice) {
		this.oldUnitPrice = oldUnitPrice;
	}

	/**
	 * @return the purchaseQuantity
	 */

	/**
	 * @return the vendorQuantity
	 */

	/**
	 * @return the unitDiscount
	 */
	public int getUnitDiscount() {
		return unitDiscount;
	}

	public double getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(double purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public double getVendorQuantity() {
		return vendorQuantity;
	}

	public void setVendorQuantity(double vendorQuantity) {
		this.vendorQuantity = vendorQuantity;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param unitDiscount
	 *            the unitDiscount to set
	 */
	public void setUnitDiscount(int unitDiscount) {
		this.unitDiscount = unitDiscount;
	}

	// PO

	public int getPurchaseItemId() {
		return purchaseItemId;
	}

	public void setPurchaseItemId(int purchaseItemId) {
		this.purchaseItemId = purchaseItemId;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public boolean isSelectCheckBox() {
		return selectCheckBox;
	}

	public void setSelectCheckBox(boolean selectCheckBox) {
		this.selectCheckBox = selectCheckBox;
	}

	public String getPrRequestNo() {
		return prRequestNo;
	}

	public void setPrRequestNo(String prRequestNo) {
		this.prRequestNo = prRequestNo;
	}

	public String getPurchaseReqQuantity() {
		return purchaseReqQuantity;
	}

	public void setPurchaseReqQuantity(String purchaseReqQuantity) {
		this.purchaseReqQuantity = purchaseReqQuantity;
	}

	public String getVendorUOM() {
		return vendorUOM;
	}

	public void setVendorUOM(String vendorUOM) {
		this.vendorUOM = vendorUOM;
	}

	public Double getTaxCGST() {
		return taxCGST;
	}

	public void setTaxCGST(Double taxCGST) {
		this.taxCGST = taxCGST;
	}

	public Double getTaxSGST() {
		return taxSGST;
	}

	public void setTaxSGST(Double taxSGST) {
		this.taxSGST = taxSGST;
	}

	public Double getTaxIGST() {
		return taxIGST;
	}

	public void setTaxIGST(Double taxIGST) {
		this.taxIGST = taxIGST;
	}

	public Integer getQuotationDetailId() {
		return quotationDetailId;
	}

	public void setQuotationDetailId(Integer quotationDetailId) {
		this.quotationDetailId = quotationDetailId;
	}

	public Integer getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Integer quotationId) {
		this.quotationId = quotationId;
	}

	public Integer getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(Integer requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getEddDate() {
		return eddDate;
	}

	public void setEddDate(String eddDate) {
		this.eddDate = eddDate;
	}

	public boolean isStatuschange() {
		return statuschange;
	}

	public void setStatuschange(boolean statuschange) {
		this.statuschange = statuschange;
	}

	public Integer getTaxId() {
		return taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public String getLtaxIds() {
		return ltaxIds;
	}

	public void setLtaxIds(String ltaxIds) {
		this.ltaxIds = ltaxIds;
	}

	public ArrayList<String> getTaxIdslist() {
		return taxIdslist;
	}

	public void setTaxIdslist(ArrayList<String> taxIdslist) {
		this.taxIdslist = taxIdslist;
	}

	public ArrayList<String> getTaxIdsCodeList() {
		return taxIdsCodeList;
	}

	public void setTaxIdsCodeList(ArrayList<String> taxIdsCodeList) {
		this.taxIdsCodeList = taxIdsCodeList;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public Integer getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(Integer taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public int getTaxAccountId() {
		return taxAccountId;
	}

	public void setTaxAccountId(int taxAccountId) {
		this.taxAccountId = taxAccountId;
	}

	public ArrayList<Object> getTaxAccountList() {
		return taxAccountList;
	}

	public void setTaxAccountList(ArrayList<Object> taxAccountList) {
		this.taxAccountList = taxAccountList;
	}

	public Integer getDiscountTypeId() {
		return discountTypeId;
	}

	public void setDiscountTypeId(Integer discountTypeId) {
		this.discountTypeId = discountTypeId;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Integer getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(Integer queryStatus) {
		this.queryStatus = queryStatus;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getDisAmt() {
		return disAmt;
	}

	public void setDisAmt(double disAmt) {
		this.disAmt = disAmt;
	}

	public double getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(double taxAmt) {
		this.taxAmt = taxAmt;
	}

	public Integer getSubTaxTypeId() {
		return subTaxTypeId;
	}

	public void setSubTaxTypeId(Integer subTaxTypeId) {
		this.subTaxTypeId = subTaxTypeId;
	}

	public String getSubTaxType() {
		return subTaxType;
	}

	public void setSubTaxType(String subTaxType) {
		this.subTaxType = subTaxType;
	}

	public Double getSubTaxPercentage() {
		return subTaxPercentage;
	}

	public void setSubTaxPercentage(Double subTaxPercentage) {
		this.subTaxPercentage = subTaxPercentage;
	}

	public Double getSubTaxAmount() {
		return subTaxAmount;
	}

	public void setSubTaxAmount(Double subTaxAmount) {
		this.subTaxAmount = subTaxAmount;
	}

	public String getSubTaxTypePercent() {
		return subTaxTypePercent;
	}

	public void setSubTaxTypePercent(String subTaxTypePercent) {
		this.subTaxTypePercent = subTaxTypePercent;
	}

	public String getSubTaxTypeAmt() {
		return subTaxTypeAmt;
	}

	public void setSubTaxTypeAmt(String subTaxTypeAmt) {
		this.subTaxTypeAmt = subTaxTypeAmt;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

}
