package com.dci.payroll.tds.taxsubsection;

public class TaxSubSectionBean {
	private String taxSubSectionCode;
	private String taxSectionCode;
	private String taxSubSectionDescription;
	private int taxSubSectionMaxLimit;
	private boolean computed;
	private int displayOrder;
	private boolean taxSubSectionStatus;
	private boolean isEdit;

	public String getTaxSubSectionCode() {
		return taxSubSectionCode;
	}

	public void setTaxSubSectionCode(String taxSubSectionCode) {
		this.taxSubSectionCode = taxSubSectionCode;
	}

	public String getTaxSectionCode() {
		return taxSectionCode;
	}

	public void setTaxSectionCode(String taxSectionCode) {
		this.taxSectionCode = taxSectionCode;
	}

	public String getTaxSubSectionDescription() {
		return taxSubSectionDescription;
	}

	public void setTaxSubSectionDescription(String taxSubSectionDescription) {
		this.taxSubSectionDescription = taxSubSectionDescription;
	}

	public int getTaxSubSectionMaxLimit() {
		return taxSubSectionMaxLimit;
	}

	public void setTaxSubSectionMaxLimit(int taxSubSectionMaxLimit) {
		this.taxSubSectionMaxLimit = taxSubSectionMaxLimit;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public boolean isTaxSubSectionStatus() {
		return taxSubSectionStatus;
	}

	public void setTaxSubSectionStatus(boolean taxSubSectionStatus) {
		this.taxSubSectionStatus = taxSubSectionStatus;
	}

	public boolean isComputed() {
		return computed;
	}

	public void setComputed(boolean computed) {
		this.computed = computed;
	}

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
}