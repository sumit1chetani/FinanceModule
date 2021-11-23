package com.dci.payroll.payroll.withHold;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/withhold")
public class WithHoldController {

	private final static Logger LOGGER = LoggerFactory.getLogger(WithHoldController.class);

	@Autowired
	private WithHoldService WithholdService;

	@RequestMapping(value = "/employeeList")
	public WithHoldResultBean getEmployeeList() {
		WithHoldResultBean objPayrollWithHoldResultBean = new WithHoldResultBean();
		try {
			objPayrollWithHoldResultBean.setEmployeeList(WithholdService.getEmployeeList());
			objPayrollWithHoldResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollWithHoldResultBean;
	}

	// year list
	@RequestMapping(value = "/yearList")
	public WithHoldResultBean getYearList() {
		WithHoldResultBean objPayrollWithHoldResultBean = new WithHoldResultBean();
		try {
			objPayrollWithHoldResultBean.setYearList(WithholdService.getYearList());
			objPayrollWithHoldResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollWithHoldResultBean;
	}

	// list
	@RequestMapping(value = "/withHoldList")
	public @ResponseBody WithHoldResultBean withHoldList() {
		WithHoldResultBean loanEntryResultBean = new WithHoldResultBean();
		try {

			loanEntryResultBean.setWithholdList(WithholdService.getWithHoldList());
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

	@RequestMapping(value = "/addwithhold")
	public boolean addWithHold(@RequestBody WithHoldBean withHold) {
		WithHoldResultBean loanEntryResultBean = new WithHoldResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = WithholdService.addWithHold(withHold);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	// update

	@RequestMapping(value = "/updatewithhold")
	public boolean updateWithHold(@RequestBody WithHoldBean withHold) {
		WithHoldResultBean loanEntryResultBean = new WithHoldResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = WithholdService.updateWithHold(withHold);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	// with hold Report

	@RequestMapping(value = "/withholdReport")
	public @ResponseBody WithHoldResultBean withholdReport(@RequestBody WithHoldBean withhold) {
		WithHoldResultBean loanEntryResultBean = new WithHoldResultBean();
		try {

			loanEntryResultBean.setWithholdAddList(WithholdService.getWithholdReport(withhold));
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

	// edit

	@RequestMapping(value = "/withholdEdit")
	public @ResponseBody WithHoldResultBean withHoldEdit(@RequestParam("withHoldCode") String withHoldCode) {
		WithHoldResultBean loanEntryResultBean = new WithHoldResultBean();
		try {

			loanEntryResultBean.setWithholdList(WithholdService.editwithHold(withHoldCode));
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

	// employe check

	@RequestMapping(value = "/employeeCheck")
	public @ResponseBody WithHoldResultBean employeeCheck(@RequestParam("employee") String employee) {
		WithHoldResultBean loanEntryResultBean = new WithHoldResultBean();
		try {

			loanEntryResultBean.setWithholdList(WithholdService.employeeCheck(employee));
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

	// delete
	@RequestMapping(value = "/deletewithHold")
	public boolean deleteWithHold(@RequestParam String withHoldCode) {
		boolean isDeleted = false;
		try {
			isDeleted = WithholdService.deleteWithHold(withHoldCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

	// export excel

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody WithHoldResultBean exportExcel(@RequestBody WithHoldBean withhold, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		WithHoldResultBean withholdResultBean = new WithHoldResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc/Withhold.xls");
			WithholdService.exportExcel(withhold, filePath);
			withholdResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return withholdResultBean;

	}

}
