package com.dci.tenant.master.chargeHead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
@Controller
@RequestMapping(value = "{tenantid}/chargeHead")
public class ChargeHeadController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ChargeHeadDaoImpl.class);

	@Autowired
	ChargeHeadService chargeHeadSerivce;
	@RequestMapping(value = "/grouplist")
	public @ResponseBody ChargeHeadResultBean getcity() throws Exception {
		ChargeHeadResultBean ResultBean = null;

		try {
			
			ResultBean = new ChargeHeadResultBean();
			
			
			ResultBean = chargeHeadSerivce.selectivity();
			
		} catch (CustomException e) {

			e.printStackTrace();
		}
		return ResultBean;

	}
	@RequestMapping("/list")
	public @ResponseBody ChargeHeadResultBean list() throws CustomException {

		ChargeHeadResultBean ResultBean;
		 
		try {

			ResultBean = new ChargeHeadResultBean();

			ResultBean.setList(chargeHeadSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error on list" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody ChargeHeadBean  bean) throws CustomException {

		ChargeHeadResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new ChargeHeadResultBean();

			isSuccess = chargeHeadSerivce.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on save" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody ChargeHeadBean  editvalue(@RequestBody int rowid) throws CustomException {
		ChargeHeadBean bean = new ChargeHeadBean();
		try {
			bean = chargeHeadSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	
	@RequestMapping("/view")
	public @ResponseBody ChargeHeadBean  viewvalue(@RequestBody int rowid) throws CustomException {
		ChargeHeadBean bean = new ChargeHeadBean();
		try {
			bean = chargeHeadSerivce.view(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody ChargeHeadBean update) throws CustomException {

		boolean isSuccess = false;
		
		try {
			isSuccess = chargeHeadSerivce.update(update);
			
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {

		boolean isDeleted = false;
		isDeleted = chargeHeadSerivce.delete(rowid);
		return isDeleted;
	}
	}