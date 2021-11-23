package com.dci.payroll.tds.NscInterest;

import java.math.BigDecimal;

public class NscInterestBean {
	private String financialYear;
	private BigDecimal rateOfInterest;
	private boolean isEdit; // Button Change While Adding and Updating

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public BigDecimal getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(BigDecimal rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

}
