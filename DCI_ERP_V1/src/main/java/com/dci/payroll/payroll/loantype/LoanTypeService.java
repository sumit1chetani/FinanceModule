package com.dci.payroll.payroll.loantype;

import java.util.List;

public interface LoanTypeService {

	List<LoanType> getLoanTypeList() throws Exception;

	List<LoanType> getActiveLoanTypeList() throws Exception;

	List<LoanType> getLoanTypeListById(String loanTypeId) throws Exception;

	boolean insertLoanType(LoanType loanTypeBean) throws Exception;

	boolean updateLoanType(LoanType loanTypeBean) throws Exception;

	LoanType deleteLoanType(String loanTypeId) throws Exception;
}
