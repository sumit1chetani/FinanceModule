package com.dci.finance.leaveApproval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class LeaveAppCancelServiceImpl implements LeaveAppCancelService {
	@Autowired
	LeaveAppCancelDAO leaveAppCancelDAO;

	/*@Override
	public LeaveAppCancelResultBean getList() throws Exception {
		// TODO Auto-generated method stub
		return leaveAppCancelDAO.getList();
	}
*/
	@Override
	public LeaveAppCancelBean getEditListData(int leaveRequestId) throws Exception {
		// TODO Auto-generated method stub
		return leaveAppCancelDAO.getEditListData(leaveRequestId);
	}

	@Override
	public boolean updateActionData(LeaveAppCancelBean updateBean) throws Exception {
		// TODO Auto-generated method stub
		return leaveAppCancelDAO.updateActionData(updateBean);
	}
	
	@Override
	public List<LeaveAppCancelBean> getList() throws CustomException {
		return leaveAppCancelDAO.getList();
	}

}
