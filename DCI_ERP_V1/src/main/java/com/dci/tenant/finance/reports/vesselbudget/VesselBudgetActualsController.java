package com.dci.tenant.finance.reports.vesselbudget;
/*package com.mbk.tenant.finance.reports.vesselbudget;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mbk.common.util.BasicResultBean;
import com.mbk.common.util.ConfigurationProps;
import com.mbk.common.util.CustomException;
//import com.mbkfinance.budget.budgetAllocation.BudgetAllocationBean;
//import com.mbkfinance.budget.budgetAllocation.BudgetAllocationResultBean;


@Controller
@RequestMapping(value = "{tenantid}/app/fibudgetactuals")
public class VesselBudgetActualsController {

	private final static Logger LOGGER = LoggerFactory.getLogger(VesselBudgetActualsController.class);

	@Autowired
	private VesselBudgetActualsService budgetActualsService;

	@RequestMapping("/list")
	public @ResponseBody BudgetAllocationResultBean getBudgetActualsList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		BudgetAllocationResultBean budgetAllocationResultBean = new BudgetAllocationResultBean();

		try {
			budgetAllocationResultBean.setBudgetAllocationBeanList(budgetActualsService.getBudgetActualsList());
			budgetAllocationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return budgetAllocationResultBean;
	}

	@RequestMapping("/viewOld")
	public @ResponseBody VesselBudgetActualsBean getBudgetAllocationDtl(@RequestBody VesselBudgetActualsBean objBudgetActualsBean) throws CustomException,
			InterruptedException {
		VesselBudgetActualsBean budgetActualsBean = null;

		try {
			System.out.println("budget actuals dtl" + objBudgetActualsBean.getDepartmentName() + "=" + objBudgetActualsBean.getBudgetDesc());
			budgetActualsBean = budgetActualsService.getBudgetAllocationDetails(objBudgetActualsBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return budgetActualsBean;
	}
	
	@RequestMapping("/view")
	public @ResponseBody BudgetAllocationBean getBudgetActuals(@RequestBody BudgetAllocationBean objBudgetAllocaitonBean) throws CustomException, InterruptedException {
		BudgetAllocationBean budgetAllocationBean = null;

		try {
			System.out.println("budget allocaiton dtl");
			budgetAllocationBean = budgetActualsService.getBudgetActuals(objBudgetAllocaitonBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return budgetAllocationBean;
	}

	@RequestMapping("/getVessel")
	public @ResponseBody List<VesselBudgetActualsBean> getVesselList() throws CustomException {
		List<VesselBudgetActualsBean> vesselList = new ArrayList<VesselBudgetActualsBean>();

		try {
			vesselList = budgetActualsService.getVesselList();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return vesselList;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody VesselBudgetActualsResultBean exportExcel(@RequestBody VesselBudgetActualsBean objBudgetActualsBean, HttpServletRequest request,
			HttpServletRequest response) throws CustomException {
		VesselBudgetActualsResultBean budgetActualsResultBean = new VesselBudgetActualsResultBean();
		try {
			System.out.println("budget actual excel export=");
			String msg = budgetActualsService.excelExport(objBudgetActualsBean, ConfigurationProps.exportFilesPath + "/BudgetActuals.xls");
			budgetActualsResultBean.setSuccess(true);
			budgetActualsResultBean.setMessage(msg);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return budgetActualsResultBean;

	}
	
	
	@RequestMapping(value = "/budgetActualsExcelExport")
	public @ResponseBody VesselBudgetActualsResultBean exportExcelBudgetVsActual(@RequestBody BudgetAllocationBean objBudgetAllocaitonBean, HttpServletRequest request,
			HttpServletRequest response) throws CustomException {
		VesselBudgetActualsResultBean budgetActualsResultBean = new VesselBudgetActualsResultBean();
		try {
			System.out.println("budget vs actual excel export");
			String msg = budgetActualsService.budgetActualsExcelExport(objBudgetAllocaitonBean, ConfigurationProps.exportFilesPath + "/BudgetActuals.xls");
			budgetActualsResultBean.setSuccess(true);
			budgetActualsResultBean.setMessage(msg);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return budgetActualsResultBean;

	}
	

	@RequestMapping("/budgetUpload")
	public @ResponseBody BasicResultBean bulkUpload(MultipartFile file) throws CustomException {
		BasicResultBean objBasicResultBean = new BasicResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					String sMessage = budgetActualsService.uploadFile(file);
					if(sMessage=="" || sMessage.isEmpty()){
						objBasicResultBean.setSuccess(true);
						objBasicResultBean.setMessage("Uploaded Sucessfully");
					}else{
						objBasicResultBean.setMessage(sMessage);
					}
					
				} else {
					objBasicResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				objBasicResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBasicResultBean;
	}

}
*/