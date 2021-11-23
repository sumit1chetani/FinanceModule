package com.dci.tenant.finance.journalVoucherType;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class JournalVoucherTypeResultBean extends BasicResultBean {

	private List<JournalVoucherTypeBean> journalVoucherTypeBeans;

	private JournalVoucherTypeBean journalVoucherTypeBean;

	public List<JournalVoucherTypeBean> getJournalVoucherTypeBeans() {
		return journalVoucherTypeBeans;
	}

	public void setJournalVoucherTypeBeans(List<JournalVoucherTypeBean> journalVoucherTypeBeans) {
		this.journalVoucherTypeBeans = journalVoucherTypeBeans;
	}

	public JournalVoucherTypeBean getJournalVoucherTypeBean() {
		return journalVoucherTypeBean;
	}

	public void setJournalVoucherTypeBean(JournalVoucherTypeBean journalVoucherTypeBean) {
		this.journalVoucherTypeBean = journalVoucherTypeBean;
	}
}
