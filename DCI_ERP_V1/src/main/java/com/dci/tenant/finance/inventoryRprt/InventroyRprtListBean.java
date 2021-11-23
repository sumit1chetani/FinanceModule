package com.dci.tenant.finance.inventoryRprt;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class InventroyRprtListBean extends BasicResultBean implements Serializable {

	private List<InventoryRprtBean> inventoryMasterList;

	public List<InventoryRprtBean> getInventoryMasterList() {
		return inventoryMasterList;
	}

	public void setInventoryMasterList(List<InventoryRprtBean> inventoryMasterList) {
		this.inventoryMasterList = inventoryMasterList;
	}

	private List<InventoryRprtDtlBean> inventorySubList;
	private List<InventoryRprtDtlBean> inventoryBatchList;

	public List<InventoryRprtDtlBean> getInventorySubList() {
		return inventorySubList;
	}

	public void setInventorySubList(List<InventoryRprtDtlBean> inventorySubList) {
		this.inventorySubList = inventorySubList;
	}

	private List<InventoryRprtBean> itemList;
	private List<InventoryRprtBean> locationList;
	private List<InventoryRprtBean> categoryList;

	public List<InventoryRprtBean> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<InventoryRprtBean> categoryList) {
		this.categoryList = categoryList;
	}

	public List<InventoryRprtBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<InventoryRprtBean> itemList) {
		this.itemList = itemList;
	}

	public List<InventoryRprtBean> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<InventoryRprtBean> locationList) {
		this.locationList = locationList;
	}

	public List<InventoryRprtDtlBean> getInventoryBatchList() {
		return inventoryBatchList;
	}

	public void setInventoryBatchList(List<InventoryRprtDtlBean> inventoryBatchList) {
		this.inventoryBatchList = inventoryBatchList;
	}

}
