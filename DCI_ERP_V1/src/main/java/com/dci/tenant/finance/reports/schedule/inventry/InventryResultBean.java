package com.dci.tenant.finance.reports.schedule.inventry;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class InventryResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<InventryBean> inventoryList;

	public List<InventryBean> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<InventryBean> inventoryList) {
		this.inventoryList = inventoryList;
	}

}
