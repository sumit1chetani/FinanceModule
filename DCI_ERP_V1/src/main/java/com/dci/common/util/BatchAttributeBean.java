package com.dci.common.util;

public class BatchAttributeBean {

	private int itemId;
	private String batchNo;
	private int batchQty;
	private int batchDtlId;
	private String expiryDate;
	private String manufacturer;
	private int originalbatchQty;
	private double mrpPrice;
	private boolean select;
	private int grnId;
	private int quantity;
	private int transferQty;
	private int sourceLocation;
	private int destinationLocation;
	private int stockTransferBatchDetailId;
	private int destinationQty;
	private int ginDetailId;
	private int sourceQty;
	private int receiveQty;
	private String itemName;
	private int receivedQty;
	private int pendingQty;
	private int originalConvertedQty;
	private String requisitionNumber;
	private int stockLedgerId;

	public int getStockLedgerId() {
		return stockLedgerId;
	}

	public void setStockLedgerId(int stockLedgerId) {
		this.stockLedgerId = stockLedgerId;
	}

	public String getRequisitionNumber() {
		return requisitionNumber;
	}

	public void setRequisitionNumber(String requisitionNumber) {
		this.requisitionNumber = requisitionNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo
	 *            the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the mrpPrice
	 */
	public double getMrpPrice() {
		return mrpPrice;
	}

	/**
	 * @param mrpPrice
	 *            the mrpPrice to set
	 */
	public void setMrpPrice(double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	/**
	 * @return the batchQty
	 */
	public int getBatchQty() {
		return batchQty;
	}

	/**
	 * @param batchQty
	 *            the batchQty to set
	 */
	public void setBatchQty(int batchQty) {
		this.batchQty = batchQty;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the receivedQty
	 */
	public int getReceivedQty() {
		return receivedQty;
	}

	/**
	 * @param receivedQty
	 *            the receivedQty to set
	 */
	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
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
	 * @return the originalConvertedQty
	 */
	public int getOriginalConvertedQty() {
		return originalConvertedQty;
	}

	/**
	 * @param originalConvertedQty
	 *            the originalConvertedQty to set
	 */
	public void setOriginalConvertedQty(int originalConvertedQty) {
		this.originalConvertedQty = originalConvertedQty;
	}

	/**
	 * @return the sourceLocation
	 */
	public int getSourceLocation() {
		return sourceLocation;
	}

	/**
	 * @param sourceLocation
	 *            the sourceLocation to set
	 */
	public void setSourceLocation(int sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	/**
	 * @return the destinationLocation
	 */
	public int getDestinationLocation() {
		return destinationLocation;
	}

	/**
	 * @param destinationLocation
	 *            the destinationLocation to set
	 */
	public void setDestinationLocation(int destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	/**
	 * @return the destinationQty
	 */
	public int getDestinationQty() {
		return destinationQty;
	}

	/**
	 * @param destinationQty
	 *            the destinationQty to set
	 */
	public void setDestinationQty(int destinationQty) {
		this.destinationQty = destinationQty;
	}

	/**
	 * @return the sourceQty
	 */
	public int getSourceQty() {
		return sourceQty;
	}

	/**
	 * @param sourceQty
	 *            the sourceQty to set
	 */
	public void setSourceQty(int sourceQty) {
		this.sourceQty = sourceQty;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the receiveQty
	 */
	public int getReceiveQty() {
		return receiveQty;
	}

	/**
	 * @param receiveQty
	 *            the receiveQty to set
	 */
	public void setReceiveQty(int receiveQty) {
		this.receiveQty = receiveQty;
	}

	/**
	 * @return the select
	 */
	public boolean isSelect() {
		return select;
	}

	/**
	 * @param select
	 *            the select to set
	 */
	public void setSelect(boolean select) {
		this.select = select;
	}

	/**
	 * @return the stockTransferBatchDetailId
	 */
	public int getStockTransferBatchDetailId() {
		return stockTransferBatchDetailId;
	}

	/**
	 * @param stockTransferBatchDetailId
	 *            the stockTransferBatchDetailId to set
	 */
	public void setStockTransferBatchDetailId(int stockTransferBatchDetailId) {
		this.stockTransferBatchDetailId = stockTransferBatchDetailId;
	}

	/**
	 * @return the originalbatchQty
	 */
	public int getOriginalbatchQty() {
		return originalbatchQty;
	}

	/**
	 * @param originalbatchQty
	 *            the originalbatchQty to set
	 */
	public void setOriginalbatchQty(int originalbatchQty) {
		this.originalbatchQty = originalbatchQty;
	}

	/**
	 * @return the transferQty
	 */
	public int getTransferQty() {
		return transferQty;
	}

	/**
	 * @param transferQty
	 *            the transferQty to set
	 */
	public void setTransferQty(int transferQty) {
		this.transferQty = transferQty;
	}

	public int getBatchDtlId() {
		return batchDtlId;
	}

	public void setBatchDtlId(int batchDtlId) {
		this.batchDtlId = batchDtlId;
	}

	public int getGrnId() {
		return grnId;
	}

	public void setGrnId(int grnId) {
		this.grnId = grnId;
	}

	public int getGinDetailId() {
		return ginDetailId;
	}

	public void setGinDetailId(int ginDetailId) {
		this.ginDetailId = ginDetailId;
	}

}