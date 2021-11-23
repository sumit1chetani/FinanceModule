package com.dci.tenant.userList;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ListResultBean extends BasicResultBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<ListBean> listBean;

	public List<ListBean> getListBean() {
		return listBean;
	}

	public void setListBean(List<ListBean> listBean) {
		this.listBean = listBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
