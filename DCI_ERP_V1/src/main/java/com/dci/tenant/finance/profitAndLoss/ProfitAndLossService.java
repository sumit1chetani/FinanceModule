package com.dci.tenant.finance.profitAndLoss;

import java.util.List;

public interface ProfitAndLossService {
	List<ProfitAndLossBean> generatePLReport1(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReport(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportDtl(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportDtl1(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportAHDtl(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportAHDtl1(ProfitAndLossBean objProfitAndLossBean);

	boolean exportPLExcel1(ProfitAndLossBean objProfitAndLossBean, String filepath);

	boolean exportPLExcel(ProfitAndLossBean objProfitAndLossBean, String filepath);

	public ProfitAndLossBean getProfitLossTransactions(String accountHeadCode, String fromDate, String toDate);

}
