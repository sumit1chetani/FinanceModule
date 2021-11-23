package com.dci.tenant.finance.profitAndLoss;

import java.util.List;

public interface ProfitAndLossDao {
	List<ProfitAndLossBean> generatePLReport1(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReport(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportDtl(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportDtl1(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportAHDtl(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportAHDtl1(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> getProfitLossReportList(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> getProfitLossReportList1(ProfitAndLossBean objProfitAndLossBean);

	public ProfitAndLossBean getProfitLossTransactions(String accountHeadCode, String fromDate, String toDate);

}
