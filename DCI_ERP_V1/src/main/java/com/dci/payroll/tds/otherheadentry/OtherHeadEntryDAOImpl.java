package com.dci.payroll.tds.otherheadentry;

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
import com.dci.payroll.tds.taxsection.TaxsectionQueryUtil;


@Repository
public class OtherHeadEntryDAOImpl implements OtherHeadEntryDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(OtherHeadEntryDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<OtherHeadEntryBean> getOtherHeadEntryList(String employeeId, String financialYearId) throws CustomException {
		List<OtherHeadEntryBean> otherHeadEntryList = new ArrayList<OtherHeadEntryBean>();
		try {

			otherHeadEntryList = jdbcTemplate.query(OtherHeadEntryQueryUtil.SELET_OTHER_ENTRY, new BeanPropertyRowMapper<OtherHeadEntryBean>(OtherHeadEntryBean.class), employeeId, financialYearId, financialYearId, employeeId);
			return otherHeadEntryList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in OtherHeadEntryDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertOtherHead(ArrayList<OtherHeadEntryBean> otherHeadEntryBean) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		String autoGenTrnSchId = "";
		try {

			List<OtherHeadEntryBean> empHeBeansList = new ArrayList<OtherHeadEntryBean>();

			Map<String, Object> tdsDeclarationMap = null;

			for (OtherHeadEntryBean oHeadEntryBean : otherHeadEntryBean) {

				tdsDeclarationMap = new HashMap<String, Object>();

				tdsDeclarationMap.put("employee_id", oHeadEntryBean.getEmployeeId());
				tdsDeclarationMap.put("financial_year_id", oHeadEntryBean.getFinancialYearId());
				tdsDeclarationMap.put("other_income_head_id", oHeadEntryBean.getOtherIncomeHeadId());
				tdsDeclarationMap.put("amount", oHeadEntryBean.getAmount());

				empHeBeansList = jdbcTemplate.query(OtherHeadEntryQueryUtil.CHECK_OTHER_HEAD_ENTRY, new BeanPropertyRowMapper<OtherHeadEntryBean>(OtherHeadEntryBean.class), oHeadEntryBean.getEmployeeId(), oHeadEntryBean.getFinancialYearId(), oHeadEntryBean.getOtherIncomeHeadId());
				if (empHeBeansList.size() == 0) {
					namedParameterJdbcTemplate.update(OtherHeadEntryQueryUtil.INSERT_OTHERHEAD, tdsDeclarationMap);
				} else {
					namedParameterJdbcTemplate.update(OtherHeadEntryQueryUtil.UPDATE_OTHERHEAD, tdsDeclarationMap);
				}

			}

			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in insertotherHeadEntry", e.getMessage());
			throw new CustomException("Other Head Name already exists.");
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public OtherHeadEntryBean getOtherHeadById(Integer otherHeadId) throws CustomException {
		OtherHeadEntryBean otherHeadEntry = new OtherHeadEntryBean();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { otherHeadId };
			Map row = jdbcTemplate.queryForMap(OtherHeadEntryQueryUtil.SELECT_OTHERHEADENTRY_BYID, otherHeadId);
			if (row.get("other_income_head_name") != null) {
				otherHeadEntry.setOtherIncomeHeadName((String) row.get("other_income_head_name"));
			}

			otherHeadEntry.setisEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLoanEntryId", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		// TODO Auto-generated method stub
		return otherHeadEntry;
	}

	@Override
	public boolean updateHeadEntry(OtherHeadEntryBean otherHeadEntryBean) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		String autoGenTrnSchId = "";
		try {
			Map<String, Object> otherHeadMap = new HashMap<String, Object>();

			otherHeadMap.put("other_income_head_id", otherHeadEntryBean.getOtherIncomeHeadId());
			otherHeadMap.put("other_income_head_name", otherHeadEntryBean.getOtherIncomeHeadName());

			namedParameterJdbcTemplate.update(TaxsectionQueryUtil.UPDATE_TAXSECTION, otherHeadMap);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean deleteOtherHeadEntry(Integer otherHeadId) throws CustomException {
		boolean isSuccess = false;
		int val = 1;
		try {
			val = jdbcTemplate.update(OtherHeadEntryQueryUtil.DELETE_OTHERHEAD, otherHeadId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteBranch", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

}