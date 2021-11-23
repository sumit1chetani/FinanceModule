package com.dci.tenant.finance.TDSForm;

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
@RequestMapping(value = "app/tds")
public class TDSFormController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TDSFormController.class);

	@Autowired
	private TDSFormService ObjTDSFormService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean addAcctHead(@RequestBody TDSFormBean objTDSFormBean) throws CustomException {
		String userId = "E001";
		boolean isSuccess = false;
		TDSFormResultBean objTDSFormResultBean = new TDSFormResultBean();
		try {
			isSuccess = ObjTDSFormService.addAcctHeadMastercom(objTDSFormBean, userId);
			objTDSFormResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/list")
	public @ResponseBody TDSFormResultBean getAcctHeadList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		TDSFormResultBean objTDSFormResultBean = new TDSFormResultBean();
		try {
			objTDSFormResultBean.setlAccountHeadMasterBeanBean(ObjTDSFormService.getAcctHeadMasterList(limit, offset));
			objTDSFormResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objTDSFormResultBean;
	}

	@RequestMapping("/edit")
	public @ResponseBody TDSFormBean editBankcompanyValues(@RequestBody String tdsauto) throws CustomException {
		TDSFormBean objTDSFormBean = new TDSFormBean();
		try {
			objTDSFormBean = ObjTDSFormService.getBankcompanyValues(tdsauto);
			// .seti
		} catch (Exception e) {
			// .setIsEdit(false);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objTDSFormBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteDepartment(@RequestParam("tdsauto") String tdsauto) throws CustomException {
		boolean isDeleted = false;
		try {
			isDeleted = ObjTDSFormService.deleteVendor(tdsauto);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isDeleted;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateAcctHead(@RequestBody TDSFormBean objTDSFormBean) throws CustomException {
		boolean isSuccess = false;
		TDSFormResultBean ObjTDSFormResultBean = new TDSFormResultBean();
		try {
			isSuccess = ObjTDSFormService.updateAcctHeadMaster(objTDSFormBean);
			ObjTDSFormResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

}
