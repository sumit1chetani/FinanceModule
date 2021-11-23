package com.dci.tenant.finance.cashbankpayment;

import java.util.List;

import com.dci.common.util.CustomException;
import com.dci.tenant.finance.paymentReport.PaymentHistoryReportBean;

public interface CashBankPaymentDAO {

	List<CashBankPaymentBean> getBankAcctList(String sPaymentType);

	List<CashBankPaymentBean> getBankAcctListcom(String companyName);

	List<CashBankPaymentBean> getBankAcctListcompanyNew(String companyName);

	List<CashBankPaymentBean> getCashAcctListcompanyNew(String companyName);

	List<CashBankPaymentBean> getsubacct(String cbpdtlAccountHead);

	List<CashBankPaymentBean> getBankAcctListcompanycode(String companyCode);

	List<CashBankPaymentBean> subAccountCodeList();

	List<CashBankPaymentBean> getExchangeRateWithCurrency(String sCurrencyCode);

	List<CashBankPaymentBean> getVoyageList();

	List<CashBankPaymentBean> saveCashBankPmtData(CashBankPaymentBean objCashBankPaymentBean, String userId, String companyCode);

	List<CashBankPaymentBean> getCashBankPaymentHdrList(int limit, int offset);

	List<CashBankPaymentBean> getPaymentOrderNoList();

	CashBankPaymentBean getPaymentVoucherDetailforEdit(String sVoucherNo);

	boolean updateCashBankPayment(CashBankPaymentBean objCashBankPaymentBean);

	List<CashBankPaymentBean> getAttributeListWithAccountCode(String accountCode);

	boolean deleteCashBankPayment(String voucherNo);

	CashBankPaymentDetailBean getPendingInvoiceDetails(String supplierCode);

	List<CashBankPaymentBean> getPaidToList();

	List<PaymentHistoryReportBean> getPendingPaymentReportDtlList(String voucherNo);

	List<PaymentHistoryReportBean> pendingPayment1stLevelList();

	List<PaymentHistoryReportBean> getPendingPaymentReportInvoiceDtl(int pmtDtlId);

	List<PaymentHistoryReportBean> getPaymentHistory1stLevelList();

	List<PaymentHistoryReportBean> getPaymentHistoryReportDtlList(String invoiceNo);

	List<PaymentHistoryReportBean> getPaymentHistoryInvoiceDtlList(int pmtDtlId);

	CashBankPaymentResultBean getPendingPaymentRptInvoiceDetails(String supplierCode);

	List<PaymentHistoryReportBean> getPendingPaymentInvExportList(PaymentHistoryReportBean objPmtBean);

	List<PaymentHistoryReportBean> getPaymentHistoryExportList();

	String reversePayment(String voucherNo, String createdDate);

	String validateBudget(CashBankPaymentBean objCashBankPaymentBean);

	CashBankPaymentBean printPaymentVoucher(String voucherNo);

	List<CashBankPaymentBean> getChequeNoList(String sAccountName);

	List<CashBankPaymentBean> getChequeNoEditList(CashBankPaymentBean bankPaymentBean);

	CashBankPaymentResultBean budgetdefnvalidation(CashBankPaymentBean objCashBankPaymentBean);

	CashBankPaymentBean getBudgetValue(String costCenter, Integer budgetDefId);

	CashBankPaymentResultBean getReceiptNo(String pmtype, String cashbankPmtDate, String accountName) throws CustomException;

	List<CashBankPaymentBean> subPaymentList();

	List<CashBankPaymentBean> receiptList();

	List<CashBankPaymentBean> subPaymentreceiptList();
}
