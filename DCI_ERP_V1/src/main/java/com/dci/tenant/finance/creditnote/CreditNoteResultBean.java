package com.dci.tenant.finance.creditnote;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CreditNoteResultBean extends BasicResultBean implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private List<CreditNoteBean> lCreditNoteBean;
	private List<CreditNoteBean> reverseList;

	public List<CreditNoteBean> getReverseList() {
		return reverseList;
	}

	public void setReverseList(List<CreditNoteBean> reverseList) {
		this.reverseList = reverseList;
	}

	public List<CreditNoteBean> getlCreditNoteBean() {
		return lCreditNoteBean;
	}

	public void setlCreditNoteBean(List<CreditNoteBean> lCreditNoteBean) {
		this.lCreditNoteBean = lCreditNoteBean;
	}
}
