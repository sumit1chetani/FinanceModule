package com.dci.payroll.payroll.Esi;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.payroll.tds.professionaltaxslab.ProfessionalTaxSlabController;


@RestController
@RequestMapping(value = "payroll/payroll/esi")
public class EsiController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ProfessionalTaxSlabController.class);

	@Autowired
	EsiService esiService;

	@RequestMapping(value = "/list")
	public EsiResultBean getEPFList(@RequestBody EsiBean bean) {
		EsiResultBean esiResultBean = new EsiResultBean();
		try {
			esiResultBean.setEsiBeanList(esiService.getESIList(bean));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esiResultBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody EsiResultBean exportExcelAverage(@RequestBody ArrayList<EsiBean> esiBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		EsiResultBean esiResultBean = new EsiResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = esiService.insertEsiList(esiBean);
			if (isSuccess == true) {
				//String filePath = request.getServletContext().getRealPath("/tempdoc/EMPLOYEE_ESI_FILE.xls");
				esiService.exportExcel(esiBean, ConfigurationProps.exportFilesPath);
				esiResultBean.setSuccess(true);
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return esiResultBean;

	}
	
	
	
	

}