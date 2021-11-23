package com.dci.tenant.finance.subheadgroupaccount;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class SubHeadGroupAccountResultListBean extends BasicResultBean implements Serializable {
	private List<SubHeadGroupAccountBean> objGrpHeadBeanBean;

	/**
	 * @return the objGrpHeadBeanBean
	 */
	public List<SubHeadGroupAccountBean> getObjGrpHeadBeanBean() {
		return objGrpHeadBeanBean;
	}

	/**
	 * @param objGrpHeadBeanBean
	 *            the objGrpHeadBeanBean to set
	 */
	public void setObjGrpHeadBeanBean(List<SubHeadGroupAccountBean> objGrpHeadBeanBean) {
		this.objGrpHeadBeanBean = objGrpHeadBeanBean;
	}

	private List<SubHeadGroupAccountBean> objSubGroupAccountBeanBean;

	/**
	 * @return the objSubGroupAccountBeanBean
	 */
	public List<SubHeadGroupAccountBean> getObjSubGroupAccountBeanBean() {
		return objSubGroupAccountBeanBean;
	}

	/**
	 * @param objSubGroupAccountBeanBean
	 *            the objSubGroupAccountBeanBean to set
	 */
	public void setObjSubGroupAccountBeanBean(List<SubHeadGroupAccountBean> objSubGroupAccountBeanBean) {
		this.objSubGroupAccountBeanBean = objSubGroupAccountBeanBean;
	}

	private SubHeadGroupAccountBean editSubGroupAccountBean;

	public SubHeadGroupAccountBean getEditSubGroupAccountBean() {
		return editSubGroupAccountBean;
	}

	public void setEditSubGroupAccountBean(SubHeadGroupAccountBean editSubGroupAccountBean) {
		this.editSubGroupAccountBean = editSubGroupAccountBean;
	}

	private SubHeadGroupAccountResultListBean listGroupHead;

	public SubHeadGroupAccountResultListBean getListGroupHead() {
		return listGroupHead;
	}

	public void setListGroupHead(SubHeadGroupAccountResultListBean listGroupHead) {
		this.listGroupHead = listGroupHead;
	}

}
