package com.dci.payroll.payroll.Esi;

import java.util.List;

public class EsiResultBean {
	private List<EsiBean> esiBeanList;
	private boolean isSuccess;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public List<EsiBean> getEsiBeanList() {
		return esiBeanList;
	}

	public void setEsiBeanList(List<EsiBean> esiBeanList) {
		this.esiBeanList = esiBeanList;
	}
}
