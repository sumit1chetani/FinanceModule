package com.dci.tenant.finance.bankreconciliation;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class BankReconciliationResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<BankReconciliationBean> lDifferenceResultList;
	private List<BankReconciliationBean> lBookStatementList;
	private List<BankReconciliationBean> lBankStatementList;
	private List<SelectivityBean> bankList;

	private String message;

	private Double bankBalanceAsPerBook;
	private Double bankBalanceAsPerBank;
	private Double balanceAsPerBook;

	private Double differencePayment;

	private Double differenceReceipt;

	public Double getDifferencePayment() {
		return differencePayment;
	}

	public void setDifferencePayment(Double differencePayment) {
		this.differencePayment = differencePayment;
	}

	public Double getDifferenceReceipt() {
		return differenceReceipt;
	}

	public void setDifferenceReceipt(Double differenceReceipt) {
		this.differenceReceipt = differenceReceipt;
	}

	public Double getBalanceAsPerBook() {
		return balanceAsPerBook;
	}

	public void setBalanceAsPerBook(Double balanceAsPerBook) {
		this.balanceAsPerBook = balanceAsPerBook;
	}

	public Double getBankBalanceAsPerBook() {
		return bankBalanceAsPerBook;
	}

	public void setBankBalanceAsPerBook(Double bankBalanceAsPerBook) {
		this.bankBalanceAsPerBook = bankBalanceAsPerBook;
	}

	public Double getBankBalanceAsPerBank() {
		return bankBalanceAsPerBank;
	}

	public void setBankBalanceAsPerBank(Double bankBalanceAsPerBank) {
		this.bankBalanceAsPerBank = bankBalanceAsPerBank;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	private List<BankReconciliationBean> bankReconciliationBean;

	public List<SelectivityBean> getBankList() {
		return bankList;
	}

	public void setBankList(List<SelectivityBean> bankList) {
		this.bankList = bankList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<BankReconciliationBean> getlDifferenceResultList() {
		return lDifferenceResultList;
	}

	public void setlDifferenceResultList(List<BankReconciliationBean> lDifferenceResultList) {
		this.lDifferenceResultList = lDifferenceResultList;
	}

	public List<BankReconciliationBean> getlBookStatementList() {
		return lBookStatementList;
	}

	public List<BankReconciliationBean> getBankReconciliationBean() {
		return bankReconciliationBean;
	}

	public void setBankReconciliationBean(List<BankReconciliationBean> bankReconciliationBean) {
		this.bankReconciliationBean = bankReconciliationBean;
	}

	public void setlBookStatementList(List<BankReconciliationBean> lBookStatementList) {
		this.lBookStatementList = lBookStatementList;
	}

	public List<BankReconciliationBean> getlBankStatementList() {
		return lBankStatementList;
	}

	public void setlBankStatementList(List<BankReconciliationBean> lBankStatementList) {
		this.lBankStatementList = lBankStatementList;
	}

}
