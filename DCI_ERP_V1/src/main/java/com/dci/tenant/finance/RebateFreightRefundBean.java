package com.dci.tenant.finance;

import java.util.ArrayList;

public class RebateFreightRefundBean {
	private String rebateRefundId;
	private String customerCode;
	private String customerName;
	private String fromDate;
	private String toDate;
	private String slabVolume;
	private String slabRevenue;
	private String slabPeriod;
	private String exceptionPortsExcluded;
	private String exceptionInvoicesExcluded;
	private String exceptionOthers;
	private String portsExcluded;
	private String invoicesExcluded;
	private String oneOffRate;
	private String oneOffSailings;
	private String rebateApproved;
	private String Remarks;
	private ArrayList<RebateFreightRefundDtlBean> slabsVolumeBasedList;
	private ArrayList<RebateFreightRefundDtlBean> slabsBasedPeriodList;

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getSlabVolume() {
		return slabVolume;
	}

	public void setSlabVolume(String slabVolume) {
		this.slabVolume = slabVolume;
	}

	public String getSlabRevenue() {
		return slabRevenue;
	}

	public void setSlabRevenue(String slabRevenue) {
		this.slabRevenue = slabRevenue;
	}

	public String getSlabPeriod() {
		return slabPeriod;
	}

	public void setSlabPeriod(String slabPeriod) {
		this.slabPeriod = slabPeriod;
	}

	public String getExceptionPortsExcluded() {
		return exceptionPortsExcluded;
	}

	public void setExceptionPortsExcluded(String exceptionPortsExcluded) {
		this.exceptionPortsExcluded = exceptionPortsExcluded;
	}

	public String getExceptionInvoicesExcluded() {
		return exceptionInvoicesExcluded;
	}

	public void setExceptionInvoicesExcluded(String exceptionInvoicesExcluded) {
		this.exceptionInvoicesExcluded = exceptionInvoicesExcluded;
	}

	public String getExceptionOthers() {
		return exceptionOthers;
	}

	public void setExceptionOthers(String exceptionOthers) {
		this.exceptionOthers = exceptionOthers;
	}

	public String getPortsExcluded() {
		return portsExcluded;
	}

	public void setPortsExcluded(String portsExcluded) {
		this.portsExcluded = portsExcluded;
	}

	public String getInvoicesExcluded() {
		return invoicesExcluded;
	}

	public void setInvoicesExcluded(String invoicesExcluded) {
		this.invoicesExcluded = invoicesExcluded;
	}

	public String getOneOffRate() {
		return oneOffRate;
	}

	public void setOneOffRate(String oneOffRate) {
		this.oneOffRate = oneOffRate;
	}

	public String getOneOffSailings() {
		return oneOffSailings;
	}

	public void setOneOffSailings(String oneOffSailings) {
		this.oneOffSailings = oneOffSailings;
	}

	public String getRebateApproved() {
		return rebateApproved;
	}

	public void setRebateApproved(String rebateApproved) {
		this.rebateApproved = rebateApproved;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public ArrayList<RebateFreightRefundDtlBean> getSlabsVolumeBasedList() {
		return slabsVolumeBasedList;
	}

	public void setSlabsVolumeBasedList(ArrayList<RebateFreightRefundDtlBean> slabsVolumeBasedList) {
		this.slabsVolumeBasedList = slabsVolumeBasedList;
	}

	public ArrayList<RebateFreightRefundDtlBean> getSlabsBasedPeriodList() {
		return slabsBasedPeriodList;
	}

	public void setSlabsBasedPeriodList(ArrayList<RebateFreightRefundDtlBean> slabsBasedPeriodList) {
		this.slabsBasedPeriodList = slabsBasedPeriodList;
	}

	public String getRebateRefundId() {
		return rebateRefundId;
	}

	public void setRebateRefundId(String rebateRefundId) {
		this.rebateRefundId = rebateRefundId;
	}

}
