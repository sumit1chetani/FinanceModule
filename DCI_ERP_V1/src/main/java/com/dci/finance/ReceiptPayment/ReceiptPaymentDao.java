package com.dci.finance.ReceiptPayment;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

public interface ReceiptPaymentDao {

	List<ReceiptPaymentBean> getGeneralLedgerReport(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGeneralLedgerAHLevel(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGeneralTransaction(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGLTransactionLevel(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGeneralLedgerList(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getSubLedgerReport(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getSubLedgerReport1(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getConsolidatedGeneralLedgerList(ReceiptPaymentBean objGeneralLedgerBean);

	List<SelectivityBean> getGroupHeadList();

	List<SelectivityBean> mainaccountList();

	List<ReceiptPaymentBean> getGeneralLedgerListOP(ReceiptPaymentBean objGeneralLedgerBean);

	ReceiptPaymentBean getOpeningBalance(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getOpeningBalanceSub(ReceiptPaymentBean objGeneralLedgerBean);

	ReceiptPaymentBean getOpeningBalanceValue(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getSubLedgerReport_only(ReceiptPaymentBean objGeneralLedgerBean);

	public List<SelectivityBean> getsub(List<String> sub) throws CustomException;

	public List<SelectivityBean> getmain(String main) throws CustomException;

	String getcompanycode(ReceiptPaymentBean objGeneralLedgerBean);

	String getsubgroup(ReceiptPaymentBean objGeneralLedgerBean);

	String getaccountname(ReceiptPaymentBean objGeneralLedgerBean);

	String getsubaccountname(ReceiptPaymentBean objGeneralLedgerBean);

	public ReceiptPaymentBean getJournalVoucherforPrint(String companyCode);

	public ReceiptPaymentBean getAddress(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGLTransactionLevel1(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGLBankDetail(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGLBankDetailPayemnt(ReceiptPaymentBean objGeneralLedgerBean);

}