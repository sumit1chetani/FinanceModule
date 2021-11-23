package  com.dci.finance.shiftallocation;

import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.auditlog.EmployeeMasterBean;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")
public class ShiftAllocationDAOImpl implements ShiftAllocationDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ShiftAllocationDAOImpl.class);
	@Resource
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ShiftAllocationBean> getShiftAllocationList() throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ShiftAllocationBean> shiftAllocationList = new ArrayList<ShiftAllocationBean>();
		try {
			shiftAllocationList = jdbcTemplate.query(ShiftAllocationQueryUtil.GetShiftAllocationList, new BeanPropertyRowMapper<ShiftAllocationBean>(ShiftAllocationBean.class));
			return shiftAllocationList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ShiftAllocationResultBean getBranchList(String companyId) throws Exception {
		ShiftAllocationResultBean objShiftAllocationResultBean = new ShiftAllocationResultBean();
		List<ShiftAllocationBean> branchList = new ArrayList<ShiftAllocationBean>();
		try {
			branchList = jdbcTemplate.query(ShiftAllocationQueryUtil.SELECT_BRANCH_LIST, new BeanPropertyRowMapper<ShiftAllocationBean>(ShiftAllocationBean.class), companyId);
			objShiftAllocationResultBean.setBranchList(branchList);
			objShiftAllocationResultBean.setSuccess(true);
			return objShiftAllocationResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Branch List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ShiftAllocationResultBean getDepartmentList(String branchId) throws Exception {
		ShiftAllocationResultBean objShiftAllocationResultBean = new ShiftAllocationResultBean();
		List<ShiftAllocationBean> departmentList = new ArrayList<ShiftAllocationBean>();
		try {
			departmentList = jdbcTemplate.query(ShiftAllocationQueryUtil.SELECT_DEPARTMENT_LIST, new BeanPropertyRowMapper<ShiftAllocationBean>(ShiftAllocationBean.class), new Object[] { branchId });
			objShiftAllocationResultBean.setDepartmentList(departmentList);
			objShiftAllocationResultBean.setSuccess(true);
			return objShiftAllocationResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Department List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ShiftAllocationResultBean getEmployeeList(ShiftAllocationBean bean) throws Exception {
		ShiftAllocationResultBean objShiftAllocationResultBean = new ShiftAllocationResultBean();
		List<ShiftAllocationBean> employeeList = new ArrayList<ShiftAllocationBean>();
		try {
			employeeList = jdbcTemplate.query(ShiftAllocationQueryUtil.SELECT_EMPLOYEE_LIST, new BeanPropertyRowMapper<ShiftAllocationBean>(ShiftAllocationBean.class), bean.getDeptId(), bean.getBranchId());
			objShiftAllocationResultBean.setEmployeeList(employeeList);
			objShiftAllocationResultBean.setSuccess(true);
			return objShiftAllocationResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ShiftAllocationResultBean getSchemeList(ShiftAllocationBean shiftAllocationBean) throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ShiftAllocationResultBean objShiftAllocationResultBean = new ShiftAllocationResultBean();
		List<ShiftAllocationBean> schemeList = new ArrayList<ShiftAllocationBean>();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String date = shiftAllocationBean.getValidityFrom();
			Date fromDate = formatter.parse(date);

			String date1 = shiftAllocationBean.getValidityTo();
			Date toDate = formatter.parse(date1);
			String empId = shiftAllocationBean.getEmployeeId();

			int rowCount = jdbcTemplate.queryForObject(ShiftAllocationQueryUtil.getDateCount, Integer.class, fromDate, toDate, shiftAllocationBean.getEmployeeId() );
			if (rowCount > 0) {
				objShiftAllocationResultBean.setMessage("Shift Scheme Already Allocated for this employee");
				objShiftAllocationResultBean.setSuccess(false);
			} else {
				schemeList = jdbcTemplate.query(ShiftAllocationQueryUtil.SELECT_SCHEME_LIST, new BeanPropertyRowMapper<ShiftAllocationBean>(ShiftAllocationBean.class), fromDate, toDate, userDetail.getCompanyCode());
				objShiftAllocationResultBean.setSchemeList(schemeList);
				objShiftAllocationResultBean.setSuccess(true);
			}
			return objShiftAllocationResultBean;
		} catch (Exception e) {
//			LOGGER.error("Error in Scheme List", e.getMessage());
			e.printStackTrace();
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ShiftAllocationBean addShiftAllocation(ShiftAllocationBean objShiftAllocationBean) throws Exception {
		ShiftAllocationBean objAllocationBean = new ShiftAllocationBean();
		List<ShiftAllocationBean> shiftAllocationObjList = new ArrayList<ShiftAllocationBean>();
		EmployeeMasterBean objbean = new EmployeeMasterBean();
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		boolean isSuccess = false;
		int value = 0, detailValue = 0;
		boolean isReserved = false;
		boolean weekOff = false;
		boolean weekEnd = false;
		try {

			String fromDate = objShiftAllocationBean.getValidityFrom();

			Date date = formatter.parse(fromDate);
			java.sql.Timestamp validityFrom = new Timestamp(date.getTime());

			String toDate = objShiftAllocationBean.getValidityTo();

			Date date1 = formatter.parse(toDate);
			java.sql.Timestamp validityTo = new Timestamp(date1.getTime());

			int shiftId;
			String schemename = "";
			String shftSchemeName = "";
			String schemeNm = "";

			schemeNm = objShiftAllocationBean.getShiftId();
			int sName = Integer.parseInt(schemeNm);
			int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.DATE, Types.DATE, Types.BOOLEAN };

			shftSchemeName = jdbcTemplate.queryForObject(ShiftAllocationQueryUtil.SELECT_SHIFT_NAME, String.class, sName);

			shiftAllocationObjList = jdbcTemplate.query(ShiftAllocationQueryUtil.checkSchemeName, new BeanPropertyRowMapper<ShiftAllocationBean>(ShiftAllocationBean.class), shftSchemeName);

			if (shiftAllocationObjList.size() > 0) {
				DateFormat formatterq = new SimpleDateFormat("dd/MM/yyyy");
				String valFromdate = objShiftAllocationBean.getValidityFrom();
				Date frmDt = formatterq.parse(valFromdate);
				String valTodate = objShiftAllocationBean.getValidityTo();
				Date ToDate = formatterq.parse(valTodate);
				String[] employeeId = objShiftAllocationBean.getEmployeeId().split(",");
				String employeeuniqueId = "";
				String id = "";
				for (int i = 0; i < employeeId.length; i++) {
					employeeuniqueId = employeeId[i];
					if (!employeeuniqueId.equalsIgnoreCase(id)) {
						boolean checkEmpJoinDate = jdbcTemplate.queryForObject(ShiftAllocationQueryUtil.checkEmpJoinDate, Boolean.class, frmDt, employeeuniqueId);

						boolean checkEmpToDate = jdbcTemplate.queryForObject(ShiftAllocationQueryUtil.checkEmpJoinDate, Boolean.class, ToDate, employeeuniqueId);

						if (checkEmpJoinDate == false) {
							objbean = jdbcTemplate.queryForObject(ShiftAllocationQueryUtil.getEmpJoinDate, new BeanPropertyRowMapper<EmployeeMasterBean>(EmployeeMasterBean.class), employeeuniqueId);
							fromDate = objbean.getDoj();
							Date date11 = formatter.parse(fromDate);
							validityFrom = new Timestamp(date11.getTime());
						}

						Object[] params = new Object[] { employeeuniqueId, sName, validityFrom, validityTo, isReserved };
						if (checkEmpToDate == true) {

							value = jdbcTemplate.update(ShiftAllocationQueryUtil.sAddShiftAllocation, params, types);
							if (value != 0) {

								Date datefrm = formatter.parse(fromDate);
								Date dateto = formatter.parse(toDate);
								int days = (int) ((dateto.getTime() - datefrm.getTime()) / (1000 * 60 * 60 * 24));
								List<Date> dates = new ArrayList<Date>();
								long interval = 24 * 1000 * 60 * 60;
								long endTime = dateto.getTime();

								long curTime = datefrm.getTime();
								while (curTime <= endTime) {
									dates.add(new Date(curTime));
									curTime += interval;
								}

								for (int iCount = 0; iCount < dates.size(); iCount++) {
									Date lDate = dates.get(iCount);
									String ds = formatter.format(lDate);
									Date sqeDate = formatter.parse(ds);

									String dayOfWeek = null;
									int weekDays = 0;
									dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(sqeDate);
									String getdayOfWeek = "";
									getdayOfWeek = dayOfWeek;

									if ((getdayOfWeek).equals("Sunday"))
										weekDays = 1;
									else if ((getdayOfWeek).equals("Monday"))
										weekDays = 2;
									else if ((getdayOfWeek).equals("Tuesday"))
										weekDays = 3;
									else if ((getdayOfWeek).equals("Wednesday"))
										weekDays = 4;
									else if ((getdayOfWeek).equals("Thursday"))
										weekDays = 5;
									else if ((getdayOfWeek).equals("Friday"))
										weekDays = 6;
									else if ((getdayOfWeek).equals("Saturday"))
										weekDays = 7;

									schemename = jdbcTemplate.queryForObject(ShiftAllocationQueryUtil.SELECT_SHIFT_NAME, String.class, sName);

									int[] typ = new int[] { Types.VARCHAR, Types.INTEGER };
									Object[] par = new Object[] { schemename, weekDays };

									shiftId = jdbcTemplate.queryForObject(ShiftAllocationQueryUtil.SELECT_SHIFT, par, typ, Integer.class);

									if (shiftId == -1) {
										weekOff = false;
										weekEnd = true;
									} else if (shiftId == 0) {
										weekOff = true;
										weekEnd = false;
									} else {
										weekOff = false;
										weekEnd = false;
									}

									int[] types1 = new int[] { Types.VARCHAR, Types.INTEGER,

									Types.DATE, Types.BOOLEAN, Types.BOOLEAN };
									Object[] params1 = new Object[] {

									employeeuniqueId, shiftId, sqeDate, weekOff, weekEnd };

									detailValue = jdbcTemplate.update(ShiftAllocationQueryUtil.sAddShiftAllocationDetail, params1, types1);

									if (detailValue != 0) {
										objAllocationBean.setSuccess(true);
										objAllocationBean.setDsatesuccess(true);
										objAllocationBean.setErrorMessage("Record Saved Successfully");
									}
								}
							}
						} else {
							objAllocationBean.setSuccess(false);
							objAllocationBean.setDsatesuccess(false);
							objAllocationBean.setErrorMessage("Validity To Should be greater than your date of joining!");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return objAllocationBean;
	}

	@Override
	public boolean updateShiftAllocation(ShiftAllocationBean objShiftAllocationBean) throws Exception {
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		boolean isSuccess = false;
		int value = 0, detailValue = 0, deleteValue = 0;
		boolean weekOff = false;
		boolean weekEnd = false;

		try {

			String fromDate = objShiftAllocationBean.getValidityFrom();
			Date date = formatter.parse(fromDate);
			java.sql.Timestamp validityFrom = new Timestamp(date.getTime());
			String toDate = objShiftAllocationBean.getValidityTo();
			Date date1 = formatter.parse(toDate);
			java.sql.Timestamp validityTo = new Timestamp(date1.getTime());
			String schemeName = objShiftAllocationBean.getSchemeName();
			int schemeid = objShiftAllocationBean.getSchemeId();
			int[] types = new int[] { Types.DATE, Types.VARCHAR, Types.INTEGER, Types.DATE };
			Object[] params = new Object[] { validityTo, objShiftAllocationBean.getEmployeeNo(), schemeid, validityFrom };

			value = jdbcTemplate.update(ShiftAllocationQueryUtil.sUpdateShiftAllocation, params, types);

			if (value != 0) {

				Date datefrm = formatter.parse(fromDate);
				Date dateto = formatter.parse(toDate);
				int days = (int) ((dateto.getTime() - datefrm.getTime()) / (1000 * 60 * 60 * 24));
				List<Date> dates = new ArrayList<Date>();
				long interval = 24 * 1000 * 60 * 60;
				long endTime = dateto.getTime();

				long curTime = datefrm.getTime();
				while (curTime <= endTime) {
					dates.add(new Date(curTime));
					curTime += interval;
				}

				for (int iCount = 0; iCount < dates.size(); iCount++) {
					Date lDate = dates.get(iCount);
					String ds = formatter.format(lDate);
					Date sqeDate = formatter.parse(ds);
					int shiftId = 0;
					String dayOfWeek = null;
					int weekDays = 0;
					dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(sqeDate);
					String getdayOfWeek = "";
					getdayOfWeek = dayOfWeek;

					if ((getdayOfWeek).equals("Sunday"))
						weekDays = 1;
					// return weekDays;
					else if ((getdayOfWeek).equals("Monday"))
						weekDays = 2;
					else if ((getdayOfWeek).equals("Tuesday"))
						weekDays = 3;
					else if ((getdayOfWeek).equals("Wednesday"))
						weekDays = 4;
					else if ((getdayOfWeek).equals("Thursday"))
						weekDays = 5;
					else if ((getdayOfWeek).equals("Friday"))
						weekDays = 6;
					else if ((getdayOfWeek).equals("Saturday"))
						weekDays = 7;

					int[] typ = new int[] { Types.VARCHAR, Types.INTEGER };
					Object[] par = new Object[] { objShiftAllocationBean.getSchemeName(), weekDays };

					shiftId = jdbcTemplate.queryForObject(ShiftAllocationQueryUtil.SELECT_SHIFT, par, typ, Integer.class);

					int[] type = new int[] { Types.VARCHAR, Types.DATE };
					Object[] param = new Object[] { objShiftAllocationBean.getEmployeeNo(), sqeDate };

					deleteValue = jdbcTemplate.update(ShiftAllocationQueryUtil.sUpdateDeleteShiftAllocationDetail, param, type);

					if (shiftId == -1) {
						weekOff = false;
						weekEnd = true;
					} else if (shiftId == 0) {
						weekOff = true;
						weekEnd = false;
					} else {
						weekOff = false;
						weekEnd = false;
					}

					int[] types1 = new int[] { Types.VARCHAR, Types.INTEGER, Types.DATE, Types.BOOLEAN, Types.BOOLEAN };
					Object[] params1 = new Object[] { objShiftAllocationBean.getEmployeeNo(), shiftId, sqeDate, weekOff, weekEnd };

					detailValue = jdbcTemplate.update(ShiftAllocationQueryUtil.sAddShiftAllocationDetail, params1, types1);

					if (detailValue != 0) {
						isSuccess = true;
					}
				}
			}

		} catch (Exception e) {
			LOGGER.error("Error in Update Shift Allocation", e);
			throw new CustomException(ErrorMessage.ERROR_UPDATE);
		}

		return isSuccess;
	}

	@Override
	public ShiftAllocationBean getShiftAllocationEditList(int schemeId, String employeeId, String validFrom, String validTo) throws CustomException {

		ShiftAllocationBean objShiftAllocationBean = new ShiftAllocationBean();
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ShiftAllocationQueryUtil.sGetShiftAllocationEditList, new Object[] { employeeId, schemeId, validFrom, validTo });

			for (Map row : rows) {

				objShiftAllocationBean.setEmployeeNo((String) row.get("employeeNo"));
				objShiftAllocationBean.setSchemeName((String) row.get("schemeName"));
				objShiftAllocationBean.setSchemeId((int) row.get("schemeId"));
				objShiftAllocationBean.setValidityFrom((String) row.get("validityFrom"));
				objShiftAllocationBean.setValidityTo((String) row.get("validityTo"));
				objShiftAllocationBean.setDepartmentId(String.valueOf((int) row.get("departmentId")));
				objShiftAllocationBean.setBranchId((String) row.get("branchId"));
				objShiftAllocationBean.setDepartmentName((String) row.get("departmentName"));
				objShiftAllocationBean.setValidTo((String) row.get("ValidTo"));
				objShiftAllocationBean.setBranchName((String) row.get("branchName"));

				objShiftAllocationBean.setCompanyId((String) row.get("companyId"));
				objShiftAllocationBean.setEmployeeName((String) row.get("employeeName"));

			}
		} catch (Exception e) {
      e.printStackTrace();
throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return objShiftAllocationBean;
	}

	@Override
	public boolean deleteShiftAllocation(int schemeId, String employeeId, String validFrom, String validTo) throws Exception {
		boolean issucces = false;
		int value = 0;
		try {
			jdbcTemplate.update(ShiftAllocationQueryUtil.deleteEmpShift, employeeId, validFrom, validTo);
			value = jdbcTemplate.update(ShiftAllocationQueryUtil.sDeleteShiftAllocation, schemeId, employeeId, validFrom, validTo);

			if (value != 0) {
				issucces = true;
			}
		} catch (Exception e) {
			LOGGER.error("Error in Delete", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		return issucces;
	}

	@Override
	public ShiftAllocationResultBean getShiftList() throws Exception {
		ShiftAllocationResultBean objShiftAllocationResultBean = new ShiftAllocationResultBean();
		List<ShiftAllocationBean> shiftList = new ArrayList<ShiftAllocationBean>();
		try {
			shiftList = jdbcTemplate.query(ShiftAllocationQueryUtil.SELECT_SHIFT_LIST, new BeanPropertyRowMapper<ShiftAllocationBean>(ShiftAllocationBean.class));
			objShiftAllocationResultBean.setShiftList(shiftList);
			objShiftAllocationResultBean.setSuccess(true);
			return objShiftAllocationResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Scheme List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ShiftAllocationResultBean getDateList(String schemeName) throws Exception {
		ShiftAllocationResultBean objShiftAllocationResultBean = new ShiftAllocationResultBean();
		List<ShiftAllocationBean> dateList = new ArrayList<ShiftAllocationBean>();
		try {
			dateList = jdbcTemplate.query(ShiftAllocationQueryUtil.SELECT_DATE_LIST, new BeanPropertyRowMapper<ShiftAllocationBean>(ShiftAllocationBean.class), new Object[] { schemeName });
			objShiftAllocationResultBean.setDateList(dateList);
			objShiftAllocationResultBean.setSuccess(true);
			return objShiftAllocationResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

}
