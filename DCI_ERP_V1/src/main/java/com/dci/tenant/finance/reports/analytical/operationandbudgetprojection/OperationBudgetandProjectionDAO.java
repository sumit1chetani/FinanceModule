package com.dci.tenant.finance.reports.analytical.operationandbudgetprojection;

import java.sql.SQLException;
import java.util.List;

public interface OperationBudgetandProjectionDAO {

	public OperationBudgetandProjectionResultBean getvessel() throws Exception;

	public OperationBudgetandProjectionResultBean getvoyage(String vesselCode) throws Exception;

	public OperationBudgetandProjectionResultBean getSectorList() throws Exception;

	public OperationBudgetandProjectionResultBean getSectorCode(String voyageId) throws Exception;

	public boolean insertOperationbudjet(OperationBudgetandProjectionBean operationBudjectProject) throws SQLException;

	public List<OperationBudgetandProjectionBean> getOpernBudgetHdrList(int limit, int offset);

}
