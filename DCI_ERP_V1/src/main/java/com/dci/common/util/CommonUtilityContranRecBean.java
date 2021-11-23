package com.dci.common.util;

import java.util.ArrayList;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;


@AuditLoggableType(tableName = "stock_transfer", formCode = "F5200")
public class CommonUtilityContranRecBean {

	private Integer stockId; // stock_transfer_id
	private String stockNo; // stock_transfer_number
	private String stockDate; // stock_transfer_date
	private Integer transportType; // transport_type
	private String serviceName; // service_name
	private String personName;// person_name
	private Integer requisitionId; // purchase_requisition_id
	private String requisitionDate;
	private Integer deliveryMethod; // delivery_method
	private String status; // status
	private Integer entityId; // entity_id
	private String reason; // reason
	private Integer sourceLocation;// source_location
	private Integer destLocation; // destination_location
	private Integer stockType;// stock_type
	private String receivedBy;// received_by
	private Integer quotationId; // purchase_quot_id
	private ArrayList<CommonUtilityStockDetailBean> stockDetTables;
	private ArrayList<CommonUtillityAssetTrackDetailBean> assetTrackDetails;
	private ArrayList<CommonUtilityStockDetailBean> ldetedIds;
	private Integer consignmentInId; // consignment_in_id
	private Integer stockIndentId;
	private String companyId;
	private String vendorId;
	private int stockOutId;	
	private String tableName;
	private String formCode;	

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public ArrayList<CommonUtilityStockDetailBean> getLdetedIds() {
		return ldetedIds;
	}

	public void setLdetedIds(ArrayList<CommonUtilityStockDetailBean> ldetedIds) {
		this.ldetedIds = ldetedIds;
	}

	public int getStockOutId() {
		return stockOutId;
	}

	public void setStockOutId(int stockOutId) {
		this.stockOutId = stockOutId;
	}

	@AuditLoggable(fieldName = "entity_id", displayName = "vendorId")
	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	@AuditLoggable(fieldName = "company_id", displayName = "companyId")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Integer getConsignmentInId() {
		return consignmentInId;
	}

	public void setConsignmentInId(Integer consignmentInId) {
		this.consignmentInId = consignmentInId;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockNo() {
		return stockNo;
	}

	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}

	public String getStockDate() {
		return stockDate;
	}

	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}

	@AuditLoggable(fieldName = "transportType", displayName = "transportType")
	public Integer getTransportType() {
		return transportType;
	}

	public void setTransportType(Integer transportType) {
		this.transportType = transportType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(Integer requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(String requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public Integer getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(Integer deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	@AuditLoggable(fieldName = "status", displayName = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	@AuditLoggable(fieldName = "reason", displayName = "reason")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@AuditLoggable(fieldName = "source_location", displayName = "sourceLocation")
	public Integer getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(Integer sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	@AuditLoggable(fieldName = "destination_location", displayName = "destLocation")
	public Integer getDestLocation() {
		return destLocation;
	}

	public void setDestLocation(Integer destLocation) {
		this.destLocation = destLocation;
	}

	public Integer getStockType() {
		return stockType;
	}

	public void setStockType(Integer stockType) {
		this.stockType = stockType;
	}

	@AuditLoggable(fieldName = "received_by", displayName = "receivedBy")
	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public ArrayList<CommonUtilityStockDetailBean> getStockDetTables() {
		return stockDetTables;
	}

	public void setStockDetTables(ArrayList<CommonUtilityStockDetailBean> stockDetTables) {
		this.stockDetTables = stockDetTables;
	}

	public Integer getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Integer quotationId) {
		this.quotationId = quotationId;
	}

	public Integer getStockIndentId() {
		return stockIndentId;
	}

	public void setStockIndentId(Integer stockIndentId) {
		this.stockIndentId = stockIndentId;
	}

	/**
	 * @return the assetTrackDetails
	 */
	public ArrayList<CommonUtillityAssetTrackDetailBean> getAssetTrackDetails() {
		return assetTrackDetails;
	}

	/**
	 * @param assetTrackDetails
	 *            the assetTrackDetails to set
	 */
	public void setAssetTrackDetails(ArrayList<CommonUtillityAssetTrackDetailBean> assetTrackDetails) {
		this.assetTrackDetails = assetTrackDetails;
	}

}
