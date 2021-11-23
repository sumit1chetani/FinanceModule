package com.dci.tenant.finance.cashbankreceipt;

import java.util.List;

import com.dci.common.util.CustomException;

public interface CashBankReceiptDAO {

	public CashBankReceiptResultBean getBankDrpDwn() throws CustomException;

	public CashBankReceiptResultBean getCashDrpDwn() throws CustomException;

	public CashBankReceiptResultBean getCurrencyAndExchangeRate(String accountNo) throws CustomException;

	public boolean addCashBankReceiptHdr(CashBankReceiptListBean objCashBankReceiptListBean, String userId, String companyCode) throws CustomException;

	public List<CashBankReceiptListBean> getCashBankReceiptHdrList(int limit, int offset);

	public boolean deleteCashBankReceiptData(String voucherNo);

	public CashBankReceiptListBean getReceiptVoucherDetailforEdit(String voucherNo);

	public boolean updateCashBankReceiptData(CashBankReceiptListBean objCashBankReceiptListBean);

	public CashBankReceiptResultBean getCompanyListWithUser(String userId, String companyCode);

	public List<CashBankReceiptListBean> getReceivedFromList();

	public CashBankReceiptDetailBean getPendingInvoiceDetails(String customerCode);

	public String reverseReceipt(String receiptVoucherNo, String createdDate);

	public CashBankReceiptListBean getReceiptVoucherforView(String voucherNo);

	public CashBankReceiptResultBean getReceiptNo(String pmtype, String cbReceiptDate) throws CustomException;
	
	public CashBankReceiptListBean getReceiptVoucherforView1(String voucherNo);

}
