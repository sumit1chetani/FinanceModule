package com.dci.tenant.finance.subheadgroupaccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "app/subheadgroupacct")
public class SubHeadGroupAccountController {

	private final static Logger LOGGER = LoggerFactory.getLogger(SubHeadGroupAccountController.class);

	@Autowired
	private SubHeadGroupAccountService subGroupAccountService;

	@RequestMapping("/getGrpHdDrpDwn")
	public @ResponseBody SubHeadGroupAccountResultListBean getGrpHdDrpDwn() throws CustomException {
		SubHeadGroupAccountResultListBean lgetGrpHdList = new SubHeadGroupAccountResultListBean();
		try {
			lgetGrpHdList = subGroupAccountService.getGrpHeadDrpDwn();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lgetGrpHdList;
	}

	@RequestMapping(value = "/add")
	public @ResponseBody boolean addSubGroupAccount(@RequestBody SubHeadGroupAccountBean objSubGroupAccountBean) throws Exception {
		String userId = "";
		boolean isAdded = false;
		SubHeadGroupAccountResultListBean objSubGrpAcctResultBean = new SubHeadGroupAccountResultListBean();

		try {
			isAdded = subGroupAccountService.addSubGroupAccount(objSubGroupAccountBean, userId);

			if (isAdded) {
				try {
					int offset = 0;
					int limit = 0;
					objSubGrpAcctResultBean.setObjSubGroupAccountBeanBean(subGroupAccountService.getSubGroupAccountList(limit, offset));
					objSubGrpAcctResultBean.setSuccess(true);
				} catch (Exception e) {
					LOGGER.error("Error", e);
					throw new CustomException();
				}
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return isAdded;
	}

	@RequestMapping("/list")
	public @ResponseBody SubHeadGroupAccountResultListBean getSubGroupAccountList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		SubHeadGroupAccountResultListBean objSubGrpAcctResultBean = new SubHeadGroupAccountResultListBean();
		if (offset < 5000) {
			try {
				objSubGrpAcctResultBean.setObjSubGroupAccountBeanBean(subGroupAccountService.getSubGroupAccountList(limit, offset));
				objSubGrpAcctResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objSubGrpAcctResultBean;
	}

	@RequestMapping("/edit")
	public @ResponseBody SubHeadGroupAccountResultListBean getSubGroupAccountEditData(@RequestParam("subGroupCode") String subGroupHeadCode) throws CustomException {
		SubHeadGroupAccountResultListBean objSubGrpAcctResultBean = new SubHeadGroupAccountResultListBean();
		try {
			objSubGrpAcctResultBean.setEditSubGroupAccountBean(subGroupAccountService.getSubGroupAccountEditData(subGroupHeadCode));
			objSubGrpAcctResultBean.setListGroupHead(subGroupAccountService.getGrpHeadDrpDwn());
			objSubGrpAcctResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objSubGrpAcctResultBean;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateSubGroupAccount(@RequestBody SubHeadGroupAccountBean objSubGroupAccountBean) throws Exception {
		String userId = "";
		boolean isAdded = false;
		SubHeadGroupAccountResultListBean objSubGrpAcctResultBean = new SubHeadGroupAccountResultListBean();

		try {
			isAdded = subGroupAccountService.updateSubGroupAccount(objSubGroupAccountBean, userId);

			if (isAdded) {
				try {
					int offset = 0;
					int limit = 0;
					objSubGrpAcctResultBean.setObjSubGroupAccountBeanBean(subGroupAccountService.getSubGroupAccountList(limit, offset));
					objSubGrpAcctResultBean.setSuccess(true);
				} catch (Exception e) {
					LOGGER.error("Error", e);
					throw new CustomException();
				}
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return isAdded;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteSubGroupAccount(@RequestBody String subGroupHeadCode) throws Exception {
		boolean isDeleted = false;
		isDeleted = subGroupAccountService.deleteSubGroupAccount(subGroupHeadCode);
		return isDeleted;
	}

	@RequestMapping("/validate")
	public @ResponseBody SubHeadGroupAccountResultListBean getvalidate(@RequestBody SubHeadGroupAccountBean objSubGroupAccountBean) throws CustomException {
		SubHeadGroupAccountResultListBean sGroupHead = null;
		try {
			String subGroupName = objSubGroupAccountBean.getSubGroupName();
			boolean edit = objSubGroupAccountBean.isEdit();
			String subGroupCode = objSubGroupAccountBean.getSubGroupCode();
			sGroupHead = subGroupAccountService.getvalidate(subGroupName, edit, subGroupCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sGroupHead;
	}
}
