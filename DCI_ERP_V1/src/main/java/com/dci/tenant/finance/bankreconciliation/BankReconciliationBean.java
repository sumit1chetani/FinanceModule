package com.dci.tenant.finance.bankreconciliation;

import java.util.List;

public class BankReconciliationBean {
	private boolean success;
	private boolean isAvailable;
	private List<BankReconciliationBean> lDifferenceResultList1;
	private List<BankReconciliationBean> lDifferenceResultList2;
	private String tableName;
	private String formCode;
	private String toDate;
	private String fromDate;
	private String type;
	private String customer;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private Double differencePayment;
	private Double differenceReceipt;
	private Double bankBalanceAsPerBook;
	private Double bankBalanceAsPerBank;

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

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public List<BankReconciliationBean> getlDifferenceResultList2() {
		return lDifferenceResultList2;
	}

	public void setlDifferenceResultList2(List<BankReconciliationBean> lDifferenceResultList2) {
		this.lDifferenceResultList2 = lDifferenceResultList2;
	}

	public List<BankReconciliationBean> getlDifferenceResultList1() {
		return lDifferenceResultList1;
	}

	public void setlDifferenceResultList1(List<BankReconciliationBean> lDifferenceResultList1) {
		this.lDifferenceResultList1 = lDifferenceResultList1;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private boolean isActive;

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	private Integer bank_stmt_id;
	private String transaction_no;
	private String book_date;
	private String book_cheque_no;
	private String book_cheque_date;
	private double book_debit_amt;
	private double book_credit_amt;
	private String book_narration;
	private String bank_cheque_no;
	private String bank_date;
	private double bank_debit_amt;
	private double bank_credit_amt;
	private String bank_account_code;
	private String bank_narration;
	private double bank_closing_balance;
	private String remarks;
	private String bank_code;
	private String id;
	private String text;
	private Double balanceAsPerBank;
	private Double balanceAsPerBankUsd;
	private Double balanceAsPerBook;
	private Double difference;
	private String transactionNo;
	private String chqNo;
	private String chqDt;
	private String doctype;
	private String docdate;
	private double debitamount;
	private double creditamount;
	private double tcCreditAmount;
	private double tcDebitAmount;
	private String narration;
	private String transactionType;
	private String supplier;
	private String bank;
	private String bankCode;
	private String debitamount1;
	private String creditamount1;

	public String getDebitamount1() {
		return debitamount1;
	}

	public void setDebitamount1(String debitamount1) {
		this.debitamount1 = debitamount1;
	}

	public String getCreditamount1() {
		return creditamount1;
	}

	public void setCreditamount1(String creditamount1) {
		this.creditamount1 = creditamount1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private String value_date;

	private String bankAccountNo;
	private String bankCurrency;
	private boolean select;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBank_stmt_id() {
		return bank_stmt_id;
	}

	public void setBank_stmt_id(Integer bank_stmt_id) {
		this.bank_stmt_id = bank_stmt_id;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getTransaction_no() {
		return transaction_no;
	}

	public void setTransaction_no(String transaction_no) {
		this.transaction_no = transaction_no;
	}

	public String getBook_date() {
		return book_date;
	}

	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}

	public String getBook_cheque_no() {
		return book_cheque_no;
	}

	public void setBook_cheque_no(String book_cheque_no) {
		this.book_cheque_no = book_cheque_no;
	}

	public String getBook_cheque_date() {
		return book_cheque_date;
	}

	public void setBook_cheque_date(String book_cheque_date) {
		this.book_cheque_date = book_cheque_date;
	}

	public double getBook_debit_amt() {
		return book_debit_amt;
	}

	public void setBook_debit_amt(double book_debit_amt) {
		this.book_debit_amt = book_debit_amt;
	}

	public double getBook_credit_amt() {
		return book_credit_amt;
	}

	public void setBook_credit_amt(double book_credit_amt) {
		this.book_credit_amt = book_credit_amt;
	}

	public String getBook_narration() {
		return book_narration;
	}

	public void setBook_narration(String book_narration) {
		this.book_narration = book_narration;
	}

	public String getBank_cheque_no() {
		return bank_cheque_no;
	}

	public void setBank_cheque_no(String bank_cheque_no) {
		this.bank_cheque_no = bank_cheque_no;
	}

	public String getBank_date() {
		return bank_date;
	}

	public void setBank_date(String bank_date) {
		this.bank_date = bank_date;
	}

	public double getBank_debit_amt() {
		return bank_debit_amt;
	}

	public void setBank_debit_amt(double bank_debit_amt) {
		this.bank_debit_amt = bank_debit_amt;
	}

	public double getBank_credit_amt() {
		return bank_credit_amt;
	}

	public void setBank_credit_amt(double bank_credit_amt) {
		this.bank_credit_amt = bank_credit_amt;
	}

	public String getBank_account_code() {
		return bank_account_code;
	}

	public void setBank_account_code(String bank_account_code) {
		this.bank_account_code = bank_account_code;
	}

	public String getBank_narration() {
		return bank_narration;
	}

	public void setBank_narration(String bank_narration) {
		this.bank_narration = bank_narration;
	}

	public double getBank_closing_balance() {
		return bank_closing_balance;
	}

	public void setBank_closing_balance(double bank_closing_balance) {
		this.bank_closing_balance = bank_closing_balance;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBankCurrency() {
		return bankCurrency;
	}

	public void setBankCurrency(String bankCurrency) {
		this.bankCurrency = bankCurrency;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public String getValue_date() {
		return value_date;
	}

	public void setValue_date(String value_date) {
		this.value_date = value_date;
	}

	private List<BankReconciliationBean> lDifferenceResultList;

	public List<BankReconciliationBean> getlDifferenceResultList() {
		return lDifferenceResultList1;
	}

	public void setlDifferenceResultList(List<BankReconciliationBean> lDifferenceResultList) {
		this.lDifferenceResultList1 = lDifferenceResultList;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public String getChqNo() {
		return chqNo;
	}

	public String getChqDt() {
		return chqDt;
	}

	public String getDoctype() {
		return doctype;
	}

	public String getDocdate() {
		return docdate;
	}

	public double getDebitamount() {
		return debitamount;
	}

	public double getCreditamount() {
		return creditamount;
	}

	public String getNarration() {
		return narration;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}

	public void setChqDt(String chqDt) {
		this.chqDt = chqDt;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public void setDocdate(String docdate) {
		this.docdate = docdate;
	}

	public void setDebitamount(double debitamount) {
		this.debitamount = debitamount;
	}

	public void setCreditamount(double creditamount) {
		this.creditamount = creditamount;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Double getBalanceAsPerBank() {
		return balanceAsPerBank;
	}

	public void setBalanceAsPerBank(Double balanceAsPerBank) {
		this.balanceAsPerBank = balanceAsPerBank;
	}

	public Double getBalanceAsPerBook() {
		return balanceAsPerBook;
	}

	public void setBalanceAsPerBook(Double balanceAsPerBook) {
		this.balanceAsPerBook = balanceAsPerBook;
	}

	public Double getDifference() {
		return difference;
	}

	public void setDifference(Double difference) {
		this.difference = difference;
	}

	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * @param bankCode
	 *            the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
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

	public double getTcCreditAmount() {
		return tcCreditAmount;
	}

	public void setTcCreditAmount(double tcCreditAmount) {
		this.tcCreditAmount = tcCreditAmount;
	}

	public double getTcDebitAmount() {
		return tcDebitAmount;
	}

	public void setTcDebitAmount(double tcDebitAmount) {
		this.tcDebitAmount = tcDebitAmount;
	}

	public Double getBalanceAsPerBankUsd() {
		return balanceAsPerBankUsd;
	}

	public void setBalanceAsPerBankUsd(Double balanceAsPerBankUsd) {
		this.balanceAsPerBankUsd = balanceAsPerBankUsd;
	}

}
