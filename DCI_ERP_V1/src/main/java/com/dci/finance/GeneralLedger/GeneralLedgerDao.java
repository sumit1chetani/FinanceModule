package com.dci.finance.GeneralLedger;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

public interface GeneralLedgerDao {

	List<GeneralLedgerBean> getGeneralLedgerReport(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getGeneralLedgerAHLevel(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getGeneralTransaction(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getGLTransactionLevel(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getGeneralLedgerList(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getSubLedgerReport(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getSubLedgerReport1(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getConsolidatedGeneralLedgerList(GeneralLedgerBean objGeneralLedgerBean);

	List<SelectivityBean> getGroupHeadList();

	List<SelectivityBean> mainaccountList();

	List<GeneralLedgerBean> getGeneralLedgerListOP(GeneralLedgerBean objGeneralLedgerBean);

	GeneralLedgerBean getOpeningBalance(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getOpeningBalanceSub(GeneralLedgerBean objGeneralLedgerBean);

	GeneralLedgerBean getOpeningBalanceValue(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getSubLedgerReport_only(GeneralLedgerBean objGeneralLedgerBean);

	public List<SelectivityBean> getsub(List<String> sub) throws CustomException;

	public List<SelectivityBean> getmain(String main) throws CustomException;

	String getcompanycode(GeneralLedgerBean objGeneralLedgerBean);

	String getsubgroup(GeneralLedgerBean objGeneralLedgerBean);

	String getaccountname(GeneralLedgerBean objGeneralLedgerBean);

	String getsubaccountname(GeneralLedgerBean objGeneralLedgerBean);

	public GeneralLedgerBean getJournalVoucherforPrint(String companyCode);

	public GeneralLedgerBean getAddress(GeneralLedgerBean objGeneralLedgerBean);

	List<GeneralLedgerBean> getGeneralLedgerAHLevelAcct(GeneralLedgerBean objGeneralLedgerBean);

}