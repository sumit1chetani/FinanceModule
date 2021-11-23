package com.dci.payroll.payroll.loanrepayment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanRepaymentServiceImpl implements LoanRepaymentService {

	@Autowired
	LoanRepaymentDAO loanRepaymentDAO;

	@Override
	public List<LoanRepaymentBean> getDeductedList(String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return loanRepaymentDAO.getDeductedList(monthYear);
	}

	@Override
	public List<LoanRepaymentBean> getTobeDeductedList(String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return loanRepaymentDAO.getTobeDeductedList(monthYear);
	}

	@Override
	public List<LoanRepaymentBean> getLoanReport(String departmengt) throws Exception {
		// TODO Auto-generated method stub
		return loanRepaymentDAO.getLoanReport(departmengt);
	}

	@Override
	public List<LoanRepaymentBean> checkLoanRepaymentList(String loanId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return loanRepaymentDAO.checkLoanRepaymentList(loanId, monthYear);
	}

	@Override
	public boolean insertLoanRepayment(ArrayList<LoanRepaymentBean> loanRepaymentBean) throws Exception {
		// TODO Auto-generated method stub
		return loanRepaymentDAO.insertLoanRepayment(loanRepaymentBean);
	}

}