package com.dci.finance.permissionApproval;

import java.util.List;

public interface PermissionApprovalCancellationService {

	public List<PermissionApprovalCancellationBean> getPermissionRequestApprovalList(int limit, int offset) throws Exception;

	public List<PermissionApprovalCancellationBean> getRecentRequestList(int limit, int offset) throws Exception;

	public PermissionApprovalCancellationBean editPermissionRequestApproval(String id) throws Exception;

	public boolean updatePermissionRequestApproval(PermissionApprovalCancellationBean objPermissionApprovalCancellationBean) throws Exception;

}
