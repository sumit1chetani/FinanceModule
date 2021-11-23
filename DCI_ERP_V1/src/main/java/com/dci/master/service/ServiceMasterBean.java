package com.dci.master.service;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "sector_master", formCode = "F6067")
public class ServiceMasterBean {

	private String sectorCode;
	private String sectorName;
	private long sectorSlnoNumber;
	private String operationSince;
	private String  serviceLoc;
	private String eqmtCntrlEnable;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
	private String isActive;
	private String commenceDate;
	private String completionDate;
	private String companyCode;
	private String companyName;
	private String shortName;	
	private String comLocation;
	private String companyLocation;
	private String id;
	
	private boolean isSuccess;
	private String message;
	
	private String branchName;
	
	private String vesselOperator;
	
	private Double avgtrans= 0.0;
	
	private Double sailingfreq = 0.0;
	
	private String vendorName;
	
	
	
	
public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

public Double getAvgtrans() {
		return avgtrans;
	}

	public void setAvgtrans(Double avgtrans) {
		this.avgtrans = avgtrans;
	}

	public Double getSailingfreq() {
		return sailingfreq;
	}

	public void setSailingfreq(Double sailingfreq) {
		this.sailingfreq = sailingfreq;
	}

	/*
	public double getAvgtrans() {
		return avgtrans;
	}

	public void setAvgtrans(double avgtrans) {
		this.avgtrans = avgtrans;
	}

	public double getSailingfreq() {
		return sailingfreq;
	}

	public void setSailingfreq(double sailingfreq) {
		this.sailingfreq = sailingfreq;
	}
*/
	public String getVesselOperator() {
		return vesselOperator;
	}

	public void setVesselOperator(String vesselOperator) {
		this.vesselOperator = vesselOperator;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	private String text;
	private boolean isEdit;

	@AuditLoggable(fieldName = "sector_code", displayName = "Service Code")
	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}

	@AuditLoggable(fieldName = "sector_name", displayName = "Service Name")
	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	@AuditLoggable(fieldName = "operation_since", displayName = "Operation Since")
	public String getOperationSince() {
		return operationSince;
	}

	public void setOperationSince(String operationSince) {
		this.operationSince = operationSince;
	}

	@AuditLoggable(fieldName = "eqpt_cntrl", displayName = "Equipment Control Enabled")
	public String getEqmtCntrlEnable() {
		return eqmtCntrlEnable;
	}

	public void setEqmtCntrlEnable(String eqmtCntrlEnable) {
		this.eqmtCntrlEnable = eqmtCntrlEnable;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@AuditLoggable(fieldName = "sector_active", displayName = "Active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@AuditLoggable(fieldName = "commencement Date", displayName = "Commencement Date")
	public String getCommenceDate() {
		return commenceDate;
	}

	public void setCommenceDate(String commenceDate) {
		this.commenceDate = commenceDate;
	}

	@AuditLoggable(fieldName = "completion_date", displayName = "Completion Date")
	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	@AuditLoggable(fieldName = "sec_company_code", displayName = "Company Location")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	
	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public long getSectorSlnoNumber() {
		return sectorSlnoNumber;
	}

	public void setSectorSlnoNumber(long sectorSlnoNumber) {
		this.sectorSlnoNumber = sectorSlnoNumber;
	}

	public String getComLocation() {
		return comLocation;
	}

	public void setComLocation(String comLocation) {
		this.comLocation = comLocation;
	}

	public String getServiceLoc() {
		return serviceLoc;
	}

	public void setServiceLoc(String serviceLoc) {
		this.serviceLoc = serviceLoc;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
