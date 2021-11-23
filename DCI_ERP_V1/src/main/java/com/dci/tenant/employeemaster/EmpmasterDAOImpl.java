package com.dci.tenant.employeemaster;

import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CipherCrypto;
import com.dci.common.util.CodeStandardMsgUtil;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;
import com.dci.tenant.user.UserMasterDAO;
import com.dci.tenant.user.resetPassword.ResetPasswordQueryUtil;
import com.google.common.base.Joiner;

@Repository
@Transactional("tenantTransactionManager")

public class EmpmasterDAOImpl implements EmpmasterDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmpmasterDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	UserMasterDAO objUserMasterDAO;
	
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@SuppressWarnings("deprecation")
	@Override
	public boolean addEmpmaster(EmpmasterBean objEmpmasterBean) throws Exception {
		int val = 1;
		String port = "";
		boolean isSuccess = false;
		String EmpAutoId = "";
		List<String> mulPortVal = objEmpmasterBean.getMulPort();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Map parameters = new HashMap();
			EmpAutoId = jdbcTemplate.queryForObject(EmpmasterQueryUtil.getEmpIdAutoIncrement, String.class);
			String empName = objEmpmasterBean.getEmpName().trim().toUpperCase();
			String doj = objEmpmasterBean.getDoj();
			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(doj);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
          
			String dob = objEmpmasterBean.getDob();
			DateFormat formatter1;
			formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = formatter1.parse(dob);
			java.sql.Timestamp timeStampDate1 = new Timestamp(date1.getTime());
	
			String pswd = CommonUtil.encrypt(objEmpmasterBean.getPswd());

			String ppf = objEmpmasterBean.getPpf();
			java.sql.Timestamp timeStampDate2 = null;
			if(!ppf.equals("")){
				DateFormat formatter2;
				formatter2 = new SimpleDateFormat("dd/MM/yyyy");
				Date date2 = formatter2.parse(ppf);
				timeStampDate2 = new Timestamp(date2.getTime());
			}
			String ppt = objEmpmasterBean.getPpt();
			java.sql.Timestamp timeStampDate3 = null;
			if(!ppt.equals("")){
				DateFormat formatter3;
				formatter3 = new SimpleDateFormat("dd/MM/yyyy");
				Date date3 = formatter3.parse(dob);
				timeStampDate3 = new Timestamp(date3.getTime());
			}
			objEmpmasterBean.setEmpId(EmpAutoId);
			String biMark = objEmpmasterBean.getBiMark();
			String company = objEmpmasterBean.getCompany();
			String bldGrp = objEmpmasterBean.getBldGrp();
			String desgn = objEmpmasterBean.getDsgn();
			String dept = objEmpmasterBean.getDept();
			int bPay = objEmpmasterBean.getbPay();
			String moPay = objEmpmasterBean.getMoPay();
			String acNo = objEmpmasterBean.getAcNo();
			String contactNo = objEmpmasterBean.getContactNo();
			String emailId = objEmpmasterBean.getEmailId();
			String passNo = objEmpmasterBean.getPassNo();
			String placeIssue = objEmpmasterBean.getPlaceIssue();
			String contactAddr = objEmpmasterBean.getContactAddr();
			String isActive = objEmpmasterBean.getIsActive();
			String accessRight = objEmpmasterBean.getAccessRights();
			String agent = objEmpmasterBean.getAgent();
	
			String LoginFlag = "";
			if (agent.equals("Y")) {
				LoginFlag = "A";
			} else {
				LoginFlag = "E";
			}
			String portStr = Joiner.on(",").join(mulPortVal);			
			String serviceLoc =  objEmpmasterBean.getServiceLoc();
			System.out.println("serviceLoc");
			System.out.println(serviceLoc);	
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String createdBy = userDetails.getUserId();
			int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP,
					Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR , Types.VARCHAR};
			Object[] params = new Object[] { EmpAutoId, empName, timeStampDate, timeStampDate1, pswd, timeStampDate2, timeStampDate3, biMark,
					company, bldGrp, desgn, dept, bPay, moPay, acNo, contactNo, emailId, passNo, placeIssue, contactAddr, isActive, accessRight,
					agent, LoginFlag, portStr, createdBy ,serviceLoc};

			val = jdbcTemplate.update(EmpmasterQueryUtil.sAddEmpMaster, params, types);
			if (val > 0) {
		//	DigitalLibraryUtil.saveMenu(jdbcTemplate, EmpAutoId, empName, "User");
			}
			isSuccess = true;
			UserLog userLog = userlogDao.userLogForInsert(objEmpmasterBean, EmpAutoId, userDetails.getUserId());
			auditLogDao.auditLogForInsert(objEmpmasterBean, userLog, null);	
		} catch (DataAccessException e) {
			LOGGER.error("Error in addCostCentre", e);

		}
		return isSuccess;
	}


	
	//edit cotrrrwdsd
	@Override
	public EmpmasterBean getempmasterValues(String empId) throws CustomException {
		EmpmasterBean objBean = new EmpmasterBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { empId };
			Map row = jdbcTemplate.queryForMap(EmpmasterQueryUtil.sEditempMaster, params, types);
			
			objBean.setServiceLoc((String) row.get("serviceLoc"));
			objBean.setEmpId((String) row.get("empId"));
			objBean.setEmpName((String) row.get("empName"));
			objBean.setDoj((String) row.get("doj"));
			objBean.setPswd((String) row.get("pswd"));
			objBean.setContactAddr((String) row.get("contactAddr"));
			objBean.setBiMark((String) row.get("biMark"));
			objBean.setCompany((String) row.get("company"));
			objBean.setBldGrp((String) row.get("bldGrp"));
			objBean.setDsgn((String) row.get("dsgn"));
			objBean.setDept((String) row.get("dept"));
			objBean.setMoPay((String) row.get("moPay"));
			objBean.setAcNo((String) row.get("acNo"));
			objBean.setContactNo((String) row.get("contactNo"));
			objBean.setEmailId((String) row.get("emailId"));
			objBean.setPassNo((String) row.get("passNo"));
			objBean.setPlaceIssue((String) row.get("placeIssue"));
			objBean.setIsActive((String) row.get("isActive"));
			objBean.setAgent((String) row.get("agent"));
			objBean.setAccessRights((String) row.get("accessRights"));
			objBean.setLeaveDate((String) row.get("leaveDate"));
			objBean.setConfDate((String) row.get("confDate"));
			objBean.setDob((String) row.get("dob"));
			objBean.setPpf((String) row.get("ppf"));
			objBean.setPpt((String) row.get("ppt"));
			objBean.setProfileImg(StringUtils.trimToEmpty((String) row.get("profileImg")));

			String portsList = (String) row.get("port");
			if (StringUtils.isNotBlank(portsList)) {
				String arrass[] = portsList.split(",");
				List alresult = new ArrayList();
				for (int i = 0; i < arrass.length; i++) {
					alresult.add(arrass[i]);
				}
				objBean.setMulPort(alresult);
			}
			
			String serviceLoc = (String) row.get("serviceLoc");
			if (StringUtils.isNotBlank(serviceLoc)) {
				String arrass[] = serviceLoc.split(",");
				List alresult = new ArrayList();
				for (int i = 0; i < arrass.length; i++) {
					alresult.add(arrass[i]);
				}
				objBean.setLserviceLoc(alresult);
			}

			objBean.setIsEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
		//	throw new CustomException(VesselMasterMsgUtil.ERROR_ADD);
		}
		return objBean;
	}

	@Override
	public List<EmpmasterBean> getEmpmasterList(int limit, int offset) throws CustomException {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<EmpmasterBean> lEmpmasterBean = jdbcTemplate.query(EmpmasterQueryUtil.sGetEmpmasterValues, new BeanPropertyRowMapper<EmpmasterBean>(
					EmpmasterBean.class));
			return lEmpmasterBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
	}

	@Override
	public EmpmasterResultBean getCompany() {
		EmpmasterResultBean resultBean = new EmpmasterResultBean();
		List<EmpmasterBean> companyList = new ArrayList<EmpmasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			companyList = jdbcTemplate.query(EmpmasterQueryUtil.sCompanyDropDown, new BeanPropertyRowMapper<EmpmasterBean>(EmpmasterBean.class));
			resultBean.setCompanyList(companyList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}

		return resultBean;
	}

	@Override
	public EmpmasterResultBean getDepartment() {
		EmpmasterResultBean resultBean = new EmpmasterResultBean();
		List<EmpmasterBean> departmentList = new ArrayList<EmpmasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			departmentList = jdbcTemplate
					.query(EmpmasterQueryUtil.sDepartmentDropDown, new BeanPropertyRowMapper<EmpmasterBean>(EmpmasterBean.class));
			resultBean.setDepartmentList(departmentList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}

		return resultBean;
	}

	@Override
	public EmpmasterResultBean getDesignation() {
		EmpmasterResultBean resultBean = new EmpmasterResultBean();
		List<EmpmasterBean> designationList = new ArrayList<EmpmasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			designationList = jdbcTemplate.query(EmpmasterQueryUtil.sDesignationDropDown, new BeanPropertyRowMapper<EmpmasterBean>(
					EmpmasterBean.class));
			resultBean.setDesignationList(designationList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}

		return resultBean;
	}

	@Override
	public List getEmployee() {
		List lEmployee = new ArrayList();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(EmpmasterQueryUtil.sEmployeeDropDown);

			for (Map row : rows) {
				EmpmasterBean bean = new EmpmasterBean();
				bean.setEmpName((String) row.get("emp_name"));
				lEmployee.add(bean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getService", e);
		}
		return lEmployee;
	}

	@Override
	public boolean deleteEmpmaster(String empId) throws CustomException {
		boolean isDeleted = false;
		int val = 1;
		EmpmasterBean objPortMaster = getempvalues(empId);
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			val = jdbcTemplate.update(EmpmasterQueryUtil.sDeleteEmpMaster, empId);
			
			val = jdbcTemplate.update(EmpmasterQueryUtil.Delete_SQL_Password, empId);
			if (val > 0) {
				objUserMasterDAO.deleteFormPropertyBeanListByUser(empId);
			}

			isDeleted = true;
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserLog userLog = userlogDao.userLogForDelete(objPortMaster, empId, userDetails.getUserId());
			auditLogDao.auditLogForDelete(objPortMaster, userLog, null);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Port", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_DELETE);
		}

		return isDeleted;
	}

	@Override
	public boolean updateUserProfile(EmpmasterBean objEmpmasterBean) throws CustomException {

		boolean issucces = false;
		int value = 1;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			value = jdbcTemplate.update(EmpmasterQueryUtil.SUpadateEmpmasterProfileImg, new Object[] { objEmpmasterBean.getProfileImg(),
					objEmpmasterBean.getEmpId() });

			if (value != 0) {
				issucces = true;
			}
		}

		catch (Exception ae) {
			LOGGER.error("Error in addCodeStandard", ae);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return issucces;
	}

	@Override
	public boolean updateEmpmaster(EmpmasterBean objEmpmasterBean) throws CustomException {

		boolean issucces = false;
		int value = 1;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<String> mulPortVal = objEmpmasterBean.getMulPort();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String empId = objEmpmasterBean.getEmpId();
			String empName = objEmpmasterBean.getEmpName().trim().toUpperCase();
			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			String doj = objEmpmasterBean.getDoj();
			Date date = formatter.parse(doj);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

			String dob = objEmpmasterBean.getDob();
			DateFormat formatter1;
			formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = formatter1.parse(dob);
			java.sql.Timestamp timeStampDate1 = new Timestamp(date1.getTime());

			String pswd = objEmpmasterBean.getPswd();
			String ppf = objEmpmasterBean.getPpf();
			java.sql.Timestamp timeStampDate2 = null;
			if(ppf != null && !(ppf.equals(""))){
				DateFormat formatter2;
				formatter2 = new SimpleDateFormat("dd/MM/yyyy");
				Date date2 = formatter2.parse(ppf);
				timeStampDate2 = new Timestamp(date2.getTime());
			}

			String ppt = objEmpmasterBean.getPpt();

			java.sql.Timestamp timeStampDate3 = null;
			if(ppt != null && !(ppt.equals(""))){
				DateFormat formatter3;
				formatter3 = new SimpleDateFormat("dd/MM/yyyy");
				Date date3 = formatter3.parse(dob);
				timeStampDate3 = new Timestamp(date3.getTime());
			}
			String biMark = objEmpmasterBean.getBiMark();
			String company = objEmpmasterBean.getCompany();
			String bldGrp = objEmpmasterBean.getBldGrp();
			String desgn = objEmpmasterBean.getDsgn();
			String dept = objEmpmasterBean.getDept();
			int bPay = objEmpmasterBean.getbPay();
			String moPay = objEmpmasterBean.getMoPay();
			String acNo = objEmpmasterBean.getAcNo();
			String contactNo = objEmpmasterBean.getContactNo();
			String emailId = objEmpmasterBean.getEmailId();
			String passNo = objEmpmasterBean.getPassNo();
			String placeIssue = objEmpmasterBean.getPlaceIssue();
			String contactAddr = objEmpmasterBean.getContactAddr();
			String isActive = objEmpmasterBean.getIsActive();
			String accessRight = objEmpmasterBean.getAccessRights();
			String agent = objEmpmasterBean.getAgent();
			String modifiedBy = userDetails.getUserId();
			String confDate = objEmpmasterBean.getConfDate();
			String serviceLoc =  objEmpmasterBean.getServiceLoc();
			java.sql.Timestamp timeStampDate4 = null;
			java.sql.Timestamp timeStampDate5 = null;
			String LoginFlag = "";
			if (agent.equals("Y")) {
				LoginFlag = "A";
			} else {
				LoginFlag = "E";
			}
			String portStr = "";

			DateFormat formatter4;
			if (confDate != null && !confDate.isEmpty()) {
				formatter4 = new SimpleDateFormat("dd/MM/yyyy");
				Date date4 = formatter4.parse(confDate);
				timeStampDate4 = new Timestamp(date4.getTime());
			}

			String leaveDate = objEmpmasterBean.getLeaveDate();
			DateFormat formatter5;
			if (leaveDate != null && !leaveDate.isEmpty()) {
				formatter5 = new SimpleDateFormat("dd/MM/yyyy");
				Date date5 = formatter5.parse(leaveDate);
				timeStampDate5 = new Timestamp(date5.getTime());
			}
			if (mulPortVal != null && !mulPortVal.isEmpty()) {
				portStr = Joiner.on(",").join(mulPortVal);
			}

			
			EmpmasterBean oldempmasterbean = getempmasterValues(empId);
			int[] types = new int[] { Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR ,Types.VARCHAR , Types.VARCHAR};
			Object[] params = new Object[] { empName, timeStampDate, timeStampDate1, timeStampDate2, timeStampDate3, biMark, company, bldGrp, desgn,
					dept, bPay, moPay, acNo, contactNo, emailId, passNo, placeIssue, contactAddr, isActive, accessRight, agent, modifiedBy,
					timeStampDate4, timeStampDate5, LoginFlag, portStr, serviceLoc ,pswd,empId };

			value = jdbcTemplate.update(EmpmasterQueryUtil.SUpadateEmpmaster, params, types);

			if (value > 0) {
			//	DigitalLibraryUtil.updateMenu(jdbcTemplate, empId, empName, "User");
				/*
				 * objUserMasterDAO.deleteFormPropertyBeanListByUser(empId);
				 * objUserMasterDAO
				 * .insertFormPropertyBeanListDesgnNCompUser(company, empId,
				 * desgn);
				 */
			}

			if (value != 0) {
				UserLog userLog = userlogDao.userLogForUpdate(oldempmasterbean, objEmpmasterBean, empId, userDetails.getUserId());
				auditLogDao.auditLogForUpdate(oldempmasterbean, objEmpmasterBean, userLog, null);
				issucces = true;
			}
		}

		catch (Exception ae) {
			LOGGER.error("Error in addCodeStandard", ae);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return issucces;
	}

	@Override
	public EmpmasterResultBean updateUserPassword(EmpmasterBean objEmpmasterBean) throws CustomException {
		boolean isUpdate = false;
		EmpmasterResultBean bean = new EmpmasterResultBean();
		int value = 0;
		String old ="";
		 if(old != null && !old.equalsIgnoreCase("")){
				old = CipherCrypto.Encrypt(objEmpmasterBean.getOlpwd());
 
		 }
		try {
			
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
			 if(old != null && !old.equalsIgnoreCase("")){
			
			if(userDetails.getPassword().equals(old )) {
				
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String pswd = CipherCrypto.Encrypt(objEmpmasterBean.getConfrmPwd());

			int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
			Object[] params = new Object[] { pswd, objEmpmasterBean.getEmpId(), objEmpmasterBean.getEmpId() };

			if(!userDetails.getPassword().equals(pswd)) {
				value = jdbcTemplate.update(EmpmasterQueryUtil.SUpadatePassword, params, types);
				int[] types2 = new int[] { Types.VARCHAR, Types.VARCHAR};
				Object[] params2 = new Object[] { pswd,objEmpmasterBean.getEmpId() };
				
				Integer userCount = jdbcTemplate.queryForObject(ResetPasswordQueryUtil.sGetUserCountLog,new Object[]{objEmpmasterBean.getEmpId()},Integer.class);

				if(userCount > 0) {
					value = jdbcTemplate.update(EmpmasterQueryUtil.UPDATE_USERS_PASSWORD_LOGS,new Object[] { objEmpmasterBean.getConfrmPwd(),objEmpmasterBean.getEmpId() });

				}
				else{
					 value = jdbcTemplate.update(EmpmasterQueryUtil.INSERT_USERS_PASSWORD_LOGS,new Object[] { objEmpmasterBean.getEmpId(),objEmpmasterBean.getConfrmPwd()});

				}
				value = jdbcTemplate.update(EmpmasterQueryUtil.EmpResetPassword, params2, types2);
			}else {
				
				bean.setMessage("New Password Should not same as Old Password.. ");
			}
			

			if (value > 0) {
				bean.setMessage("Password Successfully Changed");
				bean.setSuccess(true);
			} else {
				bean.setMessage("New Password Should not same as Old Password..");
				bean.setSuccess(false);
			}
		}else {
			bean.setMessage("Old Password is not Matched.. ");
			bean.setSuccess(false);
		}
			 }
			 else{
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
					String pswd = CipherCrypto.Encrypt(objEmpmasterBean.getConfrmPwd());

					int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
					Object[] params = new Object[] { pswd, objEmpmasterBean.getEmpId(), objEmpmasterBean.getEmpId() };

					if(!userDetails.getPassword().equals(pswd)) {
						value = jdbcTemplate.update(EmpmasterQueryUtil.SUpadatePassword, params, types);
						int[] types2 = new int[] { Types.VARCHAR, Types.VARCHAR};
						Object[] params2 = new Object[] { pswd,objEmpmasterBean.getEmpId() };

						Integer userCount = jdbcTemplate.queryForObject(ResetPasswordQueryUtil.sGetUserCountLog,new Object[]{objEmpmasterBean.getEmpId()},Integer.class);

						if(userCount > 0) {
							value = jdbcTemplate.update(EmpmasterQueryUtil.UPDATE_USERS_PASSWORD_LOGS,new Object[] { objEmpmasterBean.getConfrmPwd(),objEmpmasterBean.getEmpId() });

						}
						else{
							 value = jdbcTemplate.update(EmpmasterQueryUtil.INSERT_USERS_PASSWORD_LOGS,new Object[] { objEmpmasterBean.getEmpId(),objEmpmasterBean.getConfrmPwd()});

						}						
						value = jdbcTemplate.update(EmpmasterQueryUtil.EmpResetPassword, params2, types2);
					}else {
						
						bean.setMessage("New Password Should not same as Old Password.. ");
					}
					

					if (value > 0) {
						bean.setMessage("Password Successfully Changed");
						bean.setSuccess(true);
					} else {
						bean.setMessage("New Password Should not same as Old Password..");
						bean.setSuccess(false);
					}
				
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public EmpmasterBean getempvalues(String objPortMasterId) throws CustomException {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			EmpmasterBean obj = jdbcTemplate.queryForObject(EmpmasterQueryUtil.sGetEmpmasterValuesaudit, new Object[] { objPortMasterId },
					new BeanPropertyRowMapper<EmpmasterBean>(EmpmasterBean.class));
			return obj;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException("Error in getting obj");
		}
	}

	@Override
	public EmpmasterResultBean getCompanyLocation() {
		// TODO Auto-generated method stub
		EmpmasterResultBean objResultBean = new EmpmasterResultBean();
		List<EmpmasterBean> objCompanyLst = new ArrayList<EmpmasterBean>();
		List<EmpmasterBean> objPortTransmit = new ArrayList<EmpmasterBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			objCompanyLst = jdbcTemplate.query(EmpmasterQueryUtil.sCompanyLocationDropDown, new BeanPropertyRowMapper<EmpmasterBean>(
					EmpmasterBean.class));
			objResultBean.setObjCompanyInfo(objCompanyLst);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSector", e);
		}

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			objPortTransmit = jdbcTemplate.query(EmpmasterQueryUtil.sPortDropDown, new BeanPropertyRowMapper<EmpmasterBean>(
					EmpmasterBean.class));
			objResultBean.setObjPortTransmitInfo(objPortTransmit);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSector", e);
		}
		return objResultBean;
	}
}