package com.dci.payroll.master.professionalTaxSlab;

public class ProfessionalTaxSlabRateDetailBean {

	private String slabName;
	private int slabHdrId;
	private String rangeFromAmount;
	private String rangeToAmount;
	private String professionaltax;

	public String getSlabName() {
		return slabName;
	}

	public int getSlabHdrId() {
		return slabHdrId;
	}

	public void setSlabHdrId(int slabHdrId) {
		this.slabHdrId = slabHdrId;
	}

	public void setSlabName(String slabName) {
		this.slabName = slabName;
	}

	public String getRangeFromAmount() {
		return rangeFromAmount;
	}

	public void setRangeFromAmount(String rangeFromAmount) {
		this.rangeFromAmount = rangeFromAmount;
	}

	public String getRangeToAmount() {
		return rangeToAmount;
	}

	public void setRangeToAmount(String rangeToAmount) {
		this.rangeToAmount = rangeToAmount;
	}

	public String getProfessionaltax() {
		return professionaltax;
	}

	public void setProfessionaltax(String professionaltax) {
		this.professionaltax = professionaltax;
	}

}
