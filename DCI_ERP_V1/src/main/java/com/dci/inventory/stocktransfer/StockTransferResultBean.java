package com.dci.inventory.stocktransfer;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;

public class StockTransferResultBean extends BasicResultBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<StockTransferBean> lStockTransferBean = null;
	private List<GRNPurchaseOrderBean> lStockTransferBatchBean = null;

	private List<Object> oStockTransferBean = null;

	public List<StockTransferBean> getlStockTransferBean() {
		return lStockTransferBean;
	}

	public void setlStockTransferBean(List<StockTransferBean> lStockTransferBean) {
		this.lStockTransferBean = lStockTransferBean;
	}

	public List<Object> getoStockTransferBean() {
		return oStockTransferBean;
	}

	public void setoStockTransferBean(List<Object> oStockTransferBean) {
		this.oStockTransferBean = oStockTransferBean;
	}

	public List<GRNPurchaseOrderBean> getlStockTransferBatchBean() {
		return lStockTransferBatchBean;
	}

	public void setlStockTransferBatchBean(List<GRNPurchaseOrderBean> lStockTransferBatchBean) {
		this.lStockTransferBatchBean = lStockTransferBatchBean;
	}

}
