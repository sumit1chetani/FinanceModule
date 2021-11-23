package com.dci.finance.leaveApproval;

import java.util.List;

import com.dci.common.util.CustomException;

public interface LeaveAppCancelService {

	//public LeaveAppCancelResultBean getList() throws Exception;

	public LeaveAppCancelBean getEditListData(int leaveRequestId) throws Exception;

	public boolean updateActionData(LeaveAppCancelBean updateBean) throws Exception;

	public List<LeaveAppCancelBean> getList() throws CustomException;

}
