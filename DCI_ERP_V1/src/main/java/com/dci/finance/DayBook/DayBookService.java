package com.dci.finance.DayBook;

import java.io.IOException;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

import jxl.write.WriteException;

public interface DayBookService {

	List<DayBookBean> getGeneralLedgerReport(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getGeneralLedgerAHLevel(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getGeneralTransaction(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getGLTransactionLevel(DayBookBean objGeneralLedgerBean);

	boolean exportGeneralLedgerExcelSecondary(String sFilePath, DayBookBean objGeneralLedgerBean);

	boolean exportGeneralLedgerExcel(String sFilePath, DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getSubLedgerReport(DayBookBean objGeneralLedgerBean);

	DayBookResultBean exportSubLedgerExcel(String exportFilesPath, DayBookBean objGeneralLedgerBean) throws IOException, WriteException;

	List<SelectivityBean> getGroupHeadList();

	List<SelectivityBean> mainaccountList();

	boolean exportGeneralLedgerExcelOP(String exportFilesPath, DayBookBean objGeneralLedgerBean);

	boolean exportTransactionLevelExcel(String exportFilesPath, DayBookBean objGeneralLedgerBean);

	DayBookBean getOpeningBalanceValue(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getSubLedgerReport_only(DayBookBean objGeneralLedgerBean);

	public List<SelectivityBean> getsub(List<String> sub) throws CustomException;

	public List<SelectivityBean> getmain(String main) throws CustomException;

	public DayBookBean getJournalVoucherforPrint(String companyCode);

	public DayBookBean pdfExportNew(DayBookBean detentionTariffBean, String exportFilesPath);

}