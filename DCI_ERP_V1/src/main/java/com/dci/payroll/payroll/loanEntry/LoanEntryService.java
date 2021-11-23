package com.dci.payroll.payroll.loanEntry;

import java.util.List;

public interface LoanEntryService {

	List<LoanEntry> getLoanEntryList(int status) throws Exception;

	boolean insertLoanEntry(LoanEntry loaEntry) throws Exception;

	List<LoanEntry> getLoanEntryById(int loanId) throws Exception;

	List<LoanEntry> getEmployeeLoanEntry(LoanEntry loanEntryBean) throws Exception;

	LoanEntry getEmployeeId(String employeeId) throws Exception;

	boolean updateLoanEntry(LoanEntry loaEntry) throws Exception;

	boolean approvalupdate(LoanEntry loaEntry) throws Exception;

	boolean deleteLoanEntry(int loanId) throws Exception;
}
