package com.dci.tenant.finance.reports.financials.BankBook;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface BankBookDao {

	public List<BankBook> getBankBookList(BankBook objBankBook) throws Exception;

	public List<BankBook> getBankBookAccountList(BankBook objBankBook);

/*	public List<BankBook> getAccountList() throws Exception;
*/

	List<SelectivityBean> getAccountList();

	public List<BankBook> getConsolidatedBankLedgerList(BankBook objBankBook);

}
