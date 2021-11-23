package com.dci.tenant.finance.manageCustomer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;

@RestController
@RequestMapping(value = "app/customerMaster")
public class ManageCustomerController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageCustomerController.class);

	@Autowired
	private ManageCustomerService manageCustomerService;

	@RequestMapping("/list")
	public @ResponseBody ManageCustomerResultBean getCustomerList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("entityType") String entityType) throws CustomException {
		ManageCustomerResultBean objManageCustomerResultBean = new ManageCustomerResultBean();
		try {
			objManageCustomerResultBean.setlManageCustomerBean(manageCustomerService.getCustomerList(limit, offset, entityType));
			objManageCustomerResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objManageCustomerResultBean;
	}

	@RequestMapping("/getCityList")
	public @ResponseBody ManageCustomerResultBean getCityList() throws CustomException {
		ManageCustomerResultBean lManageCustomerResultBean = new ManageCustomerResultBean();

		try {
			lManageCustomerResultBean = manageCustomerService.getCityList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lManageCustomerResultBean;
	}

	@RequestMapping("/getCityStateCountryList")
	public @ResponseBody ManageCustomerResultBean getCityStateCountryList(@RequestParam("cityId") int cityId) throws CustomException {
		ManageCustomerResultBean lManageCustomerResultBean = new ManageCustomerResultBean();

		try {
			lManageCustomerResultBean = manageCustomerService.getCityStateCountryList(cityId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lManageCustomerResultBean;
	}

	@RequestMapping("/save")
	public @ResponseBody boolean saveCustomerData(@RequestBody ManageCustomerBean objManageCustomerBean) throws CustomException {
		boolean isSuccess = false;
		ManageCustomerResultBean objManageCustomerResultBean = new ManageCustomerResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			objManageCustomerResultBean.setlManageCustomerBean(manageCustomerService.saveCustomerData(objManageCustomerBean, userId));
			isSuccess = true;

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/getCustomerDataOnEdit")
	public @ResponseBody ManageCustomerBean getCustomerDataOnEdit(@RequestParam("entityId") int entityId, @RequestParam("screenName") String screenName) throws CustomException {
		ManageCustomerBean objManageCustomerBean = new ManageCustomerBean();

		try {
			objManageCustomerBean = manageCustomerService.getCustomerDataOnEdit(entityId, screenName);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objManageCustomerBean;
	}

	@RequestMapping(value = "/paymentTerms")
	public ManageCustomerResultBean getpaymentList() {
		ManageCustomerResultBean lManageCustomerResultBean = new ManageCustomerResultBean();
		try {
			lManageCustomerResultBean = manageCustomerService.getpaymentList();
			lManageCustomerResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lManageCustomerResultBean;
	}

	@RequestMapping("/update")
	public @ResponseBody boolean updateCustmerData(@RequestBody ManageCustomerBean objManageCustomerBean) throws CustomException {
		boolean isSuccess = false;
		ManageCustomerResultBean objManageCustomerResultBean = new ManageCustomerResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			objManageCustomerResultBean.setlManageCustomerBean(manageCustomerService.updateCustmerData(objManageCustomerBean, userId));
			objManageCustomerResultBean.setSuccess(true);

			isSuccess = true;

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public boolean deleteEntityMaster(@RequestBody Integer entityId) throws Exception {
		ManageCustomerResultBean customerResultBean = new ManageCustomerResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = manageCustomerService.deleteEntityMaster(entityId);
			if (isSuccess) {
				customerResultBean.setSuccess(true);
				isSuccess = true;
			}

			else {
				customerResultBean.setSuccess(false);
				isSuccess = false;
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/checkVendorName")
	public @ResponseBody int checkVendorName(@RequestParam("entityName") String entityName) throws CustomException {
		int entity;

		try {
			entity = manageCustomerService.checkVendorName(entityName);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return entity;
	}

	@RequestMapping("/checkCustomerName")
	public @ResponseBody int checkCustomerName(@RequestParam("entityName") String entityName) throws CustomException {
		int entity;

		try {
			entity = manageCustomerService.checkCustomerName(entityName);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return entity;
	}
	
	@RequestMapping(value = "/deletecust", method = RequestMethod.POST)
	public boolean deleteEntityCustMaster(@RequestBody Integer entityId) throws Exception {
		ManageCustomerResultBean customerResultBean = new ManageCustomerResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = manageCustomerService.deleteEntityCustMaster(entityId);
			if (isSuccess) {
				customerResultBean.setSuccess(true);
				isSuccess = true;
			}

			else {
				customerResultBean.setSuccess(false);
				isSuccess = false;
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}
}
