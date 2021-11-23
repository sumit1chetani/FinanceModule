package com.dci.finance.DayBook;

import java.util.List;

import com.dci.common.util.BasicResultBean;

@SuppressWarnings("serial")
public class DayBookResultBean extends BasicResultBean {

	private String filePath;
	private DayBookBean amt;
	private List<DayBookBean> lGeneralLedgerList;
	private List<DayBookBean> lGeneralLedgerAHList;
	private List<DayBookBean> lGeneralLedgerTransactionList;

	private Double totalAmount;

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<DayBookBean> getlGeneralLedgerList() {
		return lGeneralLedgerList;
	}

	public void setlGeneralLedgerList(List<DayBookBean> lGeneralLedgerList) {
		this.lGeneralLedgerList = lGeneralLedgerList;
	}

	public List<DayBookBean> getlGeneralLedgerAHList() {
		return lGeneralLedgerAHList;
	}

	public void setlGeneralLedgerAHList(List<DayBookBean> lGeneralLedgerAHList) {
		this.lGeneralLedgerAHList = lGeneralLedgerAHList;
	}

	public List<DayBookBean> getlGeneralLedgerTransactionList() {
		return lGeneralLedgerTransactionList;
	}

	public void setlGeneralLedgerTransactionList(List<DayBookBean> lGeneralLedgerTransactionList) {
		this.lGeneralLedgerTransactionList = lGeneralLedgerTransactionList;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public DayBookBean getAmt() {
		return amt;
	}

	public void setAmt(DayBookBean amt) {
		this.amt = amt;
	}

}