package com.dci.payroll.tds.otherheadentry;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class OtherHeadEntryResultBean extends BasicResultBean implements Serializable {
	private List<OtherHeadEntryBean> otherHeadEntryList;
	private OtherHeadEntryBean otherHeadEntryBean = null;

	public List<OtherHeadEntryBean> getOtherHeadEntryList() {
		return otherHeadEntryList;
	}

	public void setOtherHeadEntryList(List<OtherHeadEntryBean> otherHeadEntryList) {
		this.otherHeadEntryList = otherHeadEntryList;
	}

	public OtherHeadEntryBean getOtherHeadEntryBean() {
		return otherHeadEntryBean;
	}

	public void setOtherHeadEntryBean(OtherHeadEntryBean otherHeadEntryBean) {
		this.otherHeadEntryBean = otherHeadEntryBean;
	}
}