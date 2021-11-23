package com.dci.common.util;

import java.util.List;

public class LogBatchBean {
	private int itemId;
	private String batchNo;
	private int batchQty;
	private String itemName;
	private String message;
	private List<LogBatchBean> lBatchList;
	private int status = 300;
	private boolean success = false;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public int getBatchQty() {
		return batchQty;
	}

	public void setBatchQty(int batchQty) {
		this.batchQty = batchQty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the lBatchList
	 */
	public List<LogBatchBean> getlBatchList() {
		return lBatchList;
	}

	/**
	 * @param lBatchList the lBatchList to set
	 */
	public void setlBatchList(List<LogBatchBean> lBatchList) {
		this.lBatchList = lBatchList;
	}

}
