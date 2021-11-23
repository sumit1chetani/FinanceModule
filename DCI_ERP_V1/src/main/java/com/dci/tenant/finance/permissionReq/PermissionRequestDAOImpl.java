package com.dci.tenant.finance.permissionReq;


import java.sql.Types;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.common.CommonUtilityService;
import com.dci.tenant.user.UserDetail;



@Repository
@Transactional("tenantTransactionManager")

public class PermissionRequestDAOImpl implements PermissionRequestDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(PermissionRequestDAOImpl.class);
	@Resource
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Autowired
	CommonUtilityService commonUtilityService;

	@SuppressWarnings("deprecation")
	@Override
	public boolean addPermissionRequest(PermissionRequestBean objPermissionRequestBean, String userId) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//java.util.Properties p = new java.util.Properties();
		//p.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
		//Velocity.init(p);
		boolean isAdded = false;
		String customerCode = null;
		try {
			String permissiondate = objPermissionRequestBean.getPermissiondate();
			String hoursfrom = objPermissionRequestBean.getHoursfrom();
			String hoursto = objPermissionRequestBean.getHoursto();
			String reason = objPermissionRequestBean.getReason();
			String employeeno = objPermissionRequestBean.getEmployeeno();
			String userName = objPermissionRequestBean.getUserName();

			NamedParameterJdbcTemplate namedjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Map parameters = new HashMap();
			parameters.put("permissiondate", permissiondate);
			parameters.put("hoursfrom", hoursfrom);
			parameters.put("hoursto", hoursto);
			parameters.put("reason", reason);
			parameters.put("employeeno", userId);
			parameters.put("userName", userName);

			int i = jdbcTemplate.queryForObject(PermissionRequestQueryUtil.sChecPermission, Integer.class, permissiondate );
			int j = jdbcTemplate.queryForObject(PermissionRequestQueryUtil.cChecHoliday, Integer.class,permissiondate );
			if (i == 0 && j == 0) {
				namedjdbcTemplate.update(PermissionRequestQueryUtil.sAddPermissionRequest, parameters);
				isAdded = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in addCompanyDetails", e);
		}
		/*try {
			int count = jdbcTemplate.update(PermissionRequestQueryUtil.getTemplateContentcheck);
			if (count == 1) {
				String template = jdbcTemplate.queryForObject(PermissionRequestQueryUtil.getTemplateContent, String.class);

				int j = jdbcTemplate.update(PermissionRequestQueryUtil.to_Email1, userDetails.getUserId());

				if (j == 1) {
					String toEmail = jdbcTemplate.queryForObject(PermissionRequestQueryUtil.to_Email, String.class, userDetails.getUserId());
					String name = jdbcTemplate.queryForObject(PermissionRequestQueryUtil.name, String.class, userDetails.getUserId());
					String reportTo = jdbcTemplate.queryForObject(PermissionRequestQueryUtil.toName, String.class, userDetails.getUserId());
					String[] toMailAddress = toEmail.split(",");
					Email email = new Email();
					String from = mail;
					email.setFromEmailAddress(from);
					email.setToEmailAddress(toMailAddress);
					StringBuffer sb = new StringBuffer();
					String path = "";
					sb.append("<html><body>");

					// Velocity Append
					StringWriter writer = new StringWriter();
					VelocityContext context = new VelocityContext();
					context.put("ReportingTo", reportTo);
					context.put("Name", name);

					Velocity.evaluate(context, writer, "TemplateName", template);

					sb.append(writer);

					String divTag = "";
					String sDivHtml = "<div>";

					divTag = divTag + sDivHtml;
					sb.append(divTag);

					sb.append("</body></ht ml>");

					email.setBodyHtml(sb.toString());
					email.setSubject("Permission Request");
					commonUtilityService.sendMail2(email, path);
				}
			}
		} *//*catch (Exception e) {
			e.printStackTrace();
		}*/
		return isAdded;
	}

	// Populate Grid
	@Override
	public List<PermissionRequestBean> getPermissionRequestList(int limit, int offset, String userId, String userName) throws CustomException {
		List<PermissionRequestBean> lPermissionRequestBean = new ArrayList<PermissionRequestBean>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> row1 = jdbcTemplate.queryForList(PermissionRequestQueryUtil.sViewPermissionRequest, teampUser.getUserId());
			for (Map row : row1) {
				PermissionRequestBean objPermissionRequestBean = new PermissionRequestBean();
				objPermissionRequestBean.setUserId(userId);
				objPermissionRequestBean.setUserName(userName);
				String permissionDate = df.format(row.get("permissiondate"));
				objPermissionRequestBean.setPermissiondate(permissionDate);
				objPermissionRequestBean.setHoursfrom(row.get("hoursfrom").toString());
				objPermissionRequestBean.setHoursto(row.get("hoursto").toString());
				objPermissionRequestBean.setReason((String) row.get("reason"));
				objPermissionRequestBean.setPermissionrequestid(row.get("permissionrequestid").toString());
				objPermissionRequestBean.setEmployeeno(row.get("requestby").toString());
				String requestedDate = df.format(row.get("requestdate"));
				objPermissionRequestBean.setRequesteddate(requestedDate);
				int Status = (int) row.get("status");
				if (Status == 0) {
					objPermissionRequestBean.setStatus("Pending");
				}
				if (Status == 1) {
					objPermissionRequestBean.setStatus("Approved");
				}
				if (Status == 2) {
					objPermissionRequestBean.setStatus("Cancelled");
						
				}
				lPermissionRequestBean.add(objPermissionRequestBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
			e.printStackTrace();
		}
		return lPermissionRequestBean;
	}

	// Permission Request Edit
	@Override
	public PermissionRequestBean editPermissionRequest(String permissionrequestid) throws CustomException {
		List<PermissionRequestBean> listPermissionRequest = new ArrayList<PermissionRequestBean>();

		PermissionRequestBean objPermissionRequestBean = new PermissionRequestBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { permissionrequestid };
			Map row = jdbcTemplate.queryForMap(PermissionRequestQueryUtil.sEditPermissionRequest, params, types);
			objPermissionRequestBean.setPermissionrequestid(row.get("permissionrequestid").toString());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String permissionDate = df.format(row.get("permissiondate"));
			objPermissionRequestBean.setPermissiondate(permissionDate);
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String shoursfrom = sdf.format(row.get("hoursfrom"));
			objPermissionRequestBean.setHoursfrom(shoursfrom);
			String shoursto = sdf.format(row.get("hoursto"));
			objPermissionRequestBean.setHoursto(shoursto);
			objPermissionRequestBean.setReason((String) row.get("reason"));
			objPermissionRequestBean.setEmployeeno(row.get("employeeno").toString());
			objPermissionRequestBean.setUserName(row.get("userName").toString());

			listPermissionRequest = jdbcTemplate.query(PermissionRequestQueryUtil.getEmployeeShiftDetails, new BeanPropertyRowMapper<PermissionRequestBean>(PermissionRequestBean.class), objPermissionRequestBean.getUserId(), objPermissionRequestBean.getPermissiondate());

			for (PermissionRequestBean permissionRequestBean : listPermissionRequest) {
				objPermissionRequestBean.setShiftName(permissionRequestBean.getShiftName());
				objPermissionRequestBean.setStartTime(permissionRequestBean.getStartTime());
				objPermissionRequestBean.setEndTime(permissionRequestBean.getEndTime());
			}

			objPermissionRequestBean.setEdit(true);
			objPermissionRequestBean.setSuccess(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in editCompanyDetails", e);
		}
		return objPermissionRequestBean;
	}

	@Override
	public boolean updatePermissionRequest(PermissionRequestBean objPermissionRequestBean) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		boolean isAdded = false;
		int i = 1;
		try {
			String permissionrequestid = objPermissionRequestBean.getPermissionrequestid();
			String permissiondate = objPermissionRequestBean.getPermissiondate();
			DateFormat formatter;
			String hoursform = objPermissionRequestBean.getHoursfrom();
			String hoursto = objPermissionRequestBean.getHoursto();
			String reason = objPermissionRequestBean.getReason();
			String userName = objPermissionRequestBean.getUserName();


			NamedParameterJdbcTemplate namedjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Map parameters = new HashMap();
			parameters.put("permissiondate", permissiondate);
			parameters.put("hoursfrom", hoursform);
			parameters.put("hoursto", hoursto);
			parameters.put("reason", reason);
			parameters.put("userName", userName);


			parameters.put("permissionrequestid", Integer.parseInt(permissionrequestid));
			int i1 = jdbcTemplate.queryForObject(PermissionRequestQueryUtil.sChecPermissionDate,Integer.class , permissiondate, Integer.parseInt(permissionrequestid), objPermissionRequestBean.getEmployeeno() );
			int j = jdbcTemplate.queryForObject(PermissionRequestQueryUtil.cChecHoliday,Integer.class , permissiondate);

			if (i1 == 0 && j == 0) {
				namedjdbcTemplate.update(PermissionRequestQueryUtil.sUpdatePermissionRequest, parameters);
				isAdded = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in updateCompanyDetail", e);
			e.printStackTrace();
		}
		
		return isAdded;
	}
	@Override
	public boolean deletePermissionRequest(String permissionrequestid) throws CustomException {
		int val = 1;
		boolean isDeleted = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			val = jdbcTemplate.update(PermissionRequestQueryUtil.sDeletePermissionRequest, Integer.parseInt(permissionrequestid));
			isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteCompanyDetail", e);
		}
		return isDeleted;
	}

	@Override
	public PermissionRequestResultBean getEmployeeDetails(PermissionRequestBean permissionRequestBean) throws Exception {
		PermissionRequestResultBean permissionRequestResultBean = new PermissionRequestResultBean();

		List<PermissionRequestBean> listPermissionRequest = new ArrayList<PermissionRequestBean>();
		try {

			listPermissionRequest = jdbcTemplate.query(PermissionRequestQueryUtil.getEmployeeShiftDetails, new BeanPropertyRowMapper<PermissionRequestBean>(PermissionRequestBean.class), permissionRequestBean.getUserId(), permissionRequestBean.getPermissiondate());
			permissionRequestResultBean.setLpermissionRequestBean(listPermissionRequest);
		} catch (DataAccessException e) {
			LOGGER.error("Error in slabRateList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return permissionRequestResultBean;
	}
}
