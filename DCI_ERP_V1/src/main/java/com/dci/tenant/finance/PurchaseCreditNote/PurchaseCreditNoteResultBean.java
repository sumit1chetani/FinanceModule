package com.dci.tenant.finance.PurchaseCreditNote;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class PurchaseCreditNoteResultBean extends BasicResultBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<PurchaseCreditNoteBean> lCreditNoteBean;

	private List<PurchaseCreditNoteBean> reverseList;

	private String sErrorMessage;

	private String companyCode;

	public List<PurchaseCreditNoteBean> getlCreditNoteBean() {
		return lCreditNoteBean;
	}

	public void setlCreditNoteBean(List<PurchaseCreditNoteBean> lCreditNoteBean) {
		this.lCreditNoteBean = lCreditNoteBean;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public List<PurchaseCreditNoteBean> getReverseList() {
		return reverseList;
	}

	public void setReverseList(List<PurchaseCreditNoteBean> reverseList) {
		this.reverseList = reverseList;
	}

	public String getsErrorMessage() {
		return sErrorMessage;
	}

	public void setsErrorMessage(String sErrorMessage) {
		this.sErrorMessage = sErrorMessage;
	}

}