package com.dci.tenant.finance.paymentreceipt;

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
import com.dci.master.company.CompanyQueryUtil;

@Repository
public class PaymentreceiptDAOImpl implements PaymentreceiptDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(PaymentreceiptDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@SuppressWarnings("deprecation")
	@Override
	public boolean addAcctHeadMaster(PaymentreceiptMasterBean objSubGroupAccountBean, String userId) throws CustomException {
		int val = 1;
		boolean isSuccess = false;
		String acctpayment = "";
		String acctreceipt = "";

		try {

			String subGroupCode = objSubGroupAccountBean.getSubGroupAccountCode();

		/*	String acctHeadCode = "" + subGroupCode + "0001";
			String acctHeadCodeLike = "" + subGroupCode + "%";*/
			//String AcctHeadCode = jdbcTemplate.queryForObject(PaymentreceiptQueryUtil.AUTOGENERATE_OF_ACCT_HEAD_CODE_WITHOUT_ZERO, String.class);
			
			String AcctHeadCode = jdbcTemplate.queryForObject(PaymentreceiptQueryUtil.AUTOGENERATE_OF_ACCT_HEAD_CODE_WITHOUT_ZERO, new Object[] { "PR", "PR" },
					String.class);
			AcctHeadCode = "PR" + AcctHeadCode;
			
			String AcctHeadName = objSubGroupAccountBean.getAccountHeadName().toUpperCase();
			String desc = objSubGroupAccountBean.getDescription();
			String type = objSubGroupAccountBean.getType();
			String financialYearId = "1";
			String currencyCode = objSubGroupAccountBean.getCurrencyCode();
			String ispayment = objSubGroupAccountBean.getIspayment();
			String isreceipt = objSubGroupAccountBean.getIsreceipt();

			/*if (ispayment == "Y") {
				acctpayment = "Y";
			} else {
				acctpayment = "N";
			}
			
			if (isreceipt == "Y") {
				acctreceipt = "Y";
			} else {
				acctreceipt = "N";
			}
			*/
			Calendar calendar = Calendar.getInstance();
			java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());

			val = jdbcTemplate.update(PaymentreceiptQueryUtil.sInsertSubGroup, new Object[] { AcctHeadCode, subGroupCode.toUpperCase().toUpperCase(), desc, userId, ispayment ,isreceipt});

			if (val > 0) {
			/*	for (String sAttributeName : objSubGroupAccountBean.getlAttributes()) {
					val = jdbcTemplate.update(PaymentreceiptQueryUtil.sInsertAccountAttributeMapping, new Object[] { AcctHeadCode, sAttributeName });
				}*/
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
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PaymentreceiptQueryUtil.GET_FIN_YEAR_ID);
			for (Map row : rows) {
				sFinYearId = (String) row.get("FIN_YEAR_ID");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Financial Year Id", e);
		}
		return sFinYearId;
	}

	@Override
	public PaymentreceiptMasterBean getAccountHeadValues(String iAccountCode) throws CustomException {
		PaymentreceiptMasterBean objBean = new PaymentreceiptMasterBean();
		String ispayment = "";
		String isreceipt= "";

		try {
			Object[] params = new Object[] { iAccountCode };
			objBean = jdbcTemplate.queryForObject(PaymentreceiptQueryUtil.sEditAccHeadValues, params, new BeanPropertyRowMapper<>(PaymentreceiptMasterBean.class));
			if (objBean.getIspayment().equalsIgnoreCase("Y")) {
				ispayment = "Y";
			} else if (objBean.getIspayment().equalsIgnoreCase("N")) {
				ispayment = "N";
			} else {
				ispayment = "N";
			}
			if (objBean.getIsreceipt().equalsIgnoreCase("Y")) {
				isreceipt = "Y";
			} else if (objBean.getIsreceipt().equalsIgnoreCase("N")) {
				isreceipt = "N";
			} else {
				isreceipt = "N";
			}
			
			objBean.setIspayment(ispayment);
			objBean.setIsreceipt(isreceipt);

			objBean.setEdit(true);
			/*List<String> lAttributes = new ArrayList<>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PaymentreceiptQueryUtil.GETACCOUNTATTRIBUTEMAPPING, new Object[] { iAccountCode });
			for (Map<String, Object> eachrow : rows) {
				lAttributes.add(eachrow.get("attributeName").toString());
			}

			objBean.setlAttributes(lAttributes);*/

		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
		}
		return objBean;
	}

	@Override
	public boolean updateAcctHeadMaster(PaymentreceiptMasterBean objAccountHeadMasterBean) throws CustomException {

		boolean issucces = false;
		int value = 1;
		int value1 = 1;

		String acctpayment = "", sAccountHeadCode = "";
		 String acctreceipt = "";
		try {
			sAccountHeadCode = objAccountHeadMasterBean.getAccountHeadCode();
			String ispayment = objAccountHeadMasterBean.getIspayment();
			String isreceipt = objAccountHeadMasterBean.getIsreceipt();

		/*	if (ispayment == "Y") {
				acctpayment = "Y";
			} else {
				acctpayment = "N";
			}
			if (isreceipt == "Y") {
				acctreceipt = "Y";
			} else {
				acctreceipt = "N";
			}*/

			Object[] params = new Object[] { objAccountHeadMasterBean.getSubGroupAccountCode(), objAccountHeadMasterBean.getDescription(), ispayment,isreceipt, sAccountHeadCode };
			value1 = jdbcTemplate.update(PaymentreceiptQueryUtil.sUpdateSubGroup, params);
			//value = jdbcTemplate.update(PaymentreceiptQueryUtil.sDeleteAccountAttributeMapping, new Object[] { objAccountHeadMasterBean.getAccountHeadCode() });
			/*for (String sAttributeName : objAccountHeadMasterBean.getlAttributes()) {
				value = jdbcTemplate.update(PaymentreceiptQueryUtil.sInsertAccountAttributeMapping, new Object[] { objAccountHeadMasterBean.getAccountHeadCode(), sAttributeName });
			}
			if (value1 != 0) {
				issucces = true;
			}*/
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
	public List<PaymentreceiptMasterBean> getAcctHeadMasterList(int limit, int offset) throws CustomException {
		try {
			List<PaymentreceiptMasterBean> lSubGroupAccountBeanBean = jdbcTemplate.query(PaymentreceiptQueryUtil.sAccountHeadList, new BeanPropertyRowMapper<>(PaymentreceiptMasterBean.class));
			return lSubGroupAccountBeanBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException("");
		}

	}

	@Override
	public PaymentreceiptResultBean getSubGroupHead() {
		PaymentreceiptResultBean resultBean = new PaymentreceiptResultBean();
		List<PaymentreceiptMasterBean> subGroupHeadList = new ArrayList<>();
		try {
			subGroupHeadList = jdbcTemplate.query(PaymentreceiptQueryUtil.sGroupHeadDropDown, new BeanPropertyRowMapper<>(PaymentreceiptMasterBean.class));
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
			value = jdbcTemplate.update(PaymentreceiptQueryUtil.sDeleteAccount, subGrpAcctCode);

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
			lAttributeList = jdbcTemplate.query(PaymentreceiptQueryUtil.sAttributeList, new BeanPropertyRowMapper<>(AttributeBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
		}
		return lAttributeList;
	}

	@Override
	public PaymentreceiptResultBean getCurrencyList() {
		PaymentreceiptResultBean resultBean = new PaymentreceiptResultBean();
		List<PaymentreceiptMasterBean> currencyList = new ArrayList<>();
		try {
			currencyList = jdbcTemplate.query(PaymentreceiptQueryUtil.sCurrencyDropDown, new BeanPropertyRowMapper<>(PaymentreceiptMasterBean.class));
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
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PaymentreceiptQueryUtil.sGetSGAccountAttributeMapping, new Object[] { sSubGroupCode });
			for (Map<String, Object> eachrow : rows) {
				lAttributeList.add(eachrow.get("attributeName").toString());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
		}
		return lAttributeList;
	}

	@Override
	public PaymentreceiptResultBean getvalidate(String accountHeadName, boolean edit, String accountHeadCode) {
		PaymentreceiptResultBean resultBean = new PaymentreceiptResultBean();
		List<PaymentreceiptMasterBean> acctHeadlist = new ArrayList<>();
		try {
			String Str = "";
			if (edit == true) {

				acctHeadlist = jdbcTemplate.query(PaymentreceiptQueryUtil.validatehead, new BeanPropertyRowMapper<>(PaymentreceiptMasterBean.class));

				for (PaymentreceiptMasterBean bean : acctHeadlist) {
					if (accountHeadName.equals(bean.getAccountHeadName())) {
						Str = "success";
					}
				}
				if (Str.equals("success")) {
					int count = jdbcTemplate.queryForObject(PaymentreceiptQueryUtil.count, new Object[] { accountHeadName, accountHeadCode }, Integer.class);
					if (count > 0) {
						resultBean.setMessage("success");

					}
				}

			} else {
				acctHeadlist = jdbcTemplate.query(PaymentreceiptQueryUtil.validatehead, new BeanPropertyRowMapper<>(PaymentreceiptMasterBean.class));

				for (PaymentreceiptMasterBean bean : acctHeadlist) {
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
	public List<PaymentreceiptMasterBean> searchportDtl(PaymentreceiptMasterBean objPendingapprovalBean) throws Exception {
		List<PaymentreceiptMasterBean> searchList = new ArrayList<>();
		String whereCond = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			// searchList = jdbcTemplate.query(TdsReportQueryUtil.list +
			// whereCond + "", new
			// BeanPropertyRowMapper<>(TdsReportBean.class));

			searchList = jdbcTemplate.query(PaymentreceiptQueryUtil.ACCONUTLISTEXCEL, new BeanPropertyRowMapper<>(PaymentreceiptMasterBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchList;
	}

}
