package com.dci.tenant.finance.permissionReq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionRequestServiceImpl implements PermissionRequestService {

	@Autowired
	PermissionRequestDAO objPermissionRequestDAO;

	@Override
	public boolean addPermissionRequest(PermissionRequestBean objPermissionRequestBean, String userId) throws Exception {
		return objPermissionRequestDAO.addPermissionRequest(objPermissionRequestBean, userId);
	}

	@Override
	public List<PermissionRequestBean> getPermissionRequestList(int limit, int offset, String userId, String userName) throws Exception {

		return objPermissionRequestDAO.getPermissionRequestList(limit, offset, userId, userName);
	}

	@Override
	public PermissionRequestBean editPermissionRequest(String permissionrequestid) throws Exception {
		// TODO Auto-generated method stub
		return objPermissionRequestDAO.editPermissionRequest(permissionrequestid);
	}

	@Override
	public boolean updatePermissionRequest(PermissionRequestBean objPermissionRequestBean) throws Exception {

		return objPermissionRequestDAO.updatePermissionRequest(objPermissionRequestBean);

	}

	@Override
	public boolean deletePermissionRequest(String permissionrequestid) throws Exception {
		// TODO Auto-generated method stub
		return objPermissionRequestDAO.deletePermissionRequest(permissionrequestid);
	}

	@Override
	public PermissionRequestResultBean getEmployeeDetails(PermissionRequestBean permissionRequestBean) throws Exception {
		// TODO Auto-generated method stub
		return objPermissionRequestDAO.getEmployeeDetails(permissionRequestBean);
	}

}
