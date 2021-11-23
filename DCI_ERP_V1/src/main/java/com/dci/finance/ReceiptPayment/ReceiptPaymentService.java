package com.dci.finance.ReceiptPayment;

import java.io.IOException;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

import jxl.write.WriteException;

public interface ReceiptPaymentService {

	List<ReceiptPaymentBean> getGeneralLedgerReport(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGeneralLedgerAHLevel(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGeneralTransaction(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGLTransactionLevel(ReceiptPaymentBean objGeneralLedgerBean);

	boolean exportGeneralLedgerExcelSecondary(String sFilePath, ReceiptPaymentBean objGeneralLedgerBean);

	boolean exportGeneralLedgerExcel(String sFilePath, ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getSubLedgerReport(ReceiptPaymentBean objGeneralLedgerBean);

	ReceiptPaymentResultBean exportSubLedgerExcel(String exportFilesPath, ReceiptPaymentBean objGeneralLedgerBean) throws IOException, WriteException;

	List<SelectivityBean> getGroupHeadList();

	List<SelectivityBean> mainaccountList();

	boolean exportGeneralLedgerExcelOP(String exportFilesPath, ReceiptPaymentBean objGeneralLedgerBean);

	boolean exportTransactionLevelExcel(String exportFilesPath, ReceiptPaymentBean objGeneralLedgerBean);

	ReceiptPaymentBean getOpeningBalanceValue(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getSubLedgerReport_only(ReceiptPaymentBean objGeneralLedgerBean);

	public List<SelectivityBean> getsub(List<String> sub) throws CustomException;

	public List<SelectivityBean> getmain(String main) throws CustomException;

	public ReceiptPaymentBean getJournalVoucherforPrint(String companyCode);

	List<ReceiptPaymentBean> getGLTransactionLevel1(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGLBankDetail(ReceiptPaymentBean objGeneralLedgerBean);

	List<ReceiptPaymentBean> getGLBankDetailPayemnt(ReceiptPaymentBean objGeneralLedgerBean);

	public ReceiptPaymentBean pdfExportNew(ReceiptPaymentBean rpreport, String exportFilesPath);

}