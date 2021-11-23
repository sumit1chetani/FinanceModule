package com.dci.payroll.payroll.rate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {
	@Autowired
	RateDAO rateDAO;

	@Override
	public List<RateBean> getRateList() throws Exception {
		// TODO Auto-generated method stub
		return rateDAO.getRateList();
	}

	@Override
	public RateBean getRateListById(int taxRateId) throws Exception {
		// TODO Auto-generated method stub
		return rateDAO.getRateListById(taxRateId);
	}

	@Override
	public boolean insertRate(RateBean rateBean) throws Exception {
		// TODO Auto-generated method stub
		return rateDAO.insertRate(rateBean);
	}

	@Override
	public boolean updateRate(RateBean rateBean) throws Exception {
		// TODO Auto-generated method stub
		return rateDAO.updateRate(rateBean);
	}

	@Override
	public boolean deleteRate(int taxRateId) throws Exception {
		// TODO Auto-generated method stub
		return rateDAO.deleteRate(taxRateId);
	}

}
