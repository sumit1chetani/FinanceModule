package com.dci.payroll.payroll.fullfinalsettlement;

public class FullFinalSettlementDetailBean {
	private int employeeFinalSettlementDtlId;
	private double credit;
	private double debit;
	private int slNo;
	private boolean select;
	private String description;
	private String employeeFinalSettlementId;

	public int getEmployeeFinalSettlementDtlId() {
		return employeeFinalSettlementDtlId;
	}

	public void setEmployeeFinalSettlementDtlId(int employeeFinalSettlementDtlId) {
		this.employeeFinalSettlementDtlId = employeeFinalSettlementDtlId;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmployeeFinalSettlementId() {
		return employeeFinalSettlementId;
	}

	public void setEmployeeFinalSettlementId(String employeeFinalSettlementId) {
		this.employeeFinalSettlementId = employeeFinalSettlementId;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}
}
