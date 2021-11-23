package com.dci.tenant.finance.grouphead;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class GroupHeadMasterResultBean extends BasicResultBean implements Serializable {

	private List<GroupHeadMasterListBean> objGrpHeadMasterBean;

	/**
	 * @return the objGrpHeadMasterBean
	 */
	public List<GroupHeadMasterListBean> getObjGrpHeadMasterBean() {
		return objGrpHeadMasterBean;
	}

	/**
	 * @param objGrpHeadMasterBean
	 *            the objGrpHeadMasterBean to set
	 */
	public void setObjGrpHeadMasterBean(List<GroupHeadMasterListBean> objGrpHeadMasterBean) {
		this.objGrpHeadMasterBean = objGrpHeadMasterBean;
	}
}
