package com.dci.payroll.payroll.employeebonus;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;


@Repository
public class EmployeeBonusDAOImpl implements EmployeeBonusDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeBonusDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EmployeeBonusBean> getEmployeeBonusList(String companyId, String branchId, String dept, String financialYear) throws CustomException {
		List<EmployeeBonusBean> employeeBonusList = new ArrayList<EmployeeBonusBean>();
		try {
			employeeBonusList = jdbcTemplate.query(EmployeeBonusQueryUtil.SELECT_EMPLOYEE_BONUS_LIST, new BeanPropertyRowMapper<EmployeeBonusBean>(EmployeeBonusBean.class), financialYear, companyId, branchId, dept, financialYear);
		} catch (DataAccessException e) {
			LOGGER.error("Error inEmployeeBonusDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return employeeBonusList;
	}

	@Override
	public boolean insertEmployeeBonusBean(ArrayList<EmployeeBonusBean> employeeBonusBean) throws CustomException {
		boolean isSuccess = false;
		List<EmployeeBonusBean> empBonusList = new ArrayList<EmployeeBonusBean>();
		try {
			Map<String, Object> empBonusMap = null;
			for (EmployeeBonusBean empBonus : employeeBonusBean) {
				empBonusMap = new HashMap<String, Object>();
				empBonusMap.put("employeeId", empBonus.getEmployeeId());
				empBonusMap.put("financialYear", empBonus.getFinancialYear());
				empBonusMap.put("declaredAmount", empBonus.getDeclaredAmount());
				empBonusList = jdbcTemplate.query(EmployeeBonusQueryUtil.SELECT_EMP_BONUS_BY_ID, new BeanPropertyRowMapper<EmployeeBonusBean>(EmployeeBonusBean.class), empBonus.getEmployeeId(), empBonus.getFinancialYear());
				if (empBonusList.size() == 0) {
					if (empBonus.getDeclaredAmount() > 0) {
						namedParameterJdbcTemplate.update(EmployeeBonusQueryUtil.INSERT_EMPBONUS, empBonusMap);
					}
				} else {
					namedParameterJdbcTemplate.update(EmployeeBonusQueryUtil.UPDATE_EMPBONUS, empBonusMap);
				}
			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertEmployeeBonusBean", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public EmployeeBonusBean getPaidDetailById(Integer bonusId) throws CustomException {
		EmployeeBonusBean employeeBonusEntry = new EmployeeBonusBean();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { bonusId };

			List<EmployeeBonusBean> empBonusList = new ArrayList<EmployeeBonusBean>();

			Map row = jdbcTemplate.queryForMap(EmployeeBonusQueryUtil.SELECT_EMP_BONUS_BY_BONUS_ID, bonusId);

			if (row.size() > 0) {

				if (row.get("bonus_id") != null) {

					employeeBonusEntry.setBonusId((Integer) row.get("bonus_id"));

				}
				if (row.get("employee_id") != null) {
					employeeBonusEntry.setEmployeeId((String) row.get("employee_id"));
				}
				if (row.get("declared_amount") != null) {
					employeeBonusEntry.setDeclaredAmount((double) row.get("declared_amount"));
				}
				if (row.get("employee_name") != null) {
					employeeBonusEntry.setEmployeeName((String) row.get("employee_name"));
				}
				if (row.get("paid_amount") != null) {
					employeeBonusEntry.setPaidAmount((double) row.get("paid_amount"));
				}

				employeeBonusEntry.setisEdit(true);
			} else {
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLoanEntryId", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		return employeeBonusEntry;
	}

	@Override
	public EmployeeBonusBean getPaidDetailByDate(Integer bonusId, String paidOn) throws CustomException {
		EmployeeBonusBean employeeBonusEntry = new EmployeeBonusBean();
		List<EmployeeBonusBean> empBonusList = new ArrayList<EmployeeBonusBean>();
		try {

			empBonusList = jdbcTemplate.query(EmployeeBonusQueryUtil.CHECK_EMPLOYEE_BONUS_PAID, new BeanPropertyRowMapper<EmployeeBonusBean>(EmployeeBonusBean.class), bonusId);

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { bonusId };

			if (empBonusList.size() > 0) {
				for (EmployeeBonusBean emp : empBonusList) {
					employeeBonusEntry.setBonusId(bonusId);
					employeeBonusEntry.setPaidOn(emp.getPaidOn());
				}

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLoanEntryId", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		return employeeBonusEntry;
	}

	@Override
	public boolean updteEmployeeBonusPaid(EmployeeBonusBean employeeBonusBean) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {
			Map<String, Object> employeeBonusPaid = new HashMap<String, Object>();

			employeeBonusPaid.put("paid_amount", employeeBonusBean.getPaidAmount());
			employeeBonusPaid.put("paid_on", employeeBonusBean.getPaidOn());
			employeeBonusPaid.put("bonus_id", employeeBonusBean.getBonusId());

			namedParameterJdbcTemplate.update(EmployeeBonusQueryUtil.INSERT_BONUS_SUMMARY, employeeBonusPaid);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public EmployeeBonusBean getEmployeeBonusBean(String payComponentId) throws CustomException {
		return null;
	}

	@Override
	public boolean updateEmployeeBonusBean(EmployeeBonusBean employeeBonusBean) throws CustomException {
		return false;
	}

	@Override
	public List<EmployeeBonusBean> getEmployeeBonusSummary(Integer bonusId) throws CustomException {
		List<EmployeeBonusBean> employeeBonusSummaryList = new ArrayList<EmployeeBonusBean>();
		try {
			employeeBonusSummaryList = jdbcTemplate.query(EmployeeBonusQueryUtil.SELECT_EMP_BONUS_SUMMARY, new BeanPropertyRowMapper<EmployeeBonusBean>(EmployeeBonusBean.class), bonusId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in EmployeeBonusDAOImpl - getEmployeeBonusSummary", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return employeeBonusSummaryList;
	}

}