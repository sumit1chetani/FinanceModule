package com.dci.tenant.master.chargeHeadGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
@Controller
@RequestMapping(value = "{tenantid}/chargeHeadGroup")
public class ChargeHeadGroupController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ChargeHeadGroupDaoImpl.class);

	@Autowired
	ChargeHeadGroupService chargeHeadGroupSerivce;
	
	@RequestMapping("/list")
	public @ResponseBody ChargeHeadGroupResultBean list() throws CustomException {

		ChargeHeadGroupResultBean ResultBean;
		 
		try {

			ResultBean = new ChargeHeadGroupResultBean();

			ResultBean.setList(chargeHeadGroupSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error on list" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody ChargeHeadGroupBean  bean) throws CustomException {

		ChargeHeadGroupResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new ChargeHeadGroupResultBean();

			isSuccess = chargeHeadGroupSerivce.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on save" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody ChargeHeadGroupBean  editvalue(@RequestBody int rowid) throws CustomException {
		ChargeHeadGroupBean bean = new ChargeHeadGroupBean();
		try {
			bean = chargeHeadGroupSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody ChargeHeadGroupBean update) throws CustomException {
		boolean isSuccess = false;
		
		try {
			isSuccess = chargeHeadGroupSerivce.update(update);
			
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {
		boolean isDeleted = false;
		isDeleted = chargeHeadGroupSerivce.delete(rowid);
		return isDeleted;
	}
	}