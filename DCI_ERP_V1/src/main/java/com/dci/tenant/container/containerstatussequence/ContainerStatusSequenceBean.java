package com.dci.tenant.container.containerstatussequence;

import java.util.List;

public class ContainerStatusSequenceBean {
	
	
	public String direction;
	public String sequence;
	public String status;
	public String text;
	public String id;
	public Boolean isSuccess;
	public String message;
	private String createdDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private String sequenceS;		
	private List<ContainerStatusSequenceBean> sequenceM ;		
			
	
	private List<ContainerStatusSequenceBean> containerstatussequenceDtl;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public List<ContainerStatusSequenceBean> getContainerstatussequenceDtl() {
		return containerstatussequenceDtl;
	}

	public void setContainerstatussequenceDtl(
			List<ContainerStatusSequenceBean> containerstatussequenceDtl) {
		this.containerstatussequenceDtl = containerstatussequenceDtl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSequenceS() {
		return sequenceS;
	}

	public void setSequenceS(String sequenceS) {
		this.sequenceS = sequenceS;
	}

	public List<ContainerStatusSequenceBean> getSequenceM() {
		return sequenceM;
	}

	public void setSequenceM(List<ContainerStatusSequenceBean> sequenceM) {
		this.sequenceM = sequenceM;
	}

	

	

	
	

	

}
