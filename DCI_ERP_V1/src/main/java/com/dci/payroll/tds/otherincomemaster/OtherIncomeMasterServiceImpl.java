package com.dci.payroll.tds.otherincomemaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherIncomeMasterServiceImpl implements OtherIncomeMasterService {
	@Autowired
	OtherIncomeMasterDAO otherIncomeMasterDAO;

	@Override
	public List<OtherIncomeMasterBean> getOtherIncomeMasterList() throws Exception {
		return otherIncomeMasterDAO.getOtherIncomeMasterList();
	}

}