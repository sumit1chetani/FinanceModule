package com.dci.payroll.payroll.loantype;

import java.util.List;

import com.dci.common.util.CustomException;


public interface LoanTypeDAO {
	public List<LoanType> getLoanTypeList() throws CustomException;

	public List<LoanType> getActiveLoanTypeList() throws CustomException;

	public List<LoanType> getLoanTypeListById(String loanTypeId) throws CustomException;

	public boolean insertLoanType(LoanType loanTypeBean) throws CustomException;

	public boolean updateLoanType(LoanType loanTypeBean) throws CustomException;

	public LoanType deleteLoanType(String loanTypeId) throws CustomException;

}
