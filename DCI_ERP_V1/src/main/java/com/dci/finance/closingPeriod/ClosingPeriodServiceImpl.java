package com.dci.finance.closingPeriod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class ClosingPeriodServiceImpl implements ClosingPeriodService {

	@Autowired
	ClosingPeriodDAO objClosingPeriodDAO;

	@Override
	public List<ClosingPeriodBean> getClosingList() throws CustomException {
		// TODO Auto-generated method stub
		return objClosingPeriodDAO.getClosingList();
	}

	@Override
	public boolean delete(String closingAccountCode) throws CustomException {
		// TODO Auto-generated method stub
		return objClosingPeriodDAO.delete(closingAccountCode);
	}

	@Override
	public boolean save(ClosingPeriodBean objClosingPeriodBean) throws CustomException {
		// TODO Auto-generated method stub
		return objClosingPeriodDAO.save(objClosingPeriodBean);
	}

	@Override
	public boolean chkDate(String cbReceiptDate) throws CustomException {
		// TODO Auto-generated method stub
		return objClosingPeriodDAO.chkDate(cbReceiptDate);
	}
}
