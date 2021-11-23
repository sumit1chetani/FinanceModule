package com.dci.finance.storeToPurchase;

import com.dci.master.settings.UOM.EntityBean;

public class StoreToPurchase extends EntityBean {
	private int purchaseRequisitionId;
	private String requisitionNumber;
	private String requisitionDate;
	private String employeeId;// requested_by
	private String employeeName;
	private Integer requisitionType;
	private String designationName;// Job Tittle
	private Integer sourceLocation;
	private String destinationLocationName;
	private String sourceLocationName;
	private String destinationLocation;
	private Integer designationId;
	private Integer requisitionStatus;
	private String requisitionStatusName;
	private String companyId;
	private String companyName;

	private boolean isselect;

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

	private String id;
	private String text;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	private String locationName;

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getPurchaseRequisitionId() {
		return purchaseRequisitionId;
	}

	public void setPurchaseRequisitionId(int purchaseRequisitionId) {
		this.purchaseRequisitionId = purchaseRequisitionId;
	}

	public String getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(String requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getRequisitionType() {
		return requisitionType;
	}

	public void setRequisitionType(Integer requisitionType) {
		this.requisitionType = requisitionType;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public Integer getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(Integer sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	public String getDestinationLocationName() {
		return destinationLocationName;
	}

	public void setDestinationLocationName(String destinationLocationName) {
		this.destinationLocationName = destinationLocationName;
	}

	public String getSourceLocationName() {
		return sourceLocationName;
	}

	public void setSourceLocationName(String sourceLocationName) {
		this.sourceLocationName = sourceLocationName;
	}

	public String getRequisitionNumber() {
		return requisitionNumber;
	}

	public void setRequisitionNumber(String requisitionNumber) {
		this.requisitionNumber = requisitionNumber;
	}

	public Integer getRequisitionStatus() {
		return requisitionStatus;
	}

	public void setRequisitionStatus(Integer requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}

	public String getRequisitionStatusName() {
		return requisitionStatusName;
	}

	public void setRequisitionStatusName(String requisitionStatusName) {
		this.requisitionStatusName = requisitionStatusName;
	}

	public boolean isIsselect() {
		return isselect;
	}

	public void setIsselect(boolean isselect) {
		this.isselect = isselect;
	}

}
