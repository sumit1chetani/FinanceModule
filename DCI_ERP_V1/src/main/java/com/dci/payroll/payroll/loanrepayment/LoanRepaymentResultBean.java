package com.dci.payroll.payroll.loanrepayment;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class LoanRepaymentResultBean extends BasicResultBean implements Serializable {
	private List<LoanRepaymentBean> loanDeductedList = null;
	private List<LoanRepaymentBean> loanTobeDeductedList = null;

	public List<LoanRepaymentBean> getLoanDeductedList() {
		return loanDeductedList;
	}

	public void setLoanDeductedList(List<LoanRepaymentBean> loanDeductedList) {
		this.loanDeductedList = loanDeductedList;
	}

	public List<LoanRepaymentBean> getLoanTobeDeductedList() {
		return loanTobeDeductedList;
	}

	public void setLoanTobeDeductedList(List<LoanRepaymentBean> loanTobeDeductedList) {
		this.loanTobeDeductedList = loanTobeDeductedList;
	}
}