package com.dci.truck.grade;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;



@Repository
@Transactional("tenantTransactionManager")


public class GradeAdminDAOImpl implements GradeAdminDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(GradeAdminDAOImpl.class);

	

	@Autowired
	DataSource dataSource;

	@Autowired
	UserLogDAO userlogDao;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<GradeAdmin> getGradeList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<GradeAdmin> gradeList = new ArrayList<GradeAdmin>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			gradeList = jdbcTemplate.query(GradeAdminQueryUtil.SELECT_GRADE_LIST, new BeanPropertyRowMapper<GradeAdmin>(GradeAdmin.class));
			return gradeList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getGradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertGrade(GradeAdmin grade) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int gradeId=0;
		try {
			Map<String, Object> gradeMap = new HashMap<String, Object>();
			gradeMap.put("companyId", grade.getCompanyId());
			gradeMap.put("gradeName", grade.getGradeName());
			gradeMap.put("description", grade.getDescription());
			gradeMap.put("status", grade.getStatus());
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(GradeAdminQueryUtil.CHECK_COUNT_GRADE,Integer.class, new Object[] { grade.getCompanyId(), grade.getGradeName() });
			if (i == 0) {

				namedParameterJdbcTemplate.update(GradeAdminQueryUtil.INSERT_GRADE, gradeMap);
				isSuccess = true;
				gradeId = jdbcTemplate.queryForObject(GradeAdminQueryUtil.select_previous_id,Integer.class);
				grade.setTableName("grade");
				grade.setFormCode("F5119");
				 userlogDao.userLogForInsert(grade, gradeId + "", userDetail.getUserId());

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getGradeAdd", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public GradeAdmin getGradeById(Integer gradeId) throws CustomException {
		GradeAdmin grade = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			grade = jdbcTemplate.queryForObject(GradeAdminQueryUtil.SELECT_GRADE_BY_ID, new BeanPropertyRowMapper<GradeAdmin>(GradeAdmin.class), gradeId);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getGradeEdit", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}
		return grade;
	}

	@Override
	public boolean updateGrade(GradeAdmin grade) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		GradeAdmin gradeOld=getGradeById(grade.getGradeId());
		try {
			String gradename = jdbcTemplate.queryForObject(GradeAdminQueryUtil.Grade_Name, String.class, grade.getGradeId(), grade.getCompanyId());

			if (grade.getGradeName().equals(gradename)) {

				boolean status = false;
				Map<String, Object> gradeMap = new HashMap<String, Object>();
				gradeMap.put("companyId", grade.getCompanyId());
				gradeMap.put("gradeName", grade.getGradeName());
				gradeMap.put("description", grade.getDescription());
				gradeMap.put("status", grade.getStatus());
				gradeMap.put("gradeId", grade.getGradeId());
				grade.setTableName("grade");
				grade.setFormCode("F5119");
				namedParameterJdbcTemplate.update(GradeAdminQueryUtil.UPDATE_GRADE, gradeMap);
				UserLog userLog = userlogDao.userLogForUpdate(gradeOld, grade, grade.getGradeId()+ "",teampUser.getUserId());


				isSuccess = true;
			} else {

				i = jdbcTemplate.queryForObject(GradeAdminQueryUtil.CHECK_COUNT_GRADE_UPDATE, Integer.class,grade.getCompanyId(), grade.getGradeName(), grade.getGradeId());
				if (i == 0) {

					boolean status = false;
					Map<String, Object> gradeMap = new HashMap<String, Object>();
					gradeMap.put("companyId", grade.getCompanyId());
					gradeMap.put("gradeName", grade.getGradeName());
					gradeMap.put("description", grade.getDescription());
					gradeMap.put("status", grade.getStatus());
					gradeMap.put("gradeId", grade.getGradeId());
					namedParameterJdbcTemplate.update(GradeAdminQueryUtil.UPDATE_GRADE, gradeMap);
					isSuccess = true;
				} else {

				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getGradeEdit", e);
			throw new CustomException(ErrorMessage.ERROR_UPDATE);
		}

		return isSuccess;
	}

	@Override
	public void deleteGrade(Integer gradeId) throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		GradeAdmin grade = getGradeById(gradeId);
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			grade.setTableName("grade");
			grade.setFormCode("F5119");
			jdbcTemplate.update(GradeAdminQueryUtil.DELETE_GRADE, gradeId);
			 userlogDao.userLogForDelete(grade, gradeId + "", teampUser.getUserId());

		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteDesignation", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}

	}

	@Override
	public GradeAdminResultBean getCompanyList() throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		GradeAdminResultBean gradeResultBean = new GradeAdminResultBean();
		List<GradeAdmin> companyList = new ArrayList<GradeAdmin>();
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			companyList = jdbcTemplate.query(GradeAdminQueryUtil.SELECT_COMPANY_LIST, new BeanPropertyRowMapper<GradeAdmin>(GradeAdmin.class));
			gradeResultBean.setCompanyList(companyList);
			gradeResultBean.setSuccess(true);
			return gradeResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public void uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		ArrayList<GradeAdmin> lGrade = new ArrayList<GradeAdmin>();
		GradeAdmin objGrade = null;
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
					objGrade = new GradeAdmin();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0) {
								objGrade.setGradeName(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 2) {
								objGrade.setDescription(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 3) {
								objGrade.setCompanyId(cell.getStringCellValue().trim());
							}
							break;

						case Cell.CELL_TYPE_BOOLEAN:
							if (cell.getColumnIndex() == 1) {
								objGrade.setStatus(cell.getBooleanCellValue());
							}
							break;
						}
					}
					lGrade.add(objGrade);
				}

			}
			exportDataToDB(lGrade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void exportDataToDB(ArrayList<GradeAdmin> lGrade) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			for (GradeAdmin objGrade : lGrade) {

				String GRADE_NAME = objGrade.getGradeName();
				boolean STATUS = objGrade.getStatus();
				String DESCRIPTION = objGrade.getDescription();
				String COMPANY = objGrade.getCompanyId();
				jdbcTemplate.update(GradeAdminQueryUtil.INSERT_GRADE_UPLOAD, new Object[] { GRADE_NAME, STATUS, DESCRIPTION, COMPANY });
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the grade table", e);
		}

	}
}

