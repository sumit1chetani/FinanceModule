package com.dci.finance.permissionApproval;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")

public class PermissionApprovalCancellationDAOImpl implements PermissionApprovalCancellationDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(PermissionApprovalCancellationDAOImpl.class);
	@Resource
	DataSource dataSource;
	@SuppressWarnings("deprecation")
	// Populate Grid
	@Override
	public List<PermissionApprovalCancellationBean> getPermissionRequestApprovalList(int limit, int offset) throws CustomException {
		List<PermissionApprovalCancellationBean> lPermissionApprovalCancellationBean = new ArrayList<PermissionApprovalCancellationBean>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<Map<String, Object>> row1 = jdbcTemplate.queryForList(PermissionApprovalCancellationQueryUtil.sViewPermissionRequest, teampUser.getUserId());
			for (Map row : row1) {
				PermissionApprovalCancellationBean objPermissionApprovalCancellationBean = new PermissionApprovalCancellationBean();
				objPermissionApprovalCancellationBean.setPermissionrequestid(row.get("permissionrequestid").toString());
				objPermissionApprovalCancellationBean.setRequestedby(row.get("requestedby").toString());
				String permissionDate = df.format(row.get("permissiondate"));
				objPermissionApprovalCancellationBean.setPermissiondate(permissionDate);
				String requesteddate = df.format(row.get("requesteddate"));
				objPermissionApprovalCancellationBean.setRequesteddate(requesteddate);
				objPermissionApprovalCancellationBean.setReason(row.get("reason").toString());
				objPermissionApprovalCancellationBean.setFromtime(row.get("fromtime").toString());
				objPermissionApprovalCancellationBean.setTotime(row.get("totime").toString());
				int status = (int) row.get("status");
				if (status == 0) {
					objPermissionApprovalCancellationBean.setStatus("Pending");
				}
				if (status == 1) {
					objPermissionApprovalCancellationBean.setStatus("Approved");
				}
				if (status == 2) {
					objPermissionApprovalCancellationBean.setStatus("Cancelled");
				}
				if (row.get("remarks") == null) {
					objPermissionApprovalCancellationBean.setRemarks(null);
				} else {
					objPermissionApprovalCancellationBean.setRemarks(row.get("remarks").toString());

				}

				lPermissionApprovalCancellationBean.add(objPermissionApprovalCancellationBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
		}
		return lPermissionApprovalCancellationBean;
	}

	// Populate Grid
	@Override
	public List<PermissionApprovalCancellationBean> getRecentRequestList(int limit, int offset) throws CustomException {
		List<PermissionApprovalCancellationBean> lPermissionApprovalCancellationBean = new ArrayList<PermissionApprovalCancellationBean>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> row1 = jdbcTemplate.queryForList(PermissionApprovalCancellationQueryUtil.sViewRecentRequst);
			for (Map row : row1) {
				PermissionApprovalCancellationBean objPermissionApprovalCancellationBean = new PermissionApprovalCancellationBean();
				objPermissionApprovalCancellationBean.setPermissionrequestid(row.get("permissionrequestid").toString());
				objPermissionApprovalCancellationBean.setRequestedby(row.get("requestedby").toString());
				String permissionDate = df.format(row.get("permissiondate"));
				objPermissionApprovalCancellationBean.setPermissiondate(permissionDate);
				String requesteddate = df.format(row.get("requesteddate"));
				objPermissionApprovalCancellationBean.setRequesteddate(requesteddate);
				objPermissionApprovalCancellationBean.setReason(row.get("reason").toString());
				objPermissionApprovalCancellationBean.setFromtime(row.get("fromtime").toString());
				objPermissionApprovalCancellationBean.setTotime(row.get("totime").toString());
				int status = (int) row.get("status");
				if (status == 0) {
					objPermissionApprovalCancellationBean.setStatus("Pending");
				}
				if (status == 1) {
					objPermissionApprovalCancellationBean.setStatus("Approved");
				}
				if (status == 2) {
					objPermissionApprovalCancellationBean.setStatus("Cancelled");
				}
				if (row.get("remarks") == null) {
					objPermissionApprovalCancellationBean.setRemarks(null);
				} else {
					objPermissionApprovalCancellationBean.setRemarks(row.get("remarks").toString());

				}

				lPermissionApprovalCancellationBean.add(objPermissionApprovalCancellationBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
		}
		return lPermissionApprovalCancellationBean;
	}

	// Permission Approval Cancellation Edit
	@Override
	public PermissionApprovalCancellationBean editPermissionRequestApproval(String id) throws CustomException {
		PermissionApprovalCancellationBean objPermissionApprovalCancellationBean = new PermissionApprovalCancellationBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Map row = jdbcTemplate.queryForMap(PermissionApprovalCancellationQueryUtil.sEditPermissionRequestApproval, teampUser.getUserId(), Integer.parseInt(id.toString()));
			objPermissionApprovalCancellationBean.setPermissionrequestid(row.get("permissionrequestid").toString());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String permissionDate = df.format(row.get("permissiondate"));
			objPermissionApprovalCancellationBean.setPermissiondate(permissionDate);
			objPermissionApprovalCancellationBean.setRequestedby(row.get("requestedby").toString());
			String requestedDate = df.format(row.get("requesteddate"));
			objPermissionApprovalCancellationBean.setRequesteddate(requestedDate);
			objPermissionApprovalCancellationBean.setFromtime(row.get("hoursfrom").toString());
			objPermissionApprovalCancellationBean.setTotime(row.get("hoursto").toString());
			objPermissionApprovalCancellationBean.setReason(row.get("reason").toString());
			if (row.get("remarks") == null) {
				objPermissionApprovalCancellationBean.setRemarks(null);
			} else {
				objPermissionApprovalCancellationBean.setRemarks(row.get("remarks").toString());
			}
			int status = (int) row.get("status");
			if (status == 0) {
				objPermissionApprovalCancellationBean.setStatus("Pending");
			}
			if (status == 1) {
				objPermissionApprovalCancellationBean.setStatus("Approved");
			}
			if (status == 2) {
				objPermissionApprovalCancellationBean.setStatus("Cancelled");
			}

			objPermissionApprovalCancellationBean.setEdit(true);
			objPermissionApprovalCancellationBean.setSuccess(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in editCompanyDetails", e);
		}
		return objPermissionApprovalCancellationBean;
	}

	// Permission Approval Cancellation Update
	@Override
	public boolean updatePermissionRequestApproval(PermissionApprovalCancellationBean objPermissionApprovalCancellationBean) throws CustomException {
		boolean isAdded = false;
		boolean btour = false;
		boolean bholiday = false;
		boolean bhalfday = false;
		int istatus = 0;
		int i = 1;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String reportingId = jdbcTemplate.queryForObject(PermissionApprovalCancellationQueryUtil.reporting_to, String.class, teampUser.getUserId());
			String remarks = objPermissionApprovalCancellationBean.getRemarks();
			String status = objPermissionApprovalCancellationBean.getStatus();
			if (status.equalsIgnoreCase("Pending")) {
				istatus = 0;
			}
			if (status.equalsIgnoreCase("Approved")) {
				istatus = 1;
			}
			if (status.equalsIgnoreCase("Cancelled")) {
				istatus = 2;
			}

			String permissionrequestid = objPermissionApprovalCancellationBean.getPermissionrequestid();
			NamedParameterJdbcTemplate namedjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map parameters = new HashMap();
			parameters.put("remarks", remarks);
			parameters.put("status", istatus);
			parameters.put("reporting", teampUser.getUserId());
			parameters.put("id", Integer.parseInt(permissionrequestid));

			namedjdbcTemplate.update(PermissionApprovalCancellationQueryUtil.sUpdatePermissionRequestApproval, parameters);
			isAdded = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in updateCompanyDetail", e);
		}
		return isAdded;
	}
}
