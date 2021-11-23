package com.dci.payroll.payroll.advance;

import java.util.ArrayList;

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
@RequestMapping(value = "payroll/payroll/advance")
public class AdvanceController {

	private final static Logger LOGGER = LoggerFactory.getLogger(AdvanceController.class);

	@Autowired
	private AdvanceService AdvanceService;

	@RequestMapping(value = "/employeeList")
	public AdvanceResultBean getDepartmentList() {
		AdvanceResultBean objPayrollGenerationResultBean = new AdvanceResultBean();
		try {
			objPayrollGenerationResultBean.setEmployeeList(AdvanceService.getEmployeeList());
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/employeeDetail")
	public Advance getemployeeDetail(@RequestParam("emp") String emp) {
		Advance objPayrollGenerationResultBean = new Advance();
		try {
			objPayrollGenerationResultBean = AdvanceService.getEmployeeDetail(emp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/designatioList")
	public AdvanceResultBean getDesignationList() {
		AdvanceResultBean objPayrollGenerationResultBean = new AdvanceResultBean();
		try {
			objPayrollGenerationResultBean.setEmployeeList(AdvanceService.getDesignationList());
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/getEmployeeList")
	public AdvanceResultBean getEmployeeList(@RequestParam("des") String des) {
		AdvanceResultBean objPayrollGenerationResultBean = new AdvanceResultBean();
		try {
			objPayrollGenerationResultBean.setEmployeeList(AdvanceService.getEmployeeListbasondes(des));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/getInsList")
	public AdvanceResultBean getInsList(@RequestBody Advance Advance) {
		AdvanceResultBean objPayrollGenerationResultBean = new AdvanceResultBean();
		try {
			objPayrollGenerationResultBean.setAdvanceCountList(AdvanceService.getInsList(Advance));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/addAdvance")
	public boolean addAdvance(@RequestBody Advance Advance) {
		AdvanceResultBean loanEntryResultBean = new AdvanceResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = AdvanceService.addAdvance(Advance);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/advanceList")
	public @ResponseBody AdvanceResultBean advanceList() {
		AdvanceResultBean loanEntryResultBean = new AdvanceResultBean();
		try {

			loanEntryResultBean.setAdvanceList(AdvanceService.getAdvanceListList());
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

	@RequestMapping(value = "/advanceEdit")
	public @ResponseBody AdvanceResultBean advanceEdit(@RequestParam("advanceCode") String advanceCode) {
		AdvanceResultBean loanEntryResultBean = new AdvanceResultBean();
		try {

			loanEntryResultBean.setAdvanceList(AdvanceService.getAdvanceListbyCode(advanceCode));
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

	@RequestMapping(value = "/updateAdvance")
	public boolean updateAdvance(@RequestBody Advance Advance) {
		AdvanceResultBean loanEntryResultBean = new AdvanceResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = AdvanceService.updateAdvance(Advance);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/deleteAdvance")
	public boolean deleteAdvance(@RequestParam String advanceCode) {
		boolean isDeleted = false;
		try {
			isDeleted = AdvanceService.deleteAdvance(advanceCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

	@RequestMapping(value = "/advanceAddList")
	public @ResponseBody AdvanceResultBean advanceAddList(@RequestBody Advance Advance) {
		AdvanceResultBean loanEntryResultBean = new AdvanceResultBean();
		try {

			loanEntryResultBean.setAdvanceAddList(AdvanceService.getAdvanceAddList(Advance));
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

	@RequestMapping(value = "/advanceAddGenerate")
	public AdvanceResultBean advanceAddGenerate(@RequestBody ArrayList<Advance> Advance) {

		AdvanceResultBean taxSlabResultBean = new AdvanceResultBean();

		try {
			taxSlabResultBean = AdvanceService.addAdvanceAmount(Advance);
		} catch (CustomException e) {
			taxSlabResultBean.setSuccess(false);
			taxSlabResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taxSlabResultBean;

	}

	@RequestMapping(value = "advanceDegenerate")
	public AdvanceResultBean advanceDegenerate(@RequestBody Advance Advance) {
		AdvanceResultBean advanceDegenerate = new AdvanceResultBean();
		try {
			boolean isdeleted = false;
			isdeleted = AdvanceService.deleteAdvanceAdd(Advance.getMonthYear(), Advance.getDepartmentId(), Advance.getEmployeeCode());
			advanceDegenerate.setSuccess(isdeleted);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return advanceDegenerate;
	}

	@RequestMapping(value = "/advanceReport")
	public @ResponseBody AdvanceResultBean advanceReport(@RequestBody Advance Advance) {
		AdvanceResultBean loanEntryResultBean = new AdvanceResultBean();
		try {

			loanEntryResultBean.setAdvanceAddList(AdvanceService.getAdvanceReport(Advance));
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

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody AdvanceResultBean exportExcelAverage(@RequestBody Advance Advance, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		AdvanceResultBean paySlipResultBean = new AdvanceResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc/Advance.xls");
			AdvanceService.exportExcel(Advance, filePath);
			paySlipResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return paySlipResultBean;

	}
}
