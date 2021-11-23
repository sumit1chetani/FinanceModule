package com.dci.finance.ReceiptPayment;

import java.util.List;

import com.dci.common.util.BasicResultBean;

@SuppressWarnings("serial")
public class ReceiptPaymentResultBean extends BasicResultBean {

	private String filePath;
	private ReceiptPaymentBean amt;
	private List<ReceiptPaymentBean> lGeneralLedgerList;
	private List<ReceiptPaymentBean> lGeneralLedgerBankList;

	private List<ReceiptPaymentBean> lGeneralLedgerAHList;
	private List<ReceiptPaymentBean> lGeneralLedgerTransactionList;
    private Double preTotalAmount;
	public Double getPreTotalAmount() {
		return preTotalAmount;
	}

	public List<ReceiptPaymentBean> getlGeneralLedgerBankList() {
		return lGeneralLedgerBankList;
	}

	public void setlGeneralLedgerBankList(List<ReceiptPaymentBean> lGeneralLedgerBankList) {
		this.lGeneralLedgerBankList = lGeneralLedgerBankList;
	}

	public void setPreTotalAmount(Double preTotalAmount) {
		this.preTotalAmount = preTotalAmount;
	}

	private Double totalAmount;

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<ReceiptPaymentBean> getlGeneralLedgerList() {
		return lGeneralLedgerList;
	}

	public void setlGeneralLedgerList(List<ReceiptPaymentBean> lGeneralLedgerList) {
		this.lGeneralLedgerList = lGeneralLedgerList;
	}

	public List<ReceiptPaymentBean> getlGeneralLedgerAHList() {
		return lGeneralLedgerAHList;
	}

	public void setlGeneralLedgerAHList(List<ReceiptPaymentBean> lGeneralLedgerAHList) {
		this.lGeneralLedgerAHList = lGeneralLedgerAHList;
	}

	public List<ReceiptPaymentBean> getlGeneralLedgerTransactionList() {
		return lGeneralLedgerTransactionList;
	}

	public void setlGeneralLedgerTransactionList(List<ReceiptPaymentBean> lGeneralLedgerTransactionList) {
		this.lGeneralLedgerTransactionList = lGeneralLedgerTransactionList;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public ReceiptPaymentBean getAmt() {
		return amt;
	}

	public void setAmt(ReceiptPaymentBean amt) {
		this.amt = amt;
	}

}