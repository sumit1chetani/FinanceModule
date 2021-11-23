package com.dci.tenant.finance.profitandlossnew;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface ProfitAndLossServiceNew {

	List<SelectivityBean> getCompanyList();

	List<ProfitAndLossBean> generatePLReport(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportDtl(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportAHDtl(ProfitAndLossBean objProfitAndLossBean);

	boolean exportPLExcel(String sFilePath, ProfitAndLossBean objProfitAndLossBean);

	ProfitLossResultBeanNew generatePLReportNew(ProfitAndLossBean objProfitAndLossBean);

	// List<ProfitandLossJobOrderReport>
	// geJobOrderReport(ProfitandLossJobOrderReport objrevenueregister);

	ProfitLossResultBeanNew generatePLReportNewHor(ProfitAndLossBean objProfitAndLossBean);

	boolean exportPLExcelHor(String exportFilesPath, ProfitAndLossBean objProfitAndLossBean);

	ProfitAndLossBean getCompanyDetails(String companyCode);

	ProfitAndLossBean pdfExportNew(ProfitAndLossBean profitreport, String exportFilesPath);

	// ProfitLossResultBeanNew exportAsExcel(String exportPath,
	// JobOrderReportResultBean objProfitAndLossBean);

	// String getcompanycode(GeneralLedgerBean objGeneralLedgerBean);

}
