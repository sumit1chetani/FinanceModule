package com.dci.tenant.finance.cashbankbook;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CashBankBookResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private CashBankBook objCashBankBook = new CashBankBook();

	private List<CashBankBook> lCashBankBook;
	private List<CashBankBook> sublCashBankBook;
	private List<CashBankBook> lGeneralLedgerList;
	private CashBankBook amt;

	public List<CashBankBook> getSublCashBankBook() {
		return sublCashBankBook;
	}

	public void setSublCashBankBook(List<CashBankBook> sublCashBankBook) {
		this.sublCashBankBook = sublCashBankBook;
	}

	public CashBankBook getAmt() {
		return amt;
	}

	public void setAmt(CashBankBook amt) {
		this.amt = amt;
	}

	public List<CashBankBook> getlGeneralLedgerList() {
		return lGeneralLedgerList;
	}

	public void setlGeneralLedgerList(List<CashBankBook> lGeneralLedgerList) {
		this.lGeneralLedgerList = lGeneralLedgerList;
	}

	public CashBankBook getObjCashBankBook() {
		return objCashBankBook;
	}

	public void setObjCashBankBook(CashBankBook objCashBankBook) {
		this.objCashBankBook = objCashBankBook;
	}

	public List<CashBankBook> getlCashBankBook() {
		return lCashBankBook;
	}

	public void setlCashBankBook(List<CashBankBook> lCashBankBook) {
		this.lCashBankBook = lCashBankBook;
	}

}