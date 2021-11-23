package com.dci.tenant.finance.generalpurchaseInvoice;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class GeneralPurchaseInvoiceResultBean extends BasicResultBean implements Serializable {

	private List<GeneralPurchaseInvoiceHeaderBean> objPuInvHdrLstBean;

	private GeneralPurchaseInvoiceHeaderBean objPuInvHdrBean;

	/**
	 * @return the objPuInvHdrLstBean
	 */
	public List<GeneralPurchaseInvoiceHeaderBean> getObjPuInvHdrLstBean() {
		return objPuInvHdrLstBean;
	}

	/**
	 * @param objPuInvHdrLstBean
	 *            the objPuInvHdrLstBean to set
	 */
	public void setObjPuInvHdrLstBean(List<GeneralPurchaseInvoiceHeaderBean> objPuInvHdrLstBean) {
		this.objPuInvHdrLstBean = objPuInvHdrLstBean;
	}

	public GeneralPurchaseInvoiceHeaderBean getObjPuInvHdrBean() {
		return objPuInvHdrBean;
	}

	public void setObjPuInvHdrBean(GeneralPurchaseInvoiceHeaderBean objPuInvHdrBean) {
		this.objPuInvHdrBean = objPuInvHdrBean;
	}

}
