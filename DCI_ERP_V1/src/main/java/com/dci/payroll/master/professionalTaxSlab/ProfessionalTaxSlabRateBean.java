package com.dci.payroll.master.professionalTaxSlab;

import java.util.List;

public class ProfessionalTaxSlabRateBean {

	private int slabHdrId;
	private String slabName;
	private String fromDate;
	private String toDate;
	private boolean savedSuccess;
	private boolean updated;
	private boolean deleted;
	private boolean edit;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	private double rangeFromAmount;
	private double rangeToAmount;
	private double professionaltax;
	private List<ProfessionalTaxSlabRateDetailBean> rateTable;
	private List<ProfessionalTaxSlabRateDetailBean> editTable;
	/*
	 * private String rangeFromAmount; private String rangeToAmount; private
	 * String professionaltax;
	 */

	public boolean isSavedSuccess() {
		return savedSuccess;
	}

	public List<ProfessionalTaxSlabRateDetailBean> getEditTable() {
		return editTable;
	}

	public void setEditTable(List<ProfessionalTaxSlabRateDetailBean> editTable) {
		this.editTable = editTable;
	}

	public int getSlabHdrId() {
		return slabHdrId;
	}

	public void setSlabHdrId(int slabHdrId) {
		this.slabHdrId = slabHdrId;
	}

	public void setSavedSuccess(boolean savedSuccess) {
		this.savedSuccess = savedSuccess;
	}

	public double getRangeFromAmount() {
		return rangeFromAmount;
	}

	public void setRangeFromAmount(double rangeFromAmount) {
		this.rangeFromAmount = rangeFromAmount;
	}

	public double getRangeToAmount() {
		return rangeToAmount;
	}

	public void setRangeToAmount(double rangeToAmount) {
		this.rangeToAmount = rangeToAmount;
	}

	public double getProfessionaltax() {
		return professionaltax;
	}

	public void setProfessionaltax(double professionaltax) {
		this.professionaltax = professionaltax;
	}

	public List<ProfessionalTaxSlabRateDetailBean> getRateTable() {
		return rateTable;
	}

	public void setRateTable(List<ProfessionalTaxSlabRateDetailBean> rateTable) {
		this.rateTable = rateTable;
	}

	public String getSlabName() {
		return slabName;
	}

	public void setSlabName(String slabName) {
		this.slabName = slabName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
