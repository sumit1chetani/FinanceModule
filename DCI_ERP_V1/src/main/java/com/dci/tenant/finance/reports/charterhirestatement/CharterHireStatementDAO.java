package com.dci.tenant.finance.reports.charterhirestatement;

import java.util.List;

public interface CharterHireStatementDAO {

	List<CharterHireStatementBean> getCharterHireStmtReportData(CharterHireStatementBean objCharterHireStatementBean);

}
