package com.dci.tenant.finance.cashbankbook;

import java.util.ArrayList;
import java.util.List;

public interface CashBankBookDAO {

	public ArrayList<CashBankBook> getBankBookList(CashBankBook bean);

	public ArrayList<CashBankBook> getBankBookAccountList(String sAccCode, String parentCode);

	public List<CashBankBook> getGeneralLedgerReport(CashBankBook objGeneralLedgerBean);

	public List<CashBankBook> getOpeningBalanceValue(CashBankBook objGeneralLedgerBean);

	String getcompanycode(CashBankBook objGeneralLedgerBean);

}