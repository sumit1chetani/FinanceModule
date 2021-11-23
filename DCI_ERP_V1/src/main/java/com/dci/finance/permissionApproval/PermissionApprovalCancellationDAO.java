package com.dci.finance.permissionApproval;

import java.util.List;

import com.dci.common.util.CustomException;


public interface PermissionApprovalCancellationDAO {

	public List<PermissionApprovalCancellationBean> getPermissionRequestApprovalList(int limit, int offset) throws CustomException;

	public List<PermissionApprovalCancellationBean> getRecentRequestList(int limit, int offset) throws CustomException;

	public PermissionApprovalCancellationBean editPermissionRequestApproval(String id) throws CustomException;

	public boolean updatePermissionRequestApproval(PermissionApprovalCancellationBean objPermissionApprovalCancellationBean) throws CustomException;
}
