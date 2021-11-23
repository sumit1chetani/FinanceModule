package com.dci.finance.GeneralLedger;

import java.io.IOException;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

import jxl.write.WriteException;

public interface GeneralLedgerService {

	List<GeneralLedgerBean> getGeneralLedgerReport(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getGeneralLedgerAHLevel(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getGeneralTransaction(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getGLTransactionLevel(GeneralLedgerBean objGeneralLedgerBean);

	boolean exportGeneralLedgerExcelSecondary(String sFilePath, GeneralLedgerBean objGeneralLedgerBean);

	boolean exportGeneralLedgerExcel(String sFilePath, GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getSubLedgerReport(GeneralLedgerBean objGeneralLedgerBean);

	GeneralLedgerResultBean exportSubLedgerExcel(String exportFilesPath, GeneralLedgerBean objGeneralLedgerBean) throws IOException, WriteException;

	List<SelectivityBean> getGroupHeadList();

	List<SelectivityBean> mainaccountList();

	boolean exportGeneralLedgerExcelOP(String exportFilesPath, GeneralLedgerBean objGeneralLedgerBean);

	boolean exportTransactionLevelExcel(String exportFilesPath, GeneralLedgerBean objGeneralLedgerBean);

	GeneralLedgerBean getOpeningBalanceValue(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getSubLedgerReport_only(GeneralLedgerBean objGeneralLedgerBean);

	public List<SelectivityBean> getsub(List<String> sub) throws CustomException;

	public List<SelectivityBean> getmain(String main) throws CustomException;

	public GeneralLedgerBean getJournalVoucherforPrint(String companyCode);

	List<GeneralLedgerBean> getGeneralLedgerAHLevelAcct(GeneralLedgerBean objGeneralLedgerBean);

	public GeneralLedgerBean pdfExportNew(GeneralLedgerBean glreport, String exportFilesPath);

}