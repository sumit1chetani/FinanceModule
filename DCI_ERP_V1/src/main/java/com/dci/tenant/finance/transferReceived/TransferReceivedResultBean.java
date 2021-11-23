package com.dci.tenant.finance.transferReceived;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.common.util.BatchAttributeBean;

public class TransferReceivedResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<TransferReceivedBean> transferBeanList = null;
	private List<BatchAttributeBean> batchAttributeBeans = null;

	private List<TransferReceivedDetailBean> transferDetailBeanList = null;

	public List<TransferReceivedDetailBean> getTransferDetailBeanList() {
		return transferDetailBeanList;
	}

	public void setTransferDetailBeanList(List<TransferReceivedDetailBean> transferDetailBeanList) {
		this.transferDetailBeanList = transferDetailBeanList;
	}

	public List<TransferReceivedBean> getTransferBeanList() {
		return transferBeanList;
	}

	public void setTransferBeanList(List<TransferReceivedBean> transferBeanList) {
		this.transferBeanList = transferBeanList;
	}

	/**
	 * @return the batchAttributeBeans
	 */
	public List<BatchAttributeBean> getBatchAttributeBeans() {
		return batchAttributeBeans;
	}

	/**
	 * @param batchAttributeBeans the batchAttributeBeans to set
	 */
	public void setBatchAttributeBeans(List<BatchAttributeBean> batchAttributeBeans) {
		this.batchAttributeBeans = batchAttributeBeans;
	}

}
