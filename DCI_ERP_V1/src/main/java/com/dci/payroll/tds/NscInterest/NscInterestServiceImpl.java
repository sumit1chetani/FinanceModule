package com.dci.payroll.tds.NscInterest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NscInterestServiceImpl implements NscInterestService {
	@Autowired
	NscInterestDAO nscInterestDAO;

	@Override
	public List<NscInterestBean> getNscInterestList() throws Exception {
		return nscInterestDAO.getNscInterestList();
	}

	@Override
	public NscInterestBean getNscInterestById(String financialYear) throws Exception {
		return nscInterestDAO.getNscInterestById(financialYear);
	}

	@Override
	public boolean insertNscInterest(NscInterestBean nscInterest) throws Exception {
		return nscInterestDAO.insertNscInterest(nscInterest);
	}

	@Override
	public boolean updateNscInterest(NscInterestBean nscInterest) throws Exception {
		return nscInterestDAO.updateNscInterest(nscInterest);
	}

}
