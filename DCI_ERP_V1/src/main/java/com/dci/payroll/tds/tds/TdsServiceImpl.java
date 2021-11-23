package com.dci.payroll.tds.tds;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TdsServiceImpl implements TdsService {
	@Autowired
	TdsDAO tdsDAO;

	@Override
	public List<TdsBean> getSlabList(String employeeId, String financialYear) throws Exception {
		// TODO Auto-generated method stub
		return tdsDAO.getSlabList(employeeId, financialYear);
	}

	@Override
	public List<Map<String, Object>> getPayList(String employeeId, String financialYear) throws Exception {
		// TODO Auto-generated method stub
		return tdsDAO.getPayList(employeeId, financialYear);
	}

	@Override
	public List<Map<String, Object>> getSubSectionList(String employeeId, String financialYear, boolean declared, boolean actuval) throws Exception {
		// TODO Auto-generated method stub
		return tdsDAO.getSubSectionList(employeeId, financialYear, declared, actuval);
	}

	@Override
	public List<Map<String, Object>> getOtherIncomeList(String employeeId, String financialYear) throws Exception {
		// TODO Auto-generated method stub
		return tdsDAO.getOtherIncomeList(employeeId, financialYear);
	}

	@Override
	public TdsBean getmothBean(String employeeId, String financialYear) throws Exception {
		// TODO Auto-generated method stub
		return tdsDAO.getmothBean(employeeId, financialYear);
	}

}