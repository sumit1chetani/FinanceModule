package com.dci.tenant.finance.reports.financials.BankBook;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface BankBookService {

	public List<BankBook> getBankBookAccountList(BankBook getBankBookList);

	public List<BankBook> getBankBookList(BankBook getBankBookList) throws Exception;

/*	public List<BankBook> getAccountList() throws Exception;
*/
	List<SelectivityBean> getAccountList();
	

	public boolean exportBankBookExcel(String sFilePath, BankBook objBankBook);

}