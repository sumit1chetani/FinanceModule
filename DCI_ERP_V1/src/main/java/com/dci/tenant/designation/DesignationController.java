package com.dci.tenant.designation;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/app/designation")
public class DesignationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(DesignationController.class);

	@Autowired
	private DesignationService designationService;

	// Save Method

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean addDesignation(@RequestBody DesignationBean objDesignationBean) throws CustomException {
		boolean isSuccess = false;
		DesignationResultBean objDesignationResultBean = new DesignationResultBean();
		try {

			isSuccess = designationService.addDesignation(objDesignationBean);
			System.out.println("Result" + isSuccess);
			objDesignationResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/edit")
	public @ResponseBody DesignationBean editdesignationValues(@RequestBody String desgnCode) throws CustomException {
		DesignationBean desgnList = new DesignationBean();
		try {
			desgnList = designationService.getdesignationValues(desgnCode);
			desgnList.setIsEdit(true);
		} catch (Exception e) {
			desgnList.setIsEdit(false);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return desgnList;
	}

	@RequestMapping("/getDesignation")
	public @ResponseBody List getDesignation() throws CustomException {
		List sDesignation = new ArrayList();
		try {
			sDesignation = designationService.getDesignation();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sDesignation;
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody boolean deleteDesignation(@RequestParam("desgnCode") String dCode) throws CustomException {
		boolean isDeleted = false;
		try {
			isDeleted = designationService.deleteDesignation(dCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isDeleted;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateDesignation(@RequestBody DesignationBean objDesignationBean) throws CustomException {
		boolean isSuccess = false;
		DesignationResultBean objDesignationResultBean = new DesignationResultBean();
		try {

			isSuccess = designationService.updateDesignation(objDesignationBean);
			objDesignationResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	// Getting List

	@RequestMapping("/list")
	public @ResponseBody DesignationResultBean getDesignationList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		DesignationResultBean objDesignationResultBean = new DesignationResultBean();

		if (offset < 5000) {
			try {
				objDesignationResultBean.setlDesignationBean(designationService.getDesignationList(limit, offset));
				objDesignationResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objDesignationResultBean;
	}
}
