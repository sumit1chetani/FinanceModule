package com.dci.master.userAdminMaster;

import java.io.IOException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CipherCrypto;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;
import com.dci.tenant.employeemaster.EmpmasterQueryUtil;
import com.dci.tenant.user.UserDetail;
import com.dci.tenant.user.UserMasterService;


@Repository
@Transactional("tenantTransactionManager")
public class UserAdminMasterDAOImpl implements UserAdminMasterDAO {
	private final static Logger LOGGER = Logger.getLogger(UserAdminMasterDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	private UserMasterService userMasterService;

	/*
	 * @Value("${folder.path.localPath}") private String localPath;
	 * 
	 * @Value("${folder.path.serverPath}") private String serverpath;
	 */

	@Value("${folder.path.localPath}")
	private String getFileUrl;

	@Value("${folder.path.serverPath}")
	private String getFilePath;

	@Value("${folder.path.localPath}")
	private String getFilePropertyUrl;

	@Value("${folder.path.serverPath}")
	private String getFileServerPath;

	@Value("${folder.path.localPath}")
	private String bcodeLocalPath;

	@Value("${folder.path.serverPath}")
	private String bCodeServerPath;

	@Override
	public List<UserAdminMasterBean> getEmployeeList(int limit, int offset, UserAdminMasterBean bean)
			throws CustomException {
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<UserAdminMasterBean> empDataList = new ArrayList<UserAdminMasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (bean.getStatus1().equalsIgnoreCase("0")) {
				List<Map<String, Object>> rows = jdbcTemplate
						.queryForList(UserAdminMasterQueryUtil.SELECT_EMPLOYEE_LIST1);
				for (Map row : rows) {

					UserAdminMasterBean objEmployeeMasterBean = new UserAdminMasterBean();
					/*
					 * DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					 * String dob = df.format(row.get("dob")); String doj =
					 * df.format(row.get("doj"));
					 */
					objEmployeeMasterBean.setBranchName((String) row.get("branchName"));
					objEmployeeMasterBean.setCompanyName((String) row.get("companyName"));
					objEmployeeMasterBean.setDivisionName((String) row.get("divisionName"));
					objEmployeeMasterBean.setEmpId((String) row.get("empId"));
					objEmployeeMasterBean.setDonorCode((String) row.get("donorCode"));
					objEmployeeMasterBean.setFirstName((String) row.get("firstName"));
					objEmployeeMasterBean.setDepartmentCode((String) row.get("departmentCode"));
					objEmployeeMasterBean.setDepartmentName((String) row.get("departmentName"));
					objEmployeeMasterBean.setDesignationName((String) row.get("designationName"));
					objEmployeeMasterBean.setCusName((String) row.get("cusName"));
					objEmployeeMasterBean.setStatus((String) row.get("status"));
					objEmployeeMasterBean.setDob((String) row.get("dob"));
					objEmployeeMasterBean.setDoj((String) row.get("doj"));
					objEmployeeMasterBean.setVendor((String) row.get("vendor"));
					objEmployeeMasterBean.setCreatedBy((String) row.get("createdBy"));
					objEmployeeMasterBean.setCreatedDate((String) row.get("createdDate"));
					objEmployeeMasterBean.setModifiedBy((String) row.get("modifiedBy"));
					objEmployeeMasterBean.setModifiedDate((String) row.get("modifiedDate"));
					objEmployeeMasterBean.setUserlocation((String) row.get("userlocation"));
					objEmployeeMasterBean.setEmailId((String) row.get("emailId"));
					
					empDataList.add(objEmployeeMasterBean);
				}
			} else if (bean.getStatus1().equalsIgnoreCase("1")) {
				List<Map<String, Object>> rows = jdbcTemplate
						.queryForList(UserAdminMasterQueryUtil.SELECT_EMPLOYEE_LIST2);

				for (Map row : rows) {

					UserAdminMasterBean objEmployeeMasterBean = new UserAdminMasterBean();
					/*
					 * DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					 * String dob = df.format(row.get("dob")); String doj =
					 * df.format(row.get("doj"));
					 */
					objEmployeeMasterBean.setBranchName((String) row.get("branchName"));
					objEmployeeMasterBean.setCompanyName((String) row.get("companyName"));
					objEmployeeMasterBean.setDivisionName((String) row.get("divisionName"));
					objEmployeeMasterBean.setEmpId((String) row.get("empId"));
					objEmployeeMasterBean.setDonorCode((String) row.get("donorCode"));
					objEmployeeMasterBean.setFirstName((String) row.get("firstName"));
					objEmployeeMasterBean.setDepartmentCode((String) row.get("departmentCode"));
					objEmployeeMasterBean.setDepartmentName((String) row.get("departmentName"));
					objEmployeeMasterBean.setDesignationName((String) row.get("designationName"));
					objEmployeeMasterBean.setCusName((String) row.get("cusName"));
					objEmployeeMasterBean.setStatus((String) row.get("status"));
					objEmployeeMasterBean.setDob((String) row.get("dob"));
					objEmployeeMasterBean.setDoj((String) row.get("doj"));
					objEmployeeMasterBean.setVendor((String) row.get("vendor"));
					objEmployeeMasterBean.setCreatedBy((String) row.get("createdBy"));
					objEmployeeMasterBean.setCreatedDate((String) row.get("createdDate"));
					objEmployeeMasterBean.setModifiedBy((String) row.get("modifiedBy"));
					objEmployeeMasterBean.setModifiedDate((String) row.get("modifiedDate"));
					objEmployeeMasterBean.setUserlocation((String) row.get("userlocation"));
					objEmployeeMasterBean.setEmailId((String) row.get("emailId"));

					empDataList.add(objEmployeeMasterBean);
				}
			} else {
				List<Map<String, Object>> rows = jdbcTemplate
						.queryForList(UserAdminMasterQueryUtil.SELECT_EMPLOYEE_LIST3);
				for (Map row : rows) {

					UserAdminMasterBean objEmployeeMasterBean = new UserAdminMasterBean();
					/*
					 * DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					 * String dob = df.format(row.get("dob")); String doj =
					 * df.format(row.get("doj"));
					 */
					objEmployeeMasterBean.setBranchName((String) row.get("branchName"));
					objEmployeeMasterBean.setCompanyName((String) row.get("companyName"));
					objEmployeeMasterBean.setDivisionName((String) row.get("divisionName"));
					objEmployeeMasterBean.setEmpId((String) row.get("empId"));
					objEmployeeMasterBean.setDonorCode((String) row.get("donorCode"));
					objEmployeeMasterBean.setFirstName((String) row.get("firstName"));
					objEmployeeMasterBean.setDepartmentCode((String) row.get("departmentCode"));
					objEmployeeMasterBean.setDesignationName((String) row.get("designationName"));
					objEmployeeMasterBean.setCusName((String) row.get("cusName"));
					objEmployeeMasterBean.setStatus((String) row.get("status"));
					objEmployeeMasterBean.setDob((String) row.get("dob"));
					objEmployeeMasterBean.setDoj((String) row.get("doj"));
					objEmployeeMasterBean.setVendor((String) row.get("vendor"));
					objEmployeeMasterBean.setCreatedBy((String) row.get("createdBy"));
					objEmployeeMasterBean.setCreatedDate((String) row.get("createdDate"));
					objEmployeeMasterBean.setModifiedBy((String) row.get("modifiedBy"));
					objEmployeeMasterBean.setModifiedDate((String) row.get("modifiedDate"));
					objEmployeeMasterBean.setUserlocation((String) row.get("userlocation"));
					objEmployeeMasterBean.setEmailId((String) row.get("emailId"));

					empDataList.add(objEmployeeMasterBean);
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeeList", e);
			// throw new CustomException(PermissionRequestQueryUtil.ERROR_GET);
		}
		return empDataList;
	}

	@Override
	public UserAdminMasterResultBean getEmployeeById(String empId) throws CustomException {
		UserAdminMasterResultBean bean = new UserAdminMasterResultBean();
		List<UserAdminMasterBean> beans = new ArrayList<UserAdminMasterBean>();
		List<UserAdminMasterPhoneNoDetailBean> alPresentAddDetail = new ArrayList<UserAdminMasterPhoneNoDetailBean>();
		UserAdminMasterBean employeeBean = new UserAdminMasterBean();
		List<UserAdminMasterBean> objList = new ArrayList<UserAdminMasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { empId };
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Map row = jdbcTemplate.queryForMap(UserAdminMasterQueryUtil.SELECT_EMPLOYEE_BY_ID, params, types);

			String dob = null;
			String doj = null;
			if (row.get("doj") != null && row.get("doj") != "") {

				doj = df.format(row.get("doj"));
			}
			if (row.get("dob") != null && row.get("dob") != "") {
				dob = df.format(row.get("dob"));
			}

			String reldate = null;
			String confirmDate = "";
			String resignationDate = "";
			String employmentdate = null;

			boolean genderType = false;
			boolean overTime = false;
			boolean esiApp = false;
			boolean lateApp = false;
			boolean pfApp = false;
			boolean earlyExit = false;
			boolean leaveOption = false;

			String isActiveSight = "";
			String isActiveDumb = "";
			String isActiveHearing = "";
			String isActiveHand = "";
			String isActiveFeet = "";

			String gTyep = "";
			String nominateGender = "";
			
			
			if (row.get("createdBy") != null) {
				employeeBean.setCreatedBy((String) row.get("createdBy"));
			}
			
			if (row.get("createdDate") != null) {
				employeeBean.setCreatedDate((String) row.get("createdDate"));
			}
			
			if (row.get("modifiedBy") != null) {
				employeeBean.setModifiedBy((String) row.get("modifiedBy"));
			}
			
			if (row.get("modifiedDate") != null) {
				employeeBean.setModifiedDate((String) row.get("modifiedDate"));
			}
			

			if (row.get("empId") != null) {
				employeeBean.setEmpId((String) row.get("empId"));
			}
			if (row.get("firstName") != null) {
				employeeBean.setFirstName((String) row.get("firstName"));
			}
			if (row.get("middleName") != null) {
				employeeBean.setMiddleName((String) row.get("middleName"));
			}
			if (row.get("lastName") != null) {
				employeeBean.setLastName((String) row.get("lastName"));
			}
			if (row.get("gender") != null) {
				employeeBean.setGender((String) row.get("gender"));
			}

			if (row.get("genderName") != null) {
				employeeBean.setGenderName((String) row.get("genderName"));
			}

			if (row.get("branchName") != null) {
				employeeBean.setBranchName((String) row.get("branchName"));
			}

			if (row.get("active") != null) {
				employeeBean.setActive((String) row.get("active"));
			}
			
			if (row.get("deptContact") != null) {
				employeeBean.setDeptContact((Boolean)row.get("deptContact"));
			}


			if (row.get("designationName") != null) {
				employeeBean.setDesignationName((String) row.get("designationName"));
			}

			
			if (row.get("userlocation") != null) {
				employeeBean.setUserlocation((String) row.get("userlocation"));
			}
			if (dob != null) {
				employeeBean.setDob(dob);
			}
			if (doj != null) {
				employeeBean.setDoj(doj);

			}

			if (row.get("countryName") != null) {
				employeeBean.setCountryName((String) row.get("countryName"));
			}

			if (row.get("agentName") != null) {
				employeeBean.setAgentName((String) row.get("agentName"));
			}
			if (row.get("mobileNo") != null) {
				employeeBean.setMobileNo((String) row.get("mobileNo"));
			}
			if (row.get("emailId") != null) {
				employeeBean.setEmailId((String) row.get("emailId"));
			}
			if (row.get("uploadPhoto") != null) {
				employeeBean.setUploadPhoto(String.valueOf(row.get("uploadPhoto")));
			}

			if (row.get("departmentId") != null) {
				employeeBean.setDepartmentId(String.valueOf(row.get("departmentId").toString()));
			}
			if (row.get("designation") != null) {
				employeeBean.setDesignation(String.valueOf(row.get("designation").toString()));
			}

			if (row.get("status") != null) {
				employeeBean.setStatus(String.valueOf(row.get("status")));
			}

			if (row.get("pwd") != null) {

				employeeBean.setPwd(CipherCrypto.Decrypt((String) row.get("pwd")));
			}

			if (reldate != null) {
				employeeBean.setRelieveDate(reldate);
			} else {
				employeeBean.setRelieveDate(reldate);
			}

			if (employmentdate != null) {
				employeeBean.setEmploymentDate(employmentdate);
			} else {
				employeeBean.setEmploymentDate(employmentdate);
			}

			if (row.get("departmentCode") != null) {
				employeeBean.setDepartmentCode((String) row.get("departmentCode"));
			}

			if (row.get("companyName") != null) {
				employeeBean.setCompanyName((String) row.get("companyName"));
			}

			if (row.get("country") != null) {
				employeeBean.setCountry((String) row.get("country"));
			}

			if (row.get("vendor") != null) {
				employeeBean.setVendor((String) row.get("vendor"));
			}

			if (row.get("branchId") != null) {
				employeeBean.setBranchId((String) row.get("branchId"));

			}

			if (row.get("customerName") != null) {
				employeeBean.setCustomerName((String) row.get("customerName"));
			}

			employeeBean.setIsActiveSight(isActiveSight);
			employeeBean.setIsActiveDumb(isActiveDumb);
			employeeBean.setIsActiveHearing(isActiveHearing);
			employeeBean.setIsActiveHand(isActiveHand);
			employeeBean.setIsActiveFeet(isActiveFeet);

			if (row.get("companyCode") != null) {
				employeeBean.setCompanyCode(String.valueOf(row.get("companyCode")));
			}
			if (row.get("portCodes") != null) {
				employeeBean.setPortCodes(String.valueOf(row.get("portCodes")));
			}
			
			if (row.get("accesscodes") != null) {
				employeeBean.setAccesscodes(String.valueOf(row.get("accesscodes")));
			}
			
			if (row.get("vendorShow") != null) {
				employeeBean.setVendorShow(String.valueOf(row.get("vendorShow")));
			}
			employeeBean.setisEdit(true);
			bean.setBranchList(jdbcTemplate.query(UserAdminMasterQueryUtil.SELECT_BRANCH_LIST,
					new BeanPropertyRowMapper<UserAdminMasterBean>(UserAdminMasterBean.class)));

			beans.add(employeeBean);
			bean.setEditList(beans);
			bean.setBranchEditList(jdbcTemplate.query(UserAdminMasterQueryUtil.SELECT_BRANCH_EDIT__LIST,
					new BeanPropertyRowMapper<UserAdminMasterBean>(UserAdminMasterBean.class), empId));

			
			
			
			 List<Map<String, Object>> rows=null;
				
				
			    rows = jdbcTemplate.queryForList(UserAdminMasterQueryUtil.GET_FILE_PATH,
							new Object[] {empId});
			    
			    for (Map row1: rows) {
			    	UserAdminMasterBean objDetailBean= new UserAdminMasterBean();
					
			    	objDetailBean.setEmpId(row1.get("emp_id").toString());
			    	objDetailBean.setFilepath(row1.get("file_path").toString());
			    	objDetailBean.setFilename(row1.get("file_name").toString());
					objList.add(objDetailBean);
						
				}
			    employeeBean.setFiles1(objList);
			
			
			
			
			
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeById", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		// TODO Auto-generated method stub

		return bean;
	}

	@Override
	public synchronized UserAdminMasterResultBean insertEmployee(UserAdminMasterBean objEmployee)
			throws CustomException, IOException {
		boolean isSuccess = false;
		UserAdminMasterResultBean objEmployeeMasterResultBean = new UserAdminMasterResultBean();
		String accessCardNo = "";

		List<UserAdminDuplicateBean> duplicateData = objEmployee.getEmployeeDuplicateList();

		try {
			String employeeId = "";
			boolean status = false;
			int isPrimary = 1;
			int getProfileVal;
			int getEmployeeDuplicateVal;
			int getCompanyUser;
			if (objEmployee.getStatus().equals('Y')) {
				status = true;
			}
			String dob = objEmployee.getDob();
			String doj = objEmployee.getDoj();
			String relieveDate = objEmployee.getRelieveDate();
			String employeementDate = objEmployee.getEmploymentDate();

			DateFormat formatter;
			Date date = null, relievingDate = null, dateOFBirth = null, employMentDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			String comments = "New Employee" + " - " + strDate;
			String id;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			int checkEmail = jdbcTemplate.queryForObject(UserMasterQueryUtil.checkEmail, Integer.class,
					objEmployee.getEmailId());

			if (checkEmail == 0) {

				try {

					if (doj != null && doj != "" && !doj.equalsIgnoreCase("")) {
						date = formatter.parse(doj);
					}
					if (dob != null && dob != "" && !dob.equalsIgnoreCase("")) {
						dateOFBirth = formatter.parse(dob);
					} else {
						// date = formatter.parse("");
					}

					if (objEmployee.getEmploymentDate() != null
							&& !objEmployee.getEmploymentDate().equalsIgnoreCase("")) {
						employMentDate = formatter.parse(employeementDate);
					}

					if (objEmployee.getRelieveDate() != null && !objEmployee.getRelieveDate().equalsIgnoreCase("")) {
						relievingDate = formatter.parse(relieveDate);
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// objEmployee.setBranchId(jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.GETBRANCHID,String.class,objEmployee.getCompanyCode()));
				accessCardNo = "test01";
				if (objEmployee.getBranchId() == null) {
					objEmployee.setBranchId("");
				}
				if (objEmployee.getDepartmentId() == null || objEmployee.getDepartmentId() == "") {
					objEmployee.setDepartmentId("DP001");
				}
				if (objEmployee.getGrade() == null) {
					objEmployee.setGrade(1);
				}
				if (objEmployee.getDesignation() == null || objEmployee.getDesignation() == "") {
					objEmployee.setDesignation("DS001");
				}

				 employeeId = jdbcTemplate.queryForObject(UserAdminMasterQueryUtil.GET_MAX_EMPLOYEE_ID,
						String.class);
				//String brnch=jdbcTemplate.queryForObject(UserAdminMasterQueryUtil.brn_id,
				//			String.class,objEmployee.getBranchId());
				String	brnch=objEmployee.getBranchId();
				UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				Map<String, Object> empMap = new HashMap<String, Object>();
				objEmployee.setEmpId(employeeId);
				empMap.put("empId", objEmployee.getEmpId());
				empMap.put("reportMangrId", objEmployee.getReportMangrId());
				empMap.put("accessCardNo", accessCardNo);
				empMap.put("firstName", objEmployee.getFirstName());
				empMap.put("middleName", objEmployee.getMiddleName());
				empMap.put("lastName", objEmployee.getLastName());
				empMap.put("gender", objEmployee.getGender());
				empMap.put("dob", dateOFBirth);
				empMap.put("doj", date);
				empMap.put("mobileNo", objEmployee.getMobileNo());
				empMap.put("emailId", objEmployee.getEmailId());
				empMap.put("uploadPhoto", objEmployee.getUploadPhoto());
				empMap.put("designation", objEmployee.getDesignation());
				empMap.put("departmentId", objEmployee.getDepartmentId());
				empMap.put("grade", objEmployee.getGrade());
				empMap.put("division", objEmployee.getDivision());
				empMap.put("companyCode", objEmployee.getCompanyCode());

				empMap.put("pwd", CipherCrypto.Encrypt(objEmployee.getPwd()));
				empMap.put("typeOfEmp", objEmployee.getTypeOfEmp());
				empMap.put("epfNo", objEmployee.getEpfNo());
				empMap.put("esic", objEmployee.getEsic());
				empMap.put("fixedGross", objEmployee.getFixedGross());
				empMap.put("relieveDate", relievingDate);
				// empMap.put("category", objEmployee.getCategory());
				// empMap.put("secondLevel", objEmployee.getSecondLevel());
				empMap.put("donorCode", objEmployee.getDonorCode());
				// empMap.put("principal", objEmployee.isPrincipal());
				// empMap.put("ms", objEmployee.isMs());

				empMap.put("status", objEmployee.getStatus());
				empMap.put("isEmailExempted", objEmployee.getIsEmailExempted());

				empMap.put("empname", objEmployee.getFirstName() + " " + objEmployee.getLastName());

				empMap.put("loginFlag", 'E');
				empMap.put("saright", 'Y');
				empMap.put("branchId", brnch);
				empMap.put("insuranceNo", objEmployee.getInsuranceNo());
				empMap.put("empUserId", objEmployee.getEmpUserId());
				empMap.put("uan", objEmployee.getUan());
				empMap.put("createdBy", userDtl.getUserId());
				empMap.put("vendor", objEmployee.getVendor());
				empMap.put("country", objEmployee.getCountry());
				
				empMap.put("userlocation", objEmployee.getUserlocation());

				empMap.put("customerName", objEmployee.getCustomerName());
				empMap.put("port", objEmployee.getPortCodes());
				empMap.put("accessCat", objEmployee.getAccesscodes());
				
				empMap.put("deptContact", objEmployee.isDeptContact());

				if (objEmployee.getTypeOfEmp() == null) {
					objEmployee.setTypeOfEmp(1);
				}
				if (objEmployee.getTypeOfEmp() == 1) {
					empMap.put("employmentDate", employMentDate);
				} else {
					empMap.put("employmentDate", null);
				}
				int count = jdbcTemplate.queryForObject(UserAdminMasterQueryUtil.COUNT_USERID,
						new Object[] { objEmployee.getEmpUserId() }, Integer.class);

				NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
				getProfileVal = namedParameterJdbcTemplate.update(UserAdminMasterQueryUtil.INSERT_USER, empMap);

				/*
				 * getProfileVal = namedParameterJdbcTemplate.update(
				 * UserAdminMasterQueryUtil.INSERT_USERMASTER, empMap);
				 */

				// int j =
				// jdbcTemplate.update(EmpMasterQueryUtil.USERS_PASSWORD_LOGS,
				// objEmployee.getEmpId(), objEmployee.getPwd() );

				objEmployee.setTableName("employee_master");
				objEmployee.setFormCode("F037");
				String Id = jdbcTemplate.queryForObject(UserAdminMasterQueryUtil.SELECT_PREVIOUS_ID, String.class);
				UserLog userLog = userlogDao.userLogForInsert(objEmployee, Id, userDtl.getUserId());
				objEmployeeMasterResultBean.setSuccess(true);
				objEmployeeMasterResultBean.setEmployeeId(Id);
					if(getProfileVal > 0) {
						
				 customerMail(objEmployee);
						}

			} else {
				objEmployeeMasterResultBean.setSuccess(false);
				objEmployeeMasterResultBean.setStatus(302);
			}
			userMasterService.insertUserToUser("E0001", employeeId, objEmployee.getCompanyCode());
		} catch (Exception e) {
			objEmployeeMasterResultBean.setSuccess(false);
			LOGGER.error("Error in Employee Add", e);
			e.printStackTrace();
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return objEmployeeMasterResultBean;
	}

	@Override
	public boolean updateEmployee(UserAdminMasterBean employeeMasterBean) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		int getProfileVal;
		int getEmployeeDuplicateVal;
		int presentAddressId;
		List<UserAdminMasterPhoneNoDetailBean> alPresentAddDetail = new ArrayList<UserAdminMasterPhoneNoDetailBean>();
		List<UserAdminDuplicateBean> duplicateData = employeeMasterBean.getEmployeeDuplicateList();

		try {
			boolean status = false;
			if (employeeMasterBean.getStatus().equals("Y")) {
				status = true;
			}

			String dob = employeeMasterBean.getDob();
			String doj = employeeMasterBean.getDoj();
			String relieveDate = employeeMasterBean.getRelieveDate();
			String employeementDate = employeeMasterBean.getEmploymentDate();

			DateFormat formatter;
			Date date = null, relievingDate = null, dateOFBirth = null, employMentDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			String comments = "Profile Update" + " - " + strDate;

			try {

				if (doj != null && !doj.equalsIgnoreCase("") && !doj.equalsIgnoreCase("01/01/0001")) {
					date = formatter.parse(doj);
				}
				if (dob != null && !dob.equalsIgnoreCase("")) {
					dateOFBirth = formatter.parse(dob);
				}

				if (employeeMasterBean.getEmploymentDate() != null
						&& !employeeMasterBean.getEmploymentDate().equalsIgnoreCase("")) {
					employMentDate = formatter.parse(employeementDate);
				}

				if (employeeMasterBean.getRelieveDate() != null
						&& !employeeMasterBean.getRelieveDate().equalsIgnoreCase("")) {
					relievingDate = formatter.parse(relieveDate);
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if (employeeMasterBean.getVendor() == null) {
				employeeMasterBean.setCustomerName("");
			}
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("reportMangrId", employeeMasterBean.getReportMangrId());
			empMap.put("accessCardNo", employeeMasterBean);
			empMap.put("firstName", employeeMasterBean.getFirstName());
			empMap.put("middleName", employeeMasterBean.getMiddleName());
			empMap.put("lastName", employeeMasterBean.getLastName());
			empMap.put("gender", employeeMasterBean.getGender());
			empMap.put("dob", dateOFBirth);
			empMap.put("doj", date);
			empMap.put("mobileNo", employeeMasterBean.getMobileNo());
			empMap.put("emailId", employeeMasterBean.getEmailId());
			empMap.put("uploadPhoto", employeeMasterBean.getUploadPhoto());
			empMap.put("designation", employeeMasterBean.getDesignation());
			empMap.put("departmentId", employeeMasterBean.getDepartmentId());
			empMap.put("grade", employeeMasterBean.getGrade());
			empMap.put("companyCode", employeeMasterBean.getCompanyCode());

			// empMap.put("pwd",
			// CipherCrypto.Encrypt(employeeMasterBean.getPwd()));
			empMap.put("typeOfEmp", employeeMasterBean.getTypeOfEmp());
			empMap.put("epfNo", employeeMasterBean.getEpfNo());
			empMap.put("esic", employeeMasterBean.getEsic());
			empMap.put("fixedGross", employeeMasterBean.getFixedGross());
			empMap.put("relieveDate", relievingDate);
			// empMap.put("category", objEmployee.getCategory());
			// empMap.put("secondLevel", objEmployee.getSecondLevel());
			empMap.put("donorCode", employeeMasterBean.getDonorCode());
			// empMap.put("principal", objEmployee.isPrincipal());
			// empMap.put("ms", objEmployee.isMs());

			empMap.put("status", employeeMasterBean.getStatus());
			empMap.put("isEmailExempted", employeeMasterBean.getIsEmailExempted());

			empMap.put("empname", employeeMasterBean.getFirstName() + " " + employeeMasterBean.getLastName());

			empMap.put("loginFlag", 'E');
			empMap.put("saright", 'Y');
			empMap.put("branchId", employeeMasterBean.getBranchId());
			empMap.put("insuranceNo", employeeMasterBean.getInsuranceNo());
			empMap.put("empUserId", employeeMasterBean.getEmpUserId());
			empMap.put("uan", employeeMasterBean.getUan());
			empMap.put("createdBy", userDtl.getUserId());
			empMap.put("vendor", employeeMasterBean.getVendor());
			empMap.put("country", employeeMasterBean.getCountry());
			empMap.put("customerName", employeeMasterBean.getCustomerName());
			empMap.put("port", employeeMasterBean.getPortCodes());
			empMap.put("deptContact", employeeMasterBean.isDeptContact());
			
			empMap.put("accessCat", employeeMasterBean.getAccesscodes());
			
			empMap.put("userlocation", employeeMasterBean.getUserlocation());

			empMap.put("modifiedBy", userDtl.getUserId());

			
			empMap.put("employmentDate", null);

			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			try {
				UserAdminMasterResultBean oldlocationBean = getEmployeeById(employeeMasterBean.getEmpId());

				String empName = jdbcTemplate.queryForObject(UserAdminMasterQueryUtil.getEmployee, String.class,
						employeeMasterBean.getEmpId());
				if (employeeMasterBean.getEmpId().equals(empName)) {

					boolean status1 = false;
					if (employeeMasterBean.getStatus().equals("Y")) {
						status1 = true;
					}
					getProfileVal = namedParameterJdbcTemplate.update(UserAdminMasterQueryUtil.UPDATE_EMPLOYEE, empMap);

					/*
					 * namedParameterJdbcTemplate
					 * .update(UserAdminMasterQueryUtil.UPDATE_EMPLOYEE_MASTER,
					 * empMap);
					 */
					// int k =
					// jdbcTemplate.update(EmpMasterQueryUtil.UPDATE_USERS_PASSWORD_LOGS,new
					// Object[] {
					// CipherCrypto.Encrypt(employeeMasterBean.getPwd()),employeeMasterBean.getEmpId()
					// });

					isSuccess = true;
					employeeMasterBean.setTableName("employee_master");
					employeeMasterBean.setFormCode("F5031");
					UserLog userLog = userlogDao.userLogForUpdate(oldlocationBean.getEditList().get(0),
							employeeMasterBean, employeeMasterBean.getEmpId() + "", userDtl.getUserId());

					if (getProfileVal == 1) {
						for (int j = 0; j < duplicateData.size(); j++) {

							HashMap<String, Object> employeeDuplicateSubMap = new HashMap<String, Object>();
							employeeDuplicateSubMap.put("empId", employeeMasterBean.getEmpId());
							employeeDuplicateSubMap.put("employmentDate", employMentDate);
							employeeDuplicateSubMap.put("columnName", duplicateData.get(j).getColumnName());
							employeeDuplicateSubMap.put("oldValue", duplicateData.get(j).getOldValue());
							employeeDuplicateSubMap.put("newValue", duplicateData.get(j).getNewValue());
							employeeDuplicateSubMap.put("comments", comments);

							if (duplicateData.get(j).isActive() == true) {
								getEmployeeDuplicateVal = namedParameterJdbcTemplate.update(
										UserAdminMasterQueryUtil.INSERT_EMPLOYEE_DUPLICATE_SUBDATA,
										employeeDuplicateSubMap);
							}

						}
					}
				} else {
					int rowCount = jdbcTemplate.queryForObject(UserAdminMasterQueryUtil.COUNT_USERID,
							new Object[] { employeeMasterBean.getEmpId() }, Integer.class);

					if (rowCount > 0) {
						throw new CustomException(ErrorMessage.NAME_ALREADY_EXISTS);
					} else {
						boolean status1 = false;
						if (employeeMasterBean.getStatus().equals("Y")) {
							status1 = true;
						}
						getProfileVal = namedParameterJdbcTemplate.update(UserAdminMasterQueryUtil.UPDATE_EMPLOYEE,
								empMap);

						isSuccess = true;
						employeeMasterBean.setTableName("employee_master");
						employeeMasterBean.setFormCode("F5031");
						UserLog userLog = userlogDao.userLogForUpdate(oldlocationBean.getEditList().get(0),
								employeeMasterBean, employeeMasterBean.getEmpId() + "", userDtl.getUserId());

					}

				}

			} catch (DataAccessException e) {
				LOGGER.error("Error in updateDesignation", e);

			}

		} catch (Exception e) {
			isSuccess = false;
			LOGGER.error("Error in update Employee", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean deleteEmployee(String empId) throws CustomException {
		boolean isSuccess = false;
		int val = 0;
		int getEmpId, i;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserAdminMasterResultBean oldbean = getEmployeeById(empId);

			UserAdminMasterBean employeeMasterBean = new UserAdminMasterBean();

			jdbcTemplate.update(UserAdminMasterQueryUtil.DELETE_EMPLOYEE_EMPLOYEE, empId);
			jdbcTemplate.update(UserAdminMasterQueryUtil.DELETE_EMPLOYEE_USERMASTER, empId);
			val = jdbcTemplate.update(EmpmasterQueryUtil.Delete_SQL_Password, empId);

			isSuccess = true;

			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			UserLog userLog = userlogDao.userLogForDelete(oldbean, empId, userDetails.getUserId());

		} catch (DataAccessException e) {
			LOGGER.error("Error in delete Employee", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public UserAdminMasterResultBean getCompanyList() throws CustomException {
		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		List<UserAdminMasterBean> companyList = new ArrayList<UserAdminMasterBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			companyList = jdbcTemplate.query(UserAdminMasterQueryUtil.SELECT_COMPANY_LIST,
					new BeanPropertyRowMapper<UserAdminMasterBean>(UserAdminMasterBean.class));
			employeeMasterResultBean.setCompanyList(companyList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public UserAdminMasterResultBean getBranchList() throws CustomException {
		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		List<UserAdminMasterBean> branchList = new ArrayList<UserAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			branchList = jdbcTemplate.query(UserAdminMasterQueryUtil.SELECT_BRANCH_LIST,
					new BeanPropertyRowMapper<UserAdminMasterBean>(UserAdminMasterBean.class));
			employeeMasterResultBean.setBranchList(branchList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getBranchList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	// department

	@Override
	public UserAdminMasterResultBean getDepartmentList() throws CustomException {

		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		List<UserAdminMasterBean> departmentList = new ArrayList<UserAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			departmentList = jdbcTemplate.query(UserAdminMasterQueryUtil.SELECT_DEPARTMENT_LIST,
					new BeanPropertyRowMapper<UserAdminMasterBean>(UserAdminMasterBean.class));
			employeeMasterResultBean.setDepartmentList(departmentList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDepartmentList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public UserAdminMasterResultBean getDesignationList() throws CustomException {
		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		List<UserAdminMasterBean> designationList = new ArrayList<UserAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			designationList = jdbcTemplate.query(UserAdminMasterQueryUtil.SELECT_DESIGNATION_LIST,
					new BeanPropertyRowMapper<UserAdminMasterBean>(UserAdminMasterBean.class));
			employeeMasterResultBean.setDesignationList(designationList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDesignationList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public UserAdminMasterResultBean viewEmployeeById(String empId) throws CustomException {
		UserAdminMasterResultBean bean = new UserAdminMasterResultBean();
		List<UserAdminMasterBean> beans = new ArrayList<UserAdminMasterBean>();
		List<UserAdminMasterPhoneNoDetailBean> alPresentAddDetail = new ArrayList<UserAdminMasterPhoneNoDetailBean>();
		UserAdminMasterBean employeeBean = new UserAdminMasterBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { empId };
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Map row = jdbcTemplate.queryForMap(UserAdminMasterQueryUtil.SELECT_EMPLOYEE_BY_ID, params, types);
			List<UserAdminMasterPersonalBean> lPersonalBean = jdbcTemplate.query(
					UserAdminMasterQueryUtil.SELET_EMP_PERSONAL_ID, new Object[] { empId },
					new BeanPropertyRowMapper<UserAdminMasterPersonalBean>(UserAdminMasterPersonalBean.class));
			List<UserAdminFamilyBean> lFamilyBean = jdbcTemplate.query(UserAdminMasterQueryUtil.SELECT_FAMILY_BY_ID,
					new Object[] { empId }, new BeanPropertyRowMapper<UserAdminFamilyBean>(UserAdminFamilyBean.class));
			List<UserAdminEducationBean> lEducationBean = jdbcTemplate.query(
					UserAdminMasterQueryUtil.SELECT_EDUCATION_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<UserAdminEducationBean>(UserAdminEducationBean.class));
			List<UserMAsterPerDetailsBean> lpersonalDetailBean = jdbcTemplate.query(
					UserMasterQueryUtil.SELET_EMP_PER_DETAIL_ID, new Object[] { empId },
					new BeanPropertyRowMapper<UserMAsterPerDetailsBean>(UserMAsterPerDetailsBean.class));
			List<UserMasterPhysicalBean> lphysicalBean = jdbcTemplate.query(
					UserAdminMasterQueryUtil.SELET_EMP_PHYSICAL_ID, new Object[] { empId },
					new BeanPropertyRowMapper<UserMasterPhysicalBean>(UserMasterPhysicalBean.class));
			List<UserAdminExperianceBean> lExperianceBean = jdbcTemplate.query(
					UserAdminMasterQueryUtil.SELECT_EXPERIENCE_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<UserAdminExperianceBean>(UserAdminExperianceBean.class));
			List<UserAdminMeritsBean> lMeritsBean = jdbcTemplate.query(UserAdminMasterQueryUtil.SELECT_MERITS_BY_ID,
					new Object[] { empId }, new BeanPropertyRowMapper<UserAdminMeritsBean>(UserAdminMeritsBean.class));
			List<UserAdminReferanceBean> lRefBean = jdbcTemplate.query(UserAdminMasterQueryUtil.SELET_EMP_REF_ID,
					new Object[] { empId },
					new BeanPropertyRowMapper<UserAdminReferanceBean>(UserAdminReferanceBean.class));
			List<UserAdminDuplicateBean> lHistoryBean = jdbcTemplate.query(
					UserAdminMasterQueryUtil.SELET_EMP_DUPLICATE_ID, new Object[] { empId },
					new BeanPropertyRowMapper<UserAdminDuplicateBean>(UserAdminDuplicateBean.class));
			bean.setEmployeeFamilyBeanList(lFamilyBean);
			bean.setEmployeeEducationBeanList(lEducationBean);
			bean.setEmployeePersonalBeanList(lPersonalBean);
			bean.setEmployeeMAsterPerDetailsBeanList(lpersonalDetailBean);
			bean.setEmployeeMasterPhysicalBeanBeanList(lphysicalBean);
			bean.setEmployeeExperianceList(lExperianceBean);
			bean.setEmployeeMeritsBeanList(lMeritsBean);
			bean.setEmployeeReferanceBeanList(lRefBean);
			bean.setEmployeeDuplicateList(lHistoryBean);
			String dob = df.format(row.get("dob"));
			String doj = df.format(row.get("doj"));
			String reldate = null;
			String confirmDate = "";
			String resignationDate = "";
			String employmentdate = null;
			if (row.get("relieveDate") != null) {
				reldate = df.format(row.get("relieveDate"));
			}
			if (row.get("employmentDate") != null) {
				employmentdate = df.format(row.get("employmentDate"));
			}
			if (row.get("confirmDate") != null) {
				confirmDate = df.format(row.get("confirmDate"));
			} else {
				confirmDate = null;
			}

			if (row.get("resignationDate") != null) {
				resignationDate = df.format(row.get("resignationDate"));
			} else {
				resignationDate = null;
			}

			String isActiveCash = "";

			if (row.get("confirmDate") != null) {
				confirmDate = df.format(row.get("confirmDate"));
			} else {
				confirmDate = null;
			}

			if (row.get("resignationDate") != null) {
				resignationDate = df.format(row.get("resignationDate"));
			} else {
				resignationDate = null;
			}

			String nomdateOfBirth = "";
			if (row.get("nomdateOfBirth") != null) {
				nomdateOfBirth = df.format(row.get("nomdateOfBirth"));
			} else {
				nomdateOfBirth = null;
			}
			String issuedDate = "";
			if (row.get("issuedDate") != null) {
				issuedDate = df.format(row.get("issuedDate"));
			} else {
				issuedDate = null;
			}

			String expiryDate = "";
			if (row.get("expiryDate") != null) {
				expiryDate = df.format(row.get("expiryDate"));
			} else {
				expiryDate = null;
			}

			String licenseIssuedDate = "";
			if (row.get("licenseIssuedDate") != null) {
				licenseIssuedDate = df.format(row.get("licenseIssuedDate"));
			} else {
				licenseIssuedDate = null;
			}

			String licenseexpiryDate = "";
			if (row.get("licenseexpiryDate") != null) {
				licenseexpiryDate = df.format(row.get("licenseexpiryDate"));
			} else {
				licenseexpiryDate = null;
			}

			String renewalDate = "";
			if (row.get("renewalDate") != null) {
				renewalDate = df.format(row.get("renewalDate"));
			} else {
				renewalDate = null;
			}

			String visaExpiryDate = "";
			if (row.get("visaExpiryDate") != null) {
				visaExpiryDate = df.format(row.get("visaExpiryDate"));
			} else {
				visaExpiryDate = null;
			}

			String visaIssuedDate = "";
			if (row.get("visaIssuedDate") != null) {
				visaIssuedDate = df.format(row.get("visaIssuedDate"));
			} else {
				visaIssuedDate = null;
			}

			if (row.get("marritalStatus") != null) {
				employeeBean.setMarritalStatus((boolean) row.get("marritalStatus"));
			}

			boolean genderType = false;
			boolean overTime = false;
			boolean esiApp = false;
			boolean lateApp = false;
			boolean pfApp = false;
			boolean earlyExit = false;
			boolean leaveOption = false;

			String isActiveSight = "";
			String isActiveDumb = "";
			String isActiveHearing = "";
			String isActiveHand = "";
			String isActiveFeet = "";

			if (row.get("overTime") != null) {
				if ((boolean) row.get("overTime") == true) {
					overTime = true;
				} else {
					overTime = false;
				}
			}
			if (row.get("esiApp") != null) {
				if ((boolean) row.get("esiApp") == true) {
					esiApp = true;
				} else {
					esiApp = false;
				}
			}
			if (row.get("lateApp") != null) {
				if ((boolean) row.get("lateApp") == true) {
					lateApp = true;
				} else {
					lateApp = false;
				}
			}
			if (row.get("pfApp") != null) {
				if ((boolean) row.get("pfApp") == true) {
					pfApp = true;
				} else {
					pfApp = false;
				}
			}
			if (row.get("earlyExit") != null) {
				if ((boolean) row.get("earlyExit") == true) {
					earlyExit = true;
				} else {
					earlyExit = false;
				}
			}
			if (row.get("leaveOption") != null) {
				if ((boolean) row.get("leaveOption") == true) {
					leaveOption = true;
				} else {
					leaveOption = false;
				}
			}

			if (row.get("isActiveSight") != null) {
				if ((boolean) row.get("isActiveSight") == true) {
					isActiveSight = "Y";
				} else {
					isActiveSight = "N";
				}
			}

			if (row.get("isActiveDumb") != null) {
				if ((boolean) row.get("isActiveDumb") == true) {
					isActiveDumb = "Y";
				} else {
					isActiveDumb = "N";
				}
			}

			if (row.get("isActiveHearing") != null) {
				if ((boolean) row.get("isActiveHearing") == true) {
					isActiveHearing = "Y";
				} else {
					isActiveHearing = "N";
				}
			}

			if (row.get("isActiveHand") != null) {
				if ((boolean) row.get("isActiveHand") == true) {
					isActiveHand = "Y";
				} else {
					isActiveHand = "N";
				}
			}

			if (row.get("isActiveFeet") != null) {
				if ((boolean) row.get("isActiveFeet") == true) {
					isActiveFeet = "Y";
				} else {
					isActiveFeet = "N";
				}
			}

			String gTyep = "";
			String nominateGender = "";

			if (row.get("genderType") != null) {
				if ((boolean) row.get("genderType") == true) {
					gTyep = "Male";
				} else if ((boolean) row.get("genderType") == false) {
					gTyep = "Female";
				}
			} else
				gTyep = "Select";

			if (row.get("nominateGender") != null) {
				if ((boolean) row.get("nominateGender") == true) {
					nominateGender = "Male";
				} else if ((boolean) row.get("nominateGender") == false) {
					nominateGender = "Female";
				}
			} else
				nominateGender = "Select";

			
			
		
			
			
			
			if (row.get("empId") != null) {
				employeeBean.setEmpId((String) row.get("empId"));
			}
			if (row.get("firstName") != null) {
				employeeBean.setFirstName((String) row.get("firstName"));
			}
			if (row.get("middleName") != null) {
				employeeBean.setMiddleName((String) row.get("middleName"));
			}
			if (row.get("lastName") != null) {
				employeeBean.setLastName((String) row.get("lastName"));
			}
			if (row.get("gender") != null) {
				employeeBean.setGender((String) row.get("gender"));
			}
			if (dob != null) {
				employeeBean.setDob(dob);
			}
			if (row.get("insuranceNo") != null) {
				employeeBean.setInsuranceNo((String) row.get("insuranceNo"));
			}
			if (doj != null) {
				employeeBean.setDoj(doj);
			}
			if (row.get("mobileNo") != null) {
				employeeBean.setMobileNo((String) row.get("mobileNo"));
			}
			if (row.get("emailId") != null) {
				employeeBean.setEmailId((String) row.get("emailId"));
			}
			if (row.get("uploadPhoto") != null) {
				employeeBean.setUploadPhoto(String.valueOf(row.get("uploadPhoto")));
			}

			if (row.get("departmentId") != null) {
				employeeBean.setDepartmentId(String.valueOf(row.get("departmentId").toString()));
			}
			if (row.get("designation") != null) {
				employeeBean.setDesignation(String.valueOf(row.get("designation").toString()));
			}
			if (row.get("isEmailExempted") != null) {
				employeeBean.setIsEmailExempted(String.valueOf(row.get("isEmailExempted")));
			}
			if (row.get("status") != null) {
				employeeBean.setStatus(String.valueOf(row.get("status")));
			}
			if (row.get("grade") != null) {
				employeeBean.setGrade(Integer.valueOf(row.get("grade").toString()));
			}
			if (row.get("division") != null) {
				employeeBean.setDivision(Integer.valueOf(row.get("division").toString()));
			}
			if (row.get("pwd") != null) {

				employeeBean.setPwd(CipherCrypto.Decrypt((String) row.get("pwd")));
			}
			if (row.get("typeOfEmp") != null) {
				employeeBean.setTypeOfEmp(Integer.valueOf(row.get("typeOfEmp").toString()));
			}
			if (row.get("epfNo") != null) {
				employeeBean.setEpfNo((String) row.get("epfNo"));
			}

			if (row.get("esic") != null) {
				employeeBean.setEsic((String) row.get("esic"));
			}

			if (row.get("uan") != null) {
				employeeBean.setUan((String) row.get("uan"));
			}

			if (reldate != null) {
				employeeBean.setRelieveDate(reldate);
			} else {
				employeeBean.setRelieveDate(reldate);
			}

			if (employmentdate != null) {
				employeeBean.setEmploymentDate(employmentdate);
			} else {
				employeeBean.setEmploymentDate(employmentdate);
			}

			if (row.get("fixedGross") != null) {
				employeeBean.setFixedGross(Double.valueOf(row.get("fixedGross").toString()));
			}
			if (row.get("donorCode") != null) {
				employeeBean.setDonorCode((String) row.get("donorCode"));
			}
			if (row.get("departmentCode") != null) {
				employeeBean.setDepartmentCode((String) row.get("departmentCode"));
			}
			if (row.get("designationName") != null) {
				employeeBean.setDesignationName((String) row.get("designationName"));
			}
			if (row.get("empTypeName") != null) {
				employeeBean.setEmpTypeName((String) row.get("empTypeName"));
			}
			if (row.get("gradeName") != null) {
				employeeBean.setGradeName((String) row.get("gradeName"));
			}
			if (row.get("divisionName") != null) {
				employeeBean.setDivisionName((String) row.get("divisionName"));
			}
			if (row.get("reportMangrId") != null) {
				employeeBean.setReportMangrId((String) row.get("reportMangrId"));
			}
			if (row.get("reportBranch") != null) {
				employeeBean.setReportToBranch((String) row.get("reportBranch"));
			}
			if (row.get("reportDesigId") != null) {
				employeeBean.setReportDesigId((String) row.get("reportDesigId"));
			}
			if (row.get("reportToBranchName") != null) {
				employeeBean.setReportToBranchName((String) row.get("reportToBranchName"));
			}
			if (row.get("branchName") != null) {
				employeeBean.setBranchName((String) row.get("branchName"));
			}
			if (row.get("companyName") != null) {
				employeeBean.setCompanyName((String) row.get("companyName"));
			}
			if (row.get("customerId") != null) {
				employeeBean.setCustomerId((int) row.get("customerId"));
			}
			if (row.get("empUserId") != null) {
				employeeBean.setEmpUserId((String) row.get("empUserId"));
			}

			/*
			 * employeeBean.setReportToBranchName((String)
			 * row.get("reportToBranchName"));
			 * employeeBean.setBranchName((String) row.get("branchName"));
			 * employeeBean.setCompanyName((String) row.get("companyName"));
			 * employeeBean.setCustomerId((int) row.get("customerId"));
			 * employeeBean.setEmpUserId((String) row.get("empUserId"));
			 */
			if (row.get("reportDeptId") != null) {
				// if ((int) row.get("reportDeptId") != 0) {
				employeeBean.setReportDeptId(row.get("reportDeptId").toString());
				// }
			} else {
				employeeBean.setReportDeptId("0");
			}

			if (row.get("reportToDept") != null) {
				employeeBean.setReportToDept((String) row.get("reportToDept"));
			}
			if (row.get("reportToDesig") != null) {
				employeeBean.setReportToDesig((String) row.get("reportToDesig"));
			}
			if (row.get("reportManagerName") != null) {
				employeeBean.setReportManagerName((String) row.get("reportManagerName"));
			}
			if (row.get("marritalStatus") != null) {
				employeeBean.setMarritalStatus((boolean) row.get("marritalStatus"));
			}

			if (row.get("guardianName") != null) {
				employeeBean.setGuardianName((String) row.get("guardianName"));
			}
			if (row.get("motherName") != null) {
				employeeBean.setMotherName((String) row.get("motherName"));
			}

			if (row.get("guardiansName") != null) {
				employeeBean.setGuardiansName((String) row.get("guardiansName"));
			}
			if (row.get("bloodGrp") != null) {
				employeeBean.setBloodGrp((String) row.get("bloodGrp"));
			}
			if (row.get("caste") != null) {
				employeeBean.setCaste((String) row.get("caste"));
			}
			if (row.get("religion") != null) {
				employeeBean.setReligion((String) row.get("religion"));
			}
			if (row.get("motherTongue") != null) {
				employeeBean.setMotherTongue((String) row.get("motherTongue"));
			}
			if (row.get("nationality") != null) {
				employeeBean.setNationality((String) row.get("nationality"));
			}
			if (row.get("panNo") != null) {
				employeeBean.setPanNo((String) row.get("panNo"));
			}

			if (row.get("aadharno") != null) {
				employeeBean.setAadharno((String) row.get("aadharno"));
			}
			if (row.get("gratuityNominee") != null) {
				employeeBean.setGratuityNominee((String) row.get("gratuityNominee"));
			}
			if (row.get("nomineeRelation") != null) {
				employeeBean.setNomineeRelation((String) row.get("nomineeRelation"));
			}
			if (row.get("modeConveyence") != null) {
				employeeBean.setModeConveyence((String) row.get("modeConveyence"));
			}
			if (row.get("emgContactNo") != null) {
				employeeBean.setEmgContactNo((String) row.get("emgContactNo"));
			}
			if (row.get("emgContactName") != null) {
				employeeBean.setEmgContactName((String) row.get("emgContactName"));
			}
			if (row.get("noticePeriod") != null) {
				employeeBean.setNoticePeriod(Integer.valueOf(row.get("noticePeriod").toString()));
			}
			if (row.get("remarks") != null) {
				employeeBean.setRemarks((String) row.get("remarks"));
			}
			if (row.get("hobbies") != null) {
				employeeBean.setHobbies((String) row.get("hobbies"));
			}
			if (confirmDate != null) {

				employeeBean.setConfirmDate(confirmDate);
				/* } */
				/* if (resignationDate != null) { */
				employeeBean.setResignationDate(resignationDate);
				/* } */
				/* if (relieveDate != null) { */
				// employeeBean.setRelieveDate(relieveDate);
				/* } */
				/*
				 * if (row.get("languages") != null) {
				 * employeeBean.setLanguages((String) row.get("languages")); }
				 * /* if (row.get("race") != null) {
				 * employeeBean.setRace((String) row.get("race")); }
				 */

				if (row.get("confirmationPeriod") != null) {
					employeeBean.setConfirmationPeriod(Integer.valueOf(row.get("confirmationPeriod").toString()));
				}
				if (row.get("husbWifeName") != null) {
					employeeBean.setHusbWifeName((String) row.get("husbWifeName"));
				}
				if (row.get("permState") != null) {
					employeeBean.setPermState((String) row.get("permState"));
				}
				if (row.get("permAddress") != null) {
					employeeBean.setPermAddress((String) row.get("permAddress"));
				}
				if (row.get("permPlace") != null) {
					employeeBean.setPermPlace((String) row.get("permPlace"));
				}
				if (row.get("permDistrict") != null) {
					employeeBean.setPermDistrict((String) row.get("permDistrict"));
				}
				if (row.get("permPin") != null) {
					employeeBean.setPermPin((String) row.get("permPin"));
				}
				if (row.get("permPhone") != null) {
					employeeBean.setPermPhone((String) row.get("permPhone"));
				}
				if (row.get("permMobile") != null) {
					employeeBean.setPermMobile((String) row.get("permMobile"));
				}

				if (row.get("familyName") != null) {
					employeeBean.setFamilyName((String) row.get("familyName"));
				}

				employeeBean.setGenderType(gTyep);

				if (row.get("relationshipWithEmp") != null) {
					employeeBean.setRelationshipWithEmp((String) row.get("relationshipWithEmp"));
				}
				if (row.get("empDependence") != null) {
					employeeBean.setEmpDependence((boolean) row.get("empDependence"));
				}
				if (row.get("qualification") != null) {
					employeeBean.setQualification((String) row.get("qualification"));
				}
				if (row.get("percentage") != null) {
					employeeBean.setPercentage(Double.valueOf(row.get("percentage").toString()));
				}
				if (row.get("courseType") != null) {
					employeeBean.setCourseType((String) row.get("courseType"));
				}
				if (row.get("institution") != null) {
					employeeBean.setInstitution((String) row.get("institution"));
				}
				if (row.get("yearPassed") != null) {
					employeeBean.setYearPassed(Integer.valueOf(row.get("yearPassed").toString()));
				}
				if (row.get("organization") != null) {
					employeeBean.setOrganization((String) row.get("organization"));
				}
				if (row.get("experienceYear") != null) {
					employeeBean.setExperienceYear(Double.valueOf(row.get("experienceYear").toString()));
				}
				if (row.get("expDesisnation") != null) {
					employeeBean.setExpDesisnation((String) row.get("expDesisnation"));
				}
				if (row.get("expRemarks") != null) {
					employeeBean.setExpRemarks((String) row.get("expRemarks"));
				}
				if (row.get("nominateName") != null) {
					employeeBean.setNominateName((String) row.get("nominateName"));
				}
				if (row.get("nominateName") != null) {
					employeeBean.setNominateName((String) row.get("nominateName"));
				}
				employeeBean.setNominateGender(nominateGender);
				if (row.get("nominateOccupation") != null) {
					employeeBean.setNominateOccupation((String) row.get("nominateOccupation"));
				}
				if (row.get("nominateRelationship") != null) {
					employeeBean.setNominateRelationship((String) row.get("nominateRelationship"));
				}
				if (row.get("nominateEmail") != null) {
					employeeBean.setNominateEmail((String) row.get("nominateEmail"));
				}
				if (row.get("nominatePhone") != null) {
					employeeBean.setNominatePhone((String) row.get("nominatePhone"));
				}
				if (row.get("nominateMobile") != null) {
					employeeBean.setNominateMobile((String) row.get("nominateMobile"));
				}
				if (nomdateOfBirth != null) {
					employeeBean.setNomdateOfBirth(nomdateOfBirth);

					if (row.get("nomineAddress") != null) {
						employeeBean.setNomineAddress((String) row.get("nomineAddress"));
					}
					if (row.get("nominatePincode") != null) {
						employeeBean.setNominatePincode((String) row.get("nominatePincode"));
					}
					if (row.get("nominatePlace") != null) {
						employeeBean.setNominatePlace((String) row.get("nominatePlace"));
					}
					if (row.get("awardName") != null) {
						employeeBean.setAwardName((String) row.get("awardName"));
					}
					if (row.get("scholarshipName") != null) {
						employeeBean.setScholarshipName((String) row.get("scholarshipName"));
					}
					if (row.get("meritDesc") != null) {
						employeeBean.setMeritDesc((String) row.get("meritDesc"));
					}
					if (row.get("emergencyName") != null) {
						employeeBean.setEmergencyName((String) row.get("emergencyName"));
					}
					if (row.get("emergencyOccu") != null) {
						employeeBean.setEmergencyOccu((String) row.get("emergencyOccu"));
					}
					if (row.get("emergRelationship") != null) {
						employeeBean.setEmergRelationship((String) row.get("emergRelationship"));
					}
					if (row.get("emergEmail") != null) {
						employeeBean.setEmergEmail((String) row.get("emergEmail"));
					}
					if (row.get("emergPhone") != null) {
						employeeBean.setEmergPhone((String) row.get("emergPhone"));
					}
					if (row.get("emergMobile") != null) {
						employeeBean.setEmergMobile((String) row.get("emergMobile"));
					}
					if (row.get("emergPlace") != null) {
						employeeBean.setEmergPlace((String) row.get("emergPlace"));
					}
					if (row.get("emerAddress") != null) {
						employeeBean.setEmerAddress((String) row.get("emerAddress"));
					}
					if (row.get("emergencyPincode") != null) {
						employeeBean.setEmergencyPincode((String) row.get("emergencyPincode"));
					}
					if (row.get("referenceName") != null) {
						employeeBean.setReferenceName((String) row.get("referenceName"));
					}
					if (row.get("occupationRef") != null) {
						employeeBean.setOccupationRef((String) row.get("occupationRef"));
					}
					if (row.get("relationshipRef") != null) {
						employeeBean.setRelationshipRef((String) row.get("relationshipRef"));
					}
					if (row.get("emailRef") != null) {
						employeeBean.setEmailRef((String) row.get("emailRef"));
					}
					if (row.get("referenceAddress") != null) {
						employeeBean.setReferenceAddress((String) row.get("referenceAddress"));
					}
					if (row.get("pincodeRef") != null) {
						employeeBean.setPincodeRef((String) row.get("pincodeRef"));
					}
					if (row.get("phoneRef") != null) {
						employeeBean.setPhoneRef((String) row.get("phoneRef"));
					}
					if (row.get("accountNo") != null) {
						employeeBean.setAccountNo((String) row.get("accountNo"));
					}
					if (row.get("bankName") != null) {
						employeeBean.setBankName((String) row.get("bankName"));
					}
					if (row.get("bankPlace") != null) {
						employeeBean.setBankPlace((String) row.get("bankPlace"));
					}
					if (row.get("passportNo") != null) {
						employeeBean.setPassportNo((String) row.get("passportNo"));
					}

					// employeeBean.setIssuedDate(issuedDate);

					// employeeBean.setExpiryDate(expiryDate);

					if (row.get("issuedPlace") != null) {
						employeeBean.setIssuedPlace((String) row.get("issuedPlace"));
					}
					if (row.get("licenseNo") != null) {
						employeeBean.setLicenseNo((String) row.get("licenseNo"));
					}
					if (row.get("licenseType") != null) {
						employeeBean.setLicenseType((String) row.get("licenseType"));
					}

					employeeBean.setLicenseIssuedDate(licenseIssuedDate);

					employeeBean.setLicenseexpiryDate(licenseexpiryDate);

					employeeBean.setRenewalDate(renewalDate);

					if (row.get("joinDocUpload") != null) {
						employeeBean.setJoinDocUpload((String) row.get("joinDocUpload"));
					}
					if (row.get("visaRefNo") != null) {
						employeeBean.setVisaRefNo((String) row.get("visaRefNo"));
					}
					if (row.get("visaType") != null) {
						employeeBean.setVisaType((String) row.get("visaType"));
					}
					if (row.get("visaIssuedPlace") != null) {
						employeeBean.setVisaIssuedPlace((String) row.get("visaIssuedPlace"));
					}

					employeeBean.setVisaExpiryDate(visaExpiryDate);

					employeeBean.setVisaIssuedDate(visaIssuedDate);

					if (row.get("isActiveCash") != null) {

						if ((boolean) row.get("isActiveCash") == true) {
							isActiveCash = "Y";
						} else {
							isActiveCash = "N";
						}
					}
				}
			}
			employeeBean.setIsActiveCash(isActiveCash);
			employeeBean.setIsActiveSight(isActiveSight);
			employeeBean.setIsActiveDumb(isActiveDumb);
			employeeBean.setIsActiveHearing(isActiveHearing);
			employeeBean.setIsActiveHand(isActiveHand);
			employeeBean.setIsActiveFeet(isActiveFeet);

			if (row.get("height") != null) {
				employeeBean.setHeight(Double.valueOf(row.get("height").toString()));
			}
			if (row.get("weight") != null) {
				employeeBean.setWeight(Double.valueOf(row.get("weight").toString()));
			}
			if (row.get("overTime") != null) {
				employeeBean.setOverTime((boolean) row.get("overTime"));
			}
			if (row.get("esiApp") != null) {
				employeeBean.setEsiApp((boolean) row.get("esiApp"));
			}
			if (row.get("lateApp") != null) {
				employeeBean.setLateApp((boolean) row.get("lateApp"));
			}
			if (row.get("pfApp") != null) {
				employeeBean.setPfApp((boolean) row.get("pfApp"));
			}
			if (row.get("earlyExit") != null) {
				employeeBean.setEarlyExit((boolean) row.get("earlyExit"));
			}
			if (row.get("telephoneLimit") != null) {
				employeeBean.setTelephoneLimit(Double.valueOf(row.get("telephoneLimit").toString()));
			}
			if (row.get("medicalLimit") != null) {
				employeeBean.setMedicalLimit(Double.valueOf(row.get("medicalLimit").toString()));
			}
			if (row.get("branch") != null) {
				employeeBean.setBranch(String.valueOf(row.get("branch")));
			}
			if (row.get("companyCode") != null) {
				employeeBean.setCompanyCode(String.valueOf(row.get("companyCode")));
			}
			employeeBean.setisEdit(true);
			bean.setBranchList(jdbcTemplate.query(UserAdminMasterQueryUtil.SELECT_BRANCH_LIST,
					new BeanPropertyRowMapper<UserAdminMasterBean>(UserAdminMasterBean.class)));

			// bean.setObjPresentAddDetail(alPresentAddDetail);
			// bean.setPresentAddressMultiple(alPresentAddDetail);
			bean.setEmployeeFamilyBeanList(lFamilyBean);
			bean.setEmployeeEducationBeanList(lEducationBean);
			bean.setEmployeeExperianceList(lExperianceBean);
			bean.setEmployeeMeritsBeanList(lMeritsBean);
			beans.add(employeeBean);
			bean.setEditList(beans);

		} catch (Exception e) {
			LOGGER.error("Error in viewEmployeeById", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		// TODO Auto-generated method stub

		return bean;
	}

	@Override
	public List getBranch(String companyCode) {
		List branchList = new ArrayList();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserAdminMasterQueryUtil.COMAPANY_BASED_BRANCH,
					companyCode);
			for (Map row : rows) {
				UserAdminMasterBean bean = new UserAdminMasterBean();
				bean.setId((String) row.get("id"));
				bean.setText((String) row.get("text"));
				branchList.add(bean);
			}
		} catch (DataAccessException e) {
			// LOGGER.error("Error in getVessel", e);
			LOGGER.error("Error in getReporingManager", e);
		}
		return branchList;

	}

	public String customerMail(UserAdminMasterBean bean) throws Exception {

		Email email = new Email();
		StringBuffer sb = new StringBuffer();
		String path = "";
		email.setFromEmailAddress("mbksupport@paragondynamics.in");
		String toMailAddress = bean.getEmailId();
		String[] toEmailIds = toMailAddress.split(",");
		email.setToEmailAddress(toEmailIds);
		/*String bcc = "gopi@paragondynamics.in,support@cordelialine.com";*/
		String bcc = "gopi@paragondynamics.in,mbksupport@paragondynamics.in";
			email.setBccEmailAddress(bcc.split(","));
		sb.append("Hi\n\n" + bean.getFirstName() + ",\n\n<br><br>");
		sb.append(
				"  \n\nGood day!!!\n\n Please find below the application URL for MBK and your login credentials\n\n<br><br>");
		sb.append("http://104.238.92.147:8090/dci<br><br>");
		sb.append("User id  : " + bean.getEmpId() + "<br>");
		sb.append("Password : " + bean.getPwd() + "<br><br>");
		sb.append("Kindly revert in case of any further inputs or assistance required.<br><br>");

		sb.append("Best Regards," + "\n\n<br>");
		sb.append("IT Support" + "\n\n<br>");
		sb.append("+91 8248654402" + "\n\n<br>");
		email.setBodyHtml(sb.toString());

		email.setSubject("MBK Application Access Details");

		MailUtility.sendMailCordelia(email, path);
		return path;
	}
	
	
	
	@Override
	public void insertFiles1(String employeeId,String filename, String path) {
	
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
				jdbcTemplate.update(UserAdminMasterQueryUtil.INSERT_FILES_KYC, new Object[] {  employeeId,filename, path });

			} catch (Exception se) {
				se.printStackTrace();
				throw se;
			}

		}

}
