package com.dci.payroll.tds.TdsDeclaration;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;



@Repository
public class TdsDeclarationDAOImpl implements TdsDeclarationDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(TdsDeclarationDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<TdsDeclarationBean> getTdsDeclarationList(String employeeId, String financialYearId, String taxSectionCode) throws CustomException {
		List<TdsDeclarationBean> tdsDeclarationList = new ArrayList<TdsDeclarationBean>();
		try {

			tdsDeclarationList = jdbcTemplate.query(TdsDeclarationQueryUtill.SELECT_ALL, new BeanPropertyRowMapper<TdsDeclarationBean>(TdsDeclarationBean.class), employeeId, financialYearId, taxSectionCode, false);
			return tdsDeclarationList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in TdsDeclaration", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<TdsDeclarationBean> getTdsGenerationList(String companyId, String branchId, int departmentId, String employeeId, String monthYear) throws CustomException {
		List<TdsDeclarationBean> tdsDeclarationList = new ArrayList<TdsDeclarationBean>();

		String paycomponentId = "TDS";

		if (departmentId == 0) {
			tdsDeclarationList = jdbcTemplate.query(TdsDeclarationQueryUtill.EMPLOYEE_TDS_GENERATION, new BeanPropertyRowMapper<TdsDeclarationBean>(TdsDeclarationBean.class), companyId, branchId, null, employeeId, paycomponentId, monthYear);
		} else {
			tdsDeclarationList = jdbcTemplate.query(TdsDeclarationQueryUtill.EMPLOYEE_TDS_GENERATION, new BeanPropertyRowMapper<TdsDeclarationBean>(TdsDeclarationBean.class), companyId, branchId, departmentId, employeeId, paycomponentId, monthYear);
		}

		try {

			return tdsDeclarationList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in TdsDeclaration", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public TdsDeclarationBean getTdsDeclarationBySk(int sk) throws CustomException {
		TdsDeclarationBean tdsDeclaration = null;
		try {
			tdsDeclaration = jdbcTemplate.queryForObject(TdsDeclarationQueryUtill.SELECT_BY_SK, new BeanPropertyRowMapper<TdsDeclarationBean>(TdsDeclarationBean.class), sk);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTdsDeclarationEdit", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}
		return tdsDeclaration;
	}

	@Override
	public boolean insertTdsDeclaration(ArrayList<TdsDeclarationBean> tdsDeclaration) throws CustomException {
		boolean isSuccess = false;
		try {
			List<TdsDeclarationBean> empDeclarationList = new ArrayList<TdsDeclarationBean>();

			Map<String, Object> tdsDeclarationMap = null;

			for (TdsDeclarationBean declarationBean : tdsDeclaration) {

				tdsDeclarationMap = new HashMap<String, Object>();
				tdsDeclarationMap.put("employee_id", declarationBean.getEmployeeId());
				tdsDeclarationMap.put("financial_year_id", declarationBean.getFinancialYearId());
				tdsDeclarationMap.put("tax_section_code", declarationBean.getTaxSectionCode());
				tdsDeclarationMap.put("tax_sub_section_code", declarationBean.getTaxSubSectionCode());
				tdsDeclarationMap.put("actual_amount", declarationBean.getActualAmount());
				tdsDeclarationMap.put("declared_amount", declarationBean.getDeclaredAmount());
				tdsDeclarationMap.put("status", declarationBean.getStatus());
				empDeclarationList = jdbcTemplate.query(TdsDeclarationQueryUtill.SELECT_EMP_DECLARATION_BY_ID, new BeanPropertyRowMapper<TdsDeclarationBean>(TdsDeclarationBean.class), declarationBean.getEmployeeId(), declarationBean.getFinancialYearId(), declarationBean.getTaxSubSectionCode());
				if (empDeclarationList.size() == 0) {

					if (declarationBean.getDeclaredAmount() > 0) {
						namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.INSERT, tdsDeclarationMap);
					}

				} else {
					if (declarationBean.getDeclaredAmount() >= 0) {
						namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.UPDATE_EMP_DECLARATION, tdsDeclarationMap);
					}

				}

			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTdsDeclarationAdd", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean insertTdsGeneration(ArrayList<TdsDeclarationBean> tdsDeclaration) throws CustomException {
		boolean isSuccess = false;
		try {
			List<TdsDeclarationBean> empPayCompPaidList = new ArrayList<TdsDeclarationBean>();

			Map<String, Object> tdsDeclarationMap = null;

			for (TdsDeclarationBean declarationBean : tdsDeclaration) {

				tdsDeclarationMap = new HashMap<String, Object>();

				tdsDeclarationMap.put("employee_id", declarationBean.getEmployeeId());
				tdsDeclarationMap.put("pay_component_id", "TDS");
				tdsDeclarationMap.put("month_year", declarationBean.getMonthYear());
				tdsDeclarationMap.put("amount", declarationBean.getAmount());

				empPayCompPaidList = jdbcTemplate.query(TdsDeclarationQueryUtill.CHECK_EMP_PAYCOM_PAID_EXISTS, new BeanPropertyRowMapper<TdsDeclarationBean>(TdsDeclarationBean.class), declarationBean.getEmployeeId(), declarationBean.getMonthYear(), "TDS");

				if (empPayCompPaidList.size() == 0) {

					if (declarationBean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.INSERT_EMP_PAYCOM_PAID, tdsDeclarationMap);
					}

				} else {
					if (declarationBean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.UPDATE_EMP_PAYCOM_PAID, tdsDeclarationMap);
					} else {
						if (declarationBean.getAmount() <= 0) {
							namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.DELETE_EMP_PAYCOM, tdsDeclarationMap);
						}
					}

				}

			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTdsDeclarationAdd", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean updateTdsDeclaration(TdsDeclarationBean tdsDeclaration) throws CustomException {
		boolean isSuccess = false;
		try {
			Map<String, Object> tdsDeclarationMap = new HashMap<String, Object>();
			tdsDeclarationMap.put("sk", tdsDeclaration.getSk());
			tdsDeclarationMap.put("employeeId", tdsDeclaration.getEmployeeId());
			tdsDeclarationMap.put("financialYearId", tdsDeclaration.getFinancialYearId());
			tdsDeclarationMap.put("taxSectionCode", tdsDeclaration.getTaxSectionCode());
			tdsDeclarationMap.put("taxSubSectionCode", tdsDeclaration.getTaxSubSectionCode());
			tdsDeclarationMap.put("actualAmount", tdsDeclaration.getActualAmount());
			tdsDeclarationMap.put("declaredAmount", tdsDeclaration.getDeclaredAmount());
			tdsDeclarationMap.put("status", tdsDeclaration.getStatus());
			tdsDeclarationMap.put("filepathUrl", tdsDeclaration.getFilepathUrl());
			namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.UPDATE, tdsDeclarationMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in updateTdsDeclaration", e);
			throw new CustomException(ErrorMessage.ERROR_UPDATE);
		}
		return isSuccess;
	}

	@Override
	public boolean updateActualAmount(ArrayList<TdsDeclarationBean> actuvlList) throws CustomException {

		boolean isSuccess = false;
		try {
			List<TdsDeclarationBean> empPayCompPaidList = new ArrayList<TdsDeclarationBean>();

			Map<String, Object> tdsDeclarationMap = null;

			for (TdsDeclarationBean declarationBean : actuvlList) {

				tdsDeclarationMap = new HashMap<String, Object>();
				tdsDeclarationMap.put("employee_id", declarationBean.getEmployeeId());
				tdsDeclarationMap.put("financial_year_id", declarationBean.getFinancialYearId());
				tdsDeclarationMap.put("tax_section_code", declarationBean.getTaxSectionCode());
				tdsDeclarationMap.put("tax_sub_section_code", declarationBean.getTaxSubSectionCode());
				tdsDeclarationMap.put("actual_amount", declarationBean.getActualAmount());
				tdsDeclarationMap.put("status", declarationBean.getStatus());
				tdsDeclarationMap.put("filepath_url", declarationBean.getFilepathUrl());
				empPayCompPaidList = jdbcTemplate.query(TdsDeclarationQueryUtill.SELECT_EMP_DECLARATION_BY_ID, new BeanPropertyRowMapper<TdsDeclarationBean>(TdsDeclarationBean.class), declarationBean.getEmployeeId(), declarationBean.getFinancialYearId(), declarationBean.getTaxSubSectionCode());
				if (empPayCompPaidList.size() == 0) {

					if (declarationBean.getActualAmount() > 0) {
						namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.INSERT_ACTUAL, tdsDeclarationMap);
					}

				} else {
					if (declarationBean.getActualAmount() >= 0) {
						namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.UPDATE_EMP_ACTUAL, tdsDeclarationMap);
					}

				}

			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTdsDeclarationAdd", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;

	}

	@Override
	public boolean deleteTdsDeclarationBySk(int sk) throws CustomException {
		boolean isSucess = false;
		try {
			int i = jdbcTemplate.update(TdsDeclarationQueryUtill.DELETE_BY_SK, sk);
			if (i > 0)
				isSucess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteTdsDeclaration", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		return isSucess;
	}

	@Override
	public TdsDeclarationResultBean uploadDocFile(MultipartFile file, String employeeName, String taxSubSectionName, String taxSectionCode) {
		// TODO Auto-generated method stub
		TdsDeclarationResultBean tdsDeclarationResultBean = new TdsDeclarationResultBean();

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String workingDir = System.getProperty("user.dir");

				File dir = new File(workingDir + "/webapp" + File.separator + "tmpDocFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server

				File serverFile = new File(dir.getAbsolutePath() + File.separator + employeeName + "_" + taxSectionCode + "_" + taxSubSectionName + "_" + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				tdsDeclarationResultBean.setDocFileName("/document/" + file.getOriginalFilename());
				tdsDeclarationResultBean.setDocPath(serverFile.getPath());

				tdsDeclarationResultBean.setSuccess(true);
			} catch (Exception e) {

			}
		}
		return tdsDeclarationResultBean;
	}

}
