package com.dci.tenant.finance.cashbankbook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashBankBookServiceImpl implements CashBankBookService {
	@Autowired
	CashBankBookDAO objCashBankBookDAO;

	@Override
	public ArrayList<CashBankBook> getBankBookList(CashBankBook bean) {
		return objCashBankBookDAO.getBankBookList(bean);
	}

	@Override
	public ArrayList<CashBankBook> getBankBookAccountList(String sAccCode, String parentCode) {
		return objCashBankBookDAO.getBankBookAccountList(sAccCode, parentCode);
	}

	@Override
	public List<CashBankBook> getGeneralLedgerReport(CashBankBook objGeneralLedgerBean) {
		return objCashBankBookDAO.getGeneralLedgerReport(objGeneralLedgerBean);
	}

	@Override
	public List<CashBankBook> getOpeningBalanceValue(CashBankBook objGeneralLedgerBean) {
		// TODO Auto-generated method stub
		return objCashBankBookDAO.getOpeningBalanceValue(objGeneralLedgerBean);
	}
}