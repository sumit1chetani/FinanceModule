package com.dci.payroll.payroll.loanrepayment;

import java.util.ArrayList;
import java.util.List;

public interface LoanRepaymentService {

	List<LoanRepaymentBean> getDeductedList(String monthYear) throws Exception;

	List<LoanRepaymentBean> getTobeDeductedList(String monthYear) throws Exception;

	List<LoanRepaymentBean> getLoanReport(String department) throws Exception;

	List<LoanRepaymentBean> checkLoanRepaymentList(String loanId, String monthYear) throws Exception;

	boolean insertLoanRepayment(ArrayList<LoanRepaymentBean> loanRepaymentBean) throws Exception;
}