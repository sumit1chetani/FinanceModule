package com.dci.tenant.finance.trialBalance;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.finance.GeneralLedger.GeneralLedgerBean;

public interface TrialBalanceService {

	public List<SelectivityBean> getCompanyList();

	public List<SelectivityBean> getSubGroupList();

	public List<SelectivityBean> getAccountHeadList(String subGroupCode);

	public List<SelectivityBean> getSubAccountList();

	public List<TrialBalanceBean> getTrialBalanceSGList(TrialBalanceBean objTrialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSGList1(TrialBalanceBean objTrialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSGListRPSplitup(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceAHLevel(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceAHLevel1(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSALevel1(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSALevel(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSALevelRPonly(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSALevelExcludeRP(TrialBalanceBean trialBalanceBean);

	public boolean exportTBExcel1(String sFilePath, TrialBalanceBean trialBalanceBean);

	public boolean exportTBExcel(String sFilePath, TrialBalanceBean trialBalanceBean);

	public boolean exportTBExcelFormatNew(String sFilePath, TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceAHLevelRPonly(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceAHLevelExcludeRp(TrialBalanceBean trialBalanceBean);

	public boolean exportTBExcelSplitRP(String sFilePath, TrialBalanceBean trialBalanceBean);

	public boolean exportTBExcelWithPlain(String sFilePath, TrialBalanceBean trialBalanceBean);

	public TrialBalanceBean pdfExportNew(TrialBalanceBean tbreport, String exportFilesPath);

	//public List<TrialBalanceBean> getTrialBalanceSGList2(TrialBalanceBean trialBalanceBean);

	public List<SelectivityBean> getAccountList();

}