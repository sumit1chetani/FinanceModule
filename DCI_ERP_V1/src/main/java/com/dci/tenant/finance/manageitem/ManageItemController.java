package com.dci.tenant.finance.manageitem;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.dci.tenant.common.CommonUtilityService;

@Controller
@RequestMapping(value = "hospital/inventory/manageitem")
public class ManageItemController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ManageItemController.class);

	@Autowired(required = true)
	ManageItemService objManageItemService;
	@Autowired
	CommonUtilityService commonUtilityService;

	@RequestMapping("/list")
	public @ResponseBody ManageItemResultBean getItemList() throws CustomException {
		ManageItemResultBean objManageItemResultBean = new ManageItemResultBean();
		try {
			objManageItemResultBean = objManageItemService.getManageItemList();
			objManageItemResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objManageItemResultBean;
	}

	@RequestMapping("/defList")
	public @ResponseBody ManageItemResultBean getDefTableValues() throws CustomException {
		ManageItemResultBean objManageItemResultBean = new ManageItemResultBean();
		try {
			objManageItemResultBean.setItemTypeList(commonUtilityService.getDefTableList(6));
			objManageItemResultBean.setPurchaseList(commonUtilityService.getDefTableList(7));
			objManageItemResultBean.setCostingList(commonUtilityService.getDefTableList(8));
			objManageItemResultBean.setInventoryValuvationList(commonUtilityService.getDefTableList(9));
			objManageItemResultBean.setIssueList(commonUtilityService.getDefTableList(10));
			objManageItemResultBean.setPricingTypeList(commonUtilityService.getDefTableList(14));
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objManageItemResultBean;
	}

	@RequestMapping("/dropDownList")
	public @ResponseBody ManageItemResultBean getDropDownValues() throws CustomException {
		ManageItemResultBean objManageItemResultBean = new ManageItemResultBean();

		try {

			objManageItemResultBean.setItemCategoryList(objManageItemService.getItemCtaegoryList());
			objManageItemResultBean.setEntityList(objManageItemService.getEntityList());
			objManageItemResultBean.setUomList(objManageItemService.getUOmList());
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objManageItemResultBean;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody boolean insertManageItemDetails(@RequestBody ManageItemBean objManageItem) throws CustomException {
		boolean isSuccess = false;
		ManageItemResultBean objManageItemResultBean = new ManageItemResultBean();
		try {

			isSuccess = objManageItemService.insertManageItemDetails(objManageItem);
			objManageItemResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/checkItemName")
	public @ResponseBody int checkItemName(@RequestParam("checkItemName") String checkItemName) throws CustomException {
		int category;

		try {
			category = objManageItemService.checkItemName(checkItemName);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return category;
	}

	@RequestMapping(value = "/checkItemCode")
	public @ResponseBody int checkItemCode(@RequestParam("checkItemCode") String checkItemCode) throws CustomException {
		int category;
		try {
			category = objManageItemService.checkItemCode(checkItemCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return category;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody boolean supdateManageItemDetails(@RequestBody ManageItemBean objManageItem) throws CustomException {
		boolean isSuccess = false;
		ManageItemResultBean objManageItemResultBean = new ManageItemResultBean();
		try {

			isSuccess = objManageItemService.updateManageItemDetails(objManageItem);
			objManageItemResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteManageItemDetails(@RequestBody String itemId) throws CustomException {
		boolean isDeleted = false;
		try {
			isDeleted = objManageItemService.deleteItemDetails(itemId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isDeleted;
	}

	@RequestMapping("/getManageItemEditList")
	public @ResponseBody ManageItemResultBean getEditManageItemList(@RequestParam("ItemCode") String ItemCode) throws CustomException {
		ManageItemResultBean objcharterhiredtobean = new ManageItemResultBean();
		objcharterhiredtobean = objManageItemService.getEditManageItem(ItemCode);

		return objcharterhiredtobean;
	}

	@RequestMapping(value = "/attributeDetails")
	public @ResponseBody ManageItemResultBean getAttributeDetails(@RequestParam("itemCategoryId") int itemCategoryId) throws Exception {
		ManageItemResultBean itemSpecificationDetail = new ManageItemResultBean();
		try {
			itemSpecificationDetail = objManageItemService.getAttributeDetails(itemCategoryId);
			itemSpecificationDetail.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemSpecificationDetail;
	}

	@RequestMapping(value = "/grnattributeDetails")
	public @ResponseBody ArrayList grnAttributeDetails(@RequestParam("itemCategoryId") int itemCategoryId) throws Exception {
		ArrayList alList = new ArrayList();
		try {
			alList = objManageItemService.getGrnAttributeDetails(itemCategoryId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alList;
	}

	@RequestMapping("/itemconsumptionList")
	public @ResponseBody ManageItemResultBean getItemConsumptionMasterList(@RequestParam("itm") String itm, @RequestParam("rdoDays") int rdoDays) throws CustomException, InterruptedException {
		ManageItemResultBean objManageItemConsumptionBean = new ManageItemResultBean();
		try {
			objManageItemConsumptionBean = objManageItemService.getItemConsumptionMasterList(itm, rdoDays);
			objManageItemConsumptionBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objManageItemConsumptionBean;
	}

	@RequestMapping("/uomCategoryBasedList")
	public @ResponseBody ManageItemResultBean getUOMCategoryBasedList(@RequestParam("uomId") int uomId) {
		ManageItemResultBean objItemResultBean = new ManageItemResultBean();
		try {
			objItemResultBean = objManageItemService.getUOMCategoryBasedList(uomId);
			objItemResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objItemResultBean;
	}

	@RequestMapping(value = "/exportManageItemReport", method = RequestMethod.POST)
	public @ResponseBody boolean exportChqDepoCollReport(@RequestBody ManageItemBean ManageItemBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc");
			// isSuccess =
			// ManageItemService.exportManageItemReport(ConfigurationProps.exportFilesPath,
			// ManageItemBean);
			isSuccess = objManageItemService.exportManageItemReport(filePath, ManageItemBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

}
