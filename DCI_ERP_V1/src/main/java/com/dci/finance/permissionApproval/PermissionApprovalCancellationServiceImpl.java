package com.dci.finance.permissionApproval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionApprovalCancellationServiceImpl implements PermissionApprovalCancellationService {

	@Autowired
	PermissionApprovalCancellationDAO objPermissionApprovalCancellationDAO;

	@Override
	public List<PermissionApprovalCancellationBean> getPermissionRequestApprovalList(int limit, int offset) throws Exception {

		return objPermissionApprovalCancellationDAO.getPermissionRequestApprovalList(limit, offset);

	}

	@Override
	public List<PermissionApprovalCancellationBean> getRecentRequestList(int limit, int offset) throws Exception {

		return objPermissionApprovalCancellationDAO.getRecentRequestList(limit, offset);

	}

	@Override
	public PermissionApprovalCancellationBean editPermissionRequestApproval(String id) throws Exception {
		// TODO Auto-generated method stub
		return objPermissionApprovalCancellationDAO.editPermissionRequestApproval(id);
	}

	@Override
	public boolean updatePermissionRequestApproval(PermissionApprovalCancellationBean objPermissionApprovalCancellationBean) throws Exception {

		return objPermissionApprovalCancellationDAO.updatePermissionRequestApproval(objPermissionApprovalCancellationBean);

	}

}
