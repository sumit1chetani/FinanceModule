package com.dci.tenant.finance.reports.analytical.revenueregister;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.ReportHeaderBean;
import com.dci.common.util.BasicResultBean;

public class revenueregisterResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<revenueregister> lrevenueregisterlist;
	private List<ReportHeaderBean> getRevenueHeaderList;
	private List<ReportHeaderBean> lrevenueheaderlist;
	private revenueregister revenueregisterBean;

	public List<revenueregister> getLrevenueregisterlist() {
		return lrevenueregisterlist;
	}

	public void setLrevenueregisterlist(List<revenueregister> lrevenueregisterlist) {
		this.lrevenueregisterlist = lrevenueregisterlist;
	}

	public List<ReportHeaderBean> getGetRevenueHeaderList() {
		return getRevenueHeaderList;
	}

	public void setGetRevenueHeaderList(List<ReportHeaderBean> getRevenueHeaderList) {
		this.getRevenueHeaderList = getRevenueHeaderList;
	}

	public List<ReportHeaderBean> getLrevenueheaderlist() {
		return lrevenueheaderlist;
	}

	public void setLrevenueheaderlist(List<ReportHeaderBean> lrevenueheaderlist) {
		this.lrevenueheaderlist = lrevenueheaderlist;
	}

	public revenueregister getRevenueregisterBean() {
		return revenueregisterBean;
	}

	public void setRevenueregisterBean(revenueregister revenueregisterBean) {
		this.revenueregisterBean = revenueregisterBean;
	}
}
