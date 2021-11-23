package com.dci.tenant.finance.cashbankpayment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;
import com.dci.tenant.finance.paymentReport.PaymentHistoryReportBean;

@Transactional
@Service
public class CashBankPaymentServiceImpl implements CashBankPaymentService {

	@Autowired
	CashBankPaymentDAO objCashBankPaymentDAO;

	@Override
	public List<CashBankPaymentBean> getBankAcctList(String sPaymentType) {
		return objCashBankPaymentDAO.getBankAcctList(sPaymentType);
	}

	@Override
	public List<CashBankPaymentBean> getBankAcctListcom(String companyName) {
		return objCashBankPaymentDAO.getBankAcctListcom(companyName);
	}

	@Override
	public List<CashBankPaymentBean> getBankAcctListcompanyNew(String companyName) {
		return objCashBankPaymentDAO.getBankAcctListcompanyNew(companyName);
	}

	@Override
	public List<CashBankPaymentBean> getCashAcctListcompanyNew(String companyName) {
		return objCashBankPaymentDAO.getCashAcctListcompanyNew(companyName);
	}

	@Override
	public List<CashBankPaymentBean> getsubacct(String cbpdtlAccountHead) {
		return objCashBankPaymentDAO.getsubacct(cbpdtlAccountHead);
	}

	@Override
	public List<CashBankPaymentBean> getBankAcctListcompanycode(String companyCode) {
		return objCashBankPaymentDAO.getBankAcctListcompanycode(companyCode);
	}

	@Override
	public List<CashBankPaymentBean> subAccountCodeList() {
		return objCashBankPaymentDAO.subAccountCodeList();
	}

	@Override
	public List<CashBankPaymentBean> getExchangeRateWithCurrency(String sCurrencyCode) {
		return objCashBankPaymentDAO.getExchangeRateWithCurrency(sCurrencyCode);
	}

	@Override
	public List<CashBankPaymentBean> getVoyageList() {
		return objCashBankPaymentDAO.getVoyageList();
	}

	@Override
	public List<CashBankPaymentBean> saveCashBankPmtData(CashBankPaymentBean objCashBankPaymentBean, String userId, String companyCode) {
		return objCashBankPaymentDAO.saveCashBankPmtData(objCashBankPaymentBean, userId, companyCode);
	}

	@Override
	public List<CashBankPaymentBean> getCashBankPaymentHdrList(int limit, int offset) {
		return objCashBankPaymentDAO.getCashBankPaymentHdrList(limit, offset);
	}

	@Override
	public List<CashBankPaymentBean> getPaymentOrderNoList() {
		return objCashBankPaymentDAO.getPaymentOrderNoList();
	}

	@Override
	public CashBankPaymentBean getPaymentVoucherDetailforEdit(String sVoucherNo) {
		return objCashBankPaymentDAO.getPaymentVoucherDetailforEdit(sVoucherNo);
	}

	@Override
	public boolean updateCashBankPayment(CashBankPaymentBean objCashBankPaymentBean) {
		return objCashBankPaymentDAO.updateCashBankPayment(objCashBankPaymentBean);
	}

	@Override
	public List<CashBankPaymentBean> getAttributeListWithAccountCode(String accountCode) {
		return objCashBankPaymentDAO.getAttributeListWithAccountCode(accountCode);
	}

	@Override
	public boolean deleteCashBankPayment(String voucherNo) {
		return objCashBankPaymentDAO.deleteCashBankPayment(voucherNo);
	}

	@Override
	public CashBankPaymentDetailBean getPendingInvoiceDetails(String supplierCode) {
		return objCashBankPaymentDAO.getPendingInvoiceDetails(supplierCode);
	}

	@Override
	public List<CashBankPaymentBean> getPaidToList() {
		return objCashBankPaymentDAO.getPaidToList();
	}

	@Override
	public List<PaymentHistoryReportBean> getPendingPaymentReportDtlList(String voucherNo) {
		return objCashBankPaymentDAO.getPendingPaymentReportDtlList(voucherNo);
	}

	@Override
	public List<PaymentHistoryReportBean> pendingPayment1stLevelList() {
		return objCashBankPaymentDAO.pendingPayment1stLevelList();
	}

	@Override
	public List<PaymentHistoryReportBean> getPendingPaymentReportInvoiceDtl(int pmtDtlId) {
		return objCashBankPaymentDAO.getPendingPaymentReportInvoiceDtl(pmtDtlId);
	}

	@Override
	public List<PaymentHistoryReportBean> getPaymentHistory1stLevelList() {
		return objCashBankPaymentDAO.getPaymentHistory1stLevelList();
	}

	@Override
	public List<PaymentHistoryReportBean> getPaymentHistoryReportDtlList(String invoiceNo) {
		return objCashBankPaymentDAO.getPaymentHistoryReportDtlList(invoiceNo);
	}

	@Override
	public List<PaymentHistoryReportBean> getPaymentHistoryInvoiceDtlList(int pmtDtlId) {
		return objCashBankPaymentDAO.getPaymentHistoryInvoiceDtlList(pmtDtlId);
	}

	@Override
	public CashBankPaymentResultBean getPendingPaymentRptInvoiceDetails(String supplierCode) {
		return objCashBankPaymentDAO.getPendingPaymentRptInvoiceDetails(supplierCode);
	}

	@Override
	public String reversePayment(String voucherNo, String createdDate) {
		return objCashBankPaymentDAO.reversePayment(voucherNo, createdDate);
	}

	@Override
	public String validateBudget(CashBankPaymentBean objCashBankPaymentBean) {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.validateBudget(objCashBankPaymentBean);
	}

	@Override
	public CashBankPaymentBean printPaymentVoucher(String voucherNo) {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.printPaymentVoucher(voucherNo);
	}

	@Override
	public List<CashBankPaymentBean> getChequeNoList(String sAccountName) {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.getChequeNoList(sAccountName);
	}

	@Override
	public List<CashBankPaymentBean> getChequeNoEditList(CashBankPaymentBean bankPaymentBean) {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.getChequeNoEditList(bankPaymentBean);
	}

	@Override
	public CashBankPaymentResultBean budgetdefnvalidation(CashBankPaymentBean objCashBankPaymentBean) {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.budgetdefnvalidation(objCashBankPaymentBean);
	}

	@Override
	public CashBankPaymentBean getBudgetValue(String costCenter, Integer budgetDefId) {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.getBudgetValue(costCenter, budgetDefId);
	}

	@Override
	public CashBankPaymentResultBean getReceiptNo(String pmtype, String cashbankPmtDate,String accountName) throws CustomException {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.getReceiptNo(pmtype,cashbankPmtDate,accountName);
	}

	@Override
	public List<CashBankPaymentBean> subPaymentList() {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.subPaymentList();
	}

	@Override
	public List<CashBankPaymentBean> receiptList() {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.receiptList();
	}

	@Override
	public List<CashBankPaymentBean> subPaymentreceiptList() {
		// TODO Auto-generated method stub
		return objCashBankPaymentDAO.subPaymentreceiptList();
	}

}
