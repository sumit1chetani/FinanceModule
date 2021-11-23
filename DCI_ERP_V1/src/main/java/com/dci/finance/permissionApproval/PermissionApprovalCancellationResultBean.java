package com.dci.finance.permissionApproval;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class PermissionApprovalCancellationResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<PermissionApprovalCancellationBean> lPermissionApprovalCancellationBean;

	private PermissionApprovalCancellationBean PermissionApprovalCancellationBean;

	public PermissionApprovalCancellationBean getPermissionApprovalCancellationBean() {
		return PermissionApprovalCancellationBean;
	}

	public void setPermissionApprovalCancellationBean(PermissionApprovalCancellationBean permissionApprovalCancellationBean) {
		PermissionApprovalCancellationBean = permissionApprovalCancellationBean;
	}

	public List<PermissionApprovalCancellationBean> getlPermissionApprovalCancellationBean() {
		return lPermissionApprovalCancellationBean;
	}

	public void setlPermissionApprovalCancellationBean(List<PermissionApprovalCancellationBean> lPermissionApprovalCancellationBean) {
		this.lPermissionApprovalCancellationBean = lPermissionApprovalCancellationBean;
	}

}
