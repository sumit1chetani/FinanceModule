package com.dci.payroll.payroll.loanEntry;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class LoanEntryResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<LoanEntry> LoanEntryList;
	private List<LoanEntry> LoanEntryListById;
	private List<LoanEntry> employeeLoanEntry;
	private LoanEntry loanentry = new LoanEntry();

	/**
	 * @return the loanEntryList
	 */
	public List<LoanEntry> getLoanEntryList() {
		return LoanEntryList;
	}

	/**
	 * @param loanEntryList
	 *            the loanEntryList to set
	 */
	public void setLoanEntryList(List<LoanEntry> loanEntryList) {
		LoanEntryList = loanEntryList;
	}

	public List<LoanEntry> getLoanEntryListById() {
		return LoanEntryListById;
	}

	public void setLoanEntryListById(List<LoanEntry> loanEntryListById) {
		LoanEntryListById = loanEntryListById;
	}

	public List<LoanEntry> getEmployeeLoanEntry() {
		return employeeLoanEntry;
	}

	public void setEmployeeLoanEntry(List<LoanEntry> employeeLoanEntry) {
		this.employeeLoanEntry = employeeLoanEntry;
	}

	public LoanEntry getLoanentry() {
		return loanentry;
	}

	public void setLoanentry(LoanEntry loanentry) {
		this.loanentry = loanentry;
	}

}
