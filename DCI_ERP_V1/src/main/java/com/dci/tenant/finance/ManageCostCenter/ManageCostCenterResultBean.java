package com.dci.tenant.finance.ManageCostCenter;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ManageCostCenterResultBean extends BasicResultBean implements Serializable {
	private ManageCostCenterBean manageCostCenterBean = new ManageCostCenterBean();

	private List<ManageCostCenterBean> manageCostCenterList;

	public ManageCostCenterBean getManageCostCenterBean() {
		return manageCostCenterBean;
	}

	public void setManageCostCenterBean(ManageCostCenterBean manageCostCenterBean) {
		this.manageCostCenterBean = manageCostCenterBean;
	}

	public List<ManageCostCenterBean> getManageCostCenterList() {
		return manageCostCenterList;
	}

	public void setManageCostCenterList(List<ManageCostCenterBean> manageCostCenterList) {
		this.manageCostCenterList = manageCostCenterList;
	}
}
