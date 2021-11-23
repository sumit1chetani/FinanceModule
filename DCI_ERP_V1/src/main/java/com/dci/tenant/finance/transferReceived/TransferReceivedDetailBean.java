package com.dci.tenant.finance.transferReceived;

import java.util.List;

import com.dci.common.util.BatchAttributeBean;

public class TransferReceivedDetailBean {

	private int receivedDtlId;
	private int receivedId;
	private int transferQty;
	private int receivedQty;
	private int pendingQty;
	private int itemId;
	private String itemCode;
	private String itemName;
	private int stockReceivedDetailId;
	private Object select;
	private Boolean isBatchNoExist;
	private int id;
	private List<BatchAttributeBean> attributeBeans;
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getReceivedDtlId() {
		return receivedDtlId;
	}

	public void setReceivedDtlId(int receivedDtlId) {
		this.receivedDtlId = receivedDtlId;
	}

	public int getReceivedId() {
		return receivedId;
	}

	public void setReceivedId(int receivedId) {
		this.receivedId = receivedId;
	}

	public int getTransferQty() {
		return transferQty;
	}

	public void setTransferQty(int transferQty) {
		this.transferQty = transferQty;
	}

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
	}

	public int getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(int pendingQty) {
		this.pendingQty = pendingQty;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public Object getSelect() {
		return select;
	}

	public void setSelect(Object select) {
		this.select = select;
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
	 * @return the isBatchNoExist
	 */
	public Boolean getIsBatchNoExist() {
		return isBatchNoExist;
	}

	/**
	 * @param isBatchNoExist
	 *            the isBatchNoExist to set
	 */
	public void setIsBatchNoExist(Boolean isBatchNoExist) {
		this.isBatchNoExist = isBatchNoExist;
	}

	/**
	 * @return the stockReceivedDetailId
	 */
	public int getStockReceivedDetailId() {
		return stockReceivedDetailId;
	}

	/**
	 * @param stockReceivedDetailId the stockReceivedDetailId to set
	 */
	public void setStockReceivedDetailId(int stockReceivedDetailId) {
		this.stockReceivedDetailId = stockReceivedDetailId;
	}

}
