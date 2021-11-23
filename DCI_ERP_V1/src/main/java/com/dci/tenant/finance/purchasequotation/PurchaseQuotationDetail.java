package com.dci.tenant.finance.purchasequotation;

import java.util.ArrayList;
import java.util.List;

public class PurchaseQuotationDetail {

	private Integer quotationDetailId;
	private Integer quotationId;
	private Integer requisitionId;
	private int vendorId;
	private String requisitionNo;
	private Integer itemId;
	private double quantity;
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
	private Double unitPrice;
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

	private double taxCGST;
	private double taxSGST;
	private double taxIGST;

	private double taxPercentage;
	private double taxAmount;
	private double disAmt;
	private double taxAmt;
	private double pedningQuantity;
	private Integer subTaxTypeId;
	private String subTaxType;
	private Double subTaxPercentage;
	private Double subTaxAmount;
	private String subTaxTypePercent;
	private String subTaxTypeAmt;
	private String vendorName;
	private boolean selectCheckBox;
	private String prRequestNo;
	private Double taxCGSTinPercent;
	private Double taxSGSTinPercent;
	private Double taxIGSTinPercent;
	// private String itemCode;
	// private String itemName;
	// private String itemDesc;
	// private String EDD;
	// private String purchaseUOM;
	private String purchaseReqQuantity;
	private String vendorUOM;
	// private String vendorQuantity;
	// private String uom;
	// private String uomName;
	// private String vendorUomName;
	// private String unitPrice;
	// private String taxCGST;
	// private String taxSGST;
	// private String taxIGST;
	private String discount;
	private double discount1;
	private double discountcal;

	private boolean select = false;
	public String costcenter;
	private double discountAmount;
	private double discountPercent;
	private double rowSubTotal;
	private List<PurchaseQuotationDetail> subTaxList = new ArrayList<>();
	private List<PurchaseQuotationDetail> newlist = new ArrayList<>();

	private int vendoruom;
	private String vendorUomName;
	private double vendorQuantity;
	private double vendorConvertedQuantity;
	private double availableQty;
	private double CheckQuantity;
	private double requestedQty;
	private String poNumber;
	private Double oldunitPrice;

	private String purchaseUOM;
	private double purchaseQty;

	private String purchaseUOMName;

	private Integer altuom;
	private double altqty;

	private String altuomName;

	public Integer getAltuom() {
		return altuom;
	}

	public void setAltuom(Integer altuom) {
		this.altuom = altuom;
	}

	public double getAltqty() {
		return altqty;
	}

	public void setAltqty(double altqty) {
		this.altqty = altqty;
	}

	public String getAltuomName() {
		return altuomName;
	}

	public void setAltuomName(String altuomName) {
		this.altuomName = altuomName;
	}

	public String getPurchaseUOMName() {
		return purchaseUOMName;
	}

	public void setPurchaseUOMName(String purchaseUOMName) {
		this.purchaseUOMName = purchaseUOMName;
	}

	public double getPurchaseQty() {
		return purchaseQty;
	}

	public void setPurchaseQty(double purchaseQty) {
		this.purchaseQty = purchaseQty;
	}

	public String getPurchaseUOM() {
		return purchaseUOM;
	}

	public void setPurchaseUOM(String purchaseUOM) {
		this.purchaseUOM = purchaseUOM;
	}

	public Double getOldunitPrice() {
		return oldunitPrice;
	}

	public void setOldunitPrice(Double oldunitPrice) {
		this.oldunitPrice = oldunitPrice;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public double getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(double requestedQty) {
		this.requestedQty = requestedQty;
	}

	public double getCheckQuantity() {
		return CheckQuantity;
	}

	public void setCheckQuantity(double checkQuantity) {
		CheckQuantity = checkQuantity;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getVendorConvertedQuantity() {
		return vendorConvertedQuantity;
	}

	public void setVendorConvertedQuantity(double vendorConvertedQuantity) {
		this.vendorConvertedQuantity = vendorConvertedQuantity;
	}

	public double getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(double availableQty) {
		this.availableQty = availableQty;
	}

	public double getDiscount1() {
		return discount1;
	}

	public void setDiscount1(double discount1) {
		this.discount1 = discount1;
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

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
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

	public List<PurchaseQuotationDetail> getSubTaxList() {
		return subTaxList;
	}

	public void setSubTaxList(List<PurchaseQuotationDetail> subTaxList) {
		this.subTaxList = subTaxList;
	}

	public List<PurchaseQuotationDetail> getNewlist() {
		return newlist;
	}

	public void setNewlist(List<PurchaseQuotationDetail> newlist) {
		this.newlist = newlist;
	}

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

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	/*
	 * private Integer quotationDetailId; private Integer quotationId; private
	 * Integer requisitionId; private int vendorId; private String requisitionNo;
	 * private Integer itemId; private Integer quantity; private String eddDate;
	 * private boolean statuschange; private Integer taxId; private String ltaxIds;
	 * private ArrayList<String> taxIdslist = new ArrayList<String>(); private
	 * ArrayList<String> taxIdsCodeList = new ArrayList<String>(); private String
	 * taxType; private String taxCode; private String taxName; private Integer
	 * taxTypeId; private int taxAccountId; private ArrayList<Object> taxAccountList
	 * = new ArrayList<Object>(); private Integer discountTypeId; private String
	 * discountType; private Integer percentage; private Double amount; private
	 * Integer deliveryLeadTime; private Integer queryStatus; private Double
	 * unitPrice; private String itemCode; private String status; private String
	 * reqDate; private String locationName; private String itemName; private String
	 * itemDescription; private int uom; private String uomName; private int city;
	 * private String stateCode; private String stateName; private String cityName;
	 * private String street; private String pincode; private String vendorAddress;
	 * private String country;
	 * 
	 * private double taxCGST; private double taxSGST; private double taxIGST;
	 * 
	 * private double taxPercentage; private double taxAmount; private double
	 * disAmt; private double taxAmt;
	 * 
	 * private Integer subTaxTypeId; private String subTaxType; private Double
	 * subTaxPercentage; private Double subTaxAmount; private String
	 * subTaxTypePercent; private String subTaxTypeAmt; private String vendorName;
	 * private boolean selectCheckBox; private String prRequestNo;
	 * 
	 * // private String itemCode; // private String itemName; // private String
	 * itemDesc; // private String EDD; // private String purchaseUOM; private
	 * String purchaseReqQuantity; private String vendorUOM; // private String
	 * vendorQuantity; // private String uom; // private String uomName; // private
	 * String vendorUomName; // private String unitPrice; // private String taxCGST;
	 * // private String taxSGST; // private String taxIGST; private String
	 * discount;
	 * 
	 * // private String discountType; // private String leadTime;
	 * 
	 * public String getPrRequestNo() { return prRequestNo; }
	 * 
	 * public String getPurchaseReqQuantity() { return purchaseReqQuantity; }
	 * 
	 * public void setPurchaseReqQuantity(String purchaseReqQuantity) {
	 * this.purchaseReqQuantity = purchaseReqQuantity; }
	 * 
	 * public String getVendorUOM() { return vendorUOM; }
	 * 
	 * public void setVendorUOM(String vendorUOM) { this.vendorUOM = vendorUOM; }
	 * 
	 * public String getDiscount() { return discount; }
	 * 
	 * public void setDiscount(String discount) { this.discount = discount; }
	 * 
	 * public void setPrRequestNo(String prRequestNo) { this.prRequestNo =
	 * prRequestNo; }
	 * 
	 * public boolean isSelectCheckBox() { return selectCheckBox; }
	 * 
	 * public void setSelectCheckBox(boolean selectCheckBox) { this.selectCheckBox =
	 * selectCheckBox; }
	 * 
	 * public double getTaxCGST() { return taxCGST; }
	 * 
	 * public void setTaxCGST(double taxCGST) { this.taxCGST = taxCGST; }
	 * 
	 * public double getTaxSGST() { return taxSGST; }
	 * 
	 * public void setTaxSGST(double taxSGST) { this.taxSGST = taxSGST; }
	 * 
	 * public double getTaxIGST() { return taxIGST; }
	 * 
	 * public void setTaxIGST(double taxIGST) { this.taxIGST = taxIGST; }
	 * 
	 * public String getVendorName() { return vendorName; }
	 * 
	 * public void setVendorName(String vendorName) { this.vendorName = vendorName;
	 * }
	 * 
	 * public List<PurchaseQuotationDetail> getNewlist() { return newlist; }
	 * 
	 * public void setNewlist(List<PurchaseQuotationDetail> newlist) { this.newlist
	 * = newlist; }
	 * 
	 * private boolean select = false;
	 * 
	 * private double discountAmount; private double discountPercent; private double
	 * rowSubTotal; private List<PurchaseQuotationDetail> subTaxList = new
	 * ArrayList<PurchaseQuotationDetail>(); private List<PurchaseQuotationDetail>
	 * newlist = new ArrayList<PurchaseQuotationDetail>();
	 * 
	 * private int vendoruom; private String vendorUomName; private int
	 * vendorQuantity; private int vendorConvertedQuantity;
	 * 
	 * public int getVendoruom() { return vendoruom; }
	 * 
	 * public void setVendoruom(int vendoruom) { this.vendoruom = vendoruom; }
	 * 
	 * public String getVendorUomName() { return vendorUomName; }
	 * 
	 * public void setVendorUomName(String vendorUomName) { this.vendorUomName =
	 * vendorUomName; }
	 * 
	 * public int getVendorQuantity() { return vendorQuantity; }
	 * 
	 * public void setVendorQuantity(int vendorQuantity) { this.vendorQuantity =
	 * vendorQuantity; }
	 * 
	 * public Integer getQuotationDetailId() { return quotationDetailId; }
	 * 
	 * public void setQuotationDetailId(Integer quotationDetailId) {
	 * this.quotationDetailId = quotationDetailId; }
	 * 
	 * public Integer getQuotationId() { return quotationId; }
	 * 
	 * public void setQuotationId(Integer quotationId) { this.quotationId =
	 * quotationId; }
	 * 
	 * public Integer getRequisitionId() { return requisitionId; }
	 * 
	 * public void setRequisitionId(Integer requisitionId) { this.requisitionId =
	 * requisitionId; }
	 * 
	 * public Integer getItemId() { return itemId; }
	 * 
	 * public void setItemId(Integer itemId) { this.itemId = itemId; }
	 * 
	 * public Integer getQuantity() { return quantity; }
	 * 
	 * public void setQuantity(Integer quantity) { this.quantity = quantity; }
	 * 
	 * public String getEddDate() { return eddDate; }
	 * 
	 * public void setEddDate(String eddDate) { this.eddDate = eddDate; }
	 * 
	 * public Integer getTaxId() { return taxId; }
	 * 
	 * public void setTaxId(Integer taxId) { this.taxId = taxId; }
	 * 
	 * public String getTaxType() { return taxType; }
	 * 
	 * public void setTaxType(String taxType) { this.taxType = taxType; }
	 * 
	 * public String getTaxCode() { return taxCode; }
	 * 
	 * public void setTaxCode(String taxCode) { this.taxCode = taxCode; }
	 * 
	 * public String getTaxName() { return taxName; }
	 * 
	 * public void setTaxName(String taxName) { this.taxName = taxName; }
	 * 
	 * public Integer getDiscountTypeId() { return discountTypeId; }
	 * 
	 * public void setDiscountTypeId(Integer discountTypeId) { this.discountTypeId =
	 * discountTypeId; }
	 * 
	 * public String getDiscountType() { return discountType; }
	 * 
	 * public void setDiscountType(String discountType) { this.discountType =
	 * discountType; }
	 * 
	 * public Integer getPercentage() { return percentage; }
	 * 
	 * public void setPercentage(Integer percentage) { this.percentage = percentage;
	 * }
	 * 
	 * public Double getAmount() { return amount; }
	 * 
	 * public void setAmount(Double amount) { this.amount = amount; }
	 * 
	 * public Integer getDeliveryLeadTime() { return deliveryLeadTime; }
	 * 
	 * public void setDeliveryLeadTime(Integer deliveryLeadTime) {
	 * this.deliveryLeadTime = deliveryLeadTime; }
	 * 
	 * public Integer getQueryStatus() { return queryStatus; }
	 * 
	 * public void setQueryStatus(Integer queryStatus) { this.queryStatus =
	 * queryStatus; }
	 * 
	 * public Double getUnitPrice() { return unitPrice; }
	 * 
	 * public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }
	 * 
	 * public String getRequisitionNo() { return requisitionNo; }
	 * 
	 * public void setRequisitionNo(String requisitionNo) { this.requisitionNo =
	 * requisitionNo; }
	 * 
	 * public String getItemCode() { return itemCode; }
	 * 
	 * public void setItemCode(String itemCode) { this.itemCode = itemCode; }
	 * 
	 * public String getStatus() { return status; }
	 * 
	 * public void setStatus(String status) { this.status = status; }
	 * 
	 * public String getReqDate() { return reqDate; }
	 * 
	 * public void setReqDate(String reqDate) { this.reqDate = reqDate; }
	 * 
	 * public String getLocationName() { return locationName; }
	 * 
	 * public void setLocationName(String locationName) { this.locationName =
	 * locationName; }
	 * 
	 * public String getItemDescription() { return itemDescription; }
	 * 
	 * public void setItemDescription(String itemDescription) { this.itemDescription
	 * = itemDescription; }
	 * 
	 * public String getItemName() { return itemName; }
	 * 
	 * public void setItemName(String itemName) { this.itemName = itemName; }
	 * 
	 * public int getCity() { return city; }
	 * 
	 * public void setCity(int city) { this.city = city; }
	 * 
	 * public String getStateCode() { return stateCode; }
	 * 
	 * public void setStateCode(String stateCode) { this.stateCode = stateCode; }
	 * 
	 * public String getStateName() { return stateName; }
	 * 
	 * public void setStateName(String stateName) { this.stateName = stateName; }
	 * 
	 * public String getCityName() { return cityName; }
	 * 
	 * public void setCityName(String cityName) { this.cityName = cityName; }
	 * 
	 * public String getStreet() { return street; }
	 * 
	 * public void setStreet(String street) { this.street = street; }
	 * 
	 * public String getPincode() { return pincode; }
	 * 
	 * public void setPincode(String pincode) { this.pincode = pincode; }
	 * 
	 * public String getVendorAddress() { return vendorAddress; }
	 * 
	 * public void setVendorAddress(String vendorAddress) { this.vendorAddress =
	 * vendorAddress; }
	 * 
	 * public String getCountry() { return country; }
	 * 
	 * public void setCountry(String country) { this.country = country; }
	 * 
	 * public double getTaxPercentage() { return taxPercentage; }
	 * 
	 * public void setTaxPercentage(double taxPercentage) { this.taxPercentage =
	 * taxPercentage; }
	 * 
	 * public double getTaxAmount() { return taxAmount; }
	 * 
	 * public void setTaxAmount(double taxAmount) { this.taxAmount = taxAmount; }
	 * 
	 * public double getTaxAmt() { return taxAmt; }
	 * 
	 * public void setTaxAmt(double taxAmt) { this.taxAmt = taxAmt; }
	 * 
	 * public double getDisAmt() { return disAmt; }
	 * 
	 * public void setDisAmt(double disAmt) { this.disAmt = disAmt; }
	 * 
	 * public double getDiscountAmount() { return discountAmount; }
	 * 
	 * public void setDiscountAmount(double discountAmount) { this.discountAmount =
	 * discountAmount; }
	 * 
	 * public double getDiscountPercent() { return discountPercent; }
	 * 
	 * public void setDiscountPercent(double discountPercent) { this.discountPercent
	 * = discountPercent; }
	 * 
	 * public double getRowSubTotal() { return rowSubTotal; }
	 * 
	 * public void setRowSubTotal(double rowSubTotal) { this.rowSubTotal =
	 * rowSubTotal; }
	 * 
	 * public int getUom() { return uom; }
	 * 
	 * public void setUom(int uom) { this.uom = uom; }
	 * 
	 * public String getUomName() { return uomName; }
	 * 
	 * public void setUomName(String uomName) { this.uomName = uomName; }
	 * 
	 * public Integer getSubTaxTypeId() { return subTaxTypeId; }
	 * 
	 * public void setSubTaxTypeId(Integer subTaxTypeId) { this.subTaxTypeId =
	 * subTaxTypeId; }
	 * 
	 * public String getSubTaxType() { return subTaxType; }
	 * 
	 * public void setSubTaxType(String subTaxType) { this.subTaxType = subTaxType;
	 * }
	 * 
	 * public Double getSubTaxPercentage() { return subTaxPercentage; }
	 * 
	 * public void setSubTaxPercentage(Double subTaxPercentage) {
	 * this.subTaxPercentage = subTaxPercentage; }
	 * 
	 * public Double getSubTaxAmount() { return subTaxAmount; }
	 * 
	 * public void setSubTaxAmount(Double subTaxAmount) { this.subTaxAmount =
	 * subTaxAmount; }
	 * 
	 * public List<PurchaseQuotationDetail> getSubTaxList() { return subTaxList; }
	 * 
	 * public void setSubTaxList(List<PurchaseQuotationDetail> subTaxList) {
	 * this.subTaxList = subTaxList; }
	 * 
	 * public String getSubTaxTypePercent() { return subTaxTypePercent; }
	 * 
	 * public void setSubTaxTypePercent(String subTaxTypePercent) {
	 * this.subTaxTypePercent = subTaxTypePercent; }
	 * 
	 * public String getSubTaxTypeAmt() { return subTaxTypeAmt; }
	 * 
	 * public void setSubTaxTypeAmt(String subTaxTypeAmt) { this.subTaxTypeAmt =
	 * subTaxTypeAmt; }
	 * 
	 * public boolean isSelect() { return select; }
	 * 
	 * public void setSelect(boolean select) { this.select = select; }
	 * 
	 * public int getVendorId() { return vendorId; }
	 * 
	 * public void setVendorId(int vendorId) { this.vendorId = vendorId; }
	 * 
	 * public ArrayList<String> getTaxIdslist() { return taxIdslist; }
	 * 
	 * public void setTaxIdslist(ArrayList<String> taxIdslist) { this.taxIdslist =
	 * taxIdslist; }
	 * 
	 * public ArrayList<String> getTaxIdsCodeList() { return taxIdsCodeList; }
	 * 
	 * public void setTaxIdsCodeList(ArrayList<String> taxIdsCodeList) {
	 * this.taxIdsCodeList = taxIdsCodeList; }
	 * 
	 * public Integer getTaxTypeId() { return taxTypeId; }
	 * 
	 * public void setTaxTypeId(Integer taxTypeId) { this.taxTypeId = taxTypeId; }
	 * 
	 * public String getLtaxIds() { return ltaxIds; }
	 * 
	 * public void setLtaxIds(String ltaxIds) { this.ltaxIds = ltaxIds; }
	 * 
	 * public boolean isStatuschange() { return statuschange; }
	 * 
	 * public void setStatuschange(boolean statuschange) { this.statuschange =
	 * statuschange; }
	 * 
	 * public int getVendorConvertedQuantity() { return vendorConvertedQuantity; }
	 * 
	 * public void setVendorConvertedQuantity(int vendorConvertedQuantity) {
	 * this.vendorConvertedQuantity = vendorConvertedQuantity; }
	 *//**
		 * @return the taxAccountId
		 */
	/*
	 * public int getTaxAccountId() { return taxAccountId; }
	 *//**
		 * @param taxAccountId
		 *            the taxAccountId to set
		 */
	/*
	 * public void setTaxAccountId(int taxAccountId) { this.taxAccountId =
	 * taxAccountId; }
	 *//**
		 * @return the taxAccountList
		 */
	/*
	 * public ArrayList<Object> getTaxAccountList() { return taxAccountList; }
	 *//**
		 * @param taxAccountList
		 *            the taxAccountList to set
		 */
	/*
	 * public void setTaxAccountList(ArrayList<Object> taxAccountList) {
	 * this.taxAccountList = taxAccountList; }
	 */

}
