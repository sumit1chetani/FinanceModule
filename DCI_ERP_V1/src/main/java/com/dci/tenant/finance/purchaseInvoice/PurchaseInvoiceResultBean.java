package com.dci.tenant.finance.purchaseInvoice;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class PurchaseInvoiceResultBean extends BasicResultBean implements Serializable {

	private List<PurchaseInvoiceHeaderBean> objPuInvHdrLstBean;

	private PurchaseInvoiceHeaderBean objPuInvHdrBean;

	/**
	 * @return the objPuInvHdrLstBean
	 */
	public List<PurchaseInvoiceHeaderBean> getObjPuInvHdrLstBean() {
		return objPuInvHdrLstBean;
	}

	/**
	 * @param objPuInvHdrLstBean
	 *            the objPuInvHdrLstBean to set
	 */
	public void setObjPuInvHdrLstBean(List<PurchaseInvoiceHeaderBean> objPuInvHdrLstBean) {
		this.objPuInvHdrLstBean = objPuInvHdrLstBean;
	}

	public PurchaseInvoiceHeaderBean getObjPuInvHdrBean() {
		return objPuInvHdrBean;
	}

	public void setObjPuInvHdrBean(PurchaseInvoiceHeaderBean objPuInvHdrBean) {
		this.objPuInvHdrBean = objPuInvHdrBean;
	}

}
