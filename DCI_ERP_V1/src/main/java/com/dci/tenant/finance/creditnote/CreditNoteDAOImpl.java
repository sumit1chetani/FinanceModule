package com.dci.tenant.finance.creditnote;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.dci.common.util.CommonUtil;
import com.dci.tenant.user.UserDetail;

/**
 * This class Dispatches the user's action according to the DAO, it perform only
 * get,add,update,delete and so on.
 * 
 * @author raghavan
 * @version 1.0
 * @revision 16-Sept-2015; Created
 */
@Repository
public class CreditNoteDAOImpl implements CreditNoteDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(CreditNoteDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public List<CreditNoteBean> getAcctHeadComboList() {
		List<CreditNoteBean> creditNoteList = new ArrayList<>();
		CreditNoteBean bean = null;
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CreditNoteQueryUtil.sGetAcctHeadDropDown);
			for (Map row : rows) {
				bean = new CreditNoteBean();

				bean.setId((String) row.get("ACCT_HEAD_CODE"));
				bean.setText((String) row.get("NAME"));
				bean.setAcctName((String) row.get("NAME"));
				bean.setAcctHeadCode((String) row.get("ACCT_HEAD_CODE"));
				bean.setCurrencyCode((String) row.get("CURR"));
				double exgRate = (((BigDecimal) row.get("RATE")).doubleValue());
				bean.setExgRate(exgRate);
				bean.setMloName((String) row.get("MLO_NAME"));

				creditNoteList.add(bean);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Acct Head", e);
		}
		return creditNoteList;
	}

	@Override
	public List<CreditNoteBean> getInvoiceNoList(String sAcctHeadCode) {
		List<CreditNoteBean> invNoList = new ArrayList<>();
		CreditNoteBean bean = null;
		try {
			if (sAcctHeadCode.substring(0, 1).equalsIgnoreCase("C")) {
				invNoList = jdbcTemplate.query(CreditNoteQueryUtil.sGetInvoiceNumber, new Object[] { sAcctHeadCode ,sAcctHeadCode,sAcctHeadCode}, new BeanPropertyRowMapper<>(CreditNoteBean.class));
			} else if (sAcctHeadCode.substring(0, 1).equalsIgnoreCase("S")) {
				invNoList = jdbcTemplate.query(CreditNoteQueryUtil.sGetPurchaseInvoiceNumber, new Object[] { sAcctHeadCode,sAcctHeadCode,sAcctHeadCode }, new BeanPropertyRowMapper<>(CreditNoteBean.class));

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Invoice Number", e);
		}
		return invNoList;
	}

	@Override
	public List<CreditNoteBean> getCreditNoteList(int limit, int offset) {
		List<CreditNoteBean> alCreditNoteList = new ArrayList<>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		CreditNoteBean bean = null;
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);
			alCreditNoteList = jdbcTemplate.query(CreditNoteQueryUtil.sGetCreditNoteList, new BeanPropertyRowMapper<>(CreditNoteBean.class), userDetails.getCompanyCode());
System.out.println("test" +userDetails.getCompanyCode());
		} catch (DataAccessException e) {
			LOGGER.error("Error in get Credit Note List", e);
		}
		return alCreditNoteList;
	}

	/**
	 * save credit note data with detail table
	 * *****************************************************
	 */
	@Override
	public boolean saveCreditNoteData(CreditNoteBean objCreditNoteBean, String userId, String companyCode) {
		List<CreditNoteBean> alCreditNoteList = new ArrayList<>();
		boolean isSuccess = false;
		 String creditNoteStatus = "APPROVED";
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);

			String creditNoteNo = generateCreditNoteNumber(objCreditNoteBean);
			Date creditNoteDate = CommonUtil.convertSqlDateFormat(objCreditNoteBean.getCreditNoteDate());
			String acctHeadCode = objCreditNoteBean.getAccountName();
			String invoiceNo = objCreditNoteBean.getInvoiceNo();
			Date invoiceDt = CommonUtil.convertSqlDateFormat(objCreditNoteBean.getInvoiceDate());
			String currencyCode = objCreditNoteBean.getCurrencyCode();
			double exchangeRate = objCreditNoteBean.getExchangeRate();
			String narration = objCreditNoteBean.getNarration();
			if(acctHeadCode.substring(0, 1).equalsIgnoreCase("C")) {
				acctHeadCode = "10040001";
			}
			else if(acctHeadCode.substring(0, 1).equalsIgnoreCase("S")) {
				acctHeadCode = "20000001";
	
			}
			int iCNHdr = jdbcTemplate.update(CreditNoteQueryUtil.saveCreditNoteData, new Object[] { creditNoteNo, creditNoteDate, acctHeadCode, currencyCode, exchangeRate, invoiceNo, narration, companyCode, userId, "APPROVED" });

			if (iCNHdr > 0) {
				isSuccess = saveCreditNoteDetail(objCreditNoteBean, creditNoteNo, jdbcTemplate, currencyCode, exchangeRate);
				isSuccess = saveCreditNoteMainHdrData(creditNoteNo, userId);
				isSuccess = saveCreditNoteMainDtlData(creditNoteNo);

				isSuccess = updateStatusCreditTempNoteData(creditNoteNo, creditNoteStatus, userId);

				if (isSuccess) {
					isSuccess = saveCreditNoteGeneralLedgerCreditEntry(creditNoteNo);
					isSuccess = saveCreditNoteGeneralLedgerDebitEntry(creditNoteNo);
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Records!", e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		alCreditNoteList.add(objCreditNoteBean);

		return isSuccess;
	}

	@SuppressWarnings("rawtypes")
	private boolean saveCreditNoteDetail(CreditNoteBean objCreditNoteBean, String creditNoteNo, JdbcTemplate jdbcTemplate, String currencyCode, double exchangeRate) {
		boolean flag = false;
		try {

			List<CreditNoteDetailBean> crTableData = objCreditNoteBean.getCredittables();
			for (CreditNoteDetailBean objCreditNoteDetailBean : crTableData) {

				int iCNDtl = jdbcTemplate.update(CreditNoteQueryUtil.saveCreditNoteDetailData, new Object[] { creditNoteNo, objCreditNoteDetailBean.getCrdtlAccountHead(), objCreditNoteDetailBean.getBcamount(), objCreditNoteDetailBean.getNarration(), objCreditNoteDetailBean.getTcamount(), objCreditNoteBean.getCurrencyCode(), objCreditNoteBean.getExchangeRate(), objCreditNoteDetailBean.getSlNo(), objCreditNoteDetailBean.getSubAcctCode(), objCreditNoteDetailBean.getEmployeeCode(), objCreditNoteDetailBean.getCountryCode(),
						objCreditNoteDetailBean.getCustomerCode(), objCreditNoteDetailBean.getSupplierCode(), objCreditNoteDetailBean.getDesignationCode(), objCreditNoteDetailBean.getCompanyCode(), objCreditNoteDetailBean.getCostCenter(), objCreditNoteDetailBean.getDepartmentCode(), objCreditNoteDetailBean.getPatientCode(), objCreditNoteDetailBean.getCbpdtlpaymentreceipt()});

				if (iCNDtl > 0)
					flag = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Detail Records!", e);
		}

		return flag;
	}

	/**
	 * generate Credit Note Number while save record
	 * 
	 * @return
	 * @throws ParseException
	 */
	public String generateCreditNoteNumber(CreditNoteBean bean) throws ParseException {

		String creditNoteNoValue = "";
		String sCNYear = "", sDefaultCNNo = "";
		DateFormat formatter;
		String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

		formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date;
		try {
			date = formatter.parse(bean.getCreditNoteDate());

			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String Gidate = df.format(date);
			sCurrentYear = Gidate.substring(2);

			sCNYear = "CN" + sCurrentYear + "%";
			sDefaultCNNo = "CN" + sCurrentYear + "00001";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CreditNoteQueryUtil.autoGenCreditNoteNo, new Object[] { sDefaultCNNo, sCNYear });
			for (Map row : rows) {
				creditNoteNoValue = (String) row.get("CREDITNOTE_NO");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Credit Note Number", e);
		}
		return creditNoteNoValue;
	}

	public String generateCreditNoteNumber() throws ParseException {

		String creditNoteNoValue = "";
		String sCNYear = "", sDefaultCNNo = "";

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			sCurrentYear = sCurrentYear.substring(2);
			sCNYear = "CN" + sCurrentYear + "%";
			sDefaultCNNo = "CN" + sCurrentYear + "00001";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CreditNoteQueryUtil.autoGenCreditNoteNo, new Object[] { sDefaultCNNo, sCNYear });
			for (Map row : rows) {
				creditNoteNoValue = (String) row.get("CREDITNOTE_NO");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Credit Note Number", e);
		}
		return creditNoteNoValue;
	}

	/**
	 * approve Credit Note Data
	 * 
	 * from creditnote_temp_hdr, creditnote_temp_dtl table to main table
	 * "creditnote_hdr, creditnote_dtl"
	 */
	@Override
	public boolean approveCreditNoteData(String creditnoteCode, String creditNoteStatus, String userId) {
		String SelectedIds[] = creditnoteCode.split(",");
		boolean isSuccess = false;
		for (String credNoteCode : SelectedIds) {
			isSuccess = saveCreditNoteMainHdrData(credNoteCode, userId);
			isSuccess = saveCreditNoteMainDtlData(credNoteCode);

			isSuccess = updateStatusCreditTempNoteData(credNoteCode, creditNoteStatus, userId);

			if (isSuccess) {
				isSuccess = saveCreditNoteGeneralLedgerCreditEntry(credNoteCode);
				isSuccess = saveCreditNoteGeneralLedgerDebitEntry(credNoteCode);
			}
		}
		return isSuccess;
	}

	private boolean saveCreditNoteMainHdrData(String creditnoteCode, String userId) {
		boolean flag = false;
		try {
			int iCrHdr = jdbcTemplate.update(CreditNoteQueryUtil.saveCreditNoteMainHdrData, new Object[] { userId, creditnoteCode });
			if (iCrHdr > 0)
				flag = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Header Records!", e);
		}
		return flag;
	}

	private boolean saveCreditNoteMainDtlData(String creditnoteCode) {
		boolean flag = false;
		try {
			int iCrDtl = jdbcTemplate.update(CreditNoteQueryUtil.saveCreditNoteMainDtlData, new Object[] { creditnoteCode });

			if (iCrDtl > 0)
				flag = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Detail Records!", e);
		}
		return flag;
	}

	private boolean updateStatusCreditTempNoteData(String creditnoteCode, String creditNoteStatus, String userId) {
		boolean flag = false;
		try {
			int iCrHdr = jdbcTemplate.update(CreditNoteQueryUtil.updateStatusCreditNoteTempHdrData, new Object[] { creditNoteStatus, userId, creditnoteCode });

			if (iCrHdr > 0)
				flag = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update Status of Credit Note Temp Header Records!", e);
		}
		return flag;
	}

	private boolean saveCreditNoteGeneralLedgerCreditEntry(String credNoteCode) {
		boolean flag = false;
		try {
			String subGroupCodeForTradeDebtors = "1004";// Trade Debtors
			String subGroupCodeForTradeCreditors = "2000";// Trade Creditors

			int iCrHdr = jdbcTemplate.update(CreditNoteQueryUtil.INSERT_GENERAL_LEDGER_CREDIT_ENTRY_CREDITNOTE, new Object[] { subGroupCodeForTradeDebtors, subGroupCodeForTradeCreditors, credNoteCode });

			if (iCrHdr > 0)
				flag = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update Status of Credit Note Temp Header Records!", e);
		}
		return flag;
	}

	private boolean saveCreditNoteGeneralLedgerDebitEntry(String credNoteCode) {
		boolean flag = false;
		try {
			int iCrHdr = jdbcTemplate.update(CreditNoteQueryUtil.INSERT_GENERAL_LEDGER_DEBIT_ENTRY_CREDITNOTE, new Object[] { credNoteCode });

			if (iCrHdr > 0)
				flag = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update Status of Credit Note Temp Header Records!", e);
		}
		return flag;
	}

	@Override
	public CreditNoteBean getCreditNoteForEdit(String creditNoteNo) {
		List<CreditNoteDetailBean> creditNoteDetailList = new ArrayList<>();
		CreditNoteBean objCreditNoteBean = new CreditNoteBean();
		try {
			objCreditNoteBean = jdbcTemplate.queryForObject(CreditNoteQueryUtil.GET_CREDIT_HDR_EDIT, new Object[] { creditNoteNo }, new BeanPropertyRowMapper<>(CreditNoteBean.class));
			creditNoteDetailList = jdbcTemplate.query(CreditNoteQueryUtil.GET_CREDIT_DTL_EDIT, new Object[] { creditNoteNo }, new BeanPropertyRowMapper<>(CreditNoteDetailBean.class));

			objCreditNoteBean.setCredittables((ArrayList<CreditNoteDetailBean>) creditNoteDetailList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Credit Note List", e);
		}
		return objCreditNoteBean;
	}

	@Override
	public boolean updateCRData(CreditNoteBean objCreditNoteBean, String userId) {
		boolean success = false;
		int isUpdated = 0;
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);
			isUpdated = jdbcTemplate.update(CreditNoteQueryUtil.UPDATE_CREDIT_HDR, new Object[] { CommonUtil.convertSqlDateFormat(objCreditNoteBean.getCreditNoteDate()), objCreditNoteBean.getAccountName(), objCreditNoteBean.getCurrencyCode(), objCreditNoteBean.getExchangeRate(), objCreditNoteBean.getInvoiceNo(), objCreditNoteBean.getNarration(), objCreditNoteBean.getCompanyCode(), userId, objCreditNoteBean.getCreditNoteCode() });

			if (isUpdated > 0) {
				jdbcTemplate.update(CreditNoteQueryUtil.sDeleteCreditNoteDtl, objCreditNoteBean.getCreditNoteCode());
				saveCreditNoteDetail(objCreditNoteBean, objCreditNoteBean.getCreditNoteCode(), jdbcTemplate, objCreditNoteBean.getCurrencyCode(), objCreditNoteBean.getExgRate());
				success = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Swap", e);
		}
		return success;
	}

	@Override
	public boolean deleteCreditNote(String creditCode) {

		boolean issucces = false;
		int value = 0, valueDtl = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			valueDtl = jdbcTemplate.update(CreditNoteQueryUtil.sDeleteCreditNoteDtl, creditCode);
			value = jdbcTemplate.update(CreditNoteQueryUtil.sDeleteCreditNote, creditCode);

			if (value > 0)
				issucces = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
		}
		return issucces;

	}

	@Override
	public List<CreditNoteBean> reverseList() {
		List<CreditNoteBean> reverseList = new ArrayList<>();
		CreditNoteBean bean = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			if (userDetails.getCompanyCode().equalsIgnoreCase("C0028") || userDetails.getCompanyCode().equalsIgnoreCase("C0029")) {
				reverseList = jdbcTemplate.query(CreditNoteQueryUtil.GET_REVERSE_LIST_FOR_AGENTS, new Object[] { userDetails.getUserId() }, new BeanPropertyRowMapper<>(CreditNoteBean.class));
			} else {
				reverseList = jdbcTemplate.query(CreditNoteQueryUtil.GET_REVERSE_LIST, new BeanPropertyRowMapper<>(CreditNoteBean.class));
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Credit Note List", e);
		}
		return reverseList;
	}

	@Override
	public String reversePayment(String creditNoteNo, String createdDate) {
		String sReceiptStatus = "";
		String sMessage = "";
		try {
			List<Map<String, Object>> RowData = jdbcTemplate.queryForList(CreditNoteQueryUtil.GET_PAYMENT_STATUS, new Object[] { creditNoteNo });
			for (Map<String, Object> row : RowData) {
				sReceiptStatus = (String) row.get("reverseCN");
			}

			if ("N".equalsIgnoreCase(sReceiptStatus)) {
				reversePaymentRecord(creditNoteNo, createdDate);
				sMessage = "Credit Note Reversed sucessfully";
			} else {
				sMessage = "Credit Note is already Reversed !..";
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Reverse Payment List", e);
		}
		return sMessage;
	}

	private void reversePaymentRecord(String creditNoteNo, String createdDate) {
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String reverseBBStatus = "Y";
			jdbcTemplate.update(CreditNoteQueryUtil.UPDATE_JV_HDR_STATUS, new Object[] { reverseBBStatus, creditNoteNo });
			String creditNoteNumber = generateCreditNoteNumber();
			int iCNDtl = jdbcTemplate.queryForObject(CreditNoteQueryUtil.REVERSE_CN, new Object[] { creditNoteNo, createdDate, userDetails.getUserId(), creditNoteNumber }, Integer.class);

			// int count = jdbcTemplate.update(CreditNoteQueryUtil.REVERSE_CN, new Object[]
			// { creditNoteNo, createdDate, userDetails.getUserId(), creditNoteNumber },
			// Integer.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
