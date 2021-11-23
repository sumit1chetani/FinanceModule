package com.dci.tenant.finance.reports.financials.BankBook;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class BankBookResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private BankBook objBankBook = new BankBook();

	private List<BankBook> lBankBook;
	private List<BankBook> laccountList;

	public BankBook getObjBankBook() {
		return objBankBook;
	}

	public void setObjBankBook(BankBook objBankBook) {
		this.objBankBook = objBankBook;
	}

	public List<BankBook> getlBankBook() {
		return lBankBook;
	}

	public void setlBankBook(List<BankBook> lBankBook) {
		this.lBankBook = lBankBook;
	}

	public List<BankBook> getLaccountList() {
		return laccountList;
	}

	public void setLaccountList(List<BankBook> laccountList) {
		this.laccountList = laccountList;
	}

}