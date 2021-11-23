package com.dci.tenant.finance.chqreconcilation;

import java.util.ArrayList;

public class ChqReconcilationBook {
	private String TransactionNo;
	private String BookChequeDate;
	private String BookChequeNo;
	private double BookDebitAmount;
	private double BookCreditAmount;
	private String BankChequeNo;
	private String BankDate;
	private double BankDebitAmount;
	private double BankCreditAmount;
	private String Remarks;
	private int BookStatementId;
	private int BankStatementId;
	private double OpeningBalance;
	private double ClosingBalance;
	private String id;
	private String text;

	private String fromdate;
	private String todate;
	private String bankAccount;
	private ArrayList<ChqReconcilationBook> differentrecli;
	private String remarks;
	private boolean select;

	public String getTransactionNo() {
		return TransactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		TransactionNo = transactionNo;
	}

	public String getBookChequeDate() {
		return BookChequeDate;
	}

	public void setBookChequeDate(String bookChequeDate) {
		BookChequeDate = bookChequeDate;
	}

	public String getBookChequeNo() {
		return BookChequeNo;
	}

	public void setBookChequeNo(String bookChequeNo) {
		BookChequeNo = bookChequeNo;
	}

	public double getBookDebitAmount() {
		return BookDebitAmount;
	}

	public void setBookDebitAmount(double bookDebitAmount) {
		BookDebitAmount = bookDebitAmount;
	}

	public double getBookCreditAmount() {
		return BookCreditAmount;
	}

	public void setBookCreditAmount(double bookCreditAmount) {
		BookCreditAmount = bookCreditAmount;
	}

	public String getBankChequeNo() {
		return BankChequeNo;
	}

	public void setBankChequeNo(String bankChequeNo) {
		BankChequeNo = bankChequeNo;
	}

	public String getBankDate() {
		return BankDate;
	}

	public void setBankDate(String bankDate) {
		BankDate = bankDate;
	}

	public double getBankDebitAmount() {
		return BankDebitAmount;
	}

	public void setBankDebitAmount(double bankDebitAmount) {
		BankDebitAmount = bankDebitAmount;
	}

	public double getBankCreditAmount() {
		return BankCreditAmount;
	}

	public void setBankCreditAmount(double bankCreditAmount) {
		BankCreditAmount = bankCreditAmount;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public int getBookStatementId() {
		return BookStatementId;
	}

	public void setBookStatementId(int bookStatementId) {
		BookStatementId = bookStatementId;
	}

	public int getBankStatementId() {
		return BankStatementId;
	}

	public void setBankStatementId(int bankStatementId) {
		BankStatementId = bankStatementId;
	}

	public double getOpeningBalance() {
		return OpeningBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		OpeningBalance = openingBalance;
	}

	public double getClosingBalance() {
		return ClosingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		ClosingBalance = closingBalance;
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

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public ArrayList<ChqReconcilationBook> getDifferentrecli() {
		return differentrecli;
	}

	public void setDifferentrecli(ArrayList<ChqReconcilationBook> differentrecli) {
		this.differentrecli = differentrecli;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

}