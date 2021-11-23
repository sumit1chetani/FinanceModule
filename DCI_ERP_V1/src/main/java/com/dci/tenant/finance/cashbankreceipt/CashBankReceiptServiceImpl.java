package com.dci.tenant.finance.cashbankreceipt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class CashBankReceiptServiceImpl implements CashBankReceiptService {

	@Autowired
	CashBankReceiptDAO objCashBankReceiptDAO;

	@Override
	public CashBankReceiptResultBean getBankDrpDwn() throws CustomException {
		return objCashBankReceiptDAO.getBankDrpDwn();
	}

	@Override
	public CashBankReceiptResultBean getCashDrpDwn() throws CustomException {
		return objCashBankReceiptDAO.getCashDrpDwn();
	}

	@Override
	public CashBankReceiptResultBean getCurrencyAndExchangeRate(String accountNo) throws CustomException {
		return objCashBankReceiptDAO.getCurrencyAndExchangeRate(accountNo);
	}

	@Override
	public List<CashBankReceiptListBean> getCashBankReceiptHdrList(int limit, int offset) {
		return objCashBankReceiptDAO.getCashBankReceiptHdrList(limit, offset);
	}

	@Override
	public boolean addCashBankReceiptHdr(CashBankReceiptListBean objCashBankReceiptListBean, String userId, String companyCode) throws CustomException {
		return objCashBankReceiptDAO.addCashBankReceiptHdr(objCashBankReceiptListBean, userId, companyCode);
	}

	@Override
	public boolean deleteCBReceiptData(String voucherNo) {
		return objCashBankReceiptDAO.deleteCashBankReceiptData(voucherNo);
	}

	@Override
	public CashBankReceiptListBean getReceiptVoucherDetailforEdit(String voucherNo) {
		return objCashBankReceiptDAO.getReceiptVoucherDetailforEdit(voucherNo);
	}

	@Override
	public boolean updateCashBankReceiptData(CashBankReceiptListBean objCashBankReceiptListBean) {
		return objCashBankReceiptDAO.updateCashBankReceiptData(objCashBankReceiptListBean);
	}

	@Override
	public CashBankReceiptResultBean getCompanyListWithUser(String userId, String companyCode) {
		return objCashBankReceiptDAO.getCompanyListWithUser(userId, companyCode);
	}

	@Override
	public List<CashBankReceiptListBean> getReceivedFromList() {
		return objCashBankReceiptDAO.getReceivedFromList();
	}

	@Override
	public CashBankReceiptDetailBean getPendingInvoiceDetails(String customerCode) {
		return objCashBankReceiptDAO.getPendingInvoiceDetails(customerCode);
	}

	@Override
	public String reverseReceipt(String receiptVoucherNo, String createdDate) {
		return objCashBankReceiptDAO.reverseReceipt(receiptVoucherNo, createdDate);
	}

	@Override
	public CashBankReceiptListBean getReceiptVoucherforView(String voucherNo) {
		// TODO Auto-generated method stub
		return objCashBankReceiptDAO.getReceiptVoucherforView(voucherNo);
	}

	@Override
	public CashBankReceiptResultBean getReceiptNo(String pmtype, String cbReceiptDate) throws CustomException {
		// TODO Auto-generated method stub
		return objCashBankReceiptDAO.getReceiptNo(pmtype,cbReceiptDate);
	}
	
	@Override
	public CashBankReceiptListBean getReceiptVoucherforView1(String voucherNo) {
		// TODO Auto-generated method stub
		return objCashBankReceiptDAO.getReceiptVoucherforView1(voucherNo);
	}
	
	
	
	
	
	

	
}
