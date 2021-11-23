package com.dci.payroll.payroll.loanEntry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanEntryServiceImpl implements LoanEntryService {

	@Autowired
	LoanEntryDAO loanEntryDAO;

	@Override
	public boolean insertLoanEntry(LoanEntry loaEntry) throws Exception {
		// TODO Auto-generated method stub
		return loanEntryDAO.insertLoanEntry(loaEntry);
	}

	@Override
	public List<LoanEntry> getLoanEntryList(int status) throws Exception {
		return loanEntryDAO.getLoanEntryList(status);
	}

	@Override
	public List<LoanEntry> getLoanEntryById(int loanId) throws Exception {
		// TODO Auto-generated method stub
		return loanEntryDAO.getLoanEntryById(loanId);
	}

	@Override
	public boolean updateLoanEntry(LoanEntry loaEntry) throws Exception {
		// TODO Auto-generated method stub
		return loanEntryDAO.updateLoanEntry(loaEntry);
	}

	@Override
	public boolean approvalupdate(LoanEntry loaEntry) throws Exception {
		// TODO Auto-generated method stub
		return loanEntryDAO.approvalupdate(loaEntry);
	}

	@Override
	public boolean deleteLoanEntry(int loanId) throws Exception {
		// TODO Auto-generated method stub
		return loanEntryDAO.deleteLoanEntry(loanId);
	}

	@Override
	public List<LoanEntry> getEmployeeLoanEntry(LoanEntry loanEntryBean) throws Exception {
		// TODO Auto-generated method stub
		return loanEntryDAO.getEmployeeLoanEntry(loanEntryBean);
	}

	@Override
	public LoanEntry getEmployeeId(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		return loanEntryDAO.getEmployeeId(employeeId);
	}
}
