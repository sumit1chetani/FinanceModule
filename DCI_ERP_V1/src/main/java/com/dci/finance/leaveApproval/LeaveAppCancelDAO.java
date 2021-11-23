package com.dci.finance.leaveApproval;

import java.util.List;

import com.dci.common.util.CustomException;

public interface LeaveAppCancelDAO {


	public List<LeaveAppCancelBean> getList() throws CustomException;

	public LeaveAppCancelBean getEditListData(int leaveRequestId) throws Exception;

	public boolean updateActionData(LeaveAppCancelBean updateBean) throws Exception;

}