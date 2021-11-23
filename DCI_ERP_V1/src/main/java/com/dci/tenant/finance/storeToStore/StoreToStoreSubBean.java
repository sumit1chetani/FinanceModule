package com.dci.tenant.finance.storeToStore;

import java.util.List;

import com.dci.common.util.BatchAttributeBean;

public class StoreToStoreSubBean {

	private int purchaseRequisitionId;
	private int purchaseRequisitionSubId;
	private String itemCode;
	private String itemName;
	private String itemDesc;
	private Integer itemCategoryId;
	private Integer requestedQty;
	private String itemCategoryName;
	private Integer uomId;
	private String uomName;
	private String eddDate;
	private List<BatchAttributeBean> attributeBeans;
	private double quantity;
	private String itemId;
	private double vendorMinQty;
	private int slNo;

	private int physicalQty;
	private int itemCategoryType;
	private boolean disableDate = false;
	private boolean checkPhysicalQuantity = false;

	private boolean select;
	private String availQty;

	private String id;
	private String text;

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getVendorMinQty() {
		return vendorMinQty;
	}

	public void setVendorMinQty(double vendorMinQty) {
		this.vendorMinQty = vendorMinQty;
	}

	public int getPhysicalQty() {
		return physicalQty;
	}

	public void setPhysicalQty(int physicalQty) {
		this.physicalQty = physicalQty;
	}

	public String getId() {
		return id;
	}

	public int getItemCategoryType() {
		return itemCategoryType;
	}

	public void setItemCategoryType(int itemCategoryType) {
		this.itemCategoryType = itemCategoryType;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPurchaseRequisitionId() {
		return purchaseRequisitionId;
	}

	public void setPurchaseRequisitionId(int purchaseRequisitionId) {
		this.purchaseRequisitionId = purchaseRequisitionId;
	}

	public int getPurchaseRequisitionSubId() {
		return purchaseRequisitionSubId;
	}

	public void setPurchaseRequisitionSubId(int purchaseRequisitionSubId) {
		this.purchaseRequisitionSubId = purchaseRequisitionSubId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Integer getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(Integer itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getEddDate() {
		return eddDate;
	}

	public void setEddDate(String eddDate) {
		this.eddDate = eddDate;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isDisableDate() {
		return disableDate;
	}

	public void setDisableDate(boolean disableDate) {
		this.disableDate = disableDate;
	}

	public boolean isCheckPhysicalQuantity() {
		return checkPhysicalQuantity;
	}

	public void setCheckPhysicalQuantity(boolean checkPhysicalQuantity) {
		this.checkPhysicalQuantity = checkPhysicalQuantity;
	}

	public String getAvailQty() {
		return availQty;
	}

	public void setAvailQty(String availQty) {
		this.availQty = availQty;
	}

	/**
	 * @return the attributeBeans
	 */
	public List<BatchAttributeBean> getAttributeBeans() {
		return attributeBeans;
	}

	/**
	 * @param attributeBeans
	 *            the attributeBeans to set
	 */
	public void setAttributeBeans(List<BatchAttributeBean> attributeBeans) {
		this.attributeBeans = attributeBeans;
	}

	/**
	 * @return the requestedQty
	 */
	public Integer getRequestedQty() {
		return requestedQty;
	}

	/**
	 * @param requestedQty
	 *            the requestedQty to set
	 */
	public void setRequestedQty(Integer requestedQty) {
		this.requestedQty = requestedQty;
	}

}
