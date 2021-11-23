package com.dci.tenant.master.city;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
@Controller
@RequestMapping(value = "{tenantid}/city")
public class CityController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CityDaoImpl.class);

	@Autowired
	CityService portSerivce;
	@RequestMapping(value = "/statelist")
	public @ResponseBody CityResultBean getstate() throws Exception {
		CityResultBean ResultBean = null;

		try {
			
			ResultBean = new CityResultBean();
			
			
			ResultBean = portSerivce.selectivity();
			
		} catch (CustomException e) {

			e.printStackTrace();
		}
		return ResultBean;

	}
	
	
	@RequestMapping("/list")
	public @ResponseBody CityResultBean list() throws CustomException {

		CityResultBean ResultBean;
		 
		try {

			ResultBean = new CityResultBean();

			ResultBean.setList(portSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody CityBean  bean) throws CustomException {

		CityResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new CityResultBean();

			isSuccess = portSerivce.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody CityBean  editvalue(@RequestBody int rowid) throws CustomException {
		CityBean bean = new CityBean();
		try {
			bean = portSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody CityBean update) throws CustomException {
		boolean isSuccess = false;
		
		try {
			isSuccess = portSerivce.update(update);
			
		} catch (Exception e) {
			e.printStackTrace();
			//LOGGER.error("Error", e);
			//throw new CustomException();
		}
		return isSuccess;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {
		boolean isDeleted = false;
		isDeleted = portSerivce.delete(rowid);
		return isDeleted;
	}
	}