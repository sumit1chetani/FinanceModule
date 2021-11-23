package com.dci.tenant.finance.permissionReq;

import java.util.List;

public interface PermissionRequestService {

	public boolean addPermissionRequest(PermissionRequestBean objPermissionRequestBean, String userId) throws Exception;

	public List<PermissionRequestBean> getPermissionRequestList(int limit, int offset, String userId, String userName) throws Exception;

	public PermissionRequestBean editPermissionRequest(String permissionrequestid) throws Exception;

	public boolean updatePermissionRequest(PermissionRequestBean objPermissionRequestBean) throws Exception;

	boolean deletePermissionRequest(String permissionrequestid) throws Exception;

	public PermissionRequestResultBean getEmployeeDetails(PermissionRequestBean permissionRequestBean) throws Exception;

}
