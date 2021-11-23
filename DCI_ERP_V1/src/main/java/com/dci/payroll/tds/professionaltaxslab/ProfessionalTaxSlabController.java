package com.dci.payroll.tds.professionaltaxslab;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;


@RestController
@RequestMapping(value = "payroll/tds/ptslab")
public class ProfessionalTaxSlabController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ProfessionalTaxSlabController.class);

	@Autowired
	ProfessionalTaxSlabService professionalTaxSlabService;

	@RequestMapping(value = "/list")
	public ProfessionalTaxSlabResultBean getProfessionalTaxSlabList() {
		ProfessionalTaxSlabResultBean professionalTaxSlabResultBean = new ProfessionalTaxSlabResultBean();
		try {
			professionalTaxSlabResultBean.setProfessionalTaxSlabList(professionalTaxSlabService.getProfessionalTaxSlabList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professionalTaxSlabResultBean;
	}

	@RequestMapping(value = "/generationlist")
	public ProfessionalTaxSlabResultBean getProfessionalGenerationList(@RequestBody ProfessionalTaxSlabBean professionalTaxSlabBean) {
		ProfessionalTaxSlabResultBean professionalTaxSlabResultBean = new ProfessionalTaxSlabResultBean();
		try {
			professionalTaxSlabResultBean.setProfessionaltxList(professionalTaxSlabService.getProfessionalGenerationList(professionalTaxSlabBean.getCompanyId(), professionalTaxSlabBean.getBranchId(), professionalTaxSlabBean.getDepartmentId(), professionalTaxSlabBean.getFinancialYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professionalTaxSlabResultBean;
	}

	@RequestMapping(value = "/generatetypelist")
	public ProfessionalTaxSlabResultBean getProfessionalGenerationList1(@RequestBody ProfessionalTaxSlabBean professionalTaxSlabBean) {
		ProfessionalTaxSlabResultBean professionalTaxSlabResultBean = new ProfessionalTaxSlabResultBean();
		try {
			professionalTaxSlabResultBean.setProfessionaltxList(professionalTaxSlabService.gettypeList(professionalTaxSlabBean.getCompanyId(), professionalTaxSlabBean.getBranchId(), professionalTaxSlabBean.getDept(), professionalTaxSlabBean.getTypeId(), professionalTaxSlabBean.getFinancialYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professionalTaxSlabResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody ProfessionalTaxSlabBean professionalTaxSlabBean) {
		ProfessionalTaxSlabResultBean taxsectionResultBean = new ProfessionalTaxSlabResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = professionalTaxSlabService.insertPtSlab(professionalTaxSlabBean);

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
	public ProfessionalTaxSlabBean getTaxSectionById(@RequestBody ProfessionalTaxSlabBean professionalTaxSlabBean) {
		try {
			return professionalTaxSlabService.getPtSlabById(professionalTaxSlabBean.getBranchId(), professionalTaxSlabBean.getFinancialYear(), professionalTaxSlabBean.getRangeFrom());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/insertEmployeePTList")
	public boolean insertEmployeePTList(@RequestBody ArrayList<ProfessionalTaxSlabBean> professionalTaxSlabBeans) {

		ProfessionalTaxSlabResultBean taxSlabResultBean = new ProfessionalTaxSlabResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = professionalTaxSlabService.insertEmployeePTList(professionalTaxSlabBeans);
		} catch (CustomException e) {
			taxSlabResultBean.setSuccess(false);
			taxSlabResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping(value = "/insertEmployeeDeductionList")
	public boolean insertEmployeePTList1(@RequestBody ArrayList<ProfessionalTaxSlabBean> professionalTaxSlabBeans) {

		ProfessionalTaxSlabResultBean taxSlabResultBean = new ProfessionalTaxSlabResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = professionalTaxSlabService.insertEmployeedeDuctionList(professionalTaxSlabBeans);
		} catch (CustomException e) {
			taxSlabResultBean.setSuccess(false);
			taxSlabResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody ProfessionalTaxSlabBean professionalTaxSlabBean) {
		ProfessionalTaxSlabResultBean professionalTaxSlabResultBean = new ProfessionalTaxSlabResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = professionalTaxSlabService.updatePTSlab(professionalTaxSlabBean);
		} catch (CustomException e) {
			professionalTaxSlabResultBean.setSuccess(false);
			professionalTaxSlabResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody ProfessionalTaxSlabBean professionalTaxSlabBean) {
		boolean isDeleted = false;
		try {
			isDeleted = professionalTaxSlabService.deletePTSlab(professionalTaxSlabBean.getBranchId(), professionalTaxSlabBean.getFinancialYear(), professionalTaxSlabBean.getRangeFrom());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

	@RequestMapping(value = "/financialYear")
	public ProfessionalTaxSlabResultBean getFinancialYear(@RequestBody String companyId) {
		ProfessionalTaxSlabResultBean professionalTaxSlabResultBean = new ProfessionalTaxSlabResultBean();
		try {
			professionalTaxSlabResultBean.setFinancialYearList(professionalTaxSlabService.getFinancialYear(companyId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professionalTaxSlabResultBean;
	}

	@RequestMapping(value = "/getLoginfinancialYear")
	public ProfessionalTaxSlabResultBean getLoginfinancialYear() {

		ProfessionalTaxSlabResultBean professionalTaxSlabResultBean = new ProfessionalTaxSlabResultBean();
		try {
			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			professionalTaxSlabResultBean.setFinancialYearList(professionalTaxSlabService.getLoginfinancialYear(user.getCompanyCode()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professionalTaxSlabResultBean;
	}

	@RequestMapping(value = "/financialYearList")
	public ProfessionalTaxSlabResultBean getFinancialYearList() {
		ProfessionalTaxSlabResultBean professionalTaxSlabResultBean = new ProfessionalTaxSlabResultBean();
		try {
			professionalTaxSlabResultBean.setFinancialYearList(professionalTaxSlabService.getFinancialYearList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professionalTaxSlabResultBean;
	}

	// Import FILE

	@RequestMapping("/uploadfile")
	public @ResponseBody ProfessionalTaxSlabResultBean uploadFile(MultipartFile file) throws CustomException {
		ProfessionalTaxSlabResultBean professionalTaxSlabResultBean = new ProfessionalTaxSlabResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {

					professionalTaxSlabResultBean.setProfessionalTaxSlabBean(professionalTaxSlabService.uploadFile(file));
					professionalTaxSlabResultBean.setSuccess(true);
				} else {
					professionalTaxSlabResultBean.setSuccess(false);

				}

			} else {
				professionalTaxSlabResultBean.setSuccess(false);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return professionalTaxSlabResultBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody ProfessionalTaxSlabResultBean exportExcelAverage(@RequestBody ProfessionalTaxSlabBean taxSlabBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		ProfessionalTaxSlabResultBean captainMessageResultBean = new ProfessionalTaxSlabResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc/Employee_Profession_Tax.xls");
			professionalTaxSlabService.exportExcel(taxSlabBean,  ConfigurationProps.exportFilesPath);
			captainMessageResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return captainMessageResultBean;

	}

	@RequestMapping(value = "/exportExcel1")
	public @ResponseBody ProfessionalTaxSlabResultBean exportExcelAverage1(@RequestBody ProfessionalTaxSlabBean taxSlabBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		ProfessionalTaxSlabResultBean captainMessageResultBean = new ProfessionalTaxSlabResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc/Employee_Deduction.xls");
			professionalTaxSlabService.exportExcel1(taxSlabBean,  ConfigurationProps.exportFilesPath);
			captainMessageResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return captainMessageResultBean;

	}

}