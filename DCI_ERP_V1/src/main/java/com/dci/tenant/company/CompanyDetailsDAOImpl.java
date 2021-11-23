package com.dci.tenant.company;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
@Transactional("tenantTransactionManager")

public class CompanyDetailsDAOImpl implements CompanyDetailsDAO {

	private final static Logger LOGGER = Logger.getLogger(CompanyDetailsDAOImpl.class);

	@Autowired
	DataSource dataSource;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@SuppressWarnings("deprecation")
	// Company Add
	@Override
	public boolean addCompanyDetails(List<CompanyDetailsBean> objCompanyDetailsBean, String userId) throws CustomException {
		boolean isAdded = false;
		String companyCode = "";
		try {
			for (int i = 0; i < objCompanyDetailsBean.size(); i++) {
				String companyname = (objCompanyDetailsBean.get(i)).getCompanyname().trim().toUpperCase();
				String shortName = (objCompanyDetailsBean.get(i)).getShortName().trim().toUpperCase();
				String location = (objCompanyDetailsBean.get(i)).getLocation().trim().toUpperCase();
				String address = (objCompanyDetailsBean.get(i)).getAddress().trim().toUpperCase();
				String phoneno = (objCompanyDetailsBean.get(i)).getPhoneno().trim().toUpperCase();
				String faxno = (objCompanyDetailsBean.get(i)).getFaxno().trim().toUpperCase();
				String email = (objCompanyDetailsBean.get(i)).getEmail().trim().toUpperCase();
				String personincharge = (objCompanyDetailsBean.get(i)).getPersonincharge().trim().toUpperCase();
				String relationship = (objCompanyDetailsBean.get(i)).getRelationship().trim().toUpperCase();
				String intercompgroup = (objCompanyDetailsBean.get(i)).getIntercompgroup().trim().toUpperCase();
				NamedParameterJdbcTemplate namedjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				companyCode = jdbcTemplate.queryForObject(CompanyDetailsQueryUtil.SELEECT_COMPANY_CODE, String.class);
				Map parameters = new HashMap();
				parameters.put("companyname", companyname);
				parameters.put("shortName", shortName);
				parameters.put("location", location);
				parameters.put("companyCode", companyCode);
				parameters.put("address", address);
				parameters.put("phoneno", phoneno);
				parameters.put("faxno", faxno);
				parameters.put("email", email);
				parameters.put("personincharge", personincharge);
				parameters.put("relationship", relationship);
				parameters.put("intercompgroup", intercompgroup);
				parameters.put("userid", userId);
				parameters.put("currencyCode", objCompanyDetailsBean.get(i).getCurrencyCode());
				parameters.put("isOperation", objCompanyDetailsBean.get(i).getIsOperation());
				jdbcTemplate.queryForObject(CompanyDetailsQueryUtil.sCheckCompanyName, new Object[] { companyname },Integer.class);
				
			namedjdbcTemplate.update(CompanyDetailsQueryUtil.sAddCompanydetails, parameters);
			//DigitalLibraryUtil.saveMenu(jdbcTemplate, companyname, companyname, "Company");
					isAdded = true;
					UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					UserLog userLog = userlogDao.userLogForInsert(objCompanyDetailsBean.get(i),companyCode , userDetails.getUserId());
				
					
				
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCompanyDetails", e);
			throw new CustomException(CompanyDetailsMsgUtil.ERROR_ADD);
		}
		return isAdded;
	}

	// Populate Grid
	@Override
	public List<CompanyDetailsBean> getCompanyDetailsList(int limit, int offset) throws CustomException {
		List<CompanyDetailsBean> lCompanyDetailsBean = new ArrayList<CompanyDetailsBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CompanyDetailsQueryUtil.sViewCompanyDetails);
			for (Map row : rows) {
				CompanyDetailsBean objCompanyDetailsBean = new CompanyDetailsBean();
				objCompanyDetailsBean.setCompanycode((String) row.get("companycode"));
				objCompanyDetailsBean.setCompanyname((String) row.get("companyname"));
				objCompanyDetailsBean.setLocation((String) row.get("location"));
				objCompanyDetailsBean.setAddress((String) row.get("address"));
				objCompanyDetailsBean.setPhoneno((String) row.get("phoneno"));
				objCompanyDetailsBean.setFaxno((String) row.get("faxno"));
				objCompanyDetailsBean.setEmail((String) row.get("email"));
				objCompanyDetailsBean.setPersonincharge((String) row.get("personincharge"));
				objCompanyDetailsBean.setRelationship((String) row.get("relationship"));
				objCompanyDetailsBean.setIntercompgroup((String) row.get("intercompgroup"));
				lCompanyDetailsBean.add(objCompanyDetailsBean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompanyDetailsList", e);
			throw new CustomException(CompanyDetailsMsgUtil.ERROR_GET);
		}
		return lCompanyDetailsBean;
	}

	// Company Edit
	@Override
	public CompanyDetailsBean editCompanyDetails(String companycode) throws CustomException {
		CompanyDetailsBean objCompanyDetailsBean = new CompanyDetailsBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { companycode };
			Map row = jdbcTemplate.queryForMap(CompanyDetailsQueryUtil.sEditCompanyDetails, params, types);
			objCompanyDetailsBean.setCompanyname((String) row.get("companyname"));
			objCompanyDetailsBean.setShortName((String) row.get("shortName"));
			objCompanyDetailsBean.setLocation((String) row.get("location"));
			objCompanyDetailsBean.setCompanycode((String) row.get("companycode"));
			objCompanyDetailsBean.setAddress((String) row.get("address"));
			objCompanyDetailsBean.setPhoneno((String) row.get("phoneno"));
			objCompanyDetailsBean.setFaxno((String) row.get("faxno"));
			objCompanyDetailsBean.setEmail((String) row.get("email"));
			objCompanyDetailsBean.setPersonincharge((String) row.get("personincharge"));
			objCompanyDetailsBean.setRelationship((String) row.get("relationship"));
			objCompanyDetailsBean.setIntercompgroup((String) row.get("intercompgroup"));
			objCompanyDetailsBean.setCurrencyCode((String) row.get("currencyCode"));
			objCompanyDetailsBean.setIsOperation((String) row.get("isOperation"));

			objCompanyDetailsBean.setEdit(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in editCompanyDetails", e);
			throw new CustomException(CompanyDetailsMsgUtil.ERROR_EDIT);
		}
		return objCompanyDetailsBean;
	}

	// Company Delete
	@Override
	public boolean deleteCompanyDetail(String companycode) throws CustomException {
		int val = 1;
		boolean isDeleted = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			CompanyDetailsBean objCompanyDetailsBean = editCompanyDetails(companycode);

			val = jdbcTemplate.update(CompanyDetailsQueryUtil.sDeleteCompanyDetail, companycode);
			System.out.println("val*********************************************" + val);
			isDeleted = true;
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserLog userLog = userlogDao.userLogForDelete(objCompanyDetailsBean, companycode, userDetails.getUserId());
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteCompanyDetail", e);
			throw new CustomException(CompanyDetailsMsgUtil.ERROR_DELETE);
		}
		System.out.println("isDeleted*********************************************" + isDeleted);
		return isDeleted;
	}

	// Company Update
	@Override
	public boolean updateCompanyDetail(CompanyDetailsBean objCompanyDetailsBean, String userId) throws CustomException {
		boolean isAdded = false;
		int i = 1;
		int j = 1;
		try {
			String companycode = objCompanyDetailsBean.getCompanycode().trim().toUpperCase();
			String companyname = objCompanyDetailsBean.getCompanyname().trim().toUpperCase();
			String shortName = objCompanyDetailsBean.getShortName().trim().toUpperCase();
			String location = objCompanyDetailsBean.getLocation().trim().toUpperCase();
			String address = objCompanyDetailsBean.getAddress().trim().toUpperCase();
			String phoneno = objCompanyDetailsBean.getPhoneno().trim().toUpperCase();
			String faxno = objCompanyDetailsBean.getFaxno().trim().toUpperCase();
			String email = objCompanyDetailsBean.getEmail().trim().toUpperCase();
			String personincharge = objCompanyDetailsBean.getPersonincharge().trim().toUpperCase();
			String relationship = objCompanyDetailsBean.getRelationship().trim().toUpperCase();
			String intercompgroup = objCompanyDetailsBean.getIntercompgroup().trim().toUpperCase();
			NamedParameterJdbcTemplate namedjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Map parameters = new HashMap();
			parameters.put("companycode", companycode);
			parameters.put("companyname", companyname);
			parameters.put("shortName", shortName);
			parameters.put("location", location);
			parameters.put("address", address);
			parameters.put("phoneno", phoneno);
			parameters.put("faxno", faxno);
			parameters.put("email", email);
			parameters.put("personincharge", personincharge);
			parameters.put("relationship", relationship);
			parameters.put("intercompgroup", intercompgroup);
			parameters.put("userid", userId);
			parameters.put("currencyCode", objCompanyDetailsBean.getCurrencyCode());
			parameters.put("isOperation", objCompanyDetailsBean.getIsOperation());
			CompanyDetailsBean objCompanyDetailsBeanOld = editCompanyDetails(companycode);

			i = jdbcTemplate.queryForObject(CompanyDetailsQueryUtil.sCheckUpdateCompanyName, new Object[] { companycode, companyname },Integer.class);
			if (i == 0) {
				namedjdbcTemplate.update(CompanyDetailsQueryUtil.sUpdateCompanyDetail, parameters);
			//	DigitalLibraryUtil.updateMenu(jdbcTemplate, companycode, companyname, "Company");
				isAdded = true;
				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				UserLog userLog = userlogDao.userLogForUpdate(objCompanyDetailsBeanOld, objCompanyDetailsBean, objCompanyDetailsBean.getCompanycode(), userDetails.getUserId());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in updateCompanyDetail", e);
			throw new CustomException(CompanyDetailsMsgUtil.ERROR_UPDATE);
		}
		return isAdded;
	}

	// CompanyName Check
	@Override
	public boolean CompanyNameCheck(String companyname) throws CustomException {
		boolean isDuplicate = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String scompanyname = companyname;
			companyname = scompanyname.toUpperCase();
			int i = jdbcTemplate.queryForObject(CompanyDetailsQueryUtil.sCheckCompanyName, new Object[] { companyname },Integer.class);
			if (i == 1) {
				isDuplicate = true;
			} else {
				isDuplicate = false;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in CompanyNameCheck", e);
			throw new CustomException(CompanyDetailsMsgUtil.ERROR_CMPNAMECHECK);
		}
		return isDuplicate;
	}

	// Fetching location dropdown
	@Override
	public List getCompany() {
		List lAssetMasterBean = new ArrayList();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CompanyDetailsQueryUtil.sCompandLoc);
			for (Map row : rows) {
				CompanyDetailsBean bean = new CompanyDetailsBean();
				bean.setCompanyname((String) row.get("companyname"));
				bean.setLocation((String) row.get("location"));
				lAssetMasterBean.add(bean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getCompany", e);
		}
		return lAssetMasterBean;
	}

	@Override
	public List getCurrencyList() {
		List<SelectivityBean> lCurrencyList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCurrencyList = jdbcTemplate.query(CompanyDetailsQueryUtil.sGetCurrencyList, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Currency LIST", e);
		}
		return lCurrencyList;
	}
}
