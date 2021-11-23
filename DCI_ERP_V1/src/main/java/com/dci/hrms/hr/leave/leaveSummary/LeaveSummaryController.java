package com.dci.hrms.hr.leave.leaveSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "hrms/hr/leaveSummary")
public class LeaveSummaryController {

	@Autowired
	public LeaveSummaryService leaveSummaryService;

	@RequestMapping(value = "/summaryDetails")
	public LeaveSummaryResultBean getSummaryDetails(@RequestBody String LeaveType) {
		LeaveSummaryResultBean leaveSummaryResultBean = new LeaveSummaryResultBean();
		try {
			leaveSummaryResultBean.setSummaryDetails(leaveSummaryService.getSummaryDetails(LeaveType));
			leaveSummaryResultBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return leaveSummaryResultBean;
	}

}
