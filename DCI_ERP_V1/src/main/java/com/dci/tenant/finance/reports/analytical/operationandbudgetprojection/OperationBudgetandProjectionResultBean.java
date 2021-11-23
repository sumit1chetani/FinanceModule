package com.dci.tenant.finance.reports.analytical.operationandbudgetprojection;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class OperationBudgetandProjectionResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<OperationBudgetandProjectionBean> lOperationBudgetandProjectionBean;

	private List<SelectivityBean> vesselList;

	private List<SelectivityBean> voyageList;

	private List<SelectivityBean> sectorList;

	private OperationBudgetandProjectionBean operationBudget = new OperationBudgetandProjectionBean();

	public List<OperationBudgetandProjectionBean> getlOperationBudgetandProjectionBean() {
		return lOperationBudgetandProjectionBean;
	}

	public void setlOperationBudgetandProjectionBean(List<OperationBudgetandProjectionBean> lOperationBudgetandProjectionBean) {
		this.lOperationBudgetandProjectionBean = lOperationBudgetandProjectionBean;
	}

	public List<SelectivityBean> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<SelectivityBean> vesselList) {
		this.vesselList = vesselList;
	}

	public List<SelectivityBean> getVoyageList() {
		return voyageList;
	}

	public void setVoyageList(List<SelectivityBean> voyageList) {
		this.voyageList = voyageList;
	}

	public List<SelectivityBean> getSectorList() {
		return sectorList;
	}

	public void setSectorList(List<SelectivityBean> sectorList) {
		this.sectorList = sectorList;
	}

	public OperationBudgetandProjectionBean getOperationBudget() {
		return operationBudget;
	}

	public void setOperationBudget(OperationBudgetandProjectionBean operationBudget) {
		this.operationBudget = operationBudget;
	}

}
