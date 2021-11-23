package com.dci.tenant.finance.chqBook;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ChqBookResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ChqBookBean> statusList;
	private List<ChqBookBean> chqBookList;
	private List<ChqBookBean> editList;

	public List<ChqBookBean> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<ChqBookBean> statusList) {
		this.statusList = statusList;
	}

	public List<ChqBookBean> getChqBookList() {
		return chqBookList;
	}

	public void setChqBookList(List<ChqBookBean> chqBookList) {
		this.chqBookList = chqBookList;
	}

	public List<ChqBookBean> getEditList() {
		return editList;
	}

	public void setEditList(List<ChqBookBean> editList) {
		this.editList = editList;
	}

}
