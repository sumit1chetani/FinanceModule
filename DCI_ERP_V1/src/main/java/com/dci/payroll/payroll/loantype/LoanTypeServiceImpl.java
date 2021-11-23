package com.dci.payroll.payroll.loantype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanTypeServiceImpl implements LoanTypeService {
	@Autowired
	LoanTypeDAO loanTypeDAO;

	@Override
	public List<LoanType> getLoanTypeList() throws Exception {
		// TODO Auto-generated method stub
		return loanTypeDAO.getLoanTypeList();
	}

	@Override
	public List<LoanType> getActiveLoanTypeList() throws Exception {
		// TODO Auto-generated method stub
		return loanTypeDAO.getActiveLoanTypeList();
	}

	@Override
	public List<LoanType> getLoanTypeListById(String loanTypeId) throws Exception {
		// TODO Auto-generated method stub
		return loanTypeDAO.getLoanTypeListById(loanTypeId);
	}

	@Override
	public boolean insertLoanType(LoanType loanTypeBean) throws Exception {
		// TODO Auto-generated method stub
		return loanTypeDAO.insertLoanType(loanTypeBean);
	}

	@Override
	public boolean updateLoanType(LoanType loanTypeBean) throws Exception {
		// TODO Auto-generated method stub
		return loanTypeDAO.updateLoanType(loanTypeBean);
	}

	@Override
	public LoanType deleteLoanType(String loanTypeId) throws Exception {
		// TODO Auto-generated method stub
		return loanTypeDAO.deleteLoanType(loanTypeId);
	}

}
