package com.dci.tenant.finance.manageitem;

import java.util.List;

public class ManageItemDTO {

	private ManageItemBean manageItem;

	private List<ManageItemVendorBean> lmanageitemvendor;

	/**
	 * @return the manageItem
	 */
	public ManageItemBean getManageItem() {
		return manageItem;
	}

	/**
	 * @param manageItem
	 *            the manageItem to set
	 */
	public void setManageItem(ManageItemBean manageItem) {
		this.manageItem = manageItem;
	}

	/**
	 * @return the lmanageitemvendor
	 */
	public List<ManageItemVendorBean> getLmanageitemvendor() {
		return lmanageitemvendor;
	}

	/**
	 * @param lmanageitemvendor
	 *            the lmanageitemvendor to set
	 */
	public void setLmanageitemvendor(List<ManageItemVendorBean> lmanageitemvendor) {
		this.lmanageitemvendor = lmanageitemvendor;
	}

}
