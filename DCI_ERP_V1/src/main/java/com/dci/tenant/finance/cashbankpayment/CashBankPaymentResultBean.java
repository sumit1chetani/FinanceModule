package com.dci.tenant.finance.cashbankpayment;

import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.tenant.finance.paymentReport.PaymentHistoryReportBean;

public class CashBankPaymentResultBean extends BasicResultBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6622196385092674283L;

	private List<CashBankPaymentBean> lCashbankpaymentBean;

	private List<PaymentHistoryReportBean> lPendingPaymentReportBean;

	private List<PaymentHistoryReportBean> lPendingPaymentReportDtlBean;

	private List<PaymentHistoryReportBean> lPendingPaymentReportInvoiceDtlBean;

	private List<PaymentHistoryReportBean> lPaymentHistoryReportBean;
	private List<PaymentHistoryReportBean> lPaymentHistoryReportDtlBean;
	private List<PaymentHistoryReportBean> lPaymentHistoryReportInvoiceDtlBean;
	private double budgetAmt;
	private double budgetUtilizedAmt;
	private int count;
	private String cbVoucherNo;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getBudgetAmt() {
		return budgetAmt;
	}

	public void setBudgetAmt(double budgetAmt) {
		this.budgetAmt = budgetAmt;
	}

	public double getBudgetUtilizedAmt() {
		return budgetUtilizedAmt;
	}

	public void setBudgetUtilizedAmt(double budgetUtilizedAmt) {
		this.budgetUtilizedAmt = budgetUtilizedAmt;
	}

	public List<CashBankPaymentBean> getlCashbankpaymentBean() {
		return lCashbankpaymentBean;
	}

	public void setlCashbankpaymentBean(List<CashBankPaymentBean> lCashbankpaymentBean) {
		this.lCashbankpaymentBean = lCashbankpaymentBean;
	}

	public List<PaymentHistoryReportBean> getlPendingPaymentReportBean() {
		return lPendingPaymentReportBean;
	}

	public void setlPendingPaymentReportBean(List<PaymentHistoryReportBean> lPendingPaymentReportBean) {
		this.lPendingPaymentReportBean = lPendingPaymentReportBean;
	}

	public List<PaymentHistoryReportBean> getlPendingPaymentReportDtlBean() {
		return lPendingPaymentReportDtlBean;
	}

	public void setlPendingPaymentReportDtlBean(List<PaymentHistoryReportBean> lPendingPaymentReportDtlBean) {
		this.lPendingPaymentReportDtlBean = lPendingPaymentReportDtlBean;
	}

	public List<PaymentHistoryReportBean> getlPendingPaymentReportInvoiceDtlBean() {
		return lPendingPaymentReportInvoiceDtlBean;
	}

	public void setlPendingPaymentReportInvoiceDtlBean(List<PaymentHistoryReportBean> lPendingPaymentReportInvoiceDtlBean) {
		this.lPendingPaymentReportInvoiceDtlBean = lPendingPaymentReportInvoiceDtlBean;
	}

	public List<PaymentHistoryReportBean> getlPaymentHistoryReportBean() {
		return lPaymentHistoryReportBean;
	}

	public void setlPaymentHistoryReportBean(List<PaymentHistoryReportBean> lPaymentHistoryReportBean) {
		this.lPaymentHistoryReportBean = lPaymentHistoryReportBean;
	}

	public List<PaymentHistoryReportBean> getlPaymentHistoryReportDtlBean() {
		return lPaymentHistoryReportDtlBean;
	}

	public void setlPaymentHistoryReportDtlBean(List<PaymentHistoryReportBean> lPaymentHistoryReportDtlBean) {
		this.lPaymentHistoryReportDtlBean = lPaymentHistoryReportDtlBean;
	}

	public List<PaymentHistoryReportBean> getlPaymentHistoryReportInvoiceDtlBean() {
		return lPaymentHistoryReportInvoiceDtlBean;
	}

	public void setlPaymentHistoryReportInvoiceDtlBean(List<PaymentHistoryReportBean> lPaymentHistoryReportInvoiceDtlBean) {
		this.lPaymentHistoryReportInvoiceDtlBean = lPaymentHistoryReportInvoiceDtlBean;
	}

	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCbVoucherNo() {
		return cbVoucherNo;
	}

	public void setCbVoucherNo(String cbVoucherNo) {
		this.cbVoucherNo = cbVoucherNo;
	}

}
