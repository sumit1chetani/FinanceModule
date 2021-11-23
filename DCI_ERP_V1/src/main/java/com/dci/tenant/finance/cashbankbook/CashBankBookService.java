package com.dci.tenant.finance.cashbankbook;

import java.util.ArrayList;
import java.util.List;

public interface CashBankBookService {
	public ArrayList<CashBankBook> getBankBookList(CashBankBook objGeneralLedgerBean);

	public ArrayList<CashBankBook> getBankBookAccountList(String sAccCode, String sAccCode2);

	public List<CashBankBook> getGeneralLedgerReport(CashBankBook objGeneralLedgerBean);

	public List<CashBankBook> getOpeningBalanceValue(CashBankBook objGeneralLedgerBean);

}