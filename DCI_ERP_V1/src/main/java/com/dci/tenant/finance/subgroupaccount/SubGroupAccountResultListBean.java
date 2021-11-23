package com.dci.tenant.finance.subgroupaccount;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class SubGroupAccountResultListBean extends BasicResultBean implements Serializable {
	private List<SubGroupAccountBean> objGrpHeadBeanBean;
	private List<SubGroupAccountBean> subHeadGrpList;

	public List<SubGroupAccountBean> getSubHeadGrpList() {
		return subHeadGrpList;
	}

	public void setSubHeadGrpList(List<SubGroupAccountBean> subHeadGrpList) {
		this.subHeadGrpList = subHeadGrpList;
	}

	/**
	 * @return the objGrpHeadBeanBean
	 */
	public List<SubGroupAccountBean> getObjGrpHeadBeanBean() {
		return objGrpHeadBeanBean;
	}

	/**
	 * @param objGrpHeadBeanBean
	 *            the objGrpHeadBeanBean to set
	 */
	public void setObjGrpHeadBeanBean(List<SubGroupAccountBean> objGrpHeadBeanBean) {
		this.objGrpHeadBeanBean = objGrpHeadBeanBean;
	}

	private List<SubGroupAccountBean> objSubGroupAccountBeanBean;

	/**
	 * @return the objSubGroupAccountBeanBean
	 */
	public List<SubGroupAccountBean> getObjSubGroupAccountBeanBean() {
		return objSubGroupAccountBeanBean;
	}

	/**
	 * @param objSubGroupAccountBeanBean
	 *            the objSubGroupAccountBeanBean to set
	 */
	public void setObjSubGroupAccountBeanBean(List<SubGroupAccountBean> objSubGroupAccountBeanBean) {
		this.objSubGroupAccountBeanBean = objSubGroupAccountBeanBean;
	}

	private SubGroupAccountBean editSubGroupAccountBean;

	public SubGroupAccountBean getEditSubGroupAccountBean() {
		return editSubGroupAccountBean;
	}

	public void setEditSubGroupAccountBean(SubGroupAccountBean editSubGroupAccountBean) {
		this.editSubGroupAccountBean = editSubGroupAccountBean;
	}

	private SubGroupAccountResultListBean listGroupHead;

	public SubGroupAccountResultListBean getListGroupHead() {
		return listGroupHead;
	}

	public void setListGroupHead(SubGroupAccountResultListBean listGroupHead) {
		this.listGroupHead = listGroupHead;
	}

}
