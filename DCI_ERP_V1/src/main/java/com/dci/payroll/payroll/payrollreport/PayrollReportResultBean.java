package com.dci.payroll.payroll.payrollreport;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dci.common.util.BasicResultBean;


public class PayrollReportResultBean extends BasicResultBean implements Serializable {
	private List<PayrollReportBean> payRollReportList;

	private List<Map<String, Object>> payRollList;

	private List<Map<String, Object>> monthlyPayRollList;

	public List<PayrollReportBean> getPayRollReportList() {
		return payRollReportList;
	}

	public void setPayRollReportList(List<PayrollReportBean> payRollReportList) {
		this.payRollReportList = payRollReportList;
	}

	public List<Map<String, Object>> getPayRollList() {
		return payRollList;
	}

	public void setPayRollList(List<Map<String, Object>> payRollList) {
		this.payRollList = payRollList;
	}

	public List<Map<String, Object>> getMonthlyPayRollList() {
		return monthlyPayRollList;
	}

	public void setMonthlyPayRollList(List<Map<String, Object>> monthlyPayRollList) {
		this.monthlyPayRollList = monthlyPayRollList;
	}

}