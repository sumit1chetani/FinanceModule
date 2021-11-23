package com.dci.payroll.payroll.loanrepayment;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/loanrepayment")
public class LoanRepaymentController {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoanRepaymentController.class);

	@Autowired
	private LoanRepaymentService loanRepaymentService;

	@RequestMapping(value = "/deductedlist")
	public LoanRepaymentResultBean getLoanDeductedList(@RequestBody String monthYear) {
		LoanRepaymentResultBean loanRepaymentResultBean = new LoanRepaymentResultBean();
		try {
			loanRepaymentResultBean.setLoanDeductedList(loanRepaymentService.getDeductedList(monthYear));
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loanRepaymentResultBean;
	}

	@RequestMapping(value = "/todeductedlist")
	public LoanRepaymentResultBean getLoanTobeDeductedList(@RequestBody String monthYear) {
		LoanRepaymentResultBean loanRepaymentResultBean = new LoanRepaymentResultBean();
		try {
			loanRepaymentResultBean.setLoanTobeDeductedList(loanRepaymentService.getTobeDeductedList(monthYear));
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loanRepaymentResultBean;
	}

	@RequestMapping(value = "/loanlist")
	public LoanRepaymentResultBean getLoanReport(@RequestBody String newValue) {
		LoanRepaymentResultBean loanRepaymentResultBean = new LoanRepaymentResultBean();
		try {
			loanRepaymentResultBean.setLoanTobeDeductedList(loanRepaymentService.getLoanReport(newValue));
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loanRepaymentResultBean;
	}

	@RequestMapping(value = "/deductloan")
	public boolean save(@RequestBody ArrayList<LoanRepaymentBean> loanRepaymentBean) {
		LoanRepaymentResultBean loanRepaymentResultBean = new LoanRepaymentResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = loanRepaymentService.insertLoanRepayment(loanRepaymentBean);

		} catch (CustomException e) {
			loanRepaymentResultBean.setSuccess(false);
			loanRepaymentResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}
}