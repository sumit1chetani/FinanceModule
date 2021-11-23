package com.dci.tenant.finance.cashbankpayment;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.AccountsConstants;
import com.dci.common.util.BasicResultBean;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.NumberstoWordsConversion;
import com.dci.tenant.finance.cashbankreceipt.CashBankReceiptListBean;
import com.dci.tenant.finance.cashbankreceipt.CashBankReceiptResultBean;
import com.dci.tenant.finance.paymentReport.PaymentHistoryReportBean;
import com.dci.tenant.user.UserDetail;

@Repository
public class CashBankPaymentDAOImpl implements CashBankPaymentDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(CashBankPaymentDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	static int chequeStatus = 180;
	NumberstoWordsConversion wordingConversion;

	@Override
	public List<CashBankPaymentBean> getBankAcctList(String sPaymentType) {
		List<CashBankPaymentBean> lBankAcctList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			if (sPaymentType.equalsIgnoreCase("bank")) {
				lBankAcctList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_BANK_ACCOUNT_HEAD_LIST_DUBAI,
						new Object[] { AccountsConstants.BANK_SG },
						new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

			} else if (sPaymentType.equalsIgnoreCase("cash")) {
				lBankAcctList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_CASH_ACCOUNT_HEAD_LIST_DUBAI,
						new Object[] {}, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

			} else if (sPaymentType.equalsIgnoreCase("bankreco")) {
				lBankAcctList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_BANK_ACCOUNT_HEAD_LIST_RECO,
						new Object[] {}, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctList;
	}

	@Override
	public List<CashBankPaymentBean> getBankAcctListcom(String companyName) {
		List<CashBankPaymentBean> lBankAcctListcom = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcom = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_BANK_COMPANY,
					new Object[] { companyName }, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcom;
	}

	@Override
	public List<CashBankPaymentBean> getBankAcctListcompanyNew(String companyName) {
		List<CashBankPaymentBean> lBankAcctListcom = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcom = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_BANK_COMPANY_NEW,
					new Object[] { companyName }, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcom;
	}

	@Override
	public List<CashBankPaymentBean> getCashAcctListcompanyNew(String companyName) {
		List<CashBankPaymentBean> lBankAcctListcom = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcom = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_BANK_COMPANY_NEW_CASH,
					new Object[] { companyName }, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcom;
	}

	@Override
	public List<CashBankPaymentBean> getsubacct(String cbpdtlAccountHead) {
		List<CashBankPaymentBean> lBankAcctListcom = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcom = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_SUBEMP,
					new Object[] { cbpdtlAccountHead }, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcom;
	}

	@Override
	public List<CashBankPaymentBean> getBankAcctListcompanycode(String companyCode) {
		List<CashBankPaymentBean> lBankAcctListcompany = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcompany = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_BANK_COMPANY,
					new Object[] { companyCode }, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcompany;
	}

	@Override
	public List<CashBankPaymentBean> subAccountCodeList() {
		List<CashBankPaymentBean> lBankAcctListcompany = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcompany = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_SUPPLIER, new Object[] {},
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcompany;
	}

	@Override
	public List<CashBankPaymentBean> getExchangeRateWithCurrency(String sCurrencyCode) {
		List<CashBankPaymentBean> lCurExgRatList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCurExgRatList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_EXCHANGE_RATE_WITH_CURRENCY,
					new Object[] { sCurrencyCode }, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lCurExgRatList;
	}

	@Override
	public List<CashBankPaymentBean> getVoyageList() {
		List<CashBankPaymentBean> lCurExgRatList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCurExgRatList = jdbcTemplate.query(CashBankPaymentQueryUtil.getVoyageVesselSectorList,
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lCurExgRatList;
	}

	@Override
	public List<CashBankPaymentBean> getPaymentOrderNoList() {
		List<CashBankPaymentBean> lPmtOrderNoList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lPmtOrderNoList = jdbcTemplate.query(CashBankPaymentQueryUtil.getPmtOrderNoList,
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lPmtOrderNoList;
	}

	// stage 1 CBP
	@Override
	public List<CashBankPaymentBean> saveCashBankPmtData(CashBankPaymentBean objCashBankPaymentBean, String userId,
			String companyCode) {
		List<CashBankPaymentBean> alCBPmtList = new ArrayList<>();
		CashBankPaymentBean bean = null;
		boolean isSuccess = false;
		String sCompanyCode = "", sLocnName = "", pmtType = "";
		Date chequeDate = null;
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			// String cbVoucherNo =
			// generateCashbankPaymentCode(objCashBankPaymentBean.getPmtType(),
			// objCashBankPaymentBean);
			// objCashBankPaymentBean.setCbVoucherNo(cbVoucherNo);

			Date voucherDate = CommonUtil.convertSqlDateFormat(objCashBankPaymentBean.getCashbankPmtDate());

			if (objCashBankPaymentBean.getPmtType().equalsIgnoreCase("bank")) {
				pmtType = "B";
				chequeDate = CommonUtil.convertSqlDateFormat(objCashBankPaymentBean.getChequeDate());
			} else if (objCashBankPaymentBean.getPmtType().equalsIgnoreCase("cash")) {
				pmtType = "C";
				chequeDate = null;
			}

			companyCode = objCashBankPaymentBean.getCompanyName();

			String acctName = objCashBankPaymentBean.getAccountName();
			String currCode = objCashBankPaymentBean.getCurrencyCode();
			double exchangeRate = objCashBankPaymentBean.getExchangeRate();
			String chequeNo = objCashBankPaymentBean.getChequeNo();

			double bcAmtHdr = objCashBankPaymentBean.getBcAmountHdr();
			double tcAmtHdr = objCashBankPaymentBean.getTcAmountHdr();
			String narration = "test";
			String approvenote = "";

			if (objCashBankPaymentBean.getApprovenote() != null
					&& !"".equalsIgnoreCase(objCashBankPaymentBean.getApprovenote()))
				approvenote = objCashBankPaymentBean.getApprovenote();
			else
				approvenote = "";

			if (objCashBankPaymentBean.getNarration() != null
					&& !"".equalsIgnoreCase(objCashBankPaymentBean.getNarration()))
				narration = objCashBankPaymentBean.getNarration();
			else
				narration = "";

			String paidTo = objCashBankPaymentBean.getPaidTo();
			System.out.println("voucher No ===== " + objCashBankPaymentBean.getCbVoucherNo1());
			System.out.println("voucher No ===== " + objCashBankPaymentBean.getCbVoucherNo());
			int iSave = jdbcTemplate.update(CashBankPaymentQueryUtil.SAVE_CASH_BANK_PMT_HDR,
					new Object[] { objCashBankPaymentBean.getCbVoucherNo(), voucherDate, pmtType, acctName,
							exchangeRate, chequeNo, chequeDate, bcAmtHdr, tcAmtHdr, narration, userId, paidTo,
							companyCode, objCashBankPaymentBean.getCostCenter(),
							objCashBankPaymentBean.getCashdenomination(), approvenote });
			if (iSave > 0) {

				HashMap<String, Object> chqBookMap = new HashMap<>();

				if (!objCashBankPaymentBean.getChequeDate().isEmpty()) {
					chqBookMap.put("chequeDate", objCashBankPaymentBean.getChequeDate());
					chqBookMap.put("narration", narration);
					chqBookMap.put("chequeStatus", 179);
					chqBookMap.put("bcAmountHdr", objCashBankPaymentBean.getBcAmountHdr());
					chqBookMap.put("chqBookId", chequeNo);
					// namedParameterJdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_CHQ_BOOK,
					// chqBookMap);
				}

				objCashBankPaymentBean.setCbVoucherNo(objCashBankPaymentBean.getCbVoucherNo());
				isSuccess = saveCashBankPmtDetail(objCashBankPaymentBean, objCashBankPaymentBean.getCbVoucherNo());
				isSuccess = saveCashBankPmtDetailcash(objCashBankPaymentBean, objCashBankPaymentBean.getCbVoucherNo());

			}
			if (isSuccess == false) {
				isSuccess = saveCBPmtGeneralLedgerCreditEntry(objCashBankPaymentBean);
				isSuccess = saveCBPmtGeneralLedgerDebitEntry(objCashBankPaymentBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Cash Bank Payment Records!", e);
		}

		alCBPmtList.add(objCashBankPaymentBean);

		return alCBPmtList;
	}

	// stage 2 CBP
	private boolean saveCashBankPmtDetail(CashBankPaymentBean objCashBankPaymentBean, String cbVoucherNo) {
		boolean flag = false;
		try {
			int iCounter = 1;
			
			List<CashBankPaymentDetailBean> cbpmtTableData = objCashBankPaymentBean.getCbptables();
			for (CashBankPaymentDetailBean objCashBankPaymentDetailBean : cbpmtTableData) {
				
			 	objCashBankPaymentDetailBean.getCbpdtlPmtOrderNo();
				objCashBankPaymentDetailBean.getCbpdtlCurrencyCode();
				objCashBankPaymentDetailBean.getCbpdtlExgRate();
				objCashBankPaymentDetailBean.getCbpDtlBcAmount();
				objCashBankPaymentDetailBean.getCbpDtlTcAmount();
				
				objCashBankPaymentDetailBean.setCbpdtlAccountHead(objCashBankPaymentDetailBean.getCbdtlsubAccountCode());
				objCashBankPaymentDetailBean.setCbdtlsubAccountCode(objCashBankPaymentDetailBean.getCbdtlsubAccountCode());

				//System.out.println("Account Head 2 = " + objCashBankPaymentDetailBean.getCbdtlsubAccountCode());
				objCashBankPaymentDetailBean.getCbdtlsubAccountCode();

				//System.out.println("Account Head 3 = " + objCashBankPaymentDetailBean.getCbpdtlAccountHead());
				objCashBankPaymentDetailBean.getCbpdtlAccountHead().substring(0, 4);

				objCashBankPaymentDetailBean.getCostCenter();
				objCashBankPaymentDetailBean.getPurInvoiceNo();

				//System.out.println("Account Head 4= " + objCashBankPaymentDetailBean.getBudgetDefnId());
				objCashBankPaymentDetailBean.getBudgetDefnId();

				//System.out.println("Account Head 5 = " + objCashBankPaymentDetailBean.getCbpdtlpaymentHead());
				objCashBankPaymentDetailBean.getCbpdtlpaymentHead();

				int slNo = iCounter;

				Object[] params = new Object[] { cbVoucherNo, objCashBankPaymentDetailBean.getCbpdtlAccountHead(),
						objCashBankPaymentDetailBean.getPurInvoiceNo(), "INR",
						objCashBankPaymentDetailBean.getCbpdtlExgRate(),
						objCashBankPaymentDetailBean.getCbpDtlBcAmount(),
						objCashBankPaymentDetailBean.getCbpDtlTcAmount(),
						objCashBankPaymentDetailBean.getDepartmentCode(),
						objCashBankPaymentDetailBean.getCbpdtlAccountHead().substring(0, 4), slNo,
						objCashBankPaymentDetailBean.getCbdtlsubAccountCode(),
						objCashBankPaymentDetailBean.getEmployeeCode(), objCashBankPaymentDetailBean.getCountryCode(),
						objCashBankPaymentDetailBean.getCustomerCode(), objCashBankPaymentDetailBean.getSupplierCode(),
						objCashBankPaymentDetailBean.getDesignationCode(),
						objCashBankPaymentDetailBean.getCompanyCode(), objCashBankPaymentDetailBean.getCostCenter(),
						objCashBankPaymentDetailBean.getPatientCode(), objCashBankPaymentDetailBean.getBudgetDefnId(),
						objCashBankPaymentDetailBean.getCbpdtlPmtOrderNo(),
						objCashBankPaymentDetailBean.getCbpdtlpaymentHead() };

				int iCbpDtl = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.SAVE_CASH_BANK_PMT_DTL, params,
						Integer.class);

				if (iCbpDtl > 0) {
					objCashBankPaymentDetailBean.setCashBankPmtDtlId(iCbpDtl);
					List<CashBankPaymentInvoiceDetailBean> cbpmtInvoiceData = objCashBankPaymentDetailBean
							.getInvoicePaymentList();
					for (CashBankPaymentInvoiceDetailBean objCBPmtInvDtlBean : cbpmtInvoiceData) {

						if (!"".equalsIgnoreCase(checkEmptyString(objCBPmtInvDtlBean.getInvoiceNo()))) {
							objCBPmtInvDtlBean.setpInvoiceNo(objCBPmtInvDtlBean.getInvoiceNo());
						}
						if (objCBPmtInvDtlBean.getBcAmount() != 0) {
							objCBPmtInvDtlBean.setBcInvAmt(objCBPmtInvDtlBean.getBcAmount());
						}
						if (objCBPmtInvDtlBean.getBcAmount() != 0) {
							objCBPmtInvDtlBean.setTcInvAmt(objCBPmtInvDtlBean.getBcAmount());
						}
						if (!"".equalsIgnoreCase(checkEmptyString(objCBPmtInvDtlBean.getPaidBCAmount()))
								&& !"0".equalsIgnoreCase(checkEmptyString(objCBPmtInvDtlBean.getPaidBCAmount()))) {
							objCBPmtInvDtlBean.setBcPaidAmt(Double.valueOf(objCBPmtInvDtlBean.getPaidBCAmount()));
						}
						if (!"".equalsIgnoreCase(checkEmptyString(objCBPmtInvDtlBean.getPaidBCAmount()))
								&& !"0".equalsIgnoreCase(checkEmptyString(objCBPmtInvDtlBean.getPaidBCAmount()))) {
							objCBPmtInvDtlBean.setTcPaidAmt(Double.valueOf(objCBPmtInvDtlBean.getPaidBCAmount()));
						}
						flag = saveCashBankPmtInvoiceDetail(objCashBankPaymentBean, objCashBankPaymentDetailBean,
								objCBPmtInvDtlBean);
						if (flag)
							updatePurchaseInvoicePaymentStatus(objCBPmtInvDtlBean.getCurrency(),
									objCBPmtInvDtlBean.getBcPaidAmt(), objCBPmtInvDtlBean.getTcPaidAmt(),
									objCBPmtInvDtlBean.getBcBalanceAmt(), objCBPmtInvDtlBean.getTcBalanceAmt(),
									objCBPmtInvDtlBean.getpInvoiceNo());
					}
				}
				if (iCbpDtl > 0)
					flag = true;
				iCounter++;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Detail Records!", e);
		}
		return flag;
	}

	// stage 3
	private boolean saveCashBankPmtDetailcash(CashBankPaymentBean objCashBankPaymentBean, String cbVoucherNo) {
		boolean flag = false;
		try {
			int iCounter = 1;
			List<CashBankPaymentDetailBean> cbpmtTableDatacash = objCashBankPaymentBean.getCbptablescash();
			for (CashBankPaymentDetailBean objCashBankPaymentDetailBean : cbpmtTableDatacash) {
				objCashBankPaymentDetailBean.getDenomAmt();
				objCashBankPaymentDetailBean.getCountamt();
				objCashBankPaymentDetailBean.getRupessAmt();

				int slNo = iCounter;

				Object[] params = new Object[] { cbVoucherNo, objCashBankPaymentDetailBean.getDenomAmt(),
						objCashBankPaymentDetailBean.getCountamt(), objCashBankPaymentDetailBean.getRupessAmt() };

				int iCbpDtlcas = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.SAVE_CASH_BANK_PMT_DTL_cash,
						params, Integer.class);

				if (iCbpDtlcas > 0)
					flag = true;
				iCounter++;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Credit Note Detail Records!", e);
		}
		return flag;
	}

	public static String checkEmptyString(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null")) {
			return "";
		} else {
			return s1;
		}
	}

	private boolean saveCashBankPmtInvoiceDetail(CashBankPaymentBean objCashBankPaymentBean,
			CashBankPaymentDetailBean objCashBankPaymentDetailBean,
			CashBankPaymentInvoiceDetailBean objCBPmtInvDtlBean) {
		boolean isSuccess = false;
		try {

			int iCbpInvDtl = jdbcTemplate.update(CashBankPaymentQueryUtil.SAVE_CASH_BANK_PMT_INVOICE_DTL,
					new Object[] { objCashBankPaymentDetailBean.getCashBankPmtDtlId(),
							objCBPmtInvDtlBean.getpInvoiceNo(), objCBPmtInvDtlBean.getBcInvAmt(),
							objCBPmtInvDtlBean.getTcInvAmt(), objCBPmtInvDtlBean.getBcPaidAmt(),
							objCBPmtInvDtlBean.getTcPaidAmt(), objCBPmtInvDtlBean.getCurrency(),
							objCBPmtInvDtlBean.getExchangeRate() });
			if (iCbpInvDtl > 0)
				isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
		return isSuccess;
	}

	private void updatePurchaseInvoicePaymentStatus(String currency, Double bcPaidAmt, Double tcPaidAmt,
			Double bcBalanceAmt, Double tcBalanceAmt, String sPInvoiceNo) {
		double amount = 0;
		String pmtStatus = "";
		try {
			if ("INR".equalsIgnoreCase(currency)) {
				if (bcBalanceAmt == null) {
					bcBalanceAmt = 0.0;
				}
				amount = bcBalanceAmt - bcPaidAmt;

				if (amount <= 0.0) {
					pmtStatus = "Fully Paid";
				} else {
					pmtStatus = "Part Paid";
				}

				jdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_PAYMENT_STATUS_PIN_HDR,
						new Object[] { pmtStatus, sPInvoiceNo });

			} else if (!"INR".equalsIgnoreCase(currency)) {
				amount = tcBalanceAmt - tcPaidAmt;

				if (amount <= 0.0) {
					pmtStatus = "Fully Paid";
				} else {
					pmtStatus = "Part Paid";
				}

				jdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_PAYMENT_STATUS_PIN_HDR,
						new Object[] { pmtStatus, sPInvoiceNo });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
	}

	/**
	 * HEADER Credit Entry
	 * 
	 * @param objCashBankPaymentBean
	 * @return
	 */
	private boolean saveCBPmtGeneralLedgerCreditEntry(CashBankPaymentBean objCashBankPaymentBean) {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(CashBankPaymentQueryUtil.INSERT_GENERAL_LEDGER_CREDIT_ENTRY_PAYMENT,
					new Object[] { objCashBankPaymentBean.getCbVoucherNo() });
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
		return isSuccess;
	}

	/**
	 * DETAIL - Debit Entry
	 * 
	 * @param objCashBankPaymentBean
	 * @return
	 */
	private boolean saveCBPmtGeneralLedgerDebitEntry(CashBankPaymentBean objCashBankPaymentBean) {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(CashBankPaymentQueryUtil.INSERT_GENERAL_LEDGER_DEBIT_ENTRY_PAYMENT,
					new Object[] { objCashBankPaymentBean.getCbVoucherNo() });
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
		return isSuccess;
	}

	/**
	 * generate Voucher No based on company Location........
	 * 
	 * @param sLocnName
	 * @return
	 */
	private String generateCashbankPaymentCode(String pmtType, CashBankPaymentBean objCashBankPaymentBean) {
		String companyCode = "";
		String voucherNo = "";
		// String acctName = "10060034";
		// String acctNamekvb = "10060033";
		System.out.println("PT ==== "+objCashBankPaymentBean.getPmtType());
		System.out.println("PD ===="+objCashBankPaymentBean.getCashbankPmtDate());
		System.out.println("AC ===="+objCashBankPaymentBean.getAccountName());
		String sCBPYear = "", sDefaultCBPNo = "", pmtCode = "";
		String CompanyShortName = "DCI";
		CashBankPaymentBean ObjCashBankPaymentBean = new CashBankPaymentBean();
		BasicResultBean BasicResultBean = new BasicResultBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date;
			java.util.Date datefrwd;

			date = formatter.parse(objCashBankPaymentBean.getCashbankPmtDate());
			datefrwd = new java.util.Date();

			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String Gidate = df.format(date);

			SimpleDateFormat dff = new SimpleDateFormat("dd/mm/yyyy");
			String current = dff.format(datefrwd);
			int yr = Calendar.getInstance().get(Calendar.YEAR);
			Integer oldyr = (yr);
			Integer newyr = (yr + 1);

			java.util.Date FrwdYrDate = formatter.parse("01/04/" + newyr);
			java.util.Date previousYrDate = formatter.parse("31/03/" + oldyr);

			Integer nr = (newyr + 1);
			Integer or = (oldyr + 1);

			if (date.compareTo(FrwdYrDate) >= 0) {
				sCurrentYear = newyr.toString().substring(2) + "-" + nr.toString().substring(2);
			} else if (date.compareTo(previousYrDate) >= 0) {
				sCurrentYear = oldyr.toString().substring(2) + "-" + or.toString().substring(2);
			}

			System.out.println("yr " + sCurrentYear);
			// sCurrentYear = Gidate.substring(2);
			String result = "";
			String acctName = objCashBankPaymentBean.getAccountName();

			if (pmtType.equalsIgnoreCase("bank") && objCashBankPaymentBean.getAccountName() == null
					|| objCashBankPaymentBean.getAccountName() == ""
					|| objCashBankPaymentBean.getAccountName() == "undefined") {

				// String banknamekvb = "AB SB A/c No.50008646691";
				String banknamekvb = "AB SB A/c No.50008646691";

				result = banknamekvb.substring(20, 24);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				/*
				 * sDefaultCBPNo =
				 * jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.
				 * GET_PURCHASE_ORDER_NUMBER_CAPX1, String.class, sCurrentYear +
				 * "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				 * sDefaultCBPNo = CompanyShortName.concat("-ABSB").concat("-" +
				 * result).concat("-" + sDefaultCBPNo);
				 * BasicResultBean.setType(sDefaultCBPNo);
				 * BasicResultBean.setMessage("CASH BANK changed...New PONO :" +
				 * " " + sDefaultCBPNo);
				 */

				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-AB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10000034")) {
				String bankname = "KVB Operation SBA/c1244155000119945";
				result = bankname.substring(31, 35);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-KVB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			} else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10000034")) {
				String banknamekvb = "KVBSB Operation A/c1244155000119921";
				result = banknamekvb.substring(31, 35);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-KVB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10000034")) {
				String banknamekvb = "KVBSB Operation A/c1244155000119933";
				result = banknamekvb.substring(31, 35);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-KVB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10000034")) {
				String banknamekvb = "KVBSB A/c.1244155000114886";
				result = banknamekvb.substring(22, 26);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-KVB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10000034")) {
				String banknamekvb = "Allahabad Bank SB A/c No.50012383066";
				result = banknamekvb.substring(32, 36);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-ALB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10030001")) {
				// if (pmtType.equalsIgnoreCase("bank") ) {

				// String banknamekvb = "AB SB A/c No.50008646691";
				String banknamekvb = "AB SB A/c No.50008646691";

				result = banknamekvb.substring(20, 24);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				/*
				 * sDefaultCBPNo =
				 * jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.
				 * GET_PURCHASE_ORDER_NUMBER_CAPX1, String.class, sCurrentYear +
				 * "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				 * sDefaultCBPNo = CompanyShortName.concat("-ABSB").concat("-" +
				 * result).concat("-" + sDefaultCBPNo);
				 * BasicResultBean.setType(sDefaultCBPNo);
				 * BasicResultBean.setMessage("CASH BANK changed...New PONO :" +
				 * " " + sDefaultCBPNo);
				 */

				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-AB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10030002")) {
				String banknamekvb = "AB SB A/c No.50050624777";
				result = banknamekvb.substring(20, 24);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-ABSB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10030003")) {
				String banknamekvb = "AB SB Account50012803015";
				result = banknamekvb.substring(20, 24);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-ABSB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10030004")) {
				String banknamekvb = "ABA/c No.20257127389";
				result = banknamekvb.substring(16, 20);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-AB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10030005")) {
				String banknamekvb = "ABA/c No.20257128305";
				result = banknamekvb.substring(16, 20);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-AB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10000006")) {
				String banknamekvb = "ABA/c No.20257129262";
				result = banknamekvb.substring(16, 20);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-AB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			} else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10060007")) {
				String banknamekvb = "ABA/c No.20257144757";
				result = banknamekvb.substring(16, 20);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-AB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10060008")) {
				String banknamekvb = "ABA/c No.50014365170";
				result = banknamekvb.substring(16, 20);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-AB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			} else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10060009")) {
				String banknamekvb = "ABA/c No.50094129681";
				result = banknamekvb.substring(16, 20);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-AB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10060010")) {
				String banknamekvb = "ABSB A/c No.20257130277";
				result = banknamekvb.substring(20, 24);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-ABSB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10060011")) {
				String banknamekvb = "ABSB A/c No.50050623036";
				result = banknamekvb.substring(20, 23);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-ABSB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			} else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10060014")) {
				String banknamekvb = "ICICI BankA/c No.269601000042RD";
				result = banknamekvb.substring(27, 31);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-ICI").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			}

			else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10060016")) {
				String banknamekvb = "INDIAN BANK A/C NO 842789960";
				result = banknamekvb.substring(24, 28);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-IND").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			} else if (pmtType.equalsIgnoreCase("bank") && acctName.contains("10060019")) {
				String banknamekvb = "KVBSB A/c.1244155000114898";
				result = banknamekvb.substring(23, 26);
				System.out.println(result);

				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1,
						String.class, sCurrentYear + "-0001", sCurrentYear + "-", CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-KVB").concat("-" + result).concat("-" + sDefaultCBPNo);
				BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);

			} else if (pmtType.equalsIgnoreCase("cash")) {
				System.out.println("pType == " +pmtType);
				// String CompanyShortName =
				// jdbcTemplate.queryForObject(ConsignmentRequestQueryUtil.GET_SHORT_NAME,
				// String.class, ObjCashBankPaymentBean.getCompanyName());
				sDefaultCBPNo = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PURCHASE_ORDER_NUMBER_CAPX1CP,
						String.class, CompanyShortName.concat("%"));
				sDefaultCBPNo = CompanyShortName.concat("-" + sDefaultCBPNo);
				// BasicResultBean.setType(sDefaultCBPNo);
				BasicResultBean.setMessage("CASH BANK changed...New PONO :" + " " + sDefaultCBPNo);
				System.out.println("VNO - " +sDefaultCBPNo);
				/*
				 * sCurrentYear = sCurrentYear.substring(2); pmtCode = "CP";
				 * sCBPYear = "CP" + sCurrentYear + "%"; sDefaultCBPNo = "CP" +
				 * sCurrentYear + "00001"; List<Map<String, Object>> rows =
				 * jdbcTemplate.queryForList(CashBankPaymentQueryUtil.
				 * AUTOGEN_CASHBANK_VOUCHER_NO, new Object[] { sDefaultCBPNo,
				 * pmtCode, sCBPYear }); for (Map row : rows) { voucherNo =
				 * (String) row.get("VOUCHER_NO"); }
				 */
			}

		} catch (DataAccessException | ParseException e) {
			LOGGER.error("Error in Generate VOUCHER Number", e);
		}
		return sDefaultCBPNo;
	}

	/*
	 * 
	 * public String generateQuotationNo(CashBankPaymentBean
	 * objCashBankPaymentBean) {
	 * 
	 * String quotation = ""; String quotationBranch = ""; String dateYear = "";
	 * int count = 0; int count1 = 0;
	 * 
	 * try { JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	 * 
	 * List<Map<String, Object>> rows =
	 * jdbcTemplate.queryForList(SeaQuotationQueryUtil.getQuotBranch, branchId,
	 * IE); for (Map row : rows) { quotationBranch = (String)
	 * row.get("quotBranch"); }
	 * 
	 * List<Map<String, Object>> rows4 =
	 * jdbcTemplate.queryForList(SeaQuotationQueryUtil.DateandYear); for (Map
	 * row5 : rows4) { dateYear = (String) row5.get("dateYear"); }
	 * 
	 * int mnth = Integer.parseInt(dateYear.subSequence(0, 2).toString()); int
	 * yr = Integer.parseInt(dateYear.subSequence(2, 4).toString());
	 * 
	 * if (mnth >= 4) // If April month, sequence will be start 1 {
	 * List<Map<String, Object>> aprows1 =
	 * jdbcTemplate.queryForList(SeaQuotationQueryUtil
	 * .getQuotCountForApril(quotationBranch)); for (Map aprow2 : aprows1) {
	 * count = (int) aprow2.get("count"); count1 = count + 1; } } else {
	 * List<Map<String, Object>> rows1 =
	 * jdbcTemplate.queryForList(SeaQuotationQueryUtil
	 * .getQuotCount(quotationBranch)); for (Map row2 : rows1) { count = (int)
	 * row2.get("count"); count1 = count + 1; } }
	 * 
	 * if (count <= 9) { count1 = count + 1; quotation = quotationBranch + "/" +
	 * dateYear + "/" + "000" + count1;
	 * 
	 * } else if (count <= 99) { count1 = count + 1; quotation = quotationBranch
	 * + "/" + dateYear + "/" + "00" + count1;
	 * 
	 * } else if (count <= 999) { count1 = count + 1; quotation =
	 * quotationBranch + "/" + dateYear + "/" + "0" + count1; } else { count1 =
	 * count + 1; quotation = quotationBranch + "/" + dateYear + "/" + count1; }
	 * 
	 * // quotation = quotationBranch + "/" + dateYear + "/" + count1;
	 * 
	 * int id = checkQuoExists(quotation);
	 * 
	 * if (id > 0) { generateQuotationNo(branchId, IE); }
	 * 
	 * } catch (Exception e) { LOGGER.error("Error in generate code", e); }
	 * return quotation; }
	 */
	@Override
	public List<CashBankPaymentBean> getCashBankPaymentHdrList(int limit, int offset) {
		List<CashBankPaymentBean> lCBPmtHdrList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCBPmtHdrList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_CASHBANK_PMT_HDR_LIST,
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lCBPmtHdrList;
	}

	@Override
	public CashBankPaymentBean getPaymentVoucherDetailforEdit(String sVoucherNo) {
		CashBankPaymentBean objCashBankPaymentBean = new CashBankPaymentBean();
		try {
			objCashBankPaymentBean = getPaymentVoucherHeaderDetail(sVoucherNo);
			List<CashBankPaymentDetailBean> lDetailList = new ArrayList<>();
			List<CashBankPaymentDetailBean> lDetailListcash = new ArrayList<>();

			lDetailList = getPaymentVoucherDetailList(sVoucherNo);
			objCashBankPaymentBean.setCbptables(lDetailList);
			lDetailListcash = getPaymentVoucherDetailListcash(sVoucherNo);
			objCashBankPaymentBean.setCbptablescash(lDetailListcash);

		} catch (CustomException e) {
			LOGGER.error("Error in Get lSubAccountList List", e);
		}

		return objCashBankPaymentBean;
	}

	private CashBankPaymentBean getPaymentVoucherHeaderDetail(String sVoucherNo) {
		CashBankPaymentBean objCashBankPaymentBean = new CashBankPaymentBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objCashBankPaymentBean = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PAYMENT_VOUCHER_HDR,
					new Object[] { sVoucherNo }, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

			List<CashBankPaymentBean> lBankAcctList = new ArrayList<>();
			if ("B".equalsIgnoreCase(objCashBankPaymentBean.getPmtType()))
				lBankAcctList = getBankAcctList("bank");
			else
				lBankAcctList = getBankAcctList("cash");

			objCashBankPaymentBean.setlBankList(lBankAcctList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Payment Header Detail ", e);
		}
		return objCashBankPaymentBean;
	}

	public List<CashBankPaymentDetailBean> getPaymentVoucherDetailList(String sVoucherNo) throws CustomException {
		List<CashBankPaymentDetailBean> dtlDataList = new ArrayList<>();
		List<CashBankPaymentInvoiceDetailBean> lInvoicePmtData = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			dtlDataList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PAYMENT_VOUCHER_DTL,
					new Object[] { sVoucherNo }, new BeanPropertyRowMapper<>(CashBankPaymentDetailBean.class));

			for (CashBankPaymentDetailBean row : dtlDataList) {
				Integer cbpmtDtlId = row.getCashBankPmtDtlId();
				lInvoicePmtData = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PAYMENT_INVOICE_DTL,
						new Object[] { cbpmtDtlId },
						new BeanPropertyRowMapper<>(CashBankPaymentInvoiceDetailBean.class));
				row.setInvoicePaymentList(lInvoicePmtData);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Detail list", e);
			throw new CustomException("Error in Get Detail list");
		}
		return dtlDataList;
	}

	public List<CashBankPaymentDetailBean> getPaymentVoucherDetailListcash(String sVoucherNo) throws CustomException {
		List<CashBankPaymentDetailBean> dtlDataListcash = new ArrayList<>();
		List<CashBankPaymentInvoiceDetailBean> lInvoicePmtData = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			dtlDataListcash = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PAYMENT_VOUCHER_DTL_cash,
					new Object[] { sVoucherNo }, new BeanPropertyRowMapper<>(CashBankPaymentDetailBean.class));

			for (CashBankPaymentDetailBean row : dtlDataListcash) {
				Integer cbpmtDtlId = row.getCashBankPmtDtlId();
				lInvoicePmtData = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PAYMENT_INVOICE_DTL,
						new Object[] { cbpmtDtlId },
						new BeanPropertyRowMapper<>(CashBankPaymentInvoiceDetailBean.class));
				row.setInvoicePaymentList(lInvoicePmtData);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Detail list", e);
			throw new CustomException("Error in Get Detail list");
		}
		return dtlDataListcash;
	}

	@Override
	public boolean updateCashBankPayment(CashBankPaymentBean objCashBankPaymentBean) {

		boolean isSuccess = false;
		try {
			isSuccess = updatePaymentVoucherHeader(objCashBankPaymentBean); //
			if (isSuccess) {

				HashMap<String, Object> chqBookMap = new HashMap<>();

				if (objCashBankPaymentBean.getPmtType().equalsIgnoreCase("bank")) {
					chqBookMap.put("chequeDate", objCashBankPaymentBean.getChequeDate());
					chqBookMap.put("narration", objCashBankPaymentBean.getNarration());
					chqBookMap.put("chequeStatus", 179);
					chqBookMap.put("bcAmountHdr", objCashBankPaymentBean.getBcAmountHdr());
					chqBookMap.put("chqBookId", Integer.parseInt(objCashBankPaymentBean.getChequeNo()));

					namedParameterJdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_CHQ_BOOK, chqBookMap);

					int iGLDel1 = jdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_CHQ_BOOK_STATUS,
							new Object[] { 181, objCashBankPaymentBean.getChequeNoId() });
				}

				isSuccess = updatePaymentVoucherDetail(objCashBankPaymentBean); //
				isSuccess = updatePaymentVoucherDetailcash(objCashBankPaymentBean); //

			}

			if (isSuccess) {
				int iGLDel = jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_GENERAL_LEDGER,
						new Object[] { objCashBankPaymentBean.getCbVoucherNo() });
				if (iGLDel > 0) {
					isSuccess = saveCBPmtGeneralLedgerCreditEntry(objCashBankPaymentBean);
					isSuccess = saveCBPmtGeneralLedgerDebitEntry(objCashBankPaymentBean);
				}

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Update", e);
		}
		return isSuccess;
	}

	/**
	 * Update - Cash Bank Payment Header
	 * 
	 * @param objCashBankPaymentBean
	 * @return
	 */
	private boolean updatePaymentVoucherHeader(CashBankPaymentBean objCashBankPaymentBean) {
		boolean isSuccess = false;
		String chequeDate = null;
		String sPaymentType = "";

		Date voucherDate = CommonUtil.convertSqlDateFormat(objCashBankPaymentBean.getCashbankPmtDate());

		if (objCashBankPaymentBean.getPmtType().equalsIgnoreCase("bank")) {
			sPaymentType = "B";
			chequeDate = objCashBankPaymentBean.getChequeDate();
		} else if (objCashBankPaymentBean.getPmtType().equalsIgnoreCase("cash")) {
			sPaymentType = "C";
			chequeDate = null;
		}

		int iCBPHdrUpd = jdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_CBPAYMENT_HDR,
				new Object[] { voucherDate, sPaymentType, objCashBankPaymentBean.getAccountName(),
						objCashBankPaymentBean.getExchangeRate(), objCashBankPaymentBean.getChequeNo(), chequeDate,
						objCashBankPaymentBean.getBcAmountHdr(), objCashBankPaymentBean.getTcAmountHdr(),
						objCashBankPaymentBean.getNarration(), "E001", objCashBankPaymentBean.getPaidTo(),
						objCashBankPaymentBean.getCompanyName(), objCashBankPaymentBean.getCostCenter(),
						objCashBankPaymentBean.getCbVoucherNo() });

		if (iCBPHdrUpd > 0)
			isSuccess = true;

		return isSuccess;
	}

	/**
	 * 
	 * Update - Cash Bank Payment Detail
	 * 
	 * @param objCashBankPaymentBean
	 * @return
	 */
	private boolean updatePaymentVoucherDetail(CashBankPaymentBean objCashBankPaymentBean) {
		boolean flag = false;
		try {
			int iCounter = 1;
			List<CashBankPaymentDetailBean> cbpmtTableData = objCashBankPaymentBean.getCbptables();

			List<CashBankPaymentDetailBean> cbpmtDeletedTableData = objCashBankPaymentBean.getDeletedCBPmtDtlsRow();
			for (CashBankPaymentDetailBean objCashBankPaymentDetailBean : cbpmtTableData) {
				objCashBankPaymentDetailBean.getCbpdtlAccountHead();
				objCashBankPaymentDetailBean.getCbpdtlPmtOrderNo();
				objCashBankPaymentDetailBean.getCbpdtlCurrencyCode();
				objCashBankPaymentDetailBean.getCbpdtlExgRate();
				objCashBankPaymentDetailBean.getCbpDtlBcAmount();
				objCashBankPaymentDetailBean.getCbpDtlTcAmount();
				objCashBankPaymentDetailBean.getCbdtlsubAccountCode();
				objCashBankPaymentDetailBean.getCbpdtlAccountHead().substring(0, 4);
				objCashBankPaymentDetailBean.getCbpdtlpaymentHead();
				int slNo = iCounter;

				if (objCashBankPaymentDetailBean.getCashBankPmtDtlId() > 0) {// update
					Object[] cbpdtlUpdParams = new Object[] { objCashBankPaymentBean.getCbVoucherNo(),
							objCashBankPaymentDetailBean.getCbpdtlAccountHead(),
							objCashBankPaymentDetailBean.getPurInvoiceNo(),
							objCashBankPaymentDetailBean.getCbpdtlCurrencyCode(),
							objCashBankPaymentDetailBean.getCbpdtlExgRate(),
							objCashBankPaymentDetailBean.getCbpDtlBcAmount(),
							objCashBankPaymentDetailBean.getCbpDtlTcAmount(),
							objCashBankPaymentDetailBean.getDepartmentCode(),
							objCashBankPaymentDetailBean.getCbpdtlAccountHead().substring(0, 4), slNo,
							objCashBankPaymentDetailBean.getCbdtlsubAccountCode(),
							objCashBankPaymentDetailBean.getEmployeeCode(),
							objCashBankPaymentDetailBean.getCountryCode(),
							objCashBankPaymentDetailBean.getCustomerCode(),
							objCashBankPaymentDetailBean.getSupplierCode(),
							objCashBankPaymentDetailBean.getDesignationCode(),
							objCashBankPaymentDetailBean.getCompanyCode(), objCashBankPaymentDetailBean.getCostCenter(),
							objCashBankPaymentDetailBean.getPatientCode(),
							objCashBankPaymentDetailBean.getCbpdtlpaymentHead(),
							objCashBankPaymentDetailBean.getCashBankPmtDtlId() };

					int iCBPDtlId = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.UPDATE_CBPAYMENT_DTL,
							cbpdtlUpdParams, Integer.class);
					if (iCBPDtlId > 0) {
						List<CashBankPaymentInvoiceDetailBean> cbPmtInvoiceData = objCashBankPaymentDetailBean
								.getInvoicePaymentList();
						for (CashBankPaymentInvoiceDetailBean objCBPmtInvDtlBean : cbPmtInvoiceData) {
							if (objCBPmtInvDtlBean.getCbPmtInvDtlId() > 0 && iCBPDtlId > 0) {
								int iInvDtlUpd = jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_CB_PAYMENT_INV_DTL,
										new Object[] { objCBPmtInvDtlBean.getCbPmtInvDtlId() });
								flag = saveCashBankPmtInvoiceDetail(objCashBankPaymentBean,
										objCashBankPaymentDetailBean, objCBPmtInvDtlBean);
							} else {
								flag = saveCashBankPmtInvoiceDetail(objCashBankPaymentBean,
										objCashBankPaymentDetailBean, objCBPmtInvDtlBean);
							}
						}
						flag = true;
					}
				} else {// insert
					Object[] cbpdtlSaveParams = new Object[] { objCashBankPaymentBean.getCbVoucherNo(),
							objCashBankPaymentDetailBean.getCbpdtlAccountHead(),
							objCashBankPaymentDetailBean.getPurInvoiceNo(),
							objCashBankPaymentDetailBean.getCbpdtlCurrencyCode(),
							objCashBankPaymentDetailBean.getCbpdtlExgRate(),
							objCashBankPaymentDetailBean.getCbpDtlBcAmount(),
							objCashBankPaymentDetailBean.getCbpDtlTcAmount(),
							objCashBankPaymentDetailBean.getDepartmentCode(),
							objCashBankPaymentDetailBean.getCbpdtlAccountHead().substring(0, 4), slNo,
							objCashBankPaymentDetailBean.getCbdtlsubAccountCode(),
							objCashBankPaymentDetailBean.getEmployeeCode(),
							objCashBankPaymentDetailBean.getCountryCode(),
							objCashBankPaymentDetailBean.getCustomerCode(),
							objCashBankPaymentDetailBean.getSupplierCode(),
							objCashBankPaymentDetailBean.getDesignationCode(),
							objCashBankPaymentDetailBean.getCompanyCode(), objCashBankPaymentDetailBean.getCostCenter(),
							objCashBankPaymentDetailBean.getPatientCode() };

					int iCbpDtl = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.SAVE_CASH_BANK_PMT_DTL,
							cbpdtlSaveParams, Integer.class);
					if (iCbpDtl > 0) {
						objCashBankPaymentDetailBean.setCashBankPmtDtlId(iCbpDtl);
						List<CashBankPaymentInvoiceDetailBean> cbPmtInvoiceData = objCashBankPaymentDetailBean
								.getInvoicePaymentList();
						for (CashBankPaymentInvoiceDetailBean objCBPmtInvDtlBean : cbPmtInvoiceData) {
							flag = saveCashBankPmtInvoiceDetail(objCashBankPaymentBean, objCashBankPaymentDetailBean,
									objCBPmtInvDtlBean);
						}

					}
				}

				iCounter++;
			}

			if (cbpmtDeletedTableData.size() > 0) {
				for (CashBankPaymentDetailBean objDeletedBean : cbpmtDeletedTableData) {
					if (objDeletedBean.isSelect()) {
						jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_CB_PAYMENT_INV_DTL_WITH_PMT_DTL_ID,
								new Object[] { objDeletedBean.getCashBankPmtDtlId() });
						jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_CB_PAYMENT_DTL,
								new Object[] { objDeletedBean.getCashBankPmtDtlId() });
					}
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Cash Bank Payment Detail Records!", e);
		}
		return flag;
	}

	public boolean updatePaymentVoucherDetailcash(CashBankPaymentBean objCashBankPaymentBean) {

		try {
			List<CashBankPaymentDetailBean> alProductDetailListacct = objCashBankPaymentBean.getCbptablescash();
			for (CashBankPaymentDetailBean objdelbean : alProductDetailListacct) {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_CBPAYMENT_DTL_cash,
						new Object[] { objdelbean.getCbVoucherNo(), objdelbean.getDenomAmt(), objdelbean.getCountamt(),
								objdelbean.getRupessAmt(), objdelbean.getCashBankPmtDtlIdcash() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return true;
	}

	/*
	 * private boolean updatePaymentVoucherDetailcash(CashBankPaymentBean
	 * objCashBankPaymentBean) { boolean flag = false; try { int iCounter = 1;
	 * List<CashBankPaymentDetailBean> cbpmtTableDatacash =
	 * objCashBankPaymentBean.getCbptablescash();
	 * 
	 * List<CashBankPaymentDetailBean> cbpmtDeletedTableData =
	 * objCashBankPaymentBean.getDeletedCBPmtDtlsRowcash(); for
	 * (CashBankPaymentDetailBean objCashBankPaymentDetailBean :
	 * cbpmtTableDatacash) { objCashBankPaymentDetailBean.getDenomAmt();
	 * objCashBankPaymentDetailBean.getCountamt();
	 * objCashBankPaymentDetailBean.getRupessAmt();
	 * 
	 * int slNo = iCounter;
	 * 
	 * if (objCashBankPaymentDetailBean.getCashBankPmtDtlIdcash() > 0) {//
	 * update Object[] cbpdtlUpdParams = new Object[] {
	 * objCashBankPaymentBean.getCbVoucherNo(),
	 * objCashBankPaymentDetailBean.getDenomAmt(),
	 * objCashBankPaymentDetailBean.getCountamt(),
	 * objCashBankPaymentDetailBean.getRupessAmt(),
	 * objCashBankPaymentDetailBean.getCashBankPmtDtlIdcash() };
	 * 
	 * int iCBPDtlIdcash = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.
	 * UPDATE_CBPAYMENT_DTL_cash, cbpdtlUpdParams, Integer.class); if
	 * (iCBPDtlIdcash > 0) { List<CashBankPaymentInvoiceDetailBean>
	 * cbPmtInvoiceData = objCashBankPaymentDetailBean.getInvoicePaymentList();
	 * for (CashBankPaymentInvoiceDetailBean objCBPmtInvDtlBean :
	 * cbPmtInvoiceData) { if (objCBPmtInvDtlBean.getCbPmtInvDtlId() > 0 &&
	 * iCBPDtlIdcash > 0) { int iInvDtlUpd =
	 * jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_CB_PAYMENT_INV_DTL,
	 * new Object[] { objCBPmtInvDtlBean.getCbPmtInvDtlId() }); flag =
	 * saveCashBankPmtInvoiceDetail(objCashBankPaymentBean,
	 * objCashBankPaymentDetailBean, objCBPmtInvDtlBean); } else { flag =
	 * saveCashBankPmtInvoiceDetail(objCashBankPaymentBean,
	 * objCashBankPaymentDetailBean, objCBPmtInvDtlBean); } } flag = true; } }
	 * else {// insert Object[] cbpdtlSaveParams = new Object[] {
	 * objCashBankPaymentBean.getCbVoucherNo(),
	 * objCashBankPaymentDetailBean.getDenomAmt(),
	 * objCashBankPaymentDetailBean.getCountamt(),
	 * objCashBankPaymentDetailBean.getRupessAmt() };
	 * 
	 * int iCbpDtlcah = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.
	 * SAVE_CASH_BANK_PMT_DTL_cash, cbpdtlSaveParams, Integer.class); if
	 * (iCbpDtlcah > 0) {
	 * objCashBankPaymentDetailBean.setCashBankPmtDtlIdcash(iCbpDtlcah);
	 * List<CashBankPaymentInvoiceDetailBean> cbPmtInvoiceData =
	 * objCashBankPaymentDetailBean.getInvoicePaymentList(); for
	 * (CashBankPaymentInvoiceDetailBean objCBPmtInvDtlBean : cbPmtInvoiceData)
	 * { flag = saveCashBankPmtInvoiceDetail(objCashBankPaymentBean,
	 * objCashBankPaymentDetailBean, objCBPmtInvDtlBean); }
	 * 
	 * } }
	 * 
	 * iCounter++; }
	 * 
	 * if (cbpmtDeletedTableData.size() > 0) { for (CashBankPaymentDetailBean
	 * objDeletedBean : cbpmtDeletedTableData) { if (objDeletedBean.isSelect())
	 * { jdbcTemplate.update(CashBankPaymentQueryUtil.
	 * DELETE_CB_PAYMENT_INV_DTL_WITH_PMT_DTL_ID_cash, new Object[] {
	 * objDeletedBean.getCashBankPmtDtlIdcash() });
	 * jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_CB_PAYMENT_DTL, new
	 * Object[] { objDeletedBean.getCashBankPmtDtlId() }); } } }
	 * 
	 * } catch (DataAccessException e) {
	 * LOGGER.error("Error in save the Cash Bank Payment Detail Records!", e); }
	 * return flag; }
	 */
	@Override
	public List<CashBankPaymentBean> getAttributeListWithAccountCode(String accountCode) {
		List<CashBankPaymentBean> lAttributeList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lAttributeList = jdbcTemplate.query(CashBankPaymentQueryUtil.getAttributeList, new Object[] { accountCode },
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lAttributeList;
	}

	@Override
	public boolean deleteCashBankPayment(String voucherNo) {
		boolean isDeleted = false;
		try {
			int cbpHdrDel = 0;
			int cbpInvDtlDel = jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_CBPAYMENT_INVOICE_DTL,
					new Object[] { voucherNo });
			int cbpDtlDel = jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_CBPAYMENT_DTL,
					new Object[] { voucherNo });
			int rowGL = jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_GENERAL_LEDGER, new Object[] { voucherNo });

			cbpHdrDel = jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_CBPAYMENT_HDR, new Object[] { voucherNo });

			if (cbpHdrDel > 0)
				isDeleted = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete Journal Voucher Records", e);
		}
		return isDeleted;
	}

	@Override
	public CashBankPaymentDetailBean getPendingInvoiceDetails(String supplierCode) {
		CashBankPaymentDetailBean objCashBankPaymentBean = new CashBankPaymentDetailBean();
		List<CashBankPaymentInvoiceDetailBean> lPendingInvList = new ArrayList<>();
		try {
			lPendingInvList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_INVOICE_DETAILS,
					new Object[] { supplierCode, supplierCode },
					new BeanPropertyRowMapper<>(CashBankPaymentInvoiceDetailBean.class));

			double bcInvAmt = 0, tcInvAmt = 0, bcPaidAmt = 0, tcPaidAmt = 0, bcBalanceAmt = 0, tcBalanceAmt = 0;
			for (CashBankPaymentInvoiceDetailBean objInvBean : lPendingInvList) {
				// objInvBean.setBcInvAmt(CommonUtil.roundOffValue(objInvBean.getBcInvAmt(),
				// 2));
				// objInvBean.setTcInvAmt(CommonUtil.roundOffValue(objInvBean.getTcInvAmt(),
				// 2));
				// objInvBean.setBcPaidAmt(CommonUtil.roundOffValue(objInvBean.getBcPaidAmt(),
				// 2));
				// objInvBean.setTcPaidAmt(CommonUtil.roundOffValue(objInvBean.getTcPaidAmt(),
				// 2));
				// objInvBean.setBcBalanceAmt(CommonUtil.roundOffValue(objInvBean.getBcBalanceAmt(),
				// 2));
				// objInvBean.setTcBalanceAmt(CommonUtil.roundOffValue(objInvBean.getTcBalanceAmt(),
				// 2));
			}

			objCashBankPaymentBean.setPendingInvoiceDtls(lPendingInvList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Pending Invoice Details List", e);
		}

		return objCashBankPaymentBean;
	}

	@Override
	public List<CashBankPaymentBean> getPaidToList() {
		List<CashBankPaymentBean> lPaidToList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lPaidToList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PAID_TO_LIST,
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Paid To List", e);
		}
		return lPaidToList;
	}

	@Override
	public List<PaymentHistoryReportBean> pendingPayment1stLevelList() {
		List<PaymentHistoryReportBean> lCBPmtHdrList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCBPmtHdrList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_1STLEVEL_LIST,
					new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in pendingPayment1stLevelList List", e);
		}
		return lCBPmtHdrList;
	}

	@Override
	public List<PaymentHistoryReportBean> getPendingPaymentReportDtlList(String voucherNo) {
		List<PaymentHistoryReportBean> lCBPmtHdrList = new ArrayList<>();
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCBPmtHdrList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_2NDLEVEL_LIST,
					new Object[] { voucherNo }, new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPendingPaymentReportDtlList List", e);
		}
		return lCBPmtHdrList;
	}

	@Override
	public List<PaymentHistoryReportBean> getPendingPaymentReportInvoiceDtl(int pmtDtlId) {
		List<PaymentHistoryReportBean> lCBPmtHdrList = new ArrayList<>();
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCBPmtHdrList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_3RDLEVEL_LIST,
					new Object[] { pmtDtlId }, new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPendingPaymentReportInvoiceDtl List", e);
		}
		return lCBPmtHdrList;
	}

	@Override
	public List<PaymentHistoryReportBean> getPaymentHistory1stLevelList() {
		List<PaymentHistoryReportBean> lCBPmtHdrList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCBPmtHdrList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_1STLEVEL_LIST,
					new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));

			for (PaymentHistoryReportBean objInvBean : lCBPmtHdrList) {
				// objInvBean.setBcAmountHdr(CommonUtil.roundOffValue(objInvBean.getBcAmountHdr(),
				// 2));
				// objInvBean.setTcAmountHdr(CommonUtil.roundOffValue(objInvBean.getTcAmountHdr(),
				// 2));
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPaymentHistory1stLevelList List", e);
		}
		return lCBPmtHdrList;
	}

	@Override
	public List<PaymentHistoryReportBean> getPaymentHistoryReportDtlList(String invoiceNo) {
		List<PaymentHistoryReportBean> lCBPmtHdrList = new ArrayList<>();
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCBPmtHdrList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_2NDLEVEL_LIST,
					new Object[] { invoiceNo }, new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPaymentHistoryReportDtlList List", e);
		}
		return lCBPmtHdrList;
	}

	@Override
	public List<PaymentHistoryReportBean> getPaymentHistoryInvoiceDtlList(int pmtDtlId) {
		List<PaymentHistoryReportBean> lCBPmtHdrList = new ArrayList<>();
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCBPmtHdrList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_3RDLEVEL_LIST,
					new Object[] { pmtDtlId }, new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPaymentHistoryInvoiceDtlList List", e);
		}
		return lCBPmtHdrList;
	}

	@Override
	public CashBankPaymentResultBean getPendingPaymentRptInvoiceDetails(String supplierCode) {
		CashBankPaymentResultBean objCashBankPaymentBean = new CashBankPaymentResultBean();
		List<PaymentHistoryReportBean> lPendingInvList = new ArrayList<>();
		try {
			lPendingInvList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_INVOICE_DETAILS,
					new Object[] { supplierCode, supplierCode },
					new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));
			double bcInvAmt = 0, tcInvAmt = 0, bcPaidAmt = 0, tcPaidAmt = 0, bcBalanceAmt = 0, tcBalanceAmt = 0;
			for (PaymentHistoryReportBean objInvBean : lPendingInvList) {
				// objInvBean.setInvoiceBCAmt(CommonUtil.roundOffValue(objInvBean.getInvoiceBCAmt(),
				// 2));
				// objInvBean.setInvoiceTCAmt(CommonUtil.roundOffValue(objInvBean.getInvoiceTCAmt(),
				// 2));
				// objInvBean.setPaidAmountBC(CommonUtil.roundOffValue(objInvBean.getPaidAmountBC(),
				// 2));
				// objInvBean.setPaidAmountTC(CommonUtil.roundOffValue(objInvBean.getPaidAmountTC(),
				// 2));
				// objInvBean.setBcBalanceAmt(CommonUtil.roundOffValue(objInvBean.getBcBalanceAmt(),
				// 2));
				// objInvBean.setTcBalanceAmt(CommonUtil.roundOffValue(objInvBean.getTcBalanceAmt(),
				// 2));
			}
			objCashBankPaymentBean.setlPendingPaymentReportBean(lPendingInvList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Pending Invoice Details List", e);
		}

		return objCashBankPaymentBean;
	}

	@Override
	public List<PaymentHistoryReportBean> getPendingPaymentInvExportList(PaymentHistoryReportBean objPmtBean) {
		List<PaymentHistoryReportBean> lPendingInvList = new ArrayList<>();
		try {
			lPendingInvList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_INVOICE_DETAILS,
					new Object[] { objPmtBean.getSupplier(), objPmtBean.getSupplier() },
					new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Pending Invoice Details List", e);
		}

		return lPendingInvList;
	}

	@Override
	public List<PaymentHistoryReportBean> getPaymentHistoryExportList() {
		List<PaymentHistoryReportBean> lPmtHistoryList = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<PaymentHistoryReportBean> lPurchaseInvoiceList = new ArrayList<>();
			lPurchaseInvoiceList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_1STLEVEL_LIST,
					new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));

			for (PaymentHistoryReportBean objPaymentHistoryDtlBean : lPurchaseInvoiceList) {
				List<PaymentHistoryReportBean> lPmtInvTempList = new ArrayList<>();
				lPmtInvTempList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PENDING_PAYMENT_2NDLEVEL_LIST,
						new Object[] { objPaymentHistoryDtlBean.getPurInvoiceNo() },
						new BeanPropertyRowMapper<>(PaymentHistoryReportBean.class));
				objPaymentHistoryDtlBean.setPendingRptDtlList(lPmtInvTempList);
				lPmtHistoryList.add(objPaymentHistoryDtlBean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get company List", e);
		}
		return lPmtHistoryList;
	}

	@Override
	public String reversePayment(String voucherNo, String createdDate) {
		String sReceiptStatus = "";
		String sMessage = "";
		try {
			List<Map<String, Object>> RowData = jdbcTemplate.queryForList(CashBankPaymentQueryUtil.GET_PAYMENT_STATUS,
					new Object[] { voucherNo });
			for (Map<String, Object> row : RowData) {
				sReceiptStatus = (String) row.get("reverseBB");
			}

			if ("N".equalsIgnoreCase(sReceiptStatus)) {
				reversePaymentRecord(voucherNo, createdDate);
				sMessage = "Payment Reversed sucessfully";
			} else {
				sMessage = "Payment is already Reversed !..";
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
			jdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_CBPAYMENT_HDR_STATUS,
					new Object[] { reverseBBStatus, voucherNo });
			// jdbcTemplate.update(CashBankPaymentQueryUtil.REVERSE_GENERAL_LEDGER_RECORDS,
			// new Object[] { voucherNo });
			// jdbcTemplate.update(CashBankPaymentQueryUtil.DELETE_CBPAYMENT_INVOICE_DTL,
			// new Object[] { voucherNo });

			// String invoiceNumber =
			// jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_INVOICE_DTL,
			// new
			// Object[] { voucherNo }, String.class);

			// String[] invoiceNo = invoiceNumber.split(",");
			// for (int i = 0; i < invoiceNo.length; i++) {
			// jdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_INVOICE_STATUS,
			// new
			// Object[] { invoiceNo[i] });
			// }
			String pmType = "bank";
			CashBankPaymentBean bean = getPaymentVoucherDetailforEdit(voucherNo);
			if (bean.getPmtType().equalsIgnoreCase("B")) {
				pmType = "bank";
			} else {
				pmType = "cash";
			}
			String voucherNoNew = generateCashbankPaymentCode(pmType, bean);
			// int succ =
			// jdbcTemplate.update(CashBankPaymentQueryUtil.REVERSE_CBP, new
			// Object[] { voucherNo, createdDate, userDetails.getUserId(),
			// voucherNoNew });
			int succ = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.REVERSE_CBP,
					new Object[] { voucherNo, createdDate, userDetails.getUserId(), voucherNoNew }, Integer.class);
			int succ1 = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.REVERSE_CBR_GL,
					new Object[] { Integer.parseInt(voucherNoNew) }, Integer.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String validateBudget(CashBankPaymentBean objCashBankPaymentBean) {
		String msg = "";
		List accountsList = new ArrayList();
		try {

			String expAccounts = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_BUDGET_ACCOUNTS,
					String.class);
			if (expAccounts != null) {
				String[] expCode = expAccounts.split(",");
				for (String str : expCode) {
					accountsList.add(str);
				}
			}

			List<CashBankPaymentDetailBean> cbpmtTableData = objCashBankPaymentBean.getCbptables();
			for (CashBankPaymentDetailBean objCashBankPaymentDetailBean : cbpmtTableData) {

				objCashBankPaymentDetailBean.setCbpdtlAccountHead(objCashBankPaymentDetailBean.getCbdtlsubAccountCode());
				
				System.out.println("P Head 1"+objCashBankPaymentDetailBean.getAcctHeadCode() );
				System.out.println("P Head 1"+ objCashBankPaymentDetailBean.getAccountHeadName());
				System.out.println("P Head 1"+ objCashBankPaymentDetailBean.getCbdtlsubAccountCode());
				System.out.println("P Head 1"+objCashBankPaymentDetailBean.getCbpdtlAccountHead() );
				 
				String subGrp = objCashBankPaymentDetailBean.getCbpdtlAccountHead().substring(0, 4); 
				
				 

				/*	getCbpdtlAccountHead
				 * if (accountsList.contains(subGrp)) { String finYear =
				 * jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.
				 * GET_FIN_YEAR_FOR_COMPANY, new Object[] {
				 * objCashBankPaymentBean.getCompanyName(), "Approved" },
				 * String.class); String[] str = finYear.split("-"); String
				 * frmDt = str[0] + "-04-01", toDt = "20" + str[1] + "-03-31";
				 * 
				 * double budgetVal =
				 * jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.
				 * GET_BUDGET_AMOUNT, new Object[] {
				 * objCashBankPaymentBean.getCompanyName(), finYear, "Approved",
				 * subGrp }, java.lang.Double.class); double paidVal =
				 * jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.
				 * GET_PAID_FOR_SG, new Object[] { frmDt, toDt, subGrp,
				 * objCashBankPaymentBean.getCompanyName() },
				 * java.lang.Double.class);
				 * 
				 * if (budgetVal <= (paidVal +
				 * objCashBankPaymentDetailBean.getCbpDtlBcAmount())) msg +=
				 * "Payment Exceeding Budget Limit For Category : " + subGrp; }
				 */

				String finYear = "";
				if (accountsList.contains(subGrp)) {
					Integer finYearcount = jdbcTemplate.queryForObject(
							CashBankPaymentQueryUtil.GET_FIN_YEAR_FOR_COMPANY1,
							new Object[] { objCashBankPaymentBean.getCompanyName(), "Approved" }, Integer.class);

					if (finYearcount > 0) {
						finYear = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_FIN_YEAR_FOR_COMPANY,
								new Object[] { objCashBankPaymentBean.getCompanyName(), "Approved" }, String.class);

						String[] str = finYear.split("-");
						String frmDt = str[0] + "-04-01", toDt = "20" + str[1] + "-03-31";

						double budgetVal = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_BUDGET_AMOUNT,
								new Object[] { objCashBankPaymentBean.getCompanyName(), finYear, "Approved", subGrp },
								java.lang.Double.class);
						double paidVal = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PAID_FOR_SG,
								new Object[] { frmDt, toDt, subGrp, objCashBankPaymentBean.getCompanyName() },
								java.lang.Double.class);

						if (budgetVal <= (paidVal + objCashBankPaymentDetailBean.getCbpDtlBcAmount()))
							msg += "Payment Exceeding Budget Limit For Category : " + subGrp;
					}
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Budget Validation!", e);
		}
		return msg;
	}

	@Override
	public CashBankPaymentBean printPaymentVoucher(String voucherNo) {

		CashBankPaymentBean objCashBankPaymentBean = new CashBankPaymentBean();
		String sJvNo = "";
		try {

			objCashBankPaymentBean = jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_PAYMENT_VOUCHER_VIEW_HDR,
					new Object[] { voucherNo }, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));
			if (objCashBankPaymentBean.getCompanyCode().equalsIgnoreCase("C0002")) {
				objCashBankPaymentBean.setCompanyName("Dental Council Of India");
			} else {
				objCashBankPaymentBean.setCompanyName("Dental Council Of India");
			}
			List<CashBankPaymentDetailBean> lDetailList = jdbcTemplate.query(
					CashBankPaymentQueryUtil.GET_PAYMENT_VOUCHER_VIEW_DTL, new Object[] { voucherNo, voucherNo },
					new BeanPropertyRowMapper<>(CashBankPaymentDetailBean.class));
			objCashBankPaymentBean.setCbptables(lDetailList);
			System.out.println("1" + lDetailList.get(0).getDtlnarration());
			List<CashBankPaymentInvoiceDetailBean> lInvoiceDtlList = new ArrayList<>();
			List<CashBankPaymentBean> allocInvoiceDtlList = new ArrayList<>();

			double dTcAmountDtl = 0.0, dBcAmountDtl = 0.0;
			for (CashBankPaymentDetailBean objCashBankPaymentDetailBean : lDetailList) {

				lInvoiceDtlList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PAID_INVOICE_DTLS,
						new Object[] { voucherNo },
						new BeanPropertyRowMapper<>(CashBankPaymentInvoiceDetailBean.class));
				objCashBankPaymentDetailBean.setInvoicePaymentList(lInvoiceDtlList);

				dTcAmountDtl = dTcAmountDtl + objCashBankPaymentDetailBean.getCbpDtlTcAmount();
				dBcAmountDtl = dBcAmountDtl + objCashBankPaymentDetailBean.getCbpDtlBcAmount();

			}

			allocInvoiceDtlList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PAID_INVOICE_ALLOC_DTLS,
					new Object[] { voucherNo }, new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

			objCashBankPaymentBean.setInvoicealloc(allocInvoiceDtlList);
			objCashBankPaymentBean.setTcAmountDtl(dTcAmountDtl);
			objCashBankPaymentBean.setBcAmountDtl(dBcAmountDtl);

			String Type = "Rupees";
			objCashBankPaymentBean.setCurrencyType(Type);
			String amountInWords = wordingConversion
					.convertToIndianCurrency(String.valueOf(Math.round(objCashBankPaymentBean.getBcAmountDtl())));
			amountInWords = "Rupees" + "  " + amountInWords;
			objCashBankPaymentBean.setAmountinWords(amountInWords);
			System.out.println(objCashBankPaymentBean.getCurrencyType() + "  " + wordingConversion
					.convertToIndianCurrency(String.valueOf(objCashBankPaymentBean.getBcAmountDtl())));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get lSubAccountList List", e);
		}

		return objCashBankPaymentBean;

	}

	@Override
	public List<CashBankPaymentBean> getChequeNoList(String sAccountName) {
		List<CashBankPaymentBean> lChequeNoList = new ArrayList<>();

		try {

			lChequeNoList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_CHEQUE_NO_LIST,
					new Object[] { sAccountName, chequeStatus, sAccountName },
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Cheque No List", e);
		}
		return lChequeNoList;
	}

	@Override
	public List<CashBankPaymentBean> getChequeNoEditList(CashBankPaymentBean bankPaymentBean) {
		List<CashBankPaymentBean> lChequeNoList = new ArrayList<>();

		try {
			lChequeNoList = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_CHEQUE_NO_EDIT_LIST,
					new Object[] { bankPaymentBean.getAcctHeadCode(), 180, bankPaymentBean.getCbVoucherNo(),
							bankPaymentBean.getAcctHeadCode() },
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Cheque No List", e);
		}
		return lChequeNoList;
	}

	@Override
	public CashBankPaymentResultBean budgetdefnvalidation(CashBankPaymentBean objCashBankPaymentBean) {
		String msg = "";
		boolean success = false;
		List accountsList = new ArrayList();
		CashBankPaymentResultBean rsbean = new CashBankPaymentResultBean();
		try {

			int rowCount = 0;

			List<CashBankPaymentDetailBean> cbpmtTableData = objCashBankPaymentBean.getCbptables();
			for (CashBankPaymentDetailBean objCashBankPaymentDetailBean : cbpmtTableData) {
				rowCount++;
				if (objCashBankPaymentDetailBean.getBudgetDefnId() != 0) {
					// String subGrp =
					// objCashBankPaymentDetailBean.getCbpdtlAccountHead().substring(0,
					// 4);

					// if (accountsList.contains(subGrp)) {
					// String finYear =
					// jdbcTemplate.queryForObject(CashBankPaymentQueryUtil.GET_FIN_YEAR_FOR_COMPANY_NEW,
					// String.class);
					// String[] str = finYear.split("-");
					// String frmDt = str[0] + "-04-01", toDt = "20" + str[1] +
					// "-03-31";
					String query = CashBankPaymentQueryUtil.GET_BUDGET_DEFN_AMOUNT;
					String queryCount = CashBankPaymentQueryUtil.GET_BUDGET_DEFN_AMOUNT_COUNT;
					String utilizedQuery = CashBankPaymentQueryUtil.GET_BUDGET_UTILIZED_AMOUNT_COUNT;
					String utilizedQueryCount = CashBankPaymentQueryUtil.GET_BUDGET_UTILIZED_AMOUNT_COUNT1;
					if (objCashBankPaymentDetailBean.getBudgetDefnId() != 0) {
						query = query + " and budget_definition_id = '" + objCashBankPaymentDetailBean.getBudgetDefnId()
								+ "'";
						queryCount = queryCount + " and budget_definition_id = '"
								+ objCashBankPaymentDetailBean.getBudgetDefnId() + "'";
						utilizedQuery = utilizedQuery + " and purchase_order.budget_type_id  = "
								+ objCashBankPaymentDetailBean.getBudgetDefnId() + "";
						utilizedQueryCount = utilizedQueryCount + " and purchase_order.budget_type_id  = "
								+ objCashBankPaymentDetailBean.getBudgetDefnId() + "";

						if (objCashBankPaymentDetailBean.getCostCenter() != null) {
							query = query + "      and  cost_center = '" + objCashBankPaymentDetailBean.getCostCenter()
									+ "'";
							queryCount = queryCount + "  and  cost_center = '"
									+ objCashBankPaymentDetailBean.getCostCenter() + "'";
							// utilizedQuery = utilizedQuery + " and cost_center
							// =
							// '" + objCashBankPaymentDetailBean.getCostCenter()
							// +
							// "'";
						}
					}
					double balanceAmt = 0;
					double UAmt = 0;
					DecimalFormat df = new DecimalFormat("0.00");
					int count = jdbcTemplate.queryForObject(queryCount, Integer.class);
					if (count > 0) {
						double budgetVal = jdbcTemplate.queryForObject(query, Double.class);
						rsbean.setBudgetAmt(budgetVal);
						double paidVal = 0;
						UAmt = jdbcTemplate.queryForObject(utilizedQueryCount, Double.class);
						if (UAmt > 0) {
							paidVal = jdbcTemplate.queryForObject(utilizedQuery, Double.class);
							rsbean.setBudgetUtilizedAmt(paidVal);
							// if (budgetVal <= (paidVal +
							// objCashBankPaymentDetailBean.getCbpDtlBcAmount()))
							// msg += "Payment Exceeding Budget Limit For
							// Category :
							// " +
							// subGrp;
							balanceAmt = budgetVal - paidVal;
							if (balanceAmt < objCashBankPaymentDetailBean.getCbpDtlBcAmount()) {
								// msg += "Row " + rowCount + " There is no
								// budget
								// allocated for this expense ! ";
								msg += "Row " + rowCount
										+ " Amount entered is greater than the Allocated/Balance budget ("
										+ df.format(budgetVal - paidVal) + ")";

							}
						} else {
							if (budgetVal > 0)
								msg = "";

							else if (budgetVal == 0)
								msg += "Row " + rowCount
										+ " The cost center you have entered is not having any budget allocated ! ";
							else
								msg += "Row " + rowCount
										+ " Amount entered is greater than the Allocated/Balance budget ("
										+ df.format(budgetVal - paidVal) + ")";

						}
					}
					if (count <= 0) {
						msg += "Row " + rowCount
								+ " The cost center you have entered is not having any budget allocated ! ";
					}
					// else
					// success = true;
					// }
				} else {
					if (msg == "")
						msg = "";
				}
			}
			if (msg == "") {
				success = true;
			} else {
				success = false;
			}
			rsbean.setSuccess(success);
			rsbean.setMessage(msg);
			rsbean.setCount(rowCount);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Budget Validation!", e);
		}
		return rsbean;
	}

	@Override
	public CashBankPaymentBean getBudgetValue(String costCenter, Integer budgetDefId) {

		CashBankPaymentBean CashBankPaymentBean = new CashBankPaymentBean();
		try {
			int rowCount = 0;
			rowCount++;

			if (budgetDefId != null) {
				if (budgetDefId != 0) {
					String query = CashBankPaymentQueryUtil.GET_BUDGET_DEFN_AMOUNT;
					String queryCount = CashBankPaymentQueryUtil.GET_BUDGET_DEFN_AMOUNT_COUNT;
					String utilizedQuery = CashBankPaymentQueryUtil.GET_BUDGET_UTILIZED_AMOUNT_COUNT;
					String utilizedQueryCount = CashBankPaymentQueryUtil.GET_BUDGET_UTILIZED_AMOUNT_COUNT1;
					if (budgetDefId != 0) {
						query = query + " and budget_definition_id = '" + budgetDefId + "'";
						queryCount = queryCount + " and budget_definition_id = '" + budgetDefId + "'";
						utilizedQuery = utilizedQuery + " and purchase_order.budget_type_id  = " + budgetDefId + "";
						utilizedQueryCount = utilizedQueryCount + " and purchase_order.budget_type_id  = " + budgetDefId
								+ "";

						if (costCenter != null) {
							if (costCenter != "") {
								query = query + "      and  cost_center = '" + costCenter + "'";
								queryCount = queryCount + "  and  cost_center = '" + costCenter + "'";
							}
						}
					}
					double balanceAmt = 0;
					double UAmt = 0;
					DecimalFormat df = new DecimalFormat("0.00");
					int count = jdbcTemplate.queryForObject(queryCount, Integer.class);
					if (count > 0) {
						double budgetVal = jdbcTemplate.queryForObject(query, Double.class);
						CashBankPaymentBean.setBudgetAmt(budgetVal);
						double paidVal = 0;
						UAmt = jdbcTemplate.queryForObject(utilizedQueryCount, Double.class);
						if (UAmt > 0) {
							paidVal = jdbcTemplate.queryForObject(utilizedQuery, Double.class);
							CashBankPaymentBean.setBudgetUtilizedAmt(paidVal);
							// if (budgetVal <= (paidVal +
							// objCashBankPaymentDetailBean.getCbpDtlBcAmount()))
							// msg += "Payment Exceeding Budget Limit For
							// Category :
							// " +
							// subGrp;
							balanceAmt = budgetVal - paidVal;
							// if (balanceAmt <
							// objCashBankPaymentDetailBean.getCbpDtlBcAmount())
							// {
							// // msg += "Row " + rowCount + " There is no
							// // budget
							// // allocated for this expense ! ";
							//// msg += "Row " + rowCount + " Amount entered is
							// greater than the Allocated/Balance budget (" +
							// df.format(budgetVal - paidVal) + ")";
							//
							// }
						} else {
							// if (budgetVal > 0)
							// msg = "";

							// else if (budgetVal == 0)
							// msg += "Row " + rowCount + " The cost center you
							// have
							// entered is not having any budget allocated ! ";
							// else
							// msg += "Row " + rowCount + " Amount entered is
							// greater than the Allocated/Balance budget (" +
							// df.format(budgetVal - paidVal) + ")";

						}
					}
					if (count <= 0) {
						// msg += "Row " + rowCount + " The cost center you have
						// entered is not having any budget allocated ! ";
					}
					// else
					// success = true;
					// }
				}
			} else {
				/*
				 * if (msg == "") msg = "";
				 */}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CashBankPaymentBean;

	}

	@Override
	public CashBankPaymentResultBean getReceiptNo(String pmtype, String cashbankPmtDate, String accountName)
			throws CustomException {
		CashBankPaymentResultBean resultBean = new CashBankPaymentResultBean();
		CashBankPaymentBean objCashBankReceiptListBean = new CashBankPaymentBean();

		try {
			objCashBankReceiptListBean.setPmtType(pmtype);
			objCashBankReceiptListBean.setCashbankPmtDate(cashbankPmtDate);
			objCashBankReceiptListBean.setAccountName(accountName);
			String cbVoucherNo = generateCashbankPaymentCode(objCashBankReceiptListBean.getPmtType(),
					objCashBankReceiptListBean);
			resultBean.setCbVoucherNo(cbVoucherNo);
			resultBean.setMessage("success");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public List<CashBankPaymentBean> subPaymentList() {
		List<CashBankPaymentBean> lBankAcctListcompany = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcompany = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_PAyment, new Object[] {},
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcompany;
	}

	@Override
	public List<CashBankPaymentBean> receiptList() {
		List<CashBankPaymentBean> lBankAcctListcompany = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcompany = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_receipt, new Object[] {},
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcompany;
	}

	@Override
	public List<CashBankPaymentBean> subPaymentreceiptList() {
		List<CashBankPaymentBean> lBankAcctListcompany = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lBankAcctListcompany = jdbcTemplate.query(CashBankPaymentQueryUtil.GET_receipt_payment, new Object[] {},
					new BeanPropertyRowMapper<>(CashBankPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return lBankAcctListcompany;
	}
}
