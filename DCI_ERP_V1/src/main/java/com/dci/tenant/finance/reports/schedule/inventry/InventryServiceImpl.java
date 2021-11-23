package com.dci.tenant.finance.reports.schedule.inventry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class InventryServiceImpl implements InventryService {
	private static final long serialVersionUID = 1L;

	@Autowired
	InventryDAO objInventryDAO;

	@Override
	public List<InventryBean> getInventryList(InventryBean inventryBean) throws CustomException {
		return objInventryDAO.getInventryList(inventryBean);
	}

}
