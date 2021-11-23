package com.dci.tenant.finance.purchaseorder;

import java.util.ArrayList;
import java.util.List;

import com.dci.tenant.finance.purchasequotation.PurchaseQuotationDetail;

public class PurchaseOrderDetail {

	private int purchaseOrderDetailId;
	private int purchaseQuoteDetailId;
	private int purchaseQuoteId;
	private int purchaseOrderId;
	private int purchaseItemId;
	private String purchaseItemName;
	private String purchaseItemDesc;
	private String costcenter;

	private String purchaseItemCode;
	private String purchaseStatus;
	private Double unitPrice;
	private Double oldUnitPrice;
	private Double quantity;
	private Double price;
	private int purchaseStatusId;
	private int edit;
	private Double discount;
	private Double tax;
	private Double requestedQty;
	private boolean isCheck = false;
	private boolean isSelected = false;
	// private int statusId;
	private String edd;
	private boolean selectCheckBox;
	private String prRequestNo;

	private String purchaseReqQuantity;
	private String vendorUOM;
	private Double taxCGST;
	private Double taxSGST;
	private Double taxIGST;
	private double pedningQuantity;
	private double discountcal;
	private Double taxCGSTinPercent;
	private Double taxSGSTinPercent;
	private Double taxIGSTinPercent;
	private double availableQty;
	private String PurchaseOrderDetail;
	private String deliverySchdCount;
	private String tooltipPo;
	private double purchaseQuantity;
	private String purchaseRequestNum;
	private double unitDiscount;
	private String vendorId1;
	private double finalTotal;

	private String purchaseUOM;
	private double purchaseQty;
	private String purchaseUOMName;
	// public int getStatusId() {
	// return statusId;
	// }
	//
	// public void setStatusId(int statusId) {
	// this.statusId = statusId;
	// }

	public String getPurchaseRequestNum() {
		return purchaseRequestNum;
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

	public double getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}

	public String getVendorId1() {
		return vendorId1;
	}

	public void setVendorId1(String vendorId1) {
		this.vendorId1 = vendorId1;
	}

	public double getUnitDiscount() {
		return unitDiscount;
	}

	public void setUnitDiscount(double unitDiscount) {
		this.unitDiscount = unitDiscount;
	}

	public void setPurchaseRequestNum(String purchaseRequestNum) {
		this.purchaseRequestNum = purchaseRequestNum;
	}

	public String getDeliverySchdCount() {
		return deliverySchdCount;
	}

	public double getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(double purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getTooltipPo() {
		return tooltipPo;
	}

	public void setTooltipPo(String tooltipPo) {
		this.tooltipPo = tooltipPo;
	}

	public void setDeliverySchdCount(String deliverySchdCount) {
		this.deliverySchdCount = deliverySchdCount;
	}

	public String getPurchaseOrderDetail() {
		return PurchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(String purchaseOrderDetail) {
		PurchaseOrderDetail = purchaseOrderDetail;
	}

	public String getEdd() {
		return edd;
	}

	public double getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(double availableQty) {
		this.availableQty = availableQty;
	}

	public double getDiscountcal() {
		return discountcal;
	}

	public void setDiscountcal(double discountcal) {
		this.discountcal = discountcal;
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

	public double getPedningQuantity() {
		return pedningQuantity;
	}

	public void setPedningQuantity(double pedningQuantity) {
		this.pedningQuantity = pedningQuantity;
	}

	public String getPurchaseItemDesc() {
		return purchaseItemDesc;
	}

	public void setPurchaseItemDesc(String purchaseItemDesc) {
		this.purchaseItemDesc = purchaseItemDesc;
	}

	public Double getOldUnitPrice() {
		return oldUnitPrice;
	}

	public void setOldUnitPrice(Double oldUnitPrice) {
		this.oldUnitPrice = oldUnitPrice;
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

	public boolean isSelectCheckBox() {
		return selectCheckBox;
	}

	public void setSelectCheckBox(boolean selectCheckBox) {
		this.selectCheckBox = selectCheckBox;
	}

	public void setEdd(String edd) {
		this.edd = edd;
	}

	private List<RateContractDetail> rateContractDetails;

	private Double splittedQuantity;

	private boolean select = false;

	public int getPurchaseOrderDetailId() {
		return purchaseOrderDetailId;
	}

	public void setPurchaseOrderDetailId(int purchaseOrderDetailId) {
		this.purchaseOrderDetailId = purchaseOrderDetailId;
	}

	public int getPurchaseQuoteDetailId() {
		return purchaseQuoteDetailId;
	}

	public void setPurchaseQuoteDetailId(int purchaseQuoteDetailId) {
		this.purchaseQuoteDetailId = purchaseQuoteDetailId;
	}

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public int getPurchaseItemId() {
		return purchaseItemId;
	}

	public void setPurchaseItemId(int purchaseItemId) {
		this.purchaseItemId = purchaseItemId;
	}

	public String getPurchaseItemName() {
		return purchaseItemName;
	}

	public void setPurchaseItemName(String purchaseItemName) {
		this.purchaseItemName = purchaseItemName;
	}

	public String getPurchaseItemCode() {
		return purchaseItemCode;
	}

	public void setPurchaseItemCode(String purchaseItemCode) {
		this.purchaseItemCode = purchaseItemCode;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public int getPurchaseStatusId() {
		return purchaseStatusId;
	}

	public void setPurchaseStatusId(int purchaseStatusId) {
		this.purchaseStatusId = purchaseStatusId;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public int getEdit() {
		return edit;
	}

	public void setEdit(int edit) {
		this.edit = edit;
	}

	public List<RateContractDetail> getRateContractDetails() {
		return rateContractDetails;
	}

	public void setRateContractDetails(List<RateContractDetail> rateContractDetails) {
		this.rateContractDetails = rateContractDetails;
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

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public int getPurchaseQuoteId() {
		return purchaseQuoteId;
	}

	public void setPurchaseQuoteId(int purchaseQuoteId) {
		this.purchaseQuoteId = purchaseQuoteId;
	}

	public Double getSplittedQuantity() {
		return splittedQuantity;
	}

	public void setSplittedQuantity(Double splittedQuantity) {
		this.splittedQuantity = splittedQuantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	// .....................Quotation detail ..............

	private Integer quotationDetailId;
	private Integer quotationId;
	private Integer requisitionId;
	private int vendorId;
	private String requisitionNo;
	private Integer itemId;
	// private Integer quantity;
	private String eddDate;
	private boolean statuschange;
	private Integer taxId;
	private String ltaxIds;
	private ArrayList<String> taxIdslist = new ArrayList<>();
	private ArrayList<String> taxIdsCodeList = new ArrayList<>();
	private String taxType;
	private String taxCode;
	private String taxName;
	private Integer taxTypeId;
	private int taxAccountId;
	private ArrayList<Object> taxAccountList = new ArrayList<>();
	private Integer discountTypeId;
	private String discountType;
	private Integer percentage;
	private Double amount;
	private Integer deliveryLeadTime;
	private Integer queryStatus;
	// private Double unitPrice;
	private String itemCode;
	private String status;
	private String reqDate;
	private String locationName;
	private String itemName;
	private String itemDescription;
	private int uom;
	private String uomName;
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

	private Integer subTaxTypeId;
	private String subTaxType;
	private Double subTaxPercentage;
	private Double subTaxAmount;
	private String subTaxTypePercent;
	private String subTaxTypeAmt;
	private String vendorName;

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<PurchaseQuotationDetail> getNewlist() {
		return newlist;
	}

	public void setNewlist(List<PurchaseQuotationDetail> newlist) {
		this.newlist = newlist;
	}

	// private boolean select = false;

	private double discountAmount;
	private double discountPercent;
	private double rowSubTotal;
	private List<PurchaseQuotationDetail> subTaxList = new ArrayList<>();
	private List<PurchaseQuotationDetail> newlist = new ArrayList<>();

	private int vendoruom;
	private String vendorUomName;
	private double vendorQuantity;
	private int vendorConvertedQuantity;

	public int getVendoruom() {
		return vendoruom;
	}

	public void setVendoruom(int vendoruom) {
		this.vendoruom = vendoruom;
	}

	public String getVendorUomName() {
		return vendorUomName;
	}

	public void setVendorUomName(String vendorUomName) {
		this.vendorUomName = vendorUomName;
	}

	public double getVendorQuantity() {
		return vendorQuantity;
	}

	public void setVendorQuantity(double vendorQuantity) {
		this.vendorQuantity = vendorQuantity;
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

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	// public Integer getQuantity() {
	// return quantity;
	// }
	//
	// public void setQuantity(Integer quantity) {
	// this.quantity = quantity;
	// }

	public String getEddDate() {
		return eddDate;
	}

	public void setEddDate(String eddDate) {
		this.eddDate = eddDate;
	}

	public Integer getTaxId() {
		return taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getDeliveryLeadTime() {
		return deliveryLeadTime;
	}

	public void setDeliveryLeadTime(Integer deliveryLeadTime) {
		this.deliveryLeadTime = deliveryLeadTime;
	}

	public Integer getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(Integer queryStatus) {
		this.queryStatus = queryStatus;
	}

	//
	// public Double getUnitPrice() {
	// return unitPrice;
	// }
	//
	// public void setUnitPrice(Double unitPrice) {
	// this.unitPrice = unitPrice;
	// }

	public String getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
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

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public double getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(double taxAmt) {
		this.taxAmt = taxAmt;
	}

	public double getDisAmt() {
		return disAmt;
	}

	public void setDisAmt(double disAmt) {
		this.disAmt = disAmt;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getRowSubTotal() {
		return rowSubTotal;
	}

	public void setRowSubTotal(double rowSubTotal) {
		this.rowSubTotal = rowSubTotal;
	}

	public int getUom() {
		return uom;
	}

	public void setUom(int uom) {
		this.uom = uom;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
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

	public List<PurchaseQuotationDetail> getSubTaxList() {
		return subTaxList;
	}

	public void setSubTaxList(List<PurchaseQuotationDetail> subTaxList) {
		this.subTaxList = subTaxList;
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

	// public boolean isSelect() {
	// return select;
	// }
	//
	// public void setSelect(boolean select) {
	// this.select = select;
	// }

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
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

	public Integer getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(Integer taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public String getLtaxIds() {
		return ltaxIds;
	}

	public void setLtaxIds(String ltaxIds) {
		this.ltaxIds = ltaxIds;
	}

	public boolean isStatuschange() {
		return statuschange;
	}

	public void setStatuschange(boolean statuschange) {
		this.statuschange = statuschange;
	}

	public int getVendorConvertedQuantity() {
		return vendorConvertedQuantity;
	}

	public void setVendorConvertedQuantity(int vendorConvertedQuantity) {
		this.vendorConvertedQuantity = vendorConvertedQuantity;
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
	 * @return the taxAccountList
	 */
	public ArrayList<Object> getTaxAccountList() {
		return taxAccountList;
	}

	/**
	 * @param taxAccountList
	 *            the taxAccountList to set
	 */
	public void setTaxAccountList(ArrayList<Object> taxAccountList) {
		this.taxAccountList = taxAccountList;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

}
