package com.dci.payroll.tds.employeeTaxParameter;

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
public class EmployeeTaxParameterDAOImpl implements EmployeeTaxParameterDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeTaxParameterDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EmployeeTaxParameterBean> getEmployeeTaxParameterList(String companyId, String branchId, Integer departmentId, String employeeId) throws Exception {
		List<EmployeeTaxParameterBean> employeeTaxParameterList = new ArrayList<EmployeeTaxParameterBean>();
		try {
			employeeTaxParameterList = jdbcTemplate.query(EmployeeTaxParameterQueryUtil.SelectAll, new BeanPropertyRowMapper<EmployeeTaxParameterBean>(EmployeeTaxParameterBean.class), companyId, branchId, departmentId, employeeId);
			return employeeTaxParameterList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in employeeTaxParameterList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeTaxParameterBean getEmpTaxParambyEmpId(String employeeId) throws Exception {
		EmployeeTaxParameterBean empTaxParamBean = new EmployeeTaxParameterBean();
		try {
			empTaxParamBean = jdbcTemplate.queryForObject(EmployeeTaxParameterQueryUtil.EMPTAXPARAM_BY_EMPID, new Object[] { employeeId }, new BeanPropertyRowMapper<EmployeeTaxParameterBean>(EmployeeTaxParameterBean.class));

		} catch (DataAccessException e) {
			empTaxParamBean = null;
			return empTaxParamBean;
		}
		return empTaxParamBean;
	}

	@Override
	public boolean insertEmpTaxParam(EmployeeTaxParameterBean empTaxParamBean) throws Exception {
		boolean isSuccess = false;
		List<EmployeeTaxParameterBean> employeeTaxParameterList = new ArrayList<EmployeeTaxParameterBean>();
		try {
			employeeTaxParameterList = jdbcTemplate.query(EmployeeTaxParameterQueryUtil.EMPTAXPARAM_BY_EMPID, new BeanPropertyRowMapper<EmployeeTaxParameterBean>(EmployeeTaxParameterBean.class), empTaxParamBean.getEmployeeId());
			Map<String, Object> empTaxParamMap = new HashMap<String, Object>();
			empTaxParamMap.put("employee_id", empTaxParamBean.getEmployeeId());
			empTaxParamMap.put("is_living_in_metro", empTaxParamBean.isLivingInMetro());
			empTaxParamMap.put("is_self_occupied_house", empTaxParamBean.isSelfOccupiedHouse());
			empTaxParamMap.put("tax_payer_type_id", empTaxParamBean.getTaxPayerTypeId());
			empTaxParamMap.put("ph_type", empTaxParamBean.getPhType());
			if (employeeTaxParameterList.size() == 0) {
				namedParameterJdbcTemplate.update(EmployeeTaxParameterQueryUtil.INSERT_EMPTAX_PARAM, empTaxParamMap);
			} else {
				namedParameterJdbcTemplate.update(EmployeeTaxParameterQueryUtil.UPDATE_EMPTAX_PARAM, empTaxParamMap);
			}

			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertEmpTaxParam", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		return isSuccess;
	}

	@Override
	public boolean updateEmpTaxParam(EmployeeTaxParameterBean empTaxParamBean) throws Exception {
		boolean isSuccess = false;
		try {

			Map<String, Object> empTaxParamMap = new HashMap<String, Object>();
			empTaxParamMap.put("employee_id", empTaxParamBean.getEmployeeId());
			empTaxParamMap.put("is_living_in_metro", empTaxParamBean.isLivingInMetro());
			empTaxParamMap.put("is_self_occupied_house", empTaxParamBean.isSelfOccupiedHouse());
			empTaxParamMap.put("tax_payer_type_id", empTaxParamBean.getTaxPayerTypeId());
			empTaxParamMap.put("ph_type", empTaxParamBean.getPhType());
			namedParameterJdbcTemplate.update(EmployeeTaxParameterQueryUtil.UPDATE_EMPTAX_PARAM, empTaxParamMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in updateEmpTaxParam", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return isSuccess;
	}

	@Override
	public boolean deleteEmpTaxParam(String employeeId) throws Exception {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(EmployeeTaxParameterQueryUtil.DELETE_EMPTAX_PARAM, employeeId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteEmpTaxParam", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		return isSuccess;
	}
}