package com.dci.payroll.payroll.loantype;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class LoanTypeResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<LoanType> loanTypeList;
	private List<LoanType> activeLoanTypeList;
	private List<LoanType> loanTypeListById;

	private LoanType loanTypebean = new LoanType();

	public List<LoanType> getLoanTypeList() {
		return loanTypeList;
	}

	public void setLoanTypeList(List<LoanType> loanTypeList) {
		this.loanTypeList = loanTypeList;
	}

	public LoanType getloanTypebean() {
		return loanTypebean;
	}

	public void setloanTypebean(LoanType loanTypebean) {
		this.loanTypebean = loanTypebean;
	}

	public List<LoanType> getActiveLoanTypeList() {
		return activeLoanTypeList;
	}

	public void setActiveLoanTypeList(List<LoanType> activeLoanTypeList) {
		this.activeLoanTypeList = activeLoanTypeList;
	}

	public List<LoanType> getLoanTypeListById() {
		return loanTypeListById;
	}

	public void setLoanTypeListById(List<LoanType> loanTypeListById) {
		this.loanTypeListById = loanTypeListById;
	}

}
