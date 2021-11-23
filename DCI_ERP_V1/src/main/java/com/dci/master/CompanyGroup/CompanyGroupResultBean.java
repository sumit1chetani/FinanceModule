package com.dci.master.CompanyGroup;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CompanyGroupResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<CompanyGroupBean> lCompanyGroupBean;

	public List<CompanyGroupBean> getlCompanyGroupBean() {
		return lCompanyGroupBean;
	}

	public void setlCompanyGroupBean(List<CompanyGroupBean> lCompanyGroupBean) {
		this.lCompanyGroupBean = lCompanyGroupBean;
	}

}
