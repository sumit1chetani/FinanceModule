package com.dci.tenant.finance.reports.analytical.operationandbudgetprojection;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationBudgetandProjectionServiceImpl implements OperationBudgetandProjectionService {

	@Autowired
	OperationBudgetandProjectionDAO operationBudgetDAO;

	@Override
	public OperationBudgetandProjectionResultBean getvessel() throws Exception {
		return operationBudgetDAO.getvessel();
	}

	@Override
	public OperationBudgetandProjectionResultBean getvoyage(String vesselCode) throws Exception {
		return operationBudgetDAO.getvoyage(vesselCode);
	}

	@Override
	public OperationBudgetandProjectionResultBean getSectorList() throws Exception {
		return operationBudgetDAO.getSectorList();
	}

	@Override
	public OperationBudgetandProjectionResultBean getSectorCode(String voyageId) throws Exception {
		return operationBudgetDAO.getSectorCode(voyageId);
	}

	@Override
	public boolean insertOperationbudjet(OperationBudgetandProjectionBean operationBudjectProject) throws SQLException {
		return operationBudgetDAO.insertOperationbudjet(operationBudjectProject);
	}

	@Override
	public List<OperationBudgetandProjectionBean> getOpernBudgetHdrList(int limit, int offset) {
		return operationBudgetDAO.getOpernBudgetHdrList(limit, offset);
	}

}
