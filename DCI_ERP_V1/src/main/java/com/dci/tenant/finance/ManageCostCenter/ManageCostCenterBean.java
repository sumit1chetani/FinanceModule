package com.dci.tenant.finance.ManageCostCenter;

public class ManageCostCenterBean {
	private String costCenterName;
	private String costCenter;
	private Integer costCenterId;
	private String id;
	private String text;
	private String companyId;

	private String costCenterCode;
	private String costCenterDescription;
	private boolean status;
	private boolean isEdit; // Button Change While Adding and Updating

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public Integer getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(Integer costCenterId) {
		this.costCenterId = costCenterId;
	}

	public String getCostCenterCode() {
		return costCenterCode;
	}

	public void setCostCenterCode(String costCenterCode) {
		this.costCenterCode = costCenterCode;
	}

	public String getCostCenterDescription() {
		return costCenterDescription;
	}

	public void setCostCenterDescription(String costCenterDescription) {
		this.costCenterDescription = costCenterDescription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

}