package com.dci.tenant.auditlog;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;

@Repository
public class AuditLogDAOImpl implements AuditLogDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(AuditLogDAO.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	/*@Autowired
	MongoTemplate mongoTemplate;*/

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<AuditLogBean> getAuditLogList(String date, String employeeNo) throws CustomException {
		// TODO Auto-generated method stub
		List<AuditLogBean> auditLogBeanList = new ArrayList<AuditLogBean>();
		/*try {
			Query query = new Query();
			if (StringUtils.isNotBlank(date)) {
				query.addCriteria(Criteria.where("createdOn").regex(date));
			}
			if (StringUtils.isNotBlank(employeeNo)) {
				query.addCriteria(Criteria.where("employeeId").is(employeeNo));
			}
			auditLogBeanList = mongoTemplate.find(query, AuditLogBean.class, "audit_log");
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in getAuditLogList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}*/
		return auditLogBeanList;
	}

	@Override
	public List<SesLogBean> getSesLogList(String date, String employeeNo) throws CustomException {
		// TODO Auto-generated method stub
		List<SesLogBean> sesLogBeanList = new ArrayList<SesLogBean>();
		/*try {
			Query query = new Query();
			if (StringUtils.isNotBlank(date)) {
				query.addCriteria(Criteria.where("createdOn").regex(date));
			}
			if (StringUtils.isNotBlank(employeeNo)) {
				query.addCriteria(Criteria.where("employeeId").is(employeeNo));
			}
			sesLogBeanList = mongoTemplate.find(query, SesLogBean.class, "session_log");
		} catch (DataAccessException e) {
			LOGGER.error("Error in getSesLogList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}*/
		return sesLogBeanList;
	}

	@Override
	public void auditLogForInsert(Object newObject, UserLog userLog, String parentId) {
		/*try {
			List<AuditLogBean> auditLogList = AuditLogUtil.auditLogForInsert(newObject, userLog, parentId);
			this.insertAuditLog(auditLogList);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in auditLogForInsert", e);
		}*/
	}

	@Override
	public void auditLogForUpdate(Object oldObject, Object newObject, UserLog userLog, String parentId) {
		/*try {
			List<AuditLogBean> auditLogList = AuditLogUtil.auditLogForUpdate(oldObject, newObject, userLog, parentId);
			this.insertAuditLog(auditLogList);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in auditLogForUpdate", e);
		}*/
	}

	@Override
	public void auditLogForDelete(Object newObject, UserLog userLog, String parentId) {
		/*try {
			List<AuditLogBean> auditLogList = AuditLogUtil.auditLogForDelete(newObject, userLog, parentId);
			this.insertAuditLog(auditLogList);
		} catch (Exception e) {
			LOGGER.error("Error in auditLogForDelete", e);
		}*/
	}

	@Override
	public void insertAuditLog(List<AuditLogBean> auditLogBeanList) {
		/*for (AuditLogBean auditLog : auditLogBeanList) {
			// TODO Auto-generated method stub
			try {
				auditLog.setCreatedOn(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS").format(new Date()));
				auditLog.setLogdateMillis(new Date().getTime());
				//mongoTemplate.insert(auditLog, "audit_log");
			} catch (DataAccessException e) {
				LOGGER.error("Error in insertAuditLog", e);
			}
		}*/
	}

	@Override
	public void insertSessionLog(SesLogBean sesLogBean) {
		/*try {
			mongoTemplate.insert(sesLogBean, "session_log");
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertAuditLog", e);
		}*/
	}
}
