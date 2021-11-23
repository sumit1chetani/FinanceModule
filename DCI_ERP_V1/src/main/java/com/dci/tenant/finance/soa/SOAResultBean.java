package com.dci.tenant.finance.soa;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class SOAResultBean extends BasicResultBean implements Serializable {

	private List<SOABean> listCustomerSoa;

	public List<SOABean> getListCustomerSoa() {
		return listCustomerSoa;
	}

	public void setListCustomerSoa(List<SOABean> listCustomerSoa) {
		this.listCustomerSoa = listCustomerSoa;
	}

	private List<SOABean> subListCustomerSoa;

	public List<SOABean> getSubListCustomerSoa() {
		return subListCustomerSoa;
	}

	public void setSubListCustomerSoa(List<SOABean> subListCustomerSoa) {
		this.subListCustomerSoa = subListCustomerSoa;
	}

	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
