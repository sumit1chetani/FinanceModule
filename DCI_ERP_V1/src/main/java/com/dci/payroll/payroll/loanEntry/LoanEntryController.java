package com.dci.payroll.payroll.loanEntry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/loanentry")
public class LoanEntryController {

	private final static Logger LOGGER = LoggerFactory.getLogger(LoanEntryController.class);

	@Autowired
	private LoanEntryService loanEntryService;

	@RequestMapping(value = "/list")
	public @ResponseBody LoanEntryResultBean getLoanEntryList(@RequestBody int status) {
		LoanEntryResultBean loanEntryResultBean = new LoanEntryResultBean();
		try {

			loanEntryResultBean.setLoanEntryList(loanEntryService.getLoanEntryList(status));
			loanEntryResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loanEntryResultBean;

	}

	@RequestMapping(value = "/emploanentry")
	public LoanEntryResultBean getEmployeeLoanEntry(@RequestBody LoanEntry loanEntryBean) {
		LoanEntryResultBean loanEntryResultBean = new LoanEntryResultBean();
		try {

			loanEntryResultBean.setEmployeeLoanEntry(loanEntryService.getEmployeeLoanEntry(loanEntryBean));
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loanEntryResultBean;

	}

	@RequestMapping(value = "/getEmployeeId")
	public LoanEntryResultBean getEmployeeId(@RequestBody LoanEntry loanEntryBean) {
		LoanEntryResultBean loanEntryResultBean = new LoanEntryResultBean();
		try {
			loanEntryResultBean.setLoanentry(loanEntryService.getEmployeeId(loanEntryBean.getEmployeeId()));
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loanEntryResultBean;

	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody LoanEntry loaEntry) {
		LoanEntryResultBean loanEntryResultBean = new LoanEntryResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = loanEntryService.insertLoanEntry(loaEntry);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/edit")
	public LoanEntryResultBean getLoanEntryById(@RequestBody int loanId) {
		LoanEntryResultBean loanEntryResultBean = new LoanEntryResultBean();
		try {

			loanEntryResultBean.setLoanEntryListById(loanEntryService.getLoanEntryById(loanId));
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loanEntryResultBean;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody LoanEntry loaEntry) {
		LoanEntryResultBean loanEntryResultBean = new LoanEntryResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = loanEntryService.updateLoanEntry(loaEntry);
		} catch (CustomException e) {
			loanEntryResultBean.setSuccess(false);
			loanEntryResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/approvalupdate")
	public boolean approvalupdate(@RequestBody LoanEntry loaEntry) {
		LoanEntryResultBean loanEntryResultBean = new LoanEntryResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = loanEntryService.approvalupdate(loaEntry);
		} catch (CustomException e) {
			loanEntryResultBean.setSuccess(false);
			loanEntryResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody int loanId) {
		boolean isDeleted = false;
		try {
			isDeleted = loanEntryService.deleteLoanEntry(loanId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

}
