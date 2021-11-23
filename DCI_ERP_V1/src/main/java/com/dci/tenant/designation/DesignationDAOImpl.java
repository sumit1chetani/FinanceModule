package com.dci.tenant.designation;



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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CodeStandardMsgUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")

public class DesignationDAOImpl implements DesignationDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(DesignationDAOImpl.class);

	@Autowired
	DataSource dataSource;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Override
	public boolean addDesignation(DesignationBean objDesignationBean) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean issucces = false;
		String createdBy = "";
		int value = 0;
		String getDesgnIdAutoIncrement = "";
		try {
			//String desgnCode = objDesignationBean.getDesgnCode();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Map parameters = new HashMap();

			getDesgnIdAutoIncrement = jdbcTemplate.queryForObject(DesignationQueryUtil.getDesgnIdAutoIncrement, String.class);
			createdBy = userDetails.getUserId();
			 objDesignationBean.setDesgnCode(getDesgnIdAutoIncrement);
			int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
			Object[] params = new Object[] { getDesgnIdAutoIncrement, objDesignationBean.getDesgnName(), objDesignationBean.getIsActive(),
					objDesignationBean.getDesgnDesc(), createdBy };
			int i = jdbcTemplate.queryForObject(DesignationQueryUtil.sCheckDesignationAdd, new Object[] { objDesignationBean.getDesgnName() },Integer.class);
			objDesignationBean.setDesgnCode(getDesgnIdAutoIncrement);
			if (i == 0) {
				value = jdbcTemplate.update(DesignationQueryUtil.sInsertDesgnDetails, params, types);
				issucces = true;
				objDesignationBean.setTableName("designation_master");
				objDesignationBean.setFormCode("F0060");
				UserLog userLog = userlogDao.userLogForInsert(objDesignationBean, objDesignationBean.getDesgnCode(), userDetails.getUserId());
				auditLogDao.auditLogForInsert(objDesignationBean, userLog, null);
			}

		} catch (Exception ae) {
			LOGGER.error("Error in addCodeStandard", ae);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return issucces;
	}

	@Override
	public DesignationBean getdesignationValues(String desgnCode) throws CustomException {
		DesignationBean objBean = new DesignationBean();
		String desgnDesc="";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { desgnCode };
			Map row = jdbcTemplate.queryForMap(DesignationQueryUtil.sEditDesignation, params, types);
			objBean.setDesgnName((String) row.get("desgnName"));
			objBean.setIsActive((String) row.get("isActive"));
			objBean.setIsEdit(true);
			objBean.setDesgnCode(desgnCode);
			objBean.setDesgnDesc(desgnDesc);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
	//		throw new CustomException(VesselMasterMsgUtil.ERROR_ADD);
		}
		return objBean;
	}

	@Override
	public boolean deleteDesignation(String dCode) throws CustomException {

		boolean issucces = false;
		int value = 0;
		String getDesgnIdAutoIncrement = "";
		try {
			DesignationBean objDesignationBean= getdesignationValues( dCode);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			value = jdbcTemplate.update(DesignationQueryUtil.sDeleteDesgnDetail, dCode);
			getDesgnIdAutoIncrement = jdbcTemplate.queryForObject(DesignationQueryUtil.getDesgnIdAutoIncrement, String.class);
			 objDesignationBean.setDesgnCode(getDesgnIdAutoIncrement);

			if (value != 0) {
				issucces = true;
				objDesignationBean.setTableName("designation_master");
				objDesignationBean.setFormCode("F0060");
				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				UserLog userLog = userlogDao.userLogForDelete(objDesignationBean, objDesignationBean.getDesgnCode(), userDetails.getUserId());
				auditLogDao.auditLogForDelete(objDesignationBean, userLog, null);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return issucces;
	}

	@Override
	public boolean updateDesignation(DesignationBean objDesignationBean) throws CustomException {

		boolean issucces = false;
		int value = 0;
		String gedesgnId = "";
		String getDesgnIdAutoIncrement = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			gedesgnId = objDesignationBean.getDesgnCode();

			DesignationBean objDesignationBeanOld = getdesignationValues(gedesgnId);
			 objDesignationBean.setDesgnCode(gedesgnId);
			int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
			Object[] params = new Object[] { objDesignationBean.getDesgnName(), objDesignationBean.getIsActive(), gedesgnId };

			int i = jdbcTemplate.queryForObject(DesignationQueryUtil.sCheckDesignationUpdate,
					new Object[] { gedesgnId, objDesignationBean.getDesgnName() },int.class);
			if (i == 0) {
				jdbcTemplate.update(DesignationQueryUtil.sUpdateDesgn, objDesignationBean.getDesgnName(), objDesignationBean.getIsActive(),gedesgnId);
				issucces = true;
				objDesignationBean.setTableName("designation_master");
				objDesignationBean.setFormCode("F0060");
				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				UserLog userLog = userlogDao.userLogForUpdate(objDesignationBeanOld, objDesignationBean, gedesgnId, userDetails.getUserId());
				auditLogDao.auditLogForUpdate(objDesignationBeanOld, objDesignationBean, userLog, null);
			}
		}

		catch (Exception ae) {
			LOGGER.error("Error in addCodeStandard", ae);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return issucces;
	}

	@Override
	public List getDesignation() {
		List lDesignation = new ArrayList();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(DesignationQueryUtil.sDesignationDropDown);

			for (Map row : rows) {
				DesignationBean bean = new DesignationBean();
				bean.setDesgnName((String) row.get("desgn_name"));
				lDesignation.add(bean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getService", e);
		}
		return lDesignation;
	}

	@Override
	public List<DesignationBean> getDesignationList(int limit, int offset) throws CustomException {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<DesignationBean> lDesignationBean = jdbcTemplate.query(DesignationQueryUtil.sGetDesignationValues,
					new BeanPropertyRowMapper<DesignationBean>(DesignationBean.class));
			return lDesignationBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}

	}
	public DesignationBean getdesignationValue(String desgnCode) throws Exception {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			System.out.println(desgnCode);
			DesignationBean designationBean = jdbcTemplate.queryForObject(DesignationQueryUtil.sGetDesignationValues, new Object[] { desgnCode },
					new BeanPropertyRowMapper<DesignationBean>(DesignationBean.class));
			return designationBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException("Error in getting currency");
		}
	}
}

