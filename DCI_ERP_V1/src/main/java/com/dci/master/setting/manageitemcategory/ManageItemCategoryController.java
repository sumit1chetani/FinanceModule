package com.dci.master.setting.manageitemcategory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "hospital/inventory/manageitemcategory")

public class ManageItemCategoryController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageItemCategoryController.class);

	@Autowired
	private ManageItemCategoryService manageItemCategoryService;

	@RequestMapping(value = "/list")
	public ManageItemCategoryResultBean getItemCategoryList() {
		ManageItemCategoryResultBean itemCategoryBean = new ManageItemCategoryResultBean();
		try {

			itemCategoryBean.setManageItemCategoryList(manageItemCategoryService.getItemCategoryList());
			itemCategoryBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemCategoryBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteItemCategory(@RequestBody int itemCategoryId) throws Exception {
		boolean isDeleted = false;
		isDeleted = manageItemCategoryService.deleteItemCategory(itemCategoryId);
		return isDeleted;
	}

	@RequestMapping(value = "/getCategoryList")
	public ManageItemCategoryResultBean getCategoryList() {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {
			objManageItemCategoryResultBean = manageItemCategoryService.getCategoryList();
			objManageItemCategoryResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objManageItemCategoryResultBean;
	}

	@RequestMapping(value = "/getParentCategoryList")
	public ManageItemCategoryResultBean getParentCategoryList() {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {
			objManageItemCategoryResultBean = manageItemCategoryService.getParentCategoryList();
			objManageItemCategoryResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objManageItemCategoryResultBean;
	}

	@RequestMapping(value = "/getSalesList")
	public ManageItemCategoryResultBean getSalesList() {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {
			objManageItemCategoryResultBean = manageItemCategoryService.getSalesList();
			objManageItemCategoryResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objManageItemCategoryResultBean;
	}

	@RequestMapping(value = "/getPurchaseList")
	public ManageItemCategoryResultBean getPurchaseList() {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {
			objManageItemCategoryResultBean = manageItemCategoryService.getPurchaseList();
			objManageItemCategoryResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objManageItemCategoryResultBean;
	}

	@RequestMapping(value = "/getIncomeAccountList")
	public ManageItemCategoryResultBean getIncomeAccountList() {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {
			objManageItemCategoryResultBean = manageItemCategoryService.getIncomeAccountList();
			objManageItemCategoryResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objManageItemCategoryResultBean;
	}

	@RequestMapping(value = "/getExpenseAccountList")
	public ManageItemCategoryResultBean getExpenseAccountList() {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {
			objManageItemCategoryResultBean = manageItemCategoryService.getExpenseAccountList();
			objManageItemCategoryResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objManageItemCategoryResultBean;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean addItemCategory(@RequestBody ManageItemCategoryPropertyBean objItemCategoryBean) throws CustomException {
		boolean isSuccess = false;
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {

			isSuccess = manageItemCategoryService.addItemCategory(objItemCategoryBean);
			objManageItemCategoryResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/getItemCategoryEditList")
	public @ResponseBody ManageItemCategoryBean getItemCategoryEditList(@RequestParam("itemCategoryId") int itemCategoryId) throws Exception {
		ManageItemCategoryBean objItemCategoryBean = new ManageItemCategoryBean();
		objItemCategoryBean = manageItemCategoryService.getItemCategoryEditList(itemCategoryId);
		return objItemCategoryBean;
	}

	@RequestMapping(value = "/getPropertyList")
	public ManageItemCategoryResultBean getPropertyList() {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {
			objManageItemCategoryResultBean = manageItemCategoryService.getPropertyList();
			objManageItemCategoryResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objManageItemCategoryResultBean;
	}

	@RequestMapping("/getItemPropertiesDetail")
	public List<ItemPropertiesBean> getItemPropertiesDetail(@RequestParam("propertyTypeId") int propertyTypeId) throws Exception {
		List<ItemPropertiesBean> itemPropertyDetail = new ArrayList<>();
		itemPropertyDetail = manageItemCategoryService.getItemPropertiesDetail(propertyTypeId);
		return itemPropertyDetail;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody boolean updateItemCategory(@RequestBody ManageItemCategoryPropertyBean objItemCategoryBean) throws CustomException {
		boolean isSuccess = false;
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {

			isSuccess = manageItemCategoryService.updateItemCategory(objItemCategoryBean);
			objManageItemCategoryResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/checkCategoryName")
	public @ResponseBody int checkCatgeoryName(@RequestParam("categoryName") String categoryName) throws CustomException {
		int category;

		try {
			category = manageItemCategoryService.checkCatgeoryName(categoryName);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return category;
	}

	@RequestMapping(value = "/getGrnAttributeList")
	public ManageItemCategoryResultBean getGrnAttributeList(@RequestBody String parentCategoryId) {
		ManageItemCategoryResultBean objManageItemCategoryResultBean = new ManageItemCategoryResultBean();
		try {
			objManageItemCategoryResultBean = manageItemCategoryService.getGrnAttributeList(parentCategoryId);
			objManageItemCategoryResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objManageItemCategoryResultBean;
	}

}
