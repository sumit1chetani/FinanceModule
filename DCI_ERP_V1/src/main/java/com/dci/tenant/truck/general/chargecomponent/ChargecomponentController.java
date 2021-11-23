package com.dci.tenant.truck.general.chargecomponent;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/changecomponent")
public class ChargecomponentController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ChargecomponentDaoImpl.class);

	@Autowired
	ChargecomponentSerivce chargecomponentSerivce;
	
	@RequestMapping(value = "/currencylist")
	public @ResponseBody ChargecomponentResultBean gettype() {
		ChargecomponentResultBean ResultBean = null;

		try {
			
			ResultBean = new ChargecomponentResultBean();
			
			
			ResultBean = chargecomponentSerivce.selectivity();
			
		} catch (CustomException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return ResultBean;

	}
	
	@RequestMapping("/list")
	public @ResponseBody ChargecomponentResultBean list() throws CustomException {

		ChargecomponentResultBean ResultBean;
		 
		try {

			ResultBean = new ChargecomponentResultBean();

			ResultBean.setList(chargecomponentSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody ChargecomponentBean  bean) throws CustomException {

		ChargecomponentResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new ChargecomponentResultBean();

			isSuccess = chargecomponentSerivce.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody ChargecomponentBean  editvalue(@RequestBody int rowid) throws CustomException {
		ChargecomponentBean bean = new ChargecomponentBean();
		try {
			bean = chargecomponentSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody ChargecomponentBean update) throws CustomException {
		boolean isSuccess = false;
		
		try {
			isSuccess = chargecomponentSerivce.update(update);
			
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {
		boolean isDeleted = false;
		isDeleted = chargecomponentSerivce.delete(rowid);
		return isDeleted;
	}

}

