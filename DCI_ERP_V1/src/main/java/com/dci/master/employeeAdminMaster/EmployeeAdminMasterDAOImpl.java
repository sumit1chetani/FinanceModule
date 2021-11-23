package com.dci.master.employeeAdminMaster;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.io.FilenameUtils;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CipherCrypto;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.common.util.HisFileUploadUtillity;
import com.dci.master.userAdminMaster.UserAdminMasterQueryUtil;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")

public class EmployeeAdminMasterDAOImpl implements EmployeeAdminMasterDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeAdminMasterDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	UserLogDAO userlogDAO;

	@Autowired
	AuditLogDAO auditLogDAO;

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

	@Value("${export.files.absolutePath}")
	private String getImgPath;

	@Override
	public List<EmployeeAdminMasterBean> getEmployeeList(int limit, int offset, EmployeeAdminMasterBean bean)
			throws CustomException {
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<EmployeeAdminMasterBean> empDataList = new ArrayList<EmployeeAdminMasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (bean.getStatus1().equalsIgnoreCase("0")) {
				List<Map<String, Object>> rows = jdbcTemplate
						.queryForList(EmployeeAdminMasterQueryUtil.SELECT_EMPLOYEE_LIST1);
				for (Map row : rows) {

					EmployeeAdminMasterBean objEmployeeMasterBean = new EmployeeAdminMasterBean();
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
					objEmployeeMasterBean.setDob((String) row.get("dob"));
					objEmployeeMasterBean.setDoj((String) row.get("doj"));
					objEmployeeMasterBean.setStatus((String) row.get("status"));
					objEmployeeMasterBean.setUserLocation((String) row.get("userLocation"));

					empDataList.add(objEmployeeMasterBean);
				}
			} else if (bean.getStatus1().equalsIgnoreCase("1")) {
				List<Map<String, Object>> rows = jdbcTemplate
						.queryForList(EmployeeAdminMasterQueryUtil.SELECT_EMPLOYEE_LIST2);

				for (Map row : rows) {

					EmployeeAdminMasterBean objEmployeeMasterBean = new EmployeeAdminMasterBean();
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
					objEmployeeMasterBean.setDob((String) row.get("dob"));
					objEmployeeMasterBean.setDoj((String) row.get("doj"));
					objEmployeeMasterBean.setStatus((String) row.get("status"));
					objEmployeeMasterBean.setUserLocation((String) row.get("userLocation"));

					empDataList.add(objEmployeeMasterBean);
				}
			} else {
				List<Map<String, Object>> rows = jdbcTemplate
						.queryForList(EmployeeAdminMasterQueryUtil.SELECT_EMPLOYEE_LIST3);
				for (Map row : rows) {

					EmployeeAdminMasterBean objEmployeeMasterBean = new EmployeeAdminMasterBean();
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
					objEmployeeMasterBean.setDob((String) row.get("dob"));
					objEmployeeMasterBean.setDoj((String) row.get("doj"));
					objEmployeeMasterBean.setStatus((String) row.get("status"));
					objEmployeeMasterBean.setUserLocation((String) row.get("userLocation"));

					empDataList.add(objEmployeeMasterBean);
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeeDetailsList", e);
			// throw new CustomException(PermissionRequestQueryUtil.ERROR_GET);
		}
		return empDataList;
	}

	@Override
	public List<EmployeeAdminMasterBean> getEmployeeReportList(int limit, int offset, String cmp, int dept,
			String branch) throws CustomException {

		List<EmployeeAdminMasterBean> employeeReportShow = new ArrayList<EmployeeAdminMasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if ((cmp == "" || cmp == null) && (dept == 0 || dept <= 0) && (branch == "" || branch == null)) {
				List<Map<String, Object>> rows = jdbcTemplate
						.queryForList(EmployeeAdminMasterQueryUtil.SELECT_EMPLOYEE_REPORT_LIST);
				for (Map row : rows) {

					EmployeeAdminMasterBean objEmployeeMasterBean = new EmployeeAdminMasterBean();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dob = df.format(row.get("dob"));
					String doj = df.format(row.get("doj"));
					objEmployeeMasterBean.setEmpId((String) row.get("empId"));
					objEmployeeMasterBean.setFirstName((String) row.get("firstName"));
					objEmployeeMasterBean.setCompanyName((String) row.get("companyName"));

					objEmployeeMasterBean.setBranchName((String) row.get("branchName"));
					objEmployeeMasterBean.setDepartmentCode((String) row.get("departmentCode"));
					objEmployeeMasterBean.setDesignationName((String) row.get("designationName"));
					objEmployeeMasterBean.setDob(dob);
					objEmployeeMasterBean.setDoj(doj);
					objEmployeeMasterBean.setReportManagerName((String) row.get("reportManagerName"));
					Double a = 0.0;
					Double gross = 0.0;
					a = (Double) row.get("experienceYear");
					if (a != null) {
						objEmployeeMasterBean.setExperienceYear(a);

					} else {
						a = 0.0;
						objEmployeeMasterBean.setExperienceYear(a);
					}

					if (row.get("fixedGross") != null) {
						objEmployeeMasterBean.setFixedGross(Double.valueOf(row.get("fixedGross").toString()));
					}
					if (row.get("marriedStatus") != null) {
						objEmployeeMasterBean.setMarriedStatus((boolean) row.get("marriedStatus"));
					}
					if (row.get("motherTongue") != null) {
						objEmployeeMasterBean.setMotherTongue((String) row.get("motherTongue"));
					}
					if (row.get("nationality") != null) {
						objEmployeeMasterBean.setNationality((String) row.get("nationality"));
					}
					if (row.get("languages") != null) {
						objEmployeeMasterBean.setLanguages((String) row.get("languages"));
					}
					if (row.get("gradeName") != null) {
						objEmployeeMasterBean.setGradeName((String) row.get("gradeName"));
					}
					if (row.get("bankName") != null) {
						objEmployeeMasterBean.setBankName((String) row.get("bankName"));
					}
					if (row.get("telephoneLimit") != null) {
						objEmployeeMasterBean.setTelephoneLimit(Double.valueOf(row.get("telephoneLimit").toString()));
					}
					if (row.get("medicalLimit") != null) {
						objEmployeeMasterBean.setMedicalLimit(Double.valueOf(row.get("medicalLimit").toString()));
					}
					employeeReportShow.add(objEmployeeMasterBean);
				}
			} else if (cmp != "" && dept != 0 && branch != "") {
				/*
				 * employeeReportShow =
				 * jdbcTemplate.query(EmployeeMasterQueryUtil.SELECT_REPORT_CDB,
				 * new
				 * BeanPropertyRowMapper<EmployeeMasterBean>(EmployeeMasterBean
				 * .class), new Object[] { cmp, dept, branch }); return
				 * employeeReportShow;
				 */

				// List<Map<String, Object>> rows =
				// jdbcTemplate.queryForList(EmployeeMasterQueryUtil.SELECT_EMPLOYEE_REPORT_LIST);

				int[] type = new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR };
				Object[] param = new Object[] { cmp, dept, branch };

				// List<Map<String, Object>> rows =
				// jdbcTemplate.queryForList(EmployeeMasterQueryUtil.SELECT_REPORT_CDB,
				// new
				// BeanPropertyRowMapper<EmployeeMasterBean>(EmployeeMasterBean.class),
				// param, type);

				List<Map<String, Object>> rows = jdbcTemplate
						.queryForList(EmployeeAdminMasterQueryUtil.SELECT_REPORT_CDB, param, type);
				/*
				 * values = jdbcTemplate.update(ShiftReAllocationQueryUtil.
				 * sUpdateShiftReAllocation, param, type);
				 */

				// List<Map<String, Object>> rows =
				// jdbcTemplate.queryForList(EmployeeMasterQueryUtil.SELECT_REPORT_CDB,
				// new
				// BeanPropertyRowMapper<EmployeeMasterBean>(EmployeeMasterBean.class),
				// new Object[] { cmp, dept, branch });

				for (Map row : rows) {

					EmployeeAdminMasterBean objEmployeeMasterBean = new EmployeeAdminMasterBean();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dob = df.format(row.get("dob"));
					String doj = df.format(row.get("doj"));
					objEmployeeMasterBean.setEmpId((String) row.get("empId"));
					objEmployeeMasterBean.setFirstName((String) row.get("firstName"));
					objEmployeeMasterBean.setCompanyName((String) row.get("companyName"));

					objEmployeeMasterBean.setBranchName((String) row.get("branchName"));
					objEmployeeMasterBean.setDepartmentCode((String) row.get("departmentCode"));
					objEmployeeMasterBean.setDesignationName((String) row.get("designationName"));
					objEmployeeMasterBean.setDob(dob);
					objEmployeeMasterBean.setReportManagerName((String) row.get("reportManagerName"));

					if (row.get("marriedStatus") != null) {
						objEmployeeMasterBean.setMarriedStatus((boolean) row.get("marriedStatus"));
					}

					Double a = 0.0;
					a = (Double) row.get("experienceYear");
					if (a != null) {
						objEmployeeMasterBean.setExperienceYear(a);

					} else {
						a = 0.0;
						objEmployeeMasterBean.setExperienceYear(a);
					}
					employeeReportShow.add(objEmployeeMasterBean);
				}

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeeDetailsList", e);
			// throw new CustomException(PermissionRequestQueryUtil.ERROR_GET);
		}
		return employeeReportShow;
	}

	@Override
	public EmployeeAdminMasterResultBean getEmployeeById(String empId) throws CustomException {
		EmployeeAdminMasterResultBean bean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> beans = new ArrayList<EmployeeAdminMasterBean>();
		List<EmployeeAdminMasterPhoneNoDetailBean> alPresentAddDetail = new ArrayList<EmployeeAdminMasterPhoneNoDetailBean>();
		EmployeeAdminMasterBean employeeBean = new EmployeeAdminMasterBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { empId };
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Map row = jdbcTemplate.queryForMap(EmployeeAdminMasterQueryUtil.SELECT_EMPLOYEE_BY_ID, params, types);
			List<EmployeeAdminMasterPersonalBean> lPersonalBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_PERSONAL_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterPersonalBean>(EmployeeAdminMasterPersonalBean.class));
			List<EmployeeAdminFamilyBean> lFamilyBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELECT_FAMILY_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminFamilyBean>(EmployeeAdminFamilyBean.class));
			List<EmployeeAdminEducationBean> lEducationBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELECT_EDUCATION_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminEducationBean>(EmployeeAdminEducationBean.class));
			List<EmployeeMAsterPerDetailsBean> lpersonalDetailBean = jdbcTemplate.query(
					EmployeeMasterQueryUtil.SELET_EMP_PER_DETAIL_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeMAsterPerDetailsBean>(EmployeeMAsterPerDetailsBean.class));
			List<EmployeeMasterPhysicalBean> lphysicalBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_PHYSICAL_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeMasterPhysicalBean>(EmployeeMasterPhysicalBean.class));
			List<EmployeeAdminExperianceBean> lExperianceBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELECT_EXPERIENCE_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminExperianceBean>(EmployeeAdminExperianceBean.class));
			List<EmployeeAdminMeritsBean> lMeritsBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELECT_MERITS_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMeritsBean>(EmployeeAdminMeritsBean.class));
			List<EmployeeAdminReferanceBean> lRefBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_REF_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminReferanceBean>(EmployeeAdminReferanceBean.class));
			List<EmployeeAdminDuplicateBean> lHistoryBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_DUPLICATE_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminDuplicateBean>(EmployeeAdminDuplicateBean.class));
			List<EmployeeAdminMasterBean> lformsreview = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_forms_REVIEW_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			bean.setEmployeeFamilyBeanList(lFamilyBean);
			bean.setEmployeeEducationBeanList(lEducationBean);
			bean.setEmployeePersonalBeanList(lPersonalBean);
			bean.setEmployeeMAsterPerDetailsBeanList(lpersonalDetailBean);
			bean.setEmployeeMasterPhysicalBeanBeanList(lphysicalBean);
			bean.setEmployeeExperianceList(lExperianceBean);
			bean.setEmployeeMeritsBeanList(lMeritsBean);
			bean.setEmployeeReferanceBeanList(lRefBean);
			bean.setEmployeeDuplicateList(lHistoryBean);
			bean.setEmployeeFormrevList(lformsreview);
			
			String dob = "";
			String doj = "";
			if(row.get("dob") != null)
			 dob = df.format(row.get("dob"));
			if(row.get("doj") != null)
			 doj = df.format(row.get("doj"));
			String reldate = null;
			String confirmDate = "";
			String resignationDate = "";
			String employmentdate = null;

			if (row.get("formreviewType") != null) {
				employeeBean.setFormreviewType((String) row.get("formreviewType"));
			}
			if (row.get("formreviewDate") != null) {
				employeeBean.setFormreviewDate((String) row.get("formreviewDate"));
			}
			if (row.get("formsreviewcomments") != null) {
				employeeBean.setFormsreviewcomments((String) row.get("formsreviewcomments"));
			}

			if (row.get("formreviewtemplete") != null) {
				employeeBean.setFormreviewtemplete((String) row.get("formreviewtemplete"));
			}

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
			if (row.get("isapp") != null) {
				employeeBean.setIsapp(String.valueOf(row.get("isapp")));
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

			if (row.get("salarybreakup") != null) {
				employeeBean.setSalarybreakup(Double.valueOf(row.get("salarybreakup").toString()));
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

			if (row.get("vendor") != null) {
				employeeBean.setVendor((String) row.get("vendor"));
			}
			if (row.get("country") != null) {
				employeeBean.setCountry((String) row.get("country"));
			}
			if (row.get("customerName") != null) {
				employeeBean.setCustomerName((String) row.get("customerName"));
			}

			if (row.get("portCodes") != null) {
				employeeBean.setPortCodes(String.valueOf(row.get("portCodes")));
			}

			if (row.get("altreportMangrId") != null) {
				employeeBean.setAltreportMangrId((String) row.get("altreportMangrId"));
			}
			if (row.get("altreportManagerName") != null) {
				employeeBean.setAltreportManagerName((String) row.get("altreportManagerName"));
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

			if (row.get("userLocation") != null) {
				employeeBean.setUserLocation((String) row.get("userLocation"));
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

			if (row.get("remarks") != null) {
				employeeBean.setRemarks((String) row.get("remarks"));
			}
			if (row.get("hobbies") != null) {
				employeeBean.setHobbies((String) row.get("hobbies"));
			}

			if (row.get("citizen") != null) {
				employeeBean.setCitizen((String) row.get("citizen"));
			}
			if (row.get("othercitizen") != null) {
				employeeBean.setOthercitizen((String) row.get("othercitizen"));
			}
			if (row.get("homedesti") != null) {
				employeeBean.setHomedesti((String) row.get("homedesti"));
			}
			if (row.get("airticketclass") != null) {
				employeeBean.setAirticketclass((String) row.get("airticketclass"));
			}
			if (row.get("probationperiod") != null) {
				employeeBean.setProbationperiod((String) row.get("probationperiod"));
			}
			if (row.get("noticeperiod") != null) {
				employeeBean.setNoticeperiod((String) row.get("noticeperiod"));
			}
			if (row.get("workcalender") != null) {
				employeeBean.setWorkcalender((String) row.get("workcalender"));
			}
			if (row.get("fatherName") != null) {
				employeeBean.setFatherName((String) row.get("fatherName"));
			}
			if (row.get("momcyName") != null) {
				employeeBean.setMomcyName((String) row.get("momcyName"));
			}
			if (row.get("socialNo") != null) {
				employeeBean.setSocialNo((String) row.get("socialNo"));
			}

			if (row.get("incometaxNo") != null) {
				employeeBean.setIncometaxNo((String) row.get("incometaxNo"));
			}
			if (row.get("faxName") != null) {
				employeeBean.setFaxName((String) row.get("faxName"));
			}

			if (row.get("profitCenter") != null) {
				employeeBean.setProfitCenter((String) row.get("profitCenter"));
			}
			if (row.get("unit") != null) {
				employeeBean.setUnit((String) row.get("unit"));
			}
			if (row.get("appraisalone") != null) {
				employeeBean.setAppraisalone((String) row.get("appraisalone"));
			}
			if (row.get("appraisalfinal") != null) {
				employeeBean.setAppraisalfinal((String) row.get("appraisalfinal"));
			}
			if (row.get("appraisaloneName") != null) {
				employeeBean.setAppraisaloneName((String) row.get("appraisaloneName"));
			}
			if (row.get("appraisalfinalName") != null) {
				employeeBean.setAppraisalfinalName((String) row.get("appraisalfinalName"));
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
			if (row.get("emp_status") != null) {
				employeeBean.setFirstName1(String.valueOf(row.get("emp_status")));
			}
			if (row.get("generic") != null) {
				employeeBean.setGeneric(String.valueOf(row.get("generic")));
			}
			employeeBean.setisEdit(true);
			bean.setBranchList(jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_BRANCH_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class)));

			// bean.setObjPresentAddDetail(alPresentAddDetail);
			// bean.setPresentAddressMultiple(alPresentAddDetail);
			bean.setEmployeeFamilyBeanList(lFamilyBean);
			bean.setEmployeeEducationBeanList(lEducationBean);
			bean.setEmployeeExperianceList(lExperianceBean);
			bean.setEmployeeMeritsBeanList(lMeritsBean);
			bean.setEmployeeFormrevList(lformsreview);
			beans.add(employeeBean);
			bean.setEditList(beans);

		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeById", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		// TODO Auto-generated method stub

		return bean;
	}

	@Override
	public synchronized EmployeeAdminMasterResultBean insertEmployee(EmployeeAdminMasterBean objEmployee)
			throws CustomException, IOException {
		boolean isSuccess = false;
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		String accessCardNo = "";

		List<EmployeeAdminDuplicateBean> duplicateData = objEmployee.getEmployeeDuplicateList();

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

			int checkEmail = jdbcTemplate.queryForObject(EmployeeMasterQueryUtil.checkEmail, Integer.class,
					objEmployee.getEmailId());

			if (checkEmail == 0) {

				try {

					dateOFBirth = formatter.parse(dob);
					date = formatter.parse(doj);

					if (objEmployee.getEmploymentDate() != null) {
						employMentDate = formatter.parse(employeementDate);
					}

					if (objEmployee.getRelieveDate() != null) {
						relievingDate = formatter.parse(relieveDate);
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				accessCardNo = "test01";
				Integer branchDeptId = 0, deptBranchId = 0, BranchId = 0;

				branchDeptId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_BRANCH,
						new Object[] { objEmployee.getBranch(), objEmployee.getDepartmentId() }, Integer.class);

				if (branchDeptId != null && branchDeptId != 0) {
					deptBranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sGetBranchDepartmentId,
							new Object[] { objEmployee.getBranch(), objEmployee.getDepartmentId() }, Integer.class);
				} else {

					int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
					BranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sGetBranchId,
							new Object[] { objEmployee.getBranch() }, Integer.class);

					Object[] params = new Object[] { BranchId, objEmployee.getDepartmentId(), objEmployee.getBranch() };

					deptBranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sInsertBranchDeparment,
							params, types, Integer.class);
				}
				BranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sGetBranchId,
						new Object[] { objEmployee.getBranch() }, Integer.class);
				String employeeId1 = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.GET_MAX_EMPLOYEE_ID,
						String.class);

				UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				Map<String, Object> empMap = new HashMap<String, Object>();
				objEmployee.setEmpId(employeeId1);

				boolean payFlag = false;

				if (objEmployee.getPayrollFlag()) {
					payFlag = true;
				}
				empMap.put("empId", objEmployee.getEmpId());
				empMap.put("reportMangrId", objEmployee.getReportMangrId());
				empMap.put("altreportMangrId", objEmployee.getAltreportMangrId());
				empMap.put("vendor", "N");
				empMap.put("customerName", objEmployee.getCustomerName());
				empMap.put("port", objEmployee.getPortCodes());
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

				empMap.put("salarybreakup", objEmployee.getSalarybreakup());
				empMap.put("relieveDate", relievingDate);
				// empMap.put("category", objEmployee.getCategory());
				// empMap.put("secondLevel", objEmployee.getSecondLevel());
				empMap.put("donorCode", objEmployee.getDonorCode());
				// empMap.put("principal", objEmployee.isPrincipal());
				// empMap.put("ms", objEmployee.isMs());

				empMap.put("status", objEmployee.getStatus());
				empMap.put("isEmailExempted", objEmployee.getIsEmailExempted());
				empMap.put("isapp", objEmployee.getIsapp());
				empMap.put("country", objEmployee.getCountry());

				empMap.put("fatherName", objEmployee.getFatherName());
				empMap.put("momcyName", objEmployee.getMomcyName());
				empMap.put("socialNo", objEmployee.getSocialNo());
				empMap.put("incometaxNo", objEmployee.getIncometaxNo());
				empMap.put("faxName", objEmployee.getFaxName());
				empMap.put("profitCenter", objEmployee.getProfitCenter());
				empMap.put("unit", objEmployee.getUnit());
				empMap.put("appraisalone", objEmployee.getAppraisalone());
				empMap.put("appraisalfinal", objEmployee.getAppraisalfinal());

				empMap.put("citizen", objEmployee.getCitizen());
				empMap.put("othercitizen", objEmployee.getOthercitizen());
				empMap.put("homedesti", objEmployee.getHomedesti());
				empMap.put("airticketclass", objEmployee.getAirticketclass());
				empMap.put("probationperiod", objEmployee.getProbationperiod());
				empMap.put("noticeperiod", objEmployee.getNoticeperiod());
				empMap.put("workcalender", objEmployee.getWorkcalender());
				empMap.put("contractperiod", objEmployee.getContractperiod());

				empMap.put("empname", objEmployee.getFirstName() + " " + objEmployee.getLastName());

				empMap.put("loginFlag", 'E');
				empMap.put("departmentCode", objEmployee.getDepartmentId());

				empMap.put("saright", 'Y');
				//int brnch=Integer.parseInt(objEmployee.getBranch());
				empMap.put("branchId", BranchId);

				empMap.put("insuranceNo", objEmployee.getInsuranceNo());
				empMap.put("empUserId", objEmployee.getEmpUserId());
				empMap.put("uan", objEmployee.getUan());
				empMap.put("payrollFlag", payFlag);

				empMap.put("createdBy", userDtl.getUserId());
				empMap.put("empstatus", objEmployee.getFirstName1());
				empMap.put("generic", objEmployee.getGeneric());
				empMap.put("userLocation", objEmployee.getUserLocation());
				
				if (objEmployee.getTypeOfEmp() == 1) {
					empMap.put("employmentDate", employMentDate);
				} else {
					empMap.put("employmentDate", null);
				}
				int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.COUNT_USERID,
						new Object[] { objEmployee.getEmpUserId() }, Integer.class);

				NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
				getProfileVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_EMPLOY, empMap);

				if (objEmployee.getIsapp().equalsIgnoreCase("Y")) {

					String userid1 = jdbcTemplate.queryForObject(UserAdminMasterQueryUtil.GET_MAX_EMPLOYEE_ID,
							String.class);
					objEmployee.setUserId(userid1);
					empMap.put("empId", objEmployee.getEmpId());

					empMap.put("userId", objEmployee.getUserId());
					getProfileVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_USER, empMap);
				}

				// getProfileVal =
				// namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_USERMASTER,
				// empMap);

				objEmployee.setTableName("employee_master");
				objEmployee.setFormCode("F5031");
				String Id = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELECT_PREVIOUS_ID, String.class);
				userlogDAO.userLogForInsert(objEmployee, Id, userDtl.getUserId());
				
				if(getProfileVal > 0) {
				 customerMail(objEmployee);
				}
				/*
				 * Map<String, Object> empMaps = new HashMap<String, Object>();
				 * empMaps.put("empId", objEmployee.getEmpId());
				 * empMaps.put("companyCode", objEmployee.getCompanyCode());
				 * empMaps.put("isPrimary", isPrimary);
				 * 
				 * int[] types = new int[] { Types.VARCHAR, Types.VARCHAR,
				 * Types.INTEGER }; Object[] params = new Object[] {
				 * objEmployee.getCompanyCode(), objEmployee.getEmpId(),
				 * isPrimary };
				 * 
				 * getCompanyUser =
				 * jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.
				 * INSERT_COMPANY_USER, params, types, Integer.class);
				 * 
				 * 
				 * try {
				 * 
				 * int[] type = new int[] { Types.INTEGER, Types.INTEGER };
				 * Object[] param = new Object[] { getCompanyUser,
				 * objEmployee.getDesignation() };
				 * 
				 * List<Map<String, Object>> ros =
				 * jdbcTemplate.queryForList(EmployeeMasterQueryUtil.
				 * SELECT_DESIGNATION_RIGHTS,param, type); for (Map row : ros) {
				 * 
				 * int cmp = (int) row.get("companyUserId"); int formProp =
				 * (int) row.get("formPropertyId");
				 * 
				 * jdbcTemplate.update(EmployeeMasterQueryUtil.
				 * INSERT_USER_RIGHTS, new Object[] { cmp, formProp }); }
				 * 
				 * } catch (DataAccessException e) {
				 * LOGGER.error("Error in getEmployeeDetailsList", e); }
				 */
				if (getProfileVal == 1) {
					objEmployeeMasterResultBean.setSuccess(true);
					objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
					objEmployeeMasterResultBean.setEmpUserId(objEmployee.getEmpUserId());

					for (int j = 0; j < duplicateData.size(); j++) {

						HashMap<String, Object> employeeDuplicateSubMap = new HashMap<String, Object>();
						employeeDuplicateSubMap.put("empId", objEmployee.getEmpId());
						employeeDuplicateSubMap.put("employmentDate", employMentDate);
						employeeDuplicateSubMap.put("columnName", duplicateData.get(j).getColumnName());
						employeeDuplicateSubMap.put("oldValue", duplicateData.get(j).getOldValue());
						employeeDuplicateSubMap.put("newValue", duplicateData.get(j).getNewValue());
						employeeDuplicateSubMap.put("comments", comments);

						getEmployeeDuplicateVal = namedParameterJdbcTemplate.update(
								EmployeeAdminMasterQueryUtil.INSERT_EMPLOYEE_DUPLICATE_SUBDATA,
								employeeDuplicateSubMap);
					}

					// DigitalLibraryUtil.saveMenu(jdbcTemplate,
					// objEmployee.getEmpId(), objEmployee.getFirstName(),
					// "User");
					// savePersonalInfo(objEmployee);
				} else {
					objEmployeeMasterResultBean.setSuccess(false);
				}

			} else {
				objEmployeeMasterResultBean.setSuccess(false);
				objEmployeeMasterResultBean.setStatus(302);
			}

		} catch (Exception e) {
			LOGGER.error("Error in Employee Add", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return objEmployeeMasterResultBean;
	}

	public boolean savePersonalInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		try {
			int getPersonalVal;
			boolean personalStatus = true;
			String marriageDate = objEmployee.getConfirmDate();
			String confirmDate = objEmployee.getConfirmDate();
			String resignationDate = objEmployee.getResignationDate();

			DateFormat formatter;
			Date date = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = formatter.parse(marriageDate);
				date = formatter.parse(confirmDate);
				date = formatter.parse(resignationDate);
			} catch (ParseException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			Map<String, Object> empMap = new HashMap<String, Object>();

			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("marritalStatus", objEmployee.isMarritalStatus());
			empMap.put("guardianName", objEmployee.getGuardianName());
			empMap.put("motherName", objEmployee.getMotherName());
			empMap.put("guardiansName", objEmployee.getGuardiansName());
			empMap.put("husbWifeName", objEmployee.getHusbWifeName());
			empMap.put("bloodGrp", objEmployee.getBloodGrp());
			empMap.put("caste", objEmployee.getCaste());
			empMap.put("religion", objEmployee.getReligion());
			empMap.put("motherTongue", objEmployee.getMotherTongue());
			empMap.put("languages", objEmployee.getLanguages());
			empMap.put("nationality", objEmployee.getNationality());
			empMap.put("panNo", objEmployee.getPanNo());
			empMap.put("hobbies", objEmployee.getHobbies());
			empMap.put("remarks", objEmployee.getRemarks());
			empMap.put("confirmDate", confirmDate);
			empMap.put("confirmationPeriod", objEmployee.getConfirmationPeriod());
			empMap.put("gratuityNominee", objEmployee.getGratuityNominee());
			empMap.put("nomineeRelation", objEmployee.getNomineeRelation());
			empMap.put("modeConveyence", objEmployee.getModeConveyence());
			empMap.put("emgContactNo", objEmployee.getEmgContactNo());
			empMap.put("emgContactName", objEmployee.getEmgContactName());
			empMap.put("resignationDate", resignationDate);
			empMap.put("race", objEmployee.getRace());
			empMap.put("noticePeriod", objEmployee.getNoticePeriod());
			empMap.put("personalStatus", personalStatus);
			// empMap.put("marriageDate", marriageDate);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getPersonalVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PERSONAL_INF,
					empMap);
			if (getPersonalVal == 1) {
				isSuccess = true;
				// saveAddressInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;

	}

	public boolean saveAddressInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		try {
			int getAddressVal;
			int presentAddressId = 0;
			String empID = "";
			/*
			 * if (objEmployee.getIsActiveAddress().equals("Y")) {
			 * isActiveAddress = true; }
			 */
			/*
			 * if (objEmployee.getIsActiveOldAddress().equals("Y")) {
			 * isActiveOldAddress = true; }
			 */
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			empID = objEmployee.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("permAddress", objEmployee.getPermAddress());
			empMap.put("permPlace", objEmployee.getPermPlace());
			empMap.put("permDistrict", objEmployee.getPermDistrict());
			empMap.put("permState", objEmployee.getPermState());
			empMap.put("permPin", objEmployee.getPermPin());
			empMap.put("permPhone", objEmployee.getPermPhone());
			empMap.put("permMobile", objEmployee.getPermMobile());
			// empMap.put("isActiveAddress", isActiveAddress);
			/*
			 * empMap.put("presentAddress", objEmployee.getPresentAddress());
			 * empMap.put("presentPlace", objEmployee.getPresentPlace());
			 * empMap.put("presentDistrict", objEmployee.getPresentDistrict());
			 * empMap.put("presentPin", objEmployee.getPresentPin());
			 * empMap.put("presentPhone", objEmployee.getPresentPhone());
			 * empMap.put("presentMobile", objEmployee.getPresentMobile());
			 */
			// empMap.put("isActiveOldAddress", isActiveOldAddress);
			String employeeId = objEmployee.getEmpId();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ADDRESS_INF, empMap);
			List<EmployeeAdminMasterPhoneNoDetailBean> presentAddressMultiple = objEmployee.getPresentAddressMultiple();
			for (EmployeeAdminMasterPhoneNoDetailBean objPhoneNoDetailBean : presentAddressMultiple) {
				presentAddressId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.INSERT_PRESENT_ADDRESS,
						new Object[] { objPhoneNoDetailBean.getPresentAddress(), objPhoneNoDetailBean.getPresentPlace(),
								objPhoneNoDetailBean.getPresentDistrict(), objPhoneNoDetailBean.getPresentState(),
								objPhoneNoDetailBean.getPresentPin(), employeeId },
						Integer.class);
				for (EmployeeAdminMasterPhoneNoDetailBean objPhoneBean : objPhoneNoDetailBean.getPresentPhone()) {
					jdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PHONE_NO, employeeId, presentAddressId,
							objPhoneBean.getPresentPhoneNo());
				}
				for (EmployeeAdminMasterPhoneNoDetailBean objMobileBean : objPhoneNoDetailBean.getPresentMobile()) {
					jdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_MOBILE_NO, employeeId, presentAddressId,
							objMobileBean.getPresentMobileNo());
				}

			}
			if (getAddressVal == 1 && presentAddressId > 0) {
				isSuccess = true;
				saveRulessInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;

	}

	public boolean saveRulessInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		try {
			int getRuleVal;
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("overTime", objEmployee.isOverTime());
			empMap.put("esiApp", objEmployee.getEsiApp());
			empMap.put("lateApp", objEmployee.isLateApp());
			empMap.put("telephoneLimit", objEmployee.getTelephoneLimit());
			empMap.put("pfApp", objEmployee.isPfApp());
			empMap.put("leaveOption", objEmployee.isLeaveOption());
			empMap.put("noticePeriodRule", objEmployee.getNoticePeriodRule());
			empMap.put("medicalLimit", objEmployee.getMedicalLimit());
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getRuleVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_RULES_INF, empMap);
			if (getRuleVal == 1) {
				isSuccess = true;
				savePhysicalInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;

	}

	public boolean saveNomineeInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		try {
			int getNomineeVal;
			boolean genderType = false;
			if (objEmployee.getNominateGender().equals("Male")) {
				genderType = true;
			} else if (objEmployee.getNominateGender().equals("Female")) {
				genderType = false;
			}

			String nomdateOfBirth = objEmployee.getNomdateOfBirth();

			DateFormat formatter;
			Date date = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = formatter.parse(nomdateOfBirth);

			} catch (ParseException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("nominateName", objEmployee.getNominateName());
			empMap.put("nominateGender", genderType);
			empMap.put("nominateOccupation", objEmployee.getNominateOccupation());
			empMap.put("nominateRelationship", objEmployee.getNominateRelationship());
			empMap.put("nominateEmail", objEmployee.getNominateEmail());
			empMap.put("nominatePhone", objEmployee.getNominatePhone());
			empMap.put("nominateMobile", objEmployee.getNominateMobile());
			empMap.put("nomdateOfBirth", date);
			empMap.put("nomineAddress", objEmployee.getNomineAddress());
			empMap.put("nominatePincode", objEmployee.getNominatePincode());
			empMap.put("nominatePlace", objEmployee.getNominatePlace());
			empMap.put("uploadPhotoNominee", objEmployee.getUploadPhotoNominee());
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getNomineeVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_NOMINEE_INF, empMap);
			if (getNomineeVal > 0) {
				isSuccess = true;
				savePhysicalInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;

	}

	public boolean savePhysicalInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		try {
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			boolean isActiveSight = false, isActiveDumb = false, isActiveHearing = false, isActiveHand = false,
					isActiveFeet = false;
			int getPhyVal;
			if (objEmployee.getIsActiveSight().equals("Y")) {
				isActiveSight = true;
			}
			if (objEmployee.getIsActiveDumb().equals("Y")) {
				isActiveDumb = true;
			}
			if (objEmployee.getIsActiveHearing().equals("Y")) {
				isActiveHearing = true;
			}
			if (objEmployee.getIsActiveHand().equals("Y")) {
				isActiveHand = true;
			}
			if (objEmployee.getIsActiveFeet().equals("Y")) {
				isActiveFeet = true;
			}
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("isActiveSight", isActiveSight);
			empMap.put("isActiveDumb", isActiveDumb);
			empMap.put("isActiveHearing", isActiveHearing);
			empMap.put("isActiveHand", isActiveHand);
			empMap.put("isActiveFeet", isActiveFeet);
			empMap.put("otherDisablity", objEmployee.getOtherDisablity());
			empMap.put("height", objEmployee.getHeight());
			empMap.put("weight", objEmployee.getWeight());
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getPhyVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PHYSICAL_INF, empMap);
			if (getPhyVal == 1) {
				isSuccess = true;
				// saveEmergencyInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;

	}

	public boolean saveEmergencyInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		try {

			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			int getEmerVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("emergencyName", objEmployee.getEmergencyName());
			empMap.put("emergencyOccu", objEmployee.getEmergencyOccu());
			empMap.put("emergRelationship", objEmployee.getEmergRelationship());
			empMap.put("emergEmail", objEmployee.getEmergEmail());
			empMap.put("emergPhone", objEmployee.getEmergPhone());
			empMap.put("emergMobile", objEmployee.getEmergMobile());
			empMap.put("emergPlace", objEmployee.getEmergPlace());
			empMap.put("emerAddress", objEmployee.getEmerAddress());
			empMap.put("emergencyPincode", objEmployee.getEmergencyPincode());

			getEmerVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_EMERGENCY_INF, empMap);
			if (getEmerVal == 1) {
				isSuccess = true;
				saveReferenceInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;
	}

	public boolean saveReferenceInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		try {
			int getRefVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("referenceName", objEmployee.getReferenceName());
			empMap.put("occupationRef", objEmployee.getOccupationRef());
			empMap.put("relationshipRef", objEmployee.getRelationshipRef());
			empMap.put("emailRef", objEmployee.getEmailRef());
			empMap.put("referenceAddress", objEmployee.getReferenceAddress());
			empMap.put("pincodeRef", objEmployee.getPincodeRef());
			empMap.put("phoneRef", objEmployee.getPhoneRef());
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getRefVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_REFERENCE_INF, empMap);
			if (getRefVal == 1) {
				isSuccess = true;
				saveDocumentInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;
	}

	public boolean saveDocumentInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try {
			int getDocVal;
			boolean isActiveCash = false;
			if (objEmployee.getIsActiveCash().equals("Y")) {
				isActiveCash = true;
			}

			String issuedDate = objEmployee.getIssuedDate();
			String expiryDate = objEmployee.getExpiryDate();
			String licenseIssuedDate = objEmployee.getLicenseIssuedDate();
			String licenseexpiryDate = objEmployee.getLicenseexpiryDate();
			String renewalDate = objEmployee.getRenewalDate();
			String visaIssuedDate = objEmployee.getVisaIssuedDate();
			String visaExpiryDate = objEmployee.getVisaExpiryDate();

			DateFormat formatter;
			Date date = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = formatter.parse(issuedDate);
				date = formatter.parse(expiryDate);
				date = formatter.parse(licenseIssuedDate);
				date = formatter.parse(licenseexpiryDate);
				date = formatter.parse(renewalDate);
				date = formatter.parse(visaIssuedDate);
				date = formatter.parse(visaExpiryDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("accountNo", objEmployee.getAccountNo());
			empMap.put("bankName", objEmployee.getBankName());
			empMap.put("bankPlace", objEmployee.getBankPlace());
			empMap.put("passportNo", objEmployee.getPassportNo());
			empMap.put("issuedDate", date);
			empMap.put("expiryDate", date);
			empMap.put("issuedPlace", objEmployee.getIssuedPlace());
			empMap.put("licenseNo", objEmployee.getLicenseNo());
			empMap.put("licenseType", objEmployee.getLicenseType());
			empMap.put("licenseIssuedDate", date);
			empMap.put("licenseexpiryDate", date);
			empMap.put("renewalDate", date);
			empMap.put("joinDocUpload", objEmployee.getJoinDocUpload());
			empMap.put("visaRefNo", objEmployee.getVisaRefNo());
			empMap.put("visaType", objEmployee.getVisaType());
			empMap.put("visaIssuedPlace", objEmployee.getVisaIssuedPlace());
			empMap.put("visaIssuedDate", date);
			empMap.put("visaExpiryDate", date);
			empMap.put("isActiveCash", isActiveCash);

			getDocVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_DOCUMENT_INF, empMap);
			if (getDocVal == 1) {
				isSuccess = true;
				saveFamilyInfo(objEmployee);

			} else {
				isSuccess = false;
			}
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;
	}

	public boolean saveFamilyInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		try {
			int getFamilyVal = 0;
			boolean genderType = false;
			if (objEmployee.getGenderType().equals("Male")) {
				genderType = true;
			} else if (objEmployee.getGenderType().equals("Female")) {
				genderType = false;
			}

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("familyName", objEmployee.getFamilyName());
			empMap.put("genderType", genderType);
			empMap.put("relationshipWithEmp", objEmployee.getRelationshipWithEmp());
			empMap.put("empDependence", objEmployee.isEmpDependence());
			// getFamilyVal =
			// namedParameterJdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_FAMILY_INF,
			// empMap);
			if (getFamilyVal == 1) {
				isSuccess = true;
				saveEducationInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;
	}

	public boolean saveEducationInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try {
			int getEduVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("qualification", objEmployee.getQualification());
			empMap.put("percentage", objEmployee.getPercentage());
			empMap.put("courseType", objEmployee.getCourseType());
			empMap.put("institution", objEmployee.getInstitution());
			empMap.put("yearPassed", objEmployee.getYearPassed());
			getEduVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_EDUC_INF, empMap);
			if (getEduVal == 1) {
				isSuccess = true;
				saveMeritInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;
	}

	public boolean saveMeritInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try {
			int getMeritVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("awardName", objEmployee.getAwardName());
			empMap.put("scholarshipName", objEmployee.getScholarshipName());
			empMap.put("meritDesc", objEmployee.getMeritDesc());
			getMeritVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_MERIT_INF, empMap);
			if (getMeritVal == 1) {
				isSuccess = true;
				saveExperienceInfo(objEmployee);
			} else {
				isSuccess = false;
			}
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;
	}

	public boolean saveExperienceInfo(EmployeeAdminMasterBean objEmployee) {
		boolean isSuccess = false;
		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			int getExperVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("organization", objEmployee.getOrganization());
			empMap.put("experienceYear", objEmployee.getExperienceYear());
			empMap.put("expDesisnation", objEmployee.getExpDesisnation());
			empMap.put("expRemarks", objEmployee.getExpRemarks());
			getExperVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_EXPERIENCE_INF, empMap);
			if (getExperVal == 1) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			objEmployee.setTableName("employee_master");
			objEmployee.setFormCode("F5031");
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			userlogDAO.userLogForInsert(objEmployee, objEmployee.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return isSuccess;
	}

	@Override
	public boolean updateEmployee(EmployeeAdminMasterBean employeeMasterBean) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		int getProfileVal;
		int getEmployeeDuplicateVal;
		int presentAddressId;
		List<EmployeeAdminMasterPhoneNoDetailBean> alPresentAddDetail = new ArrayList<EmployeeAdminMasterPhoneNoDetailBean>();
		List<EmployeeAdminDuplicateBean> duplicateData = employeeMasterBean.getEmployeeDuplicateList();

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
				date = formatter.parse(dob);
				date = formatter.parse(doj);

				if (employeeMasterBean.getEmploymentDate() != null) {
					employMentDate = formatter.parse(employeementDate);
				}

				if (employeeMasterBean.getRelieveDate() != null) {
					relievingDate = formatter.parse(relieveDate);
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int branchDeptId = 0, deptBranchId = 0, BranchId = 0;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			branchDeptId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_BRANCH,
					new Object[] { employeeMasterBean.getBranch(), employeeMasterBean.getDepartmentId() },
					Integer.class);

			if (branchDeptId != 0) {
				deptBranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sGetBranchDepartmentId,
						new Object[] { employeeMasterBean.getBranch(), employeeMasterBean.getDepartmentId() },
						Integer.class);
			} else {

				int[] types = new int[] { Types.VARCHAR, Types.INTEGER };
				BranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sGetBranchId,
						new Object[] { employeeMasterBean.getBranch() }, Integer.class);

				Object[] params = new Object[] { BranchId, employeeMasterBean.getDepartmentId(),
						employeeMasterBean.getBranch() };

				deptBranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sInsertBranchDeparment, params,
						Integer.class);
			}
			BranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sGetBranchId,
					new Object[] { employeeMasterBean.getBranch() }, Integer.class);
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Map<String, Object> empMap = new HashMap<String, Object>();
			boolean payFlag = false;

			if (employeeMasterBean.getPayrollFlag()) {
				payFlag = true;
			}
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("reportMangrId", employeeMasterBean.getReportMangrId());
			empMap.put("altreportMangrId", employeeMasterBean.getAltreportMangrId());
			empMap.put("vendor", "N");
			empMap.put("customerName", employeeMasterBean.getCustomerName());
			empMap.put("port", employeeMasterBean.getPortCodes());
			empMap.put("accessCardNo", employeeMasterBean);
			empMap.put("firstName", employeeMasterBean.getFirstName());
			empMap.put("middleName", employeeMasterBean.getMiddleName());
			empMap.put("lastName", employeeMasterBean.getLastName());
			empMap.put("gender", employeeMasterBean.getGender());
			empMap.put("dob", employeeMasterBean.getDob());
			empMap.put("doj", employeeMasterBean.getDoj());
			empMap.put("mobileNo", employeeMasterBean.getMobileNo());
			empMap.put("emailId", employeeMasterBean.getEmailId());
			empMap.put("uploadPhoto", employeeMasterBean.getUploadPhoto());
			empMap.put("designation", employeeMasterBean.getDesignation());
			empMap.put("departmentId", employeeMasterBean.getDepartmentId());
			empMap.put("grade", employeeMasterBean.getGrade());
			empMap.put("division", employeeMasterBean.getDivision());
			empMap.put("companyCode", employeeMasterBean.getCompanyCode());

			// empMap.put("pwd",CipherCrypto.Encrypt(employeeMasterBean.getPwd()));
			empMap.put("typeOfEmp", employeeMasterBean.getTypeOfEmp());
			empMap.put("epfNo", employeeMasterBean.getEpfNo());
			empMap.put("esic", employeeMasterBean.getEsic());
			empMap.put("fixedGross", employeeMasterBean.getFixedGross());
			empMap.put("salarybreakup", employeeMasterBean.getSalarybreakup());
			empMap.put("relieveDate", relievingDate);
			// empMap.put("category", objEmployee.getCategory());
			// empMap.put("secondLevel", objEmployee.getSecondLevel());
			empMap.put("donorCode", employeeMasterBean.getDonorCode());
			// empMap.put("principal", objEmployee.isPrincipal());
			// empMap.put("ms", objEmployee.isMs());
			empMap.put("isapp", employeeMasterBean.getIsapp());
			empMap.put("status", employeeMasterBean.getStatus());
			empMap.put("isEmailExempted", employeeMasterBean.getIsEmailExempted());

			empMap.put("userId", employeeMasterBean.getUserId());
			empMap.put("country", employeeMasterBean.getCountry());
			empMap.put("empname", employeeMasterBean.getFirstName() + " " + employeeMasterBean.getLastName());

			empMap.put("contractperiod", employeeMasterBean.getContractperiod());

			empMap.put("fatherName", employeeMasterBean.getFatherName());
			empMap.put("momcyName", employeeMasterBean.getMomcyName());
			empMap.put("socialNo", employeeMasterBean.getSocialNo());
			empMap.put("incometaxNo", employeeMasterBean.getIncometaxNo());
			empMap.put("faxName", employeeMasterBean.getFaxName());
			empMap.put("profitCenter", employeeMasterBean.getProfitCenter());
			empMap.put("unit", employeeMasterBean.getUnit());
			empMap.put("appraisalone", employeeMasterBean.getAppraisalone());
			empMap.put("appraisalfinal", employeeMasterBean.getAppraisalfinal());

			empMap.put("citizen", employeeMasterBean.getCitizen());
			empMap.put("othercitizen", employeeMasterBean.getOthercitizen());
			empMap.put("homedesti", employeeMasterBean.getHomedesti());
			empMap.put("airticketclass", employeeMasterBean.getAirticketclass());
			empMap.put("probationperiod", employeeMasterBean.getProbationperiod());
			empMap.put("noticeperiod", employeeMasterBean.getNoticeperiod());
			empMap.put("workcalender", employeeMasterBean.getWorkcalender());

			empMap.put("loginFlag", 'E');
			empMap.put("saright", 'Y');
			empMap.put("branchId", BranchId);
			empMap.put("insuranceNo", employeeMasterBean.getInsuranceNo());
			empMap.put("empUserId", employeeMasterBean.getEmpUserId());
			empMap.put("uan", employeeMasterBean.getUan());
			empMap.put("payrollFlag", payFlag);
			empMap.put("createdBy", userDtl.getUserId());
			empMap.put("empstatus", employeeMasterBean.getFirstName1());
			empMap.put("generic", employeeMasterBean.getGeneric());
			empMap.put("userLocation", employeeMasterBean.getUserLocation());

			if (employeeMasterBean.getTypeOfEmp() == 1) {
				empMap.put("employmentDate", employMentDate);
			} else {
				empMap.put("employmentDate", null);
			}

			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			try {
				EmployeeAdminMasterResultBean oldlocationBean = getEmployeeById(employeeMasterBean.getEmpId());

				String empName = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.getEmployee, String.class,
						employeeMasterBean.getEmpId());
				if (employeeMasterBean.getEmpId().equals(empName)) {

					boolean status1 = false;
					if (employeeMasterBean.getStatus().equals("Y")) {
						status1 = true;
					}
					getProfileVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMPLOYEE,
							empMap);

					if (employeeMasterBean.getIsapp().equalsIgnoreCase("Y")
							&& employeeMasterBean.getStatus().equals("Y")) {

						int Count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECKEMP_COUNT,
								new Object[] { employeeMasterBean.getEmpId() }, Integer.class);

						if (Count > 0) {
							getProfileVal = namedParameterJdbcTemplate
									.update(UserAdminMasterQueryUtil.UPDATE_EMPLOYEE_USER, empMap);
						}
						if (employeeMasterBean.getIsapp().equalsIgnoreCase("Y")
								&& employeeMasterBean.getStatus().equals("Y")) {
							int empCount = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECKEMP_COUNT,
									new Object[] { employeeMasterBean.getEmpId() }, Integer.class);

							if (empCount == 0) {
								String userid1 = jdbcTemplate
										.queryForObject(UserAdminMasterQueryUtil.GET_MAX_EMPLOYEE_ID, String.class);
								// employeeMasterBean.setUserId(userid1);

								/*
								 * empMap.put("empId",
								 * employeeMasterBean.getEmpId());
								 * 
								 * empMap.put("userId",
								 * employeeMasterBean.getUserId());
								 */
								/*
								 * getProfileVal =
								 * namedParameterJdbcTemplate.update(
								 * EmployeeAdminMasterQueryUtil.
								 * INSERT_USER_ISAPP, empMap);
								 * 
								 * 
								 * 
								 */

								String tDate = employeeMasterBean.getDob();
								Date dobir = formatter.parse(tDate);
								java.sql.Timestamp toDate = new Timestamp(date.getTime());

								String tDate1 = employeeMasterBean.getDoj();
								Date dojir = formatter.parse(tDate1);
								java.sql.Timestamp toDate1 = new Timestamp(date.getTime());

								String tDate2 = employeeMasterBean.getEmploymentDate();
								Date usd = formatter.parse(tDate2);
								// java.sql.Timestamp toDate2 = new
								// Timestamp(date.getTime());

								getProfileVal = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_USER_ISAPP,
										new Object[] { userid1, employeeMasterBean.getReportMangrId(),
												employeeMasterBean.getAccessCardNo(), employeeMasterBean.getFirstName(),
												employeeMasterBean.getMiddleName(), employeeMasterBean.getLastName(),
												employeeMasterBean.getGender(), dobir, dojir,
												employeeMasterBean.getMobileNo(), employeeMasterBean.getEmailId(),
												employeeMasterBean.getUploadPhoto(),
												employeeMasterBean.getDesignation(), employeeMasterBean.getGrade(),
												employeeMasterBean.getDivision(),
												CipherCrypto.Encrypt(employeeMasterBean.getPwd()),
												employeeMasterBean.getTypeOfEmp(), employeeMasterBean.getEpfNo(),
												employeeMasterBean.getEsic(), employeeMasterBean.getFixedGross(),
												employeeMasterBean.getDonorCode(), employeeMasterBean.getStatus(),
												employeeMasterBean.getIsEmailExempted(),
												employeeMasterBean.getBranchId(), employeeMasterBean.getInsuranceNo(),
												employeeMasterBean.getRelieveDate(), usd,
												employeeMasterBean.getEmpUserId(), employeeMasterBean.getDepartmentId(),
												employeeMasterBean.getUan(), employeeMasterBean.getFirstName(), 'Y',
												userDtl.getUserId(), employeeMasterBean.getCompanyCode(), 'E',
												employeeMasterBean.getCustomerName(), "N",
												employeeMasterBean.getCountry(), employeeMasterBean.getEmpId() });
							}

						}

					}

					// namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMPLOYEE_MASTER,
					// empMap);

					isSuccess = true;
/*					if(employeeMasterBean.getTypeOfEmp()==1){
						int count=jdbcTemplate
								.queryForObject(EmployeeAdminMasterQueryUtil.checkdate,new Object[]{employeeMasterBean.getEmpId()},Integer.class);
					 if(count>0){
						 jdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_conform_date,new Object[] { employeeMasterBean.getEmpId()});
					 }else{
						 jdbcTemplate.update(EmployeeAdminMasterQueryUtil.insert_conform_date,new Object[]{employeeMasterBean.getEmpId()});

					}
					}
*/					if (getProfileVal == 1) {
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
										EmployeeAdminMasterQueryUtil.INSERT_EMPLOYEE_DUPLICATE_SUBDATA,
										employeeDuplicateSubMap);
							}

						}
					}
				} else {
					int rowCount = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.COUNT_USERID,
							new Object[] { employeeMasterBean.getEmpId() }, Integer.class);

					if (rowCount > 0) {
						throw new CustomException(ErrorMessage.NAME_ALREADY_EXISTS);
					} else {
						boolean status1 = false;
						if (employeeMasterBean.getStatus().equals("Y")) {
							status1 = true;
						}
						getProfileVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMPLOYEE,
								empMap);
						
						isSuccess = true;
						employeeMasterBean.setTableName("employee_master");
						employeeMasterBean.setFormCode("F5031");
						userlogDAO.userLogForUpdate(oldlocationBean, employeeMasterBean,
								employeeMasterBean.getEmpId() + "", userDtl.getUserId());
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
											EmployeeAdminMasterQueryUtil.INSERT_EMPLOYEE_DUPLICATE_SUBDATA,
											employeeDuplicateSubMap);
								}

							}
						}
					}

				}

			} catch (DataAccessException e) {
				LOGGER.error("Error in updateDesignation", e);
			}

		} catch (Exception e) {
			isSuccess = false;
			LOGGER.error("Error in update employee", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updatePesronalInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int i = 1;
		int getProfileVal;
		try {
			/*
			 * boolean marriedStatus = false; if
			 * (employeeMasterBean.isMarriedStatus() == true) { marriedStatus =
			 * true; }
			 */
			String confirmDate = employeeMasterBean.getConfirmDate();
			String resignationDate = employeeMasterBean.getResignationDate();

			DateFormat formatter;
			Date date = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = formatter.parse(confirmDate);
				date = formatter.parse(resignationDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("marritalStatus", employeeMasterBean.isMarritalStatus());
			empMap.put("guardianName", employeeMasterBean.getGuardianName());
			empMap.put("motherName", employeeMasterBean.getMotherName());
			empMap.put("guardiansName", employeeMasterBean.getGuardiansName());
			empMap.put("bloodGrp", employeeMasterBean.getBloodGrp());
			empMap.put("caste", employeeMasterBean.getCaste());
			empMap.put("religion", employeeMasterBean.getReligion());
			empMap.put("motherTongue", employeeMasterBean.getMotherTongue());
			empMap.put("nationality", employeeMasterBean.getNationality());
			empMap.put("panNo", employeeMasterBean.getPanNo());
			empMap.put("gratuityNominee", employeeMasterBean.getGratuityNominee());
			empMap.put("nomineeRelation", employeeMasterBean.getNomineeRelation());
			empMap.put("modeConveyence", employeeMasterBean.getModeConveyence());
			empMap.put("hobbies", employeeMasterBean.getHobbies());
			empMap.put("emgContactNo", employeeMasterBean.getEmgContactNo());
			empMap.put("emgContactName", employeeMasterBean.getEmgContactName());
			empMap.put("noticePeriod", employeeMasterBean.getNoticePeriod());
			empMap.put("remarks", employeeMasterBean.getRemarks());
			empMap.put("confirmDate", confirmDate);
			empMap.put("resignationDate", resignationDate);
			empMap.put("languages", employeeMasterBean.getLanguages());
			empMap.put("race", employeeMasterBean.getRace());
			empMap.put("confirmationPeriod", employeeMasterBean.getConfirmationPeriod());
			empMap.put("husbWifeName", employeeMasterBean.getHusbWifeName());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());

			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_PERSONAL_INF, empMap);
				// updateAddressInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getProfileVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_PERSONAL_INFO,
						empMap);
				if (getProfileVal == 1) {
					isSuccess = true;
					// updateAddressInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateAddressInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getAddressVal;
		int presentAddressId;
		int i = 1;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("permAddress", employeeMasterBean.getPermAddress());
			empMap.put("permPlace", employeeMasterBean.getPermPlace());
			empMap.put("permDistrict", employeeMasterBean.getPermDistrict());
			empMap.put("permState", employeeMasterBean.getPermState());
			empMap.put("permPin", employeeMasterBean.getPermPin());
			empMap.put("permPhone", employeeMasterBean.getPermPhone());
			empMap.put("permMobile", employeeMasterBean.getPermMobile());
			/*
			 * empMap.put("presentAddress",
			 * employeeMasterBean.getPresentAddress());
			 * empMap.put("presentPlace", employeeMasterBean.getPresentPlace());
			 * empMap.put("presentDistrict",
			 * employeeMasterBean.getPresentDistrict());
			 * empMap.put("presentPin", employeeMasterBean.getPresentPin());
			 * empMap.put("presentPhone", employeeMasterBean.getPresentPhone());
			 * empMap.put("presentMobile",
			 * employeeMasterBean.getPresentMobile());
			 */
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_ADDRESS_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_ADDRESS_INF, empMap);
				updateFamilyInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_ADDRESS_INFO,
						empMap);
				if (getAddressVal == 1) {
					isSuccess = true;
					updateFamilyInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_MOBILE_NO,
					new Object[] { employeeMasterBean.getEmpId() });
			jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_PHONE_NO,
					new Object[] { employeeMasterBean.getEmpId() });
			jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_PRESENT_ADDRESS,
					new Object[] { employeeMasterBean.getEmpId() });

			List<EmployeeAdminMasterPhoneNoDetailBean> presentAddressMultiple = employeeMasterBean
					.getPresentAddressMultiple();
			for (EmployeeAdminMasterPhoneNoDetailBean objPhoneNoDetailBean : presentAddressMultiple) {
				presentAddressId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.INSERT_PRESENT_ADDRESS,
						new Object[] { objPhoneNoDetailBean.getPresentAddress(), objPhoneNoDetailBean.getPresentPlace(),
								objPhoneNoDetailBean.getPresentDistrict(), objPhoneNoDetailBean.getPresentState(),
								objPhoneNoDetailBean.getPresentPin(), employeeMasterBean.getEmpId() },
						Integer.class);
				for (EmployeeAdminMasterPhoneNoDetailBean objPhoneBean : objPhoneNoDetailBean.getPresentPhone()) {
					jdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PHONE_NO, employeeMasterBean.getEmpId(),
							presentAddressId, objPhoneBean.getPresentPhoneNo());
				}
				for (EmployeeAdminMasterPhoneNoDetailBean objMobileBean : objPhoneNoDetailBean.getPresentMobile()) {
					jdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_MOBILE_NO, employeeMasterBean.getEmpId(),
							presentAddressId, objMobileBean.getPresentMobileNo());
				}

			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateFamilyInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getFamVal;
		int i = 1;
		try {
			boolean genderType = false;
			if (employeeMasterBean.getGenderType().equals("Male")) {
				genderType = true;
			} else if (employeeMasterBean.getGenderType().equals("Female")) {
				genderType = false;
			}
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("familyName", employeeMasterBean.getFamilyName());
			empMap.put("genderType", genderType);
			empMap.put("relationshipWithEmp", employeeMasterBean.getRelationshipWithEmp());
			empMap.put("empDependence", employeeMasterBean.isEmpDependence());
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_FAMILY_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_FAMILY_INF, empMap);
				updateEduInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getFamVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_FAMILY_INFO, empMap);
				if (getFamVal == 1) {
					isSuccess = true;
					updateEduInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateEduInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getEduVal;
		int i = 1;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			boolean genderType = false;
			if (employeeMasterBean.getGenderType().equals("Male")) {
				genderType = true;
			} else if (employeeMasterBean.getGenderType().equals("Female")) {
				genderType = false;
			}
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());

			empMap.put("qualification", employeeMasterBean.getQualification());
			empMap.put("percentage", employeeMasterBean.getPercentage());
			empMap.put("courseType", employeeMasterBean.getCourseType());
			empMap.put("institution", employeeMasterBean.getInstitution());
			empMap.put("yearPassed", employeeMasterBean.getYearPassed());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_EDU_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_EDU_INF, empMap);
				updateExperianceInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getEduVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EDU_INFO, empMap);
				if (getEduVal == 1) {
					isSuccess = true;
					updateExperianceInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateExperianceInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getExpVal;
		int i = 1;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("organization", employeeMasterBean.getOrganization());
			empMap.put("experienceYear", employeeMasterBean.getExperienceYear());
			empMap.put("expDesisnation", employeeMasterBean.getExpDesisnation());
			empMap.put("expRemarks", employeeMasterBean.getExpRemarks());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_EXP_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_EXP_INF, empMap);
				updateNomineeInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getExpVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EXP_INFO, empMap);
				if (getExpVal == 1) {
					isSuccess = true;
					updateNomineeInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateNomineeInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getNomVal;
		int i = 1;
		try {
			String nomdateOfBirth = employeeMasterBean.getNomdateOfBirth();

			DateFormat formatter;
			Date date = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = formatter.parse(nomdateOfBirth);
				if (date != null) {
					date = formatter.parse(nomdateOfBirth);

				} else {
					date = null;
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean nominateGender = false;
			if (employeeMasterBean.getNominateGender().equals("Male")) {
				nominateGender = true;
			} else if (employeeMasterBean.getNominateGender().equals("Female")) {
				nominateGender = false;
			}
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("nominateName", employeeMasterBean.getNominateName());
			empMap.put("nominateGender", nominateGender);
			empMap.put("nominateOccupation", employeeMasterBean.getNominateOccupation());
			empMap.put("nominateRelationship", employeeMasterBean.getNominateRelationship());
			empMap.put("nominateEmail", employeeMasterBean.getNominateEmail());
			empMap.put("nominatePhone", employeeMasterBean.getNominatePhone());
			empMap.put("nominateMobile", employeeMasterBean.getNominateMobile());
			empMap.put("nomdateOfBirth", nomdateOfBirth);
			empMap.put("nomineAddress", employeeMasterBean.getNomineAddress());
			empMap.put("nominatePincode", employeeMasterBean.getNominatePincode());
			empMap.put("nominatePlace", employeeMasterBean.getNominatePlace());
			empMap.put("uploadPhotoNominee", employeeMasterBean.getUploadPhotoNominee());
			empMap.put("emergPhone", employeeMasterBean.getEmergPhone());
			empMap.put("emergMobile", employeeMasterBean.getEmergMobile());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_NOMINEE_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_NOMINEE_INF, empMap);
				updateMeritInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getNomVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_NOMINEE_INFO, empMap);
				if (getNomVal == 1) {
					isSuccess = true;
					updateMeritInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateMeritInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getMeritVal;
		int i = 1;
		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());

			empMap.put("awardName", employeeMasterBean.getAwardName());
			empMap.put("scholarshipName", employeeMasterBean.getScholarshipName());
			empMap.put("meritDesc", employeeMasterBean.getMeritDesc());

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_MERIT_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_MERIT_INF, empMap);
				updateEmerInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getMeritVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_MERIT_INFO, empMap);
				if (getMeritVal == 1) {
					isSuccess = true;
					updateEmerInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateEmerInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getEmerVal;
		int i = 1;
		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("emergencyName", employeeMasterBean.getEmergencyName());
			empMap.put("emergencyOccu", employeeMasterBean.getEmergencyOccu());
			empMap.put("emergRelationship", employeeMasterBean.getEmergRelationship());
			empMap.put("emergEmail", employeeMasterBean.getEmergEmail());
			empMap.put("emergPhone", employeeMasterBean.getEmergPhone());
			empMap.put("emergMobile", employeeMasterBean.getEmergMobile());
			empMap.put("emergPlace", employeeMasterBean.getEmergPlace());
			empMap.put("emerAddress", employeeMasterBean.getEmerAddress());
			empMap.put("emergencyPincode", employeeMasterBean.getEmergencyPincode());
			empMap.put("emergPhone", employeeMasterBean.getEmergPhone());
			empMap.put("emergMobile", employeeMasterBean.getEmergMobile());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_EMER_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_EMER_INF, empMap);
				updateReferenceInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getEmerVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMER_INFO, empMap);
				if (getEmerVal == 1) {
					isSuccess = true;
					updateReferenceInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
				EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
				UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

				employeeMasterBean.setTableName("employee_master");
				employeeMasterBean.setFormCode("F5031");
				userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
						employeeMasterBean.getEmpId() + "", userDtl.getUserId());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateReferenceInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getRefVal;
		int i = 1;
		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("referenceName", employeeMasterBean.getReferenceName());
			empMap.put("occupationRef", employeeMasterBean.getOccupationRef());
			empMap.put("relationshipRef", employeeMasterBean.getRelationshipRef());
			empMap.put("emailRef", employeeMasterBean.getEmailRef());
			empMap.put("referenceAddress", employeeMasterBean.getReferenceAddress());
			empMap.put("pincodeRef", employeeMasterBean.getPincodeRef());
			empMap.put("emergPhone", employeeMasterBean.getPhoneRef());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_REF_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_REF_INF, empMap);
				// updateDocumentInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getRefVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_REFERENCE_INFO,
						empMap);
				if (getRefVal == 1) {
					isSuccess = true;
					// updateDocumentInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateDocumentInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getDocVal;
		int i = 1;
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			boolean isActiveCash = false;
			if (employeeMasterBean.getIsActiveCash().equals("Y")) {
				isActiveCash = true;
			} else if (employeeMasterBean.getIsActiveCash().equals("N")) {
				isActiveCash = false;
			}
			String issuedDate = employeeMasterBean.getIssuedDate();
			String expiryDate = employeeMasterBean.getExpiryDate();
			String licenseIssuedDate = employeeMasterBean.getLicenseIssuedDate();
			String licenseexpiryDate = employeeMasterBean.getLicenseexpiryDate();
			String renewalDate = employeeMasterBean.getRenewalDate();
			String visaExpiryDate = employeeMasterBean.getVisaExpiryDate();
			String visaIssuedDate = employeeMasterBean.getVisaIssuedDate();

			DateFormat formatter;
			Date date = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = formatter.parse(issuedDate);
				date = formatter.parse(expiryDate);
				date = formatter.parse(licenseIssuedDate);
				date = formatter.parse(licenseexpiryDate);
				date = formatter.parse(renewalDate);
				date = formatter.parse(visaExpiryDate);
				date = formatter.parse(visaIssuedDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("accountNo", employeeMasterBean.getAccountNo());
			empMap.put("bankName", employeeMasterBean.getBankName());
			empMap.put("bankPlace", employeeMasterBean.getBankPlace());
			empMap.put("passportNo", employeeMasterBean.getPassportNo());
			empMap.put("issuedDate", issuedDate);
			empMap.put("expiryDate", expiryDate);
			empMap.put("issuedPlace", employeeMasterBean.getIssuedPlace());
			empMap.put("licenseNo", employeeMasterBean.getLicenseNo());
			empMap.put("licenseType", employeeMasterBean.getLicenseType());
			empMap.put("licenseIssuedDate", licenseIssuedDate);
			empMap.put("licenseexpiryDate", licenseexpiryDate);
			empMap.put("renewalDate", renewalDate);
			empMap.put("joinDocUpload", employeeMasterBean.getJoinDocUpload());
			empMap.put("visaRefNo", employeeMasterBean.getVisaRefNo());
			empMap.put("visaType", employeeMasterBean.getVisaType());
			empMap.put("visaIssuedPlace", employeeMasterBean.getVisaIssuedPlace());
			empMap.put("visaExpiryDate", visaExpiryDate);
			empMap.put("visaIssuedDate", visaIssuedDate);
			empMap.put("isActiveCash", isActiveCash);
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_DOC_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_DOC_INF, empMap);
				updatePhysicalInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getDocVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_DOCUMENT_INFO,
						empMap);
				if (getDocVal == 1) {
					isSuccess = true;
					updatePhysicalInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updatePhysicalInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getPhyVal;
		int i = 1;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try {
			boolean isActiveSight = false;
			boolean isActiveDumb = false;
			boolean isActiveHearing = false;
			boolean isActiveHand = false;
			boolean isActiveFeet = false;

			if (employeeMasterBean.getIsActiveSight().equals("Y")) {
				isActiveSight = true;
			} else if (employeeMasterBean.getIsActiveSight().equals("N")) {
				isActiveSight = false;
			}

			if (employeeMasterBean.getIsActiveDumb().equals("Y")) {
				isActiveDumb = true;
			} else if (employeeMasterBean.getIsActiveDumb().equals("N")) {
				isActiveDumb = false;
			}

			if (employeeMasterBean.getIsActiveHearing().equals("Y")) {
				isActiveHearing = true;
			} else if (employeeMasterBean.getIsActiveHearing().equals("N")) {
				isActiveHearing = false;
			}

			if (employeeMasterBean.getIsActiveHand().equals("Y")) {
				isActiveHand = true;
			} else if (employeeMasterBean.getIsActiveHand().equals("N")) {
				isActiveHand = false;
			}
			if (employeeMasterBean.getIsActiveFeet().equals("Y")) {
				isActiveFeet = true;
			} else if (employeeMasterBean.getIsActiveFeet().equals("N")) {
				isActiveFeet = false;
			}
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("isActiveSight", isActiveSight);
			empMap.put("isActiveDumb", isActiveDumb);
			empMap.put("isActiveHearing", isActiveHearing);
			empMap.put("isActiveHand", isActiveHand);
			empMap.put("isActiveFeet", isActiveFeet);
			empMap.put("otherDisablity", employeeMasterBean.getOtherDisablity());
			empMap.put("height", employeeMasterBean.getHeight());
			empMap.put("weight", employeeMasterBean.getWeight());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_PHY_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_PHY_INF, empMap);
				// updateRuleInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getPhyVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_PHYSICAL_INFO,
						empMap);
				if (getPhyVal == 1) {
					isSuccess = true;
					// updateRuleInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	public boolean updateRuleInfo(EmployeeAdminMasterBean employeeMasterBean) {
		boolean isSuccess = false;
		int getRuleVal;
		int i = 1;
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("overTime", employeeMasterBean.isOverTime());
			empMap.put("esiApp", employeeMasterBean.getEsiApp());
			empMap.put("lateApp", employeeMasterBean.isLateApp());
			empMap.put("pfApp", employeeMasterBean.isPfApp());
			empMap.put("leaveOption", employeeMasterBean.isLeaveOption());
			empMap.put("earlyExit", employeeMasterBean.isEarlyExit());
			empMap.put("telephoneLimit", employeeMasterBean.getTelephoneLimit());
			empMap.put("noticePeriodRule", employeeMasterBean.getNoticePeriodRule());
			empMap.put("medicalLimit", employeeMasterBean.getMedicalLimit());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_RULE_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_RULE_INF, empMap);
				isSuccess = true;
			} else {
				getRuleVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_RULE_INFO, empMap);
				if (getRuleVal == 1) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}
			}
			EmployeeAdminMasterResultBean oldlocationBean = editEmployeeDetail(employeeMasterBean.getEmpId());
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForUpdate(oldlocationBean.getEditList(), employeeMasterBean,
					employeeMasterBean.getEmpId() + "", userDtl.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
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

			EmployeeAdminMasterBean employeeMasterBean = new EmployeeAdminMasterBean();
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_PERSONAL, empId);

			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_ADDRESS_EMPID,
					new Object[] { empId }, Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_ADDRESS, empId));
			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_FAMILY_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_FAMILY, empId));
			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_EDU_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_EDU, empId));
			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_EXP_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_EXP, empId));

			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_RULE_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_RULE, empId));

			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_DOC_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_DOC, empId));

			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_NOMINEE_EMPID,
					new Object[] { empId }, Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_NOMINEE, empId));

			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_MERIT_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_MERIT, empId));

			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_PHY_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_PHY, empId));

			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_EMER_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_EMERG, empId));

			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_REF_EMPID, new Object[] { empId },
					Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_REF, empId));

			} else {
				val += 1;
			}
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_MASTER_DOCUMENT_EMPID,
					new Object[] { empId }, Integer.class);
			if (i > 0) {
				val += (jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_DOCUMETNS, empId));

			} else {
				val += 1;
			}

			if (val == 13) {
				jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_DUPLICATE, empId);
				jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_EMPLOYEE, empId);
				jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMPLOYEE_USER_MASTER, empId);

				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			employeeMasterBean.setTableName("employee_master");
			employeeMasterBean.setFormCode("F5031");
			userlogDAO.userLogForDelete(employeeMasterBean, empId + "", userDtl.getUserId());

		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteEmployee", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public EmployeeAdminMasterResultBean getCompanyList() throws CustomException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> companyList = new ArrayList<EmployeeAdminMasterBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			companyList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_COMPANY_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
			employeeMasterResultBean.setCompanyList(companyList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeAdminMasterResultBean getBranchList() throws CustomException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> branchList = new ArrayList<EmployeeAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			branchList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_BRANCH_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
			employeeMasterResultBean.setBranchList(branchList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getBranchList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}
	@Override
	public EmployeeAdminMasterResultBean getBranchList1(String comp) throws CustomException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> branchList = new ArrayList<EmployeeAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			branchList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_BRANCH_LIST_by_comp,new Object[]{comp},
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
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
	public EmployeeAdminMasterResultBean getDepartmentList() throws CustomException {

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> departmentList = new ArrayList<EmployeeAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			departmentList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_DEPARTMENT_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
			employeeMasterResultBean.setDepartmentList(departmentList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDepartmentList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeAdminMasterResultBean getDesignationList() throws CustomException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> designationList = new ArrayList<EmployeeAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			designationList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_DESIGNATION_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
			employeeMasterResultBean.setDesignationList(designationList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDesignationList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeAdminMasterResultBean getDivisionList() throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> divisionList = new ArrayList<EmployeeAdminMasterBean>();
		try {
			// divisionList =
			// jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_DIVISION_LIST,
			// new
			// BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class),
			// companyCode);
			employeeMasterResultBean.setDivisionList(divisionList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDivisionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeAdminMasterResultBean getGradeList() throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> gradeList = new ArrayList<EmployeeAdminMasterBean>();
		try {
			gradeList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_GRADE_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
			employeeMasterResultBean.setGradeList(gradeList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getGradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeAdminMasterResultBean getReportToBranchList() throws CustomException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> reportToBranchList = new ArrayList<EmployeeAdminMasterBean>();
		try {
			reportToBranchList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_REPORT_BRANCH_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
			employeeMasterResultBean.setReportToBranchList(reportToBranchList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Branch", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeAdminMasterResultBean getReportToDeptList(String branchId) throws CustomException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> reportToDeptList = new ArrayList<EmployeeAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			reportToDeptList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_REPORT_DEPT_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class), branchId);
			employeeMasterResultBean.setReportToDeptList(reportToDeptList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Department", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeAdminMasterResultBean getReportToDesigList(String repManagerId) throws CustomException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> reportToDesigList = new ArrayList<EmployeeAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			reportToDesigList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_REORT_DESIG_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class), repManagerId);
			employeeMasterResultBean.setReportToDesigList(reportToDesigList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Designation", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpTypeList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> empTypeList = new ArrayList<EmployeeAdminMasterBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			empTypeList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_EMP_TYPE_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
			employeeMasterResultBean.setEmpTypeList(empTypeList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Type", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List getReporingManager(int depId, String branchId) {
		List lReportManager = new ArrayList();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList(EmployeeAdminMasterQueryUtil.SELECT_REPORT_MANAGER_LIST, depId, branchId);
			for (Map row : rows) {
				EmployeeAdminMasterBean bean = new EmployeeAdminMasterBean();
				bean.setId((String) row.get("id"));
				bean.setText((String) row.get("text"));
				bean.setReportMangrId((String) row.get("reportMangrId"));
				bean.setReportManagerName((String) row.get("reportManagerName"));
				lReportManager.add(bean);
			}
		} catch (DataAccessException e) {
			// LOGGER.error("Error in getVessel", e);
		}
		return lReportManager;
	}

	@Override
	public EmployeeAdminMasterResultBean uploadFile(MultipartFile file, String employee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		String eId = null;
		String filePath = "";

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss");
		String strDate = sdf.format(cal.getTime());
		if (!file.isEmpty()) {
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				byte[] bytes = file.getBytes();
				String workingDir = System.getProperty("user.dir");
				String fileName;
				String myName;
				String maxId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.GET_MAX_EMPLOYEE_ID,
						String.class);

				fileName = maxId;
				myName = maxId + strDate;

				/*
				 * File dir = new File(getFilePropertyUrl); if (!dir.exists())
				 * dir.mkdirs();
				 */

				// File serverFile = new File(dir.getAbsolutePath() +
				// File.separator + file.getOriginalFilename());
				eId = employee;
				String serverPath = "";
				String currentTimeStamp = file.getOriginalFilename();
				String currentTimeStamp1 = FilenameUtils.getBaseName(file.getOriginalFilename());

				if (eId.equals("null")) {
					System.out.println("getFilePropertyUrl" + getFileUrl);
					System.out.println("getFileServerPath" + getImgPath);
					System.out.println("fileName" + fileName);
					filePath = HisFileUploadUtillity.uploadImgFileHandler(file, getFileUrl, getImgPath, fileName);
					serverPath = "/filePath/" + fileName;
					employeeMasterResultBean.setImgPath(serverPath);
					employeeMasterResultBean
							.setFileName(fileName + '.' + FilenameUtils.getExtension(file.getOriginalFilename()));
				} else {
					System.out.println("getFilePropertyUrl" + getFileUrl);
					System.out.println("getFileServerPath" + getImgPath);
					System.out.println("fileName" + maxId);
					filePath = HisFileUploadUtillity.uploadImgFileHandler(file, getFileUrl, getImgPath, currentTimeStamp1);
					//serverPath = "/filePath/" + fileName;
					serverPath = "/filePath/" + currentTimeStamp;
					employeeMasterResultBean.setImgPath(serverPath);
					employeeMasterResultBean.setFileName(filePath);
				}
				employeeMasterResultBean.setSuccess(true);

			} catch (Exception e) {

			}
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean uploadDocFile(MultipartFile file) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String workingDir = System.getProperty("user.dir");
				File dir = new File(workingDir + "/webapp" + File.separator + "tmpDocFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println(serverFile.getAbsolutePath());
				employeeMasterResultBean.setDocFileName("/document/" + file.getOriginalFilename());
				employeeMasterResultBean.setDocPath(serverFile.getPath());
				System.out.println(serverFile.getPath());

				employeeMasterResultBean.setSuccess(true);
			} catch (Exception e) {

			}
		}
		return employeeMasterResultBean;
	}

	@Override
	public boolean uploadExeFile(MultipartFile file) {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		ArrayList<EmployeeAdminMasterBean> lEmployeeMasterBean = new ArrayList<EmployeeAdminMasterBean>();
		EmployeeAdminMasterBean objEmployeeMasterBean = null;
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
					objEmployeeMasterBean = new EmployeeAdminMasterBean();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0) {
								objEmployeeMasterBean.setFirstName(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 2) {
								objEmployeeMasterBean.setDob(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 3) {
								objEmployeeMasterBean.setDoj(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 5) {
								objEmployeeMasterBean.setMiddleName(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 6) {
								objEmployeeMasterBean.setLastName(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 7) {
								objEmployeeMasterBean.setGender(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 8) {
								objEmployeeMasterBean.setMobileNo(cell.getStringCellValue());
							} else if (cell.getColumnIndex() == 9) {
								objEmployeeMasterBean.setEmailId(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 10) {
								objEmployeeMasterBean.setStatus(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 11) {
								objEmployeeMasterBean.setEpfNo(cell.getStringCellValue());
							} else if (cell.getColumnIndex() == 12) {
								System.out.println("Esi code is" + cell.getStringCellValue());
								objEmployeeMasterBean.setEsic(cell.getStringCellValue());
							} else if (cell.getColumnIndex() == 13) {
								objEmployeeMasterBean.setRelieveDate(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 19) {
								objEmployeeMasterBean.setCompanyCode(cell.getStringCellValue());
							} else if (cell.getColumnIndex() == 20) {
								objEmployeeMasterBean.setReportMangrId(cell.getStringCellValue());
							} else if (cell.getColumnIndex() == 18) {
								objEmployeeMasterBean.setBranch(cell.getStringCellValue().trim());
							}
							break;

						case Cell.CELL_TYPE_NUMERIC:
							if (cell.getColumnIndex() == 1) {
								objEmployeeMasterBean.setDepartmentId(cell.getStringCellValue());
							} else if (cell.getColumnIndex() == 4) {
								objEmployeeMasterBean.setDesignation(cell.getStringCellValue());
							} else if (cell.getColumnIndex() == 15) {
								objEmployeeMasterBean.setDivision((int) (cell.getNumericCellValue()));
							} else if (cell.getColumnIndex() == 16) {
								objEmployeeMasterBean.setGrade((int) (cell.getNumericCellValue()));
							} else if (cell.getColumnIndex() == 17) {
								objEmployeeMasterBean.setEmployeeType((int) (cell.getNumericCellValue()));
							} else if (cell.getColumnIndex() == 14) {
								objEmployeeMasterBean.setFixedGross(Double.valueOf(cell.getNumericCellValue()));
							}
							break;
						}
					}
					lEmployeeMasterBean.add(objEmployeeMasterBean);
				}

			}
			isSuccess = exportDataToDB(lEmployeeMasterBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private boolean exportDataToDB(ArrayList<EmployeeAdminMasterBean> lEmployeeMasterBean) {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			for (EmployeeAdminMasterBean objEmployeeMasterBean : lEmployeeMasterBean) {

				int maxId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.GET_MAX_EMPLOYEE_ID,
						Integer.class);
				int nextId = maxId + 1;
				String employeeId = nextId + "";
				String prefix = "";
				if (employeeId.length() == 1) {
					prefix = "E000";
				} else if (employeeId.length() == 2) {
					prefix = "E00";
				} else if (employeeId.length() == 3) {
					prefix = "E0";
				} else {
					prefix = "E";
				}
				employeeId = prefix + employeeId;

				System.out.println("EmployeeId is" + employeeId);

				Integer branchDeptId = 0, deptBranchId = 0;

				branchDeptId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_BRANCH,
						new Object[] { objEmployeeMasterBean.getBranch(), objEmployeeMasterBean.getDepartmentId() },
						Integer.class);

				if (branchDeptId != null && branchDeptId != 0) {
					deptBranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sGetBranchDepartmentId,
							new Object[] { objEmployeeMasterBean.getBranch(), objEmployeeMasterBean.getDepartmentId() },
							Integer.class);
				} else {

					int[] types = new int[] { Types.VARCHAR, Types.INTEGER };
					Object[] params = new Object[] { objEmployeeMasterBean.getBranch(),
							objEmployeeMasterBean.getDepartmentId() };

					deptBranchId = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sInsertBranchDeparment,
							params, types, Integer.class);
				}

				String EMP_ID = employeeId;
				String EMP_NAME = objEmployeeMasterBean.getFirstName();
				String DEPARTMERNT_ID = objEmployeeMasterBean.getDepartmentId();
				String EMP_USER_ID = employeeId;
				System.out.println("DOB" + objEmployeeMasterBean.getDob());

				System.out.println("Esi code is" + objEmployeeMasterBean.getEsic());
				String DOB = objEmployeeMasterBean.getDob();
				String DOJ = objEmployeeMasterBean.getDoj();
				String reporting_manager = objEmployeeMasterBean.getReportMangrId();
				String RELIEVING_DATE = objEmployeeMasterBean.getRelieveDate();
				String company = objEmployeeMasterBean.getCompanyCode();
				String branch = objEmployeeMasterBean.getBranch();
				int grade_id = objEmployeeMasterBean.getGrade();
				int division_id = objEmployeeMasterBean.getDivision();
				int employee_type = objEmployeeMasterBean.getEmployeeType();
				DateFormat formatter;
				Date dobDate = null, dojDate = null, relievingDate = null;
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				try {
					dobDate = formatter.parse(DOB);
					dojDate = formatter.parse(DOJ);
					relievingDate = formatter.parse(RELIEVING_DATE);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String DESIGNATION_ID = objEmployeeMasterBean.getDesignation();
				String MIDDLE_NAME = objEmployeeMasterBean.getMiddleName();
				String LAST_NAME = objEmployeeMasterBean.getLastName();
				String GENDER = objEmployeeMasterBean.getGender();
				String PHONE_NO = objEmployeeMasterBean.getMobileNo();
				String EMAIL_ID = objEmployeeMasterBean.getEmailId();
				String STATUS_VAl = objEmployeeMasterBean.getStatus();
				boolean STATUS = Boolean.valueOf(STATUS_VAl);
				String EPF_NO = objEmployeeMasterBean.getEpfNo();
				String ESIC_CODE = objEmployeeMasterBean.getEsic();
				double FIXED_GROSS = objEmployeeMasterBean.getFixedGross();

				jdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_EMPLOYEE_UPLOAD,
						new Object[] { EMP_ID, EMP_NAME, DEPARTMERNT_ID, dobDate, dojDate, DESIGNATION_ID, MIDDLE_NAME,
								LAST_NAME, GENDER, PHONE_NO, EMAIL_ID, STATUS, EPF_NO, ESIC_CODE, relievingDate,
								FIXED_GROSS, deptBranchId, grade_id, division_id, employee_type, reporting_manager,
								EMP_USER_ID });
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the employee table", e);
		}
		return isSuccess;

	}

	@Override
	public EmployeeAdminMasterResultBean getEmployeeNameList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeeNameList = new ArrayList<EmployeeAdminMasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			employeeNameList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_EMPLOYEE_NAME_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class),
					userDetail.getCompanyCode());
			employeeMasterResultBean.setEmployeeNameList(employeeNameList);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeeNameList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeExperiance(EmployeeAdminExperianceBean objEmp) {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		// String frmExp = objEmp.getExFrom();
		// String toExp = objEmp.getExTo();
		int value = 0;
		// DateFormat formatter;
		// Date date = null, toExperiance = null, frmExperiance = null;
		// formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			// frmExperiance = formatter.parse(frmExp);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			// toExperiance = formatter.parse(toExp);
			value = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_EMPLOY_EXPERIANCE, objEmp.getEmpId(),
					objEmp.getOrganization(), objEmp.getExperienceYear(), objEmp.getExpDesisnation(),
					objEmp.getExpRemarks(), objEmp.getExFrom(), objEmp.getExTo(), objEmp.getContactname(),
					objEmp.getContactno());
			if (value > 0) {
				objEmployeeMasterResultBean.setEmpId(objEmp.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpExList(String empId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminExperianceBean> lEmployeeExperianceBean = new ArrayList<EmployeeAdminExperianceBean>();
		lEmployeeExperianceBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_EXP, new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminExperianceBean>(EmployeeAdminExperianceBean.class));
		// TODO Auto-generated method stub
		employeeMasterResultBean.setEmployeeExperianceList(lEmployeeExperianceBean);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpEduList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminEducationBean> lEmployeeEducationBean = new ArrayList<EmployeeAdminEducationBean>();
		lEmployeeEducationBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_EDU, new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminEducationBean>(EmployeeAdminEducationBean.class));
		// TODO Auto-generated method stub
		employeeMasterResultBean.setEmployeeEducationBeanList(lEmployeeEducationBean);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpMeritList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMeritsBean> lEmployeeMeritsBean = new ArrayList<EmployeeAdminMeritsBean>();
		lEmployeeMeritsBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_MERITS, new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMeritsBean>(EmployeeAdminMeritsBean.class));
		// TODO Auto-generated method stub
		employeeMasterResultBean.setEmployeeMeritsBeanList(lEmployeeMeritsBean);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpFamList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminFamilyBean> lEmployeeFamilyBean = new ArrayList<EmployeeAdminFamilyBean>();
		lEmployeeFamilyBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_EMP_FAMILY, new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminFamilyBean>(EmployeeAdminFamilyBean.class));
		// TODO Auto-generated method stub
		employeeMasterResultBean.setEmployeeFamilyBeanList(lEmployeeFamilyBean);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getNominationList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminNominationBean> lEmployeeNominationBean = new ArrayList<EmployeeAdminNominationBean>();
		lEmployeeNominationBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_NOMINATION,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminNominationBean>(EmployeeAdminNominationBean.class));
		employeeMasterResultBean.setEmployeeNominationBeanList(lEmployeeNominationBean);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getReferenceList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminReferanceBean> lEmployeeReferanceBean = new ArrayList<EmployeeAdminReferanceBean>();
		lEmployeeReferanceBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_REF_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminReferanceBean>(EmployeeAdminReferanceBean.class));
		employeeMasterResultBean.setEmployeeReferanceBeanList(lEmployeeReferanceBean);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getLeaveList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> lEmployeeReferanceBean = new ArrayList<EmployeeAdminMasterBean>();
		lEmployeeReferanceBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_LEAVELIST_ID,
				new Object[] { empId, empId, empId, empId, empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeeLeaveBeanList(lEmployeeReferanceBean);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getContractList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeecontractBeanList = new ArrayList<EmployeeAdminMasterBean>();
		employeecontractBeanList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_contrcat_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeecontractBeanList(employeecontractBeanList);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getPayslipList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeePayslipBeanList = new ArrayList<EmployeeAdminMasterBean>();
		employeePayslipBeanList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_PAYSLIP_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeePayslipBeanList(employeePayslipBeanList);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getAssetsList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeeLetterAssetsBeanList = new ArrayList<EmployeeAdminMasterBean>();
		employeeLetterAssetsBeanList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_ASSET_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeeLetterAssetsBeanList(employeeLetterAssetsBeanList);
		employeeMasterResultBean.setEmpId(empId);

		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getAirClaimList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> lEmployeeReferanceBean = new ArrayList<EmployeeAdminMasterBean>();
		lEmployeeReferanceBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_AIRCLAIM_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeeAirBeanList(lEmployeeReferanceBean);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getLetterRequestList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> lEmployeeReferanceBean = new ArrayList<EmployeeAdminMasterBean>();
		lEmployeeReferanceBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_LETTERREQUEST_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeeLetterReqBeanList(lEmployeeReferanceBean);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getAddressBookList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> lEmployeeReferanceBean = new ArrayList<EmployeeAdminMasterBean>();
		lEmployeeReferanceBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_ADDRESS_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeeadddressBeanList(lEmployeeReferanceBean);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getSettlementList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> lEmployeeReferanceBean = new ArrayList<EmployeeAdminMasterBean>();
		lEmployeeReferanceBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_SETTLEMENT_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeeSettleBeanList(lEmployeeReferanceBean);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getLoanList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> lEmployeeReferanceBean = new ArrayList<EmployeeAdminMasterBean>();
		lEmployeeReferanceBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_LOANLIST_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeeLoanBeanList(lEmployeeReferanceBean);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getPassportRelease(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeePassportBeanList = new ArrayList<EmployeeAdminMasterBean>();
		employeePassportBeanList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_PASSPORTLIST_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeePassportBeanList(employeePassportBeanList);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getpayrolldeductionList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeePayrolldedBeanList = new ArrayList<EmployeeAdminMasterBean>();
		employeePayrolldedBeanList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_PAYROLLDEDUCTIONLIST_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeePayrolldedBeanList(employeePayrolldedBeanList);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getformList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeeFormrevList = new ArrayList<EmployeeAdminMasterBean>();
		employeeFormrevList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_form_ID, new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeeFormrevList(employeeFormrevList);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getEndofserviceList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeePayrolldedBeanList = new ArrayList<EmployeeAdminMasterBean>();
		employeePayrolldedBeanList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_PAYROLLDEDUCTIONLIST_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeePayrolldedBeanList(employeePayrolldedBeanList);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getPayrollBankList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeePayrollBankBeanList = new ArrayList<EmployeeAdminMasterBean>();
		employeePayrollBankBeanList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_PAYROLLLIST_ID,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeePayrollBankBeanList(employeePayrollBankBeanList);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean gettravelHistorysList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> employeeTravelhistoryBeanList = new ArrayList<EmployeeAdminMasterBean>();
		employeeTravelhistoryBeanList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_TRAVEL_DETAIL,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

		for (int i = 0; i < employeeTravelhistoryBeanList.size(); i++) {
			// TravelReportsBean travelBean = searchList.get(i);
			// EmployeeAdminMasterBean EmployeeAdminMasterBean2 =
			// employeeTravelhistoryBeanList.get(i);
			if (employeeTravelhistoryBeanList.get(i).getRequestType() == 1) {
				employeeTravelhistoryBeanList.get(i).setTravelType("Railway Booking");
			} else if (employeeTravelhistoryBeanList.get(i).getRequestType() == 2) {
				employeeTravelhistoryBeanList.get(i).setTravelType("Air Booking");
			} else if (employeeTravelhistoryBeanList.get(i).getRequestType() == 3) {
				employeeTravelhistoryBeanList.get(i).setTravelType("Hotel Booking");
			}
		}

		employeeMasterResultBean.setEmployeeTravelhistoryBeanList(employeeTravelhistoryBeanList);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getEmergencyList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminEmergencyBean> lEmployeeEmergencyBean = new ArrayList<EmployeeAdminEmergencyBean>();
		lEmployeeEmergencyBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_EMERGENCY,
				new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminEmergencyBean>(EmployeeAdminEmergencyBean.class));
		employeeMasterResultBean.setEmployeeEmergencyBeanList(lEmployeeEmergencyBean);
		employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeMerits(EmployeeAdminMeritsBean objEmployeeMeritsBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMeritsBean objEmployeeMerits = new EmployeeAdminMeritsBean();
		objEmployeeMerits = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_AWARD_ID,
				new Object[] { objEmployeeMeritsBean.getEmpMeritId() },
				new BeanPropertyRowMapper<EmployeeAdminMeritsBean>(EmployeeAdminMeritsBean.class));
		employeeMasterResultBean.setObjEmployeeMeritsBean(objEmployeeMerits);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeFamily(EmployeeAdminFamilyBean objEmployeeFamilyBean) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminFamilyBean objEmployeeFamily = new EmployeeAdminFamilyBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		objEmployeeFamily = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELECT_EMP_FAMILY_BY_DEPENDID,
				new Object[] { objEmployeeFamilyBean.getDependentId() },
				new BeanPropertyRowMapper<EmployeeAdminFamilyBean>(EmployeeAdminFamilyBean.class));

		employeeMasterResultBean.setObjEmployeeFamilyBean(objEmployeeFamily);
		employeeMasterResultBean.setEmpId(objEmployeeFamilyBean.getEmpId());
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeExperiance(EmployeeAdminExperianceBean objEmployeeExperianceBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminExperianceBean objEmployeeExperiance = new EmployeeAdminExperianceBean();
		objEmployeeExperiance = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_EXP_ID,
				new Object[] { objEmployeeExperianceBean.getEmpExpId() },
				new BeanPropertyRowMapper<EmployeeAdminExperianceBean>(EmployeeAdminExperianceBean.class));
		employeeMasterResultBean.setObjEmployeeExperianceBean(objEmployeeExperiance);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeEducation(EmployeeAdminEducationBean objEmployeeEducationBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminEducationBean objEmployeeEducation = new EmployeeAdminEducationBean();
		objEmployeeEducation = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_EDU_ID,
				new Object[] { objEmployeeEducationBean.getEmpEduId() },
				new BeanPropertyRowMapper<EmployeeAdminEducationBean>(EmployeeAdminEducationBean.class));
		employeeMasterResultBean.setObjEmployeeEducationBean(objEmployeeEducation);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeEducation(EmployeeAdminEducationBean objEmployeeEducationBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		jdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMP_EDU, objEmployeeEducationBean.getSpecialization(),
				objEmployeeEducationBean.getQualification(), objEmployeeEducationBean.getPercentage(),
				objEmployeeEducationBean.getCourseType(), objEmployeeEducationBean.getInstitution(),
				objEmployeeEducationBean.getYearPassed(), objEmployeeEducationBean.getEmpEduId());
		employeeMasterResultBean.setSuccess(true);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeFamily(EmployeeAdminFamilyBean objEmployeeFamilyBean) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		Map<String, Object> empFamilyMap = new HashMap<String, Object>();
		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			boolean genderType = false;
			if (objEmployeeFamilyBean.getSex().equals("Male")) {
				genderType = true;
			} else if (objEmployeeFamilyBean.getSex().equals("Female")) {
				genderType = false;
			}

			DateFormat formatter;
			Date date = null, dependentDob = null, dependentPassportIssuedDate = null,
					dependentPassportExpiryDate = null, dependentVisaIssuedDate = null,
					dependentVisaExpirationDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {

				if (objEmployeeFamilyBean.getDependentDob() != null) {
					dependentDob = formatter.parse(objEmployeeFamilyBean.getDependentDob());
				}

				if (objEmployeeFamilyBean.getDependentPassportIssuedDate() != null) {
					dependentPassportIssuedDate = formatter
							.parse(objEmployeeFamilyBean.getDependentPassportIssuedDate());
				}

				if (objEmployeeFamilyBean.getDependentPassportExpiryDate() != null) {
					dependentPassportExpiryDate = formatter
							.parse(objEmployeeFamilyBean.getDependentPassportExpiryDate());
				}

				if (objEmployeeFamilyBean.getDependentVisaIssuedDate() != null) {
					dependentVisaIssuedDate = formatter.parse(objEmployeeFamilyBean.getDependentVisaIssuedDate());
				}

				if (objEmployeeFamilyBean.getDependentVisaExpirationDate() != null) {
					dependentVisaExpirationDate = formatter
							.parse(objEmployeeFamilyBean.getDependentVisaExpirationDate());
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("dependentOnEmployee" + objEmployeeFamilyBean.isDependentOnEmployee());

			empFamilyMap.put("aadharno1", objEmployeeFamilyBean.getAadharno1());
			empFamilyMap.put("mobileno", objEmployeeFamilyBean.getMobileno());
			empFamilyMap.put("dependentId", objEmployeeFamilyBean.getDependentId());
			empFamilyMap.put("employeeId", objEmployeeFamilyBean.getEmployeeId());
			empFamilyMap.put("dependentDob", dependentDob);
			empFamilyMap.put("age", objEmployeeFamilyBean.getAge());
			empFamilyMap.put("sex", genderType);
			empFamilyMap.put("relativeName", objEmployeeFamilyBean.getRelativeName());
			empFamilyMap.put("relationToEmployee", objEmployeeFamilyBean.getRelationToEmployee());
			empFamilyMap.put("dependentOnEmployee", objEmployeeFamilyBean.isDependentOnEmployee());
			empFamilyMap.put("dependentPassportNo", objEmployeeFamilyBean.getDependentPassportNo());
			empFamilyMap.put("dependentPassportIssuedDate", dependentPassportIssuedDate);
			empFamilyMap.put("dependentPassportExpiryDate", dependentPassportExpiryDate);
			empFamilyMap.put("dependentPassportIssuedPlace", objEmployeeFamilyBean.getDependentPassportIssuedPlace());
			empFamilyMap.put("dependentVisaReferenceNumber", objEmployeeFamilyBean.getDependentVisaReferenceNumber());
			empFamilyMap.put("dependentVisaType", objEmployeeFamilyBean.getDependentVisaType());
			empFamilyMap.put("dependentVisaIssuedPlace", objEmployeeFamilyBean.getDependentVisaIssuedPlace());
			empFamilyMap.put("dependentVisaIssuedDate", dependentVisaIssuedDate);
			empFamilyMap.put("dependentVisaExpirationDate", dependentVisaExpirationDate);
			empFamilyMap.put("dependentPhotoUrl", objEmployeeFamilyBean.getDependentPhotoUrl());
			empFamilyMap.put("dependentMedicalEntitlement", objEmployeeFamilyBean.getDependentMedicalEntitlement());
			namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMP_FAMILY, empFamilyMap);
			employeeMasterResultBean.setSuccess(true);
			return employeeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in updateEmployeeFamily", e);

		}
		return employeeMasterResultBean;

		// EmployeeMasterResultBean employeeMasterResultBean = new
		// EmployeeMasterResultBean();
		// jdbcTemplate.update(EmployeeMasterQueryUtil.UPDATE_EMP_FAMILY,
		// objEmployeeFamilyBean.getFamilyName(),
		// objEmployeeFamilyBean.getGenderType(),
		// objEmployeeFamilyBean.getRelationshipWithEmp(),
		// objEmployeeFamilyBean.getEmpDependence(),
		// objEmployeeFamilyBean.getUploadPhotoFamily(),
		// objEmployeeFamilyBean.getEmpFamilyId());

	}

	@Override
	public EmployeeAdminMasterResultBean UpdateExperianceDetail(EmployeeAdminExperianceBean objEmployeeExperianceBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		jdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMP_EXPERIANCE,
				objEmployeeExperianceBean.getContactname(), objEmployeeExperianceBean.getContactno(),
				objEmployeeExperianceBean.getOrganization(), objEmployeeExperianceBean.getExperienceYear(),
				objEmployeeExperianceBean.getExpDesisnation(), objEmployeeExperianceBean.getExpRemarks(),
				objEmployeeExperianceBean.getExFrom(), objEmployeeExperianceBean.getExTo(),
				objEmployeeExperianceBean.getEmpExpId());
		employeeMasterResultBean.setSuccess(true);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeMerit(EmployeeAdminMeritsBean objEmployeeMeritsBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		jdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMP_MERITS, objEmployeeMeritsBean.getAwardName(),
				objEmployeeMeritsBean.getScholarshipName(), objEmployeeMeritsBean.getMeritDesc(),
				objEmployeeMeritsBean.getEmpMeritId());
		employeeMasterResultBean.setSuccess(true);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeReference(EmployeeAdminReferanceBean objeBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminReferanceBean objEmployeeReferance = new EmployeeAdminReferanceBean();
		// List<EmployeeReferanceBean> lEmployeeReferanceBean = new
		// ArrayList<EmployeeReferanceBean>();
		objEmployeeReferance = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_REFERENCE,
				new Object[] { objeBean.getEmpRefId() },
				new BeanPropertyRowMapper<EmployeeAdminReferanceBean>(EmployeeAdminReferanceBean.class));
		// lEmployeeReferanceBean =
		// jdbcTemplate.query(EmployeeMasterQueryUtil.SELET_EMP_Phone_No, new
		// Object[] { objeBean.getEmpRefId() }, new
		// BeanPropertyRowMapper<EmployeeReferanceBean>(EmployeeReferanceBean.class));
		employeeMasterResultBean.setObjEmployeeReferanceBean(objEmployeeReferance);
		// employeeMasterResultBean.setEmployeeReferanceBeanList(lEmployeeReferanceBean);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeEmergency(EmployeeAdminEmergencyBean objBean) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminEmergencyBean objEmployeeEmergency = new EmployeeAdminEmergencyBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		/*
		 * List<EmployeeEmergencyBean> lEmployeePhone = new
		 * ArrayList<EmployeeEmergencyBean>(); List<EmployeeEmergencyBean>
		 * lEmployeeMobile = new ArrayList<EmployeeEmergencyBean>();
		 */
		objEmployeeEmergency = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_EMERGENCY_ID,
				new Object[] { objBean.getEmplEmerId() },
				new BeanPropertyRowMapper<EmployeeAdminEmergencyBean>(EmployeeAdminEmergencyBean.class));
		// lEmployeePhone =
		// jdbcTemplate.query(EmployeeMasterQueryUtil.SELET_EMP_EME_Phone, new
		// Object[] { objBean.getEmplEmerId() }, new
		// BeanPropertyRowMapper<EmployeeEmergencyBean>(EmployeeEmergencyBean.class));
		// lEmployeeMobile =
		// jdbcTemplate.query(EmployeeMasterQueryUtil.SELET_EMP_EME_MOBILE, new
		// Object[] { objBean.getEmplEmerId() }, new
		// BeanPropertyRowMapper<EmployeeEmergencyBean>(EmployeeEmergencyBean.class));
		// employeeMasterResultBean.setEmployeeEmeMobNoList(lEmployeeMobile);
		// employeeMasterResultBean.setEmployeeEmePhNoList(lEmployeePhone);
		employeeMasterResultBean.setObjEmployeeEmergencyBean(objEmployeeEmergency);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeNomination(EmployeeAdminNominationBean objEmp) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminNominationBean objEmployeeNomination = new EmployeeAdminNominationBean();
		// List<EmployeeNominationBean> lEmployeePhone = new
		// ArrayList<EmployeeNominationBean>();
		// List<EmployeeNominationBean> lEmployeeMobile = new
		// ArrayList<EmployeeNominationBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		objEmployeeNomination = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_NOMINATION_ID,
				new Object[] { objEmp.getEmployeeNomId() },
				new BeanPropertyRowMapper<EmployeeAdminNominationBean>(EmployeeAdminNominationBean.class));
		// lEmployeePhone =
		// jdbcTemplate.query(EmployeeMasterQueryUtil.SELET_EMP_NOM_PH_No, new
		// Object[] { objEmp.getEmployeeNomId() }, new
		// BeanPropertyRowMapper<EmployeeNominationBean>(EmployeeNominationBean.class));
		// lEmployeeMobile =
		// jdbcTemplate.query(EmployeeMasterQueryUtil.SELET_EMP_NOM_MOB_No, new
		// Object[] { objEmp.getEmployeeNomId() }, new
		// BeanPropertyRowMapper<EmployeeNominationBean>(EmployeeNominationBean.class));
		employeeMasterResultBean.setObjEmployeeNominationBean(objEmployeeNomination);
		// employeeMasterResultBean.setEmployeeMobileNoList(lEmployeeMobile);
		// employeeMasterResultBean.setEmployeePhoneNoList(lEmployeePhone);
		employeeMasterResultBean.setEmpId(objEmp.getEmpId());
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeReference(EmployeeAdminReferanceBean objEmployeeReferanceBean) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		String employeeId = objEmployeeReferanceBean.getEmpId();
		// jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_PHONE_REF,
		// objEmployeeReferanceBean.getEmpRefId());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_REF_EMPLOYEE,
				objEmployeeReferanceBean.getOccupationRef(), objEmployeeReferanceBean.getEmailRef(),
				objEmployeeReferanceBean.getRelationshipRef(), objEmployeeReferanceBean.getPincodeRef(),
				objEmployeeReferanceBean.getReferenceAddress(), objEmployeeReferanceBean.getReferenceName(),
				objEmployeeReferanceBean.getEmpRefId());
		/*
		 * List<EmployeeReferanceBean> lEmployeeReferanceBean =
		 * objEmployeeReferanceBean.getPhoneRefMultiple(); for
		 * (EmployeeReferanceBean objEmployeeReferance : lEmployeeReferanceBean)
		 * { jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_REF_PHONE_NO,
		 * employeeId, objEmployeeReferance.getEmpRefId(),
		 * objEmployeeReferance.getEmergPhone()); }
		 */
		employeeMasterResultBean.setSuccess(true);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeEmergency(EmployeeAdminEmergencyBean objEmployeeEmergencyBean) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		String employeeId = objEmployeeEmergencyBean.getEmpId();
		/*
		 * jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_PHONE_EME,
		 * objEmployeeEmergencyBean.getEmplEmerId());
		 * jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_MOBILE_EME,
		 * objEmployeeEmergencyBean.getEmplEmerId());
		 */
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMER_EMPLOYEE,
				objEmployeeEmergencyBean.getEmergencyName(), objEmployeeEmergencyBean.getEmergencyOccu(),
				objEmployeeEmergencyBean.getEmergRelationship(), objEmployeeEmergencyBean.getEmergEmail(),
				objEmployeeEmergencyBean.getEmergPlace(), objEmployeeEmergencyBean.getEmerAddress(),
				objEmployeeEmergencyBean.getEmergencyPincode(), objEmployeeEmergencyBean.getEmergPhone(),
				objEmployeeEmergencyBean.getEmergMobile(), objEmployeeEmergencyBean.getEmplEmerId());
		/*
		 * List<EmployeeEmergencyBean> lEmployeeMobile =
		 * objEmployeeEmergencyBean.getMobileNoMultiple();
		 * List<EmployeeEmergencyBean> lEmployeePhone =
		 * objEmployeeEmergencyBean.getPhoneNoMultiple(); for
		 * (EmployeeEmergencyBean objEmployeeMobile : lEmployeeMobile) {
		 * jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_EMER_MOBILE_NO,
		 * employeeId, objEmployeeEmergencyBean.getEmplEmerId(),
		 * objEmployeeMobile.getEmergMobile()); } for (EmployeeEmergencyBean
		 * objEmployeePhone : lEmployeePhone) {
		 * jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_EMER_PHONE_NO,
		 * employeeId, objEmployeeEmergencyBean.getEmplEmerId(),
		 * objEmployeePhone.getEmergPhone()); }
		 */
		employeeMasterResultBean.setSuccess(true);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeNomination(
			EmployeeAdminNominationBean objEmployeeNominationBean) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		String employeeId = objEmployeeNominationBean.getEmpId();
		// jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_PHONE_NOM,
		// objEmployeeNominationBean.getEmployeeNomId());
		// jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_MOBILE_NOM,
		// objEmployeeNominationBean.getEmployeeNomId());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_MOBILE_NOM, objEmployeeNominationBean.getAadharno2(),
				objEmployeeNominationBean.getNominateName(), objEmployeeNominationBean.getNominateGender(),
				objEmployeeNominationBean.getNominateOccupation(), objEmployeeNominationBean.getNominateRelationship(),
				objEmployeeNominationBean.getNominateEmail(), objEmployeeNominationBean.getNomdateOfBirth(),
				objEmployeeNominationBean.getNomineAddress(), objEmployeeNominationBean.getNominatePincode(),
				objEmployeeNominationBean.getNominatePlace(), objEmployeeNominationBean.getEmergPhone(),
				objEmployeeNominationBean.getEmergMobile(), objEmployeeNominationBean.getEmployeeNomId());
		/*
		 * List<EmployeeNominationBean> lEmployeeMobile =
		 * objEmployeeNominationBean.getNominateMobileMultiple();
		 * List<EmployeeNominationBean> lEmployeePhone =
		 * objEmployeeNominationBean.getNominatePhoneMultiple(); for
		 * (EmployeeNominationBean objEmployeeMobile : lEmployeeMobile) {
		 * jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_NOM_MOBILE_NO,
		 * employeeId, objEmployeeNominationBean.getEmployeeNomId(),
		 * objEmployeeMobile.getEmergMobile()); } for (EmployeeNominationBean
		 * objEmployeePhone : lEmployeePhone) {
		 * jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_NOM_PHONE_NO,
		 * employeeId, objEmployeeNominationBean.getEmployeeNomId(),
		 * objEmployeePhone.getEmergPhone()); }
		 */
		employeeMasterResultBean.setSuccess(true);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeePersonal(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try {
			int getPersonalVal;
			boolean personalStatus = true;
			boolean mStatus;
			int marStatus;
			String marriageDate = objEmployee.getConfirmDate();
			String confirmDate = objEmployee.getConfirmDate();
			String resignationDate = objEmployee.getResignationDate();

			DateFormat formatter;
			Date date = null;

			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = formatter.parse(marriageDate);
				date = formatter.parse(confirmDate);
				date = formatter.parse(resignationDate);
			} catch (ParseException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

			Map<String, Object> empMap = new HashMap<String, Object>();

			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("marritalStatus", objEmployee.isMarritalStatus());
			empMap.put("guardianName", objEmployee.getGuardianName());
			// empMap.put("motherName", objEmployee.getMotherName());
			// empMap.put("guardiansName", objEmployee.getGuardiansName());
			empMap.put("husbWifeName", objEmployee.getHusbWifeName());
			empMap.put("bloodGrp", Integer.parseInt(objEmployee.getBloodGrp()));
			empMap.put("caste", objEmployee.getCaste());
			empMap.put("religion", objEmployee.getReligion());
			empMap.put("motherTongue", objEmployee.getMotherTongue());
			empMap.put("languages", objEmployee.getLanguages());
			empMap.put("nationality", objEmployee.getNationality());
			empMap.put("panNo", objEmployee.getPanNo());
			empMap.put("hobbies", objEmployee.getHobbies());
			empMap.put("remarks", objEmployee.getRemarks());
			empMap.put("confirmDate", confirmDate);
			empMap.put("confirmationPeriod", objEmployee.getConfirmationPeriod());
			empMap.put("gratuityNominee", objEmployee.getGratuityNominee());
			empMap.put("nomineeRelation", objEmployee.getNomineeRelation());
			empMap.put("modeConveyence", objEmployee.getModeConveyence());
			empMap.put("emgContactNo", objEmployee.getEmgContactNo());
			empMap.put("emgContactName", objEmployee.getEmgContactName());
			empMap.put("resignationDate", resignationDate);
			// empMap.put("race", objEmployee.getRace());
			empMap.put("noticePeriod", objEmployee.getNoticePeriod());
			empMap.put("personalStatus", personalStatus);
			empMap.put("aadharno", objEmployee.getAadharno());

			empMap.put("married", objEmployee.getMarried());
			// empMap.put("marriageDate", marriageDate);
			getPersonalVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PERSONAL_INF,
					empMap);
			if (getPersonalVal == 1) {
				objEmployeeMasterResultBean.setSuccess(true);
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				// isSuccess = true;
				// saveAddressInfo(objEmployee);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeAddress(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getAddressVal;
			int presentAddressId = 0;
			boolean isActiveAddress = false;
			boolean isActiveOldAddress = false;
			String empID = "";
			if (objEmployee.getIsActiveAddress().equals("Y")) {
				isActiveAddress = true;
			}
			/*
			 * if (objEmployee.getIsActiveOldAddress().equals("Y")) {
			 * isActiveOldAddress = true; }
			 */
			empID = objEmployee.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("permAddress", objEmployee.getPermAddress());
			empMap.put("permPlace", objEmployee.getPermPlace());
			empMap.put("permDistrict", objEmployee.getPermDistrict());
			empMap.put("permState", objEmployee.getPermState());
			empMap.put("permPin", objEmployee.getPermPin());
			empMap.put("permPhone", objEmployee.getPermPhone());
			empMap.put("permMobile", objEmployee.getPermMobile());
			// empMap.put("isActiveAddress", isActiveAddress);
			empMap.put("presentAddress", objEmployee.getPresentAddress());
			empMap.put("presentPlace", objEmployee.getPresentPlace());
			empMap.put("presentDistrict", objEmployee.getPresentDistrict());
			empMap.put("presentPin", objEmployee.getPresentPin());
			empMap.put("presentPhone", objEmployee.getPresentPhone());
			empMap.put("presentMobile", objEmployee.getPresentMobile());

			String employeeId = objEmployee.getEmpId();
			getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ADDRESS_INF, empMap);

			objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;

	}

	@Override
	public EmployeeAdminMasterResultBean savePayBank(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getAddressVal;

			String empID = "";

			empID = objEmployee.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("paybankname", objEmployee.getPaybankname());
			empMap.put("paybankacctName", objEmployee.getPaybankacctName());
			empMap.put("iban", objEmployee.getIban());
			empMap.put("payAcctNum", objEmployee.getPayAcctNum());
			empMap.put("paybankBranch", objEmployee.getPaybankBranch());
			empMap.put("paycomments", objEmployee.getPaycomments());

			String employeeId = objEmployee.getEmpId();
			getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PAYBANK_INF, empMap);

			objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;

	}

	@Override
	public EmployeeAdminMasterResultBean savefrmAssets(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getAddressVal;

			String empID = "";

			empID = objEmployee.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("assetName", objEmployee.getAssetName());
			empMap.put("assetType", objEmployee.getAssetType());
			empMap.put("assetdesc", objEmployee.getAssetdesc());
			empMap.put("assetstatus", objEmployee.getAssetstatus());
			empMap.put("assetlocation", objEmployee.getAssetlocation());
			empMap.put("assetquantity", objEmployee.getAssetquantity());

			String employeeId = objEmployee.getEmpId();
			getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ASSETS_INF, empMap);

			objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;

	}

	@Override
	public EmployeeAdminMasterResultBean saveAirClaim(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getAddressVal;

			String empID = "";
			String airdueDate = objEmployee.getAirdueDate();

			DateFormat formatter;
			Date requestDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			requestDate = formatter.parse(airdueDate);

			empID = objEmployee.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("ticksec", objEmployee.getTicksec());
			empMap.put("airclass", objEmployee.getAirclass());
			empMap.put("airclaimcomments", objEmployee.getAirclaimcomments());
			empMap.put("airdueDate", requestDate);
			empMap.put("airselftickAmt", objEmployee.getAirselftickAmt());
			empMap.put("airadulttickAmt", objEmployee.getAiradulttickAmt());

			empMap.put("airinfanttickAmt", objEmployee.getAirinfanttickAmt());
			empMap.put("airChildtickAmt", objEmployee.getAirChildtickAmt());
			empMap.put("airselftick", objEmployee.getAirselftick());
			empMap.put("airadulttick", objEmployee.getAiradulttick());
			empMap.put("airinfanttick", objEmployee.getAirinfanttick());
			empMap.put("airChildtick", objEmployee.getAirChildtick());

			// String employeeId = objEmployee.getEmpId();
			getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_AIRCLAIMS_INF,
					empMap);

			objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (DataAccessException | ParseException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;

	}

	@Override
	public EmployeeAdminMasterResultBean saveSettle(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getAddressVal;

			String empID = "";
			String settlelastDate = objEmployee.getSettlelastDate();

			DateFormat formatter;
			Date requestDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			requestDate = formatter.parse(settlelastDate);

			empID = objEmployee.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("settleType", objEmployee.getSettleType());
			empMap.put("settleCurrency", objEmployee.getSettleCurrency());
			empMap.put("settlecomments", objEmployee.getSettlecomments());
			empMap.put("settlelastDate", requestDate);

			// String employeeId = objEmployee.getEmpId();
			getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_SETTLEMET_INF,
					empMap);

			objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (DataAccessException | ParseException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;

	}

	@Override
	public EmployeeAdminMasterResultBean savePassport(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getAddressVal;

			String empID = "";
			String passrequestDate = objEmployee.getPassrequestDate();

			DateFormat formatter;
			Date requestDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			requestDate = formatter.parse(passrequestDate);

			empID = objEmployee.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("passrequestType", objEmployee.getPassrequestType());
			empMap.put("passrequestDate", requestDate);
			empMap.put("passrequestcomments", objEmployee.getPassrequestcomments());

			// String employeeId = objEmployee.getEmpId();
			getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PASSPORT_INF, empMap);

			objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (DataAccessException | ParseException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;

	}

	@Override
	public EmployeeAdminMasterResultBean saveFormReview(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getAddressVal;

			String empID = "";
			String formreviewDate = objEmployee.getFormreviewDate();

			DateFormat formatter;
			Date requestDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			requestDate = formatter.parse(formreviewDate);

			empID = objEmployee.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("formreviewType", objEmployee.getPassrequestType());
			empMap.put("formreviewDate", requestDate);
			empMap.put("formreviewtemplete", objEmployee.getFormreviewtemplete());
			empMap.put("formsreviewcomments", objEmployee.getFormsreviewcomments());

			// String employeeId = objEmployee.getEmpId();
			getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_FORMs_REVIEW, empMap);

			objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (DataAccessException | ParseException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;

	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeRule(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			int getRuleVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("overTime", objEmployee.isOverTime());
			empMap.put("esiApp", objEmployee.getEsiApp());
			empMap.put("lateApp", objEmployee.isLateApp());
			empMap.put("telephoneLimit", objEmployee.getTelephoneLimit());
			empMap.put("pfApp", objEmployee.isPfApp());
			empMap.put("leaveOption", objEmployee.isLeaveOption());
			empMap.put("noticePeriodRule", objEmployee.getNoticePeriodRule());
			empMap.put("earlyExit", objEmployee.isEarlyExit());
			empMap.put("medicalLimit", objEmployee.getMedicalLimit());

			getRuleVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_RULES_INF, empMap);
			if (getRuleVal == 1) {
				objEmployeeMasterResultBean.setSuccess(true);
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;

	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeDocument(EmployeeAdminMasterBean objEmployee) {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		// TODO Auto-generated method stub
		try {
			int getDocVal;
			boolean isActiveCash = false;
			if (objEmployee.getIsActiveCash().equals("Y")) {
				isActiveCash = true;
			}

			DateFormat formatter;

			Date issuDate = null;
			Date expdate = null;
			Date linissuedate = null;
			Date linexpdate = null;
			Date renrewdate = null;
			Date visaExpdate = null;
			Date visaIsuedate = null;

			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				if (objEmployee.getIssuedDate() != null) {
					issuDate = formatter.parse(objEmployee.getIssuedDate());
				}
				if (objEmployee.getExpiryDate() != null) {
					expdate = formatter.parse(objEmployee.getExpiryDate());
				}

				if (objEmployee.getLicenseIssuedDate() != null) {
					linissuedate = formatter.parse(objEmployee.getLicenseIssuedDate());
				}

				if (objEmployee.getLicenseexpiryDate() != null) {
					linexpdate = formatter.parse(objEmployee.getLicenseexpiryDate());
				}

				if (objEmployee.getRenewalDate() != null) {
					renrewdate = formatter.parse(objEmployee.getRenewalDate());
				}
				if (objEmployee.getVisaIssuedDate() != null) {
					visaIsuedate = formatter.parse(objEmployee.getVisaIssuedDate());
				}

				if (objEmployee.getVisaExpiryDate() != null) {
					visaExpdate = formatter.parse(objEmployee.getVisaExpiryDate());
				}
			} catch (Exception e) {

			}

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("accountNo", objEmployee.getAccountNo());
			empMap.put("bankName", objEmployee.getBankName());
			empMap.put("bankPlace", objEmployee.getBankPlace());
			empMap.put("passportNo", objEmployee.getPassportNo());
			empMap.put("issuedDate", issuDate);
			empMap.put("expiryDate", expdate);
			empMap.put("issuedPlace", objEmployee.getIssuedPlace());
			empMap.put("licenseNo", objEmployee.getLicenseNo());
			empMap.put("licenseType", objEmployee.getLicenseType());
			empMap.put("licenseIssuedDate", linissuedate);
			empMap.put("licenseexpiryDate", linexpdate);
			empMap.put("joinDocUpload", objEmployee.getJoinDocUpload());
			empMap.put("visaRefNo", objEmployee.getVisaRefNo());
			empMap.put("visaType", objEmployee.getVisaType());
			empMap.put("visaIssuedPlace", objEmployee.getVisaIssuedPlace());
			empMap.put("visaIssuedDate", visaIsuedate);
			empMap.put("visaExpiryDate", visaExpdate);
			empMap.put("linceseRenewdDate", renrewdate);

			empMap.put("isActiveCash", isActiveCash);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getDocVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_DOCUMENT_INF, empMap);
			if (getDocVal == 1) {
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeePhysical(EmployeeAdminMasterBean objEmployee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			boolean isActiveSight = false, isActiveDumb = false, isActiveHearing = false, isActiveHand = false,
					isActiveFeet = false, isLeftSidePower = false, IsRightSidePower = false;
			int getPhyVal;
			if (objEmployee.getIsActiveSight().equals("Y")) {
				isActiveSight = true;
			}
			if (objEmployee.getIsActiveDumb().equals("Y")) {
				isActiveDumb = true;
			}
			if (objEmployee.getIsActiveHearing().equals("Y")) {
				isActiveHearing = true;
			}
			if (objEmployee.getIsActiveHand().equals("Y")) {
				isActiveHand = true;
			}
			if (objEmployee.getIsActiveFeet().equals("Y")) {
				isActiveFeet = true;
			}

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("isActiveSight", isActiveSight);
			empMap.put("isActiveDumb", isActiveDumb);
			empMap.put("isActiveHearing", isActiveHearing);
			empMap.put("isActiveHand", isActiveHand);
			empMap.put("isActiveFeet", isActiveFeet);
			empMap.put("LeftSidePower", objEmployee.getLeftSidePower());
			empMap.put("RightSidePower", objEmployee.getRightSidePower());
			empMap.put("otherDisablity", objEmployee.getOtherDisablity());
			empMap.put("height", objEmployee.getHeight());
			empMap.put("weight", objEmployee.getWeight());
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getPhyVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PHYSICAL_INF, empMap);
			if (getPhyVal == 1) {
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
				// saveEmergencyInfo(objEmployee);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeFamily(EmployeeAdminFamilyBean empMasterBean) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		Map<String, Object> empFamilyMap = new HashMap<String, Object>();

		try {
			int getEduVal = 0;
			boolean genderType = false;
			if (empMasterBean.getSex().equals("Male")) {
				genderType = true;
			} else if (empMasterBean.getSex().equals("Female")) {
				genderType = false;
			}

			DateFormat formatter;
			Date date = null, dependentDob = null, dependentPassportIssuedDate = null,
					dependentPassportExpiryDate = null, dependentVisaIssuedDate = null,
					dependentVisaExpirationDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {

				if (empMasterBean.getDependentDob() != null) {
					dependentDob = formatter.parse(empMasterBean.getDependentDob());
				}

				if (empMasterBean.getDependentPassportIssuedDate() != null
						&& !empMasterBean.getDependentPassportIssuedDate().equalsIgnoreCase("")) {
					dependentPassportIssuedDate = formatter.parse(empMasterBean.getDependentPassportIssuedDate());
				}

				if (empMasterBean.getDependentPassportExpiryDate() != null) {
					dependentPassportExpiryDate = formatter.parse(empMasterBean.getDependentPassportExpiryDate());
				}

				if (empMasterBean.getDependentVisaIssuedDate() != null) {
					dependentVisaIssuedDate = formatter.parse(empMasterBean.getDependentVisaIssuedDate());
				}

				if (empMasterBean.getDependentVisaExpirationDate() != null) {
					dependentVisaExpirationDate = formatter.parse(empMasterBean.getDependentVisaExpirationDate());
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			empFamilyMap.put("employeeId", empMasterBean.getEmployeeId());
			empFamilyMap.put("dependentDob", dependentDob);
			empFamilyMap.put("age", empMasterBean.getAge());
			empFamilyMap.put("sex", genderType);
			empFamilyMap.put("relativeName", empMasterBean.getRelativeName());
			empFamilyMap.put("relationToEmployee", empMasterBean.getRelationToEmployee());
			empFamilyMap.put("dependentOnEmployee", empMasterBean.isDependentOnEmployee());
			empFamilyMap.put("dependentPassportNo", empMasterBean.getDependentPassportNo());
			empFamilyMap.put("dependentPassportIssuedDate", dependentPassportIssuedDate);
			empFamilyMap.put("dependentPassportExpiryDate", dependentPassportExpiryDate);
			empFamilyMap.put("dependentPassportIssuedPlace", empMasterBean.getDependentPassportIssuedPlace());
			empFamilyMap.put("dependentVisaReferenceNumber", empMasterBean.getDependentVisaReferenceNumber());
			empFamilyMap.put("dependentVisaType", empMasterBean.getDependentVisaType());
			empFamilyMap.put("dependentVisaIssuedPlace", empMasterBean.getDependentVisaIssuedPlace());
			empFamilyMap.put("dependentVisaIssuedDate", dependentVisaIssuedDate);
			empFamilyMap.put("dependentVisaExpirationDate", dependentVisaExpirationDate);
			empFamilyMap.put("dependentPhotoUrl", empMasterBean.getDependentPhotoUrl());
			empFamilyMap.put("dependentMedicalEntitlement", empMasterBean.getDependentMedicalEntitlement());
			empFamilyMap.put("aadharno", empMasterBean.getAadharno());
			empFamilyMap.put("mobileno", empMasterBean.getMobileno());

			namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_EMP_FAMILY, empFamilyMap);
			if (getEduVal == 1) {
				objEmployeeMasterResultBean.setEmpId(empMasterBean.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertEmployeeFamily", e);

		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeEducation(EmployeeAdminEducationBean objEmployee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try {
			int getEduVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("qualification", objEmployee.getQualification());
			empMap.put("percentage", objEmployee.getPercentage());
			empMap.put("courseType", objEmployee.getCourseType());
			empMap.put("institution", objEmployee.getInstitution());
			empMap.put("yearPassed", objEmployee.getYearPassed());
			empMap.put("specialization", objEmployee.getSpecialization());
			getEduVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_EDUC_INF, empMap);
			if (getEduVal == 1) {
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeMerits(EmployeeAdminMeritsBean objEmployee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			int getMeritVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("awardName", objEmployee.getAwardName());
			empMap.put("scholarshipName", objEmployee.getScholarshipName());
			empMap.put("meritDesc", objEmployee.getMeritDesc());
			getMeritVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_MERIT_INF, empMap);
			if (getMeritVal == 1) {
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeEmergency(EmployeeAdminEmergencyBean objEmployee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getEmerVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("emergencyName", objEmployee.getEmergencyName());
			empMap.put("emergencyOccu", objEmployee.getEmergencyOccu());
			empMap.put("emergRelationship", objEmployee.getEmergRelationship());
			empMap.put("emergEmail", objEmployee.getEmergEmail());
			empMap.put("emergPlace", objEmployee.getEmergPlace());
			empMap.put("emerAddress", objEmployee.getEmerAddress());
			empMap.put("emergencyPincode", objEmployee.getEmergencyPincode());
			empMap.put("emergPhone", objEmployee.getEmergPhone());
			empMap.put("emergMobile", objEmployee.getEmergMobile());
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getEmerVal = namedParameterJdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.INSERT_EMERGENCY_INF,
					empMap, Integer.class);
			/*
			 * List<EmployeeEmergencyBean> lEmployeeMobile =
			 * objEmployee.getMobileNoMultiple(); List<EmployeeEmergencyBean>
			 * lEmployeePhone = objEmployee.getPhoneNoMultiple(); for
			 * (EmployeeEmergencyBean objEmergencyMobile : lEmployeeMobile) {
			 * jdbcTemplate
			 * .update(EmployeeMasterQueryUtil.INSERT_EMER_MOBILE_NO,
			 * objEmployee.getEmpId(), getEmerVal,
			 * objEmergencyMobile.getEmergMobile());
			 * 
			 * } for (EmployeeEmergencyBean objEmergencyPhone : lEmployeePhone)
			 * {
			 * jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_EMER_PHONE_NO,
			 * objEmployee.getEmpId(), getEmerVal,
			 * objEmergencyPhone.getEmergPhone()); }
			 */

			if (getEmerVal > 0) {
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeReference(EmployeeAdminReferanceBean objEmployee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getRefVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("referenceName", objEmployee.getReferenceName());
			empMap.put("occupationRef", objEmployee.getOccupationRef());
			empMap.put("relationshipRef", objEmployee.getRelationshipRef());
			empMap.put("emailRef", objEmployee.getEmailRef());
			empMap.put("referenceAddress", objEmployee.getReferenceAddress());
			empMap.put("pincodeRef", objEmployee.getPincodeRef());
			empMap.put("emergMobile", objEmployee.getEmergPhone());
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getRefVal = namedParameterJdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.INSERT_REFERENCE_INF,
					empMap, Integer.class);
			/*
			 * List<EmployeeReferanceBean> lEmployeePhone =
			 * objEmployee.getPhoneRefMultiple(); for (EmployeeReferanceBean
			 * objReferanceBean : lEmployeePhone) {
			 * jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_REF_PHONE_NO,
			 * objEmployee.getEmpId(), getRefVal,
			 * objReferanceBean.getEmergPhone()); }
			 */
			if (getRefVal > 0) {
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}

		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeNomination(EmployeeAdminNominationBean objEmployee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getNomineeVal = 0;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("aadharno2", objEmployee.getAadharno2());
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("nominateName", objEmployee.getNominateName());
			empMap.put("nominateGender", objEmployee.getNominateGender());
			empMap.put("nominateOccupation", objEmployee.getNominateOccupation());
			empMap.put("nominateRelationship", objEmployee.getNominateRelationship());
			empMap.put("nominateEmail", objEmployee.getNominateEmail());
			empMap.put("nomdateOfBirth", objEmployee.getNomdateOfBirth());
			empMap.put("nomineAddress", objEmployee.getNomineAddress());
			empMap.put("nominatePincode", objEmployee.getNominatePincode());
			empMap.put("nominatePlace", objEmployee.getNominatePlace());
			empMap.put("uploadPhotoNominee", objEmployee.getUploadPhotoNominee());
			empMap.put("emergPhone", objEmployee.getEmergPhone());
			empMap.put("emergMobile", objEmployee.getEmergMobile());
			/*
			 * List<EmployeeNominationBean> lEmployeePhone =
			 * objEmployee.getNominatePhoneMultiple();
			 * List<EmployeeNominationBean> lEmployeeMobile =
			 * objEmployee.getNominateMobileMultiple();
			 */
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			getNomineeVal = namedParameterJdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.INSERT_NOMINEE_INF,
					empMap, Integer.class);
			/*
			 * for (EmployeeNominationBean objNominationMobileBean :
			 * lEmployeeMobile) {
			 * jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_NOM_MOBILE_NO,
			 * objEmployee.getEmpId(), getNomineeVal,
			 * objNominationMobileBean.getEmergMobile()); } for
			 * (EmployeeNominationBean objNominationPhoneBean : lEmployeePhone)
			 * {
			 * jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_NOM_PHONE_NO,
			 * objEmployee.getEmpId(), getNomineeVal,
			 * objNominationPhoneBean.getEmergPhone()); }
			 */
			if (getNomineeVal > 1) {
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeNomination(EmployeeAdminNominationBean objEmp) {
		// TODO Auto-generated method stub

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		int nominee;
		/*
		 * jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_PHONE_NOM,
		 * objEmp.getEmployeeNomId());
		 * jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_MOBILE_NOM,
		 * objEmp.getEmployeeNomId());
		 */
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		nominee = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_NOMINATION, objEmp.getEmployeeNomId());
		if (nominee > 0) {
			objEmployeeMasterResultBean.setSuccess(true);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeEmergency(EmployeeAdminEmergencyBean objemp) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		int emergency;
		// jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_PHONE_EME,
		// objemp.getEmplEmerId());
		// jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_MOBILE_EME,
		// objemp.getEmplEmerId());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		emergency = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EMERGENCY, objemp.getEmplEmerId());
		if (emergency > 0) {
			objEmployeeMasterResultBean.setSuccess(true);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeReference(EmployeeAdminReferanceBean objBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		int reference;
		reference = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_REFERENCE, objBean.getEmpRefId());
		if (reference > 0) {
			objEmployeeMasterResultBean.setSuccess(true);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeExperiance(EmployeeAdminExperianceBean objBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		int expereience;
		expereience = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EXPERIENCE, objBean.getEmpExpId());
		if (expereience > 0) {
			objEmployeeMasterResultBean.setSuccess(true);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeMerit(EmployeeAdminMeritsBean objBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		int merit;
		merit = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_MERIT, objBean.getEmpMeritId());
		if (merit > 0) {
			objEmployeeMasterResultBean.setSuccess(true);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeFamily(EmployeeAdminFamilyBean objBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		int family;
		family = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_FAMILY, objBean.getDependentId());
		if (family > 0) {
			objEmployeeMasterResultBean.setSuccess(true);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeEducation(EmployeeAdminEducationBean objBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		int education;
		education = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_EDUCATION, objBean.getEmpEduId());
		if (education > 0) {
			objEmployeeMasterResultBean.setSuccess(true);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public boolean updatePersonalInfo(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		boolean isSuccess = false;
		int i = 1;
		int getProfileVal;
		try {
			/*
			 * boolean marriedStatus = false; if
			 * (employeeMasterBean.isMarriedStatus() == true) { marriedStatus =
			 * true; }
			 */
			// String confirmDate = employeeMasterBean.getConfirmDate();
			// String resignationDate = employeeMasterBean.getResignationDate();

			// DateFormat formatter;
			// Date date = null;
			// formatter = new SimpleDateFormat("dd/MM/yyyy");
			// try {
			// date = formatter.parse(confirmDate);
			// date = formatter.parse(resignationDate);

			// } catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("marritalStatus", employeeMasterBean.isMarritalStatus());
			empMap.put("guardianName", employeeMasterBean.getGuardianName());
			// empMap.put("motherName", employeeMasterBean.getMotherName());
			// empMap.put("guardiansName",
			// employeeMasterBean.getGuardiansName());
			empMap.put("bloodGrp", Integer.parseInt(employeeMasterBean.getBloodGrp()));
			empMap.put("caste", employeeMasterBean.getCaste());
			empMap.put("religion", employeeMasterBean.getReligion());
			empMap.put("motherTongue", employeeMasterBean.getMotherTongue());
			empMap.put("nationality", employeeMasterBean.getNationality());
			empMap.put("panNo", employeeMasterBean.getPanNo());
			empMap.put("aadharno", employeeMasterBean.getAadharno());
			empMap.put("gratuityNominee", employeeMasterBean.getGratuityNominee());
			empMap.put("nomineeRelation", employeeMasterBean.getNomineeRelation());
			empMap.put("modeConveyence", employeeMasterBean.getModeConveyence());
			empMap.put("hobbies", employeeMasterBean.getHobbies());
			empMap.put("emgContactNo", employeeMasterBean.getEmgContactNo());
			empMap.put("emgContactName", employeeMasterBean.getEmgContactName());
			empMap.put("noticePeriod", employeeMasterBean.getNoticePeriod());
			empMap.put("remarks", employeeMasterBean.getRemarks());
			empMap.put("confirmDate", employeeMasterBean.getConfirmDate());
			empMap.put("resignationDate", employeeMasterBean.getResignationDate());
			empMap.put("languages", employeeMasterBean.getLanguages());
			// empMap.put("race", employeeMasterBean.getRace());
			empMap.put("confirmationPeriod", employeeMasterBean.getConfirmationPeriod());
			empMap.put("husbWifeName", employeeMasterBean.getHusbWifeName());

			empMap.put("married", employeeMasterBean.getMarried());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_PERSONAL_INF, empMap);
				// updateAddressInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getProfileVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_PERSONAL_INFO,
						empMap);
				if (getProfileVal == 1) {
					isSuccess = true;
					// updateAddressInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updateAddress(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getAddressVal;
		int presentAddressId;
		int i = 1;
		try {

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("permAddress", employeeMasterBean.getPermAddress());
			empMap.put("permPlace", employeeMasterBean.getPermPlace());
			empMap.put("permDistrict", employeeMasterBean.getPermDistrict());
			empMap.put("permState", employeeMasterBean.getPermState());
			empMap.put("permPin", employeeMasterBean.getPermPin());
			empMap.put("permPhone", employeeMasterBean.getPermPhone());
			empMap.put("permMobile", employeeMasterBean.getPermMobile());

			empMap.put("presentAddress", employeeMasterBean.getPresentAddress());
			empMap.put("presentPlace", employeeMasterBean.getPresentPlace());
			empMap.put("presentDistrict", employeeMasterBean.getPresentDistrict());
			empMap.put("presentPin", employeeMasterBean.getPresentPin());
			empMap.put("presentPhone", employeeMasterBean.getPresentPhone());
			empMap.put("presentMobile", employeeMasterBean.getPresentMobile());
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_ADDRESS_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_ADDRESS_INF, empMap);
				// updateFamilyInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_ADDRESS_INFO,
						empMap);
				if (getAddressVal == 1) {
					isSuccess = true;
					// updateFamilyInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updatePayBank(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getAddressVal;
		int presentAddressId;
		int i = 1;
		try {

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("paybankname", employeeMasterBean.getPaybankname());
			empMap.put("paybankacctName", employeeMasterBean.getPaybankacctName());
			empMap.put("payAcctNum", employeeMasterBean.getPayAcctNum());
			empMap.put("iban", employeeMasterBean.getIban());
			empMap.put("paybankBranch", employeeMasterBean.getPaybankBranch());
			empMap.put("paycomments", employeeMasterBean.getPaycomments());

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_PAYBANK_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {

				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PAYBANK_INF, empMap);
				isSuccess = true;
			} else {
				getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_PAYBANK_INFO,
						empMap);
				if (getAddressVal == 1) {
					isSuccess = true;

				} else {
					isSuccess = false;
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updateformReview(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getAddressVal;
		int presentAddressId;
		int i = 1;
		try {

			String formreviewDate = employeeMasterBean.getFormreviewDate();

			DateFormat formatter;
			Date requestDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			requestDate = formatter.parse(formreviewDate);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("formreviewType", employeeMasterBean.getFormreviewType());
			empMap.put("formreviewtemplete", employeeMasterBean.getFormreviewtemplete());
			empMap.put("formsreviewcomments", employeeMasterBean.getFormsreviewcomments());
			empMap.put("formreviewDate", requestDate);

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_FORM_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {

				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_FORMs_REVIEW, empMap);
				isSuccess = true;
			} else {
				getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_form_REVIW_INFO,
						empMap);
				if (getAddressVal == 1) {
					isSuccess = true;

				} else {
					isSuccess = false;
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updatefrmAssets(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getAddressVal;
		int presentAddressId;
		int i = 1;
		try {

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("assetName", employeeMasterBean.getAssetName());
			empMap.put("assetType", employeeMasterBean.getAssetType());
			empMap.put("assetdesc", employeeMasterBean.getAssetdesc());
			empMap.put("assetstatus", employeeMasterBean.getAssetstatus());
			empMap.put("assetlocation", employeeMasterBean.getAssetlocation());
			empMap.put("assetquantity", employeeMasterBean.getAssetquantity());

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_ASSETS_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {

				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ASSETSCAR_INF, empMap);
				isSuccess = true;
			} else {
				getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_ASSETS_INFO,
						empMap);
				if (getAddressVal == 1) {
					isSuccess = true;

				} else {
					isSuccess = false;
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updateAirClaim(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getAddressVal;
		int presentAddressId;
		int i = 1;
		try {

			String empID = "";
			String airdueDate = employeeMasterBean.getAirdueDate();

			DateFormat formatter;
			Date requestDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			requestDate = formatter.parse(airdueDate);

			empID = employeeMasterBean.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("ticksec", employeeMasterBean.getTicksec());
			empMap.put("airclass", employeeMasterBean.getAirclass());
			empMap.put("airclaimcomments", employeeMasterBean.getAirclaimcomments());
			empMap.put("airdueDate", requestDate);
			empMap.put("airselftickAmt", employeeMasterBean.getAirselftickAmt());
			empMap.put("airadulttickAmt", employeeMasterBean.getAiradulttickAmt());

			empMap.put("airinfanttickAmt", employeeMasterBean.getAirinfanttickAmt());
			empMap.put("airChildtickAmt", employeeMasterBean.getAirChildtickAmt());
			empMap.put("airselftick", employeeMasterBean.getAirselftick());
			empMap.put("airadulttick", employeeMasterBean.getAiradulttick());
			empMap.put("airinfanttick", employeeMasterBean.getAirinfanttick());
			empMap.put("airChildtick", employeeMasterBean.getAirChildtick());

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_AIRCLAIMS_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {

				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_AIRCLAIMS_INF, empMap);
				isSuccess = true;
			} else {
				getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_AIRCLAIMS_INFO,
						empMap);
				if (getAddressVal == 1) {
					isSuccess = true;

				} else {
					isSuccess = false;
				}
			}

		} catch (DataAccessException | ParseException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updateSettle(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getAddressVal;
		int presentAddressId;
		int i = 1;
		try {

			String empID = "";
			String settlelastDate = employeeMasterBean.getSettlelastDate();

			DateFormat formatter;
			Date requestDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			requestDate = formatter.parse(settlelastDate);

			empID = employeeMasterBean.getEmpId();
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("settleType", employeeMasterBean.getSettleType());
			empMap.put("settleCurrency", employeeMasterBean.getSettleCurrency());
			empMap.put("settlecomments", employeeMasterBean.getSettlecomments());
			empMap.put("settlelastDate", requestDate);

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_SETTLEMENT_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {

				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_SETTLEMET_INF, empMap);
				isSuccess = true;
			} else {
				getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_SETTLEMENT_INFO,
						empMap);
				if (getAddressVal == 1) {
					isSuccess = true;

				} else {
					isSuccess = false;
				}
			}

		} catch (DataAccessException | ParseException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updatePassport(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getAddressVal;
		int presentAddressId;
		int i = 1;
		try {

			String passrequestDate = employeeMasterBean.getPassrequestDate();

			DateFormat formatter;
			Date requestDate = null;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			// Added for Comments in employee History
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String strDate = sdf.format(cal.getTime());

			requestDate = formatter.parse(passrequestDate);

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("passrequestType", employeeMasterBean.getPassrequestType());
			empMap.put("passrequestDate", requestDate);
			empMap.put("passrequestcomments", employeeMasterBean.getPassrequestcomments());

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_PASSPORT_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {

				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_PASSPORT_INFORMATION, empMap);
				isSuccess = true;
			} else {
				getAddressVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_PASSPORT_INFO,
						empMap);
				if (getAddressVal == 1) {
					isSuccess = true;

				} else {
					isSuccess = false;
				}
			}

		} catch (DataAccessException | ParseException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updateRules(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getRuleVal;
		int i = 1;
		try {
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("overTime", employeeMasterBean.isOverTime());
			empMap.put("esiApp", employeeMasterBean.getEsiApp());
			empMap.put("esiApp", employeeMasterBean.getEsiApp());
			empMap.put("lateApp", employeeMasterBean.isLateApp());
			empMap.put("pfApp", employeeMasterBean.isPfApp());
			empMap.put("leaveOption", employeeMasterBean.isLeaveOption());
			empMap.put("telephoneLimit", employeeMasterBean.getTelephoneLimit());
			empMap.put("noticePeriodRule", employeeMasterBean.getNoticePeriodRule());
			empMap.put("earlyExit", employeeMasterBean.isEarlyExit());
			empMap.put("medicalLimit", employeeMasterBean.getMedicalLimit());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_RULE_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_RULE_INF, empMap);
				isSuccess = true;
			} else {
				getRuleVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_RULE_INFO, empMap);
				if (getRuleVal == 1) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updateDocument(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getDocVal;
		int i = 1;
		try {

			boolean isActiveCash = false;
			if (employeeMasterBean.getIsActiveCash().equals("Y")) {
				isActiveCash = true;
			} else if (employeeMasterBean.getIsActiveCash().equals("N")) {
				isActiveCash = false;
			}

			DateFormat formatter;

			Date issuDate = null;
			Date expdate = null;
			Date linissuedate = null;
			Date linexpdate = null;
			Date renrewdate = null;
			Date visaExpdate = null;
			Date visaIsuedate = null;

			formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				if (employeeMasterBean.getIssuedDate() != null) {
					issuDate = formatter.parse(employeeMasterBean.getIssuedDate());
				}
				if (employeeMasterBean.getExpiryDate() != null) {
					expdate = formatter.parse(employeeMasterBean.getExpiryDate());
				}

				if (employeeMasterBean.getLicenseIssuedDate() != null) {
					linissuedate = formatter.parse(employeeMasterBean.getLicenseIssuedDate());
				}

				if (employeeMasterBean.getLicenseexpiryDate() != null) {
					linexpdate = formatter.parse(employeeMasterBean.getLicenseexpiryDate());
				}

				if (employeeMasterBean.getRenewalDate() != null) {
					renrewdate = formatter.parse(employeeMasterBean.getRenewalDate());
				}
				if (employeeMasterBean.getVisaIssuedDate() != null) {
					visaIsuedate = formatter.parse(employeeMasterBean.getVisaIssuedDate());
				}

				if (employeeMasterBean.getVisaExpiryDate() != null) {
					visaExpdate = formatter.parse(employeeMasterBean.getVisaExpiryDate());
				}
			} catch (Exception e) {

			}

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("accountNo", employeeMasterBean.getAccountNo());
			empMap.put("bankName", employeeMasterBean.getBankName());
			empMap.put("bankPlace", employeeMasterBean.getBankPlace());
			empMap.put("passportNo", employeeMasterBean.getPassportNo());
			empMap.put("issuedDate", issuDate);
			empMap.put("expiryDate", expdate);
			empMap.put("issuedPlace", employeeMasterBean.getIssuedPlace());
			empMap.put("licenseNo", employeeMasterBean.getLicenseNo());
			empMap.put("licenseType", employeeMasterBean.getLicenseType());
			empMap.put("licenseIssuedDate", linissuedate);
			empMap.put("licenseexpiryDate", linexpdate);
			empMap.put("renewalDate", renrewdate);
			empMap.put("joinDocUpload", employeeMasterBean.getJoinDocUpload());
			empMap.put("visaRefNo", employeeMasterBean.getVisaRefNo());
			empMap.put("visaType", employeeMasterBean.getVisaType());
			empMap.put("visaIssuedPlace", employeeMasterBean.getVisaIssuedPlace());
			empMap.put("visaExpiryDate", visaExpdate);
			empMap.put("visaIssuedDate", visaIsuedate);
			empMap.put("isActiveCash", isActiveCash);
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_DOC_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_DOC_INF, empMap);
				// updatePhysicalInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getDocVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_DOCUMENT_INFO,
						empMap);
				if (getDocVal == 1) {
					isSuccess = true;
					// updatePhysicalInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updatePhysical(EmployeeAdminMasterBean employeeMasterBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		boolean isSuccess = false;
		int getPhyVal;
		int i = 1;
		try {
			boolean isActiveSight = false;
			boolean isActiveDumb = false;
			boolean isActiveHearing = false;
			boolean isActiveHand = false;
			boolean isActiveFeet = false;
			boolean isLeftSidePower = false, IsRightSidePower = false;

			if (employeeMasterBean.getIsActiveSight().equals("Y")) {
				isActiveSight = true;
			} else if (employeeMasterBean.getIsActiveSight().equals("N")) {
				isActiveSight = false;
			}

			if (employeeMasterBean.getIsActiveDumb().equals("Y")) {
				isActiveDumb = true;
			} else if (employeeMasterBean.getIsActiveDumb().equals("N")) {
				isActiveDumb = false;
			}

			if (employeeMasterBean.getIsActiveHearing().equals("Y")) {
				isActiveHearing = true;
			} else if (employeeMasterBean.getIsActiveHearing().equals("N")) {
				isActiveHearing = false;
			}

			if (employeeMasterBean.getIsActiveHand().equals("Y")) {
				isActiveHand = true;
			} else if (employeeMasterBean.getIsActiveHand().equals("N")) {
				isActiveHand = false;
			}
			if (employeeMasterBean.getIsActiveFeet().equals("Y")) {
				isActiveFeet = true;
			} else if (employeeMasterBean.getIsActiveFeet().equals("N")) {
				isActiveFeet = false;
			}

			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", employeeMasterBean.getEmpId());
			empMap.put("isActiveSight", isActiveSight);
			empMap.put("isActiveDumb", isActiveDumb);
			empMap.put("isActiveHearing", isActiveHearing);
			empMap.put("isActiveHand", isActiveHand);
			empMap.put("isActiveFeet", isActiveFeet);
			empMap.put("LeftSidePower", employeeMasterBean.getLeftSidePower());
			empMap.put("RightSidePower", employeeMasterBean.getRightSidePower());
			empMap.put("otherDisablity", employeeMasterBean.getOtherDisablity());
			empMap.put("height", employeeMasterBean.getHeight());
			empMap.put("weight", employeeMasterBean.getWeight());
			i = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.CHECK_FOR_PHY_EMPID, Integer.class,
					new Object[] { employeeMasterBean.getEmpId() });
			if (i == 0) {
				namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_ON_UPDATE_PHY_INF, empMap);
				// updateRuleInfo(employeeMasterBean);
				isSuccess = true;
			} else {
				getPhyVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_PHYSICAL_INFO,
						empMap);
				if (getPhyVal == 1) {
					isSuccess = true;
					// updateRuleInfo(employeeMasterBean);
				} else {
					isSuccess = false;
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Update", e);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeDoc(EmployeeAdminDocumentBean objEmployee) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try {
			int getMeritVal;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("docName", objEmployee.getDocName());
			empMap.put("description", objEmployee.getDescription());
			empMap.put("uploadDoc", objEmployee.getUploadDoc());
			empMap.put("docType", objEmployee.getDocType());
			empMap.put("issuecountry", objEmployee.getIssuecountry());
			empMap.put("expiryDate", objEmployee.getExpiryDate());
			empMap.put("issueDate", objEmployee.getIssueDate());

			getMeritVal = namedParameterJdbcTemplate.update(EmployeeAdminMasterQueryUtil.INSERT_DOCUMENT, empMap);
			if (getMeritVal > 0) {
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				objEmployeeMasterResultBean.setEmpDocId(getMeritVal);
				objEmployeeMasterResultBean.setSuccess(true);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeDoc(EmployeeAdminDocumentBean objEmployeeDocumentBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminDocumentBean objEmployeeDoc = new EmployeeAdminDocumentBean();
		objEmployeeDoc = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_DOC_ID,
				new Object[] { objEmployeeDocumentBean.getEmpDocId() },
				new BeanPropertyRowMapper<EmployeeAdminDocumentBean>(EmployeeAdminDocumentBean.class));
		employeeMasterResultBean.setObjEmployeeDocumentBean(objEmployeeDoc);
		employeeMasterResultBean.setEmpId(objEmployeeDocumentBean.getEmpId());
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getEmpDocumentList(String empId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminDocumentBean> lEmployeeDocumentBean = new ArrayList<EmployeeAdminDocumentBean>();
		lEmployeeDocumentBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_EMP_DOC, new Object[] { empId },
				new BeanPropertyRowMapper<EmployeeAdminDocumentBean>(EmployeeAdminDocumentBean.class));
		// TODO Auto-generated method stub
		employeeMasterResultBean.setEmployeeDocumentBeanList(lEmployeeDocumentBean);
		// employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeDoc(EmployeeAdminDocumentBean objEmployeeDocumentBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		jdbcTemplate.update(EmployeeAdminMasterQueryUtil.UPDATE_EMP_DOC, objEmployeeDocumentBean.getIssueDate(),objEmployeeDocumentBean.getDocName(),
				objEmployeeDocumentBean.getDescription(), objEmployeeDocumentBean.getUploadDoc(),
				objEmployeeDocumentBean.getIssuecountry(), objEmployeeDocumentBean.getDocType(),
				objEmployeeDocumentBean.getExpiryDate(), objEmployeeDocumentBean.getEmpDocId());
		employeeMasterResultBean.setSuccess(true);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeDoc(EmployeeAdminDocumentBean objDocumentBean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		int family;
		family = jdbcTemplate.update(EmployeeAdminMasterQueryUtil.DELETE_DOC, objDocumentBean.getEmpDocId());
		if (family > 0) {
			objEmployeeMasterResultBean.setSuccess(true);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean insertEmployeeProbation(EmployeeAdminProbationBean objEmployee) {
		// TODO Auto-generated method stub
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			int getMeritVal = 0;
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("empId", objEmployee.getEmpId());
			empMap.put("frmProbation", objEmployee.getFrmProbation());
			empMap.put("toProbation", objEmployee.getToProbation());
			empMap.put("extend", objEmployee.getExtend());
			empMap.put("duration", objEmployee.getDuration());
			empMap.put("breakAny", objEmployee.getBreakAny());
			empMap.put("frmBreProbation", objEmployee.getFrmBreakPro());
			empMap.put("toBreProbation", objEmployee.getToBreakPro());
			empMap.put("breakDuration", objEmployee.getBreakDuration());
			empMap.put("completion", objEmployee.getCompletion());
			// getMeritVal =
			// namedParameterJdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_PROBATION,
			// empMap);
			if (getMeritVal == 1) {
				objEmployeeMasterResultBean.setEmpId(objEmployee.getEmpId());
				objEmployeeMasterResultBean.setSuccess(true);
			} else {
				objEmployeeMasterResultBean.setSuccess(false);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee Add", e);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeProbation(EmployeeAdminProbationBean objEmployeeProbationBean) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminProbationBean objEmployeeProbation = new EmployeeAdminProbationBean();
		// objEmployeeProbation =
		// jdbcTemplate.queryForObject(EmployeeMasterQueryUtil.SELET_EMP_PROBATION_ID,
		// new Object[] { objEmployeeProbationBean.getEmpProbationId() }, new
		// BeanPropertyRowMapper<EmployeeProbationBean>(EmployeeProbationBean.class));
		employeeMasterResultBean.setObjEmployeeProbationBean(objEmployeeProbation);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getProbationList(String empId) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminProbationBean> lEmployeeProbation = new ArrayList<EmployeeAdminProbationBean>();
		// lEmployeeProbation =
		// jdbcTemplate.query(EmployeeMasterQueryUtil.SELET_EMP_PRO_EMP_ID, new
		// Object[] { empId }, new
		// BeanPropertyRowMapper<EmployeeProbationBean>(EmployeeProbationBean.class));
		employeeMasterResultBean.setEmployeeProbationBeanList(lEmployeeProbation);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean updateEmployeeProbation(EmployeeAdminProbationBean objEmployeeProbationBean) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		if (objEmployeeProbationBean.getEmpProbationId() != 0) {
			// jdbcTemplate.update(EmployeeMasterQueryUtil.UPDATE_EMP_PROBATION,
			// objEmployeeProbationBean.getFrmProbation(),
			// objEmployeeProbationBean.getToProbation(),
			// objEmployeeProbationBean.getExtend(),
			// objEmployeeProbationBean.getDuration(),
			// objEmployeeProbationBean.getBreakAny(),
			// objEmployeeProbationBean.getFrmBreakPro(),
			// objEmployeeProbationBean.getToBreakPro(),
			// objEmployeeProbationBean.getCompletion(),
			// objEmployeeProbationBean.getBreakDuration(),
			// objEmployeeProbationBean.getEmpProbationId());
		} else {
			// jdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_PROBATION_UPDATE,
			// objEmployeeProbationBean.getEmpId(),
			// objEmployeeProbationBean.getFrmProbation(),
			// objEmployeeProbationBean.getToProbation(),
			// objEmployeeProbationBean.getExtend(),
			// objEmployeeProbationBean.getDuration(),
			// objEmployeeProbationBean.getBreakAny(),
			// objEmployeeProbationBean.getFrmBreakPro(),
			// objEmployeeProbationBean.getToBreakPro(),
			// objEmployeeProbationBean.getBreakDuration(),
			// objEmployeeProbationBean.getCompletion());
		}
		employeeMasterResultBean.setSuccess(true);
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean deleteEmployeeProbation(EmployeeAdminProbationBean objProbationBean) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		int probation = 0;
		// probation =
		// jdbcTemplate.update(EmployeeMasterQueryUtil.DELETE_PROBATION,
		// objProbationBean.getEmpProbationId());
		if (probation > 0) {
			objEmployeeMasterResultBean.setSuccess(true);
		}
		return objEmployeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeePersonal(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterPersonalBean objEmployeePersonal = new EmployeeAdminMasterPersonalBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PERSONAL_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeePersonal = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PERSONAL_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterPersonalBean>(EmployeeAdminMasterPersonalBean.class));
			employeeMasterResultBean.setObjEmployeeMasterPersonalBean(objEmployeePersonal);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeAddress(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterAddressBean objEmployeeAddress = new EmployeeAdminMasterAddressBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_ADDRESS_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeeAddress = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_ADDRESS_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterAddressBean>(EmployeeAdminMasterAddressBean.class));
			employeeMasterResultBean.setObjEmployeeMasterAddressBean(objEmployeeAddress);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editPayRoll(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterAddressBean objEmployeeAddress = new EmployeeAdminMasterAddressBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PAYBANK_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeeAddress = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PAYBANK_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterAddressBean>(EmployeeAdminMasterAddressBean.class));
			employeeMasterResultBean.setObjEmployeeMasterAddressBean(objEmployeeAddress);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editFormReview(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterAddressBean objEmployeeAddress = new EmployeeAdminMasterAddressBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_FORM_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeeAddress = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_form_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterAddressBean>(EmployeeAdminMasterAddressBean.class));
			employeeMasterResultBean.setObjEmployeeMasterAddressBean(objEmployeeAddress);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editAssets(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterAddressBean objEmployeeAddress = new EmployeeAdminMasterAddressBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_ASSETS_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeeAddress = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_ASSETS_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterAddressBean>(EmployeeAdminMasterAddressBean.class));
			employeeMasterResultBean.setObjEmployeeMasterAddressBean(objEmployeeAddress);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editPassportReqeuest(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterAddressBean objEmployeeAddress = new EmployeeAdminMasterAddressBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PASSPORT_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeeAddress = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PASSPORT_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterAddressBean>(EmployeeAdminMasterAddressBean.class));
			employeeMasterResultBean.setObjEmployeeMasterAddressBean(objEmployeeAddress);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editAirClaim(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterAddressBean objEmployeeAddress = new EmployeeAdminMasterAddressBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_AIRCLAIM_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeeAddress = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_AIRCLAIM_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterAddressBean>(EmployeeAdminMasterAddressBean.class));
			employeeMasterResultBean.setObjEmployeeMasterAddressBean(objEmployeeAddress);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editSettlement(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterAddressBean objEmployeeAddress = new EmployeeAdminMasterAddressBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_SETTLEMENT_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeeAddress = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_SETTLEMENT_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterAddressBean>(EmployeeAdminMasterAddressBean.class));
			employeeMasterResultBean.setObjEmployeeMasterAddressBean(objEmployeeAddress);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeRule(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterRulesBean objEmployeeRule = new EmployeeAdminMasterRulesBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_RULE_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeeRule = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_RULE_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterRulesBean>(EmployeeAdminMasterRulesBean.class));
			employeeMasterResultBean.setObjEmployeeMasterRulesBean(objEmployeeRule);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeeDetail(String editEmployeeID) {
		// TODO Auto-generated method stub
		String isActiveCash = " ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMAsterPerDetailsBean objEmployeePerDetails = new EmployeeAdminMAsterPerDetailsBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PER_DETAIL_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeePerDetails = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PER_DETAIL_ID,
					new Object[] { editEmployeeID }, new BeanPropertyRowMapper<EmployeeAdminMAsterPerDetailsBean>(
							EmployeeAdminMAsterPerDetailsBean.class));
			String cash = objEmployeePerDetails.getIsActiveCash();
			if (cash.equals("t")) {
				isActiveCash = "Y";
				objEmployeePerDetails.setIsActiveCash(isActiveCash);
			} else {
				isActiveCash = "N";
				objEmployeePerDetails.setIsActiveCash(isActiveCash);
			}
			employeeMasterResultBean.setObjEmployeeMAsterPerDetailsBean(objEmployeePerDetails);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean editEmployeePhysical(String editEmployeeID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String isActiveSight = " ";
		String isActiveDumb = " ";
		String isActiveHearing = " ";
		String isActiveHand = " ";
		String isActiveFeet = " ";

		String isLeftSidePower = " ";
		String IsRightSidePower = " ";
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterPhysicalBean objEmployeePhysical = new EmployeeAdminMasterPhysicalBean();
		int count = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PHYSICAL_COUNT,
				new Object[] { editEmployeeID }, Integer.class);
		if (count > 0) {
			objEmployeePhysical = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.SELET_EMP_PHYSICAL_ID,
					new Object[] { editEmployeeID },
					new BeanPropertyRowMapper<EmployeeAdminMasterPhysicalBean>(EmployeeAdminMasterPhysicalBean.class));
			String sight = objEmployeePhysical.getIsActiveSight();
			String dumb = objEmployeePhysical.getIsActiveDumb();
			String hear = objEmployeePhysical.getIsActiveHearing();
			String hand = objEmployeePhysical.getIsActiveHand();
			String feet = objEmployeePhysical.getIsActiveFeet();

			if (sight.equals("t")) {
				isActiveSight = "Y";
				objEmployeePhysical.setIsActiveSight(isActiveSight);
			} else {
				isActiveSight = "N";
				objEmployeePhysical.setIsActiveSight(isActiveSight);
			}
			if (dumb.equals("t")) {
				isActiveDumb = "Y";
				objEmployeePhysical.setIsActiveDumb(isActiveDumb);
			} else {
				isActiveDumb = "N";
				objEmployeePhysical.setIsActiveDumb(isActiveDumb);
			}
			if (hear.equals("t")) {
				isActiveHearing = "Y";
				objEmployeePhysical.setIsActiveHearing(isActiveHearing);
			} else {
				isActiveHearing = "N";
				objEmployeePhysical.setIsActiveHearing(isActiveHearing);
			}
			if (hand.equals("t")) {
				isActiveHand = "Y";
				objEmployeePhysical.setIsActiveHand(isActiveHand);
			} else {
				isActiveHand = "N";
				objEmployeePhysical.setIsActiveHand(isActiveHand);
			}
			if (feet.equals("t")) {
				isActiveFeet = "Y";
				objEmployeePhysical.setIsActiveFeet(isActiveFeet);
			} else {
				isActiveFeet = "N";
				objEmployeePhysical.setIsActiveFeet(isActiveFeet);
			}

			employeeMasterResultBean.setObjEmployeeMasterPhysicalBean(objEmployeePhysical);
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getYearList() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<Integer> lEducationBean = new ArrayList<Integer>();
		try {
			lEducationBean = jdbcTemplate.queryForList(EmployeeAdminMasterQueryUtil.SELECT_YEAR_LIST, Integer.class);
			employeeMasterResultBean.setYearsList(lEducationBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean uploadDependentFile(MultipartFile file, String employeeID) {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		System.out.println("Employee ID:" + employeeID);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String eId = null;
		String filePath = "";
		if (!file.isEmpty()) {
			try {

				byte[] bytes = file.getBytes();
				String workingDir = System.getProperty("user.dir");
				String fileName;
				/*
				 * int maxId =
				 * jdbcTemplate.queryForObject(EmployeeMasterQueryUtil
				 * .GET_MAX_EMPLOYEE_ID, Integer.class); int nextId = maxId + 1;
				 * String employeeId = nextId + ""; String prefix = ""; if
				 * (employeeId.length() == 1) { prefix = "E000"; } else if
				 * (employeeId.length() == 2) { prefix = "E00"; } else if
				 * (employeeId.length() == 3) { prefix = "E0"; } else { prefix =
				 * "E"; } fileName = prefix + employeeId;
				 */
				fileName = employeeID;
				eId = employeeID;
				if (eId.equals("null")) {
					System.out.println("getFilePropertyUrl" + getFilePropertyUrl);
					System.out.println("getFileServerPath" + getFileServerPath);
					System.out.println("fileName" + fileName);
					filePath = HisFileUploadUtillity.uploadImgFileHandler(file, getFilePropertyUrl, getFileServerPath,
							fileName);
					employeeMasterResultBean.setImgPath(filePath);
					employeeMasterResultBean.setDependentFileName(
							fileName + '.' + FilenameUtils.getExtension(file.getOriginalFilename()));
				} else {
					System.out.println("getFilePropertyUrl" + getFilePropertyUrl);
					System.out.println("getFileServerPath" + getFileServerPath);
					System.out.println("fileName" + employeeID);
					filePath = HisFileUploadUtillity.uploadImgFileHandler(file, getFilePropertyUrl, getFileServerPath,
							employeeID);
					employeeMasterResultBean.setImgPath(filePath);
					employeeMasterResultBean.setDependentFileName(
							employeeID + '.' + FilenameUtils.getExtension(file.getOriginalFilename()));
				}
				employeeMasterResultBean.setSuccess(true);

			} catch (Exception e) {

			}
		}
		return employeeMasterResultBean;
	}

	/*
	 * @Override public EmployeeAdminMasterBean getProfileInfo() throws
	 * Exception { // TODO Auto-generated method stub
	 * 
	 * EmployeeAdminMasterBean employeeMasterBean = new
	 * EmployeeAdminMasterBean(); try { UserDetail userDetails = (UserDetail)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * String firstName = ""; String lastName = ""; if
	 * (userDetails.getFirstName() == null) { firstName = ""; } else { firstName
	 * = userDetails.getFirstName(); } if (userDetails.getLastname() == null) {
	 * lastName = ""; } else { lastName = userDetails.getLastname(); }
	 * employeeMasterBean.setEmpId(userDetails.getUserId());
	 * employeeMasterBean.setFirstName(firstName);
	 * employeeMasterBean.setLastName(lastName);
	 * employeeMasterBean.setCompanyName(userDetails.getCompanyName());
	 * employeeMasterBean.setBranchName(userDetails.getBranchName());
	 * employeeMasterBean.setDesignationName(userDetails.getDesignationName());
	 * employeeMasterBean.setUploadPhoto(userDetails.getPhotoUrl());
	 * employeeMasterBean.setDoj(userDetails.getDoj());
	 * employeeMasterBean.setGradeName(userDetails.getGradeName());
	 * 
	 * return employeeMasterBean;
	 * 
	 * } catch (DataAccessException e) { LOGGER.error("Error in getProfileInfo",
	 * e); throw new CustomException(ErrorMessage.ERROR_LIST); }
	 * 
	 * }
	 */

	@Override
	public int checkESICNo(String esic) throws Exception {
		int esciNo = 0;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			esciNo = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sCheckESICNo, Integer.class,
					new Object[] { esic });

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check ESIC No", e);
		}

		return esciNo;

	}

	@Override
	public int checkEPFNo(String epfNo) throws Exception {
		int epfNumber = 0;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			epfNumber = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sCheckEPFNo, Integer.class,
					new Object[] { epfNo });

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check EPF No", e);
		}

		return epfNumber;

	}

	@Override
	public int checkPersonalInfoPANNo(String panNo) throws Exception {
		int panNumber = 0;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {

			panNumber = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.sCheckPANNo, Integer.class,
					new Object[] { panNo });

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check PAN No", e);
		}

		return panNumber;

	}

	@Override
	public EmployeeAdminMasterBean getProfileInfo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeAdminMasterResultBean getDesigantion(String designationId) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		EmployeeAdminMasterResultBean employeeAdminMasterResultBean = new EmployeeAdminMasterResultBean();
		String desination = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.GETDESINGNATIONAME, String.class,
				designationId);
		if (desination.equalsIgnoreCase("Driver")) {
			employeeAdminMasterResultBean.setDesignationStatus(true);
		}
		if (desination.equalsIgnoreCase("Sales")) {
			employeeAdminMasterResultBean.setSalesStatus(true);
		}
		return employeeAdminMasterResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean getBloodGroupList() throws CustomException {
		// TODO Auto-generated method stub
		EmployeeAdminMasterResultBean objResultBean = new EmployeeAdminMasterResultBean();
		List<SelectivityBean> bloodGroupList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			bloodGroupList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.BLOODGROUP_LIST,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			objResultBean.setBloodGroupList(bloodGroupList);
			objResultBean.setSuccess(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTypeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return objResultBean;
	}

	@Override
	public EmployeeAdminMasterResultBean viewEmployeeById(String empId) throws CustomException {
		EmployeeAdminMasterResultBean bean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> beans = new ArrayList<EmployeeAdminMasterBean>();
		List<EmployeeAdminMasterPhoneNoDetailBean> alPresentAddDetail = new ArrayList<EmployeeAdminMasterPhoneNoDetailBean>();
		EmployeeAdminMasterBean employeeBean = new EmployeeAdminMasterBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { empId };
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Map row = jdbcTemplate.queryForMap(EmployeeAdminMasterQueryUtil.SELECT_EMPLOYEE_BY_ID, params, types);
			List<EmployeeAdminMasterPersonalBean> lPersonalBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_PERSONAL_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterPersonalBean>(EmployeeAdminMasterPersonalBean.class));
			List<EmployeeAdminFamilyBean> lFamilyBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELECT_FAMILY_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminFamilyBean>(EmployeeAdminFamilyBean.class));
			List<EmployeeAdminEducationBean> lEducationBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELECT_EDUCATION_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminEducationBean>(EmployeeAdminEducationBean.class));
			List<EmployeeMAsterPerDetailsBean> lpersonalDetailBean = jdbcTemplate.query(
					EmployeeMasterQueryUtil.SELET_EMP_PER_DETAIL_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeMAsterPerDetailsBean>(EmployeeMAsterPerDetailsBean.class));
			List<EmployeeMasterPhysicalBean> lphysicalBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_PHYSICAL_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeMasterPhysicalBean>(EmployeeMasterPhysicalBean.class));
			List<EmployeeAdminExperianceBean> lExperianceBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELECT_EXPERIENCE_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminExperianceBean>(EmployeeAdminExperianceBean.class));
			List<EmployeeAdminMeritsBean> lMeritsBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELECT_MERITS_BY_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMeritsBean>(EmployeeAdminMeritsBean.class));
			List<EmployeeAdminReferanceBean> lRefBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_REF_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminReferanceBean>(EmployeeAdminReferanceBean.class));
			List<EmployeeAdminDuplicateBean> lHistoryBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_DUPLICATE_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminDuplicateBean>(EmployeeAdminDuplicateBean.class));
			List<SelectivityBean> leaveTypeList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.GET_LEAVET_TYPE_LIST,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

			List<EmployeeAdminMasterBean> lformList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_form_ID,
					new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
			// List<EmployeeAdminMasterBean> lEmployeeLeaveBean =
			// jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_LEAVELIST_ID,
			// new Object[] { empId,empId,empId,empId,empId }, new
			// BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			List<EmployeeAdminMasterBean> employeePayrolldedBeanList = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_PAYROLLDEDUCTIONLIST_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			List<EmployeeAdminMasterBean> lAirclaimeBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_AIRCLAIM_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			List<EmployeeAdminMasterBean> lEndofserviceEmployeeLeaveBean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_SETTLEMENT_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			List<EmployeeAdminMasterBean> loanList = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_LOANLIST_ID,
					new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			List<EmployeeAdminMasterBean> lAddressBenan = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_ADDRESS_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			List<EmployeeAdminMasterBean> lLetterReqBenan = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_EMP_LETTERREQUEST_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			List<EmployeeAdminMasterBean> lpassportbean = jdbcTemplate.query(
					EmployeeAdminMasterQueryUtil.SELET_PASSPORTLIST_ID, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			List<EmployeeAdminMasterBean> lAssetsbean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_ASSET_ID,
					new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			List<EmployeeAdminMasterBean> lPayBean = jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELET_PAYSLIP_ID,
					new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));

			bean.setEmployeeFamilyBeanList(lFamilyBean);
			bean.setEmployeeEducationBeanList(lEducationBean);
			bean.setEmployeePersonalBeanList(lPersonalBean);
			bean.setEmployeeMAsterPerDetailsBeanList(lpersonalDetailBean);
			bean.setEmployeeMasterPhysicalBeanBeanList(lphysicalBean);
			bean.setEmployeeExperianceList(lExperianceBean);
			bean.setEmployeeMeritsBeanList(lMeritsBean);
			bean.setEmployeeReferanceBeanList(lRefBean);
			bean.setEmployeeDuplicateList(lHistoryBean);

			// bean.setEmployeeLeaveBeanList(lEmployeeLeaveBean);
			bean.setEmployeePayrolldedBeanList(employeePayrolldedBeanList);
			bean.setEmployeeSettleBeanList(lEndofserviceEmployeeLeaveBean);
			bean.setEmployeeAirBeanList(lAirclaimeBean);
			bean.setEmployeeLoanBeanList(loanList);
			bean.setEmployeeadddressBeanList(lAddressBenan);
			bean.setEmployeeLetterReqBeanList(lLetterReqBenan);
			bean.setEmployeePassportBeanList(lpassportbean);
			bean.setEmployeeLetterAssetsBeanList(lAssetsbean);
			bean.setEmployeeFormrevList(lformList);
			bean.setEmployeePayslipBeanList(lPayBean);
			String dob = df.format(row.get("dob"));
			String doj = df.format(row.get("doj"));
			String reldate = null;
			String confirmDate = "";
			String resignationDate = "";
			String employmentdate = null;
			String confirmationDate = "";

			if (row.get("confirmationDate") != null) {
				employeeBean.setConfirmationDate(String.valueOf(row.get("confirmationDate")));
			} else {
				confirmationDate = null;
			}

			if (row.get("permAddress") != null) {
				employeeBean.setPermAddress((String) row.get("permAddress"));
			}

			if (row.get("presentAddress") != null) {
				employeeBean.setPresentAddress((String) row.get("presentAddress"));
			}
			if (row.get("permPin") != null) {
				employeeBean.setPermPin((String) row.get("permPin"));
			}

			if (row.get("permMobile") != null) {
				employeeBean.setPermMobile((String) row.get("permMobile"));
			}

			if (row.get("permMobile") != null) {
				employeeBean.setPermMobile((String) row.get("permMobile"));
			}

			if (row.get("airselftick") != null) {
				employeeBean.setAirselftick(Integer.valueOf(row.get("airselftick").toString()));
			}

			if (row.get("airadulttick") != null) {
				employeeBean.setAiradulttick(Integer.valueOf(row.get("airadulttick").toString()));
			}

			if (row.get("formreviewType") != null) {
				employeeBean.setFormreviewType((String) row.get("formreviewType"));
			}
			if (row.get("formreviewDate") != null) {
				employeeBean.setFormreviewDate((String) row.get("formreviewDate"));
			}
			if (row.get("formsreviewcomments") != null) {
				employeeBean.setFormsreviewcomments((String) row.get("formsreviewcomments"));
			}

			if (row.get("formreviewtemplete") != null) {
				employeeBean.setFormreviewtemplete((String) row.get("formreviewtemplete"));
			}

			if (row.get("passrequestType") != null) {
				employeeBean.setPassrequestType((String) row.get("passrequestType"));
			}

			if (row.get("passrequestDate") != null) {
				employeeBean.setPassrequestDate((String) row.get("passrequestDate"));
			}
			if (row.get("passrequestcomments") != null) {
				employeeBean.setPassrequestcomments((String) row.get("passrequestcomments"));
			}

			if (row.get("leaveType") != null) {
				reldate = df.format(row.get("leaveType"));
			}

			if (row.get("fromdate") != null) {
				reldate = df.format(row.get("fromdate"));
			}

			if (row.get("todate") != null) {
				reldate = df.format(row.get("todate"));
			}

			if (row.get("noDays") != null) {
				reldate = df.format(row.get("noDays"));
			}

			if (row.get("paySlipNo") != null) {
				reldate = df.format(row.get("paySlipNo"));
			}

			if (row.get("paymonthYear") != null) {
				reldate = df.format(row.get("paymonthYear"));
			}

			if (row.get("assetName") != null) {
				reldate = df.format(row.get("assetName"));
			}

			if (row.get("assetType") != null) {
				reldate = df.format(row.get("assetType"));
			}

			if (row.get("assetdesc") != null) {
				reldate = df.format(row.get("assetdesc"));
			}

			if (row.get("assetstatus") != null) {
				reldate = df.format(row.get("assetstatus"));
			}

			if (row.get("assetlocation") != null) {
				reldate = df.format(row.get("assetlocation"));
			}

			if (row.get("assetquantity") != null) {
				reldate = df.format(row.get("assetquantity"));
			}

			if (row.get("paycompName") != null) {
				reldate = df.format(row.get("paycompName"));
			}

			if (row.get("monthYear") != null) {
				reldate = df.format(row.get("monthYear"));
			}

			if (row.get("amount") != null) {
				reldate = df.format(row.get("amount"));
			}

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

			if (row.get("fullName") != null) {
				employeeBean.setFullName((String) row.get("fullName"));
			}
			if (row.get("reportdot") != null) {
				employeeBean.setReportdot((String) row.get("reportdot"));
			}

			if (row.get("bloodgroupName") != null) {
				employeeBean.setBloodgroupName((String) row.get("bloodgroupName"));
			}

			if (row.get("marriedName") != null) {
				employeeBean.setMarriedName((String) row.get("marriedName"));
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

			if (row.get("citizen") != null) {
				employeeBean.setCitizen((String) row.get("citizen"));
			}
			if (row.get("othercitizen") != null) {
				employeeBean.setOthercitizen((String) row.get("othercitizen"));
			}
			if (row.get("homedesti") != null) {
				employeeBean.setHomedesti((String) row.get("homedesti"));
			}
			if (row.get("airticketclass") != null) {
				employeeBean.setAirticketclass((String) row.get("airticketclass"));
			}
			if (row.get("probationperiod") != null) {
				employeeBean.setProbationperiod((String) row.get("probationperiod"));
			}
			if (row.get("noticeperiod") != null) {
				employeeBean.setNoticeperiod((String) row.get("noticeperiod"));
			}
			if (row.get("workcalender") != null) {
				employeeBean.setWorkcalender((String) row.get("workcalender"));
			}
			if (row.get("fatherName") != null) {
				employeeBean.setFatherName((String) row.get("fatherName"));
			}
			if (row.get("momcyName") != null) {
				employeeBean.setMomcyName((String) row.get("momcyName"));
			}
			if (row.get("socialNo") != null) {
				employeeBean.setSocialNo((String) row.get("socialNo"));
			}

			if (row.get("incometaxNo") != null) {
				employeeBean.setIncometaxNo((String) row.get("incometaxNo"));
			}
			if (row.get("faxName") != null) {
				employeeBean.setFaxName((String) row.get("faxName"));
			}

			if (row.get("profitCenter") != null) {
				employeeBean.setProfitCenter((String) row.get("profitCenter"));
			}
			if (row.get("unit") != null) {
				employeeBean.setUnit((String) row.get("unit"));
			}
			if (row.get("appraisalone") != null) {
				employeeBean.setAppraisalone((String) row.get("appraisalone"));
			}
			if (row.get("appraisalfinal") != null) {
				employeeBean.setAppraisalfinal((String) row.get("appraisalfinal"));
			}
			if (row.get("appraisaloneName") != null) {
				employeeBean.setAppraisaloneName((String) row.get("appraisaloneName"));
			}
			if (row.get("appraisalfinalName") != null) {
				employeeBean.setAppraisalfinalName((String) row.get("appraisalfinalName"));
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
			if (row.get("emp_status") != null) {
				employeeBean.setFirstName1(String.valueOf(row.get("emp_status")));
			}
			if (row.get("country") != null && !String.valueOf(row.get("country")).equalsIgnoreCase("")) {
				// employeeBean.setFirstName1(String.valueOf(row.get("emp_status")));
				String countrycode = String.valueOf(row.get("country"));
				String countryName = jdbcTemplate.queryForObject(EmployeeAdminMasterQueryUtil.GETCOUNTRYNAME,
						String.class, countrycode);
				employeeBean.setCountry(countryName);
			}
			if (row.get("generic") != null) {
				employeeBean.setGeneric(String.valueOf(row.get("generic")));
			}
			employeeBean.setisEdit(true);
			bean.setBranchList(jdbcTemplate.query(EmployeeAdminMasterQueryUtil.SELECT_BRANCH_LIST,
					new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class)));

			// bean.setObjPresentAddDetail(alPresentAddDetail);
			// bean.setPresentAddressMultiple(alPresentAddDetail);
			bean.setEmployeeFamilyBeanList(lFamilyBean);
			bean.setEmployeeEducationBeanList(lEducationBean);
			bean.setEmployeeExperianceList(lExperianceBean);
			bean.setEmployeeMeritsBeanList(lMeritsBean);
			bean.setLeaveTypeList(leaveTypeList);
			beans.add(employeeBean);
			bean.setEditList(beans);

		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeById", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		// TODO Auto-generated method stub

		return bean;
	}

	@Override
	public EmployeeAdminMasterResultBean getLeaveListSeach(EmployeeAdminMasterBean bean) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		List<EmployeeAdminMasterBean> lEmployeeReferanceBean = new ArrayList<EmployeeAdminMasterBean>();

		String query = EmployeeAdminMasterQueryUtil.SELET_LEAVELIST_ID1;

		query += " where employee_id='" + bean.getEmpId() + "'";
		if (bean.getLeaveType() != null && bean.getLeaveType() != "") {
			query += " and leave_type='" + bean.getLeaveType() + "'";
		}
		if (bean.getStatusId() != null && bean.getStatusId() != "") {
			if (bean.getStatusId().equalsIgnoreCase("Approved")) {
				query += " and status='" + 1 + "'";

			} else if (bean.getStatusId().equalsIgnoreCase("Pending")) {
				query += " and status='" + 0 + "'";
			} else if (bean.getStatusId().equalsIgnoreCase("Cancelled"))

				query += " and status='" + 2 + "'";
		}
		if (bean.getYear() != null && bean.getYear() != "") {
			query += " and date_part('year',created_on) ='" + bean.getYear() + "'";
		}

		lEmployeeReferanceBean = jdbcTemplate.query(query,
				new Object[] { bean.getEmpId(), bean.getEmpId(), bean.getEmpId(), bean.getEmpId() },
				new BeanPropertyRowMapper<EmployeeAdminMasterBean>(EmployeeAdminMasterBean.class));
		employeeMasterResultBean.setEmployeeLeaveBeanList(lEmployeeReferanceBean);
		// employeeMasterResultBean.setEmpId(empId);
		return employeeMasterResultBean;
	}

	private String customerMail(EmployeeAdminMasterBean objEmployee) throws Exception {

		Email email = new Email();
		StringBuffer sb = new StringBuffer();
		String path = "";
		email.setFromEmailAddress("support@cordelialine.com");
		String toMailAddress = objEmployee.getEmailId();
		String[] toEmailIds = toMailAddress.split(",");
		email.setToEmailAddress(toEmailIds);
	/*	String cc[] = { "" };*/
		String bcc = "gopi@paragondynamics.in,support@cordelialine.com";
		
	/*	email.setCcEmailAddress(cc);*/
		email.setBccEmailAddress(bcc.split(","));
		sb.append("Hi\n\n" + objEmployee.getFirstName() + ",\n\n<br><br>");
		sb.append(
				"  \n\n\n\nGood day!!!\n\n Please find below the application URL for Cordelia and your login credentials\n\n<br><br>");
		sb.append("http://213.42.28.72:8082/cordelia<br><br>");
		sb.append("User id  : " + objEmployee.getUserId() + "<br>");
		sb.append("Password : " + objEmployee.getPwd() + "<br><br>");
		sb.append("Kindly revert in case of any further inputs or assistance required.<br><br>");

		sb.append("Best Regards," + "\n\n<br>");
		sb.append("IT Support" + "\n\n<br>");
		sb.append("+91 8248654402" + "\n\n<br>");
		email.setBodyHtml(sb.toString());

		email.setSubject("Cordelia Application Access Details");

		MailUtility.sendMailCordelia(email, path);
		return path;
	}

@Override
	public EmployeeAdminMasterResultBean uploadFileNew(MultipartFile file) {
		// TODO Auto-generated method stub
	EmployeeAdminMasterResultBean ResultBean = new EmployeeAdminMasterResultBean();

		String serverPath = "";

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss");
		String strDate = sdf.format(cal.getTime());
		if (!file.isEmpty()) {
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				byte[] bytes = file.getBytes();
				String workingDir = System.getProperty("user.dir");
				String fileName;
				String myName;

				myName = "upload" + strDate;
				String localPath = ConfigurationProps.exportFilesPath;
				String name = file.getOriginalFilename();
				int dot = name.lastIndexOf('.');
				String base = (dot == -1) ? name : name.substring(0, dot);
				String extension = (dot == -1) ? "" : name.substring(dot + 1);
				File dir = new File(localPath);

				Date date = new Date();

				base = base + "_" + date.getHours() + "_" + date.getMinutes() + "_" + date.getSeconds() + "."
						+ extension;
				File serverFile = new File(dir.getAbsolutePath() + File.separator + base);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				serverPath = "/filePath/" + base;
				ResultBean.setImgPath(serverPath);

				ResultBean.setSuccess(true);

			} catch (Exception e) {
				LOGGER.error("Error in uploadFile", e);
			}
		}
		return ResultBean;
	}
}