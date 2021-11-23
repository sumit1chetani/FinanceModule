package com.dci.payroll.tds.employeeHraReceipts;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
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
public class EmployeeHraReceiptsDAOImpl implements EmployeeHraReceiptsDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeHraReceiptsDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EmployeeHraReceiptsBean> getEmployeeHraReceiptsList() throws Exception {
		List<EmployeeHraReceiptsBean> employeeHraReceiptsList = new ArrayList<EmployeeHraReceiptsBean>();
		try {
			employeeHraReceiptsList = jdbcTemplate.query(EmployeeHraReceiptsQueryUtil.LIST_EMPLOYEEHRARECEIPTS, new BeanPropertyRowMapper<EmployeeHraReceiptsBean>(EmployeeHraReceiptsBean.class));
			return employeeHraReceiptsList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in employeeHraReceiptsList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertEmployeeeHraReceipt(EmployeeHraReceiptsBean employeeHraReceiptsBean) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		String autoGenTrnSchId = "";
		try {
			Map<String, Object> employeeHramap = new HashMap<String, Object>();
			employeeHramap.put("employee_id", employeeHraReceiptsBean.getEmployeeId());
			employeeHramap.put("hra_status", employeeHraReceiptsBean.getHraStatus());
			employeeHramap.put("month_year", employeeHraReceiptsBean.getMonthYear());
			employeeHramap.put("rent_paid", employeeHraReceiptsBean.getRentPaid());
			employeeHramap.put("file_name", employeeHraReceiptsBean.getFileName());
			namedParameterJdbcTemplate.update(EmployeeHraReceiptsQueryUtil.INSERT_EMPLOYEEHRARECEIPTS, employeeHramap);
			isSuccess = true;
			if (i == 0) {

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in insertDesignation", e.getMessage());
			throw new CustomException("Tax Section Name '" + employeeHraReceiptsBean.getEmployeeId() + "' already exists.");
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public EmployeeHraReceiptsBean getEmployeeHraReceipt(String employeeId, String monthYear) throws CustomException {
		EmployeeHraReceiptsBean employeeHramap = new EmployeeHraReceiptsBean();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { employeeId };
			Map row = jdbcTemplate.queryForMap(EmployeeHraReceiptsQueryUtil.SELCT_EMPLOYEEHRARECEIPTS_BYID, employeeId, monthYear);

			if (row.get("employee_id") != null) {
				employeeHramap.setEmployeeId((String) row.get("employee_id"));
			}
			if (row.get("department_Id") != null) {
				employeeHramap.setDepartmentId((int) row.get("department_Id"));
			}
			if (row.get("branch_Id") != null) {
				employeeHramap.setBranchId((String) row.get("branch_Id"));
			}
			if (row.get("company_Id") != null) {
				employeeHramap.setCompanyId((String) row.get("company_Id"));
			}
			if (row.get("company_name") != null) {
				employeeHramap.setCompanyName((String) row.get("company_name"));
			}
			if (row.get("department_name") != null) {
				employeeHramap.setDepartmentName((String) row.get("department_name"));
			}
			if (row.get("branch_name") != null) {
				employeeHramap.setBranchName((String) row.get("branch_name"));
			}
			if (row.get("employeeName") != null) {
				employeeHramap.setEmployeeName((String) row.get("employeeName"));
			}
			if (row.get("hra_status") != null) {
				employeeHramap.setHraStatus((int) row.get("hra_status"));
			}
			if (row.get("month_year") != null) {
				employeeHramap.setMonthYear((String) row.get("month_year"));
			}
			if (row.get("rent_paid") != null) {
				employeeHramap.setRentPaid((BigDecimal) row.get("rent_paid"));
			}
			if (row.get("file_name") != null) {
				employeeHramap.setFileName((String) row.get("file_name"));
			}

			employeeHramap.setisEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLoanEntryId", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		// TODO Auto-generated method stub
		return employeeHramap;
	}

	@Override
	public boolean updateEmployeeeHraReceipt(EmployeeHraReceiptsBean employeeHraReceiptsBean) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {
			Map<String, Object> employeeHramap = new HashMap<String, Object>();

			employeeHramap.put("employee_id", employeeHraReceiptsBean.getEmployeeId());
			employeeHramap.put("month_year", employeeHraReceiptsBean.getMonthYear());
			employeeHramap.put("rent_paid", employeeHraReceiptsBean.getRentPaid());
			employeeHramap.put("file_name", employeeHraReceiptsBean.getFileName());

			namedParameterJdbcTemplate.update(EmployeeHraReceiptsQueryUtil.UPDATE_EMPLOYEEHRARECEIPTS, employeeHramap);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean approveupdate(EmployeeHraReceiptsBean employeeHraReceiptsBean) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {
			Map<String, Object> employeeHramap = new HashMap<String, Object>();

			employeeHramap.put("employee_id", employeeHraReceiptsBean.getEmployeeId());
			employeeHramap.put("month_year", employeeHraReceiptsBean.getMonthYear());
			employeeHramap.put("hra_status", employeeHraReceiptsBean.getHraStatus());

			namedParameterJdbcTemplate.update(EmployeeHraReceiptsQueryUtil.APPROVAL_UPDATE_EMPLOYEEHRARECEIPTS, employeeHramap);
			isSuccess = true;

			// }

		} catch (DataAccessException e) {
			LOGGER.error("Error in update LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean deleteEmployeeeHraReceipt(String employeeId, String monthYear) throws CustomException {
		boolean isSuccess = false;
		int val = 1;
		try {
			val = jdbcTemplate.update(EmployeeHraReceiptsQueryUtil.DELETE_EMPLOYEEHRARECEIPTS, employeeId, monthYear);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteBranch", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public EmployeeHraReceiptsResultBean uploadDocFile(MultipartFile file, String employeeName) {
		// TODO Auto-generated method stub
		EmployeeHraReceiptsResultBean employeeHraReceiptsResultBean = new EmployeeHraReceiptsResultBean();

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
				employeeHraReceiptsResultBean.setDocFileName("/document/" + file.getOriginalFilename());
				employeeHraReceiptsResultBean.setDocPath(serverFile.getPath());

				employeeHraReceiptsResultBean.setSuccess(true);
			} catch (Exception e) {

			}
		}
		return employeeHraReceiptsResultBean;
	}

}