package com.dci.tenant.finance.BudgetReport;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.tenant.finance.budgetAllocation.BudgetAllocationController;

@RestController
@RequestMapping(value = "app/budgetreport")
public class BudgetReportController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetAllocationController.class);

	@Autowired
	private BudgetReportService ObjBudgetReportService;

	@RequestMapping(value = "/searchlist", method = RequestMethod.POST)
	public @ResponseBody BudgetReportResultBean searchportDtl(@RequestBody BudgetReportBean objBudgetReportBean) throws Exception {
		BudgetReportResultBean objPendingapprovalResultBean = new BudgetReportResultBean();
		objPendingapprovalResultBean.setSearchList(ObjBudgetReportService.searchportDtl(objBudgetReportBean));
		objPendingapprovalResultBean.setSuccess(true);
		return objPendingapprovalResultBean;
	}

	@RequestMapping(value = "/ExportExcel", method = RequestMethod.POST)
	public @ResponseBody BudgetReportResultBean getExcelReportExportList(@RequestBody BudgetReportBean objPendingapprovalBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		BudgetReportResultBean objPendingapprovalResultBean = new BudgetReportResultBean();
		List<BudgetReportBean> lQuotationBean = new ArrayList<>();

		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			System.out.println("List Of  fee excel");
			// quotationResultBean.setlQuotationBean(ObjPendingapprovalService.getList(objPendingapprovalBean));
			objPendingapprovalResultBean.setSearchList(ObjBudgetReportService.searchportDtl(objPendingapprovalBean));

			ObjBudgetReportService.excellExport(objPendingapprovalResultBean, objPendingapprovalBean, sFilePath);

			objPendingapprovalResultBean.setSuccess(true);
		} catch (Exception e) {
			System.out.println(e);

		}
		return objPendingapprovalResultBean;
	}
}
