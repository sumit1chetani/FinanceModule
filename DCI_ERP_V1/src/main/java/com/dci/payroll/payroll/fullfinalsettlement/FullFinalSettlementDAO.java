package com.dci.payroll.payroll.fullfinalsettlement;

import java.util.List;

import com.dci.common.util.CustomException;


public interface FullFinalSettlementDAO {
	public List<FullFinalSettlementBean> getFullFinalSettlementList(FullFinalSettlementBean finalSettlementBean) throws CustomException;

	public boolean save(FullFinalSettlementBean finalSettlementBean);

	public boolean approve(FullFinalSettlementBean finalSettlementBean);
}