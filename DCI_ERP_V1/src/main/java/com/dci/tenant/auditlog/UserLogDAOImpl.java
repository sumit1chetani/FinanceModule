package com.dci.tenant.auditlog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

@Repository
@Transactional("tenantTransactionManager")
public class UserLogDAOImpl implements UserLogDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserLogDAO.class);

//	@Autowired
//	JdbcTemplate jdbcTemplate;
	
	@Resource
	private DataSource dataSource;

	/*@Autowired
	MongoTemplate mongoTemplate;
*/
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<UserLog> getUserLogList(UserLog userLog) throws CustomException {
		// TODO Auto-generated method stub
		List<UserLog> userLogList = new ArrayList<UserLog>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			userLogList = jdbcTemplate.query(UserLogQueryUtil.getUserLogList(userLog.getDateFrom(), userLog.getDateTo(), userLog.getEmployeeId(), userLog.getFormCode(),userLog.getActionType()), new BeanPropertyRowMapper<UserLog>(UserLog.class));
			return userLogList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getAuditLogList", e);
			throw new CustomException("");
		}
	}

public Query addCriteria(UserLog userLog, Query query){


	/*if (StringUtils.isNotBlank(userLog.getFormCode())) {
		query.addCriteria(Criteria.where("formCode").is(userLog.getFormCode()));
	}
	if (StringUtils.isNotBlank(userLog.getEmployeeId())) {
		query.addCriteria(Criteria.where("employeeId").is(userLog.getEmployeeId()));
	}

	if (StringUtils.isNotBlank(userLog.getTableName())) {
		query.addCriteria(Criteria.where("tableName").is(userLog.getTableName()));
	}
	
	if (StringUtils.isNotBlank(userLog.getActionType())) {
		query.addCriteria(Criteria.where("actionType").is(userLog.getActionType()));
	}
	
	query.with(new Sort(Sort.Direction.DESC, "_id"));*/

	return query;

}
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<String> getFormCodeList() throws Exception {
//		// TODO Auto-generated method stub
//		List<EmployeeMasterBean> employeeList = new ArrayList<EmployeeMasterBean>();
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		try {
//			employeeList = jdbcTemplate.query(UserLogQueryUtil.SELECT_EMPLOYEE_LIST, new BeanPropertyRowMapper<EmployeeMasterBean>(EmployeeMasterBean.class));
//
//		} catch (DataAccessException e) {
//			LOGGER.error("Error in getEmployeeList", e);
//			throw new CustomException(ErrorMessage.ERROR_LIST);
//		}
//		return employeeList;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLog> getTableNameList() throws Exception {
		List<UserLog> tableNameList = new ArrayList<UserLog>();
		/*try {

			tableNameList = mongoTemplate.getCollection("user_log").distinct("tableName");

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return tableNameList;
	}

//	private UserLog insertUserLog(UserLog userLog) {
//		/*try {
//			userLog.setLogdate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS").format(new Date()));
//			userLog.setLogdateMillis(new Date().getTime());
//			mongoTemplate.insert(userLog, "user_log");
//			userLog.setUserLogId(userLog.getId());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//		return userLog;
//	}
	
	@Override
	public List<EmployeeMasterBean> getEmployeeList() throws CustomException {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		EmployeeMasterBean okk = new EmployeeMasterBean();
		List<SelectivityBean> okker = new ArrayList<SelectivityBean>();
		List<EmployeeMasterBean> employeeList = new ArrayList<EmployeeMasterBean>();
		try {
			okker = jdbcTemplate.query(UserLogQueryUtil.SELECT_EMPLOYEE_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			okk.setOkker(okker);
			employeeList.add(okk);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeeList", e);
		}
		return employeeList;
	}

	
	
	@SuppressWarnings("deprecation")
	private UserLog insertUserLog(UserLog userLog) {
		Integer userLogId = 0;
		Map<String, Object> userLogMap = new HashMap<String, Object>();
		userLogMap.put("employeeId", userLog.getEmployeeId());
		userLogMap.put("formCode", userLog.getFormCode());
		userLogMap.put("actionType", userLog.getActionType());
		userLogMap.put("primaryDataId", userLog.getPrimaryDataId());
		userLogMap.put("tableName", userLog.getTableName());
		userLogMap.put("logDesc", userLog.getLogDescription());
		userLogMap.put("userip", userLog.getIpAddres());
		try {
			int i= namedParameterJdbcTemplate.update(UserLogQueryUtil.INSERT_USER_LOG, userLogMap);
		   if(i>0)
		   {
			   System.out.println("sfsdfsfs");
			   }
			//userLog.setUserLogId(userLogId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userLog;
	}
	
	
	@Override
	public UserLog userLogForInsert(Object newObject, String primaryId, String createdBy) {
		UserLog userLog = null;
		try {
			userLog = UserLogUtil.userLogDescForInsert(newObject, primaryId, createdBy);
			userLog = insertUserLog(userLog);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in userLogForInsert", e);
		}
		return userLog;
	}

	@Override
	public UserLog userLogForUpdate(Object oldObject, Object newObject, String primaryId, String createdBy) {
		UserLog userLog = null;
		try {
			userLog = UserLogUtil.userLogDescForUpdate(oldObject, newObject, primaryId, createdBy);
			userLog = insertUserLog(userLog);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in userLogForUpdate", e);
		}
		return userLog;
	}

	@Override
	public UserLog userLogForDelete(Object oldObject, String primaryId, String createdBy) {
		UserLog userLog = null;
		try {
			userLog = UserLogUtil.userLogDescForDelete(oldObject, primaryId, createdBy);
			userLog = insertUserLog(userLog);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in userLogForDelete", e);
		}
		return userLog;
	}
	

	//User IP Log 

@Override
public List<UserLog> getUserIPLogList(UserLog userLog) throws CustomException{
	List<UserLog> getUserIPLogList = new ArrayList<UserLog>();
	//String wherCondition="";
	/*try {
		if (!CommonExcelUtils.checkEmptyString(userLog.getDateFrom()).equals("")) {
			if (wherCondition.isEmpty()) {
				wherCondition = " where ";
			} else {
				wherCondition = " and ";
			}
			wherCondition = wherCondition + "CREATED_DT::date >= to_date('"+ userLog.getDateFrom() + "','DD/MM/YYYY')";
		}
		if (!CommonExcelUtils.checkEmptyString(userLog.getDateTo()).equals("")) {
			if (wherCondition.isEmpty()) {
				wherCondition = " where ";
			} else {
				wherCondition = wherCondition +" and ";
			}
			wherCondition = wherCondition + "CREATED_DT::date <= to_date('" + userLog.getDateTo() + "','DD/MM/YYYY')";
		}
		if (!CommonExcelUtils.checkEmptyString(userLog.getEmployeeId()).equals("")) {
			if (wherCondition.isEmpty()) {
				wherCondition = " where ";
			} else {
				wherCondition = wherCondition + " and ";
			}
			wherCondition = wherCondition + "USER_ID ='"+userLog.getEmployeeId()+"'";
		}

		if (!CommonExcelUtils.checkEmptyString(userLog.getActionType()).equals("")) {
			if (wherCondition.isEmpty()) {
				wherCondition = " where ";
			} else {
				wherCondition = wherCondition +" and ";
			}
			wherCondition = wherCondition + "ACTION ='"+userLog.getActionType().toUpperCase()+"'";
		}
		System.out.println(wherCondition);
		getUserIPLogList = jdbcTemplate.query(UserLogQueryUtil.SELECT_UserIPLog(wherCondition), new BeanPropertyRowMapper<UserLog>(UserLog.class));
		return getUserIPLogList;

	} catch (DataAccessException e) {
		LOGGER.error("Error in getUserIPLogList", e);
		throw new CustomException(ErrorMessage.ERROR_LIST);
	}*/
	return getUserIPLogList;
 }

@Override
public List<UserLog> getFormCodeList() throws Exception {
	List<UserLog> formCodeList = new ArrayList<UserLog>();
	UserLog user = new UserLog();
	List<SelectivityBean> onkk = new ArrayList<SelectivityBean>();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	try {
		onkk = jdbcTemplate.query(UserLogQueryUtil.SELECT_USER_LOG_FORM_CODE, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		
		user.setOnkk(onkk);
		
		formCodeList.add(user);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return formCodeList;
}
@Override
public UserLog userLogForFreightInvoice(Object newObject, String primaryId, String createdBy, String printType) {
	UserLog userLog = null;
	try {
		userLog = UserLogUtil.userLogForFreightInvoice(newObject, primaryId, createdBy, printType);
		userLog = insertUserLog(userLog);
	} catch (Exception e) {
		e.printStackTrace();
		LOGGER.error("Error in userLogForFreightInvoice", e);
	}
	return userLog;
}


}
