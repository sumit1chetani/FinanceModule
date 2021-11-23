package com.dci.inventory.stocktransfer;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.BatchAttributeBean;
import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;

/**
 * @author paragon
 *
 */
public class StockTransferBean {
	private String stockNumber;
	private String reqType;
	private double availableQTY;
	private String requisitionNo;
	private int issueType;
	private String issueTypeName;
	private String requisitionDetailId;
	private String requisitionId;

	public String getRequisitionDetailId() {
		return requisitionDetailId;
	}

	public void setRequisitionDetailId(String requisitionDetailId) {
		this.requisitionDetailId = requisitionDetailId;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getIssueTypeName() {
		return issueTypeName;
	}

	public void setIssueTypeName(String issueTypeName) {
		this.issueTypeName = issueTypeName;
	}

	public int getIssueType() {
		return issueType;
	}

	public void setIssueType(int issueType) {
		this.issueType = issueType;
	}

	public double getAvailableQTY() {
		return availableQTY;
	}

	public void setAvailableQTY(double availableQTY) {
		this.availableQTY = availableQTY;
	}

	public String getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	private String prNumber;

	public String getPrNumber() {
		return prNumber;
	}

	public void setPrNumber(String prNumber) {
		this.prNumber = prNumber;
	}

	public String getRequisitionNumber() {
		return requisitionNumber;
	}

	public void setRequisitionNumber(String requisitionNumber) {
		this.requisitionNumber = requisitionNumber;
	}

	private String requisitionNumber;
	private String id;
	private String text;
	private String itemName;
	private String itemDesc;
	private double prquantity;
	private double quantity;
	private double pendingQuantity;
	private String issueSlip;
	private double checkQuantity;

	public double getCheckQuantity() {
		return checkQuantity;
	}

	public void setCheckQuantity(double checkQuantity) {
		this.checkQuantity = checkQuantity;
	}

	public String getIssueSlip() {
		return issueSlip;
	}

	public void setIssueSlip(String issueSlip) {
		this.issueSlip = issueSlip;
	}

	private String reqDate;
	private String reqBy;
	private String uom;
	private List<BatchAttributeBean> attributeBeans;
	private boolean isBatchNoExist = false;

	private int deliveryMet;
	private int destLoc;
	private String vendorId;
	private String requestNumber;
	private int requsitionDtlId;
	private int requsitionId;

	public int getRequsitionDtlId() {
		return requsitionDtlId;
	}

	public void setRequsitionDtlId(int requsitionDtlId) {
		this.requsitionDtlId = requsitionDtlId;
	}

	public int getRequsitionId() {
		return requsitionId;
	}

	public void setRequsitionId(int requsitionId) {
		this.requsitionId = requsitionId;
	}

	public String getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	public double getPendingQuantity() {
		return pendingQuantity;
	}

	public void setPendingQuantity(double pendingQuantity) {
		this.pendingQuantity = pendingQuantity;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	private String personName;
	private int requisition;
	private String requisitionBy;
	private String requisitionDate;
	private int sourceLoc;
	private String status;
	private int transportType;
	private String itemCode;
	private String sourceLocName;
	private String destLocName;
	private String stockId;
	private String reason;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	private double amount;
	private double quantityn;

	private String date;
	private double reqQuantity;
	private String serviceName;
	private int reqDetailId;
	private int transferQty;
	private String deliveryMethod;
	private String transportPort;
	private int stockDtlId;
	private List<StockTransferBean> itemlist;
	private ArrayList<StockTransferBean> ldeltedIds;
	private ArrayList<StockTransferBean> rowCollection;
	private ArrayList<GRNPurchaseOrderBean> batchDetails;
	private List<GRNPurchaseOrderBean> stockTransferBatchList;
	private String companyId;
	private String companyName;

	private double originalQty;
	private boolean disable;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getQuantityn() {
		return quantityn;
	}

	public void setQuantityn(double quantityn) {
		this.quantityn = quantityn;
	}

	public double getOriginalQty() {
		return originalQty;
	}

	public void setOriginalQty(double originalQty) {
		this.originalQty = originalQty;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public double getPrquantity() {
		return prquantity;
	}

	public void setPrquantity(double prquantity) {
		this.prquantity = prquantity;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getReqBy() {
		return reqBy;
	}

	public void setReqBy(String reqBy) {
		this.reqBy = reqBy;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getDeliveryMet() {
		return deliveryMet;
	}

	public void setDeliveryMet(int deliveryMet) {
		this.deliveryMet = deliveryMet;
	}

	public int getDestLoc() {
		return destLoc;
	}

	public void setDestLoc(int destLoc) {
		this.destLoc = destLoc;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getRequisition() {
		return requisition;
	}

	public void setRequisition(int requisition) {
		this.requisition = requisition;
	}

	public String getRequisitionBy() {
		return requisitionBy;
	}

	public void setRequisitionBy(String requisitionBy) {
		this.requisitionBy = requisitionBy;
	}

	public String getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(String requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public int getSourceLoc() {
		return sourceLoc;
	}

	public void setSourceLoc(int sourceLoc) {
		this.sourceLoc = sourceLoc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTransportType() {
		return transportType;
	}

	public void setTransportType(int transportType) {
		this.transportType = transportType;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getSourceLocName() {
		return sourceLocName;
	}

	public void setSourceLocName(String sourceLocName) {
		this.sourceLocName = sourceLocName;
	}

	public String getDestLocName() {
		return destLocName;
	}

	public void setDestLocName(String destLocName) {
		this.destLocName = destLocName;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<StockTransferBean> getRowCollection() {
		return rowCollection;
	}

	public void setRowCollection(ArrayList<StockTransferBean> rowCollection) {
		this.rowCollection = rowCollection;
	}

	public double getReqQuantity() {
		return reqQuantity;
	}

	public void setReqQuantity(double reqQuantity) {
		this.reqQuantity = reqQuantity;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getReqDetailId() {
		return reqDetailId;
	}

	public void setReqDetailId(int reqDetailId) {
		this.reqDetailId = reqDetailId;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getTransportPort() {
		return transportPort;
	}

	public void setTransportPort(String transportPort) {
		this.transportPort = transportPort;
	}

	public int getStockDtlId() {
		return stockDtlId;
	}

	public void setStockDtlId(int stockDtlId) {
		this.stockDtlId = stockDtlId;
	}

	public List<StockTransferBean> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<StockTransferBean> itemlist) {
		this.itemlist = itemlist;
	}

	public ArrayList<StockTransferBean> getLdeltedIds() {
		return ldeltedIds;
	}

	public void setLdeltedIds(ArrayList<StockTransferBean> ldeltedIds) {
		this.ldeltedIds = ldeltedIds;
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

	public boolean isBatchNoExist() {
		return isBatchNoExist;
	}

	public void setBatchNoExist(boolean isBatchNoExist) {
		this.isBatchNoExist = isBatchNoExist;
	}

	public ArrayList<GRNPurchaseOrderBean> getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(ArrayList<GRNPurchaseOrderBean> batchDetails) {
		this.batchDetails = batchDetails;
	}

	public List<GRNPurchaseOrderBean> getStockTransferBatchList() {
		return stockTransferBatchList;
	}

	public void setStockTransferBatchList(List<GRNPurchaseOrderBean> stockTransferBatchList) {
		this.stockTransferBatchList = stockTransferBatchList;
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

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

}
