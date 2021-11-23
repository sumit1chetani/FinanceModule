package com.dci.payroll.tds.taxsection;

public class TaxsectionBean {
	private String taxSectionCode;
	private String taxSectionDescription;
	private int taxSectionMaxLimit;
	private int displayOrder;
	private Boolean taxSectionStatus;
	private boolean isEdit; // Button Change While Adding and Updating
	private String id;
	private String text;

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

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getTaxSectionCode() {
		return taxSectionCode;
	}

	public void setTaxSectionCode(String taxSectionCode) {
		this.taxSectionCode = taxSectionCode;
	}

	public String getTaxSectionDescription() {
		return taxSectionDescription;
	}

	public void setTaxSectionDescription(String taxSectionDescription) {
		this.taxSectionDescription = taxSectionDescription;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public int getTaxSectionMaxLimit() {
		return taxSectionMaxLimit;
	}

	public void setTaxSectionMaxLimit(int taxSectionMaxLimit) {
		this.taxSectionMaxLimit = taxSectionMaxLimit;
	}

	public Boolean getTaxSectionStatus() {
		return taxSectionStatus;
	}

	public void setTaxSectionStatus(Boolean taxSectionStatus) {
		this.taxSectionStatus = taxSectionStatus;
	}
}
