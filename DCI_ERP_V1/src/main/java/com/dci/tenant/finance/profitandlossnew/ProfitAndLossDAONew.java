package com.dci.tenant.finance.profitandlossnew;

import java.util.List;
import java.util.Map;

import com.dci.common.model.SelectivityBean;

public interface ProfitAndLossDAONew {

	List<SelectivityBean> getCompanyList();

	List<ProfitAndLossBean> generatePLReport(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportDtl(ProfitAndLossBean objProfitAndLossBean);

	List<ProfitAndLossBean> generatePLReportAHDtl(ProfitAndLossBean objProfitAndLossBean);

	Map<String, ProfitAndLossBean> getProfitLossReportList(ProfitAndLossBean objProfitAndLossBean);

	ProfitAndLossBean getCompanyDetails(String companyCode);


	// String getBranch(JobOrderReportResultBean objGeneralLedgerBean);
}
