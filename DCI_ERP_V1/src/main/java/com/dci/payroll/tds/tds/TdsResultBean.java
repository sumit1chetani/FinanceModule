package com.dci.payroll.tds.tds;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dci.common.util.BasicResultBean;


public class TdsResultBean extends BasicResultBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<TdsBean> tdsSlabList = null;

	private TdsBean monthbean = null;

	private List<Map<String, Object>> tdsPayList = null;

	private List<Map<String, Object>> tdsSubSectionList = null;

	private List<Map<String, Object>> tdsOtherIncomeList = null;

	public List<TdsBean> getTdsSlabList() {
		return tdsSlabList;
	}

	public void setTdsSlabList(List<TdsBean> tdsSlabList) {
		this.tdsSlabList = tdsSlabList;
	}

	public List<Map<String, Object>> getTdsPayList() {
		return tdsPayList;
	}

	public void setTdsPayList(List<Map<String, Object>> tdsPayList) {
		this.tdsPayList = tdsPayList;
	}

	public List<Map<String, Object>> getTdsSubSectionList() {
		return tdsSubSectionList;
	}

	public void setTdsSubSectionList(List<Map<String, Object>> tdsSubSectionList) {
		this.tdsSubSectionList = tdsSubSectionList;
	}

	public List<Map<String, Object>> getTdsOtherIncomeList() {
		return tdsOtherIncomeList;
	}

	public void setTdsOtherIncomeList(List<Map<String, Object>> tdsOtherIncomeList) {
		this.tdsOtherIncomeList = tdsOtherIncomeList;
	}

	public TdsBean getMonthbean() {
		return monthbean;
	}

	public void setMonthbean(TdsBean monthbean) {
		this.monthbean = monthbean;
	}

}
