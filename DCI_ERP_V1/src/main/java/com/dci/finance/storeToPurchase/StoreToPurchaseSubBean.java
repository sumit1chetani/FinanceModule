package com.dci.finance.storeToPurchase;

public class StoreToPurchaseSubBean {

	private int purchaseRequisitionId;
	private int purchaseRequisitionSubId;
	private String itemCode;
	private String itemName;
	private Object section;
	private String itemDesc;
	private Integer itemCategoryId;
	private String itemCategoryName;
	private Integer uomId;
	private String uomName;
	private String eddDate;
	private Integer quantity;
	private String itemId;
	private int slNo;
	private boolean disableDate = false;

	private String id;
	private String text;

	private boolean isselect;
	private boolean tableId;

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getSection() {
		return section;
	}

	public void setSection(Object section) {
		this.section = section;
	}

	public boolean isIsselect() {
		return isselect;
	}

	public void setIsselect(boolean isselect) {
		this.isselect = isselect;
	}

	public boolean isTableId() {
		return tableId;
	}

	public void setTableId(boolean tableId) {
		this.tableId = tableId;
	}

	public boolean isDisableDate() {
		return disableDate;
	}

	public void setDisableDate(boolean disableDate) {
		this.disableDate = disableDate;
	}

}
