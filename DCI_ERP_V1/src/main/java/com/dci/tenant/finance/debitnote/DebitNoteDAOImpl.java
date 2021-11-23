package com.dci.tenant.finance.debitnote;

import java.sql.Date;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.finance.creditnote.CreditNoteBean;
import com.dci.tenant.finance.creditnote.CreditNoteQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class DebitNoteDAOImpl implements DebitNoteDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(DebitNoteDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@SuppressWarnings("deprecation")
	@Override
	public boolean saveDebitNoteData(DebitNoteBean objDebitNoteBean, String userId, String companyCode) {
		List<DebitNoteBean> alDebitNoteList = new ArrayList<>();
		boolean isSuccess = false;
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);

			String debitNoteNo = generateDebitNoteNumber();

			Date debitNoteDate = CommonUtil.convertSqlDateFormat(objDebitNoteBean.getDebitNoteDate());
			String acctHeadCode = objDebitNoteBean.getAcctHeadName();
			String invoiceNo = objDebitNoteBean.getInvoiceNo();
			String invoiceDt = objDebitNoteBean.getInvoiceDate();
			String currencyCode = objDebitNoteBean.getCurrencyCode();
			double exchangeRate = objDebitNoteBean.getExchangeRate();
			String narration = objDebitNoteBean.getNarration();
			objDebitNoteBean.setDebitNoteNo(debitNoteNo);
			
			
			if(acctHeadCode.substring(0, 1).equalsIgnoreCase("C")) {
				acctHeadCode = "10040001";
			}
			else if(acctHeadCode.substring(0, 1).equalsIgnoreCase("S")) {
				acctHeadCode = "20000001";
	
			}

			int iSave = jdbcTemplate.update(DebitNoteQueryUtil.saveDebitNoteData, new Object[] { debitNoteNo, debitNoteDate, acctHeadCode, currencyCode, exchangeRate, invoiceNo, narration, companyCode, userId });

			if (iSave > 0) {
				isSuccess = saveDebitNoteDetail(objDebitNoteBean, debitNoteNo, jdbcTemplate, currencyCode, exchangeRate);
			}

			if (isSuccess) {
				isSuccess = saveDebitNoteGeneralLedgerDebitEntry(debitNoteNo);// header
				isSuccess = saveDebitNoteGeneralLedgerCreditEntry(debitNoteNo);// detail
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Debit Note Records!", e);
		}

		return isSuccess;
	}

	@SuppressWarnings("rawtypes")
	private boolean saveDebitNoteDetail(DebitNoteBean objDebitNoteBean, String debitNoteNo, JdbcTemplate jdbcTemplate, String currencyCode, double exchangeRate) {
		boolean flag = false;
		try {

			List<DebitNoteDetailBean> drTableData = objDebitNoteBean.getDebittables();
			for (DebitNoteDetailBean objDebitNoteDetailBean : drTableData) {

				int iDNDtl = jdbcTemplate.update(DebitNoteQueryUtil.saveDebitNoteDetailData, new Object[] { objDebitNoteBean.getDebitNoteNo(), objDebitNoteDetailBean.getDrdtlAccountHead(), objDebitNoteDetailBean.getAmount(), objDebitNoteDetailBean.getDtlNarration(), objDebitNoteDetailBean.getAmountUSD(), objDebitNoteBean.getCurrencyCode(), objDebitNoteBean.getExchangeRate(), objDebitNoteDetailBean.getSlNo(), objDebitNoteDetailBean.getSubAcctCode(), objDebitNoteDetailBean.getEmployeeCode(), objDebitNoteDetailBean.getCountryCode(),
						objDebitNoteDetailBean.getCustomerCode(), objDebitNoteDetailBean.getSupplierCode(), objDebitNoteDetailBean.getDesignationCode(), objDebitNoteDetailBean.getCompanyCode(), objDebitNoteDetailBean.getCostCenter(), objDebitNoteDetailBean.getDepartmentCode(), objDebitNoteDetailBean.getPatientCode(),objDebitNoteDetailBean.getCbpdtlpaymentreceipt() });
				if (iDNDtl > 0)
					flag = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in saving Debit Note Detail Records!", e);
		}
		return flag;
	}

	/**
	 * debit note header to general ledger debit entry
	 * 
	 * @param debitNoteNo
	 * @return
	 */
	private boolean saveDebitNoteGeneralLedgerDebitEntry(String debitNoteNo) {
		boolean flag = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			String subGroupCodeForTradeDebtors = "1004";// Trade Debtors
			String subGroupCodeForTradeCreditors = "2000";// Trade Creditors

			int iCrHdr = jdbcTemplate.update(DebitNoteQueryUtil.INSERT_GENERAL_LEDGER_DEBIT_ENTRY_DEBITNOTE, new Object[] { subGroupCodeForTradeDebtors, subGroupCodeForTradeCreditors, userDetails.getUserId(), debitNoteNo });

			if (iCrHdr > 0)
				flag = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update Status of Credit Note Temp Header Records!", e);
		}
		return flag;
	}

	/**
	 * debit note header to general ledger credit entry
	 * 
	 * @param debitNoteNo
	 * @return
	 */
	private boolean saveDebitNoteGeneralLedgerCreditEntry(String debitNoteNo) {
		boolean flag = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {

			int iCrHdr = jdbcTemplate.update(DebitNoteQueryUtil.INSERT_GENERAL_LEDGER_CREDIT_ENTRY_DEBITNOTE, new Object[] { userDetails.getUserId(), debitNoteNo });

			if (iCrHdr > 0)
				flag = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update Status of Credit Note Temp Header Records!", e);
		}
		return flag;
	}

	/**
	 * generate Debit Note Number
	 * 
	 * @return
	 */
	public String generateDebitNoteNumber() {
		String debitNoteNoValue = "";
		String sDNYear = "", sDefaultDNNo = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

			sCurrentYear = sCurrentYear.substring(2);
			sDNYear = "DN" + sCurrentYear + "%";
			sDefaultDNNo = "DN" + sCurrentYear + "00001";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(DebitNoteQueryUtil.autoGenDebitNoteNo, new Object[] { sDefaultDNNo, sDNYear });
			for (Map row : rows) {
				debitNoteNoValue = (String) row.get("DEBITNOTE_NO");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Debit Note Number", e);
		}
		return debitNoteNoValue;

	}

	@Override
	public boolean deleteDebitNote(String debitNoteNo) throws CustomException {
		boolean isSuccess = false;
		int value = 0, valueDtl = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			valueDtl = jdbcTemplate.update(DebitNoteQueryUtil.DELETE_GENERAL_LEDGER, debitNoteNo);
			valueDtl = jdbcTemplate.update(DebitNoteQueryUtil.sDeleteDebitNoteDtl, debitNoteNo);

			value = jdbcTemplate.update(DebitNoteQueryUtil.sDeleteDebitNote, debitNoteNo);

			if (value > 0)
				isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
		}
		return isSuccess;
	}

	/****** New grid List *******/
	@Override
	public List<DebitNoteBean> getDebitNoteList(int limit, int offset) throws CustomException {
		List<DebitNoteBean> alDebitNoteList = new ArrayList<>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		DebitNoteBean bean = null;
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);
			alDebitNoteList = jdbcTemplate.query(DebitNoteQueryUtil.sGetDebitNoteDatas, new BeanPropertyRowMapper<>(DebitNoteBean.class), userDetails.getCompanyCode());
			//alDebitNoteList = jdbcTemplate.query(DebitNoteQueryUtil.sGetDebitNoteDatas, new BeanPropertyRowMapper<>(CreditNoteBean.class), userDetails.getCompanyCode());

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Credit Note List", e);
		}
		return alDebitNoteList;

	}

	@Override
	public DebitNoteBean getDebitNoteForEdit(String debitCode) {
		DebitNoteBean objDebitNoteBean = new DebitNoteBean();
		List<DebitNoteDetailBean> debitNoteDetailList = new ArrayList<>();
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);

			objDebitNoteBean = jdbcTemplate.queryForObject(DebitNoteQueryUtil.GET_DEBIT_HDR_EDIT, new Object[] { debitCode }, new BeanPropertyRowMapper<>(DebitNoteBean.class));
			debitNoteDetailList = jdbcTemplate.query(DebitNoteQueryUtil.GET_DEBIT_DTL_EDIT, new Object[] { debitCode }, new BeanPropertyRowMapper<>(DebitNoteDetailBean.class));

			objDebitNoteBean.setDebittables((ArrayList<DebitNoteDetailBean>) debitNoteDetailList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Debit Note Records!", e);
		}

		return objDebitNoteBean;
	}

	@Override
	public boolean updateDebitAcct(DebitNoteBean objDebitNoteBean, String userId) {
		boolean isSuccess = false;
		int isUpdated = 0;
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);
			isUpdated = jdbcTemplate.update(DebitNoteQueryUtil.UPDATE_DEBIT_HDR, new Object[] { CommonUtil.convertSqlDateFormat(objDebitNoteBean.getDebitNoteDate()), objDebitNoteBean.getAcctHeadName(), objDebitNoteBean.getCurrencyCode(), objDebitNoteBean.getExchangeRate(), objDebitNoteBean.getInvoiceNo(), objDebitNoteBean.getNarration(), objDebitNoteBean.getCompanyCode(), userId, objDebitNoteBean.getDebitNoteNo() });

			if (isUpdated > 0) {
				jdbcTemplate.update(DebitNoteQueryUtil.sDeleteDebitNoteDtl, objDebitNoteBean.getDebitNoteNo());
				isSuccess = updateDebitAcctDetails(objDebitNoteBean);
			}

			if (isSuccess) {
				int iGLDel = jdbcTemplate.update(DebitNoteQueryUtil.DELETE_GENERAL_LEDGER, new Object[] { objDebitNoteBean.getDebitNoteNo() });

				isSuccess = saveDebitNoteGeneralLedgerDebitEntry(objDebitNoteBean.getDebitNoteNo());// header
				isSuccess = saveDebitNoteGeneralLedgerCreditEntry(objDebitNoteBean.getDebitNoteNo());// detail

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Debit Note Records", e);
		}
		return isSuccess;
	}

	private boolean updateDebitAcctDetails(DebitNoteBean objDebitNoteBean) {
		List<DebitNoteDetailBean> alDetailList = objDebitNoteBean.getDebittables();
		boolean flag = false;
		try {
			for (DebitNoteDetailBean objDebitNoteDetailBean : alDetailList) {

				int iDNDtl = jdbcTemplate.update(DebitNoteQueryUtil.saveDebitNoteDetailData, new Object[] { objDebitNoteBean.getDebitNoteNo(), objDebitNoteDetailBean.getDrdtlAccountHead(), objDebitNoteDetailBean.getAmount(), objDebitNoteDetailBean.getDtlNarration(), objDebitNoteDetailBean.getAmountUSD(), objDebitNoteBean.getCurrencyCode(), objDebitNoteBean.getExchangeRate(), objDebitNoteDetailBean.getSlNo(), objDebitNoteDetailBean.getSubAcctCode(), objDebitNoteDetailBean.getEmployeeCode(), objDebitNoteDetailBean.getCountryCode(),
						objDebitNoteDetailBean.getCustomerCode(), objDebitNoteDetailBean.getSupplierCode(), objDebitNoteDetailBean.getDesignationCode(), objDebitNoteDetailBean.getCompanyCode(), objDebitNoteDetailBean.getCostCenter(), objDebitNoteDetailBean.getDepartmentCode(), objDebitNoteDetailBean.getPatientCode() });
				if (iDNDtl > 0)
					flag = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Debit Note Detail Records", e);
		}

		return flag;
	}

	@Override
	public List<SelectivityBean> getDebitNoteCodeList() {
		List<SelectivityBean> list = new ArrayList<>();
		try {
			list = jdbcTemplate.query(DebitNoteQueryUtil.sGetDebitNoteCode, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String reversePayment(String debitCode, String createdDate) {
		String sReceiptStatus = "";
		String sMessage = "";
		try {
			List<Map<String, Object>> RowData = jdbcTemplate.queryForList(DebitNoteQueryUtil.GET_DEBITNOTE_STATUS, new Object[] { debitCode });
			for (Map<String, Object> row : RowData) {
				sReceiptStatus = (String) row.get("reverseDN");
			}

			if ("N".equalsIgnoreCase(sReceiptStatus)) {
				reversePaymentRecord(debitCode, createdDate);
				sMessage = "DebitNote Reversed sucessfully";
			} else {
				sMessage = "DebitNote is already Reversed !..";
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Reverse Payment List", e);
		}
		return sMessage;
	}

	private void reversePaymentRecord(String voucherNo, String createdDate) {
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String reverseBBStatus = "Y";
			jdbcTemplate.update(DebitNoteQueryUtil.UPDATE_DEBIT_HDR_STATUS, new Object[] { reverseBBStatus, voucherNo });

			String pmType = "bank";
			String debitNoteNo = generateDebitNoteNumber();

			int succ = jdbcTemplate.queryForObject(DebitNoteQueryUtil.REVERSE_DEBIT_NOTE, new Object[] { voucherNo, createdDate, userDetails.getUserId(), debitNoteNo }, Integer.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
