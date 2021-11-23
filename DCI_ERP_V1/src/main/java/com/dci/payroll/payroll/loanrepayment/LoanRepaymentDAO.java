package com.dci.payroll.payroll.loanrepayment;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CustomException;


public interface LoanRepaymentDAO {
	public List<LoanRepaymentBean> getDeductedList(String monthYear) throws CustomException;

	public List<LoanRepaymentBean> getTobeDeductedList(String monthYear) throws CustomException;

	public List<LoanRepaymentBean> getLoanReport(String monthYear) throws CustomException;

	public List<LoanRepaymentBean> checkLoanRepaymentList(String loanId, String monthYear) throws CustomException;

	public boolean insertLoanRepayment(ArrayList<LoanRepaymentBean> loanRepaymentBean) throws CustomException;
}