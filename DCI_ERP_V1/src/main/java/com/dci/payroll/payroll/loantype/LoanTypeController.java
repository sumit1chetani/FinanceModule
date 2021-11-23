package com.dci.payroll.payroll.loantype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/loantype")
public class LoanTypeController {

	private final static Logger LOGGER = LoggerFactory.getLogger(LoanTypeController.class);

	@Autowired
	private LoanTypeService loanTypeService;

	@RequestMapping(value = "/list")
	public LoanTypeResultBean getLoanTypeList() {
		LoanTypeResultBean loanTypeResultBean = new LoanTypeResultBean();
		try {

			loanTypeResultBean.setLoanTypeList(loanTypeService.getLoanTypeList());
			loanTypeResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loanTypeResultBean;

	}

	@RequestMapping(value = "/loantypelist")
	public LoanTypeResultBean getActiveLoanTypeList() {
		LoanTypeResultBean loanTypeResultBean = new LoanTypeResultBean();
		try {
			loanTypeResultBean.setActiveLoanTypeList(loanTypeService.getActiveLoanTypeList());

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loanTypeResultBean;

	}

	@RequestMapping(value = "/loantypelistbyid")
	public LoanTypeResultBean getLoanTypeListById(@RequestBody String loanTypeId) {
		LoanTypeResultBean loanTypeResultBean = new LoanTypeResultBean();
		try {

			loanTypeResultBean.setLoanTypeListById(loanTypeService.getLoanTypeListById(loanTypeId));

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loanTypeResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody LoanType loanTypeBean) {
		boolean isSuccess = false;
		try {
			isSuccess = loanTypeService.insertLoanType(loanTypeBean);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody LoanType loanTypeBean) {
		boolean isSuccess = false;
		try {
			isSuccess = loanTypeService.updateLoanType(loanTypeBean);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public LoanType delete(@RequestBody String loanTypeId) {
		LoanType loanTypeBean = new LoanType();
		try {
			loanTypeBean = loanTypeService.deleteLoanType(loanTypeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loanTypeBean;
	}

}
