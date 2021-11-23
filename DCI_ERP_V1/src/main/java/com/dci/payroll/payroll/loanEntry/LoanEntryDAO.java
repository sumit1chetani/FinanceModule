package com.dci.payroll.payroll.loanEntry;

import java.util.List;

import com.dci.common.util.CustomException;


public interface LoanEntryDAO {
	public boolean insertLoanEntry(LoanEntry loanEntry) throws CustomException;

	public List<LoanEntry> getLoanEntryList(int status) throws CustomException;

	public List<LoanEntry> getLoanTypeList() throws CustomException;

	public List<LoanEntry> getLoanEntryById(int loanId) throws CustomException;

	public List<LoanEntry> getEmployeeLoanEntry(LoanEntry loanEntryBean) throws CustomException;

	LoanEntry getEmployeeId(String employeeId) throws Exception;

	public boolean updateLoanEntry(LoanEntry loanEntry) throws CustomException;

	public boolean approvalupdate(LoanEntry loanEntry) throws CustomException;

	public boolean deleteLoanEntry(int loanId) throws CustomException;

}
