package com.dci.payroll.payroll.fullfinalsettlement;

import java.util.List;

public interface FullFinalSettlementService {
	public List<FullFinalSettlementBean> getFullFinalSettlementList(FullFinalSettlementBean finalSettlementBean) throws Exception;

	public boolean save(FullFinalSettlementBean finalSettlementBean);

	public boolean approve(FullFinalSettlementBean finalSettlementBean);
}