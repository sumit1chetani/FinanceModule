package com.dci.tenant.finance.accounthead;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.master.attributes.AttributeBean;

@Repository
public class AccountHeadMasterDAOImpl implements AccountHeadMasterDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(AccountHeadMasterDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@SuppressWarnings("deprecation")
	@Override
	public boolean addAcctHeadMaster(AccountHeadMasterBean objSubGroupAccountBean, String userId) throws CustomException {
		int val = 1;
		boolean isSuccess = false;
		String acctHeadStatus = "";
		try {

			String subGroupCode = objSubGroupAccountBean.getSubGroupAccountCode();

			String acctHeadCode = "" + subGroupCode + "0001";
			String acctHeadCodeLike = "" + subGroupCode + "%";
			String AcctHeadCode = jdbcTemplate.queryForObject(AccountHeadMasterQueryUtil.AUTOGENERATE_OF_ACCT_HEAD_CODE_WITHOUT_ZERO, new Object[] { acctHeadCode, acctHeadCodeLike }, String.class);
			String AcctHeadName = objSubGroupAccountBean.getAccountHeadName().toUpperCase();
			String desc = objSubGroupAccountBean.getDescription();
			String type = objSubGroupAccountBean.getType();
			String financialYearId = "";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(AccountHeadMasterQueryUtil.GET_FINANCIAL_YEAR_ID);
			for (Map row : rows) {
				financialYearId = (String) row.get("financial_year_id");
			}
			String currencyCode = objSubGroupAccountBean.getCurrencyCode();
			String isActive = objSubGroupAccountBean.getAcctHeadStatus();
			if (isActive == "true") {
				acctHeadStatus = "Y";
			} else {
				acctHeadStatus = "N";
			}
			Calendar calendar = Calendar.getInstance();
			java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());

			val = jdbcTemplate.update(AccountHeadMasterQueryUtil.sInsertSubGroup, new Object[] { AcctHeadCode, subGroupCode, AcctHeadName.toUpperCase(), desc, type, userId, currencyCode, financialYearId, acctHeadStatus });

			if (val > 0) {
				for (String sAttributeName : objSubGroupAccountBean.getlAttributes()) {
					val = jdbcTemplate.update(AccountHeadMasterQueryUtil.sInsertAccountAttributeMapping, new Object[] { AcctHeadCode, sAttributeName });
				}
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Account Code", e);

		}
		return isSuccess;
	}

	private String getFinancialYearId() {

		String sFinYearId = "";
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(AccountHeadMasterQueryUtil.GET_FIN_YEAR_ID);
			for (Map row : rows) {
				sFinYearId = (String) row.get("FIN_YEAR_ID");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Financial Year Id", e);
		}
		return sFinYearId;
	}

	@Override
	public AccountHeadMasterBean getAccountHeadValues(String iAccountCode) throws CustomException {
		AccountHeadMasterBean objBean = new AccountHeadMasterBean();
		String isActive = "";
		try {
			Object[] params = new Object[] { iAccountCode };
			objBean = jdbcTemplate.queryForObject(AccountHeadMasterQueryUtil.sEditAccHeadValues, params, new BeanPropertyRowMapper<>(AccountHeadMasterBean.class));
			if (objBean.getAcctHeadStatus().equalsIgnoreCase("Y")) {
				isActive = "true";
			} else if (objBean.getAcctHeadStatus().equalsIgnoreCase("N")) {
				isActive = "false";
			} else {
				isActive = "false";
			}
			objBean.setAcctHeadStatus(isActive);

			objBean.setEdit(true);
			List<String> lAttributes = new ArrayList<>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(AccountHeadMasterQueryUtil.GETACCOUNTATTRIBUTEMAPPING, new Object[] { iAccountCode });
			for (Map<String, Object> eachrow : rows) {
				lAttributes.add(eachrow.get("attributeName").toString());
			}

			objBean.setlAttributes(lAttributes);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
		}
		return objBean;
	}

	@Override
	public boolean updateAcctHeadMaster(AccountHeadMasterBean objAccountHeadMasterBean) throws CustomException {

		boolean issucces = false;
		int value = 1;
		int value1 = 1;

		String acctHeadStatus = "", sAccountHeadCode = "";
		try {
			sAccountHeadCode = objAccountHeadMasterBean.getAccountHeadCode();
			String isActive = objAccountHeadMasterBean.getAcctHeadStatus();
			if (isActive == "true") {
				acctHeadStatus = "Y";
			} else {
				acctHeadStatus = "N";
			}

			Object[] params = new Object[] { objAccountHeadMasterBean.getAccountHeadName(), objAccountHeadMasterBean.getDescription(), objAccountHeadMasterBean.getType(), objAccountHeadMasterBean.getCurrencyCode(), acctHeadStatus, objAccountHeadMasterBean.getSubGroupAccountCode(), sAccountHeadCode };
			value1 = jdbcTemplate.update(AccountHeadMasterQueryUtil.sUpdateSubGroup, params);
			value = jdbcTemplate.update(AccountHeadMasterQueryUtil.sDeleteAccountAttributeMapping, new Object[] { objAccountHeadMasterBean.getAccountHeadCode() });
			for (String sAttributeName : objAccountHeadMasterBean.getlAttributes()) {
				value = jdbcTemplate.update(AccountHeadMasterQueryUtil.sInsertAccountAttributeMapping, new Object[] { objAccountHeadMasterBean.getAccountHeadCode(), sAttributeName });
			}
			if (value1 != 0) {
				issucces = true;
			}
		}

		catch (Exception ae) {
			LOGGER.error("Error in addCodeStandard", ae);
		}
		return issucces;
	}

	@Override
	public List<AccountHeadMasterBean> getAcctHeadMasterList(int limit, int offset) throws CustomException {
		try {
			List<AccountHeadMasterBean> lSubGroupAccountBeanBean = jdbcTemplate.query(AccountHeadMasterQueryUtil.sAccountHeadList, new BeanPropertyRowMapper<>(AccountHeadMasterBean.class));
			return lSubGroupAccountBeanBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException("");
		}

	}

	@Override
	public AccountHeadMasterResultBean getSubGroupHead() {
		AccountHeadMasterResultBean resultBean = new AccountHeadMasterResultBean();
		List<AccountHeadMasterBean> subGroupHeadList = new ArrayList<>();
		try {
			subGroupHeadList = jdbcTemplate.query(AccountHeadMasterQueryUtil.sGroupHeadDropDown, new BeanPropertyRowMapper<>(AccountHeadMasterBean.class));
			resultBean.setSubGroupHeadList(subGroupHeadList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}

	@Override
	public boolean deleteAcctHeadMaster(String subGrpAcctCode) throws CustomException {

		boolean issucces = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(AccountHeadMasterQueryUtil.sDeleteAccount, subGrpAcctCode);

			if (value != 0) {
				issucces = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
			throw new CustomException("");
		}
		return issucces;
	}

	@Override
	public List<AttributeBean> getAttributeList() {
		List<AttributeBean> lAttributeList = new ArrayList<>();
		try {
			lAttributeList = jdbcTemplate.query(AccountHeadMasterQueryUtil.sAttributeList, new BeanPropertyRowMapper<>(AttributeBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
		}
		return lAttributeList;
	}

	@Override
	public AccountHeadMasterResultBean getCurrencyList() {
		AccountHeadMasterResultBean resultBean = new AccountHeadMasterResultBean();
		List<AccountHeadMasterBean> currencyList = new ArrayList<>();
		try {
			currencyList = jdbcTemplate.query(AccountHeadMasterQueryUtil.sCurrencyDropDown, new BeanPropertyRowMapper<>(AccountHeadMasterBean.class));
			resultBean.setCurrencyList(currencyList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}

	@Override
	public List<String> getSGAttributeList(String sSubGroupCode) {
		List<String> lAttributeList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(AccountHeadMasterQueryUtil.sGetSGAccountAttributeMapping, new Object[] { sSubGroupCode });
			for (Map<String, Object> eachrow : rows) {
				lAttributeList.add(eachrow.get("attributeName").toString());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
		}
		return lAttributeList;
	}

	@Override
	public AccountHeadMasterResultBean getvalidate(String accountHeadName, boolean edit, String accountHeadCode) {
		AccountHeadMasterResultBean resultBean = new AccountHeadMasterResultBean();
		List<AccountHeadMasterBean> acctHeadlist = new ArrayList<>();
		try {
			String Str = "";
			if (edit == true) {

				acctHeadlist = jdbcTemplate.query(AccountHeadMasterQueryUtil.validatehead, new BeanPropertyRowMapper<>(AccountHeadMasterBean.class));

				for (AccountHeadMasterBean bean : acctHeadlist) {
					if (accountHeadName.equals(bean.getAccountHeadName())) {
						Str = "success";
					}
				}
				if (Str.equals("success")) {
					int count = jdbcTemplate.queryForObject(AccountHeadMasterQueryUtil.count, new Object[] { accountHeadName, accountHeadCode }, Integer.class);
					if (count > 0) {
						resultBean.setMessage("success");

					}
				}

			} else {
				acctHeadlist = jdbcTemplate.query(AccountHeadMasterQueryUtil.validatehead, new BeanPropertyRowMapper<>(AccountHeadMasterBean.class));

				for (AccountHeadMasterBean bean : acctHeadlist) {
					if (accountHeadName.toUpperCase().trim().equals(bean.getAccountHeadName().trim().toUpperCase())) {
						resultBean.setMessage("success");
					}
				}
			}
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}

	@Override
	public List<AccountHeadMasterBean> searchportDtl(AccountHeadMasterBean objPendingapprovalBean) throws Exception {
		List<AccountHeadMasterBean> searchList = new ArrayList<>();
		String whereCond = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			// searchList = jdbcTemplate.query(TdsReportQueryUtil.list +
			// whereCond + "", new
			// BeanPropertyRowMapper<>(TdsReportBean.class));

			searchList = jdbcTemplate.query(AccountHeadMasterQueryUtil.ACCONUTLISTEXCEL, new BeanPropertyRowMapper<>(AccountHeadMasterBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchList;
	}

}
