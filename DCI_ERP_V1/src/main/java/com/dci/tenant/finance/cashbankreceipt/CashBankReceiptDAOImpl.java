package com.dci.tenant.finance.cashbankreceipt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.AccountsConstants;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.NumberstoWordsConversion;
import com.dci.tenant.finance.cashbankpayment.CashBankPaymentQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class CashBankReceiptDAOImpl implements CashBankReceiptDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(CashBankReceiptDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	NumberstoWordsConversion wordingConversion;

	
	@Override
	public CashBankReceiptResultBean getBankDrpDwn() throws CustomException {
		CashBankReceiptResultBean resultBean = new CashBankReceiptResultBean();
		List<SelectivityBean> bankList = new ArrayList<>();
		try {
			bankList = jdbcTemplate.query(CashBankReceiptQueryUtil.bankAccountDub, new Object[] { AccountsConstants.BANK_SG }, new BeanPropertyRowMapper<>(SelectivityBean.class));
			resultBean.setObjCashBankReceiptListBean(bankList);
			resultBean.setMessage("success");
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Bank Account List", e);
			resultBean.setMessage("failure");
		}
		return resultBean;
	}

	@Override
	public CashBankReceiptResultBean getCashDrpDwn() throws CustomException {
		CashBankReceiptResultBean resultBean = new CashBankReceiptResultBean();
		List<SelectivityBean> cashList = new ArrayList<>();
		try {
			cashList = jdbcTemplate.query(CashBankReceiptQueryUtil.cashAccountDub, new Object[] {}, new BeanPropertyRowMapper<>(SelectivityBean.class));
			resultBean.setObjCashBankReceiptListBean(cashList);
			resultBean.setMessage("success");
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Currency List", e);
			throw new CustomException("Error in Get Currency List");
		}
		return resultBean;
	}

	@Override
	public CashBankReceiptResultBean getCurrencyAndExchangeRate(String accountNo) throws CustomException {
		CashBankReceiptResultBean resultBean = new CashBankReceiptResultBean();
		List<CashBankReceiptListBean> lCurrExgList = new ArrayList<>();
		try {
			lCurrExgList = jdbcTemplate.query(CashBankReceiptQueryUtil.onSelectAc, new Object[] { accountNo }, new BeanPropertyRowMapper<>(CashBankReceiptListBean.class));

			resultBean.setObjCashBankReceiptListListBean(lCurrExgList);
			resultBean.setMessage("success");
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Currency List", e);
		}
		return resultBean;
	}

	@Override
	public List<CashBankReceiptListBean> getReceivedFromList() {
		List<CashBankReceiptListBean> lReceivedFromList = new ArrayList<>();

		try {

			lReceivedFromList = jdbcTemplate.query(CashBankReceiptQueryUtil.GET_RECEIVED_FROM_LIST, new BeanPropertyRowMapper<>(CashBankReceiptListBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Received From List", e);
		}
		return lReceivedFromList;
	}

	//stage 1 REC
	@Override
	public boolean addCashBankReceiptHdr(CashBankReceiptListBean objCashBankReceiptListBean, String userId, String companyCode) throws CustomException {

		boolean isSuccess = false;
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);
			String voucherNo = "";
			/*try {
				voucherNo = getVoucherNo(objCashBankReceiptListBean.getPaymentMode(), objCashBankReceiptListBean);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			Date chequeDate = null;
			//objCashBankReceiptListBean.setVoucherNo(voucherNo);

			Date cbReceiptDate = CommonUtil.convertSqlDateFormat(objCashBankReceiptListBean.getCbReceiptDate());
			if (objCashBankReceiptListBean.getPaymentMode().equalsIgnoreCase("B")) {
				chequeDate = CommonUtil.convertSqlDateFormat(objCashBankReceiptListBean.getChequeDate());

			} else if (objCashBankReceiptListBean.getPaymentMode().equalsIgnoreCase("C")) {
				chequeDate = null;
			}

			int iCBRHdr =  jdbcTemplate.update(CashBankReceiptQueryUtil.SAVE_CASHBANK_RECEIPT_HDR, new Object[] { objCashBankReceiptListBean.getVoucherNo(), cbReceiptDate, objCashBankReceiptListBean.getPaymentMode(), objCashBankReceiptListBean.getAccountName(), objCashBankReceiptListBean.getExchangeRate(), objCashBankReceiptListBean.getNarration(), userId, objCashBankReceiptListBean.getChequeNO(), objCashBankReceiptListBean.getBcAmountHdr(), objCashBankReceiptListBean.getBcAmountHdr(), objCashBankReceiptListBean.getReceivedFrom(), chequeDate,
					objCashBankReceiptListBean.getCompanyCode(), objCashBankReceiptListBean.getCostCenter() ,objCashBankReceiptListBean.getReceiptfrom(),objCashBankReceiptListBean.getApprovenote()});
			
			
			if (iCBRHdr > 0)
				isSuccess = saveCashBankReceiptDetail(objCashBankReceiptListBean, chequeDate);
			

			if (isSuccess) {				 
				isSuccess = saveCBReceiptGeneralLedgerDebitEntry(objCashBankReceiptListBean);
				isSuccess = saveCBReceiptGeneralLedgerCreditEntry(objCashBankReceiptListBean);
			}

			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Unable to Save!", e);
		}
		return isSuccess;
	}

	// REC stage 2
	private boolean saveCashBankReceiptDetail(CashBankReceiptListBean objCashBankReceiptListBean, Date chequeDate) {
		boolean flagCBRcptDet = false;	
		try {			
			int iCounter = 1;
			List<CashBankReceiptDetailBean> lcbRcptBankDetailList = objCashBankReceiptListBean.getCshBankDetail();
			for (CashBankReceiptDetailBean objCBRcptDetailBean : lcbRcptBankDetailList) {
				
				objCBRcptDetailBean.setSiNo(iCounter);				
				 System.out.println("Sub Group ==== " +objCBRcptDetailBean.getSubAccountCode() );
				System.out.println("Receive From ==== " +objCashBankReceiptListBean.getReceiptfrom());
				System.out.println("receipt from ==== " +objCashBankReceiptListBean.getReceiptfrom()); 				  
				
				objCBRcptDetailBean.setAcctName(objCBRcptDetailBean.getSubAccountCode());
				objCBRcptDetailBean.getSubAccountCode();
				objCBRcptDetailBean.setSubgroupcode(objCBRcptDetailBean.getAcctName().substring(0, 4));
				
				System.out.println("Account head Rec1 = " +objCBRcptDetailBean.getAcctName());
				System.out.println("Account head Rec2 = " +objCBRcptDetailBean.getSubgroupcode());
				System.out.println("Account head Rec3 = " +objCBRcptDetailBean.getAcctName().substring(0, 4));
				
				

				Object[] cbrdtlParams = new Object[] { objCashBankReceiptListBean.getVoucherNo(), objCBRcptDetailBean.getAcctName(), objCBRcptDetailBean.getGenInvoiceNo(), objCashBankReceiptListBean.getChequeNO(), chequeDate, "INR", objCBRcptDetailBean.getExgRate(), objCBRcptDetailBean.getTcamount(), objCBRcptDetailBean.getTcamount(), objCBRcptDetailBean.getDepartmentCode(), objCBRcptDetailBean.getSubgroupcode(), objCBRcptDetailBean.getSiNo(), objCBRcptDetailBean.getSubAccountCode(), objCBRcptDetailBean.getEmployeeCode(),
						objCBRcptDetailBean.getCountryCode(), objCBRcptDetailBean.getCustomerCode(), objCBRcptDetailBean.getSupplierCode(), objCBRcptDetailBean.getDesignationCode(), objCBRcptDetailBean.getCompanyCode(), objCBRcptDetailBean.getCostCenter(), objCBRcptDetailBean.getPatientCode() ,objCBRcptDetailBean.getReceipt()};
				
				int iCBRDtl = jdbcTemplate.queryForObject(CashBankReceiptQueryUtil.SAVE_CASHBANK_RECEIPT_DTL, cbrdtlParams, Integer.class);

				if (iCBRDtl > 0) {

					objCBRcptDetailBean.setCashBankRcptDtlId(iCBRDtl);
					if (objCBRcptDetailBean.getInvoicePaymentList() != null) {
						List<CashBankReceiptInvoiceDetailBean> cbrcptInvoiceData = objCBRcptDetailBean.getInvoicePaymentList();

						for (CashBankReceiptInvoiceDetailBean objCBRcptInvDtlBean : cbrcptInvoiceData)

						{
							flagCBRcptDet = saveCashBankReceiptInvoiceDetail(objCashBankReceiptListBean, objCBRcptDetailBean, objCBRcptInvDtlBean);
							// if (flagCBRcptDet)  
							// updateSalesInvoiceInvoiceRecevedStatus(objCBRcptInvDtlBean); 
						}
					}
				}

				flagCBRcptDet = true;
				iCounter++;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Cash Bank Receipt Detail Records!", e);
		}

		return flagCBRcptDet;
	}
	
	// stage 3 CBR
	private boolean saveCashBankReceiptInvoiceDetail(CashBankReceiptListBean objCashBankReceiptListBean, CashBankReceiptDetailBean objCBRcptDetailBean, CashBankReceiptInvoiceDetailBean objCBRcptInvDtlBean) {
		boolean isSuccess = false;
		try {

			int iCbrInvDtl = jdbcTemplate.update(CashBankReceiptQueryUtil.SAVE_CASH_BANK_RCPT_INVOICE_DTL, new Object[] { objCBRcptDetailBean.getCashBankRcptDtlId(), objCBRcptInvDtlBean.getInvoiceNo(), objCBRcptInvDtlBean.getTcAmount(), objCBRcptInvDtlBean.getTcAmount(), objCBRcptInvDtlBean.getPendingAmount(), objCBRcptInvDtlBean.getPendingAmount(), objCBRcptInvDtlBean.getExchangeRate(), objCBRcptInvDtlBean.getCurrency() });
			if (iCbrInvDtl > 0)
				isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Cash Bank Receipt Invoice Detail  Records!", e);
		}
		return isSuccess;
	}

	private void updateSalesInvoiceInvoiceRecevedStatus(CashBankReceiptInvoiceDetailBean objCBRcptInvDtlBean) {
		double amount = 0;
		String rcvdStatus = "";
		try {
			double bcBalanceAmt = objCBRcptInvDtlBean.getBcBalanceAmt();
			double bcPaidAmt = objCBRcptInvDtlBean.getBcPaidAmt();
			double tcBalanceAmt = objCBRcptInvDtlBean.getTcBalanceAmt();
			double tcPaidAmt = objCBRcptInvDtlBean.getTcPaidAmt();

			if ("INR".equalsIgnoreCase(objCBRcptInvDtlBean.getCurrency())) {
				amount = bcBalanceAmt - bcPaidAmt;

				if (amount <= 0.0) {
					rcvdStatus = "Received";
				} else {
					rcvdStatus = "Partially Received";
				}

				jdbcTemplate.update(CashBankReceiptQueryUtil.UPDATE_RECEIVED_STATUS_SALES_INVOICE_HDR, new Object[] { rcvdStatus, objCBRcptInvDtlBean.getgInvoiceNo() });

			} else if (!"INR".equalsIgnoreCase(objCBRcptInvDtlBean.getCurrency())) {
				amount = tcBalanceAmt - tcPaidAmt;

				if (amount <= 0.0) {
					rcvdStatus = "Received";
				} else {
					rcvdStatus = "Partially Received";
				}

				jdbcTemplate.update(CashBankReceiptQueryUtil.UPDATE_RECEIVED_STATUS_SALES_INVOICE_HDR, new Object[] { rcvdStatus, objCBRcptInvDtlBean.getgInvoiceNo() });
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in update the Received Status!", e);
		}

	}

	/**
	 * Header Debit entry
	 * 
	 * @param objCashBankReceiptListBean
	 * @return
	 */
	private boolean saveCBReceiptGeneralLedgerCreditEntryReversal(String objCashBankReceiptListBean) {
		boolean isSuccess = false;
		try {
			int iGLCredit = jdbcTemplate.update(CashBankReceiptQueryUtil.INSERT_GENERAL_LEDGER_CREDIT_ENTRY_FOR_RECEIPT, new Object[] { objCashBankReceiptListBean });
			if (iGLCredit > 0) {
				isSuccess = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
		return isSuccess;
	}

	private boolean saveCBReceiptGeneralLedgerDebitEntryReversal(String objCashBankReceiptListBean) {
		boolean isSuccess = false;
		try {
			int iGLDebit = jdbcTemplate.update(CashBankReceiptQueryUtil.INSERT_GENERAL_LEDGER_DEBIT_ENTRY_FOR_RECEIPT, new Object[] { objCashBankReceiptListBean });
			if (iGLDebit > 0) {
				isSuccess = true;
			}
		} catch (DataAccessException e) {
			isSuccess = false;
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
		return isSuccess;
	}

	//stage 4 CBR
	private boolean saveCBReceiptGeneralLedgerDebitEntry(CashBankReceiptListBean objCashBankReceiptListBean) {
		boolean isSuccess = false;
		try {
			int iGLDebit = jdbcTemplate.update(CashBankReceiptQueryUtil.INSERT_GENERAL_LEDGER_DEBIT_ENTRY_FOR_RECEIPT, new Object[] { objCashBankReceiptListBean.getVoucherNo() });
			if (iGLDebit > 0) {
				isSuccess = true;
			}
		} catch (DataAccessException e) {
			isSuccess = false;
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
		return isSuccess;
	}

	
	/**
	 * Detail Credit Entry stage 4
	 * 
	 * @param objCashBankReceiptListBean
	 * @return
	 */
	private boolean saveCBReceiptGeneralLedgerCreditEntry(CashBankReceiptListBean objCashBankReceiptListBean) {
		boolean isSuccess = false;
		try {
			int iGLCredit = jdbcTemplate.update(CashBankReceiptQueryUtil.INSERT_GENERAL_LEDGER_CREDIT_ENTRY_FOR_RECEIPT, new Object[] { objCashBankReceiptListBean.getVoucherNo() });
			if (iGLCredit > 0) {
				isSuccess = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in save the General Ledger Records!", e);
		}
		return isSuccess;
	}

	public String getVoucherNo(String pmtType, CashBankReceiptListBean bean) throws CustomException, ParseException {

		String voucherNo = "";
		String sCBRYear = "", sDefaultCBRNo = "", pmtCode = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// String sCurrentYear =
			// String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(bean.getCbReceiptDate());
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String receiptDateyear = df.format(date);
			String sCurrentYear = receiptDateyear.substring(2);

			if (pmtType.equalsIgnoreCase("B")) {
				// sCurrentYear = sCurrentYear.substring(2);
				pmtCode = "BR";
				sCBRYear = "BR" + sCurrentYear + "%";
				sDefaultCBRNo = "BR" + sCurrentYear + "00001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.AUTOGEN_RECEIPT_VOUCHER_NO, new Object[] { sDefaultCBRNo, pmtCode, sCBRYear });
				for (Map row : rows) {
					voucherNo = (String) row.get("VOUCHER_NO");
				}

			} else if (pmtType.equalsIgnoreCase("C")) {

				// sCurrentYear = sCurrentYear.substring(2);
				pmtCode = "CR";
				sCBRYear = "CR" + sCurrentYear + "%";
				sDefaultCBRNo = "CR" + sCurrentYear + "00001";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.AUTOGEN_RECEIPT_VOUCHER_NO, new Object[] { sDefaultCBRNo, pmtCode, sCBRYear });
				for (Map row : rows) {
					voucherNo = (String) row.get("VOUCHER_NO");
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate VOUCHER Number", e);
		}
		return voucherNo;
	}

	public String getlocationName(String compCode) throws CustomException {
		String locnName = "";
		try {
			List<Map<String, Object>> locationRows = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.sGetLocation, new Object[] { compCode });
			for (Map row : locationRows) {
				locnName = (String) row.get("location");
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Currency List", e);
			throw new CustomException("Error in Get Currency List");
		}
		return locnName;
	}

	@Override
	public List<CashBankReceiptListBean> getCashBankReceiptHdrList(int limit, int offset) {
		List<CashBankReceiptListBean> lCBRcptHdrList = new ArrayList<>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCBRcptHdrList = jdbcTemplate.query(CashBankReceiptQueryUtil.GET_CASHBANK_RCPT_HDR_LIST, new BeanPropertyRowMapper<>(CashBankReceiptListBean.class));

		} catch (DataAccessException e) {
			e.printStackTrace();
			LOGGER.error("Error in Reconcile List", e);
		}
		return lCBRcptHdrList;
	}

	@Override
	public boolean deleteCashBankReceiptData(String voucherNo) {
		boolean isDeleted = false;
		try {
			int iCBRHdr = 0;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int iCBRInv = jdbcTemplate.update(CashBankReceiptQueryUtil.DELETE_CASHBANK_RCPT_INVOICE_DTL, new Object[] { voucherNo });
			int iCBR = jdbcTemplate.update(CashBankReceiptQueryUtil.DELETE_CASHBANK_RCPT_DTL, new Object[] { voucherNo });

			iCBRHdr = jdbcTemplate.update(CashBankReceiptQueryUtil.DELETE_CASHBANK_RCPT_HDR, new Object[] { voucherNo });

			if (iCBRHdr > 0)
				isDeleted = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in delete Cash Bank Receipt list", e);
		}
		return isDeleted;
	}

	@Override
	public CashBankReceiptListBean getReceiptVoucherDetailforEdit(String voucherNo) {
		CashBankReceiptListBean objCashBankReceiptListBean = new CashBankReceiptListBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			objCashBankReceiptListBean = jdbcTemplate.queryForObject(CashBankReceiptQueryUtil.GET_RECEIPT_VOUCHER_HDR, new Object[] { voucherNo }, new BeanPropertyRowMapper<>(CashBankReceiptListBean.class));

			List<SelectivityBean> lCashBankAcctList = new ArrayList<>();
			if ("B".equalsIgnoreCase(objCashBankReceiptListBean.getPaymentMode()))
				lCashBankAcctList = jdbcTemplate.query(CashBankReceiptQueryUtil.bankAccountDub, new Object[] { AccountsConstants.BANK_SG }, new BeanPropertyRowMapper<>(SelectivityBean.class));
			else
				lCashBankAcctList = jdbcTemplate.query(CashBankReceiptQueryUtil.cashAccountDub, new BeanPropertyRowMapper<>(SelectivityBean.class));

			objCashBankReceiptListBean.setlCashBankAccountList(lCashBankAcctList);

			List<CashBankReceiptDetailBean> lDetailList = new ArrayList<>();
			lDetailList = getReceiptVoucherDetailList(voucherNo);
			objCashBankReceiptListBean.setCshBankDetail(lDetailList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Receipt Header Detail", e);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return objCashBankReceiptListBean;
	}

	public List<CashBankReceiptDetailBean> getReceiptVoucherDetailList(String sVoucherNo) throws CustomException {
		List<CashBankReceiptDetailBean> dtlDataList = new ArrayList<>();
		List<CashBankReceiptInvoiceDetailBean> lInvoiceRcptData = new ArrayList<>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			dtlDataList = jdbcTemplate.query(CashBankReceiptQueryUtil.GET_RECEIPT_VOUCHER_DTL, new Object[] { sVoucherNo }, new BeanPropertyRowMapper<>(CashBankReceiptDetailBean.class));
			/*
			 * for (CashBankReceiptDetailBean row : dtlDataList) { lInvoiceRcptData =
			 * jdbcTemplate.query(CashBankReceiptQueryUtil.GET_RCPT_INVOICE_DTL, new
			 * Object[] { row.getCashBankRcptDtlId() }, new
			 * BeanPropertyRowMapper<>(CashBankReceiptInvoiceDetailBean.class));
			 * row.setInvoicePaymentList(lInvoiceRcptData); }
			 */
		} catch (Exception e) {
			LOGGER.error("Error in Get Detail list", e);
			throw new CustomException("Error in Get Detail list");
		}
		return dtlDataList;
	}

	@Override
	public boolean updateCashBankReceiptData(CashBankReceiptListBean objCashBankReceiptListBean) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSuccess = false;
		Date chequeDate = null;
		try {
			Date cbReceiptDate = CommonUtil.convertSqlDateFormat(objCashBankReceiptListBean.getCbReceiptDate());
			if (objCashBankReceiptListBean.getPaymentMode().equalsIgnoreCase("B")) {
				chequeDate = CommonUtil.convertSqlDateFormat(objCashBankReceiptListBean.getChequeDate());
			} else if (objCashBankReceiptListBean.getPaymentMode().equalsIgnoreCase("C")) {
				chequeDate = null;
			}

			int iHdrUpd = jdbcTemplate.update(CashBankReceiptQueryUtil.UPDATE_CBRECEIPT_HDR, new Object[] { cbReceiptDate, objCashBankReceiptListBean.getPaymentMode(), objCashBankReceiptListBean.getAccountName(), objCashBankReceiptListBean.getExchangeRate(), objCashBankReceiptListBean.getChequeNO(), chequeDate, objCashBankReceiptListBean.getBcAmountHdr(), objCashBankReceiptListBean.getTcAmountHdr(), objCashBankReceiptListBean.getNarration(), objCashBankReceiptListBean.getCompanyCode(), objCashBankReceiptListBean.getCostCenter(),
					objCashBankReceiptListBean.getReceivedFrom(), objCashBankReceiptListBean.getReceiptfrom(), userDetails.getUserId(), objCashBankReceiptListBean.getVoucherNo() });

			if (iHdrUpd > 0) {
				isSuccess = updateCashBankReceiptVoucherDetail(objCashBankReceiptListBean, chequeDate); //
			}

			if (isSuccess) {
				int iGLDel = jdbcTemplate.update(CashBankReceiptQueryUtil.DELETE_GENERAL_LEDGER, new Object[] { objCashBankReceiptListBean.getVoucherNo() });
				if (iGLDel > 0) {
					//isSuccess = saveCBReceiptGeneralLedgerDebitEntry(objCashBankReceiptListBean);
					//isSuccess = saveCBReceiptGeneralLedgerCreditEntry(objCashBankReceiptListBean);
				}
			}

			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Unable to Save!", e);
		}
		return isSuccess;
	}

	private boolean updateCashBankReceiptVoucherDetail(CashBankReceiptListBean objCashBankReceiptListBean, Date chequeDate) {
		boolean isSuccess = false;

		int iCounter = 1;
		List<CashBankReceiptDetailBean> cbRcptTableData = objCashBankReceiptListBean.getCshBankDetail();
		for (CashBankReceiptDetailBean objCBRcptDetailBean : cbRcptTableData) {

			objCBRcptDetailBean.setSiNo(iCounter);
			objCBRcptDetailBean.setSubgroupcode(objCBRcptDetailBean.getAcctName().substring(0, 4));

			if (objCBRcptDetailBean.getCashBankRcptDtlId() > 0) {// update dtl
				Object[] cbrdtlUpdParams = new Object[] { objCashBankReceiptListBean.getVoucherNo(), objCBRcptDetailBean.getAcctName(), objCBRcptDetailBean.getGenInvoiceNo(), objCashBankReceiptListBean.getChequeNO(), chequeDate, objCBRcptDetailBean.getCurrency(), objCBRcptDetailBean.getExgRate(), objCBRcptDetailBean.getBcamount(), objCBRcptDetailBean.getTcamount(), objCBRcptDetailBean.getDepartmentCode(), objCBRcptDetailBean.getSubgroupcode(), objCBRcptDetailBean.getSiNo(), objCBRcptDetailBean.getSubAccountCode(),
						objCBRcptDetailBean.getEmployeeCode(), objCBRcptDetailBean.getCountryCode(), objCBRcptDetailBean.getCustomerCode(), objCBRcptDetailBean.getSupplierCode(), objCBRcptDetailBean.getDesignationCode(), objCBRcptDetailBean.getCompanyCode(), objCBRcptDetailBean.getCostCenter(), objCBRcptDetailBean.getPatientCode(), objCBRcptDetailBean.getCashBankRcptDtlId() };

				int iCBRDtlId = jdbcTemplate.queryForObject(CashBankReceiptQueryUtil.UPDATE_CBRECEIPT_DTL, cbrdtlUpdParams, Integer.class);

				if (iCBRDtlId > 0) {
					List<CashBankReceiptInvoiceDetailBean> cbrcptInvoiceData = objCBRcptDetailBean.getInvoicePaymentList();
					for (CashBankReceiptInvoiceDetailBean objCBRcptInvDtlBean : cbrcptInvoiceData) {
						if (objCBRcptInvDtlBean.getCbRcptInvDtlId() > 0 && iCBRDtlId > 0) {
							int iInvDtlUpd = jdbcTemplate.update(CashBankReceiptQueryUtil.DELETE_CBRECEIPT_INVOICE_DTL, new Object[] { objCBRcptInvDtlBean.getCbRcptInvDtlId() });
							isSuccess = saveCashBankReceiptInvoiceDetail(objCashBankReceiptListBean, objCBRcptDetailBean, objCBRcptInvDtlBean);
						} else {
							isSuccess = saveCashBankReceiptInvoiceDetail(objCashBankReceiptListBean, objCBRcptDetailBean, objCBRcptInvDtlBean);
						}
					}
				}
			} else {// insert on detail table if dtl Id not-exists
				Object[] cbrdtlParams = new Object[] { objCashBankReceiptListBean.getVoucherNo(), objCBRcptDetailBean.getAcctName(), objCBRcptDetailBean.getGenInvoiceNo(), objCashBankReceiptListBean.getChequeNO(), chequeDate, objCBRcptDetailBean.getCurrency(), objCBRcptDetailBean.getExgRate(), objCBRcptDetailBean.getBcamount(), objCBRcptDetailBean.getTcamount(), objCBRcptDetailBean.getDepartmentCode(), objCBRcptDetailBean.getSubgroupcode(), objCBRcptDetailBean.getSiNo(), objCBRcptDetailBean.getSubgroupcode(), objCBRcptDetailBean.getEmployeeCode(),
						objCBRcptDetailBean.getCountryCode(), objCBRcptDetailBean.getCustomerCode(), objCBRcptDetailBean.getSupplierCode(), objCBRcptDetailBean.getDesignationCode(), objCBRcptDetailBean.getCompanyCode(), objCBRcptDetailBean.getCostCenter(), objCBRcptDetailBean.getPatientCode() };

				int iCBRDtl = jdbcTemplate.queryForObject(CashBankReceiptQueryUtil.SAVE_CASHBANK_RECEIPT_DTL, cbrdtlParams, Integer.class);
				if (iCBRDtl > 0) {
					objCBRcptDetailBean.setCashBankRcptDtlId(iCBRDtl);
					List<CashBankReceiptInvoiceDetailBean> cbrcptInvoiceData = objCBRcptDetailBean.getInvoicePaymentList();
					for (CashBankReceiptInvoiceDetailBean objCBRcptInvDtlBean : cbrcptInvoiceData) {
						isSuccess = saveCashBankReceiptInvoiceDetail(objCashBankReceiptListBean, objCBRcptDetailBean, objCBRcptInvDtlBean);
					}
				}
			}
		}

		return isSuccess;
	}

	@Override
	public CashBankReceiptResultBean getCompanyListWithUser(String userId, String companyCode) {
		List<CashBankReceiptListBean> lCBRcptHdrList = new ArrayList<>();
		CashBankReceiptResultBean resultBean = new CashBankReceiptResultBean();
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lCBRcptHdrList = jdbcTemplate.query(CashBankReceiptQueryUtil.GET_COMPANY_LIST_WITH_USER, new Object[] { userId }, new BeanPropertyRowMapper<>(CashBankReceiptListBean.class));
			resultBean.setlCashbankReceiptListBean(lCBRcptHdrList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Reconcile List", e);
		}
		return resultBean;
	}

	@Override
	public CashBankReceiptDetailBean getPendingInvoiceDetails(String customerCode) {
		CashBankReceiptDetailBean objCashBankRcptBean = new CashBankReceiptDetailBean();
		List<CashBankReceiptInvoiceDetailBean> lPendingInvList = new ArrayList<>();
		try {
			lPendingInvList = jdbcTemplate.query(CashBankReceiptQueryUtil.GET_PENDING_INVOICE_DETAILS, new Object[] { customerCode, customerCode, customerCode, customerCode }, new BeanPropertyRowMapper<>(CashBankReceiptInvoiceDetailBean.class));

			objCashBankRcptBean.setPendingInvoiceDtls(lPendingInvList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Pending Invoice Details List", e);
		}

		return objCashBankRcptBean;
	}

	@Override
	public String reverseReceipt(String receiptVoucherNo, String createdDate) {
		String sReceiptStatus = "";
		String sMessage = "";
		try {
			List<Map<String, Object>> RowData = jdbcTemplate.queryForList(CashBankReceiptQueryUtil.GET_RECEIPT_STATUS, new Object[] { receiptVoucherNo });
			for (Map<String, Object> row : RowData) {
				sReceiptStatus = (String) row.get("reverseBr");
			}

			if ("N".equalsIgnoreCase(sReceiptStatus)) {
				reverseReceiptRecord(receiptVoucherNo, createdDate);
				sMessage = "Receipt reversed sucessfully";
			} else {
				sMessage = "Receipt is already reversed !..";
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Reverse receipt List", e);
		}
		return sMessage;
	}

	private void reverseReceiptRecord(String receiptVoucherNo, String createdDate) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSuccess = false;
		try {
			String reverseStatus = "Y";
			jdbcTemplate.update(CashBankReceiptQueryUtil.UPDATE_CBRECEIPT_HDR_STATUS, new Object[] { reverseStatus, receiptVoucherNo });
			// jdbcTemplate.update(CashBankReceiptQueryUtil.REVERSE_GENERAL_LEDGER_RECORDS,
			// new Object[] { userDetails.getUserId(), receiptVoucherNo });
			// jdbcTemplate.update(CashBankReceiptQueryUtil.DELETE_CASHBANK_RCPT_INV_DTL,
			// new Object[] { receiptVoucherNo });
			// int succ = jdbcTemplate.update(CashBankReceiptQueryUtil.REVERSE_CBR, new
			// Object[] { receiptVoucherNo, createdDate, userDetails.getUserId() });
			int succ = jdbcTemplate.queryForObject(CashBankReceiptQueryUtil.REVERSE_CBR, new Object[] { receiptVoucherNo, createdDate, userDetails.getUserId() }, Integer.class);
			int succ1 = jdbcTemplate.queryForObject(CashBankReceiptQueryUtil.REVERSE_CBR_GL, Integer.class);

			// isSuccess = saveCBReceiptGeneralLedgerDebitEntryReversal(receiptVoucherNo);
			// isSuccess = saveCBReceiptGeneralLedgerCreditEntryReversal(receiptVoucherNo);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Currency List", e);
		}
	}

	@Override
	public CashBankReceiptListBean getReceiptVoucherforView(String voucherNo) {
		CashBankReceiptListBean objCashBankReceiptListBean = new CashBankReceiptListBean();
		String sJvno = "";
		double dTotalBcAmount = 0.0, dTotalTcAmount = 0.0;
		try {
			objCashBankReceiptListBean = jdbcTemplate.queryForObject(CashBankReceiptQueryUtil.GET_RECEIPT_VOUCHER_VIEW_HDR, new Object[] { voucherNo }, new BeanPropertyRowMapper<>(CashBankReceiptListBean.class));
			if (objCashBankReceiptListBean.getCompanyCode().equalsIgnoreCase("C0002")) {
				objCashBankReceiptListBean.setCompanyName("Dental Council Of India");
			} else {
				objCashBankReceiptListBean.setCompanyName("Dental Council Of India");
			}
			List<CashBankReceiptDetailBean> lDetailList = new ArrayList<>();
			List<CashBankReceiptDetailBean> lDetailList1 = new ArrayList<>();
			lDetailList = jdbcTemplate.query(CashBankReceiptQueryUtil.GET_RECEIPT_VOUCHER_VIEW_DTL, new Object[] { voucherNo ,voucherNo}, new BeanPropertyRowMapper<>(CashBankReceiptDetailBean.class));
			int i=0;
 
/*i=	lDetailList.size();
 lDetailList.get(i-1).setAcctName(objCashBankReceiptListBean.getAccountName());
 lDetailList.get(i-1).setBcamountNew(lDetailList.get(i-1).getBcamountNew());*/

			objCashBankReceiptListBean.setCshBankDetail(lDetailList);

		List<CashBankReceiptDetailBean> lInvoiceDtlList = new ArrayList<>();

			for (CashBankReceiptDetailBean objCashBankReceiptDetailBean : lDetailList) {
				dTotalTcAmount = dTotalTcAmount + objCashBankReceiptDetailBean.getTcamount();
				dTotalBcAmount = dTotalBcAmount + objCashBankReceiptDetailBean.getBcamountNew();

				lInvoiceDtlList = jdbcTemplate.query(CashBankReceiptQueryUtil.GET_RECEIPT_VOUCHER_VIEW_INVOICE_DTL, new Object[] { voucherNo }, new BeanPropertyRowMapper<>(CashBankReceiptDetailBean.class));
			}
			objCashBankReceiptListBean.setInvoicealloc(lInvoiceDtlList);

			objCashBankReceiptListBean.setBcAmountHdr(dTotalBcAmount);
			objCashBankReceiptListBean.setTcAmountHdr(dTotalTcAmount);
			
			
			String Type = "Rupees";
			objCashBankReceiptListBean.setCurrencyType(Type);
			String amountInWords = wordingConversion.convertToIndianCurrency(String.valueOf(Math.round(objCashBankReceiptListBean.getTcAmountHdr())));
			amountInWords = "Rupees" + "  " + amountInWords;
			objCashBankReceiptListBean.setAmountinWords(amountInWords);
			System.out.println(objCashBankReceiptListBean.getCurrencyType() + "  " + wordingConversion.convertToIndianCurrency(String.valueOf(objCashBankReceiptListBean.getTcAmountHdr())));

			
			
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in Receipt Header Detail ", e);
		}
		return objCashBankReceiptListBean;
	}

	@Override
	public CashBankReceiptResultBean getReceiptNo(String pmtype,String cbReceiptDate) throws CustomException {
		CashBankReceiptResultBean resultBean = new CashBankReceiptResultBean();
		CashBankReceiptListBean objCashBankReceiptListBean = new CashBankReceiptListBean();
		String voucherNo ="";
		try {
			objCashBankReceiptListBean.setPaymentMode(pmtype);
			objCashBankReceiptListBean.setCbReceiptDate(cbReceiptDate);
				voucherNo = getVoucherNo(objCashBankReceiptListBean.getPaymentMode(), objCashBankReceiptListBean);
				resultBean.setVoucherNo(voucherNo);
				resultBean.setMessage("success");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return resultBean;
	}
	
	@Override
	public CashBankReceiptListBean getReceiptVoucherforView1(String voucherNo) {
		CashBankReceiptListBean objCashBankReceiptListBean = new CashBankReceiptListBean();
		String sJvno = "";
		double dTotalBcAmount = 0.0, dTotalTcAmount = 0.0;
		try {
			objCashBankReceiptListBean = jdbcTemplate.queryForObject(CashBankReceiptQueryUtil.GET_RECEIPT_VOUCHER_VIEW_HDR, new Object[] { voucherNo }, new BeanPropertyRowMapper<>(CashBankReceiptListBean.class));
			if (objCashBankReceiptListBean.getCompanyCode().equalsIgnoreCase("C0002")) {
				objCashBankReceiptListBean.setCompanyName("Dental Council Of India");
			} else {
				objCashBankReceiptListBean.setCompanyName("Dental Council Of India");
			}
			List<CashBankReceiptDetailBean> lDetailList = new ArrayList<>();
			lDetailList = jdbcTemplate.query(CashBankReceiptQueryUtil.GET_RECEIPT_VOUCHER_VIEW_DTL, new Object[] { voucherNo }, new BeanPropertyRowMapper<>(CashBankReceiptDetailBean.class));

			objCashBankReceiptListBean.setCshBankDetail(lDetailList);

			List<CashBankReceiptDetailBean> lInvoiceDtlList = new ArrayList<>();

			for (CashBankReceiptDetailBean objCashBankReceiptDetailBean : lDetailList) {
				dTotalTcAmount = dTotalTcAmount + objCashBankReceiptDetailBean.getTcamount();
				dTotalBcAmount = dTotalBcAmount + objCashBankReceiptDetailBean.getBcamountNew();

				lInvoiceDtlList = jdbcTemplate.query(CashBankReceiptQueryUtil.GET_RECEIPT_VOUCHER_VIEW_INVOICE_DTL, new Object[] { voucherNo }, new BeanPropertyRowMapper<>(CashBankReceiptDetailBean.class));
			}
			objCashBankReceiptListBean.setInvoicealloc(lInvoiceDtlList);

			objCashBankReceiptListBean.setBcAmountHdr(dTotalBcAmount);
			objCashBankReceiptListBean.setTcAmountHdr(dTotalTcAmount);
		} catch (DataAccessException e) {
			LOGGER.error("Error in Receipt Header Detail ", e);
		}
		return objCashBankReceiptListBean;
	}


	
	
}
