package com.dci.payroll.payroll.fullfinalsettlement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullFinalSettlementServiceImpl implements FullFinalSettlementService {
	@Autowired
	FullFinalSettlementDAO fullFinalSettlementDAO;

	@Override
	public List<FullFinalSettlementBean> getFullFinalSettlementList(FullFinalSettlementBean finalSettlementBean) throws Exception {
		return fullFinalSettlementDAO.getFullFinalSettlementList(finalSettlementBean);
	}

	@Override
	public boolean save(FullFinalSettlementBean finalSettlementBean) {
		// TODO Auto-generated method stub
		return fullFinalSettlementDAO.save(finalSettlementBean);
	}

	@Override
	public boolean approve(FullFinalSettlementBean finalSettlementBean) {
		// TODO Auto-generated method stub
		return fullFinalSettlementDAO.approve(finalSettlementBean);
	}

}