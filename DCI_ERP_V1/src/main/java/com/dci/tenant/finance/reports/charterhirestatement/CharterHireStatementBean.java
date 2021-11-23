package com.dci.tenant.finance.reports.charterhirestatement;

import java.util.ArrayList;

public class CharterHireStatementBean {

	private String charterHireNo;
	private String charterDate;
	private String chFromDate;
	private String chToDate;
	private String vesselCode;
	private String vesselName;
	private String currencyCode;
	private Integer noOfDays;
	private Double exchangeRate;
	private Double totalCharges;

	private Double commissionPercent;
	private Double totalChargesWithCommission;
	private Double charExpenseComn;
	private Double charExpenRep;
	private Double charLashingExpen;
	private Double charterExpenseCharges;
	private Double ownersExpAcct1;
	private Double ownersExpAcct2;
	private Double ownersExpAcct3;
	private Double ownersExpenceCharges;
	private Double deliveryBunkerFO;
	private Double deliveryBunkerRate;
	private Double deliveryBunkerCharges;
	private Double redeliveryFO;
	private Double redeliveryRate;
	private Double redeliveryBunkerCharges;
	private Double nettDueToOwnerCharges;

	private ArrayList<CharterHireStatementBean> rowData;

	public String getCharterHireNo() {
		return charterHireNo;
	}

	public String getCharterDate() {
		return charterDate;
	}

	public String getChFromDate() {
		return chFromDate;
	}

	public String getChToDate() {
		return chToDate;
	}

	public String getVesselCode() {
		return vesselCode;
	}

	public String getVesselName() {
		return vesselName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public Double getTotalCharges() {
		return totalCharges;
	}

	public Double getCommissionPercent() {
		return commissionPercent;
	}

	public Double getTotalChargesWithCommission() {
		return totalChargesWithCommission;
	}

	public Double getCharExpenseComn() {
		return charExpenseComn;
	}

	public Double getCharExpenRep() {
		return charExpenRep;
	}

	public Double getCharLashingExpen() {
		return charLashingExpen;
	}

	public Double getCharterExpenseCharges() {
		return charterExpenseCharges;
	}

	public Double getOwnersExpAcct1() {
		return ownersExpAcct1;
	}

	public Double getOwnersExpAcct2() {
		return ownersExpAcct2;
	}

	public Double getOwnersExpAcct3() {
		return ownersExpAcct3;
	}

	public Double getOwnersExpenceCharges() {
		return ownersExpenceCharges;
	}

	public Double getDeliveryBunkerFO() {
		return deliveryBunkerFO;
	}

	public Double getDeliveryBunkerRate() {
		return deliveryBunkerRate;
	}

	public Double getDeliveryBunkerCharges() {
		return deliveryBunkerCharges;
	}

	public Double getRedeliveryFO() {
		return redeliveryFO;
	}

	public Double getRedeliveryRate() {
		return redeliveryRate;
	}

	public Double getRedeliveryBunkerCharges() {
		return redeliveryBunkerCharges;
	}

	public Double getNettDueToOwnerCharges() {
		return nettDueToOwnerCharges;
	}

	public void setCharterHireNo(String charterHireNo) {
		this.charterHireNo = charterHireNo;
	}

	public void setCharterDate(String charterDate) {
		this.charterDate = charterDate;
	}

	public void setChFromDate(String chFromDate) {
		this.chFromDate = chFromDate;
	}

	public void setChToDate(String chToDate) {
		this.chToDate = chToDate;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public void setTotalCharges(Double totalCharges) {
		this.totalCharges = totalCharges;
	}

	public void setCommissionPercent(Double commissionPercent) {
		this.commissionPercent = commissionPercent;
	}

	public void setTotalChargesWithCommission(Double totalChargesWithCommission) {
		this.totalChargesWithCommission = totalChargesWithCommission;
	}

	public void setCharExpenseComn(Double charExpenseComn) {
		this.charExpenseComn = charExpenseComn;
	}

	public void setCharExpenRep(Double charExpenRep) {
		this.charExpenRep = charExpenRep;
	}

	public void setCharLashingExpen(Double charLashingExpen) {
		this.charLashingExpen = charLashingExpen;
	}

	public void setCharterExpenseCharges(Double charterExpenseCharges) {
		this.charterExpenseCharges = charterExpenseCharges;
	}

	public void setOwnersExpAcct1(Double ownersExpAcct1) {
		this.ownersExpAcct1 = ownersExpAcct1;
	}

	public void setOwnersExpAcct2(Double ownersExpAcct2) {
		this.ownersExpAcct2 = ownersExpAcct2;
	}

	public void setOwnersExpAcct3(Double ownersExpAcct3) {
		this.ownersExpAcct3 = ownersExpAcct3;
	}

	public void setOwnersExpenceCharges(Double ownersExpenceCharges) {
		this.ownersExpenceCharges = ownersExpenceCharges;
	}

	public void setDeliveryBunkerFO(Double deliveryBunkerFO) {
		this.deliveryBunkerFO = deliveryBunkerFO;
	}

	public void setDeliveryBunkerRate(Double deliveryBunkerRate) {
		this.deliveryBunkerRate = deliveryBunkerRate;
	}

	public void setDeliveryBunkerCharges(Double deliveryBunkerCharges) {
		this.deliveryBunkerCharges = deliveryBunkerCharges;
	}

	public void setRedeliveryFO(Double redeliveryFO) {
		this.redeliveryFO = redeliveryFO;
	}

	public void setRedeliveryRate(Double redeliveryRate) {
		this.redeliveryRate = redeliveryRate;
	}

	public void setRedeliveryBunkerCharges(Double redeliveryBunkerCharges) {
		this.redeliveryBunkerCharges = redeliveryBunkerCharges;
	}

	public void setNettDueToOwnerCharges(Double nettDueToOwnerCharges) {
		this.nettDueToOwnerCharges = nettDueToOwnerCharges;
	}

	public ArrayList<CharterHireStatementBean> getRowData() {
		return rowData;
	}

	public void setRowData(ArrayList<CharterHireStatementBean> rowData) {
		this.rowData = rowData;
	}

}
