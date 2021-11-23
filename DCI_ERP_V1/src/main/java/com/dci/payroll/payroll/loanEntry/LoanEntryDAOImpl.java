package com.dci.payroll.payroll.loanEntry;

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
public class LoanEntryDAOImpl implements LoanEntryDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoanEntryDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<LoanEntry> getLoanEntryList(int status) throws CustomException {
		List<LoanEntry> LoanEntryList = new ArrayList<LoanEntry>();
		try {
			LoanEntryList = jdbcTemplate.query(LoanEntryQueryUtil.SELECT_LOANENTRY, new BeanPropertyRowMapper<LoanEntry>(LoanEntry.class), status);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getBranchList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return LoanEntryList;
	}

	@Override
	public boolean insertLoanEntry(LoanEntry loanEntry) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		String autoGenTrnSchId = "";
		List<LoanEntry> LoanEntryList = new ArrayList<LoanEntry>();
		try {
			Map<String, Object> loanEntryMap = new HashMap<String, Object>();

			autoGenTrnSchId = jdbcTemplate.queryForObject(LoanEntryQueryUtil.loanIdAutoGen, String.class);
			loanEntry.setLoanId(Integer.parseInt(autoGenTrnSchId));
			loanEntryMap.put("loanId", loanEntry.getLoanId());
			loanEntryMap.put("employeeId", loanEntry.getEmployeeId());
			loanEntryMap.put("loanTypeId", loanEntry.getLoanTypeId());
			loanEntryMap.put("amount", loanEntry.getAmount());
			loanEntryMap.put("numberOfInstalments", loanEntry.getNumberOfInstalments());
			loanEntryMap.put("deductFrom", loanEntry.getDeductFrom());
			loanEntryMap.put("deductionAmount", loanEntry.getDeductionAmount());
			loanEntryMap.put("status", loanEntry.getStatus());
			LoanEntryList = jdbcTemplate.query(LoanEntryQueryUtil.CHECK_LOAN_EXISTS, new BeanPropertyRowMapper<LoanEntry>(LoanEntry.class), loanEntry.getLoanTypeId(), loanEntry.getEmployeeId());
			if (LoanEntryList.size() == 0) {
				namedParameterJdbcTemplate.update(LoanEntryQueryUtil.INSERT_LOANENTRY, loanEntryMap);
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in insert LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public List<LoanEntry> getLoanEntryById(int loanId) throws CustomException {
		List<LoanEntry> LoanEntryList = new ArrayList<LoanEntry>();
		try {
			LoanEntryList = jdbcTemplate.query(LoanEntryQueryUtil.SELECT_LOANENTRYBYID, new BeanPropertyRowMapper<LoanEntry>(LoanEntry.class), loanId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getLoanEntryById", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return LoanEntryList;

	}

	@Override
	public boolean updateLoanEntry(LoanEntry loanEntry) throws CustomException {

		List<LoanEntry> LoanEntryList = new ArrayList<LoanEntry>();
		boolean isSuccess = false;
		try {
			Map<String, Object> loanEntryMap = new HashMap<String, Object>();

			loanEntryMap.put("loanId", loanEntry.getLoanId());
			loanEntryMap.put("employeeId", loanEntry.getEmployeeId());
			loanEntryMap.put("loanTypeId", loanEntry.getLoanTypeId());
			loanEntryMap.put("amount", loanEntry.getAmount());
			loanEntryMap.put("numberOfInstalments", loanEntry.getNumberOfInstalments());
			loanEntryMap.put("deductFrom", loanEntry.getDeductFrom());
			loanEntryMap.put("deductionAmount", loanEntry.getDeductionAmount());
			loanEntryMap.put("status", loanEntry.getStatus());
			LoanEntryList = jdbcTemplate.query(LoanEntryQueryUtil.SELECT_LOANENTRYBYID, new BeanPropertyRowMapper<LoanEntry>(LoanEntry.class), loanEntry.getLoanId());
			if (LoanEntryList.size() != 0) {
				namedParameterJdbcTemplate.update(LoanEntryQueryUtil.UPDATE_LOANENTRY, loanEntryMap);
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in insert LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean approvalupdate(LoanEntry loanEntry) throws CustomException {
		List<LoanEntry> LoanEntryList = new ArrayList<LoanEntry>();
		boolean isSuccess = false;
		try {
			Map<String, Object> loanEntryMap = new HashMap<String, Object>();

			loanEntryMap.put("loan_id", loanEntry.getLoanId());
			loanEntryMap.put("approved_on", loanEntry.getApprovedOn());
			loanEntryMap.put("approved_by", loanEntry.getApprovedBy());
			loanEntryMap.put("status", loanEntry.getStatus());

			LoanEntryList = jdbcTemplate.query(LoanEntryQueryUtil.SELECT_LOANENTRYBYID, new BeanPropertyRowMapper<LoanEntry>(LoanEntry.class), loanEntry.getLoanId());
			if (LoanEntryList.size() != 0) {
				namedParameterJdbcTemplate.update(LoanEntryQueryUtil.UPDATE_APPROVAL_LOANENTRY, loanEntryMap);
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in insert LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean deleteLoanEntry(int loanId) throws CustomException {
		boolean isSuccess = false;
		int val = 1;
		try {
			val = jdbcTemplate.update(LoanEntryQueryUtil.DELETE_LOANENTRY, loanId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteBranch", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public List<LoanEntry> getLoanTypeList() throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanEntry> getEmployeeLoanEntry(LoanEntry loanEntryBean) throws CustomException {
		List<LoanEntry> LoanEntryList = new ArrayList<LoanEntry>();
		try {
			LoanEntryList = jdbcTemplate.query(LoanEntryQueryUtil.SELECT_LOANENTRY_BYSTATUS_EMPID, new BeanPropertyRowMapper<LoanEntry>(LoanEntry.class), loanEntryBean.getStatus(), loanEntryBean.getEmployeeId());

		} catch (DataAccessException e) {
			LOGGER.error("Error in getBranchList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return LoanEntryList;
	}

	@Override
	public LoanEntry getEmployeeId(String employeeId) throws CustomException {
		LoanEntry loanEntry = new LoanEntry();
		try {
			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] {};
			Map row = jdbcTemplate.queryForMap(LoanEntryQueryUtil.getemployeeId, employeeId);
			if (row.get("employee_name") != null) {
				loanEntry.setEmployeeName((String) row.get("employee_name"));

			}
			return loanEntry;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getBranchList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}
}
