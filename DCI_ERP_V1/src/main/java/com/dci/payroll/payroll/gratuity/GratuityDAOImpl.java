package com.dci.payroll.payroll.gratuity;

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
public class GratuityDAOImpl implements GratuityDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(GratuityDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<GratuityBean> getGratuityList() throws CustomException {
		List<GratuityBean> gratuityList = new ArrayList<GratuityBean>();
		try {
			gratuityList = jdbcTemplate.query(GratuityQueryUtill.SELECT_GTATUITY_LIST, new BeanPropertyRowMapper<GratuityBean>(GratuityBean.class));
			return gratuityList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Gratuity", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public GratuityBean getGratuityById(String employeeId) throws CustomException {
		GratuityBean gratuity = null;
		try {
			gratuity = jdbcTemplate.queryForObject(GratuityQueryUtill.SELECT_GTATUITY_BY_ID, new BeanPropertyRowMapper<GratuityBean>(GratuityBean.class), employeeId);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getGratuityEdit", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}
		return gratuity;
	}

	@Override
	public boolean insertGratuity(GratuityBean gratuity) throws CustomException {
		boolean isSuccess = false;
		try {
			Map<String, Object> gratuityMap = new HashMap<String, Object>();
			gratuityMap.put("employeeId", gratuity.getEmployeeId());
			gratuityMap.put("grossSalary", gratuity.getGrossSalary());
			gratuityMap.put("basicPay", gratuity.getBasicPay());
			gratuityMap.put("currentSalary", gratuity.getCurrentSalary());
			gratuityMap.put("yearOfService", gratuity.getYearOfService());
			gratuityMap.put("gratuityAmount", gratuity.getGratuityAmount());
			gratuityMap.put("periodFrom", gratuity.getPeriodFrom());
			gratuityMap.put("periodTo", gratuity.getPeriodTo());
			gratuityMap.put("comments", gratuity.getComments());
			gratuityMap.put("createdBy", gratuity.getCreatedBy());
			gratuityMap.put("createdDate", gratuity.getCreatedDate());

			namedParameterJdbcTemplate.update(GratuityQueryUtill.INSERT_GTATUITY, gratuityMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getGratuityAdd", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean updateGratuity(GratuityBean gratuity) throws CustomException {
		boolean isSuccess = false;
		try {
			Map<String, Object> gratuityMap = new HashMap<String, Object>();
			gratuityMap.put("employeeId", gratuity.getEmployeeId());
			gratuityMap.put("grossSalary", gratuity.getGrossSalary());
			gratuityMap.put("basicPay", gratuity.getBasicPay());
			gratuityMap.put("currentSalary", gratuity.getCurrentSalary());
			gratuityMap.put("yearOfService", gratuity.getYearOfService());
			gratuityMap.put("gratuityAmount", gratuity.getGratuityAmount());
			gratuityMap.put("periodFrom", gratuity.getPeriodFrom());
			gratuityMap.put("periodTo", gratuity.getPeriodTo());
			gratuityMap.put("comments", gratuity.getComments());
			gratuityMap.put("createdBy", gratuity.getCreatedBy());
			gratuityMap.put("createdDate", gratuity.getCreatedDate());

			namedParameterJdbcTemplate.update(GratuityQueryUtill.UPDATE_GTATUITY, gratuityMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in updateGratuity", e);
			throw new CustomException(ErrorMessage.ERROR_UPDATE);
		}

		return isSuccess;
	}
}
