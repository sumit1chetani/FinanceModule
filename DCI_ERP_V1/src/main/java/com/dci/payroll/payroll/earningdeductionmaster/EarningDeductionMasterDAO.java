package com.dci.payroll.payroll.earningdeductionmaster;

import java.util.List;

import com.dci.common.util.CustomException;


public interface EarningDeductionMasterDAO {
	List<EarningDeductionMasterBean> getEarningDeductionMasterList() throws CustomException;

	List<EarningDeductionMasterBean> getPayComponentList() throws CustomException;

	public boolean insertEarningDeduction(EarningDeductionMasterBean earningDeductionMasterBean) throws CustomException;

	public EarningDeductionMasterBean getEarningDeductionbyId(String payComponentId) throws CustomException;

	public boolean updateEarningDeduction(EarningDeductionMasterBean earningDeductionMasterBean) throws CustomException;

	public EarningDeductionMasterBean deleteEarningDeduction(String payComponentId) throws CustomException;

}