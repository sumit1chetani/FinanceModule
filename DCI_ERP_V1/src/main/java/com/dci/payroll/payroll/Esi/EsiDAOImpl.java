package com.dci.payroll.payroll.Esi;

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
public class EsiDAOImpl implements EsiDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(EsiDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EsiBean> getESIList(EsiBean esiBean) throws CustomException {
		List<EsiBean> employeeProvidentFundList = new ArrayList<EsiBean>();
		try {
			employeeProvidentFundList = jdbcTemplate.query(EsiQueryUtil.SELECT_ESI_LIST, new BeanPropertyRowMapper<EsiBean>(EsiBean.class), esiBean.getMonthYear(), esiBean.getCompanyId(), esiBean.getBranchId(), esiBean.getDept(), esiBean.getMonthYear(), esiBean.getMonthYear());
			return employeeProvidentFundList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in ProfessionalTaxSlabDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertEsiList(ArrayList<EsiBean> esiBeanList) throws CustomException {
		boolean isSuccess = false;
		try {
			List<EsiBean> esiBeansList = new ArrayList<EsiBean>();

			Map<String, Object> esiMap = null;

			for (EsiBean esiBean : esiBeanList) {

				esiMap = new HashMap<String, Object>();
				esiMap.put("employee_id", esiBean.getEmployeeId());
				esiMap.put("month_year", esiBean.getMonthYear());
				esiMap.put("days_worked", esiBean.getDays());
				esiMap.put("esi_salary", esiBean.getWages());

				esiBeansList = jdbcTemplate.query(EsiQueryUtil.CHECK_ESILIST, new BeanPropertyRowMapper<EsiBean>(EsiBean.class), esiBean.getEmployeeId(), esiBean.getMonthYear());

				if (esiBeansList.size() == 0) {
					namedParameterJdbcTemplate.update(EsiQueryUtil.INSERT_ESI_PAID, esiMap);

				} else {
					namedParameterJdbcTemplate.update(EsiQueryUtil.DELET_ESI_PAID, esiMap);
					namedParameterJdbcTemplate.update(EsiQueryUtil.INSERT_ESI_PAID, esiMap);
				}
			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTdsDeclarationAdd", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

}
