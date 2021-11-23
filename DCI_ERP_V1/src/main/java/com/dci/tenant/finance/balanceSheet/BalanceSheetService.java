package com.dci.tenant.finance.balanceSheet;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface BalanceSheetService {

	public List<SelectivityBean> getCompanyList();

	public List<BalanceSheetBean> getBalanceSheetList1(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> getBalanceSheetList(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> generateBalanceSheetReportDtl(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> generateBalanceSheetReportAHDtl(BalanceSheetBean objBalanceSheetBean);

	public boolean excelBSExport(BalanceSheetBean objBalanceSheetBean, String filepath);

	public boolean excelBSExport1(BalanceSheetBean objBalanceSheetBean, String filepath);

	// new
	public List<BalanceSheetBean> getBalanceSheetListAsset(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> getBalanceSheetListLiabilities(BalanceSheetBean objBalanceSheetBean);

	public BalanceSheetBean getBalanceSheetListAssetCurrentPeriod(BalanceSheetBean objBalanceSheetBean);

	public BalanceSheetBean pdfExportNew(BalanceSheetBean bsreport, String exportFilesPath);

}
