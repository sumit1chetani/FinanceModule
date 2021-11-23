package com.dci.payroll.payroll.earningdeductionmaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EarningDeductionMasterServiceImpl implements EarningDeductionMasterService {
	@Autowired
	EarningDeductionMasterDAO earningDeductionMasterDAO;

	@Override
	public List<EarningDeductionMasterBean> getEarningDeductionMasterList() throws Exception {
		// TODO Auto-generated method stub
		return earningDeductionMasterDAO.getEarningDeductionMasterList();
	}

	@Override
	public List<EarningDeductionMasterBean> getPayComponentList() throws Exception {
		// TODO Auto-generated method stub
		return earningDeductionMasterDAO.getPayComponentList();
	}

	@Override
	public boolean insertEarningDeduction(EarningDeductionMasterBean earningDeductionMasterBean) throws Exception {
		// TODO Auto-generated method stub
		return earningDeductionMasterDAO.insertEarningDeduction(earningDeductionMasterBean);
	}

	@Override
	public EarningDeductionMasterBean getEarningDeductionbyId(String payComponentId) throws Exception {
		// TODO Auto-generated method stub
		return earningDeductionMasterDAO.getEarningDeductionbyId(payComponentId);
	}

	@Override
	public boolean updateEarningDeduction(EarningDeductionMasterBean earningDeductionMasterBean) throws Exception {
		// TODO Auto-generated method stub
		return earningDeductionMasterDAO.updateEarningDeduction(earningDeductionMasterBean);
	}

	@Override
	public EarningDeductionMasterBean deleteEarningDeduction(String payComponentId) throws Exception {
		// TODO Auto-generated method stub
		return earningDeductionMasterDAO.deleteEarningDeduction(payComponentId);
	}

}