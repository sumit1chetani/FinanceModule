package com.dci.payroll.payroll.fullfinalsettlement;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class FullFinalSettlementResultBean extends BasicResultBean implements Serializable {
	private List<FullFinalSettlementBean> fullFinalSettlementList;
	private FullFinalSettlementBean fullFinalSettlementBean = null;

	public List<FullFinalSettlementBean> getFullFinalSettlementList() {
		return fullFinalSettlementList;
	}

	public void setFullFinalSettlementList(List<FullFinalSettlementBean> fullFinalSettlementList) {
		this.fullFinalSettlementList = fullFinalSettlementList;
	}

	public FullFinalSettlementBean getFullFinalSettlementBean() {
		return fullFinalSettlementBean;
	}

	public void setFullFinalSettlementBean(FullFinalSettlementBean fullFinalSettlementBean) {
		this.fullFinalSettlementBean = fullFinalSettlementBean;
	}
}