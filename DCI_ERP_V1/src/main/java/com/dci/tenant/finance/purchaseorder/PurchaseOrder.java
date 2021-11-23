package com.dci.tenant.finance.purchaseorder;

import java.util.List;

public class PurchaseOrder {

	private int purchaseOrderId;
	private PurchaseOrder splittedPurchaseOrderbean;
	private String purchaseOrderNum;
	private String purchaseOrderDate;
	private int purchaseFor;
	private String reqType;
	private int purchaseType;
	private String companyId;
	private String costcenter;
	private String vendorId;
	private boolean isCheck = false;
	private int locationId;
	private Integer statusId;
	private String termsCondition;
	private String remarks;
	private String remarksforother;
	private String purchaseForName;
	private String purchaseTypeName;
	private String companyName;
	private String vendorName;
	private String locationName;
	private String purchaseStatus;
	private Double subTotal;
	private Double totalDiscount;
	private Double totalTax;
	private Double freight;
	private Double freightTax;
	private Double freightAmount;
	private String gstgroupbyPercent;
	private double gstAmtgroupbyPercent;
	private String poAmendmentNovalid;
	private String budgetTypeName;
	private String statusName;
	private String currencyName;
	private String costcenterName;
	private String deliverySchedule;
	private int count;
	private double amount;
	private double budgetAmt;

	private double budgetUtilizedAmt;

	private double budgetBalAmt;

	private String createdDate;

	private String modifiedDate;

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

	public String getPurchaseUOMName() {
		return purchaseUOMName;
	}

	public void setPurchaseUOMName(String purchaseUOMName) {
		this.purchaseUOMName = purchaseUOMName;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public double getBudgetAmt() {
		return budgetAmt;
	}

	public void setBudgetAmt(double budgetAmt) {
		this.budgetAmt = budgetAmt;
	}

	public double getBudgetUtilizedAmt() {
		return budgetUtilizedAmt;
	}

	public void setBudgetUtilizedAmt(double budgetUtilizedAmt) {
		this.budgetUtilizedAmt = budgetUtilizedAmt;
	}

	public double getBudgetBalAmt() {
		return budgetBalAmt;
	}

	public void setBudgetBalAmt(double budgetBalAmt) {
		this.budgetBalAmt = budgetBalAmt;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDeliverySchedule() {
		return deliverySchedule;
	}

	public void setDeliverySchedule(String deliverySchedule) {
		this.deliverySchedule = deliverySchedule;
	}

	public String getCostcenterName() {
		return costcenterName;
	}

	public void setCostcenterName(String costcenterName) {
		this.costcenterName = costcenterName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getBudgetTypeName() {
		return budgetTypeName;
	}

	public void setBudgetTypeName(String budgetTypeName) {
		this.budgetTypeName = budgetTypeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getPoAmendmentNovalid() {
		return poAmendmentNovalid;
	}

	public void setPoAmendmentNovalid(String poAmendmentNovalid) {
		this.poAmendmentNovalid = poAmendmentNovalid;
	}

	public double getGstAmtgroupbyPercent() {
		return gstAmtgroupbyPercent;
	}

	public void setGstAmtgroupbyPercent(double gstAmtgroupbyPercent) {
		this.gstAmtgroupbyPercent = gstAmtgroupbyPercent;
	}

	public String getGstgroupbyPercent() {
		return gstgroupbyPercent;
	}

	public void setGstgroupbyPercent(String gstgroupbyPercent) {
		this.gstgroupbyPercent = gstgroupbyPercent;
	}

	public Double getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(Double freightAmount) {
		this.freightAmount = freightAmount;
	}

	public Double getFreightTax() {
		return freightTax;
	}

	public void setFreightTax(Double freightTax) {
		this.freightTax = freightTax;
	}

	private int itemId;
	private String itemDescription;
	private Double totalAmount;
	private Integer conTransNo;
	private Integer detailQuantity;
	private String detailItemName;
	private Integer paymentTerms;
	private String userName;
	private String userId;
	private String recmndDate;
	private String recmndremarks;
	private String recmmendedBy;
	private boolean isSelected = false;
	private boolean isdelSelected;
	// private String VendorAddress;
	private String vendorCityId;
	private List<PurchaseOrderDetail> purchaseOrderUpdateList;
	private List<RateContractDetail> isDeletedIds;
	private List<RateContractDetail> isOrderIds;
	private List<PurchaseOrderDetail> purchaseOrderDetails;
	private List<PurchaseQuoteDetail> purchaseQuoteDetails;
	private List<RateContractDetail> rateContractDetails;
	private List<PurchaseOrderDetail> quotationDetailList;
	private List<PurchaseOrder> vendordetailList;
	private List<PurchaseOrder> gstgropuList;
	private String potype;
	private Boolean isEdit = false;
	private Boolean isDelete = false;
	private Boolean isView = false;
	private Boolean isPrint = true;

	private boolean select = false;
	private Double totalTaxCGST;
	private Double totalTaxSGST;
	private Double totalTaxIGST;

	private Double duplicateFreight;
	private String reason_for_amendment;
	private Double advanceamt;
	private Double otherCharges;
	private String purchaseRequisitionNO;
	private List<PurchaseOrder> itemList;
	private String prnumber;
	private String currency;
	private String poAmendmentNo;
	private int budgetType;
	private double checkqty;

	// private String vendorName;

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public double getCheckqty() {
		return checkqty;
	}

	public void setCheckqty(double checkqty) {
		this.checkqty = checkqty;
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

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(int budgetType) {
		this.budgetType = budgetType;
	}

	public String getPoAmendmentNo() {
		return poAmendmentNo;
	}

	public void setPoAmendmentNo(String poAmendmentNo) {
		this.poAmendmentNo = poAmendmentNo;
	}

	public String getRemarksforother() {
		return remarksforother;
	}

	public void setRemarksforother(String remarksforother) {
		this.remarksforother = remarksforother;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(Double otherCharges) {
		this.otherCharges = otherCharges;
	}

	public String getPrnumber() {
		return prnumber;
	}

	public void setPrnumber(String prnumber) {
		this.prnumber = prnumber;
	}

	public List<PurchaseOrder> getItemList() {
		return itemList;
	}

	public void setItemList(List<PurchaseOrder> itemList) {
		this.itemList = itemList;
	}

	public String getPurchaseRequisitionNO() {
		return purchaseRequisitionNO;
	}

	public void setPurchaseRequisitionNO(String purchaseRequisitionNO) {
		this.purchaseRequisitionNO = purchaseRequisitionNO;
	}

	/*
	 * public String getOtherCharges() { return otherCharges; }
	 * 
	 * public void setOtherCharges(String otherCharges) { this.otherCharges =
	 * otherCharges; }
	 */
	public Double getTotalTaxCGST() {
		return totalTaxCGST;
	}

	public void setTotalTaxCGST(Double totalTaxCGST) {
		this.totalTaxCGST = totalTaxCGST;
	}

	public Double getTotalTaxSGST() {
		return totalTaxSGST;
	}

	public void setTotalTaxSGST(Double totalTaxSGST) {
		this.totalTaxSGST = totalTaxSGST;
	}

	public Double getTotalTaxIGST() {
		return totalTaxIGST;
	}

	public void setTotalTaxIGST(Double totalTaxIGST) {
		this.totalTaxIGST = totalTaxIGST;
	}

	public String getPotype() {
		return potype;
	}

	public void setPotype(String potype) {
		this.potype = potype;
	}

	public String getVendorCityId() {
		return vendorCityId;
	}

	public void setVendorCityId(String vendorCityId) {
		this.vendorCityId = vendorCityId;
	}

	public List<PurchaseOrder> getVendordetailList() {
		return vendordetailList;
	}

	public void setVendordetailList(List<PurchaseOrder> vendordetailList) {
		this.vendordetailList = vendordetailList;
	}

	public Double getAdvanceamt() {
		return advanceamt;
	}

	public void setAdvanceamt(Double advanceamt) {
		this.advanceamt = advanceamt;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getPurchaseOrderNum() {
		return purchaseOrderNum;
	}

	public void setPurchaseOrderNum(String purchaseOrderNum) {
		this.purchaseOrderNum = purchaseOrderNum;
	}

	public String getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(String purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

	public int getPurchaseFor() {
		return purchaseFor;
	}

	public void setPurchaseFor(int purchaseFor) {
		this.purchaseFor = purchaseFor;
	}

	public int getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(int purchaseType) {
		this.purchaseType = purchaseType;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getTermsCondition() {
		return termsCondition;
	}

	public void setTermsCondition(String termsCondition) {
		this.termsCondition = termsCondition;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPurchaseForName() {
		return purchaseForName;
	}

	public void setPurchaseForName(String purchaseForName) {
		this.purchaseForName = purchaseForName;
	}

	public String getPurchaseTypeName() {
		return purchaseTypeName;
	}

	public void setPurchaseTypeName(String purchaseTypeName) {
		this.purchaseTypeName = purchaseTypeName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public List<PurchaseQuoteDetail> getPurchaseQuoteDetails() {
		return purchaseQuoteDetails;
	}

	public void setPurchaseQuoteDetails(List<PurchaseQuoteDetail> purchaseQuoteDetails) {
		this.purchaseQuoteDetails = purchaseQuoteDetails;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public List<RateContractDetail> getRateContractDetails() {
		return rateContractDetails;
	}

	public void setRateContractDetails(List<RateContractDetail> rateContractDetails) {
		this.rateContractDetails = rateContractDetails;
	}

	public Integer getConTransNo() {
		return conTransNo;
	}

	public void setConTransNo(Integer conTransNo) {
		this.conTransNo = conTransNo;
	}

	public Integer getDetailQuantity() {
		return detailQuantity;
	}

	public void setDetailQuantity(Integer detailQuantity) {
		this.detailQuantity = detailQuantity;
	}

	public String getDetailItemName() {
		return detailItemName;
	}

	public void setDetailItemName(String detailItemName) {
		this.detailItemName = detailItemName;
	}

	public Integer getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(Integer paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRecmndDate() {
		return recmndDate;
	}

	public void setRecmndDate(String recmndDate) {
		this.recmndDate = recmndDate;
	}

	public String getRecmndremarks() {
		return recmndremarks;
	}

	public void setRecmndremarks(String recmndremarks) {
		this.recmndremarks = recmndremarks;
	}

	public String getRecmmendedBy() {
		return recmmendedBy;
	}

	public void setRecmmendedBy(String recmmendedBy) {
		this.recmmendedBy = recmmendedBy;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsView() {
		return isView;
	}

	public void setIsView(Boolean isView) {
		this.isView = isView;
	}

	public Boolean getIsPrint() {
		return isPrint;
	}

	public void setIsPrint(Boolean isPrint) {
		this.isPrint = isPrint;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isIsdelSelected() {
		return isdelSelected;
	}

	public void setIsdelSelected(boolean isdelSelected) {
		this.isdelSelected = isdelSelected;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public List<RateContractDetail> getIsOrderIds() {
		return isOrderIds;
	}

	public void setIsOrderIds(List<RateContractDetail> isOrderIds) {
		this.isOrderIds = isOrderIds;
	}

	public List<RateContractDetail> getIsDeletedIds() {
		return isDeletedIds;
	}

	public void setIsDeletedIds(List<RateContractDetail> isDeletedIds) {
		this.isDeletedIds = isDeletedIds;
	}

	public Double getDuplicateFreight() {
		return duplicateFreight;
	}

	public void setDuplicateFreight(Double duplicateFreight) {
		this.duplicateFreight = duplicateFreight;
	}

	public PurchaseOrder getSplittedPurchaseOrderbean() {
		return splittedPurchaseOrderbean;
	}

	public void setSplittedPurchaseOrderbean(PurchaseOrder splittedPurchaseOrderbean) {
		this.splittedPurchaseOrderbean = splittedPurchaseOrderbean;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderUpdateList() {
		return purchaseOrderUpdateList;
	}

	public void setPurchaseOrderUpdateList(List<PurchaseOrderDetail> purchaseOrderUpdateList) {
		this.purchaseOrderUpdateList = purchaseOrderUpdateList;
	}

	public List<PurchaseOrderDetail> getQuotationDetailList() {
		return quotationDetailList;
	}

	public void setQuotationDetailList(List<PurchaseOrderDetail> quotationDetailList) {
		this.quotationDetailList = quotationDetailList;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getReason_for_amendment() {
		return reason_for_amendment;
	}

	public void setReason_for_amendment(String reason_for_amendment) {
		this.reason_for_amendment = reason_for_amendment;
	}

	// ...................... For Purchase Quotation
	// ............................

	// private Double subTotal;
	// private Double totalDiscount;
	// private Double totalTax;
	private Double totalFreight;
	private Double tax;
	// private Double freight;
	private Double grandTotal;
	// private String remarks;
	private String createdBy;
	private String modifiedBy;
	private String purchaseForValue;
	private String entityName;
	private String vendorAddress;
	private Integer city;
	private String cityName;
	private String stateCode;
	private String state;
	private String zipcode;
	private String country;
	private String fixedPrice;
	private String fixedQty;
	private Integer requisitionId;
	private Integer pmtTermsId;
	private String pmtTerms;
	private String validFromDate;
	private String validToDate;
	// private Integer paymentTerms;
	// private String companyId;
	// private String companyName;
	// private String costcenter;
	private Integer requisitionNo;

	private Integer itemCode;
	private int quotationId;
	private String quotationNo;
	private String quoteDate;
	// private Integer purchaseFor;
	// private Integer purchaseType;
	// private String vendorId;
	private String vendorId1;
	private Integer vendorLocId;
	private String vendorLocName;
	private Integer uomName;
	// private String uomName;
	private Double discount;

	// private Integer locationId;
	// private String purchaseOrderDate;
	// private Integer statusId;
	// private String termsCondition;

	public Double getTotalFreight() {
		return totalFreight;
	}

	public void setTotalFreight(Double totalFreight) {
		this.totalFreight = totalFreight;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getPurchaseForValue() {
		return purchaseForValue;
	}

	public void setPurchaseForValue(String purchaseForValue) {
		this.purchaseForValue = purchaseForValue;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(String fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public String getFixedQty() {
		return fixedQty;
	}

	public void setFixedQty(String fixedQty) {
		this.fixedQty = fixedQty;
	}

	public Integer getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(Integer requisitionId) {
		this.requisitionId = requisitionId;
	}

	public Integer getPmtTermsId() {
		return pmtTermsId;
	}

	public void setPmtTermsId(Integer pmtTermsId) {
		this.pmtTermsId = pmtTermsId;
	}

	public String getPmtTerms() {
		return pmtTerms;
	}

	public void setPmtTerms(String pmtTerms) {
		this.pmtTerms = pmtTerms;
	}

	public String getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(String validFromDate) {
		this.validFromDate = validFromDate;
	}

	public String getValidToDate() {
		return validToDate;
	}

	public void setValidToDate(String validToDate) {
		this.validToDate = validToDate;
	}

	public Integer getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(Integer requisitionNo) {
		this.requisitionNo = requisitionNo;
	}

	public Integer getItemCode() {
		return itemCode;
	}

	public void setItemCode(Integer itemCode) {
		this.itemCode = itemCode;
	}

	public int getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public String getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(String quoteDate) {
		this.quoteDate = quoteDate;
	}

	public String getVendorId1() {
		return vendorId1;
	}

	public void setVendorId1(String vendorId1) {
		this.vendorId1 = vendorId1;
	}

	public Integer getVendorLocId() {
		return vendorLocId;
	}

	public void setVendorLocId(Integer vendorLocId) {
		this.vendorLocId = vendorLocId;
	}

	public String getVendorLocName() {
		return vendorLocName;
	}

	public void setVendorLocName(String vendorLocName) {
		this.vendorLocName = vendorLocName;
	}

	public Integer getUomName() {
		return uomName;
	}

	public void setUomName(Integer uomName) {
		this.uomName = uomName;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

}
