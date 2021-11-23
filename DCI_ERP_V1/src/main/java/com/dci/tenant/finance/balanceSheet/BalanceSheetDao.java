package com.dci.tenant.finance.balanceSheet;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface BalanceSheetDao {

	public List<SelectivityBean> getCompanyList();
	
	
	//public List<BalanceSheetBean> getCompanyList();

	public List<BalanceSheetBean> getBalanceSheetList1(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> getBalanceSheetListAsset(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> getBalanceSheetListLiabilities(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> getBalanceSheetList(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> generateBalanceSheetReportDtl(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> generateBalanceSheetReportAHDtl(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> getBalanceSheetReportList1(BalanceSheetBean objBalanceSheetBean);

	public List<BalanceSheetBean> getBalanceSheetReportList(BalanceSheetBean objBalanceSheetBean);

	BalanceSheetBean getBalanceSheetListAssetCurrentPeriod(BalanceSheetBean objBalanceSheetBean);




}
