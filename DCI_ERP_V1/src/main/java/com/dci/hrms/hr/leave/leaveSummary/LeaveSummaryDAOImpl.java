package com.dci.hrms.hr.leave.leaveSummary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;


@Repository
public class LeaveSummaryDAOImpl implements LeaveSummaryDAO {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Autowired
	public DataSource dataSource;

	@Override
	public List<LeaveSummaryBean> getSummaryDetails(String leaveType) throws CustomException {
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LeaveSummaryBean> summaryList = new ArrayList<LeaveSummaryBean>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveSummaryQueryUtil.getLeaveSummaryDetails, new Object[] { leaveType, teampUser.getUserId() });
			for (Map row : rows) {
				LeaveSummaryBean leaveSummary = new LeaveSummaryBean();
				leaveSummary.setLeaveCode((String) row.get("leaveCode"));
				leaveSummary.setDateFrom((String) row.get("dateFrom"));
				leaveSummary.setDateTo((String) row.get("dateTo"));
				leaveSummary.setNoOfDays(Double.parseDouble(row.get("noOfDays").toString()));
				leaveSummary.setAppliedOn((String) row.get("appliedOn"));
				leaveSummary.setStatus((int) row.get("status"));
				if ((String) row.get("approvedBy") != null && (String) row.get("approvedBy") != "") {
					String approvedBy = jdbcTemplate.queryForObject(LeaveSummaryQueryUtil.getApprovedBy, String.class, (String) row.get("approvedBy"));
					leaveSummary.setApprovedBy(approvedBy);
				} else {
					leaveSummary.setApprovedBy(null);
				}
				summaryList.add(leaveSummary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return summaryList;
	}
}
