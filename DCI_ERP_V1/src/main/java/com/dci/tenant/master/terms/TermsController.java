package com.dci.tenant.master.terms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/terms")
public class TermsController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TermsDaoImpl.class);

	@Autowired
	TermsService portSerivce;
	@RequestMapping(value = "/statelist")
	public @ResponseBody TermsResultBean getstate() throws Exception {
		TermsResultBean ResultBean = null;

		try {
			
			ResultBean = new TermsResultBean();
			
			
			ResultBean = portSerivce.selectivity();
			
		} catch (CustomException e) {

			e.printStackTrace();
		}
		return ResultBean;

	}
	
	
	@RequestMapping("/list")
	public @ResponseBody TermsResultBean list() throws CustomException {

		TermsResultBean ResultBean;
		 
		try {

			ResultBean = new TermsResultBean();

			ResultBean.setList(portSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody TermsBean  bean) throws CustomException {

		TermsResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new TermsResultBean();

			isSuccess = portSerivce.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody TermsBean  editvalue(@RequestBody int rowid) throws CustomException {
		TermsBean bean = new TermsBean();
		try {
			bean = portSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody TermsBean update) throws CustomException {
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