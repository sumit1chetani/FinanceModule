package com.dci.tenant.finance.permissionReq;

import java.util.List;

import com.dci.common.util.CustomException;



public interface PermissionRequestDAO {

	public boolean addPermissionRequest(PermissionRequestBean objPermissionRequestBean, String userId) throws CustomException;

	public List<PermissionRequestBean> getPermissionRequestList(int limit, int offset, String userId, String userName) throws CustomException;

	public PermissionRequestBean editPermissionRequest(String permissionrequestid) throws CustomException;

	public boolean updatePermissionRequest(PermissionRequestBean objPermissionRequestBean) throws CustomException;

	public boolean deletePermissionRequest(String permissionrequestid) throws CustomException;

	public PermissionRequestResultBean getEmployeeDetails(PermissionRequestBean permissionRequestBean) throws Exception;

}
