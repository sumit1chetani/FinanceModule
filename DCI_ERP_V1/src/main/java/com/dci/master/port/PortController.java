package com.dci.master.port;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
@Controller
@RequestMapping(value = "{tenantid}/port")
public class PortController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PortDaoImpl.class);

	@Autowired
	PortService portSerivce;
	
	@RequestMapping(value = "/citylist")
	public @ResponseBody PortResultBean getcity() throws Exception {
		PortResultBean ResultBean = null;

		try {
			
			ResultBean = new PortResultBean();
			
			
			ResultBean = portSerivce.selectivity();
			
		} catch (CustomException e) {

			e.printStackTrace();
		}
		return ResultBean;

	}@RequestMapping("/list")
	public @ResponseBody PortResultBean list() throws CustomException {

		PortResultBean ResultBean;
		 
		try {

			ResultBean = new PortResultBean();

			ResultBean.setList(portSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody PortBean  bean) throws CustomException {

		PortResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new PortResultBean();

			isSuccess = portSerivce.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody PortBean  editvalue(@RequestBody int rowid) throws CustomException {
		PortBean bean = new PortBean();
		try {
			bean = portSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody PortBean update) throws CustomException {
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