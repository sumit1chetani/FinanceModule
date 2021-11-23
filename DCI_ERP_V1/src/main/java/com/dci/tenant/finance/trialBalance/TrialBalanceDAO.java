package com.dci.tenant.finance.trialBalance;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface TrialBalanceDAO {

	public List<SelectivityBean> getCompanyList();

	public List<SelectivityBean> getSubGroupList();

	public List<SelectivityBean> getSubAccountList();
	public List<SelectivityBean> getAccountList();

	public List<SelectivityBean> getAccountHeadList(String subGroupCode);

	public List<TrialBalanceBean> getTrialBalanceSGList1(TrialBalanceBean objTrialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSGList(TrialBalanceBean objTrialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSGListRPSplitup(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceAHLevel(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceAHLevel1(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSALevel(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSALevel1(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSALevelRPonly(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceSALevelExcludeRP(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceAHLevelRPonly(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceAHLevelExcludeRp(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceListRPSplit(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceList(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceList1(TrialBalanceBean trialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceGLList(TrialBalanceBean objTrialBalanceBean);

	public List<TrialBalanceBean> getTrialBalanceListWithPlain(TrialBalanceBean trialBalanceBean);

	//public List<TrialBalanceBean> getTrialBalanceSGList2(TrialBalanceBean trialBalanceBean);

}