package com.dci.tenant.finance.reports.analytical.ARregister;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.ReportHeaderBean;
import com.dci.common.util.BasicResultBean;

public class ARregisterResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ARregister> lARregisterlists;
	private List<ReportHeaderBean> getheaderList;
	private List<ReportHeaderBean> lARheaderlist;

	public List<ReportHeaderBean> getlARheaderlist() {
		return lARheaderlist;
	}

	public void setlARheaderlist(List<ReportHeaderBean> lARheaderlist) {
		this.lARheaderlist = lARheaderlist;
	}

	public List<ARregister> getlARregisterlists() {
		return lARregisterlists;
	}

	public void setlARregisterlists(List<ARregister> lARregisterlists) {
		this.lARregisterlists = lARregisterlists;
	}

	public List<ReportHeaderBean> getGetheaderList() {
		return getheaderList;
	}

	public void setGetheaderList(List<ReportHeaderBean> getheaderList) {
		this.getheaderList = getheaderList;
	}

}
