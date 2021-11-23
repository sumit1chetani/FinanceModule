package com.dci.tenant.finance.staffcircular;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")


public class StaffCircularDAOImpl implements StaffCircularDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	//@Value("${sms.url.username}")
	private String username;

	//@Value("${sms.url.password}")
	private String password;

	@Override
	public StaffCircularResultBean getNotification() {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		List<StaffCircularBean> lStaffCircularBean = new ArrayList<StaffCircularBean>();

		try {
			lStaffCircularBean = jdbcTemplate.query(StaffCircularQueryUtil.GET_LIST, new BeanPropertyRowMapper<StaffCircularBean>(StaffCircularBean.class));
			StaffCircularResultBean.setLstaffNotificationBeanDetail(lStaffCircularBean);
			StaffCircularResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean publishNotification(int staffCircularId) {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		String whereCode = "where status='t'";
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			StaffCircularBean StaffCircularBean = new StaffCircularBean();
			StaffCircularBean = jdbcTemplate.queryForObject(StaffCircularQueryUtil.EDIT_DETAIL, new BeanPropertyRowMapper<StaffCircularBean>(StaffCircularBean.class), staffCircularId);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(StaffCircularQueryUtil.EDIT_DETAIL1, new Object[] { staffCircularId });

			for (Map row : rows) {
				StaffCircularBean.getDepartment().add(row.get("department"));
			}

			/*
			 * List<Map<String, Object>> rows1 =
			 * jdbcTemplate.queryForList(StaffCircularQueryUtil .EDIT_DETAIL2,
			 * new Object[] { staffNotificationId });
			 * 
			 * for (Map row : rows1) { StaffCircularBean.getDesignation
			 * ().add(row.get("designation")); }
			 */

			List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(StaffCircularQueryUtil.EDIT_DETAIL3, new Object[] { staffCircularId });

			for (Map row : rows2) {
				StaffCircularBean.getDivision().add(row.get("division"));
			}

			/*
			 * List<Map<String, Object>> rows3 =
			 * jdbcTemplate.queryForList(StaffCircularQueryUtil .EDIT_DETAIL4,
			 * new Object[] { staffNotificationId });
			 * 
			 * for (Map row : rows3) {
			 * StaffCircularBean.getGrade().add(row.get("grade")); }
			 */
			for (int i = 0; i < StaffCircularBean.getDepartment().size(); i++) {
				if (StaffCircularBean.getDepartment().get(i) != null) {
					if (whereCode.isEmpty()) {

						whereCode = whereCode + " where department_id=" + StaffCircularBean.getDepartment().get(i) + "";
					} else {
						if (i == 0) {
							whereCode = whereCode + "  and department_id in(" + StaffCircularBean.getDepartment().get(i) + "";

						} else {
							whereCode = whereCode + ", " + StaffCircularBean.getDepartment().get(i) + "";
						}
						if (i == (StaffCircularBean.getDepartment().size() - 1)) {
							whereCode = whereCode + ")";
						}
					}
				}
			}

			/*
			 * for (int i = 0; i < StaffCircularBean.getDesignation().size();
			 * i++) { if (StaffCircularBean.getDesignation().get(i) != null) {
			 * if (whereCode.isEmpty()) {
			 * 
			 * whereCode = whereCode + " where designation_id=" +
			 * StaffCircularBean.getDesignation().get(i) + ""; } else { if (i ==
			 * 0) { whereCode = whereCode + "  and designation_id in(" +
			 * StaffCircularBean.getDesignation().get(i) + "";
			 * 
			 * } else {
			 * 
			 * whereCode = whereCode + ", " +
			 * StaffCircularBean.getDesignation().get(i) + ""; } if (i ==
			 * (StaffCircularBean.getDesignation().size() - 1)) { whereCode =
			 * whereCode + ")"; }
			 * 
			 * } } }
			 */

			for (int i = 0; i < StaffCircularBean.getDivision().size(); i++) {
				if (StaffCircularBean.getDivision().get(i) != null) {

					if (whereCode.isEmpty()) {

						whereCode = whereCode + " where division_id=" + StaffCircularBean.getDivision().get(i) + "";
					} else {
						if (i == 0) {
							whereCode = whereCode + "  and division_id in(" + StaffCircularBean.getDivision().get(i) + "";

						} else {
							whereCode = whereCode + ", " + StaffCircularBean.getDivision().get(i) + "";
						}

						System.out.println(i + " -->i " + " getDivision --> " + StaffCircularBean.getDivision().size());
						if (i == (StaffCircularBean.getDivision().size() - 1)) {
							whereCode = whereCode + ")";
						}

					}
				}
			}

			/*
			 * for (int i = 0; i < StaffCircularBean.getGrade().size(); i++) {
			 * if (StaffCircularBean.getGrade().get(i) != null) { if
			 * (whereCode.isEmpty()) {
			 * 
			 * whereCode = whereCode + " where grade_id=" +
			 * StaffCircularBean.getGrade().get(i) + ""; } else { if (i == 0) {
			 * whereCode = whereCode + "  and grade_id in(" +
			 * StaffCircularBean.getGrade().get(i) + "";
			 * 
			 * } else { whereCode = whereCode + ", " +
			 * StaffCircularBean.getGrade().get(i) + ""; } if (i ==
			 * (StaffCircularBean.getGrade().size() - 1)) { whereCode =
			 * whereCode + ")"; }
			 * 
			 * } } }
			 */

			/*
			 * for (int i = 0; i < StaffCircularBean.getReporting().size(); i++)
			 * { if (StaffCircularBean.getReporting().get(i) != null) { if
			 * (whereCode.isEmpty()) {
			 * 
			 * whereCode = whereCode + "where reporting_to='" +
			 * StaffCircularBean.getReporting().get(i) + "'"; } else { if (i ==
			 * 0) { whereCode = whereCode + " and reporting_to in ('" +
			 * StaffCircularBean.getReporting().get(i) + "'";
			 * 
			 * } else {
			 * 
			 * whereCode = whereCode + ", '" +
			 * StaffCircularBean.getReporting().get(i) + "'";
			 * 
			 * } if (i == (StaffCircularBean.getReporting().size() - 1)) {
			 * whereCode = whereCode + ")"; }
			 * 
			 * }
			 * 
			 * } } for (int i = 0; i < StaffCircularBean.getReporting().size();
			 * i++) { if (StaffCircularBean.getReporting().get(i) != null) { if
			 * (whereCode.isEmpty()) {
			 * 
			 * whereCode = whereCode + "where employee_id='" +
			 * StaffCircularBean.getReporting().get(i) + "'"; } else { if (i ==
			 * 0) { whereCode = whereCode + " or employee_id in ('" +
			 * StaffCircularBean.getReporting().get(i) + "'";
			 * 
			 * } else {
			 * 
			 * whereCode = whereCode + ", '" +
			 * StaffCircularBean.getReporting().get(i) + "'";
			 * 
			 * } if (i == (StaffCircularBean.getReporting().size() - 1)) {
			 * whereCode = whereCode + ")"; }
			 * 
			 * }
			 * 
			 * } }
			 */
			String data = " ";
			String querys = StaffCircularQueryUtil.GET_EMPLOYEE_REPORT_LIST + data + whereCode + data + "group by employee_id";
			List<StaffCircularBean> MobileNo = new ArrayList<StaffCircularBean>();
			MobileNo = jdbcTemplate.query(querys, new BeanPropertyRowMapper<StaffCircularBean>(StaffCircularBean.class));
			for (int i = 0; i < MobileNo.size(); i++) {
				String employeembnum = MobileNo.get(i).getPhoneNo();

				String message = StaffCircularBean.getNotificationContent();

				String requestUrl = "http://www.businesssms.co.in/SMS.aspx?ID=" + URLEncoder.encode(username, "UTF-8") + "&Pwd=" + URLEncoder.encode(password, "UTF-8") + "&PhNo=" + URLEncoder.encode(employeembnum, "UTF-8") + "&Text=" + URLEncoder.encode(message, "UTF-8") + "&ScheduleAt= ";
				URL url = new URL(requestUrl);
				InputStream in = url.openStream();

				jdbcTemplate.update(StaffCircularQueryUtil.UPDATE_STATUS, staffCircularId);
				jdbcTemplate.update(StaffCircularQueryUtil.SAVE_SMS_LOG, employeembnum, userDetail.getCustomerId(), message);

			}
			StaffCircularResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean saveNotification(StaffCircularBean StaffCircularBean) {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			// quotationMap.put("validFromDate",
			// CommonUtil.convertSqlDateFormat(purchaseQuotation.getValidFromDate()));

			Object[] params = new Object[] { StaffCircularBean.getNotificationContent(), userDetail.getUserId(), StaffCircularBean.getFromDate(), StaffCircularBean.getToDate(), StaffCircularBean.getTitle() };
			int k = jdbcTemplate.queryForObject(StaffCircularQueryUtil.SAVE_NOTIFICATION, params, Integer.class);
			if (k > 0) {
				for (int i = 0; i < StaffCircularBean.getDepartment().size(); i++) {
					Object[] params1 = new Object[] {  StaffCircularBean.getDepartment().get(i), k };
					jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION1, params1);
				}
				for (int i = 0; i < StaffCircularBean.getDivision().size(); i++) {
					Object[] params1 = new Object[] { StaffCircularBean.getDivision().get(i), k };
					jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION2, params1);
				}
				/*
				 * for (int i = 0; i <
				 * StaffCircularBean.getDesignation().size(); i++) { Object[]
				 * params1 = new Object[] { Integer.parseInt((String)
				 * StaffCircularBean.getDesignation().get(i)), k }; jdbcTemplate
				 * .update(StaffCircularQueryUtil.SAVE_NOTIFICATION3, params1);
				 * } for (int i = 0; i < StaffCircularBean.getGrade().size();
				 * i++) { Object[] params1 = new Object[] {
				 * Integer.parseInt((String)
				 * StaffCircularBean.getGrade().get(i)), k }; jdbcTemplate
				 * .update(StaffCircularQueryUtil.SAVE_NOTIFICATION4, params1);
				 * }
				 */

				StaffCircularResultBean.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean updateNotification(StaffCircularBean StaffCircularBean) {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			Object[] params = new Object[] { StaffCircularBean.getNotificationContent(), StaffCircularBean.getTitle(), userDetail.getUserId(),StaffCircularBean.getFromDate(), StaffCircularBean.getToDate(), StaffCircularBean.getStaffNotificationId() };
			int k = jdbcTemplate.update(StaffCircularQueryUtil.UPDATE_NOTIFICATION, params);

			jdbcTemplate.update(StaffCircularQueryUtil.DELETE_NOTIFICATION, StaffCircularBean.getStaffNotificationId());

			if (k > 0) {
				for (int i = 0; i < StaffCircularBean.getDepartment().size(); i++) {

					jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION1, StaffCircularBean.getDepartment().get(i), StaffCircularBean.getStaffNotificationId());
				}
				for (int i = 0; i < StaffCircularBean.getDivision().size(); i++) {

					jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION2, StaffCircularBean.getDivision().get(i), StaffCircularBean.getStaffNotificationId());
				}
				/*
				 * for (int i = 0; i <
				 * StaffCircularBean.getDesignation().size(); i++) {
				 * 
				 * jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION3
				 * , Integer.parseInt((String)
				 * StaffCircularBean.getDesignation().get(i)),
				 * StaffCircularBean.getStaffNotificationId()); } for (int i =
				 * 0; i < StaffCircularBean.getGrade().size(); i++) {
				 * 
				 * jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION4
				 * , Integer.parseInt((String)
				 * StaffCircularBean.getGrade().get(i)),
				 * StaffCircularBean.getStaffNotificationId()); }
				 */

				StaffCircularResultBean.setStaffNotificationBeanDetail(StaffCircularBean);
				StaffCircularResultBean.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean editNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		StaffCircularBean StaffCircularBean = new StaffCircularBean();
		try {
			StaffCircularBean = jdbcTemplate.queryForObject(StaffCircularQueryUtil.EDIT_DETAIL, new BeanPropertyRowMapper<StaffCircularBean>(StaffCircularBean.class), staffNotificationId);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(StaffCircularQueryUtil.EDIT_DETAIL1, new Object[] { staffNotificationId });

			for (Map row : rows) {
				StaffCircularBean.getDepartment().add(row.get("department"));
			}

			/*
			 * List<Map<String, Object>> rows1 =
			 * jdbcTemplate.queryForList(StaffCircularQueryUtil .EDIT_DETAIL2,
			 * new Object[] { staffNotificationId });
			 * 
			 * for (Map row : rows1) { StaffCircularBean.getDesignation
			 * ().add(row.get("designation")); }
			 */

			List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(StaffCircularQueryUtil.EDIT_DETAIL3, new Object[] { staffNotificationId });

			for (Map row : rows2) {
				StaffCircularBean.getDivision().add(row.get("division"));
			}
			/*
			 * List<Map<String, Object>> rows3 =
			 * jdbcTemplate.queryForList(StaffCircularQueryUtil .EDIT_DETAIL4,
			 * new Object[] { staffNotificationId });
			 * 
			 * for (Map row : rows3) {
			 * StaffCircularBean.getGrade().add(row.get("grade")); }
			 */

			StaffCircularResultBean.setStaffNotificationBeanDetail(StaffCircularBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean deleteNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();

		try

		{
			jdbcTemplate.update(StaffCircularQueryUtil.DELETE_NOTIFICATION, staffNotificationId);
			jdbcTemplate.update(StaffCircularQueryUtil.DELETE_NOTIFICATION1, staffNotificationId);
			StaffCircularResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean saveAndPublishNotification(StaffCircularBean StaffCircularBean) {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String whereCode = "where status='t'";
		try {
			Object[] params = new Object[] { StaffCircularBean.getNotificationContent(), userDetail.getUserId() };
			int staffNotificationId = jdbcTemplate.queryForObject(StaffCircularQueryUtil.SAVE_NOTIFICATION, params, Integer.class);
			if (staffNotificationId > 0) {
				for (int i = 0; i < StaffCircularBean.getDepartment().size(); i++) {
					Object[] params1 = new Object[] { Integer.parseInt((String) StaffCircularBean.getDepartment().get(i)), staffNotificationId };
					jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION1, params1);
				}
				for (int i = 0; i < StaffCircularBean.getDivision().size(); i++) {
					Object[] params1 = new Object[] { Integer.parseInt((String) StaffCircularBean.getDivision().get(i)), staffNotificationId };
					jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION2, params1);
				}
				/*
				 * for (int i = 0; i <
				 * StaffCircularBean.getDesignation().size(); i++) { Object[]
				 * params1 = new Object[] { Integer.parseInt((String)
				 * StaffCircularBean.getDesignation().get(i)),
				 * staffNotificationId };
				 * jdbcTemplate.update(StaffCircularQueryUtil
				 * .SAVE_NOTIFICATION3, params1); } for (int i = 0; i <
				 * StaffCircularBean.getGrade().size(); i++) { Object[] params1
				 * = new Object[] { Integer.parseInt((String)
				 * StaffCircularBean.getGrade().get(i)), staffNotificationId };
				 * jdbcTemplate.update(StaffCircularQueryUtil
				 * .SAVE_NOTIFICATION4, params1); }
				 */

				List<Map<String, Object>> rows = jdbcTemplate.queryForList(StaffCircularQueryUtil.EDIT_DETAIL1, new Object[] { staffNotificationId });

				for (Map row : rows) {
					StaffCircularBean.getDepartment().add(row.get("department"));
				}

				/*
				 * List<Map<String, Object>> rows1 =
				 * jdbcTemplate.queryForList(StaffCircularQueryUtil
				 * .EDIT_DETAIL2, new Object[] { staffNotificationId });
				 * 
				 * for (Map row : rows1) { StaffCircularBean.getDesignation
				 * ().add(row.get("designation")); }
				 */

				List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(StaffCircularQueryUtil.EDIT_DETAIL3, new Object[] { staffNotificationId });

				for (Map row : rows2) {
					StaffCircularBean.getDivision().add(row.get("division"));
				}

				/*
				 * List<Map<String, Object>> rows3 =
				 * jdbcTemplate.queryForList(StaffCircularQueryUtil
				 * .EDIT_DETAIL4, new Object[] { staffNotificationId });
				 * 
				 * for (Map row : rows3) {
				 * StaffCircularBean.getGrade().add(row.get("grade")); }
				 */

				for (int i = 0; i < StaffCircularBean.getDepartment().size(); i++) {
					if (StaffCircularBean.getDepartment().get(i) != null) {
						if (whereCode.isEmpty()) {

							whereCode = whereCode + " where department_id=" + StaffCircularBean.getDepartment().get(i) + "";
						} else {
							if (i == 0) {
								whereCode = whereCode + "  and department_id in(" + StaffCircularBean.getDepartment().get(i) + "";

							} else {
								whereCode = whereCode + ", " + StaffCircularBean.getDepartment().get(i) + "";
							}
							if (i == (StaffCircularBean.getDepartment().size() - 1)) {
								whereCode = whereCode + ")";
							}
						}
					}
				}

				/*
				 * for (int i = 0; i <
				 * StaffCircularBean.getDesignation().size(); i++) { if
				 * (StaffCircularBean.getDesignation().get(i) != null) { if
				 * (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + " where designation_id=" +
				 * StaffCircularBean.getDesignation().get(i) + ""; } else { if
				 * (i == 0) { whereCode = whereCode + "  and designation_id in("
				 * + StaffCircularBean.getDesignation().get(i) + "";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", " +
				 * StaffCircularBean.getDesignation().get(i) + ""; } if (i ==
				 * (StaffCircularBean.getDesignation().size() - 1)) { whereCode
				 * = whereCode + ")"; }
				 * 
				 * } } }
				 */

				for (int i = 0; i < StaffCircularBean.getDivision().size(); i++) {
					if (StaffCircularBean.getDivision().get(i) != null) {

						if (whereCode.isEmpty()) {

							whereCode = whereCode + " where division_id=" + StaffCircularBean.getDivision().get(i) + "";
						} else {
							if (i == 0) {
								whereCode = whereCode + "  and division_id in(" + StaffCircularBean.getDivision().get(i) + "";

							} else {
								whereCode = whereCode + ", " + StaffCircularBean.getDivision().get(i) + "";
							}

							System.out.println(i + " -->i " + " getDivision --> " + StaffCircularBean.getDivision().size());
							if (i == (StaffCircularBean.getDivision().size() - 1)) {
								whereCode = whereCode + ")";
							}

						}
					}
				}

				/*
				 * for (int i = 0; i < StaffCircularBean.getGrade().size(); i++)
				 * { if (StaffCircularBean.getGrade().get(i) != null) { if
				 * (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + " where grade_id=" +
				 * StaffCircularBean.getGrade().get(i) + ""; } else { if (i ==
				 * 0) { whereCode = whereCode + "  and grade_id in(" +
				 * StaffCircularBean.getGrade().get(i) + "";
				 * 
				 * } else { whereCode = whereCode + ", " +
				 * StaffCircularBean.getGrade().get(i) + ""; } if (i ==
				 * (StaffCircularBean.getGrade().size() - 1)) { whereCode =
				 * whereCode + ")"; }
				 * 
				 * } } }
				 */

				/*
				 * for (int i = 0; i < StaffCircularBean.getReporting().size();
				 * i++) { if (StaffCircularBean.getReporting().get(i) != null) {
				 * if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + "where reporting_to='" +
				 * StaffCircularBean.getReporting().get(i) + "'"; } else { if (i
				 * == 0) { whereCode = whereCode + " and reporting_to in ('" +
				 * StaffCircularBean.getReporting().get(i) + "'";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", '" +
				 * StaffCircularBean.getReporting().get(i) + "'";
				 * 
				 * } if (i == (StaffCircularBean.getReporting().size() - 1)) {
				 * whereCode = whereCode + ")"; }
				 * 
				 * }
				 * 
				 * } }
				 */
				/*
				 * for (int i = 0; i < StaffCircularBean.getReporting().size();
				 * i++) { if (StaffCircularBean.getReporting().get(i) != null) {
				 * if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + "where reporting_to='" +
				 * StaffCircularBean.getReporting().get(i) + "'"; } else { if (i
				 * == 0) { whereCode = whereCode + " or employee_id in ('" +
				 * StaffCircularBean.getReporting().get(i) + "'";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", '" +
				 * StaffCircularBean.getReporting().get(i) + "'";
				 * 
				 * } if (i == (StaffCircularBean.getReporting().size() - 1)) {
				 * whereCode = whereCode + ")"; }
				 * 
				 * }
				 * 
				 * } }
				 */
				String data = " ";
				String querys = StaffCircularQueryUtil.GET_EMPLOYEE_REPORT_LIST + data + whereCode + data + "group by employee_id";
				List<StaffCircularBean> MobileNo = new ArrayList<StaffCircularBean>();
				MobileNo = jdbcTemplate.query(querys, new BeanPropertyRowMapper<StaffCircularBean>(StaffCircularBean.class));
				if (MobileNo.size() > 0) {
					for (int i = 0; i < MobileNo.size(); i++) {
						String employeembnum = MobileNo.get(i).getPhoneNo();

						String message = StaffCircularBean.getNotificationContent();

						String requestUrl = "http://www.businesssms.co.in/SMS.aspx?ID=" + URLEncoder.encode(username, "UTF-8") + "&Pwd=" + URLEncoder.encode(password, "UTF-8") + "&PhNo=" + URLEncoder.encode(employeembnum, "UTF-8") + "&Text=" + URLEncoder.encode(message, "UTF-8") + "&ScheduleAt= ";
						URL url = new URL(requestUrl);
						InputStream in = url.openStream();

						jdbcTemplate.update(StaffCircularQueryUtil.UPDATE_STATUS, staffNotificationId);

						jdbcTemplate.update(StaffCircularQueryUtil.SAVE_SMS_LOG, employeembnum, userDetail.getCustomerId(), message);

					}
				} else {
					StaffCircularResultBean.setSuccess(false);

				}
				StaffCircularResultBean.setSuccess(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean getDepartmentList() {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		List<SelectivityBean> ldepartmentlist = new ArrayList<SelectivityBean>();
		try {
			ldepartmentlist = jdbcTemplate.query(StaffCircularQueryUtil.GET_DEPARTMENT_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			StaffCircularResultBean.setLdepartmentlist(ldepartmentlist);
			StaffCircularResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean getDesignationList() {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		List<SelectivityBean> ldesignationlist = new ArrayList<SelectivityBean>();
		try {
			ldesignationlist = jdbcTemplate.query(StaffCircularQueryUtil.GET_DESIGNATION_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			StaffCircularResultBean.setLdesignationlist(ldesignationlist);
			StaffCircularResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean getDivisionList() {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		List<SelectivityBean> ldivisionlist = new ArrayList<SelectivityBean>();
		try {
			ldivisionlist = jdbcTemplate.query(StaffCircularQueryUtil.GET_DIVISION_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			StaffCircularResultBean.setLdivisionlist(ldivisionlist);
			StaffCircularResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean getRepotingToList() {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		List<SelectivityBean> lreportingTolist = new ArrayList<SelectivityBean>();
		try {
			lreportingTolist = jdbcTemplate.query(StaffCircularQueryUtil.GET_REPORTINGTO_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			StaffCircularResultBean.setLreportingTolist(lreportingTolist);
			StaffCircularResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean getGradeList() {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		List<SelectivityBean> lgradelist = new ArrayList<SelectivityBean>();
		try {
			lgradelist = jdbcTemplate.query(StaffCircularQueryUtil.GET_GRADE_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			StaffCircularResultBean.setLgradelist(lgradelist);
			StaffCircularResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}

	@Override
	public StaffCircularResultBean UpdateAndPublishNotification(StaffCircularBean StaffCircularBean) {
		// TODO Auto-generated method stub
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String whereCode = "where status='t'";
		try {
			Object[] params = new Object[] { StaffCircularBean.getNotificationContent(), userDetail.getUserId(), StaffCircularBean.getStaffNotificationId() };
			int k = jdbcTemplate.update(StaffCircularQueryUtil.UPDATE_NOTIFICATION, params);

			jdbcTemplate.update(StaffCircularQueryUtil.DELETE_NOTIFICATION, StaffCircularBean.getStaffNotificationId());

			if (k > 0) {
				for (int i = 0; i < StaffCircularBean.getDepartment().size(); i++) {

					jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION1, Integer.parseInt((String) StaffCircularBean.getDepartment().get(i)), StaffCircularBean.getStaffNotificationId());
				}
				for (int i = 0; i < StaffCircularBean.getDivision().size(); i++) {

					jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION2, Integer.parseInt((String) StaffCircularBean.getDivision().get(i)), StaffCircularBean.getStaffNotificationId());
				}
				/*
				 * for (int i = 0; i <
				 * StaffCircularBean.getDesignation().size(); i++) {
				 * 
				 * jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION3
				 * , Integer.parseInt((String)
				 * StaffCircularBean.getDesignation().get(i)),
				 * StaffCircularBean.getStaffNotificationId()); } for (int i =
				 * 0; i < StaffCircularBean.getGrade().size(); i++) {
				 * 
				 * jdbcTemplate.update(StaffCircularQueryUtil.SAVE_NOTIFICATION4
				 * , Integer.parseInt((String)
				 * StaffCircularBean.getGrade().get(i)),
				 * StaffCircularBean.getStaffNotificationId()); }
				 */

				StaffCircularResultBean.setStaffNotificationBeanDetail(StaffCircularBean);
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(StaffCircularQueryUtil.EDIT_DETAIL1, new Object[] { StaffCircularBean.getStaffNotificationId() });

				for (Map row : rows) {
					StaffCircularBean.getDepartment().add(row.get("department"));
				}

				/*
				 * List<Map<String, Object>> rows1 =
				 * jdbcTemplate.queryForList(StaffCircularQueryUtil
				 * .EDIT_DETAIL2, new Object[] {
				 * StaffCircularBean.getStaffNotificationId() });
				 * 
				 * for (Map row : rows1) { StaffCircularBean.getDesignation
				 * ().add(row.get("designation")); }
				 */

				List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(StaffCircularQueryUtil.EDIT_DETAIL3, new Object[] { StaffCircularBean.getStaffNotificationId() });

				for (Map row : rows2) {
					StaffCircularBean.getDivision().add(row.get("division"));
				}

				/*
				 * List<Map<String, Object>> rows3 =
				 * jdbcTemplate.queryForList(StaffCircularQueryUtil
				 * .EDIT_DETAIL4, new Object[] {
				 * StaffCircularBean.getStaffNotificationId() });
				 * 
				 * for (Map row : rows3) {
				 * StaffCircularBean.getGrade().add(row.get("grade")); }
				 */
				for (int i = 0; i < StaffCircularBean.getDepartment().size(); i++) {
					if (StaffCircularBean.getDepartment().get(i) != null) {
						if (whereCode.isEmpty()) {

							whereCode = whereCode + " where department_id=" + StaffCircularBean.getDepartment().get(i) + "";
						} else {
							if (i == 0) {
								whereCode = whereCode + "  and department_id in(" + StaffCircularBean.getDepartment().get(i) + "";

							} else {
								whereCode = whereCode + ", " + StaffCircularBean.getDepartment().get(i) + "";
							}
							if (i == (StaffCircularBean.getDepartment().size() - 1)) {
								whereCode = whereCode + ")";
							}
						}
					}
				}

				/*
				 * for (int i = 0; i <
				 * StaffCircularBean.getDesignation().size(); i++) { if
				 * (StaffCircularBean.getDesignation().get(i) != null) { if
				 * (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + " where designation_id=" +
				 * StaffCircularBean.getDesignation().get(i) + ""; } else { if
				 * (i == 0) { whereCode = whereCode + "  and designation_id in("
				 * + StaffCircularBean.getDesignation().get(i) + "";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", " +
				 * StaffCircularBean.getDesignation().get(i) + ""; } if (i ==
				 * (StaffCircularBean.getDesignation().size() - 1)) { whereCode
				 * = whereCode + ")"; }
				 * 
				 * } } }
				 */

				for (int i = 0; i < StaffCircularBean.getDivision().size(); i++) {
					if (StaffCircularBean.getDivision().get(i) != null) {

						if (whereCode.isEmpty()) {

							whereCode = whereCode + " where division_id=" + StaffCircularBean.getDivision().get(i) + "";
						} else {
							if (i == 0) {
								whereCode = whereCode + "  and division_id in(" + StaffCircularBean.getDivision().get(i) + "";

							} else {
								whereCode = whereCode + ", " + StaffCircularBean.getDivision().get(i) + "";
							}

							System.out.println(i + " -->i " + " getDivision --> " + StaffCircularBean.getDivision().size());
							if (i == (StaffCircularBean.getDivision().size() - 1)) {
								whereCode = whereCode + ")";
							}

						}
					}
				}

				/*
				 * for (int i = 0; i < StaffCircularBean.getGrade().size(); i++)
				 * { if (StaffCircularBean.getGrade().get(i) != null) { if
				 * (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + " where grade_id=" +
				 * StaffCircularBean.getGrade().get(i) + ""; } else { if (i ==
				 * 0) { whereCode = whereCode + "  and grade_id in(" +
				 * StaffCircularBean.getGrade().get(i) + "";
				 * 
				 * } else { whereCode = whereCode + ", " +
				 * StaffCircularBean.getGrade().get(i) + ""; } if (i ==
				 * (StaffCircularBean.getGrade().size() - 1)) { whereCode =
				 * whereCode + ")"; }
				 * 
				 * } } }
				 */
				/*
				 * for (int i = 0; i < StaffCircularBean.getReporting().size();
				 * i++) { if (StaffCircularBean.getReporting().get(i) != null) {
				 * if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + "where reporting_to='" +
				 * StaffCircularBean.getReporting().get(i) + "'"; } else { if (i
				 * == 0) { whereCode = whereCode + " and reporting_to in ('" +
				 * StaffCircularBean.getReporting().get(i) + "'";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", '" +
				 * StaffCircularBean.getReporting().get(i) + "'";
				 * 
				 * } if (i == (StaffCircularBean.getReporting().size() - 1)) {
				 * whereCode = whereCode + ")"; }
				 * 
				 * }
				 * 
				 * } }
				 */
				/*
				 * for (int i = 0; i < StaffCircularBean.getReporting().size();
				 * i++) { if (StaffCircularBean.getReporting().get(i) != null) {
				 * if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + "where reporting_to='" +
				 * StaffCircularBean.getReporting().get(i) + "'"; } else { if (i
				 * == 0) { whereCode = whereCode + " or employee_id in ('" +
				 * StaffCircularBean.getReporting().get(i) + "'";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", '" +
				 * StaffCircularBean.getReporting().get(i) + "'";
				 * 
				 * } if (i == (StaffCircularBean.getReporting().size() - 1)) {
				 * whereCode = whereCode + ")"; }
				 * 
				 * }
				 * 
				 * } }
				 */
				String data = " ";
				String querys = StaffCircularQueryUtil.GET_EMPLOYEE_REPORT_LIST + data + whereCode + data + "group by employee_id";
				List<StaffCircularBean> MobileNo = new ArrayList<StaffCircularBean>();
				MobileNo = jdbcTemplate.query(querys, new BeanPropertyRowMapper<StaffCircularBean>(StaffCircularBean.class));
				for (int i = 0; i < MobileNo.size(); i++) {
					String employeembnum = MobileNo.get(i).getPhoneNo();

					String message = StaffCircularBean.getNotificationContent();

					String requestUrl = "http://www.businesssms.co.in/SMS.aspx?ID=" + URLEncoder.encode(username, "UTF-8") + "&Pwd=" + URLEncoder.encode(password, "UTF-8") + "&PhNo=" + URLEncoder.encode(employeembnum, "UTF-8") + "&Text=" + URLEncoder.encode(message, "UTF-8") + "&ScheduleAt= ";
					URL url = new URL(requestUrl);
					InputStream in = url.openStream();

					jdbcTemplate.update(StaffCircularQueryUtil.UPDATE_STATUS, StaffCircularBean.getStaffNotificationId());
					jdbcTemplate.update(StaffCircularQueryUtil.SAVE_SMS_LOG, employeembnum, userDetail.getCustomerId(), message);

				}
				StaffCircularResultBean.setSuccess(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;
	}
}
