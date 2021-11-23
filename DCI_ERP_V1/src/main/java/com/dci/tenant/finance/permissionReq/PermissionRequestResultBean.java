package com.dci.tenant.finance.permissionReq;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;



public class PermissionRequestResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<PermissionRequestBean> lpermissionRequestBean;

	private PermissionRequestBean permissionRequestBean;

	public List<PermissionRequestBean> getLpermissionRequestBean() {
		return lpermissionRequestBean;
	}

	public void setLpermissionRequestBean(List<PermissionRequestBean> lpermissionRequestBean) {
		this.lpermissionRequestBean = lpermissionRequestBean;
	}

	public PermissionRequestBean getPermissionRequestBean() {
		return permissionRequestBean;
	}

	public void setPermissionRequestBean(PermissionRequestBean permissionRequestBean) {
		this.permissionRequestBean = permissionRequestBean;
	}
}
