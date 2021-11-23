package com.dci.master.CompanyGroup;

import java.util.ArrayList;
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

import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
public class CompanyGroupDAOImpl implements CompanyGroupDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(CompanyGroupDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@SuppressWarnings("deprecation")
	// Company Add
	@Override
	public boolean addCompanyDetails(CompanyGroupBean objCompanyGroupBean) throws CustomException {
		boolean isAdded = false;
		String groupName = "";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {

			String companyGroupName = objCompanyGroupBean.getGroupname().trim().toUpperCase();
			int companyGroupId = objCompanyGroupBean.getGroupid();
			boolean isEdit = objCompanyGroupBean.isEdit();
			ArrayList userSelectedCompanyList = new ArrayList();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			ArrayList companydetailList = new ArrayList();

			userSelectedCompanyList = objCompanyGroupBean.getUsrSelectedList();

			companydetailList = ((ArrayList) userSelectedCompanyList.get(0));

			if (isEdit) {
				
				CompanyGroupBean oldHeader = new CompanyGroupBean();
				groupName = jdbcTemplate.queryForObject(CompanyGroupQueryUtil.SELECT_GROUP_NAME, new Object[] { companyGroupId },String.class);
				oldHeader.setGroupname(groupName);
				jdbcTemplate.update(CompanyGroupQueryUtil.sUpdateCompanyGroupDetail, new Object[] { companyGroupName, companyGroupId });
				UserLog userLog = userlogDao.userLogForUpdate(oldHeader, objCompanyGroupBean, companyGroupName, userDetails.getUserId());
				auditLogDao.auditLogForUpdate(oldHeader, objCompanyGroupBean, userLog, null);
				if (companydetailList.size() > 0) {
					saveCompanyGroupDetail(userSelectedCompanyList, companyGroupId,companyGroupName);
				}

				isAdded = true;

			} else {
				int rowCount  = jdbcTemplate.queryForObject(CompanyGroupQueryUtil.sCheckCompanyGroupName, new Object[] { companyGroupName },Integer.class);

			//	int rowCount = jdbcTemplate.queryForInt(CompanyGroupQueryUtil.sCheckCompanyGroupName, new Object[] { companyGroupName });

				if (rowCount > 0) {
					isAdded = false;
					throw new CustomException(CompanyGroupMsgUtil.ALREADY_EXIST);
				}

				int groupId = insertEmployee(companyGroupName);

				if (companydetailList.size() > 0) {

					saveCompanyGroupDetail(userSelectedCompanyList, groupId,companyGroupName);
				}
				isAdded = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCompanyDetails", e);
			throw new CustomException(CompanyGroupMsgUtil.ERROR_ADD);
		}
		return isAdded;

	}

	public int insertEmployee(final String companyGroupName) {
		
		int groupId;
		CompanyGroupBean bean = new CompanyGroupBean();
		bean.setGroupname(companyGroupName);
		final String INSERT_SQL = "INSERT INTO COMPANY_GROUP_MASTER (COMPANY_GROUP_NAME)VALUES(?)";
		groupId  = jdbcTemplate.queryForObject(CompanyGroupQueryUtil.sAddCompanyGroupdetails, new Object[] { companyGroupName },Integer.class);

	//	groupId = jdbcTemplate.queryForInt(CompanyGroupQueryUtil.sAddCompanyGroupdetails, new Object[] { companyGroupName });
		
		/*KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "COMPANY_GROUP_ID" });
				ps.setString(1, companyGroupName);
				return ps;
			}
		}, keyHolder);*/

		return groupId;
	}

	private boolean saveCompanyGroupDetail(ArrayList userSelectedCompany, int companyGroupId,String companyGroupName) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean flag = false;
		Integer groupId = companyGroupId;
		try {
			jdbcTemplate.update(CompanyGroupQueryUtil.deleteCompanyGroupDetailTable, new Object[] { companyGroupId });
			CompanyGroupBean bean = new CompanyGroupBean();
			bean.setGroupname(companyGroupName);
			for (int i = 0; i < userSelectedCompany.size(); i++) {

				ArrayList GetList = ((ArrayList) userSelectedCompany.get(i));

				for (int j = 0; j < GetList.size(); j++) {
					
					String companyCode = (String) GetList.get(j);
					bean.setGroupname(companyGroupName);
					bean.setCompanycode(companyCode);
					jdbcTemplate.update(CompanyGroupQueryUtil.sAddCompanyGroupDetailTable, new Object[] { companyGroupId, companyCode });
					UserLog userLog = userlogDao.userLogForInsert(bean, groupId.toString(), userDetails.getUserId());
					auditLogDao.auditLogForInsert(bean, userLog, null);
				}

			}
			flag = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Detail Records!", e);
		}
		return flag;
	}

	// Populate checkbox list
	@Override
	public List<CompanyGroupBean> getCompanyDetailsList() {

		List<CompanyGroupBean> lCompanyDetailsBean = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CompanyGroupQueryUtil.sViewCompanyDetails);
			for (Map row : rows) {
				CompanyGroupBean objCompanyDetailsBean = new CompanyGroupBean();
				objCompanyDetailsBean.setCompanycode((String) row.get("companycode"));
				objCompanyDetailsBean.setCompanyname((String) row.get("companyname"));

				lCompanyDetailsBean.add(objCompanyDetailsBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
			// throw new CustomException(CompanyDetailsMsgUtil.ERROR_ADD);
		}
		return lCompanyDetailsBean;
	}

	// Populate main table list
	@Override
	public List<CompanyGroupBean> getCompanyGroupTableList() {

		List<CompanyGroupBean> lCompanyDetailsBean = new ArrayList<>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CompanyGroupQueryUtil.sViewCompanyGroupTableList_NEW,new Object[] { userDetails.getUserId() });
			for (Map row : rows) {
				CompanyGroupBean objCompanyGroupBean = new CompanyGroupBean();
				objCompanyGroupBean.setGroupid(Integer.parseInt(row.get("COMPANY_GROUP_ID").toString()));
				objCompanyGroupBean.setGroupname((String) row.get("COMPANY_GROUP_NAME"));
				objCompanyGroupBean.setId((row.get("COMPANY_GROUP_ID").toString()));
				objCompanyGroupBean.setText((String) row.get("COMPANY_GROUP_NAME"));



				lCompanyDetailsBean.add(objCompanyGroupBean);
			}

		}  catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
			// throw new CustomException(CompanyDetailsMsgUtil.ERROR_ADD);
		}
		return lCompanyDetailsBean;
	}

	// get edit row details
	@Override
	public List<CompanyGroupBean> CompanyGroupEditDetList(Integer groupId) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<CompanyGroupBean> lCompanyDetailsBean = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CompanyGroupQueryUtil.sGetCompanyFromGroup,
					new Object[] { userDetails.getUserId(),groupId });
			for (Map row : rows) {
				CompanyGroupBean objCompanyGroupBean = new CompanyGroupBean();
				objCompanyGroupBean.setCompanycode((String) row.get("COMPANY_CODE"));
				objCompanyGroupBean.setId((String)row.get("COMPANY_CODE"));
				objCompanyGroupBean.setText((String)row.get("text"));
				
				

				lCompanyDetailsBean.add(objCompanyGroupBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
			// throw new CustomException(CompanyDetailsMsgUtil.ERROR_ADD);
		}
		return lCompanyDetailsBean;
	}

	// Company Delete
	@Override
	public boolean deleteCompanyDetail(int groupId) throws CustomException {
		int val = 1;
		Integer groupId1 = groupId;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isDeleted = false;
		List<CompanyGroupBean> oldDetail = CompanyGroupEditDetList(groupId);
		CompanyGroupBean bean = new CompanyGroupBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String groupName = "";
			jdbcTemplate.update(CompanyGroupQueryUtil.deleteCompanyGroupDetailTable, new Object[] { groupId });
			groupName = jdbcTemplate.queryForObject(CompanyGroupQueryUtil.SELECT_GROUP_NAME,new Object[] { groupId }, String.class);
			val = jdbcTemplate.update(CompanyGroupQueryUtil.sDeleteCompanyGroupDetail, groupId);
			for(CompanyGroupBean list : oldDetail){
				list.setGroupname(groupName);
				UserLog userLog = userlogDao.userLogForDelete(list, groupId1.toString(), userDetails.getUserId());
				auditLogDao.auditLogForDelete(list, userLog, null);
			}
			isDeleted = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteCompanyDetail", e);
			throw new CustomException(CompanyGroupMsgUtil.ERROR_DELETE);
		}

		return isDeleted;
	}

	// Company Multidelete
	@Override
	public boolean multideleteCompanyDetail(String companycode) throws CustomException {
		int val = 1;

		boolean isDeleted = false;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			val = jdbcTemplate.update(CompanyGroupQueryUtil.sDeleteCompanyDetail, companycode);
			isDeleted = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in multideleteCompanyDetail", e);
			throw new CustomException(CompanyGroupMsgUtil.ERROR_DELETE);
		}
		return isDeleted;
	}

	// CompanyName Check
	@Override
	public boolean companyGroupNameCheck(String companyGroupName) throws CustomException {

		boolean isDuplicate = false;
		String GroupName = companyGroupName.trim().toUpperCase();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			int rowCount = jdbcTemplate.queryForObject(CompanyGroupQueryUtil.sCheckCompanyGroupName, new Object[] { GroupName },Integer.class);
			if (rowCount > 0) {
				isDuplicate = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteCompanyDetail", e);
			throw new CustomException(CompanyGroupMsgUtil.ERROR_DELETE);
		}

		return isDuplicate;
	}
	
	@Override
	public List<CompanyGroupBean> getCompanyList() throws CustomException {
		try {

			List<CompanyGroupBean> companyList = jdbcTemplate.query(CompanyGroupQueryUtil.sCompanyDropDown, new BeanPropertyRowMapper<>(CompanyGroupBean.class));
			return companyList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
			throw new CustomException("Error in Get company List");
		}

	}
}
