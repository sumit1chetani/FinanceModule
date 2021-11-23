package com.dci.tenant.finance.paymentOrder;

import java.sql.Date;
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

import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.finance.cashbankpayment.CashBankPaymentQueryUtil;
import com.dci.tenant.finance.paymentInformation.PaymentInformationBean;
import com.dci.tenant.finance.paymentInformation.PaymentInformationDetailBean;
import com.dci.tenant.finance.purchaseorder.PurchaseConstants;
import com.dci.tenant.user.UserDetail;

@Repository
public class PaymentOrderDAOImpl implements PaymentOrderDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(PaymentOrderDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<PaymentOrderBean> getPaymentOrderList() throws CustomException {
		List<PaymentOrderBean> paymentOrderBeans = new ArrayList<>();
		try {

			paymentOrderBeans = jdbcTemplate.query(PaymentOrderQueryUtil.SAVE_PAYMENT_ORDER_LIST, new BeanPropertyRowMapper<>(PaymentOrderBean.class));

			for (PaymentOrderBean orderBean : paymentOrderBeans) {

				PaymentInformationBean paymentInformationBean = new PaymentInformationBean();

				List<PaymentInformationDetailBean> detailList = new ArrayList<>();

				paymentInformationBean = jdbcTemplate.queryForObject(PaymentOrderQueryUtil.GET_POR_HDR, new Object[] { orderBean.getPaymentOrderNo() }, new BeanPropertyRowMapper<>(PaymentInformationBean.class));

				detailList = jdbcTemplate.query(PaymentOrderQueryUtil.GET_POR_DTL_LIST, new BeanPropertyRowMapper<>(PaymentInformationDetailBean.class), orderBean.getPaymentOrderNo());

				paymentInformationBean.setDetailBeans(detailList);

				orderBean.setInvoiceDtlBean(paymentInformationBean);

			}

		} catch (Exception e) {
			LOGGER.error("Error in slabRateList", e);
		}
		return paymentOrderBeans;
	}

	@Override
	public List<PaymentOrderBankBean> getCashBankList() throws CustomException {

		List<PaymentOrderBankBean> paBankBeanslist = new ArrayList<>();
		try {

			paBankBeanslist = jdbcTemplate.query(PaymentOrderQueryUtil.SELCT_ALL_PAYMENT_LIST, new BeanPropertyRowMapper<>(PaymentOrderBankBean.class));

		} catch (Exception e) {
			LOGGER.error("Error in slabRateList", e);
		}
		return paBankBeanslist;
	}

	@Override
	public List<PaymentOrderBankBean> getChequeList(String AccountCode) throws CustomException {

		List<PaymentOrderBankBean> pChequeList = new ArrayList<>();
		try {

			pChequeList = jdbcTemplate.query(PaymentOrderQueryUtil.SELECT_CHEQUE_LIST, new BeanPropertyRowMapper<>(PaymentOrderBankBean.class), AccountCode);

		} catch (Exception e) {
			LOGGER.error("Error in slabRateList", e);
		}
		return pChequeList;
	}

	@Override
	public List<PaymentOrderBankBean> generatePayment(ArrayList<PaymentOrderBean> payOrderList) throws CustomException {
		List<PaymentOrderBankBean> pChequeList = new ArrayList<>();
		boolean isSuccess = false;
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();

			for (PaymentOrderBean objCashBankPaymentBean : payOrderList) {

				if (objCashBankPaymentBean.isSelect() == true) {

					String cbVoucherNo = generateCashbankPaymentCode(objCashBankPaymentBean.getBankAccountType());
					objCashBankPaymentBean.setVoucherNumber(cbVoucherNo);
					Date voucherDate = CommonUtil.convertSqlDateFormat(objCashBankPaymentBean.getChequeDate());
					Date chequeDate = null;
					String pmtType = null;

					if (objCashBankPaymentBean.getBankAccountType().equalsIgnoreCase("bank")) {
						pmtType = "B";
						chequeDate = CommonUtil.convertSqlDateFormat(objCashBankPaymentBean.getChequeDate());
					} else if (objCashBankPaymentBean.getBankAccountType().equalsIgnoreCase("cash")) {
						pmtType = "C";
						chequeDate = null;
					}

					String companyCode = objCashBankPaymentBean.getCompanyCode();

					String acctName = objCashBankPaymentBean.getAcctHead();
					String currCode = objCashBankPaymentBean.getCashPaycurrency();
					double exchangeRate = objCashBankPaymentBean.getCashPayExRate();
					String chequeNo = objCashBankPaymentBean.getChequeNo();
					String invoiceref = objCashBankPaymentBean.getInvoiceref();

					double bcAmtHdr = objCashBankPaymentBean.getCashPayBcAmt();
					double tcAmtHdr = objCashBankPaymentBean.getCashPayTcAmt();

					String narration = "updated via payment order";

					int iSave = jdbcTemplate.update(PaymentOrderQueryUtil.SAVE_CASH_BANK_PMT_HDR, new Object[] { cbVoucherNo, pmtType, acctName, exchangeRate, chequeNo, invoiceref, chequeDate, bcAmtHdr, tcAmtHdr, narration, userId, companyCode });

					if (iSave > 0) {

						HashMap<String, Object> chqBookMap = new HashMap<>();

						if (pmtType.equalsIgnoreCase("B")) {
							chqBookMap.put("chequeDate", objCashBankPaymentBean.getChequeDate());
							chqBookMap.put("narration", narration);
							chqBookMap.put("chequeStatus", 179);
							chqBookMap.put("bcAmountHdr", objCashBankPaymentBean.getCashPayBcAmt());
							chqBookMap.put("bankaccount", objCashBankPaymentBean.getAcctHead());
							chqBookMap.put("chqBookId", objCashBankPaymentBean.getChequeNo());
							namedParameterJdbcTemplate.update(PaymentOrderQueryUtil.UPDATE_CHQ_BOOK, chqBookMap);

						}

					}

					isSuccess = saveCashBankPmtDetail(objCashBankPaymentBean, cbVoucherNo);

				}

			}
		} catch (Exception e) {
			LOGGER.error("Error in slabRateList", e);
		}
		return pChequeList;
	}

	private boolean saveCashBankPmtDetail(PaymentOrderBean objCashBankPaymentBean, String cbVoucherNo) {
		boolean success = false;

		Object[] cbpdtlSaveParams = new Object[] { cbVoucherNo, PurchaseConstants.TRADE_CREDITORS_AH, objCashBankPaymentBean.getPaymentOrderNo(), objCashBankPaymentBean.getCurrency(), objCashBankPaymentBean.getCashPayExRate(), objCashBankPaymentBean.getCashPayBcAmt(), objCashBankPaymentBean.getCashPayTcAmt(), PurchaseConstants.TRADE_CREDITORS_SG, 1, objCashBankPaymentBean.getSupplier(), objCashBankPaymentBean.getCompanyCode() };

		int iCbpDtl = jdbcTemplate.queryForObject(PaymentOrderQueryUtil.SAVE_CASH_BANK_PMT_DTL, cbpdtlSaveParams, Integer.class);

		for (PaymentInformationDetailBean detailBean : objCashBankPaymentBean.getInvoiceDtlBean().getDetailBeans()) {

			int invDtl = jdbcTemplate.update(PaymentOrderQueryUtil.SAVE_CASH_BANK_PMT_INVOICE_DTL, new Object[] { iCbpDtl, detailBean.getInvoiceNo(), detailBean.getInvBcAmt(), detailBean.getInvTcAmt(), detailBean.getPayableBcAmt(), detailBean.getPayableTcAmt(), objCashBankPaymentBean.getCurrency(), objCashBankPaymentBean.getExRate(), objCashBankPaymentBean.getPaymentOrderNo() });

			PaymentInformationDetailBean informationDetailBeanBcAmt = new PaymentInformationDetailBean();

			informationDetailBeanBcAmt = jdbcTemplate.queryForObject(PaymentOrderQueryUtil.GET_TOATAL_PAY_AMOUNT, new Object[] { detailBean.getInvoiceNo() }, new BeanPropertyRowMapper<>(PaymentInformationDetailBean.class));

			detailBean.setTotalPaidBcAmt(informationDetailBeanBcAmt.getTotalPaidBcAmt());
			detailBean.setTotatlPaidTcAmt(informationDetailBeanBcAmt.getTotatlPaidTcAmt());

			updatePurchaseInvoicePaymentStatus(objCashBankPaymentBean.getCashPaycurrency(), detailBean.getTotalPaidBcAmt(), detailBean.getTotatlPaidTcAmt(), detailBean.getInvBcAmt(), detailBean.getInvTcAmt(), detailBean.getInvoiceNo());

		}

		success = saveCBPmtGeneralLedgerCreditEntry(objCashBankPaymentBean, cbVoucherNo);

		success = saveCBPmtGeneralLedgerDebitEntry(objCashBankPaymentBean, cbVoucherNo);

		return success;

	}

	private void updatePurchaseInvoicePaymentStatus(String currency, Double totalBcAmt, Double totalTcAmt, Double invBcAmt, Double invTcAmt, String sPInvoiceNo) {
		double amount = 0;
		double totalAmt = 0;
		String pmtStatus = "";
		try {

			if ("INR".equalsIgnoreCase(currency)) {

				if (String.valueOf(invBcAmt).equalsIgnoreCase(String.valueOf(totalBcAmt))) {
					pmtStatus = "Fully Paid";
				} else {
					pmtStatus = "Part Paid";
				}

				jdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_PAYMENT_STATUS_PIN_HDR, new Object[] { pmtStatus, sPInvoiceNo });

			} else if (!"INR".equalsIgnoreCase(currency)) {

				if (invTcAmt == totalTcAmt) {
					pmtStatus = "Fully Paid";
				} else {
					pmtStatus = "Part Paid";
				}

				jdbcTemplate.update(CashBankPaymentQueryUtil.UPDATE_PAYMENT_STATUS_PIN_HDR, new Object[] { pmtStatus, sPInvoiceNo });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
	}

	private boolean saveCBPmtGeneralLedgerCreditEntry(PaymentOrderBean objCashBankPaymentBean, String cbVoucherNo) {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(CashBankPaymentQueryUtil.INSERT_GENERAL_LEDGER_CREDIT_ENTRY_PAYMENT, new Object[] { cbVoucherNo });
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
	private boolean saveCBPmtGeneralLedgerDebitEntry(PaymentOrderBean objCashBankPaymentBean, String cbVoucherNo) {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(CashBankPaymentQueryUtil.INSERT_GENERAL_LEDGER_DEBIT_ENTRY_PAYMENT, new Object[] { cbVoucherNo });
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
		return isSuccess;
	}

	private String generateCashbankPaymentCode(String pmtType) {

		String voucherNo = "";
		String sCBPYear = "", sDefaultCBPNo = "", pmtCode = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

			if (pmtType.equalsIgnoreCase("bank")) {
				sCurrentYear = sCurrentYear.substring(2);
				pmtCode = "BP";
				sCBPYear = "BP" + sCurrentYear + "%";
				sDefaultCBPNo = "BP" + sCurrentYear + "00001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(PaymentOrderQueryUtil.AUTOGEN_CASHBANK_VOUCHER_NO, new Object[] { sDefaultCBPNo, pmtCode, sCBPYear });
				for (Map row : rows) {
					voucherNo = (String) row.get("VOUCHER_NO");
				}

			} else if (pmtType.equalsIgnoreCase("cash")) {

				sCurrentYear = sCurrentYear.substring(2);
				pmtCode = "CP";
				sCBPYear = "CP" + sCurrentYear + "%";
				sDefaultCBPNo = "CP" + sCurrentYear + "00001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(PaymentOrderQueryUtil.AUTOGEN_CASHBANK_VOUCHER_NO, new Object[] { sDefaultCBPNo, pmtCode, sCBPYear });
				for (Map row : rows) {
					voucherNo = (String) row.get("VOUCHER_NO");
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate VOUCHER Number", e);
		}
		return voucherNo;
	}

	@Override
	public List<PaymentOrderBean> searchList(String companyCode) throws CustomException {
		// TODO Auto-generated method stub

		List<PaymentOrderBean> paymentOrderBeans = new ArrayList<>();
		try {

			paymentOrderBeans = jdbcTemplate.query(PaymentOrderQueryUtil.SAVE_PAYMENT_ORDER_SEARCH_LIST, new BeanPropertyRowMapper<>(PaymentOrderBean.class), companyCode);

			for (PaymentOrderBean orderBean : paymentOrderBeans) {

				PaymentInformationBean paymentInformationBean = new PaymentInformationBean();

				List<PaymentInformationDetailBean> detailList = new ArrayList<>();

				paymentInformationBean = jdbcTemplate.queryForObject(PaymentOrderQueryUtil.GET_POR_HDR, new Object[] { orderBean.getPaymentOrderNo() }, new BeanPropertyRowMapper<>(PaymentInformationBean.class));

				detailList = jdbcTemplate.query(PaymentOrderQueryUtil.GET_POR_DTL_LIST, new BeanPropertyRowMapper<>(PaymentInformationDetailBean.class), orderBean.getPaymentOrderNo());

				paymentInformationBean.setDetailBeans(detailList);

				orderBean.setInvoiceDtlBean(paymentInformationBean);

			}

		} catch (Exception e) {
			LOGGER.error("Error in slabRateList", e);
		}
		return paymentOrderBeans;

	}
}
