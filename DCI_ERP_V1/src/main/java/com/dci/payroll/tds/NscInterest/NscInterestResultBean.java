package com.dci.payroll.tds.NscInterest;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class NscInterestResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<NscInterestBean> nscInterestList;

	private NscInterestBean nscInterestBean = null;

	public List<NscInterestBean> getNscInterestList() {
		return nscInterestList;
	}

	public void setNscInterestList(List<NscInterestBean> nscInterestList) {
		this.nscInterestList = nscInterestList;
	}

	public NscInterestBean getNscInterestBean() {
		return nscInterestBean;
	}

	public void setNscInterestBean(NscInterestBean nscInterestBean) {
		this.nscInterestBean = nscInterestBean;
	}

}
