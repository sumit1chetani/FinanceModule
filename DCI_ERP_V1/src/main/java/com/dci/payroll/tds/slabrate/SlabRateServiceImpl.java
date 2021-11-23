package com.dci.payroll.tds.slabrate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlabRateServiceImpl implements SlabRateService {
	@Autowired
	SlabRateDAO slabRateDAO;

	@Override
	public List<SlabRateBean> getSlabRateList() throws Exception {
		return slabRateDAO.getSlabRateList();
	}

	@Override
	public List<SlabRateBean> getTaxPayerTypeList() throws Exception {
		// TODO Auto-generated method stub
		return slabRateDAO.getTaxPayerTypeList();
	}

	@Override
	public SlabRateBean getSlabRateListById(int taxRateId) throws Exception {
		// TODO Auto-generated method stub
		return slabRateDAO.getSlabRateListById(taxRateId);
	}

	@Override
	public boolean insertSlabRate(SlabRateBean slabRateBean) throws Exception {
		// TODO Auto-generated method stub
		return slabRateDAO.insertSlabRate(slabRateBean);
	}

	@Override
	public boolean updateSlabRate(SlabRateBean slabRateBean) throws Exception {
		// TODO Auto-generated method stub
		return slabRateDAO.updateSlabRate(slabRateBean);
	}

	@Override
	public boolean deleteSlabRate(int taxRateId) throws Exception {
		// TODO Auto-generated method stub
		return slabRateDAO.deleteSlabRate(taxRateId);
	}
}