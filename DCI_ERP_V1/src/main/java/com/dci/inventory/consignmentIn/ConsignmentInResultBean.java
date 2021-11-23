package com.dci.inventory.consignmentIn;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ConsignmentInResultBean extends BasicResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ConsignmentInBean editConsignmentInBean;

	public ConsignmentInBean getEditConsignmentInBean() {
		return editConsignmentInBean;
	}

	public void setEditConsignmentInBean(ConsignmentInBean editConsignmentInBean) {
		this.editConsignmentInBean = editConsignmentInBean;
	}

	private List<ConsignmentInBean> lConsignmentInBean = null;
	private List<ConsignmentInDetailBean> lConsignmentInDetailBean = null;

	public List<ConsignmentInDetailBean> getlConsignmentInDetailBean() {
		return lConsignmentInDetailBean;
	}

	public void setlConsignmentInDetailBean(List<ConsignmentInDetailBean> lConsignmentInDetailBean) {
		this.lConsignmentInDetailBean = lConsignmentInDetailBean;
	}

	private List<Object> oConsignmentInBean = null;

	public List<ConsignmentInBean> getlConsignmentInBean() {
		return lConsignmentInBean;
	}

	public List<Object> getoConsignmentInBean() {
		return oConsignmentInBean;
	}

	public void setoConsignmentInBean(List<Object> oConsignmentInBean) {
		this.oConsignmentInBean = oConsignmentInBean;
	}

	public void setlConsignmentInBean(List<ConsignmentInBean> lConsignmentInBean) {
		this.lConsignmentInBean = lConsignmentInBean;
	}

}
