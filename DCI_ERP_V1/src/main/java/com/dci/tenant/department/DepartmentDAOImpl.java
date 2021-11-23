	package com.dci.tenant.department;

	
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

	public class DepartmentDAOImpl implements DepartmentDAO {

		private final static Logger LOGGER = LoggerFactory.getLogger(DepartmentDAOImpl.class);

		@Autowired
		DataSource dataSource;
		
		@Autowired
		AuditLogDAO auditLogDao;

		@Autowired
		UserLogDAO userlogDao;

		@SuppressWarnings("deprecation")
		@Override
		public boolean addDepartment(DepartmentBean objDepartmentBean) throws CustomException {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			boolean issucces = false;
			String createdBy = "";
			int value = 0;
			String getDeptIdAutoIncrement = "";
			try {
				String deptCode = objDepartmentBean.getDeptCode();
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				Map parameters = new HashMap();

				getDeptIdAutoIncrement = jdbcTemplate.queryForObject(DepartmentQueryUtil.getDeptIdAutoIncrement, String.class);
				createdBy = userDetails.getUserId();
				objDepartmentBean.setDeptCode(getDeptIdAutoIncrement);

				int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
				Object[] params = new Object[] { getDeptIdAutoIncrement, objDepartmentBean.getDeptName(), objDepartmentBean.getDeptHead(),
						objDepartmentBean.getIsActive(), objDepartmentBean.getDeptDesc(), createdBy };
				int i = jdbcTemplate.queryForObject(DepartmentQueryUtil.sCheckDepartmentAdd, new Object[] { objDepartmentBean.getDeptName() },Integer.class );
				if (i == 0) {
					value = jdbcTemplate.update(DepartmentQueryUtil.sInsertDeptDetails, params, types);
					objDepartmentBean.setTableName("branch_master");
					objDepartmentBean.setFormCode("F5118");
					issucces = true;
					UserLog userLog = userlogDao.userLogForInsert(objDepartmentBean, objDepartmentBean.getDeptCode(), userDetails.getUserId());
					auditLogDao.auditLogForInsert(objDepartmentBean, userLog, null);
				}

			} catch (Exception ae) {
				LOGGER.error("Error in addCodeStandard", ae);
				throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
			}
			return issucces;
		}

		@Override
		public DepartmentBean getdepartmentValues(String deptCode) throws CustomException {
			DepartmentBean objBean = new DepartmentBean();
			String deptDesc="";
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				int[] types = new int[] { Types.VARCHAR };
				Object[] params = new Object[] { deptCode };
				Map row = jdbcTemplate.queryForMap(DepartmentQueryUtil.sEditDepartment, params, types);
				objBean.setDeptName((String) row.get("deptName"));
				objBean.setDeptHead((String) row.get("deptHead"));
				objBean.setIsActive((String) row.get("isActive"));
				objBean.setIsEdit(true);
				objBean.setDeptCode(deptCode);
				objBean.setDeptDesc(deptDesc);

			} catch (DataAccessException e) {
				LOGGER.error("Error in getList", e);
				//throw new CustomException(VesselMasterMsgUtil.ERROR_ADD);
			}
			return objBean;
		}

		@Override
		public DepartmentResultBean getEmployee() {
			DepartmentResultBean resultBean = new DepartmentResultBean();
			List<DepartmentBean> employeeList = new ArrayList<DepartmentBean>();
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				employeeList = jdbcTemplate.query(DepartmentQueryUtil.sEmployeeDropDown, new BeanPropertyRowMapper<DepartmentBean>(DepartmentBean.class));
				resultBean.setEmployeeList(employeeList);
				resultBean.setMessage("success");
			} catch (Exception e1) {
				LOGGER.error("Error in ", e1);
				resultBean.setMessage("failure");
			}

			return resultBean;
		}

		@Override
		public List getDepartment() {
			List lDepartment = new ArrayList();
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				List<Map<String, Object>> rows = jdbcTemplate.queryForList(DepartmentQueryUtil.sDepartmentDropDown);

				for (Map row : rows) {
					DepartmentBean bean = new DepartmentBean();
					bean.setDeptName((String) row.get("dept_name"));
					lDepartment.add(bean);
				}
			} catch (DataAccessException e) {
				LOGGER.error("Error in getService", e);
			}
			return lDepartment;
		}

		@Override
		public boolean deleteDepartment(String dCode) throws CustomException {

			boolean issucces = false;
			int value = 0;
			String getDeptIdAutoIncrement = "";

			try {
				DepartmentBean objDepartmentBean= getdepartmentValues(dCode);
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				value = jdbcTemplate.update(DepartmentQueryUtil.sDeleteDeptDetail, dCode);
				 objDepartmentBean.setDeptCode(getDeptIdAutoIncrement);
				if (value != 0) {
					issucces = true;
					objDepartmentBean.setTableName("branch_master");
					objDepartmentBean.setFormCode("F5118");
					UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					UserLog userLog = userlogDao.userLogForDelete(objDepartmentBean,dCode, userDetails.getUserId());
					auditLogDao.auditLogForDelete(objDepartmentBean, userLog, null);
				}
			} catch (DataAccessException e) {
				LOGGER.error("Error in Delete", e);
				throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
			}
			return issucces;
		}

		@Override
		public boolean updateDepartment(DepartmentBean objDepartmentBean) throws CustomException {

			boolean issucces = false;
			int value = 0;
			String gedeptId = "";
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				gedeptId = objDepartmentBean.getDeptCode();
				DepartmentBean objDepartmentBeanOld = getdepartmentValues(gedeptId);
				int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
				Object[] params = new Object[] { objDepartmentBean.getDeptName(), objDepartmentBean.getDeptHead(), objDepartmentBean.getIsActive(),
						gedeptId };

				int i = jdbcTemplate.queryForObject(DepartmentQueryUtil.sCheckDepartmentUpdate, new Object[] { gedeptId, objDepartmentBean.getDeptName()},Integer.class );
				if (i == 0) {
					jdbcTemplate.update(DepartmentQueryUtil.sUpdateDept,objDepartmentBean.getDeptName(), objDepartmentBean.getDeptHead(), objDepartmentBean.getIsActive(),
							gedeptId);
					objDepartmentBean.setTableName("branch_master");
					objDepartmentBean.setFormCode("F5118");
					issucces = true;
					UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					UserLog userLog = userlogDao.userLogForUpdate(objDepartmentBeanOld, objDepartmentBean, objDepartmentBean.getDeptCode(), userDetails.getUserId());
					auditLogDao.auditLogForUpdate(objDepartmentBeanOld, objDepartmentBean, userLog, null);
				}

			}

			catch (Exception ae) {
				LOGGER.error("Error in addCodeStandard", ae);
				throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
			}
			return issucces;
		}

		@Override
		public List<DepartmentBean> getDepartmentList(int limit, int offset) throws CustomException {
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				List<DepartmentBean> lDepartmentBean = jdbcTemplate.query(DepartmentQueryUtil.sGetDepartmentValues,
						new BeanPropertyRowMapper<DepartmentBean>(DepartmentBean.class));
				return lDepartmentBean;
			} catch (DataAccessException e) {
				LOGGER.error("Error in List", e);
				throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
			}

		}
		public DepartmentBean getdepartmentValue(String deptId) throws Exception {
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				System.out.println(deptId);
				DepartmentBean departmentBean = jdbcTemplate.queryForObject(DepartmentQueryUtil.sEditDepartment, new Object[] { deptId },
						new BeanPropertyRowMapper<DepartmentBean>(DepartmentBean.class));
				return departmentBean;
			} catch (DataAccessException e) {
				LOGGER.error("Error in List", e);
				throw new CustomException("Error in getting currency");
			}
		}
	}
																			