package com.dci.payroll.payroll.reimbursement;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;



@Repository
public class ReimbursementDAOImpl implements ReimbursementDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ReimbursementDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Reimbursement> getReimbursementList(int status) throws CustomException {
		List<Reimbursement> ReimbursementList = new ArrayList<Reimbursement>();
		try {

			ReimbursementList = jdbcTemplate.query(ReimbursementQueryUtil.LIST_REIMBURSEMENT, new BeanPropertyRowMapper<Reimbursement>(Reimbursement.class), status);
			return ReimbursementList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Emibursement list", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<Reimbursement> getReimbursementListByStatus(int status, String approvalempId) throws CustomException {
		List<Reimbursement> ReimbursementList = new ArrayList<Reimbursement>();
		try {
			ReimbursementList = jdbcTemplate.query(ReimbursementQueryUtil.LIST_REIMBURSEMENT_BYSTATUS, new BeanPropertyRowMapper<Reimbursement>(Reimbursement.class), status, approvalempId);
			return ReimbursementList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Emibursement list", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<Reimbursement> getCurrencyList() throws CustomException {
		List<Reimbursement> ReimbursementList = new ArrayList<Reimbursement>();
		try {
			ReimbursementList = jdbcTemplate.query(ReimbursementQueryUtil.SELECT_CURRENCYLIST, new BeanPropertyRowMapper<Reimbursement>(Reimbursement.class));
			return ReimbursementList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Currency list", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<Reimbursement> getReimburseMentTypeList() throws CustomException {
		List<Reimbursement> ReimbursementList = new ArrayList<Reimbursement>();
		try {
			ReimbursementList = jdbcTemplate.query(ReimbursementQueryUtil.SELECT_REIMBURSEMENTTYPELIST, new BeanPropertyRowMapper<Reimbursement>(Reimbursement.class));
			return ReimbursementList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Currency list", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertReimbursementreq(Reimbursement reimbursement) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		String autoGenTrnSchId = "";
		try {
			Map<String, Object> reimbursementMap = new HashMap<String, Object>();
			autoGenTrnSchId = jdbcTemplate.queryForObject(ReimbursementQueryUtil.reimbursementIdAutoGen, String.class);
			reimbursement.setReimbursementId(Integer.parseInt(autoGenTrnSchId));
			reimbursementMap.put("reimbursement_id", reimbursement.getReimbursementId());
			reimbursementMap.put("employee_id", reimbursement.getEmployeeId());
			reimbursementMap.put("reimbursement_type_id", reimbursement.getReimbursementTypeId());
			reimbursementMap.put("payment_mode", reimbursement.getPaymentMode());
			reimbursementMap.put("currency_code", reimbursement.getCurrencyCode());
			reimbursementMap.put("amount", reimbursement.getAmount());
			reimbursementMap.put("description", reimbursement.getDescription());
			reimbursementMap.put("requested_by", reimbursement.getRequestedby());
			reimbursementMap.put("requested_date", reimbursement.getRequesteddate());
			reimbursementMap.put("status", reimbursement.getStatus());
			reimbursementMap.put("attachment", reimbursement.getFileName());
			namedParameterJdbcTemplate.update(ReimbursementQueryUtil.INSERT_REIMBURSEMENT, reimbursementMap);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in insert LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public Reimbursement getReimbursementById(int reimbursementId) throws CustomException {
		Reimbursement reimbursement = new Reimbursement();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { reimbursementId };
			Map row = jdbcTemplate.queryForMap(ReimbursementQueryUtil.SELECT_REIMBURSEMENT_ID, reimbursementId);

			if (row.get("department_Id") != null) {
				reimbursement.setDepartmentId((int) row.get("department_Id"));
			}
			if (row.get("company_name") != null) {
				reimbursement.setCompanyName((String) row.get("company_name"));
			}
			if (row.get("department_name") != null) {
				reimbursement.setDepartmentName((String) row.get("department_name"));
			}
			if (row.get("branch_name") != null) {
				reimbursement.setBranchName((String) row.get("branch_name"));
			}
			if (row.get("reimbusement_name") != null) {
				reimbursement.setReimbusementName((String) row.get("reimbusement_name"));
			}
			if (row.get("branch_Id") != null) {
				reimbursement.setBranchId((String) row.get("branch_Id"));
			}
			if (row.get("currency_name") != null) {
				reimbursement.setCurrencyName((String) row.get("currency_name"));
			}
			if (row.get("employee_Id") != null) {
				reimbursement.setEmployeeId((String) row.get("employee_Id"));
			}
			if (row.get("employeeName") != null) {
				reimbursement.setEmployeeName((String) row.get("employeeName"));
			}
			if (row.get("reimbursement_type_Id") != null) {
				reimbursement.setReimbursementTypeId((String) row.get("reimbursement_type_Id"));
			}
			if (row.get("payment_mode") != null) {
				reimbursement.setPaymentMode((String) row.get("payment_mode"));
			}
			if (row.get("currency_code") != null) {
				reimbursement.setCurrencyCode((String) row.get("currency_code"));
			}
			if (row.get("amount") != null) {
				reimbursement.setAmount((double) row.get("amount"));
			}
			if (row.get("description") != null) {
				reimbursement.setDescription((String) row.get("description"));
			}
			if (row.get("status") != null) {
				reimbursement.setStatus((int) row.get("status"));
			}
			if (row.get("reimbursement_id") != null) {
				reimbursement.setReimbursementId((int) row.get("reimbursement_id"));
			}
			if (row.get("attachment") != null) {
				reimbursement.setFileName((String) row.get("attachment"));
			}

			reimbursement.setisEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLoanEntryId", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		// TODO Auto-generated method stub
		return reimbursement;
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {

			Map<String, Object> reimbursementMap = new HashMap<String, Object>();

			reimbursementMap.put("reimbursement_id", reimbursement.getReimbursementId());
			reimbursementMap.put("employee_id", reimbursement.getEmployeeId());
			reimbursementMap.put("reimbursement_type_id", reimbursement.getReimbursementTypeId());
			reimbursementMap.put("payment_mode", reimbursement.getPaymentMode());
			reimbursementMap.put("currency_code", reimbursement.getCurrencyCode());
			reimbursementMap.put("amount", reimbursement.getAmount());
			reimbursementMap.put("description", reimbursement.getDescription());
			reimbursementMap.put("requested_by", reimbursement.getRequestedby());
			reimbursementMap.put("requested_date", reimbursement.getRequesteddate());
			reimbursementMap.put("status", reimbursement.getStatus());
			reimbursementMap.put("attachment", reimbursement.getFileName());

			namedParameterJdbcTemplate.update(ReimbursementQueryUtil.UPDATE_REIMBURSEMENT, reimbursementMap);

			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean approvalupdate(Reimbursement reimbursement) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {

			Map<String, Object> reimbursementMap = new HashMap<String, Object>();

			reimbursementMap.put("status", reimbursement.getStatus());
			reimbursementMap.put("approved_by", reimbursement.getApprovalempId());
			reimbursementMap.put("approved_date", reimbursement.getApprovedDate());
			reimbursementMap.put("description", reimbursement.getDescription());
			reimbursementMap.put("reimbursement_id", reimbursement.getReimbursementId());

			namedParameterJdbcTemplate.update(ReimbursementQueryUtil.UPDATE_APPORVAL_REIMBURSEMENT, reimbursementMap);

			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean deleteReimbursement(int reimbursementId) throws CustomException {
		boolean isSuccess = false;
		int val = 1;
		try {
			val = jdbcTemplate.update(ReimbursementQueryUtil.DELETE_REIMBURSEMENT, reimbursementId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteBranch", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public ReimbursementResultBean uploadDocFile(MultipartFile file, String employeeName) {
		// TODO Auto-generated method stub
		ReimbursementResultBean reimburesResultBean = new ReimbursementResultBean();

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String workingDir = System.getProperty("user.dir");

				File dir = new File(workingDir + "/webapp" + File.separator + "tmpDocFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server

				File serverFile = new File(dir.getAbsolutePath() + File.separator + employeeName + "_" + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				reimburesResultBean.setDocFileName("/document/" + file.getOriginalFilename());
				reimburesResultBean.setDocPath(serverFile.getPath());

				reimburesResultBean.setSuccess(true);
			} catch (Exception e) {

			}
		}
		return reimburesResultBean;
	}

}
