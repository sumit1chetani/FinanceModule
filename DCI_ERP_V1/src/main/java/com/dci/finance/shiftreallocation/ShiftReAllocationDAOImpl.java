package com.dci.finance.shiftreallocation;

import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.dci.tenant.user.UserDetail;
@Transactional("tenantTransactionManager")

@Repository
public class ShiftReAllocationDAOImpl implements ShiftReAllocationDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ShiftReAllocationDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ShiftReAllocationBean> getShiftReAllocationList() throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ShiftReAllocationBean> shiftReAllocationList = new ArrayList<ShiftReAllocationBean>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ShiftReAllocationQueryUtil.GetShiftReAllocationList, userDetail.getCompanyCode());

			for (Map row : rows) {
				ShiftReAllocationBean shiftReAllocationBean = new ShiftReAllocationBean();
				shiftReAllocationBean.setEmployeeId((String) row.get("employeeId"));
				shiftReAllocationBean.setFromDate((String) row.get("fromDate"));
				shiftReAllocationBean.setToDate((String) row.get("toDate"));
				shiftReAllocationBean.setCompanyName((String) row.get("companyName"));

				shiftReAllocationBean.setCompanyId((String) row.get("companyId"));
				shiftReAllocationBean.setBranchId((String) row.get("branchId"));
				shiftReAllocationBean.setBranchName((String) row.get("branchName"));
				shiftReAllocationBean.setDepartmentName((String) row.get("departmentName"));
				shiftReAllocationBean.setDesignationName((String) row.get("designationName"));
				shiftReAllocationBean.setShiftId((int) row.get("shiftCode"));

				if (shiftReAllocationBean.getShiftId() == -1) {
					shiftReAllocationBean.setShiftName("Week End");
				} else if (shiftReAllocationBean.getShiftId() == 0) {
					shiftReAllocationBean.setShiftName("Weekly Off");
				} else {
					shiftReAllocationBean.setShiftName((String) row.get("shiftName"));
				}

				shiftReAllocationBean.setEmployeeName((String) row.get("employeeName"));
				shiftReAllocationList.add(shiftReAllocationBean);
			}

		} catch (Exception e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return shiftReAllocationList;
	}

	@Override
	public ShiftReAllocationResultBean getDesignationList(String empId) throws Exception {
		ShiftReAllocationResultBean objShiftReAllocationResultBean = new ShiftReAllocationResultBean();
		List<ShiftReAllocationBean> designationList = new ArrayList<ShiftReAllocationBean>();
		try {
			designationList = jdbcTemplate.query(ShiftReAllocationQueryUtil.SELECT_DESIG_LIST, new BeanPropertyRowMapper<ShiftReAllocationBean>(ShiftReAllocationBean.class), empId);
			objShiftReAllocationResultBean.setDesignationList(designationList);
			objShiftReAllocationResultBean.setSuccess(true);
			return objShiftReAllocationResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Designation List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean addShiftReAllocation(ShiftReAllocationBean objShiftReAllocationBean) throws CustomException {

		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		boolean isSuccess = false;
		boolean isReserved = true;
		int value = 0, values = 0;
		boolean weekOff = false;
		boolean weekEnd = false;

		try {

			String fromDt = objShiftReAllocationBean.getFromDate();

			Date date = formatter.parse(fromDt);
			java.sql.Timestamp fromDate = new Timestamp(date.getTime());

			String toDt = objShiftReAllocationBean.getToDate();

			Date date1 = formatter.parse(toDt);
			java.sql.Timestamp toDate = new Timestamp(date1.getTime());

			Date sysdate = new Date();

			java.sql.Timestamp sysDt = new Timestamp(sysdate.getTime());
			String[] employeeId = objShiftReAllocationBean.getEmployeeId().split(",");
			String employeeuniqueId = "";
			String id = "";
			for (int i = 0; i < employeeId.length; i++) {
				employeeuniqueId = employeeId[i];
				if (!employeeuniqueId.equalsIgnoreCase(id)) {
					int[] types = new int[] { Types.VARCHAR, Types.DATE, Types.DATE, Types.INTEGER };
					Object[] params = new Object[] { employeeuniqueId, fromDate, toDate, objShiftReAllocationBean.getShiftCode() };

					int checkAllocation = jdbcTemplate.queryForObject(ShiftReAllocationQueryUtil.checkAllocation, Integer.class, employeeuniqueId, fromDate, toDate);

					if (checkAllocation > 0) {
						value = jdbcTemplate.update(ShiftReAllocationQueryUtil.INSERT_SHIFT_REALLOCATION, params, types);

						if (value != 0) {

							Date datefrm = formatter.parse(fromDt);
							Date dateto = formatter.parse(toDt);
							List<Date> dates = new ArrayList<Date>();
							Calendar start = Calendar.getInstance();
							start.setTime(date);
							Calendar end = Calendar.getInstance();
							end.setTime(date1);

							for (Date datecheck = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), datecheck = start.getTime()) {
								Calendar cal = Calendar.getInstance();
								cal.setTime(datecheck);
								dates.add(cal.getTime());
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

								if (objShiftReAllocationBean.getShiftCode().equals("0")) {
									weekOff = true;
									weekEnd = false;
								} else if (objShiftReAllocationBean.getShiftCode().equals("-1")) {
									weekOff = false;
									weekEnd = true;
								} else {
									weekOff = false;
									weekEnd = false;
								}

								int[] type = new int[] { Types.INTEGER, Types.BOOLEAN, Types.BOOLEAN, Types.DATE, Types.VARCHAR };
								Object[] param = new Object[] { objShiftReAllocationBean.getShiftCode(), weekOff, weekEnd, sqeDate, employeeuniqueId };

								values = jdbcTemplate.update(ShiftReAllocationQueryUtil.sUpdateShiftReAllocation, param, type);

								if (values != 0) {
									isSuccess = true;
								}
							}
						}
					} else {
						throw new CustomException("Yet Shift did not Allocated for this employee. Please Allocate the Shift first");
					}

				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			LOGGER.error("Error in Add Shift ReAllocation", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;
	}

	// new update
	@Override
	public boolean updateShiftReAllocation(ShiftReAllocationBean objShiftReAllocationBean) throws Exception {
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		boolean isSuccess = false;
		int value = 0, values = 0, deleteValue = 0;
		boolean weekOff = false;
		boolean weekEnd = false;

		try {

			String fromDt = objShiftReAllocationBean.getFromDate();
			Date date = formatter.parse(fromDt);
			java.sql.Timestamp fromDate = new Timestamp(date.getTime());

			String toDt = objShiftReAllocationBean.getToDate();
			Date date1 = formatter.parse(toDt);
			java.sql.Timestamp toDate = new Timestamp(date1.getTime());

			int[] types = new int[] { Types.VARCHAR, Types.DATE, Types.VARCHAR, Types.DATE };
			Object[] params = new Object[] { objShiftReAllocationBean.getShiftCode(), toDate, objShiftReAllocationBean.getEmployeeId(), fromDate };

			value = jdbcTemplate.update(ShiftReAllocationQueryUtil.updateShiftReAllocation, params, types);

			if (value != 0) {

				Date datefrm = formatter.parse(fromDt);
				Date dateto = formatter.parse(toDt);
				List<Date> dates = new ArrayList<Date>();
				Calendar start = Calendar.getInstance();
				start.setTime(date);
				Calendar end = Calendar.getInstance();
				end.setTime(date1);

				for (Date datecheck = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), datecheck = start.getTime()) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(datecheck);
					dates.add(cal.getTime());
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

					if (objShiftReAllocationBean.getShiftCode().equals("0")) {
						weekOff = true;
						weekEnd = false;
					} else if (objShiftReAllocationBean.getShiftCode().equals("-1")) {
						weekOff = false;
						weekEnd = true;
					} else {
						weekOff = false;
						weekEnd = false;
					}

					int[] type = new int[] { Types.VARCHAR, Types.BOOLEAN, Types.BOOLEAN, Types.VARCHAR, Types.DATE };
					Object[] param = new Object[] { objShiftReAllocationBean.getShiftCode(), weekOff, weekEnd, objShiftReAllocationBean.getEmployeeId(), sqeDate };

					values = jdbcTemplate.update(ShiftReAllocationQueryUtil.updateReAllocation, param, type);

					if (values != 0) {
						isSuccess = true;
					}
				}
			}

		} catch (Exception e) {
			LOGGER.error("Error in Update Shift ReAllocation", e);
			throw new CustomException(ErrorMessage.ERROR_UPDATE);
		}

		return isSuccess;
	}

	@Override
	public boolean deleteShiftReAllocation(String shiftCode, String employeeId) throws Exception {

		boolean issucces = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(ShiftReAllocationQueryUtil.sDeleteShiftReAllocation, employeeId, Integer.valueOf(shiftCode));

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
	public ShiftReAllocationBean getShiftReAllocationEditList(String employeeId, String fromDate, String toDate) throws Exception {

		ShiftReAllocationBean objReShiftAllocationBean = new ShiftReAllocationBean();
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ShiftReAllocationQueryUtil.sGetReShiftAllocationEditList, new Object[] { employeeId, fromDate, toDate });

			for (Map row : rows) {
				objReShiftAllocationBean.setDesignationId(String.valueOf((int) row.get("designationId")));
				objReShiftAllocationBean.setDesignationName((String) row.get("designationName"));
				objReShiftAllocationBean.setCompanyId((String) row.get("companyId"));
				objReShiftAllocationBean.setCompanyName((String) row.get("companyName"));
				objReShiftAllocationBean.setDepartmentId(String.valueOf((int) row.get("departmentId")));
				objReShiftAllocationBean.setDepartmentName((String) row.get("departmentName"));
				objReShiftAllocationBean.setBranchId((String) row.get("branchId"));
				objReShiftAllocationBean.setBranchName((String) row.get("branchName"));
				objReShiftAllocationBean.setEmployeeId((String) row.get("employeeId"));
				objReShiftAllocationBean.setEmployeeName((String) row.get("employeeName"));
				objReShiftAllocationBean.setShiftCode(String.valueOf((int) row.get("shiftCode")));
				objReShiftAllocationBean.setShiftName((String) row.get("shiftName"));
				objReShiftAllocationBean.setFromDate((String) row.get("fromDate"));
				objReShiftAllocationBean.setToDate((String) row.get("toDate"));
			}
		} catch (Exception e) {
			LOGGER.error("Error in Get Shift Re Allocation Edit List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return objReShiftAllocationBean;
	}

	@Override
	public ShiftReAllocationResultBean getShiftList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ShiftReAllocationResultBean shiftReAllocationResultBean = new ShiftReAllocationResultBean();
		List<ShiftReAllocationBean> shiftList = new ArrayList<ShiftReAllocationBean>();
		try {
			shiftList = jdbcTemplate.query(ShiftReAllocationQueryUtil.SELECT_SHIFT_LIST, new BeanPropertyRowMapper<ShiftReAllocationBean>(ShiftReAllocationBean.class), userDetail.getCompanyCode());

			shiftReAllocationResultBean.setShiftList(shiftList);
			shiftReAllocationResultBean.setSuccess(true);
			return shiftReAllocationResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getShiftList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	
	


	@Override
	public ShiftReAllocationResultBean getShiftNameList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ShiftReAllocationResultBean shiftReAllocationResultBean = new ShiftReAllocationResultBean();
		List<ShiftReAllocationBean> shiftList = new ArrayList<ShiftReAllocationBean>();
		ShiftReAllocationBean shiftReAllocationBean = new ShiftReAllocationBean();
		ShiftReAllocationBean shiftSchemeMasterBean1 = new ShiftReAllocationBean();
		try {
			shiftList = jdbcTemplate.query(ShiftReAllocationQueryUtil.SELECT_SHIFT_NAME_LIST, new BeanPropertyRowMapper<ShiftReAllocationBean>(ShiftReAllocationBean.class), userDetail.getCompanyCode());
			shiftReAllocationBean.setShiftCode("0");
			shiftReAllocationBean.setShiftName("Weekly Off");
			shiftList.add(shiftReAllocationBean);
			shiftSchemeMasterBean1.setShiftCode("-1");
			shiftSchemeMasterBean1.setShiftName("Week End");
			shiftList.add(shiftSchemeMasterBean1);
			shiftReAllocationResultBean.setShiftNameList(shiftList);
			shiftReAllocationResultBean.setSuccess(true);
			return shiftReAllocationResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getShiftNameList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	
	
	@Override
	public List<ShiftReAllocationBean> getDropdown() {

		List<ShiftReAllocationBean> list = new ArrayList<ShiftReAllocationBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(ShiftReAllocationQueryUtil.SELECT_Branch_LIST, new BeanPropertyRowMapper<ShiftReAllocationBean>(ShiftReAllocationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getDropDown", e);
		}

		return list;
	}

	
	
	@Override
	public List<ShiftReAllocationBean> companyList() {

		List<ShiftReAllocationBean> list = new ArrayList<ShiftReAllocationBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(ShiftReAllocationQueryUtil.companyList, new BeanPropertyRowMapper<ShiftReAllocationBean>(ShiftReAllocationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getDropDown", e);
		}

		return list;
	}
	
	
	@Override
	public List<ShiftReAllocationBean> shiftNameList() {

		List<ShiftReAllocationBean> list = new ArrayList<ShiftReAllocationBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(ShiftReAllocationQueryUtil.SELECT_shiftNameList_LIST, new BeanPropertyRowMapper<ShiftReAllocationBean>(ShiftReAllocationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getDropDown", e);
		}

		return list;
	}

}