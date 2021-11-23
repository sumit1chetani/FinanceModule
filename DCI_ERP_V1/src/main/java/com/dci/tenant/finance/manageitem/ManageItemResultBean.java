package com.dci.tenant.finance.manageitem;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.tenant.finance.inventoryRprt.InventoryRprtBean;

public class ManageItemResultBean extends BasicResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List itemTypeList;
	private List purchaseList;
	private List costingList;
	private List pricingTypeList;
	private List inventoryValuvationList;
	private List issueList;
	private List entityList;
	private List specificationList;

	private List<ManageItemBean> itemList;
	private List<ManageItemVendorBean> itemvendorList;
	private List<ManageItemBean> itemspecificationList;
	private List<InventoryRprtBean> listItemLocation;
	private ManageItemBean manageItemBean;

	private List<ManageItemBean> itemConsumptionMasterList;
	private List<ManageItemBean> itemConsumptionMax;
	private List<ManageItemBean> itemConsumptionMin;
	private List<ManageItemBean> itemConsumptionAvg;
	private List<ManageItemBean> itemTotalConsumption;

	public List<ManageItemBean> getItemConsumptionMasterList() {
		return itemConsumptionMasterList;
	}

	public void setItemConsumptionMasterList(List<ManageItemBean> itemConsumptionMasterList) {
		this.itemConsumptionMasterList = itemConsumptionMasterList;
	}

	public List<ManageItemBean> getItemConsumptionMax() {
		return itemConsumptionMax;
	}

	public void setItemConsumptionMax(List<ManageItemBean> itemConsumptionMax) {
		this.itemConsumptionMax = itemConsumptionMax;
	}

	public List<ManageItemBean> getItemConsumptionMin() {
		return itemConsumptionMin;
	}

	public void setItemConsumptionMin(List<ManageItemBean> itemConsumptionMin) {
		this.itemConsumptionMin = itemConsumptionMin;
	}

	public List<ManageItemBean> getItemConsumptionAvg() {
		return itemConsumptionAvg;
	}

	public void setItemConsumptionAvg(List<ManageItemBean> itemConsumptionAvg) {
		this.itemConsumptionAvg = itemConsumptionAvg;
	}

	public List<ManageItemBean> getItemTotalConsumption() {
		return itemTotalConsumption;
	}

	public void setItemTotalConsumption(List<ManageItemBean> itemTotalConsumption) {
		this.itemTotalConsumption = itemTotalConsumption;
	}

	/**
	 * @return the entityList
	 */
	public List getEntityList() {
		return entityList;
	}

	/**
	 * @param entityList
	 *            the entityList to set
	 */
	public void setEntityList(List entityList) {
		this.entityList = entityList;
	}

	private List itemCategoryList;
	private List uomList;

	/**
	 * @return the itemCategoryList
	 */
	public List getItemCategoryList() {
		return itemCategoryList;
	}

	/**
	 * @param itemCategoryList
	 *            the itemCategoryList to set
	 */
	public void setItemCategoryList(List itemCategoryList) {
		this.itemCategoryList = itemCategoryList;
	}

	/**
	 * @return the uomList
	 */
	public List getUomList() {
		return uomList;
	}

	/**
	 * @param uomList
	 *            the uomList to set
	 */
	public void setUomList(List uomList) {
		this.uomList = uomList;
	}

	/**
	 * @return the itemTypeList
	 */
	public List getItemTypeList() {
		return itemTypeList;
	}

	/**
	 * @param itemTypeList
	 *            the itemTypeList to set
	 */
	public void setItemTypeList(List itemTypeList) {
		this.itemTypeList = itemTypeList;
	}

	/**
	 * @return the purchaseList
	 */
	public List getPurchaseList() {
		return purchaseList;
	}

	/**
	 * @param purchaseList
	 *            the purchaseList to set
	 */
	public void setPurchaseList(List purchaseList) {
		this.purchaseList = purchaseList;
	}

	/**
	 * @return the costingList
	 */
	public List getCostingList() {
		return costingList;
	}

	/**
	 * @param costingList
	 *            the costingList to set
	 */
	public void setCostingList(List costingList) {
		this.costingList = costingList;
	}

	/**
	 * @return the pricingTypeList
	 */
	public List getPricingTypeList() {
		return pricingTypeList;
	}

	/**
	 * @param pricingTypeList
	 *            the pricingTypeList to set
	 */
	public void setPricingTypeList(List pricingTypeList) {
		this.pricingTypeList = pricingTypeList;
	}

	/**
	 * @return the inventoryValuvationList
	 */
	public List getInventoryValuvationList() {
		return inventoryValuvationList;
	}

	/**
	 * @param inventoryValuvationList
	 *            the inventoryValuvationList to set
	 */
	public void setInventoryValuvationList(List inventoryValuvationList) {
		this.inventoryValuvationList = inventoryValuvationList;
	}

	/**
	 * @return the issueList
	 */
	public List getIssueList() {
		return issueList;
	}

	/**
	 * @param issueList
	 *            the issueList to set
	 */
	public void setIssueList(List issueList) {
		this.issueList = issueList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the itemList
	 */
	public List<ManageItemBean> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList
	 *            the itemList to set
	 */
	public void setItemList(List<ManageItemBean> itemList) {
		this.itemList = itemList;
	}

	/**
	 * @return the itemvendorList
	 */
	public List<ManageItemVendorBean> getItemvendorList() {
		return itemvendorList;
	}

	/**
	 * @param itemvendorList
	 *            the itemvendorList to set
	 */
	public void setItemvendorList(List<ManageItemVendorBean> itemvendorList) {
		this.itemvendorList = itemvendorList;
	}

	/**
	 * @return the manageItemBean
	 */
	public ManageItemBean getManageItemBean() {
		return manageItemBean;
	}

	/**
	 * @param manageItemBean
	 *            the manageItemBean to set
	 */
	public void setManageItemBean(ManageItemBean manageItemBean) {
		this.manageItemBean = manageItemBean;
	}

	public List getSpecificationList() {
		return specificationList;
	}

	public void setSpecificationList(List specificationList) {
		this.specificationList = specificationList;
	}

	public List<ManageItemBean> getItemspecificationList() {
		return itemspecificationList;
	}

	public void setItemspecificationList(List<ManageItemBean> itemspecificationList) {
		this.itemspecificationList = itemspecificationList;
	}

	/**
	 * @return the listItemLocation
	 */
	public List<InventoryRprtBean> getListItemLocation() {
		return listItemLocation;
	}

	/**
	 * @param listItemLocation
	 *            the listItemLocation to set
	 */
	public void setListItemLocation(List<InventoryRprtBean> listItemLocation) {
		this.listItemLocation = listItemLocation;
	}
}
