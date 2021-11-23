package com.dci.finance.DayBook;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

public interface DayBookDao {

	List<DayBookBean> getGeneralLedgerReport(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getGeneralLedgerAHLevel(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getGeneralTransaction(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getGLTransactionLevel(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getGeneralLedgerList(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getSubLedgerReport(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getSubLedgerReport1(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getConsolidatedGeneralLedgerList(DayBookBean objGeneralLedgerBean);

	List<SelectivityBean> getGroupHeadList();

	List<SelectivityBean> mainaccountList();

	List<DayBookBean> getGeneralLedgerListOP(DayBookBean objGeneralLedgerBean);

	DayBookBean getOpeningBalance(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getOpeningBalanceSub(DayBookBean objGeneralLedgerBean);

	DayBookBean getOpeningBalanceValue(DayBookBean objGeneralLedgerBean);

	List<DayBookBean> getSubLedgerReport_only(DayBookBean objGeneralLedgerBean);

	public List<SelectivityBean> getsub(List<String> sub) throws CustomException;

	public List<SelectivityBean> getmain(String main) throws CustomException;

	String getcompanycode(DayBookBean objGeneralLedgerBean);

	String getsubgroup(DayBookBean objGeneralLedgerBean);

	String getaccountname(DayBookBean objGeneralLedgerBean);

	String getsubaccountname(DayBookBean objGeneralLedgerBean);

	public DayBookBean getJournalVoucherforPrint(String companyCode);

	public DayBookBean getAddress(DayBookBean objGeneralLedgerBean);

}