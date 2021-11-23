package com.dci.tenant.finance.disciplinaryaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "{tenantid}/app/hr/disciplinaryaction")

public class DisciplinaryActionController {
	private final static Logger LOGGER = LoggerFactory.getLogger(DisciplinaryActionController.class);
	@Autowired
	DisciplinaryActionService disciplinaryService;

	@RequestMapping("/list")
	public DisciplinaryActionResultBean getDisciplinaryActionList() {

		DisciplinaryActionResultBean disciplinaryBean = new DisciplinaryActionResultBean();
		try {
			disciplinaryBean.setDisciplinaryList(disciplinaryService.getDisciplinaryActionList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return disciplinaryBean;
	}

	@RequestMapping("/save")
	public @ResponseBody boolean saveDisciplinaryData(@RequestBody DisciplinaryActionBean objDisciplinaryData) throws CustomException {

		boolean isSuccess = false;
		try {
			isSuccess = disciplinaryService.insertDisciplinaryData(objDisciplinaryData);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteDisciplinaryData(@RequestBody String disciplinaryId) throws Exception {
		int disciplinaryIds = Integer.parseInt(disciplinaryId);
		boolean isDeleted = false;
		isDeleted = disciplinaryService.deleteDisciplinaryData(disciplinaryIds);
		return isDeleted;
	}

	@RequestMapping("/getDisciplinaryDataEdit")
	public @ResponseBody DisciplinaryActionBean getDisciplinaryDataEdit(@RequestBody Integer disciplinary_proceedings_sk) throws Exception {
		DisciplinaryActionBean objDiscipBean = new DisciplinaryActionBean();
		objDiscipBean = disciplinaryService.getDisciplinaryDataEdit(disciplinary_proceedings_sk);
		return objDiscipBean;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody boolean updateDisciplinaryData(@RequestBody DisciplinaryActionBean objDiscipBean) throws CustomException {
		boolean isSuccess = false;
		DisciplinaryActionResultBean objDisciplinaryResultBean = new DisciplinaryActionResultBean();
		try {

			isSuccess = disciplinaryService.updateDisciplinaryData(objDiscipBean);
			objDisciplinaryResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping(value = "/getEmployeeList")
	public DisciplinaryActionBean getEmployeeList(@RequestBody DisciplinaryActionBean objDiscipBean) {
		DisciplinaryActionBean employeeList = new DisciplinaryActionBean();
		try {
			employeeList = disciplinaryService.getEmployeeList(objDiscipBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

}
