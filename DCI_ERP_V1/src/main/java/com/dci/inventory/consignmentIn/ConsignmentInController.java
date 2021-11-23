package com.dci.inventory.consignmentIn;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.tenant.common.CommonUtilityBean;
import com.dci.tenant.common.CommonUtilityService;
import com.dci.tenant.user.UserDetail;



@RestController
@RequestMapping(value = "app/inventory/consignmentIn")
public class ConsignmentInController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ConsignmentInController.class);

	@Autowired
	private ConsignmentInService objConsignmentInService;

	@Autowired
	private CommonUtilityService cusCommonUtilityService;

	@RequestMapping(value = "/parentlocationlist")
	public List<CommonUtilityBean> getparentlocationList() {

		List<CommonUtilityBean> parentLocationList = Arrays.asList();
		try {
			parentLocationList = cusCommonUtilityService.getParentLocationList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parentLocationList;

	}

	@RequestMapping(value = "/getDropdownValues")
	public ConsignmentInResultBean getDropdownValues() {

		ConsignmentInResultBean objConsignmentInResultBean = new ConsignmentInResultBean();
		try {
			objConsignmentInResultBean.setoConsignmentInBean(objConsignmentInService.getDropdownValues());
			objConsignmentInResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objConsignmentInResultBean;
	}

	@RequestMapping(value = "/getDropdownValues1")
	public ConsignmentInResultBean getDropdownValues1() {

		ConsignmentInResultBean objConsignmentInResultBean = new ConsignmentInResultBean();
		try {
			objConsignmentInResultBean.setoConsignmentInBean(objConsignmentInService.getDropdownValues1());
			objConsignmentInResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objConsignmentInResultBean;
	}

	@RequestMapping("/save")
	public @ResponseBody ConsignmentInResultBean saveCRData(@RequestBody ConsignmentInBean objConsignmentInBean) throws CustomException {
		ConsignmentInResultBean objConsignmentInResultBean = new ConsignmentInResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		boolean isSuccess = false;
		try {
			isSuccess = objConsignmentInService.saveConsignmentInData(objConsignmentInBean);

			if (isSuccess)
				objConsignmentInResultBean.setSuccess(true);
			else
				objConsignmentInResultBean.setSuccess(false);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objConsignmentInResultBean;
	}

	@RequestMapping("/checkBatchNumber")
	public @ResponseBody int checkStoreName(@RequestParam("checkBatchNumber") String checkBatchNumber) throws CustomException {
		int storeName = 0;
		try {
			storeName = objConsignmentInService.checkBatchNumber(checkBatchNumber);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return storeName;
	}

	@RequestMapping(value = "/QuotationItem")
	public ConsignmentInResultBean getItemrequisition(@RequestBody String id) {

		ConsignmentInResultBean consignmentInResultBean = new ConsignmentInResultBean();
		try {
			consignmentInResultBean.setlConsignmentInDetailBean(objConsignmentInService.getItemrequisition(id));
			consignmentInResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consignmentInResultBean;
	}

	@RequestMapping("/getConsignmentInList")
	public @ResponseBody ConsignmentInResultBean getQuotationList() throws Exception {
		ConsignmentInResultBean consignmentInResultBean = new ConsignmentInResultBean();
		try {
			consignmentInResultBean = objConsignmentInService.getConsignmentInList();
			consignmentInResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return consignmentInResultBean;
	}

	@RequestMapping("/getConsignmentInDataOnEdit")
	public @ResponseBody ConsignmentInResultBean getConsignmentInDataOnEdit(@RequestParam("consignmentInId") Integer consignmentInId) throws Exception {
		ConsignmentInResultBean objConsignmentInBean = new ConsignmentInResultBean();
		try {

			objConsignmentInBean.setoConsignmentInBean(objConsignmentInService.getDropdownValues());
			objConsignmentInBean.setEditConsignmentInBean(objConsignmentInService.getConsignmentInDataOnEdit(consignmentInId));
			objConsignmentInBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objConsignmentInBean;
	}

	@RequestMapping("/update")
	public @ResponseBody ConsignmentInResultBean updateConsignmentInData(@RequestBody ConsignmentInBean objConsignmentInBean) throws CustomException {
		ConsignmentInResultBean objConsignmentInResultBean = new ConsignmentInResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		boolean isSuccess = false;
		try {
			isSuccess = objConsignmentInService.updateConsignmentInData(objConsignmentInBean);

			if (isSuccess)
				objConsignmentInResultBean.setSuccess(true);
			else
				objConsignmentInResultBean.setSuccess(false);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objConsignmentInResultBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteConsignmentInData(@RequestParam("consignmentInId") Integer consignmentInId) throws CustomException {
		ConsignmentInResultBean objConsignmentInResultBean = new ConsignmentInResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = objConsignmentInService.deleteConsignmentInData(consignmentInId);

			if (isSuccess)
				objConsignmentInResultBean.setSuccess(true);
			else
				objConsignmentInResultBean.setSuccess(false);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

}
