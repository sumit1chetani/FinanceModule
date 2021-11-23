package com.dci.tenant.finance.PurchaseCreditNote;

import java.math.BigDecimal;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import com.dci.common.util.AccountsConstants;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.finance.journalvoucher.JournalVoucherBean;
import com.dci.tenant.user.UserDetail;

/**
 * This class Dispatches the user's action according to the DAO, it perform only
 * get,add,update,delete ageneralnd so on.
 * 
 * @author raghavan
 * @version 1.0
 * @revision 12-June-2015; Created
 */
@Repository
public class PuchaseCreditNoteDAOImpl implements PurchaseCreditNoteDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(PuchaseCreditNoteDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Override
	public List<PurchaseCreditNoteBean> getAcctHeadComboList() {
		List<PurchaseCreditNoteBean> alPayerList = new ArrayList<>();
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			alPayerList = jdbcTemplate.query(PurchaseCreditNoteQueryUtil.sGetAcctHeadDropDown, new BeanPropertyRowMapper<>(PurchaseCreditNoteBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Acct Head", e);
		}
		return alPayerList;
	}

	@Override
	public List<PurchaseCreditNoteBean> getInvoiceNoList(String sAcctHeadCode) {
		List<PurchaseCreditNoteBean> creditNoteList = new ArrayList<>();
		PurchaseCreditNoteBean bean = null;
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseCreditNoteQueryUtil.sGetInvoiceNumber, new Object[] { sAcctHeadCode, sAcctHeadCode });

			for (Map row : rows) {
				bean = new PurchaseCreditNoteBean();

				bean.setId((String) row.get("INVOICE_NO"));
				bean.setText((String) row.get("INVOICE_NO"));
				bean.setInvoiceNo((String) row.get("INVOICE_NO"));
				bean.setInvoiceDate((String) row.get("INVOICE_DT"));
				creditNoteList.add(bean);

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in get Invoice Number", e);
		}
		return creditNoteList;
	}

	@Override
	public List<PurchaseCreditNoteBean> getCreditNoteList(int limit, int offset, String formCode, String userId) {
		List<PurchaseCreditNoteBean> alCreditNoteList = new ArrayList<>();
		PurchaseCreditNoteBean bean = null;
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);
			// alCreditNoteList =
			// jdbcTemplate.query(PurchaseCreditNoteQueryUtil.sGetCreditNoteList,
			// new Object[] { formCode, userId });
			alCreditNoteList = jdbcTemplate.query(PurchaseCreditNoteQueryUtil.sGetCreditNoteList, new BeanPropertyRowMapper<>(PurchaseCreditNoteBean.class));

			/*
			 * List<Map<String, Object>> rows = for (Map row : rows) { bean = new
			 * PurchaseCreditNoteBean(); bean.setCreditNoteCode((String)
			 * row.get("CREDITNOTE_NO")); bean.setCreditNoteDate((String)
			 * row.get("CREDITNOTE_DATE")); bean.setMloName((String)
			 * row.get("PAYER_SHORT_NAME")); bean.setInvoiceNo((String)
			 * row.get("CREDITNOTE_INVOICE_NO")); bean.setApproveStatus((String)
			 * row.get("APPROVE_STATUS")); bean.setLocation((String) row.get("LOCATION"));
			 * bean.setCompany((String) row.get("COMPANY_NAME")); if (((BigDecimal)
			 * row.get("CR_AMOUNT")) != null) { bean.setCreditAmount((((BigDecimal)
			 * row.get("CR_AMOUNT")).doubleValue())); } if ((BigDecimal)
			 * row.get("CR_AMOUNTUSD") != null) { bean.setCreditAmountUSD((((BigDecimal)
			 * row.get("CR_AMOUNTUSD")).doubleValue())); }
			 */
			/*
			 * bean.setUrIsDelete((String) row.get("urIsDelete")); bean.setUrIsEdit((String)
			 * row.get("urIsEdit")); bean.setUrIsPrint((String) row.get("urIsPrint"));
			 * bean.setUrIsView((String) row.get("urIsView"));
			 */
			// alCreditNoteList.add(bean);

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Credit Note List", e);
		}
		return alCreditNoteList;
	}

	@Override
	public List<PurchaseCreditNoteBean> reverseList() {
		List<PurchaseCreditNoteBean> reverseList = new ArrayList<>();
		PurchaseCreditNoteBean bean = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			if (userDetails.getCompanyCode().equalsIgnoreCase("C0028") || userDetails.getCompanyCode().equalsIgnoreCase("C0029")) {
				reverseList = jdbcTemplate.query(PurchaseCreditNoteQueryUtil.GET_REVERSE_LIST_FOR_AGENTS, new Object[] { userDetails.getUserId() }, new BeanPropertyRowMapper<>(PurchaseCreditNoteBean.class));
			} else {
				reverseList = jdbcTemplate.query(PurchaseCreditNoteQueryUtil.GET_REVERSE_LIST, new BeanPropertyRowMapper<>(PurchaseCreditNoteBean.class));
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Credit Note List", e);
		}
		return reverseList;
	}

	/**
	 * save credit note data with detail table *
	 * 
	 * @throws ParseException
	 *             ****************************************************
	 */
	@Override
	public synchronized List<PurchaseCreditNoteBean> saveCreditNoteData(PurchaseCreditNoteBean objCreditNoteBean, String userId) throws ParseException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<PurchaseCreditNoteBean> alCreditNoteList = new ArrayList<>();
		PurchaseCreditNoteBean bean = null;
		String sCompanyCode = objCreditNoteBean.getCompanyCode(), sLocnName = "";
		try {
			/*
			 * if (objCreditNoteBean.getDraftMode() != null) { if
			 * (objCreditNoteBean.getDraftMode().equalsIgnoreCase("D")) { jdbcTemplate
			 * .update(PurchaseCreditNoteQueryUtil.sDeleteCreditNoteDraftDtl,
			 * objCreditNoteBean.getCreditNoteCode());
			 * jdbcTemplate.update(PurchaseCreditNoteQueryUtil .sDeleteCreditNoteDraft,
			 * objCreditNoteBean.getCreditNoteCode()); } }
			 */
			jdbcTemplate = new JdbcTemplate(dataSource);
			//
			// List<Map<String, Object>> locnNameRows =
			// jdbcTemplate.queryForList(PurchaseCreditNoteQueryUtil.sGetLocationWithInvoiceNo,
			// new Object[] { objCreditNoteBean.getCompanyCode() });
			// for (Map row : locnNameRows) {
			// sLocnName = (String) row.get("LOCATION");
			// }
			String creditNoteNo = generateCreditNoteNumber_Direct(sLocnName, objCreditNoteBean.getCreditNoteDate());
			String creditNoteDate = objCreditNoteBean.getCreditNoteDate();
			String acctHeadCode = objCreditNoteBean.getAccountName();
			String invoiceNo = objCreditNoteBean.getInvoiceNo();
			String invoiceDt = objCreditNoteBean.getInvoiceDate();
			String currencyCode = objCreditNoteBean.getCurrencyCode();
			double exchangeRate = objCreditNoteBean.getExchangeRate();
			String narration = objCreditNoteBean.getNarration();
			String voyage = objCreditNoteBean.getVoyageId();
			String creditNoteRefNo = objCreditNoteBean.getCreditNoteNo();
			String mainAcctCode = AccountsConstants.TRADE_CREDITORS_AH;
			String mainSubGroupCode = AccountsConstants.TRADE_CREDITORS_SG;
			objCreditNoteBean.setCreditNoteNo(creditNoteNo);
			System.out.println(creditNoteNo);

			String sRefNo = getRefernceNo(objCreditNoteBean.getCompanyCode(), creditNoteNo);
			objCreditNoteBean.setRefNo(sRefNo);
			int iCNHdr = jdbcTemplate.update(PurchaseCreditNoteQueryUtil.saveCreditNoteData, new Object[] { creditNoteNo, creditNoteDate, acctHeadCode, currencyCode, exchangeRate, invoiceNo, narration, sCompanyCode, userId, "N", voyage, objCreditNoteBean.getBcAmount(), objCreditNoteBean.getTcAmount(), mainAcctCode, mainSubGroupCode, creditNoteRefNo, sRefNo });

			if (iCNHdr > 0) {
				UserLog userLog = userlogDao.userLogForInsert(objCreditNoteBean, creditNoteNo, userDetails.getUserId());
				// auditLogDao.auditLogForInsert(objCreditNoteBean, userLog,
				// null);
				// savecreditHeaderProcedureCall(objCreditNoteBean, "save");
				saveReverseCreditNoteDetail(objCreditNoteBean, creditNoteNo, jdbcTemplate, currencyCode, exchangeRate);
			}

			objCreditNoteBean.setCreditNoteCode(creditNoteNo);
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Records!", e);
		}

		alCreditNoteList.add(objCreditNoteBean);

		return alCreditNoteList;
	}

	/*
	 * private boolean savecreditHeaderProcedureCall(PurchaseCreditNoteBean
	 * objCreditNoteBean, String method) { boolean isSuccess = false; Connection
	 * conn = null; try { GeneralLedgerProcedureBean objGeneralLedgerProcedureBean =
	 * new GeneralLedgerProcedureBean();
	 * objGeneralLedgerProcedureBean.setAccountHeadCode(AccountsConstants.
	 * TRADE_CREDITORS_AH);
	 * objGeneralLedgerProcedureBean.setSubGroupCode(AccountsConstants.
	 * TRADE_CREDITORS_SG);
	 * objGeneralLedgerProcedureBean.setTransactionNo(objCreditNoteBean.
	 * getCreditNoteNo());
	 * objGeneralLedgerProcedureBean.setCurrencyCode(objCreditNoteBean.
	 * getCurrencyCode());
	 * objGeneralLedgerProcedureBean.setExchangeRate(objCreditNoteBean.
	 * getExchangeRate());
	 * objGeneralLedgerProcedureBean.setBcAmount(objCreditNoteBean.getBcAmount());
	 * objGeneralLedgerProcedureBean.setTcAmount(objCreditNoteBean.getTcAmount());
	 * objGeneralLedgerProcedureBean.setLedgerDate(objCreditNoteBean.
	 * getCreditNoteDate());
	 * objGeneralLedgerProcedureBean.setCompanyCode(objCreditNoteBean.getCompanyCode
	 * ()); objGeneralLedgerProcedureBean.setSubAccountCode(objCreditNoteBean.
	 * getAccountName());
	 * objGeneralLedgerProcedureBean.setNarration(objCreditNoteBean.getNarration());
	 * objGeneralLedgerProcedureBean.setRefNo(objCreditNoteBean.getRefNo());
	 * 
	 * 
	 * if (method.equalsIgnoreCase("save")) {
	 * jdbcTemplate.queryForList(CreditNoteQueryUtil
	 * .CALL_HEADER_GENERAL_LEDGER_FUNCTION, new Object[] {
	 * objGeneralLedgerProcedureBean.getAccountHeadCode(),
	 * objGeneralLedgerProcedureBean.getSubGroupCode(),
	 * objGeneralLedgerProcedureBean.getTransactionNo(),
	 * objGeneralLedgerProcedureBean.getCurrencyCode(),
	 * objGeneralLedgerProcedureBean.getExchangeRate(),
	 * objGeneralLedgerProcedureBean.getTcAmount(), 0,
	 * objGeneralLedgerProcedureBean.getBcAmount(), 0, "INSERT",
	 * objGeneralLedgerProcedureBean.getLedgerDate(), //
	 * CommonUtil.DISPLAY_DATE_FORMAT1, 0,
	 * objGeneralLedgerProcedureBean.getCompanyCode(),
	 * objGeneralLedgerProcedureBean.getSubAccountCode(),
	 * objGeneralLedgerProcedureBean.getNarration(), null, null,
	 * objGeneralLedgerProcedureBean.getRefNo() });
	 * 
	 * // isSuccess = //
	 * GeneralLedgerProcedureUtil.saveCreditEntryForHeaderProcedureCallNEW
	 * (objGeneralLedgerProcedureBean, // conn); }
	 * 
	 * else { // GeneralLedgerProcedureUtil.deleteDebitEntryHeaderProcedure
	 * (objGeneralLedgerProcedureBean, // conn); }
	 * 
	 * 
	 * } catch (DataAccessException e) {
	 * LOGGER.error("Error in save the Header Records in General Ledger!", e); }
	 * finally { if (conn != null) try { conn.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 * 
	 * return isSuccess; }
	 */
	private void saveReverseCreditNoteDetail(PurchaseCreditNoteBean objCreditNoteBean, String creditNoteNo, JdbcTemplate jdbcTemplate, String currencyCode, double exchangeRate) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		boolean isInterCompanyTransaction = false;
		try {
			boolean flag = false;
			List<JournalVoucherBean> lJournalVoucherList = new ArrayList<>();
			List<PuchaseCreditNoteDetailBean> crTableData = objCreditNoteBean.getCredittables();
			for (PuchaseCreditNoteDetailBean objCreditNoteDetailBean : crTableData) {
				if (!(objCreditNoteBean.getCompanyCode().equals(objCreditNoteDetailBean.getCompany_id_dtl()))) {
					JournalVoucherBean objJournalVoucherCreditBean = new JournalVoucherBean();
					isInterCompanyTransaction = true;
					String creditaccount = "";
					String debitaccount = "";
					String debitnarration = "";
					String creditnarration = "";

				}

				jdbcTemplate.update(PurchaseCreditNoteQueryUtil.saveCreditNoteDetailData, new Object[] { creditNoteNo,

						objCreditNoteDetailBean.getCrdtlAccountHead(),

						objCreditNoteDetailBean.getCurrency(), objCreditNoteDetailBean.getExchangeRate(),

						objCreditNoteDetailBean.getTcamount(), objCreditNoteDetailBean.getNarration(),

						objCreditNoteDetailBean.getBcamount(), objCreditNoteDetailBean.getSlNo(),

						objCreditNoteDetailBean.getCrdtlAccountHead().substring(0, 4), objCreditNoteDetailBean.getSubAcctCode(),

						objCreditNoteDetailBean.getEmployeeCode(), objCreditNoteDetailBean.getPortCode(),

						objCreditNoteDetailBean.getAgentCode(), objCreditNoteDetailBean.getCountryCode(),

						objCreditNoteDetailBean.getCustomerCode(), objCreditNoteDetailBean.getSupplierCode(),

						objCreditNoteDetailBean.getDesignationCode(), objCreditNoteDetailBean.getCompanyCode(),

						objCreditNoteDetailBean.getCostCenter(), objCreditNoteDetailBean.getQuantityGO(),

						objCreditNoteDetailBean.getQuantityFO(), objCreditNoteDetailBean.getPortSequence(), objCreditNoteDetailBean.getDepartmentCode(), objCreditNoteDetailBean.getVoyageCode(), objCreditNoteDetailBean.getVesselCode(), objCreditNoteDetailBean.getSectorCode(), objCreditNoteDetailBean.getCompany_id_dtl(), objCreditNoteBean.getRefNo() });

				UserLog userLog = userlogDao.userLogForInsert(objCreditNoteDetailBean, creditNoteNo, userDetails.getUserId());
				// auditLogDao.auditLogForInsert(objCreditNoteDetailBean,
				// userLog, null);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Detail Records!", e);
		}
	}

	/*
	 * public String generateJournalVoucherNumber_Direct(String sCompanyCode, String
	 * recDate, PurchaseCreditNoteBean objCreditNoteBean) throws CustomException,
	 * ParseException {
	 * 
	 * String sLocnName = "", shortName = ""; List<Map<String, Object>> locnNameRows
	 * = jdbcTemplate.queryForList(CashBankPaymentQueryUtil.
	 * GET_LOCATION_WITH_COMPANY_ID, new Object[] { sCompanyCode }); for (Map row :
	 * locnNameRows) { sLocnName = (String) row.get("LOCATION"); shortName =
	 * (String) row.get("shortName");
	 * 
	 * } sLocnName = shortName.substring(0, 2); DateFormat formatter; formatter =
	 * new SimpleDateFormat("dd/MM/yyyy"); Date date = formatter.parse(recDate);
	 * SimpleDateFormat df = new SimpleDateFormat("yyyy"); String receiptDateyear =
	 * df.format(date); String sCurrentYear = receiptDateyear.substring(2);
	 * 
	 * String journalNo = ""; String sJVYearWithLike = "", sJVLocn = "", sJVYear =
	 * "", sJVstartingNo = ""; try { // String sCurrentYear = //
	 * String.valueOf(Calendar.getInstance().get(Calendar.YEAR)); // sCurrentYear =
	 * sCurrentYear.substring(2); List<JournalVoucherBean> lJournalVoucherList = new
	 * ArrayList<>(); List<PuchaseCreditNoteDetailBean> crTableData =
	 * objCreditNoteBean.getCredittables(); for (PuchaseCreditNoteDetailBean
	 * objCreditNoteDetailBean : crTableData) { if
	 * (!(objCreditNoteBean.getCompanyCode().equals(objCreditNoteDetailBean.
	 * getCompany_id_dtl()))) { if
	 * (objCreditNoteBean.getCompanyCode().equalsIgnoreCase("C0002")) {
	 * sJVYearWithLike = "PAP" + "JV" + sCurrentYear + "%"; sJVLocn = "PAP" + "JV" +
	 * sCurrentYear; sJVYear = "PAP" + "JV" + sCurrentYear; sJVstartingNo = "PAP" +
	 * "JV" + sCurrentYear + "00001"; List<Map<String, Object>> rows =
	 * jdbcTemplate.queryForList(JournalVoucherQueryUtil.
	 * AUTO_GEN_PG_JOURNAL_NO_SIN_FOR_INTRA, new Object[] { sJVstartingNo, sJVLocn,
	 * sJVYearWithLike }); for (Map row : rows) { journalNo = (String)
	 * row.get("JOURNAL_NO"); } } else if
	 * (objCreditNoteBean.getCompanyCode().equalsIgnoreCase("C0003")) {
	 * sJVYearWithLike = "PAP" + "JV" + sCurrentYear + "%"; sJVLocn = "PAP" + "JV" +
	 * sCurrentYear; sJVYear = "PAP" + "JV" + sCurrentYear; sJVstartingNo = "PAP" +
	 * "JV" + sCurrentYear + "00001"; List<Map<String, Object>> rows =
	 * jdbcTemplate.queryForList(JournalVoucherQueryUtil.
	 * AUTO_GEN_PG_JOURNAL_NO_SIN_FOR_INTRA, new Object[] { sJVstartingNo, sJVLocn,
	 * sJVYearWithLike }); for (Map row : rows) { journalNo = (String)
	 * row.get("JOURNAL_NO"); } } else if
	 * (objCreditNoteBean.getCompanyCode().equalsIgnoreCase("C0004")) {
	 * 
	 * sJVYearWithLike = "PAP" + "JV" + sCurrentYear + "%"; sJVLocn = "PAP" + "JV" +
	 * sCurrentYear; sJVYear = "PAP" + "JV" + sCurrentYear; sJVstartingNo = "PAP" +
	 * "JV" + sCurrentYear + "00001"; List<Map<String, Object>> rows =
	 * jdbcTemplate.queryForList(JournalVoucherQueryUtil.
	 * AUTO_GEN_PG_JOURNAL_NO_SIN_FOR_INTRA, new Object[] { sJVstartingNo, sJVLocn,
	 * sJVYearWithLike }); for (Map row : rows) { journalNo = (String)
	 * row.get("JOURNAL_NO"); } }
	 * 
	 * else { sJVYearWithLike = "PAP" + "JV" + sCurrentYear + "%"; sJVYear = "PAP" +
	 * "JV" + sCurrentYear; sJVLocn = "PAP" + "JV" + sCurrentYear; sJVstartingNo =
	 * "PAP" + "JV" + sCurrentYear + "00001"; List<Map<String, Object>> rows =
	 * jdbcTemplate.queryForList(JournalVoucherQueryUtil.
	 * AUTO_GEN_PG_JOURNAL_NO_SIN_FOR_INTRA, new Object[] { sJVstartingNo, sJVLocn,
	 * sJVYearWithLike }); for (Map row : rows) { journalNo = (String)
	 * row.get("JOURNAL_NO"); } } } } }
	 * 
	 * catch (DataAccessException e) { } return journalNo; }
	 */
	/*
	 * public String getJournalRefernceNo(String sCompanyCode, String journalNumber)
	 * throws CustomException { String refno = ""; List<String> lOwnersCompany = new
	 * ArrayList<>(); List<Map<String, Object>> rows =
	 * jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY); for
	 * (Map row : rows) { lOwnersCompany.add((String) row.get("COMPANY_CODE")); }
	 * 
	 * if ("C0001".equalsIgnoreCase(sCompanyCode)) { refno =
	 * jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GET_REF_NO_FEEDER,
	 * String.class); } else if (lOwnersCompany.contains(sCompanyCode)) { refno =
	 * jdbcTemplate.queryForObject(JournalVoucherQueryUtil.GET_REF_NO_OWNERS,
	 * String.class); } else { refno = journalNumber; }
	 * 
	 * return refno; }
	 */

	public String getRefernceNo(String sCompanyCode, String sInvoiceNo) {
		String refno = "";
		List<String> lOwnersCompany = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonUtilityQueryUtil.GET_OWNERS_COMPANY);
		for (Map row : rows) {
			lOwnersCompany.add((String) row.get("COMPANY_CODE"));
		}
		if ("C0001".equalsIgnoreCase(sCompanyCode)) {
			refno = jdbcTemplate.queryForObject(PurchaseCreditNoteQueryUtil.GET_REF_NO_FEEDER, String.class);
		} else if (lOwnersCompany.contains(sCompanyCode)) {
			refno = jdbcTemplate.queryForObject(PurchaseCreditNoteQueryUtil.GET_REF_NO_OWNERS, String.class);
		} else {
			refno = sInvoiceNo;
		}

		return refno;
	}

	public static String returnEmptyForNull(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null")) {
			return "";
		} else {
			return s1;
		}
	}

	/*
	 * private void savecreditHeaderProcedureCall_old(PurchaseCreditNoteBean
	 * objCreditNoteBean, String method) { boolean isSuccess = false; Connection
	 * conn = null; try { conn = jdbcTemplate.getDataSource().getConnection();
	 * GeneralLedgerProcedureBean objGeneralLedgerProcedureBean = new
	 * GeneralLedgerProcedureBean();
	 * objGeneralLedgerProcedureBean.setAccountHeadCode(AccountsConstants.
	 * TRADE_CREDITORS_AH);
	 * objGeneralLedgerProcedureBean.setSubGroupCode(AccountsConstants.
	 * TRADE_CREDITORS_SG);
	 * objGeneralLedgerProcedureBean.setTransactionNo(objCreditNoteBean.
	 * getCreditNoteNo());
	 * objGeneralLedgerProcedureBean.setCurrencyCode(objCreditNoteBean.
	 * getCurrencyCode());
	 * objGeneralLedgerProcedureBean.setExchangeRate(objCreditNoteBean.
	 * getExchangeRate());
	 * objGeneralLedgerProcedureBean.setBcAmount(objCreditNoteBean.getTotalBCAmount(
	 * ));
	 * objGeneralLedgerProcedureBean.setTcAmount(objCreditNoteBean.getTotalTCAmount(
	 * )); objGeneralLedgerProcedureBean.setLedgerDate(objCreditNoteBean.
	 * getCreditNoteDate());
	 * objGeneralLedgerProcedureBean.setCompanyCode(objCreditNoteBean.getCompanyCode
	 * ()); objGeneralLedgerProcedureBean.setSubAccountCode(objCreditNoteBean.
	 * getAccountName());
	 * 
	 * if (method.equalsIgnoreCase("save")) { //
	 * GeneralLedgerProcedureUtil.saveDebitEntryForHeaderProcedureCall(
	 * objGeneralLedgerProcedureBean, // conn); } else { //
	 * GeneralLedgerProcedureUtil.deleteDebitEntryHeaderProcedure(
	 * objGeneralLedgerProcedureBean, // conn); } } catch (DataAccessException |
	 * SQLException e) {
	 * LOGGER.error("Error in save the Header Records in General Ledger!", e); }
	 * finally { if (conn != null) try { conn.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */

	public String generateCreditNoteNumber_Direct(String sLocnName, String recDate) throws ParseException {

		String creditNoteNoValue = "";
		String sCNYear = "", sCNLocn = "", sCNStartingNo = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// String sCurrentYear =
			// String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			sLocnName = sLocnName.substring(0);
			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(recDate);
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String receiptDateyear = df.format(date);
			String sCurrentYear = receiptDateyear.substring(2);
			if (!sLocnName.equalsIgnoreCase("DU")) {
				// sCurrentYear = sCurrentYear.substring(2);
				// sCNYear = "PCN" + sLocnName + sCurrentYear + "%";
				// sCNLocn = "PCN" + sLocnName + sCurrentYear;

				sCNYear = "GPCN" + sCurrentYear + "%";
				sCNLocn = "GPCN";
				sCNStartingNo = "GPCN" + sCurrentYear + "00001";

				List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseCreditNoteQueryUtil.AUTO_GEN_FOR_PG_CREDITNOTE_NO, new Object[] { sCNStartingNo, sCNLocn, sCNYear });
				for (Map row : rows) {
					creditNoteNoValue = (String) row.get("PUR_CREDITNOTE_NO");
				}
			} else {
				// sCurrentYear = sCurrentYear.substring(2);
				sCNYear = "GPCN" + sCurrentYear + "%";
				sCNLocn = "GPCN";
				sCNStartingNo = "GPCN" + sCurrentYear + "00001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseCreditNoteQueryUtil.AUTO_GEN_FOR_PG_CREDITNOTE_NO_DUBAI, new Object[] { sCNStartingNo, sCNLocn, sCNYear });
				for (Map row : rows) {
					creditNoteNoValue = (String) row.get("PUR_CREDITNOTE_NO");
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Credit Note Number", e);
		}
		return creditNoteNoValue;
	}

	/**
	 * generate Credit Note Number while save record
	 * 
	 * @param sLocnName
	 * 
	 * @return
	 */
	@Override
	public String generateCreditNoteNumber(String sLocnName) {

		String creditNoteNoValue = "";
		String sCNYear = "", sCNLocn = "", sCNStartingNo = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			sLocnName = sLocnName.substring(0, 2);
			if (!sLocnName.equalsIgnoreCase("DU")) {
				sCurrentYear = sCurrentYear.substring(2);
				// sCNYear = "PCN" + sLocnName + sCurrentYear + "%";
				// sCNLocn = "PCN" + sLocnName + sCurrentYear;

				sCNYear = sLocnName + "PCN" + sCurrentYear + "%";
				sCNLocn = sLocnName + "PCN";
				sCNStartingNo = sLocnName + "PCN" + sCurrentYear + "00001";

				List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseCreditNoteQueryUtil.AUTO_GEN_FOR_PG_CREDITNOTE_NO, new Object[] { sCNStartingNo, sCNLocn, sCNYear });
				for (Map row : rows) {
					creditNoteNoValue = (String) row.get("PUR_CREDITNOTE_NO");
				}
			} else {
				sCurrentYear = sCurrentYear.substring(2);
				sCNYear = "PCN" + sCurrentYear + "%";
				sCNLocn = "PCN";
				sCNStartingNo = "PCN" + sCurrentYear + "00001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseCreditNoteQueryUtil.AUTO_GEN_FOR_PG_CREDITNOTE_NO_DUBAI, new Object[] { sCNStartingNo, sCNLocn, sCNYear });
				for (Map row : rows) {
					creditNoteNoValue = (String) row.get("PUR_CREDITNOTE_NO");
				}
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
	public boolean approveCreditNoteData(String creditnoteCode, String userId) {
		String SelectedIds[] = creditnoteCode.split(",");
		boolean isSuccess = false;
		for (int i = 0; i < SelectedIds.length; i++) {
			isSuccess = updateStatusCreditTempNoteData(SelectedIds[i], userId);

		}
		return isSuccess;
	}

	@Override
	public boolean approveCreditNoteSign(PurchaseCreditNoteBean creditnoteCode, String userId) {

		boolean isSuccess = false;

		isSuccess = updateStatusCreditTempNoteData(creditnoteCode.getCreditNoteCode(), userId);

		return isSuccess;
	}

	private boolean updateStatusCreditTempNoteData(String creditnoteCode, String userId) {
		boolean flag = false;
		try {
			int iCrHdr = jdbcTemplate.update(PurchaseCreditNoteQueryUtil.updateStatusCreditNoteTempHdrData, new Object[] { "Y", userId, creditnoteCode });

			if (iCrHdr > 0)
				flag = true;
			System.out.println("updateStatusCreditNoteTempHdrData:::::::::::::::::::::::::::" + flag);
		} catch (DataAccessException e) {
			LOGGER.error("Error in update Status of Purchase Credit Note Temp Header Records!", e);
		}
		return flag;
	}

	@Override
	public PurchaseCreditNoteBean getCreditNoteForEdit(String creditCode) {
		PurchaseCreditNoteBean bean = new PurchaseCreditNoteBean();
		List<PuchaseCreditNoteDetailBean> detailList = new ArrayList<>();
		List<PuchaseCreditNoteDetailBean> detailRowList = new ArrayList<>();
		ArrayList finalList = new ArrayList();
		Map detailMap = null;
		double amt = 0, amtUsd = 0;
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);
			bean = jdbcTemplate.queryForObject(PurchaseCreditNoteQueryUtil.GET_CREDIT_HDR_EDIT, new Object[] { creditCode }, new BeanPropertyRowMapper<>(PurchaseCreditNoteBean.class));
			detailList = getCreditNoteDtlForEdit(creditCode);
			bean.setCredittables((ArrayList<PuchaseCreditNoteDetailBean>) detailList);

			bean.setAcctHeadList(getAcctHeadComboList());

			if (bean.getAccountName() != null && !bean.getAccountName().equalsIgnoreCase(""))
				bean.setInvoiceList(getInvoiceNoList(bean.getAccountName()));

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the credit Note Records!", e);
		}

		return bean;
	}

	@Override
	public PurchaseCreditNoteBean getCreditNoteForView(String creditCode) {
		PurchaseCreditNoteBean bean = new PurchaseCreditNoteBean();
		List<PuchaseCreditNoteDetailBean> detailList = new ArrayList<>();
		List<PuchaseCreditNoteDetailBean> detailRowList = new ArrayList<>();
		ArrayList finalList = new ArrayList();
		Map detailMap = null;

		double totalbc = 0, totaltc = 0;
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);
			bean = jdbcTemplate.queryForObject(PurchaseCreditNoteQueryUtil.selectCreditNoteViewData, new Object[] { creditCode }, new BeanPropertyRowMapper<>(PurchaseCreditNoteBean.class));
			detailList = getCreditNoteDtlForView(creditCode);
			bean.setCredittables((ArrayList<PuchaseCreditNoteDetailBean>) detailList);

			for (PuchaseCreditNoteDetailBean noteBean : detailList) {
				totalbc = totalbc + noteBean.getTcamount();
				totaltc = totaltc + noteBean.getBcamount();

				System.out.println("totaltc" + totalbc);
			}

			// bean.setTcamountWords(currencyInWords(Math.round(totaltc * 100.0)
			// / 100.0, "Amount(" + bean.getCompanyCurrency() + ")"));
			// bean.setBcamountWords(currencyInWords(Math.round(totalbc * 100.0)
			// / 100.0, "Amount(" + bean.getCurrencyCode() + ")"));
			bean.setTotalbc(Math.round(totalbc * 100.0) / 100.0);
			bean.setTotaltc(Math.round(totaltc * 100.0) / 100.0);

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the credit Note Records!", e);
		}

		return bean;
	}

	private List<PuchaseCreditNoteDetailBean> getCreditNoteDtlForEdit(String creditCode) {
		List<PuchaseCreditNoteDetailBean> dtlList = new ArrayList<>();
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);
			dtlList = jdbcTemplate.query(PurchaseCreditNoteQueryUtil.GET_CREDIT_DTL_EDIT, new Object[] { creditCode }, new BeanPropertyRowMapper<>(PuchaseCreditNoteDetailBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Debit Note Records!", e);
		}

		return dtlList;
	}

	private List<PuchaseCreditNoteDetailBean> getCreditNoteDtlForView(String creditCode) {
		List<PuchaseCreditNoteDetailBean> dtlList = new ArrayList<>();
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);
			dtlList = jdbcTemplate.query(PurchaseCreditNoteQueryUtil.selectCrediteDetailViewData, new Object[] { creditCode }, new BeanPropertyRowMapper<>(PuchaseCreditNoteDetailBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Debit Note Records!", e);
		}

		return dtlList;
	}

	/*
	 * @Override public boolean updateCRData(PurchaseCreditNoteBean
	 * objCreditNoteBean, String userId) { UserDetail userDetails = (UserDetail)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * boolean success = false; int isUpdated = 0; try { PurchaseCreditNoteBean
	 * oldBean = getCreditNoteForEdit(objCreditNoteBean.getCreditNoteCode());
	 * jdbcTemplate = new JdbcTemplate(dataSource); isUpdated =
	 * jdbcTemplate.update(PurchaseCreditNoteQueryUtil.UPDATE_CREDIT_HDR, new
	 * Object[] { objCreditNoteBean.getCreditNoteDate(),
	 * objCreditNoteBean.getAccountName(), objCreditNoteBean.getCurrencyCode(),
	 * objCreditNoteBean.getExchangeRate(), objCreditNoteBean.getInvoiceNo(),
	 * objCreditNoteBean.getNarration(), objCreditNoteBean.getCompanyCode(), userId,
	 * objCreditNoteBean.getTotalBCAmount(), objCreditNoteBean.getTotalTCAmount(),
	 * objCreditNoteBean.getVoyageId(), objCreditNoteBean.getCreditNoteNo(),
	 * objCreditNoteBean.getCreditNoteCode() });
	 * 
	 * if (isUpdated > 0) { UserLog userLog = userlogDao.userLogForUpdate(oldBean,
	 * objCreditNoteBean, objCreditNoteBean.getCreditNoteCode(),
	 * userDetails.getUserId()); auditLogDao.auditLogForUpdate(oldBean,
	 * objCreditNoteBean, userLog, null);
	 * jdbcTemplate.update(PurchaseCreditNoteQueryUtil.sDeleteCreditNoteDtl,
	 * objCreditNoteBean.getCreditNoteCode());
	 * saveCreditNoteDetail(objCreditNoteBean,
	 * objCreditNoteBean.getCreditNoteCode(), jdbcTemplate,
	 * objCreditNoteBean.getCurrencyCode(), objCreditNoteBean.getExgRate()); success
	 * = true; }
	 * 
	 * } catch (DataAccessException e) { LOGGER.error("Error in Save Swap", e); }
	 * return success; }
	 */

	@Override
	public boolean deleteCreditNote(String creditCode) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean issucces = false;
		int value = 0, valueDtl = 0, gldelete = 0;
		try {
			PurchaseCreditNoteBean oldBean = getCreditNoteForEdit(creditCode);
			List<PuchaseCreditNoteDetailBean> oldDetail = getCreditNoteDtlForEdit(creditCode);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			valueDtl = jdbcTemplate.update(PurchaseCreditNoteQueryUtil.sDeleteCreditNoteDtl, creditCode);
			System.out.println("valueDtl::::::::::::::::::::" + valueDtl);
			if (valueDtl > 0) {
				value = jdbcTemplate.update(PurchaseCreditNoteQueryUtil.sDeleteCreditNote, creditCode);
			} else if (valueDtl == 0) {
				value = jdbcTemplate.update(PurchaseCreditNoteQueryUtil.sDeleteCreditNote, creditCode);
			}

			/*
			 * if (value != 0 && valueDtl != 0) { issucces = true; gldelete =
			 * jdbcTemplate.update(PurchaseCreditNoteQueryUtil.DeleteGL, creditCode);
			 * 
			 * UserLog userLog = userlogDao.userLogForDelete(oldBean, creditCode,
			 * userDetails.getUserId()); auditLogDao.auditLogForDelete(oldBean, userLog,
			 * null); for (PuchaseCreditNoteDetailBean bean : oldDetail) { UserLog userLog1
			 * = userlogDao.userLogForDelete(bean, creditCode, userDetails.getUserId());
			 * auditLogDao.auditLogForDelete(bean, userLog1, null); }
			 * 
			 * }
			 */
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
		}
		return issucces;

	}

	/*
	 * @Override public Invoice printInvoice(String invoiceNo, String compLoc)
	 * throws CustomException { double totalUSD, totalAED; int currFractionAED = 0;
	 * int currFractionUSD = 2; String strTotalAED = ""; String strTotalUSD = "";
	 * String agent = ""; Invoice listInvoice = new Invoice(); try {
	 * 
	 * JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); listInvoice =
	 * jdbcTemplate
	 * .queryForObject(PurchaseCreditNoteQueryUtil.GetInvoiceAddresList, new
	 * Object[] { invoiceNo }, new BeanPropertyRowMapper<>(Invoice.class));
	 * 
	 * getCompanyName(invoiceNo, listInvoice); System.out.println("Location " +
	 * listInvoice.getLocationName());
	 * 
	 * } catch (Exception e) { LOGGER.error("Error in addCodeStandard", e); } return
	 * listInvoice; }
	 * 
	 * public String inWords(long val) {
	 * 
	 * double ibillion = val / 1000000000;
	 * 
	 * long billion = (long) (ibillion);
	 * 
	 * val = val - billion * 1000000000;
	 * 
	 * float imillion = val / 1000000;
	 * 
	 * int million = (int) (imillion);
	 * 
	 * val = val - million * 1000000;
	 * 
	 * float ithousand = val / 1000;
	 * 
	 * int thousand = (int) ithousand;
	 * 
	 * float ihundred = (val - (thousand * 1000));
	 * 
	 * int hundred = Math.abs((int) (ihundred));
	 * 
	 * String return_str = convert1(hundred);
	 * 
	 * // Check whether currency value is greater than thousand if (thousand != 0) {
	 * String str_thousand = convert1(thousand);
	 * 
	 * if (return_str == "") return_str = str_thousand + " Thousand"; else
	 * return_str = str_thousand + " Thousand  " + return_str;
	 * 
	 * }
	 * 
	 * // Check whether currency value is greater than million if (million != 0) {
	 * 
	 * String str_million = convert1(million); if (return_str == "") return_str =
	 * str_million + " million"; else return_str = str_million + " Million  " +
	 * return_str;
	 * 
	 * }
	 * 
	 * // Check whether currency value is greater than billion if (billion != 0) {
	 * 
	 * String str_billion = convert1(billion);
	 * 
	 * if (return_str == "") return_str = str_billion + " Billion"; else return_str
	 * = str_billion + " Billion  " + return_str;
	 * 
	 * } return return_str;
	 * 
	 * }
	 * 
	 * public String convert1(long value) { float ihundred; int ten; long val; val =
	 * value; String convert = null;
	 * 
	 * // Check if the amount is greater than hundred // if true append a string
	 * equalent to currency if (val > 99) { ihundred = val / 100; int hundred =
	 * (int) ihundred; val = (val - (hundred * 100)); String str_hundred = "";
	 * 
	 * if (hundred >= 1) str_hundred = convert1(hundred);
	 * 
	 * if (val == 0) convert = str_hundred + " Hundred ";
	 * 
	 * else convert = str_hundred + " Hundred " + convert1(val);
	 * 
	 * } else {
	 * 
	 * if (val > 19) { float iten = (val / 10); ten = (int) iten; val = (val - (ten
	 * * 10));
	 * 
	 * // Append string equalent to currency switch (ten) { case 2: convert =
	 * " Twenty " + convert1(val); break; case 3: convert = " Thirty " +
	 * convert1(val); break; case 4: convert = " Fourty " + convert1(val); break;
	 * case 5: convert = " Fifty " + convert1(val); break; case 6: convert =
	 * " Sixty " + convert1(val); break; case 7: convert = " Seventy " +
	 * convert1(val); break; case 8: convert = " Eighty " + convert1(val); break;
	 * case 9: convert = " Ninety " + convert1(val); break;
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * // Append string equalent to currency switch ((int) val) { case 1: convert =
	 * " One "; break; case 2: convert = " Two "; break; case 3: convert =
	 * " Three "; break; case 4: convert = " Four "; break; case 5: convert =
	 * " Five "; break; case 6: convert = " Six "; break; case 7: convert =
	 * " Seven "; break; case 8: convert = " Eight "; break; case 9: convert =
	 * " Nine "; break; case 10: convert = " Ten "; break; case 11: convert =
	 * " Eleven "; break; case 12: convert = " Twelve "; break; case 13: convert =
	 * " Thirteen "; break; case 14: convert = " Fourteen "; break; case 15: convert
	 * = " Fifteen "; break; case 16: convert = " Sixteen "; break; case 17: convert
	 * = " Seventeen "; break; case 18: convert = " Eighteen "; break; case 19:
	 * convert = " Nineteen "; break; default: convert = "";
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } return convert;
	 * 
	 * }
	 * 
	 * public String currencyInWords(double amount, String curr) {
	 * 
	 * String return_str = ""; // If the amount is zero then return string as 'zero'
	 * if (amount == 0) { return_str = "Zero"; } double dupAmount = amount; long
	 * intAmount = (long) amount; int fils = 0; String str_amount =
	 * inWords(intAmount); String str_fils = inWords(fils);
	 * 
	 * if (intAmount == 0) {
	 * 
	 * if (fils == 0) { return_str = "Zero"; } else { return_str = str_fils + ""; }
	 * 
	 * } else { if (fils == 0) { return_str = "(" + curr + str_amount + ")"; } else
	 * { return_str = "(" + curr + str_amount + " and " + fils + "/100 only)"; } }
	 * return return_str;
	 * 
	 * }
	 */
	/*
	 * private void getCompanyName(String invoiceNo, Invoice listInvoice) { try {
	 * JdbcTemplate jdbctemplate = new JdbcTemplate(dataSource); Invoice
	 * listInvoice1 =
	 * jdbctemplate.queryForObject(PurchaseCreditNoteQueryUtil.getCompanyAddres, new
	 * Object[] { invoiceNo }, new BeanPropertyRowMapper<>(Invoice.class));
	 * listInvoice.setFooterphno(listInvoice1.getFooterphno());
	 * listInvoice.setFooteraddr(listInvoice1.getFooteraddr());
	 * listInvoice.setFootermail(listInvoice1.getFootermail());
	 * listInvoice.setFaxno(listInvoice1.getFooterfaxno());
	 * listInvoice.setLocationName(listInvoice1.getLocationName());
	 * listInvoice.setComapnyName(listInvoice1.getComapnyName());
	 * listInvoice.setLocationId(listInvoice1.getLocationId());
	 * listInvoice.setInvoiceId(listInvoice1.getInvoiceId());
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	@Override
	public PurchaseCreditNoteBean getVesselVoyageDetail(String invoiceNumber) {
		PurchaseCreditNoteBean bean = new PurchaseCreditNoteBean();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] {};

			jdbcTemplate = new JdbcTemplate(dataSource);
			bean = jdbcTemplate.queryForObject(PurchaseCreditNoteQueryUtil.selectVoyageVesselByInvoice, new Object[] { invoiceNumber }, new

			BeanPropertyRowMapper<>(PurchaseCreditNoteBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the credit Note Records!", e);
		}

		return bean;
	}

	@Override
	public List<PurchaseCreditNoteBean> getSupplierCurExg(String sAcctHeadCode) {
		List<PurchaseCreditNoteBean> creditNoteList = new ArrayList<>();
		PurchaseCreditNoteBean bean = null;
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(PurchaseCreditNoteQueryUtil.sgetSupplierCurExg, new Object[] { sAcctHeadCode });

			for (Map row : rows) {
				bean = new PurchaseCreditNoteBean();
				bean.setCurrencyCode((String) row.get("currencyCode"));
				double exgRate = (((BigDecimal) row.get("exchangeRate")).doubleValue());
				bean.setExgRate(exgRate);

				creditNoteList.add(bean);

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in get Invoice Number", e);
		}
		return creditNoteList;
	}

	@Override
	public String reversePCN(PurchaseCreditNoteBean purchaseCreditNoteBean) {
		String sReceiptStatus = "";
		String sMessage = "";
		try {
			List<Map<String, Object>> RowData = jdbcTemplate.queryForList(PurchaseCreditNoteQueryUtil.GET_PCN_STATUS, new Object[] { purchaseCreditNoteBean.getCreditNoteNo() });
			for (Map<String, Object> row : RowData) {
				sReceiptStatus = (String) row.get("REVERSEBR");
			}

			if ("N".equalsIgnoreCase(sReceiptStatus)) {
				reverseReceiptRecord(purchaseCreditNoteBean);
				sMessage = "S";
			} else {
				sMessage = "F";
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Reverse receipt List", e);
		}
		return sMessage;
	}

	private void reverseReceiptRecord(PurchaseCreditNoteBean purchaseCreditNoteBean) {
		try {
			jdbcTemplate.update(PurchaseCreditNoteQueryUtil.UPDATE_PCN_STATUS, new Object[] { purchaseCreditNoteBean.getCreditNoteNo() });
			PurchaseCreditNoteBean objPurchaseCreditNoteBean = new PurchaseCreditNoteBean();

			objPurchaseCreditNoteBean = getCreditNoteForEdit(purchaseCreditNoteBean.getCreditNoteNo());
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();

			PurchaseCreditNoteBean objCashBankReceiptResultBean = ReversePCNtHdr(objPurchaseCreditNoteBean, userId, objPurchaseCreditNoteBean.getCompanyCode(), purchaseCreditNoteBean);
			/*
			 * String sJvNO = objPurchaseCreditNoteBean.getJvNo(); String newJVNo = ""; if
			 * (sJvNO != null && sJvNO != "") { newJVNo = ReverseJV(sJvNO, voucherBean);
			 * jdbcTemplate.update(CashBankReceiptQueryUtil .UPDATE_JVNO_CASHBANK_HDR, new
			 * Object[] { newJVNo, objCashBankReceiptResultBean.getsReceiptCode() }); }
			 */
			jdbcTemplate.update(PurchaseCreditNoteQueryUtil.UPDATE_ACTUALNO_PCN_HDR, new Object[] { objCashBankReceiptResultBean.getCreditNoteNo(), purchaseCreditNoteBean.getCreditNoteNo() });

		} catch (DataAccessException | ParseException p) {
			LOGGER.error("Error in Get Currency List", p);
		}
	}

	public PurchaseCreditNoteBean ReversePCNtHdr(PurchaseCreditNoteBean objPurchaseCreditNoteBean, String userId, String companyCode, PurchaseCreditNoteBean purchaseCreditNoteBean) throws ParseException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseCreditNoteBean alCreditNoteList = new PurchaseCreditNoteBean();
		PurchaseCreditNoteBean bean = null;
		String sCompanyCode = objPurchaseCreditNoteBean.getCompanyCode(), sLocnName = "";
		try {

			jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> locnNameRows = jdbcTemplate.queryForList(PurchaseCreditNoteQueryUtil.sGetLocationWithInvoiceNo, new Object[] { objPurchaseCreditNoteBean.getCompanyCode() });
			for (Map row : locnNameRows) {
				sLocnName = (String) row.get("LOCATION");
			}
			String creditNoteNo = generateCreditNoteNumber_Direct(sLocnName, purchaseCreditNoteBean.getPcnDate());
			String creditNoteDate = objPurchaseCreditNoteBean.getCreditNoteDate();
			String acctHeadCode = objPurchaseCreditNoteBean.getAccountName();
			String invoiceNo = objPurchaseCreditNoteBean.getInvoiceNo();
			String invoiceDt = objPurchaseCreditNoteBean.getInvoiceDate();
			String currencyCode = objPurchaseCreditNoteBean.getCurrencyCode();
			double exchangeRate = objPurchaseCreditNoteBean.getExgRate();
			String narration = objPurchaseCreditNoteBean.getNarration();
			String voyage = objPurchaseCreditNoteBean.getVoyageId();
			String creditNoteRefNo = objPurchaseCreditNoteBean.getCreditNoteNo();
			String mainAcctCode = AccountsConstants.TRADE_CREDITORS_AH;
			String mainSubGroupCode = AccountsConstants.TRADE_CREDITORS_SG;
			objPurchaseCreditNoteBean.setCreditNoteNo(creditNoteNo);
			objPurchaseCreditNoteBean.setTcAmount(-objPurchaseCreditNoteBean.getTcAmount());
			objPurchaseCreditNoteBean.setBcAmount(-objPurchaseCreditNoteBean.getBcAmount());

			String sRefNo = getRefernceNo(objPurchaseCreditNoteBean.getCompanyCode(), purchaseCreditNoteBean.getCreditNoteNo());
			objPurchaseCreditNoteBean.setRefNo(sRefNo);
			int iCNHdr = jdbcTemplate.update(PurchaseCreditNoteQueryUtil.saveCreditNoteData, new Object[] { creditNoteNo, purchaseCreditNoteBean.getPcnDate(), acctHeadCode, currencyCode, exchangeRate, invoiceNo, narration + "_Reversal", sCompanyCode, userId, "N", voyage, objPurchaseCreditNoteBean.getBcAmount(), objPurchaseCreditNoteBean.getTcAmount(), mainAcctCode, mainSubGroupCode, creditNoteRefNo, sRefNo });

			alCreditNoteList.setCreditNoteNo(creditNoteNo);
			alCreditNoteList.setJvNo(objPurchaseCreditNoteBean.getJvNo());
			objPurchaseCreditNoteBean.setCreditNoteNo(creditNoteNo);
			objPurchaseCreditNoteBean.setCreditNoteDate(purchaseCreditNoteBean.getPcnDate());

			if (iCNHdr > 0) {
				UserLog userLog = userlogDao.userLogForInsert(objPurchaseCreditNoteBean, purchaseCreditNoteBean.getCreditNoteNo(), userDetails.getUserId());
				auditLogDao.auditLogForInsert(objPurchaseCreditNoteBean, userLog, null);
				// savecreditHeaderProcedureCall(objPurchaseCreditNoteBean,
				// "save");
				// saveReverseCreditNoteDetail(objPurchaseCreditNoteBean,
				// creditNoteNo, jdbcTemplate, currencyCode, exchangeRate);
			}

			// objCreditNoteBean.setCreditNoteCode(creditNoteNo);
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Records!", e);
		}

		// alCreditNoteList.add(objCreditNoteBean);

		return alCreditNoteList;
	}

	@Override
	public boolean updateCRData(PurchaseCreditNoteBean objCreditNoteBean, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * private void saveReverseCreditNoteDetail(PurchaseCreditNoteBean
	 * objCreditNoteBean, String creditNoteNo, JdbcTemplate jdbcTemplate, String
	 * currencyCode, double exchangeRate) { UserDetail userDetails = (UserDetail)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
	 * userId = userDetails.getUserId(); boolean isInterCompanyTransaction = false;
	 * try { boolean flag = false; List<JournalVoucherBean> lJournalVoucherList =
	 * new ArrayList<>(); List<PuchaseCreditNoteDetailBean> crTableData =
	 * objCreditNoteBean.getCredittables(); for (PuchaseCreditNoteDetailBean
	 * objCreditNoteDetailBean : crTableData) { if
	 * (!(objCreditNoteBean.getCompanyCode
	 * ().equals(objCreditNoteDetailBean.getCompany_id_dtl()))) { JournalVoucherBean
	 * objJournalVoucherCreditBean = new JournalVoucherBean();
	 * isInterCompanyTransaction = true; String creditaccount = ""; String
	 * debitaccount = ""; String debitnarration = ""; String creditnarration = "";
	 * List<Map<String, Object>> rowsdata =
	 * jdbcTemplate.queryForList(CashBankReceiptQueryUtil.GET_ACCOUNT_INTRA, new
	 * Object[] { objCreditNoteDetailBean.getCompany_id_dtl() }); for (Map row :
	 * rowsdata) { debitaccount = String.valueOf(row.get("account_head"));
	 * debitnarration = String.valueOf(row.get("intra_name")); }
	 * 
	 * List<Map<String, Object>> rowsdata1 =
	 * jdbcTemplate.queryForList(CashBankReceiptQueryUtil.GET_ACCOUNT_INTRA, new
	 * Object[] { objCreditNoteBean.getCompanyCode() }); for (Map row : rowsdata1) {
	 * creditaccount = String.valueOf(row.get("account_head")); creditnarration =
	 * String.valueOf(row.get("intra_name")); }
	 * 
	 * // credit entry objJournalVoucherCreditBean.setAccountCode(creditaccount);
	 * objJournalVoucherCreditBean
	 * .setCurrency(objCreditNoteDetailBean.getCurrency());
	 * objJournalVoucherCreditBean
	 * .setExchangeRate(objCreditNoteDetailBean.getExchangeRate());
	 * objJournalVoucherCreditBean.setTcDebitAmount(0.0);
	 * objJournalVoucherCreditBean
	 * .setNarration(AccountsConstants.SYSTEM_BALANCE_TRANSACION + " - " +
	 * creditnarration);
	 * objJournalVoucherCreditBean.setTcCreditAmount(objCreditNoteDetailBean
	 * .getTcamount());
	 * objJournalVoucherCreditBean.setDepartmentCode(objCreditNoteDetailBean
	 * .getDepartmentCode());
	 * objJournalVoucherCreditBean.setVoyageCode(objCreditNoteDetailBean
	 * .getVoyageCode());
	 * objJournalVoucherCreditBean.setVesselCode(objCreditNoteDetailBean
	 * .getVesselCode());
	 * objJournalVoucherCreditBean.setSectorCode(objCreditNoteDetailBean
	 * .getSectorCode());
	 * objJournalVoucherCreditBean.setSubGroupAccount(AccountsConstants
	 * .INTER_COMPANY_MANAGING_ACCOUNTS_SG);
	 * objJournalVoucherCreditBean.setBcDebitAmount(0.0);
	 * objJournalVoucherCreditBean
	 * .setBcCreditAmount(objCreditNoteDetailBean.getBcamount()); //
	 * objJournalVoucherCreditBean
	 * .setSubAccountCode(objPurchaseInvoiceDetailBean.getSubAccountCode());
	 * objJournalVoucherCreditBean
	 * .setEmployeeCode(objCreditNoteDetailBean.getEmployeeCode());
	 * objJournalVoucherCreditBean
	 * .setPortCode(objCreditNoteDetailBean.getPortCode());
	 * objJournalVoucherCreditBean
	 * .setAgentCode(objCreditNoteDetailBean.getAgentCode());
	 * objJournalVoucherCreditBean
	 * .setCountryCode(objCreditNoteDetailBean.getCountryCode());
	 * objJournalVoucherCreditBean
	 * .setCustomerCode(objCreditNoteDetailBean.getCustomerCode());
	 * objJournalVoucherCreditBean
	 * .setSupplierCode(objCreditNoteDetailBean.getSupplierCode());
	 * objJournalVoucherCreditBean
	 * .setDesignationCode(objCreditNoteDetailBean.getDesignationCode());
	 * objJournalVoucherCreditBean
	 * .setCompanyCode(objCreditNoteDetailBean.getCompany_id_dtl());
	 * objJournalVoucherCreditBean
	 * .setCostCenter(objCreditNoteDetailBean.getCostCenter());
	 * objJournalVoucherCreditBean
	 * .setQuantityGO(objCreditNoteDetailBean.getQuantityGO());
	 * objJournalVoucherCreditBean
	 * .setQuantityFO(objCreditNoteDetailBean.getQuantityFO());
	 * objJournalVoucherCreditBean
	 * .setPortSequence(objCreditNoteDetailBean.getPortSequence());
	 * objJournalVoucherCreditBean
	 * .setAssetCode(objCreditNoteDetailBean.getAssetCode());
	 * lJournalVoucherList.add(objJournalVoucherCreditBean);
	 * 
	 * // debit entry JournalVoucherBean objJournalVoucherDebitBean = new
	 * JournalVoucherBean();
	 * 
	 * objJournalVoucherDebitBean.setAccountCode(debitaccount);
	 * objJournalVoucherDebitBean
	 * .setCurrency(objCreditNoteDetailBean.getCurrency());
	 * objJournalVoucherDebitBean
	 * .setExchangeRate(objCreditNoteDetailBean.getExchangeRate());
	 * objJournalVoucherDebitBean
	 * .setTcDebitAmount(objCreditNoteDetailBean.getTcamount());
	 * objJournalVoucherDebitBean
	 * .setNarration(AccountsConstants.SYSTEM_BALANCE_TRANSACION + " - " +
	 * debitnarration); objJournalVoucherDebitBean.setTcCreditAmount(0.0);
	 * objJournalVoucherDebitBean
	 * .setDepartmentCode(objCreditNoteDetailBean.getDepartmentCode());
	 * objJournalVoucherDebitBean
	 * .setVoyageCode(objCreditNoteDetailBean.getVoyageCode());
	 * objJournalVoucherDebitBean
	 * .setVesselCode(objCreditNoteDetailBean.getVesselCode());
	 * objJournalVoucherDebitBean
	 * .setSectorCode(objCreditNoteDetailBean.getSectorCode());
	 * objJournalVoucherDebitBean
	 * .setSubGroupAccount(AccountsConstants.INTER_COMPANY_MANAGING_ACCOUNTS_SG );
	 * objJournalVoucherDebitBean.setBcDebitAmount(objCreditNoteDetailBean.
	 * getBcamount()); objJournalVoucherDebitBean.setBcCreditAmount(0.0); //
	 * objJournalVoucherDebitBean
	 * .setSubAccountCode(objPurchaseInvoiceDetailBean.getSubAccountCode());
	 * objJournalVoucherDebitBean
	 * .setEmployeeCode(objCreditNoteDetailBean.getEmployeeCode());
	 * objJournalVoucherDebitBean
	 * .setPortCode(objCreditNoteDetailBean.getPortCode());
	 * objJournalVoucherDebitBean
	 * .setAgentCode(objCreditNoteDetailBean.getAgentCode());
	 * objJournalVoucherDebitBean
	 * .setCountryCode(objCreditNoteDetailBean.getCountryCode());
	 * objJournalVoucherDebitBean
	 * .setCustomerCode(objCreditNoteDetailBean.getCustomerCode());
	 * objJournalVoucherDebitBean
	 * .setSupplierCode(objCreditNoteDetailBean.getSupplierCode());
	 * objJournalVoucherDebitBean
	 * .setDesignationCode(objCreditNoteDetailBean.getDesignationCode());
	 * objJournalVoucherDebitBean
	 * .setCompanyCode(objCreditNoteBean.getCompanyCode());
	 * objJournalVoucherDebitBean
	 * .setCostCenter(objCreditNoteDetailBean.getCostCenter());
	 * objJournalVoucherDebitBean
	 * .setQuantityGO(objCreditNoteDetailBean.getQuantityGO());
	 * objJournalVoucherDebitBean
	 * .setQuantityFO(objCreditNoteDetailBean.getQuantityFO());
	 * objJournalVoucherDebitBean
	 * .setPortSequence(objCreditNoteDetailBean.getPortSequence());
	 * objJournalVoucherCreditBean
	 * .setAssetCode(objCreditNoteDetailBean.getAssetCode());
	 * lJournalVoucherList.add(objJournalVoucherDebitBean); }
	 * 
	 * jdbcTemplate.update( PurchaseCreditNoteQueryUtil.saveCreditNoteDetailData,
	 * new Object[] { creditNoteNo, objCreditNoteDetailBean.getCrdtlAccountHead(),
	 * objCreditNoteDetailBean.getCurrency(),
	 * objCreditNoteDetailBean.getExchangeRate(),
	 * -objCreditNoteDetailBean.getTcamount(),
	 * objCreditNoteDetailBean.getNarration(),
	 * -objCreditNoteDetailBean.getBcamount(), objCreditNoteDetailBean.getSlNo(),
	 * objCreditNoteDetailBean.getCrdtlAccountHead().substring(0, 4),
	 * objCreditNoteDetailBean.getSubAcctCode(),
	 * objCreditNoteDetailBean.getEmployeeCode(),
	 * objCreditNoteDetailBean.getPortCode(),
	 * objCreditNoteDetailBean.getAgentCode(),
	 * objCreditNoteDetailBean.getCountryCode(),
	 * objCreditNoteDetailBean.getCustomerCode(),
	 * objCreditNoteDetailBean.getSupplierCode(),
	 * objCreditNoteDetailBean.getDesignationCode(),
	 * objCreditNoteDetailBean.getCompanyCode(),
	 * objCreditNoteDetailBean.getCostCenter(),
	 * objCreditNoteDetailBean.getQuantityGO(),
	 * objCreditNoteDetailBean.getQuantityFO(),
	 * objCreditNoteDetailBean.getPortSequence(),
	 * objCreditNoteDetailBean.getDepartmentCode(),
	 * objCreditNoteDetailBean.getVoyageCode(),
	 * objCreditNoteDetailBean.getVesselCode(),
	 * objCreditNoteDetailBean.getSectorCode(),
	 * objCreditNoteDetailBean.getCompany_id_dtl(), objCreditNoteBean.getRefNo() });
	 * 
	 * UserLog userLog = userlogDao.userLogForInsert(objCreditNoteDetailBean,
	 * creditNoteNo, userDetails.getUserId());
	 * auditLogDao.auditLogForInsert(objCreditNoteDetailBean, userLog, null); } //
	 * Auto generated jv for inter-company transaction if
	 * (isInterCompanyTransaction) { try { String journalNumber =
	 * generateJournalVoucherNumber_Direct(objCreditNoteBean.getCompanyCode(),
	 * objCreditNoteBean.getCreditNoteDate()); String journalRefNo =
	 * getJournalRefernceNo(objCreditNoteBean.getCompanyCode(), journalNumber); int
	 * iJvHdr =
	 * jdbcTemplate.update(PurchaseCreditNoteQueryUtil.ADD_JOURNAL_VOUCHER_HEADER ,
	 * new Object[] { journalNumber, objCreditNoteBean.getCreditNoteDate(),
	 * AccountsConstants.SYSTEM_BALANCE_TRANSACION, userId,
	 * objCreditNoteBean.getCompanyCode(), journalRefNo });
	 * 
	 * int iJvDtlCount = 1; for (JournalVoucherBean objJournalVoucherBean :
	 * lJournalVoucherList) {
	 * jdbcTemplate.update(PurchaseCreditNoteQueryUtil.ADD_JOURNAL_VOUCHER_DTL, new
	 * Object[] { journalNumber, objJournalVoucherBean.getAccountCode(),
	 * objJournalVoucherBean.getCurrency(), objJournalVoucherBean.getExchangeRate(),
	 * -objJournalVoucherBean.getTcDebitAmount(),
	 * -objJournalVoucherBean.getTcCreditAmount(),
	 * objJournalVoucherBean.getNarration(),
	 * objJournalVoucherBean.getDepartmentCode(),
	 * objJournalVoucherBean.getVoyageCode(), objJournalVoucherBean.getVesselCode(),
	 * objJournalVoucherBean.getSectorCode(),
	 * objJournalVoucherBean.getAccountCode().substring(0, 4),
	 * -objJournalVoucherBean.getBcDebitAmount(),
	 * -objJournalVoucherBean.getBcCreditAmount(), iJvDtlCount,
	 * objJournalVoucherBean.getSubAccountCode(),
	 * objJournalVoucherBean.getEmployeeCode(), objJournalVoucherBean.getPortCode(),
	 * objJournalVoucherBean.getAgentCode(), objJournalVoucherBean.getCountryCode(),
	 * objJournalVoucherBean.getCustomerCode(),
	 * objJournalVoucherBean.getSupplierCode(),
	 * objJournalVoucherBean.getDesignationCode(),
	 * objJournalVoucherBean.getCompanyCode(),
	 * objJournalVoucherBean.getCostCenter(), objJournalVoucherBean.getQuantityGO(),
	 * objJournalVoucherBean.getQuantityFO(),
	 * objJournalVoucherBean.getPortSequence(), journalRefNo,
	 * objJournalVoucherBean.getAssetCode() });
	 * 
	 * iJvDtlCount++; }
	 * 
	 * // updating Purchase Invoice hdr table- for relating jv.no
	 * 
	 * jdbcTemplate.update(PurchaseCreditNoteQueryUtil.UPDATE_JVNO_PCN_HDR, new
	 * Object[] { journalNumber, creditNoteNo });
	 * 
	 * } catch (Exception e) { flag = false; e.printStackTrace(); } } } catch
	 * (DataAccessException e) {
	 * LOGGER.error("Error in save the Credit Note Detail Records!", e); } }
	 */

}