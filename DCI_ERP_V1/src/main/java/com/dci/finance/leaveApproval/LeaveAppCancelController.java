package com.dci.finance.leaveApproval;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "{tenantid}/finance/leaveapp")

public class LeaveAppCancelController {
	private final static Logger LOGGER = LoggerFactory.getLogger(LeaveAppCancelController.class);
	@Autowired
	LeaveAppCancelService leaveAppService;

	@RequestMapping(value = "/list")
	public LeaveAppCancelResultBean getList() throws Exception {
		LeaveAppCancelResultBean resultBean = new LeaveAppCancelResultBean();
		try{
		//resultBean = leaveAppService.getList();
		resultBean.setLeaveAppList(leaveAppService.getList());
		resultBean.setSuccess(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
		return resultBean;
	}

	

	@RequestMapping(value = "/getEdit")
	public LeaveAppCancelBean getEditListData(@RequestParam("leaveRequestId") int leaveRequestId) throws Exception {
		LeaveAppCancelBean editBean = new LeaveAppCancelBean();
		editBean = leaveAppService.getEditListData(leaveRequestId);

		return editBean;
	}

	@RequestMapping(value = "/update")
	public boolean updateActionData(@RequestBody LeaveAppCancelBean updateBean) throws Exception {
		boolean sucess = false;
		sucess = leaveAppService.updateActionData(updateBean);

		return sucess;
	}

}
