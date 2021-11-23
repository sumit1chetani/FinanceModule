package com.dci.inventory.consignmentIn;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.BatchAttributeBean;
import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;

public class ConsignmentInBean {

	private int consignmentInId;

	private String consignmentInNo;
	private String consignmentInDate;
	private int transportType;
	private int sourceLocName;
	private int destinationLocName;
	private String requisitionDate;
	private String receivedBy;
	private String stockReason;
	private String status;
	private String personName;
	private String serviceName;
	private int deliveryMet;
	private int vendor;
	private String vendorName;
	private Integer requisition = 0;

	private Integer quotation;
	private String quotationNo;

	private String parentLocation;
	private List<ConsignmentInDetailBean> deletedIds;

	private List<ConsignmentInDetailBean> quotList;
	private String companyId;
	private String companyName;

	private List<BatchAttributeBean> attributeBeans;
	private ArrayList<ConsignmentInDetailBean> rowCollection;
	private ArrayList<GRNPurchaseOrderBean> batchDetails;
	private List<GRNPurchaseOrderBean> stockTransferBatchList;

	public List<BatchAttributeBean> getAttributeBeans() {
		return attributeBeans;
	}

	public void setAttributeBeans(List<BatchAttributeBean> attributeBeans) {
		this.attributeBeans = attributeBeans;
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

	public String getParentLocation() {
		return parentLocation;
	}

	public void setParentLocation(String parentLocation) {
		this.parentLocation = parentLocation;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	private Integer id;
	private String text;

	private ArrayList<ConsignmentInDetailBean> consignmentIntables;

	public int getTransportType() {
		return transportType;
	}

	public void setTransportType(int transportType) {
		this.transportType = transportType;
	}

	public int getSourceLocName() {
		return sourceLocName;
	}

	public void setSourceLocName(int sourceLocName) {
		this.sourceLocName = sourceLocName;
	}

	public int getDestinationLocName() {
		return destinationLocName;
	}

	public void setDestinationLocName(int destinationLocName) {
		this.destinationLocName = destinationLocName;
	}

	public String getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(String requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public String getStockReason() {
		return stockReason;
	}

	public void setStockReason(String stockReason) {
		this.stockReason = stockReason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getDeliveryMet() {
		return deliveryMet;
	}

	public void setDeliveryMet(int deliveryMet) {
		this.deliveryMet = deliveryMet;
	}

	public String getConsignmentInDate() {
		return consignmentInDate;
	}

	public void setConsignmentInDate(String consignmentInDate) {
		this.consignmentInDate = consignmentInDate;
	}

	public String getConsignmentInNo() {
		return consignmentInNo;
	}

	public void setConsignmentInNo(String consignmentInNo) {
		this.consignmentInNo = consignmentInNo;
	}

	public int getConsignmentInId() {
		return consignmentInId;
	}

	public void setConsignmentInId(int consignmentInId) {
		this.consignmentInId = consignmentInId;
	}

	public int getVendor() {
		return vendor;
	}

	public void setVendor(int vendor) {
		this.vendor = vendor;
	}

	public ArrayList<ConsignmentInDetailBean> getConsignmentIntables() {
		return consignmentIntables;
	}

	public void setConsignmentIntables(ArrayList<ConsignmentInDetailBean> consignmentIntables) {
		this.consignmentIntables = consignmentIntables;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRequisition() {
		return requisition;
	}

	public void setRequisition(Integer requisition) {
		this.requisition = requisition;
	}

	public Integer getQuotation() {
		return quotation;
	}

	public void setQuotation(Integer quotation) {
		this.quotation = quotation;
	}

	public List<ConsignmentInDetailBean> getQuotList() {
		return quotList;
	}

	public void setQuotList(List<ConsignmentInDetailBean> quotList) {
		this.quotList = quotList;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public List<ConsignmentInDetailBean> getDeletedIds() {
		return deletedIds;
	}

	public void setDeletedIds(List<ConsignmentInDetailBean> deletedIds) {
		this.deletedIds = deletedIds;
	}

	public ArrayList<ConsignmentInDetailBean> getRowCollection() {
		return rowCollection;
	}

	public void setRowCollection(ArrayList<ConsignmentInDetailBean> rowCollection) {
		this.rowCollection = rowCollection;
	}

}
