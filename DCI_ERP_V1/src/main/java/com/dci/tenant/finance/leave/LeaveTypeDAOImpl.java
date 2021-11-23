package com.dci.tenant.finance.leave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")
public class LeaveTypeDAOImpl implements LeaveTypeDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LeaveTypeDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Resource
	DataSource dataSource;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<LeaveType> getLeaveTypeList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<LeaveType> leaveTypeList = new ArrayList<LeaveType>();
		try {
			leaveTypeList = jdbcTemplate.query(LeaveTypeQueryUtil.SELECT_LEAVE_TYPE_LIST, new BeanPropertyRowMapper<LeaveType>(LeaveType.class), userDetail.getCompanyCode());
			return leaveTypeList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLeaveTypeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertLeaveType(LeaveType leaveType) throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			
			
		
			if (leaveType.getMaxDaysUnderProbation() == "") {
				leaveType.setMaxDaysUnderProbation("0");
			}
			if (leaveType.getMaxDaysMedicalLeave() == "") {
				leaveType.setMaxDaysMedicalLeave("0");
			}
			if (leaveType.getMaxDaysMaternityLeave() == "") {
				leaveType.setMaxDaysMaternityLeave("0");
			}
			Map<String, Object> leaveTypeMap = new HashMap<String, Object>();
			leaveTypeMap.put("shortName", leaveType.getShortName());
			leaveTypeMap.put("leaveTypeName", leaveType.getLeaveTypeName());
			leaveTypeMap.put("canCarryForward", leaveType.getCanCarryForward());
			leaveTypeMap.put("carryForwardLimit", leaveType.getCarryForwardLimit());
			leaveTypeMap.put("encashable", leaveType.getEncashable());
			leaveTypeMap.put("appUnderProbation", leaveType.getApplicableUnderProbation());
			leaveTypeMap.put("gender", leaveType.getGender());
			leaveTypeMap.put("status", leaveType.getStatus());
			leaveTypeMap.put("maxDaysUnderProbation", leaveType.getMaxDaysUnderProbation());
			leaveTypeMap.put("isMedical", leaveType.getMedical());
			leaveTypeMap.put("maxDaysMedicalLeave", leaveType.getMaxDaysMedicalLeave());
			leaveTypeMap.put("isMaternityLeave", leaveType.getMaternityLeave());
			leaveTypeMap.put("maxDaysMaternityLeave", leaveType.getMaxDaysMaternityLeave());
			leaveTypeMap.put("companyId", userDetail.getCompanyCode());
			leaveTypeMap.put("year", leaveType.getYear());
			leaveTypeMap.put("creadted_by", userDetail.getUserId());
			leaveTypeMap.put("empid", leaveType.getEmpId());
			leaveTypeMap.put("branch", leaveType.getBranch());


			namedParameterJdbcTemplate.update(LeaveTypeQueryUtil.INSERT_LEAVE_TYPE, leaveTypeMap);
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertLeaveType", e.getMessage());
			if (e.getMessage().indexOf("unique constraint") != -1) {
				throw new CustomException("Leave Short Name '" + leaveType.getShortName() + "' already exists.");
			} else {
				//throw new CustomException(ErrorMessage.ERROR_ADD);
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public void updateLeaveType(LeaveType leaveType) throws CustomException {
		try {
			if (leaveType.getMaxDaysUnderProbation() == "") {
				leaveType.setMaxDaysUnderProbation("0");
			}
			if (leaveType.getMaxDaysMedicalLeave() == "") {
				leaveType.setMaxDaysMedicalLeave("0");
			}
			if (leaveType.getMaxDaysMaternityLeave() == "") {
				leaveType.setMaxDaysMaternityLeave("0");
			}

			Map<String, Object> leaveTypeMap = new HashMap<String, Object>();
			leaveTypeMap.put("shortName", leaveType.getShortName());
			leaveTypeMap.put("leaveTypeName", leaveType.getLeaveTypeName());
			leaveTypeMap.put("canCarryForward", leaveType.getCanCarryForward());
			leaveTypeMap.put("carryForwardLimit", leaveType.getCarryForwardLimit());
			leaveTypeMap.put("encashable", leaveType.getEncashable());
			leaveTypeMap.put("appUnderProbation", leaveType.getApplicableUnderProbation());
			leaveTypeMap.put("gender", leaveType.getGender());
			leaveTypeMap.put("status", leaveType.getStatus());
			leaveTypeMap.put("maxDaysUnderProbation", leaveType.getMaxDaysUnderProbation());
			leaveTypeMap.put("isMedical", leaveType.getMedical());
			leaveTypeMap.put("maxDaysMedicalLeave", leaveType.getMaxDaysMedicalLeave());
			leaveTypeMap.put("isMaternityLeave", leaveType.getMaternityLeave());
			leaveTypeMap.put("maxDaysMaternityLeave", leaveType.getMaxDaysMaternityLeave());
			leaveTypeMap.put("empId", leaveType.getEmpId());
			leaveTypeMap.put("year", leaveType.getYear());

			namedParameterJdbcTemplate.update(LeaveTypeQueryUtil.UPDATE_LEAVE_TYPE, leaveTypeMap);
		} catch (DataAccessException e) {
			LOGGER.error("Error in updateLeaveType", e);
		}
	}

	@Override
	public void deleteLeaveType(String shortName) throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			jdbcTemplate.update(LeaveTypeQueryUtil.DELETE_LEAVE_TYPE, shortName);
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteLeaveType", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
	}

	@Override
	public LeaveType getLeaveTypeByShortName(String shortName) throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		LeaveType leaveType = null;
		try {
			leaveType = jdbcTemplate.queryForObject(LeaveTypeQueryUtil.SELECT_LEAVE_TYPE_BY_SHORT_NAME, new Object[] { shortName }, new BeanPropertyRowMapper<LeaveType>(LeaveType.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getLeaveTypeByShortName", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return leaveType;
	}

	@Override
	public void bulkDeleteLeaveType(List<String> shortNameList) throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			for (String shortName : shortNameList) {
				jdbcTemplate.update(LeaveTypeQueryUtil.DELETE_LEAVE_TYPE, shortName, userDetail.getCompanyCode());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteLeaveType", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
	}

	@Override
	public boolean uploadFile(MultipartFile file) {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		ArrayList<LeaveType> lLeaveType = new ArrayList<LeaveType>();
		LeaveType objLeaveType = null;
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		String datestring = "";
		int stopExec = 0;
		Workbook workbook = null;
		try {
			if (fileName.endsWith("xls")) {
				workbook = new HSSFWorkbook(file.getInputStream());
				HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet.rowIterator();
			} else if (fileName.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet.rowIterator();
			} else {
				System.out.println("Not a valid file format");
			}

			int rowCnt = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowCnt += 1;
				if (rowCnt > 1) {
					Iterator<Cell> cellIterator = row.cellIterator();
					String sDateCheck = "";
					objLeaveType = new LeaveType();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0) {
								objLeaveType.setShortName(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 1) {
								objLeaveType.setLeaveTypeName(cell.getStringCellValue().trim());
							}/*
							 * else if (cell.getColumnIndex() == 3) {
							 * objLeaveType
							 * .setCarryForwardLimit(cell.getStringCellValue
							 * ().trim()); }
							 */
							break;

						case Cell.CELL_TYPE_BOOLEAN:
							if (cell.getColumnIndex() == 2) {
								objLeaveType.setCanCarryForward(cell.getBooleanCellValue());
							} else if (cell.getColumnIndex() == 4) {
								objLeaveType.setEncashable(cell.getBooleanCellValue());
							} else if (cell.getColumnIndex() == 5) {
								objLeaveType.setApplicableUnderProbation(cell.getBooleanCellValue());
							} else if (cell.getColumnIndex() == 7) {
								objLeaveType.setStatus(cell.getBooleanCellValue());
							} else if (cell.getColumnIndex() == 9) {
								objLeaveType.setMedical(cell.getBooleanCellValue());
							} else if (cell.getColumnIndex() == 11) {
								objLeaveType.setMaternityLeave(cell.getBooleanCellValue());
							}
							break;

						case Cell.CELL_TYPE_NUMERIC:
							if (cell.getColumnIndex() == 3) {
								objLeaveType.setCarryForwardLimit(String.valueOf(cell.getNumericCellValue()));
							} else if (cell.getColumnIndex() == 6) {
								objLeaveType.setGender((int) cell.getNumericCellValue());
							} else if (cell.getColumnIndex() == 8) {
								objLeaveType.setMaxDaysUnderProbation(String.valueOf(cell.getNumericCellValue()));
							} else if (cell.getColumnIndex() == 10) {
								objLeaveType.setMaxDaysMedicalLeave(String.valueOf(cell.getNumericCellValue()));
							} else if (cell.getColumnIndex() == 12) {
								objLeaveType.setMaxDaysMaternityLeave(String.valueOf(cell.getNumericCellValue()));
							}
							break;
						}
					}
					lLeaveType.add(objLeaveType);
				}

			}
			isSuccess = exportDataToDB(lLeaveType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private boolean exportDataToDB(ArrayList<LeaveType> lLeaveType) {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		try {

			for (LeaveType objLeaveType : lLeaveType) {

				String SHORT_NAME = objLeaveType.getShortName();
				String LEAVE_TYPE_NAME = objLeaveType.getLeaveTypeName();
				boolean CAN_CARRY_FRWD = objLeaveType.getCanCarryForward();

				String CARRY_FRWD_LMT = objLeaveType.getCarryForwardLimit().trim();
				double CARRY_FRWD_LMTNO = Double.valueOf(CARRY_FRWD_LMT);

				boolean ENCASHABLE = objLeaveType.getEncashable();
				boolean APPLICABLE_PROB = objLeaveType.getApplicableUnderProbation();
				int GENDER = objLeaveType.getGender();
				boolean STATUS = objLeaveType.getStatus();

				String MAX_DAY_PROB = objLeaveType.getMaxDaysUnderProbation();
				double MAX_DAYS_UNDPROB = Double.valueOf(MAX_DAY_PROB);

				boolean IS_MEDICAL = objLeaveType.getMedical();

				String MAX_MEDIC_LEAVE = objLeaveType.getMaxDaysMedicalLeave();
				double MAX_DAYS_MEDICAL_LEAVE = Double.valueOf(MAX_MEDIC_LEAVE);

				boolean IS_MATERNITY_LEAVE = objLeaveType.getMaternityLeave();

				String MAX_MATERMITY = objLeaveType.getMaxDaysMaternityLeave();
				double MAX_DAYS_MATERNITY_LEAVE = Double.valueOf(MAX_MATERMITY);
				jdbcTemplate.update(LeaveTypeQueryUtil.INSERT_LEAVE_TYPE_UPLOAD, new Object[] { SHORT_NAME, LEAVE_TYPE_NAME, CAN_CARRY_FRWD, CARRY_FRWD_LMTNO, ENCASHABLE, APPLICABLE_PROB, GENDER, STATUS, MAX_DAYS_UNDPROB, IS_MEDICAL, MAX_DAYS_MEDICAL_LEAVE, IS_MATERNITY_LEAVE, MAX_DAYS_MATERNITY_LEAVE });
				isSuccess = true;

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the department table", e);
		}
		return isSuccess;

	}
}
