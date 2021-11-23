package com.dci.payroll.payroll.rate;

public class RateBean {

	private int rangeFrom;
	private int rangeTo;
	private double unitCharge;

	private int id;

	public int getRangeFrom() {
		return rangeFrom;
	}

	public void setRangeFrom(int rangeFrom) {
		this.rangeFrom = rangeFrom;
	}

	public int getRangeTo() {
		return rangeTo;
	}

	public void setRangeTo(int rangeTo) {
		this.rangeTo = rangeTo;
	}

	public double getUnitCharge() {
		return unitCharge;
	}

	public void setUnitCharge(double unitCharge) {
		this.unitCharge = unitCharge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
