package com.dci.payroll.payroll.payslip;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;


@RestController
@RequestMapping(value = "payroll/payroll/payslip")
public class PaySlipController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PaySlipController.class);
	@Autowired
	PaySlipService paySlipService;

	@RequestMapping(value = "/generate")
	public PaySlipResultBean getPaySlipList(@RequestBody PaySlipBean resultBean) {
		PaySlipResultBean paySlipResultBean = new PaySlipResultBean();
		try {
			paySlipResultBean.setPaySlipListDTO(paySlipService.getPaySlipList(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getEmployeeId(), resultBean.getMonthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paySlipResultBean;
	}

	@RequestMapping(value = "/mailid")
	public PaySlipBean getPaySlipList(@RequestParam("employeeId") String employeeId) {
		PaySlipBean paySlipBean = new PaySlipBean();
		String mail;
		try {
			paySlipBean = paySlipService.getPaySlipList1(employeeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return paySlipBean;
	}

	@RequestMapping(value = "/bulkmailid")
	public PaySlipResultBean getPaySlipList1(@RequestBody List<PaySlipBean> employeeId) {
		PaySlipResultBean paySlipBean = new PaySlipResultBean();
		String mail;
		try {
			paySlipBean = paySlipService.getPaySlipList2(employeeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return paySlipBean;
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
		if(paySlipListDTO.getPaySlipList().size()>0)
		obj.addObject("companydetail", paySlipListDTO.getPaySlipList().get(0).getCmpyadd());
		
		else{
			obj.addObject("companydetail", "");
		}
		if(paySlipListDTO.getPaySlipList().size()>0)
			obj.addObject("monthdetail", paySlipListDTO.getPaySlipList().get(0).getMonthYear());
			
			else{
				obj.addObject("monthdetail", "");
			}
		return obj;
	}

	@RequestMapping("/sendMail")
	public @ResponseBody PaySlipResultBean sendMail(@RequestParam("companyId") String companyId, @RequestParam("branchId") String branchId, @RequestParam("dept") String dept, @RequestParam("employeeId") String employeeId, @RequestParam("emailAddress") String emailAddress, @RequestParam("monthYear") String monthYear, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PaySlipResultBean resultBean = new PaySlipResultBean();

		PaySlipListDTO paySlipListDTO = new PaySlipListDTO();

		paySlipListDTO = paySlipService.getPaySlipList(companyId, branchId, dept, employeeId, monthYear);

		resultBean = paySlipService.sendMailForPaySlip(companyId, branchId, dept, employeeId, monthYear, emailAddress, userDetails, request, response, paySlipListDTO);

		return resultBean;
	}

	@RequestMapping("/sendMailBulk")
	public @ResponseBody PaySlipResultBean sendMailBulk(@RequestBody PaySlipBean PaySlipBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		PaySlipResultBean resultBean = new PaySlipResultBean();

		PaySlipListDTO paySlipListDTO = new PaySlipListDTO();

		for (PaySlipBean obj : PaySlipBean.getMailSend()) {

			if (obj.isSelect() == true) {

				paySlipListDTO = paySlipService.getPaySlipList(PaySlipBean.getCompanyId(), PaySlipBean.getBranchId(), obj.getDept(), obj.getEmpId(), PaySlipBean.getMonthYear());

				resultBean = paySlipService.sendMailForPaySlip(PaySlipBean.getCompanyId(), PaySlipBean.getBranchId(), obj.getDept(), obj.getEmpId(), PaySlipBean.getMonthYear(), obj.getEmail(), userDetails, request, response, paySlipListDTO);

			}
		}
		return resultBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody PaySlipResultBean exportExcelAverage(@RequestBody PaySlipBean paySlipBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		PaySlipResultBean paySlipResultBean = new PaySlipResultBean();

		try {
		//	String filePath = request.getServletContext().getRealPath("/tempdoc/PaySlip.xls");
			paySlipService.exportExcel(paySlipBean, ConfigurationProps.exportFilesPath);
			//paySlipService.exportExcel(paySlipBean, filePath);
			paySlipResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return paySlipResultBean;

	}
}