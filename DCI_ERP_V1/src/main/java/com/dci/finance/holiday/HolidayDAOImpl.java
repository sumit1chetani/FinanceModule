package com.dci.finance.holiday;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.dci.common.model.SelectivityBean;
import com.dci.tenant.user.UserDetail;


@Transactional("tenantTransactionManager")


@Repository
public class HolidayDAOImpl implements HolidayDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(HolidayDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<HolidayBean> getHolidayList() throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<HolidayBean> holidayList = new ArrayList<HolidayBean>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(HolidayQueryUtil.holidaySelect);
		for (Map row : rows) {
			HolidayBean bean = new HolidayBean();
			bean.setCompanyName((String) row.get("companyName"));
			bean.setBranch((String) row.get("branch"));
			bean.setHolidayName((String) row.get("holidayName"));
			bean.setDate((String) row.get("holidaydate"));
		//	bean.setDay((String) row.get("days"));
			bean.setHolidayId((int) row.get("holidayId"));

			holidayList.add(bean);
		}
		return holidayList;
	}

	@Override
	public void saveHoliday(HolidayBean holidaybean) throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");

		int holiday_Id = jdbcTemplate.queryForObject(HolidayQueryUtil.getHolidayId,Integer.class);

		String holidaDate = holidaybean.getDate();

		//Date date = formatter.parse(holidaDate);
	//	java.sql.Timestamp holDate = new Timestamp(date.getTime());
		jdbcTemplate.update(HolidayQueryUtil.holidayInsert, holiday_Id, holidaDate, holidaybean.getHolidayName(), holidaybean.getBranch() ,holidaybean.getCompanyId());
	}

	@Override
	public HolidayBean getHolidayEditList(Integer HolidayId) throws Exception {
		// TODO Auto-generated method stub
		HolidayBean resultBean = new HolidayBean();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(HolidayQueryUtil.getHolidayEditList, new Object[] { HolidayId });
		for (Map row : rows) {
			resultBean.setHolidayId((int) row.get("holidayId"));
			resultBean.setDate((String) row.get("date"));
			resultBean.setHolidayName((String) row.get("holidayName"));
			resultBean.setCompanyId((String) row.get("companyId"));
			resultBean.setBranch((String) row.get("branch"));
			resultBean.setBranchId((String) row.get("branchId"));
			//resultBean.setCompanyName((String) row.get("companyName"));

			System.out.println("resultBean" + resultBean);
		}

		return resultBean;
	}

	@Override
	public boolean updateHoliday(HolidayBean holidaybean) throws Exception {
		boolean isSucess = false;
		/*DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		String effdate = holidaybean.getDate();
		Date date = formatter.parse(effdate);
		java.sql.Timestamp holidayDate = new Timestamp(date.getTime());*/
		int i = jdbcTemplate.update(HolidayQueryUtil.updateHoliday, holidaybean.getDate(), holidaybean.getHolidayName(), holidaybean.getBranchId(), holidaybean.getHolidayId());
		if (i > 0) {
			isSucess = true;
		}
		return isSucess;
	}

	@Override
	public boolean deleteHoliday(Integer holidayId) throws Exception {
		boolean isSucess = false;
		System.out.println("hoddlidayyy" + holidayId);
		int i = jdbcTemplate.update(HolidayQueryUtil.deleteHoliday, holidayId);
		System.out.println("iiii" + i);
		if (i > 0) {
			isSucess = true;
		}
		return isSucess;
	}

	@Override
	public boolean uploadFile(MultipartFile file) {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		ArrayList<HolidayBean> lHolidayBean = new ArrayList<HolidayBean>();
		HolidayBean objHolidayBean = null;
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
					objHolidayBean = new HolidayBean();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0) {
								objHolidayBean.setBranch(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 1) {
								objHolidayBean.setDate(cell.getStringCellValue().trim());

							} else if (cell.getColumnIndex() == 2) {
								objHolidayBean.setHolidayName(cell.getStringCellValue().trim());
							}
							break;

						}
					}
					lHolidayBean.add(objHolidayBean);
				}

			}
			isSuccess = exportDataToDB(lHolidayBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private boolean exportDataToDB(ArrayList<HolidayBean> lHolidayBean) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		try {

			for (HolidayBean objHolidayBean : lHolidayBean) {

				String BRANCH = objHolidayBean.getBranch();
				String HOLIDAY_NAME = objHolidayBean.getHolidayName();
				int holiday_Id = jdbcTemplate.queryForObject(HolidayQueryUtil.getHolidayId,Integer.class);
				String holidayDate = objHolidayBean.getDate();

				DateFormat formatter;
				Date date = null;
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				try {
					date = formatter.parse(holidayDate);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// String HOLIDAY_DATE = objHolidayBean.getDate();

				jdbcTemplate.update(HolidayQueryUtil.INSERT_HOSPITAL_UPLOAD, new Object[] { holiday_Id, BRANCH, HOLIDAY_NAME, date });
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the holiday table", e);
		}
		return isSuccess;

	}

	@Override
	public List<HolidayBean> getTotalHolidaylist() throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<HolidayBean> holidayList = new ArrayList<HolidayBean>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(HolidayQueryUtil.holidayList);
		for (Map row : rows) {
			HolidayBean bean = new HolidayBean();
			bean.setCompanyId((String) row.get("companyId"));
			bean.setBranch((String) row.get("branch"));
			bean.setBranchId((String) row.get("branchId"));
			bean.setHolidayName((String) row.get("holidayName"));
			bean.setDate((String) row.get("holidaydate"));
			bean.setDay((String) row.get("days"));
			bean.setHolidayId((int) row.get("holidayId"));

			holidayList.add(bean);
		}
		return holidayList;
	}

	@Override
	public List<SelectivityBean> getboardList() {
		List<SelectivityBean> lSubboardList = new ArrayList<SelectivityBean>();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			lSubboardList = jdbcTemplate.query(HolidayQueryUtil.GET_Branch_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get SUB Group List", e);
		}
		return lSubboardList;
	}
	
	

	@Override
	public List<SelectivityBean> getgradeList() {
		List<SelectivityBean> gradelist = new ArrayList<SelectivityBean>();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			gradelist = jdbcTemplate.query(HolidayQueryUtil.GET_GRADE_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get SUB Group List", e);
		}
		return gradelist;
	}
	
	
	@Override
	public List<HolidayBean> getCustomerListByVoyage(String departmentId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 

		List<HolidayBean> lCustomerList = new ArrayList<HolidayBean>();
		try {
			lCustomerList = jdbcTemplate.query(HolidayQueryUtil.GET_EMP_DEPT_LISt,new Object[]{departmentId},
					new BeanPropertyRowMapper <HolidayBean>(HolidayBean.class));

	

		} catch (DataAccessException e) {
			LOGGER.error("Error in Customer LIST", e);
		}
		return lCustomerList;
	}
	@Override
	public List<SelectivityBean> getbranchList() {
		
		List<SelectivityBean> list = new ArrayList<SelectivityBean>();
		
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			list = jdbcTemplate.query(HolidayQueryUtil.get_branch_list, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
