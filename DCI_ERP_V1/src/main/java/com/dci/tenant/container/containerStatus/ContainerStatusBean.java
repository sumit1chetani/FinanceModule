package com.dci.tenant.container.containerStatus;

public class ContainerStatusBean {
	public String containerStatusCode;
	public boolean depot;
	public boolean customer;
	public boolean shipper;
	public boolean consignee;
	public boolean vessel;
	public boolean voyage;

	public boolean pol;
	public boolean pod;



	public String containerStatusDescription;
	public Boolean isSuccess;
	public String message;
	private String createdDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private String subCode;
	private String subCodeDesc;
	
	
	
	

	public boolean isDepot() {
		return depot;
	}
	public void setDepot(boolean depot) {
		this.depot = depot;
	}
	public boolean isCustomer() {
		return customer;
	}
	public void setCustomer(boolean customer) {
		this.customer = customer;
	}
	public boolean isShipper() {
		return shipper;
	}
	public void setShipper(boolean shipper) {
		this.shipper = shipper;
	}
	public boolean isConsignee() {
		return consignee;
	}
	public void setConsignee(boolean consignee) {
		this.consignee = consignee;
	}
	public boolean isVessel() {
		return vessel;
	}
	public void setVessel(boolean vessel) {
		this.vessel = vessel;
	}
	public boolean isVoyage() {
		return voyage;
	}
	public void setVoyage(boolean voyage) {
		this.voyage = voyage;
	}
	public boolean isPol() {
		return pol;
	}
	public void setPol(boolean pol) {
		this.pol = pol;
	}
	public boolean isPod() {
		return pod;
	}
	public void setPod(boolean pod) {
		this.pod = pod;
	}
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getContainerStatusCode() {
		return containerStatusCode;
	}
	public void setContainerStatusCode(String containerStatusCode) {
		this.containerStatusCode = containerStatusCode;
	}
	public String getContainerStatusDescription() {
		return containerStatusDescription;
	}
	public void setContainerStatusDescription(String containerStatusDescription) {
		this.containerStatusDescription = containerStatusDescription;
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
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getSubCodeDesc() {
		return subCodeDesc;
	}
	public void setSubCodeDesc(String subCodeDesc) {
		this.subCodeDesc = subCodeDesc;
	}
	
	

}
