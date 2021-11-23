package com.dci.master.employeemaster;
import java.sql.Types;
import java.util.ArrayList;
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
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.employeemaster.EmpmasterQueryUtil;
import com.dci.tenant.user.UserDetail;
import com.dci.tenant.user.UserMasterDAO;

@Repository
@Transactional("tenantTransactionManager")

public class EmpMasterDAOImpl  implements EmpMasterDAO{
	private final static Logger LOGGER = LoggerFactory.getLogger(EmpMasterDAOImpl.class);


	@Autowired
	DataSource dataSource;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	UserMasterDAO objUserMasterDAO;
	@Autowired
	UserMasterDAO userMasterServiceDAO;
	
	@Override
	public List<EmpMasterBean> MasterList() {

		List<EmpMasterBean> list = new ArrayList<EmpMasterBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(EmpMasterQueryUtil.list,new BeanPropertyRowMapper<EmpMasterBean>(EmpMasterBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public EmpMasterBean insert(EmpMasterBean master) throws Exception {
		// TODO Auto-generated method stub
		Boolean isSuccess = false;
		String emp=" ";
		EmpMasterBean masterBean = new EmpMasterBean();
		
	
		
		
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			emp= jdbcTemplate.queryForObject(EmpMasterQueryUtil.Last_seq_no,String.class);
			String pswd = CipherCrypto.Encrypt(master.getPassword());
			
			
			int i= 	jdbcTemplate.update(EmpMasterQueryUtil.INSERT,emp,master.getProbationfrom(),master.getContact_no(), master.getEmp_name(), master.getProbation_to(),master.getEmail(),
					master.getDt_of_birth(),master.getBirth_identity(),pswd,master.getPassport_no(),master.getDt_of_join(),master.getCompany(),master.getPlace_issue(),master.getDesignation(),
					master.getBlood_group(),master.getAddress(),master.getDepartment(),master.getBasic_pay(),master.getDt_of_confirm(),master.getMode_payment(),master.getDt_of_leave(),
					master.isAgent(),master.isActive(),master.getAgentName(),master.getPort());
			int j = jdbcTemplate.update(EmpMasterQueryUtil.USERS_PASSWORD_LOGS, emp, master.getPassword() );
			 if(i>0) {
	            	isSuccess = true;
	            	masterBean.setIsSuccess(isSuccess);
	            }
		}catch (DataAccessException e) {
			
			e.printStackTrace();
			isSuccess = false;
			masterBean.setIsSuccess(isSuccess);
			masterBean.setMessage("Error in save :" + e.getMessage());
		}
		return masterBean;
	}
	@Override
	public boolean deleteMaster(String emp_id) {
		boolean isDeleted = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 

		try {
			jdbcTemplate.update(EmpMasterQueryUtil.delete, emp_id);

		jdbcTemplate.update(EmpmasterQueryUtil.Delete_SQL_Password, emp_id);

			
			isDeleted = true;
		} catch (DataAccessException e) {
			
			
		}

		return isDeleted;
	}

	@Override
	public EmpMasterBean getEdit(String emp_id) {
		EmpMasterBean damagebean =new EmpMasterBean();
		try {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			damagebean = jdbcTemplate.queryForObject(EmpMasterQueryUtil.GET_MASTER,
					new Object[] { emp_id },
					new BeanPropertyRowMapper<EmpMasterBean>(EmpMasterBean.class));

		}catch (Exception e) {
			e.printStackTrace();
		}
		return damagebean;
	}

	@Override
	public EmpMasterBean update(EmpMasterBean master) throws Exception {
		
		Boolean isSuccess = false;
		EmpMasterBean masterBean = new EmpMasterBean();
		
		
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			
		int i =	jdbcTemplate.update(EmpMasterQueryUtil.UPDATE,master.getProbationfrom(),master.getContact_no(), master.getEmp_name(), master.getProbation_to(),master.getEmail(),
				master.getDt_of_birth(),master.getBirth_identity(),master.getPassport_no(),master.getDt_of_join(),master.getCompany(),master.getPlace_issue(),master.getDesignation(),
				master.getBlood_group(),master.getAddress(),master.getDepartment(),master.getBasic_pay(),master.getDt_of_confirm(),master.getMode_payment(),master.getDt_of_leave(),
				master.isAgent(),master.isActive(),master.getAgentName(),master.getPort(),master.getEmp_id());
		if(i>0) {
        	isSuccess = true;
        	masterBean.setIsSuccess(isSuccess);
        }
		}catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			masterBean.setIsSuccess(isSuccess);
			masterBean.setMessage("Error in save :" + e.getMessage());
		}
		return masterBean;
	}
	
	
	@Override
	public List<EmpMasterBean> getDropDown() {

		List<EmpMasterBean> list = new ArrayList<EmpMasterBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(EmpMasterQueryUtil.Deplist,new BeanPropertyRowMapper<EmpMasterBean>(EmpMasterBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<EmpMasterBean> agent() {

		List<EmpMasterBean> list = new ArrayList<EmpMasterBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(EmpMasterQueryUtil.Agentlist,new BeanPropertyRowMapper<EmpMasterBean>(EmpMasterBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<EmpMasterBean> dropdown() {

		List<EmpMasterBean> list = new ArrayList<EmpMasterBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(EmpMasterQueryUtil.Deslist,new BeanPropertyRowMapper<EmpMasterBean>(EmpMasterBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<EmpMasterBean> port() {

		List<EmpMasterBean> list = new ArrayList<EmpMasterBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(EmpMasterQueryUtil.Prtlist,new BeanPropertyRowMapper<EmpMasterBean>(EmpMasterBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	@Override
	public List<EmpMasterBean> drop() {

		List<EmpMasterBean> list = new ArrayList<EmpMasterBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(EmpMasterQueryUtil.Cmplist,new BeanPropertyRowMapper<EmpMasterBean>(EmpMasterBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public EmpMasterBean updateUserPassword(EmpMasterBean objEmpmasterBean) throws CustomException {
		EmpMasterBean resultBean = new EmpMasterBean();
		resultBean.setIsSuccess(false);
		int value = 0;
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			System.out.println("new PWD " + objEmpmasterBean.getConfrmPwd());
			UserDetail user = userMasterServiceDAO.loadUserByUsername(userDetails.getEmail().toUpperCase());
			if (!(user.getPassword()).equals(CipherCrypto.Encrypt(objEmpmasterBean.getConfrmPwd()))) {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				String pswd = CipherCrypto.Encrypt(objEmpmasterBean.getConfrmPwd());
				String oldpswd = jdbcTemplate.queryForObject(EmpMasterQueryUtil.getOldpswrd, String.class,objEmpmasterBean.getEmp_id());

				EmpmasterBean1 old = new EmpmasterBean1();
				old.setPswd(oldpswd);
				old.setEmpId(objEmpmasterBean.getEmp_id());
				
				EmpmasterBean2 newone = new EmpmasterBean2();
				newone.setPswd(pswd);
				newone.setEmpId(objEmpmasterBean.getEmp_id());
				
				
				int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
				Object[] params = new Object[] { pswd, objEmpmasterBean.getEmp_id(), objEmpmasterBean.getEmp_id() };

				value = jdbcTemplate.update(EmpMasterQueryUtil.SUpdatePassword, params, types);
				
				int i = jdbcTemplate.update(EmpMasterQueryUtil.UPDATE_USERS_PASSWORD_LOGS,new Object[] { pswd,objEmpmasterBean.getEmp_id() });
				
				if (value > 0) {
					objEmpmasterBean.setPassword(pswd);
					UserLog userLog = userlogDao.userLogForUpdate(old, newone, objEmpmasterBean.getEmp_id(), userDetails.getUserId());
					auditLogDao.auditLogForUpdate(old, newone, userLog, null);
					
					resultBean.setIsSuccess(true);
				} else {
					resultBean.setIsSuccess(false);
					resultBean.setErrors("Please try Later!");
				}
			} else {
				resultBean.setErrors("New Password Should be Diff. from Old Password!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public EmpMasterBean getempmasterValues(String emp_id) throws Exception {
		EmpMasterBean objBean = new EmpMasterBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { emp_id };
			Map row = jdbcTemplate.queryForMap(EmpmasterQueryUtil.sEditempMaster, params, types);
			objBean.setServiceLoc((String) row.get("serviceLoc"));
			objBean.setEmp_id((String) row.get("empId"));
			objBean.setEmp_name((String) row.get("empName"));
			objBean.setDt_of_birth((String) row.get("doj"));
			objBean.setPassword((String) row.get("pswd"));
			objBean.setBirth_identity((String) row.get("biMark"));
			objBean.setCompany((String) row.get("company"));
			objBean.setBlood_group((String) row.get("bldGrp"));
			objBean.setDesignation((String) row.get("dsgn"));
			objBean.setDepartment((String) row.get("dept"));
			objBean.setMoPay((String) row.get("moPay"));
			objBean.setAcNo((String) row.get("acNo"));
			objBean.setAddress((String) row.get("address"));
			objBean.setContact_no((String) row.get("contactNo"));
			objBean.setEmail((String) row.get("emailId"));
			objBean.setPassport_no((String) row.get("passNo"));
			objBean.setPlace_issue((String) row.get("placeIssue"));
			objBean.setActive((boolean) row.get("isActive"));
			objBean.setAgent((boolean) row.get("agent"));
			objBean.setDt_of_leave((String) row.get("leaveDate"));
			objBean.setDt_of_confirm((String) row.get("confDate"));
			objBean.setDt_of_birth((String) row.get("dob"));
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
			
			

			objBean.setEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
		}
		return objBean;
	}
	

	@Override
	public boolean updateUserProfile(EmpMasterBean objEmpmasterBean) throws CustomException {
		boolean issucces = false;
		int value = 1;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			value = jdbcTemplate.update(EmpmasterQueryUtil.SUpadateEmpmasterProfileImg, new Object[] { objEmpmasterBean.getProfileImg(),
					objEmpmasterBean.getEmp_id() });

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

}
