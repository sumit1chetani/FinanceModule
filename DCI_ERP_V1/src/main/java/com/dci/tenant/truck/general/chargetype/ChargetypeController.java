package com.dci.tenant.truck.general.chargetype;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/changetype")
public class ChargetypeController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ChargetypeController.class);

	@Autowired
	ChargetypeService changetypeService;
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody ChargetypeBean bean) throws CustomException {

		ChargetypeResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new ChargetypeResultBean();

			isSuccess = changetypeService.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/list")
	public @ResponseBody ChargetypeResultBean list() throws CustomException {

		ChargetypeResultBean ResultBean;
		 
		try {

			ResultBean = new ChargetypeResultBean();

			ResultBean.setList(changetypeService.getList());

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody ChargetypeBean  editvalue(@RequestBody int rowid) throws CustomException {
		ChargetypeBean bean = new ChargetypeBean();
		try {
			bean = changetypeService.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody ChargetypeBean update) throws CustomException {
		boolean isSuccess = false;
		
		try {
			isSuccess = changetypeService.update(update);
			
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {
		boolean isDeleted = false;
		isDeleted = changetypeService.delete(rowid);
		return isDeleted;
	}
}

