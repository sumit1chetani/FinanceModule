package com.dci.tenant.finance.disciplinaryaction;

import java.util.ArrayList;
import java.util.List;
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

import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;



@Repository
@Transactional("tenantTransactionManager")

public class DisciplinaryActionDAOImpl implements DisciplinaryActionDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(DisciplinaryActionDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<DisciplinaryActionBean> getDisciplinaryList() throws Exception {
		UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<DisciplinaryActionBean> disciplinaryList = new ArrayList<DisciplinaryActionBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		disciplinaryList = jdbcTemplate.query(DisciplinaryActionQueryUtil.getDisciplinaryList, new BeanPropertyRowMapper<DisciplinaryActionBean>(DisciplinaryActionBean.class));
		return disciplinaryList;
	}

	@Override
	public boolean insertDisciplinaryData(DisciplinaryActionBean objsBean) {
		boolean isSuccess = false;
		int value = 0;

		try {
			DisciplinaryActionBean objDisciplinaryBean = objsBean.getDisciplinaryData();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			java.sql.Timestamp procedingdate = CommonUtil.getCurrentTimeStamp();
		//	java.sql.Date suspendFrom = CommonUtil.convertSqlDateFormate(objDisciplinaryBean.getSuspendFrom());
		//	java.sql.Date suspendTo = CommonUtil.convertSqlDateFormat(objDisciplinaryBean.getSuspendTo());
			boolean status = true;
			Object[] params = new Object[] { procedingdate, objDisciplinaryBean.getProceedings(), objDisciplinaryBean.getEmployeeId(), objDisciplinaryBean.getSuspendFrom(), objDisciplinaryBean.getSuspendTo(), objDisciplinaryBean.getSuspendedDays(), objDisciplinaryBean.getIssueWarning(), objDisciplinaryBean.getReason(), status, objDisciplinaryBean.getHospitalId(), objDisciplinaryBean.getBranchId(), objDisciplinaryBean.getDepartmentId(), objDisciplinaryBean.getDesignationId(), objDisciplinaryBean.getGradeId() };
			value = jdbcTemplate.queryForObject(DisciplinaryActionQueryUtil.INSERT_DISCIPLINARYDATE, params, Integer.class);
			if (value > 0) {
				isSuccess = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public boolean deleteDisciplinaryData(int disciplinaryId) throws Exception {

		boolean issucces = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(DisciplinaryActionQueryUtil.sDeleteDisciplinaryData, disciplinaryId);

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
	public DisciplinaryActionBean getDisciplinaryDataEdit(int disciplinary_proceedings_sk) throws CustomException {

		DisciplinaryActionBean objDisciplinaryDataBean = new DisciplinaryActionBean();
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(DisciplinaryActionQueryUtil.sGetDisciplinaryDataEditList, new Object[] { disciplinary_proceedings_sk });

			for (Map row : rows) {
				objDisciplinaryDataBean.setDisciplinary_proceedings_sk((int) row.get("disciplinary_proceedings_sk"));
				objDisciplinaryDataBean.setHospitalId((String) row.get("companyId"));
				objDisciplinaryDataBean.setBranchId((String) row.get("branchId"));
				objDisciplinaryDataBean.setDepartmentId((String) row.get("departmentId"));
				objDisciplinaryDataBean.setDesignationId((String) row.get("designationId"));
				objDisciplinaryDataBean.setGradeId((String) row.get("gradeId"));
				objDisciplinaryDataBean.setEmployeeId((String) row.get("employeeId"));
				objDisciplinaryDataBean.setProceedings((String) row.get("proceedings"));
				objDisciplinaryDataBean.setSuspendFrom((String.valueOf(row.get("suspendFrom"))));
				objDisciplinaryDataBean.setSuspendTo((String.valueOf(row.get("suspendTo"))));
				objDisciplinaryDataBean.setSuspendedDays((int) row.get("suspendDays"));
				objDisciplinaryDataBean.setIssueWarning((String) row.get("issueWarning"));
				objDisciplinaryDataBean.setReason((String) row.get("reason"));
			}
		} catch (Exception e) {
			LOGGER.error("Error in Get Shift Allocation Edit List", e);
e.printStackTrace();
}

		return objDisciplinaryDataBean;
	}

	@Override
	public boolean updateDisciplinaryData(DisciplinaryActionBean objsBean) throws Exception {

		boolean isSuccess = false;
		int value = 0;
		try {
			objsBean.getDisciplinaryData();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//	java.sql.Date suspendFrom = CommonUtil.convertSqlDateFormat(objDisciplinaryBean.getSuspendFrom());
		//	java.sql.Date suspendTo = CommonUtil.convertSqlDateFormat(objDisciplinaryBean.getSuspendTo());
			boolean status = true;
			Object[] params = new Object[] { objsBean.getEmployeeId(), objsBean.getSuspendFrom(), objsBean.getSuspendTo(), objsBean.getSuspendedDays(), objsBean.getIssueWarning(), objsBean.getReason(), status, objsBean.getHospitalId(), objsBean.getBranchId(), objsBean.getDepartmentId(), objsBean.getDesignationId(), objsBean.getGradeId(), objsBean.getDisciplinary_proceedings_sk() };
			value = jdbcTemplate.update(DisciplinaryActionQueryUtil.sUpdateDisciplinaryData, params);
			if (value > 0) {
				isSuccess = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	@Override
	public DisciplinaryActionBean getEmployeeList(DisciplinaryActionBean objsBean) throws CustomException {

		String dept = objsBean.getDepartmentId();
		String branch = objsBean.getBranchId();
		DisciplinaryActionBean resultBean = new DisciplinaryActionBean();
		List<DisciplinaryActionBean> employeeList = new ArrayList<DisciplinaryActionBean>();
		try {
			employeeList = jdbcTemplate.query(DisciplinaryActionQueryUtil.getEmployeeList, new BeanPropertyRowMapper<DisciplinaryActionBean>(DisciplinaryActionBean.class), dept, branch);
			resultBean.setEmployeeList(employeeList);
			return resultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

}
