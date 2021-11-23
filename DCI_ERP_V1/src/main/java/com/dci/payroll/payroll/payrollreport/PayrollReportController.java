package com.dci.payroll.payroll.payrollreport;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.CustomException;
import com.dci.payroll.payroll.payslip.PaySlipDTO;
import com.dci.payroll.payroll.payslip.PaySlipListDTO;
import com.dci.payroll.payroll.payslip.PaySlipService;



@RestController
@RequestMapping(value = "payroll/payroll/payrollreport")
public class PayrollReportController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PayrollReportController.class);
	@Autowired
	PayrollReportService payrollReportService;
	@Autowired
	PaySlipService paySlipService;

	@RequestMapping(value = "/list")
	public PayrollReportResultBean getPayRollList(@RequestBody PayrollReportBean resultBean) {
		PayrollReportResultBean payrollResultBean = new PayrollReportResultBean();
		try {
			payrollResultBean.setPayRollList(payrollReportService.getPayrollList(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getMonthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollResultBean;
	}

	@RequestMapping(value = "/monthlyreport")
	public PayrollReportResultBean getMonthlyPayRollList(@RequestBody PayrollReportBean resultBean) {
		PayrollReportResultBean payrollResultBean = new PayrollReportResultBean();
		try {
			payrollResultBean.setMonthlyPayRollList(payrollReportService.getMonthlyPayrollList(resultBean.getEmployeeId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollResultBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody PayrollReportResultBean exportExcelAverage(@RequestBody PayrollReportBean payrollReportBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		PayrollReportResultBean payrollReportResultBean = new PayrollReportResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc/Salary.xls");
			payrollReportService.exportExcel(payrollReportBean, filePath);
			payrollReportResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return payrollReportResultBean;

	}

	@RequestMapping("/print")
	public ModelAndView printPaySlipReport(@RequestParam("companyId") String companyId, @RequestParam("branchId") String branchId, @RequestParam("dept") String dept, @RequestParam("employeeId") String employeeId, @RequestParam("monthYear") String monthYear) throws Exception {

		ModelAndView obj = null;
		int totalEarnings = 0;
		int totalDeductions = 0;
		int totalDeduct = 0;

		NumberFormat formatter = new DecimalFormat("#0.00");

		obj = new ModelAndView("print/paySlipReportPdf");
		PaySlipDTO objBean = new PaySlipDTO();
		PaySlipListDTO paySlipListDTO = new PaySlipListDTO();
		paySlipListDTO = paySlipService.getPaySlipList(companyId, branchId, dept, employeeId, monthYear);

		List<PaySlipDTO> list = paySlipListDTO.getPaySlipList();

		for (int i = 0; i < list.size(); i++) {

			PaySlipDTO dtbean = list.get(i);
			totalEarnings = (int) dtbean.getTotalEarnings() + totalEarnings;
			totalDeductions = (int) dtbean.getTotalDeductions() + totalDeductions;

			for (int j = 0; j < dtbean.getEarningsList().size(); j++) {
				dtbean.getEarningsList().get(j).setPrintamount((int) dtbean.getEarningsList().get(j).getAmount());
			}

			for (int k = 0; k < dtbean.getDeductionsList().size(); k++) {
				dtbean.getDeductionsList().get(k).setPrintamount((int) dtbean.getDeductionsList().get(k).getAmount());
			}
		}

		objBean.setEarnings(totalEarnings);
		totalDeduct = totalEarnings - totalDeductions;

		objBean.setDeductions(totalDeduct);

		obj.addObject("paySlipReportObj", objBean);
		obj.addObject("paySlipReportList", paySlipListDTO.getPaySlipList());

		return obj;
	}
}