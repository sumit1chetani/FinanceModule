package com.dci.tenant.finance.purchaseorder;

public class RateContractDetail {

	private int purchaseDeliveryId;
	private int itemId;
	private String purchaseOrderDeliveryDate;
	private int quantity;
	private int purchaseOrderDetailId;
	private int pendingQty;
	private int originalQty;
	private int edit;
	private boolean scheduleItem;
	private boolean isSelected = false;
	private boolean select = false;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getPurchaseOrderDeliveryDate() {
		return purchaseOrderDeliveryDate;
	}

	public void setPurchaseOrderDeliveryDate(String purchaseOrderDeliveryDate) {
		this.purchaseOrderDeliveryDate = purchaseOrderDeliveryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getEdit() {
		return edit;
	}

	public void setEdit(int edit) {
		this.edit = edit;
	}

	public int getPurchaseDeliveryId() {
		return purchaseDeliveryId;
	}

	public void setPurchaseDeliveryId(int purchaseDeliveryId) {
		this.purchaseDeliveryId = purchaseDeliveryId;
	}

	public int getPurchaseOrderDetailId() {
		return purchaseOrderDetailId;
	}

	public void setPurchaseOrderDetailId(int purchaseOrderDetailId) {
		this.purchaseOrderDetailId = purchaseOrderDetailId;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	/**
	 * @return the pendingQty
	 */
	public int getPendingQty() {
		return pendingQty;
	}

	/**
	 * @param pendingQty
	 *            the pendingQty to set
	 */
	public void setPendingQty(int pendingQty) {
		this.pendingQty = pendingQty;
	}

	/**
	 * @return the scheduleItem
	 */
	public boolean isScheduleItem() {
		return scheduleItem;
	}

	/**
	 * @param scheduleItem
	 *            the scheduleItem to set
	 */
	public void setScheduleItem(boolean scheduleItem) {
		this.scheduleItem = scheduleItem;
	}

	/**
	 * @return the originalQty
	 */
	public int getOriginalQty() {
		return originalQty;
	}

	/**
	 * @param originalQty the originalQty to set
	 */
	public void setOriginalQty(int originalQty) {
		this.originalQty = originalQty;
	}

}
