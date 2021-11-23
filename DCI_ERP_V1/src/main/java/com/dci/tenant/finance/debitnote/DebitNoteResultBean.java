package com.dci.tenant.finance.debitnote;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class DebitNoteResultBean extends BasicResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<DebitNoteBean> lDebitNoteBean;

	public List<DebitNoteBean> getlDebitNoteBean() {
		return lDebitNoteBean;
	}

	public void setlDebitNoteBean(List<DebitNoteBean> lDebitNoteBean) {
		this.lDebitNoteBean = lDebitNoteBean;
	}

}
