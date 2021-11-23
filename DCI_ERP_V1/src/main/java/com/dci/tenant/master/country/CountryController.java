package com.dci.tenant.master.country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
@Controller
@RequestMapping(value = "{tenantid}/country")
public class CountryController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CountryDaoImpl.class);

	@Autowired
	CountryService portSerivce;
	@RequestMapping(value = "/regionlist")
	public @ResponseBody CountryResultBean getregion() throws Exception {
		CountryResultBean ResultBean = null;

		try {
			
			ResultBean = new CountryResultBean();
			
			
			ResultBean = portSerivce.selectivity();
			
		} catch (CustomException e) {

			e.printStackTrace();
		}
		return ResultBean;

	}
	
	
	@RequestMapping("/list")
	public @ResponseBody CountryResultBean list() throws CustomException {

		CountryResultBean ResultBean;
		 
		try {

			ResultBean = new CountryResultBean();

			ResultBean.setList(portSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody CountryBean  bean) throws CustomException {

		CountryResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new CountryResultBean();

			isSuccess = portSerivce.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody CountryBean  editvalue(@RequestBody int rowid) throws CustomException {
		CountryBean bean = new CountryBean();
		try {
			bean = portSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody CountryBean update) throws CustomException {
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