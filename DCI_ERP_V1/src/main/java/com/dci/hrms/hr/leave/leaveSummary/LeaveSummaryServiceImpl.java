package com.dci.hrms.hr.leave.leaveSummary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;


@Service
public class LeaveSummaryServiceImpl implements LeaveSummaryService {

	@Autowired
	public LeaveSummaryDAO leaveSummaryDAO;

	@Override
	public List<LeaveSummaryBean> getSummaryDetails(String leaveType) throws CustomException {
		return leaveSummaryDAO.getSummaryDetails(leaveType);
	}

}
