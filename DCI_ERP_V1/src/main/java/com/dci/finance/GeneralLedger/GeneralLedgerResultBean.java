package com.dci.finance.GeneralLedger;

import java.util.List;

import com.dci.common.util.BasicResultBean;

@SuppressWarnings("serial")
public class GeneralLedgerResultBean extends BasicResultBean {

	private String filePath;
	private GeneralLedgerBean amt;
	private List<GeneralLedgerBean> lGeneralLedgerList;
	private List<GeneralLedgerBean> lGeneralLedgerAHList;
	private List<GeneralLedgerBean> lGeneralLedgerAHListAcc;

	private List<GeneralLedgerBean> lGeneralLedgerTransactionList;

	public List<GeneralLedgerBean> getlGeneralLedgerList() {
		return lGeneralLedgerList;
	}

	public void setlGeneralLedgerList(List<GeneralLedgerBean> lGeneralLedgerList) {
		this.lGeneralLedgerList = lGeneralLedgerList;
	}

	public List<GeneralLedgerBean> getlGeneralLedgerAHList() {
		return lGeneralLedgerAHList;
	}

	public List<GeneralLedgerBean> getlGeneralLedgerAHListAcc() {
		return lGeneralLedgerAHListAcc;
	}

	public void setlGeneralLedgerAHListAcc(List<GeneralLedgerBean> lGeneralLedgerAHListAcc) {
		this.lGeneralLedgerAHListAcc = lGeneralLedgerAHListAcc;
	}

	public void setlGeneralLedgerAHList(List<GeneralLedgerBean> lGeneralLedgerAHList) {
		this.lGeneralLedgerAHList = lGeneralLedgerAHList;
	}

	public List<GeneralLedgerBean> getlGeneralLedgerTransactionList() {
		return lGeneralLedgerTransactionList;
	}

	public void setlGeneralLedgerTransactionList(List<GeneralLedgerBean> lGeneralLedgerTransactionList) {
		this.lGeneralLedgerTransactionList = lGeneralLedgerTransactionList;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public GeneralLedgerBean getAmt() {
		return amt;
	}

	public void setAmt(GeneralLedgerBean amt) {
		this.amt = amt;
	}

}