package com.dci.payroll.tds.otherheadentry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherHeadEntryServiceImpl implements OtherHeadEntryService {
	@Autowired
	OtherHeadEntryDAO otherHeadEntryDAO;

	@Override
	public List<OtherHeadEntryBean> getOtherHeadEntryList(String employeeId, String financialYearId) throws Exception {
		return otherHeadEntryDAO.getOtherHeadEntryList(employeeId, financialYearId);
	}

	@Override
	public boolean insertOtherHead(ArrayList<OtherHeadEntryBean> otherHeadEntryBean) throws Exception {
		// TODO Auto-generated method stub
		return otherHeadEntryDAO.insertOtherHead(otherHeadEntryBean);
	}

	@Override
	public OtherHeadEntryBean getOtherHeadById(Integer otherHeadId) throws Exception {
		// TODO Auto-generated method stub
		return otherHeadEntryDAO.getOtherHeadById(otherHeadId);
	}

	@Override
	public boolean updateHeadEntry(OtherHeadEntryBean otherHeadEntryBean) throws Exception {
		// TODO Auto-generated method stub
		return otherHeadEntryDAO.updateHeadEntry(otherHeadEntryBean);
	}

	@Override
	public boolean deleteOtherHeadEntry(Integer otherHeadId) throws Exception {
		// TODO Auto-generated method stub
		return otherHeadEntryDAO.deleteOtherHeadEntry(otherHeadId);
	}

}