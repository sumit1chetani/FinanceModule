package com.dci.tenant.finance.grn;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.BatchAttributeBean;

public class GRNPurchaseOrderBean {
	private int serialNumber;
	private int grnId;
	private int grnDtlId;
	private int poId;
	private boolean checkConsignmentBatch;
	private String poNo;
	private String poDate;
	private int dtlItemId;
	private int dtlQuoteId;
	private double dtlQty;
	private int dtlStatus;
	private double dtlPrice;
	private String dtlItemCode;
	private String dtlItemName;
	private String dtlItemDesc;
	private int ginDetailId;
	private int dtlUom;
	private int dtlPODtlId;
	private String costcenter;
	private int stockTransferDetailId;
	private int transferQty;
	private String select;
	private String address;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String lotNo;
	private String expiryDate;
	private String manufactureDef;
	private int purchaseQuantity;
	private int vendorQty;
	private double mrp;
	private int receivedQty;
	private double pendingQty;
	private int vendorLoc;
	private double dtlDisc;
	private double dtlTax;
	private int destinationId;
	private List<BatchAttributeBean> attributeBeans;
	private List<GRNPurchaseOrderBean> batchDetailsConsignment;
	private ArrayList<GRNPurchaseOrderBean> batchDetails;
	private int scheduleId;
	private int scheduleItemId;
	private String scheduleItemCode;
	private String scheduleItemName;
	private int scheduleQty;
	private int scheduleItemQty;
	private String scheduleItemDate;
	private int schedulePendingQty;
	private int scheduleReceivedQty;
	private int consignmentTransferQty;
	private int batchItemId;
	private String batchItemName;
	private int batchQty;
	private boolean qualityCheck;
	private boolean batchNoExist;

	private int sampleQty;
	private int qcStatus;
	private String qcRemarks;

	private boolean itemBatch;
	private boolean itemMrp;
	private boolean itemExpDate;
	private boolean itemManufacture;

	private String status;
	private double purReqQuantity;
	private double originalConvertedQty;
	private String autoIssue;

	private List<GRNResultBean> grnresultbean;

	private double convertedQty;
	private double vendorQuantity;
	private int itemId;
	private String batchNo;
	private String manufacturer;
	private String mrpPrice;
	private int reqDetailId;
	private double totalTaxCGST;
	private double totalTaxSGST;
	private double totalTaxIGST;
	private double taxCGST;
	private double taxSGST;
	private double taxIGST;

	private double taxCGSTinPercent;
	private double taxSGSTinPercent;
	private double taxIGSTinPercent;
	private double discountPercentage;
	private double discountAmount;
	private String dtlUomName;
	private double subTotal;
	private double total;
	private double finalTotal;
	private int discountType;
	private double price;
	private double discount;
	private double netPrice;
	private boolean selectCheckBox;
	private String gstgroupbyPercent;
	private double gstAmtgroupbyPercent;
	private double rowTotal;
	private String purchaseUOM;
	private double purchaseQty;
	private String purchaseUOMName;
	private String costCenterName;

	private String vendorUOM;
	private String vendorUOMName;
	private double convertedQtyNew;
	private boolean convertedQtyFlag = false;
	private double balanceConvertedQtyNew;
	private double conqty;
	private double cnvtQty;

	public double getCnvtQty() {
		return cnvtQty;
	}

	public void setCnvtQty(double cnvtQty) {
		this.cnvtQty = cnvtQty;
	}

	public double getConqty() {
		return conqty;
	}

	public void setConqty(double conqty) {
		this.conqty = conqty;
	}

	public double getBalanceConvertedQtyNew() {
		return balanceConvertedQtyNew;
	}

	public void setBalanceConvertedQtyNew(double balanceConvertedQtyNew) {
		this.balanceConvertedQtyNew = balanceConvertedQtyNew;
	}

	public double getConvertedQtyNew() {
		return convertedQtyNew;
	}

	public void setConvertedQtyNew(double convertedQtyNew) {
		this.convertedQtyNew = convertedQtyNew;
	}

	public boolean isConvertedQtyFlag() {
		return convertedQtyFlag;
	}

	public void setConvertedQtyFlag(boolean convertedQtyFlag) {
		this.convertedQtyFlag = convertedQtyFlag;
	}

	public String getVendorUOM() {
		return vendorUOM;
	}

	public void setVendorUOM(String vendorUOM) {
		this.vendorUOM = vendorUOM;
	}

	public String getVendorUOMName() {
		return vendorUOMName;
	}

	public void setVendorUOMName(String vendorUOMName) {
		this.vendorUOMName = vendorUOMName;
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

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public double getRowTotal() {
		return rowTotal;
	}

	public void setRowTotal(double rowTotal) {
		this.rowTotal = rowTotal;
	}

	public String getGstgroupbyPercent() {
		return gstgroupbyPercent;
	}

	public void setGstgroupbyPercent(String gstgroupbyPercent) {
		this.gstgroupbyPercent = gstgroupbyPercent;
	}

	public double getGstAmtgroupbyPercent() {
		return gstAmtgroupbyPercent;
	}

	public void setGstAmtgroupbyPercent(double gstAmtgroupbyPercent) {
		this.gstAmtgroupbyPercent = gstAmtgroupbyPercent;
	}

	public boolean isSelectCheckBox() {
		return selectCheckBox;
	}

	public void setSelectCheckBox(boolean selectCheckBox) {
		this.selectCheckBox = selectCheckBox;
	}

	public double getDtlQty() {
		return dtlQty;
	}

	public void setDtlQty(double dtlQty) {
		this.dtlQty = dtlQty;
	}

	public double getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(double pendingQty) {
		this.pendingQty = pendingQty;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
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

	public String getDtlUomName() {
		return dtlUomName;
	}

	public void setDtlUomName(String dtlUomName) {
		this.dtlUomName = dtlUomName;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getTotalTaxCGST() {
		return totalTaxCGST;
	}

	public void setTotalTaxCGST(double totalTaxCGST) {
		this.totalTaxCGST = totalTaxCGST;
	}

	public double getTotalTaxSGST() {
		return totalTaxSGST;
	}

	public void setTotalTaxSGST(double totalTaxSGST) {
		this.totalTaxSGST = totalTaxSGST;
	}

	public double getTotalTaxIGST() {
		return totalTaxIGST;
	}

	public void setTotalTaxIGST(double totalTaxIGST) {
		this.totalTaxIGST = totalTaxIGST;
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

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getReqDetailId() {
		return reqDetailId;
	}

	public void setReqDetailId(int reqDetailId) {
		this.reqDetailId = reqDetailId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getMrpPrice() {
		return mrpPrice;
	}

	public void setMrpPrice(String mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getScheduleReceivedQty() {
		return scheduleReceivedQty;
	}

	public void setScheduleReceivedQty(int scheduleReceivedQty) {
		this.scheduleReceivedQty = scheduleReceivedQty;
	}

	public String getAutoIssue() {
		return autoIssue;
	}

	public void setAutoIssue(String autoIssue) {
		this.autoIssue = autoIssue;
	}

	public boolean isItemBatch() {
		return itemBatch;
	}

	public void setItemBatch(boolean itemBatch) {
		this.itemBatch = itemBatch;
	}

	public boolean isItemMrp() {
		return itemMrp;
	}

	public void setItemMrp(boolean itemMrp) {
		this.itemMrp = itemMrp;
	}

	public boolean isItemExpDate() {
		return itemExpDate;
	}

	public void setItemExpDate(boolean itemExpDate) {
		this.itemExpDate = itemExpDate;
	}

	public boolean isItemManufacture() {
		return itemManufacture;
	}

	public void setItemManufacture(boolean itemManufacture) {
		this.itemManufacture = itemManufacture;
	}

	public int getVendorLoc() {
		return vendorLoc;
	}

	public void setVendorLoc(int vendorLoc) {
		this.vendorLoc = vendorLoc;
	}

	public int getSampleQty() {
		return sampleQty;
	}

	public void setSampleQty(int sampleQty) {
		this.sampleQty = sampleQty;
	}

	public int getQcStatus() {
		return qcStatus;
	}

	public void setQcStatus(int qcStatus) {
		this.qcStatus = qcStatus;
	}

	public String getQcRemarks() {
		return qcRemarks;
	}

	public void setQcRemarks(String qcRemarks) {
		this.qcRemarks = qcRemarks;
	}

	public boolean isQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(boolean qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public int getSchedulePendingQty() {
		return schedulePendingQty;
	}

	public void setSchedulePendingQty(int schedulePendingQty) {
		this.schedulePendingQty = schedulePendingQty;
	}

	public int getScheduleQty() {
		return scheduleQty;
	}

	public void setScheduleQty(int scheduleQty) {
		this.scheduleQty = scheduleQty;
	}

	public int getGrnDtlId() {
		return grnDtlId;
	}

	public void setGrnDtlId(int grnDtlId) {
		this.grnDtlId = grnDtlId;
	}

	public int getBatchItemId() {
		return batchItemId;
	}

	public void setBatchItemId(int batchItemId) {
		this.batchItemId = batchItemId;
	}

	public String getBatchItemName() {
		return batchItemName;
	}

	public void setBatchItemName(String batchItemName) {
		this.batchItemName = batchItemName;
	}

	public int getBatchQty() {
		return batchQty;
	}

	public void setBatchQty(int batchQty) {
		this.batchQty = batchQty;
	}

	private List<GRNPurchaseOrderBean> scheduleList;

	private List<GRNPurchaseOrderBean> batchDtls;

	public List<GRNPurchaseOrderBean> getBatchDtls() {
		return batchDtls;
	}

	public void setBatchDtls(List<GRNPurchaseOrderBean> batchDtls) {
		this.batchDtls = batchDtls;
	}

	public List<GRNPurchaseOrderBean> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<GRNPurchaseOrderBean> scheduleList) {
		this.scheduleList = scheduleList;
	}

	public String getScheduleItemDate() {
		return scheduleItemDate;
	}

	public void setScheduleItemDate(String scheduleItemDate) {
		this.scheduleItemDate = scheduleItemDate;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getScheduleItemId() {
		return scheduleItemId;
	}

	public void setScheduleItemId(int scheduleItemId) {
		this.scheduleItemId = scheduleItemId;
	}

	public String getScheduleItemCode() {
		return scheduleItemCode;
	}

	public void setScheduleItemCode(String scheduleItemCode) {
		this.scheduleItemCode = scheduleItemCode;
	}

	public String getScheduleItemName() {
		return scheduleItemName;
	}

	public void setScheduleItemName(String scheduleItemName) {
		this.scheduleItemName = scheduleItemName;
	}

	public int getScheduleItemQty() {
		return scheduleItemQty;
	}

	public void setScheduleItemQty(int scheduleItemQty) {
		this.scheduleItemQty = scheduleItemQty;
	}

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getManufactureDef() {
		return manufactureDef;
	}

	public void setManufactureDef(String manufactureDef) {
		this.manufactureDef = manufactureDef;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public int getGrnId() {
		return grnId;
	}

	public void setGrnId(int grnId) {
		this.grnId = grnId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public int getDtlPODtlId() {
		return dtlPODtlId;
	}

	public void setDtlPODtlId(int dtlPODtlId) {
		this.dtlPODtlId = dtlPODtlId;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public int getDtlItemId() {
		return dtlItemId;
	}

	public void setDtlItemId(int dtlItemId) {
		this.dtlItemId = dtlItemId;
	}

	public int getDtlQuoteId() {
		return dtlQuoteId;
	}

	public void setDtlQuoteId(int dtlQuoteId) {
		this.dtlQuoteId = dtlQuoteId;
	}

	public int getDtlStatus() {
		return dtlStatus;
	}

	public void setDtlStatus(int dtlStatus) {
		this.dtlStatus = dtlStatus;
	}

	public double getDtlPrice() {
		return dtlPrice;
	}

	public void setDtlPrice(double dtlPrice) {
		this.dtlPrice = dtlPrice;
	}

	public String getDtlItemCode() {
		return dtlItemCode;
	}

	public void setDtlItemCode(String dtlItemCode) {
		this.dtlItemCode = dtlItemCode;
	}

	public String getDtlItemName() {
		return dtlItemName;
	}

	public void setDtlItemName(String dtlItemName) {
		this.dtlItemName = dtlItemName;
	}

	public String getDtlItemDesc() {
		return dtlItemDesc;
	}

	public void setDtlItemDesc(String dtlItemDesc) {
		this.dtlItemDesc = dtlItemDesc;
	}

	public int getDtlUom() {
		return dtlUom;
	}

	public void setDtlUom(int dtlUom) {
		this.dtlUom = dtlUom;
	}

	public double getDtlDisc() {
		return dtlDisc;
	}

	public void setDtlDisc(double dtlDisc) {
		this.dtlDisc = dtlDisc;
	}

	public double getDtlTax() {
		return dtlTax;
	}

	public void setDtlTax(double dtlTax) {
		this.dtlTax = dtlTax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<GRNResultBean> getGrnresultbean() {
		return grnresultbean;
	}

	public void setGrnresultbean(List<GRNResultBean> grnresultbean) {
		this.grnresultbean = grnresultbean;
	}

	public double getPurReqQuantity() {
		return purReqQuantity;
	}

	public void setPurReqQuantity(double purReqQuantity) {
		this.purReqQuantity = purReqQuantity;
	}

	public double getOriginalConvertedQty() {
		return originalConvertedQty;
	}

	public void setOriginalConvertedQty(double originalConvertedQty) {
		this.originalConvertedQty = originalConvertedQty;
	}

	public double getConvertedQty() {
		return convertedQty;
	}

	public void setConvertedQty(double convertedQty) {
		this.convertedQty = convertedQty;
	}

	public double getVendorQuantity() {
		return vendorQuantity;
	}

	public void setVendorQuantity(double vendorQuantity) {
		this.vendorQuantity = vendorQuantity;
	}

	/**
	 * @return the attributeBeans
	 */
	public List<BatchAttributeBean> getAttributeBeans() {
		return attributeBeans;
	}

	/**
	 * @param attributeBeans
	 *            the attributeBeans to set
	 */
	public void setAttributeBeans(List<BatchAttributeBean> attributeBeans) {
		this.attributeBeans = attributeBeans;
	}

	/**
	 * @return the transferQty
	 */
	public int getTransferQty() {
		return transferQty;
	}

	/**
	 * @param transferQty
	 *            the transferQty to set
	 */
	public void setTransferQty(int transferQty) {
		this.transferQty = transferQty;
	}

	/**
	 * @return the destinationId
	 */
	public int getDestinationId() {
		return destinationId;
	}

	/**
	 * @param destinationId
	 *            the destinationId to set
	 */
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public boolean isCheckConsignmentBatch() {
		return checkConsignmentBatch;
	}

	public void setCheckConsignmentBatch(boolean checkConsignmentBatch) {
		this.checkConsignmentBatch = checkConsignmentBatch;
	}

	/**
	 * @return the purchaseQuantity
	 */
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	/**
	 * @param purchaseQuantity
	 *            the purchaseQuantity to set
	 */
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	/**
	 * @return the vendorQty
	 */
	public int getVendorQty() {
		return vendorQty;
	}

	/**
	 * @param vendorQty
	 *            the vendorQty to set
	 */
	public void setVendorQty(int vendorQty) {
		this.vendorQty = vendorQty;
	}

	public boolean isBatchNoExist() {
		return batchNoExist;
	}

	public void setBatchNoExist(boolean batchNoExist) {
		this.batchNoExist = batchNoExist;
	}

	/**
	 * @return the batchDetails
	 */
	public ArrayList<GRNPurchaseOrderBean> getBatchDetails() {
		return batchDetails;
	}

	/**
	 * @param batchDetails
	 *            the batchDetails to set
	 */
	public void setBatchDetails(ArrayList<GRNPurchaseOrderBean> batchDetails) {
		this.batchDetails = batchDetails;
	}

	/**
	 * @return the batchDetailsConsignment
	 */
	public List<GRNPurchaseOrderBean> getBatchDetailsConsignment() {
		return batchDetailsConsignment;
	}

	/**
	 * @param batchDetailsConsignment
	 *            the batchDetailsConsignment to set
	 */
	public void setBatchDetailsConsignment(List<GRNPurchaseOrderBean> batchDetailsConsignment) {
		this.batchDetailsConsignment = batchDetailsConsignment;
	}

	/**
	 * @return the consignmentTransferQty
	 */
	public int getConsignmentTransferQty() {
		return consignmentTransferQty;
	}

	/**
	 * @param consignmentTransferQty
	 *            the consignmentTransferQty to set
	 */
	public void setConsignmentTransferQty(int consignmentTransferQty) {
		this.consignmentTransferQty = consignmentTransferQty;
	}

	/**
	 * @return the stockTransferDetailId
	 */
	public int getStockTransferDetailId() {
		return stockTransferDetailId;
	}

	/**
	 * @param stockTransferDetailId
	 *            the stockTransferDetailId to set
	 */
	public void setStockTransferDetailId(int stockTransferDetailId) {
		this.stockTransferDetailId = stockTransferDetailId;
	}

	public int getGinDetailId() {
		return ginDetailId;
	}

	public void setGinDetailId(int ginDetailId) {
		this.ginDetailId = ginDetailId;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

}
