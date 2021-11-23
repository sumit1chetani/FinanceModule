package com.dci.payroll.payroll.earningdeductionmaster;

import java.util.List;

public interface EarningDeductionMasterService {
	List<EarningDeductionMasterBean> getEarningDeductionMasterList() throws Exception;

	List<EarningDeductionMasterBean> getPayComponentList() throws Exception;

	boolean insertEarningDeduction(EarningDeductionMasterBean earningDeductionMasterBean) throws Exception;

	EarningDeductionMasterBean getEarningDeductionbyId(String payComponentId) throws Exception;

	boolean updateEarningDeduction(EarningDeductionMasterBean earningDeductionMasterBean) throws Exception;

	EarningDeductionMasterBean deleteEarningDeduction(String payComponentId) throws Exception;
}