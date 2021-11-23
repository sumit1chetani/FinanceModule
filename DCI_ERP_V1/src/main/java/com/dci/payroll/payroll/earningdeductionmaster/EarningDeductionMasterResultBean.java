package com.dci.payroll.payroll.earningdeductionmaster;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class EarningDeductionMasterResultBean extends BasicResultBean implements Serializable {
	private List<EarningDeductionMasterBean> earningDeductionMasterList;
	private List<EarningDeductionMasterBean> payComponentList;
	private EarningDeductionMasterBean earningDeductionMasterBean = null;

	public List<EarningDeductionMasterBean> getEarningDeductionMasterList() {
		return earningDeductionMasterList;
	}

	public void setEarningDeductionMasterList(List<EarningDeductionMasterBean> earningDeductionMasterList) {
		this.earningDeductionMasterList = earningDeductionMasterList;
	}

	public EarningDeductionMasterBean getEarningDeductionMasterBean() {
		return earningDeductionMasterBean;
	}

	public void setEarningDeductionMasterBean(EarningDeductionMasterBean earningDeductionMasterBean) {
		this.earningDeductionMasterBean = earningDeductionMasterBean;
	}

	public List<EarningDeductionMasterBean> getPayComponentList() {
		return payComponentList;
	}

	public void setPayComponentList(List<EarningDeductionMasterBean> payComponentList) {
		this.payComponentList = payComponentList;
	}
}