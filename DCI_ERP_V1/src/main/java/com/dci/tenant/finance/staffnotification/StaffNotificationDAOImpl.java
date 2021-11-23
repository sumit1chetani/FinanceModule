package com.dci.tenant.finance.staffnotification;

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

public class StaffNotificationDAOImpl implements StaffNotificationDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	//@Value("${sms.url.username}")
	private String username;

	//@Value("${sms.url.password}")
	private String password;

	@Override
	public StaffNotificationResultBean getNotification() {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		List<StaffNotificationBeanDetail> lstaffNotificationBeanDetail = new ArrayList<StaffNotificationBeanDetail>();

		try {
			lstaffNotificationBeanDetail = jdbcTemplate.query(StaffNotificationQueryUtil.GET_LIST, new BeanPropertyRowMapper<StaffNotificationBeanDetail>(StaffNotificationBeanDetail.class));
			staffNotificationResultBean.setLstaffNotificationBeanDetail(lstaffNotificationBeanDetail);
			staffNotificationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean publishNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		String whereCode = "where status='t'";
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			StaffNotificationBeanDetail staffNotificationBeanDetail = new StaffNotificationBeanDetail();
			staffNotificationBeanDetail = jdbcTemplate.queryForObject(StaffNotificationQueryUtil.EDIT_DETAIL, new BeanPropertyRowMapper<StaffNotificationBeanDetail>(StaffNotificationBeanDetail.class), staffNotificationId);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(StaffNotificationQueryUtil.EDIT_DETAIL1, new Object[] { staffNotificationId });

			for (Map row : rows) {
				staffNotificationBeanDetail.getDepartment().add(row.get("department"));
			}

			/*
			 * List<Map<String, Object>> rows1 =
			 * jdbcTemplate.queryForList(StaffNotificationQueryUtil
			 * .EDIT_DETAIL2, new Object[] { staffNotificationId });
			 * 
			 * for (Map row : rows1) {
			 * staffNotificationBeanDetail.getDesignation
			 * ().add(row.get("designation")); }
			 */

			List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(StaffNotificationQueryUtil.EDIT_DETAIL3, new Object[] { staffNotificationId });

			for (Map row : rows2) {
				staffNotificationBeanDetail.getDivision().add(row.get("division"));
			}

			/*
			 * List<Map<String, Object>> rows3 =
			 * jdbcTemplate.queryForList(StaffNotificationQueryUtil
			 * .EDIT_DETAIL4, new Object[] { staffNotificationId });
			 * 
			 * for (Map row : rows3) {
			 * staffNotificationBeanDetail.getGrade().add(row.get("grade")); }
			 */
			for (int i = 0; i < staffNotificationBeanDetail.getDepartment().size(); i++) {
				if (staffNotificationBeanDetail.getDepartment().get(i) != null) {
					if (whereCode.isEmpty()) {

						whereCode = whereCode + " where department_id=" + staffNotificationBeanDetail.getDepartment().get(i) + "";
					} else {
						if (i == 0) {
							whereCode = whereCode + "  and department_id in(" + staffNotificationBeanDetail.getDepartment().get(i) + "";

						} else {
							whereCode = whereCode + ", " + staffNotificationBeanDetail.getDepartment().get(i) + "";
						}
						if (i == (staffNotificationBeanDetail.getDepartment().size() - 1)) {
							whereCode = whereCode + ")";
						}
					}
				}
			}

			/*
			 * for (int i = 0; i <
			 * staffNotificationBeanDetail.getDesignation().size(); i++) { if
			 * (staffNotificationBeanDetail.getDesignation().get(i) != null) {
			 * if (whereCode.isEmpty()) {
			 * 
			 * whereCode = whereCode + " where designation_id=" +
			 * staffNotificationBeanDetail.getDesignation().get(i) + ""; } else
			 * { if (i == 0) { whereCode = whereCode +
			 * "  and designation_id in(" +
			 * staffNotificationBeanDetail.getDesignation().get(i) + "";
			 * 
			 * } else {
			 * 
			 * whereCode = whereCode + ", " +
			 * staffNotificationBeanDetail.getDesignation().get(i) + ""; } if (i
			 * == (staffNotificationBeanDetail.getDesignation().size() - 1)) {
			 * whereCode = whereCode + ")"; }
			 * 
			 * } } }
			 */

			for (int i = 0; i < staffNotificationBeanDetail.getDivision().size(); i++) {
				if (staffNotificationBeanDetail.getDivision().get(i) != null) {

					if (whereCode.isEmpty()) {

						whereCode = whereCode + " where division_id=" + staffNotificationBeanDetail.getDivision().get(i) + "";
					} else {
						if (i == 0) {
							whereCode = whereCode + "  and division_id in(" + staffNotificationBeanDetail.getDivision().get(i) + "";

						} else {
							whereCode = whereCode + ", " + staffNotificationBeanDetail.getDivision().get(i) + "";
						}

						System.out.println(i + " -->i " + " getDivision --> " + staffNotificationBeanDetail.getDivision().size());
						if (i == (staffNotificationBeanDetail.getDivision().size() - 1)) {
							whereCode = whereCode + ")";
						}

					}
				}
			}

			/*
			 * for (int i = 0; i <
			 * staffNotificationBeanDetail.getGrade().size(); i++) { if
			 * (staffNotificationBeanDetail.getGrade().get(i) != null) { if
			 * (whereCode.isEmpty()) {
			 * 
			 * whereCode = whereCode + " where grade_id=" +
			 * staffNotificationBeanDetail.getGrade().get(i) + ""; } else { if
			 * (i == 0) { whereCode = whereCode + "  and grade_id in(" +
			 * staffNotificationBeanDetail.getGrade().get(i) + "";
			 * 
			 * } else { whereCode = whereCode + ", " +
			 * staffNotificationBeanDetail.getGrade().get(i) + ""; } if (i ==
			 * (staffNotificationBeanDetail.getGrade().size() - 1)) { whereCode
			 * = whereCode + ")"; }
			 * 
			 * } } }
			 */

			/*
			 * for (int i = 0; i <
			 * staffNotificationBeanDetail.getReporting().size(); i++) { if
			 * (staffNotificationBeanDetail.getReporting().get(i) != null) { if
			 * (whereCode.isEmpty()) {
			 * 
			 * whereCode = whereCode + "where reporting_to='" +
			 * staffNotificationBeanDetail.getReporting().get(i) + "'"; } else {
			 * if (i == 0) { whereCode = whereCode + " and reporting_to in ('" +
			 * staffNotificationBeanDetail.getReporting().get(i) + "'";
			 * 
			 * } else {
			 * 
			 * whereCode = whereCode + ", '" +
			 * staffNotificationBeanDetail.getReporting().get(i) + "'";
			 * 
			 * } if (i == (staffNotificationBeanDetail.getReporting().size() -
			 * 1)) { whereCode = whereCode + ")"; }
			 * 
			 * }
			 * 
			 * } } for (int i = 0; i <
			 * staffNotificationBeanDetail.getReporting().size(); i++) { if
			 * (staffNotificationBeanDetail.getReporting().get(i) != null) { if
			 * (whereCode.isEmpty()) {
			 * 
			 * whereCode = whereCode + "where employee_id='" +
			 * staffNotificationBeanDetail.getReporting().get(i) + "'"; } else {
			 * if (i == 0) { whereCode = whereCode + " or employee_id in ('" +
			 * staffNotificationBeanDetail.getReporting().get(i) + "'";
			 * 
			 * } else {
			 * 
			 * whereCode = whereCode + ", '" +
			 * staffNotificationBeanDetail.getReporting().get(i) + "'";
			 * 
			 * } if (i == (staffNotificationBeanDetail.getReporting().size() -
			 * 1)) { whereCode = whereCode + ")"; }
			 * 
			 * }
			 * 
			 * } }
			 */
			String data = " ";
			String querys = StaffNotificationQueryUtil.GET_EMPLOYEE_REPORT_LIST + data + whereCode + data + "group by employee_id";
			List<StaffNotificationBeanDetail> MobileNo = new ArrayList<StaffNotificationBeanDetail>();
			MobileNo = jdbcTemplate.query(querys, new BeanPropertyRowMapper<StaffNotificationBeanDetail>(StaffNotificationBeanDetail.class));
			for (int i = 0; i < MobileNo.size(); i++) {
				String employeembnum = MobileNo.get(i).getPhoneNo();

				String message = staffNotificationBeanDetail.getNotificationContent();

				String requestUrl = "http://www.businesssms.co.in/SMS.aspx?ID=" + URLEncoder.encode(username, "UTF-8") + "&Pwd=" + URLEncoder.encode(password, "UTF-8") + "&PhNo=" + URLEncoder.encode(employeembnum, "UTF-8") + "&Text=" + URLEncoder.encode(message, "UTF-8") + "&ScheduleAt= ";
				URL url = new URL(requestUrl);
				InputStream in = url.openStream();

				jdbcTemplate.update(StaffNotificationQueryUtil.UPDATE_STATUS, staffNotificationId);
				jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_SMS_LOG, employeembnum, userDetail.getCustomerId(), message);

			}
			staffNotificationResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean publish(int staffNotificationId) {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		StaffNotificationBeanDetail bean = new StaffNotificationBeanDetail();

		String whereCode = "where status='t'";
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			StaffNotificationBeanDetail staffNotificationBeanDetail = new StaffNotificationBeanDetail();
			Object[] params = new Object[] { "Publish", staffNotificationId };
			int k = jdbcTemplate.update(StaffNotificationQueryUtil.UPDATE, params);

			staffNotificationResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean saveNotification(StaffNotificationBeanDetail staffNotificationBeanDetail) {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			Object[] params = new Object[] { staffNotificationBeanDetail.getNotificationContent(), userDetail.getUserId() };
			int k = jdbcTemplate.queryForObject(StaffNotificationQueryUtil.SAVE_NOTIFICATION, params, Integer.class);
			if (k > 0) {
				for (int i = 0; i < staffNotificationBeanDetail.getDepartment().size(); i++) {
					Object[] params1 = new Object[] {staffNotificationBeanDetail.getDepartment().get(i), k };
					jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION1, params1);
				}
				for (int i = 0; i < staffNotificationBeanDetail.getDivision().size(); i++) {
					Object[] params1 = new Object[] { staffNotificationBeanDetail.getDivision().get(i), k  };
					jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION2, params1);
				}
				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getDesignation().size(); i++) {
				 * Object[] params1 = new Object[] { Integer.parseInt((String)
				 * staffNotificationBeanDetail.getDesignation().get(i)), k };
				 * jdbcTemplate
				 * .update(StaffNotificationQueryUtil.SAVE_NOTIFICATION3,
				 * params1); } for (int i = 0; i <
				 * staffNotificationBeanDetail.getGrade().size(); i++) {
				 * Object[] params1 = new Object[] { Integer.parseInt((String)
				 * staffNotificationBeanDetail.getGrade().get(i)), k };
				 * jdbcTemplate
				 * .update(StaffNotificationQueryUtil.SAVE_NOTIFICATION4,
				 * params1); }
				 */

				staffNotificationResultBean.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean updateNotification(StaffNotificationBeanDetail staffNotificationBeanDetail) {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			Object[] params = new Object[] { staffNotificationBeanDetail.getNotificationContent(), userDetail.getUserId(), staffNotificationBeanDetail.getStaffNotificationId() };
			int k = jdbcTemplate.update(StaffNotificationQueryUtil.UPDATE_NOTIFICATION, params);

			jdbcTemplate.update(StaffNotificationQueryUtil.DELETE_NOTIFICATION, staffNotificationBeanDetail.getStaffNotificationId());

			if (k > 0) {
				for (int i = 0; i < staffNotificationBeanDetail.getDepartment().size(); i++) {

					jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION1, staffNotificationBeanDetail.getDepartment().get(i), staffNotificationBeanDetail.getStaffNotificationId());
				}
				for (int i = 0; i < staffNotificationBeanDetail.getDivision().size(); i++) {

					jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION2,  staffNotificationBeanDetail.getDivision().get(i), staffNotificationBeanDetail.getStaffNotificationId());
				}
				
				staffNotificationResultBean.setStaffNotificationBeanDetail(staffNotificationBeanDetail);
				staffNotificationResultBean.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean editNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		StaffNotificationBeanDetail staffNotificationBeanDetail = new StaffNotificationBeanDetail();
		try {
			staffNotificationBeanDetail = jdbcTemplate.queryForObject(StaffNotificationQueryUtil.EDIT_DETAIL, new BeanPropertyRowMapper<StaffNotificationBeanDetail>(StaffNotificationBeanDetail.class), staffNotificationId);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(StaffNotificationQueryUtil.EDIT_DETAIL1, new Object[] { staffNotificationId });

			for (Map row : rows) {
				staffNotificationBeanDetail.getDepartment().add(row.get("department"));
			}

			/*
			 * List<Map<String, Object>> rows1 =
			 * jdbcTemplate.queryForList(StaffNotificationQueryUtil
			 * .EDIT_DETAIL2, new Object[] { staffNotificationId });
			 * 
			 * for (Map row : rows1) {
			 * staffNotificationBeanDetail.getDesignation
			 * ().add(row.get("designation")); }
			 */

			List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(StaffNotificationQueryUtil.EDIT_DETAIL3, new Object[] { staffNotificationId });

			for (Map row : rows2) {
				staffNotificationBeanDetail.getDivision().add(row.get("division"));
			}
			/*
			 * List<Map<String, Object>> rows3 =
			 * jdbcTemplate.queryForList(StaffNotificationQueryUtil
			 * .EDIT_DETAIL4, new Object[] { staffNotificationId });
			 * 
			 * for (Map row : rows3) {
			 * staffNotificationBeanDetail.getGrade().add(row.get("grade")); }
			 */

			StaffNotificationResultBean.setStaffNotificationBeanDetail(staffNotificationBeanDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean deleteNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();

		try

		{
			jdbcTemplate.update(StaffNotificationQueryUtil.DELETE_NOTIFICATION, staffNotificationId);
			jdbcTemplate.update(StaffNotificationQueryUtil.DELETE_NOTIFICATION1, staffNotificationId);
			staffNotificationResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean saveAndPublishNotification(StaffNotificationBeanDetail staffNotificationBeanDetail) {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String whereCode = "where status='t'";
		try {
			Object[] params = new Object[] { staffNotificationBeanDetail.getNotificationContent(), userDetail.getUserId() };
			int staffNotificationId = jdbcTemplate.queryForObject(StaffNotificationQueryUtil.SAVE_NOTIFICATION, params, Integer.class);
			if (staffNotificationId > 0) {
				for (int i = 0; i < staffNotificationBeanDetail.getDepartment().size(); i++) {
					Object[] params1 = new Object[] { Integer.parseInt((String) staffNotificationBeanDetail.getDepartment().get(i)), staffNotificationId };
					jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION1, params1);
				}
				for (int i = 0; i < staffNotificationBeanDetail.getDivision().size(); i++) {
					Object[] params1 = new Object[] { Integer.parseInt((String) staffNotificationBeanDetail.getDivision().get(i)), staffNotificationId };
					jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION2, params1);
				}
				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getDesignation().size(); i++) {
				 * Object[] params1 = new Object[] { Integer.parseInt((String)
				 * staffNotificationBeanDetail.getDesignation().get(i)),
				 * staffNotificationId };
				 * jdbcTemplate.update(StaffNotificationQueryUtil
				 * .SAVE_NOTIFICATION3, params1); } for (int i = 0; i <
				 * staffNotificationBeanDetail.getGrade().size(); i++) {
				 * Object[] params1 = new Object[] { Integer.parseInt((String)
				 * staffNotificationBeanDetail.getGrade().get(i)),
				 * staffNotificationId };
				 * jdbcTemplate.update(StaffNotificationQueryUtil
				 * .SAVE_NOTIFICATION4, params1); }
				 */

				List<Map<String, Object>> rows = jdbcTemplate.queryForList(StaffNotificationQueryUtil.EDIT_DETAIL1, new Object[] { staffNotificationId });

				for (Map row : rows) {
					staffNotificationBeanDetail.getDepartment().add(row.get("department"));
				}

				/*
				 * List<Map<String, Object>> rows1 =
				 * jdbcTemplate.queryForList(StaffNotificationQueryUtil
				 * .EDIT_DETAIL2, new Object[] { staffNotificationId });
				 * 
				 * for (Map row : rows1) {
				 * staffNotificationBeanDetail.getDesignation
				 * ().add(row.get("designation")); }
				 */

				List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(StaffNotificationQueryUtil.EDIT_DETAIL3, new Object[] { staffNotificationId });

				for (Map row : rows2) {
					staffNotificationBeanDetail.getDivision().add(row.get("division"));
				}

				/*
				 * List<Map<String, Object>> rows3 =
				 * jdbcTemplate.queryForList(StaffNotificationQueryUtil
				 * .EDIT_DETAIL4, new Object[] { staffNotificationId });
				 * 
				 * for (Map row : rows3) {
				 * staffNotificationBeanDetail.getGrade().add(row.get("grade"));
				 * }
				 */

				for (int i = 0; i < staffNotificationBeanDetail.getDepartment().size(); i++) {
					if (staffNotificationBeanDetail.getDepartment().get(i) != null) {
						if (whereCode.isEmpty()) {

							whereCode = whereCode + " where department_id=" + staffNotificationBeanDetail.getDepartment().get(i) + "";
						} else {
							if (i == 0) {
								whereCode = whereCode + "  and department_id in(" + staffNotificationBeanDetail.getDepartment().get(i) + "";

							} else {
								whereCode = whereCode + ", " + staffNotificationBeanDetail.getDepartment().get(i) + "";
							}
							if (i == (staffNotificationBeanDetail.getDepartment().size() - 1)) {
								whereCode = whereCode + ")";
							}
						}
					}
				}

				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getDesignation().size(); i++) {
				 * if (staffNotificationBeanDetail.getDesignation().get(i) !=
				 * null) { if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + " where designation_id=" +
				 * staffNotificationBeanDetail.getDesignation().get(i) + ""; }
				 * else { if (i == 0) { whereCode = whereCode +
				 * "  and designation_id in(" +
				 * staffNotificationBeanDetail.getDesignation().get(i) + "";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", " +
				 * staffNotificationBeanDetail.getDesignation().get(i) + ""; }
				 * if (i == (staffNotificationBeanDetail.getDesignation().size()
				 * - 1)) { whereCode = whereCode + ")"; }
				 * 
				 * } } }
				 */

				for (int i = 0; i < staffNotificationBeanDetail.getDivision().size(); i++) {
					if (staffNotificationBeanDetail.getDivision().get(i) != null) {

						if (whereCode.isEmpty()) {

							whereCode = whereCode + " where division_id=" + staffNotificationBeanDetail.getDivision().get(i) + "";
						} else {
							if (i == 0) {
								whereCode = whereCode + "  and division_id in(" + staffNotificationBeanDetail.getDivision().get(i) + "";

							} else {
								whereCode = whereCode + ", " + staffNotificationBeanDetail.getDivision().get(i) + "";
							}

							System.out.println(i + " -->i " + " getDivision --> " + staffNotificationBeanDetail.getDivision().size());
							if (i == (staffNotificationBeanDetail.getDivision().size() - 1)) {
								whereCode = whereCode + ")";
							}

						}
					}
				}

				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getGrade().size(); i++) { if
				 * (staffNotificationBeanDetail.getGrade().get(i) != null) { if
				 * (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + " where grade_id=" +
				 * staffNotificationBeanDetail.getGrade().get(i) + ""; } else {
				 * if (i == 0) { whereCode = whereCode + "  and grade_id in(" +
				 * staffNotificationBeanDetail.getGrade().get(i) + "";
				 * 
				 * } else { whereCode = whereCode + ", " +
				 * staffNotificationBeanDetail.getGrade().get(i) + ""; } if (i
				 * == (staffNotificationBeanDetail.getGrade().size() - 1)) {
				 * whereCode = whereCode + ")"; }
				 * 
				 * } } }
				 */

				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getReporting().size(); i++) { if
				 * (staffNotificationBeanDetail.getReporting().get(i) != null) {
				 * if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + "where reporting_to='" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'"; }
				 * else { if (i == 0) { whereCode = whereCode +
				 * " and reporting_to in ('" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", '" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'";
				 * 
				 * } if (i == (staffNotificationBeanDetail.getReporting().size()
				 * - 1)) { whereCode = whereCode + ")"; }
				 * 
				 * }
				 * 
				 * } }
				 */
				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getReporting().size(); i++) { if
				 * (staffNotificationBeanDetail.getReporting().get(i) != null) {
				 * if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + "where reporting_to='" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'"; }
				 * else { if (i == 0) { whereCode = whereCode +
				 * " or employee_id in ('" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", '" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'";
				 * 
				 * } if (i == (staffNotificationBeanDetail.getReporting().size()
				 * - 1)) { whereCode = whereCode + ")"; }
				 * 
				 * }
				 * 
				 * } }
				 */
				String data = " ";
				String querys = StaffNotificationQueryUtil.GET_EMPLOYEE_REPORT_LIST + data + whereCode + data + "group by employee_id";
				List<StaffNotificationBeanDetail> MobileNo = new ArrayList<StaffNotificationBeanDetail>();
				MobileNo = jdbcTemplate.query(querys, new BeanPropertyRowMapper<StaffNotificationBeanDetail>(StaffNotificationBeanDetail.class));
				if (MobileNo.size() > 0) {
					for (int i = 0; i < MobileNo.size(); i++) {
						String employeembnum = MobileNo.get(i).getPhoneNo();

						String message = staffNotificationBeanDetail.getNotificationContent();

						String requestUrl = "http://www.businesssms.co.in/SMS.aspx?ID=" + URLEncoder.encode(username, "UTF-8") + "&Pwd=" + URLEncoder.encode(password, "UTF-8") + "&PhNo=" + URLEncoder.encode(employeembnum, "UTF-8") + "&Text=" + URLEncoder.encode(message, "UTF-8") + "&ScheduleAt= ";
						URL url = new URL(requestUrl);
						InputStream in = url.openStream();

						jdbcTemplate.update(StaffNotificationQueryUtil.UPDATE_STATUS, staffNotificationId);

						jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_SMS_LOG, employeembnum, userDetail.getCustomerId(), message);

					}
				} else {
					staffNotificationResultBean.setSuccess(false);

				}
				staffNotificationResultBean.setSuccess(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean getDepartmentList() {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		List<SelectivityBean> ldepartmentlist = new ArrayList<SelectivityBean>();
		try {
			ldepartmentlist = jdbcTemplate.query(StaffNotificationQueryUtil.GET_DEPARTMENT_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			staffNotificationResultBean.setLdepartmentlist(ldepartmentlist);
			staffNotificationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean getDesignationList() {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		List<SelectivityBean> ldesignationlist = new ArrayList<SelectivityBean>();
		try {
			ldesignationlist = jdbcTemplate.query(StaffNotificationQueryUtil.GET_DESIGNATION_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			staffNotificationResultBean.setLdesignationlist(ldesignationlist);
			staffNotificationResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean getDivisionList() {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		List<SelectivityBean> ldivisionlist = new ArrayList<SelectivityBean>();
		try {
			ldivisionlist = jdbcTemplate.query(StaffNotificationQueryUtil.GET_DIVISION_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			staffNotificationResultBean.setLdivisionlist(ldivisionlist);
			staffNotificationResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean getRepotingToList() {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		List<SelectivityBean> lreportingTolist = new ArrayList<SelectivityBean>();
		try {
			lreportingTolist = jdbcTemplate.query(StaffNotificationQueryUtil.GET_REPORTINGTO_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			staffNotificationResultBean.setLreportingTolist(lreportingTolist);
			staffNotificationResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean getGradeList() {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		List<SelectivityBean> lgradelist = new ArrayList<SelectivityBean>();
		try {
			lgradelist = jdbcTemplate.query(StaffNotificationQueryUtil.GET_GRADE_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			staffNotificationResultBean.setLgradelist(lgradelist);
			staffNotificationResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean UpdateAndPublishNotification(StaffNotificationBeanDetail staffNotificationBeanDetail) {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String whereCode = "where status='t'";
		try {
			Object[] params = new Object[] { staffNotificationBeanDetail.getNotificationContent(), userDetail.getUserId(), staffNotificationBeanDetail.getStaffNotificationId() };
			int k = jdbcTemplate.update(StaffNotificationQueryUtil.UPDATE_NOTIFICATION, params);

			jdbcTemplate.update(StaffNotificationQueryUtil.DELETE_NOTIFICATION, staffNotificationBeanDetail.getStaffNotificationId());

			if (k > 0) {
				for (int i = 0; i < staffNotificationBeanDetail.getDepartment().size(); i++) {

					jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION1, Integer.parseInt((String) staffNotificationBeanDetail.getDepartment().get(i)), staffNotificationBeanDetail.getStaffNotificationId());
				}
				for (int i = 0; i < staffNotificationBeanDetail.getDivision().size(); i++) {

					jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION2, Integer.parseInt((String) staffNotificationBeanDetail.getDivision().get(i)), staffNotificationBeanDetail.getStaffNotificationId());
				}
				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getDesignation().size(); i++) {
				 * 
				 * jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION3
				 * , Integer.parseInt((String)
				 * staffNotificationBeanDetail.getDesignation().get(i)),
				 * staffNotificationBeanDetail.getStaffNotificationId()); } for
				 * (int i = 0; i <
				 * staffNotificationBeanDetail.getGrade().size(); i++) {
				 * 
				 * jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_NOTIFICATION4
				 * , Integer.parseInt((String)
				 * staffNotificationBeanDetail.getGrade().get(i)),
				 * staffNotificationBeanDetail.getStaffNotificationId()); }
				 */

				staffNotificationResultBean.setStaffNotificationBeanDetail(staffNotificationBeanDetail);
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(StaffNotificationQueryUtil.EDIT_DETAIL1, new Object[] { staffNotificationBeanDetail.getStaffNotificationId() });

				for (Map row : rows) {
					staffNotificationBeanDetail.getDepartment().add(row.get("department"));
				}

				/*
				 * List<Map<String, Object>> rows1 =
				 * jdbcTemplate.queryForList(StaffNotificationQueryUtil
				 * .EDIT_DETAIL2, new Object[] {
				 * staffNotificationBeanDetail.getStaffNotificationId() });
				 * 
				 * for (Map row : rows1) {
				 * staffNotificationBeanDetail.getDesignation
				 * ().add(row.get("designation")); }
				 */

				List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(StaffNotificationQueryUtil.EDIT_DETAIL3, new Object[] { staffNotificationBeanDetail.getStaffNotificationId() });

				for (Map row : rows2) {
					staffNotificationBeanDetail.getDivision().add(row.get("division"));
				}

				/*
				 * List<Map<String, Object>> rows3 =
				 * jdbcTemplate.queryForList(StaffNotificationQueryUtil
				 * .EDIT_DETAIL4, new Object[] {
				 * staffNotificationBeanDetail.getStaffNotificationId() });
				 * 
				 * for (Map row : rows3) {
				 * staffNotificationBeanDetail.getGrade().add(row.get("grade"));
				 * }
				 */
				for (int i = 0; i < staffNotificationBeanDetail.getDepartment().size(); i++) {
					if (staffNotificationBeanDetail.getDepartment().get(i) != null) {
						if (whereCode.isEmpty()) {

							whereCode = whereCode + " where department_id=" + staffNotificationBeanDetail.getDepartment().get(i) + "";
						} else {
							if (i == 0) {
								whereCode = whereCode + "  and department_id in(" + staffNotificationBeanDetail.getDepartment().get(i) + "";

							} else {
								whereCode = whereCode + ", " + staffNotificationBeanDetail.getDepartment().get(i) + "";
							}
							if (i == (staffNotificationBeanDetail.getDepartment().size() - 1)) {
								whereCode = whereCode + ")";
							}
						}
					}
				}

				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getDesignation().size(); i++) {
				 * if (staffNotificationBeanDetail.getDesignation().get(i) !=
				 * null) { if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + " where designation_id=" +
				 * staffNotificationBeanDetail.getDesignation().get(i) + ""; }
				 * else { if (i == 0) { whereCode = whereCode +
				 * "  and designation_id in(" +
				 * staffNotificationBeanDetail.getDesignation().get(i) + "";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", " +
				 * staffNotificationBeanDetail.getDesignation().get(i) + ""; }
				 * if (i == (staffNotificationBeanDetail.getDesignation().size()
				 * - 1)) { whereCode = whereCode + ")"; }
				 * 
				 * } } }
				 */

				for (int i = 0; i < staffNotificationBeanDetail.getDivision().size(); i++) {
					if (staffNotificationBeanDetail.getDivision().get(i) != null) {

						if (whereCode.isEmpty()) {

							whereCode = whereCode + " where division_id=" + staffNotificationBeanDetail.getDivision().get(i) + "";
						} else {
							if (i == 0) {
								whereCode = whereCode + "  and division_id in(" + staffNotificationBeanDetail.getDivision().get(i) + "";

							} else {
								whereCode = whereCode + ", " + staffNotificationBeanDetail.getDivision().get(i) + "";
							}

							System.out.println(i + " -->i " + " getDivision --> " + staffNotificationBeanDetail.getDivision().size());
							if (i == (staffNotificationBeanDetail.getDivision().size() - 1)) {
								whereCode = whereCode + ")";
							}

						}
					}
				}

				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getGrade().size(); i++) { if
				 * (staffNotificationBeanDetail.getGrade().get(i) != null) { if
				 * (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + " where grade_id=" +
				 * staffNotificationBeanDetail.getGrade().get(i) + ""; } else {
				 * if (i == 0) { whereCode = whereCode + "  and grade_id in(" +
				 * staffNotificationBeanDetail.getGrade().get(i) + "";
				 * 
				 * } else { whereCode = whereCode + ", " +
				 * staffNotificationBeanDetail.getGrade().get(i) + ""; } if (i
				 * == (staffNotificationBeanDetail.getGrade().size() - 1)) {
				 * whereCode = whereCode + ")"; }
				 * 
				 * } } }
				 */
				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getReporting().size(); i++) { if
				 * (staffNotificationBeanDetail.getReporting().get(i) != null) {
				 * if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + "where reporting_to='" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'"; }
				 * else { if (i == 0) { whereCode = whereCode +
				 * " and reporting_to in ('" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", '" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'";
				 * 
				 * } if (i == (staffNotificationBeanDetail.getReporting().size()
				 * - 1)) { whereCode = whereCode + ")"; }
				 * 
				 * }
				 * 
				 * } }
				 */
				/*
				 * for (int i = 0; i <
				 * staffNotificationBeanDetail.getReporting().size(); i++) { if
				 * (staffNotificationBeanDetail.getReporting().get(i) != null) {
				 * if (whereCode.isEmpty()) {
				 * 
				 * whereCode = whereCode + "where reporting_to='" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'"; }
				 * else { if (i == 0) { whereCode = whereCode +
				 * " or employee_id in ('" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'";
				 * 
				 * } else {
				 * 
				 * whereCode = whereCode + ", '" +
				 * staffNotificationBeanDetail.getReporting().get(i) + "'";
				 * 
				 * } if (i == (staffNotificationBeanDetail.getReporting().size()
				 * - 1)) { whereCode = whereCode + ")"; }
				 * 
				 * }
				 * 
				 * } }
				 */
				String data = " ";
				String querys = StaffNotificationQueryUtil.GET_EMPLOYEE_REPORT_LIST + data + whereCode + data + "group by employee_id";
				List<StaffNotificationBeanDetail> MobileNo = new ArrayList<StaffNotificationBeanDetail>();
				MobileNo = jdbcTemplate.query(querys, new BeanPropertyRowMapper<StaffNotificationBeanDetail>(StaffNotificationBeanDetail.class));
				for (int i = 0; i < MobileNo.size(); i++) {
					String employeembnum = MobileNo.get(i).getPhoneNo();

					String message = staffNotificationBeanDetail.getNotificationContent();

					String requestUrl = "http://www.businesssms.co.in/SMS.aspx?ID=" + URLEncoder.encode(username, "UTF-8") + "&Pwd=" + URLEncoder.encode(password, "UTF-8") + "&PhNo=" + URLEncoder.encode(employeembnum, "UTF-8") + "&Text=" + URLEncoder.encode(message, "UTF-8") + "&ScheduleAt= ";
					URL url = new URL(requestUrl);
					InputStream in = url.openStream();

					jdbcTemplate.update(StaffNotificationQueryUtil.UPDATE_STATUS, staffNotificationBeanDetail.getStaffNotificationId());
					jdbcTemplate.update(StaffNotificationQueryUtil.SAVE_SMS_LOG, employeembnum, userDetail.getCustomerId(), message);

				}
				staffNotificationResultBean.setSuccess(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

	@Override
	public StaffNotificationResultBean unpublish(int staffNotificationId) {
		// TODO Auto-generated method stub
		StaffNotificationResultBean staffNotificationResultBean = new StaffNotificationResultBean();
		StaffNotificationBeanDetail bean = new StaffNotificationBeanDetail();

		String whereCode = "where status='t'";
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			StaffNotificationBeanDetail staffNotificationBeanDetail = new StaffNotificationBeanDetail();
			Object[] params = new Object[] { "unPublish", staffNotificationId };
			int k = jdbcTemplate.update(StaffNotificationQueryUtil.UPDATE_unPublish, params);

			staffNotificationResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffNotificationResultBean;
	}

}
