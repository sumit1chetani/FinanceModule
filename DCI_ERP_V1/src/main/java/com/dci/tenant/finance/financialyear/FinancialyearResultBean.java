package com.dci.tenant.finance.financialyear;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class FinancialyearResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<FinancialyearBean> lfinancialyearBean;

	public List<FinancialyearBean> getLfinancialyearBean() {
		return lfinancialyearBean;
	}

	public void setLfinancialyearBean(List<FinancialyearBean> lfinancialyearBean) {
		this.lfinancialyearBean = lfinancialyearBean;
	}

	public FinancialyearBean getFinancialyearBean() {
		return financialyearBean;
	}

	public void setFinancialyearBean(FinancialyearBean financialyearBean) {
		this.financialyearBean = financialyearBean;
	}

	private FinancialyearBean financialyearBean;

}
