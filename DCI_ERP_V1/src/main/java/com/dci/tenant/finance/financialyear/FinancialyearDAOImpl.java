package com.dci.tenant.finance.financialyear;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;

@SuppressWarnings("deprecation")
@Repository
public class FinancialyearDAOImpl implements FinancialyearDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(FinancialyearDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<FinancialyearBean> getFinancialYearList(int limit, int offset) throws CustomException {
		List<FinancialyearBean> lfinancialyearBean = new ArrayList<FinancialyearBean>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			lfinancialyearBean = jdbcTemplate.query(FinancialyearQueryUtil.sViewFinancialYear, new BeanPropertyRowMapper<FinancialyearBean>(FinancialyearBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
		}
		return lfinancialyearBean;
	}

	private String generateFyCode() {
		// TODO Auto-generated method stub
		String prCode = "";
		try {
			prCode = jdbcTemplate.queryForObject(FinancialyearQueryUtil.FY_CODE, String.class);
		} catch (DataAccessException e) {
			LOGGER.error("Error in FY_CODE Generation", e);
		}
		return prCode;
	}

	@Override
	public FinancialyearResultBean saveFinancialYear(FinancialyearBean financialyearBean) {
		FinancialyearResultBean objBean = new FinancialyearResultBean();
		try {
			if (validateFY(financialyearBean)) {
				String finId = generateFyCode();
				if (financialyearBean.isActive() == true) {
					int saved1 = jdbcTemplate.update(FinancialyearQueryUtil.UPDATE_CURRENT, new Object[] { false, financialyearBean.getCompanyCode() });
				}
				int saved = jdbcTemplate.update(FinancialyearQueryUtil.SAVE_FY, new Object[] { financialyearBean.getFyId(), financialyearBean.getFyFrom(), financialyearBean.getFyTo(), finId, financialyearBean.getCompanyCode(), financialyearBean.isActive() });

				if (saved > 0)
					objBean.setSuccess(true);
			} else {
				objBean.setErrors("Financial Already Exist for the Company");
				objBean.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Presentation", e);
		}
		return objBean;
	}

	@Override
	public FinancialyearBean getFinancialYearData(String finId) {
		FinancialyearBean financialyearBean = new FinancialyearBean();
		try {
			financialyearBean = jdbcTemplate.queryForObject(FinancialyearQueryUtil.FY_EDIT, new Object[] { finId }, new BeanPropertyRowMapper<FinancialyearBean>(FinancialyearBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getFinancialYearData", e);
		}
		return financialyearBean;
	}

	@Override
	public boolean updateFinancialYear(FinancialyearBean financialyearBean) {
		boolean success = false;
		try {
			if (financialyearBean.isActive() == true) {
				int saved1 = jdbcTemplate.update(FinancialyearQueryUtil.UPDATE_CURRENT, new Object[] { false, financialyearBean.getCompanyCode() });
			}
			int saved = jdbcTemplate.update(FinancialyearQueryUtil.UPDATE_FY, new Object[] { financialyearBean.isActive(), financialyearBean.getFyFrom(), financialyearBean.getFyTo(), financialyearBean.getFyId(), financialyearBean.getCompanyCode(), financialyearBean.getFyShortId() });

			if (saved > 0)
				success = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Presentation", e);
		}
		return success;
	}

	@Override
	public boolean deleteFinancialYear(String finId) {
		boolean success = false;
		try {
			int deleted = jdbcTemplate.update(FinancialyearQueryUtil.DELETE_FY, new Object[] { finId });

			if (deleted > 0)
				success = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Presentation", e);
		}
		return success;
	}

	@Override
	public boolean validateFY(FinancialyearBean financialyearBean) {
		// TODO Auto-generated method stub
		boolean success = false;
		try {
			int fyCode = jdbcTemplate.queryForObject(FinancialyearQueryUtil.VALIDATE_FY, new Object[] { financialyearBean.getFyId(), financialyearBean.getCompanyCode() }, Integer.class);

			if (fyCode > 0)
				success = false;
			else
				success = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in FY_CODE Generation", e);
		}
		return success;
	}
}
