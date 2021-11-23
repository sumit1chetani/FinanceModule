package com.dci.tenant.finance.bankcompany;

import java.sql.Types;
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

@Repository
public class BankcompanyDAOImpl implements BankcompanyDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(BankcompanyDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;

	@SuppressWarnings("deprecation")
	@Override
	public boolean addAcctHeadMastercom(BankcompanyBean objBankcompanyBean, String userId) throws CustomException {
		int val = 1;
		boolean isSuccess = false;
		String acctHeadStatus = "";
		String cashbankpayment = "";
		try {

			String subGroupCode = objBankcompanyBean.getSubGroupAccountCode();

			String Bankcode = "";

			Bankcode = jdbcTemplate.queryForObject(BankcompanyQueryUil.GENERATE_CODE, new Object[] { "B", "B" }, String.class);
			Bankcode = "B" + Bankcode;
			String AcctHeadName = objBankcompanyBean.getAccountHeadName();
			String acctname = objBankcompanyBean.getAccountName();
			String desc = objBankcompanyBean.getDescription();
			String type = objBankcompanyBean.getType();
			String financialYearId = "1";
			String currencyCode = objBankcompanyBean.getCurrencyCode();
			String companyName = objBankcompanyBean.getCompanyName();
			String companyCode = objBankcompanyBean.getCompanyCode();
			String bankacctname = objBankcompanyBean.getBankacctname();
			String branch = objBankcompanyBean.getBranch();
			String bankshort = objBankcompanyBean.getBankshort();
			String paymentype = objBankcompanyBean.getPaymentType();

			String isActive = objBankcompanyBean.getAcctHeadStatus();
			if (isActive.equalsIgnoreCase("Y")) {
				acctHeadStatus = "Y";
			} else {
				acctHeadStatus = "N";
			}

			String cashbankPay = objBankcompanyBean.getCashbankPayment();
			if (cashbankPay.equalsIgnoreCase("Y")) {
				cashbankpayment = "Y";
			} else {
				cashbankpayment = "N";
			}
			Calendar calendar = Calendar.getInstance();
			java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());

			val = jdbcTemplate.update(BankcompanyQueryUil.sInsertSubGroup, new Object[] { Bankcode, companyName, acctname, AcctHeadName, branch, bankshort, cashbankpayment, paymentype, acctHeadStatus });
			/*
			 * if (val > 0) { for (String sAttributeName :
			 * objBankcompanyBean.getlAttributes()) { val =
			 * jdbcTemplate.update(BankcompanyQueryUil
			 * .sInsertAccountAttributeMapping, new Object[] { companyCode,
			 * bankacctname }); } isSuccess = true; }
			 */
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Account Code", e);

		}
		return isSuccess;
	}

	@Override
	public List<BankcompanyBean> getAcctHeadMasterList(int limit, int offset) throws CustomException {
		try {
			List<BankcompanyBean> lSubGroupAccountBeanBean = jdbcTemplate.query(BankcompanyQueryUil.sAccountHeadList, new BeanPropertyRowMapper<>(BankcompanyBean.class));
			return lSubGroupAccountBeanBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException("");
		}

	}

	// edit

	@Override
	public BankcompanyBean getBankcompanyValues(String bankCode) throws CustomException {
		BankcompanyBean objBean = new BankcompanyBean();
		// String formDesc = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { bankCode };
			Map row = jdbcTemplate.queryForMap(BankcompanyQueryUil.Editbankcompanyvalues, params, types);
			objBean.setCompanyCode((String) row.get("companyCode"));
			objBean.setBranch((String) row.get("branch"));
			objBean.setAccountName((String) row.get("accountName"));
			objBean.setCompanyName((String) row.get("companyName"));
			objBean.setBankCode((String) row.get("bankCode"));
			objBean.setAccountHeadCode((String) row.get("accountHeadCode"));
			objBean.setAccountHeadName((String) row.get("accountHeadName"));
			objBean.setAcctdesc((String) row.get("acctdesc"));
			objBean.setBankshort((String) row.get("bankshort"));

			objBean.setAcctHeadStatus((String) row.get("isActive"));
			// objBean.setIsActive((String) row.get("isActive"));
			objBean.setCashbankPayment((String) row.get("cashbankPayment"));
			objBean.setPaymentType((String) row.get("paymentType"));

			// objBean.setIsEdit(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
			throw new CustomException("");
		}
		return objBean;
	}

	@Override
	public boolean deleteVendor(String bankCode) throws CustomException {
		boolean issucces = false;
		int value = 0;
		String getDeptIdAutoIncrement = "";

		try {
			// BankcompanyBean VendorBean = getVendorEdit(bankCode);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			value = jdbcTemplate.update(BankcompanyQueryUil.delete, bankCode);
			issucces = true;
			/*
			 * objDepartmentBean.setDeptCode(getDeptIdAutoIncrement); if (value
			 * != 0) { issucces = true;
			 * objDepartmentBean.setTableName("department_master");
			 * objDepartmentBean.setFormCode("F5118"); UserDetail userDetails =
			 * (UserDetail)
			 * SecurityContextHolder.getContext().getAuthentication(
			 * ).getPrincipal(); UserLog userLog =
			 * userlogDao.userLogForDelete(objDepartmentBean,dCode,
			 * userDetails.getUserId());
			 * //auditLogDao.auditLogForDelete(objDepartmentBean, userLog,
			 * null); }
			 */

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
			// throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return issucces;
	}

	@Override
	public boolean updateAcctHeadMaster(BankcompanyBean objBankcompanyBean) throws CustomException {

		boolean issucces = false;
		int value = 1;
		int value1 = 1;
		String cashbankpayment = "";

		String acctHeadStatus = "", bankcode = "";
		try {
			bankcode = objBankcompanyBean.getBankCode();

			String isActive = objBankcompanyBean.getAcctHeadStatus();
			if (isActive.equalsIgnoreCase("Y")) {
				acctHeadStatus = "Y";
			} else {
				acctHeadStatus = "N";
			}

			String cashbankPay = objBankcompanyBean.getCashbankPayment();
			if (cashbankPay.equalsIgnoreCase("Y")) {
				cashbankpayment = "Y";
			} else {
				cashbankpayment = "N";
			}

			Object[] params = new Object[] { objBankcompanyBean.getCompanyName(), objBankcompanyBean.getAccountName(), objBankcompanyBean.getAccountHeadName(), objBankcompanyBean.getBranch(), objBankcompanyBean.getBankshort(), cashbankpayment, acctHeadStatus, objBankcompanyBean.getPaymentType(), bankcode };
			value1 = jdbcTemplate.update(BankcompanyQueryUil.sUpdateSubGroup, params);
			/*
			 * value = jdbcTemplate.update(AccountHeadMasterQueryUtil.
			 * sDeleteAccountAttributeMapping, new Object[] {
			 * objAccountHeadMasterBean.getAccountHeadCode() }); for (String
			 * sAttributeName : objAccountHeadMasterBean.getlAttributes()) {
			 * value = jdbcTemplate.update(AccountHeadMasterQueryUtil.
			 * sInsertAccountAttributeMapping, new Object[] {
			 * objAccountHeadMasterBean.getAccountHeadCode(), sAttributeName });
			 * }
			 */
			if (value1 != 0) {
				issucces = true;
			}
		}

		catch (Exception ae) {
			LOGGER.error("Error in addCodeStandard", ae);
		}
		return issucces;
	}
}
