package com.dci.tenant.company;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CompanyDetailsResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CompanyDetailsBean> lCompanyDetailsBean;

	public List<CompanyDetailsBean> getlCompanyDetailsBean() {
		return lCompanyDetailsBean;
	}

	public void setlCompanyDetailsBean(List<CompanyDetailsBean> lCompanyDetailsBean) {
		this.lCompanyDetailsBean = lCompanyDetailsBean;
	}

}
