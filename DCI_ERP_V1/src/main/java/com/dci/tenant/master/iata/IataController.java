package com.dci.tenant.master.iata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
@Controller
@RequestMapping(value = "{tenantid}/iata")
public class IataController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(IataDaoImpl.class);

	@Autowired
	IataService iataSerivce;
	
	@RequestMapping(value = "/citylist")
	public @ResponseBody IataResultBean getcity() throws Exception {
		IataResultBean ResultBean = null;

		try {
			
			ResultBean = new IataResultBean();
			
			
			ResultBean = iataSerivce.selectivity();
			
		} catch (CustomException e) {

			e.printStackTrace();
		}
		return ResultBean;

	}@RequestMapping("/list")
	public @ResponseBody IataResultBean list() throws CustomException {

		IataResultBean ResultBean;
		 
		try {

			ResultBean = new IataResultBean();

			ResultBean.setList(iataSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error on list" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody IataBean  bean) throws CustomException {

		IataResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new IataResultBean();

			isSuccess = iataSerivce.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on save" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody IataBean  editvalue(@RequestBody int rowid) throws CustomException {
		IataBean bean = new IataBean();
		try {
			bean = iataSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody IataBean update) throws CustomException {
		boolean isSuccess = false;
		
		try {
			isSuccess = iataSerivce.update(update);
			
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {
		boolean isDeleted = false;
		isDeleted = iataSerivce.delete(rowid);
		return isDeleted;
	}
	}